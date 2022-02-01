import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class amzz
  extends Handler
{
  amzz(amzy paramamzy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.b();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxySvcPack", 2, new Object[] { "real notify pcStatus:", Integer.valueOf(amzy.a(this.a)), " ,devStatus:", Integer.valueOf(amzy.b(this.a)), " ,clientType:", Long.valueOf(amzy.a(this.a)), " ,appid:", Long.valueOf(amzy.b(this.a)) });
      }
      this.a.notifyUI(2, true, new Object[] { Integer.valueOf(amzy.b(this.a)) });
    } while (amzy.b(this.a) != 0);
    if (!this.a.a.hasMessages(101)) {
      this.a.a.sendEmptyMessageDelayed(101, 3000L);
    }
    bfrf.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzz
 * JD-Core Version:    0.7.0.1
 */