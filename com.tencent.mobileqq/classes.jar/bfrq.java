import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class bfrq
  implements BusinessObserver
{
  bfrq(bfrj parambfrj, bfqv parambfqv, boolean paramBoolean, bfrt parambfrt, int paramInt, preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity) {}
  
  private void a(int paramInt, String paramString)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "--> preAuth onFail mPreAuthRetryCount=", Integer.valueOf(bfrj.c(this.jdField_a_of_type_Bfrj)), ", errorCode=", Integer.valueOf(paramInt) });
    if (bfrj.c(this.jdField_a_of_type_Bfrj) < this.jdField_a_of_type_Int)
    {
      bfrj.d(this.jdField_a_of_type_Bfrj);
      this.jdField_a_of_type_Bfrj.a(this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthRequest, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bfqv, this.jdField_a_of_type_Bfrt, this.jdField_a_of_type_Int);
      return;
    }
    bfrj.b(this.jdField_a_of_type_Bfrj, 0);
    this.jdField_a_of_type_Bfrt.a(paramInt, paramString);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry isSuccess=", Boolean.valueOf(paramBoolean), ", type=", Integer.valueOf(paramInt), ", mPreAuthRetryCount=", Integer.valueOf(bfrj.c(this.jdField_a_of_type_Bfrj)) });
    if (!paramBoolean)
    {
      aseh.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bfqv, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("data");
    if (arrayOfByte == null)
    {
      aseh.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bfqv, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    preAuth.PreAuthResponse localPreAuthResponse = new preAuth.PreAuthResponse();
    Object localObject = arrayOfByte;
    if (!this.jdField_a_of_type_Boolean) {
      localObject = bfru.b(arrayOfByte, this.jdField_a_of_type_Bfqv);
    }
    try
    {
      localObject = (preAuth.PreAuthResponse)localPreAuthResponse.mergeFrom((byte[])localObject);
      if ((((preAuth.PreAuthResponse)localObject).ret.has()) && (((preAuth.PreAuthResponse)localObject).ret.get() == 0))
      {
        QLog.d("OpenSdkVirtualManager", 1, "--> preAuth mergeFrom success");
        aseh.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bfqv, true);
        bfrj.a(this.jdField_a_of_type_Bfrj, (preAuth.PreAuthResponse)localObject);
        bfrj.b(this.jdField_a_of_type_Bfrj, 0);
        this.jdField_a_of_type_Bfrt.a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("OpenSdkVirtualManager", 1, "Exception", localException);
      aseh.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bfqv, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "--> preAuth mergeFrom fail ret=", Integer.valueOf(localException.ret.get()), ", msg=", localException.msg.get() });
    aseh.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bfqv, false);
    a(localException.ret.get(), localException.msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfrq
 * JD-Core Version:    0.7.0.1
 */