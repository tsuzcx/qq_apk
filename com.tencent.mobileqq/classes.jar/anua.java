import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class anua
  extends Handler
{
  anua(antz paramantz, Looper paramLooper)
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
        QLog.d("RegisterProxySvcPack", 2, new Object[] { "real notify pcStatus:", Integer.valueOf(antz.a(this.a)), " ,devStatus:", Integer.valueOf(antz.b(this.a)), " ,clientType:", Long.valueOf(antz.a(this.a)), " ,appid:", Long.valueOf(antz.b(this.a)) });
      }
      this.a.notifyUI(2, true, new Object[] { Integer.valueOf(antz.b(this.a)) });
    } while (antz.b(this.a) != 0);
    if (!this.a.a.hasMessages(101)) {
      this.a.a.sendEmptyMessageDelayed(101, 3000L);
    }
    bghu.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anua
 * JD-Core Version:    0.7.0.1
 */