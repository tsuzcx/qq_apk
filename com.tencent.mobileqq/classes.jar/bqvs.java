import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SlideBottomPanel;

public class bqvs
  implements ValueAnimator.AnimatorUpdateListener
{
  public bqvs(SlideBottomPanel paramSlideBottomPanel, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if ((paramValueAnimator instanceof Float))
    {
      this.jdField_a_of_type_AndroidViewView.setY(((Float)paramValueAnimator).floatValue());
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel.a != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel.a.fadeBackground(1.0F - ((Float)paramValueAnimator).floatValue() / (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel.b - this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSlideBottomPanel.j));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqvs
 * JD-Core Version:    0.7.0.1
 */