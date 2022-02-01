import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloGameViewBinder.GameListAdapter.2;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloGameViewBinder.GameListAdapter.2.1.1;

public class anqa
  implements Animation.AnimationListener
{
  public anqa(ApolloGameViewBinder.GameListAdapter.2 param2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(8);
    this.a.a.postDelayed(new ApolloGameViewBinder.GameListAdapter.2.1.1(this), 300L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqa
 * JD-Core Version:    0.7.0.1
 */