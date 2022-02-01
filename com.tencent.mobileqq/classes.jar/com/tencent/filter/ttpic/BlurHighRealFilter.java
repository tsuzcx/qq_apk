package com.tencent.filter.ttpic;

import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import java.util.Map;

public class BlurHighRealFilter
  extends BaseFilter
{
  private static String kPortraitBlurAreaFragmentShaderString = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float debug;\n uniform float inner;\n uniform float outer;\n uniform vec2 ellipse;\n uniform vec2 center;\n uniform vec3 line1;\n uniform vec3 line2;\n uniform float filterAdjustParam;\n void main() {\n     vec4 original = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 tempColor;\n     float fx = (textureCoordinate.x - center.x);\n     float fy = (textureCoordinate.y - center.y);\n     float dist = sqrt(fx * fx * ellipse.x + fy * fy * ellipse.y);\n     if (dist < inner) {\n         tempColor = original;\n     } else {\n         vec3 point = vec3(textureCoordinate.x, textureCoordinate.y, 1.0);\n         float value1 = dot(line1, point);\n         float value2 = dot(line2, point);\n         if (value1 >= 0.0 && value2 >= 0.0) {\n             tempColor = original;\n         } else {\n             vec4 blur = texture2D(inputImageTexture, textureCoordinate);\n             float lineAlpha = max(-value1 / 0.15, -value2 / 0.15);\n             float alpha = (dist - inner)/outer;\n             alpha = min(lineAlpha, alpha);\n             alpha = clamp(alpha, 0.0, 1.0);\n             tempColor = mix(original, blur, alpha);\n         }\n     }\n    gl_FragColor = mix(original,tempColor,filterAdjustParam);\n }\n";
  private float adjust = 0.0F;
  private float angle = 0.0F;
  private BaseFilter blurArea = null;
  private PointF center = new PointF(0.5F, 0.5F);
  private boolean circle = false;
  private float debug = 0.0F;
  private BaseFilter horizontal = null;
  private int previewHeight;
  private int previewWidth;
  private float radius = 0.35F;
  private float ratio = 1.333333F;
  private BaseFilter vertical = null;
  
  public BlurHighRealFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  private void setAngle(float paramFloat)
  {
    double d = paramFloat / 180.0F;
    Double.isNaN(d);
    paramFloat = (float)(d * 3.141592653589793D);
    Object localObject1 = new float[3][];
    d = paramFloat;
    localObject1[0] = { (float)Math.cos(d), (float)Math.sin(d), 0.0F };
    localObject1[1] = { -(float)Math.sin(d), (float)Math.cos(d), 0.0F };
    localObject1[2] = { 0.0F, 0.0F, 1.0F };
    if (this.circle)
    {
      paramFloat = 1.0F;
      f = 1.0F;
    }
    else
    {
      paramFloat = 0.9F;
      f = 1.5F;
    }
    Object localObject2 = new float[2];
    localObject2[0] = (1.0F / (paramFloat * paramFloat));
    localObject2[1] = (1.0F / (f * f));
    float[] arrayOfFloat1 = new float[2];
    float[] tmp155_153 = arrayOfFloat1;
    tmp155_153[0] = 0.0F;
    float[] tmp159_155 = tmp155_153;
    tmp159_155[1] = 0.0F;
    tmp159_155;
    arrayOfFloat1[0] = (localObject2[0] * localObject1[0][0] + localObject2[1] * localObject1[0][1]);
    arrayOfFloat1[1] = (localObject2[0] * localObject1[1][0] + localObject2[1] * localObject1[1][1]);
    arrayOfFloat1[0] = Math.abs(arrayOfFloat1[0]);
    paramFloat = Math.abs(arrayOfFloat1[1]);
    float f = this.ratio;
    arrayOfFloat1[1] = (paramFloat * f * f);
    localObject2 = this.blurArea;
    if (localObject2 != null) {
      ((BaseFilter)localObject2).addParam(new UniformParam.FloatsParam("ellipse", arrayOfFloat1));
    }
    localObject2 = new float[3];
    localObject2[0] = -0.3F;
    localObject2[1] = 1.0F;
    localObject2[2] = 0.0F;
    arrayOfFloat1 = new float[3];
    arrayOfFloat1[0] = (localObject2[0] * localObject1[0][0] + localObject2[1] * localObject1[0][1] + localObject2[2] * localObject1[0][2]);
    arrayOfFloat1[1] = (localObject2[0] * localObject1[1][0] + localObject2[1] * localObject1[1][1] + localObject2[2] * localObject1[1][2]);
    arrayOfFloat1[2] = (localObject2[0] * localObject1[2][0] + localObject2[1] * localObject1[2][1] + localObject2[2] * localObject1[2][2]);
    float[] arrayOfFloat2 = new float[3];
    float[] tmp432_430 = arrayOfFloat2;
    tmp432_430[0] = 0.3F;
    float[] tmp437_432 = tmp432_430;
    tmp437_432[1] = 1.0F;
    float[] tmp441_437 = tmp437_432;
    tmp441_437[2] = 0.0F;
    tmp441_437;
    localObject2 = new float[3];
    localObject2[0] = (arrayOfFloat2[0] * localObject1[0][0] + arrayOfFloat2[1] * localObject1[0][1] + arrayOfFloat2[2] * localObject1[0][2]);
    localObject2[1] = (arrayOfFloat2[0] * localObject1[1][0] + arrayOfFloat2[1] * localObject1[1][1] + arrayOfFloat2[2] * localObject1[1][2]);
    localObject2[2] = (arrayOfFloat2[0] * localObject1[2][0] + arrayOfFloat2[1] * localObject1[2][1] + arrayOfFloat2[2] * localObject1[2][2]);
    arrayOfFloat1[2] = (-(arrayOfFloat1[0] * this.center.x + arrayOfFloat1[1] * this.center.y));
    localObject2[2] = (-(localObject2[0] * this.center.x + localObject2[1] * this.center.y));
    if (this.circle)
    {
      arrayOfFloat1[0] = 0.0F;
      arrayOfFloat1[1] = 0.0F;
      arrayOfFloat1[2] = -0.15F;
      localObject2[0] = 0.0F;
      localObject2[1] = 0.0F;
      localObject2[2] = -0.15F;
    }
    localObject1 = this.blurArea;
    if (localObject1 != null)
    {
      ((BaseFilter)localObject1).addParam(new UniformParam.FloatsParam("line1", arrayOfFloat1));
      this.blurArea.addParam(new UniformParam.FloatsParam("line2", (float[])localObject2));
    }
    paramFloat = this.center.x;
    f = this.center.y;
    localObject1 = this.blurArea;
    if (localObject1 != null) {
      ((BaseFilter)localObject1).addParam(new UniformParam.FloatsParam("center", new float[] { paramFloat, f }));
    }
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.previewWidth = ((int)paramFloat1);
    this.previewHeight = ((int)paramFloat2);
    if (this.previewWidth != 0) {
      this.ratio = (paramFloat2 / paramFloat1);
    }
    float f = Math.round(0.008333334F * paramFloat1);
    int i;
    if (f >= 1.0F)
    {
      double d3 = f;
      double d1 = Math.pow(d3, 2.0D);
      double d2 = 0.0039063F;
      d3 = Math.sqrt(Math.pow(d3, 2.0D) * 6.283185307179586D);
      Double.isNaN(d2);
      i = (int)Math.floor(Math.sqrt(d1 * -2.0D * Math.log(d2 * d3)));
      i += i % 2;
    }
    else
    {
      i = 0;
    }
    this.horizontal = new BaseFilter(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadius(i, f, true));
    this.vertical = new BaseFilter(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadius(i, f, false));
    this.blurArea = new BaseFilter(kPortraitBlurAreaFragmentShaderString);
    setNextFilter(this.horizontal, null);
    this.horizontal.setNextFilter(this.vertical, null);
    this.vertical.setNextFilter(this.blurArea, new int[] { this.srcTextureIndex });
    this.blurArea.addParam(new UniformParam.FloatParam("debug", this.debug));
    this.blurArea.addParam(new UniformParam.FloatParam("outer", 0.12F));
    this.blurArea.addParam(new UniformParam.FloatParam("inner", this.radius));
    this.blurArea.addParam(new UniformParam.FloatParam("filterAdjustParam", this.adjust));
    setAngle(this.angle);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.previewWidth != paramInt2) || (this.previewHeight != paramInt3))
    {
      this.previewWidth = paramInt2;
      this.previewHeight = paramInt3;
      float f = Math.round(paramInt2 * 0.008333334F);
      if (f >= 1.0F)
      {
        double d3 = f;
        double d1 = Math.pow(d3, 2.0D);
        double d2 = 0.0039063F;
        d3 = Math.sqrt(Math.pow(d3, 2.0D) * 6.283185307179586D);
        Double.isNaN(d2);
        paramInt1 = (int)Math.floor(Math.sqrt(d1 * -2.0D * Math.log(d2 * d3)));
        paramInt1 += paramInt1 % 2;
      }
      else
      {
        paramInt1 = 0;
      }
      this.horizontal.updateFragmentShader(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadius(paramInt1, f, true));
      this.horizontal.clearGLSLSelf();
      this.horizontal.apply();
      this.vertical.updateFragmentShader(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadius(paramInt1, f, false));
      this.vertical.clearGLSLSelf();
      this.vertical.apply();
      setAngle(this.angle);
    }
  }
  
  public boolean needRender()
  {
    return Math.abs(this.adjust) > 0.01F;
  }
  
  public void setAdjustParam(float paramFloat)
  {
    this.adjust = paramFloat;
    this.blurArea.addParam(new UniformParam.FloatParam("filterAdjustParam", this.adjust));
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("circle")) {
      this.circle = ((Boolean)paramMap.get("circle")).booleanValue();
    }
    BaseFilter localBaseFilter;
    if (paramMap.containsKey("debug"))
    {
      this.debug = ((Float)paramMap.get("debug")).floatValue();
      localBaseFilter = this.blurArea;
      if (localBaseFilter != null) {
        localBaseFilter.addParam(new UniformParam.FloatParam("debug", this.debug));
      }
    }
    if (paramMap.containsKey("tx")) {
      this.center.x = ((Float)paramMap.get("tx")).floatValue();
    }
    if (paramMap.containsKey("ty")) {
      this.center.y = ((Float)paramMap.get("ty")).floatValue();
    }
    if (paramMap.containsKey("ratio")) {
      this.ratio = ((Float)paramMap.get("ratio")).floatValue();
    }
    if (paramMap.containsKey("radius"))
    {
      this.radius = ((Float)paramMap.get("radius")).floatValue();
      localBaseFilter = this.blurArea;
      if (localBaseFilter != null) {
        localBaseFilter.addParam(new UniformParam.FloatParam("inner", this.radius));
      }
    }
    if (paramMap.containsKey("angle")) {
      this.angle = ((Float)paramMap.get("angle")).floatValue();
    }
    setAngle(this.angle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.BlurHighRealFilter
 * JD-Core Version:    0.7.0.1
 */