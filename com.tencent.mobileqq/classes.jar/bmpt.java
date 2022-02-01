import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;

public class bmpt
  implements View.OnClickListener
{
  public bmpt(VideoTrackContainerView paramVideoTrackContainerView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!paramView.isSelected()) {
      paramView.setSelected(true);
    }
    if (VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView) != null) {
      VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpt
 * JD-Core Version:    0.7.0.1
 */