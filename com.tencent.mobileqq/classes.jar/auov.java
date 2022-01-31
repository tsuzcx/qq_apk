import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.qphone.base.util.QLog;

public class auov
  implements URLDrawableDownListener
{
  public auov(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "URLDrawableDownListener onLoadCancelled: ");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "URLDrawableDownListener onLoadFailed: ");
    }
    ReceiptMessageDetailFragment.a(this.a).setVisibility(8);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "URLDrawableDownListener onLoadInterrupted: ");
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "URLDrawableDownListener onLoadProgressed: " + paramURLDrawable + " / " + paramInt);
    }
    ReceiptMessageDetailFragment.a(this.a).setLevel(paramInt);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    ReceiptMessageDetailFragment.a(this.a).setVisibility(8);
    ReceiptMessageDetailFragment.a(this.a, paramURLDrawable);
    ReceiptMessageDetailFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auov
 * JD-Core Version:    0.7.0.1
 */