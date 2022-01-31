import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;

class bbnx
  extends URLDrawableDownListener.Adapter
{
  bbnx(bbnw parambbnw) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.a.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.a.onLoadSuccessed(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbnx
 * JD-Core Version:    0.7.0.1
 */