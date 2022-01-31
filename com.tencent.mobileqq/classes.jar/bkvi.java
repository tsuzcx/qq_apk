import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemProperties;
import android.provider.Settings.Global;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class bkvi
{
  public static int a;
  public static final ArrayList<String> a;
  public static boolean a;
  private static String[] a;
  public static int b;
  public static boolean b;
  private static String[] b;
  public static int c;
  public static boolean c;
  public static int d;
  public static boolean d;
  public static int e;
  public static boolean e;
  public static final int f;
  public static boolean f;
  public static int g;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add("SHARP_FS8010".toLowerCase());
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "PAAM00" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "HUAWEI", "OPPO", "VIVO", "XIAOMI" };
    jdField_f_of_type_Int = bbll.a(66.0F);
  }
  
  public static int a()
  {
    return g;
  }
  
  public static int a(Activity paramActivity)
  {
    int j = a(paramActivity);
    paramActivity = paramActivity.getWindow().getDecorView();
    int i;
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP decorView=null ");
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
          if (!QLog.isColorLevel()) {
            return j;
          }
          QLog.i("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP getRootWindowInsets inserts=null ");
          return j;
        }
        paramActivity = paramActivity.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(paramActivity, new Object[0]);
        if (QLog.isColorLevel()) {
          QLog.i("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP getDisplayCutout cutOut=" + paramActivity);
        }
        if (paramActivity != null)
        {
          int k = ((Integer)paramActivity.getClass().getMethod("getSafeInsetTop", new Class[0]).invoke(paramActivity, new Object[0])).intValue();
          i = k;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP top:" + k);
          return k;
        }
      }
      catch (Exception paramActivity)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP Exception");
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
      } while (!QLog.isColorLevel());
      QLog.d("LiuHaiUtils", 2, "getSystemPropertyForXiaomi() Exception=" + paramString.getMessage());
    }
    return i;
    return paramInt;
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Int = 0;
    jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "resetAllLiuHaiStatus!");
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LiuHaiUtils", 1, "initLiuHaiProperty manufacturer:" + Build.MANUFACTURER + " hasInitHasNotch:" + jdField_c_of_type_Boolean + " sHasNotch:" + jdField_a_of_type_Boolean + " sEnableNotchOK:" + jdField_b_of_type_Boolean + " sNotchHeight:" + jdField_a_of_type_Int);
    }
    if (!jdField_c_of_type_Boolean)
    {
      jdField_b_of_type_Int = muc.b(BaseApplicationImpl.getApplication());
      jdField_c_of_type_Int = muc.a(BaseApplicationImpl.getApplication());
      jdField_a_of_type_Boolean = false;
    }
    try
    {
      jdField_a_of_type_Boolean = d(paramActivity);
      if (jdField_a_of_type_Boolean) {
        jdField_a_of_type_Int = b(paramActivity);
      }
      jdField_c_of_type_Boolean = true;
      jdField_b_of_type_Boolean = false;
      if (jdField_a_of_type_Boolean)
      {
        jdField_b_of_type_Boolean = k(paramActivity);
        if (jdField_a_of_type_Int <= 0) {
          jdField_b_of_type_Boolean = false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("LiuHaiUtils", 1, "initLiuHaiProperty[after] manufacturer:" + Build.MANUFACTURER + " hasInitHasNotch:" + jdField_c_of_type_Boolean + " sHasNotch:" + jdField_a_of_type_Boolean + " sEnableNotchOK:" + jdField_b_of_type_Boolean + " sNotchHeight:" + jdField_a_of_type_Int);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiuHaiUtils", 1, "initLiuHaiProperty manufacturer:" + Build.MANUFACTURER, localThrowable);
        }
      }
    }
  }
  
  public static boolean a()
  {
    String str = (Build.MANUFACTURER + "_" + Build.MODEL).toLowerCase();
    return jdField_a_of_type_JavaUtilArrayList.contains(str);
  }
  
  public static boolean a(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    if (paramActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "hasNotchInScreen_AndroidP decorView=null");
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
            break label90;
          }
          if (QLog.isColorLevel())
          {
            QLog.i("LiuHaiUtils", 1, "hasNotchInScreen_AndroidP getRootWindowInsets inserts=null");
            return false;
          }
        }
        catch (Exception paramActivity) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("LiuHaiUtils", 1, "hasNotchInScreen_AndroidP Exception");
    return false;
    label90:
    if (paramActivity.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(paramActivity, new Object[0]) != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "hasNotchInScreen_AndroidP getDisplayCutout  exists:" + bool);
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
          if (QLog.isColorLevel())
          {
            QLog.i("LiuHaiUtils", 1, "vivoHasNotchInScreen ret=" + bool1);
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
    } while (!QLog.isColorLevel());
    QLog.e("LiuHaiUtils", 1, "vivoHasNotchInScreen Exception", paramContext);
    return bool1;
  }
  
  public static boolean a(View paramView1, View paramView2, int paramInt)
  {
    if (paramView2 != null)
    {
      if (!b())
      {
        if (paramView1 != null) {
          paramView1.setVisibility(8);
        }
        paramView2.setVisibility(8);
        return false;
      }
      ViewGroup.LayoutParams localLayoutParams;
      if (paramView1 != null)
      {
        localLayoutParams = paramView1.getLayoutParams();
        localLayoutParams.height = jdField_a_of_type_Int;
        paramView1.setLayoutParams(localLayoutParams);
        if (paramView1.getVisibility() != 0) {
          paramView1.setVisibility(0);
        }
      }
      int j = bbll.a();
      int i = bbll.b();
      int k = (int)(j / 9.0F * 16.0F);
      j = i - k - jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "initLiuHaiScreenUI_Common manufacturer:" + Build.MANUFACTURER + " version:" + Build.VERSION.SDK_INT + " remainedPixel:" + j + " srcHeight:" + i + " sNotchHeight:" + jdField_a_of_type_Int + " BOTTOM_HEIGHT_LH: " + jdField_f_of_type_Int + " surfaceMaxHeight:" + k);
      }
      if (j > jdField_f_of_type_Int)
      {
        i = j - paramInt;
        j = (int)(jdField_f_of_type_Int * 1.2F);
        if (QLog.isColorLevel()) {
          QLog.e("LiuHaiUtils", 1, "initLiuHaiScreenUI_Common manufacturer:" + Build.MANUFACTURER + " limitMaxBottom:" + j + " remainedPixel:" + i + " sForceCenter_16_9:" + true);
        }
        paramInt = i;
        if (i > j)
        {
          paramInt = (i - jdField_f_of_type_Int) / 2;
          jdField_d_of_type_Int = paramInt;
          if (paramView1 != null)
          {
            localLayoutParams = paramView1.getLayoutParams();
            localLayoutParams.height = (jdField_a_of_type_Int + paramInt);
            paramView1.setLayoutParams(localLayoutParams);
          }
          paramInt += jdField_f_of_type_Int;
        }
        paramView1 = paramView2.getLayoutParams();
        paramView1.height = paramInt;
        paramView2.setLayoutParams(paramView1);
        jdField_e_of_type_Int = paramInt;
        if (paramView2.getVisibility() != 0) {
          paramView2.setVisibility(0);
        }
        return true;
      }
      paramInt = Math.abs(j - jdField_f_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.e("LiuHaiUtils", 1, "initLiuHaiScreenUI_Common manufacturer:" + Build.MANUFACTURER + " sIsIrregularScreen:" + jdField_d_of_type_Boolean + " remainedPixel:" + j + " diffPixels: " + paramInt);
      }
      if (paramInt < 5)
      {
        paramView1 = paramView2.getLayoutParams();
        paramView1.height = j;
        paramView2.setLayoutParams(paramView1);
        jdField_e_of_type_Int = j;
        if (paramView2.getVisibility() != 0)
        {
          paramView2.setVisibility(0);
          return true;
        }
      }
      else
      {
        if (jdField_d_of_type_Boolean)
        {
          paramView2.setVisibility(8);
          return false;
        }
        paramView1 = paramView2.getLayoutParams();
        paramView1.height = jdField_f_of_type_Int;
        paramView2.setLayoutParams(paramView1);
        jdField_e_of_type_Int = jdField_f_of_type_Int;
        if (paramView2.getVisibility() != 0) {
          paramView2.setVisibility(0);
        }
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(WindowManager.LayoutParams paramLayoutParams)
  {
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "enableNotch apiVersion: " + i);
    }
    if (i > 27) {
      return c(paramLayoutParams);
    }
    return b(paramLayoutParams);
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
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "getRealDisplay manufacturer:" + Build.MANUFACTURER + " version:" + Build.VERSION.SDK_INT + " width:" + paramContext.widthPixels + " height:" + paramContext.heightPixels);
      }
      return new int[] { paramContext.widthPixels, paramContext.heightPixels };
    }
    boolean bool = bfyf.a(paramContext);
    if (bool) {}
    for (int i = bfyf.a(paramContext);; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "getRealDisplay[none] manufacturer:" + Build.MANUFACTURER + " width:" + localDisplayMetrics.widthPixels + " height:" + localDisplayMetrics.heightPixels + " mNavigationBarHeight:" + i + " hasNavBar:" + bool);
      }
      return new int[] { localDisplayMetrics.widthPixels, i + localDisplayMetrics.heightPixels };
    }
  }
  
  public static int b(Activity paramActivity)
  {
    int k = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "getNotchInScreenHeight apiVersion: " + k);
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
        if (QLog.isColorLevel()) {
          QLog.e("LiuHaiUtils", 1, "getNotchInScreenHeight manufacturer:" + Build.MANUFACTURER + " height:" + j + " width:" + i + " status:" + k);
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
          break label196;
        }
        localObject = d(paramContext);
        break;
      }
      label196:
      localObject = null;
    }
  }
  
  public static void b(Activity paramActivity)
  {
    paramActivity.getWindow().clearFlags(1024);
    paramActivity.getWindow().addFlags(2048);
    paramActivity.getWindow().addFlags(256);
    paramActivity.getWindow().clearFlags(512);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      paramActivity.setSystemUiVisibility(paramActivity.getSystemUiVisibility() & 0xFFFFFFFB);
    }
  }
  
  public static boolean b()
  {
    return (jdField_a_of_type_Boolean) && (jdField_b_of_type_Boolean) && (jdField_a_of_type_Int > 0);
  }
  
  public static boolean b(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    String str = "" + Build.MANUFACTURER;
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "hasNotchInScreenByVersion version: " + i + " " + str);
    }
    boolean bool = false;
    if (i > 27) {
      bool = a(paramActivity);
    }
    while (i < 26) {
      return bool;
    }
    return b(paramActivity);
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
  
  private static boolean b(WindowManager.LayoutParams paramLayoutParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiuHaiUtils", 2, "color note androidO notch screen compat");
    }
    return true;
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
    //   15: invokevirtual 275	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   18: ldc_w 476
    //   21: invokevirtual 282	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   24: astore_0
    //   25: aload_0
    //   26: ldc_w 478
    //   29: iconst_0
    //   30: anewarray 103	java/lang/Class
    //   33: invokevirtual 107	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   36: aload_0
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokevirtual 113	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 480	[I
    //   47: checkcast 480	[I
    //   50: astore_0
    //   51: aload_0
    //   52: astore_1
    //   53: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +31 -> 87
    //   59: ldc 89
    //   61: iconst_1
    //   62: new 119	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 482
    //   72: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_0
    //   86: astore_1
    //   87: aload_1
    //   88: areturn
    //   89: astore_0
    //   90: aload_1
    //   91: astore_0
    //   92: aload_0
    //   93: astore_1
    //   94: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq -10 -> 87
    //   100: ldc 89
    //   102: iconst_1
    //   103: ldc_w 484
    //   106: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: areturn
    //   111: astore_0
    //   112: aload_1
    //   113: astore_0
    //   114: aload_0
    //   115: astore_1
    //   116: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq -32 -> 87
    //   122: ldc 89
    //   124: iconst_1
    //   125: ldc_w 486
    //   128: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_0
    //   132: areturn
    //   133: astore_0
    //   134: aload_1
    //   135: astore_0
    //   136: aload_0
    //   137: astore_1
    //   138: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -54 -> 87
    //   144: ldc 89
    //   146: iconst_1
    //   147: ldc_w 488
    //   150: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_0
    //   154: areturn
    //   155: astore_1
    //   156: goto -20 -> 136
    //   159: astore_1
    //   160: goto -46 -> 114
    //   163: astore_1
    //   164: goto -72 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramContext	Context
    //   3	135	1	localObject	Object
    //   155	1	1	localException	Exception
    //   159	1	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   163	1	1	localClassNotFoundException	java.lang.ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   14	51	89	java/lang/ClassNotFoundException
    //   14	51	111	java/lang/NoSuchMethodException
    //   14	51	133	java/lang/Exception
    //   53	85	155	java/lang/Exception
    //   53	85	159	java/lang/NoSuchMethodException
    //   53	85	163	java/lang/ClassNotFoundException
  }
  
  public static void c(Activity paramActivity)
  {
    paramActivity.getWindow().clearFlags(2048);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.getWindow().addFlags(256);
    paramActivity.getWindow().addFlags(512);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      paramActivity.setSystemUiVisibility(paramActivity.getSystemUiVisibility() | 0x4);
    }
  }
  
  public static boolean c()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean c(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "enableNotch apiVersion: " + i);
    }
    if (i > 27) {
      return j(paramActivity);
    }
    return i(paramActivity);
  }
  
  /* Error */
  private static boolean c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 275	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   4: ldc_w 476
    //   7: invokevirtual 282	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   10: astore_0
    //   11: aload_0
    //   12: ldc_w 495
    //   15: iconst_0
    //   16: anewarray 103	java/lang/Class
    //   19: invokevirtual 107	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   22: aload_0
    //   23: iconst_0
    //   24: anewarray 4	java/lang/Object
    //   27: invokevirtual 113	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 286	java/lang/Boolean
    //   33: invokevirtual 289	java/lang/Boolean:booleanValue	()Z
    //   36: istore_1
    //   37: iload_1
    //   38: istore_2
    //   39: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +31 -> 73
    //   45: ldc 89
    //   47: iconst_1
    //   48: new 119	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 497
    //   58: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload_1
    //   62: invokevirtual 220	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iload_1
    //   72: istore_2
    //   73: iload_2
    //   74: ireturn
    //   75: astore_0
    //   76: iconst_0
    //   77: istore_1
    //   78: iload_1
    //   79: istore_2
    //   80: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq -10 -> 73
    //   86: ldc 89
    //   88: iconst_1
    //   89: ldc_w 499
    //   92: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: iload_1
    //   96: ireturn
    //   97: astore_0
    //   98: iconst_0
    //   99: istore_1
    //   100: iload_1
    //   101: istore_2
    //   102: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq -32 -> 73
    //   108: ldc 89
    //   110: iconst_1
    //   111: ldc_w 501
    //   114: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: iload_1
    //   118: ireturn
    //   119: astore_0
    //   120: iconst_0
    //   121: istore_1
    //   122: iload_1
    //   123: istore_2
    //   124: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq -54 -> 73
    //   130: ldc 89
    //   132: iconst_1
    //   133: ldc_w 503
    //   136: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: iload_1
    //   140: ireturn
    //   141: astore_0
    //   142: goto -20 -> 122
    //   145: astore_0
    //   146: goto -46 -> 100
    //   149: astore_0
    //   150: goto -72 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramContext	Context
    //   36	104	1	bool1	boolean
    //   38	86	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   0	37	75	java/lang/ClassNotFoundException
    //   0	37	97	java/lang/NoSuchMethodException
    //   0	37	119	java/lang/Exception
    //   39	71	141	java/lang/Exception
    //   39	71	145	java/lang/NoSuchMethodException
    //   39	71	149	java/lang/ClassNotFoundException
  }
  
  private static boolean c(WindowManager.LayoutParams paramLayoutParams)
  {
    try
    {
      Field localField = paramLayoutParams.getClass().getField("layoutInDisplayCutoutMode");
      localField.setAccessible(true);
      localField.setInt(paramLayoutParams, 1);
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "enableNotchInScreen_AndroidP true");
      }
      return true;
    }
    catch (Exception paramLayoutParams)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LiuHaiUtils", 1, "enableNotchInScreen_AndroidP Exception");
      }
    }
    return false;
  }
  
  private static int[] c(Context paramContext)
  {
    try
    {
      paramContext = "" + SystemProperties.get("ro.oppo.screen.heteromorphism");
      if (TextUtils.isEmpty(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.i("LiuHaiUtils", 1, "oppoGetNotchSize mProperty empty");
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
          if (QLog.isColorLevel()) {
            QLog.i("LiuHaiUtils", 1, "oppoGetNotchSize mProperty exp ", paramContext);
          }
          paramContext = null;
          continue;
          paramContext = paramContext.split(":");
          if (QLog.isColorLevel()) {
            QLog.i("LiuHaiUtils", 1, "oppoGetNotchSize mProperty values=" + paramContext);
          }
          if (paramContext.length >= 2)
          {
            String[] arrayOfString = paramContext[0].split(",");
            if (QLog.isColorLevel()) {
              QLog.i("LiuHaiUtils", 1, "oppoGetNotchSize mProperty values[0] size=" + arrayOfString);
            }
            if (arrayOfString.length >= 2) {
              try
              {
                int i = Integer.valueOf(arrayOfString[0]).intValue();
                int j = Integer.valueOf(arrayOfString[1]).intValue();
                if (QLog.isColorLevel()) {
                  QLog.i("LiuHaiUtils", 1, "oppoGetNotchSize mProperty values[0] left=" + i + " top=" + j);
                }
                arrayOfString = paramContext[1].split(",");
                if (QLog.isColorLevel()) {
                  QLog.i("LiuHaiUtils", 1, "oppoGetNotchSize mProperty values[1] size=" + arrayOfString);
                }
                int k;
                int m;
                if ((arrayOfString.length >= 2) && (QLog.isColorLevel())) {
                  QLog.i("LiuHaiUtils", 1, "oppoGetNotchSize values[0]=" + paramContext[0], localNumberFormatException1);
                }
              }
              catch (NumberFormatException localNumberFormatException1)
              {
                try
                {
                  k = Integer.valueOf(arrayOfString[0]).intValue();
                  m = Integer.valueOf(arrayOfString[1]).intValue();
                  if (QLog.isColorLevel()) {
                    QLog.i("LiuHaiUtils", 1, "oppoGetNotchSize mProperty values[1] right=" + k + " bottom=" + m);
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
      } while (!QLog.isColorLevel());
      QLog.i("LiuHaiUtils", 1, "oppoGetNotchSize values[1]=" + paramContext[1], localNumberFormatException2);
    }
    return null;
  }
  
  public static void d(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LiuHaiUtils", 1, "initLiuHaiBarHeight manufacturer:" + Build.MANUFACTURER + " mHasInitHasNotch:" + jdField_e_of_type_Boolean + " mHasNotch:" + jdField_f_of_type_Boolean + " mNotchHeight:" + g);
    }
    if (!jdField_e_of_type_Boolean) {
      jdField_f_of_type_Boolean = false;
    }
    try
    {
      jdField_f_of_type_Boolean = d(paramActivity);
      if (jdField_f_of_type_Boolean) {
        g = b(paramActivity);
      }
      jdField_e_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.e("LiuHaiUtils", 1, "initLiuHaiBarHeight[after] manufacturer:" + Build.MANUFACTURER + " mHasInitHasNotch:" + jdField_e_of_type_Boolean + " mHasNotch:" + jdField_f_of_type_Boolean + " mNotchHeight:" + g);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiuHaiUtils", 1, "initLiuHaiProperty manufacturer:" + Build.MANUFACTURER, localThrowable);
        }
      }
    }
  }
  
  public static boolean d()
  {
    String str = Build.MODEL.toUpperCase();
    if (TextUtils.isEmpty(str)) {}
    while ((!Build.MANUFACTURER.equalsIgnoreCase("huawei")) || ((!str.contains("RLI-AN00")) && (!str.contains("RLI-N29")) && (!str.contains("TAH-AN00")) && (!str.contains("TAH-N29")) && (!str.contains("unknownRLl")) && (!str.contains("HWTAH")))) {
      return false;
    }
    return true;
  }
  
  private static boolean d(Activity paramActivity)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    jdField_d_of_type_Boolean = false;
    int i = Build.VERSION.SDK_INT;
    String str = "" + Build.MANUFACTURER;
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "hasNotchInScreen version: " + i + " " + str);
    }
    if (i < 26) {}
    do
    {
      return bool2;
      bool2 = bool1;
      if (i > 27) {
        bool2 = a(paramActivity);
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (i >= 26) {
          bool1 = b(paramActivity);
        }
      }
      if (g())
      {
        if (QLog.isColorLevel()) {
          QLog.i("LiuHaiUtils", 1, "hasNotchInScreen manufacturer = " + Build.MANUFACTURER + " ,brand = " + Build.BRAND + " ,model = " + Build.MODEL);
        }
        return true;
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.i("LiuHaiUtils", 1, "hasNotchInScreen haveNotch: " + bool1);
    return bool1;
  }
  
  private static boolean d(Context paramContext)
  {
    if (Build.MODEL.equals("PAAM00")) {
      return true;
    }
    boolean bool = paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "oppoHasNotchInScreen exits:" + bool);
    }
    return bool;
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
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "xiaomiGetNotchSize [notch_width]resourceId: " + i);
    }
    if (i > 0) {
      arrayOfInt[0] = paramContext.getResources().getDimensionPixelSize(i);
    }
    i = paramContext.getResources().getIdentifier("notch_height", "dimen", "android");
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "xiaomiGetNotchSize [notch_height]resourceId: " + i);
    }
    if (i > 0) {
      arrayOfInt[1] = paramContext.getResources().getDimensionPixelSize(i);
    }
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "xiaomiGetNotchSize width: " + arrayOfInt[0] + " height:" + arrayOfInt[1]);
    }
    return arrayOfInt;
  }
  
  public static boolean e()
  {
    String str = Build.MODEL.toUpperCase();
    if (TextUtils.isEmpty(str)) {}
    while ((!Build.MANUFACTURER.equalsIgnoreCase("samsung")) || (!str.contains("SM-F9000"))) {
      return false;
    }
    return true;
  }
  
  private static boolean e(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow();
      Window.class.getMethod("addExtraFlags", new Class[] { Integer.TYPE }).invoke(paramActivity, new Object[] { Integer.valueOf(768) });
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "enableXiaoMiNotch true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LiuHaiUtils", 1, "enableXiaoMiNotch Exception", paramActivity);
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
          if (!QLog.isColorLevel()) {
            break label130;
          }
          QLog.i("LiuHaiUtils", 1, "xiaomiHasNotchInScreen closed: " + i);
          return false;
        }
        i = a("ro.miui.notch", 0);
        if (QLog.isColorLevel()) {
          QLog.i("LiuHaiUtils", 1, "xiaomiHasNotchInScreen isNotch: " + i);
        }
        if (i != 1) {
          break label130;
        }
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      int i;
      while (QLog.isColorLevel())
      {
        QLog.i("LiuHaiUtils", 1, "xiaomiHasNotchInScreen crash: ", paramContext);
        return false;
        i = 0;
      }
    }
    label130:
    return false;
  }
  
  public static boolean f()
  {
    return (jdField_f_of_type_Boolean) && (g > 0);
  }
  
  private static boolean f(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      paramActivity.setSystemUiVisibility(0x80 | paramActivity.getSystemUiVisibility());
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "enableMeizuNotch true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LiuHaiUtils", 1, "enableMeizuNotch Exception", paramActivity);
      }
    }
    return false;
  }
  
  private static boolean g()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (str.equalsIgnoreCase(arrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static boolean g(Activity paramActivity)
  {
    return j(paramActivity);
  }
  
  private static boolean h(Activity paramActivity)
  {
    boolean bool = true;
    if ((paramActivity == null) || (paramActivity.getWindow() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "enableHuaWeiNotch invalid param");
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
        if (QLog.isColorLevel())
        {
          QLog.i("LiuHaiUtils", 1, "enableHuaWeiNotch true");
          return true;
        }
      }
      catch (Exception paramActivity)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiuHaiUtils", 1, "enableHuaWeiNotch Exception", paramActivity);
        }
      }
    }
    return false;
  }
  
  private static boolean i(Activity paramActivity)
  {
    boolean bool = true;
    String str = "" + Build.MANUFACTURER;
    if (str.equalsIgnoreCase("HUAWEI")) {
      bool = h(paramActivity);
    }
    do
    {
      do
      {
        return bool;
        if (!str.equalsIgnoreCase("OPPO")) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("LiuHaiUtils", 1, "enableNotchInScreen_AndroidO OPPO=true");
      return true;
      if (!str.equalsIgnoreCase("VIVO")) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("LiuHaiUtils", 1, "enableNotchInScreen_AndroidO VIVO=true");
    return true;
    if (str.equalsIgnoreCase("XIAOMI")) {
      return e(paramActivity);
    }
    if (str.equalsIgnoreCase("SAMSUNG")) {
      return g(paramActivity);
    }
    if (str.equalsIgnoreCase("Meizu")) {
      return f(paramActivity);
    }
    return false;
  }
  
  private static boolean j(Activity paramActivity)
  {
    WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
    try
    {
      Field localField = localLayoutParams.getClass().getField("layoutInDisplayCutoutMode");
      localField.setAccessible(true);
      localField.setInt(localLayoutParams, 1);
      paramActivity.getWindow().setAttributes(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "enableNotchInScreen_AndroidP true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LiuHaiUtils", 1, "enableNotchInScreen_AndroidP Exception");
      }
    }
    return false;
  }
  
  private static boolean k(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "enableNotchInScreen apiVersion: " + i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkvi
 * JD-Core Version:    0.7.0.1
 */