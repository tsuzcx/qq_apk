import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.OnDismissListener;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;

public class bkmv
  implements MiniLoadingAdLayout.OnDismissListener
{
  public bkmv(AdProxyImpl paramAdProxyImpl, AdProxy.ILoadingAdListener paramILoadingAdListener) {}
  
  public void onDismiss(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener.onAdDismiss(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkmv
 * JD-Core Version:    0.7.0.1
 */