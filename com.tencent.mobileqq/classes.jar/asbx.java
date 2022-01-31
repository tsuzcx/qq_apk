import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;

public class asbx
  extends Handler
{
  public asbx(LyricViewInternal paramLyricViewInternal, Looper paramLooper)
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
 * Qualified Name:     asbx
 * JD-Core Version:    0.7.0.1
 */