import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class bfnh
  implements BusinessObserver
{
  bfnh(bfna parambfna, bfmm parambfmm, boolean paramBoolean, bfnk parambfnk, int paramInt, preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity) {}
  
  private void a(int paramInt, String paramString)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "--> preAuth onFail mPreAuthRetryCount=", Integer.valueOf(bfna.c(this.jdField_a_of_type_Bfna)), ", errorCode=", Integer.valueOf(paramInt) });
    if (bfna.c(this.jdField_a_of_type_Bfna) < this.jdField_a_of_type_Int)
    {
      bfna.d(this.jdField_a_of_type_Bfna);
      this.jdField_a_of_type_Bfna.a(this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthRequest, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bfmm, this.jdField_a_of_type_Bfnk, this.jdField_a_of_type_Int);
      return;
    }
    bfna.b(this.jdField_a_of_type_Bfna, 0);
    this.jdField_a_of_type_Bfnk.a(paramInt, paramString);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry isSuccess=", Boolean.valueOf(paramBoolean), ", type=", Integer.valueOf(paramInt), ", mPreAuthRetryCount=", Integer.valueOf(bfna.c(this.jdField_a_of_type_Bfna)) });
    if (!paramBoolean)
    {
      arzy.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bfmm, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("data");
    if (arrayOfByte == null)
    {
      arzy.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bfmm, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    preAuth.PreAuthResponse localPreAuthResponse = new preAuth.PreAuthResponse();
    Object localObject = arrayOfByte;
    if (!this.jdField_a_of_type_Boolean) {
      localObject = bfnl.b(arrayOfByte, this.jdField_a_of_type_Bfmm);
    }
    try
    {
      localObject = (preAuth.PreAuthResponse)localPreAuthResponse.mergeFrom((byte[])localObject);
      if ((((preAuth.PreAuthResponse)localObject).ret.has()) && (((preAuth.PreAuthResponse)localObject).ret.get() == 0))
      {
        QLog.d("OpenSdkVirtualManager", 1, "--> preAuth mergeFrom success");
        arzy.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bfmm, true);
        bfna.a(this.jdField_a_of_type_Bfna, (preAuth.PreAuthResponse)localObject);
        bfna.b(this.jdField_a_of_type_Bfna, 0);
        this.jdField_a_of_type_Bfnk.a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("OpenSdkVirtualManager", 1, "Exception", localException);
      arzy.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bfmm, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "--> preAuth mergeFrom fail ret=", Integer.valueOf(localException.ret.get()), ", msg=", localException.msg.get() });
    arzy.a("KEY_PRE_AUTH", this.jdField_a_of_type_Bfmm, false);
    a(localException.ret.get(), localException.msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfnh
 * JD-Core Version:    0.7.0.1
 */