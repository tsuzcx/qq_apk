import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView;

public class bmes
  extends Handler
{
  public bmes(LyricWithBuoyView paramLyricWithBuoyView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmes
 * JD-Core Version:    0.7.0.1
 */