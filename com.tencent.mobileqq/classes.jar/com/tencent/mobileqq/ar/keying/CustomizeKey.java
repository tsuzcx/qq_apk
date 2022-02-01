package com.tencent.mobileqq.ar.keying;

import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CustomizeKey
  extends KeyingBase
{
  public int a;
  
  public CustomizeKey(int paramInt, String paramString)
  {
    super(paramInt);
    if (!TextUtils.isEmpty(paramString))
    {
      this.f = paramString;
      return;
    }
    throw new IllegalArgumentException("mFragmentShader can not be empty!");
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject3 = "CustomizeKey";
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("    float bgR = max(min(u_screenColor.r, 1.0), 0.0);\n    float bgG = max(min(u_screenColor.g, 1.0), 0.0);\n    float bgB = max(min(u_screenColor.b, 1.0), 0.0);\n    float R = max(min(gl_FragColor.r, 1.0), 0.0);\n    float G = max(min(gl_FragColor.g, 1.0), 0.0);\n    float B = max(min(gl_FragColor.b, 1.0), 0.0);\n    float x = position.x;\n    float y = position.y;\n    float alpha = 1.0;\n");
    label1296:
    label1300:
    label1304:
    label1313:
    label1320:
    label1329:
    for (;;)
    {
      int j;
      try
      {
        ArrayList localArrayList = new ArrayList();
        boolean bool = TextUtils.isEmpty(paramString1);
        Object localObject5 = "RGB";
        Object localObject7 = ";";
        if (bool) {
          break label1320;
        }
        Object localObject6 = paramString1.split(";");
        if (localObject6 == null) {
          break label1320;
        }
        Object localObject8 = new String[15];
        localObject8[0] = "R";
        localObject8[1] = "G";
        localObject8[2] = "B";
        localObject8[3] = "R2";
        localObject8[4] = "G2";
        localObject8[5] = "B2";
        localObject8[6] = "RG";
        localObject8[7] = "RB";
        localObject8[8] = "GB";
        localObject8[9] = "RGB";
        localObject8[10] = "R_2";
        localObject8[11] = "G_2";
        localObject8[12] = "B_2";
        localObject8[13] = "dCbCr";
        localObject8[14] = "b";
        try
        {
          localObject9 = new HashMap(localObject8.length);
          i = 0;
          localObject3 = localObject8;
          if (i < localObject3.length)
          {
            ((HashMap)localObject9).put(localObject3[i], Integer.valueOf(i));
            i += 1;
            continue;
          }
          i = localObject6.length;
          j = 0;
          f1 = 0.0F;
          f2 = 1.0F;
          localObject3 = localObject6;
          if (j >= i) {
            break label1313;
          }
          localObject6 = localObject3[j];
          if (TextUtils.isEmpty((CharSequence)localObject6)) {
            break label1296;
          }
          localObject8 = ((String)localObject6).split(":");
          if (localObject8 == null) {
            break label1296;
          }
          f3 = f2;
          if (localObject8.length != 2) {
            break label1300;
          }
          localObject6 = localObject8[0];
          localObject8 = Float.valueOf(localObject8[1]);
          if (((HashMap)localObject9).get(localObject6) != null)
          {
            localArrayList.add(new Pair(localObject6, localObject8));
            f3 = f2;
          }
          else
          {
            if ("u_clipBlack".equals(localObject6))
            {
              f1 = ((Float)localObject8).floatValue();
              break label1304;
            }
            f3 = f2;
            if ("u_clipWhite".equals(localObject6)) {
              f3 = ((Float)localObject8).floatValue();
            }
          }
        }
        catch (Exception localException2)
        {
          Object localObject9;
          int i;
          paramString1 = localException1;
          localObject5 = "CustomizeKey";
          localObject2 = localException2;
          localObject4 = localObject5;
          break label1136;
        }
        localObject8 = new StringBuilder();
        localObject9 = new StringBuilder();
        ((StringBuilder)localObject9).append("alpha = ");
        localObject6 = localArrayList.iterator();
        i = 1;
        localObject3 = localObject7;
        if (((Iterator)localObject6).hasNext())
        {
          localObject7 = (Pair)((Iterator)localObject6).next();
          if (i != 0)
          {
            ((StringBuilder)localObject9).append(((Pair)localObject7).second);
            i = 0;
          }
          else if (((Float)((Pair)localObject7).second).floatValue() >= 0.0F)
          {
            ((StringBuilder)localObject9).append("+");
            ((StringBuilder)localObject9).append(((Pair)localObject7).second);
          }
          else
          {
            ((StringBuilder)localObject9).append(((Pair)localObject7).second);
          }
          if (!"b".equals(((Pair)localObject7).first))
          {
            ((StringBuilder)localObject9).append("*");
            ((StringBuilder)localObject9).append((String)((Pair)localObject7).first);
          }
          if ("R2".equals(((Pair)localObject7).first))
          {
            ((StringBuilder)localObject8).append("float R2=R*R;\n");
            break label1329;
          }
          if ("G2".equals(((Pair)localObject7).first))
          {
            ((StringBuilder)localObject8).append("float G2=G*G;\n");
            break label1329;
          }
          if ("B2".equals(((Pair)localObject7).first))
          {
            ((StringBuilder)localObject8).append("float B2=B*B;\n");
            break label1329;
          }
          if ("RG".equals(((Pair)localObject7).first))
          {
            ((StringBuilder)localObject8).append("float RG=R*G;\n");
            break label1329;
          }
          if ("RB".equals(((Pair)localObject7).first))
          {
            ((StringBuilder)localObject8).append("float RB=R*B;\n");
            break label1329;
          }
          if ("GB".equals(((Pair)localObject7).first))
          {
            ((StringBuilder)localObject8).append("float GB=G*B;\n");
            break label1329;
          }
          if (((String)localObject5).equals(((Pair)localObject7).first))
          {
            ((StringBuilder)localObject8).append("float RGB=R*G*B;\n");
            break label1329;
          }
          if ("R_2".equals(((Pair)localObject7).first))
          {
            ((StringBuilder)localObject8).append("float R_2=sqrt(R);\n");
            break label1329;
          }
          if ("G_2".equals(((Pair)localObject7).first))
          {
            ((StringBuilder)localObject8).append("float G_2=sqrt(G);\n");
            break label1329;
          }
          if ("B_2".equals(((Pair)localObject7).first))
          {
            ((StringBuilder)localObject8).append("float B_2=sqrt(B);\n");
            break label1329;
          }
          if (!"dCbCr".equals(((Pair)localObject7).first)) {
            break label1329;
          }
          ((StringBuilder)localObject8).append("float dCbCr=distance(vec2(-0.168736*R-0.331264*G+0.5*B, 0.5*R-0.418688*B-0.081312*B), vec2(-0.168736*bgR-0.331264*bgG+0.5*bgB, 0.5*bgR-0.418688*bgB-0.081312*bgB));\n");
          break label1329;
        }
        ((StringBuilder)localObject9).append(";\n");
        ((StringBuilder)localObject8).append((CharSequence)localObject9);
        if (f1 > 0.0D)
        {
          ((StringBuilder)localObject8).append("u_clipBlack = ");
          ((StringBuilder)localObject8).append(f1);
          ((StringBuilder)localObject8).append(";\n");
        }
        if (f2 < 1.0D)
        {
          ((StringBuilder)localObject8).append("u_clipWhite = ");
          ((StringBuilder)localObject8).append(f2);
          ((StringBuilder)localObject8).append(";\n");
        }
        bool = QLog.isColorLevel();
        if (bool)
        {
          try
          {
            localObject5 = new StringBuilder();
            localObject6 = localArrayList.iterator();
            bool = ((Iterator)localObject6).hasNext();
            if (bool)
            {
              localObject7 = (Pair)((Iterator)localObject6).next();
              ((StringBuilder)localObject5).append((String)((Pair)localObject7).first);
              ((StringBuilder)localObject5).append(":");
              ((StringBuilder)localObject5).append(((Pair)localObject7).second);
              ((StringBuilder)localObject5).append((String)localObject3);
              continue;
            }
            ((StringBuilder)localObject5).append("\n          old string = \n");
            ((StringBuilder)localObject5).append(paramString1);
            ((StringBuilder)localObject5).append("\n          mainKeyingMiddle = \n");
            ((StringBuilder)localObject5).append(((StringBuilder)localObject8).toString());
            paramString1 = new StringBuilder();
            paramString1.append("buildMachineLearningFragmentShader params: \n");
            paramString1.append(((StringBuilder)localObject5).toString());
            localObject5 = paramString1.toString();
            paramString1 = "CustomizeKey";
            localObject3 = paramString1;
            localObject5 = localObject1;
          }
          catch (Exception paramString1)
          {
            try
            {
              QLog.i(paramString1, 2, (String)localObject5);
            }
            catch (Exception paramString1)
            {
              Object localObject2;
              Object localObject4;
              continue;
            }
            paramString1 = paramString1;
            localObject3 = "CustomizeKey";
          }
          localObject1 = paramString1;
          paramString1 = (String)localObject5;
        }
        else
        {
          localObject3 = "CustomizeKey";
          paramString1 = (String)localObject1;
          try
          {
            paramString1.append((CharSequence)localObject8);
          }
          catch (Exception localException1) {}
        }
        QLog.e(localObject4, 1, ((Exception)localObject2).getMessage());
      }
      catch (Exception localException3)
      {
        paramString1 = (String)localObject2;
        localObject2 = localException3;
      }
      label1136:
      paramString1.append("    alpha = max(min(alpha, 1.0), 0.0);\n    if(alpha > 0.01 && alpha < 1.0){\n        R = R - (1.0-alpha)*bgR;\n        G = G - (1.0-alpha)*bgG;\n        B = B - (1.0-alpha)*bgB;\n    }\n    alpha = smoothclip(u_clipBlack, u_clipWhite, alpha);\n    if(alpha <= 0.01){\n        R = G = B = 0.0;\n    }\n    gl_FragColor.a = alpha;\n    gl_FragColor.r = max(min(R, 1.0), 0.0);\n    gl_FragColor.g = max(min(G, 1.0), 0.0);\n    gl_FragColor.b = max(min(B, 1.0), 0.0);\n");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES samplerOES;\nuniform sampler2D sampler2d1;\nuniform sampler2D sampler2d2;\nuniform sampler2D sampler2d3;\nuniform vec4 u_screenColor;\nvarying vec2 vTextureCoord;\n");
      ((StringBuilder)localObject2).append("uniform float u_currentTime;\nfloat u_clipBlack = 0.0;\nfloat u_clipWhite = 1.0;\nfloat smoothclip(float low, float high, float x){\n    if (x <= low){\n        return 0.0;\n    }\n    if(x >= high){\n        return 1.0;\n    }\n    return (x-low)/(high-low);\n}\n");
      if (!TextUtils.isEmpty(paramString2)) {
        ((StringBuilder)localObject2).append(paramString2);
      } else {
        ((StringBuilder)localObject2).append("//用户自己定义变量及方法相关片段\n");
      }
      ((StringBuilder)localObject2).append("void main() {\n    vec2 position = vTextureCoord;\n");
      if (!TextUtils.isEmpty(paramString3)) {
        ((StringBuilder)localObject2).append(paramString3);
      } else {
        ((StringBuilder)localObject2).append("    //用户定义片段，用于在获取颜色值前处理, 如纹理坐标改变\n");
      }
      ((StringBuilder)localObject2).append("    gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);\n    #if defined(TEXTURE_TYPE_OES)\n        gl_FragColor = texture2D(samplerOES, position);\n        gl_FragColor.r = max(0.0, min(gl_FragColor.r, 1.0));\n        gl_FragColor.g = max(0.0, min(gl_FragColor.g, 1.0));\n        gl_FragColor.b = max(0.0, min(gl_FragColor.b, 1.0));\n    #endif\n    #if defined(TEXTURE_TYPE_SAMPLER2D)\n        gl_FragColor = texture2D(sampler2d1, position);\n    #endif\n    #if defined(TEXTURE_TYPE_Y_U_V)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        yuv.y = texture2D(sampler2d2, position).r-0.5;\n        yuv.z = texture2D(sampler2d3, position).r-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;\n        gl_FragColor.a = 1.0;\n    #endif\n    #if defined(TEXTURE_TYPE_Y_UV)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        vec2 uv = texture2D(sampler2d2, position).ra;\n        yuv.y = uv.x-0.5;\n        yuv.z = uv.y-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;//yuv->rgb\n        gl_FragColor.a = 1.0;\n    #endif\n");
      ((StringBuilder)localObject2).append(paramString1.toString());
      if (!TextUtils.isEmpty(paramString4)) {
        ((StringBuilder)localObject2).append(paramString4);
      } else {
        ((StringBuilder)localObject2).append(KeyingUtil.c);
      }
      ((StringBuilder)localObject2).append(KeyingUtil.d);
      return ((StringBuilder)localObject2).toString();
      float f3 = f2;
      float f2 = f3;
      j += 1;
      continue;
      continue;
      float f1 = 0.0F;
      f2 = 1.0F;
    }
  }
  
  protected void a()
  {
    this.a = GLES20.glGetUniformLocation(this.d, "u_currentTime");
  }
  
  protected void a(KeyingParams paramKeyingParams)
  {
    if (paramKeyingParams == null) {
      return;
    }
    int i = this.a;
    if (i != -1) {
      GLES20.glUniform1f(i, paramKeyingParams.j);
    }
  }
  
  protected String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(KeyingUtil.a(this.x));
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.CustomizeKey
 * JD-Core Version:    0.7.0.1
 */