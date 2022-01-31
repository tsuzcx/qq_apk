import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.opencl.OpenclInfoManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class axjp
{
  private static int jdField_a_of_type_Int;
  public static String a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "snpe", "opencl_mali", "opencl_ocl", "opengl" };
  private static int jdField_b_of_type_Int;
  private static String jdField_b_of_type_JavaLangString = "";
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "NX609J", "NX531J", "vivo X7Plus", "ARS-TL00", "MI 8 Lite", "1807-A01", "ARE-AL00" };
  private static int jdField_c_of_type_Int;
  private static String jdField_c_of_type_JavaLangString = "";
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString = { "Redmi Note 3" };
  private static int d;
  private static int e;
  private static int f = -1;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
    d = -1;
    e = 0;
  }
  
  /* Error */
  public static int a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 55	axjp:jdField_b_of_type_Int	I
    //   6: iconst_m1
    //   7: if_icmple +12 -> 19
    //   10: getstatic 55	axjp:jdField_b_of_type_Int	I
    //   13: istore_0
    //   14: ldc 2
    //   16: monitorexit
    //   17: iload_0
    //   18: ireturn
    //   19: invokestatic 72	axjp:a	()Ljava/lang/String;
    //   22: invokestatic 75	axjp:a	(Ljava/lang/String;)I
    //   25: istore_0
    //   26: goto -12 -> 14
    //   29: astore_1
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	13	0	i	int
    //   29	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	14	29	finally
    //   19	26	29	finally
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("qmcf_gpu_config", 0).getInt("cfg_version", 0);
  }
  
  public static int a(String paramString)
  {
    if (jdField_b_of_type_Int > -1) {
      return jdField_b_of_type_Int;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      jdField_b_of_type_Int = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support because of version:%d ", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) }));
      return jdField_b_of_type_Int;
    }
    int i = axkr.a();
    if (i != -1)
    {
      jdField_b_of_type_Int = i;
      QLog.d("QmcfDevicesStrategy", 1, "DPCInfo:" + i);
      return jdField_b_of_type_Int;
    }
    jdField_b_of_type_Int = 0;
    if (Build.MODEL.contains("Pixel"))
    {
      jdField_b_of_type_Int = 4;
      return jdField_b_of_type_Int;
    }
    if (Build.MODEL.contains("Nexus"))
    {
      jdField_b_of_type_Int = 0;
      QLog.d("QmcfDevicesStrategy", 1, "not support because of nexus");
      return jdField_b_of_type_Int;
    }
    String[] arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (Build.MODEL.equalsIgnoreCase(str))
      {
        jdField_b_of_type_Int = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule");
        return jdField_b_of_type_Int;
      }
      i += 1;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool1 = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
      boolean bool2 = new File("/system/lib/egl/libGLES_mali.so").exists();
      if ((bool1) || (bool2))
      {
        jdField_b_of_type_Int = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
        return jdField_b_of_type_Int;
      }
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      jdField_a_of_type_JavaLangString = new OpenclInfoManager().a();
      QLog.d("QmcfDevicesStrategy", 1, "GPUInfo:" + jdField_a_of_type_JavaLangString);
    }
    if ((TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) || (jdField_a_of_type_JavaLangString.startsWith("err")))
    {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4).getString("gl_renderer", "");
      QLog.i("QmcfDevicesStrategy", 1, "getGLRendererInfo:" + jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
      {
        jdField_b_of_type_Int = -2;
        return jdField_b_of_type_Int;
      }
    }
    jdField_b_of_type_Int = c(paramString);
    if (jdField_b_of_type_Int == 0) {
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support gpu[%s] type[%s]", new Object[] { jdField_a_of_type_JavaLangString, Integer.valueOf(jdField_b_of_type_Int) }));
    }
    return jdField_b_of_type_Int;
  }
  
  private static String a()
  {
    String str2 = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 0).getString("cfg_content", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = bbdj.d("qmcf_rule_config.xml");
    }
    return str1;
  }
  
  public static void a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("QmcfConfig", 4).edit();
    paramContext.putInt("qmcf_mobile_support", 1);
    paramContext.commit();
  }
  
  public static void a(String paramString)
  {
    if (f == -1)
    {
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4);
      f = ((SharedPreferences)localObject).getInt("gl_renderer_flag", 0);
      if (f == 0)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("gl_renderer", paramString);
        ((SharedPreferences.Editor)localObject).putInt("gl_renderer_flag", 1);
        ((SharedPreferences.Editor)localObject).commit();
        f = 1;
        QLog.i("QmcfDevicesStrategy", 1, "saveGLRendererInfo:" + paramString);
      }
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if ("large".equals(paramString1)) {
      a(paramString2, true);
    }
    do
    {
      return;
      if ("less".equals(paramString1))
      {
        a(paramString2, false);
        return;
      }
      if ("between".equals(paramString1))
      {
        b(paramString2);
        return;
      }
    } while (!"enum".equals(paramString1));
    c(paramString2);
  }
  
  private static void a(String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString1 = paramString.split(";");
    label407:
    label413:
    for (;;)
    {
      int j;
      int i;
      boolean bool1;
      String[] arrayOfString2;
      int k;
      int m;
      try
      {
        if (!jdField_a_of_type_JavaLangString.contains("Mali")) {
          break label230;
        }
        j = arrayOfString1.length;
        i = 0;
        bool1 = bool3;
        if (i < j)
        {
          arrayOfString2 = arrayOfString1[i].split("#");
          if (arrayOfString2.length != 2) {
            break label183;
          }
          paramString = arrayOfString2[0];
          if (!jdField_a_of_type_JavaLangString.contains(paramString)) {
            break label413;
          }
          paramString = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(jdField_a_of_type_JavaLangString);
          k = arrayOfString2.length;
          bool1 = paramString.find();
          if (!bool1) {
            break label413;
          }
        }
        bool1 = bool3;
      }
      catch (Exception paramString)
      {
        try
        {
          k = Integer.parseInt(paramString.group((k - 1) * 2));
          m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
          if (paramBoolean)
          {
            bool1 = bool2;
            if (k >= m) {}
          }
          else
          {
            if ((paramBoolean) || (k > m)) {
              break label407;
            }
            bool1 = bool2;
          }
          a(bool1);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        return;
      }
      label183:
      if (arrayOfString2.length == 3)
      {
        paramString = arrayOfString2[0] + arrayOfString2[1];
        continue;
        label230:
        bool1 = bool3;
        if (jdField_a_of_type_JavaLangString.contains("Adreno"))
        {
          j = arrayOfString1.length;
          i = 0;
          for (;;)
          {
            for (;;)
            {
              bool1 = bool3;
              if (i >= j) {
                break;
              }
              arrayOfString2 = arrayOfString1[i].split("#");
              paramString = "0";
              Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(jdField_a_of_type_JavaLangString);
              if (localMatcher.find()) {
                paramString = localMatcher.group(1);
              }
              if ((arrayOfString2.length != 2) || (!paramString.substring(0, 1).equals(arrayOfString2[0])))
              {
                k = arrayOfString2.length;
                if (k != 1) {}
              }
              else
              {
                try
                {
                  k = Integer.parseInt(paramString);
                  m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
                  if ((!paramBoolean) || (k < m))
                  {
                    bool1 = bool3;
                    if (paramBoolean) {
                      break;
                    }
                    bool1 = bool3;
                    if (k > m) {
                      break;
                    }
                  }
                  bool1 = true;
                }
                catch (Exception paramString)
                {
                  paramString.printStackTrace();
                }
              }
            }
            i += 1;
          }
          bool1 = false;
          continue;
          i += 1;
        }
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("verdor").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (jdField_a_of_type_JavaLangString.contains(str)) {
          b(paramJSONObject.getJSONObject(str));
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private static void a(boolean paramBoolean)
  {
    if ("white".equals(jdField_b_of_type_JavaLangString)) {
      if (paramBoolean) {
        jdField_a_of_type_Int = e;
      }
    }
    while ((!"black".equals(jdField_b_of_type_JavaLangString)) || (paramBoolean)) {
      return;
    }
    jdField_a_of_type_Int = e;
  }
  
  public static boolean a()
  {
    return lpz.a(4, 1200000L, 2147483648L);
  }
  
  public static boolean a(String paramString, int paramInt, Context paramContext)
  {
    try
    {
      a(paramContext);
      paramContext = paramContext.getSharedPreferences("qmcf_gpu_config", 0).edit();
      paramContext.putString("cfg_content", paramString);
      paramContext.putInt("cfg_version", paramInt);
      return paramContext.commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QmcfDevicesStrategy", 2, "setQmcfMobileSupport err!", localException);
        }
      }
    }
  }
  
  public static int b()
  {
    int j = 0;
    if (jdField_c_of_type_Int > -1) {
      return jdField_c_of_type_Int;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      jdField_c_of_type_Int = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support because of version:%d ", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) }));
      return jdField_c_of_type_Int;
    }
    if (!a())
    {
      jdField_c_of_type_Int = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support because of low-end devices", new Object[0]));
      return jdField_c_of_type_Int;
    }
    int i = axkr.a();
    if (i != -1)
    {
      jdField_c_of_type_Int = i;
      QLog.d("QmcfDevicesStrategy", 1, "DPCInfo:" + i);
      return jdField_c_of_type_Int;
    }
    jdField_c_of_type_Int = 0;
    if ((Build.MODEL.contains("Pixel")) || (Build.MODEL.contains("Nexus")))
    {
      jdField_c_of_type_Int = 4;
      return jdField_c_of_type_Int;
    }
    String[] arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
    int k = arrayOfString.length;
    i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      if (Build.MODEL.equalsIgnoreCase(str))
      {
        jdField_c_of_type_Int = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule");
        return jdField_c_of_type_Int;
      }
      i += 1;
    }
    arrayOfString = jdField_c_of_type_ArrayOfJavaLangString;
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      if (Build.MODEL.equalsIgnoreCase(str))
      {
        jdField_c_of_type_Int = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule loose");
        return jdField_c_of_type_Int;
      }
      i += 1;
    }
    boolean bool1 = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
    boolean bool2 = new File("/system/lib/egl/libGLES_mali.so").exists();
    if ((bool1) || (bool2))
    {
      jdField_c_of_type_Int = 4;
      QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
      return jdField_c_of_type_Int;
    }
    jdField_c_of_type_Int = 3;
    return jdField_c_of_type_Int;
  }
  
  public static int b(String paramString)
  {
    if (d > -1) {
      return d;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      d = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("multiaio not support because of version:%d ", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) }));
      return d;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool1 = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
      boolean bool2 = new File("/system/lib/egl/libGLES_mali.so").exists();
      if ((bool1) || (bool2))
      {
        d = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
        return d;
      }
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      jdField_a_of_type_JavaLangString = new OpenclInfoManager().a();
      QLog.d("QmcfDevicesStrategy", 1, "GPUInfo:" + jdField_a_of_type_JavaLangString);
    }
    if ((TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) || (jdField_a_of_type_JavaLangString.startsWith("err")))
    {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4).getString("gl_renderer", "");
      QLog.i("QmcfDevicesStrategy", 1, "getGLRendererInfo:" + jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
      {
        d = 4;
        return d;
      }
    }
    d = c(paramString);
    return d;
  }
  
  private static void b(String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = paramString.split(";");
    for (;;)
    {
      int j;
      int i;
      boolean bool1;
      Object localObject;
      int k;
      int m;
      int n;
      try
      {
        if (jdField_a_of_type_JavaLangString.contains("Mali"))
        {
          j = arrayOfString.length;
          i = 0;
          bool1 = bool3;
          if (i < j)
          {
            paramString = arrayOfString[i].split("#");
            bool1 = bool3;
            if (paramString.length == 4)
            {
              localObject = paramString[0] + paramString[1];
              if (!jdField_a_of_type_JavaLangString.contains((CharSequence)localObject)) {
                break label377;
              }
              localObject = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(jdField_a_of_type_JavaLangString);
              bool1 = ((Matcher)localObject).find();
              if (!bool1) {
                break label377;
              }
            }
          }
        }
        bool1 = bool3;
      }
      catch (Exception paramString)
      {
        try
        {
          k = Integer.parseInt(((Matcher)localObject).group(4));
          m = Integer.parseInt(paramString[2]);
          n = Integer.parseInt(paramString[3]);
          if ((k > n) || (k < m)) {
            break label371;
          }
          bool1 = bool2;
          a(bool1);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        return;
      }
      if (jdField_a_of_type_JavaLangString.contains("Adreno"))
      {
        j = arrayOfString.length;
        i = 0;
        for (;;)
        {
          for (;;)
          {
            bool1 = bool3;
            if (i >= j) {
              break;
            }
            localObject = arrayOfString[i].split("#");
            paramString = "0";
            Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(jdField_a_of_type_JavaLangString);
            if (localMatcher.find()) {
              paramString = localMatcher.group(1);
            }
            if ((localObject.length != 3) || (!paramString.substring(0, 1).equals(localObject[0])))
            {
              k = localObject.length;
              if (k != 2) {}
            }
            else
            {
              try
              {
                k = Integer.parseInt(paramString);
                m = Integer.parseInt(localObject[(localObject.length - 2)]);
                n = Integer.parseInt(localObject[(localObject.length - 1)]);
                bool1 = bool3;
                if (k > n) {
                  break;
                }
                bool1 = bool3;
                if (k < m) {
                  break;
                }
                bool1 = true;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
            }
          }
          i += 1;
        }
        label371:
        bool1 = false;
        continue;
        label377:
        i += 1;
      }
    }
  }
  
  private static void b(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("strategy").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        JSONObject localJSONObject = paramJSONObject.getJSONObject(str);
        jdField_b_of_type_JavaLangString = str;
        c(localJSONObject);
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private static int c(String paramString)
  {
    int m = 0;
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
        int n = arrayOfString.length;
        i = 0;
        int j = 0;
        int k = m;
        if (i < n)
        {
          Object localObject = arrayOfString[i];
          j += 1;
          if ((!jdField_c_of_type_JavaLangString.contains((CharSequence)localObject)) && (paramString.has((String)localObject)))
          {
            localObject = paramString.getJSONObject((String)localObject);
            e = j;
            a((JSONObject)localObject);
            if (jdField_a_of_type_Int > 0)
            {
              QLog.d("QmcfDevicesStrategy", 1, "support because of config: " + jdField_a_of_type_Int);
              k = jdField_a_of_type_Int;
            }
          }
        }
        else
        {
          return k;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return 4;
      }
      i += 1;
    }
  }
  
  private static void c(String paramString)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split(";");
    for (;;)
    {
      int i;
      try
      {
        int j = paramString.length;
        i = 0;
        boolean bool1 = bool2;
        if (i < j)
        {
          CharSequence localCharSequence = paramString[i];
          if (jdField_a_of_type_JavaLangString.contains(localCharSequence)) {
            bool1 = true;
          }
        }
        else
        {
          a(bool1);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  private static void c(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("rule").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        a(str, paramJSONObject.getString(str));
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axjp
 * JD-Core Version:    0.7.0.1
 */