import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.nearby.widget.AutoScrollImageView;

class ayen
  implements URLDrawable.URLDrawableListener
{
  ayen(ayek paramayek) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((paramURLDrawable instanceof RegionDrawable))
    {
      paramURLDrawable = ((RegionDrawable)paramURLDrawable).getBitmap();
      ayek.a(this.a).setImageBitmap(paramURLDrawable);
      ayek.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayen
 * JD-Core Version:    0.7.0.1
 */