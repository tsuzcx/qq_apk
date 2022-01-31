import android.content.Context;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@begt(a="MiniAppInfoLoadTask")
public class bewf
  extends bfeq
{
  private MiniAppInfo a;
  
  public bewf(Context paramContext, bepv parambepv)
  {
    super(paramContext, parambepv);
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
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(this.a.appId, str1, str2, new bewg(this));
      return;
      str1 = this.a.launchParam.c;
      break;
    }
  }
  
  private void h()
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoByLink(this.a.link, this.a.linkType, new bewh(this));
  }
  
  public MiniAppInfo a()
  {
    return this.a;
  }
  
  public void a()
  {
    besl.b("MiniAppInfoLoadTask", "start executing");
    if (this.a == null)
    {
      besl.d("MiniAppInfoLoadTask", "MiniAppInfo must not be null");
      f();
      return;
    }
    if (this.a.isShortcutFakeApp())
    {
      besl.b("MiniAppInfoLoadTask", "Start from shortcut, download MiniAppInfo ");
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
 * Qualified Name:     bewf
 * JD-Core Version:    0.7.0.1
 */