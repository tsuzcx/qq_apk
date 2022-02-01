package com.tencent.mobileqq.avatar.dynamicavatar;

import anvx;
import aoks;
import aqeq;
import aqfc;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

final class SelectCoverActivity$4
  implements Runnable
{
  SelectCoverActivity$4(SelectCoverActivity paramSelectCoverActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.a.b;
    File localFile = new File(str);
    if ((localFile != null) && (localFile.exists()))
    {
      aqfc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 38, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.e, 100);
      aoks.a(str);
      return;
    }
    SelectCoverActivity.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity, 2, anvx.a(2131713165), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.4
 * JD-Core Version:    0.7.0.1
 */