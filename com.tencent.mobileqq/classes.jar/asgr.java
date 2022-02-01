import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class asgr
  implements Handler.Callback
{
  asgr(asgq paramasgq) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      this.a.b = true;
      QLog.i("EmoticonFromGroup_DBManager", 1, "set db tag, mCanWriteDataToDB = true.");
    } while (this.a.b() < 300);
    asgq.a(this.a).clear();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgr
 * JD-Core Version:    0.7.0.1
 */