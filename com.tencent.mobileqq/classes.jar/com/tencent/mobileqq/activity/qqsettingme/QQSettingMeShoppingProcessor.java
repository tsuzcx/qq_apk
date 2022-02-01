package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.MenumItem;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import androidx.lifecycle.MutableLiveData;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDynamicItemBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeShoppingBean;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vip.QQSettingConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IliveDbManager;
import cooperation.ilive.manager.IliveRedManager;
import cooperation.ilive.share.IliveShareHelper;
import cooperation.ilive.util.IliveEntranceUtil;
import cooperation.ilive.util.IlivePreloadHelper;
import java.util.Map;
import mqq.app.AppRuntime;

public class QQSettingMeShoppingProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public MutableLiveData<QQSettingMeShoppingBean> b = new MutableLiveData();
  public MutableLiveData<QQSettingMeDynamicItemBean> c = new MutableLiveData();
  
  private String a(String paramString1, String paramString2)
  {
    if (IliveRedManager.isRecomRedJumpUrl(paramString2)) {
      return paramString2;
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    return str;
  }
  
  private void j()
  {
    Object localObject1 = QQSettingConfigManager.a().a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    Object localObject2 = Integer.valueOf(1);
    Object localObject3 = (MenumItem)((Map)localObject1).get(localObject2);
    if (localObject3 == null) {
      return;
    }
    localObject1 = new QQSettingMeDynamicItemBean();
    ((QQSettingMeDynamicItemBean)localObject1).jdField_a_of_type_JavaLangString = QQSettingConfigManager.a().a((Integer)localObject2);
    if (!TextUtils.isEmpty(((MenumItem)localObject3).title)) {
      ((QQSettingMeDynamicItemBean)localObject1).jdField_a_of_type_ComTencentMobileqqTextQQText = ChatRoomUtil.a(((MenumItem)localObject3).title, 16);
    }
    if (!TextUtils.isEmpty(((MenumItem)localObject3).icon))
    {
      localObject2 = ((MenumItem)localObject3).icon;
      localObject3 = URLDrawableHelperConstants.a;
      ((QQSettingMeDynamicItemBean)localObject1).jdField_a_of_type_ComTencentImageURLDrawable = VasApngUtil.getApngURLDrawable((String)localObject2, new int[] { 1 }, (Drawable)localObject3, null, null);
    }
    this.c.postValue(localObject1);
  }
  
  public String a()
  {
    return "d_qq_shopping";
  }
  
  public void a()
  {
    j();
  }
  
  public void a(View paramView)
  {
    Object localObject2 = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    paramView = ((IRedTouchManager)localObject2).getAppInfo(1, String.valueOf(101100));
    int i;
    if ((paramView != null) && (paramView.iNewFlag.get() != 0)) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject1 = IliveRedManager.parseShopRedBuffer(paramView);
    String str = IliveDbManager.getIliveDrawerData("drawer_shop_jump_scheme");
    paramView = IliveRedManager.getDrawerLiveReportStr2(paramView);
    IliveRedManager.sRedShoppingStr2 = paramView;
    IliveShareHelper.reportAction("qq_live", "chouti_page", "zhibo", "zhibo_button", "4", 102, IliveShareHelper.getFollowInfo("", paramView, "", "", ""));
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (i != 0) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    ReportController.b(localAppRuntime, "dc00898", "", "", "0X800B1F7", "0X800B1F7", 0, 0, paramView, "", "", "");
    if (i != 0) {
      ((IRedTouchManager)localObject2).reportLevelOneRedInfo(101100, 31);
    }
    paramView = a((String)localObject1, str);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Ilive start jump shop , redJumpUrl = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" \nshopJumpUrl = ");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("\nfinalJump = ");
      ((StringBuilder)localObject2).append(paramView);
      QLog.i("IliveRed", 2, ((StringBuilder)localObject2).toString());
    }
    if (URLUtil.isNetworkUrl(paramView))
    {
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", paramView);
      ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_vip");
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity((Intent)localObject1);
      return;
    }
    paramView = JumpParser.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramView);
    if (paramView != null)
    {
      paramView.a();
      return;
    }
    ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, IliveDbManager.getILiveEnterInfo(1));
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    super.a(paramQQSettingMe);
    this.b.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeShoppingProcessor.1(this, paramQQSettingMe));
    this.c.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeShoppingProcessor.2(this, paramQQSettingMe));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    super.a(((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(1, String.valueOf(101100)), paramBoolean);
  }
  
  public void b()
  {
    super.b();
    j();
    g();
  }
  
  protected void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (paramBoolean) {
      paramAppInfo = "1";
    } else {
      paramAppInfo = "2";
    }
    ReportController.b(localAppRuntime, "dc00898", "", "", "0X800B1F6", "0X800B1F6", 0, 0, paramAppInfo, "", "", "");
  }
  
  public void f()
  {
    j();
    g();
  }
  
  public void g()
  {
    QQSettingMeShoppingBean localQQSettingMeShoppingBean = new QQSettingMeShoppingBean();
    boolean bool;
    if ((IliveEntranceUtil.d()) && (!StudyModeManager.a())) {
      bool = true;
    } else {
      bool = false;
    }
    localQQSettingMeShoppingBean.jdField_a_of_type_Boolean = bool;
    if (QQSettingConfigManager.a().a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, 2))
    {
      this.b.postValue(localQQSettingMeShoppingBean);
      return;
    }
    localQQSettingMeShoppingBean.jdField_a_of_type_JavaLangString = IliveDbManager.getILiveEnterInfo(1);
    if ((!SubscribeUtils.a()) && (!QQTheme.f())) {
      localQQSettingMeShoppingBean.b = IliveDbManager.getILiveEnterInfo(2);
    }
    this.b.postValue(localQQSettingMeShoppingBean);
  }
  
  public void h()
  {
    if (QQSettingMe.a("d_qq_shopping").getVisibility() == 0) {
      IlivePreloadHelper.a(BaseApplicationImpl.getApplication(), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeShoppingProcessor
 * JD-Core Version:    0.7.0.1
 */