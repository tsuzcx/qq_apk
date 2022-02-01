package com.tencent.biz.qqcircle.polylike;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.mobileqq.pb.PBEnumField;
import java.util.List;
import qqcircle.QQCircleFeedBase.StPolyLike;

class QCirclePolyLikeAllDialog$GirdAdapter
  extends RecyclerView.Adapter<QCirclePolyLikeAllDialog.ViewHolder>
{
  private QCirclePolyLikeAllDialog$GirdAdapter(QCirclePolyLikeAllDialog paramQCirclePolyLikeAllDialog) {}
  
  public QCirclePolyLikeAllDialog.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = QCirclePolyLikeViewFactory.a(paramViewGroup.getContext(), 512, paramInt);
    return new QCirclePolyLikeAllDialog.ViewHolder(this.a, paramViewGroup);
  }
  
  public void a(QCirclePolyLikeAllDialog.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder != null) {
      paramViewHolder.a((QQCircleFeedBase.StPolyLike)QCirclePolyLikeAllDialog.c(this.a).get(paramInt), paramInt);
    }
  }
  
  public int getItemCount()
  {
    return QCirclePolyLikeAllDialog.c(this.a).size();
  }
  
  public int getItemViewType(int paramInt)
  {
    QQCircleFeedBase.StPolyLike localStPolyLike = (QQCircleFeedBase.StPolyLike)QCirclePolyLikeAllDialog.c(this.a).get(paramInt);
    if (localStPolyLike != null)
    {
      if (localStPolyLike.articleType.get() == 0) {
        return 1;
      }
      if (localStPolyLike.articleType.get() == 1) {
        return 2;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAllDialog.GirdAdapter
 * JD-Core Version:    0.7.0.1
 */