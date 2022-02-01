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
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.VipGrayConfigHelper.VipGrayConfigListener;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.mobileqq.vas.quickupdate.QQLevelIconCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
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
  public MutableLiveData<QQSettingMeLevelAndMedalBean> a;
  private final SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new QQSettingMeHeadVipProcessor.2(this);
  private final VipGrayConfigHelper.VipGrayConfigListener jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper$VipGrayConfigListener = new QQSettingMeHeadVipProcessor.1(this);
  private QQValuePagView jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView;
  public MutableLiveData<BusinessInfoCheckUpdate.AppInfo> b;
  public boolean b;
  public MutableLiveData<BusinessInfoCheckUpdate.AppInfo> c;
  private boolean c;
  
  public QQSettingMeHeadVipProcessor()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData(new QQSettingMeLevelAndMedalBean());
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_c_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  @NonNull
  private QQSettingMeLevelAndMedalBean a()
  {
    MutableLiveData localMutableLiveData = this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
    if (localMutableLiveData == null) {
      return new QQSettingMeLevelAndMedalBean();
    }
    return (QQSettingMeLevelAndMedalBean)localMutableLiveData.getValue();
  }
  
  private String a(String paramString, int paramInt, boolean paramBoolean)
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    if (paramBoolean) {
      return MobileReportManager.getNewReportInfo(paramString, localIRedTouchManager.getAppInfoByPath(String.valueOf(paramInt)));
    }
    return MobileReportManager.getNewDefaultReportInfo(paramString, "outside", "1");
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "jumpToProfile");
      }
      paramString = new AllInOne(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), 0);
      bool1 = true;
      paramString.lastActivity = 1;
      paramString.profileEntryType = 8;
      ProfileUtils.openProfileCardForResult(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramString, 1009);
      ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).checkToCleanSettingMeRedPointGuide((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
      QLog.e("QVipSettingMe.", 1, "medal list have no jump url ,so use the default");
    }
    return bool1;
  }
  
  private void j()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void k()
  {
    Object localObject = (LocalRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem1 = ((LocalRedTouchManager)localObject).a(10015);
    RedTouchItem localRedTouchItem2 = ((LocalRedTouchManager)localObject).a(10016);
    boolean bool = ((IUtil)QRoute.api(IUtil.class)).checkMedalRedPointConfig(this.jdField_a_of_type_MqqAppAppRuntime);
    int j = 0;
    int i = j;
    if (bool) {
      if (!((LocalRedTouchManager)localObject).a(localRedTouchItem1, false))
      {
        i = j;
        if (!((LocalRedTouchManager)localObject).a(localRedTouchItem2, false)) {}
      }
      else
      {
        i = 1;
      }
    }
    if (i != 0)
    {
      i = ((LocalRedTouchManager)localObject).a();
      localObject = null;
      if (i != 3) {
        if (i != 4) {
          if (i != 5) {
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
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      }
    }
  }
  
  public Card a()
  {
    return a().jdField_a_of_type_ComTencentMobileqqDataCard;
  }
  
  public String a()
  {
    return "d_head_vip";
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView = ((QQValuePagView)paramQQSettingMe.a);
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeHeadVipProcessor.3(this, paramQQSettingMe));
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeHeadVipProcessor.4(this, paramQQSettingMe));
    this.jdField_c_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeHeadVipProcessor.5(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_MqqAppAppRuntime != null)
      {
        ((QQAppInterface)paramAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
        VipGrayConfigHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper$VipGrayConfigListener);
      }
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      if (this.jdField_a_of_type_MqqAppAppRuntime != null)
      {
        ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver, true);
        VipGrayConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper$VipGrayConfigListener);
      }
    }
    else
    {
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)localObject).getAppInfoByPath(String.valueOf(101400));
    localObject = ((IRedTouchManager)localObject).getAppInfoByPath(String.valueOf(101500));
    if (this.jdField_a_of_type_Boolean) {
      ThreadManagerV2.getUIHandlerV2().post(new QQSettingMeHeadVipProcessor.7(this, localAppInfo, (BusinessInfoCheckUpdate.AppInfo)localObject, paramBoolean));
    }
  }
  
  public void b()
  {
    super.b();
    if (!this.jdField_c_of_type_Boolean)
    {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver, true);
      VipGrayConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper$VipGrayConfigListener);
      this.jdField_c_of_type_Boolean = true;
    }
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView.a((String)localObject, "setting", ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime));
    localObject = this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView;
    if ((localObject != null) && ((((QQValuePagView)localObject).a().a() instanceof PAGView)))
    {
      localObject = (PAGView)this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView.a().a();
      if (localObject != null) {
        ((PAGView)localObject).play();
      }
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void d()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_MqqAppAppRuntime != null))
    {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      VipGrayConfigHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper$VipGrayConfigListener);
    }
  }
  
  public void f()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      if (QQTheme.a()) {
        this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView.setForeground(new ColorDrawable(1996488704));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView.setForeground(null);
      }
    }
    g();
  }
  
  public void g()
  {
    ThreadManager.post(new QQSettingMeHeadVipProcessor.6(this), 5, null, false);
  }
  
  public void h()
  {
    Card localCard = a().jdField_a_of_type_ComTencentMobileqqDataCard;
    if (localCard == null) {
      return;
    }
    if (QQLevelIconCallback.isQQLevelIconExists(this.jdField_a_of_type_MqqAppAppRuntime.getApp(), localCard.mQQLevelType))
    {
      int i;
      if (localCard.mQQLevelType == 0) {
        i = 99999;
      } else {
        i = localCard.mQQLevelType;
      }
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A778", i, 0, "", "", "", "");
    }
  }
  
  public void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView;
    if ((localObject != null) && ((((QQValuePagView)localObject).a().a() instanceof PAGView)))
    {
      localObject = (PAGView)this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView.a().a();
      if (localObject != null) {
        ((PAGView)localObject).stop();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1 = null;
    boolean bool = true;
    IRedTouchManager localIRedTouchManager;
    Object localObject2;
    String str;
    if (i == 2131365969)
    {
      if (a().jdField_a_of_type_ComTencentMobileqqDataMedalList != null) {
        localObject1 = a().jdField_a_of_type_ComTencentMobileqqDataMedalList.jumpUrl;
      }
      if (a((String)localObject1)) {
        return;
      }
      localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
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
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", (String)localObject2);
      ((Intent)localObject1).putExtra("hide_operation_bar", true);
      ((Intent)localObject1).putExtra("hide_more_button", true);
      ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity((Intent)localObject1);
      if (bool) {
        localIRedTouchManager.reportLevelOneRedInfo(101500, 31);
      }
      i = VipInfoHandler.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), false);
      if ((paramView instanceof QVipMedalView)) {
        if (AnimatorHandler.playing) {
          ((QVipMedalView)paramView).a("0X800B2B5", i);
        } else {
          ((QVipMedalView)paramView).a("0X800B2B4", i);
        }
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "qvip", "0X800A127", 0, 0, String.valueOf(i), "", "", "");
      return;
    }
    if (paramView.getId() == 2131365970)
    {
      localObject2 = this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), 0).getString("sp_vip_medal_lvl_jump_url", null);
      if (a((String)localObject2)) {
        return;
      }
      localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
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
      i = VipInfoHandler.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), false);
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800B179", "0X800B179", 0, 0, String.valueOf(i), "", "", "");
      return;
    }
    if (paramView.getId() == 2131365952)
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, QQBrowserActivity.class);
      paramView.putExtra("uin", this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      paramView.putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=draw");
      paramView.putExtra("hide_more_button", true);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A9C3", "0X800A9C3", 0, 0, "", "", "", "");
      return;
    }
    if (paramView.getId() == 2131365966)
    {
      ((QQValuePagView)paramView).a("setting", this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      return;
    }
    if (paramView.getId() == 2131365977)
    {
      paramView = a().jdField_a_of_type_ComTencentMobileqqDataCard;
      if (paramView != null)
      {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramView.nameplateExtId);
        VipUtils.a("0X800B923", paramView.nameplateExtId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeHeadVipProcessor
 * JD-Core Version:    0.7.0.1
 */