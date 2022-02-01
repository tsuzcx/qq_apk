package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFollowRcmd;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BlankRecommendItemView
  extends BaseWidgetView<CertifiedAccountMeta.StFollowRcmd>
  implements View.OnClickListener
{
  private int c;
  private SquareImageView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private FollowTextView h;
  private View i;
  private boolean j;
  private ArrayList<BlankRecommendItemView.InnerRecommendItemView> k;
  
  public BlankRecommendItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private String a(int paramInt)
  {
    DecimalFormat localDecimalFormat;
    StringBuilder localStringBuilder;
    double d1;
    if (paramInt >= 10000)
    {
      localDecimalFormat = new DecimalFormat(".#");
      localStringBuilder = new StringBuilder();
      d1 = paramInt;
      Double.isNaN(d1);
      localStringBuilder.append(localDecimalFormat.format(d1 / 10000.0D));
      localStringBuilder.append("W");
      return localStringBuilder.toString();
    }
    if (paramInt >= 1000)
    {
      localDecimalFormat = new DecimalFormat(".#");
      localStringBuilder = new StringBuilder();
      d1 = paramInt;
      Double.isNaN(d1);
      localStringBuilder.append(localDecimalFormat.format(d1 / 1000.0D));
      localStringBuilder.append("K");
      return localStringBuilder.toString();
    }
    return String.valueOf(paramInt);
  }
  
  @RequiresApi(api=8)
  protected void a(CertifiedAccountMeta.StFollowRcmd paramStFollowRcmd)
  {
    if (paramStFollowRcmd != null)
    {
      if (!paramStFollowRcmd.user.has()) {
        return;
      }
      CertifiedAccountMeta.StUser localStUser = (CertifiedAccountMeta.StUser)paramStFollowRcmd.user.get();
      this.d.getLayoutParams().width = ScreenUtil.dip2px(36.0F);
      this.d.getLayoutParams().height = ScreenUtil.dip2px(36.0F);
      SubImageLoader.a(localStUser.icon.get(), this.d);
      this.e.setText(localStUser.nick.get());
      Object localObject1 = this.f;
      ((TextView)localObject1).setText(String.format("%s%s", new Object[] { ((TextView)localObject1).getContext().getString(2131916910), a(paramStFollowRcmd.fansCount.get()) }));
      Object localObject2 = paramStFollowRcmd.reason.get();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localStUser.desc.get();
      }
      this.g.setText((CharSequence)localObject1);
      this.h.setUserData(localStUser);
      this.h.setExtraTypeInfo(getExtraTypeInfo());
      this.h.setFollowStateChangeListener(new BlankRecommendItemView.1(this, localStUser));
      paramStFollowRcmd = paramStFollowRcmd.feedList.get();
      int m = 0;
      while (m < 3)
      {
        if (ArrayUtils.isOutOfArrayIndex(m, paramStFollowRcmd)) {
          ((BlankRecommendItemView.InnerRecommendItemView)this.k.get(m)).a(null);
        } else {
          ((BlankRecommendItemView.InnerRecommendItemView)this.k.get(m)).a((CertifiedAccountMeta.StFeed)paramStFollowRcmd.get(m));
        }
        m += 1;
      }
      paramStFollowRcmd = localStUser.id.get();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("");
      VSReporter.b(paramStFollowRcmd, "auth_follow", "blank_content_exp", 0, 0, new String[] { "", ((StringBuilder)localObject2).toString(), localStUser.nick.get(), localObject1 });
    }
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.d = ((SquareImageView)findViewById(2131436269));
    this.e = ((TextView)findViewById(2131448280));
    this.f = ((TextView)findViewById(2131448279));
    this.g = ((TextView)findViewById(2131448281));
    this.i = findViewById(2131432025);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h = ((FollowTextView)findViewById(2131448469));
    if (this.k == null) {
      this.k = new ArrayList();
    }
    this.k.add(new BlankRecommendItemView.InnerRecommendItemView(this, findViewById(2131444948), 1));
    this.k.add(new BlankRecommendItemView.InnerRecommendItemView(this, findViewById(2131444949), 2));
    this.k.add(new BlankRecommendItemView.InnerRecommendItemView(this, findViewById(2131444950), 3));
  }
  
  protected View f()
  {
    return this;
  }
  
  protected int getLayoutId()
  {
    return 2131624353;
  }
  
  protected View.OnClickListener getOnClickLister()
  {
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if ((m == 2131436269) || (m == 2131448280))
    {
      CertifiedAccountMeta.StFollowRcmd localStFollowRcmd = (CertifiedAccountMeta.StFollowRcmd)getData();
      SubscribeLaucher.a(getContext(), (CertifiedAccountMeta.StUser)localStFollowRcmd.user.get());
      if (2131436269 == paramView.getId()) {
        VSReporter.b(localStFollowRcmd.user.id.get(), "auth_follow", "blank_head_clk", 0, 0, new String[] { "", "", localStFollowRcmd.user.nick.get() });
      } else if (2131448280 == paramView.getId()) {
        VSReporter.b(localStFollowRcmd.user.id.get(), "auth_follow", "blank_name_clk", 0, 0, new String[] { "", "", localStFollowRcmd.user.nick.get() });
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.j = paramBoolean;
    if (this.j)
    {
      this.d.setFilterColor(1711276032);
      this.e.setTextColor(-5723992);
      this.f.setTextColor(-10132123);
      this.g.setTextColor(-10132123);
      this.h.setIsInNightMode(this.j);
      this.i.setBackgroundColor(-9211021);
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext())
      {
        BlankRecommendItemView.InnerRecommendItemView localInnerRecommendItemView = (BlankRecommendItemView.InnerRecommendItemView)localIterator.next();
        if (localInnerRecommendItemView != null) {
          localInnerRecommendItemView.a();
        }
      }
    }
  }
  
  public void setPos(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView
 * JD-Core Version:    0.7.0.1
 */