package com.tencent.biz.pubaccount.readinjoy.comment.guide;

import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.CommentGuideConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class GuidePopuppWindow$2$1
  implements ViewBase.OnClickListener
{
  GuidePopuppWindow$2$1(GuidePopuppWindow.2 param2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return;
    case 1096: 
      RIJJumpUtils.a(GuidePopuppWindow.a(this.a.a), GuidePopuppWindow.a(this.a.a), CommentGuideConfigHandler.a(GuidePopuppWindow.a(this.a.a).innerUniqueID));
      this.a.a.a(2);
      this.a.a.dismiss();
      paramViewBase = new RIJTransMergeKanDianReport.ReportR5Builder();
      paramViewBase.i().b("wording", "" + CommentGuideConfigHandler.a());
      ReadInJoyCommentUtils.a("0X8009FE8", GuidePopuppWindow.a(this.a.a), paramViewBase);
      return;
    }
    this.a.a.a(1);
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.guide.GuidePopuppWindow.2.1
 * JD-Core Version:    0.7.0.1
 */