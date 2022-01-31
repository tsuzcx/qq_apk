import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5.Player;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5.RspBody;

class bcoh
  extends nab
{
  bcoh(bcod parambcod, bcoc parambcoc, String paramString1, String paramString2) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null) || (this.jdField_a_of_type_Bcoc == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6b5. onResult error=" + paramInt + " data=" + paramArrayOfByte + " callback=" + this.jdField_a_of_type_Bcoc);
      }
      if (this.jdField_a_of_type_Bcoc != null) {
        this.jdField_a_of_type_Bcoc.a(paramInt, "sso request error or callback is null.");
      }
      return;
    }
    oidb_0x6b5.RspBody localRspBody;
    try
    {
      localRspBody = new oidb_0x6b5.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      paramInt = localRspBody.uint32_result.get();
      if ((paramInt != 0) || (paramBundle == null)) {
        break label376;
      }
      paramInt = paramBundle.getInt("subCmd");
      if ((paramInt == 0) && (localRspBody.msg_grab_result.has()))
      {
        paramArrayOfByte = (oidb_0x6b5.Player)localRspBody.msg_grab_result.get();
        paramBundle = this.jdField_a_of_type_JavaLangString + "_" + this.b;
        paramBundle = (TroopGiftBagInfo)this.jdField_a_of_type_Bcod.a.get(paramBundle);
        if (paramBundle != null)
        {
          paramBundle.myGrabResult = new bbtq(paramArrayOfByte.uint64_uin.get(), paramArrayOfByte.uint64_time.get(), paramArrayOfByte.int32_amount.get(), paramArrayOfByte.int32_index.get(), paramArrayOfByte.bytes_tips.get().toStringUtf8());
          this.jdField_a_of_type_Bcod.a(paramBundle);
        }
        this.jdField_a_of_type_Bcoc.a(paramArrayOfByte.uint64_uin.get(), paramArrayOfByte.uint64_time.get(), paramArrayOfByte.int32_amount.get(), paramArrayOfByte.int32_index.get(), paramArrayOfByte.bytes_tips.get().toStringUtf8());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6b5. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
      }
      this.jdField_a_of_type_Bcoc.a(-1, "InvalidProtocolBufferMicroException");
      return;
    }
    this.jdField_a_of_type_Bcoc.a(-1, "Invalid RspData. subCmd:" + paramInt);
    return;
    label376:
    paramArrayOfByte = localRspBody.bytes_errmsg.get().toStringUtf8();
    this.jdField_a_of_type_Bcoc.a(paramInt, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcoh
 * JD-Core Version:    0.7.0.1
 */