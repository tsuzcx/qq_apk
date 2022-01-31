import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public class bewh
{
  private bemx a;
  
  private void a(String paramString1, String paramString2, bewo parambewo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      betc.d("MiniGameAuthorizeManager", "showDialog: appid or scopeName is empty,appid= " + paramString1 + "scopeName=" + paramString2);
    }
    bevt localbevt;
    Object localObject;
    label233:
    label239:
    do
    {
      return;
      if ((this.a != null) && (this.a.isShowing()))
      {
        betc.d("MiniGameAuthorizeManager", "showDialog: mAuthorDialog is showing now.just return");
        return;
      }
      localbevt = bevz.a().a();
      if ((localbevt == null) || (!TextUtils.equals(localbevt.d, paramString1)))
      {
        betc.d("MiniGameAuthorizeManager", "showDialog: cann't get gamePkg");
        return;
      }
      localObject = beqy.a().a();
      paramString1 = new bewi(this, paramString1, paramString2, parambewo);
      this.a = new bemx((Context)localObject);
      this.a.setOnDismissListener(paramString1);
      parambewo = beic.a().a(paramString2);
      if (parambewo != null)
      {
        paramString1 = parambewo.b;
        if (parambewo == null) {
          break label233;
        }
      }
      for (parambewo = parambewo.c;; parambewo = "")
      {
        localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
        if (!"scope.userInfo".equals(paramString2)) {
          break label239;
        }
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserInfo(localbevt.d, false, "en", new bewj(this, (MiniAppProxy)localObject, localbevt, paramString1, parambewo));
        return;
        paramString1 = paramString2;
        break;
      }
    } while (this.a == null);
    this.a.a(((MiniAppProxy)localObject).getDrawable(MiniAppEnv.g().getContext(), localbevt.e, 0, 0, null), localbevt.c, paramString1, null, null, parambewo, "拒绝", new bewm(this), "允许", new bewn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewh
 * JD-Core Version:    0.7.0.1
 */