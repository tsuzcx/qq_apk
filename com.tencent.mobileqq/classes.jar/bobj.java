import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import dov.com.qq.im.aeeditor.lyric.widget.LyricViewInternalBase;

public class bobj
  extends Handler
{
  public bobj(LyricViewInternalBase paramLyricViewInternalBase, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Log.d("ModuleLyricViewInternal", "mRefreshHandler -> handleMessage begin, mState:" + this.a.l);
    this.a.requestLayout();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bobj
 * JD-Core Version:    0.7.0.1
 */