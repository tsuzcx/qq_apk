package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessCache;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public class AnonymousHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  protected void a()
  {
    if (((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a().a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getConfessTopicId()).confessorSex == 1) {}
    for (int i = 2130845100;; i = 2130845099)
    {
      a(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i));
      return;
    }
  }
  
  public boolean a()
  {
    return ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(null);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.AnonymousHeadIconController
 * JD-Core Version:    0.7.0.1
 */