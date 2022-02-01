import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewGroup.MarginLayoutParams;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackTimeLineView;
import java.util.List;

public class bmpp
  implements Animator.AnimatorListener
{
  public bmpp(VideoTrackContainerView paramVideoTrackContainerView, bmod parambmod) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bmbx.b("miles", "动画取消");
    VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, false);
    VideoTrackContainerView.b(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, false);
    VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, null);
    VideoTrackContainerView.c(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, ((ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).get(VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).size() - 1)).getLayoutParams()).rightMargin);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bmbx.b("miles", "动画结束");
    VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, false);
    VideoTrackContainerView.b(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, false);
    VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, null);
    this.jdField_a_of_type_Bmod.a();
    VideoTrackContainerView.c(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, ((ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).get(VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).size() - 1)).getLayoutParams()).rightMargin);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpp
 * JD-Core Version:    0.7.0.1
 */