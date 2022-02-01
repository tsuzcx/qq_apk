import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class bkym
  extends CmdCallback.Stub
{
  bkym(bkyl parambkyl, BaseRuntime paramBaseRuntime, String paramString1, String paramString2, String paramString3, int paramInt, RequestEvent paramRequestEvent) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("shareJson");
    QLog.d("MiniSDKClientQIPCModule", 1, "handleDirectShareSucCallback shareJsonString after = " + paramBundle);
    bkyl.a(this.jdField_a_of_type_Bkyl, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, this.jdField_a_of_type_JavaLangString, this.b, this.c, paramBundle, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkym
 * JD-Core Version:    0.7.0.1
 */