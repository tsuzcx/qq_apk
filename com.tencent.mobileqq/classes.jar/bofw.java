import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import dov.com.qq.im.aeeditor.view.videotrack.RoundFrameLayout;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackTimeLineView;

public class bofw
  extends AnimatorListenerAdapter
{
  public bofw(VideoTrackTimeLineView paramVideoTrackTimeLineView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VideoTrackTimeLineView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView).removeView(this.jdField_a_of_type_AndroidViewView);
    VideoTrackTimeLineView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bofw
 * JD-Core Version:    0.7.0.1
 */