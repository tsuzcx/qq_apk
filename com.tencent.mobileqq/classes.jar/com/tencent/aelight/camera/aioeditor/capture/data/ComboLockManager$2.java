package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ComboLockManager$2
  implements Runnable
{
  ComboLockManager$2(ComboLockManager paramComboLockManager, Context paramContext, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720121);
    String str2 = localBaseActivity.getString(2131720118);
    DialogInterface.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
    DialogUtil.a(localBaseActivity, 0, str1, str2, 2131720119, 2131720120, localOnClickListener, localOnClickListener).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.ComboLockManager.2
 * JD-Core Version:    0.7.0.1
 */