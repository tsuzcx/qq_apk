import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;

class bkel
  extends amyh
{
  bkel(bkej parambkej, Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("isSuccess", paramBoolean);
    ((Bundle)localObject).putString("uin", paramString);
    this.jdField_a_of_type_AndroidOsBundle.putAll((Bundle)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("publicAccount.followUin, isSuccess=").append(paramBoolean).append("; result=");
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        break label108;
      }
    }
    label108:
    for (paramString = this.jdField_a_of_type_AndroidOsBundle.toString();; paramString = "null")
    {
      QLog.d("BuscardPluginRemoteCommand", 2, paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener != null) {
        this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener.onInvokeFinish(this.jdField_a_of_type_AndroidOsBundle);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkel
 * JD-Core Version:    0.7.0.1
 */