package com.tencent.mobileqq.ar;

import android.opengl.GLES20;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.ARVideoLayout;
import com.tencent.mobileqq.ar.keying.CustomizeKey;
import com.tencent.mobileqq.ar.keying.KeyingManager;
import com.tencent.mobileqq.ar.keying.KeyingParams;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class ARVideoUtil
{
  public static final float[] a;
  public static final short[] a;
  public static final float[] b;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { -0.5F, 0.5F, 0.0F, 0.0F, 1.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.5F, -0.5F, 0.0F, 1.0F, 0.0F, 0.5F, 0.5F, 0.0F, 1.0F, 1.0F };
    b = new float[] { -0.5F, 0.5F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 1.0F, 0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.5F, 0.5F, 0.0F, 1.0F, 0.0F };
    jdField_a_of_type_ArrayOfShort = new short[] { 0, 1, 2, 2, 3, 0 };
  }
  
  public static int a(ARTarget paramARTarget)
  {
    if (paramARTarget != null)
    {
      if (paramARTarget.a == null) {
        return 0;
      }
      try
      {
        int i = ((ArVideoResourceInfo)paramARTarget.a.a.get(0)).jdField_b_of_type_Int;
        if (i >= 0) {
          return i;
        }
        return 0;
      }
      catch (Throwable paramARTarget)
      {
        if (QLog.isColorLevel()) {
          paramARTarget.printStackTrace();
        }
      }
    }
    return 0;
  }
  
  public static ArCloudConfigInfo.ARVideoLayout a(String paramString)
  {
    ArCloudConfigInfo.ARVideoLayout localARVideoLayout = new ArCloudConfigInfo.ARVideoLayout();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\|");
      if (paramString != null)
      {
        if (paramString.length >= 1) {
          localARVideoLayout.jdField_a_of_type_Int = Integer.valueOf(paramString[0]).intValue();
        }
        if (paramString.length >= 2) {
          localARVideoLayout.jdField_b_of_type_Int = Integer.valueOf(paramString[1]).intValue();
        }
      }
    }
    return localARVideoLayout;
  }
  
  public static ArCloudConfigInfo.ARVideoLayout a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = a(paramString);
    if (paramString.jdField_a_of_type_Int != 0)
    {
      if (paramString.jdField_b_of_type_Int == 0) {
        return paramString;
      }
      int i = paramString.jdField_a_of_type_Int;
      int j = paramString.jdField_b_of_type_Int;
      float f1 = paramInt2;
      float f2 = f1 * 1.0F / j;
      float f3 = paramInt1;
      if (f2 > 1.0F * f3 / i)
      {
        paramInt1 = j * 1 * paramInt1 / i;
        paramString.jdField_a_of_type_Float = 2.0F;
        paramString.jdField_b_of_type_Float = (paramInt1 * 2.0F / f1);
      }
      else
      {
        paramString.jdField_a_of_type_Float = (i * 1 * paramInt2 / j * 2.0F / f3);
        paramString.jdField_b_of_type_Float = 2.0F;
      }
      paramString.c = 0.0F;
      paramString.d = 0.0F;
      paramString.e = 0.0F;
    }
    return paramString;
  }
  
  public static ArCloudConfigInfo.ARVideoLayout a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArCloudConfigInfo.ARVideoLayout localARVideoLayout = a(paramString);
    if ((localARVideoLayout.jdField_a_of_type_Int == 0) || (localARVideoLayout.jdField_b_of_type_Int == 0))
    {
      localARVideoLayout.jdField_a_of_type_Int = paramInt1;
      localARVideoLayout.jdField_b_of_type_Int = paramInt2;
    }
    float f7 = paramInt1 * 1.0F / Math.max(1, paramInt2);
    float f8 = localARVideoLayout.jdField_a_of_type_Int;
    float f9 = localARVideoLayout.jdField_b_of_type_Int;
    float f10 = f8 * 1.0F / f9;
    boolean bool = TextUtils.isEmpty(paramString);
    paramInt1 = 0;
    if (!bool)
    {
      paramString = paramString.split("\\|");
      if (paramString != null)
      {
        if (paramString.length >= 3) {
          f1 = Float.valueOf(paramString[2]).floatValue();
        } else {
          f1 = 1.0F;
        }
        if (paramString.length >= 4) {
          f2 = Float.valueOf(paramString[3]).floatValue();
        } else {
          f2 = 1.0F;
        }
        if (paramString.length >= 5) {
          f3 = Float.valueOf(paramString[4]).floatValue();
        } else {
          f3 = 0.0F;
        }
        if (paramString.length >= 6) {
          f4 = -Float.valueOf(paramString[5]).floatValue();
        } else {
          f4 = 0.0F;
        }
        paramInt2 = 1;
        break label209;
      }
    }
    paramInt2 = 0;
    float f1 = 1.0F;
    float f2 = 1.0F;
    float f3 = 0.0F;
    float f4 = 0.0F;
    label209:
    if (paramInt2 != 0) {
      if ((f1 > 0.05F) && (f2 > 0.05F))
      {
        f5 = f1;
        f6 = f2;
        if (f10 <= f7) {
          break label318;
        }
      }
      else if (f1 <= 0.05F)
      {
        if (f2 > 0.05F)
        {
          f5 = f1;
          f6 = f2;
          break label318;
        }
        if (f10 > f7)
        {
          paramInt1 = 1;
          f5 = 1.0F;
          f6 = f2;
          break label318;
        }
        f6 = 1.0F;
        f5 = f1;
        break label318;
      }
    }
    paramInt1 = 1;
    float f6 = f2;
    float f5 = f1;
    label318:
    if (paramBoolean)
    {
      localARVideoLayout.jdField_a_of_type_Float = (f7 * 10.0F);
      localARVideoLayout.jdField_b_of_type_Float = 10.0F;
      localARVideoLayout.c = 0.0F;
      localARVideoLayout.d = 0.0F;
      localARVideoLayout.e = -5.0F;
      if (paramInt2 != 0)
      {
        if (paramInt1 != 0)
        {
          localARVideoLayout.jdField_a_of_type_Float = (f5 * localARVideoLayout.jdField_a_of_type_Float);
          localARVideoLayout.jdField_b_of_type_Float = (localARVideoLayout.jdField_a_of_type_Float * (f9 / f8));
          f1 = localARVideoLayout.jdField_a_of_type_Float;
        }
        else
        {
          localARVideoLayout.jdField_b_of_type_Float = (f6 * localARVideoLayout.jdField_b_of_type_Float);
          localARVideoLayout.jdField_a_of_type_Float = (localARVideoLayout.jdField_b_of_type_Float * (f8 / f9));
          f1 = localARVideoLayout.jdField_b_of_type_Float;
        }
        f1 /= 2.0F;
        localARVideoLayout.c = (f3 * f7 / f1);
        localARVideoLayout.d = (f4 / f1);
      }
    }
    else
    {
      localARVideoLayout.jdField_a_of_type_Float = 2.0F;
      localARVideoLayout.jdField_b_of_type_Float = 2.0F;
      localARVideoLayout.c = 0.0F;
      localARVideoLayout.d = 0.0F;
      localARVideoLayout.e = 0.0F;
      if (paramInt2 != 0)
      {
        if (paramInt1 != 0)
        {
          localARVideoLayout.jdField_a_of_type_Float = (f5 * localARVideoLayout.jdField_a_of_type_Float);
          localARVideoLayout.jdField_b_of_type_Float = (localARVideoLayout.jdField_a_of_type_Float * f7 * (f9 / f8));
          f1 = localARVideoLayout.jdField_a_of_type_Float;
        }
        else
        {
          localARVideoLayout.jdField_b_of_type_Float = (f6 * localARVideoLayout.jdField_b_of_type_Float);
          localARVideoLayout.jdField_a_of_type_Float = (localARVideoLayout.jdField_b_of_type_Float / f7 * (f8 / f9));
          f1 = localARVideoLayout.jdField_b_of_type_Float;
        }
        f1 /= 2.0F;
        localARVideoLayout.c = (f3 / f1);
        localARVideoLayout.d = (f4 / f1);
      }
    }
    paramString = new StringBuilder();
    paramString.append("parseVideoLayout layout = ");
    paramString.append(localARVideoLayout);
    QLog.i("ARVideoUtil", 1, paramString.toString());
    return localARVideoLayout;
  }
  
  public static Pair<Integer, KeyingParams> a(ARTarget paramARTarget)
  {
    int j = 0;
    KeyingParams localKeyingParams = KeyingManager.a(0);
    if (paramARTarget.a.d == 2) {}
    try
    {
      i = Integer.parseInt(((ArVideoResourceInfo)paramARTarget.a.a.get(0)).jdField_a_of_type_JavaLangString);
    }
    catch (Throwable paramARTarget)
    {
      int i;
      label43:
      label610:
      break label43;
    }
    i = 0;
    if (i < 0)
    {
      i = j;
    }
    else if ((i != 0) && (i != 1))
    {
      i = j;
    }
    else
    {
      break label610;
      if (paramARTarget.a.d != 3)
      {
        i = j;
        if (paramARTarget.a.d != 4) {}
      }
      else if ((paramARTarget.a.d == 4) && ("circle".equalsIgnoreCase(((ArVideoResourceInfo)paramARTarget.a.a.get(0)).jdField_a_of_type_JavaLangString)))
      {
        i = 1;
      }
      else
      {
        try
        {
          paramARTarget = ((ArVideoResourceInfo)paramARTarget.a.a.get(0)).jdField_a_of_type_JavaLangString.split("\\|");
          i = j;
          if (paramARTarget != null)
          {
            i = j;
            if (paramARTarget.length >= 5)
            {
              int k = Integer.parseInt(paramARTarget[0]);
              int m = Integer.parseInt(paramARTarget[1]);
              int n = Integer.parseInt(paramARTarget[2]);
              int i1 = Integer.parseInt(paramARTarget[3]);
              int i2 = Integer.parseInt(paramARTarget[4]);
              i = j;
              if (k <= 255)
              {
                i = j;
                if (m <= 255)
                {
                  i = j;
                  if (n <= 255)
                  {
                    i = j;
                    if (i1 <= 255)
                    {
                      i = j;
                      if (k >= 0)
                      {
                        i = j;
                        if (m >= 0)
                        {
                          i = j;
                          if (n >= 0)
                          {
                            i = j;
                            if (i1 >= 0)
                            {
                              i = j;
                              if (i2 >= 0) {
                                if (i2 > 100)
                                {
                                  i = j;
                                }
                                else
                                {
                                  localKeyingParams.a(k / 255.0F, m / 255.0F, n / 255.0F);
                                  localKeyingParams.jdField_a_of_type_Int = 1;
                                  localKeyingParams.d = (i1 / 255.0F);
                                  localKeyingParams.e = (i2 / 100.0F);
                                  if ((paramARTarget != null) && (paramARTarget.length >= 6) && (Integer.parseInt(paramARTarget[5]) == 1)) {
                                    localKeyingParams.jdField_a_of_type_Int = 2;
                                  }
                                  if ((paramARTarget != null) && (paramARTarget.length >= 8))
                                  {
                                    i = Integer.parseInt(paramARTarget[6]);
                                    paramARTarget = paramARTarget[7];
                                    if ((i == 2) && (!TextUtils.isEmpty(paramARTarget)))
                                    {
                                      paramARTarget = paramARTarget.split(";");
                                      if ((paramARTarget != null) && (paramARTarget.length == 3))
                                      {
                                        localKeyingParams.f = Float.valueOf(paramARTarget[0]).floatValue();
                                        localKeyingParams.g = Float.valueOf(paramARTarget[1]).floatValue();
                                        localKeyingParams.h = Float.valueOf(paramARTarget[2]).floatValue();
                                        localKeyingParams.jdField_a_of_type_Int = 3;
                                      }
                                    }
                                    else if ((i == 3) && (!TextUtils.isEmpty(paramARTarget)))
                                    {
                                      paramARTarget = paramARTarget.split(";");
                                      if ((paramARTarget != null) && (paramARTarget.length == 3))
                                      {
                                        localKeyingParams.f = Float.valueOf(paramARTarget[0]).floatValue();
                                        localKeyingParams.g = Float.valueOf(paramARTarget[1]).floatValue();
                                        localKeyingParams.h = Float.valueOf(paramARTarget[2]).floatValue();
                                        localKeyingParams.jdField_a_of_type_Int = 4;
                                      }
                                    }
                                    else if ((i == 4) && (!TextUtils.isEmpty(paramARTarget)))
                                    {
                                      localKeyingParams.jdField_a_of_type_JavaLangString = CustomizeKey.a(paramARTarget, "uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n");
                                      localKeyingParams.jdField_a_of_type_Int = 5;
                                    }
                                  }
                                  i = 2;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        catch (Throwable paramARTarget)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            paramARTarget.printStackTrace();
            i = j;
          }
        }
      }
    }
    return new Pair(Integer.valueOf(i), localKeyingParams);
  }
  
  public static void a(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(i);
      QLog.d("ARVideoUtil", 1, localStringBuilder.toString());
    }
  }
  
  public static boolean a()
  {
    String str = Build.MODEL.toLowerCase();
    return (Build.MANUFACTURER.toLowerCase().contains("meizu")) && (str.contains("m040"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARVideoUtil
 * JD-Core Version:    0.7.0.1
 */