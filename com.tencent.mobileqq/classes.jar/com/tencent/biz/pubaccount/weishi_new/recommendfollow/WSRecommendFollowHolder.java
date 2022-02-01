package com.tencent.biz.pubaccount.weishi_new.recommendfollow;

import NS_KING_SOCIALIZE_META.stMetaNumericSys;
import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEvent.ActionId;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public class WSRecommendFollowHolder
  extends BaseViewHolder<stSimpleMetaPerson>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private stSimpleMetaPerson jdField_a_of_type_UserGrowthStSimpleMetaPerson;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSUserBusiness jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness;
  private WSRecommendFollowListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowListener;
  private WSRoundedImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  
  public WSRecommendFollowHolder(ViewGroup paramViewGroup, WSRecommendFollowListener paramWSRecommendFollowListener)
  {
    super(paramViewGroup, 2131560528);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowListener = paramWSRecommendFollowListener;
    d();
    c();
  }
  
  public static WSRecommendFollowHolder a(ViewGroup paramViewGroup, WSRecommendFollowListener paramWSRecommendFollowListener)
  {
    return new WSRecommendFollowHolder(paramViewGroup, paramWSRecommendFollowListener);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      WSFollowBeaconReport.a("nickname", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, WSReportEvent.ActionId.a);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowListener.b(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson);
      }
      return;
      if (paramInt == 2) {
        WSFollowBeaconReport.a("profile", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, WSReportEvent.ActionId.a);
      }
    }
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    WSFollowBeaconReport.a(this.jdField_a_of_type_Int + 1, paramstSimpleMetaPerson);
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, stMetaNumericSys paramstMetaNumericSys)
  {
    if (paramstMetaNumericSys == null)
    {
      paramTextView1.setText("");
      paramTextView2.setText("");
      return;
    }
    if (paramstMetaNumericSys.feed_num > 0)
    {
      paramTextView1.setText("作品");
      paramTextView2.setText(String.valueOf(paramstMetaNumericSys.feed_num));
      return;
    }
    if (paramstMetaNumericSys.fans_num > 0)
    {
      paramTextView1.setText("粉丝数");
      paramTextView2.setText(String.valueOf(paramstMetaNumericSys.fans_num));
      return;
    }
    paramTextView1.setText("");
    paramTextView2.setText("");
  }
  
  private void c()
  {
    this.c.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.g.setOnClickListener(this);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131369411));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131369402));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView = ((WSRoundedImageView)a(2131369401));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369404));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131369405));
    this.c = ((TextView)a(2131369403));
    this.d = ((TextView)a(2131369406));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131369407));
    this.e = ((TextView)a(2131369410));
    this.f = ((TextView)a(2131369408));
    this.g = ((TextView)a(2131369409));
    this.h = ((TextView)a(2131369326));
    this.i = ((TextView)a(2131369325));
  }
  
  private void e()
  {
    if (!NetworkUtil.a(a()))
    {
      ToastUtil.a().a(2131720723);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness = WSUserBusiness.a();
    }
    if (WSFeedUtils.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus))
    {
      WSFeedUtils.a(a(), new WSRecommendFollowHolder.1(this), null);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, 1);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus = 1;
    this.h.setVisibility(8);
    this.i.setVisibility(0);
    WSFollowBeaconReport.a("follow", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, WSReportEvent.ActionId.q);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowListener != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaPerson != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowListener.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson);
      WSFollowBeaconReport.a("close", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, WSReportEvent.ActionId.a);
    }
  }
  
  public stSimpleMetaPerson a()
  {
    return this.jdField_a_of_type_UserGrowthStSimpleMetaPerson;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaPerson == null) {
      return;
    }
    if (WSFeedUtils.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus))
    {
      this.h.setVisibility(8);
      this.i.setVisibility(0);
      return;
    }
    this.h.setVisibility(0);
    this.i.setVisibility(8);
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson, int paramInt)
  {
    super.a(paramstSimpleMetaPerson);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson = paramstSimpleMetaPerson;
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    WeishiUtils.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView, paramstSimpleMetaPerson.avatar);
    boolean bool = WSFeedUtils.b(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool) {}
    for (paramInt = 0;; paramInt = 8)
    {
      localTextView.setVisibility(paramInt);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      WSFeedUtils.a(this.jdField_b_of_type_AndroidWidgetTextView, paramstSimpleMetaPerson.medal, bool);
      this.d.setText(WSFeedUtils.a(paramstSimpleMetaPerson.nick));
      a(this.e, this.f, paramstSimpleMetaPerson.nueric);
      this.g.setText(paramstSimpleMetaPerson.recommendReason);
      a();
      return;
    }
  }
  
  public void b()
  {
    WSLog.b("WSRecommendFollowHolder", "[reportExposure]");
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaPerson == null)
    {
      WSLog.d("WSRecommendFollowHolder", "[reportExposure] mCurrentPerson is null");
      return;
    }
    a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson);
  }
  
  public void onClick(View paramView)
  {
    WSLog.b("WSRecommendFollowHolder", "[onClick] view: " + paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      f();
      continue;
      e();
      continue;
      a(1);
      continue;
      a(0);
      continue;
      a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSRecommendFollowHolder
 * JD-Core Version:    0.7.0.1
 */