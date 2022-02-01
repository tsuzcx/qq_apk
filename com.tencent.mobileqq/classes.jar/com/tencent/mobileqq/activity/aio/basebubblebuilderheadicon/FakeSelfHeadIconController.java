package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public class FakeSelfHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  protected void a()
  {
    a(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.fakeSenderType == 1;
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.FakeSelfHeadIconController
 * JD-Core Version:    0.7.0.1
 */