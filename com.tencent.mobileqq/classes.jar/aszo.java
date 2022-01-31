import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.qphone.base.util.QLog;

public class aszo
  extends Handler
{
  public aszo(NearbyFakeActivity paramNearbyFakeActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyFakeActivity", 2, "procPreload time out");
      }
      NearbyFakeActivity.a(this.a, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aszo
 * JD-Core Version:    0.7.0.1
 */