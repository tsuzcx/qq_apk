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
public class atbz
{
  private static atcb a = new atcb(null);
  
  public static void a()
  {
    try
    {
      localClass1 = Class.forName("android.view.ViewRootImpl");
      JavaHookBridge.findAndHookMethod(localClass1, "setView", new Object[] { View.class, WindowManager.LayoutParams.class, View.class, new atca(localClass1) });
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
          bdal.a(localClassNotFoundException2);
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
          bdal.a(localNoSuchMethodException2);
          return;
        }
        catch (ClassNotFoundException localClassNotFoundException3)
        {
          bdal.a(localClassNotFoundException3);
          return;
        }
        localNoSuchMethodException1 = localNoSuchMethodException1;
        bdal.a(localNoSuchMethodException1);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      for (;;)
      {
        bdal.a(localClassNotFoundException1);
      }
    }
    try
    {
      JavaHookBridge.findAndHookMethod(localClassNotFoundException3, "addView", new Object[] { View.class, ViewGroup.LayoutParams.class, a });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      bdal.a(localNoSuchMethodException3);
    }
  }
  
  private static void b(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new BadTokenHooker.2(paramString1, paramString2, paramInt1), paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbz
 * JD-Core Version:    0.7.0.1
 */