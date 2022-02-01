package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

class CmGameAvHandler$17
  implements QQPermissionCallback
{
  CmGameAvHandler$17(CmGameAvHandler paramCmGameAvHandler, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.jdField_a_of_type_MqqAppAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.17
 * JD-Core Version:    0.7.0.1
 */