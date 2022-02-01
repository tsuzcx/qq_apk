import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;

public class bofj
  implements View.OnClickListener
{
  public bofj(VideoTrackContainerView paramVideoTrackContainerView) {}
  
  public void onClick(View paramView)
  {
    this.a.d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bofj
 * JD-Core Version:    0.7.0.1
 */