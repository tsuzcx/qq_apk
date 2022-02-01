package com.tencent.biz.qqstory.takevideo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.app.BaseActivity;

class DanceMachineUploadVideoFragment$3
  implements DialogInterface.OnKeyListener
{
  DanceMachineUploadVideoFragment$3(DanceMachineUploadVideoFragment paramDanceMachineUploadVideoFragment) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 84) {
      return true;
    }
    if (paramInt == 4)
    {
      this.a.a();
      this.a.a();
      paramDialogInterface = this.a.a;
      paramKeyEvent = this.a.a;
      paramDialogInterface.setResult(0);
      this.a.a.finish();
      DanceMachineUploadVideoFragment.a(this.a, false);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.DanceMachineUploadVideoFragment.3
 * JD-Core Version:    0.7.0.1
 */