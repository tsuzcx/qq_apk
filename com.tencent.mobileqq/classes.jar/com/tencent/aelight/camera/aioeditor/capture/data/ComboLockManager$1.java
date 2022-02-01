package com.tencent.aelight.camera.aioeditor.capture.data;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;

class ComboLockManager$1
  implements DialogInterface.OnClickListener
{
  ComboLockManager$1(ComboLockManager paramComboLockManager, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager;
    paramDialogInterface.b(paramDialogInterface.a.a);
    paramDialogInterface = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager;
    paramDialogInterface.a = null;
    if (paramInt == 1)
    {
      paramDialogInterface.c = true;
      if ((BaseActivity.sTopActivity instanceof SplashActivity))
      {
        paramDialogInterface = (SplashActivity)BaseActivity.sTopActivity;
        Intent localIntent = new Intent();
        localIntent.putExtra("main_tab_id", 8);
        localIntent.putExtra("fragment_id", 1);
        localIntent.putExtra("switch_anim", true);
        paramDialogInterface.openMainFragment(localIntent);
        return;
      }
      paramDialogInterface = new Intent(BaseActivity.sTopActivity, SplashActivity.class);
      paramDialogInterface.putExtra("tab_index", FrameControllerUtil.a);
      paramDialogInterface.putExtra("fragment_id", 1);
      paramDialogInterface.setFlags(67108864);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.ComboLockManager.1
 * JD-Core Version:    0.7.0.1
 */