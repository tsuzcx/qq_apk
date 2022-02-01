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
    paramFloat = (float)(paramFloat / 180.0F * 3.141592653589793D);
    float[][] arrayOfFloat = new float[3][];
    arrayOfFloat[0] = { (float)Math.cos(paramFloat), (float)Math.sin(paramFloat), 0.0F };
    arrayOfFloat[1] = { -(float)Math.sin(paramFloat), (float)Math.cos(paramFloat), 0.0F };
    arrayOfFloat[2] = { 0.0F, 0.0F, 1.0F };
    float f1 = 0.9F;
    paramFloat = 1.5F;
    if (this.circle)
    {
      f1 = 1.0F;
      paramFloat = 1.0F;
    }
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = (1.0F / (f1 * f1));
    arrayOfFloat1[1] = (1.0F / (paramFloat * paramFloat));
    float[] arrayOfFloat2 = new float[2];
    float[] tmp142_140 = arrayOfFloat2;
    tmp142_140[0] = 0.0F;
    float[] tmp146_142 = tmp142_140;
    tmp146_142[1] = 0.0F;
    tmp146_142;
    arrayOfFloat2[0] = (arrayOfFloat1[0] * arrayOfFloat[0][0] + arrayOfFloat1[1] * arrayOfFloat[0][1]);
    arrayOfFloat2[1] = (arrayOfFloat1[0] * arrayOfFloat[1][0] + arrayOfFloat1[1] * arrayOfFloat[1][1]);
    arrayOfFloat2[0] = Math.abs(arrayOfFloat2[0]);
    arrayOfFloat2[1] = (Math.abs(arrayOfFloat2[1]) * this.ratio * this.ratio);
    if (this.blurArea != null) {
      this.blurArea.addParam(new UniformParam.FloatsParam("ellipse", arrayOfFloat2));
    }
    float[] arrayOfFloat3 = new float[3];
    arrayOfFloat3[0] = (-0.3F);
    arrayOfFloat3[1] = 1.0F;
    arrayOfFloat3[2] = 0.0F;
    arrayOfFloat1 = new float[3];
    float[] tmp292_290 = arrayOfFloat1;
    tmp292_290[0] = 0.3F;
    float[] tmp297_292 = tmp292_290;
    tmp297_292[1] = 1.0F;
    float[] tmp301_297 = tmp297_292;
    tmp301_297[2] = 0.0F;
    tmp301_297;
    arrayOfFloat2 = new float[3];
    arrayOfFloat2[0] = (arrayOfFloat3[0] * arrayOfFloat[0][0] + arrayOfFloat3[1] * arrayOfFloat[0][1] + arrayOfFloat3[2] * arrayOfFloat[0][2]);
    arrayOfFloat2[1] = (arrayOfFloat3[0] * arrayOfFloat[1][0] + arrayOfFloat3[1] * arrayOfFloat[1][1] + arrayOfFloat3[2] * arrayOfFloat[1][2]);
    paramFloat = arrayOfFloat3[0];
    f1 = arrayOfFloat[2][0];
    float f2 = arrayOfFloat3[1];
    float f3 = arrayOfFloat[2][1];
    arrayOfFloat2[2] = (arrayOfFloat3[2] * arrayOfFloat[2][2] + (paramFloat * f1 + f2 * f3));
    arrayOfFloat3 = new float[3];
    arrayOfFloat3[0] = (arrayOfFloat1[0] * arrayOfFloat[0][0] + arrayOfFloat1[1] * arrayOfFloat[0][1] + arrayOfFloat1[2] * arrayOfFloat[0][2]);
    arrayOfFloat3[1] = (arrayOfFloat1[0] * arrayOfFloat[1][0] + arrayOfFloat1[1] * arrayOfFloat[1][1] + arrayOfFloat1[2] * arrayOfFloat[1][2]);
    paramFloat = arrayOfFloat1[0];
    f1 = arrayOfFloat[2][0];
    f2 = arrayOfFloat1[1];
    f3 = arrayOfFloat[2][1];
    arrayOfFloat3[2] = (arrayOfFloat1[2] * arrayOfFloat[2][2] + (paramFloat * f1 + f2 * f3));
    arrayOfFloat2[2] = (-(arrayOfFloat2[0] * this.center.x + arrayOfFloat2[1] * this.center.y));
    arrayOfFloat3[2] = (-(arrayOfFloat3[0] * this.center.x + arrayOfFloat3[1] * this.center.y));
    if (this.circle)
    {
      arrayOfFloat2[0] = 0.0F;
      arrayOfFloat2[1] = 0.0F;
      arrayOfFloat2[2] = -0.15F;
      arrayOfFloat3[0] = 0.0F;
      arrayOfFloat3[1] = 0.0F;
      arrayOfFloat3[2] = -0.15F;
    }
    if (this.blurArea != null)
    {
      this.blurArea.addParam(new UniformParam.FloatsParam("line1", arrayOfFloat2));
      this.blurArea.addParam(new UniformParam.FloatsParam("line2", arrayOfFloat3));
    }
    paramFloat = this.center.x;
    f1 = this.center.y;
    if (this.blurArea != null) {
      this.blurArea.addParam(new UniformParam.FloatsParam("center", new float[] { paramFloat, f1 }));
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
    int i = 0;
    if (f >= 1.0F)
    {
      i = (int)Math.floor(Math.sqrt(-2.0D * Math.pow(f, 2.0D) * Math.log(0.0039063F * Math.sqrt(6.283185307179586D * Math.pow(f, 2.0D)))));
      i += i % 2;
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
      float f = Math.round(0.008333334F * paramInt2);
      paramInt1 = 0;
      if (f >= 1.0F)
      {
        paramInt1 = (int)Math.floor(Math.sqrt(-2.0D * Math.pow(f, 2.0D) * Math.log(0.0039063F * Math.sqrt(6.283185307179586D * Math.pow(f, 2.0D)))));
        paramInt1 += paramInt1 % 2;
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
    if (paramMap.containsKey("debug"))
    {
      this.debug = ((Float)paramMap.get("debug")).floatValue();
      if (this.blurArea != null) {
        this.blurArea.addParam(new UniformParam.FloatParam("debug", this.debug));
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
      if (this.blurArea != null) {
        this.blurArea.addParam(new UniformParam.FloatParam("inner", this.radius));
      }
    }
    if (paramMap.containsKey("angle")) {
      this.angle = ((Float)paramMap.get("angle")).floatValue();
    }
    setAngle(this.angle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.filter.ttpic.BlurHighRealFilter
 * JD-Core Version:    0.7.0.1
 */