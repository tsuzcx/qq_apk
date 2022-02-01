import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;

class bhwd
  extends URLDrawableDownListener.Adapter
{
  bhwd(bhwc parambhwc) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.a.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.a.onLoadSuccessed(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhwd
 * JD-Core Version:    0.7.0.1
 */