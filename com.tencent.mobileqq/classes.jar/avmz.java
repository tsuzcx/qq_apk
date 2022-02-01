import android.view.WindowManager.BadTokenException;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.lang.reflect.Field;

final class avmz
  implements HookMethodCallback
{
  avmz(Class paramClass) {}
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (paramMethodHookParam.throwable == null) {
      return;
    }
    Object localObject;
    if (paramMethodHookParam.throwable.getCause() != null) {
      localObject = paramMethodHookParam.throwable.getCause();
    }
    while ((localObject instanceof WindowManager.BadTokenException)) {
      try
      {
        localObject = this.a.getDeclaredField("mAccessibilityInteractionConnectionManager");
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(paramMethodHookParam.thisObject);
        Field localField = this.a.getDeclaredField("mAccessibilityManager");
        localField.setAccessible(true);
        ((AccessibilityManager)localField.get(paramMethodHookParam.thisObject)).removeAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener)localObject);
        return;
      }
      catch (NoSuchFieldException paramMethodHookParam)
      {
        paramMethodHookParam.printStackTrace();
        return;
        localObject = paramMethodHookParam.throwable;
      }
      catch (IllegalArgumentException paramMethodHookParam)
      {
        paramMethodHookParam.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramMethodHookParam)
      {
        paramMethodHookParam.printStackTrace();
        return;
      }
      catch (Exception paramMethodHookParam)
      {
        paramMethodHookParam.printStackTrace();
        return;
      }
      catch (Error paramMethodHookParam)
      {
        paramMethodHookParam.printStackTrace();
      }
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmz
 * JD-Core Version:    0.7.0.1
 */