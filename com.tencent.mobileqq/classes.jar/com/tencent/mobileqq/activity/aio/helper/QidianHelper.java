package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianHandler;

public class QidianHelper
  implements ILifeCycleHelper
{
  private FriendChatPie a;
  
  public QidianHelper(FriendChatPie paramFriendChatPie)
  {
    this.a = paramFriendChatPie;
  }
  
  public String getTag()
  {
    return "QidianHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    SessionInfo localSessionInfo;
    do
    {
      return;
      localObject = this.a.jdField_a_of_type_ComTencentQidianQidianManager;
      localSessionInfo = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if ((localObject != null) && ((localSessionInfo.jdField_a_of_type_Int == 1024) || (((QidianManager)localObject).a(localSessionInfo.jdField_a_of_type_JavaLangString)))) {
        ((QidianManager)localObject).a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int);
      }
      if ((localObject != null) && (((QidianManager)localObject).a(localSessionInfo.jdField_a_of_type_JavaLangString))) {
        ((QidianHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(null, localSessionInfo.jdField_a_of_type_JavaLangString, false);
      }
    } while ((!(this.a instanceof BusinessCmrTmpChatPie)) && (!BmqqSegmentUtil.b(localSessionInfo.jdField_a_of_type_JavaLangString)));
    if (localObject == null) {}
    for (Object localObject = "";; localObject = ((QidianManager)localObject).a(localSessionInfo.jdField_a_of_type_JavaLangString))
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", localSessionInfo.jdField_a_of_type_JavaLangString, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.5.5", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QidianHelper
 * JD-Core Version:    0.7.0.1
 */