package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.FilterAlgorithm;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.TextureResParam;
import com.tencent.filter.QImage;
import com.tencent.view.RendererUtils;
import java.util.Map;

public class FaceBeautyAutoFilter
  extends BaseFilter
{
  public static final int FBPFQ_HIGH = 3;
  public static final int FBPFQ_LOW = 1;
  public static final int FBPFQ_MEDIUM = 2;
  public static final int FBPFQ_NONE = 0;
  public static final int FBPF_BAIXI = 3;
  public static final int FBPF_HONGRUN = 2;
  public static final int FBPF_MENGHUAN = 5;
  public static final int FBPF_NONE = 0;
  public static final int FBPF_ROUNEN = 7;
  public static final int FBPF_TIANMEI = 4;
  public static final int FBPF_YANGGUANG = 6;
  public static final int FBPF_ZIRAN = 1;
  private int filter_type = 1;
  private int quality = 2;
  
  public FaceBeautyAutoFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  private void updateToneFilter(BaseFilter paramBaseFilter)
  {
    int i = this.filter_type;
    int j = this.quality;
    double d8 = 0.0D;
    double d6 = 0.0D;
    double d10 = 0.0D;
    double d11 = 0.0D;
    double d7 = 0.0D;
    double d12 = 0.0D;
    double d3 = 0.0D;
    if (i == 1)
    {
      d8 = 0.09D;
      d6 = 0.09D;
      d3 = 0.15D;
    }
    if (i == 3)
    {
      d7 = -0.06D;
      d3 = 0.07000000000000001D;
    }
    double d2 = d6;
    double d4 = d10;
    double d5 = d11;
    double d1 = d12;
    double d9 = d3;
    if (i == 4)
    {
      if (j == 1)
      {
        d2 = 0.455D;
        d4 = 0.17D;
        d5 = 0.177D;
        d1 = 0.2D;
        d9 = d3;
      }
    }
    else
    {
      d6 = d8;
      d3 = d2;
      d10 = d1;
      if (i == 2)
      {
        if (j != 1) {
          break label413;
        }
        d6 = 0.121D;
        d3 = 0.354D;
        d10 = d1;
      }
    }
    for (;;)
    {
      d1 = d7;
      if (i == 5) {
        d1 = -0.08D;
      }
      if (i == 7)
      {
        d3 = 0.1D;
        d1 = -0.08D;
        d9 = 0.15D;
      }
      if (i == 6)
      {
        d1 = -0.12D;
        d9 = 0.16D;
      }
      paramBaseFilter.addParam(new Param.FloatParam("percent1", (float)d6));
      paramBaseFilter.addParam(new Param.FloatParam("percent2", (float)d3));
      paramBaseFilter.addParam(new Param.FloatParam("percent3", (float)d4));
      paramBaseFilter.addParam(new Param.FloatParam("percent4", (float)d5));
      paramBaseFilter.addParam(new Param.FloatParam("percent5", (float)d1));
      paramBaseFilter.addParam(new Param.FloatParam("percent6", (float)d10));
      paramBaseFilter.addParam(new Param.FloatParam("percent7", (float)d9));
      return;
      if (j == 2)
      {
        d2 = 0.62D;
        d4 = 0.375D;
        d5 = 0.07000000000000001D;
        d1 = 0.125D;
        d9 = 0.26D;
        break;
      }
      d2 = d6;
      d4 = d10;
      d5 = d11;
      d1 = d12;
      d9 = d3;
      if (j != 3) {
        break;
      }
      d2 = 0.824D;
      d4 = 0.461D;
      d5 = 0.152D;
      d1 = 0.2D;
      d9 = d3;
      break;
      label413:
      if (j == 2)
      {
        d6 = 0.32D;
        d3 = 0.35D;
        d10 = -0.1D;
      }
      else
      {
        d6 = d8;
        d3 = d2;
        d10 = d1;
        if (j == 3)
        {
          d6 = 0.366D;
          d3 = 0.5540000000000001D;
          d10 = d1;
        }
      }
    }
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    new StringBuilder().append("value = ").append(this.filter_type).toString();
    this.glsl_programID = GLSLRender.FILTER_SHADER_NONE;
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_TONEADJUST_SHADER);
    setNextFilter(localBaseFilter, null);
    updateToneFilter(localBaseFilter);
    Object localObject = new MicCureFaceFilter(this.filter_type, this.quality);
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    float f;
    if (this.filter_type == 5)
    {
      f = Math.min(paramFloat2, paramFloat1);
      localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
      localBaseFilter.scaleFact = Math.min(400.0F / f, 1.0F);
      ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
      localObject = new FocusBlurFilter(this.quality, localBaseFilter.scaleFact);
      localBaseFilter.setNextFilter((BaseFilter)localObject, null);
      localBaseFilter = new BaseFilter(GLSLRender.FILTER_ALPHA_ADJUST);
      f = 0.0F;
      switch (this.quality)
      {
      }
    }
    for (;;)
    {
      ((BaseFilter)localObject).setNextFilter(localBaseFilter, new int[] { this.srcTextureIndex + 3 });
      ((BaseFilter)localObject).addParam(new Param.FloatParam("filterAdjustParam", 1.0F - f));
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      f = 0.89F;
      continue;
      f = 0.78F;
      continue;
      f = 0.573F;
    }
  }
  
  public void setEffectIndex(int paramInt)
  {
    this.filter_type = paramInt;
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("effectIndex")) {
      this.filter_type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
    if (paramMap.containsKey("filter_type")) {
      this.filter_type = ((Integer)paramMap.get("filter_type")).intValue();
    }
    if (paramMap.containsKey("filter_quality")) {
      this.quality = ((Integer)paramMap.get("filter_quality")).intValue();
    }
  }
  
  public class FocusBlurFilter
    extends BaseFilter
  {
    private float blurSize = 0.0F;
    float lastScaleFilt = 1.0F;
    private int paramTEXTRUEID = 0;
    
    public FocusBlurFilter(int paramInt, float paramFloat)
    {
      super();
      this.lastScaleFilt = paramFloat;
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.blurSize *= 2.0F;
        return;
        this.blurSize = 0.62F;
        continue;
        this.blurSize = 0.67F;
        continue;
        this.blurSize = 1.0F;
      }
    }
    
    public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
    {
      this.paramTEXTRUEID = RendererUtils.createTexture();
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    }
    
    public void ClearGLSL()
    {
      RendererUtils.clearTexture(this.paramTEXTRUEID);
      super.ClearGLSL();
    }
    
    public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
    {
      QImage localQImage = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
      FilterAlgorithm.nativeFastBlur(localQImage, this.blurSize * this.lastScaleFilt);
      GLSLRender.nativeTextImage(localQImage, this.paramTEXTRUEID);
      localQImage.Dispose();
    }
    
    public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
    {
      return super.renderTexture(this.paramTEXTRUEID, paramInt2, paramInt3);
    }
  }
  
  public class MicCureFaceFilter
    extends BaseFilter
  {
    private final String[] fileNames = { "error.file", "yijian_ziran", "yijian_hongrun", "yijian_baixi", "yijian_tianmei", "yijian_menghuan", "yijian_yangguang", "yijian_rounen" };
    int filter_type = 0;
    private final float[] qualities = { 1.0F, 1.0F, 0.95F, 0.9F };
    int quality = 2;
    
    public MicCureFaceFilter(int paramInt1, int paramInt2)
    {
      super();
      this.filter_type = paramInt1;
      this.quality = paramInt2;
      new StringBuilder().append("value = ").append(this.filter_type).toString();
    }
    
    public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
    {
      new StringBuilder().append("value = ").append(this.filter_type).toString();
      String str = "yijian/" + this.fileNames[this.filter_type] + "_" + this.quality + ".jpg";
      float f2 = this.qualities[this.quality];
      float f1 = f2;
      if (this.filter_type == 5)
      {
        if (this.quality == 1) {
          f1 = 0.912F;
        }
      }
      else
      {
        f2 = f1;
        if (this.filter_type == 4)
        {
          if (this.quality != 3) {
            break label271;
          }
          f2 = 1.1F;
        }
      }
      for (;;)
      {
        this.glsl_programID = GLSLRender.FILTER_MIC_CURE_SHADER;
        addParam(new Param.TextureResParam("inputImageTexture2", str, 33986));
        addParam(new Param.FloatParam("quality", f2));
        addParam(new Param.FloatParam("add_red", 0.0F));
        addParam(new Param.FloatParam("red_m", 0.0F));
        addParam(new Param.FloatParam("green_m", 0.0F));
        addParam(new Param.FloatParam("blue_m", 0.0F));
        super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
        return;
        if (this.quality == 2)
        {
          f1 = 0.95F;
          break;
        }
        f1 = f2;
        if (this.quality != 3) {
          break;
        }
        f1 = 0.88F;
        break;
        label271:
        f2 = f1;
        if (this.quality == 2) {
          f2 = 1.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.FaceBeautyAutoFilter
 * JD-Core Version:    0.7.0.1
 */