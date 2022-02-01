package com.tencent.luggage.wxa.hj;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.hl.b.a;
import com.tencent.luggage.wxa.hq.c;

class h$a
  extends b.a
  implements c
{
  String a;
  e b;
  
  h$a(@NonNull String paramString, @NonNull e parame)
  {
    this.b = parame;
    this.a = paramString;
    com.tencent.luggage.wxa.hq.b.a(paramString, this);
    com.tencent.luggage.wxa.hs.b.a("IPC.IPCInvokeCallbackWrapper", "keep ref of callback(%s)", new Object[] { Integer.valueOf(parame.hashCode()) });
  }
  
  public void a()
  {
    this.b = null;
    com.tencent.luggage.wxa.hq.b.b(this.a, this);
  }
  
  public void a(Bundle paramBundle)
  {
    e locale = this.b;
    if (locale == null)
    {
      com.tencent.luggage.wxa.hs.b.c("IPC.IPCInvokeCallbackWrapper", "callback failed, ref has been release", new Object[0]);
      return;
    }
    if (paramBundle == null)
    {
      locale.a(null);
      return;
    }
    paramBundle.setClassLoader(h.class.getClassLoader());
    if (paramBundle.getBoolean("__command_release_ref"))
    {
      com.tencent.luggage.wxa.hs.b.a("IPC.IPCInvokeCallbackWrapper", "release ref of callback(%s)", new Object[] { Integer.valueOf(locale.hashCode()) });
      a();
      return;
    }
    locale.a(paramBundle.getParcelable("__remote_task_result_data"));
  }
  
  protected void finalize()
  {
    a();
    com.tencent.luggage.wxa.hs.b.a("IPC.IPCInvokeCallbackWrapper", "finalize(%s)", new Object[] { Integer.valueOf(hashCode()) });
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.h.a
 * JD-Core Version:    0.7.0.1
 */