package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class GroupPanelBarLoader
  extends BaseChatPanelBarLoader
{
  public GroupPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  private void a(SessionInfo paramSessionInfo, boolean paramBoolean, HotChatManager paramHotChatManager)
  {
    paramHotChatManager = paramHotChatManager.a(paramSessionInfo.jdField_a_of_type_JavaLangString);
    a(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
    a(AIOPanelUtiles.V);
    if (!paramHotChatManager.isRobotHotChat) {
      a(AIOPanelUtiles.F);
    }
    a(AIOPanelUtiles.H);
    if (paramBoolean) {}
    for (paramSessionInfo = AIOPanelUtiles.i;; paramSessionInfo = AIOPanelUtiles.e)
    {
      a(paramSessionInfo);
      if (!paramHotChatManager.isRobotHotChat) {
        a(AIOPanelUtiles.w);
      }
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if ((ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, false, null)) || (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null)))
    {
      AIOPanelUtiles.Y[2] = 2130838084;
      return;
    }
    AIOPanelUtiles.Y[2] = 2130838085;
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    a(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
    int[] arrayOfInt;
    if (paramBoolean)
    {
      arrayOfInt = AIOPanelUtiles.p;
      a(arrayOfInt);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().a());
      c();
      if (!((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).n(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label105;
      }
      a(AIOPanelUtiles.z);
      label69:
      a(AIOPanelUtiles.Y);
      if (!paramBoolean) {
        break label121;
      }
    }
    label105:
    label121:
    for (paramQQAppInterface = AIOPanelUtiles.i;; paramQQAppInterface = AIOPanelUtiles.e)
    {
      a(paramQQAppInterface);
      a(AIOPanelUtiles.w);
      return;
      arrayOfInt = AIOPanelUtiles.l;
      break;
      if (!AIOPanelUtiles.jdField_a_of_type_Boolean) {
        break label69;
      }
      a(AIOPanelUtiles.B);
      break label69;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a(AIOPanelUtiles.b);
    if (paramBoolean)
    {
      arrayOfInt = AIOPanelUtiles.q;
      a(arrayOfInt);
      a(AIOPanelUtiles.t);
      if (!paramBoolean) {
        break label55;
      }
    }
    label55:
    for (int[] arrayOfInt = AIOPanelUtiles.j;; arrayOfInt = AIOPanelUtiles.f)
    {
      a(arrayOfInt);
      a(AIOPanelUtiles.x);
      return;
      arrayOfInt = AIOPanelUtiles.m;
      break;
    }
  }
  
  public List<AIOPanelIconItem> a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    a(paramQQAppInterface);
    return super.a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    paramBaseChatPie = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((paramBaseChatPie != null) && (paramBaseChatPie.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramQQAppInterface = paramBaseChatPie.a(paramSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.d);
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.W);
      if (!paramQQAppInterface.isRobotHotChat) {
        this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.G);
      }
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.I);
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.h);
      if (!paramQQAppInterface.isRobotHotChat) {
        this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.y);
      }
      return;
    }
    a(AIOPanelUtiles.d);
    a(AIOPanelUtiles.o);
    a();
    b();
    if (((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).n(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      a(AIOPanelUtiles.A);
    }
    for (;;)
    {
      a(AIOPanelUtiles.Y);
      a(AIOPanelUtiles.h);
      a(AIOPanelUtiles.y);
      return;
      if (AIOPanelUtiles.jdField_a_of_type_Boolean) {
        a(AIOPanelUtiles.C);
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return paramSessionInfo.jdField_a_of_type_Int == 1;
  }
  
  public void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    a(paramQQAppInterface, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d());
  }
  
  public void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool1 = AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString);
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
    if (bool1)
    {
      a(bool2);
      return;
    }
    paramBaseChatPie = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((paramBaseChatPie != null) && (paramBaseChatPie.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      a(paramSessionInfo, bool2, paramBaseChatPie);
      return;
    }
    a(paramQQAppInterface, paramSessionInfo, bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.GroupPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */