import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.lang.reflect.Field;

class atgk
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (paramMethodHookParam.throwable == null) {}
    View localView;
    do
    {
      return;
      localView = (View)paramMethodHookParam.args[0];
    } while (localView == null);
    Object localObject1 = localView.getContext();
    Object localObject2 = localObject1;
    if ("android.view.ContextThemeWrapper".equals(localObject1.getClass().getName())) {}
    label295:
    for (;;)
    {
      try
      {
        localObject2 = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mBase");
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Field)localObject2).get(localView.getContext());
        if ((localObject2 == null) || (!(localObject2 instanceof Context))) {
          break label295;
        }
        localObject2 = (Context)localObject2;
        localObject1 = localObject2;
        localObject2 = localObject1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        bdeu.a(localClassNotFoundException);
        Object localObject3 = localObject1;
        continue;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        bdeu.a(localNoSuchFieldException);
        Object localObject4 = localObject1;
        continue;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        bdeu.a(localIllegalArgumentException);
        Object localObject5 = localObject1;
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        bdeu.a(localIllegalAccessException);
        Object localObject6 = localObject1;
        continue;
        localObject1 = paramMethodHookParam.throwable;
        continue;
        paramMethodHookParam.throwable = new RuntimeException(paramMethodHookParam.throwable.getMessage() + " -- context is " + localObject6.getClass().getName(), paramMethodHookParam.throwable);
        return;
      }
      if (paramMethodHookParam.throwable.getCause() != null)
      {
        localObject1 = paramMethodHookParam.throwable.getCause();
        if ((!(localObject2 instanceof Activity)) || (((Activity)localObject2).isFinishing()) || (!(localObject1 instanceof WindowManager.BadTokenException))) {
          continue;
        }
        atgi.a(1, localObject2.getClass().getName(), paramMethodHookParam.throwable.getMessage(), 0);
        atgi.a(2, localObject2.getClass().getName(), null, 10000);
        atgi.a(3, localObject2.getClass().getName(), null, 60000);
        paramMethodHookParam.throwable = null;
        ((Activity)localObject2).finish();
      }
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgk
 * JD-Core Version:    0.7.0.1
 */