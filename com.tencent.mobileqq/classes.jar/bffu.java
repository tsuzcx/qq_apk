import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class bffu
{
  private static float jdField_a_of_type_Float;
  public static int a;
  private static String jdField_a_of_type_JavaLangString;
  public static final boolean a;
  private static int jdField_b_of_type_Int;
  private static boolean jdField_b_of_type_Boolean;
  
  static
  {
    if (bfgw.a()) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      jdField_a_of_type_JavaLangString = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
      if (Build.VERSION.SDK_INT < 19)
      {
        jdField_a_of_type_Boolean = false;
        jdField_b_of_type_Boolean = true;
        jdField_b_of_type_Int = -1;
        jdField_a_of_type_Int = -1;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        jdField_a_of_type_JavaLangString = null;
        continue;
        String str1 = Build.MANUFACTURER.toUpperCase();
        String str2 = str1 + "-" + Build.MODEL;
        if ((str1.endsWith("BBK")) || ((str1.endsWith("VIVO")) && (Build.VERSION.SDK_INT < 20)) || (str2.equals("OPPO-3007"))) {
          jdField_a_of_type_Boolean = false;
        } else {
          jdField_a_of_type_Boolean = true;
        }
      }
    }
  }
  
  public static float a(double paramDouble)
  {
    return (float)(paramDouble / jdField_a_of_type_Float);
  }
  
  public static float a(Context paramContext)
  {
    if (jdField_a_of_type_Float != 0.0F) {
      return jdField_a_of_type_Float;
    }
    if (paramContext == null) {
      throw new IllegalArgumentException("");
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    jdField_a_of_type_Float = paramContext.density;
    return paramContext.density;
  }
  
  public static int a(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      if (((!a(paramActivity)) || (!a(paramActivity))) && (!a())) {
        break label91;
      }
    }
    label91:
    for (int i = 1;; i = 0)
    {
      int k = localDisplayMetrics.heightPixels;
      int j = k;
      if (i != 0) {
        j = k - c(paramActivity);
      }
      return j;
      localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
      break;
    }
  }
  
  public static int a(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().orientation == 2) {
      return paramContext.getResources().getDisplayMetrics().heightPixels;
    }
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private static int a(Resources paramResources, String paramString)
  {
    int i = 0;
    int j = paramResources.getIdentifier(paramString, "dimen", "android");
    if (j > 0) {
      i = paramResources.getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static int a(String paramString)
  {
    String str1 = paramString;
    try
    {
      if (paramString.length() == 4)
      {
        str1 = paramString;
        if (paramString.substring(0, 1).equals("#"))
        {
          str1 = paramString.substring(1, 2);
          String str2 = paramString.substring(2, 3);
          paramString = paramString.substring(3, 4);
          str1 = "#" + str1 + str1 + str2 + str2 + paramString + paramString;
        }
      }
      int i = Color.parseColor(str1);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString1 = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null) {
        paramActivity.getDecorView().setSystemUiVisibility(23075586);
      }
    }
  }
  
  public static void a(Window paramWindow)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      Field localField = Class.forName("com.android.internal.policy.DecorView").getDeclaredField("mSemiTransparentStatusBarColor");
      localField.setAccessible(true);
      localField.setInt(paramWindow.getDecorView(), 0);
      return;
    }
    catch (Exception paramWindow)
    {
      besl.b("DisplayUtil", "反射修改状态栏颜色失败");
    }
  }
  
  public static void a(Window paramWindow, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = Build.MANUFACTURER + Build.MODEL;
      besl.b("DisplayUtil", "MANUFACTURER = " + Build.MANUFACTURER + ", MODEL = " + Build.MODEL);
      if ((str != null) && ((str.equals("MeizuPRO 7-S")) || (str.equalsIgnoreCase("MeizuM711C")))) {
        a(paramWindow);
      }
    }
    else
    {
      return;
    }
    b(paramWindow);
  }
  
  public static boolean a()
  {
    String str = a("ro.build.display.id", "");
    if (("Flyme 7.1.1.4A".equals(str)) || ("Flyme 7.3.0.0A".equals(str)))
    {
      if (("1".equals(a("persist.sys.mz_mback_nav", "0"))) && ("0".equals(a("persist.sys.mz_mainkeys", "0")))) {}
      while (("0".equals(a("persist.sys.mz_mback_nav", "0"))) && ("0".equals(a("persist.sys.mz_mback_nav", "0")))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity)
  {
    boolean bool2 = false;
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    boolean bool1 = bool2;
    int i;
    if (localViewGroup != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < localViewGroup.getChildCount())
      {
        localViewGroup.getChildAt(i).getContext().getPackageName();
        if ((localViewGroup.getChildAt(i).getId() != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i).getId())))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (jdField_b_of_type_Int != -1) {
      return jdField_b_of_type_Int == 1;
    }
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    boolean bool;
    if (i != 0)
    {
      bool = localResources.getBoolean(i);
      if ("1".equals(jdField_a_of_type_JavaLangString)) {
        bool = false;
      }
    }
    for (;;)
    {
      besl.a("XPanelContainer", "hasNavbar=" + bool);
      if (bool) {}
      for (jdField_b_of_type_Int = 1;; jdField_b_of_type_Int = 0)
      {
        return bool;
        if (!"0".equals(jdField_a_of_type_JavaLangString)) {
          break;
        }
        bool = true;
        break;
        if (Build.VERSION.SDK_INT < 14) {
          break label148;
        }
        if (!ViewConfiguration.get(paramContext).hasPermanentMenuKey())
        {
          bool = true;
          break;
        }
        bool = false;
        break;
      }
      label148:
      bool = false;
    }
  }
  
  private static boolean a(Window paramWindow, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramWindow != null) {
      for (;;)
      {
        try
        {
          WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
          Field localField1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
          Field localField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
          localField1.setAccessible(true);
          localField2.setAccessible(true);
          i = localField1.getInt(null);
          j = localField2.getInt(localLayoutParams);
          if (!paramBoolean) {
            continue;
          }
          i |= j;
          localField2.setInt(localLayoutParams, i);
          paramWindow.setAttributes(localLayoutParams);
        }
        catch (Exception localException)
        {
          int j;
          besl.d("DisplayUtil", "setStatusBarDarkModeForFlyme: failed");
          bool = false;
          continue;
          int i = j & 0xFFFFDFFF;
          continue;
        }
        if (Build.VERSION.SDK_INT >= 23)
        {
          paramWindow = paramWindow.getDecorView();
          if (paramWindow != null)
          {
            j = paramWindow.getSystemUiVisibility();
            if (!paramBoolean) {
              continue;
            }
            i = j | 0x2000;
            if (i != j) {
              paramWindow.setSystemUiVisibility(i);
            }
          }
        }
        return bool;
        i = (i ^ 0xFFFFFFFF) & j;
      }
    }
    return false;
  }
  
  public static boolean a(boolean paramBoolean, Window paramWindow)
  {
    if (bfgr.b()) {
      return a(paramWindow, paramBoolean);
    }
    if (bfgr.a()) {
      return b(paramWindow, paramBoolean);
    }
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramWindow.getDecorView().setSystemUiVisibility(9216);
        return true;
      }
    }
    else if (Build.VERSION.SDK_INT >= 23)
    {
      paramWindow.getDecorView().setSystemUiVisibility(1280);
      return true;
    }
    return false;
  }
  
  public static int b(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        return ((DisplayMetrics)localObject).heightPixels;
      }
      localObject = Display.class.getMethod("getRawHeight", new Class[0]);
      try
      {
        int i = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        return i;
      }
      catch (IllegalArgumentException paramContext)
      {
        besl.d("DisplayUtil", paramContext.getMessage());
        return -1;
      }
      catch (IllegalAccessException paramContext)
      {
        besl.d("DisplayUtil", paramContext.getMessage());
        return -1;
      }
      catch (InvocationTargetException paramContext)
      {
        besl.d("DisplayUtil", paramContext.getMessage());
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        besl.d("DisplayUtil", paramContext.getMessage());
      }
    }
    return -1;
  }
  
  public static void b(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFormat(-2);
    paramActivity.setRequestedOrientation(1);
    bfgb.a(paramActivity);
    if (bfgb.a())
    {
      if ((Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27))) {
        b(paramActivity);
      }
    }
    else {
      return;
    }
    bfgb.b(paramActivity);
  }
  
  private static void b(Window paramWindow)
  {
    try
    {
      if ((Build.VERSION.SDK_INT >= 23) || (b()))
      {
        paramWindow.clearFlags(67108864);
        paramWindow.getDecorView().setSystemUiVisibility(1280);
        paramWindow.addFlags(-2147483648);
        if (Build.VERSION.SDK_INT >= 21) {
          paramWindow.setStatusBarColor(0);
        }
      }
      return;
    }
    catch (Exception paramWindow)
    {
      besl.d("DisplayUtil", "", paramWindow);
    }
  }
  
  @TargetApi(23)
  private static void b(Window paramWindow, boolean paramBoolean)
  {
    paramWindow = paramWindow.getDecorView();
    if (paramBoolean)
    {
      paramWindow.setSystemUiVisibility(9216);
      return;
    }
    paramWindow.setSystemUiVisibility(paramWindow.getSystemUiVisibility() & 0xFFFFDFFF);
  }
  
  public static boolean b()
  {
    return ("vivo".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 21);
  }
  
  private static boolean b(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow();
      Window.class.getMethod("addExtraFlags", new Class[] { Integer.TYPE }).invoke(paramActivity, new Object[] { Integer.valueOf(1792) });
      if (besl.a()) {
        besl.b("Window", "enableXiaoMiNotch true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (besl.a()) {
        besl.d("Window", "enableXiaoMiNotch Exception", paramActivity);
      }
    }
    return false;
  }
  
  private static boolean b(Window paramWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      b(paramWindow, paramBoolean);
      return true;
    }
    return c(paramWindow, paramBoolean);
  }
  
  public static int c(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = 0;
    if (Build.VERSION.SDK_INT >= 14) {
      if (!jdField_b_of_type_Boolean) {
        break label33;
      }
    }
    label33:
    for (paramContext = "navigation_bar_height";; paramContext = "navigation_bar_height_landscape")
    {
      i = a(localResources, paramContext);
      return i;
    }
  }
  
  private static boolean c(Window paramWindow, boolean paramBoolean)
  {
    Object localObject = paramWindow.getClass();
    try
    {
      Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
      int j = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
      localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
      if (paramBoolean) {}
      for (int i = j;; i = 0)
      {
        ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        return true;
      }
      return false;
    }
    catch (Exception paramWindow)
    {
      paramWindow.printStackTrace();
    }
  }
  
  public static int d(Context paramContext)
  {
    float f3;
    float f1;
    if (jdField_a_of_type_Int == -1)
    {
      i = 0;
      paramContext = paramContext.getResources();
      int j = paramContext.getIdentifier("status_bar_height", "dimen", "android");
      if (j > 0) {
        i = paramContext.getDimensionPixelSize(j);
      }
      f3 = paramContext.getDisplayMetrics().density;
      float f2 = f3 / paramContext.getDisplayMetrics().density;
      f1 = f2;
      if (f2 <= 0.0F) {
        f1 = 1.0F;
      }
      if (i > 0) {
        break label95;
      }
    }
    label95:
    for (int i = Math.round(25.0F * f1 * f3);; i = (int)Math.ceil(i * f1 + 0.5F))
    {
      jdField_a_of_type_Int = i;
      return jdField_a_of_type_Int;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bffu
 * JD-Core Version:    0.7.0.1
 */