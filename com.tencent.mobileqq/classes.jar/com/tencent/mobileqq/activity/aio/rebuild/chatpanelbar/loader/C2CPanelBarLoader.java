package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type.SessionTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.pluspanel.PlusPanelUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.List;

public class C2CPanelBarLoader
  extends BaseChatPanelBarLoader
{
  public C2CPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
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
  
  public List<AIOPanelIconItem> a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    a(paramQQAppInterface);
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().a();
    if (!Utils.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.b = PlusPanelUtil.a(localContext);
    }
    if ((this.b != null) && (this.b.size() > 0)) {}
    for (;;)
    {
      return this.b;
      this.jdField_a_of_type_JavaUtilList = b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
      this.b = a(localContext, this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.d);
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.o);
    a();
    b();
    if (AIOPanelUtiles.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.C);
    }
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.h);
    if (Utils.b(paramSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.U);
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.y);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return SessionTypeUtil.a(paramQQAppInterface, paramSessionInfo, paramSessionInfo.jdField_a_of_type_Int);
  }
  
  public List<int[]> b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().a();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (bool) {
      if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
        b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_JavaUtilList;
      a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
      continue;
      c(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
    paramBaseChatPie = this.jdField_a_of_type_JavaUtilList;
    if (bool)
    {
      paramQQAppInterface = AIOPanelUtiles.p;
      paramBaseChatPie.add(paramQQAppInterface);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().a());
      c();
      if (AIOPanelUtiles.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.B);
      }
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilList;
      if (!bool) {
        break label141;
      }
    }
    label141:
    for (paramQQAppInterface = AIOPanelUtiles.i;; paramQQAppInterface = AIOPanelUtiles.e)
    {
      paramBaseChatPie.add(paramQQAppInterface);
      if (!Utils.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label148;
      }
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.T);
      return;
      paramQQAppInterface = AIOPanelUtiles.l;
      break;
    }
    label148:
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.C2CPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */