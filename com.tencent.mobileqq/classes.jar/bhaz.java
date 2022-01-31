import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.ui.InternalMiniActivity;

public class bhaz
  extends bgqy
{
  public bhaz(bglv parambglv)
  {
    super(parambglv);
  }
  
  private void c()
  {
    Object localObject = this.a.a();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (!(localObject instanceof InternalMiniActivity)) {
        break label139;
      }
      ((Activity)localObject).finish();
    }
    for (;;)
    {
      this.a.a(bgmd.a(60));
      if (this.a.b())
      {
        localObject = this.a.a();
        if ((localObject != null) && (((MiniAppInfo)localObject).launchParam != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject).launchParam.fromMiniAppId))) {
          bgpj.a(((MiniAppInfo)localObject).launchParam.fromMiniAppId);
        }
      }
      if (this.a.a() != null) {
        ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonCloseClick(new bglw(this.a));
      }
      return;
      label139:
      int i = 0;
      try
      {
        boolean bool = ((Activity)localObject).moveTaskToBack(true);
        i = bool;
      }
      catch (Throwable localThrowable)
      {
        label149:
        break label149;
      }
      if (i == 0)
      {
        QMLog.e("GameCapsuleButton", "moveTaskToBack failed, finish the activity.");
        ((Activity)localObject).finish();
      }
    }
  }
  
  public void a()
  {
    QMLog.i("GameCapsuleButton", "on close click");
    if ((!bgyv.b(this.a, new bhba(this))) && (!bgyv.a(this.a, new bhbb(this)))) {
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhaz
 * JD-Core Version:    0.7.0.1
 */