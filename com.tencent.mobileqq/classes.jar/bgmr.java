import android.app.Activity;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;

public class bgmr
  implements bgmq
{
  protected bgho a;
  protected ShareProxy a;
  
  public bgmr(bgho parambgho)
  {
    this.jdField_a_of_type_Bgho = parambgho;
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyShareProxy = ((ShareProxy)ProxyManager.get(ShareProxy.class));
  }
  
  public void a()
  {
    QMLog.i("CapsuleButton", "on close click");
    Activity localActivity = this.jdField_a_of_type_Bgho.a();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (!localActivity.moveTaskToBack(true))
      {
        QMLog.e("CapsuleButton", "moveTaskToBack failed, finish the activity.");
        localActivity.finish();
      }
      this.jdField_a_of_type_Bgho.a(bghw.a(60));
    }
    if (this.jdField_a_of_type_Bgho.a() != null) {
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonCloseClick(new bghp(this.jdField_a_of_type_Bgho));
    }
  }
  
  public void b()
  {
    QMLog.i("CapsuleButton", "on more click");
    ShareState localShareState = bgic.a(this.jdField_a_of_type_Bgho);
    if (localShareState != null)
    {
      localShareState.fromShareMenuBtn = 0;
      localShareState.stagingJsonParams = null;
    }
    if (!QUAUtil.isQQApp()) {
      bhih.a(this.jdField_a_of_type_Bgho);
    }
    if (this.jdField_a_of_type_Bgho.a() != null) {
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonMoreClick(new bghp(this.jdField_a_of_type_Bgho));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmr
 * JD-Core Version:    0.7.0.1
 */