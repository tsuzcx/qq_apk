import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Method;

public class bhpx
{
  public static final int a;
  public static final String a;
  public static int b = -1;
  
  static
  {
    jdField_a_of_type_JavaLangString = "[PhotoAlbum]" + bhpx.class.getSimpleName();
    jdField_a_of_type_Int = a(27);
  }
  
  public static int a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    float f = paramInt;
    return (int)(localDisplayMetrics.density * f + 0.5F);
  }
  
  private static int a(Context paramContext)
  {
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static int a(Context paramContext, Activity paramActivity)
  {
    if (b != -1)
    {
      QZLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "has notchHeight:", Integer.valueOf(b) });
      return b;
    }
    QZLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "Build.MODEL:", Build.MODEL });
    if (b(paramContext)) {
      b = jdField_a_of_type_Int;
    }
    for (;;)
    {
      return b;
      if (a(paramContext)) {
        b = 80;
      } else if (c(paramContext)) {
        b = a(paramContext)[1];
      } else if ((d(paramContext)) || (e(paramContext)) || (c())) {
        b = a(paramContext);
      } else if (d()) {
        b = 121;
      } else if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null)) {
        b = a(paramActivity.getWindow().getDecorView()).top;
      }
    }
  }
  
  @NonNull
  public static Rect a(View paramView)
  {
    Rect localRect = new Rect();
    QZLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "Build.VERSION.SDK_INT:", Integer.valueOf(Build.VERSION.SDK_INT) });
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        paramView = bhom.a(paramView, "getRootWindowInsets", false, null, null);
        QZLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "insets:", paramView });
        Object localObject3 = bhom.a(paramView, "getDisplayCutout", false, null, null);
        if (localObject3 == null)
        {
          QZLog.d(jdField_a_of_type_JavaLangString, 1, "displayCutout == null");
          return localRect;
        }
        paramView = bhom.a(localObject3, "getSafeInsetTop", false, null, null);
        Object localObject1 = bhom.a(localObject3, "getSafeInsetBottom", false, null, null);
        Object localObject2 = bhom.a(localObject3, "getSafeInsetLeft", false, null, null);
        localObject3 = bhom.a(localObject3, "getSafeInsetRight", false, null, null);
        QZLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "safeInsetTop:", paramView, " safeInsetBottom:", localObject1, " safeInsetLeft:", localObject2, " safeInsetRight:", localObject3 });
        if ((localObject2 instanceof Integer)) {
          localRect.left = ((Integer)localObject2).intValue();
        }
        if ((localObject1 instanceof Integer)) {
          localRect.bottom = ((Integer)localObject1).intValue();
        }
        if ((localObject3 instanceof Integer)) {
          localRect.right = ((Integer)localObject3).intValue();
        }
        if ((paramView instanceof Integer))
        {
          localRect.top = ((Integer)paramView).intValue();
          return localRect;
        }
      }
      catch (Exception paramView)
      {
        QZLog.e(jdField_a_of_type_JavaLangString, 1, paramView, new Object[0]);
      }
    }
    return localRect;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class, String.class }).invoke(paramContext, new Object[] { new String(paramString1), new String(paramString2) });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      return paramString2;
    }
    catch (IllegalArgumentException paramContext) {}
    return paramString2;
  }
  
  private static boolean a()
  {
    return Build.MODEL.endsWith("L78011");
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
  }
  
  public static int[] a(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      paramContext = (int[])paramContext.getMethod("getNotchSize", new Class[0]).invoke(paramContext, new Object[0]);
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(jdField_a_of_type_JavaLangString, "getNotchSize ClassNotFoundException");
      return arrayOfInt;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(jdField_a_of_type_JavaLangString, "getNotchSize NoSuchMethodException");
      return arrayOfInt;
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      QZLog.e(jdField_a_of_type_JavaLangString, "getNotchSize Exception");
      return arrayOfInt;
    }
    finally {}
    return arrayOfInt;
  }
  
  private static boolean b()
  {
    return "GM1910".equals(Build.MODEL);
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      paramContext = bhom.a("android.util.FtFeature", "isFeatureSupport", false, bhqa.a().a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(32) });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      QZLog.e(jdField_a_of_type_JavaLangString, 2, paramContext, new Object[0]);
    }
    return false;
  }
  
  private static boolean c()
  {
    return (a()) || (b()) || (e()) || ("Pixel 3 XL".equals(Build.MODEL));
  }
  
  public static boolean c(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      boolean bool = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(jdField_a_of_type_JavaLangString, "hasNotchInScreen ClassNotFoundException");
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(jdField_a_of_type_JavaLangString, "hasNotchInScreen NoSuchMethodException");
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      QZLog.e(jdField_a_of_type_JavaLangString, "hasNotchInScreen Exception");
      return false;
    }
    finally {}
    return false;
  }
  
  private static boolean d()
  {
    return "FS8010".equals(Build.MODEL);
  }
  
  public static boolean d(Context paramContext)
  {
    paramContext = a(paramContext, "ro.miui.notch", "0");
    if (paramContext != null) {
      return paramContext.equals("1");
    }
    return false;
  }
  
  private static boolean e()
  {
    return "SM-F9000".equals(Build.MODEL);
  }
  
  public static boolean e(Context paramContext)
  {
    try
    {
      paramContext = bhom.a("smartisanos.api.DisplayUtilsSmt", "isFeatureSupport", false, bhqa.a().a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(1) });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      QZLog.e(jdField_a_of_type_JavaLangString, 2, paramContext, new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhpx
 * JD-Core Version:    0.7.0.1
 */