import Wallet.FocusMpIdRsp;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import mqq.observer.BusinessObserver;

class bknx
  implements BusinessObserver
{
  bknx(bknl parambknl, AsyncResult paramAsyncResult) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (FocusMpIdRsp)paramBundle.getSerializable("rsp");
    if ((paramBundle == null) || (paramBundle.err_code != 0))
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(false, null);
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bknx
 * JD-Core Version:    0.7.0.1
 */