package com.tencent.biz.qqcircle.publish.activity;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.publish.report.QCirclePublishReport;

class QCircleLabelPart$3
  implements QCircleLabelPart.OnMyItemClickListener
{
  QCircleLabelPart$3(QCircleLabelPart paramQCircleLabelPart) {}
  
  public void a(RecyclerView paramRecyclerView, View paramView, int paramInt, String paramString)
  {
    if ((paramView instanceof TextView))
    {
      QCircleLabelPart.b(this.a).a(paramInt);
      paramRecyclerView = this.a;
      paramString = new StringBuilder();
      paramString.append("#");
      paramView = (TextView)paramView;
      paramString.append(paramView.getText().toString());
      QCircleLabelPart.a(paramRecyclerView, paramString.toString());
      QCirclePublishReport.a(15, 24, 2, null, null, null, paramView.getText().toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLabelPart.3
 * JD-Core Version:    0.7.0.1
 */