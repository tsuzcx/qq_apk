import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import java.lang.ref.WeakReference;

public class bazn
  implements View.OnLongClickListener
{
  private WeakReference<ReceiptMessageDetailFragment> a;
  
  private bazn(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    this.a = new WeakReference(paramReceiptMessageDetailFragment);
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = (ReceiptMessageDetailFragment)this.a.get();
    if ((paramView == null) || (!paramView.isAdded())) {
      return false;
    }
    blir localblir = blir.a(paramView.getActivity());
    localblir.b(2131691137);
    localblir.c(2131690580);
    localblir.a(new bazo(this, paramView, localblir));
    localblir.show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazn
 * JD-Core Version:    0.7.0.1
 */