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

class asxp
  implements ITransactionCallback
{
  asxp(asxn paramasxn, File paramFile, EIPCResult paramEIPCResult, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    QLog.i("qqidentification_server", 1, "BDH.Upload fail  : result:" + paramInt);
    asxn.a(this.jdField_a_of_type_Asxn);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097EC", "0X80097EC", 0, 0, "", "", this.c + "", "");
    this.jdField_a_of_type_EipcEIPCResult.code = -102;
    paramArrayOfByte = new Bundle();
    paramArrayOfByte.putInt("ret", 209);
    paramArrayOfByte.putString("subError", "UPLOAD onFailed I=" + paramInt);
    paramArrayOfByte.putString("errMsg", alud.a(2131706093));
    this.jdField_a_of_type_EipcEIPCResult.data = paramArrayOfByte;
    this.jdField_a_of_type_Asxn.callbackResult(asxn.a(this.jdField_a_of_type_Asxn), this.jdField_a_of_type_EipcEIPCResult);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    QLog.d("qqidentification_server", 1, "upload file success");
    asxn.a(this.jdField_a_of_type_Asxn);
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
        str = paramHashMap.ErrMsg.get();
        paramArrayOfByte.putString("errMsg", str);
        paramArrayOfByte.putBoolean("needRetry", paramHashMap.NeedRetry.get());
        QLog.d("qqidentification_server", 1, "retry: " + paramHashMap.NeedRetry.get() + " ret=" + i);
        paramArrayOfByte.putString("idKey", paramHashMap.IDKey.get());
        this.jdField_a_of_type_EipcEIPCResult.data = paramArrayOfByte;
        if (i != 0) {
          continue;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097ED", "0X80097ED", 0, 0, this.jdField_a_of_type_Int + "", "" + this.b, this.c + "", "");
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        int i;
        String str;
        QLog.e("qqidentification_server", 1, new Object[] { "parse bytes error : ", paramArrayOfByte.getMessage() });
        this.jdField_a_of_type_EipcEIPCResult.code = -102;
        paramArrayOfByte = new Bundle();
        paramArrayOfByte.putString("subError", "InvalidProtocolBufferMicroException");
        paramArrayOfByte.putInt("ret", 208);
        paramArrayOfByte.putString("errMsg", alud.a(2131706095));
        this.jdField_a_of_type_EipcEIPCResult.data = paramArrayOfByte;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097EC", "0X80097EC", 0, 0, this.jdField_a_of_type_Int + "", "" + this.b, this.c + "", "");
        continue;
      }
      this.jdField_a_of_type_Asxn.callbackResult(asxn.a(this.jdField_a_of_type_Asxn), this.jdField_a_of_type_EipcEIPCResult);
      return;
      QLog.e("qqidentification_server", 1, "request err: " + i + ", " + str);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097EE", "0X80097EE", 0, 0, this.jdField_a_of_type_Int + "", "" + this.b, this.c + "", i + "");
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxp
 * JD-Core Version:    0.7.0.1
 */