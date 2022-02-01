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
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.DoodleItem;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonalityGlareFilter
  extends VideoFilterBase
{
  public int a;
  Point jdField_a_of_type_AndroidGraphicsPoint;
  protected UniformParam.TextureBitmapParam a;
  private DoodleItem jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem;
  private String jdField_a_of_type_JavaLangString = "doodle_image";
  List<PointF> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  public int b;
  List<Bitmap> b;
  public int c = 1080;
  public int d = 1440;
  
  public PersonalityGlareFilter(DoodleItem paramDoodleItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_DOODLE));
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 320;
    this.jdField_b_of_type_Int = 480;
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem = paramDoodleItem;
    initParams();
    a(paramString);
    paramDoodleItem.width = 25;
    paramDoodleItem.height = 25;
  }
  
  private void a()
  {
    Bitmap localBitmap = (Bitmap)this.jdField_b_of_type_JavaUtilList.get(0);
    UniformParam.TextureBitmapParam localTextureBitmapParam = this.jdField_a_of_type_ComTencentAekitOpenrenderUniformParam$TextureBitmapParam;
    if (localTextureBitmapParam != null)
    {
      localTextureBitmapParam.swapTextureBitmap(localBitmap);
      return;
    }
    this.jdField_a_of_type_ComTencentAekitOpenrenderUniformParam$TextureBitmapParam = new UniformParam.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, false);
    this.jdField_a_of_type_ComTencentAekitOpenrenderUniformParam$TextureBitmapParam.initialParams(super.getProgramIds());
    super.addParam(this.jdField_a_of_type_ComTencentAekitOpenrenderUniformParam$TextureBitmapParam);
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_0.png");
    paramString = BitmapUtils.decodeSampledBitmapFromFile(FileUtils.getRealPath(localStringBuilder.toString()), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
    if (BitmapUtils.isLegal(paramString))
    {
      this.jdField_b_of_type_JavaUtilList.add(paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Personality", 2, "PersonalityGlareFilter init bitmap is null");
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
  
  PointF a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, float paramFloat)
  {
    PointF localPointF1 = new PointF((paramPointF3.x - paramPointF1.x) * 0.5F, (paramPointF3.y - paramPointF1.y) * 0.5F);
    PointF localPointF2 = new PointF((paramPointF3.x - paramPointF2.x) * 3.0F - (paramPointF4.x - paramPointF2.x) * 0.5F - (paramPointF3.x - paramPointF1.x) * 1.0F, (paramPointF3.y - paramPointF2.y) * 3.0F - (paramPointF4.y - paramPointF2.y) * 0.5F - 1.0F * (paramPointF3.y - paramPointF1.y));
    paramPointF1 = new PointF((paramPointF3.x - paramPointF2.x) * -2.0F + (paramPointF4.x - paramPointF2.x) * 0.5F + (paramPointF3.x - paramPointF1.x) * 0.5F, (paramPointF3.y - paramPointF2.y) * -2.0F + (paramPointF4.y - paramPointF2.y) * 0.5F + (paramPointF3.y - paramPointF1.y) * 0.5F);
    return new PointF(paramPointF1.x * paramFloat * paramFloat * paramFloat + localPointF2.x * paramFloat * paramFloat + localPointF1.x * paramFloat + paramPointF2.x, paramPointF1.y * paramFloat * paramFloat * paramFloat + localPointF2.y * paramFloat * paramFloat + localPointF1.y * paramFloat + paramPointF2.y);
  }
  
  void a(ArrayList<PointF> paramArrayList)
  {
    float f3 = this.jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem.width * this.width / this.c;
    int i = 3;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      int j = i - 3;
      localObject = (PointF)((List)localObject).get(j);
      List localList = this.jdField_a_of_type_JavaUtilList;
      int k = i - 2;
      float f1 = (float)PersonalityUtils.a((PointF)localObject, (PointF)localList.get(k));
      localObject = (PointF)this.jdField_a_of_type_JavaUtilList.get(k);
      localList = this.jdField_a_of_type_JavaUtilList;
      int m = i - 1;
      float f2 = 1.0F / ((int)((f1 + (float)PersonalityUtils.a((PointF)localObject, (PointF)localList.get(m)) + (float)PersonalityUtils.a((PointF)this.jdField_a_of_type_JavaUtilList.get(m), (PointF)this.jdField_a_of_type_JavaUtilList.get(i))) / (f3 * 1.5F)) * 12 * 1.0F);
      if (f2 > 0.1F)
      {
        f1 = 0.1F;
      }
      else
      {
        f1 = f2;
        if (f2 < 0.01F) {
          f1 = 0.01F;
        }
      }
      for (f2 = 0.0F; f2 < 1.0F; f2 += f1) {
        paramArrayList.add(a((PointF)this.jdField_a_of_type_JavaUtilList.get(j), (PointF)this.jdField_a_of_type_JavaUtilList.get(k), (PointF)this.jdField_a_of_type_JavaUtilList.get(m), (PointF)this.jdField_a_of_type_JavaUtilList.get(i), f2));
      }
      i += 1;
    }
  }
  
  public void a(List<PointF> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_b_of_type_JavaUtilList.size() < 1) {
      return;
    }
    a();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PointF localPointF = (PointF)paramList.next();
      localPointF = new PointF(localPointF.x + this.jdField_a_of_type_AndroidGraphicsPoint.x, localPointF.y + this.jdField_a_of_type_AndroidGraphicsPoint.y);
      this.jdField_a_of_type_JavaUtilList.add(localPointF);
    }
  }
  
  public boolean a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() >= 1))
    {
      System.currentTimeMillis();
      int i = 2;
      PersonalityUtils.a(2);
      float f1 = this.jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem.width * this.width / this.c * 1.5F;
      float f2 = this.jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem.height * this.height / this.d * 1.5F;
      localObject1 = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilList.size() <= 3) {
        i = 3;
      }
      int j = 0;
      int m;
      int k;
      float f3;
      float f5;
      float f4;
      float f6;
      while ((j < this.jdField_a_of_type_JavaUtilList.size()) && (j < i))
      {
        if (j > 0)
        {
          localObject2 = (PointF)this.jdField_a_of_type_JavaUtilList.get(j - 1);
          localObject3 = (PointF)this.jdField_a_of_type_JavaUtilList.get(j);
          m = (int)((float)PersonalityUtils.a((PointF)localObject2, (PointF)localObject3) / f1 * 18.0F) + 1;
          k = m;
          if (m < 6) {
            k = 6;
          }
          f3 = ((PointF)localObject3).x;
          f5 = ((PointF)localObject2).x;
          f4 = k * 1.0F;
          f3 = (f3 - f5) / f4;
          f4 = (((PointF)localObject3).y - ((PointF)localObject2).y) / f4;
          m = 0;
          while (m < k)
          {
            f5 = ((PointF)localObject2).x;
            f6 = m;
            ((ArrayList)localObject1).add(new PointF(f5 + f3 * f6, ((PointF)localObject2).y + f6 * f4));
            m += 1;
          }
          if (!((PointF)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).equals(((PointF)localObject3).x, ((PointF)localObject3).y)) {
            ((ArrayList)localObject1).add(localObject2);
          }
        }
        j += 1;
      }
      if (this.jdField_a_of_type_JavaUtilList.size() > 3) {
        a((ArrayList)localObject1);
      }
      Object localObject2 = new float[((ArrayList)localObject1).size() * 8];
      Object localObject3 = new float[((ArrayList)localObject1).size() * 8];
      i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        PointF localPointF = (PointF)((ArrayList)localObject1).get(i);
        f6 = localPointF.x - f1 / 2.0F;
        f5 = this.height - localPointF.y + f2 / 2.0F;
        f3 = f6 / this.width * 2.0F - 1.0F;
        f4 = f5 / this.height * 2.0F - 1.0F;
        f6 = (f6 + f1) / this.width * 2.0F - 1.0F;
        f5 = (f5 - f2) / this.height * 2.0F - 1.0F;
        int i4 = i * 8;
        j = i4 + 0;
        localObject2[j] = f3;
        k = i4 + 1;
        localObject2[k] = f5;
        m = i4 + 2;
        localObject2[m] = f6;
        int n = i4 + 3;
        localObject2[n] = f5;
        int i1 = i4 + 4;
        localObject2[i1] = f3;
        int i2 = i4 + 5;
        localObject2[i2] = f4;
        int i3 = i4 + 6;
        localObject2[i3] = f6;
        i4 += 7;
        localObject2[i4] = f4;
        localObject3[j] = 0.0F;
        localObject3[k] = 1.0F;
        localObject3[m] = 1.0F;
        localObject3[n] = 1.0F;
        localObject3[i1] = 0.0F;
        localObject3[i2] = 0.0F;
        localObject3[i3] = 1.0F;
        localObject3[i4] = 0.0F;
        i += 1;
      }
      super.setPositions((float[])localObject2);
      super.setTexCords((float[])localObject3);
      super.addParam(new UniformParam.Float2fParam("texAnchor", -this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y));
      super.addParam(new UniformParam.FloatParam("texScale", 1.0F));
      super.addParam(new UniformParam.FloatParam("texScaleX", 1.0F));
      super.addParam(new UniformParam.FloatParam("texScaleY", 1.0F));
      super.addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
      super.OnDrawFrameGLSL();
      GLES20.glDrawArrays(5, 0, ((ArrayList)localObject1).size() * 4);
      GLES20.glFlush();
      PersonalityUtils.a(0);
      System.currentTimeMillis();
      return true;
    }
    return false;
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
    super.addParam(new UniformParam.FloatParam("alpha", 1.0F));
    DoodleItem localDoodleItem = this.jdField_a_of_type_ComTencentTtpicOpenapiModelDoodleItem;
    if (localDoodleItem != null) {
      super.addParam(new UniformParam.IntParam("blendMode", localDoodleItem.blendMode));
    }
    super.addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
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
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.PersonalityGlareFilter
 * JD-Core Version:    0.7.0.1
 */