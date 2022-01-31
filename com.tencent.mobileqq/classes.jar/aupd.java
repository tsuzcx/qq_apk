import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import java.lang.ref.WeakReference;

public class aupd
  implements atpa
{
  private WeakReference<ReceiptMessageDetailFragment> a;
  
  public aupd(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    this.a = new WeakReference(paramReceiptMessageDetailFragment);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(atpb paramatpb)
  {
    ReceiptMessageDetailFragment localReceiptMessageDetailFragment = (ReceiptMessageDetailFragment)this.a.get();
    if (localReceiptMessageDetailFragment == null) {
      return;
    }
    switch (paramatpb.a)
    {
    default: 
      return;
    case -1: 
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).a().a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), null);
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(7);
      return;
    }
    ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).a().a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), null);
    ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aupd
 * JD-Core Version:    0.7.0.1
 */