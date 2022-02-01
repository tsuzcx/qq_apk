package com.tencent.biz.qqcircle.publish.activity;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import cooperation.qzone.model.LabelInfo;

public class QCircleLabelPart$LabelAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  TextView a;
  
  public QCircleLabelPart$LabelAdapter$ViewHolder(QCircleLabelPart.LabelAdapter paramLabelAdapter, View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView);
  }
  
  public void a(LabelInfo paramLabelInfo)
  {
    this.a.setText(paramLabelInfo.name);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLabelPart.LabelAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */