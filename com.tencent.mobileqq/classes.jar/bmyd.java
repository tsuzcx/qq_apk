import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;

public class bmyd
  implements ValueAnimator.AnimatorUpdateListener
{
  public bmyd(AEAlbumLinearLayout paramAEAlbumLinearLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((paramValueAnimator.getAnimatedValue() instanceof Integer))
    {
      if (AEAlbumLinearLayout.a(this.a) != null) {
        AEAlbumLinearLayout.a(this.a).a(((Integer)paramValueAnimator.getAnimatedValue()).intValue() / (AEAlbumLinearLayout.a(this.a) * 1.0F));
      }
      this.a.scrollTo(0, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyd
 * JD-Core Version:    0.7.0.1
 */