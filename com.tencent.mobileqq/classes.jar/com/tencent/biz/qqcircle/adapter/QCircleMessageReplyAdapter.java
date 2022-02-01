package com.tencent.biz.qqcircle.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleMessageReplyItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleMessageReplyItemView.QCircleMessageReplyItemListener;
import com.tencent.biz.qqcircle.richframework.part.ExtraInfoInterface;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.List;

public class QCircleMessageReplyAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements ExtraInfoInterface, ReportBean<QCircleReportBean>
{
  private List<QCircleFeedCommentInfo> a;
  private QCircleMessageReplyItemView.QCircleMessageReplyItemListener b;
  private QCircleExtraTypeInfo c;
  private QCircleReportBean d;
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean("QCircleMessageReplyAdapter", this.d);
  }
  
  public void a(QCircleMessageReplyItemView.QCircleMessageReplyItemListener paramQCircleMessageReplyItemListener)
  {
    this.b = paramQCircleMessageReplyItemListener;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.d = QCircleReportBean.setReportBean("QCircleMessageReplyAdapter", paramQCircleReportBean);
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
    if (localList != null) {
      ((QCircleMessageReplyAdapter.FeedCommentVH)paramViewHolder).a(localList.get(paramInt), paramInt, this.c);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleMessageReplyItemView(paramViewGroup.getContext());
    paramViewGroup.setReplyItemListener(this.b);
    paramViewGroup.setReportBean(a());
    return new QCircleMessageReplyAdapter.FeedCommentVH(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleMessageReplyAdapter
 * JD-Core Version:    0.7.0.1
 */