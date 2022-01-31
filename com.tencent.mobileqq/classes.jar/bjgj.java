import android.os.Handler;
import android.os.Message;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;

public class bjgj
  extends Handler
{
  public bjgj(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    this.a.onHandleMessage(QzoneVerticalVideoDownloadActivity.access$000(this.a), paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjgj
 * JD-Core Version:    0.7.0.1
 */