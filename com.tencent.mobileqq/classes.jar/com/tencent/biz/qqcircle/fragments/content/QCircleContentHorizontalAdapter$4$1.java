package com.tencent.biz.qqcircle.fragments.content;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

class QCircleContentHorizontalAdapter$4$1
  implements Runnable
{
  QCircleContentHorizontalAdapter$4$1(QCircleContentHorizontalAdapter.4 param4) {}
  
  public void run()
  {
    RecyclerView.ViewHolder localViewHolder = QCircleContentHorizontalAdapter.c(this.a.b).findViewHolderForLayoutPosition(this.a.a);
    if (QCircleContentHorizontalAdapter.e(this.a.b) != null) {
      QCircleContentHorizontalAdapter.e(this.a.b).a(localViewHolder);
    }
    this.a.b.a(localViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentHorizontalAdapter.4.1
 * JD-Core Version:    0.7.0.1
 */