import android.os.Bundle;
import com.tencent.jungle.videohub.proto.CommProtocolProto.commResponse;
import com.tencent.jungle.videohub.proto.CommonUserProto.LoginCheckRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class auno
  extends nmf
{
  auno(aunn paramaunn, int paramInt1, int paramInt2, aunq paramaunq) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("login: errorCode=").append(paramInt).append(" bundle=");
      if (paramBundle != null) {
        break label138;
      }
    }
    label138:
    for (Object localObject = "null";; localObject = paramBundle.toString())
    {
      QLog.d("ODCsChannel", 2, (String)localObject + " data=" + Arrays.toString(paramArrayOfByte));
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break label162;
      }
      QLog.i("ODCsChannel", 2, "login: fail，errorCode=" + paramInt + " data=" + Arrays.toString(paramArrayOfByte));
      if (this.jdField_a_of_type_Int <= 0) {
        break;
      }
      this.jdField_a_of_type_Aunn.a(this.c, paramArrayOfByte, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aunq);
      return;
    }
    aunn.a(this.jdField_a_of_type_Aunn, paramInt, null, paramBundle, this.jdField_a_of_type_Aunq);
    return;
    label162:
    localObject = new CommProtocolProto.commResponse();
    try
    {
      ((CommProtocolProto.commResponse)localObject).mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("ODCsChannel", 2, new Object[] { "MSF.C.NetConnTag", " code=" + ((CommProtocolProto.commResponse)localObject).code.get() + " msg=" + ((CommProtocolProto.commResponse)localObject).msg.get() + " seq=" + ((CommProtocolProto.commResponse)localObject).seq.get() + " data[]=" + Arrays.toString(((CommProtocolProto.commResponse)localObject).body.get().toByteArray()) });
      }
      if (((CommProtocolProto.commResponse)localObject).code.get() == 1008)
      {
        QLog.i("ODCsChannel", 2, "sendPBRequest: fail，token illegal, errorCode=1008");
        aunn.a(this.jdField_a_of_type_Aunn, this.c, paramArrayOfByte, true, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_Aunq);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException1.printStackTrace();
        ((CommProtocolProto.commResponse)localObject).code.set(-10);
        QLog.e("ODCsChannel", 2, "login: error=" + localInvalidProtocolBufferMicroException1.getMessage());
      }
      if (((CommProtocolProto.commResponse)localObject).code.get() != 0)
      {
        QLog.i("ODCsChannel", 2, "login: fail，errorCode=" + ((CommProtocolProto.commResponse)localObject).code.get() + " data=" + Arrays.toString(paramArrayOfByte));
        if (this.jdField_a_of_type_Int > 0)
        {
          this.jdField_a_of_type_Aunn.a(this.c, paramArrayOfByte, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aunq);
          return;
        }
        aunn.a(this.jdField_a_of_type_Aunn, paramInt, null, paramBundle, this.jdField_a_of_type_Aunq);
        return;
      }
      CommonUserProto.LoginCheckRsp localLoginCheckRsp = new CommonUserProto.LoginCheckRsp();
      try
      {
        localLoginCheckRsp.mergeFrom(((CommProtocolProto.commResponse)localObject).body.get().toByteArray());
        aunn.a(this.jdField_a_of_type_Aunn, localLoginCheckRsp);
        if (aunn.a(this.jdField_a_of_type_Aunn) == null)
        {
          QLog.i("ODCsChannel", 2, "login: fail，errorCode=" + paramInt + " data=" + Arrays.toString(paramArrayOfByte));
          if (this.jdField_a_of_type_Int > 0)
          {
            this.jdField_a_of_type_Aunn.a(this.c, paramArrayOfByte, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_Aunq);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException2.printStackTrace();
          QLog.e("ODCsChannel", 2, "startGroupVideoOrVoice error=" + localInvalidProtocolBufferMicroException2.getMessage());
        }
        aunn.a(this.jdField_a_of_type_Aunn, paramInt, (CommProtocolProto.commResponse)localObject, paramBundle, this.jdField_a_of_type_Aunq);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ODCsChannel", 2, new Object[] { "MSF.C.NetConnTag", " uid=" + localLoginCheckRsp.uid.get() + " user_sig=" + localLoginCheckRsp.user_sig.get() });
      }
      this.jdField_a_of_type_Aunn.a(this.c, paramArrayOfByte, true, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aunq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auno
 * JD-Core Version:    0.7.0.1
 */