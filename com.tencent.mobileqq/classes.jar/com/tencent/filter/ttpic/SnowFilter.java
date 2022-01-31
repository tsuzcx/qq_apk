package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureResParam;

public class SnowFilter
  extends BaseFilter
{
  public static final String shader = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float param;\n void main(void)\n {\n     vec4 color  = texture2D(inputImageTexture, textureCoordinate);\n     vec4 color2 = texture2D(inputImageTexture2, textureCoordinate);\n     vec3 ret=color.rgb+color2.rgb*param;\n     gl_FragColor = vec4(ret.rgb,1.0);\n }\n";
  
  public SnowFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/snow_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    localBaseFilter1.addParam(new Param.FloatsParam("shadowsShift", new float[] { -0.09411765F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new Param.FloatsParam("midtonesShift", new float[] { -0.09803922F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new Param.FloatsParam("highlightsShift", new float[] { -0.0588235F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new Param.IntParam("preserveLuminosity", 1));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_TEMP);
    localBaseFilter2.addParam(new Param.FloatParam("scaleC", -0.354F));
    localBaseFilter2.addParam(new Param.FloatParam("scaleT", 0.0F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_HSVADJUSTER2_SHADER);
    localBaseFilter1.addParam(new Param.FloatParam("inputH", 1.0F));
    localBaseFilter1.addParam(new Param.FloatParam("inputS", 1.0F));
    localBaseFilter1.addParam(new Param.FloatParam("inputV", 1.05F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter("precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float param;\n void main(void)\n {\n     vec4 color  = texture2D(inputImageTexture, textureCoordinate);\n     vec4 color2 = texture2D(inputImageTexture2, textureCoordinate);\n     vec3 ret=color.rgb+color2.rgb*param;\n     gl_FragColor = vec4(ret.rgb,1.0);\n }\n");
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/snow.png", 33986, paramFloat1 / paramFloat2));
    localBaseFilter2.addParam(new Param.FloatParam("param", 0.35F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.SnowFilter
 * JD-Core Version:    0.7.0.1
 */