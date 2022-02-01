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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;

public abstract class WSGridCommonHolder
  extends AbsWSGridBaseHolder<stSimpleMetaFeed>
  implements View.OnClickListener, WSGridCardContract.View
{
  private final WSGridCardPresenter a;
  
  public WSGridCommonHolder(ViewGroup paramViewGroup, int paramInt, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramViewGroup, 2131560538, paramInt, paramWSRecommendAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardPresenter = new WSGridCardPresenter(this);
    this.itemView.setOnClickListener(this);
  }
  
  public WSRecommendAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
  }
  
  public void onClick(View paramView)
  {
    if (WeishiUtils.c()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = getAdapterPosition() - ((RecyclerViewHeaderViewAdapter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.getAdapter()).a();
      WSLog.b("WSGridCommonHolder", "onClick: " + i);
      ArrayList localArrayList = new ArrayList();
      if ((i >= this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.b()) || (i < 0))
      {
        WSLog.d("WSGridCommonHolder", "position out of bound");
      }
      else
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_JavaLangObject;
        if (localstSimpleMetaFeed == null)
        {
          WSLog.d("WSGridCommonHolder", "feed is null");
        }
        else
        {
          WSReportDc00898.a(112, WSReportDc00898.a(i, localstSimpleMetaFeed));
          WeishiLinkUtil.b();
          Context localContext = a();
          if (localstSimpleMetaFeed.video_type == 1)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardPresenter.a(localContext, localstSimpleMetaFeed, i);
            WSLog.b("WSGridCommonHolder", "点击了运营图片");
          }
          else if (localstSimpleMetaFeed.video_type == 6)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardPresenter.a(localContext, i, localstSimpleMetaFeed);
          }
          else if (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardPresenter.a(localContext, i, localArrayList, localstSimpleMetaFeed))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardPresenter.a(localContext, i, localArrayList, localstSimpleMetaFeed, true);
            WSGridBeaconReport.a("gzh_click", localstSimpleMetaFeed, UserActionReportPresenter.a(localstSimpleMetaFeed, i), 1000001, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridCommonHolder
 * JD-Core Version:    0.7.0.1
 */