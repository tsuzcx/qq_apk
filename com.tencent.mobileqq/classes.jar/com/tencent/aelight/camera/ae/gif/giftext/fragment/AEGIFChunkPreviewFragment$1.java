package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import com.tencent.aelight.camera.ae.gif.giftext.AEGIFPreviewWrapper;
import com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue.Callback;
import com.tencent.aelight.camera.aebase.BaseVMPeakActivity;
import java.util.List;

class AEGIFChunkPreviewFragment$1
  implements PngsCreateWorkingQueue.Callback
{
  AEGIFChunkPreviewFragment$1(AEGIFChunkPreviewFragment paramAEGIFChunkPreviewFragment) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      AEGIFChunkPreviewFragment.a(this.a, paramString);
    }
    ((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(paramInt)).f = paramString;
    ((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(paramInt)).a = 13;
    AEGIFChunkPreviewFragment.c(this.a).runOnUiThread(new AEGIFChunkPreviewFragment.1.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */