package com.tencent.mobileqq.activity.contact.addcontact.publicaccount;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

class PublicView$3
  implements QQPermissionCallback
{
  PublicView$3(PublicView paramPublicView, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView.denied();
    DialogUtil.a(this.jdField_a_of_type_MqqAppAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView.3
 * JD-Core Version:    0.7.0.1
 */