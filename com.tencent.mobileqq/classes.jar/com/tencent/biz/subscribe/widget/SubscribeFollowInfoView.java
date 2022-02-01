package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.SquareImageView;

public class SubscribeFollowInfoView
  extends BaseWidgetView<CertifiedAccountMeta.StFeed>
{
  private SquareImageView c;
  private TextView d;
  private FollowTextView e;
  
  public SubscribeFollowInfoView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public SubscribeFollowInfoView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public SubscribeFollowInfoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    SubscribeFollowInfoView.1 local1 = new SubscribeFollowInfoView.1(this, paramStFeed);
    Object localObject = this.c;
    if (localObject != null)
    {
      ((SquareImageView)localObject).getLayoutParams().width = ScreenUtil.dip2px(27.0F);
      this.c.getLayoutParams().height = ScreenUtil.dip2px(27.0F);
      SubImageLoader.a(paramStFeed.poster.icon.get(), this.c);
      this.c.setOnClickListener(local1);
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((TextView)localObject).setText(paramStFeed.poster.nick.get());
      this.d.setOnClickListener(local1);
    }
    if (this.e != null)
    {
      if (SubscribeUtils.a(paramStFeed.poster.attr.get()))
      {
        this.e.setVisibility(8);
        return;
      }
      this.e.setVisibility(0);
      this.e.setFeedData(paramStFeed);
      this.e.setExtraTypeInfo(getExtraTypeInfo());
    }
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.c = ((SquareImageView)paramView.findViewById(2131436269));
    this.d = ((TextView)paramView.findViewById(2131448280));
    this.e = ((FollowTextView)paramView.findViewById(2131448469));
  }
  
  protected boolean a()
  {
    return (getData() != null) && (StringUtil.isEmpty(((CertifiedAccountMeta.StFeed)getData()).poster.nick.get()));
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        ((SquareImageView)localObject).getLayoutParams().width = ScreenUtil.dip2px(27.0F);
        this.c.getLayoutParams().height = ScreenUtil.dip2px(27.0F);
        SubImageLoader.a(paramStFeed.poster.icon.get(), this.c);
      }
      localObject = this.d;
      if (localObject != null) {
        ((TextView)localObject).setText(paramStFeed.poster.nick.get());
      }
    }
  }
  
  public TextView getFeedAuthorName()
  {
    return this.d;
  }
  
  public FollowTextView getFollowTextView()
  {
    return this.e;
  }
  
  protected int getLayoutId()
  {
    return 2131624364;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeFollowInfoView
 * JD-Core Version:    0.7.0.1
 */