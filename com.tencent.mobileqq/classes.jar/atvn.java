import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;

public class atvn
  implements URLDrawable.URLDrawableListener
{
  public atvn(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (NearbyMomentFragment.a(this.a) == 0) {
      NearbyMomentFragment.a(this.a).setVisibility(8);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (NearbyMomentFragment.a(this.a) == 0)
    {
      NearbyMomentFragment.a(this.a).setVisibility(0);
      NearbyMomentFragment.a(this.a).setImageDrawable(paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvn
 * JD-Core Version:    0.7.0.1
 */