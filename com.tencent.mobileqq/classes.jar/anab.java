import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView.VideoSegmentPickerListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.lang.ref.WeakReference;

public class anab
  implements View.OnClickListener
{
  public anab(VideoSegmentPickerProviderView paramVideoSegmentPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    VideoSegmentPickerProviderView.a(this.a).a.a();
    if (VideoSegmentPickerProviderView.a(this.a) != null)
    {
      paramView = (VideoSegmentPickerProviderView.VideoSegmentPickerListener)VideoSegmentPickerProviderView.a(this.a).get();
      if (paramView != null) {
        paramView.a(0L, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anab
 * JD-Core Version:    0.7.0.1
 */