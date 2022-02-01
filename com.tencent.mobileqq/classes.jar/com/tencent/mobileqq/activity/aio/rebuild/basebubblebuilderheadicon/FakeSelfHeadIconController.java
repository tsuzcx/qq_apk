package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.ChatMessage;

public class FakeSelfHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.fakeSenderType == 1;
  }
  
  protected void b()
  {
    b(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
  }
  
  protected void c()
  {
    a(null);
  }
  
  protected void d()
  {
    a(null);
  }
  
  protected void g()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.FakeSelfHeadIconController
 * JD-Core Version:    0.7.0.1
 */