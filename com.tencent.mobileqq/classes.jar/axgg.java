import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import java.lang.ref.WeakReference;

public class axgg
  implements View.OnLongClickListener
{
  private WeakReference<ReceiptMessageDetailFragment> a;
  
  private axgg(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    this.a = new WeakReference(paramReceiptMessageDetailFragment);
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = (ReceiptMessageDetailFragment)this.a.get();
    if ((paramView == null) || (!paramView.isAdded())) {
      return false;
    }
    bhpy localbhpy = bhpy.a(paramView.getActivity());
    localbhpy.b(2131691356);
    localbhpy.c(2131690648);
    localbhpy.a(new axgh(this, paramView, localbhpy));
    localbhpy.show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axgg
 * JD-Core Version:    0.7.0.1
 */