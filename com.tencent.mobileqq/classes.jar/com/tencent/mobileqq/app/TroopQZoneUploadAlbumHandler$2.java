package com.tencent.mobileqq.app;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingQueue;

class TroopQZoneUploadAlbumHandler$2
  implements Runnable
{
  TroopQZoneUploadAlbumHandler$2(TroopQZoneUploadAlbumHandler paramTroopQZoneUploadAlbumHandler) {}
  
  public void run()
  {
    while (!TroopQZoneUploadAlbumHandler.a(this.this$0)) {
      try
      {
        int i = ((Integer)TroopQZoneUploadAlbumHandler.b(this.this$0).take()).intValue();
        if ((this.this$0.b != null) && (this.this$0.b.getBinder() != null) && (this.this$0.b.getBinder().isBinderAlive()) && (this.this$0.b.getBinder().pingBinder()))
        {
          Message localMessage = Message.obtain(null, 998, i, 0);
          if (this.this$0.c == null) {
            this.this$0.c = new Messenger(this.this$0.a);
          }
          localMessage.replyTo = this.this$0.c;
          this.this$0.b.send(localMessage);
        }
        else
        {
          QLog.i("UploadPhoto", 1, "需要重新创建连接");
          this.this$0.a();
          TroopQZoneUploadAlbumHandler.c(this.this$0);
          TroopQZoneUploadAlbumHandler.b(this.this$0).offer(Integer.valueOf(i));
          TroopQZoneUploadAlbumHandler.a(this.this$0, true);
        }
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("UploadPhoto", 1, localRemoteException, new Object[0]);
      }
      catch (InterruptedException localInterruptedException)
      {
        TroopQZoneUploadAlbumHandler.a(this.this$0, true);
        QLog.e("UploadPhoto", 1, localInterruptedException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler.2
 * JD-Core Version:    0.7.0.1
 */