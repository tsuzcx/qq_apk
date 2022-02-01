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
    if (this.a.getActivity().getIntent() != null) {
      paramDialogInterface.putExtras(this.a.getActivity().getIntent());
    }
    paramDialogInterface.putExtra("key_qcircle_pulish_use_draft", true);
    this.a.getActivity().setResult(-1, paramDialogInterface);
    this.a.getActivity().finish();
    AEReportUtils.d(3, this.b.i());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.3
 * JD-Core Version:    0.7.0.1
 */