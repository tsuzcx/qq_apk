import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;
import java.lang.ref.WeakReference;

public class bove
  implements View.OnClickListener
{
  public bove(VideoSegmentPickerProviderView paramVideoSegmentPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    VideoSegmentPickerProviderView.a(this.a).a.clearSegments();
    if (VideoSegmentPickerProviderView.a(this.a) != null)
    {
      bovf localbovf = (bovf)VideoSegmentPickerProviderView.a(this.a).get();
      if (localbovf != null) {
        localbovf.a(0L, 0L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bove
 * JD-Core Version:    0.7.0.1
 */