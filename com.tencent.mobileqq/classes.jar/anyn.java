import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;

public class anyn
  implements ValueAnimator.AnimatorUpdateListener
{
  public anyn(DoodleEditView paramDoodleEditView, GestureHelper.ZoomItem paramZoomItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.n = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anyn
 * JD-Core Version:    0.7.0.1
 */