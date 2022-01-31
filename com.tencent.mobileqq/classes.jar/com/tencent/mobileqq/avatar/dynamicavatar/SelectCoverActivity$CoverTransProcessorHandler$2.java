package com.tencent.mobileqq.avatar.dynamicavatar;

import ajya;
import alyy;
import alzk;
import alzn;
import bbac;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

public class SelectCoverActivity$CoverTransProcessorHandler$2
  implements Runnable
{
  public SelectCoverActivity$CoverTransProcessorHandler$2(alzn paramalzn, SelectCoverActivity paramSelectCoverActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.a.b;
    File localFile = new File(str);
    if ((localFile != null) && (localFile.exists()))
    {
      alzk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 38, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.e, 100);
      bbac.a(str);
      return;
    }
    SelectCoverActivity.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity, 2, ajya.a(2131713717), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.CoverTransProcessorHandler.2
 * JD-Core Version:    0.7.0.1
 */