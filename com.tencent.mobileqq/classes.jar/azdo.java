import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class azdo
  extends AnimatorListenerAdapter
{
  azdo(azdh paramazdh) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (azdh.a(this.a) != null) {
      azdh.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdo
 * JD-Core Version:    0.7.0.1
 */