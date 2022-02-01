package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.view.RendererUtils;
import java.util.Map;

public class HDRHSVFilter
  extends BaseFilter
{
  private BaseFilter copyFilter;
  private HistogramsStrectchFilter hisStretchFilter;
  private BaseFilter hsv2rgbFilter;
  float maxRatio = 0.999F;
  float minRatio = 0.001F;
  private BaseFilter rgb2hsvFilter;
  private BaseFilter saturationFilter;
  float saturationMag = 1.3F;
  private BaseFilter scaleUpFilter;
  private BaseFilter sharpen = null;
  float sharpnessMag = 0.3F;
  private HDRHSVFilter.ChannelStretchFilter stretech = null;
  float stretechMag = 25.0F;
  private int[] tex = new int[1];
  
  public HDRHSVFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public Frame RenderProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    BaseFilter localBaseFilter = getmNextFilter();
    setNextFilter(null, null);
    Object localObject1 = super.RenderProcess(paramInt1, paramInt2, paramInt3);
    this.hisStretchFilter.setTextureParam(paramInt1, 0);
    Object localObject2 = this.hisStretchFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, paramInt2, paramInt3);
    ((Frame)localObject1).unlock();
    localObject1 = this.rgb2hsvFilter.RenderProcess(((Frame)localObject2).getTextureId(), paramInt2, paramInt3);
    ((Frame)localObject2).unlock();
    this.stretech.setTextureParam(((Frame)localObject1).getTextureId(), 0);
    double d = Math.max(paramInt2, paramInt3);
    Double.isNaN(d);
    paramInt1 = (int)Math.ceil(d / 200.0D);
    localObject2 = RendererUtils.saveTexture2QImage(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height);
    QImage localQImage = ((QImage)localObject2).InplaceBlur8bitQImage(paramInt1, 10);
    ((QImage)localObject2).Dispose();
    GLSLRender.nativeTextImage(localQImage, this.tex[0]);
    localQImage.Dispose();
    this.stretech.setTextureParam(this.tex[0], 1);
    localObject2 = this.stretech.RenderProcess(((Frame)localObject1).getTextureId(), paramInt2, paramInt3);
    ((Frame)localObject1).unlock();
    localObject1 = this.sharpen.RenderProcess(((Frame)localObject2).getTextureId(), paramInt2, paramInt3);
    ((Frame)localObject2).unlock();
    localObject2 = this.hsv2rgbFilter.RenderProcess(((Frame)localObject1).getTextureId(), paramInt2, paramInt3);
    ((Frame)localObject1).unlock();
    localObject1 = this.saturationFilter.RenderProcess(((Frame)localObject2).getTextureId(), paramInt2, paramInt3);
    ((Frame)localObject2).unlock();
    if (localBaseFilter != null)
    {
      localObject2 = localBaseFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height);
      ((Frame)localObject1).unlock();
      localObject1 = localObject2;
    }
    setNextFilter(localBaseFilter, null);
    return localObject1;
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    Frame localFrame = RenderProcess(paramInt1, paramInt2, paramInt3);
    this.copyFilter.RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, paramInt4, paramDouble, paramFrame);
    localFrame.clear();
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    this.scaleFact = Math.min(100.0F / Math.min(paramFloat2, paramFloat1), 1.0F);
    this.hisStretchFilter = new HistogramsStrectchFilter(this.minRatio, this.maxRatio);
    this.hisStretchFilter.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    this.rgb2hsvFilter = new BaseFilter(BaseFilter.getFragmentShader(28));
    this.rgb2hsvFilter.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    this.stretech = new HDRHSVFilter.ChannelStretchFilter();
    this.stretech.updateparam(this.stretechMag);
    this.stretech.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    this.scaleUpFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.scaleUpFilter.apply();
    this.copyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.copyFilter.apply();
    this.sharpen = new BaseFilter(BaseFilter.getVertexShader(2), BaseFilter.getFragmentShader(33));
    this.sharpen.addParam(new UniformParam.FloatParam("sharpness", this.sharpnessMag));
    this.sharpen.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    this.hsv2rgbFilter = new BaseFilter(BaseFilter.getFragmentShader(29));
    this.hsv2rgbFilter.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    this.saturationFilter = new BaseFilter(BaseFilter.getFragmentShader(31));
    this.saturationFilter.addParam(new UniformParam.FloatParam("saturation", this.saturationMag));
    this.saturationFilter.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    int[] arrayOfInt = this.tex;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.copyFilter.clearGLSLSelf();
    this.stretech.clearGLSLSelf();
    this.scaleUpFilter.clearGLSLSelf();
    this.hisStretchFilter.clearGLSLSelf();
    this.rgb2hsvFilter.clearGLSLSelf();
    this.saturationFilter.clearGLSLSelf();
    this.hsv2rgbFilter.clearGLSLSelf();
    int[] arrayOfInt = this.tex;
    GlUtil.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public boolean isAdjustFilter()
  {
    return true;
  }
  
  public void setAdjustParam(float paramFloat)
  {
    paramFloat = (float)Math.max((float)Math.min(paramFloat, 1.0D), 0.0D);
    this.stretechMag = (50.0F * paramFloat);
    this.sharpnessMag = (paramFloat * 0.6F);
    Object localObject = this.stretech;
    if (localObject != null) {
      ((HDRHSVFilter.ChannelStretchFilter)localObject).updateparam(this.stretechMag);
    }
    localObject = this.sharpen;
    if (localObject != null) {
      ((BaseFilter)localObject).addParam(new UniformParam.FloatParam("sharpness", this.sharpnessMag));
    }
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("stretechMag")) {
      this.stretechMag = ((Float)paramMap.get("stretechMag")).floatValue();
    }
    if (paramMap.containsKey("sharpnessMag")) {
      this.sharpnessMag = ((Float)paramMap.get("sharpnessMag")).floatValue();
    }
    if (paramMap.containsKey("saturationMag")) {
      this.saturationMag = ((Float)paramMap.get("saturationMag")).floatValue();
    }
    if (paramMap.containsKey("percent"))
    {
      this.minRatio = ((Float)paramMap.get("percent")).floatValue();
      this.maxRatio = (1.0F - this.minRatio);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.HDRHSVFilter
 * JD-Core Version:    0.7.0.1
 */