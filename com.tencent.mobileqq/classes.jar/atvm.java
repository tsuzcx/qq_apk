import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.qphone.base.util.QLog;

public class atvm
  implements URLDrawable.URLDrawableListener
{
  public atvm(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.i("NearbyMomentFragment", 1, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (NearbyMomentFragment.a(this.a) == 1) {
      NearbyMomentFragment.a(this.a).setVisibility(8);
    }
    QLog.i("NearbyMomentFragment", 1, "onLoadFialed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.i("NearbyMomentFragment", 1, "onLoadProgressed");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (NearbyMomentFragment.a(this.a) == 1)
    {
      NearbyMomentFragment.a(this.a).setImageDrawable(paramURLDrawable);
      NearbyMomentFragment.a(this.a).setVisibility(0);
    }
    QLog.i("NearbyMomentFragment", 1, "onLoadSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvm
 * JD-Core Version:    0.7.0.1
 */