package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWSItemView;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedCoverController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerMaskController;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerTagController;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public abstract class AbsWSGridItemView
  extends AbsWSItemView<stSimpleMetaFeed>
{
  private static final int e = ScreenUtil.dip2px(10.0F);
  protected stSimpleMetaFeed d;
  private View f;
  private View g;
  private RelativeLayout h;
  private final WSRecommendAdapter i;
  
  public AbsWSGridItemView(Context paramContext, View paramView, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramContext, paramView);
    this.i = paramWSRecommendAdapter;
    j();
  }
  
  private void j()
  {
    a(2131435986, new WSGridFeedCoverController(this.b, this.a, g(), this.i));
    if (i()) {
      a(2131436002, new WSGridFeedInnerTagController(this.b));
    }
    a(2131435992, new WSGridFeedInnerMaskController(this.b));
  }
  
  private void k()
  {
    View localView = this.f;
    int j;
    if (e()) {
      j = 0;
    } else {
      j = 8;
    }
    localView.setVisibility(j);
    this.f.setBackgroundResource(h());
  }
  
  private void l()
  {
    View localView = this.g;
    int j;
    if (f()) {
      j = 0;
    } else {
      j = 8;
    }
    localView.setVisibility(j);
  }
  
  private void m()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    int j;
    if (e())
    {
      localLayoutParams.addRule(2, 2131435987);
      j = e;
      localLayoutParams.setMargins(j, 0, j, 0);
    }
    else
    {
      localLayoutParams.addRule(8, 2131436003);
      j = e;
      localLayoutParams.setMargins(j, 0, j, j);
    }
    this.h.setLayoutParams(localLayoutParams);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.d = paramstSimpleMetaFeed;
    k();
    l();
    m();
    super.a(paramstSimpleMetaFeed);
  }
  
  public void b()
  {
    this.f = this.a.findViewById(2131435987);
    this.g = this.a.findViewById(2131435988);
    this.h = ((RelativeLayout)this.a.findViewById(2131436004));
  }
  
  public void c() {}
  
  public void d() {}
  
  public void d(int paramInt) {}
  
  protected abstract boolean e();
  
  protected abstract boolean f();
  
  protected abstract int g();
  
  @DrawableRes
  protected int h()
  {
    return 2130842810;
  }
  
  protected boolean i()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.AbsWSGridItemView
 * JD-Core Version:    0.7.0.1
 */