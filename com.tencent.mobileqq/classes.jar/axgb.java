import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.qphone.base.util.QLog;

public class axgb
  extends alsi
{
  public axgb(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment) {}
  
  public void a(long paramLong, int paramInt)
  {
    if (ReceiptMessageDetailFragment.b(this.a) == paramLong)
    {
      if (paramInt != 0) {
        break label78;
      }
      QLog.d("ReceiptMessageDetailFragment", 4, "send read report in c2c succ");
      ReceiptMessageDetailFragment.a(this.a, 0, 0, false);
      ReceiptMessageDetailFragment.a(this.a).removeObserver(this);
      if (this.a.isAdded())
      {
        ReceiptMessageDetailFragment.a(this.a).sendEmptyMessage(4);
        ReceiptMessageDetailFragment.a(this.a, 1, true);
      }
    }
    label78:
    do
    {
      return;
      QLog.d("ReceiptMessageDetailFragment", 4, "send read report in c2c fail with reply codes: " + paramInt);
      ReceiptMessageDetailFragment.a(this.a).removeObserver(this);
    } while (!this.a.isAdded());
    ReceiptMessageDetailFragment.a(this.a).sendEmptyMessage(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axgb
 * JD-Core Version:    0.7.0.1
 */