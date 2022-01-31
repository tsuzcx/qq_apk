import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class avne
  implements Animation.AnimationListener
{
  avne(avmf paramavmf) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == avmf.b(this.a))
    {
      avmf.a(this.a).setVisibility(8);
      avmf.a(this.a).setVisibility(4);
      avmf.a(this.a).clearAnimation();
      avmf.a(this.a).clearAnimation();
      avmf.a(this.a).setBackgroundResource(2130848660);
      avmf.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166606));
      avmf.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166606));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == avmf.a(this.a))
    {
      avmf.a(this.a).setVisibility(0);
      avmf.a(this.a).setVisibility(0);
      avmf.a(this.a).setBackgroundResource(2130850060);
      avmf.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166897));
      avmf.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166897));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avne
 * JD-Core Version:    0.7.0.1
 */