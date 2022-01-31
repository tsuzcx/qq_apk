import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x984.oidb_0x984.RspBody;

public class avok
  extends avpi<ReceiptMessageDetailFragment>
{
  public avok(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    super(paramReceiptMessageDetailFragment);
  }
  
  void b(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      QLog.d("ReceiptMessageDetailFragment", 1, "getDiscussionSendReadReportCallback error on code: " + paramInt);
      return;
    }
    try
    {
      paramBundle = new oidb_0x984.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      if (paramBundle.uint32_code.get() == 0) {
        break label148;
      }
      QLog.d("ReceiptMessageDetailFragment", 1, "getDiscussionSendReadReportCallback fail on code: " + paramBundle.uint32_code.get());
      if (paramBundle.uint32_code.get() == 20)
      {
        ReceiptMessageDetailFragment.n((ReceiptMessageDetailFragment)this.a);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.d("ReceiptMessageDetailFragment", 1, "Report read status fail on invalid data");
      ReceiptMessageDetailFragment.n((ReceiptMessageDetailFragment)this.a);
      return;
    }
    ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a).sendEmptyMessage(5);
    return;
    label148:
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "getDiscussionSendReadReportCallback succ");
    }
    ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a, 0, 0, false);
    ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a).sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avok
 * JD-Core Version:    0.7.0.1
 */