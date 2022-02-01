import android.os.Bundle;
import com.tencent.jungle.videohub.proto.CommProtocolProto.commResponse;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class aunp
  extends nmf
{
  aunp(aunn paramaunn, int paramInt1, int paramInt2, boolean paramBoolean, aunq paramaunq) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("sendPBRequest errorCode=").append(paramInt).append(" bundle=");
      if (paramBundle != null) {
        break label142;
      }
    }
    label142:
    for (Object localObject = "null";; localObject = paramBundle.toString())
    {
      QLog.d("ODCsChannel", 2, (String)localObject + " data=" + Arrays.toString(paramArrayOfByte));
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break label166;
      }
      QLog.i("ODCsChannel", 2, "login: fail，errorCode=" + paramInt + " data=" + Arrays.toString(paramArrayOfByte));
      if (this.jdField_a_of_type_Int <= 0) {
        break;
      }
      aunn.b(this.jdField_a_of_type_Aunn, this.c, paramArrayOfByte, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aunq);
      return;
    }
    aunn.a(this.jdField_a_of_type_Aunn, paramInt, null, paramBundle, this.jdField_a_of_type_Aunq);
    return;
    label166:
    localObject = new CommProtocolProto.commResponse();
    try
    {
      ((CommProtocolProto.commResponse)localObject).mergeFrom(paramArrayOfByte);
      if (((CommProtocolProto.commResponse)localObject).code.get() == 1008)
      {
        QLog.i("ODCsChannel", 2, "sendPBRequest: fail，token illegal, errorCode=1008");
        aunn.a(this.jdField_a_of_type_Aunn, this.c, paramArrayOfByte, this.b, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_Aunq);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        ((CommProtocolProto.commResponse)localObject).code.set(-10);
        QLog.e("ODCsChannel", 2, "sendPBRequest: error=" + localInvalidProtocolBufferMicroException.getMessage());
      }
      if (((CommProtocolProto.commResponse)localObject).code.get() == 1006)
      {
        QLog.i("ODCsChannel", 2, "sendPBRequest: fail，user sig illegal, errorCode=1006");
        this.jdField_a_of_type_Aunn.a(this.c, paramArrayOfByte, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_Aunq);
        return;
      }
      if ((((CommProtocolProto.commResponse)localObject).code.get() != 0) && (this.jdField_a_of_type_Int > 0))
      {
        QLog.i("ODCsChannel", 2, "sendPBRequest: fail，errorCode=" + ((CommProtocolProto.commResponse)localObject).code.get());
        aunn.b(this.jdField_a_of_type_Aunn, this.c, paramArrayOfByte, this.b, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_Aunq);
        return;
      }
      aunn.a(this.jdField_a_of_type_Aunn, paramInt, (CommProtocolProto.commResponse)localObject, paramBundle, this.jdField_a_of_type_Aunq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunp
 * JD-Core Version:    0.7.0.1
 */