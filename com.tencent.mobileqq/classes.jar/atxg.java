import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;

public class atxg
  extends Handler
{
  public atxg(LyricViewInternal paramLyricViewInternal, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.requestLayout();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atxg
 * JD-Core Version:    0.7.0.1
 */