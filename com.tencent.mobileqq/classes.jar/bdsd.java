import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class bdsd
  extends URLDrawableDownListener.Adapter
{
  bdsd(bdsc parambdsc) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.ac, 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.ac, 2, "onLoadFailed ,cause = " + paramThrowable);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.ac, 2, "onLoadInterrupted");
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramView == null) {}
    do
    {
      return;
      paramView.setBackgroundDrawable(null);
      if ((paramView instanceof ImageView))
      {
        ((URLImageView)paramView).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((URLImageView)paramView).setImageDrawable(paramURLDrawable);
        paramView.requestLayout();
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.a.ac, 2, "onLoadSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsd
 * JD-Core Version:    0.7.0.1
 */