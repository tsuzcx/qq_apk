package com.tencent.component.network.downloader.impl.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

class DownloadSerice$ClientHandler
  extends Handler
{
  DownloadSerice$ClientHandler(DownloadSerice paramDownloadSerice) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("on msg:");
    ((StringBuilder)localObject).append(paramMessage.what);
    Log.i("DownloadSerice", ((StringBuilder)localObject).toString());
    try
    {
      int i = paramMessage.what;
      if (i != 101)
      {
        if (i != 102)
        {
          if (i != 107)
          {
            super.handleMessage(paramMessage);
            return;
          }
          if (paramMessage.getData() != null)
          {
            localObject = paramMessage.getData();
            ((Bundle)localObject).setClassLoader(this.this$0.getClassLoader());
            localObject = (Const.SimpleRequest)((Bundle)localObject).get("request");
            DownloadSerice.access$200(this.this$0, (Const.SimpleRequest)localObject, paramMessage.replyTo);
          }
        }
        else if (paramMessage.getData() != null)
        {
          localObject = paramMessage.getData();
          ((Bundle)localObject).setClassLoader(this.this$0.getClassLoader());
          localObject = (Const.SimpleRequest)((Bundle)localObject).get("request");
          DownloadSerice.access$100(this.this$0, (Const.SimpleRequest)localObject, paramMessage.replyTo);
        }
      }
      else if (paramMessage.getData() != null)
      {
        localObject = paramMessage.getData();
        ((Bundle)localObject).setClassLoader(this.this$0.getClassLoader());
        localObject = (Const.SimpleRequest)((Bundle)localObject).get("request");
        DownloadSerice.access$000(this.this$0, (Const.SimpleRequest)localObject, paramMessage.replyTo);
        return;
      }
    }
    catch (Throwable paramMessage)
    {
      Log.e("DownloadSerice", "", paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.DownloadSerice.ClientHandler
 * JD-Core Version:    0.7.0.1
 */