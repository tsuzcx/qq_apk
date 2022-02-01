package com.tencent.biz.qqcircle.publish.preview.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QCirclePicPreviewMoveAdapter$PicAddViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public QCirclePicPreviewMoveAdapter$PicAddViewHolder(QCirclePicPreviewMoveAdapter paramQCirclePicPreviewMoveAdapter, View paramView)
  {
    super(paramView);
    paramView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (QCirclePicPreviewMoveAdapter.a(this.a) != null) {
      QCirclePicPreviewMoveAdapter.a(this.a).a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePicPreviewMoveAdapter.PicAddViewHolder
 * JD-Core Version:    0.7.0.1
 */