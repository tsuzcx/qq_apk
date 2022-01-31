import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.lang.ref.WeakReference;

final class bbam
  implements URLDrawable.URLDrawableListener
{
  bbam(WeakReference paramWeakReference) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.a != null)
    {
      paramURLDrawable = (View)this.a.get();
      if (paramURLDrawable != null) {
        paramURLDrawable.postInvalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbam
 * JD-Core Version:    0.7.0.1
 */