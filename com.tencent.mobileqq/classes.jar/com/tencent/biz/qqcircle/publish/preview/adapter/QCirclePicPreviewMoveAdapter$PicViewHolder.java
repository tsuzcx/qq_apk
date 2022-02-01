package com.tencent.biz.qqcircle.publish.preview.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePicPreviewMoveAdapter$PicViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private SquareImageView b;
  private ImageView c;
  
  public QCirclePicPreviewMoveAdapter$PicViewHolder(QCirclePicPreviewMoveAdapter paramQCirclePicPreviewMoveAdapter, View paramView)
  {
    super(paramView);
    this.b = ((SquareImageView)paramView.findViewById(2131436489));
    this.c = ((ImageView)paramView.findViewById(2131436339));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if (paramView == this.b)
    {
      if (QCirclePicPreviewMoveAdapter.a(this.a) != null) {
        QCirclePicPreviewMoveAdapter.a(this.a).a(paramView, i);
      }
    }
    else if (paramView == this.c) {
      QCirclePicPreviewMoveAdapter.a(this.a, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePicPreviewMoveAdapter.PicViewHolder
 * JD-Core Version:    0.7.0.1
 */