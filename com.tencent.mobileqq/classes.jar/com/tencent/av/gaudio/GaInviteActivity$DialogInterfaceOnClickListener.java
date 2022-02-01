package com.tencent.av.gaudio;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class GaInviteActivity$DialogInterfaceOnClickListener
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public GaInviteActivity$DialogInterfaceOnClickListener(GaInviteActivity paramGaInviteActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt != 0)
    {
      if ((paramInt == 1) || (paramInt == 2)) {
        this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.finish();
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.d) {
        this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.n();
      }
      this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.d();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteActivity.DialogInterfaceOnClickListener
 * JD-Core Version:    0.7.0.1
 */