package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureFloatsParam;
import java.util.Map;

public class BeautysRealAutoFilter
  extends BaseFilter
{
  private float[] coef = new float[7];
  private final int[] curveStatic = { 0, 1, 3, 4, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40, 42, 43, 45, 46, 47, 49, 50, 52, 53, 55, 56, 58, 59, 61, 62, 63, 65, 66, 68, 69, 71, 72, 73, 75, 76, 78, 79, 80, 82, 83, 85, 86, 87, 89, 90, 92, 93, 94, 96, 97, 98, 100, 101, 102, 104, 105, 106, 108, 109, 110, 112, 113, 114, 116, 117, 118, 119, 121, 122, 123, 125, 126, 127, 128, 130, 131, 132, 133, 134, 136, 137, 138, 139, 140, 142, 143, 144, 145, 146, 147, 149, 150, 151, 152, 153, 154, 155, 156, 157, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 181, 182, 183, 184, 185, 186, 187, 188, 188, 189, 190, 191, 192, 193, 193, 194, 195, 196, 197, 197, 198, 199, 200, 201, 201, 202, 203, 204, 204, 205, 206, 207, 207, 208, 209, 209, 210, 211, 211, 212, 213, 213, 214, 215, 215, 216, 217, 217, 218, 219, 219, 220, 221, 221, 222, 222, 223, 224, 224, 225, 226, 226, 227, 227, 228, 228, 229, 230, 230, 231, 231, 232, 232, 233, 234, 234, 235, 235, 236, 236, 237, 237, 238, 238, 239, 240, 240, 241, 241, 242, 242, 243, 243, 244, 244, 245, 245, 246, 246, 247, 247, 248, 248, 249, 249, 250, 250, 251, 251, 252, 252, 253, 253, 254, 254, 255 };
  private final int[] meituWhiten = { 0, 1, 3, 4, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 28, 29, 31, 33, 34, 36, 38, 39, 41, 42, 44, 46, 47, 49, 51, 52, 54, 55, 57, 59, 60, 62, 64, 65, 67, 68, 70, 71, 73, 75, 76, 78, 79, 81, 82, 84, 86, 87, 89, 90, 92, 93, 95, 96, 98, 99, 101, 102, 104, 105, 107, 108, 110, 111, 113, 114, 116, 117, 119, 120, 121, 123, 124, 126, 127, 128, 130, 131, 133, 134, 135, 137, 138, 139, 141, 142, 143, 145, 146, 147, 149, 150, 151, 152, 154, 155, 156, 157, 159, 160, 161, 162, 164, 165, 166, 167, 168, 169, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 186, 187, 188, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 200, 201, 202, 203, 204, 205, 205, 206, 207, 208, 208, 209, 210, 211, 211, 212, 213, 214, 214, 215, 216, 216, 217, 218, 218, 219, 219, 220, 221, 221, 222, 223, 223, 224, 224, 225, 225, 226, 226, 227, 228, 228, 229, 229, 230, 230, 231, 231, 232, 232, 233, 233, 234, 234, 234, 235, 235, 236, 236, 237, 237, 237, 238, 238, 239, 239, 240, 240, 240, 241, 241, 241, 242, 242, 243, 243, 243, 244, 244, 244, 245, 245, 245, 246, 246, 246, 247, 247, 247, 248, 248, 248, 249, 249, 249, 250, 250, 250, 251, 251, 251, 252, 252, 252, 253, 253, 253, 254, 254, 254, 255 };
  private float opttype = 1.0F;
  private BaseFilter processfilter = null;
  private float radius = 0.5F;
  private float scale = 1.0F;
  private float skinFilter = 1.0F;
  private BeautysRealAutoFilter.SmootfilterImpFilter smootfilter1 = null;
  private BeautysRealAutoFilter.SmootfilterImpFilter smootfilter2 = null;
  private float smoothMag = 0.3F;
  private float whitenmag = 0.0F;
  
  public BeautysRealAutoFilter()
  {
    super(BaseFilter.getFragmentShader(122));
    setRadius(1.0F);
  }
  
  private void setRadius(float paramFloat)
  {
    this.radius = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    this.radius = this.radius;
    if (this.smootfilter2 != null)
    {
      this.smootfilter1.updateRadius(this.radius);
      this.smootfilter2.updateRadius(this.radius);
    }
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (isValid())
    {
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    addParam(new UniformParam.FloatsParam("levelMinimum", new float[] { 0.04F, 0.04F, 0.04F }));
    addParam(new UniformParam.FloatsParam("levelMiddle", new float[] { 1.0F, 1.0F, 1.0F }));
    addParam(new UniformParam.FloatsParam("levelMaximum", new float[] { 0.96F, 0.96F, 0.96F }));
    addParam(new UniformParam.FloatsParam("minOutput", new float[] { 0.0F, 0.0F, 0.0F }));
    addParam(new UniformParam.FloatsParam("maxOutput", new float[] { 1.0F, 1.0F, 1.0F }));
    this.smootfilter1 = new BeautysRealAutoFilter.SmootfilterImpFilter(true);
    this.smootfilter1.updateRadius(this.radius);
    setNextFilter(this.smootfilter1, null);
    this.smootfilter2 = new BeautysRealAutoFilter.SmootfilterImpFilter(false);
    this.smootfilter2.updateRadius(this.radius);
    this.smootfilter1.setNextFilter(this.smootfilter2, null);
    this.processfilter = new BaseFilter(BaseFilter.getFragmentShader(121));
    this.processfilter.addParam(new TextureFloatsParam("inputImageTexture2", this.curveStatic, 33986));
    this.processfilter.addParam(new TextureFloatsParam("inputImageTexture3", this.meituWhiten, 33987));
    this.processfilter.addParam(new UniformParam.FloatParam("whiten", this.whitenmag));
    this.processfilter.addParam(new UniformParam.FloatParam("opttype", this.opttype));
    this.processfilter.addParam(new UniformParam.FloatParam("skinFilter", this.skinFilter));
    this.processfilter.addParam(new UniformParam.FloatParam("smoothMag", this.smoothMag));
    this.smootfilter2.setNextFilter(this.processfilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("opttype"))
    {
      this.opttype = ((Float)paramMap.get("opttype")).floatValue();
      if (this.processfilter != null) {
        this.processfilter.addParam(new UniformParam.FloatParam("opttype", this.opttype));
      }
    }
    if (paramMap.containsKey("whitenmag"))
    {
      this.whitenmag = Math.max(0.0F, Math.min(((Float)paramMap.get("whitenmag")).floatValue(), 1.0F));
      if (this.processfilter != null) {
        this.processfilter.addParam(new UniformParam.FloatParam("whiten", this.whitenmag));
      }
    }
    if (paramMap.containsKey("scale")) {
      this.scale = ((Float)paramMap.get("scale")).floatValue();
    }
    if (paramMap.containsKey("radius")) {
      setRadius(((Float)paramMap.get("radius")).floatValue());
    }
    if (paramMap.containsKey("smoothMag"))
    {
      this.smoothMag = ((Float)paramMap.get("smoothMag")).floatValue();
      if (this.processfilter != null) {
        this.processfilter.addParam(new UniformParam.FloatParam("smoothMag", this.smoothMag));
      }
    }
    if (paramMap.containsKey("skinFilter"))
    {
      this.skinFilter = ((Float)paramMap.get("skinFilter")).floatValue();
      if (this.processfilter != null) {
        this.processfilter.addParam(new UniformParam.FloatParam("skinFilter", this.skinFilter));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.filter.ttpic.BeautysRealAutoFilter
 * JD-Core Version:    0.7.0.1
 */