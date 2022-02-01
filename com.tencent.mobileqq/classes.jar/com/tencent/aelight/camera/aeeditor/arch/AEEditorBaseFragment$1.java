package com.tencent.aelight.camera.aeeditor.arch;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.aeeditor.view.ProgressView;
import com.tencent.aelight.camera.log.AEQLog;

class AEEditorBaseFragment$1
  implements Runnable
{
  AEEditorBaseFragment$1(AEEditorBaseFragment paramAEEditorBaseFragment, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean, CharSequence paramCharSequence) {}
  
  public void run()
  {
    if (this.this$0.getActivity().isFinishing())
    {
      AEQLog.c("AEEditorBaseFragment", "Activity has been destroy.");
      return;
    }
    if (this.this$0.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorViewProgressView = new ProgressView(this.jdField_a_of_type_AndroidContentContext);
      this.this$0.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext);
      this.this$0.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.this$0.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.this$0.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.this$0.jdField_a_of_type_AndroidAppDialog.setContentView(this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorViewProgressView);
      this.this$0.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
    else
    {
      this.this$0.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.this$0.jdField_a_of_type_AndroidAppDialog.setCancelable(this.jdField_a_of_type_Boolean);
    this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorViewProgressView.setProgressText(this.jdField_a_of_type_JavaLangCharSequence);
    this.this$0.jdField_a_of_type_AndroidAppDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */