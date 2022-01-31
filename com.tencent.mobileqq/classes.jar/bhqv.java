import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;
import java.lang.ref.WeakReference;

public class bhqv
  implements View.OnClickListener
{
  public bhqv(VideoSegmentPickerProviderView paramVideoSegmentPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    VideoSegmentPickerProviderView.a(this.a).a.clearSegments();
    if (VideoSegmentPickerProviderView.a(this.a) != null)
    {
      paramView = (bhqw)VideoSegmentPickerProviderView.a(this.a).get();
      if (paramView != null) {
        paramView.a(0L, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhqv
 * JD-Core Version:    0.7.0.1
 */