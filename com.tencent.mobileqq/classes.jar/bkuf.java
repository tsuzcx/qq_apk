import android.os.Message;
import android.widget.TextView;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

public class bkuf
  extends MqqHandler
{
  public bkuf(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = ShortVideoUtils.a(paramMessage.arg1);
    this.a.c.setText(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkuf
 * JD-Core Version:    0.7.0.1
 */