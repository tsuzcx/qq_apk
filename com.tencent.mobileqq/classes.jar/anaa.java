import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView.VideoSegmentPickerListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker;
import java.lang.ref.WeakReference;
import java.util.List;

public class anaa
  implements View.OnClickListener
{
  public anaa(VideoSegmentPickerProviderView paramVideoSegmentPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    long l1 = 0L;
    VideoSegmentPickerProviderView.VideoSegmentPickerListener localVideoSegmentPickerListener;
    long l2;
    if (VideoSegmentPickerProviderView.a(this.a) != null)
    {
      paramView = VideoSegmentPickerProviderView.a(this.a).a();
      VideoSegmentPickerProviderView.a(this.a).a.a();
      VideoSegmentPickerProviderView.a(this.a).a.b(paramView);
      if (VideoSegmentPickerProviderView.a(this.a) != null)
      {
        localVideoSegmentPickerListener = (VideoSegmentPickerProviderView.VideoSegmentPickerListener)VideoSegmentPickerProviderView.a(this.a).get();
        if (localVideoSegmentPickerListener != null)
        {
          if ((paramView == null) || (paramView.size() <= 0)) {
            break label145;
          }
          l2 = ((Long)((Pair)paramView.get(0)).first).longValue();
          l1 = ((Long)((Pair)paramView.get(0)).second).longValue();
        }
      }
    }
    for (;;)
    {
      localVideoSegmentPickerListener.a(l2, l1);
      return;
      label145:
      l2 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anaa
 * JD-Core Version:    0.7.0.1
 */