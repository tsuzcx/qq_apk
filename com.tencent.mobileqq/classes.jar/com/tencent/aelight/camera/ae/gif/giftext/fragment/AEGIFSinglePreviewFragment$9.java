package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;

class AEGIFSinglePreviewFragment$9
  implements Runnable
{
  AEGIFSinglePreviewFragment$9(AEGIFSinglePreviewFragment paramAEGIFSinglePreviewFragment) {}
  
  public void run()
  {
    if (!AEGIFSinglePreviewFragment.a(this.this$0).isFinishing())
    {
      if ((AEGIFSinglePreviewFragment.h(this.this$0) != null) && (AEGIFSinglePreviewFragment.h(this.this$0).isShowing())) {
        AEGIFSinglePreviewFragment.h(this.this$0).dismiss();
      }
      if (AEGIFSinglePreviewFragment.i(this.this$0) != null) {
        AEGIFSinglePreviewFragment.i(this.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.9
 * JD-Core Version:    0.7.0.1
 */