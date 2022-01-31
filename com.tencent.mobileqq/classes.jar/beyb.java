import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.2.1;

public class beyb
  extends ContentObserver
{
  public beyb(QzoneConfig paramQzoneConfig, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    ThreadManager.post(new QzoneConfig.2.1(this, paramBoolean), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyb
 * JD-Core Version:    0.7.0.1
 */