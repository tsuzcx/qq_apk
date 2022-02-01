package com.tencent.mobileqq.activity.qqsettingme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeLevelAndMedalBean;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.nearby.redtouch.IUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.bussiness.diamondwall.AnimatorHandler;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.VipGrayConfigHelper.VipGrayConfigListener;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.mobileqq.vas.quickupdate.QQLevelIconCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.widget.QVipMedalView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.libpag.PAGView;

public class QQSettingMeHeadVipProcessor
  extends QQSettingMeBaseProcessor
  implements ICardCatcher
{
  public boolean a;
  public MutableLiveData<QQSettingMeLevelAndMedalBean> b = new MutableLiveData(new QQSettingMeLevelAndMedalBean());
  public MutableLiveData<BusinessInfoCheckUpdate.AppInfo> i = new MutableLiveData();
  public MutableLiveData<BusinessInfoCheckUpdate.AppInfo> j = new MutableLiveData();
  private QQValuePagView k;
  private boolean l;
  private final VipGrayConfigHelper.VipGrayConfigListener m = new QQSettingMeHeadVipProcessor.1(this);
  private final SVIPObserver n = new QQSettingMeHeadVipProcessor.2(this);
  
  private String a(String paramString, int paramInt, boolean paramBoolean)
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
    if (paramBoolean) {
      return MobileReportManager.getNewReportInfo(paramString, localIRedTouchManager.getAppInfoByPath(String.valueOf(paramInt)));
    }
    return MobileReportManager.getNewDefaultReportInfo(paramString, "outside", "1");
  }
  
  private boolean b(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "jumpToProfile");
      }
      paramString = new AllInOne(this.c.getCurrentAccountUin(), 0);
      bool1 = true;
      paramString.lastActivity = 1;
      paramString.profileEntryType = 8;
      ProfileUtils.openProfileCardForResult(this.d, paramString, 1009);
      ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).checkToCleanSettingMeRedPointGuide((QQAppInterface)this.c);
      QLog.e("QVipSettingMe.", 1, "medal list have no jump url ,so use the default");
    }
    return bool1;
  }
  
  @NonNull
  private QQSettingMeLevelAndMedalBean l()
  {
    MutableLiveData localMutableLiveData = this.b;
    if (localMutableLiveData == null) {
      return new QQSettingMeLevelAndMedalBean();
    }
    return (QQSettingMeLevelAndMedalBean)localMutableLiveData.getValue();
  }
  
  private void m()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void n()
  {
    Object localObject = (LocalRedTouchManager)this.c.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem1 = ((LocalRedTouchManager)localObject).a(10015);
    RedTouchItem localRedTouchItem2 = ((LocalRedTouchManager)localObject).a(10016);
    boolean bool = ((IUtil)QRoute.api(IUtil.class)).checkMedalRedPointConfig(this.c);
    int i2 = 0;
    int i1 = i2;
    if (bool) {
      if (!((LocalRedTouchManager)localObject).a(localRedTouchItem1, false))
      {
        i1 = i2;
        if (!((LocalRedTouchManager)localObject).a(localRedTouchItem2, false)) {}
      }
      else
      {
        i1 = 1;
      }
    }
    if (i1 != 0)
    {
      i1 = ((LocalRedTouchManager)localObject).d();
      localObject = null;
      if (i1 != 3) {
        if (i1 != 4) {
          if (i1 != 5) {
            break label139;
          }
        }
      }
      for (;;)
      {
        localObject = "0X80073B8";
        continue;
        localObject = "0X8007397";
        continue;
        localObject = "0X8007392";
      }
      label139:
      if (localObject != null) {
        ReportController.b(this.c, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      }
    }
  }
  
  public Card a()
  {
    return l().b;
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.k = ((QQValuePagView)paramQQSettingMe.e);
    this.b.observe(this.e, new QQSettingMeHeadVipProcessor.3(this, paramQQSettingMe));
    this.i.observe(this.e, new QQSettingMeHeadVipProcessor.4(this, paramQQSettingMe));
    this.j.observe(this.e, new QQSettingMeHeadVipProcessor.5(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (this.l)
    {
      if (this.c != null)
      {
        ((QQAppInterface)paramAppRuntime).removeObserver(this.n);
        VipGrayConfigHelper.a().b(this.m);
      }
      this.c = paramAppRuntime;
      if (this.c != null)
      {
        ((QQAppInterface)this.c).addObserver(this.n, true);
        VipGrayConfigHelper.a().a(this.m);
      }
    }
    else
    {
      this.c = paramAppRuntime;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)localObject).getAppInfoByPath(String.valueOf(101400));
    localObject = ((IRedTouchManager)localObject).getAppInfoByPath(String.valueOf(101500));
    if (this.g) {
      ThreadManagerV2.getUIHandlerV2().post(new QQSettingMeHeadVipProcessor.7(this, localAppInfo, (BusinessInfoCheckUpdate.AppInfo)localObject, paramBoolean));
    }
  }
  
  public String b()
  {
    return "d_head_vip";
  }
  
  public void d()
  {
    super.d();
    if (!this.l)
    {
      ((QQAppInterface)this.c).addObserver(this.n, true);
      VipGrayConfigHelper.a().a(this.m);
      this.l = true;
    }
    Object localObject = this.c.getCurrentAccountUin();
    this.k.a((String)localObject, "setting", ThemeUtil.isInNightMode(this.c));
    localObject = this.k;
    if ((localObject != null) && ((((QQValuePagView)localObject).g().c() instanceof PAGView)))
    {
      localObject = (PAGView)this.k.g().c();
      if (localObject != null) {
        ((PAGView)localObject).play();
      }
    }
  }
  
  public void e()
  {
    super.e();
    this.a = false;
  }
  
  public void f()
  {
    if ((this.l) && (this.c != null))
    {
      ((QQAppInterface)this.c).removeObserver(this.n);
      VipGrayConfigHelper.a().b(this.m);
    }
  }
  
  public void h()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      if (QQTheme.isNowThemeIsNight()) {
        this.k.setForeground(new ColorDrawable(1996488704));
      } else {
        this.k.setForeground(null);
      }
    }
    i();
  }
  
  public void i()
  {
    ThreadManager.post(new QQSettingMeHeadVipProcessor.6(this), 5, null, false);
  }
  
  public void j()
  {
    Card localCard = l().b;
    if (localCard == null) {
      return;
    }
    if (QQLevelIconCallback.isQQLevelIconExists(this.c.getApp(), localCard.mQQLevelType))
    {
      int i1;
      if (localCard.mQQLevelType == 0) {
        i1 = 99999;
      } else {
        i1 = localCard.mQQLevelType;
      }
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A778", i1, 0, "", "", "", "");
    }
  }
  
  public void k()
  {
    Object localObject = this.k;
    if ((localObject != null) && ((((QQValuePagView)localObject).g().c() instanceof PAGView)))
    {
      localObject = (PAGView)this.k.g().c();
      if (localObject != null) {
        ((PAGView)localObject).stop();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject1 = null;
    boolean bool = true;
    IRedTouchManager localIRedTouchManager;
    Object localObject2;
    String str;
    if (i1 == 2131432238)
    {
      if (l().c != null) {
        localObject1 = l().c.jumpUrl;
      }
      if (b((String)localObject1)) {
        return;
      }
      localIRedTouchManager = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
      localObject2 = localIRedTouchManager.getAppInfoByPath(String.valueOf(101500));
      if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 0)) {
        bool = true;
      } else {
        bool = false;
      }
      str = a((String)localObject1, 101500, bool);
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(str);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = new Intent(this.d, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", (String)localObject2);
      ((Intent)localObject1).putExtra("hide_operation_bar", true);
      ((Intent)localObject1).putExtra("hide_more_button", true);
      ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.d.startActivity((Intent)localObject1);
      if (bool) {
        localIRedTouchManager.reportLevelOneRedInfo(101500, 31);
      }
      i1 = VipInfoHandler.a((QQAppInterface)this.c, this.c.getCurrentUin(), false);
      if ((paramView instanceof QVipMedalView)) {
        if (AnimatorHandler.playing) {
          ((QVipMedalView)paramView).a("0X800B2B5", i1);
        } else {
          ((QVipMedalView)paramView).a("0X800B2B4", i1);
        }
      }
      ReportController.b(this.c, "dc00898", "", "", "qvip", "0X800A127", 0, 0, String.valueOf(i1), "", "", "");
      return;
    }
    if (paramView.getId() == 2131432239)
    {
      localObject2 = this.c.getApplication().getSharedPreferences(this.c.getCurrentAccountUin(), 0).getString("sp_vip_medal_lvl_jump_url", null);
      if (b((String)localObject2)) {
        return;
      }
      localIRedTouchManager = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
      localObject1 = localIRedTouchManager.getAppInfoByPath(String.valueOf(101400));
      if ((localObject1 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() == 0)) {
        bool = false;
      }
      str = a((String)localObject2, 101400, bool);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(str);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      VipUtils.a(0, "mvip.pingtai.mobileqq.androidziliaoka.fromdrawer", "geren", (String)localObject1, paramView.getContext());
      if (bool) {
        localIRedTouchManager.reportLevelOneRedInfo(101400, 31);
      }
      i1 = VipInfoHandler.a((QQAppInterface)this.c, this.c.getCurrentUin(), false);
      ReportController.b(this.c, "dc00898", "", "", "0X800B179", "0X800B179", 0, 0, String.valueOf(i1), "", "", "");
      return;
    }
    if (paramView.getId() == 2131432220)
    {
      paramView = new Intent(this.d, QQBrowserActivity.class);
      paramView.putExtra("uin", this.c.getCurrentAccountUin());
      paramView.putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=draw");
      paramView.putExtra("hide_more_button", true);
      this.d.startActivity(paramView);
      ReportController.b(this.c, "dc00898", "", "", "0X800A9C3", "0X800A9C3", 0, 0, "", "", "", "");
      return;
    }
    if (paramView.getId() == 2131432235)
    {
      ((QQValuePagView)paramView).a("setting", this.c.getCurrentAccountUin());
      return;
    }
    if (paramView.getId() == 2131432247)
    {
      paramView = l().b;
      if (paramView != null)
      {
        VipUtils.a(this.d, paramView.nameplateExtId);
        VipUtils.c("0X800B923", paramView.nameplateExtId);
      }
    }
    else if (paramView.getId() == 2131432225)
    {
      localObject1 = l().b;
      if (localObject1 != null)
      {
        paramView = VasUtil.a().getGameCardManager();
        paramView.gotoGameIconSetWeb(this.d, ((Card)localObject1).uin, ((Card)localObject1).namePlateOfKingDanDisplatSwitch, ((Card)localObject1).gameCardId);
        if (paramView.isSelf(((Card)localObject1).uin)) {
          paramView = "owner";
        } else {
          paramView = "visitor";
        }
        ((IMobileReportManager)QRoute.api(IMobileReportManager.class)).reportAction(String.valueOf(((Card)localObject1).gameCardId), "4", "platform898", "choutiye", paramView, 102, 1, System.currentTimeMillis());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeHeadVipProcessor
 * JD-Core Version:    0.7.0.1
 */