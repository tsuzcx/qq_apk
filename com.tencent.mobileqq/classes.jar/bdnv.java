import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class bdnv
  implements BusinessObserver
{
  bdnv(bdno parambdno, bdna parambdna, bdny parambdny, int paramInt, preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity) {}
  
  private void a(int paramInt, String paramString)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "--> preAuth onFail mPreAuthRetryCount=", Integer.valueOf(bdno.c(this.jdField_a_of_type_Bdno)), ", errorCode=", Integer.valueOf(paramInt) });
    if (bdno.c(this.jdField_a_of_type_Bdno) < this.jdField_a_of_type_Int)
    {
      bdno.d(this.jdField_a_of_type_Bdno);
      this.jdField_a_of_type_Bdno.a(this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthRequest, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bdna, this.jdField_a_of_type_Bdny, this.jdField_a_of_type_Int);
      return;
    }
    bdno.b(this.jdField_a_of_type_Bdno, 0);
    this.jdField_a_of_type_Bdny.a(paramInt, paramString);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry isSuccess=", Boolean.valueOf(paramBoolean), ", type=", Integer.valueOf(paramInt), ", mPreAuthRetryCount=", Integer.valueOf(bdno.c(this.jdField_a_of_type_Bdno)) });
    if (!paramBoolean)
    {
      aqgh.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bdna, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("data");
    if (arrayOfByte == null)
    {
      aqgh.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bdna, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    preAuth.PreAuthResponse localPreAuthResponse = new preAuth.PreAuthResponse();
    arrayOfByte = bdnz.b(arrayOfByte, this.jdField_a_of_type_Bdna);
    try
    {
      localPreAuthResponse = (preAuth.PreAuthResponse)localPreAuthResponse.mergeFrom(arrayOfByte);
      if ((localPreAuthResponse.ret.has()) && (localPreAuthResponse.ret.get() == 0))
      {
        QLog.d("OpenSdkVirtualManager", 1, "--> preAuth mergeFrom success");
        aqgh.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bdna, true);
        bdno.a(this.jdField_a_of_type_Bdno, localPreAuthResponse);
        bdno.b(this.jdField_a_of_type_Bdno, 0);
        this.jdField_a_of_type_Bdny.a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("OpenSdkVirtualManager", 1, "Exception", localException);
      aqgh.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bdna, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "--> preAuth mergeFrom fail ret=", Integer.valueOf(localException.ret.get()), ", msg=", localException.msg.get() });
    aqgh.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bdna, false);
    a(localException.ret.get(), localException.msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdnv
 * JD-Core Version:    0.7.0.1
 */