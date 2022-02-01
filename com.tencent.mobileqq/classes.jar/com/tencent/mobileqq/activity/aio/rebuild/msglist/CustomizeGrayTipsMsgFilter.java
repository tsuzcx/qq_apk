package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.CustomizeGrayTipsManager;
import java.util.List;

public class CustomizeGrayTipsMsgFilter
  implements IMsgLoader
{
  public boolean a(@NonNull AIOContext paramAIOContext, boolean paramBoolean, List<ChatMessage> paramList)
  {
    return ((CustomizeGrayTipsManager)paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CUSTOMIZE_GRAY_TIPS)).a(paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.CustomizeGrayTipsMsgFilter
 * JD-Core Version:    0.7.0.1
 */