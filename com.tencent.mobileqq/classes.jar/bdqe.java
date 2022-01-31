import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.minigame.manager.MiniGameAuthorizeManager.1;

public class bdqe
{
  private static volatile bdqe jdField_a_of_type_Bdqe;
  private bdid jdField_a_of_type_Bdid;
  
  public static bdqe a()
  {
    if (jdField_a_of_type_Bdqe == null) {}
    try
    {
      if (jdField_a_of_type_Bdqe == null) {
        jdField_a_of_type_Bdqe = new bdqe();
      }
      return jdField_a_of_type_Bdqe;
    }
    finally {}
  }
  
  private void b(String paramString1, String paramString2, bdql parambdql)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bdnw.d("MiniGameAuthorizeManager", "showDialog: appid or scopeName is empty,appid= " + paramString1 + "scopeName=" + paramString2);
    }
    bdpy localbdpy;
    Object localObject;
    label233:
    label239:
    do
    {
      return;
      if ((this.jdField_a_of_type_Bdid != null) && (this.jdField_a_of_type_Bdid.isShowing()))
      {
        bdnw.d("MiniGameAuthorizeManager", "showDialog: mAuthorDialog is showing now.just return");
        return;
      }
      localbdpy = bdqa.a().a();
      if ((localbdpy == null) || (!TextUtils.equals(localbdpy.d, paramString1)))
      {
        bdnw.d("MiniGameAuthorizeManager", "showDialog: cann't get gamePkg");
        return;
      }
      localObject = bdlx.a().a();
      paramString1 = new bdqf(this, paramString1, paramString2, parambdql);
      this.jdField_a_of_type_Bdid = new bdid((Context)localObject);
      this.jdField_a_of_type_Bdid.setOnDismissListener(paramString1);
      parambdql = bddk.a().a(paramString2);
      if (parambdql != null)
      {
        paramString1 = parambdql.b;
        if (parambdql == null) {
          break label233;
        }
      }
      for (parambdql = parambdql.c;; parambdql = "")
      {
        localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
        if (!"scope.userInfo".equals(paramString2)) {
          break label239;
        }
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserInfo(localbdpy.d, false, "en", new bdqg(this, (MiniAppProxy)localObject, localbdpy, paramString1, parambdql));
        return;
        paramString1 = paramString2;
        break;
      }
    } while (this.jdField_a_of_type_Bdid == null);
    this.jdField_a_of_type_Bdid.a(((MiniAppProxy)localObject).getDrawable(MiniAppEnv.g().getContext(), localbdpy.e, 0, 0, null), localbdpy.c, paramString1, null, null, parambdql, "拒绝", new bdqj(this), "允许", new bdqk(this));
  }
  
  public void a(String paramString1, String paramString2, bdql parambdql)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bdnw.c("MiniGameAuthorizeManager", "requestAuthorize: appid or scopeName is empty,appid= " + paramString1 + "scopeName=" + paramString2);
    }
    do
    {
      return;
      if (a(paramString1, paramString2) != true) {
        break;
      }
    } while (parambdql == null);
    parambdql.a(true);
    return;
    bdew.c().post(new MiniGameAuthorizeManager.1(this, paramString1, paramString2, parambdql));
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (bddd.a(bdqa.a().a())) {
      return true;
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    return MiniAppEnv.g().getAuthSate(paramString1).a(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdqe
 * JD-Core Version:    0.7.0.1
 */