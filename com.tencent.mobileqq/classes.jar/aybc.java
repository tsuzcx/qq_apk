import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.ilive_new_anchor_follow_interface.FollowActionRsp;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class aybc
  implements axxd
{
  aybc(ayat paramayat) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      paramBundle = new oidb_0xada.RspBody();
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.i("PlayOperationViewModel", 2, "err_msg:   " + paramBundle.err_msg.get() + "  isFollow:" + ayat.c(this.a));
      }
      if (paramBundle.busi_buf.has())
      {
        paramArrayOfByte = new ilive_new_anchor_follow_interface.FollowActionRsp();
        paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
        if (QLog.isColorLevel()) {
          QLog.i("PlayOperationViewModel", 2, "ret:   " + paramArrayOfByte.ret.get() + ",msg:     " + paramArrayOfByte.msg.get() + "  isFollow:" + ayat.c(this.a));
        }
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybc
 * JD-Core Version:    0.7.0.1
 */