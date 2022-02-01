package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class AEGIFTextColorAdapter$1
  implements View.OnClickListener
{
  AEGIFTextColorAdapter$1(AEGIFTextColorAdapter paramAEGIFTextColorAdapter, int paramInt, AEGIFTextColorAdapter.TextEditColorViewHolder paramTextEditColorViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (this.a != AEGIFTextColorAdapter.a(this.c))
    {
      paramView = (AEGIFTextColorAdapter.TextEditColorViewHolder)AEGIFTextColorAdapter.b(this.c).findViewHolderForAdapterPosition(AEGIFTextColorAdapter.a(this.c));
      if (paramView != null) {
        paramView.a(false);
      } else {
        this.c.notifyDataSetChanged();
      }
      this.b.a(true);
      this.c.a(this.a);
      if (AEGIFTextColorAdapter.c(this.c) != null) {
        AEGIFTextColorAdapter.c(this.c).setTextColor(Color.parseColor(AEGIFTextColorAdapter.d(this.c)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFTextColorAdapter.1
 * JD-Core Version:    0.7.0.1
 */