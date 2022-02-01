package com.tencent.biz.qqcircle.polylike;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import qqcircle.QQCircleFeedBase.StPolyLike;

class QCirclePolyLikeAllDialog$ViewHolder
  extends RecyclerView.ViewHolder
{
  public QCirclePolyLikeAllDialog$ViewHolder(QCirclePolyLikeAllDialog paramQCirclePolyLikeAllDialog, View paramView)
  {
    super(paramView);
  }
  
  public void a(QQCircleFeedBase.StPolyLike paramStPolyLike, int paramInt)
  {
    if ((this.itemView instanceof QCirclePolyBaseLikeView))
    {
      RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(DisplayUtil.d() / 4, DisplayUtil.d() / 4);
      this.itemView.setLayoutParams(localLayoutParams);
      ((QCirclePolyBaseLikeView)this.itemView).setReportBean(QCirclePolyLikeAllDialog.d(this.a));
      ((QCirclePolyBaseLikeView)this.itemView).setRequestManager(QCirclePolyLikeAllDialog.e(this.a));
      ((QCirclePolyBaseLikeView)this.itemView).setCurrentFeed(QCirclePolyLikeAllDialog.f(this.a));
      ((QCirclePolyBaseLikeView)this.itemView).setHookListener(new QCirclePolyLikeAllDialog.ViewHolder.1(this));
      ((QCirclePolyBaseLikeView)this.itemView).bindData(paramStPolyLike, paramInt);
      this.a.a((QCirclePolyBaseLikeView)this.itemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAllDialog.ViewHolder
 * JD-Core Version:    0.7.0.1
 */