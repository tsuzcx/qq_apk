package com.tencent.mobileqq.activity.aio.coreui.msglist.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuDeleteProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuEssenceAddProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuEssenceCancelProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuFavoriteProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuMutePlayProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuReplyOnlyProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuReplyProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuRevokeProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuScreenShotProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuSelectMoreProcessor;
import com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuUpcomingEventProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseBubbleBuilderMenuProcessorImpl
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  private BaseBubbleBuilderMenuProcessor jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistMenuBaseBubbleBuilderMenuProcessor;
  private List<BaseBubbleBuilderMenuProcessor> jdField_a_of_type_JavaUtilList;
  
  public BaseBubbleBuilderMenuProcessorImpl(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  public static IBaseBubbleBuilderMenuAddProcessor a(BaseBubbleBuilderMenuProcessor paramBaseBubbleBuilderMenuProcessor)
  {
    if ((paramBaseBubbleBuilderMenuProcessor instanceof IBaseBubbleBuilderMenuAddProcessor)) {
      return (IBaseBubbleBuilderMenuAddProcessor)paramBaseBubbleBuilderMenuProcessor;
    }
    return null;
  }
  
  public static IBaseBubbleBuilderMenuClickProcessor a(BaseBubbleBuilderMenuProcessor paramBaseBubbleBuilderMenuProcessor)
  {
    if ((paramBaseBubbleBuilderMenuProcessor instanceof IBaseBubbleBuilderMenuClickProcessor)) {
      return (IBaseBubbleBuilderMenuClickProcessor)paramBaseBubbleBuilderMenuProcessor;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new BaseBubbleBuilderMenuReplyProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
      this.jdField_a_of_type_JavaUtilList.add(new BaseBubbleBuilderMenuScreenShotProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
      this.jdField_a_of_type_JavaUtilList.add(new BaseBubbleBuilderMenuReplyOnlyProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
      this.jdField_a_of_type_JavaUtilList.add(new BaseBubbleBuilderMenuUpcomingEventProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
      this.jdField_a_of_type_JavaUtilList.add(new BaseBubbleBuilderMenuEssenceAddProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
      this.jdField_a_of_type_JavaUtilList.add(new BaseBubbleBuilderMenuEssenceCancelProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
      this.jdField_a_of_type_JavaUtilList.add(new BaseBubbleBuilderMenuSelectMoreProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
      this.jdField_a_of_type_JavaUtilList.add(new BaseBubbleBuilderMenuRevokeProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
      this.jdField_a_of_type_JavaUtilList.add(new BaseBubbleBuilderMenuFavoriteProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
      this.jdField_a_of_type_JavaUtilList.add(new BaseBubbleBuilderMenuMutePlayProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
      this.jdField_a_of_type_JavaUtilList.add(new BaseBubbleBuilderMenuDeleteProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistMenuBaseBubbleBuilderMenuProcessor = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseBubbleBuilderMenuProcessor localBaseBubbleBuilderMenuProcessor = (BaseBubbleBuilderMenuProcessor)localIterator.next();
      if ((localBaseBubbleBuilderMenuProcessor != null) && (localBaseBubbleBuilderMenuProcessor.a(paramInt))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistMenuBaseBubbleBuilderMenuProcessor = localBaseBubbleBuilderMenuProcessor;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    a(paramInt);
    BaseBubbleBuilderMenuProcessor localBaseBubbleBuilderMenuProcessor = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistMenuBaseBubbleBuilderMenuProcessor;
    if ((localBaseBubbleBuilderMenuProcessor instanceof IBaseBubbleBuilderMenuClickProcessor)) {
      ((IBaseBubbleBuilderMenuClickProcessor)localBaseBubbleBuilderMenuProcessor).a(paramInt, paramContext, paramChatMessage);
    }
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    a(paramInt);
    BaseBubbleBuilderMenuProcessor localBaseBubbleBuilderMenuProcessor = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistMenuBaseBubbleBuilderMenuProcessor;
    if ((localBaseBubbleBuilderMenuProcessor instanceof IBaseBubbleBuilderMenuAddProcessor)) {
      ((IBaseBubbleBuilderMenuAddProcessor)localBaseBubbleBuilderMenuProcessor).a(paramQQCustomMenu, paramContext, paramInt, paramChatMessage, paramBundle);
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistMenuBaseBubbleBuilderMenuProcessor != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessorImpl
 * JD-Core Version:    0.7.0.1
 */