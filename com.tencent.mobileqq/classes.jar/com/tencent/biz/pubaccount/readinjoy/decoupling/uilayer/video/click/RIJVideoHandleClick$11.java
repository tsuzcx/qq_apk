package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.report.RIJVideoReportManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsTwoItemViewHolder;

class RIJVideoHandleClick$11
  implements ClickHandler
{
  RIJVideoHandleClick$11(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo2;
    String str;
    ArticleInfo localArticleInfo1;
    if (paramView.getId() == 2131370295)
    {
      localArticleInfo2 = (ArticleInfo)((VideoFeedsTwoItemViewHolder)paramView.getTag()).a;
      str = ((VideoFeedsTwoItemViewHolder)paramView.getTag()).b.innerUniqueID;
      localArticleInfo1 = localArticleInfo2;
      if (paramView.getId() != 2131370295) {
        break label124;
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      RIJVideoReportManager.a(bool, localArticleInfo2, localArticleInfo1, str, null, RIJVideoHandleClick.a(this.a));
      return;
      localArticleInfo2 = (ArticleInfo)((VideoFeedsTwoItemViewHolder)paramView.getTag()).b;
      str = ((VideoFeedsTwoItemViewHolder)paramView.getTag()).a.innerUniqueID;
      localArticleInfo1 = (ArticleInfo)((VideoFeedsTwoItemViewHolder)paramView.getTag()).a;
      localArticleInfo2.isTwoItem = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.11
 * JD-Core Version:    0.7.0.1
 */