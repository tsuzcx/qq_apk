package com.tencent.component.network.downloader.impl.ipc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.component.network.downloader.DownloadResult;
import java.util.ArrayList;

class DownloaderProxy$DownloadHandler
  extends Handler
{
  public DownloaderProxy$DownloadHandler(DownloaderProxy paramDownloaderProxy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ArrayList localArrayList = new ArrayList();
    Log.i("RemoteDownloader", "on message:" + paramMessage.what);
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 103: 
          super.handleMessage(paramMessage);
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        Log.e("RemoteDownloader", "", paramMessage);
        return;
      }
      if (paramMessage.getData() == null) {
        break;
      }
      paramMessage = paramMessage.getData();
      paramMessage.setClassLoader(DownloaderProxy.access$200(this.this$0).getClassLoader());
      paramMessage = (DownloadResult)paramMessage.getParcelable("result");
      DownloaderProxy.access$300(this.this$0, paramMessage.getUrl(), true, localArrayList);
      DownloaderProxy.access$400(this.this$0, localArrayList, paramMessage);
      return;
      if (paramMessage.getData() == null) {
        break;
      }
      paramMessage = paramMessage.getData();
      paramMessage.setClassLoader(DownloaderProxy.access$500(this.this$0).getClassLoader());
      paramMessage = (DownloadResult)paramMessage.getParcelable("result");
      DownloaderProxy.access$300(this.this$0, paramMessage.getUrl(), true, localArrayList);
      DownloaderProxy.access$600(this.this$0, localArrayList, paramMessage);
      return;
      if (paramMessage.getData() == null) {
        break;
      }
      paramMessage = paramMessage.getData().getString("url");
      DownloaderProxy.access$300(this.this$0, paramMessage, true, localArrayList);
      DownloaderProxy.access$700(this.this$0, localArrayList);
      return;
      if (paramMessage.getData() == null) {
        break;
      }
      String str = paramMessage.getData().getString("url");
      long l = paramMessage.arg1;
      float f = paramMessage.arg2;
      DownloaderProxy.access$300(this.this$0, str, false, localArrayList);
      DownloaderProxy.access$800(this.this$0, localArrayList, l, f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.DownloaderProxy.DownloadHandler
 * JD-Core Version:    0.7.0.1
 */