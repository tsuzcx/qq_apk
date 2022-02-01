package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.TopicInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

final class FastWebProteusReportUtils$1
  implements Runnable
{
  FastWebProteusReportUtils$1(FastWebArticleInfo paramFastWebArticleInfo) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.b == null) || (this.a.b.size() <= 0)) {
      QLog.i("FastWebProteusReportUtils", 1, "[topicTagReport] topic list is empty.");
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext())
      {
        ArticleTopicData.TopicInfo localTopicInfo = (ArticleTopicData.TopicInfo)localIterator.next();
        RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a();
        localReportR5Builder.b("puin", "" + this.a.d);
        localReportR5Builder.b("rowkey", this.a.j);
        localReportR5Builder.b("article_id", this.a.o);
        localReportR5Builder.b("tag_from_page", "3");
        localReportR5Builder.b("tag_rk", localTopicInfo.c);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B9BB", "0X800B9BB", 0, 0, "", "", "", localReportR5Builder.a(), false);
        QLog.i("FastWebProteusReportUtils", 1, "[topicTagReport] 0X800B9BB, r5 = " + localReportR5Builder.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebProteusReportUtils.1
 * JD-Core Version:    0.7.0.1
 */