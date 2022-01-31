import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.minigame.task.MiniAppInfoLoadTask.1;

@bghi(a="MiniAppInfoLoadTask")
public class bgvi
  extends bhhm
{
  private MiniAppInfo a;
  
  public bgvi(Context paramContext, bgqg parambgqg)
  {
    super(paramContext, parambgqg);
  }
  
  private void d()
  {
    QMLog.i("MiniAppInfoLoadTask", "start executing");
    if (this.a == null)
    {
      QMLog.e("MiniAppInfoLoadTask", "MiniAppInfo must not be null");
      e();
      return;
    }
    if (this.a.isShortcutFakeApp())
    {
      QMLog.i("MiniAppInfoLoadTask", "Start from shortcut, download MiniAppInfo ");
      h();
      return;
    }
    if (this.a.isFakeAppInfo())
    {
      if (this.a.link != null)
      {
        i();
        return;
      }
      h();
      return;
    }
    c();
  }
  
  private void h()
  {
    String str1;
    if (this.a.launchParam.entryPath == null)
    {
      str1 = "";
      if (this.a.launchParam.envVersion != null) {
        break label77;
      }
    }
    label77:
    for (String str2 = "";; str2 = this.a.launchParam.envVersion)
    {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(this.a.appId, str1, str2, new bgvj(this));
      return;
      str1 = this.a.launchParam.entryPath;
      break;
    }
  }
  
  private void i()
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoByLink(this.a.link, this.a.linkType, new bgvk(this));
  }
  
  public MiniAppInfo a()
  {
    return this.a;
  }
  
  public void a() {}
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.a = paramMiniAppInfo;
    if (!b())
    {
      d();
      return;
    }
    ThreadManager.a().post(new MiniAppInfoLoadTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvi
 * JD-Core Version:    0.7.0.1
 */