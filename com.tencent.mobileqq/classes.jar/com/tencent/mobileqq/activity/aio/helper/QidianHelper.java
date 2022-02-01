package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.activity.aio.tips.C2BTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianHandler;
import java.util.Map;

public class QidianHelper
  implements ILifeCycleHelper
{
  private final BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private final FriendChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie;
  protected C2BTipsBar a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public QidianManager a;
  
  public QidianHelper(FriendChatPie paramFriendChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie = paramFriendChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramFriendChatPie.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().isCreateManager(QQManagerFactory.QIDIAN_MANAGER)) {
      this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
  }
  
  public String a()
  {
    QidianManager localQidianManager = this.jdField_a_of_type_ComTencentQidianQidianManager;
    if (localQidianManager == null) {
      return null;
    }
    return localQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsC2BTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsC2BTipsBar = new C2BTipsBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsC2BTipsBar);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsC2BTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(boolean paramBoolean)
  {
    QidianManager localQidianManager = this.jdField_a_of_type_ComTencentQidianQidianManager;
    return (localQidianManager != null) && (localQidianManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, paramBoolean));
  }
  
  public String getTag()
  {
    return "QidianHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject1;
    if (paramInt != 4)
    {
      localObject1 = "";
      Object localObject2;
      if (paramInt != 9)
      {
        if (paramInt != 15) {
          return;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
        if ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && ((((BaseSessionInfo)localObject2).jdField_a_of_type_Int == 1024) || (this.jdField_a_of_type_ComTencentQidianQidianManager.a(((BaseSessionInfo)localObject2).jdField_a_of_type_JavaLangString)))) {
          this.jdField_a_of_type_ComTencentQidianQidianManager.a(((BaseSessionInfo)localObject2).jdField_a_of_type_JavaLangString, ((BaseSessionInfo)localObject2).jdField_a_of_type_Int);
        }
        QidianManager localQidianManager = this.jdField_a_of_type_ComTencentQidianQidianManager;
        if ((localQidianManager != null) && (localQidianManager.a(((BaseSessionInfo)localObject2).jdField_a_of_type_JavaLangString))) {
          ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(null, ((BaseSessionInfo)localObject2).jdField_a_of_type_JavaLangString, false);
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie instanceof BusinessCmrTmpChatPie)) || (BmqqSegmentUtil.c(((BaseSessionInfo)localObject2).jdField_a_of_type_JavaLangString)))
        {
          localQidianManager = this.jdField_a_of_type_ComTencentQidianQidianManager;
          if (localQidianManager != null) {
            localObject1 = localQidianManager.a(((BaseSessionInfo)localObject2).jdField_a_of_type_JavaLangString);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), "dc00899", "Qidian", ((BaseSessionInfo)localObject2).jdField_a_of_type_JavaLangString, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject1, "8.7.0", "");
        }
      }
      else
      {
        if (BmqqSegmentUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie instanceof BusinessCmrTmpChatPie)) || (BmqqSegmentUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          a();
          localObject2 = this.jdField_a_of_type_ComTencentQidianQidianManager;
          if (localObject2 != null) {
            localObject1 = ((QidianManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_JavaLangString);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject1, "8.7.0", "");
        }
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentQidianQidianManager;
      if ((localObject1 != null) && (((QidianManager)localObject1).a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      localObject1 = this.jdField_a_of_type_ComTencentQidianQidianManager;
      if ((localObject1 != null) && (((QidianManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        CrmUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QidianHelper
 * JD-Core Version:    0.7.0.1
 */