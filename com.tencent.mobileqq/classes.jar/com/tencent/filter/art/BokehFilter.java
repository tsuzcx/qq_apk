package com.tencent.filter.art;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.filter.Param.TextureResParam;
import com.tencent.filter.QImage;
import com.tencent.view.FilterDefault;
import com.tencent.view.RendererUtils;
import java.util.Map;

public class BokehFilter
  extends BaseFilter
{
  public static final int BOKEH_COUNT = 6;
  public static final int Bokeh_Type_CIRCLE = 1;
  public static final int Bokeh_Type_HEART = 3;
  public static final int Bokeh_Type_NONE = 0;
  public static final int Bokeh_Type_STAR = 2;
  public static final int Bokeh_Type_STAR2 = 4;
  public static Bitmap[] shaperbmp = { null, null, null, null, null, null };
  float bokehMaxWidth = 400.0F;
  int bokehType = 1;
  float input_radius = 0.5F;
  float lumi_threshold = 0.0F;
  float lumi_weight = (float)(1.0D / Math.exp(0.0D));
  Bitmap maskbmp = null;
  int radius = 8;
  
  public BokehFilter()
  {
    super(GLSLRender.FILTER_NIGHT_BOKEH);
  }
  
  public static native int nativeBokehProcess(QImage paramQImage1, QImage paramQImage2, int paramInt, float paramFloat1, float paramFloat2);
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glsl_programID = GLSLRender.FILTER_SHADER_NONE;
    this.scaleFact = (Math.min(960.0F / Math.max(paramFloat1, paramFloat2), 1.0F) * this.input_radius);
    BokehBaseFilter localBokehBaseFilter = new BokehBaseFilter(this.radius, this.lumi_weight, this.lumi_threshold, this.bokehType, 1);
    localBokehBaseFilter.setScaleFact(this.scaleFact);
    setNextFilter(localBokehBaseFilter, null);
    localBokehBaseFilter.setNextFilter(new BaseFilter(GLSLRender.FILTER_SHADER_NONE), null);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_TILT_TOUCH_MASK);
    if (this.maskbmp != null) {
      localBaseFilter.addParam(new Param.TextureBitmapParam("inputImageTexture3", this.maskbmp, 33987, false));
    }
    localBokehBaseFilter.setNextFilter(localBaseFilter, new int[] { -1 });
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void ClearGLSL()
  {
    super.ClearGLSL();
    this.maskbmp = null;
  }
  
  public void setBokehMaxWidth(float paramFloat)
  {
    this.bokehMaxWidth = paramFloat;
  }
  
  public void setInput_radius(float paramFloat)
  {
    this.input_radius = (1.0F - paramFloat);
    this.radius = 5;
    if ((this.input_radius < 0.8D) && (this.input_radius > 0.4F)) {
      this.radius = 8;
    }
    while (this.input_radius > 0.4F) {
      return;
    }
    this.input_radius = 0.4F;
    this.radius = ((int)(8 + 6.0F * paramFloat));
  }
  
  public void setMaskbmp(Bitmap paramBitmap)
  {
    this.maskbmp = paramBitmap;
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("inputradius")) {
      setInput_radius(((Float)paramMap.get("input_radius")).floatValue());
    }
    if (paramMap.containsKey("maxwidth")) {
      setBokehMaxWidth(((Float)paramMap.get("maxwidth")).floatValue());
    }
    if (paramMap.containsKey("maskbmp")) {
      setMaskbmp((Bitmap)paramMap.get("maskbmp"));
    }
    if (paramMap.containsKey("bokehType")) {
      this.bokehType = (((Integer)paramMap.get("bokehType")).intValue() % 6);
    }
    if (paramMap.containsKey("lumi_threshold")) {
      this.lumi_threshold = ((Float)paramMap.get("lumi_threshold")).floatValue();
    }
    if (paramMap.containsKey("lumi_weight")) {
      this.lumi_weight = ((float)(1.0D / Math.exp(((Float)paramMap.get("lumi_weight")).floatValue())));
    }
  }
  
  public static class BokehBaseFilter
    extends BaseFilter
  {
    int bokehType = 1;
    int bokehmode = 1;
    float lumi_threshold = 0.0F;
    float lumi_weight = (float)(1.0D / Math.exp(0.0D));
    int paramTEXTRUEID = -2000;
    int radius = 8;
    
    public BokehBaseFilter(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3)
    {
      super();
      this.radius = paramInt1;
      this.lumi_weight = paramFloat1;
      this.lumi_threshold = paramFloat2;
      this.bokehType = paramInt2;
      this.bokehmode = paramInt3;
      if (this.bokehmode > 0)
      {
        String str = getShaperFileByType(this.bokehType);
        if (str != null) {
          addParam(new Param.TextureResParam("inputImageTexture2", str, 33986));
        }
        addParam(new Param.FloatParam("lumi_threshold", this.lumi_threshold));
        addParam(new Param.FloatParam("lumi_weight", this.lumi_weight));
        if (this.bokehmode == 1)
        {
          this.glsl_programID = GLSLRender.FILTER_NIGHT_BOKEH;
          addParam(new Param.IntParam("r", this.radius));
          return;
        }
        this.glsl_programID = GLSLRender.FILTER_NIGHT_BOKEH_EX;
        return;
      }
      this.paramTEXTRUEID = RendererUtils.createTexture();
    }
    
    public static String getShaperFileByType(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "bokeh/shape1.jpg";
      case 1: 
        return "bokeh/circle.jpg";
      case 2: 
        return "bokeh/shape2.jpg";
      }
      return "bokeh/heart.jpg";
    }
    
    public void ClearGLSL()
    {
      if (this.paramTEXTRUEID != -2000)
      {
        RendererUtils.clearTexture(this.paramTEXTRUEID);
        this.paramTEXTRUEID = -2000;
      }
      super.ClearGLSL();
    }
    
    public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.bokehmode == 0)
      {
        Object localObject = getShaperFileByType(this.bokehType);
        if (localObject != null)
        {
          localObject = FilterDefault.decodeBitmap((String)localObject);
          QImage localQImage1 = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
          QImage localQImage2 = QImage.BindBitmap((Bitmap)localObject);
          BokehFilter.nativeBokehProcess(localQImage1, localQImage2, this.radius, this.lumi_weight, this.lumi_threshold);
          localQImage2.UnBindBitmap((Bitmap)localObject);
          ((Bitmap)localObject).recycle();
          GLSLRender.nativeTextImage(localQImage1, this.paramTEXTRUEID);
          localQImage1.Dispose();
        }
      }
    }
    
    public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.paramTEXTRUEID != -2000) {
        return super.renderTexture(this.paramTEXTRUEID, paramInt2, paramInt3);
      }
      return super.renderTexture(paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.art.BokehFilter
 * JD-Core Version:    0.7.0.1
 */