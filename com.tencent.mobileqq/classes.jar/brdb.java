import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;

public class brdb
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public brdb(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onGlobalLayout()
  {
    ThreadManager.post(this.a, 8, null, false);
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     brdb
 * JD-Core Version:    0.7.0.1
 */