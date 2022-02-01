package com.tencent.aelight.camera.ae.biz.circle;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.aelight.camera.aebase.AEReportUtils;

class AECirclePhotoListLogic$3
  implements DialogInterface.OnClickListener
{
  AECirclePhotoListLogic$3(AECirclePhotoListLogic paramAECirclePhotoListLogic, Fragment paramFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("key_qcircle_pulish_use_draft", true);
    this.jdField_a_of_type_AndroidAppFragment.getActivity().setResult(-1, paramDialogInterface);
    this.jdField_a_of_type_AndroidAppFragment.getActivity().finish();
    AEReportUtils.d(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.3
 * JD-Core Version:    0.7.0.1
 */