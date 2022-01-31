import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

final class arls
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    long l = Thread.currentThread().getId();
    HashMap localHashMap;
    if (arlq.a().containsKey(Long.valueOf(l)))
    {
      l = SystemClock.uptimeMillis() - ((Long)arlq.a().remove(Long.valueOf(l))).longValue();
      localHashMap = new HashMap(10);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label139;
      }
    }
    label139:
    for (paramMethodHookParam = "1";; paramMethodHookParam = "0")
    {
      localHashMap.put("param_IsMainThread", paramMethodHookParam);
      localHashMap.put("param_OptType", "connection");
      localHashMap.put("param_bustag", "Friends");
      localHashMap.put("param_OptTotalCost", String.valueOf(l));
      localHashMap.put("param_WalSwitch", String.valueOf(akfu.a));
      axrn.a(BaseApplicationImpl.getContext()).a(null, "actFriendSqliteOpt", true, l, 0L, localHashMap, null, false);
      return;
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    long l = Thread.currentThread().getId();
    if (arlq.a().containsKey(Long.valueOf(l))) {
      arlq.a().put(Long.valueOf(l), Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arls
 * JD-Core Version:    0.7.0.1
 */