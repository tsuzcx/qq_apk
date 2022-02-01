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
  private WSRecommendFollowListener a;
  private stSimpleMetaPerson b;
  private int c;
  private RelativeLayout d;
  private RelativeLayout e;
  private WSRoundedImageView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private WSUserBusiness p;
  private LinearLayout q;
  
  public WSRecommendFollowHolder(ViewGroup paramViewGroup, WSRecommendFollowListener paramWSRecommendFollowListener)
  {
    super(paramViewGroup, 2131626460);
    this.a = paramWSRecommendFollowListener;
    e();
    d();
  }
  
  public static WSRecommendFollowHolder a(ViewGroup paramViewGroup, WSRecommendFollowListener paramWSRecommendFollowListener)
  {
    return new WSRecommendFollowHolder(paramViewGroup, paramWSRecommendFollowListener);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      WSFollowBeaconReport.a("nickname", this.c + 1, this.b.id, WSReportEvent.ActionId.a);
    } else if (paramInt == 2) {
      WSFollowBeaconReport.a("profile", this.c + 1, this.b.id, WSReportEvent.ActionId.a);
    }
    WSRecommendFollowListener localWSRecommendFollowListener = this.a;
    if (localWSRecommendFollowListener != null) {
      localWSRecommendFollowListener.b(this.b);
    }
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    WSFollowBeaconReport.a(this.c + 1, paramstSimpleMetaPerson);
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
  
  private void d()
  {
    this.i.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.m.setOnClickListener(this);
  }
  
  private void e()
  {
    this.d = ((RelativeLayout)getView(2131436109));
    this.e = ((RelativeLayout)getView(2131436100));
    this.f = ((WSRoundedImageView)getView(2131436099));
    this.g = ((TextView)getView(2131436102));
    this.h = ((TextView)getView(2131436103));
    this.i = ((TextView)getView(2131436101));
    this.j = ((TextView)getView(2131436104));
    this.q = ((LinearLayout)getView(2131436105));
    this.k = ((TextView)getView(2131436108));
    this.l = ((TextView)getView(2131436106));
    this.m = ((TextView)getView(2131436107));
    this.n = ((TextView)getView(2131436021));
    this.o = ((TextView)getView(2131436020));
  }
  
  private void f()
  {
    if (!NetworkUtil.a(getContext()))
    {
      ToastUtil.a().a(2131918123);
      return;
    }
    if (this.p == null) {
      this.p = WSUserBusiness.a();
    }
    if (WSFeedUtils.b(this.b.followStatus))
    {
      WSFeedUtils.a(getContext(), new WSRecommendFollowHolder.1(this), null);
      return;
    }
    this.p.a(this.b.id, 1);
    this.b.followStatus = 1;
    this.n.setVisibility(8);
    this.o.setVisibility(0);
    WSFollowBeaconReport.a("follow", this.c + 1, this.b.id, WSReportEvent.ActionId.q);
  }
  
  private void g()
  {
    WSRecommendFollowListener localWSRecommendFollowListener = this.a;
    if (localWSRecommendFollowListener != null)
    {
      stSimpleMetaPerson localstSimpleMetaPerson = this.b;
      if (localstSimpleMetaPerson != null)
      {
        localWSRecommendFollowListener.a(localstSimpleMetaPerson);
        WSFollowBeaconReport.a("close", this.c + 1, this.b.id, WSReportEvent.ActionId.a);
      }
    }
  }
  
  public void a()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = this.b;
    if (localstSimpleMetaPerson == null) {
      return;
    }
    if (WSFeedUtils.b(localstSimpleMetaPerson.followStatus))
    {
      this.n.setVisibility(8);
      this.o.setVisibility(0);
      return;
    }
    this.n.setVisibility(0);
    this.o.setVisibility(8);
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson, int paramInt)
  {
    super.bindData(paramstSimpleMetaPerson);
    this.b = paramstSimpleMetaPerson;
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    this.c = paramInt;
    WSPicLoader.a().a(getContext(), this.f, paramstSimpleMetaPerson.avatar);
    boolean bool = WSFeedUtils.c(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.g;
    if (bool) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    localTextView.setVisibility(paramInt);
    this.h.setVisibility(8);
    WSFeedUtils.a(this.h, paramstSimpleMetaPerson.medal, bool);
    this.j.setText(WSFeedUtils.a(paramstSimpleMetaPerson.nick));
    a(this.k, this.l, paramstSimpleMetaPerson.nueric);
    this.m.setText(paramstSimpleMetaPerson.recommendReason);
    a();
  }
  
  public stSimpleMetaPerson b()
  {
    return this.b;
  }
  
  public void c()
  {
    WSLog.b("WSRecommendFollowHolder", "[reportExposure]");
    stSimpleMetaPerson localstSimpleMetaPerson = this.b;
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
    case 2131436105: 
    case 2131436107: 
      a(0);
      return;
    case 2131436104: 
      a(1);
      return;
    case 2131436101: 
      g();
      return;
    case 2131436100: 
      a(2);
      return;
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSRecommendFollowHolder
 * JD-Core Version:    0.7.0.1
 */