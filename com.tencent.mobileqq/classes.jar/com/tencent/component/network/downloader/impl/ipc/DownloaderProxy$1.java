package com.tencent.component.network.downloader.impl.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import java.util.Iterator;
import java.util.List;

class DownloaderProxy$1
  implements ServiceConnection
{
  DownloaderProxy$1(DownloaderProxy paramDownloaderProxy) {}
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    DownloaderProxy.access$002(this.this$0, new Messenger(paramIBinder));
    synchronized (DownloaderProxy.access$100(this.this$0))
    {
      paramIBinder = DownloaderProxy.access$100(this.this$0).iterator();
      if (paramIBinder.hasNext())
      {
        Const.SimpleRequest localSimpleRequest = (Const.SimpleRequest)paramIBinder.next();
        this.this$0.download(localSimpleRequest.url, localSimpleRequest.getPaths(), true, localSimpleRequest.listener, localSimpleRequest.mode);
      }
    }
    DownloaderProxy.access$100(this.this$0).clear();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    DownloaderProxy.access$002(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.DownloaderProxy.1
 * JD-Core Version:    0.7.0.1
 */