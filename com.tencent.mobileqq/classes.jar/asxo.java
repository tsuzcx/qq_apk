import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class asxo
  implements URLDrawable.URLDrawableListener
{
  asxo(asxn paramasxn) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UrlBottomImageSpan", 2, "onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UrlBottomImageSpan", 2, "onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UrlBottomImageSpan", 2, "onLoadProgressed i:" + paramInt);
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UrlBottomImageSpan", 2, "onLoadSuccessed");
    }
    paramURLDrawable = paramURLDrawable.getCallback();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof View)))
    {
      ((View)paramURLDrawable).invalidate();
      ((View)paramURLDrawable).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxo
 * JD-Core Version:    0.7.0.1
 */