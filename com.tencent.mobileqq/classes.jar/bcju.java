import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class bcju
  implements BusinessObserver
{
  bcju(bcjn parambcjn, bciz parambciz, bcjx parambcjx, int paramInt, preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity) {}
  
  private void a(int paramInt, String paramString)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "--> preAuth onFail mPreAuthRetryCount=", Integer.valueOf(bcjn.c(this.jdField_a_of_type_Bcjn)), ", errorCode=", Integer.valueOf(paramInt) });
    if (bcjn.c(this.jdField_a_of_type_Bcjn) < this.jdField_a_of_type_Int)
    {
      bcjn.d(this.jdField_a_of_type_Bcjn);
      this.jdField_a_of_type_Bcjn.a(this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthRequest, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bciz, this.jdField_a_of_type_Bcjx, this.jdField_a_of_type_Int);
      return;
    }
    bcjn.b(this.jdField_a_of_type_Bcjn, 0);
    this.jdField_a_of_type_Bcjx.a(paramInt, paramString);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry isSuccess=", Boolean.valueOf(paramBoolean), ", type=", Integer.valueOf(paramInt), ", mPreAuthRetryCount=", Integer.valueOf(bcjn.c(this.jdField_a_of_type_Bcjn)) });
    apmt.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bciz);
    if (!paramBoolean)
    {
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    preAuth.PreAuthResponse localPreAuthResponse = new preAuth.PreAuthResponse();
    byte[] arrayOfByte = bcjy.b(paramBundle.getByteArray("data"), this.jdField_a_of_type_Bciz);
    try
    {
      localPreAuthResponse = (preAuth.PreAuthResponse)localPreAuthResponse.mergeFrom(arrayOfByte);
      if ((localPreAuthResponse.ret.has()) && (localPreAuthResponse.ret.get() == 0))
      {
        QLog.d("OpenSdkVirtualManager", 1, "--> preAuth mergeFrom success");
        this.jdField_a_of_type_Bcjn.a(localPreAuthResponse);
        bcjn.b(this.jdField_a_of_type_Bcjn, 0);
        this.jdField_a_of_type_Bcjx.a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("OpenSdkVirtualManager", 1, "Exception", localException);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "--> preAuth mergeFrom fail ret=", Integer.valueOf(localException.ret.get()), ", msg=", localException.msg.get() });
    a(localException.ret.get(), localException.msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcju
 * JD-Core Version:    0.7.0.1
 */