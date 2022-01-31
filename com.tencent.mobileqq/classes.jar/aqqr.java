import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.javahook.BadTokenHooker.2;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import mqq.os.MqqHandler;

@TargetApi(14)
public class aqqr
{
  private static aqqt a = new aqqt(null);
  
  public static void a()
  {
    try
    {
      localClass1 = Class.forName("android.view.ViewRootImpl");
      JavaHookBridge.findAndHookMethod(localClass1, "setView", new Object[] { View.class, WindowManager.LayoutParams.class, View.class, new aqqs(localClass1) });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          localClass1 = Class.forName("android.view.WindowManagerImpl");
          if (Build.VERSION.SDK_INT > 16) {
            break;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          Class localClass1;
          Class localClass2;
          azzz.a(localClassNotFoundException2);
          return;
        }
        try
        {
          localClass2 = Class.forName("android.view.CompatibilityInfoHolder");
          if (localClass2 != null) {
            JavaHookBridge.findAndHookMethod(localClass1, "addView", new Object[] { View.class, ViewGroup.LayoutParams.class, localClass2, Boolean.class, a });
          }
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          azzz.a(localNoSuchMethodException2);
          return;
        }
        catch (ClassNotFoundException localClassNotFoundException3)
        {
          azzz.a(localClassNotFoundException3);
          return;
        }
        localNoSuchMethodException1 = localNoSuchMethodException1;
        azzz.a(localNoSuchMethodException1);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      for (;;)
      {
        azzz.a(localClassNotFoundException1);
      }
    }
    try
    {
      JavaHookBridge.findAndHookMethod(localClassNotFoundException3, "addView", new Object[] { View.class, ViewGroup.LayoutParams.class, a });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      azzz.a(localNoSuchMethodException3);
    }
  }
  
  private static void b(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new BadTokenHooker.2(paramString1, paramString2, paramInt1), paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqr
 * JD-Core Version:    0.7.0.1
 */