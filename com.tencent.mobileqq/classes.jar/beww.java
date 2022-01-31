import android.content.Context;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@behk(a="MiniAppInfoLoadTask")
public class beww
  extends bffh
{
  private MiniAppInfo a;
  
  public beww(Context paramContext, beqm parambeqm)
  {
    super(paramContext, parambeqm);
  }
  
  private void g()
  {
    String str1;
    if (this.a.launchParam.c == null)
    {
      str1 = "";
      if (this.a.launchParam.i != null) {
        break label77;
      }
    }
    label77:
    for (String str2 = "";; str2 = this.a.launchParam.i)
    {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(this.a.appId, str1, str2, new bewx(this));
      return;
      str1 = this.a.launchParam.c;
      break;
    }
  }
  
  private void h()
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoByLink(this.a.link, this.a.linkType, new bewy(this));
  }
  
  public MiniAppInfo a()
  {
    return this.a;
  }
  
  public void a()
  {
    betc.b("MiniAppInfoLoadTask", "start executing");
    if (this.a == null)
    {
      betc.d("MiniAppInfoLoadTask", "MiniAppInfo must not be null");
      f();
      return;
    }
    if (this.a.isShortcutFakeApp())
    {
      betc.b("MiniAppInfoLoadTask", "Start from shortcut, download MiniAppInfo ");
      g();
      return;
    }
    if (this.a.isFakeAppInfo())
    {
      if (this.a.link != null)
      {
        h();
        return;
      }
      g();
      return;
    }
    c();
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.a = paramMiniAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beww
 * JD-Core Version:    0.7.0.1
 */