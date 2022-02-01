import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListRsp;
import tencent.im.oidb.cmd0x985.oidb_0x985.RspBody;

public class aztx
  extends azuw<ReceiptMessageDetailFragment>
{
  public aztx(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    super(paramReceiptMessageDetailFragment);
  }
  
  void b(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      QLog.d("ReceiptMessageDetailFragment", 1, "mDiscussionFetchReadStatusCallback request error on code: " + paramInt);
      return;
    }
    try
    {
      paramBundle = new oidb_0x985.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      paramInt = paramBundle.uint32_code.get();
      if (paramInt == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReceiptMessageDetailFragment", 2, "mDiscussionFetchReadStatusCallback succ");
        }
        paramBundle = (oidb_0x985.GetReadListRsp)paramBundle.msg_get_read_list_rsp.get();
        paramArrayOfByte = paramBundle.rpt_msg_read_list.get();
        paramBundle = paramBundle.rpt_msg_unread_list.get();
        ReceiptMessageDetailFragment localReceiptMessageDetailFragment = (ReceiptMessageDetailFragment)this.a;
        paramInt = paramArrayOfByte.size();
        int i = paramArrayOfByte.size();
        ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, paramInt, paramBundle.size() + i, true);
        paramInt = paramArrayOfByte.size();
        ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a, paramInt, true);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.d("ReceiptMessageDetailFragment", 2, "fetch read member fail on invalid data");
      return;
    }
    QLog.d("ReceiptMessageDetailFragment", 1, "mDiscussionFetchReadStatusCallback fail on code: " + paramInt);
    ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a).sendEmptyMessage(20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztx
 * JD-Core Version:    0.7.0.1
 */