package com.tencent.luggage.wxa.da;

import android.os.Process;
import com.tencent.luggage.wxa.hj.c;
import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.hu.d;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/task/IPCKillProcessTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
  implements c<d, d>
{
  @Deprecated
  public static final a.a a = new a.a(null);
  
  public void a(@Nullable d paramd, @Nullable e<d> parame)
  {
    try
    {
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Throwable paramd)
    {
      parame = new StringBuilder();
      parame.append("runInLuggageProcess: handled throwable [");
      parame.append(paramd);
      parame.append(']');
      o.c("Luggage.task.IPCKillProcessTask", parame.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.da.a
 * JD-Core Version:    0.7.0.1
 */