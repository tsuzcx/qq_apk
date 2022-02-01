package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import java.io.File;

final class SelectCoverActivity$5
  implements Runnable
{
  SelectCoverActivity$5(SelectCoverActivity paramSelectCoverActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.a.a;
    if (new File(str).exists())
    {
      DynamicUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 37, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.e, 200);
      FaceUtil.a(str);
      return;
    }
    SelectCoverActivity.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity, 2, HardCodeUtil.a(2131713626), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.5
 * JD-Core Version:    0.7.0.1
 */