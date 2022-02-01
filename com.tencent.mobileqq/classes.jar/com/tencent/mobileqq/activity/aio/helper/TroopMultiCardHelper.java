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
import com.tencent.mobileqq.theme.ThemeUtil;
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
      return BaseApplicationImpl.getApplication().getSharedPreferences("multicard_switch_sp" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).getInt("key_multicard_switch", 1);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null))
    {
      QLog.d("TroopMultiCardHelper", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
      return null;
    }
    return new TroopMultiCardDrawer(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
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
    if (QLog.isColorLevel()) {
      QLog.d("TroopMultiCardHelper", 2, "isSwitchOn:" + localGroupIntimateRelationshipBean.a);
    }
    return localGroupIntimateRelationshipBean.a;
  }
  
  private boolean c()
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMultiCardHelper", 2, "isLocalSwitchOn: false");
      }
    }
    Object localObject;
    do
    {
      String str;
      do
      {
        do
        {
          return false;
        } while (!b());
        f();
        localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioManagerMultiAIOEntranceConfigData.a();
        str = Build.MANUFACTURER + Build.MODEL;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMultiCardHelper", 2, "devicetype:" + str + " version:" + Build.VERSION.SDK_INT);
        }
        str = str.trim();
      } while ((localObject != null) && (((List)localObject).contains(str)));
      localObject = this.jdField_a_of_type_ComTencentMobileqqMultiaioManagerMultiAIOEntranceConfigData.a();
    } while ((!TextUtils.isEmpty((CharSequence)localObject)) && (QmcfDevicesStrategy.b((String)localObject) <= 0));
    return true;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager = null;
    }
  }
  
  public void b()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) && (c())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer = a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)))
    {
      if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label144;
      }
      AIOUtils.a((InputLinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131369142), 2130850250);
      if (ThemeUtil.isDefaultTheme()) {
        break label129;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850507);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
      return;
      label129:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850508);
    }
    label144:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d.setBackgroundResource(2130843878);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130843884);
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager == null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131364598);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager = new NavigateBarManager(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localRelativeLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.a(2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.c(75);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.d(2);
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
    return new int[] { 4, 8, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      b();
      return;
    case 8: 
      c();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopMultiCardHelper
 * JD-Core Version:    0.7.0.1
 */