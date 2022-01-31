package com.tencent.mobileqq.avatar.dynamicavatar;

import alud;
import anug;
import anus;
import anuv;
import bddf;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

public class SelectCoverActivity$CoverTransProcessorHandler$1
  implements Runnable
{
  public SelectCoverActivity$CoverTransProcessorHandler$1(anuv paramanuv, SelectCoverActivity paramSelectCoverActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.a.a;
    File localFile = new File(str);
    if ((localFile != null) && (localFile.exists()))
    {
      anus.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 37, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.e, 200);
      bddf.a(str);
      return;
    }
    SelectCoverActivity.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity, 2, alud.a(2131714108), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.CoverTransProcessorHandler.1
 * JD-Core Version:    0.7.0.1
 */