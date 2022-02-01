package com.tencent.aelight.camera.ae.play;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;

class AEVideoPreviewFragment$3
  implements DialogInterface.OnClickListener
{
  AEVideoPreviewFragment$3(AEVideoPreviewFragment paramAEVideoPreviewFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = this.this$0.getMediaPosition();
    paramDialogInterface = new Intent("AEEDITOR_GENERATE_STATUS_DELETE");
    paramDialogInterface.putExtra("delete_position", paramInt);
    paramDialogInterface.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(paramDialogInterface);
    this.this$0.getBaseActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoPreviewFragment.3
 * JD-Core Version:    0.7.0.1
 */