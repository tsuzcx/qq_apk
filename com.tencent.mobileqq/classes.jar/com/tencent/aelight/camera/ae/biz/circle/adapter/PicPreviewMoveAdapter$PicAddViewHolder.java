package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;

public class PicPreviewMoveAdapter$PicAddViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (PicPreviewMoveAdapter.a(this.a) != null) {
      PicPreviewMoveAdapter.a(this.a).a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PicPreviewMoveAdapter.PicAddViewHolder
 * JD-Core Version:    0.7.0.1
 */