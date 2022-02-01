import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class bjqh
  implements BusinessObserver
{
  bjqh(bjqa parambjqa, bjpl parambjpl, boolean paramBoolean, bjqj parambjqj, int paramInt, preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity) {}
  
  private void a(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "--> preAuth onFail mPreAuthRetryCount=", Integer.valueOf(bjqa.c(this.jdField_a_of_type_Bjqa)), ", errorCode=", Integer.valueOf(paramInt) });
    if ((bjqa.c(this.jdField_a_of_type_Bjqa) < this.jdField_a_of_type_Int) && (paramInt != 110537) && (paramInt != 110509))
    {
      bjqa.d(this.jdField_a_of_type_Bjqa);
      this.jdField_a_of_type_Bjqa.a(this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthRequest, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bjpl, this.jdField_a_of_type_Bjqj, this.jdField_a_of_type_Int);
      return;
    }
    bjqa.b(this.jdField_a_of_type_Bjqa, 0);
    this.jdField_a_of_type_Bjqj.a(paramInt, paramString);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry isSuccess=", Boolean.valueOf(paramBoolean), ", type=", Integer.valueOf(paramInt), ", mPreAuthRetryCount=", Integer.valueOf(bjqa.c(this.jdField_a_of_type_Bjqa)) });
    if (!paramBoolean)
    {
      auuv.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bjpl, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("data");
    if (arrayOfByte == null)
    {
      auuv.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bjpl, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    preAuth.PreAuthResponse localPreAuthResponse = new preAuth.PreAuthResponse();
    Object localObject = arrayOfByte;
    if (this.jdField_a_of_type_Boolean) {
      localObject = bjqk.b(arrayOfByte, this.jdField_a_of_type_Bjpl);
    }
    try
    {
      localObject = (preAuth.PreAuthResponse)localPreAuthResponse.mergeFrom((byte[])localObject);
      if ((((preAuth.PreAuthResponse)localObject).ret.has()) && (((preAuth.PreAuthResponse)localObject).ret.get() == 0))
      {
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "--> preAuth mergeFrom success");
        auuv.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bjpl, true);
        bjqa.a(this.jdField_a_of_type_Bjqa, (preAuth.PreAuthResponse)localObject);
        bjqa.b(this.jdField_a_of_type_Bjqa, 0);
        this.jdField_a_of_type_Bjqj.a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("SDK_LOGIN.OpenSdkVirtualManager", 1, "Exception", localException);
      auuv.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bjpl, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "--> preAuth mergeFrom fail ret=", Integer.valueOf(localException.ret.get()), ", msg=", localException.msg.get() });
    auuv.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bjpl, false);
    a(localException.ret.get(), localException.msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjqh
 * JD-Core Version:    0.7.0.1
 */