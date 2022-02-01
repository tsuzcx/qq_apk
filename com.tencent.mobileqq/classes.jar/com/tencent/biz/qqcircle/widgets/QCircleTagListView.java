package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.adapter.QCircleTagListAdapter;
import com.tencent.biz.qqcircle.beans.QCircleTagItemInfo;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleBase.CircleRankingData;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

public class QCircleTagListView
  implements ReportBean<QCircleReportBean>
{
  protected QCircleReportBean a;
  private RecyclerView b;
  private View c;
  private QCircleTagListAdapter d;
  private List<QCircleTagItemInfo> e;
  private FeedCloudMeta.StUser f;
  
  private void b(List<QQCircleBase.CircleRankingData> paramList, QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    this.e = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QCircleTagItemInfo localQCircleTagItemInfo = new QCircleTagItemInfo(2, (QQCircleBase.CircleRankingData)paramList.next());
        this.e.add(localQCircleTagItemInfo);
      }
    }
    if (paramStMainPageBusiRspData != null)
    {
      paramList = paramStMainPageBusiRspData.recomTagList.get().iterator();
      while (paramList.hasNext())
      {
        paramStMainPageBusiRspData = new QCircleTagItemInfo(1, (FeedCloudMeta.StTagInfo)paramList.next());
        this.e.add(paramStMainPageBusiRspData);
      }
    }
  }
  
  protected String a()
  {
    return "QCircleTagListView";
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      this.b = ((RecyclerView)paramView.findViewById(2131441895));
      this.c = paramView.findViewById(2131449872);
      this.b.setOverScrollMode(2);
      this.b.setVisibility(8);
      paramView = new LinearLayoutManager(paramView.getContext());
      paramView.setOrientation(0);
      this.b.setLayoutManager(paramView);
      this.d = new QCircleTagListAdapter();
      this.b.setAdapter(this.d);
    }
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.a = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    this.f = paramStUser;
  }
  
  public void a(List<QQCircleBase.CircleRankingData> paramList, QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    b(paramList, paramStMainPageBusiRspData);
    if (this.e.size() > 0)
    {
      this.b.setVisibility(0);
      paramList = this.c;
      if (paramList != null) {
        paramList.setVisibility(0);
      }
      paramList = this.d;
      if (paramList != null)
      {
        paramList.a(b());
        this.d.a(this.f);
        this.d.a(this.e);
      }
    }
    else
    {
      this.b.setVisibility(8);
      paramList = this.c;
      if (paramList != null) {
        paramList.setVisibility(8);
      }
    }
  }
  
  public void a(QQCircleFeedBase.StMainPageBusiRspData paramStMainPageBusiRspData)
  {
    a(null, paramStMainPageBusiRspData);
  }
  
  public QCircleReportBean b()
  {
    return QCircleReportBean.getReportBean(a(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagListView
 * JD-Core Version:    0.7.0.1
 */