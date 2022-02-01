package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.view.View;

class AEGIFSinglePreviewFragment$8
  implements Runnable
{
  AEGIFSinglePreviewFragment$8(AEGIFSinglePreviewFragment paramAEGIFSinglePreviewFragment) {}
  
  public void run()
  {
    if (AEGIFSinglePreviewFragment.a(this.this$0) == null)
    {
      AEGIFSinglePreviewFragment localAEGIFSinglePreviewFragment = this.this$0;
      AEGIFSinglePreviewFragment.a(localAEGIFSinglePreviewFragment, new Dialog(AEGIFSinglePreviewFragment.a(localAEGIFSinglePreviewFragment), 2131756189));
      AEGIFSinglePreviewFragment.a(this.this$0).setCancelable(false);
      AEGIFSinglePreviewFragment.a(this.this$0).setCanceledOnTouchOutside(false);
      AEGIFSinglePreviewFragment.a(this.this$0).setContentView(2064318634);
    }
    if (AEGIFSinglePreviewFragment.a(this.this$0) != null) {
      AEGIFSinglePreviewFragment.a(this.this$0).setVisibility(0);
    }
    AEGIFSinglePreviewFragment.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8
 * JD-Core Version:    0.7.0.1
 */