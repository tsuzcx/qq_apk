package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter;

class AEGIFChunkPreviewFragment$1$1
  implements Runnable
{
  AEGIFChunkPreviewFragment$1$1(AEGIFChunkPreviewFragment.1 param1, int paramInt) {}
  
  public void run()
  {
    if (AEGIFChunkPreviewFragment.b(this.b.a) != null) {
      AEGIFChunkPreviewFragment.b(this.b.a).notifyItemChanged(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.1.1
 * JD-Core Version:    0.7.0.1
 */