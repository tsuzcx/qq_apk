import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;

public class bqmm
  implements ValueAnimator.AnimatorUpdateListener
{
  public bqmm(DoodleEditView paramDoodleEditView, bqrk parambqrk) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Bqrk.n = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqmm
 * JD-Core Version:    0.7.0.1
 */