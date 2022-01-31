import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class bexg
  extends bemk
{
  public bexg(begz parambegz)
  {
    super(parambegz);
  }
  
  private void c()
  {
    Object localObject = this.a.a();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (!((Activity)localObject).moveTaskToBack(true))
      {
        besl.d("GameCapsuleButton", "moveTaskToBack failed, finish the activity.");
        ((Activity)localObject).finish();
      }
      this.a.a(bejl.a(60));
    }
    if (this.a.e())
    {
      localObject = this.a.a();
      if ((localObject != null) && (((MiniAppInfo)localObject).launchParam != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject).launchParam.f))) {
        bekv.a(((MiniAppInfo)localObject).launchParam.f);
      }
    }
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonCloseClick(new beha(this.a));
  }
  
  public void a()
  {
    besl.b("GameCapsuleButton", "on close click");
    if ((!bevd.b(this.a, new bexh(this))) && (!bevd.a(this.a, new bexi(this)))) {
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bexg
 * JD-Core Version:    0.7.0.1
 */