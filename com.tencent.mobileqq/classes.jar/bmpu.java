import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;

public class bmpu
  implements View.OnClickListener
{
  public bmpu(VideoTrackContainerView paramVideoTrackContainerView) {}
  
  public void onClick(View paramView)
  {
    if (VideoTrackContainerView.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = VideoTrackContainerView.a(this.a, (ImageView)paramView);
      if (i != -1)
      {
        VideoTrackContainerView.a(this.a, paramView);
        VideoTrackContainerView.a(this.a).a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpu
 * JD-Core Version:    0.7.0.1
 */