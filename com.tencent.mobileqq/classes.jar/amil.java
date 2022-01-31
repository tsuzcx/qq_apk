import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import common.config.service.QzoneConfig;

public class amil
  extends ContentObserver
{
  public amil(QzoneConfig paramQzoneConfig, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    ThreadManager.post(new amim(this, paramBoolean), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     amil
 * JD-Core Version:    0.7.0.1
 */