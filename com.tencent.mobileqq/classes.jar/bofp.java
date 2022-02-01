import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.aeeditor.view.playtrack.view.PlayTrackExpandWidthView;
import dov.com.qq.im.aeeditor.view.timebar.ScaleTimeBar;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackTimeLineView;

public class bofp
  implements ValueAnimator.AnimatorUpdateListener
{
  public bofp(VideoTrackContainerView paramVideoTrackContainerView, bodv parambodv, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    ((VideoTrackTimeLineView)this.jdField_a_of_type_Bodv).b(i);
    int j = this.jdField_a_of_type_Int;
    i = VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).a(this.b - i) + j;
    ((VideoTrackTimeLineView)this.jdField_a_of_type_Bodv).a().scrollTo(i, 0);
    VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).scrollTo(i, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bofp
 * JD-Core Version:    0.7.0.1
 */