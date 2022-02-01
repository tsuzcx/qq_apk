package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;

public class WSGridFeedCoverController
  extends AbsWsUIGroup<stSimpleMetaFeed>
{
  private static final int g = WSFeedUtils.a(5.0F);
  private RoundCornerImageView h;
  private final View i;
  private View j;
  private WSRecommendAdapter k;
  private final int l;
  private stSimpleMetaFeed m;
  
  public WSGridFeedCoverController(Context paramContext, View paramView, int paramInt, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramContext);
    this.l = paramInt;
    this.i = paramView;
    this.k = paramWSRecommendAdapter;
  }
  
  private void a(Pair<Integer, Integer> paramPair)
  {
    if ((this.k != null) && (!TextUtils.isEmpty(this.m.id)) && (TextUtils.equals(this.k.m, this.m.id)) && (this.k.n))
    {
      if (this.j == null) {
        this.j = ((ViewStub)this.i.findViewById(2131436001)).inflate();
      }
      Object localObject = this.j;
      if (localObject != null)
      {
        localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = ((Integer)paramPair.first).intValue();
        ((FrameLayout.LayoutParams)localObject).height = ((Integer)paramPair.second).intValue();
        this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.j.setVisibility(0);
      }
      return;
    }
    paramPair = this.j;
    if (paramPair != null) {
      paramPair.setVisibility(8);
    }
  }
  
  private void l()
  {
    this.h.setCorner(g, this.l);
    m();
  }
  
  private void m()
  {
    Object localObject = this.j;
    if (localObject == null) {
      return;
    }
    localObject = (TextView)((View)localObject).findViewById(2131448453);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    int n;
    if (this.l == 1)
    {
      n = g;
      localGradientDrawable.setCornerRadii(new float[] { n, n, n, n, 0.0F, 0.0F, 0.0F, 0.0F });
    }
    else
    {
      n = g;
      localGradientDrawable.setCornerRadii(new float[] { n, n, n, n, n, n, n, n });
    }
    localGradientDrawable.setColor(e().getColor(2131165566));
    ((TextView)localObject).setBackgroundDrawable(localGradientDrawable);
  }
  
  private void n()
  {
    Object localObject = this.m.waterFallCardStyle;
    boolean bool;
    if ((localObject != null) && (((stWaterFallCardStyle)localObject).isFullSpan)) {
      bool = true;
    } else {
      bool = false;
    }
    ((StaggeredGridLayoutManager.LayoutParams)this.i.getLayoutParams()).setFullSpan(bool);
    localObject = (FrameLayout.LayoutParams)this.h.getLayoutParams();
    Pair localPair = WeishiUIUtil.a(this.m);
    ((FrameLayout.LayoutParams)localObject).width = ((Integer)localPair.first).intValue();
    ((FrameLayout.LayoutParams)localObject).height = ((Integer)localPair.second).intValue();
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.k;
    if ((localObject != null) && (!TextUtils.isEmpty(((WSRecommendAdapter)localObject).l)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("feeds_");
      ((StringBuilder)localObject).append(this.k.l);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "feeds";
    }
    WSPicLoader.a().a(this.h, this.m, o(), (String)localObject, true, h());
    a(localPair);
  }
  
  private Drawable o()
  {
    String str = WeishiUtils.b(this.m, true);
    if (!TextUtils.isEmpty(str))
    {
      ColorDrawable localColorDrawable = new ColorDrawable();
      if (!WeishiUIUtil.a(str)) {
        str = "#D9D9D9";
      }
      localColorDrawable.setColor(Color.parseColor(str));
      return localColorDrawable;
    }
    return WSFeedUtils.f(2131166336);
  }
  
  protected void a()
  {
    this.m = ((stSimpleMetaFeed)c());
  }
  
  protected void b()
  {
    n();
    l();
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626469;
  }
  
  protected void j()
  {
    this.h = ((RoundCornerImageView)c(2131436090));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedCoverController
 * JD-Core Version:    0.7.0.1
 */