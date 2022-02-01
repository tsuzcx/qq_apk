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
  List<PointF> a = new ArrayList();
  Point b;
  List<Bitmap> c = new ArrayList();
  protected UniformParam.TextureBitmapParam d;
  public int e = 320;
  public int f = 480;
  public int g = 1080;
  public int h = 1440;
  private String i = "doodle_image";
  private DoodleItem j;
  private boolean k = false;
  
  public PersonalityGlareFilter(DoodleItem paramDoodleItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_DOODLE));
    this.j = paramDoodleItem;
    initParams();
    a(paramString);
    paramDoodleItem.width = 25;
    paramDoodleItem.height = 25;
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    localStringBuilder.append(this.i);
    localStringBuilder.append("/");
    localStringBuilder.append(this.i);
    localStringBuilder.append("_0.png");
    paramString = BitmapUtils.decodeSampledBitmapFromFile(FileUtils.getRealPath(localStringBuilder.toString()), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
    if (BitmapUtils.isLegal(paramString))
    {
      this.c.add(paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Personality", 2, "PersonalityGlareFilter init bitmap is null");
    }
  }
  
  private void b()
  {
    Bitmap localBitmap = (Bitmap)this.c.get(0);
    UniformParam.TextureBitmapParam localTextureBitmapParam = this.d;
    if (localTextureBitmapParam != null)
    {
      localTextureBitmapParam.swapTextureBitmap(localBitmap);
      return;
    }
    this.d = new UniformParam.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, false);
    this.d.initialParams(super.getProgramIds());
    super.addParam(this.d);
  }
  
  public void ApplyGLSLFilter()
  {
    if (!this.k)
    {
      this.k = true;
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
    float f3 = this.j.width * this.width / this.g;
    int m = 3;
    while (m < this.a.size())
    {
      Object localObject = this.a;
      int n = m - 3;
      localObject = (PointF)((List)localObject).get(n);
      List localList = this.a;
      int i1 = m - 2;
      float f1 = (float)PersonalityUtils.a((PointF)localObject, (PointF)localList.get(i1));
      localObject = (PointF)this.a.get(i1);
      localList = this.a;
      int i2 = m - 1;
      float f2 = 1.0F / ((int)((f1 + (float)PersonalityUtils.a((PointF)localObject, (PointF)localList.get(i2)) + (float)PersonalityUtils.a((PointF)this.a.get(i2), (PointF)this.a.get(m))) / (f3 * 1.5F)) * 12 * 1.0F);
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
        paramArrayList.add(a((PointF)this.a.get(n), (PointF)this.a.get(i1), (PointF)this.a.get(i2), (PointF)this.a.get(m), f2));
      }
      m += 1;
    }
  }
  
  public void a(List<PointF> paramList)
  {
    this.a.clear();
    if (this.c.size() < 1) {
      return;
    }
    b();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PointF localPointF = (PointF)paramList.next();
      localPointF = new PointF(localPointF.x + this.b.x, localPointF.y + this.b.y);
      this.a.add(localPointF);
    }
  }
  
  public boolean a()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((List)localObject1).size() >= 1))
    {
      System.currentTimeMillis();
      int m = 2;
      PersonalityUtils.a(2);
      float f1 = this.j.width * this.width / this.g * 1.5F;
      float f2 = this.j.height * this.height / this.h * 1.5F;
      localObject1 = new ArrayList();
      if (this.a.size() <= 3) {
        m = 3;
      }
      int n = 0;
      int i2;
      int i1;
      float f3;
      float f5;
      float f4;
      float f6;
      while ((n < this.a.size()) && (n < m))
      {
        if (n > 0)
        {
          localObject2 = (PointF)this.a.get(n - 1);
          localObject3 = (PointF)this.a.get(n);
          i2 = (int)((float)PersonalityUtils.a((PointF)localObject2, (PointF)localObject3) / f1 * 18.0F) + 1;
          i1 = i2;
          if (i2 < 6) {
            i1 = 6;
          }
          f3 = ((PointF)localObject3).x;
          f5 = ((PointF)localObject2).x;
          f4 = i1 * 1.0F;
          f3 = (f3 - f5) / f4;
          f4 = (((PointF)localObject3).y - ((PointF)localObject2).y) / f4;
          i2 = 0;
          while (i2 < i1)
          {
            f5 = ((PointF)localObject2).x;
            f6 = i2;
            ((ArrayList)localObject1).add(new PointF(f5 + f3 * f6, ((PointF)localObject2).y + f6 * f4));
            i2 += 1;
          }
          if (!((PointF)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).equals(((PointF)localObject3).x, ((PointF)localObject3).y)) {
            ((ArrayList)localObject1).add(localObject2);
          }
        }
        n += 1;
      }
      if (this.a.size() > 3) {
        a((ArrayList)localObject1);
      }
      Object localObject2 = new float[((ArrayList)localObject1).size() * 8];
      Object localObject3 = new float[((ArrayList)localObject1).size() * 8];
      m = 0;
      while (m < ((ArrayList)localObject1).size())
      {
        PointF localPointF = (PointF)((ArrayList)localObject1).get(m);
        f6 = localPointF.x - f1 / 2.0F;
        f5 = this.height - localPointF.y + f2 / 2.0F;
        f3 = f6 / this.width * 2.0F - 1.0F;
        f4 = f5 / this.height * 2.0F - 1.0F;
        f6 = (f6 + f1) / this.width * 2.0F - 1.0F;
        f5 = (f5 - f2) / this.height * 2.0F - 1.0F;
        int i7 = m * 8;
        n = i7 + 0;
        localObject2[n] = f3;
        i1 = i7 + 1;
        localObject2[i1] = f5;
        i2 = i7 + 2;
        localObject2[i2] = f6;
        int i3 = i7 + 3;
        localObject2[i3] = f5;
        int i4 = i7 + 4;
        localObject2[i4] = f3;
        int i5 = i7 + 5;
        localObject2[i5] = f4;
        int i6 = i7 + 6;
        localObject2[i6] = f6;
        i7 += 7;
        localObject2[i7] = f4;
        localObject3[n] = 0.0F;
        localObject3[i1] = 1.0F;
        localObject3[i2] = 1.0F;
        localObject3[i3] = 1.0F;
        localObject3[i4] = 0.0F;
        localObject3[i5] = 0.0F;
        localObject3[i6] = 1.0F;
        localObject3[i7] = 0.0F;
        m += 1;
      }
      super.setPositions((float[])localObject2);
      super.setTexCords((float[])localObject3);
      super.addParam(new UniformParam.Float2fParam("texAnchor", -this.b.x, this.b.y));
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
    DoodleItem localDoodleItem = this.j;
    if (localDoodleItem != null) {
      super.addParam(new UniformParam.IntParam("blendMode", localDoodleItem.blendMode));
    }
    super.addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.b = new Point(paramInt1 / 2, paramInt2 / 2);
    super.addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.PersonalityGlareFilter
 * JD-Core Version:    0.7.0.1
 */