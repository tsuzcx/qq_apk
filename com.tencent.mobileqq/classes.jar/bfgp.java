import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class bfgp
{
  @TargetApi(23)
  private static void a(Window paramWindow, boolean paramBoolean)
  {
    paramWindow = paramWindow.getDecorView();
    if (paramBoolean)
    {
      paramWindow.setSystemUiVisibility(9216);
      return;
    }
    paramWindow.setSystemUiVisibility(paramWindow.getSystemUiVisibility() & 0xFFFFDFFF);
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
          betc.d("ImmersiveUtils", "setStatusBarDarkModeForFlyme: failed");
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
    if (bfhi.b()) {
      return a(paramWindow, paramBoolean);
    }
    if (bfhi.a()) {
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
  
  private static boolean b(Window paramWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      a(paramWindow, paramBoolean);
      return true;
    }
    return c(paramWindow, paramBoolean);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfgp
 * JD-Core Version:    0.7.0.1
 */