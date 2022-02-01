package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;

public abstract class WSGridCommonHolder
  extends AbsWSGridBaseHolder<stSimpleMetaFeed>
  implements View.OnClickListener, WSGridCardContract.View
{
  private final WSGridCardPresenter d = new WSGridCardPresenter(this);
  
  public WSGridCommonHolder(ViewGroup paramViewGroup, int paramInt, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramViewGroup, 2131626472, paramInt, paramWSRecommendAdapter);
    this.itemView.setOnClickListener(this);
  }
  
  public WSRecommendAdapter a()
  {
    return this.c;
  }
  
  public void onClick(View paramView)
  {
    if (WeishiUtils.o()) {
      return;
    }
    int i = getAdapterPosition() - ((RecyclerViewHeaderViewAdapter)this.c.a.getAdapter()).getHeaderCount();
    paramView = new StringBuilder();
    paramView.append("onClick: ");
    paramView.append(i);
    WSLog.b("WSGridCommonHolder", paramView.toString());
    if ((i < this.c.getCustomItemCount()) && (i >= 0))
    {
      paramView = (stSimpleMetaFeed)this.b;
      if (paramView == null)
      {
        WSLog.d("WSGridCommonHolder", "feed is null");
        return;
      }
      WSReportDc00898.a(112, WSReportDc00898.a(i, paramView));
      WeishiLinkUtil.c();
      Context localContext = getContext();
      if (paramView.video_type == 1)
      {
        this.d.a(localContext, paramView, i);
        WSLog.b("WSGridCommonHolder", "点击了运营图片");
        return;
      }
      if (paramView.video_type == 6)
      {
        this.d.a(localContext, i, paramView);
        return;
      }
      if (this.d.a(localContext, i, paramView, this.itemView)) {
        return;
      }
      this.d.a(localContext, i, paramView, true, false, this.itemView);
      WSGridBeaconReport.a("gzh_click", paramView, UserActionReportPresenter.a(paramView, i), 1000001, this.c.l);
      return;
    }
    WSLog.d("WSGridCommonHolder", "position out of bound");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridCommonHolder
 * JD-Core Version:    0.7.0.1
 */