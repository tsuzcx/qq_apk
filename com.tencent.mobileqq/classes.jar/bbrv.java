import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class bbrv
  extends Handler
{
  bbrv(bbru parambbru, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        do
        {
          return;
          this.a.a = ((List)paramMessage.obj);
          this.a.a(1000);
          return;
          this.a.a = ((List)paramMessage.obj);
          bbru.a(this.a);
          this.a.notifyObservers(Integer.valueOf(101));
        } while (!QLog.isColorLevel());
        QLog.d("TroopFeedsDataManager", 2, "end load feed: " + System.currentTimeMillis());
        return;
        this.a.a = ((List)paramMessage.obj);
        bbru.b(this.a);
        this.a.notifyObservers(Integer.valueOf(105));
      } while (!QLog.isColorLevel());
      QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, "end auto pull down feed");
      return;
    case 5: 
      bbru.c(this.a);
      this.a.notifyObservers(Integer.valueOf(1010));
      return;
    }
    bbru.d(this.a);
    this.a.notifyObservers(Integer.valueOf(103));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrv
 * JD-Core Version:    0.7.0.1
 */