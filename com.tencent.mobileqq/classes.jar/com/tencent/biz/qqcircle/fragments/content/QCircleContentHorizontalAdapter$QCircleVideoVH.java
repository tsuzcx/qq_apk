package com.tencent.biz.qqcircle.fragments.content;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickLayout;
import com.tencent.image.URLImageView;

public class QCircleContentHorizontalAdapter$QCircleVideoVH
  extends RecyclerView.ViewHolder
{
  QCircleContentVideo a;
  URLImageView b;
  QCircleExpandStickLayout c;
  
  public QCircleContentHorizontalAdapter$QCircleVideoVH(QCircleContentHorizontalAdapter paramQCircleContentHorizontalAdapter, View paramView)
  {
    super(paramView);
    paramQCircleContentHorizontalAdapter = (FrameLayout)paramView;
    this.b = ((URLImageView)paramQCircleContentHorizontalAdapter.getChildAt(0));
    this.c = ((QCircleExpandStickLayout)paramQCircleContentHorizontalAdapter.getChildAt(1));
  }
  
  public void a()
  {
    if ((((FrameLayout)this.itemView).getChildAt(0) instanceof QCircleContentVideo))
    {
      QCircleContentVideo localQCircleContentVideo = (QCircleContentVideo)((FrameLayout)this.itemView).getChildAt(0);
      localQCircleContentVideo.release();
      localQCircleContentVideo.setVideoCover(null);
      ((FrameLayout)this.itemView).removeViewAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentHorizontalAdapter.QCircleVideoVH
 * JD-Core Version:    0.7.0.1
 */