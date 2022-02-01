package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView;
import com.tencent.aelight.camera.ae.gif.giftext.DrawableImageView;

class AEGIFChunkPreviewAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  private ImageView b;
  private DrawableImageView c;
  private ImageView d;
  private AEGIFOutlineTextView e;
  private RelativeLayout f;
  
  public AEGIFChunkPreviewAdapter$ViewHolder(AEGIFChunkPreviewAdapter paramAEGIFChunkPreviewAdapter, View paramView, String paramString)
  {
    super(paramView);
    this.b = ((ImageView)paramView.findViewById(2063990927));
    this.f = ((RelativeLayout)paramView.findViewById(2063991344));
    this.c = ((DrawableImageView)paramView.findViewById(2063990833));
    this.d = ((ImageView)paramView.findViewById(2063990834));
    this.e = ((AEGIFOutlineTextView)paramView.findViewById(2063991291));
    this.e.setFontId(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setImageResource(2130838079);
      return;
    }
    this.b.setImageResource(2063925557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */