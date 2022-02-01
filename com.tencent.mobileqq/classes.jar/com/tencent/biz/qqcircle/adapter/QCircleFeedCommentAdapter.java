package com.tencent.biz.qqcircle.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.richframework.part.ExtraInfoInterface;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget;
import com.tencent.biz.richframework.widget.BaseWidgetView.IInteractor;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.List;

public class QCircleFeedCommentAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements ExtraInfoInterface, ReportBean<QCircleReportBean>
{
  private List<QCircleFeedCommentInfo> a;
  private BaseWidgetView.IInteractor b;
  private QCircleExtraTypeInfo c;
  private RecyclerView d;
  private QCircleReportBean e;
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean("QCircleFeedCommentAdaptr", this.e);
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.d = paramRecyclerView;
  }
  
  public void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.c = paramQCircleExtraTypeInfo;
  }
  
  public void a(BaseWidgetView.IInteractor paramIInteractor)
  {
    this.b = paramIInteractor;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.e = QCircleReportBean.setReportBean("QCircleFeedCommentAdaptr", paramQCircleReportBean);
  }
  
  public void a(List<QCircleFeedCommentInfo> paramList)
  {
    this.a = paramList;
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    List localList = this.a;
    if ((localList != null) && ((this.b instanceof QCircleInteractor))) {
      ((QCircleFeedCommentAdapter.FeedCommentVH)paramViewHolder).a(localList.get(paramInt), paramInt, this.c, (QCircleInteractor)this.b);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleFeedCommentWidget(paramViewGroup.getContext());
    paramViewGroup.setReportBean(a());
    paramViewGroup.setParentRecyclerView(this.d);
    return new QCircleFeedCommentAdapter.FeedCommentVH(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFeedCommentAdapter
 * JD-Core Version:    0.7.0.1
 */