import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class bjzv
  implements BusinessObserver
{
  bjzv(bjzo parambjzo, bjzb parambjzb, boolean paramBoolean, bjzx parambjzx, int paramInt, preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity) {}
  
  private void a(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "--> preAuth onFail mPreAuthRetryCount=", Integer.valueOf(bjzo.c(this.jdField_a_of_type_Bjzo)), ", errorCode=", Integer.valueOf(paramInt) });
    if (bjzo.c(this.jdField_a_of_type_Bjzo) < this.jdField_a_of_type_Int)
    {
      bjzo.d(this.jdField_a_of_type_Bjzo);
      this.jdField_a_of_type_Bjzo.a(this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthRequest, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bjzb, this.jdField_a_of_type_Bjzx, this.jdField_a_of_type_Int);
      return;
    }
    bjzo.b(this.jdField_a_of_type_Bjzo, 0);
    this.jdField_a_of_type_Bjzx.a(paramInt, paramString);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry isSuccess=", Boolean.valueOf(paramBoolean), ", type=", Integer.valueOf(paramInt), ", mPreAuthRetryCount=", Integer.valueOf(bjzo.c(this.jdField_a_of_type_Bjzo)) });
    if (!paramBoolean)
    {
      avcw.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bjzb, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("data");
    if (arrayOfByte == null)
    {
      avcw.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bjzb, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    preAuth.PreAuthResponse localPreAuthResponse = new preAuth.PreAuthResponse();
    Object localObject = arrayOfByte;
    if (this.jdField_a_of_type_Boolean) {
      localObject = bjzy.b(arrayOfByte, this.jdField_a_of_type_Bjzb);
    }
    try
    {
      localObject = (preAuth.PreAuthResponse)localPreAuthResponse.mergeFrom((byte[])localObject);
      if ((((preAuth.PreAuthResponse)localObject).ret.has()) && (((preAuth.PreAuthResponse)localObject).ret.get() == 0))
      {
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "--> preAuth mergeFrom success");
        avcw.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bjzb, true);
        bjzo.a(this.jdField_a_of_type_Bjzo, (preAuth.PreAuthResponse)localObject);
        bjzo.b(this.jdField_a_of_type_Bjzo, 0);
        this.jdField_a_of_type_Bjzx.a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("SDK_LOGIN.OpenSdkVirtualManager", 1, "Exception", localException);
      avcw.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bjzb, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "--> preAuth mergeFrom fail ret=", Integer.valueOf(localException.ret.get()), ", msg=", localException.msg.get() });
    avcw.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bjzb, false);
    a(localException.ret.get(), localException.msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjzv
 * JD-Core Version:    0.7.0.1
 */