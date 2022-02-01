package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilderUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.avatar.VasAvatarLoader;
import com.tencent.qphone.base.util.QLog;

public class DefaultHeadIconController
  extends BaseDefaultHeadIconController
{
  protected void a()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop;
    String str = BaseBubbleBuilderUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    int i = 1;
    if (j == 1006) {
      i = 11;
    }
    Drawable localDrawable = a(i, str);
    VasAvatarLoader localVasAvatarLoader = new VasAvatarLoader(str, -1, "small", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    localVasAvatarLoader.a = localDrawable;
    if (QLog.isColorLevel()) {
      QLog.d("BaseBubbleBuilder", 2, "QQ head, uin = " + str);
    }
    a(localVasAvatarLoader);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.DefaultHeadIconController
 * JD-Core Version:    0.7.0.1
 */