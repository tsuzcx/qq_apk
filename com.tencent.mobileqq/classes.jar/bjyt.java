import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

final class bjyt
  implements URLDrawable.URLDrawableListener
{
  bjyt(ImageView paramImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d("CommonUtils_", 1, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("CommonUtils_", 1, "onLoadFialed urldrawable load failed ");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.d("CommonUtils_", 1, "onLoadProgressed");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.setImageDrawable(paramURLDrawable);
    QLog.d("CommonUtils_", 1, "onLoadSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjyt
 * JD-Core Version:    0.7.0.1
 */