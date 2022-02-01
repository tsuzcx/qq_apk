package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class DarkCornerPtuFilter
  extends BaseFilter
{
  private static String DC_FILTER_GPULEVELS_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform int maskType;\n\nuniform vec3 levelMinimum;\nuniform vec3 levelMiddle;\nuniform vec3 levelMaximum;\nuniform vec3 minOutput;\nuniform vec3 maxOutput;\n\nuniform float filterAdjustParam;\n\nvec3 levelscontrolinput(vec3 color,vec3 minInput,vec3 gamma,vec3 maxInput )\n{\n    vec3 temp =  min(max(color - minInput, vec3(0.0)) / (maxInput - minInput), vec3(1.0));\n    return pow(temp, 1.0 / gamma);\n}\n\nvec3 levelscontrol(vec3 color,vec3 minInput,vec3 gamma,vec3 maxInput,vec3 minOutput,vec3 maxOutput )\n{\n    return mix(minOutput, maxOutput, levelscontrolinput(color, minInput, gamma, maxInput));\n}\n\nvoid main()\n{\n    vec4 original, tempColor;\n    vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    original = textureColor;\n    vec3 temp =  levelscontrol(textureColor.rgb, levelMinimum, levelMiddle, levelMaximum, minOutput, maxOutput);\n    vec4 newcolor = vec4(temp, textureColor.a);\n\n    float alpha = 1.0;\n    if(maskType == 0) {\n        alpha = texture2D(inputImageTexture2, textureCoordinate).r;\n    } else { \n        alpha = texture2D(inputImageTexture3, textureCoordinate).r;\n    }\n    tempColor = mix(textureColor, newcolor, alpha);\n\n    gl_FragColor = mix(original,tempColor,filterAdjustParam);\n}";
  private float adjust = 0.0F;
  private int maskType = 0;
  private BaseFilter nextFilter = null;
  
  public DarkCornerPtuFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.nextFilter = new BaseFilter(DC_FILTER_GPULEVELS_SHADER);
    this.nextFilter.addParam(new TextureResParam("inputImageTexture2", "sh/darkcornermask_s.png", 33986));
    this.nextFilter.addParam(new TextureResParam("inputImageTexture3", "sh/darkcornermask_l.png", 33987));
    this.nextFilter.addParam(new UniformParam.FloatsParam("levelMinimum", new float[] { 0.0F, 0.0F, 0.0F }));
    this.nextFilter.addParam(new UniformParam.FloatsParam("levelMiddle", new float[] { 0.3F, 0.3F, 0.3F }));
    this.nextFilter.addParam(new UniformParam.FloatsParam("levelMaximum", new float[] { 1.0F, 1.0F, 1.0F }));
    this.nextFilter.addParam(new UniformParam.FloatsParam("minOutput", new float[] { 0.0F, 0.0F, 0.0F }));
    this.nextFilter.addParam(new UniformParam.FloatsParam("maxOutput", new float[] { 1.0F, 1.0F, 1.0F }));
    this.nextFilter.addParam(new UniformParam.IntParam("maskType", this.maskType));
    this.nextFilter.addParam(new UniformParam.FloatParam("filterAdjustParam", this.adjust));
    setNextFilter(this.nextFilter, (int[])null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public boolean needRender()
  {
    return Math.abs(this.adjust) > 0.01F;
  }
  
  public void setAdjustParam(float paramFloat)
  {
    this.adjust = paramFloat;
    this.nextFilter.addParam(new UniformParam.FloatParam("filterAdjustParam", this.adjust));
  }
  
  public void setMaskType(int paramInt)
  {
    this.maskType = paramInt;
    BaseFilter localBaseFilter = this.nextFilter;
    if (localBaseFilter != null) {
      localBaseFilter.addParam(new UniformParam.IntParam("maskType", this.maskType));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.DarkCornerPtuFilter
 * JD-Core Version:    0.7.0.1
 */