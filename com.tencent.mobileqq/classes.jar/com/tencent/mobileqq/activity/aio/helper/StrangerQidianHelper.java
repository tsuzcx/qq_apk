package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.C2BTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class StrangerQidianHelper
  implements ILifeCycleHelper
{
  private final BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  protected C2BTipsBar a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QidianManager jdField_a_of_type_ComTencentQidianQidianManager;
  
  public StrangerQidianHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
  }
  
  public QidianManager a()
  {
    if (this.jdField_a_of_type_ComTencentQidianQidianManager == null) {
      this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
    return this.jdField_a_of_type_ComTencentQidianQidianManager;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
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
    return this.jdField_a_of_type_ComTencentQidianQidianManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, paramBoolean);
  }
  
  @NonNull
  public String getTag()
  {
    return "StrangerQidianHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject;
    if (paramInt != 4)
    {
      localObject = "";
      QidianManager localQidianManager;
      if (paramInt != 9)
      {
        if (paramInt != 15) {
          return;
        }
        if ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1025)) {
          this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
        }
        localQidianManager = this.jdField_a_of_type_ComTencentQidianQidianManager;
        if ((localQidianManager != null) && (localQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString))) {
          ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, false);
        }
        if (BmqqSegmentUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString))
        {
          localQidianManager = this.jdField_a_of_type_ComTencentQidianQidianManager;
          if (localQidianManager != null) {
            localObject = localQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.7.0", "");
        }
      }
      else if (BmqqSegmentUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString))
      {
        a();
        localQidianManager = this.jdField_a_of_type_ComTencentQidianQidianManager;
        if (localQidianManager != null) {
          localObject = localQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.7.0", "");
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1025)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getIntent().getByteArrayExtra("sigt");
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, (byte[])localObject);
        if (QLog.isDevelopLevel()) {
          QLog.d("StrangerQidianHelper", 4, "updateSession()--AIO 已保存 sigt");
        }
      }
      if (a().a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)) {
        a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      if (a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.StrangerQidianHelper
 * JD-Core Version:    0.7.0.1
 */