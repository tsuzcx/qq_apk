package com.tencent.biz.qqcircle.publish.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.biz.qqcircle.publish.viewmodel.QCircleLabelViewModel;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qzone.model.LabelInfo;
import java.util.ArrayList;

class QCircleLabelPart$LabelAdapter
  extends RecyclerView.Adapter<QCircleLabelPart.LabelAdapter.ViewHolder>
  implements View.OnClickListener
{
  QCircleLabelPart.OnMyItemClickListener a;
  
  public QCircleLabelPart$LabelAdapter(QCircleLabelPart paramQCircleLabelPart) {}
  
  public QCircleLabelPart.LabelAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new TextView(this.b.g());
    paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    paramViewGroup.setGravity(16);
    paramViewGroup.setPadding(0, 0, ViewUtils.a(16.0F), 0);
    paramViewGroup.setTextSize(2, 14.0F);
    paramViewGroup.setTextColor(QCircleSkinHelper.getInstance().getColor(2131167081));
    paramViewGroup.setOnClickListener(this);
    return new QCircleLabelPart.LabelAdapter.ViewHolder(this, paramViewGroup);
  }
  
  public void a(int paramInt)
  {
    QCircleLabelPart.a(this.b).a(paramInt);
    notifyItemRemoved(paramInt);
  }
  
  public void a(QCircleLabelPart.LabelAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if ((QCircleLabelPart.a(this.b).f != null) && (paramInt >= 0))
    {
      if (paramInt >= QCircleLabelPart.a(this.b).f.size()) {
        return;
      }
      paramViewHolder.a((LabelInfo)QCircleLabelPart.a(this.b).f.get(paramInt));
    }
  }
  
  public void a(QCircleLabelPart.OnMyItemClickListener paramOnMyItemClickListener)
  {
    this.a = paramOnMyItemClickListener;
  }
  
  public int getItemCount()
  {
    if (QCircleLabelPart.a(this.b).f == null) {
      return 0;
    }
    return QCircleLabelPart.a(this.b).f.size();
  }
  
  public void onClick(View paramView)
  {
    if ((QCircleLabelPart.k(this.b) != null) && (this.a != null))
    {
      int i = QCircleLabelPart.k(this.b).getChildAdapterPosition(paramView);
      this.a.a(QCircleLabelPart.k(this.b), paramView, i, "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLabelPart.LabelAdapter
 * JD-Core Version:    0.7.0.1
 */