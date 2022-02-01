package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class WSVerticalItemBottomContentController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  
  public WSVerticalItemBottomContentController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramString);
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void f()
  {
    WSVerticalJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    WSVerticalBeaconReport.f(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    WSReportDC898Vertical.e();
  }
  
  public void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed))) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = localWSVerticalItemData.a();
    }
  }
  
  public int b()
  {
    return 2131560153;
  }
  
  public void b()
  {
    Object localObject = (WSVerticalItemData)a();
    if (localObject == null) {}
    while (!(((WSVerticalItemData)localObject).a() instanceof stSimpleMetaFeed)) {
      return;
    }
    localObject = ((WSVerticalItemData)localObject).a();
    a(((stSimpleMetaFeed)localObject).feed_desc);
    b(((stSimpleMetaFeed)localObject).material_desc);
  }
  
  public void c() {}
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131381198));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131381199));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131381199)
    {
      WSLog.b("WSVerticalItemBottomContentController", "跳转到微视端内");
      f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomContentController
 * JD-Core Version:    0.7.0.1
 */