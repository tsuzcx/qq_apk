package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFPreviewWrapper;
import java.util.Set;

class AEGIFChunkPreviewAdapter$1
  implements View.OnClickListener
{
  AEGIFChunkPreviewAdapter$1(AEGIFChunkPreviewAdapter paramAEGIFChunkPreviewAdapter, AEGIFPreviewWrapper paramAEGIFPreviewWrapper, int paramInt, AEGIFChunkPreviewAdapter.ViewHolder paramViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == 13)
    {
      boolean bool = this.a.a() ^ true;
      if (bool)
      {
        AEGIFChunkPreviewAdapter.a(this.d).add(Integer.valueOf(this.b));
        AEGIFChunkPreviewAdapter.a(this.d, true);
      }
      else
      {
        AEGIFChunkPreviewAdapter.a(this.d).remove(Integer.valueOf(this.b));
        if (AEGIFChunkPreviewAdapter.a(this.d).size() < 1) {
          AEGIFChunkPreviewAdapter.a(this.d, false);
        }
      }
      this.a.a(bool);
      this.c.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.1
 * JD-Core Version:    0.7.0.1
 */