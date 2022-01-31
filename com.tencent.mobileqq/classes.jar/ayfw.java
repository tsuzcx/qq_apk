import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.mobileqq.screendetect.ScreenShotDetector.MediaContentObserver.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ayfw
  extends ContentObserver
{
  private Uri a;
  
  public ayfw(ScreenShotDetector paramScreenShotDetector, Uri paramUri, Handler paramHandler)
  {
    super(paramHandler);
    this.jdField_a_of_type_AndroidNetUri = paramUri;
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (!aygf.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotDetector", 2, "ScreenShot: onChange screen switch is closed!");
      }
      return;
    }
    Object localObject = (Build.MANUFACTURER + Build.MODEL).trim().toLowerCase();
    String[] arrayOfString = ScreenShotDetector.a();
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      for (;;)
      {
        if ((i >= j) || (((String)localObject).contains(arrayOfString[i].toLowerCase()))) {
          try
          {
            localObject = BaseApplicationImpl.getApplication().getRuntime();
            if (((localObject instanceof QQAppInterface)) && (((QQAppInterface)localObject).a.b())) {
              break;
            }
            ThreadManager.getSubThreadHandler().post(new ScreenShotDetector.MediaContentObserver.1(this));
            return;
          }
          catch (Exception localException)
          {
            QLog.e("ScreenShotDetector", 2, "ScreenShot: onChange error!", localException);
            return;
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfw
 * JD-Core Version:    0.7.0.1
 */