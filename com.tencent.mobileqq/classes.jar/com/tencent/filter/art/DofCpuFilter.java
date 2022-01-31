package com.tencent.filter.art;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.filter.QImage;
import java.util.Map;

public class DofCpuFilter
  extends BaseFilter
{
  int down_innerradius = 0;
  int down_outerradius = 0;
  Bitmap maskbmp = null;
  int paramTEXTRUEID = 0;
  int py = 0;
  int type = 0;
  int up_innerradius = 0;
  int up_outerradius = 0;
  int xmax = 0;
  int xmin = 0;
  int ymax = 0;
  int ymin = 0;
  
  public DofCpuFilter(int paramInt)
  {
    super(GLSLRender.FILTER_SHADER_NONE);
    this.type = paramInt;
  }
  
  private void CalDofParameter(float paramFloat1, float paramFloat2)
  {
    if ((this.xmin == 0) && (this.xmax == 0) && (this.ymin == 0) && (this.ymax == 0)) {}
    do
    {
      return;
      float f1 = this.ymax - this.ymin;
      float f4 = this.ymin;
      float f5 = f1 / 2.0F;
      float f6 = paramFloat2 / 2.0F;
      float f2 = f1 / this.ymax;
      float f3 = (this.ymax - this.ymin) / paramFloat2;
      paramFloat1 = (this.xmax - this.xmin) / paramFloat1;
      f4 = Math.abs(f4 + f5 - f6) / paramFloat2;
      f5 = Math.abs(paramFloat2 - this.ymax) / paramFloat2;
      this.py = this.ymax;
      this.down_innerradius = 0;
      if ((f3 > 0.7F) && (paramFloat1 > 0.8F))
      {
        this.up_innerradius = ((int)((1.0F - f2) * f1));
        this.up_outerradius = ((int)((1.0F - f2) * f1 + 50.0F));
        return;
      }
      this.up_innerradius = ((int)(0.3F * f1));
      this.up_outerradius = ((int)(this.up_innerradius + 0.5F * f1));
      paramFloat1 = this.up_outerradius;
      paramFloat1 = this.up_innerradius / paramFloat1;
      if (this.up_outerradius > 0.6F * paramFloat2)
      {
        this.up_outerradius = ((int)(0.6F * paramFloat2));
        this.up_innerradius = ((int)(0.6F * paramFloat2 * paramFloat1));
      }
      for (;;)
      {
        if (f4 >= f5) {
          break label397;
        }
        this.down_innerradius = ((int)(0.1F * f1));
        this.down_outerradius = ((int)(this.down_innerradius + 0.5F * f1));
        paramFloat1 = this.down_outerradius;
        paramFloat1 = this.down_innerradius / paramFloat1;
        if (this.down_outerradius <= 0.6F * paramFloat2) {
          break;
        }
        this.down_outerradius = ((int)(0.6F * paramFloat2));
        this.down_innerradius = ((int)(0.6F * paramFloat2 * paramFloat1));
        return;
        if (this.up_outerradius < 0.3F * paramFloat2)
        {
          this.up_outerradius = ((int)(0.3F * paramFloat2));
          this.up_innerradius = ((int)(0.3F * paramFloat2 * paramFloat1));
        }
      }
    } while (this.down_outerradius >= 0.2F * paramFloat2);
    this.down_outerradius = ((int)(0.2F * paramFloat2));
    this.down_innerradius = ((int)(0.2F * paramFloat2 * paramFloat1));
    return;
    label397:
    this.down_innerradius = 0;
  }
  
  public static Bitmap blurBitmap(Bitmap paramBitmap)
  {
    QImage localQImage2 = QImage.BindBitmap(paramBitmap);
    QImage localQImage1 = nativeSacle(localQImage2, 2);
    nativeRoundBlurProcess(localQImage1, 4);
    localQImage2.UnBindBitmap(paramBitmap);
    paramBitmap = Bitmap.createBitmap(localQImage1.getWidth(), localQImage1.getHeight(), Bitmap.Config.ARGB_8888);
    localQImage1.ToBitmap(paramBitmap);
    localQImage1.Dispose();
    return paramBitmap;
  }
  
  public static native void nativeRoundBlurProcess(QImage paramQImage, int paramInt);
  
  public static native QImage nativeSacle(QImage paramQImage, int paramInt);
  
  public static native void nativeblurBorder(Bitmap paramBitmap, int paramInt);
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject;
    if (this.type == 0)
    {
      this.glsl_programID = GLSLRender.FILTER_DOF_SHADER;
      if (this.maskbmp != null) {
        addParam(new Param.TextureBitmapParam("inputImageTexture2", blurBitmap(this.maskbmp), 33986, true));
      }
      CalDofParameter(paramFloat1, paramFloat2);
      addParam(new Param.FloatParam("py", this.py / paramFloat2));
      addParam(new Param.FloatParam("up_innerradius", this.up_innerradius / paramFloat2));
      addParam(new Param.FloatParam("down_innerradius", this.down_innerradius / paramFloat2));
      addParam(new Param.FloatParam("up_outerradius", this.up_outerradius / paramFloat2));
      addParam(new Param.FloatParam("down_outerradius", this.down_outerradius / paramFloat2));
      localObject = new BaseFilter(GLSLRender.FILTER_TILT_TOUCH_MASK);
      if (this.maskbmp != null)
      {
        Bitmap localBitmap = this.maskbmp.copy(this.maskbmp.getConfig(), false);
        nativeblurBorder(localBitmap, 2);
        ((BaseFilter)localObject).addParam(new Param.TextureBitmapParam("inputImageTexture3", localBitmap, 33987, true));
      }
      setNextFilter((BaseFilter)localObject, new int[] { this.srcTextureIndex });
    }
    for (;;)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      this.glsl_programID = GLSLRender.FILTER_TILT_TOUCH_MASK2;
      if (this.maskbmp != null)
      {
        localObject = this.maskbmp.copy(this.maskbmp.getConfig(), false);
        nativeblurBorder((Bitmap)localObject, 2);
        addParam(new Param.TextureBitmapParam("inputImageTexture3", (Bitmap)localObject, 33987, true));
        addParam(new Param.TextureBitmapParam("inputImageTexture2", blurBitmap(this.maskbmp), 33986, true));
      }
    }
  }
  
  public void ClearGLSL()
  {
    this.maskbmp = null;
    super.ClearGLSL();
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("xmin")) {
      this.xmin = ((Integer)paramMap.get("xmin")).intValue();
    }
    if (paramMap.containsKey("ymin")) {
      this.ymin = ((Integer)paramMap.get("ymin")).intValue();
    }
    if (paramMap.containsKey("xmax")) {
      this.xmax = ((Integer)paramMap.get("xmax")).intValue();
    }
    if (paramMap.containsKey("ymax")) {
      this.ymax = ((Integer)paramMap.get("ymax")).intValue();
    }
    if (paramMap.containsKey("maskbmp")) {
      this.maskbmp = ((Bitmap)paramMap.get("maskbmp"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.art.DofCpuFilter
 * JD-Core Version:    0.7.0.1
 */