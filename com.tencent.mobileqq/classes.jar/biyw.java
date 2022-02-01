import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class biyw
  implements BusinessObserver
{
  biyw(biyp parambiyp, biyc parambiyc, boolean paramBoolean, biyy parambiyy, int paramInt, preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity) {}
  
  private void a(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "--> preAuth onFail mPreAuthRetryCount=", Integer.valueOf(biyp.c(this.jdField_a_of_type_Biyp)), ", errorCode=", Integer.valueOf(paramInt) });
    if (biyp.c(this.jdField_a_of_type_Biyp) < this.jdField_a_of_type_Int)
    {
      biyp.d(this.jdField_a_of_type_Biyp);
      this.jdField_a_of_type_Biyp.a(this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthRequest, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Biyc, this.jdField_a_of_type_Biyy, this.jdField_a_of_type_Int);
      return;
    }
    biyp.b(this.jdField_a_of_type_Biyp, 0);
    this.jdField_a_of_type_Biyy.a(paramInt, paramString);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry isSuccess=", Boolean.valueOf(paramBoolean), ", type=", Integer.valueOf(paramInt), ", mPreAuthRetryCount=", Integer.valueOf(biyp.c(this.jdField_a_of_type_Biyp)) });
    if (!paramBoolean)
    {
      aukw.a("KEY_PRE_AUTH", this.jdField_a_of_type_Biyc, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("data");
    if (arrayOfByte == null)
    {
      aukw.a("KEY_PRE_AUTH", this.jdField_a_of_type_Biyc, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    preAuth.PreAuthResponse localPreAuthResponse = new preAuth.PreAuthResponse();
    Object localObject = arrayOfByte;
    if (this.jdField_a_of_type_Boolean) {
      localObject = biyz.b(arrayOfByte, this.jdField_a_of_type_Biyc);
    }
    try
    {
      localObject = (preAuth.PreAuthResponse)localPreAuthResponse.mergeFrom((byte[])localObject);
      if ((((preAuth.PreAuthResponse)localObject).ret.has()) && (((preAuth.PreAuthResponse)localObject).ret.get() == 0))
      {
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "--> preAuth mergeFrom success");
        aukw.a("KEY_PRE_AUTH", this.jdField_a_of_type_Biyc, true);
        biyp.a(this.jdField_a_of_type_Biyp, (preAuth.PreAuthResponse)localObject);
        biyp.b(this.jdField_a_of_type_Biyp, 0);
        this.jdField_a_of_type_Biyy.a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("SDK_LOGIN.OpenSdkVirtualManager", 1, "Exception", localException);
      aukw.a("KEY_PRE_AUTH", this.jdField_a_of_type_Biyc, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "--> preAuth mergeFrom fail ret=", Integer.valueOf(localException.ret.get()), ", msg=", localException.msg.get() });
    aukw.a("KEY_PRE_AUTH", this.jdField_a_of_type_Biyc, false);
    a(localException.ret.get(), localException.msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     biyw
 * JD-Core Version:    0.7.0.1
 */