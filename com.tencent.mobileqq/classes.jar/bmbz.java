import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker;
import java.lang.ref.WeakReference;
import java.util.List;

public class bmbz
  implements View.OnClickListener
{
  public bmbz(VideoSegmentPickerProviderView paramVideoSegmentPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    long l1 = 0L;
    bmcb localbmcb;
    long l2;
    if (VideoSegmentPickerProviderView.a(this.a) != null)
    {
      paramView = VideoSegmentPickerProviderView.a(this.a).a();
      VideoSegmentPickerProviderView.a(this.a).a.clearSegments();
      VideoSegmentPickerProviderView.a(this.a).a.addSegment(paramView);
      if (VideoSegmentPickerProviderView.a(this.a) != null)
      {
        localbmcb = (bmcb)VideoSegmentPickerProviderView.a(this.a).get();
        if (localbmcb != null)
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
      localbmcb.a(l2, l1);
      return;
      label145:
      l2 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbz
 * JD-Core Version:    0.7.0.1
 */