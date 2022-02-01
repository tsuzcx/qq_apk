import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;

public class awxh
  extends Handler
{
  public awxh(LyricViewInternal paramLyricViewInternal, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.requestLayout();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxh
 * JD-Core Version:    0.7.0.1
 */