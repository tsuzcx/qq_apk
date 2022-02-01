package com.tencent.mobileqq.activity.home.framejumpentry;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabWidget;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class TabJumpHelper
{
  private static volatile TabJumpHelper a;
  
  public static TabJumpHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TabJumpHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(FrameFragment paramFrameFragment, Intent paramIntent)
  {
    try
    {
      int i = paramIntent.getIntExtra("forward", -1);
      int j = paramIntent.getIntExtra("uintype", -1);
      if ((i > 0) && ((j == 1035) || (j == 1041) || (j == 1042)) && (((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime).isCreateManager(QQManagerFactory.PUSH_NOTICE_MANAGER)))
      {
        ((PushNoticeManager)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).a(paramFrameFragment.a(), paramIntent);
        return;
      }
      TabJumpHelper.BaseJumpActivityPlugin localBaseJumpActivityPlugin = a(i);
      if (localBaseJumpActivityPlugin != null) {
        localBaseJumpActivityPlugin.a(paramFrameFragment, paramIntent);
      }
      paramIntent.removeExtra("forward");
      return;
    }
    catch (Exception paramFrameFragment)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TabJumpHelper", 2, "", paramFrameFragment);
      }
    }
  }
  
  private void a(FrameFragment paramFrameFragment, Intent paramIntent, int paramInt)
  {
    if ((paramInt == FrameControllerUtil.h) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab()))
    {
      paramFrameFragment.jdField_a_of_type_AndroidContentIntent = paramIntent;
      QLog.d("TabJumpHelper", 1, "MainActivity:onNewIntent mTabHost, jump kandian tab fail, set pengingIntent");
    }
    if (QLog.isColorLevel()) {
      QLog.d("TabJumpHelper", 2, "MainActivity:onNewIntent mTabHost is null");
    }
  }
  
  private void a(FrameFragment paramFrameFragment, Bundle paramBundle, int paramInt)
  {
    Object localObject = (Conversation)paramFrameFragment.a(Conversation.class);
    String str = paramBundle.getString("from");
    if (localObject != null) {
      ((Conversation)localObject).b = "10003".equals(str);
    }
    int j = -1;
    int i = j;
    if ("smartdevice".equals(str))
    {
      i = j;
      if (paramInt == FrameControllerUtil.c) {
        i = 0;
      }
    }
    j = i;
    if (paramInt == FrameControllerUtil.f)
    {
      j = i;
      if (paramInt == paramFrameFragment.a()) {
        j = 1;
      }
    }
    i = j;
    if (paramInt == FrameControllerUtil.d)
    {
      i = j;
      if ("campus_notice".equals(str)) {
        i = 2;
      }
    }
    localObject = a(i);
    if (localObject != null) {
      ((TabJumpHelper.BaseJumpFramePlugin)localObject).a(paramFrameFragment, paramBundle, paramInt, str);
    }
  }
  
  private boolean a(FrameFragment paramFrameFragment, int paramInt)
  {
    if ((paramInt == FrameControllerUtil.b) && (!((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime).isCallTabShow))
    {
      Conversation localConversation = (Conversation)paramFrameFragment.a(Conversation.class);
      if (localConversation != null) {
        localConversation.a = true;
      }
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(FrameControllerUtil.a);
      return true;
    }
    return false;
  }
  
  private boolean a(FrameFragment paramFrameFragment, Bundle paramBundle, int paramInt)
  {
    if (paramInt != FrameControllerUtil.a) {
      return false;
    }
    if ((1 == paramBundle.getInt("conversation_index", -1)) && (!((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime).isCallTabShow))
    {
      paramBundle = (Conversation)paramFrameFragment.a(Conversation.class);
      if (paramBundle != null) {
        paramBundle.a = true;
      }
      paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(paramInt);
      return true;
    }
    if (paramInt == paramFrameFragment.a())
    {
      paramFrameFragment = (Conversation)paramFrameFragment.a(Conversation.class);
      String str = paramBundle.getString("from");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnNewIntent, same tab,from=");
        localStringBuilder.append(str);
        QLog.d("TabJumpHelper", 2, localStringBuilder.toString());
      }
      if (paramFrameFragment != null)
      {
        boolean bool;
        if ((!"10003".equals(str)) && (!"10004".equals(str))) {
          bool = false;
        } else {
          bool = true;
        }
        paramFrameFragment.b = bool;
        paramFrameFragment.c = paramBundle.getBoolean("theme_back_to_conversation", false);
      }
      return true;
    }
    return false;
  }
  
  private boolean a(QQTabHost paramQQTabHost, int paramInt)
  {
    if (paramInt == FrameControllerUtil.j)
    {
      paramQQTabHost.setCurrentTab(FrameControllerUtil.j);
      return true;
    }
    return false;
  }
  
  public TabJumpHelper.BaseJumpActivityPlugin a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createPlugin pluginKey: ");
    localStringBuilder.append(paramInt);
    QLog.d("TabJumpHelper", 1, localStringBuilder.toString());
    if (paramInt != 2)
    {
      if (paramInt != 3) {
        return null;
      }
      return new TabJumpHelper.WebActivityPlugin(this);
    }
    return new TabJumpHelper.ProfileActivityPlugin(this);
  }
  
  public TabJumpHelper.BaseJumpFramePlugin a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createPlugin pluginKey: ");
    localStringBuilder.append(paramInt);
    QLog.d("TabJumpHelper", 1, localStringBuilder.toString());
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return new TabJumpHelper.LebaFramePlugin(this);
      }
      return new TabJumpHelper.NowFramePlugin(this);
    }
    return new TabJumpHelper.ContactFramePlugin(this);
  }
  
  public void a(FrameFragment paramFrameFragment, Intent paramIntent, Bundle paramBundle, int paramInt)
  {
    if ((paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) && (paramInt >= 0))
    {
      if (a(paramFrameFragment, paramBundle, paramInt)) {
        return;
      }
      if (a(paramFrameFragment, paramInt)) {
        return;
      }
      if (a(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost, paramInt)) {
        return;
      }
      if (paramInt < paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getTabWidget().getChildCount())
      {
        a(paramFrameFragment, paramBundle, paramInt);
        paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(paramInt);
      }
      else if (paramInt == FrameControllerUtil.i)
      {
        paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(FrameControllerUtil.d);
      }
    }
    else
    {
      a(paramFrameFragment, paramIntent, paramInt);
    }
    a(paramFrameFragment, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.framejumpentry.TabJumpHelper
 * JD-Core Version:    0.7.0.1
 */