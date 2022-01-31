import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.qq.im.poi.LbsPackPoiListActivity;

public class anm
  implements Animation.AnimationListener
{
  public anm(LbsPackPoiListActivity paramLbsPackPoiListActivity, TranslateAnimation paramTranslateAnimation1, TranslateAnimation paramTranslateAnimation2, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      LbsPackPoiListActivity.a(this.jdField_a_of_type_ComQqImPoiLbsPackPoiListActivity).show();
      this.jdField_a_of_type_ComQqImPoiLbsPackPoiListActivity.b.setAnimation(null);
      this.jdField_a_of_type_ComQqImPoiLbsPackPoiListActivity.a.setVisibility(8);
    }
    while (paramAnimation != this.b) {
      return;
    }
    this.jdField_a_of_type_ComQqImPoiLbsPackPoiListActivity.b.setAnimation(null);
    this.jdField_a_of_type_ComQqImPoiLbsPackPoiListActivity.b.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComQqImPoiLbsPackPoiListActivity.b.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     anm
 * JD-Core Version:    0.7.0.1
 */