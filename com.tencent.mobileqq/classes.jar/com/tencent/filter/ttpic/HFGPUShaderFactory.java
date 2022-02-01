package com.tencent.filter.ttpic;

import java.util.Locale;

public class HFGPUShaderFactory
{
  private static String kGPUImagePassthroughFragmentShaderString = "precision highp float;\nvarying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }\n";
  private static String kGPUImageVertexShaderString = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 textureMat; \nuniform mat4 tMat;\nvoid main(void)\n{\ngl_Position = Projection * Modelview *position;\nvec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\ntextureCoordinate = tmp.xy;\n}\n";
  
  public static String gaussianFragmentShaderForBorderOfRadius(int paramInt, float paramFloat)
  {
    if (paramInt < 1) {
      return kGPUImagePassthroughFragmentShaderString;
    }
    float[] arrayOfFloat1 = new float[paramInt + 1];
    float f = 0.0F;
    int i = 0;
    if (i < paramInt + 1)
    {
      arrayOfFloat1[i] = ((float)(1.0D / Math.sqrt(6.283185307179586D * Math.pow(paramFloat, 2.0D)) * Math.exp(-Math.pow(i, 2.0D) / (2.0D * Math.pow(paramFloat, 2.0D)))));
      if (i == 0) {}
      for (f = arrayOfFloat1[i] + f;; f = (float)(f + 2.0D * arrayOfFloat1[i]))
      {
        i += 1;
        break;
      }
    }
    i = 0;
    while (i < paramInt + 1)
    {
      arrayOfFloat1[i] /= f;
      i += 1;
    }
    i = Math.min(paramInt / 2 + paramInt % 2, 100);
    float[] arrayOfFloat2 = new float[i];
    paramInt = 0;
    while (paramInt < i)
    {
      paramFloat = arrayOfFloat1[(paramInt * 2 + 1)];
      f = arrayOfFloat1[(paramInt * 2 + 2)];
      arrayOfFloat2[paramInt] = ((paramFloat * (paramInt * 2 + 1) + f * (paramInt * 2 + 2)) / (paramFloat + f));
      paramInt += 1;
    }
    String str = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\nlowp vec4 sum = texture2D(inputImageTexture, textureCoordinate.xy);\n", new Object[] { Integer.valueOf(i * 2 + 1) });
    str = str + "if (sum.a > 0.0001) {\n";
    str = str + "    float ratio = 1.0;\n";
    str = str + String.format(Locale.ENGLISH, "    ratio = ratio * %f;\n", new Object[] { Float.valueOf(arrayOfFloat1[0]) });
    str = str + "    highp vec2 singleStepOffsetX = vec2(horStep, 0.0);\n";
    str = str + "    highp vec2 singleStepOffsetY = vec2(0.0, verStep);\n";
    str = str + "    highp vec2 singleStepOffsetSlash1 = singleStepOffsetX + singleStepOffsetY;\n";
    str = str + "    highp vec2 singleStepOffsetSlash2 = singleStepOffsetX - singleStepOffsetY;\n";
    paramInt = 0;
    while (paramInt < i)
    {
      paramFloat = arrayOfFloat1[(paramInt * 2 + 1)] + arrayOfFloat1[(paramInt * 2 + 2)];
      str = str + String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffsetX * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat2[paramInt]), Float.valueOf(paramFloat) });
      str = str + String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffsetX * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat2[paramInt]), Float.valueOf(paramFloat) });
      str = str + String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffsetY * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat2[paramInt]), Float.valueOf(paramFloat) });
      str = str + String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffsetY * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat2[paramInt]), Float.valueOf(paramFloat) });
      str = str + String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffsetSlash1 * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat2[paramInt]), Float.valueOf(paramFloat) });
      str = str + String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffsetSlash1 * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat2[paramInt]), Float.valueOf(paramFloat) });
      str = str + String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffsetSlash2 * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat2[paramInt]), Float.valueOf(paramFloat) });
      str = str + String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffsetSlash2 * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat2[paramInt]), Float.valueOf(paramFloat) });
      paramInt += 1;
    }
    str = str + "ratio = ratio * 2.0 - 1.0;\n";
    str = str + "sum = sum * ratio;\n";
    str = str + "}\n";
    str = str + "gl_FragColor = sum;\n";
    return str + "}\n";
  }
  
  public static String gaussianFragmentShaderForOptimizedBlurOfRadius(int paramInt, float paramFloat, boolean paramBoolean)
  {
    if (paramInt < 1) {
      return kGPUImagePassthroughFragmentShaderString;
    }
    float[] arrayOfFloat = new float[paramInt + 1];
    float f1 = 0.0F;
    int i = 0;
    if (i < paramInt + 1)
    {
      arrayOfFloat[i] = ((float)(1.0D / Math.sqrt(6.283185307179586D * Math.pow(paramFloat, 2.0D)) * Math.exp(-Math.pow(i, 2.0D) / (2.0D * Math.pow(paramFloat, 2.0D)))));
      if (i == 0) {}
      for (f1 = arrayOfFloat[i] + f1;; f1 = (float)(f1 + 2.0D * arrayOfFloat[i]))
      {
        i += 1;
        break;
      }
    }
    i = 0;
    while (i < paramInt + 1)
    {
      arrayOfFloat[i] /= f1;
      i += 1;
    }
    int j = Math.min(paramInt / 2 + paramInt % 2, 7);
    Object localObject = new float[j];
    i = 0;
    while (i < j)
    {
      paramFloat = arrayOfFloat[(i * 2 + 1)];
      f1 = arrayOfFloat[(i * 2 + 2)];
      localObject[i] = ((paramFloat * (i * 2 + 1) + f1 * (i * 2 + 2)) / (paramFloat + f1));
      i += 1;
    }
    i = paramInt / 2 + paramInt % 2;
    String str = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\nlowp vec4 sum = vec4(0.0);\n", new Object[] { Integer.valueOf(j * 2 + 1) });
    str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy) * %f;\n", new Object[] { Float.valueOf(arrayOfFloat[0]) });
    if (paramBoolean) {}
    for (str = str + "highp vec2 singleStepOffset = vec2(horStep, 0.0);\n";; str = str + "highp vec2 singleStepOffset = vec2(0.0, verStep);\n")
    {
      paramInt = 0;
      while (paramInt < j)
      {
        paramFloat = arrayOfFloat[(paramInt * 2 + 1)] + arrayOfFloat[(paramInt * 2 + 2)];
        str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(localObject[paramInt]), Float.valueOf(paramFloat) });
        str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(localObject[paramInt]), Float.valueOf(paramFloat) });
        paramInt += 1;
      }
    }
    localObject = str;
    if (i > j)
    {
      paramInt = j;
      for (;;)
      {
        localObject = str;
        if (paramInt >= i) {
          break;
        }
        f1 = arrayOfFloat[(paramInt * 2 + 1)];
        float f2 = arrayOfFloat[(paramInt * 2 + 2)];
        paramFloat = f1 + f2;
        f1 = (f1 * (paramInt * 2 + 1) + f2 * (paramInt * 2 + 2)) / paramFloat;
        str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) });
        str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) });
        paramInt += 1;
      }
    }
    str = (String)localObject + "gl_FragColor = sum;\n";
    return str + "}\n";
  }
  
  public static String gaussianFragmentShaderForOptimizedBlurOfRadiusOpt1(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt < 1) {
      return kGPUImagePassthroughFragmentShaderString;
    }
    float[] arrayOfFloat = new float[paramInt + 1];
    float f1 = 0.0F;
    int i = 0;
    if (i < paramInt + 1)
    {
      arrayOfFloat[i] = ((float)(1.0D / Math.sqrt(6.283185307179586D * Math.pow(paramFloat, 2.0D)) * Math.exp(-Math.pow(i, 2.0D) / (2.0D * Math.pow(paramFloat, 2.0D)))));
      if (i == 0) {}
      for (f1 = arrayOfFloat[i] + f1;; f1 = (float)(f1 + 2.0D * arrayOfFloat[i]))
      {
        i += 1;
        break;
      }
    }
    i = 0;
    while (i < paramInt + 1)
    {
      arrayOfFloat[i] /= f1;
      i += 1;
    }
    int j = Math.min(paramInt / 2 + paramInt % 2, 7);
    Object localObject = new float[j];
    i = 0;
    while (i < j)
    {
      paramFloat = arrayOfFloat[(i * 2 + 1)];
      f1 = arrayOfFloat[(i * 2 + 2)];
      localObject[i] = ((paramFloat * (i * 2 + 1) + f1 * (i * 2 + 2)) / (paramFloat + f1));
      i += 1;
    }
    i = paramInt / 2 + paramInt % 2;
    String str = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\n vec4 color = texture2D(inputImageTexture,textureCoordinate);\nlowp float sum = 0.0;\n", new Object[] { Integer.valueOf(j * 2 + 1) });
    if (paramBoolean1)
    {
      str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy).g * %f;\n", new Object[] { Float.valueOf(arrayOfFloat[0]) });
      if (!paramBoolean2) {
        break label534;
      }
      str = str + "highp vec2 singleStepOffset = vec2(horStep, 0.0);\n";
      label354:
      paramInt = 0;
      label356:
      if (paramInt >= j) {
        break label660;
      }
      paramFloat = arrayOfFloat[(paramInt * 2 + 1)] + arrayOfFloat[(paramInt * 2 + 2)];
      if (!paramBoolean1) {
        break label559;
      }
      str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).g * %f;\n", new Object[] { Float.valueOf(localObject[paramInt]), Float.valueOf(paramFloat) });
    }
    for (str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).g * %f;\n", new Object[] { Float.valueOf(localObject[paramInt]), Float.valueOf(paramFloat) });; str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).a * %f;\n", new Object[] { Float.valueOf(localObject[paramInt]), Float.valueOf(paramFloat) }))
    {
      paramInt += 1;
      break label356;
      str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy).a * %f;\n", new Object[] { Float.valueOf(arrayOfFloat[0]) });
      break;
      label534:
      str = str + "highp vec2 singleStepOffset = vec2(0.0, verStep);\n";
      break label354;
      label559:
      str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).a * %f;\n", new Object[] { Float.valueOf(localObject[paramInt]), Float.valueOf(paramFloat) });
    }
    label660:
    localObject = str;
    if (i > j)
    {
      paramInt = j;
      localObject = str;
      if (paramInt < i)
      {
        f1 = arrayOfFloat[(paramInt * 2 + 1)];
        float f2 = arrayOfFloat[(paramInt * 2 + 2)];
        paramFloat = f1 + f2;
        f1 = (f1 * (paramInt * 2 + 1) + f2 * (paramInt * 2 + 2)) / paramFloat;
        if (paramBoolean1) {
          str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).g * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) });
        }
        for (str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).g * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) });; str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).a * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) }))
        {
          paramInt += 1;
          break;
          str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).a * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) });
        }
      }
    }
    str = (String)localObject + "color.a = sum;\n";
    str = str + "gl_FragColor = color;\n";
    return str + "}\n";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.filter.ttpic.HFGPUShaderFactory
 * JD-Core Version:    0.7.0.1
 */