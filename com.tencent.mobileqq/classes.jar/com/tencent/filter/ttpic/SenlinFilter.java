package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class SenlinFilter
  extends BaseFilter
{
  private static final String shader = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float param;\n void main(void)\n {\n     vec4 color  = texture2D(inputImageTexture, textureCoordinate);\n     vec4 color2 = texture2D(inputImageTexture2, textureCoordinate);\n     vec3 ret=color.rgb+color2.rgb*param;\n     gl_FragColor = vec4(ret.rgb,1.0);\n }\n";
  
  public SenlinFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/senlin_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(57));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { -0.2862745F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { 0.04705882F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(117));
    localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/senlin_blend.png", 33986));
    localBaseFilter2.addParam(new UniformParam.FloatParam("transparency", 0.8F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(116));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.01176471F, 0.3215686F, 0.3098039F, 1.0F }));
    localBaseFilter1.addParam(new UniformParam.FloatParam("transparency", 1.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.filter.ttpic.SenlinFilter
 * JD-Core Version:    0.7.0.1
 */