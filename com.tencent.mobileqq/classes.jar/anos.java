import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.wadl.ipc.IWadlProxyServiceMonitor;
import cooperation.wadl.ipc.WadlProxyServiceManager;

public final class anos
  extends Handler
{
  public anos(WadlProxyServiceManager paramWadlProxyServiceManager, Looper paramLooper)
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
      this.a.a.post(new anot(this, localBundle));
      continue;
      localBundle = paramMessage.getData();
      this.a.a.post(new anou(this, localBundle));
      continue;
      if (WadlProxyServiceManager.a(this.a) != null)
      {
        WadlProxyServiceManager.a(this.a).a();
        continue;
        if (WadlProxyServiceManager.a(this.a) != null) {
          WadlProxyServiceManager.a(this.a).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anos
 * JD-Core Version:    0.7.0.1
 */