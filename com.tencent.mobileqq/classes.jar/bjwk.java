import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.KingCardProxyImpl.1;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import mqq.app.AppRuntime;

@ProxyService(proxy=KingCardProxy.class)
public class bjwk
  implements KingCardProxy
{
  private bhij jdField_a_of_type_Bhij;
  private final String jdField_a_of_type_JavaLangString = "KingCardProxyImpl";
  private String b = "mini_app_kingcard_guide_";
  private String c;
  
  private void a()
  {
    String str = this.b + BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StorageUtil.getPreference().edit().putBoolean(str, true).apply();
  }
  
  private boolean a()
  {
    String str = this.b + BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return StorageUtil.getPreference().getBoolean(str, false);
  }
  
  private boolean a(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool = true;
    if (!AppNetConnInfo.isMobileConn())
    {
      QLog.i("KingCardProxyImpl", 1, "shouldShowKingCardTip network type is wifi + " + AppNetConnInfo.isWifiConn());
      return false;
    }
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appMode != null) && (paramMiniAppInfo.appMode.isWangKa)) {}
    for (int i = 1; i == 0; i = 0)
    {
      QLog.i("KingCardProxyImpl", 1, "shouldShowKingCardTip， not wangka app");
      return false;
    }
    i = bhhb.a();
    QLog.i("KingCardProxyImpl", 1, "shouldShowKingCardTip， king card status = " + i);
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public ImageView getCapsuleButtonMoreView(Context paramContext)
  {
    if (!TextUtils.isEmpty(MiniAppGlobal.KINGCARD_GUIDE_TEXT)) {}
    for (Object localObject = MiniAppGlobal.KINGCARD_GUIDE_TEXT;; localObject = paramContext.getResources().getString(2131693679))
    {
      this.c = ((String)localObject);
      this.jdField_a_of_type_Bhij = new bhij(null, paramContext);
      int i = (int)(MemoryManager.a() / 2L);
      this.jdField_a_of_type_Bhij.a(i);
      localObject = new DiniFlyAnimationView(paramContext);
      ((DiniFlyAnimationView)localObject).setVisibility(0);
      ((DiniFlyAnimationView)localObject).setContentDescription(anni.a(2131700158));
      paramContext = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(paramContext, 40.0F), -1);
      paramContext.addRule(9, -1);
      ((DiniFlyAnimationView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      ((DiniFlyAnimationView)localObject).setLayoutParams(paramContext);
      return localObject;
    }
  }
  
  public boolean showKingCardTips(IMiniAppContext paramIMiniAppContext, ImageView paramImageView)
  {
    QLog.i("KingCardProxyImpl", 1, "showKingCardTips trigger");
    Activity localActivity = paramIMiniAppContext.getAttachedActivity();
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      QLog.i("KingCardProxyImpl", 1, "activity is null");
      return false;
    }
    if (!(paramImageView instanceof DiniFlyAnimationView)) {
      return false;
    }
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    if (localMiniAppInfo == null) {
      return false;
    }
    if (this.jdField_a_of_type_Bhij == null)
    {
      QMLog.w("KingCardProxyImpl", "lottie loader is null");
      return false;
    }
    DiniFlyAnimationView localDiniFlyAnimationView = (DiniFlyAnimationView)paramImageView;
    if (localDiniFlyAnimationView.getVisibility() != 0)
    {
      QLog.i("KingCardProxyImpl", 1, "showKingCardTips 小程序官方模式下是 GONE状态，不需要展示");
      return false;
    }
    if ((paramImageView != null) && (localActivity != null) && (!localActivity.isFinishing()) && (a(localMiniAppInfo))) {
      AppBrandTask.runTaskOnUiThreadIfNot(new KingCardProxyImpl.1(this, localActivity, localDiniFlyAnimationView, paramIMiniAppContext));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwk
 * JD-Core Version:    0.7.0.1
 */