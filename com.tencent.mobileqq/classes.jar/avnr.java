import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView;

class avnr
  extends AnimatorListenerAdapter
{
  avnr(avnq paramavnq) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (avnm.a(this.a.a) != null) {
      avnm.a(this.a.a).c();
    }
    avnm.a(this.a.a, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avnr
 * JD-Core Version:    0.7.0.1
 */