package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.drawer.TroopAppShortcutDrawer;
import com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

public class TroopAppShortcutHelper
  implements ILifeCycleHelper
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  public NavigateBarManager a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public TroopAppShortcutHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private BaseChatDrawer a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((SessionInfo)localObject).jdField_a_of_type_JavaLangString)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localObject != null) {
        return new TroopAppShortcutDrawer((BaseChatPie)localObject);
      }
    }
    QLog.d("TroopAppShortcutHelper", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
    return null;
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
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie instanceof TroopChatPie)) {
      ((ChatDrawerHelper)localBaseChatPie.a(124)).a = a();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.a(3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.c(75);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.a();
  }
  
  public void e()
  {
    NavigateBarManager localNavigateBarManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager;
    if (localNavigateBarManager == null) {
      return;
    }
    localNavigateBarManager.d(3);
  }
  
  public String getTag()
  {
    return "TroopAppShortcutHelper";
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutHelper
 * JD-Core Version:    0.7.0.1
 */