import android.app.Activity;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;

public class benb
  implements bena
{
  protected behq a;
  protected ShareProxy a;
  
  public benb(behq parambehq)
  {
    this.jdField_a_of_type_Behq = parambehq;
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyShareProxy = ((ShareProxy)ProxyManager.get(ShareProxy.class));
  }
  
  public void a()
  {
    betc.b("CapsuleButton", "on close click");
    Activity localActivity = this.jdField_a_of_type_Behq.a();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (!localActivity.moveTaskToBack(true))
      {
        betc.d("CapsuleButton", "moveTaskToBack failed, finish the activity.");
        localActivity.finish();
      }
      this.jdField_a_of_type_Behq.a(bekc.a(60));
    }
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonCloseClick(new behr(this.jdField_a_of_type_Behq));
  }
  
  public void b()
  {
    betc.b("CapsuleButton", "on more click");
    ((besl)this.jdField_a_of_type_Behq.a(beki.a())).b = 0;
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonMoreClick(new behr(this.jdField_a_of_type_Behq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     benb
 * JD-Core Version:    0.7.0.1
 */