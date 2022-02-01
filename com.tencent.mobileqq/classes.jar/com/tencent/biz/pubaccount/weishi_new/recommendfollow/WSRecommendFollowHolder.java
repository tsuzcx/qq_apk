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
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEvent.ActionId;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.open.base.ToastUtil;
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
    super(paramViewGroup, 2131560415);
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
    } else if (paramInt == 2) {
      WSFollowBeaconReport.a("profile", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, WSReportEvent.ActionId.a);
    }
    WSRecommendFollowListener localWSRecommendFollowListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowListener;
    if (localWSRecommendFollowListener != null) {
      localWSRecommendFollowListener.b(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson);
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getView(2131369139));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getView(2131369130));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView = ((WSRoundedImageView)getView(2131369129));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getView(2131369132));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)getView(2131369133));
    this.c = ((TextView)getView(2131369131));
    this.d = ((TextView)getView(2131369134));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)getView(2131369135));
    this.e = ((TextView)getView(2131369138));
    this.f = ((TextView)getView(2131369136));
    this.g = ((TextView)getView(2131369137));
    this.h = ((TextView)getView(2131369058));
    this.i = ((TextView)getView(2131369057));
  }
  
  private void e()
  {
    if (!NetworkUtil.a(getContext()))
    {
      ToastUtil.a().a(2131720447);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness = WSUserBusiness.a();
    }
    if (WSFeedUtils.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus))
    {
      WSFeedUtils.a(getContext(), new WSRecommendFollowHolder.1(this), null);
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
    WSRecommendFollowListener localWSRecommendFollowListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendfollowWSRecommendFollowListener;
    if (localWSRecommendFollowListener != null)
    {
      stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStSimpleMetaPerson;
      if (localstSimpleMetaPerson != null)
      {
        localWSRecommendFollowListener.a(localstSimpleMetaPerson);
        WSFollowBeaconReport.a("close", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, WSReportEvent.ActionId.a);
      }
    }
  }
  
  public stSimpleMetaPerson a()
  {
    return this.jdField_a_of_type_UserGrowthStSimpleMetaPerson;
  }
  
  public void a()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStSimpleMetaPerson;
    if (localstSimpleMetaPerson == null) {
      return;
    }
    if (WSFeedUtils.a(localstSimpleMetaPerson.followStatus))
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
    super.bindData(paramstSimpleMetaPerson);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson = paramstSimpleMetaPerson;
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    WSPicLoader.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView, paramstSimpleMetaPerson.avatar);
    boolean bool = WSFeedUtils.b(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    localTextView.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    WSFeedUtils.a(this.jdField_b_of_type_AndroidWidgetTextView, paramstSimpleMetaPerson.medal, bool);
    this.d.setText(WSFeedUtils.a(paramstSimpleMetaPerson.nick));
    a(this.e, this.f, paramstSimpleMetaPerson.nueric);
    this.g.setText(paramstSimpleMetaPerson.recommendReason);
    a();
  }
  
  public void b()
  {
    WSLog.b("WSRecommendFollowHolder", "[reportExposure]");
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStSimpleMetaPerson;
    if (localstSimpleMetaPerson == null)
    {
      WSLog.d("WSRecommendFollowHolder", "[reportExposure] mCurrentPerson is null");
      return;
    }
    a(localstSimpleMetaPerson);
  }
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onClick] view: ");
    localStringBuilder.append(paramView);
    WSLog.b("WSRecommendFollowHolder", localStringBuilder.toString());
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131369135: 
    case 2131369137: 
      a(0);
      return;
    case 2131369134: 
      a(1);
      return;
    case 2131369131: 
      f();
      return;
    case 2131369130: 
      a(2);
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSRecommendFollowHolder
 * JD-Core Version:    0.7.0.1
 */