import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0x8da.oidb_0x8da.RspBody;
import tencent.im.oidb.oidb_0x8da.oidb_0x8da.TinyInfo;

class asdh
  extends mmk
{
  asdh(asdf paramasdf, asco paramasco, long paramLong) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q..troop.faceScore", 2, "onResult errorCode=" + paramInt + ", data=" + paramArrayOfByte);
    }
    if (paramInt == 0)
    {
      if (paramArrayOfByte != null) {
        for (;;)
        {
          try
          {
            paramBundle = new oidb_0x8da.RspBody();
            paramBundle.mergeFrom(paramArrayOfByte);
            paramArrayOfByte = paramBundle.rpt_msg_tiny_info.get().iterator();
            if (paramArrayOfByte.hasNext())
            {
              paramBundle = (oidb_0x8da.TinyInfo)paramArrayOfByte.next();
              if (paramBundle.uint32_result.get() == 0) {
                this.jdField_a_of_type_Asco.a(paramBundle.uint64_uin.get(), paramBundle.uint64_tinyid.get());
              }
            }
            else
            {
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q..troop.faceScore", 2, "onResult exception=" + paramArrayOfByte.toString());
            }
            this.jdField_a_of_type_Asco.a(this.jdField_a_of_type_Long, -1L);
          }
          this.jdField_a_of_type_Asco.a(this.jdField_a_of_type_Long, -1L);
          QLog.e("Q..troop.faceScore", 2, "getTinyIdByUin oidb_0x8da onResult  uin=" + paramBundle.uint64_uin.get() + " tinyid=" + paramBundle.uint64_tinyid.get() + " result=" + paramBundle.uint32_result.get());
        }
      }
      this.jdField_a_of_type_Asco.a(this.jdField_a_of_type_Long, -1L);
      return;
    }
    this.jdField_a_of_type_Asco.a(this.jdField_a_of_type_Long, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asdh
 * JD-Core Version:    0.7.0.1
 */