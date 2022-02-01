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
    int j = paramInt + 1;
    Object localObject = new float[j];
    int i = 0;
    float f = 0.0F;
    while (i < j)
    {
      double d1 = paramFloat;
      localObject[i] = ((float)(1.0D / Math.sqrt(Math.pow(d1, 2.0D) * 6.283185307179586D) * Math.exp(-Math.pow(i, 2.0D) / (Math.pow(d1, 2.0D) * 2.0D))));
      if (i == 0)
      {
        f += localObject[i];
      }
      else
      {
        d1 = f;
        double d2 = localObject[i];
        Double.isNaN(d2);
        Double.isNaN(d1);
        f = (float)(d1 + d2 * 2.0D);
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      localObject[i] /= f;
      i += 1;
    }
    i = Math.min(paramInt / 2 + paramInt % 2, 100);
    float[] arrayOfFloat = new float[i];
    paramInt = 0;
    while (paramInt < i)
    {
      int k = paramInt * 2;
      j = k + 1;
      paramFloat = localObject[j];
      k += 2;
      f = localObject[k];
      arrayOfFloat[paramInt] = ((paramFloat * j + f * k) / (paramFloat + f));
      paramInt += 1;
    }
    String str = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\nlowp vec4 sum = texture2D(inputImageTexture, textureCoordinate.xy);\n", new Object[] { Integer.valueOf(i * 2 + 1) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("if (sum.a > 0.0001) {\n");
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("    float ratio = 1.0;\n");
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(String.format(Locale.ENGLISH, "    ratio = ratio * %f;\n", new Object[] { Float.valueOf(localObject[0]) }));
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("    highp vec2 singleStepOffsetX = vec2(horStep, 0.0);\n");
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("    highp vec2 singleStepOffsetY = vec2(0.0, verStep);\n");
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("    highp vec2 singleStepOffsetSlash1 = singleStepOffsetX + singleStepOffsetY;\n");
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("    highp vec2 singleStepOffsetSlash2 = singleStepOffsetX - singleStepOffsetY;\n");
    str = localStringBuilder.toString();
    paramInt = 0;
    while (paramInt < i)
    {
      j = paramInt * 2;
      paramFloat = localObject[(j + 1)] + localObject[(j + 2)];
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffsetX * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat[paramInt]), Float.valueOf(paramFloat) }));
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffsetX * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat[paramInt]), Float.valueOf(paramFloat) }));
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffsetY * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat[paramInt]), Float.valueOf(paramFloat) }));
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffsetY * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat[paramInt]), Float.valueOf(paramFloat) }));
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffsetSlash1 * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat[paramInt]), Float.valueOf(paramFloat) }));
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffsetSlash1 * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat[paramInt]), Float.valueOf(paramFloat) }));
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffsetSlash2 * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat[paramInt]), Float.valueOf(paramFloat) }));
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.format(Locale.ENGLISH, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffsetSlash2 * %f).a * %f * 0.25;\n", new Object[] { Float.valueOf(arrayOfFloat[paramInt]), Float.valueOf(paramFloat) }));
      str = localStringBuilder.toString();
      paramInt += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("ratio = ratio * 2.0 - 1.0;\n");
    str = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("sum = sum * ratio;\n");
    str = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("}\n");
    str = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("gl_FragColor = sum;\n");
    str = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("}\n");
    return ((StringBuilder)localObject).toString();
  }
  
  public static String gaussianFragmentShaderForOptimizedBlurOfRadius(int paramInt, float paramFloat, boolean paramBoolean)
  {
    if (paramInt < 1) {
      return kGPUImagePassthroughFragmentShaderString;
    }
    int j = paramInt + 1;
    float[] arrayOfFloat = new float[j];
    int i = 0;
    float f1 = 0.0F;
    while (i < j)
    {
      double d1 = paramFloat;
      arrayOfFloat[i] = ((float)(1.0D / Math.sqrt(Math.pow(d1, 2.0D) * 6.283185307179586D) * Math.exp(-Math.pow(i, 2.0D) / (Math.pow(d1, 2.0D) * 2.0D))));
      if (i == 0)
      {
        f1 += arrayOfFloat[i];
      }
      else
      {
        d1 = f1;
        double d2 = arrayOfFloat[i];
        Double.isNaN(d2);
        Double.isNaN(d1);
        f1 = (float)(d1 + d2 * 2.0D);
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      arrayOfFloat[i] /= f1;
      i += 1;
    }
    j = paramInt / 2 + paramInt % 2;
    i = Math.min(j, 7);
    Object localObject2 = new float[i];
    paramInt = 0;
    int k;
    while (paramInt < i)
    {
      int m = paramInt * 2;
      k = m + 1;
      paramFloat = arrayOfFloat[k];
      m += 2;
      f1 = arrayOfFloat[m];
      localObject2[paramInt] = ((paramFloat * k + f1 * m) / (paramFloat + f1));
      paramInt += 1;
    }
    Object localObject1 = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\nlowp vec4 sum = vec4(0.0);\n", new Object[] { Integer.valueOf(i * 2 + 1) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy) * %f;\n", new Object[] { Float.valueOf(arrayOfFloat[0]) }));
    localObject1 = localStringBuilder.toString();
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("highp vec2 singleStepOffset = vec2(horStep, 0.0);\n");
      localObject1 = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("highp vec2 singleStepOffset = vec2(0.0, verStep);\n");
      localObject1 = localStringBuilder.toString();
    }
    paramInt = 0;
    while (paramInt < i)
    {
      k = paramInt * 2;
      paramFloat = arrayOfFloat[(k + 1)] + arrayOfFloat[(k + 2)];
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(localObject2[paramInt]), Float.valueOf(paramFloat) }));
      localObject1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(localObject2[paramInt]), Float.valueOf(paramFloat) }));
      localObject1 = localStringBuilder.toString();
      paramInt += 1;
    }
    localObject2 = localObject1;
    if (j > i)
    {
      paramInt = i;
      for (;;)
      {
        localObject2 = localObject1;
        if (paramInt >= j) {
          break;
        }
        k = paramInt * 2;
        i = k + 1;
        f1 = arrayOfFloat[i];
        k += 2;
        float f2 = arrayOfFloat[k];
        paramFloat = f1 + f2;
        f1 = (f1 * i + f2 * k) / paramFloat;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) }));
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) }));
        localObject1 = ((StringBuilder)localObject2).toString();
        paramInt += 1;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("gl_FragColor = sum;\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("}\n");
    return ((StringBuilder)localObject2).toString();
  }
  
  public static String gaussianFragmentShaderForOptimizedBlurOfRadiusOpt1(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt < 1) {
      return kGPUImagePassthroughFragmentShaderString;
    }
    int j = paramInt + 1;
    float[] arrayOfFloat = new float[j];
    int i = 0;
    float f1 = 0.0F;
    while (i < j)
    {
      double d1 = paramFloat;
      arrayOfFloat[i] = ((float)(1.0D / Math.sqrt(Math.pow(d1, 2.0D) * 6.283185307179586D) * Math.exp(-Math.pow(i, 2.0D) / (Math.pow(d1, 2.0D) * 2.0D))));
      if (i == 0)
      {
        f1 += arrayOfFloat[i];
      }
      else
      {
        d1 = f1;
        double d2 = arrayOfFloat[i];
        Double.isNaN(d2);
        Double.isNaN(d1);
        f1 = (float)(d1 + d2 * 2.0D);
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      arrayOfFloat[i] /= f1;
      i += 1;
    }
    j = paramInt / 2 + paramInt % 2;
    i = Math.min(j, 7);
    Object localObject2 = new float[i];
    paramInt = 0;
    int k;
    while (paramInt < i)
    {
      int m = paramInt * 2;
      k = m + 1;
      paramFloat = arrayOfFloat[k];
      m += 2;
      f1 = arrayOfFloat[m];
      localObject2[paramInt] = ((paramFloat * k + f1 * m) / (paramFloat + f1));
      paramInt += 1;
    }
    Object localObject1 = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\n vec4 color = texture2D(inputImageTexture,textureCoordinate);\nlowp float sum = 0.0;\n", new Object[] { Integer.valueOf(i * 2 + 1) });
    StringBuilder localStringBuilder;
    if (paramBoolean1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy).g * %f;\n", new Object[] { Float.valueOf(arrayOfFloat[0]) }));
      localObject1 = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy).a * %f;\n", new Object[] { Float.valueOf(arrayOfFloat[0]) }));
      localObject1 = localStringBuilder.toString();
    }
    if (paramBoolean2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("highp vec2 singleStepOffset = vec2(horStep, 0.0);\n");
      localObject1 = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("highp vec2 singleStepOffset = vec2(0.0, verStep);\n");
      localObject1 = localStringBuilder.toString();
    }
    paramInt = 0;
    while (paramInt < i)
    {
      k = paramInt * 2;
      paramFloat = arrayOfFloat[(k + 1)] + arrayOfFloat[(k + 2)];
      if (paramBoolean1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).g * %f;\n", new Object[] { Float.valueOf(localObject2[paramInt]), Float.valueOf(paramFloat) }));
        localObject1 = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).g * %f;\n", new Object[] { Float.valueOf(localObject2[paramInt]), Float.valueOf(paramFloat) }));
        localObject1 = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).a * %f;\n", new Object[] { Float.valueOf(localObject2[paramInt]), Float.valueOf(paramFloat) }));
        localObject1 = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).a * %f;\n", new Object[] { Float.valueOf(localObject2[paramInt]), Float.valueOf(paramFloat) }));
        localObject1 = localStringBuilder.toString();
      }
      paramInt += 1;
    }
    localObject2 = localObject1;
    if (j > i)
    {
      paramInt = i;
      for (;;)
      {
        localObject2 = localObject1;
        if (paramInt >= j) {
          break;
        }
        k = paramInt * 2;
        i = k + 1;
        f1 = arrayOfFloat[i];
        k += 2;
        float f2 = arrayOfFloat[k];
        paramFloat = f1 + f2;
        f1 = (f1 * i + f2 * k) / paramFloat;
        if (paramBoolean1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).g * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) }));
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).g * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) }));
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).a * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) }));
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).a * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) }));
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        paramInt += 1;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("color.a = sum;\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("gl_FragColor = color;\n");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("}\n");
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.ttpic.HFGPUShaderFactory
 * JD-Core Version:    0.7.0.1
 */