import android.app.Activity;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;

public class bemk
  implements bemj
{
  protected begz a;
  protected ShareProxy a;
  
  public bemk(begz parambegz)
  {
    this.jdField_a_of_type_Begz = parambegz;
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyShareProxy = ((ShareProxy)ProxyManager.get(ShareProxy.class));
  }
  
  public void a()
  {
    besl.b("CapsuleButton", "on close click");
    Activity localActivity = this.jdField_a_of_type_Begz.a();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (!localActivity.moveTaskToBack(true))
      {
        besl.d("CapsuleButton", "moveTaskToBack failed, finish the activity.");
        localActivity.finish();
      }
      this.jdField_a_of_type_Begz.a(bejl.a(60));
    }
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonCloseClick(new beha(this.jdField_a_of_type_Begz));
  }
  
  public void b()
  {
    besl.b("CapsuleButton", "on more click");
    ((beru)this.jdField_a_of_type_Begz.a(bejr.a())).b = 0;
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonMoreClick(new beha(this.jdField_a_of_type_Begz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bemk
 * JD-Core Version:    0.7.0.1
 */