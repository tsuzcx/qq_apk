package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.QImage;
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
  private int filterType = 1;
  private int quality = 2;
  
  public FaceBeautyAutoFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public static native void nativeFastBlur(QImage paramQImage, float paramFloat);
  
  private void updateToneFilter(BaseFilter paramBaseFilter)
  {
    int i = this.filterType;
    int j = this.quality;
    double d6;
    double d4;
    if (i == 1)
    {
      d6 = 0.09D;
      d4 = d6;
      d1 = 0.15D;
    }
    else
    {
      d1 = 0.0D;
      d6 = 0.0D;
      d4 = 0.0D;
    }
    double d5;
    double d9;
    if (i == 3)
    {
      d5 = -0.06D;
      d9 = 0.07000000000000001D;
    }
    else
    {
      d5 = 0.0D;
      d9 = d1;
    }
    double d3 = 0.2D;
    if (i == 4)
    {
      if (j == 1)
      {
        d4 = 0.455D;
        d2 = 0.17D;
      }
      for (d1 = 0.177D;; d1 = 0.152D)
      {
        d7 = d2;
        d8 = d1;
        break label174;
        if (j == 2)
        {
          d4 = 0.62D;
          d3 = 0.125D;
          d8 = 0.07000000000000001D;
          d7 = 0.375D;
          d9 = 0.26D;
          break label174;
        }
        if (j != 3) {
          break;
        }
        d4 = 0.824D;
        d2 = 0.461D;
      }
    }
    d3 = 0.0D;
    double d7 = 0.0D;
    double d8 = 0.0D;
    label174:
    double d2 = d6;
    double d1 = d4;
    double d10 = d3;
    if (i == 2) {
      if (j == 1)
      {
        d2 = 0.121D;
        d1 = 0.354D;
        d10 = d3;
      }
      else if (j == 2)
      {
        d2 = 0.32D;
        d1 = 0.35D;
        d10 = -0.1D;
      }
      else
      {
        d2 = d6;
        d1 = d4;
        d10 = d3;
        if (j == 3)
        {
          d2 = 0.366D;
          d1 = 0.5540000000000001D;
          d10 = d3;
        }
      }
    }
    if (i == 5) {
      d5 = -0.08D;
    }
    if (i == 7)
    {
      d1 = 0.1D;
      d5 = -0.08D;
      d3 = 0.15D;
    }
    else
    {
      d3 = d9;
    }
    if (i == 6)
    {
      d5 = -0.12D;
      d3 = 0.16D;
    }
    paramBaseFilter.addParam(new UniformParam.FloatParam("percent1", (float)d2));
    paramBaseFilter.addParam(new UniformParam.FloatParam("percent2", (float)d1));
    paramBaseFilter.addParam(new UniformParam.FloatParam("percent3", (float)d7));
    paramBaseFilter.addParam(new UniformParam.FloatParam("percent4", (float)d8));
    paramBaseFilter.addParam(new UniformParam.FloatParam("percent5", (float)d5));
    paramBaseFilter.addParam(new UniformParam.FloatParam("percent6", (float)d10));
    paramBaseFilter.addParam(new UniformParam.FloatParam("percent7", (float)d3));
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("value = ");
    ((StringBuilder)localObject).append(this.filterType);
    ((StringBuilder)localObject).toString();
    this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
    BaseFilter localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(99));
    setNextFilter(localBaseFilter, null);
    updateToneFilter(localBaseFilter);
    localObject = new FaceBeautyAutoFilter.MicCureFaceFilter(this, this.filterType, this.quality);
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    if (this.filterType == 5)
    {
      float f = Math.min(paramFloat2, paramFloat1);
      localBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      localBaseFilter.scaleFact = Math.min(400.0F / f, 1.0F);
      ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
      localObject = new FaceBeautyAutoFilter.FocusBlurFilter(this, this.quality, localBaseFilter.scaleFact);
      localBaseFilter.setNextFilter((BaseFilter)localObject, null);
      localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(3));
      f = 0.0F;
      int i = this.quality;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            f = 0.573F;
          }
        }
        else {
          f = 0.78F;
        }
      }
      else {
        f = 0.89F;
      }
      ((BaseFilter)localObject).setNextFilter(localBaseFilter, new int[] { this.srcTextureIndex + 3 });
      ((BaseFilter)localObject).addParam(new UniformParam.FloatParam("filterAdjustParam", 1.0F - f));
    }
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setEffectIndex(int paramInt)
  {
    this.filterType = paramInt;
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("effectIndex")) {
      this.filterType = ((Integer)paramMap.get("effectIndex")).intValue();
    }
    if (paramMap.containsKey("filter_type")) {
      this.filterType = ((Integer)paramMap.get("filter_type")).intValue();
    }
    if (paramMap.containsKey("filter_quality")) {
      this.quality = ((Integer)paramMap.get("filter_quality")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.ttpic.FaceBeautyAutoFilter
 * JD-Core Version:    0.7.0.1
 */