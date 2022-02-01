import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseActivity.MyShakeListener.1;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class anqy
  extends aodk
{
  public void a()
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject == null) {
      ScreenShot.a("MyShakeListener - top activity is null");
    }
    do
    {
      return;
      if (!((BaseActivity)localObject).mCurrentActivityShakeFlag)
      {
        ScreenShot.a("MyShakeListener - shake flag is false");
        return;
      }
    } while (ThreadManager.getSubThreadHandler().hasMessages(1001));
    localObject = ThreadManager.getSubThreadHandler().obtainMessage(1001, new BaseActivity.MyShakeListener.1(this, (BaseActivity)localObject));
    ThreadManager.getSubThreadHandler().sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anqy
 * JD-Core Version:    0.7.0.1
 */