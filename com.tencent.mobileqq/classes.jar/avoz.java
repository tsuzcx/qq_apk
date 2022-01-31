import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.oidb.cmd0x986.oidb_0x986.RspBody;

public class avoz
  extends avpi<ReceiptMessageReadMemberListContainerFragment>
{
  public avoz(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment)
  {
    super(paramReceiptMessageReadMemberListContainerFragment);
  }
  
  void b(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageReadMemberListContainerFragment", 4, "mTroopFetchReadMemberListCallback onRes: " + paramInt);
    }
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      for (;;)
      {
        try
        {
          paramBundle = new oidb_0x986.RspBody();
          paramBundle.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = paramBundle.rpt_msg_uin_info.get();
          paramArrayOfByte = ReceiptMessageReadMemberListContainerFragment.b((ReceiptMessageReadMemberListContainerFragment)this.a, paramArrayOfByte).iterator();
          if (!paramArrayOfByte.hasNext()) {
            break;
          }
          ReceiptMessageReadMemberListFragment.MemberInfo localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)paramArrayOfByte.next();
          if (!Long.toString(ReceiptMessageReadMemberListContainerFragment.d((ReceiptMessageReadMemberListContainerFragment)this.a)).equals(localMemberInfo.jdField_a_of_type_JavaLangString)) {
            if (localMemberInfo.jdField_a_of_type_Long > 0L) {
              ReceiptMessageReadMemberListContainerFragment.b((ReceiptMessageReadMemberListContainerFragment)this.a).add(localMemberInfo);
            } else {
              ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a).add(localMemberInfo);
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "fetch read member fail on invalid data");
          ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a).sendEmptyMessage(-1);
          return;
        }
      }
      if (paramBundle.uint64_next_uin.get() == 0L)
      {
        ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a).sendEmptyMessage(2);
        return;
      }
      paramArrayOfByte = ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a).obtainMessage(3, Long.valueOf(paramBundle.uint64_next_uin.get()));
      ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a).sendMessage(paramArrayOfByte);
      return;
    }
    ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a).sendEmptyMessage(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avoz
 * JD-Core Version:    0.7.0.1
 */