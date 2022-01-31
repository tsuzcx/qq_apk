import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;

public class bklt
  implements Animator.AnimatorListener
{
  public bklt(AEAlbumLinearLayout paramAEAlbumLinearLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEAlbumLinearLayout.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (AEAlbumLinearLayout.a(this.a) != null) {
      AEAlbumLinearLayout.a(this.a).a(AEAlbumLinearLayout.a(this.a), AEAlbumLinearLayout.a(this.a, AEAlbumLinearLayout.a(this.a)));
    }
    AEAlbumLinearLayout.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (AEAlbumLinearLayout.a(this.a) != null) {
      AEAlbumLinearLayout.a(this.a).a(AEAlbumLinearLayout.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bklt
 * JD-Core Version:    0.7.0.1
 */