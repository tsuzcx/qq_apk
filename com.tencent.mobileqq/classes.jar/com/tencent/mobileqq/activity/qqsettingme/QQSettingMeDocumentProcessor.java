package com.tencent.mobileqq.activity.qqsettingme;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDocumentBean;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.IDocDrawerConfig;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocsListFragment;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import mqq.app.AppRuntime;

public class QQSettingMeDocumentProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public MutableLiveData<QQSettingMeDocumentBean> b = new MutableLiveData();
  
  public String a()
  {
    return "d_tencent_document";
  }
  
  public void a()
  {
    ThreadManager.excute(new QQSettingMeDocumentProcessor.2(this), 16, null, false);
  }
  
  public void a(View paramView)
  {
    Object localObject = ((IDocDrawerConfig)QRoute.api(IDocDrawerConfig.class)).getAndroidDrawerJumpURL();
    paramView = (View)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = "mqqapi://miniapp/open?_atype=0&_mappid=1108338344&_mvid=&_vt=3&via=2066_3&_sig=905243268";
    }
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramView))
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramView, 2066, null);
    }
    else
    {
      paramView = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(paramView, "s_qq_drawer");
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      ((Intent)localObject).putExtra("fragment_class", ((ITeamWorkDocsListFragment)QRoute.api(ITeamWorkDocsListFragment.class)).getCanonicalName());
      ((Intent)localObject).putExtra("tdsourcetag", "s_qq_drawer");
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity((Intent)localObject);
    }
    paramView = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    int i = 1;
    localObject = paramView.getAppInfo(1, String.valueOf(101700));
    if ((localObject == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0)) {
      i = 0;
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800BB68", "0X800BB68", 0, i, "", "", "", "");
    if (i != 0) {
      paramView.reportLevelOneRedInfo(101700, 31);
    }
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    super.a(paramQQSettingMe);
    this.b.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeDocumentProcessor.1(this, paramQQSettingMe));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    super.a(((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(1, String.valueOf(101700)), paramBoolean);
  }
  
  public void b()
  {
    super.b();
    g();
    ThreadManager.excute(new QQSettingMeDocumentProcessor.3(this), 16, null, false);
  }
  
  protected void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void g()
  {
    QQSettingMeDocumentBean localQQSettingMeDocumentBean = new QQSettingMeDocumentBean();
    localQQSettingMeDocumentBean.jdField_a_of_type_Boolean = ((IDocDrawerConfig)QRoute.api(IDocDrawerConfig.class)).getIsShowInDrawer().booleanValue();
    localQQSettingMeDocumentBean.b = ((IDocDrawerConfig)QRoute.api(IDocDrawerConfig.class)).getAndroidDrawerText();
    localQQSettingMeDocumentBean.jdField_a_of_type_JavaLangString = ((IDocDrawerConfig)QRoute.api(IDocDrawerConfig.class)).getAndroidDrawerIconURL();
    this.b.setValue(localQQSettingMeDocumentBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDocumentProcessor
 * JD-Core Version:    0.7.0.1
 */