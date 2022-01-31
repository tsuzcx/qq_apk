import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;

public class bkdp
  implements ValueAnimator.AnimatorUpdateListener
{
  public bkdp(DoodleEditView paramDoodleEditView, bkin parambkin) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Bkin.n = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkdp
 * JD-Core Version:    0.7.0.1
 */