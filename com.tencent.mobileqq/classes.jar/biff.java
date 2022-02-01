import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class biff
  implements BusinessObserver
{
  biff(biey parambiey, biej parambiej, boolean paramBoolean, bifh parambifh, int paramInt, preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity) {}
  
  private void a(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "--> preAuth onFail mPreAuthRetryCount=", Integer.valueOf(biey.c(this.jdField_a_of_type_Biey)), ", errorCode=", Integer.valueOf(paramInt) });
    if ((biey.c(this.jdField_a_of_type_Biey) < this.jdField_a_of_type_Int) && (paramInt != 110537) && (paramInt != 110509))
    {
      biey.d(this.jdField_a_of_type_Biey);
      this.jdField_a_of_type_Biey.a(this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthRequest, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Biej, this.jdField_a_of_type_Bifh, this.jdField_a_of_type_Int);
      return;
    }
    biey.b(this.jdField_a_of_type_Biey, 0);
    this.jdField_a_of_type_Bifh.a(paramInt, paramString);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry isSuccess=", Boolean.valueOf(paramBoolean), ", type=", Integer.valueOf(paramInt), ", mPreAuthRetryCount=", Integer.valueOf(biey.c(this.jdField_a_of_type_Biey)) });
    if (!paramBoolean)
    {
      atqa.a("KEY_PRE_AUTH", this.jdField_a_of_type_Biej, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("data");
    if (arrayOfByte == null)
    {
      atqa.a("KEY_PRE_AUTH", this.jdField_a_of_type_Biej, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    preAuth.PreAuthResponse localPreAuthResponse = new preAuth.PreAuthResponse();
    Object localObject = arrayOfByte;
    if (this.jdField_a_of_type_Boolean) {
      localObject = bifi.b(arrayOfByte, this.jdField_a_of_type_Biej);
    }
    try
    {
      localObject = (preAuth.PreAuthResponse)localPreAuthResponse.mergeFrom((byte[])localObject);
      if ((((preAuth.PreAuthResponse)localObject).ret.has()) && (((preAuth.PreAuthResponse)localObject).ret.get() == 0))
      {
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "--> preAuth mergeFrom success");
        atqa.a("KEY_PRE_AUTH", this.jdField_a_of_type_Biej, true);
        biey.a(this.jdField_a_of_type_Biey, (preAuth.PreAuthResponse)localObject);
        biey.b(this.jdField_a_of_type_Biey, 0);
        this.jdField_a_of_type_Bifh.a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("SDK_LOGIN.OpenSdkVirtualManager", 1, "Exception", localException);
      atqa.a("KEY_PRE_AUTH", this.jdField_a_of_type_Biej, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "--> preAuth mergeFrom fail ret=", Integer.valueOf(localException.ret.get()), ", msg=", localException.msg.get() });
    atqa.a("KEY_PRE_AUTH", this.jdField_a_of_type_Biej, false);
    a(localException.ret.get(), localException.msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     biff
 * JD-Core Version:    0.7.0.1
 */