import android.app.Activity;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;

public class bgqy
  implements bgqx
{
  protected bglv a;
  protected ShareProxy a;
  
  public bgqy(bglv parambglv)
  {
    this.jdField_a_of_type_Bglv = parambglv;
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyShareProxy = ((ShareProxy)ProxyManager.get(ShareProxy.class));
  }
  
  public void a()
  {
    QMLog.i("CapsuleButton", "on close click");
    Activity localActivity = this.jdField_a_of_type_Bglv.a();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (!localActivity.moveTaskToBack(true))
      {
        QMLog.e("CapsuleButton", "moveTaskToBack failed, finish the activity.");
        localActivity.finish();
      }
      this.jdField_a_of_type_Bglv.a(bgmd.a(60));
    }
    if (this.jdField_a_of_type_Bglv.a() != null) {
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonCloseClick(new bglw(this.jdField_a_of_type_Bglv));
    }
  }
  
  public void b()
  {
    QMLog.i("CapsuleButton", "on more click");
    ShareState localShareState = bgmj.a(this.jdField_a_of_type_Bglv);
    if (localShareState != null)
    {
      localShareState.fromShareMenuBtn = 0;
      localShareState.stagingJsonParams = null;
    }
    if (!QUAUtil.isQQApp()) {
      bhmo.a(this.jdField_a_of_type_Bglv);
    }
    if (this.jdField_a_of_type_Bglv.a() != null) {
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonMoreClick(new bglw(this.jdField_a_of_type_Bglv));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgqy
 * JD-Core Version:    0.7.0.1
 */