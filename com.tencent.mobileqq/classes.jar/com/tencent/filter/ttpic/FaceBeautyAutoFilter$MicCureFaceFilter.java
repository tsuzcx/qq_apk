package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class FaceBeautyAutoFilter$MicCureFaceFilter
  extends BaseFilter
{
  private final String[] fileNames = { "error.file", "yijian_ziran", "yijian_hongrun", "yijian_baixi", "yijian_tianmei", "yijian_menghuan", "yijian_yangguang", "yijian_rounen" };
  private int filterType = 0;
  private final float[] qualities = { 1.0F, 1.0F, 0.95F, 0.9F };
  private int quality = 2;
  
  public FaceBeautyAutoFilter$MicCureFaceFilter(FaceBeautyAutoFilter paramFaceBeautyAutoFilter, int paramInt1, int paramInt2)
  {
    super(BaseFilter.getFragmentShader(97));
    this.filterType = paramInt1;
    this.quality = paramInt2;
    paramFaceBeautyAutoFilter = new StringBuilder();
    paramFaceBeautyAutoFilter.append("value = ");
    paramFaceBeautyAutoFilter.append(this.filterType);
    paramFaceBeautyAutoFilter.toString();
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = this.qualities;
    int i = this.quality;
    float f2 = localObject[i];
    float f1 = f2;
    if (this.filterType == 5) {
      if (i == 1)
      {
        f1 = 0.912F;
      }
      else if (i == 2)
      {
        f1 = 0.95F;
      }
      else
      {
        f1 = f2;
        if (i == 3) {
          f1 = 0.88F;
        }
      }
    }
    f2 = f1;
    if (this.filterType == 4)
    {
      i = this.quality;
      if (i == 3)
      {
        f2 = 1.1F;
      }
      else
      {
        f2 = f1;
        if (i == 2) {
          f2 = 1.0F;
        }
      }
    }
    this.glslProgramShader = BaseFilter.getFragmentShader(97);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("yijian/");
    ((StringBuilder)localObject).append(this.fileNames[this.filterType]);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.quality);
    ((StringBuilder)localObject).append(".jpg");
    addParam(new TextureResParam("inputImageTexture2", ((StringBuilder)localObject).toString(), 33986));
    addParam(new UniformParam.FloatParam("quality", f2));
    addParam(new UniformParam.FloatParam("add_red", 0.0F));
    addParam(new UniformParam.FloatParam("red_m", 0.0F));
    addParam(new UniformParam.FloatParam("green_m", 0.0F));
    addParam(new UniformParam.FloatParam("blue_m", 0.0F));
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.FaceBeautyAutoFilter.MicCureFaceFilter
 * JD-Core Version:    0.7.0.1
 */