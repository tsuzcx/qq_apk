package com.tencent.biz.qqcircle.widgets;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.QCirclePreLoadPicUtil;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;
import qqcircle.QQCircleDitto.StItemInfo;

@Deprecated
public class QCircleTagRecommendWidget$QCircleTagRecommendAdapter
  extends QCircleRecommendBaseAdapter
{
  public QCircleTagRecommendWidget$QCircleTagRecommendAdapter(QCircleTagRecommendWidget paramQCircleTagRecommendWidget) {}
  
  public QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626971, paramViewGroup, false));
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt, List<QQCircleDitto.StItemInfo> paramList)
  {
    this.b = paramStFeed;
    this.c = paramInt;
    if ((this.a != null) && (this.e != null))
    {
      this.a.clear();
      this.a.addAll(QCirclePreLoadPicUtil.b(paramList));
      paramStFeed = this.e;
      if (this.a.isEmpty()) {
        paramInt = 8;
      } else {
        paramInt = 0;
      }
      paramStFeed.setVisibility(paramInt);
      a();
      paramStFeed = new StringBuilder();
      paramStFeed.append("stItemInfos size = ");
      paramStFeed.append(paramList.size());
      QLog.d("QCircleTagPageRecommendWidget", 4, paramStFeed.toString());
      paramStFeed = new StringBuilder();
      paramStFeed.append("mDatas size = ");
      paramStFeed.append(this.a.size());
      QLog.d("QCircleTagPageRecommendWidget", 4, paramStFeed.toString());
    }
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.a.size() > paramInt) && ((paramViewHolder instanceof QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder)))
    {
      paramViewHolder = (QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder)paramViewHolder;
      paramViewHolder.a(this);
      paramViewHolder.a(this.b);
      paramViewHolder.a(this.c);
      paramViewHolder.b(this.g.getPageId());
      paramViewHolder.a(this.g.getReportBean());
      paramViewHolder.a(this.a.get(paramInt), paramInt);
      paramViewHolder = (QQCircleDitto.StItemInfo)this.a.get(paramInt);
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(this.b).setToUin(paramViewHolder.id.get()).setFeedType1(3).setFeedType2(3).setActionType(96).setSubActionType(1).setIndex(this.c).setContainerSeq(paramInt).setExt1(paramViewHolder.name.get()).setExt2(this.b.id.get()).setExt3((String)paramViewHolder.des.get().get(0)).setExt4(paramViewHolder.id.get()).setPageId(this.g.getPageId())));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagRecommendWidget.QCircleTagRecommendAdapter
 * JD-Core Version:    0.7.0.1
 */