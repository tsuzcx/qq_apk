import android.graphics.Bitmap;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

public final class bhzk
  implements URLDrawable.URLDrawableListener
{
  public bhzk(int paramInt) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getCurrDrawable() instanceof RegionDrawable)) {
      ((RegionDrawable)paramURLDrawable.getCurrDrawable()).getBitmap().setDensity(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzk
 * JD-Core Version:    0.7.0.1
 */