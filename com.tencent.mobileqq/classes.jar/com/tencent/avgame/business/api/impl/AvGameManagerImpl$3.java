package com.tencent.avgame.business.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class AvGameManagerImpl$3
  implements DialogInterface.OnClickListener
{
  AvGameManagerImpl$3(AvGameManagerImpl paramAvGameManagerImpl, Activity paramActivity, int paramInt1, String paramString, int paramInt2, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl.createAvGameRoom(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl.onPermisionDenied(this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.api.impl.AvGameManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */