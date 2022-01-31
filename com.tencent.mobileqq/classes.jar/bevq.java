import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public class bevq
{
  private bemg a;
  
  private void a(String paramString1, String paramString2, bevx parambevx)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      besl.d("MiniGameAuthorizeManager", "showDialog: appid or scopeName is empty,appid= " + paramString1 + "scopeName=" + paramString2);
    }
    bevc localbevc;
    Object localObject;
    label233:
    label239:
    do
    {
      return;
      if ((this.a != null) && (this.a.isShowing()))
      {
        besl.d("MiniGameAuthorizeManager", "showDialog: mAuthorDialog is showing now.just return");
        return;
      }
      localbevc = bevi.a().a();
      if ((localbevc == null) || (!TextUtils.equals(localbevc.d, paramString1)))
      {
        besl.d("MiniGameAuthorizeManager", "showDialog: cann't get gamePkg");
        return;
      }
      localObject = beqh.a().a();
      paramString1 = new bevr(this, paramString1, paramString2, parambevx);
      this.a = new bemg((Context)localObject);
      this.a.setOnDismissListener(paramString1);
      parambevx = behl.a().a(paramString2);
      if (parambevx != null)
      {
        paramString1 = parambevx.b;
        if (parambevx == null) {
          break label233;
        }
      }
      for (parambevx = parambevx.c;; parambevx = "")
      {
        localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
        if (!"scope.userInfo".equals(paramString2)) {
          break label239;
        }
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserInfo(localbevc.d, false, "en", new bevs(this, (MiniAppProxy)localObject, localbevc, paramString1, parambevx));
        return;
        paramString1 = paramString2;
        break;
      }
    } while (this.a == null);
    this.a.a(((MiniAppProxy)localObject).getDrawable(MiniAppEnv.g().getContext(), localbevc.e, 0, 0, null), localbevc.c, paramString1, null, null, parambevx, "拒绝", new bevv(this), "允许", new bevw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevq
 * JD-Core Version:    0.7.0.1
 */