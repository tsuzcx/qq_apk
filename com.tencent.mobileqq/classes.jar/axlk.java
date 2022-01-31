import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class axlk
{
  private static float jdField_a_of_type_Float;
  public static int a;
  private static Context jdField_a_of_type_AndroidContentContext = ;
  public static int b;
  
  static
  {
    jdField_a_of_type_Int = 320;
    b = 480;
    Display localDisplay = ((WindowManager)jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay();
    if (localDisplay != null)
    {
      jdField_a_of_type_Int = localDisplay.getWidth();
      b = localDisplay.getHeight();
    }
  }
  
  public static int a(float paramFloat)
  {
    if (jdField_a_of_type_Float == 0.0F) {
      jdField_a_of_type_Float = jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenUtil", 2, "[@] ScreenUtil.dip2px DENSITY = " + jdField_a_of_type_Float);
    }
    return (int)(jdField_a_of_type_Float * paramFloat + 0.5F);
  }
  
  @TargetApi(13)
  public static int a(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (b = localPoint.y;; b = paramContext.getDefaultDisplay().getHeight()) {
      return b;
    }
  }
  
  public static void a()
  {
    WindowManager localWindowManager = (WindowManager)jdField_a_of_type_AndroidContentContext.getSystemService("window");
    jdField_a_of_type_Int = localWindowManager.getDefaultDisplay().getWidth();
    b = localWindowManager.getDefaultDisplay().getHeight();
    jdField_a_of_type_Float = jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    if (QLog.isColorLevel()) {
      QLog.d("systemDpiChanged", 2, "mofity width:" + jdField_a_of_type_Int);
    }
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return false;
      ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        int j = localViewGroup.getChildAt(i).getId();
        if ((j != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(j)))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if ((Build.MANUFACTURER.contains("Xiaomi")) && ((Build.MODEL.contains("MIX 2S")) || (Build.MODEL.contains("MI 8")) || (Build.MODEL.contains("MI 9")) || (Build.MODEL.contains("MIX 2")) || (Build.MODEL.contains("MIX 3"))) && (Build.VERSION.SDK_INT >= 21)) {
      if (Settings.Global.getInt(BaseApplication.getContext().getContentResolver(), "force_fsg_nav_bar", 0) != 0) {}
    }
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return true;
        return false;
        if (Build.VERSION.SDK_INT < 17) {
          break;
        }
      } while (a(paramContext) != c(paramContext));
      return false;
      bool1 = ViewConfiguration.get(paramContext).hasPermanentMenuKey();
      bool2 = KeyCharacterMap.deviceHasKey(4);
    } while ((!bool1) && (!bool2));
    return false;
  }
  
  @TargetApi(13)
  public static int b(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (jdField_a_of_type_Int = localPoint.x;; jdField_a_of_type_Int = paramContext.getDefaultDisplay().getWidth()) {
      return jdField_a_of_type_Int;
    }
  }
  
  public static int c(Context paramContext)
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
        ved.e("ScreenUtil", paramContext.getMessage());
        return -1;
      }
      catch (IllegalAccessException paramContext)
      {
        ved.e("ScreenUtil", paramContext.getMessage());
        return -1;
      }
      catch (InvocationTargetException paramContext)
      {
        ved.e("ScreenUtil", paramContext.getMessage());
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        ved.e("ScreenUtil", paramContext.getMessage());
      }
    }
    return -1;
  }
  
  public static int d(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getIdentifier("navigation_bar_height", "dimen", "android");
    if (i != 0) {
      return paramContext.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static int e(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        return ((DisplayMetrics)localObject).widthPixels;
      }
      localObject = Display.class.getMethod("getRawWidth", new Class[0]);
      try
      {
        int i = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        return i;
      }
      catch (IllegalArgumentException paramContext)
      {
        ved.e("ScreenUtil", paramContext.getMessage());
        return -1;
      }
      catch (IllegalAccessException paramContext)
      {
        ved.e("ScreenUtil", paramContext.getMessage());
        return -1;
      }
      catch (InvocationTargetException paramContext)
      {
        ved.e("ScreenUtil", paramContext.getMessage());
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        ved.f("ScreenUtil", paramContext.getMessage());
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axlk
 * JD-Core Version:    0.7.0.1
 */