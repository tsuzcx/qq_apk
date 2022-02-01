import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class amjx
  implements Animation.AnimationListener
{
  public amjx(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.leftView.clearAnimation();
    this.a.a.clearAnimation();
    this.a.leftView.setVisibility(4);
    this.a.a.setVisibility(8);
    this.a.rightViewText.setClickable(true);
    this.a.rightViewText.setText(SpecailCareListActivity.b);
    this.a.rightViewText.setContentDescription(anzj.a(2131713110));
    this.a.c = true;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjx
 * JD-Core Version:    0.7.0.1
 */