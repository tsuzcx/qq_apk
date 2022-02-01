import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public abstract class bfcc
  implements BusinessObserver
{
  protected abstract void a(long paramLong);
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      String str = "success = [" + paramBoolean + "], [" + paramBundle + "]";
      QLog.i("GroupAppsObserver", 2, " onReceive: invoked. " + str);
    }
    if (!paramBoolean) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBundle.getLong("KEY_GROUP_UIN"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfcc
 * JD-Core Version:    0.7.0.1
 */