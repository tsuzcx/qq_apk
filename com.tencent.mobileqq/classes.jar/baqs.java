import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.mobileqq.screendetect.ScreenShotDetector.MediaContentObserver.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class baqs
  extends ContentObserver
{
  private Uri a;
  
  public baqs(ScreenShotDetector paramScreenShotDetector, Uri paramUri, Handler paramHandler)
  {
    super(paramHandler);
    this.jdField_a_of_type_AndroidNetUri = paramUri;
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector.a()) {
      return;
    }
    try
    {
      ThreadManager.getSubThreadHandler().post(new ScreenShotDetector.MediaContentObserver.1(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ScreenShotDetector", 2, "ScreenShot: onChange error!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqs
 * JD-Core Version:    0.7.0.1
 */