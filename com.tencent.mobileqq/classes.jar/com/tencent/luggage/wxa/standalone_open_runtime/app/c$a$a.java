package com.tencent.luggage.wxa.standalone_open_runtime.app;

import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.luggage.wxa.ed.g;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "queueIdle"}, k=3, mv={1, 1, 16})
final class c$a$a
  implements MessageQueue.IdleHandler
{
  c$a$a(c.a parama, Activity paramActivity) {}
  
  public final boolean queueIdle()
  {
    if (this.a.a.get() <= 0)
    {
      boolean bool1 = g.a.a() ^ true;
      boolean bool2 = a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("before suicide maybe (onActivityDestroyed), last activity ");
      Object localObject = this.b;
      if (localObject != null) {
        localObject = ((Activity)localObject).getComponentName();
      } else {
        localObject = null;
      }
      localStringBuilder.append(localObject);
      o.d("Luggage.WxaProcessSuicideLogic", localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("before suicide maybe (onActivityDestroyed), hasPendingLaunchActivity ");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(" hasRuntimeStashed ");
      ((StringBuilder)localObject).append(bool1);
      o.d("Luggage.WxaProcessSuicideLogic", ((StringBuilder)localObject).toString());
      if ((!bool2) && (!bool1)) {
        c.a(c.a);
      }
      if (bool1) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.app.c.a.a
 * JD-Core Version:    0.7.0.1
 */