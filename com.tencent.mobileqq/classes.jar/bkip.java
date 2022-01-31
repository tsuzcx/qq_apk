import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.wadl.ipc.WadlProxyServiceManager.ClientMessageHandler.1;
import cooperation.wadl.ipc.WadlProxyServiceManager.ClientMessageHandler.2;

public final class bkip
  extends Handler
{
  public bkip(bkil parambkil, Looper paramLooper)
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
      if (bkil.a(this.a) != null)
      {
        bkil.a(this.a).a();
        continue;
        if ((!bkil.a(this.a)) && (bkil.a(this.a) != null)) {
          bkil.a(this.a).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkip
 * JD-Core Version:    0.7.0.1
 */