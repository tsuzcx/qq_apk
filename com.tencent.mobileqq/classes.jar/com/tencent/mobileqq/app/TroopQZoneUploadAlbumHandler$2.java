package com.tencent.mobileqq.app;

import akio;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingQueue;

public class TroopQZoneUploadAlbumHandler$2
  implements Runnable
{
  public TroopQZoneUploadAlbumHandler$2(akio paramakio) {}
  
  public void run()
  {
    while (!akio.a(this.this$0)) {
      try
      {
        i = ((Integer)akio.a(this.this$0).take()).intValue();
        if ((this.this$0.jdField_a_of_type_AndroidOsMessenger == null) || (this.this$0.jdField_a_of_type_AndroidOsMessenger.getBinder() == null) || (!this.this$0.jdField_a_of_type_AndroidOsMessenger.getBinder().isBinderAlive()) || (!this.this$0.jdField_a_of_type_AndroidOsMessenger.getBinder().pingBinder()))
        {
          QLog.i("UploadPhoto", 1, "需要重新创建连接");
          this.this$0.a();
          akio.a(this.this$0);
          akio.a(this.this$0).offer(Integer.valueOf(i));
          akio.a(this.this$0, true);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        int i;
        akio.a(this.this$0, true);
        QLog.e("UploadPhoto", 1, localInterruptedException, new Object[0]);
        continue;
        Message localMessage = Message.obtain(null, 998, i, 0);
        if (this.this$0.b == null) {
          this.this$0.b = new Messenger(this.this$0.jdField_a_of_type_AndroidOsHandler);
        }
        localMessage.replyTo = this.this$0.b;
        this.this$0.jdField_a_of_type_AndroidOsMessenger.send(localMessage);
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("UploadPhoto", 1, localRemoteException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler.2
 * JD-Core Version:    0.7.0.1
 */