import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.qphone.base.util.QLog;

public class avoh
  extends akat
{
  public avoh(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment) {}
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    if (ReceiptMessageDetailFragment.c(this.a) == paramLong1)
    {
      if (paramInt != 0) {
        break label109;
      }
      QLog.d("ReceiptMessageDetailFragment", 4, "get read status in c2c succs with readtime: " + paramLong2);
      if (paramLong2 > 0L) {
        ReceiptMessageDetailFragment.a(this.a, 1, 1, true);
      }
      if (this.a.isAdded())
      {
        ReceiptMessageDetailFragment localReceiptMessageDetailFragment = this.a;
        if (paramLong2 <= 0L) {
          break label104;
        }
        paramInt = 1;
        ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, paramInt, true);
      }
      ReceiptMessageDetailFragment.a(this.a).removeObserver(this);
    }
    label104:
    label109:
    do
    {
      return;
      paramInt = 0;
      break;
      QLog.d("ReceiptMessageDetailFragment", 4, "get read status in c2c fail with reply code: " + paramInt);
      ReceiptMessageDetailFragment.a(this.a).removeObserver(this);
    } while (!this.a.isAdded());
    ReceiptMessageDetailFragment.a(this.a).sendEmptyMessage(20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avoh
 * JD-Core Version:    0.7.0.1
 */