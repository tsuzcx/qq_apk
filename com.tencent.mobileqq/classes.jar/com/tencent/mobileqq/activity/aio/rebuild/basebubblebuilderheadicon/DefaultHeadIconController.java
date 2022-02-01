package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilderUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.avatar.VasAvatarLoader;
import com.tencent.qphone.base.util.QLog;

public class DefaultHeadIconController
  extends BaseDefaultHeadIconController
{
  public boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop;
    String str = BaseBubbleBuilderUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    if (i == 1006) {
      i = 11;
    } else {
      i = 1;
    }
    Object localObject = a(i, str);
    VasAvatarLoader localVasAvatarLoader = new VasAvatarLoader(str, -1, "small", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    localVasAvatarLoader.a = ((Drawable)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQ head, uin = ");
      ((StringBuilder)localObject).append(str);
      QLog.d("BaseBubbleBuilder", 2, ((StringBuilder)localObject).toString());
    }
    b(localVasAvatarLoader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.DefaultHeadIconController
 * JD-Core Version:    0.7.0.1
 */