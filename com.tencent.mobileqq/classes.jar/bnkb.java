import android.os.Message;
import android.widget.TextView;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

public class bnkb
  extends MqqHandler
{
  public bnkb(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = ShortVideoUtils.a(paramMessage.arg1);
    this.a.c.setText(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkb
 * JD-Core Version:    0.7.0.1
 */