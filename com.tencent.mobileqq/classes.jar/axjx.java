import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView;

class axjx
  extends AnimatorListenerAdapter
{
  axjx(axjw paramaxjw) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (axjs.a(this.a.a) != null) {
      axjs.a(this.a.a).c();
    }
    axjs.a(this.a.a, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axjx
 * JD-Core Version:    0.7.0.1
 */