package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp;

class AEGIFTextEditFragment$10
  implements Runnable
{
  AEGIFTextEditFragment$10(AEGIFTextEditFragment paramAEGIFTextEditFragment, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    AEGIFTextEditFragment.g(this.this$0).a(this.a, this.b, this.c);
    AEGIFTextEditFragment.g(this.this$0).a(this.d);
    if (this.b.equals("#ccffffff"))
    {
      AEGIFTextEditFragment.g(this.this$0).a(false, true);
      return;
    }
    AEGIFTextEditFragment.g(this.this$0).a(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.10
 * JD-Core Version:    0.7.0.1
 */