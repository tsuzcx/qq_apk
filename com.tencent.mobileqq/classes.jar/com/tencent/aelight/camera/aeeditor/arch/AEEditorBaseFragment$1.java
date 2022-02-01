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
    if (this.this$0.d == null)
    {
      this.this$0.e = new ProgressView(this.a);
      this.this$0.d = new Dialog(this.a);
      this.this$0.d.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.this$0.d.setCanceledOnTouchOutside(false);
      this.this$0.d.requestWindowFeature(1);
      this.this$0.d.setContentView(this.this$0.e);
      this.this$0.d.setOnDismissListener(this.b);
    }
    else
    {
      this.this$0.d.dismiss();
    }
    this.this$0.d.setCancelable(this.c);
    this.this$0.e.setProgressText(this.d);
    this.this$0.d.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */