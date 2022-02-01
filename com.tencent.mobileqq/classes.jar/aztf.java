import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView;

class aztf
  extends AnimatorListenerAdapter
{
  aztf(aztc paramaztc) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (aztc.a(this.a) != null) {
      aztc.a(this.a).c();
    }
    aztc.a(this.a, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztf
 * JD-Core Version:    0.7.0.1
 */