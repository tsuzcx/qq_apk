package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorSelectionView;

class AEGIFTextColorAdapter$TextEditColorViewHolder
  extends RecyclerView.ViewHolder
{
  AEGIFTextColorSelectionView a;
  
  public AEGIFTextColorAdapter$TextEditColorViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.a = ((AEGIFTextColorSelectionView)paramView.findViewById(2064122008));
  }
  
  public void a(String paramString)
  {
    this.a.setColor(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFTextColorAdapter.TextEditColorViewHolder
 * JD-Core Version:    0.7.0.1
 */