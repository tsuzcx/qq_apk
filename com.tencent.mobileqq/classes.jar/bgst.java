import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.wadl.ipc.WadlProxyServiceManager.ClientMessageHandler.1;
import cooperation.wadl.ipc.WadlProxyServiceManager.ClientMessageHandler.2;

public final class bgst
  extends Handler
{
  public bgst(bgsp parambgsp, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      this.a.b();
      continue;
      this.a.c();
      continue;
      Bundle localBundle = paramMessage.getData();
      this.a.a.post(new WadlProxyServiceManager.ClientMessageHandler.1(this, localBundle));
      continue;
      localBundle = paramMessage.getData();
      this.a.a.post(new WadlProxyServiceManager.ClientMessageHandler.2(this, localBundle));
      continue;
      if (bgsp.a(this.a) != null)
      {
        bgsp.a(this.a).a();
        continue;
        if ((!bgsp.a(this.a)) && (bgsp.a(this.a) != null)) {
          bgsp.a(this.a).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgst
 * JD-Core Version:    0.7.0.1
 */