package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.view.View;

class AEGIFSinglePreviewFragment$8
  implements Runnable
{
  AEGIFSinglePreviewFragment$8(AEGIFSinglePreviewFragment paramAEGIFSinglePreviewFragment) {}
  
  public void run()
  {
    if (AEGIFSinglePreviewFragment.h(this.this$0) == null)
    {
      AEGIFSinglePreviewFragment localAEGIFSinglePreviewFragment = this.this$0;
      AEGIFSinglePreviewFragment.a(localAEGIFSinglePreviewFragment, new Dialog(AEGIFSinglePreviewFragment.a(localAEGIFSinglePreviewFragment), 2131953338));
      AEGIFSinglePreviewFragment.h(this.this$0).setCancelable(false);
      AEGIFSinglePreviewFragment.h(this.this$0).setCanceledOnTouchOutside(false);
      AEGIFSinglePreviewFragment.h(this.this$0).setContentView(2064056505);
    }
    if (AEGIFSinglePreviewFragment.i(this.this$0) != null) {
      AEGIFSinglePreviewFragment.i(this.this$0).setVisibility(0);
    }
    AEGIFSinglePreviewFragment.h(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8
 * JD-Core Version:    0.7.0.1
 */