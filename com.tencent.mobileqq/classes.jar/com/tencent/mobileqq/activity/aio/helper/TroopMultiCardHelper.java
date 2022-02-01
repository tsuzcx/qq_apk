package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.drawer.AIODrawerDpc;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.drawer.TroopMultiCardDrawer;
import com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.GroupIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.GroupIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.multiaio.manager.MultiAIOEntranceConfigData;
import com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopMultiCardHelper
  implements ILifeCycleHelper
{
  private static int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  public NavigateBarManager a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MultiAIOEntranceConfigData jdField_a_of_type_ComTencentMobileqqMultiaioManagerMultiAIOEntranceConfigData;
  
  private static int a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMultiCardHelper", 2, "getLocalMultiCardSwitchStatus() called load from sp");
      }
      localObject = (QQAppInterface)localObject;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("multicard_switch_sp");
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
      return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).getInt("key_multicard_switch", 1);
    }
    return -1;
  }
  
  private BaseChatDrawer a()
  {
    if (!AIODrawerDpc.a())
    {
      QLog.d("TroopMultiCardHelper", 1, "createChatDrawer, not support!");
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((SessionInfo)localObject).jdField_a_of_type_JavaLangString)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localObject != null) {
        return new TroopMultiCardDrawer((BaseChatPie)localObject);
      }
    }
    QLog.d("TroopMultiCardHelper", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
    return null;
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Int == -1) {
      jdField_a_of_type_Int = a();
    }
    return jdField_a_of_type_Int != 0;
  }
  
  public static boolean b()
  {
    GroupIntimateRelationshipBean localGroupIntimateRelationshipBean = GroupIntimateRelationshipConfProcessor.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSwitchOn:");
      localStringBuilder.append(localGroupIntimateRelationshipBean.a);
      QLog.d("TroopMultiCardHelper", 2, localStringBuilder.toString());
    }
    return localGroupIntimateRelationshipBean.a;
  }
  
  private boolean c()
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMultiCardHelper", 2, "isLocalSwitchOn: false");
      }
      return false;
    }
    if (!b()) {
      return false;
    }
    f();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioManagerMultiAIOEntranceConfigData.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Build.MANUFACTURER);
    ((StringBuilder)localObject2).append(Build.MODEL);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("devicetype:");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" version:");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.d("TroopMultiCardHelper", 2, localStringBuilder.toString());
    }
    localObject2 = ((String)localObject2).trim();
    if ((localObject1 != null) && (((List)localObject1).contains(localObject2))) {
      return false;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioManagerMultiAIOEntranceConfigData.a();
    return (TextUtils.isEmpty((CharSequence)localObject1)) || (QmcfDevicesStrategy.b((String)localObject1) > 0);
  }
  
  public void a()
  {
    NavigateBarManager localNavigateBarManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager;
    if (localNavigateBarManager != null)
    {
      localNavigateBarManager.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager = null;
    }
  }
  
  public void b()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) && (c())) {
      ((ChatDrawerHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(124)).a = a();
    }
    if ((((ChatDrawerHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(124)).a != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)))
    {
      if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        AIOUtils.a((InputLinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131368875), 2130850177);
        if (!ThemeUtil.isDefaultTheme()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850433);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850434);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d.setBackgroundResource(2130843798);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130843804);
    }
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager == null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131364485);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager = new NavigateBarManager(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localRelativeLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.a(2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.c(75);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.a();
  }
  
  public void e()
  {
    NavigateBarManager localNavigateBarManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager;
    if (localNavigateBarManager == null) {
      return;
    }
    localNavigateBarManager.d(2);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioManagerMultiAIOEntranceConfigData = ((MultiAIOEntranceConfigData)QConfigManager.a().a(478));
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioManagerMultiAIOEntranceConfigData == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioManagerMultiAIOEntranceConfigData = new MultiAIOEntranceConfigData();
      if (QLog.isColorLevel()) {
        QLog.d("TroopMultiCardHelper", 2, "MultiAIOEntranceConfigData =null, general new bean");
      }
    }
  }
  
  public String getTag()
  {
    return "TroopMultiCardHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 9)
      {
        if (paramInt != 15) {
          return;
        }
        a();
        return;
      }
      c();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopMultiCardHelper
 * JD-Core Version:    0.7.0.1
 */