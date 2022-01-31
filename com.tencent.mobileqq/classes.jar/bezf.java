import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.open.agent.CardContainer;
import com.tencent.qphone.base.util.QLog;

public class bezf
  extends URLDrawableDownListener.Adapter
{
  public bezf(CardContainer paramCardContainer) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "-->drawabel onLoadCancelled, view: " + paramView);
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "-->drawabel onLoadFailed, view: " + paramView);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "-->drawabel onLoadInterrupted, view: " + paramView);
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    super.onLoadProgressed(paramView, paramURLDrawable, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "-->drawabel onLoadProgressed, view: " + paramView);
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "-->drawabel onLoadSuccessed, view: " + paramView);
    }
    CardContainer.a(this.a);
    ((AnyScaleTypeImageView)paramView).setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bezf
 * JD-Core Version:    0.7.0.1
 */