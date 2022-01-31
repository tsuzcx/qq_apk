import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import java.lang.ref.WeakReference;

public class avol
  implements View.OnLongClickListener
{
  private WeakReference<ReceiptMessageDetailFragment> a;
  
  private avol(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    this.a = new WeakReference(paramReceiptMessageDetailFragment);
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = (ReceiptMessageDetailFragment)this.a.get();
    if ((paramView == null) || (!paramView.isAdded())) {
      return false;
    }
    bfpc localbfpc = bfpc.a(paramView.getActivity());
    localbfpc.b(2131691303);
    localbfpc.c(2131690596);
    localbfpc.a(new avom(this, paramView, localbfpc));
    localbfpc.show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avol
 * JD-Core Version:    0.7.0.1
 */