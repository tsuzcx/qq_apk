import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListRsp;
import tencent.im.oidb.cmd0x985.oidb_0x985.RspBody;

public class bazy
  extends bbak<ReceiptMessageReadMemberListContainerFragment>
{
  public bazy(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment)
  {
    super(paramReceiptMessageReadMemberListContainerFragment);
  }
  
  void b(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "mGetMemberList request error on code: " + paramInt);
      }
    }
    do
    {
      return;
      try
      {
        paramBundle = new oidb_0x985.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramInt = paramBundle.uint32_code.get();
        if (paramInt == 0)
        {
          paramBundle = (oidb_0x985.GetReadListRsp)paramBundle.msg_get_read_list_rsp.get();
          paramArrayOfByte = paramBundle.rpt_msg_read_list.get();
          paramBundle = paramBundle.rpt_msg_unread_list.get();
          ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a, ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a, paramArrayOfByte));
          ReceiptMessageReadMemberListContainerFragment.b((ReceiptMessageReadMemberListContainerFragment)this.a, ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a, paramBundle));
          ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a).sendEmptyMessage(2);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "fetch read member fail on invalid data");
        return;
      }
      QLog.d("ReceiptMessageReadMemberListContainerFragment", 1, "mGetMemberList fail on code: " + paramInt);
      if (paramInt == 5)
      {
        ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a).sendEmptyMessage(-1);
        return;
      }
    } while (paramInt != 20);
    ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a).sendEmptyMessage(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazy
 * JD-Core Version:    0.7.0.1
 */