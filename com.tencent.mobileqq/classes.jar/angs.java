import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.apollo.view.ApolloPanelListAdapter.1;
import com.tencent.mobileqq.apollo.view.ApolloPanelListAdapter.1.1.1;

public class angs
  implements Animation.AnimationListener
{
  public angs(ApolloPanelListAdapter.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(8);
    this.a.a.postDelayed(new ApolloPanelListAdapter.1.1.1(this), 300L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angs
 * JD-Core Version:    0.7.0.1
 */