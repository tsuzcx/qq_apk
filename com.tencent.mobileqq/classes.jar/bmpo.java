import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.aeeditor.view.timebar.ScaleTimeBar;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackTimeLineView;

public class bmpo
  implements ValueAnimator.AnimatorUpdateListener
{
  public bmpo(VideoTrackContainerView paramVideoTrackContainerView, bmod parambmod, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    ((VideoTrackTimeLineView)this.jdField_a_of_type_Bmod).d(i);
    VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).scrollTo(this.jdField_a_of_type_Int + VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).a(this.b - i), 0);
    paramValueAnimator = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView;
    int j = this.jdField_a_of_type_Int;
    paramValueAnimator.scrollTo(VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).a(this.b - i) + j, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpo
 * JD-Core Version:    0.7.0.1
 */