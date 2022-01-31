package com.tencent.mobileqq.avatar.dynamicavatar;

import ajyc;
import alyz;
import alzl;
import alzo;
import bazo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

public class SelectCoverActivity$CoverTransProcessorHandler$2
  implements Runnable
{
  public SelectCoverActivity$CoverTransProcessorHandler$2(alzo paramalzo, SelectCoverActivity paramSelectCoverActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.a.b;
    File localFile = new File(str);
    if ((localFile != null) && (localFile.exists()))
    {
      alzl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 38, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.e, 100);
      bazo.a(str);
      return;
    }
    SelectCoverActivity.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity, 2, ajyc.a(2131713706), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.CoverTransProcessorHandler.2
 * JD-Core Version:    0.7.0.1
 */