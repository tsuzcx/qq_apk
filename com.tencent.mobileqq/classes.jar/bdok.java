import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class bdok
  implements BusinessObserver
{
  bdok(bdod parambdod, bdnp parambdnp, bdon parambdon, int paramInt, preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity) {}
  
  private void a(int paramInt, String paramString)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "--> preAuth onFail mPreAuthRetryCount=", Integer.valueOf(bdod.c(this.jdField_a_of_type_Bdod)), ", errorCode=", Integer.valueOf(paramInt) });
    if (bdod.c(this.jdField_a_of_type_Bdod) < this.jdField_a_of_type_Int)
    {
      bdod.d(this.jdField_a_of_type_Bdod);
      this.jdField_a_of_type_Bdod.a(this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthRequest, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bdnp, this.jdField_a_of_type_Bdon, this.jdField_a_of_type_Int);
      return;
    }
    bdod.b(this.jdField_a_of_type_Bdod, 0);
    this.jdField_a_of_type_Bdon.a(paramInt, paramString);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry isSuccess=", Boolean.valueOf(paramBoolean), ", type=", Integer.valueOf(paramInt), ", mPreAuthRetryCount=", Integer.valueOf(bdod.c(this.jdField_a_of_type_Bdod)) });
    if (!paramBoolean)
    {
      aqgj.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bdnp, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("data");
    if (arrayOfByte == null)
    {
      aqgj.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bdnp, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    preAuth.PreAuthResponse localPreAuthResponse = new preAuth.PreAuthResponse();
    arrayOfByte = bdoo.b(arrayOfByte, this.jdField_a_of_type_Bdnp);
    try
    {
      localPreAuthResponse = (preAuth.PreAuthResponse)localPreAuthResponse.mergeFrom(arrayOfByte);
      if ((localPreAuthResponse.ret.has()) && (localPreAuthResponse.ret.get() == 0))
      {
        QLog.d("OpenSdkVirtualManager", 1, "--> preAuth mergeFrom success");
        aqgj.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bdnp, true);
        bdod.a(this.jdField_a_of_type_Bdod, localPreAuthResponse);
        bdod.b(this.jdField_a_of_type_Bdod, 0);
        this.jdField_a_of_type_Bdon.a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("OpenSdkVirtualManager", 1, "Exception", localException);
      aqgj.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bdnp, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "--> preAuth mergeFrom fail ret=", Integer.valueOf(localException.ret.get()), ", msg=", localException.msg.get() });
    aqgj.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bdnp, false);
    a(localException.ret.get(), localException.msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdok
 * JD-Core Version:    0.7.0.1
 */