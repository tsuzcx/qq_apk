import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class bdyu
{
  public static int a;
  public static final ArrayList<String> a;
  public static boolean a;
  private static String[] a;
  public static int b;
  public static boolean b;
  public static int c;
  public static boolean c;
  public static boolean d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add("SHARP_FS8010".toLowerCase());
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "HUAWEI", "OPPO", "VIVO", "XIAOMI" };
  }
  
  public static int a(Activity paramActivity)
  {
    int j = a(paramActivity);
    paramActivity = paramActivity.getWindow().getDecorView();
    int i;
    if (paramActivity == null)
    {
      if (bdnw.a()) {
        bdnw.b("LiuHaiUtils", "getNotchInScreenHeight_AndroidP decorView=null ");
      }
      i = j;
    }
    for (;;)
    {
      return i;
      try
      {
        paramActivity = paramActivity.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(paramActivity, new Object[0]);
        if (paramActivity == null)
        {
          if (!bdnw.a()) {
            return j;
          }
          bdnw.b("LiuHaiUtils", "getNotchInScreenHeight_AndroidP getRootWindowInsets inserts=null ");
          return j;
        }
        paramActivity = paramActivity.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(paramActivity, new Object[0]);
        if (bdnw.a()) {
          bdnw.b("LiuHaiUtils", "getNotchInScreenHeight_AndroidP getDisplayCutout cutOut=" + paramActivity);
        }
        if (paramActivity != null)
        {
          int k = ((Integer)paramActivity.getClass().getMethod("getSafeInsetTop", new Class[0]).invoke(paramActivity, new Object[0])).intValue();
          i = k;
          if (!bdnw.a()) {
            continue;
          }
          bdnw.b("LiuHaiUtils", "getNotchInScreenHeight_AndroidP top:" + k);
          return k;
        }
      }
      catch (Exception paramActivity)
      {
        if (bdnw.a()) {
          bdnw.d("LiuHaiUtils", "getNotchInScreenHeight_AndroidP Exception");
        }
      }
    }
    return j;
    return j;
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  private static int a(String paramString, int paramInt)
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      i = paramInt;
      if (localObject != null)
      {
        localObject = ((Class)localObject).getMethod("getInt", new Class[] { String.class, Integer.TYPE });
        i = paramInt;
        if (localObject != null)
        {
          paramString = ((Method)localObject).invoke(null, new Object[] { paramString, Integer.valueOf(paramInt) });
          i = paramInt;
          if ((paramString instanceof Integer)) {
            i = ((Integer)paramString).intValue();
          }
        }
      }
    }
    catch (Exception paramString)
    {
      do
      {
        int i = paramInt;
      } while (!bdnw.a());
      bdnw.a("LiuHaiUtils", "getSystemPropertyForXiaomi() Exception=" + paramString.getMessage());
    }
    return i;
    return paramInt;
  }
  
  public static void a(Activity paramActivity)
  {
    if (bdnw.a()) {
      bdnw.b("LiuHaiUtils", "initLiuHaiProperty manufacturer:" + Build.MANUFACTURER + " hasInitHasNotch:" + jdField_c_of_type_Boolean + " sHasNotch:" + jdField_a_of_type_Boolean + " sEnableNotchOK:" + jdField_b_of_type_Boolean + " sNotchHeight:" + jdField_a_of_type_Int);
    }
    if (!jdField_c_of_type_Boolean)
    {
      jdField_b_of_type_Int = bdyn.a(paramActivity);
      jdField_c_of_type_Int = bdyn.a(paramActivity);
      jdField_a_of_type_Boolean = false;
    }
    try
    {
      jdField_a_of_type_Boolean = c(paramActivity);
      if (jdField_a_of_type_Boolean) {
        jdField_a_of_type_Int = b(paramActivity);
      }
      jdField_c_of_type_Boolean = true;
      jdField_b_of_type_Boolean = false;
      if (jdField_a_of_type_Boolean)
      {
        jdField_b_of_type_Boolean = j(paramActivity);
        if (jdField_a_of_type_Int <= 0) {
          jdField_b_of_type_Boolean = false;
        }
      }
      if (bdnw.a()) {
        bdnw.d("LiuHaiUtils", "initLiuHaiProperty[after] manufacturer:" + Build.MANUFACTURER + " hasInitHasNotch:" + jdField_c_of_type_Boolean + " sHasNotch:" + jdField_a_of_type_Boolean + " sEnableNotchOK:" + jdField_b_of_type_Boolean + " sNotchHeight:" + jdField_a_of_type_Int);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (bdnw.a()) {
          bdnw.d("LiuHaiUtils", "initLiuHaiProperty manufacturer:" + Build.MANUFACTURER, localThrowable);
        }
      }
    }
  }
  
  public static boolean a()
  {
    return (jdField_a_of_type_Boolean) && (jdField_b_of_type_Boolean) && (jdField_a_of_type_Int > 0);
  }
  
  public static boolean a(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    if (paramActivity == null) {
      if (bdnw.a()) {
        bdnw.b("LiuHaiUtils", "hasNotchInScreen_AndroidP decorView=null");
      }
    }
    do
    {
      for (;;)
      {
        return false;
        try
        {
          paramActivity = paramActivity.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(paramActivity, new Object[0]);
          if (paramActivity != null) {
            break label84;
          }
          if (bdnw.a())
          {
            bdnw.b("LiuHaiUtils", "hasNotchInScreen_AndroidP getRootWindowInsets inserts=null");
            return false;
          }
        }
        catch (Exception paramActivity) {}
      }
    } while (!bdnw.a());
    bdnw.d("LiuHaiUtils", "hasNotchInScreen_AndroidP Exception");
    return false;
    label84:
    if (paramActivity.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(paramActivity, new Object[0]) != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (bdnw.a()) {
        bdnw.b("LiuHaiUtils", "hasNotchInScreen_AndroidP getDisplayCutout  exists:" + bool);
      }
      return bool;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    do
    {
      try
      {
        paramContext = paramContext.getClassLoader().loadClass("android.util.FtFeature");
        bool1 = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(32) })).booleanValue();
        boolean bool2 = bool1;
        bool2 = bool1;
      }
      catch (Exception paramContext)
      {
        try
        {
          if (bdnw.a())
          {
            bdnw.b("LiuHaiUtils", "vivoHasNotchInScreen ret=" + bool1);
            bool2 = bool1;
          }
          return bool2;
        }
        catch (Exception paramContext)
        {
          boolean bool1;
          continue;
        }
        paramContext = paramContext;
        bool1 = false;
      }
    } while (!bdnw.a());
    bdnw.d("LiuHaiUtils", "vivoHasNotchInScreen Exception", paramContext);
    return bool1;
  }
  
  public static int[] a(Context paramContext)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext = new DisplayMetrics();
      localDisplay.getRealMetrics(paramContext);
      if (bdnw.a()) {
        bdnw.b("LiuHaiUtils", "getRealDisplay manufacturer:" + Build.MANUFACTURER + " version:" + Build.VERSION.SDK_INT + " width:" + paramContext.widthPixels + " height:" + paramContext.heightPixels);
      }
      return new int[] { paramContext.widthPixels, paramContext.heightPixels };
    }
    boolean bool = bdyn.a(paramContext);
    if (bool) {}
    for (int i = bdyn.c(paramContext);; i = 0)
    {
      if (bdnw.a()) {
        bdnw.b("LiuHaiUtils", "getRealDisplay[none] manufacturer:" + Build.MANUFACTURER + " width:" + localDisplayMetrics.widthPixels + " height:" + localDisplayMetrics.heightPixels + " mNavigationBarHeight:" + i + " hasNavBar:" + bool);
      }
      return new int[] { localDisplayMetrics.widthPixels, i + localDisplayMetrics.heightPixels };
    }
  }
  
  public static int b(Activity paramActivity)
  {
    int k = Build.VERSION.SDK_INT;
    if (bdnw.a()) {
      bdnw.b("LiuHaiUtils", "getNotchInScreenHeight apiVersion: " + k);
    }
    int j = a(paramActivity);
    int i = j;
    if (j <= 0)
    {
      if (k > 27) {
        i = a(paramActivity);
      }
    }
    else {
      return i;
    }
    return b(paramActivity);
  }
  
  public static int b(Context paramContext)
  {
    int j = 0;
    Object localObject = "" + Build.MANUFACTURER;
    if (((String)localObject).equalsIgnoreCase("HUAWEI")) {
      localObject = b(paramContext);
    }
    for (;;)
    {
      if (localObject != null) {}
      for (int i = localObject[0];; i = 0)
      {
        if (localObject != null) {
          j = localObject[1];
        }
        int k = a(paramContext);
        if (bdnw.a()) {
          bdnw.d("LiuHaiUtils", "getNotchInScreenHeight manufacturer:" + Build.MANUFACTURER + " height:" + j + " width:" + i + " status:" + k);
        }
        return Math.max(j, k);
        if (((String)localObject).equalsIgnoreCase("OPPO"))
        {
          localObject = c(paramContext);
          break;
        }
        if (((String)localObject).equalsIgnoreCase("VIVO"))
        {
          localObject = null;
          break;
        }
        if (!((String)localObject).equalsIgnoreCase("XIAOMI")) {
          break label195;
        }
        localObject = d(paramContext);
        break;
      }
      label195:
      localObject = null;
    }
  }
  
  private static boolean b()
  {
    String str = "" + Build.MANUFACTURER;
    if (Build.VERSION.SDK_INT > 27) {}
    for (;;)
    {
      return true;
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (str.equalsIgnoreCase(arrayOfString[i])) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public static boolean b(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (bdnw.a()) {
      bdnw.b("LiuHaiUtils", "enableNotch apiVersion: " + i);
    }
    if (i > 27) {
      return i(paramActivity);
    }
    return h(paramActivity);
  }
  
  public static boolean b(Context paramContext)
  {
    String str = "" + Build.MANUFACTURER;
    if (str.equalsIgnoreCase("HUAWEI")) {
      return c(paramContext);
    }
    if (str.equalsIgnoreCase("OPPO")) {
      return d(paramContext);
    }
    if (str.equalsIgnoreCase("VIVO")) {
      return a(paramContext);
    }
    if (str.equalsIgnoreCase("XIAOMI")) {
      return e(paramContext);
    }
    return false;
  }
  
  /* Error */
  private static int[] b(Context paramContext)
  {
    // Byte code:
    //   0: iconst_2
    //   1: newarray int
    //   3: astore_1
    //   4: aload_1
    //   5: dup
    //   6: iconst_0
    //   7: iconst_0
    //   8: iastore
    //   9: dup
    //   10: iconst_1
    //   11: iconst_0
    //   12: iastore
    //   13: pop
    //   14: aload_0
    //   15: invokevirtual 240	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   18: ldc_w 361
    //   21: invokevirtual 247	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   24: astore_0
    //   25: aload_0
    //   26: ldc_w 363
    //   29: iconst_0
    //   30: anewarray 83	java/lang/Class
    //   33: invokevirtual 87	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   36: aload_0
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokevirtual 93	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 365	[I
    //   47: checkcast 365	[I
    //   50: astore_0
    //   51: aload_0
    //   52: astore_1
    //   53: invokestatic 68	bdnw:a	()Z
    //   56: ifeq +30 -> 86
    //   59: ldc 70
    //   61: new 99	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 367
    //   71: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_0
    //   75: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 75	bdnw:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_0
    //   85: astore_1
    //   86: aload_1
    //   87: areturn
    //   88: astore_0
    //   89: aload_1
    //   90: astore_0
    //   91: aload_0
    //   92: astore_1
    //   93: invokestatic 68	bdnw:a	()Z
    //   96: ifeq -10 -> 86
    //   99: ldc 70
    //   101: ldc_w 369
    //   104: invokestatic 129	bdnw:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: areturn
    //   109: astore_0
    //   110: aload_1
    //   111: astore_0
    //   112: aload_0
    //   113: astore_1
    //   114: invokestatic 68	bdnw:a	()Z
    //   117: ifeq -31 -> 86
    //   120: ldc 70
    //   122: ldc_w 371
    //   125: invokestatic 129	bdnw:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: areturn
    //   130: astore_0
    //   131: aload_1
    //   132: astore_0
    //   133: aload_0
    //   134: astore_1
    //   135: invokestatic 68	bdnw:a	()Z
    //   138: ifeq -52 -> 86
    //   141: ldc 70
    //   143: ldc_w 373
    //   146: invokestatic 129	bdnw:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_0
    //   150: areturn
    //   151: astore_1
    //   152: goto -19 -> 133
    //   155: astore_1
    //   156: goto -44 -> 112
    //   159: astore_1
    //   160: goto -69 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramContext	Context
    //   3	132	1	localObject	Object
    //   151	1	1	localException	Exception
    //   155	1	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   159	1	1	localClassNotFoundException	java.lang.ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   14	51	88	java/lang/ClassNotFoundException
    //   14	51	109	java/lang/NoSuchMethodException
    //   14	51	130	java/lang/Exception
    //   53	84	151	java/lang/Exception
    //   53	84	155	java/lang/NoSuchMethodException
    //   53	84	159	java/lang/ClassNotFoundException
  }
  
  private static boolean c(Activity paramActivity)
  {
    d = false;
    int i = Build.VERSION.SDK_INT;
    String str = "" + Build.MANUFACTURER;
    if (bdnw.a()) {
      bdnw.b("LiuHaiUtils", "hasNotchInScreen version: " + i + " " + str);
    }
    boolean bool1;
    boolean bool2;
    float f1;
    if (i > 27)
    {
      bool1 = a(paramActivity);
      if (bdnw.a()) {
        bdnw.b("LiuHaiUtils", "hasNotchInScreen haveNotch: " + bool1);
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (b())
        {
          i = bdyn.a(paramActivity);
          int j = bdyn.a(paramActivity);
          float f2 = j * 1.0F / i;
          paramActivity = a(paramActivity);
          f1 = f2;
          if (paramActivity.length == 2)
          {
            f1 = f2;
            if (paramActivity[0] > 0)
            {
              f1 = f2;
              if (paramActivity[1] > 0) {
                f1 = paramActivity[1] * 1.0F / paramActivity[0];
              }
            }
          }
          if (bdnw.a()) {
            bdnw.b("LiuHaiUtils", "hasNotchInScreen srcWidth: " + i + " srcHeight:" + j + " ratio:" + f1);
          }
          if (f1 < 2.06F) {
            break label281;
          }
          bool2 = true;
        }
      }
    }
    label281:
    do
    {
      return bool2;
      if (i >= 26)
      {
        bool1 = b(paramActivity);
        break;
      }
      return false;
      bool2 = bool1;
    } while (f1 <= 1.777778F);
    d = true;
    return true;
  }
  
  /* Error */
  private static boolean c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 240	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   4: ldc_w 361
    //   7: invokevirtual 247	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   10: astore_0
    //   11: aload_0
    //   12: ldc_w 402
    //   15: iconst_0
    //   16: anewarray 83	java/lang/Class
    //   19: invokevirtual 87	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   22: aload_0
    //   23: iconst_0
    //   24: anewarray 4	java/lang/Object
    //   27: invokevirtual 93	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 251	java/lang/Boolean
    //   33: invokevirtual 254	java/lang/Boolean:booleanValue	()Z
    //   36: istore_1
    //   37: iload_1
    //   38: istore_2
    //   39: invokestatic 68	bdnw:a	()Z
    //   42: ifeq +30 -> 72
    //   45: ldc 70
    //   47: new 99	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   54: ldc_w 404
    //   57: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_1
    //   61: invokevirtual 193	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   64: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 75	bdnw:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: iload_1
    //   71: istore_2
    //   72: iload_2
    //   73: ireturn
    //   74: astore_0
    //   75: iconst_0
    //   76: istore_1
    //   77: iload_1
    //   78: istore_2
    //   79: invokestatic 68	bdnw:a	()Z
    //   82: ifeq -10 -> 72
    //   85: ldc 70
    //   87: ldc_w 406
    //   90: invokestatic 129	bdnw:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: iload_1
    //   94: ireturn
    //   95: astore_0
    //   96: iconst_0
    //   97: istore_1
    //   98: iload_1
    //   99: istore_2
    //   100: invokestatic 68	bdnw:a	()Z
    //   103: ifeq -31 -> 72
    //   106: ldc 70
    //   108: ldc_w 408
    //   111: invokestatic 129	bdnw:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: iload_1
    //   115: ireturn
    //   116: astore_0
    //   117: iconst_0
    //   118: istore_1
    //   119: iload_1
    //   120: istore_2
    //   121: invokestatic 68	bdnw:a	()Z
    //   124: ifeq -52 -> 72
    //   127: ldc 70
    //   129: ldc_w 410
    //   132: invokestatic 129	bdnw:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: iload_1
    //   136: ireturn
    //   137: astore_0
    //   138: goto -19 -> 119
    //   141: astore_0
    //   142: goto -44 -> 98
    //   145: astore_0
    //   146: goto -69 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramContext	Context
    //   36	100	1	bool1	boolean
    //   38	83	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   0	37	74	java/lang/ClassNotFoundException
    //   0	37	95	java/lang/NoSuchMethodException
    //   0	37	116	java/lang/Exception
    //   39	70	137	java/lang/Exception
    //   39	70	141	java/lang/NoSuchMethodException
    //   39	70	145	java/lang/ClassNotFoundException
  }
  
  private static int[] c(Context paramContext)
  {
    try
    {
      paramContext = bdyn.a("ro.oppo.screen.heteromorphism", null);
      if (TextUtils.isEmpty(paramContext))
      {
        if (bdnw.a()) {
          bdnw.b("LiuHaiUtils", "oppoGetNotchSize mProperty empty");
        }
        return null;
      }
    }
    catch (Throwable paramContext)
    {
      do
      {
        for (;;)
        {
          if (bdnw.a()) {
            bdnw.b("LiuHaiUtils", "oppoGetNotchSize mProperty exp ", paramContext);
          }
          paramContext = null;
          continue;
          paramContext = paramContext.split(":");
          if (bdnw.a()) {
            bdnw.b("LiuHaiUtils", "oppoGetNotchSize mProperty values=" + paramContext);
          }
          if (paramContext.length >= 2)
          {
            String[] arrayOfString = paramContext[0].split(",");
            if (bdnw.a()) {
              bdnw.b("LiuHaiUtils", "oppoGetNotchSize mProperty values[0] size=" + arrayOfString);
            }
            if (arrayOfString.length >= 2) {
              try
              {
                int i = Integer.valueOf(arrayOfString[0]).intValue();
                int j = Integer.valueOf(arrayOfString[1]).intValue();
                if (bdnw.a()) {
                  bdnw.b("LiuHaiUtils", "oppoGetNotchSize mProperty values[0] left=" + i + " top=" + j);
                }
                arrayOfString = paramContext[1].split(",");
                if (bdnw.a()) {
                  bdnw.b("LiuHaiUtils", "oppoGetNotchSize mProperty values[1] size=" + arrayOfString);
                }
                int k;
                int m;
                if ((arrayOfString.length >= 2) && (bdnw.a())) {
                  bdnw.b("LiuHaiUtils", "oppoGetNotchSize values[0]=" + paramContext[0], localNumberFormatException1);
                }
              }
              catch (NumberFormatException localNumberFormatException1)
              {
                try
                {
                  k = Integer.valueOf(arrayOfString[0]).intValue();
                  m = Integer.valueOf(arrayOfString[1]).intValue();
                  if (bdnw.a()) {
                    bdnw.b("LiuHaiUtils", "oppoGetNotchSize mProperty values[1] right=" + k + " bottom=" + m);
                  }
                  return new int[] { k - i, m - j };
                }
                catch (NumberFormatException localNumberFormatException2) {}
                localNumberFormatException1 = localNumberFormatException1;
              }
            }
          }
        }
        return null;
      } while (!bdnw.a());
      bdnw.b("LiuHaiUtils", "oppoGetNotchSize values[1]=" + paramContext[1], localNumberFormatException2);
    }
    return null;
  }
  
  private static boolean d(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow();
      Window.class.getMethod("addExtraFlags", new Class[] { Integer.TYPE }).invoke(paramActivity, new Object[] { Integer.valueOf(768) });
      if (bdnw.a()) {
        bdnw.b("LiuHaiUtils", "enableXiaoMiNotch true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (bdnw.a()) {
        bdnw.d("LiuHaiUtils", "enableXiaoMiNotch Exception", paramActivity);
      }
    }
    return false;
  }
  
  private static boolean d(Context paramContext)
  {
    boolean bool1;
    if (Build.MODEL.equals("PAAM00")) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
      bool1 = bool2;
    } while (!bdnw.a());
    bdnw.b("LiuHaiUtils", "oppoHasNotchInScreen exits:" + bool2);
    return bool2;
  }
  
  private static int[] d(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    int i = paramContext.getResources().getIdentifier("notch_width", "dimen", "android");
    if (bdnw.a()) {
      bdnw.b("LiuHaiUtils", "xiaomiGetNotchSize [notch_width]resourceId: " + i);
    }
    if (i > 0) {
      arrayOfInt[0] = paramContext.getResources().getDimensionPixelSize(i);
    }
    i = paramContext.getResources().getIdentifier("notch_height", "dimen", "android");
    if (bdnw.a()) {
      bdnw.b("LiuHaiUtils", "xiaomiGetNotchSize [notch_height]resourceId: " + i);
    }
    if (i > 0) {
      arrayOfInt[1] = paramContext.getResources().getDimensionPixelSize(i);
    }
    if (bdnw.a()) {
      bdnw.b("LiuHaiUtils", "xiaomiGetNotchSize width: " + arrayOfInt[0] + " height:" + arrayOfInt[1]);
    }
    return arrayOfInt;
  }
  
  private static boolean e(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      paramActivity.setSystemUiVisibility(0x80 | paramActivity.getSystemUiVisibility());
      if (bdnw.a()) {
        bdnw.b("LiuHaiUtils", "enableMeizuNotch true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (bdnw.a()) {
        bdnw.d("LiuHaiUtils", "enableMeizuNotch Exception", paramActivity);
      }
    }
    return false;
  }
  
  @TargetApi(17)
  private static boolean e(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        i = Settings.Global.getInt(paramContext.getContentResolver(), "force_black", 0);
        if (i == 1)
        {
          if (!bdnw.a()) {
            break label127;
          }
          bdnw.b("LiuHaiUtils", "xiaomiHasNotchInScreen closed: " + i);
          return false;
        }
        i = a("ro.miui.notch", 0);
        if (bdnw.a()) {
          bdnw.b("LiuHaiUtils", "xiaomiHasNotchInScreen isNotch: " + i);
        }
        if (i != 1) {
          break label127;
        }
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      int i;
      while (bdnw.a())
      {
        bdnw.b("LiuHaiUtils", "xiaomiHasNotchInScreen crash: ", paramContext);
        return false;
        i = 0;
      }
    }
    label127:
    return false;
  }
  
  private static boolean f(Activity paramActivity)
  {
    return i(paramActivity);
  }
  
  private static boolean g(Activity paramActivity)
  {
    boolean bool = true;
    if ((paramActivity == null) || (paramActivity.getWindow() == null))
    {
      if (bdnw.a()) {
        bdnw.b("LiuHaiUtils", "enableHuaWeiNotch invalid param");
      }
      bool = false;
    }
    for (;;)
    {
      return bool;
      Object localObject = paramActivity.getWindow().getAttributes();
      try
      {
        paramActivity = Class.forName("com.huawei.android.view.LayoutParamsEx");
        localObject = paramActivity.getConstructor(new Class[] { WindowManager.LayoutParams.class }).newInstance(new Object[] { localObject });
        paramActivity.getMethod("addHwFlags", new Class[] { Integer.TYPE }).invoke(localObject, new Object[] { Integer.valueOf(65536) });
        if (bdnw.a())
        {
          bdnw.b("LiuHaiUtils", "enableHuaWeiNotch true");
          return true;
        }
      }
      catch (Exception paramActivity)
      {
        if (bdnw.a()) {
          bdnw.d("LiuHaiUtils", "enableHuaWeiNotch Exception", paramActivity);
        }
      }
    }
    return false;
  }
  
  private static boolean h(Activity paramActivity)
  {
    boolean bool = true;
    String str = "" + Build.MANUFACTURER;
    if (str.equalsIgnoreCase("HUAWEI")) {
      bool = g(paramActivity);
    }
    do
    {
      do
      {
        return bool;
        if (!str.equalsIgnoreCase("OPPO")) {
          break;
        }
      } while (!bdnw.a());
      bdnw.b("LiuHaiUtils", "enableNotchInScreen_AndroidO OPPO=true");
      return true;
      if (!str.equalsIgnoreCase("VIVO")) {
        break;
      }
    } while (!bdnw.a());
    bdnw.b("LiuHaiUtils", "enableNotchInScreen_AndroidO VIVO=true");
    return true;
    if (str.equalsIgnoreCase("XIAOMI")) {
      return d(paramActivity);
    }
    if (str.equalsIgnoreCase("SAMSUNG")) {
      return f(paramActivity);
    }
    if (str.equalsIgnoreCase("Meizu")) {
      return e(paramActivity);
    }
    return false;
  }
  
  private static boolean i(Activity paramActivity)
  {
    WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
    try
    {
      Field localField = localLayoutParams.getClass().getField("layoutInDisplayCutoutMode");
      localField.setAccessible(true);
      localField.setInt(localLayoutParams, 1);
      paramActivity.getWindow().setAttributes(localLayoutParams);
      if (bdnw.a()) {
        bdnw.b("LiuHaiUtils", "enableNotchInScreen_AndroidP true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (bdnw.a()) {
        bdnw.d("LiuHaiUtils", "enableNotchInScreen_AndroidP Exception");
      }
    }
    return false;
  }
  
  private static boolean j(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (bdnw.a()) {
      bdnw.b("LiuHaiUtils", "enableNotchInScreen apiVersion: " + i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdyu
 * JD-Core Version:    0.7.0.1
 */