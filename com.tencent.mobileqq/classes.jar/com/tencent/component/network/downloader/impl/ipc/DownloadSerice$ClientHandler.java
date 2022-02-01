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
    Log.i("DownloadSerice", "on msg:" + paramMessage.what);
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 101: 
          super.handleMessage(paramMessage);
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        Log.e("DownloadSerice", "", paramMessage);
        return;
      }
      if (paramMessage.getData() == null) {
        break;
      }
      Object localObject = paramMessage.getData();
      ((Bundle)localObject).setClassLoader(this.this$0.getClassLoader());
      localObject = (Const.SimpleRequest)((Bundle)localObject).get("request");
      DownloadSerice.access$000(this.this$0, (Const.SimpleRequest)localObject, paramMessage.replyTo);
      return;
      if (paramMessage.getData() == null) {
        break;
      }
      localObject = paramMessage.getData();
      ((Bundle)localObject).setClassLoader(this.this$0.getClassLoader());
      localObject = (Const.SimpleRequest)((Bundle)localObject).get("request");
      DownloadSerice.access$100(this.this$0, (Const.SimpleRequest)localObject, paramMessage.replyTo);
      return;
      if (paramMessage.getData() == null) {
        break;
      }
      localObject = paramMessage.getData();
      ((Bundle)localObject).setClassLoader(this.this$0.getClassLoader());
      localObject = (Const.SimpleRequest)((Bundle)localObject).get("request");
      DownloadSerice.access$200(this.this$0, (Const.SimpleRequest)localObject, paramMessage.replyTo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.DownloadSerice.ClientHandler
 * JD-Core Version:    0.7.0.1
 */