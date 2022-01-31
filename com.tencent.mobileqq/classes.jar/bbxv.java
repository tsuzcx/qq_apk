import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.qphone.base.util.QLog;

public class bbxv
  extends URLDrawableDownListener.Adapter
{
  public bbxv(OpenCardContainer paramOpenCardContainer) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("OpenCardContainer", 2, "-->drawabel onLoadCancelled, view: " + paramView);
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenCardContainer", 2, "-->drawabel onLoadFailed, view: " + paramView);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
    if (QLog.isColorLevel()) {
      QLog.d("OpenCardContainer", 2, "-->drawabel onLoadInterrupted, view: " + paramView);
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    super.onLoadProgressed(paramView, paramURLDrawable, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("OpenCardContainer", 2, "-->drawabel onLoadProgressed, view: " + paramView);
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenCardContainer", 2, "-->drawabel onLoadSuccessed, view: " + paramView);
    }
    OpenCardContainer.a(this.a);
    ((AnyScaleTypeImageView)paramView).setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbxv
 * JD-Core Version:    0.7.0.1
 */