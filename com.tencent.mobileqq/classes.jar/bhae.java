import android.os.Handler;
import android.os.Message;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;

public class bhae
  extends Handler
{
  public bhae(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    this.a.onHandleMessage(QzoneVerticalVideoDownloadActivity.access$000(this.a), paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhae
 * JD-Core Version:    0.7.0.1
 */