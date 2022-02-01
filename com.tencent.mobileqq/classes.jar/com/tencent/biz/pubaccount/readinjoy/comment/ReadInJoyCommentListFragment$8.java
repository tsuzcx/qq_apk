package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.comment.guide.GuidePopuppWindow.OnGuideDismissListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class ReadInJoyCommentListFragment$8
  implements GuidePopuppWindow.OnGuideDismissListener
{
  ReadInJoyCommentListFragment$8(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a(int paramInt)
  {
    if (paramInt != 2) {
      this.a.d();
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder1 = new RIJTransMergeKanDianReport.ReportR5Builder();
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder2 = localReportR5Builder1.i().b("rowkey", ReadInJoyCommentListFragment.a(this.a).innerUniqueID).b("entry", "2");
    if (paramInt == 2) {}
    for (String str = "1";; str = "0")
    {
      localReportR5Builder2.b("result", str);
      ReadInJoyCommentUtils.a("0X800A00F", ReadInJoyCommentListFragment.a(this.a), localReportR5Builder1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment.8
 * JD-Core Version:    0.7.0.1
 */