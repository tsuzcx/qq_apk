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
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.l()) {
        this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.e(true);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.d();
        break;
        if (this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.d) {
          this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.l();
        }
      }
      this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteActivity.DialogInterfaceOnClickListener
 * JD-Core Version:    0.7.0.1
 */