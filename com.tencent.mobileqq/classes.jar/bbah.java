import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import java.lang.ref.WeakReference;

public class bbah
  implements View.OnLongClickListener
{
  private WeakReference<ReceiptMessageDetailFragment> a;
  
  private bbah(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    this.a = new WeakReference(paramReceiptMessageDetailFragment);
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = (ReceiptMessageDetailFragment)this.a.get();
    if ((paramView == null) || (!paramView.isAdded())) {
      return false;
    }
    bkzi localbkzi = bkzi.a(paramView.getActivity());
    localbkzi.b(2131691261);
    localbkzi.c(2131690697);
    localbkzi.a(new bbai(this, paramView, localbkzi));
    localbkzi.show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbah
 * JD-Core Version:    0.7.0.1
 */