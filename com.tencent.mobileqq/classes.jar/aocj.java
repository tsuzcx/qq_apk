import android.opengl.GLES20;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class aocj
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
  
  public static int a(aoci paramaoci)
  {
    if ((paramaoci == null) || (paramaoci.a == null)) {}
    for (;;)
    {
      return 0;
      try
      {
        int i = ((ArVideoResourceInfo)paramaoci.a.a.get(0)).jdField_b_of_type_Int;
        if (i >= 0) {}
        for (;;)
        {
          return i;
          i = 0;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Throwable paramaoci) {}
    }
    paramaoci.printStackTrace();
    return 0;
  }
  
  public static aoex a(String paramString)
  {
    aoex localaoex = new aoex();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\|");
      if (paramString != null)
      {
        if (paramString.length >= 1) {
          localaoex.jdField_a_of_type_Int = Integer.valueOf(paramString[0]).intValue();
        }
        if (paramString.length >= 2) {
          localaoex.jdField_b_of_type_Int = Integer.valueOf(paramString[1]).intValue();
        }
      }
    }
    return localaoex;
  }
  
  public static aoex a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = a(paramString);
    if ((paramString.jdField_a_of_type_Int == 0) || (paramString.jdField_b_of_type_Int == 0)) {
      return paramString;
    }
    int i = paramString.jdField_a_of_type_Int;
    int j = paramString.jdField_b_of_type_Int;
    if (paramInt2 * 1.0F / j > paramInt1 * 1.0F / i)
    {
      paramInt1 = j * 1 * paramInt1 / i;
      paramString.jdField_a_of_type_Float = 2.0F;
    }
    for (paramString.jdField_b_of_type_Float = (paramInt1 * 2.0F / paramInt2);; paramString.jdField_b_of_type_Float = 2.0F)
    {
      paramString.c = 0.0F;
      paramString.d = 0.0F;
      paramString.e = 0.0F;
      return paramString;
      paramString.jdField_a_of_type_Float = (i * 1 * paramInt2 / j * 2.0F / paramInt1);
    }
  }
  
  public static aoex a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    aoex localaoex = a(paramString);
    if ((localaoex.jdField_a_of_type_Int == 0) || (localaoex.jdField_b_of_type_Int == 0))
    {
      localaoex.jdField_a_of_type_Int = paramInt1;
      localaoex.jdField_b_of_type_Int = paramInt2;
    }
    float f7 = paramInt1 * 1.0F / Math.max(1, paramInt2);
    float f8 = localaoex.jdField_a_of_type_Int;
    float f9 = localaoex.jdField_b_of_type_Int;
    float f2 = 1.0F;
    float f1 = 1.0F;
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f10 = 1.0F * f8 / f9;
    float f5;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\|");
      if (paramString != null)
      {
        if (paramString.length >= 3) {
          f2 = Float.valueOf(paramString[2]).floatValue();
        }
        if (paramString.length >= 4) {
          f1 = Float.valueOf(paramString[3]).floatValue();
        }
        if (paramString.length >= 5) {
          f3 = Float.valueOf(paramString[4]).floatValue();
        }
        if (paramString.length >= 6) {
          f4 = -Float.valueOf(paramString[5]).floatValue();
        }
        f5 = f4;
        paramInt2 = 1;
        f4 = f3;
        f3 = f5;
      }
    }
    for (;;)
    {
      paramInt1 = 1;
      f5 = f1;
      float f6 = f2;
      if (paramInt2 != 0)
      {
        if ((f2 <= 0.05F) || (f1 <= 0.05F)) {
          break label385;
        }
        if (f10 > f7)
        {
          paramInt1 = 1;
          f6 = f2;
          f5 = f1;
        }
      }
      else
      {
        if (!paramBoolean) {
          break label500;
        }
        localaoex.jdField_a_of_type_Float = (10.0F * f7);
        localaoex.jdField_b_of_type_Float = 10.0F;
        localaoex.c = 0.0F;
        localaoex.d = 0.0F;
        localaoex.e = -5.0F;
        if (paramInt2 != 0)
        {
          if (paramInt1 == 0) {
            break label459;
          }
          localaoex.jdField_a_of_type_Float *= f6;
          localaoex.jdField_b_of_type_Float = (localaoex.jdField_a_of_type_Float * (f9 / f8));
          f1 = localaoex.jdField_a_of_type_Float / 2.0F;
          label320:
          localaoex.c = (f4 * f7 / f1);
          localaoex.d = (f3 / f1);
        }
      }
      label385:
      label459:
      label500:
      do
      {
        QLog.i("ARVideoUtil", 1, "parseVideoLayout layout = " + localaoex);
        return localaoex;
        paramInt1 = 0;
        f5 = f1;
        f6 = f2;
        break;
        if (f2 > 0.05F)
        {
          paramInt1 = 1;
          f5 = f1;
          f6 = f2;
          break;
        }
        if (f1 > 0.05F)
        {
          paramInt1 = 0;
          f5 = f1;
          f6 = f2;
          break;
        }
        if (f10 > f7)
        {
          paramInt1 = 1;
          f6 = 1.0F;
          f5 = f1;
          break;
        }
        paramInt1 = 0;
        f5 = 1.0F;
        f6 = f2;
        break;
        localaoex.jdField_b_of_type_Float *= f5;
        localaoex.jdField_a_of_type_Float = (localaoex.jdField_b_of_type_Float * (f8 / f9));
        f1 = localaoex.jdField_b_of_type_Float / 2.0F;
        break label320;
        localaoex.jdField_a_of_type_Float = 2.0F;
        localaoex.jdField_b_of_type_Float = 2.0F;
        localaoex.c = 0.0F;
        localaoex.d = 0.0F;
        localaoex.e = 0.0F;
      } while (paramInt2 == 0);
      if (paramInt1 != 0)
      {
        localaoex.jdField_a_of_type_Float *= f6;
        localaoex.jdField_b_of_type_Float = (localaoex.jdField_a_of_type_Float * f7 * (f9 / f8));
      }
      for (f1 = localaoex.jdField_a_of_type_Float / 2.0F;; f1 = localaoex.jdField_b_of_type_Float / 2.0F)
      {
        localaoex.c = (f4 / f1);
        localaoex.d = (f3 / f1);
        break;
        localaoex.jdField_b_of_type_Float *= f5;
        localaoex.jdField_a_of_type_Float = (localaoex.jdField_b_of_type_Float / f7 * (f8 / f9));
      }
      f4 = 0.0F;
      f2 = 1.0F;
      f3 = 0.0F;
      paramInt2 = 0;
    }
  }
  
  public static Pair<Integer, aokz> a(aoci paramaoci)
  {
    int k = 0;
    aokz localaokz = aoky.a(0);
    if (paramaoci.a.d == 2) {}
    for (;;)
    {
      int j;
      try
      {
        j = Integer.parseInt(((ArVideoResourceInfo)paramaoci.a.a.get(0)).jdField_a_of_type_JavaLangString);
        if (j < 0)
        {
          i = k;
          return new Pair(Integer.valueOf(i), localaokz);
        }
      }
      catch (Throwable paramaoci)
      {
        j = 0;
        continue;
        if (j != 0)
        {
          i = k;
          if (j != 1) {
            continue;
          }
        }
        i = j;
        continue;
      }
      if (paramaoci.a.d != 3)
      {
        i = k;
        if (paramaoci.a.d != 4) {}
      }
      else if ((paramaoci.a.d == 4) && ("circle".equalsIgnoreCase(((ArVideoResourceInfo)paramaoci.a.a.get(0)).jdField_a_of_type_JavaLangString)))
      {
        i = 1;
      }
      else
      {
        try
        {
          paramaoci = ((ArVideoResourceInfo)paramaoci.a.a.get(0)).jdField_a_of_type_JavaLangString.split("\\|");
          if ((paramaoci == null) || (paramaoci.length < 5)) {
            break;
          }
          i = Integer.parseInt(paramaoci[0]);
          j = Integer.parseInt(paramaoci[1]);
          int m = Integer.parseInt(paramaoci[2]);
          int n = Integer.parseInt(paramaoci[3]);
          int i1 = Integer.parseInt(paramaoci[4]);
          if ((i > 255) || (j > 255) || (m > 255) || (n > 255) || (i < 0) || (j < 0) || (m < 0) || (n < 0) || (i1 < 0) || (i1 > 100)) {
            break label601;
          }
          localaokz.a(i / 255.0F, j / 255.0F, m / 255.0F);
          localaokz.jdField_a_of_type_Int = 1;
          localaokz.d = (n / 255.0F);
          localaokz.e = (i1 / 100.0F);
          if ((paramaoci != null) && (paramaoci.length >= 6) && (Integer.parseInt(paramaoci[5]) == 1)) {
            localaokz.jdField_a_of_type_Int = 2;
          }
          if ((paramaoci != null) && (paramaoci.length >= 8))
          {
            i = Integer.parseInt(paramaoci[6]);
            paramaoci = paramaoci[7];
            if ((i == 2) && (!TextUtils.isEmpty(paramaoci)))
            {
              paramaoci = paramaoci.split(";");
              if ((paramaoci == null) || (paramaoci.length != 3)) {
                break label606;
              }
              localaokz.f = Float.valueOf(paramaoci[0]).floatValue();
              localaokz.g = Float.valueOf(paramaoci[1]).floatValue();
              localaokz.h = Float.valueOf(paramaoci[2]).floatValue();
              localaokz.jdField_a_of_type_Int = 3;
              break label606;
            }
            if ((i == 3) && (!TextUtils.isEmpty(paramaoci)))
            {
              paramaoci = paramaoci.split(";");
              if ((paramaoci == null) || (paramaoci.length != 3)) {
                break label611;
              }
              localaokz.f = Float.valueOf(paramaoci[0]).floatValue();
              localaokz.g = Float.valueOf(paramaoci[1]).floatValue();
              localaokz.h = Float.valueOf(paramaoci[2]).floatValue();
              localaokz.jdField_a_of_type_Int = 4;
              break label611;
            }
            if ((i == 4) && (!TextUtils.isEmpty(paramaoci)))
            {
              localaokz.jdField_a_of_type_JavaLangString = aokr.a(paramaoci, "uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n");
              localaokz.jdField_a_of_type_Int = 5;
            }
          }
          i = 2;
        }
        catch (Throwable paramaoci)
        {
          i = k;
        }
        if (QLog.isColorLevel())
        {
          paramaoci.printStackTrace();
          i = k;
        }
      }
    }
    int i = 0;
    break label603;
    label601:
    i = 0;
    for (;;)
    {
      label603:
      break;
      label606:
      i = 2;
      continue;
      label611:
      i = 2;
    }
  }
  
  public static void a(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      QLog.d("ARVideoUtil", 1, paramString + ": glError " + i);
    }
  }
  
  public static boolean a()
  {
    String str = Build.MODEL.toLowerCase();
    return (Build.MANUFACTURER.toLowerCase().contains("meizu")) && (str.contains("m040"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocj
 * JD-Core Version:    0.7.0.1
 */