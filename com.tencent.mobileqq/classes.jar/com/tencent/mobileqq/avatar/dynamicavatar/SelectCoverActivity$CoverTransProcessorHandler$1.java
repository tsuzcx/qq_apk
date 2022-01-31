package com.tencent.mobileqq.avatar.dynamicavatar;

import alpo;
import anpx;
import anqj;
import anqm;
import bcyw;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

public class SelectCoverActivity$CoverTransProcessorHandler$1
  implements Runnable
{
  public SelectCoverActivity$CoverTransProcessorHandler$1(anqm paramanqm, SelectCoverActivity paramSelectCoverActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.a.a;
    File localFile = new File(str);
    if ((localFile != null) && (localFile.exists()))
    {
      anqj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 37, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.e, 200);
      bcyw.a(str);
      return;
    }
    SelectCoverActivity.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity, 2, alpo.a(2131714096), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.CoverTransProcessorHandler.1
 * JD-Core Version:    0.7.0.1
 */