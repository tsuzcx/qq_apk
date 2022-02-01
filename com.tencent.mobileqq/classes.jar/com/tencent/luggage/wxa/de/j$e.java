package com.tencent.luggage.wxa.de;

import android.util.SparseArray;
import com.tencent.ilink.tdi.b.d;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/account/tdi/TdiCgiServiceBase$mTdiCgiCallbackInner$1", "Lcom/tencent/luggage/login/account/tdi/ITdiCgiCallback;", "onReceiveAppResponse", "", "taskid", "", "error", "resp", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppResponse;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class j$e
  implements c
{
  public void a(int paramInt1, int paramInt2, @Nullable b.d paramd)
  {
    ??? = this.a.f();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onReceiveAppResponse taskid:");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(" error:");
    ((StringBuilder)localObject2).append(paramInt2);
    o.d((String)???, ((StringBuilder)localObject2).toString());
    if (paramInt2 != 0)
    {
      ??? = this.a.f();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceiveAppResponse taskid:");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" error:");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" fail");
      o.b((String)???, ((StringBuilder)localObject2).toString());
    }
    ??? = (c)null;
    synchronized (j.c(this.a))
    {
      localObject2 = (c)j.c(this.a).get(paramInt1);
      j.c(this.a).remove(paramInt1);
      Unit localUnit = Unit.INSTANCE;
      if (localObject2 != null) {
        ((c)localObject2).a(paramInt1, paramInt2, paramd);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.j.e
 * JD-Core Version:    0.7.0.1
 */