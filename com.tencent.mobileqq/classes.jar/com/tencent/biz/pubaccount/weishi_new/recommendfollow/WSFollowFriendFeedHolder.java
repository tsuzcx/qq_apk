package com.tencent.biz.pubaccount.weishi_new.recommendfollow;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.biz.pubaccount.weishi_new.follow.data.WSFriendItemData;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimationManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.trooponline.widget.RoundTextView;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;

public class WSFollowFriendFeedHolder
  extends BaseViewHolder<WSFriendItemData>
{
  private static final int a = WSFeedUtils.a(5.0F);
  private static final int b = WSFeedUtils.a(2.0F);
  private WSFollowFriendFeedAdapter c;
  private RoundCornerImageView d;
  private RoundImageView e;
  private TextView f;
  private RoundTextView g;
  private DiniFlyAnimationView h;
  private FrameLayout i;
  private DiniFlyAnimationView j;
  private stSimpleMetaFeed k;
  private WSFriendItemData l;
  private int m;
  
  private WSFollowFriendFeedHolder(ViewGroup paramViewGroup, WSFollowFriendFeedAdapter paramWSFollowFriendFeedAdapter)
  {
    super(paramViewGroup, 2131626459);
    this.c = paramWSFollowFriendFeedAdapter;
    e();
  }
  
  public static WSFollowFriendFeedHolder a(ViewGroup paramViewGroup, WSFollowFriendFeedAdapter paramWSFollowFriendFeedAdapter)
  {
    return new WSFollowFriendFeedHolder(paramViewGroup, paramWSFollowFriendFeedAdapter);
  }
  
  private void a(int paramInt)
  {
    if (paramInt <= 1)
    {
      this.g.setVisibility(8);
      return;
    }
    this.g.setVisibility(0);
    this.g.setText(String.valueOf(paramInt));
  }
  
  private void e()
  {
    this.d = ((RoundCornerImageView)getView(2131450277));
    this.e = ((RoundImageView)getView(2131450279));
    this.f = ((TextView)getView(2131450302));
    this.g = ((RoundTextView)getView(2131450283));
    this.i = ((FrameLayout)getView(2131450258));
    this.j = ((DiniFlyAnimationView)getView(2131450265));
    this.h = ((DiniFlyAnimationView)getView(2131450264));
    this.h.setOnClickListener(new WSFollowFriendFeedHolder.1(this));
    this.j.setOnClickListener(new WSFollowFriendFeedHolder.2(this));
    this.h.setAnimation("wsfollow/followbtn.json");
    this.d.setCorner(a);
    this.e.setBorderInnerPadding(5);
    this.e.setBorderWidth(b);
    this.e.setBorderColor(Color.parseColor("#D9D9D9"));
    this.g.setRoundBgColor(getContext().getResources().getColor(2131168464));
  }
  
  private void f()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = c();
    WSFollowFriendFeedAdapter localWSFollowFriendFeedAdapter = this.c;
    if ((localWSFollowFriendFeedAdapter != null) && (localstSimpleMetaPerson != null))
    {
      if (this.l == null) {
        return;
      }
      WSFeedUtils.a(localWSFollowFriendFeedAdapter.a(), localstSimpleMetaPerson.avatarSchema, 0, localstSimpleMetaPerson);
      WSFollowBeaconReport.b(this.m + 1, this.k, this.l.c(), this.l.d());
    }
  }
  
  private void g()
  {
    Object localObject = this.k;
    if ((localObject != null) && (((stSimpleMetaFeed)localObject).poster != null) && (!this.h.isAnimating()))
    {
      localObject = this.k.poster;
      WSUserBusiness.a().a(((stSimpleMetaPerson)localObject).id, 1);
      return;
    }
    WSLog.b("WSFollowFriendFeedHolder", "[showFollowAction] is null");
  }
  
  private void h()
  {
    this.h.addAnimatorListener(new WSFollowFriendFeedHolder.4(this));
    this.h.playAnimation();
  }
  
  public void a()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = c();
    if (WSFeedUtils.a(localstSimpleMetaPerson)) {
      WSLiveAnimationManager.a().a(this.j, localstSimpleMetaPerson.avatar, new WSFollowFriendFeedHolder.3(this));
    }
  }
  
  public void a(WSFriendItemData paramWSFriendItemData, int paramInt)
  {
    if (paramWSFriendItemData != null)
    {
      if (((ArrayList)paramWSFriendItemData.b()).size() < 1) {
        return;
      }
      this.l = paramWSFriendItemData;
      this.k = ((stSimpleMetaFeed)((ArrayList)paramWSFriendItemData.b()).get(0));
      if (this.k == null) {
        return;
      }
      this.m = paramInt;
      a(paramWSFriendItemData.d());
      a(paramWSFriendItemData.c());
      paramWSFriendItemData = this.k.poster;
      if (paramWSFriendItemData != null)
      {
        if (this.h.isAnimating()) {
          this.h.cancelAnimation();
        }
        if (WSFeedUtils.b(paramWSFriendItemData.followStatus))
        {
          this.h.setVisibility(8);
        }
        else
        {
          this.h.setFrame(1);
          this.h.setVisibility(0);
        }
        WSPicLoader.a().a(this.d, this.k, true, "focus", this.m);
        WSPicLoader.a().a(getContext(), this.e, paramWSFriendItemData.avatar);
        this.f.setText(paramWSFriendItemData.nick);
      }
      if (WSFeedUtils.a(paramWSFriendItemData))
      {
        this.j.setVisibility(0);
        this.i.setVisibility(8);
        return;
      }
      this.j.setVisibility(8);
      this.i.setVisibility(0);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "#67FFFFFF";
    } else {
      str = "#FF7A46FF";
    }
    int n = Color.parseColor(str);
    this.e.setBorderColor(n);
  }
  
  public void b()
  {
    WSFriendItemData localWSFriendItemData = this.l;
    if (localWSFriendItemData == null)
    {
      WSLog.b("WSFollowFriendFeedHolder", "[reportExposure] mCurrentItemData is null");
      return;
    }
    WSFollowBeaconReport.a(this.m + 1, this.k, localWSFriendItemData.c(), this.l.d());
  }
  
  public stSimpleMetaPerson c()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = this.k;
    if (localstSimpleMetaFeed != null) {
      return localstSimpleMetaFeed.poster;
    }
    return null;
  }
  
  public void d()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = this.k;
    if (localstSimpleMetaFeed != null)
    {
      if (localstSimpleMetaFeed.poster == null) {
        return;
      }
      if (WSFeedUtils.b(this.k.poster.followStatus))
      {
        this.h.setVisibility(8);
        return;
      }
      this.h.setVisibility(0);
    }
  }
  
  public void onViewDetachedFromWindow()
  {
    super.onViewDetachedFromWindow();
    WSLiveAnimationManager.a().a(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedHolder
 * JD-Core Version:    0.7.0.1
 */