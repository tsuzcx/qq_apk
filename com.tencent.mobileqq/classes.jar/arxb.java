import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.qphone.base.util.QLog;

class arxb
  extends URLDrawableDownListener.Adapter
{
  arxb(arxa paramarxa) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 2, "onLoadFailed ,cause = " + paramThrowable);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 2, "onLoadInterrupted");
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
        ((ImageView)paramView).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((ImageView)paramView).setImageDrawable(paramURLDrawable);
        paramView.requestLayout();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 2, "onLoadSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxb
 * JD-Core Version:    0.7.0.1
 */