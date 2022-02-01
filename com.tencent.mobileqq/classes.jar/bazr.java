import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x986.oidb_0x986.RspBody;

public class bazr
  extends bbak<ReceiptMessageDetailFragment>
{
  public bazr(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    super(paramReceiptMessageDetailFragment);
  }
  
  void b(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "mTroopFetchReadStatusCallback onRes: " + paramInt);
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "mTroopFetchReadStatusCallback succ");
      }
      paramBundle = new oidb_0x986.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      paramInt = paramBundle.uint32_read_uin_num.get();
      ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a, paramInt, true);
      ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a, paramInt, 2147483647, true);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.d("ReceiptMessageDetailFragment", 1, "fetch read member fail on invalid data");
      ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a).sendEmptyMessage(20);
    }
    ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a).sendEmptyMessage(20);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazr
 * JD-Core Version:    0.7.0.1
 */