import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class amdc
  implements Animation.AnimationListener
{
  public amdc(SpecailCareListActivity paramSpecailCareListActivity, amdg paramamdg) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Amdg.c.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdc
 * JD-Core Version:    0.7.0.1
 */