package com.tencent.biz.qqcircle.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class QCircleLiuHaiUtils
{
  public static final ArrayList<String> a = new ArrayList();
  public static boolean b = false;
  public static boolean c = false;
  public static boolean d = false;
  public static int e = 0;
  private static String[] f;
  private static String[] g;
  
  static
  {
    a.add("SHARP_FS8010".toLowerCase());
    f = new String[] { "PAAM00", "Lenovo L78011", "Pixel 3 XL", "SM-G9750", "N5207", "V1932A" };
    g = new String[] { "HUAWEI", "OPPO", "VIVO", "XIAOMI" };
  }
  
  public static int a()
  {
    return e;
  }
  
  private static int a(String paramString, int paramInt)
  {
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      if (localObject != null)
      {
        localObject = ((Class)localObject).getMethod("getInt", new Class[] { String.class, Integer.TYPE });
        if (localObject != null)
        {
          paramString = ((Method)localObject).invoke(null, new Object[] { paramString, Integer.valueOf(paramInt) });
          if ((paramString instanceof Integer))
          {
            int i = ((Integer)paramString).intValue();
            return i;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSystemPropertyForXiaomi() Exception=");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.d("LiuHaiUtils", 2, ((StringBuilder)localObject).toString());
      }
    }
    return paramInt;
  }
  
  public static boolean a(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "hasNotchInScreen_AndroidP decorView=null");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        paramActivity = paramActivity.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(paramActivity, new Object[0]);
        if (paramActivity == null)
        {
          if (!QLog.isColorLevel()) {
            break label158;
          }
          QLog.i("LiuHaiUtils", 1, "hasNotchInScreen_AndroidP getRootWindowInsets inserts=null");
          return false;
        }
        if (paramActivity.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(paramActivity, new Object[0]) == null) {
          break label160;
        }
        bool = true;
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("hasNotchInScreen_AndroidP getDisplayCutout  exists:");
          paramActivity.append(bool);
          QLog.i("LiuHaiUtils", 1, paramActivity.toString());
        }
        return bool;
      }
      catch (Exception paramActivity)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.e("LiuHaiUtils", 1, "hasNotchInScreen_AndroidP Exception");
      }
      return false;
      label158:
      return false;
      label160:
      boolean bool = false;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    boolean bool3;
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.util.FtFeature");
      bool1 = bool2;
      bool2 = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(32) })).booleanValue();
      bool1 = bool2;
      bool3 = bool2;
      if (QLog.isColorLevel())
      {
        bool1 = bool2;
        paramContext = new StringBuilder();
        bool1 = bool2;
        paramContext.append("vivoHasNotchInScreen ret=");
        bool1 = bool2;
        paramContext.append(bool2);
        bool1 = bool2;
        QLog.i("LiuHaiUtils", 1, paramContext.toString());
        return bool2;
      }
    }
    catch (Exception paramContext)
    {
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.e("LiuHaiUtils", 1, "vivoHasNotchInScreen Exception", paramContext);
        bool3 = bool1;
      }
    }
    return bool3;
  }
  
  public static int b(Activity paramActivity)
  {
    int i = b(paramActivity);
    paramActivity = paramActivity.getWindow().getDecorView();
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP decorView=null ");
      }
      return i;
    }
    try
    {
      paramActivity = paramActivity.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(paramActivity, new Object[0]);
      if (paramActivity == null)
      {
        if (!QLog.isColorLevel()) {
          return i;
        }
        QLog.i("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP getRootWindowInsets inserts=null ");
        return i;
      }
      paramActivity = paramActivity.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(paramActivity, new Object[0]);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNotchInScreenHeight_AndroidP getDisplayCutout cutOut=");
        localStringBuilder.append(paramActivity);
        QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
      }
      if (paramActivity == null) {
        break label219;
      }
      int j = ((Integer)paramActivity.getClass().getMethod("getSafeInsetTop", new Class[0]).invoke(paramActivity, new Object[0])).intValue();
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("getNotchInScreenHeight_AndroidP top:");
        paramActivity.append(j);
        QLog.i("LiuHaiUtils", 1, paramActivity.toString());
      }
      return j;
    }
    catch (Exception paramActivity)
    {
      label205:
      label219:
      break label205;
    }
    if (QLog.isColorLevel()) {
      QLog.e("LiuHaiUtils", 1, "getNotchInScreenHeight_AndroidP Exception");
    }
    return i;
    return i;
  }
  
  public static int b(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
  
  private static boolean b()
  {
    String str = Build.MODEL;
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = f;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (str.equalsIgnoreCase(arrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static int c(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNotchInScreenHeight apiVersion: ");
      localStringBuilder.append(i);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    int j = b(paramActivity);
    if (j <= 0)
    {
      if (i > 27) {
        return b(paramActivity);
      }
      return d(paramActivity);
    }
    return j;
  }
  
  public static boolean c(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (((String)localObject).equalsIgnoreCase("HUAWEI")) {
      return e(paramContext);
    }
    if (((String)localObject).equalsIgnoreCase("OPPO")) {
      return g(paramContext);
    }
    if (((String)localObject).equalsIgnoreCase("VIVO")) {
      return a(paramContext);
    }
    if (((String)localObject).equalsIgnoreCase("XIAOMI")) {
      return i(paramContext);
    }
    return false;
  }
  
  public static int d(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    String str = ((StringBuilder)localObject).toString();
    boolean bool = str.equalsIgnoreCase("HUAWEI");
    localObject = null;
    if (bool) {
      localObject = f(paramContext);
    } else if (str.equalsIgnoreCase("OPPO")) {
      localObject = h(paramContext);
    } else if ((!str.equalsIgnoreCase("VIVO")) && (str.equalsIgnoreCase("XIAOMI"))) {
      localObject = j(paramContext);
    }
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject[0];
    } else {
      i = 0;
    }
    if (localObject != null) {
      j = localObject[1];
    }
    int k = b(paramContext);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getNotchInScreenHeight manufacturer:");
      paramContext.append(Build.MANUFACTURER);
      paramContext.append(" height:");
      paramContext.append(j);
      paramContext.append(" width:");
      paramContext.append(i);
      paramContext.append(" status:");
      paramContext.append(k);
      QLog.e("LiuHaiUtils", 1, paramContext.toString());
    }
    return Math.max(j, k);
  }
  
  public static boolean d(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableNotch apiVersion: ");
      localStringBuilder.append(i);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i > 27) {
      return l(paramActivity);
    }
    return k(paramActivity);
  }
  
  public static void e(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("initLiuHaiBarHeight manufacturer:");
      localStringBuilder1.append(Build.MANUFACTURER);
      localStringBuilder1.append(" mHasInitHasNotch:");
      localStringBuilder1.append(c);
      localStringBuilder1.append(" mHasNotch:");
      localStringBuilder1.append(d);
      localStringBuilder1.append(" mNotchHeight:");
      localStringBuilder1.append(e);
      QLog.e("LiuHaiUtils", 1, localStringBuilder1.toString());
    }
    if (!c)
    {
      d = false;
      try
      {
        d = f(paramActivity);
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("initLiuHaiProperty manufacturer:");
          localStringBuilder2.append(Build.MANUFACTURER);
          QLog.e("LiuHaiUtils", 1, localStringBuilder2.toString(), localThrowable);
        }
      }
      if (d) {
        e = c(paramActivity);
      }
      c = true;
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("initLiuHaiBarHeight[after] manufacturer:");
      paramActivity.append(Build.MANUFACTURER);
      paramActivity.append(" mHasInitHasNotch:");
      paramActivity.append(c);
      paramActivity.append(" mHasNotch:");
      paramActivity.append(d);
      paramActivity.append(" mNotchHeight:");
      paramActivity.append(e);
      QLog.e("LiuHaiUtils", 1, paramActivity.toString());
    }
  }
  
  private static boolean e(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool6 = false;
    boolean bool1 = false;
    boolean bool3 = bool1;
    boolean bool4 = bool2;
    boolean bool5 = bool6;
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      bool3 = bool1;
      bool4 = bool2;
      bool5 = bool6;
      bool1 = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      bool2 = bool1;
      bool3 = bool1;
      bool4 = bool1;
      bool5 = bool1;
      if (!QLog.isColorLevel()) {
        break label205;
      }
      bool3 = bool1;
      bool4 = bool1;
      bool5 = bool1;
      paramContext = new StringBuilder();
      bool3 = bool1;
      bool4 = bool1;
      bool5 = bool1;
      paramContext.append("hwHasNotchInScreen ret=");
      bool3 = bool1;
      bool4 = bool1;
      bool5 = bool1;
      paramContext.append(bool1);
      bool3 = bool1;
      bool4 = bool1;
      bool5 = bool1;
      QLog.i("LiuHaiUtils", 1, paramContext.toString());
      return bool1;
    }
    catch (ClassNotFoundException paramContext)
    {
      break label186;
    }
    catch (NoSuchMethodException paramContext)
    {
      break label165;
    }
    catch (Exception paramContext)
    {
      label144:
      break label144;
    }
    bool2 = bool5;
    if (QLog.isColorLevel())
    {
      QLog.e("LiuHaiUtils", 1, "hwHasNotchInScreen Exception");
      return bool5;
      label165:
      bool2 = bool4;
      if (QLog.isColorLevel())
      {
        QLog.e("LiuHaiUtils", 1, "hwHasNotchInScreen NoSuchMethodException");
        return bool4;
        label186:
        bool2 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.e("LiuHaiUtils", 1, "hwHasNotchInScreen ClassNotFoundException");
          bool2 = bool3;
        }
      }
    }
    label205:
    return bool2;
  }
  
  private static boolean f(Activity paramActivity)
  {
    boolean bool1 = false;
    b = false;
    int i = Build.VERSION.SDK_INT;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasNotchInScreen version: ");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localObject);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i < 26) {
      return false;
    }
    if (i > 27) {
      bool1 = a(paramActivity);
    }
    if ((!bool1) && (i >= 26)) {
      bool1 = c(paramActivity);
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("hasNotchInScreen manufacturer = ");
      paramActivity.append(Build.MANUFACTURER);
      paramActivity.append(" ,brand = ");
      paramActivity.append(Build.BRAND);
      paramActivity.append(" ,model = ");
      paramActivity.append(Build.MODEL);
      QLog.i("LiuHaiUtils", 1, paramActivity.toString());
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (b()) {
        bool2 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("hasNotchInScreen haveNotch: ");
      paramActivity.append(bool2);
      QLog.i("LiuHaiUtils", 1, paramActivity.toString());
    }
    return bool2;
  }
  
  private static int[] f(Context paramContext)
  {
    Object localObject = new int[2];
    Object tmp5_4 = localObject;
    tmp5_4[0] = 0;
    Object tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      paramContext = (int[])paramContext.getMethod("getNotchSize", new Class[0]).invoke(paramContext, new Object[0]);
      localObject = paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      break label144;
    }
    catch (NoSuchMethodException paramContext)
    {
      label144:
      label146:
      label165:
      break label123;
    }
    catch (Exception paramContext)
    {
      label93:
      label96:
      label99:
      label102:
      label104:
      label123:
      label125:
      break label102;
    }
    try
    {
      if (!QLog.isColorLevel()) {
        break label165;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hwGetNotchSize ret=");
      ((StringBuilder)localObject).append(paramContext);
      QLog.i("LiuHaiUtils", 1, ((StringBuilder)localObject).toString());
      return paramContext;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label99;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label96;
    }
    catch (Exception localException)
    {
      break label93;
    }
    break label104;
    break label125;
    break label146;
    paramContext = (Context)localObject;
    localObject = paramContext;
    if (QLog.isColorLevel())
    {
      QLog.e("LiuHaiUtils", 1, "hasNotchInScreen Exception");
      return paramContext;
      paramContext = (Context)localObject;
      localObject = paramContext;
      if (QLog.isColorLevel())
      {
        QLog.e("LiuHaiUtils", 1, "hwGetNotchSize NoSuchMethodException");
        return paramContext;
        paramContext = (Context)localObject;
        localObject = paramContext;
        if (QLog.isColorLevel())
        {
          QLog.e("LiuHaiUtils", 1, "hwGetNotchSize ClassNotFoundException");
          localObject = paramContext;
        }
      }
    }
    return localObject;
  }
  
  private static boolean g(Activity paramActivity)
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
  
  private static boolean g(Context paramContext)
  {
    if (Build.MODEL.equals("PAAM00")) {
      return true;
    }
    if (paramContext == null) {
      return false;
    }
    boolean bool = paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("oppoHasNotchInScreen exits:");
      paramContext.append(bool);
      QLog.i("LiuHaiUtils", 1, paramContext.toString());
    }
    return bool;
  }
  
  private static boolean h(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      paramActivity.setSystemUiVisibility(paramActivity.getSystemUiVisibility() | 0x80);
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
  
  private static int[] h(Context paramContext)
  {
    if (TextUtils.isEmpty(null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "oppoGetNotchSize mProperty empty");
      }
      return null;
    }
    throw new NullPointerException();
  }
  
  private static boolean i(Activity paramActivity)
  {
    return l(paramActivity);
  }
  
  @TargetApi(17)
  private static boolean i(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 17) {
          break label165;
        }
        i = Settings.Global.getInt(paramContext.getContentResolver(), "force_black", 0);
        if (i == 1)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          paramContext = new StringBuilder();
          paramContext.append("xiaomiHasNotchInScreen closed: ");
          paramContext.append(i);
          QLog.i("LiuHaiUtils", 1, paramContext.toString());
          return false;
        }
        i = a("ro.miui.notch", 0);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("xiaomiHasNotchInScreen isNotch: ");
          paramContext.append(i);
          QLog.i("LiuHaiUtils", 1, paramContext.toString());
        }
        if (i == 1) {
          return true;
        }
      }
      catch (Throwable paramContext)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("xiaomiHasNotchInScreen crash: ");
          localStringBuilder.append(paramContext.getMessage());
          QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
        }
      }
      return false;
      label165:
      int i = 0;
    }
    return false;
  }
  
  private static boolean j(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null))
    {
      Object localObject = paramActivity.getWindow().getAttributes();
      try
      {
        paramActivity = Class.forName("com.huawei.android.view.LayoutParamsEx");
        localObject = paramActivity.getConstructor(new Class[] { WindowManager.LayoutParams.class }).newInstance(new Object[] { localObject });
        paramActivity.getMethod("addHwFlags", new Class[] { Integer.TYPE }).invoke(localObject, new Object[] { Integer.valueOf(65536) });
        if (QLog.isColorLevel()) {
          QLog.i("LiuHaiUtils", 1, "enableHuaWeiNotch true");
        }
        return true;
      }
      catch (Exception paramActivity)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiuHaiUtils", 1, "enableHuaWeiNotch Exception", paramActivity);
        }
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("LiuHaiUtils", 1, "enableHuaWeiNotch invalid param");
    }
    return false;
  }
  
  private static int[] j(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    int i = paramContext.getResources().getIdentifier("notch_width", "dimen", "android");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xiaomiGetNotchSize [notch_width]resourceId: ");
      localStringBuilder.append(i);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i > 0) {
      arrayOfInt[0] = paramContext.getResources().getDimensionPixelSize(i);
    }
    i = paramContext.getResources().getIdentifier("notch_height", "dimen", "android");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("xiaomiGetNotchSize [notch_height]resourceId: ");
      localStringBuilder.append(i);
      QLog.i("LiuHaiUtils", 1, localStringBuilder.toString());
    }
    if (i > 0) {
      arrayOfInt[1] = paramContext.getResources().getDimensionPixelSize(i);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("xiaomiGetNotchSize width: ");
      paramContext.append(arrayOfInt[0]);
      paramContext.append(" height:");
      paramContext.append(arrayOfInt[1]);
      QLog.i("LiuHaiUtils", 1, paramContext.toString());
    }
    return arrayOfInt;
  }
  
  private static boolean k(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    localObject = ((StringBuilder)localObject).toString();
    if (((String)localObject).equalsIgnoreCase("HUAWEI")) {
      return j(paramActivity);
    }
    if (((String)localObject).equalsIgnoreCase("OPPO"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "enableNotchInScreen_AndroidO OPPO=true");
      }
      return true;
    }
    if (((String)localObject).equalsIgnoreCase("VIVO"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiuHaiUtils", 1, "enableNotchInScreen_AndroidO VIVO=true");
      }
      return true;
    }
    if (((String)localObject).equalsIgnoreCase("XIAOMI")) {
      return g(paramActivity);
    }
    if (((String)localObject).equalsIgnoreCase("SAMSUNG")) {
      return i(paramActivity);
    }
    if (((String)localObject).equalsIgnoreCase("Meizu")) {
      return h(paramActivity);
    }
    return false;
  }
  
  private static boolean l(Activity paramActivity)
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
      label55:
      break label55;
    }
    if (QLog.isColorLevel()) {
      QLog.e("LiuHaiUtils", 1, "enableNotchInScreen_AndroidP Exception");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleLiuHaiUtils
 * JD-Core Version:    0.7.0.1
 */