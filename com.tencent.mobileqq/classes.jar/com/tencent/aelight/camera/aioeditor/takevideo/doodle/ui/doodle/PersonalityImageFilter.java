package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.model.DoodleItem;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonalityImageFilter
  extends VideoFilterBase
{
  int jdField_a_of_type_Int;
  Point jdField_a_of_type_AndroidGraphicsPoint;
  protected UniformParam.TextureBitmapParam a;
  DoodleItem jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem;
  private String jdField_a_of_type_JavaLangString = "doodle_image";
  List<List<PointF>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  public int b;
  List<Bitmap> b;
  public int c = 480;
  public int d = 1080;
  public int e = 1440;
  
  public PersonalityImageFilter(DoodleItem paramDoodleItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_DOODLE));
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = 320;
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem = paramDoodleItem;
    initParams();
    a(paramString);
  }
  
  private double a(PointF paramPointF1, PointF paramPointF2)
  {
    return Math.sqrt((paramPointF1.x - paramPointF2.x) * (paramPointF1.x - paramPointF2.x) + (paramPointF1.y - paramPointF2.y) * (paramPointF1.y - paramPointF2.y));
  }
  
  private void a()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    localObject = (Bitmap)((List)localObject).get(i % ((List)localObject).size());
    UniformParam.TextureBitmapParam localTextureBitmapParam = this.jdField_a_of_type_ComTencentAekitOpenrenderUniformParam$TextureBitmapParam;
    if (localTextureBitmapParam != null)
    {
      localTextureBitmapParam.swapTextureBitmap((Bitmap)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentAekitOpenrenderUniformParam$TextureBitmapParam = new UniformParam.TextureBitmapParam("inputImageTexture2", (Bitmap)localObject, 33986, false);
    this.jdField_a_of_type_ComTencentAekitOpenrenderUniformParam$TextureBitmapParam.initialParams(super.getProgramIds());
    super.addParam(this.jdField_a_of_type_ComTencentAekitOpenrenderUniformParam$TextureBitmapParam);
  }
  
  private void a(String paramString)
  {
    int i = 0;
    this.jdField_a_of_type_Int = 0;
    while (i < this.jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem.count)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(".png");
      localObject = BitmapUtils.decodeSampledBitmapFromFile(FileUtils.getRealPath(((StringBuilder)localObject).toString()), 80, 80);
      if (BitmapUtils.isLegal((Bitmap)localObject))
      {
        this.jdField_b_of_type_JavaUtilList.add(localObject);
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PersonalityImageFilter unlegal bitmap ");
        ((StringBuilder)localObject).append(i);
        QLog.d("Personality", 2, ((StringBuilder)localObject).toString());
      }
      i += 1;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      super.ApplyGLSLFilter();
    }
  }
  
  public void a(List<PointF> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    if (this.jdField_b_of_type_JavaUtilList.size() < 1) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PointF localPointF = (PointF)paramList.next();
      localArrayList.add(new PointF(localPointF.x + this.jdField_a_of_type_AndroidGraphicsPoint.x, localPointF.y + this.jdField_a_of_type_AndroidGraphicsPoint.y));
    }
    this.jdField_a_of_type_JavaUtilList.add(localArrayList);
  }
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
  }
  
  public void initParams()
  {
    super.addParam(new UniformParam.IntParam("texNeedTransform", 1));
    super.addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    super.addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
    super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
    super.addParam(new UniformParam.FloatParam("texScaleX", 1.0F));
    super.addParam(new UniformParam.FloatParam("texScaleY", 1.0F));
    super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    super.addParam(new UniformParam.FloatParam("positionRotate", 0.0F));
    super.addParam(new UniformParam.IntParam("blendMode", this.jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem.blendMode));
    super.addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
    super.addParam(new UniformParam.FloatParam("alpha", 1.0F));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() >= 1))
    {
      if (((List)this.jdField_a_of_type_JavaUtilList.get(0)).size() < 1) {
        return false;
      }
      this.jdField_a_of_type_Int = 0;
      localObject = null;
      paramInt2 = 0;
      while (paramInt2 < this.jdField_a_of_type_JavaUtilList.size())
      {
        paramInt3 = 0;
        while (paramInt3 < ((List)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).size())
        {
          PointF localPointF = (PointF)((List)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).get(paramInt3);
          if (localObject != null)
          {
            double d1 = a(localPointF, (PointF)localObject);
            double d2 = Math.max(this.jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem.width, this.jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem.height);
            Double.isNaN(d2);
            if (d1 <= d2 * 1.2D) {}
          }
          else
          {
            a();
            float f1 = this.jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem.width * this.width / this.d * 1.5F;
            float f2 = this.jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem.height * this.height / this.e * 1.5F;
            float f3 = localPointF.x - f1 / 2.0F;
            float f4 = this.height - localPointF.y + f2 / 2.0F;
            super.setPositions(AlgoUtils.calPositions(f3, f4, f3 + f1, f4 - f2, this.width, this.height));
            super.addParam(new UniformParam.Float2fParam("texAnchor", -this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y));
            super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
            super.addParam(new UniformParam.FloatParam("texScaleX", 1.0F));
            super.addParam(new UniformParam.FloatParam("texScaleY", 1.0F));
            super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
            GLES20.glFlush();
            super.OnDrawFrameGLSL();
            super.renderTexture(paramInt1, this.width, this.height);
            localObject = localPointF;
          }
          paramInt3 += 1;
        }
        paramInt2 += 1;
      }
      return true;
    }
    return false;
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(paramInt1 / 2, paramInt2 / 2);
    super.addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.PersonalityImageFilter
 * JD-Core Version:    0.7.0.1
 */