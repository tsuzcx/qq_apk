import android.app.Activity;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;

public class bdih
  implements bdig
{
  protected bdcz a;
  protected ShareProxy a;
  
  public bdih(bdcz parambdcz)
  {
    this.jdField_a_of_type_Bdcz = parambdcz;
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyShareProxy = ((ShareProxy)ProxyManager.get(ShareProxy.class));
  }
  
  public void a()
  {
    Activity localActivity = this.jdField_a_of_type_Bdcz.a();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (!localActivity.moveTaskToBack(true))
      {
        bdnw.d("CapsuleButton", "moveTaskToBack failed, finish the activity.");
        localActivity.finish();
      }
      this.jdField_a_of_type_Bdcz.a(bdfl.a(60));
    }
  }
  
  public void b()
  {
    ((bdgb)this.jdField_a_of_type_Bdcz.a(bdfr.a())).b = 0;
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonMoreClick(this.jdField_a_of_type_Bdcz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdih
 * JD-Core Version:    0.7.0.1
 */