import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import face.qqlogin.faceproto.Response;
import java.io.File;
import java.util.HashMap;

class avqc
  implements ITransactionCallback
{
  avqc(avpz paramavpz, File paramFile, EIPCResult paramEIPCResult, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    QLog.i("qqidentification_server", 1, "BDH.Upload fail  : result:" + paramInt);
    avpz.a(this.jdField_a_of_type_Avpz);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097EC", "0X80097EC", 0, 0, "", "", this.c + "", "");
    this.jdField_a_of_type_EipcEIPCResult.code = -102;
    paramArrayOfByte = new Bundle();
    paramArrayOfByte.putInt("ret", 209);
    paramArrayOfByte.putString("subError", "UPLOAD onFailed I=" + paramInt);
    paramArrayOfByte.putString("errMsg", anvx.a(2131705182));
    this.jdField_a_of_type_EipcEIPCResult.data = paramArrayOfByte;
    this.jdField_a_of_type_Avpz.callbackResult(avpz.a(this.jdField_a_of_type_Avpz), this.jdField_a_of_type_EipcEIPCResult);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    QLog.d("qqidentification_server", 1, "upload file success");
    avpz.a(this.jdField_a_of_type_Avpz);
    this.jdField_a_of_type_JavaIoFile.delete();
    paramHashMap = new faceproto.Response();
    for (;;)
    {
      try
      {
        paramHashMap.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new Bundle();
        i = paramHashMap.Ret.get();
        paramArrayOfByte.putInt("ret", i);
        str1 = paramHashMap.ErrMsg.get();
        paramArrayOfByte.putString("errMsg", str1);
        paramArrayOfByte.putBoolean("needRetry", paramHashMap.NeedRetry.get());
        String str2 = paramHashMap.IDKey.get();
        QLog.d("qqidentification_server", 1, new Object[] { "retry: " + paramHashMap.NeedRetry.get() + " ret=" + i, "idKey : ", str2 });
        paramArrayOfByte.putString("idKey", str2);
        this.jdField_a_of_type_EipcEIPCResult.data = paramArrayOfByte;
        if (i != 0) {
          continue;
        }
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097ED", "0X80097ED", 0, 0, this.jdField_a_of_type_Int + "", "" + this.b, this.c + "", "");
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        int i;
        String str1;
        QLog.e("qqidentification_server", 1, new Object[] { "parse bytes error : ", paramArrayOfByte.getMessage() });
        this.jdField_a_of_type_EipcEIPCResult.code = -102;
        paramArrayOfByte = new Bundle();
        paramArrayOfByte.putString("subError", "InvalidProtocolBufferMicroException");
        paramArrayOfByte.putInt("ret", 208);
        paramArrayOfByte.putString("errMsg", anvx.a(2131705184));
        this.jdField_a_of_type_EipcEIPCResult.data = paramArrayOfByte;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097EC", "0X80097EC", 0, 0, this.jdField_a_of_type_Int + "", "" + this.b, this.c + "", "");
        continue;
      }
      this.jdField_a_of_type_Avpz.callbackResult(avpz.a(this.jdField_a_of_type_Avpz), this.jdField_a_of_type_EipcEIPCResult);
      return;
      QLog.e("qqidentification_server", 1, "request err: " + i + ", " + str1);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097EE", "0X80097EE", 0, 0, this.jdField_a_of_type_Int + "", "" + this.b, this.c + "", i + "");
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqc
 * JD-Core Version:    0.7.0.1
 */