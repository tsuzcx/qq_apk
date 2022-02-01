package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimationManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.open.base.ToastUtil;

public class WSVerticalItemBottomAvatarController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private static final int g = ScreenUtil.dip2px(2.5F);
  private static final int h = ScreenUtil.dip2px(150.0F);
  private static final int i = ScreenUtil.dip2px(1.0F);
  private static final int j = Color.parseColor("#5CFFFFFF");
  private static final int k = ScreenUtil.dip2px(60.0F);
  private WSVerticalPageFragment l;
  private WSRoundedImageView m;
  private DiniFlyAnimationView n;
  private TextView o;
  private TextView p;
  private stSimpleMetaFeed q;
  
  public WSVerticalItemBottomAvatarController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.l = paramWSVerticalVideoHolder.d;
    }
  }
  
  private void c(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null)
    {
      this.m.setVisibility(8);
      return;
    }
    if (WSFeedUtils.a(paramstSimpleMetaPerson))
    {
      b(paramstSimpleMetaPerson);
      this.n.setVisibility(0);
      this.m.setVisibility(8);
      return;
    }
    d(paramstSimpleMetaPerson);
  }
  
  private void d(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    this.n.setVisibility(8);
    this.m.setVisibility(0);
    WSPicLoader.a().a(this.a, this.m, paramstSimpleMetaPerson.avatar);
  }
  
  private void e(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null)
    {
      this.o.setVisibility(8);
      return;
    }
    int i1 = l();
    int i2 = WeishiUIUtil.c();
    this.o.setVisibility(0);
    this.o.setMaxWidth(i2 - i1 - h);
    this.o.setText(paramstSimpleMetaPerson.nick);
    i1 = WSFeedUtils.d(paramstSimpleMetaPerson.medal);
    this.o.setCompoundDrawablePadding(i);
    if (i1 != -1)
    {
      this.o.setCompoundDrawablesWithIntrinsicBounds(null, null, e().getDrawable(i1), null);
      return;
    }
    this.o.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private int l()
  {
    if (this.p.getVisibility() == 0)
    {
      int i1 = this.p.getWidth();
      if (i1 != 0) {
        return i1;
      }
      return k;
    }
    return 0;
  }
  
  private void m()
  {
    ((WSVerticalPageContract.Presenter)this.l.aO_()).a("profile", this.l, this.q);
  }
  
  private void n()
  {
    ((WSVerticalPageContract.Presenter)this.l.aO_()).a("nickname", this.l, this.q);
  }
  
  private void o()
  {
    if (!NetworkUtil.a(d()))
    {
      ToastUtil.a().a(2131918123);
      return;
    }
    if (this.l != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = this.q;
      if (localstSimpleMetaFeed != null)
      {
        if (localstSimpleMetaFeed.poster == null) {
          return;
        }
        this.p.setVisibility(8);
        WSUserBusiness.a().a(this.q.poster.id, 1);
        WSVerticalBeaconReport.d(this.l.k(), this.l.l(), this.q, ((WSVerticalPageContract.Presenter)this.l.aO_()).n());
      }
    }
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if (localWSVerticalItemData == null) {
      return;
    }
    if ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed)) {
      this.q = localWSVerticalItemData.b();
    }
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    int i1 = 8;
    if (paramstSimpleMetaPerson == null)
    {
      this.p.setVisibility(8);
      return;
    }
    if (TextUtils.equals(WeishiUtils.n(), paramstSimpleMetaPerson.id))
    {
      this.p.setVisibility(8);
      return;
    }
    TextView localTextView = this.p;
    if (!WSFeedUtils.b(paramstSimpleMetaPerson.followStatus)) {
      i1 = 0;
    }
    localTextView.setVisibility(i1);
  }
  
  @UiThread
  protected void b()
  {
    Object localObject = (WSVerticalItemData)c();
    if (localObject == null) {
      return;
    }
    if ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed))
    {
      localObject = ((WSVerticalItemData)localObject).b().poster;
      a((stSimpleMetaPerson)localObject);
      e((stSimpleMetaPerson)localObject);
      c((stSimpleMetaPerson)localObject);
    }
  }
  
  public void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (WSFeedUtils.a(this.q.poster))
    {
      WSLiveAnimationManager.a().a(this.n, paramstSimpleMetaPerson.avatar, new WSVerticalItemBottomAvatarController.1(this, paramstSimpleMetaPerson));
      return;
    }
    WSLiveAnimationManager.a().a(this.n);
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626076;
  }
  
  protected void j()
  {
    this.m = ((WSRoundedImageView)c(2131449397));
    this.n = ((DiniFlyAnimationView)c(2131449398));
    this.n.setOnClickListener(this);
    this.m.setStrokeWidth(g);
    this.m.setStrokeColor(j);
    this.m.setOnClickListener(this);
    this.o = ((TextView)c(2131449403));
    this.o.setOnClickListener(this);
    this.p = ((TextView)c(2131449402));
    this.p.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131449399: 
    case 2131449400: 
    case 2131449401: 
    default: 
      return;
    case 2131449403: 
      n();
      return;
    case 2131449402: 
      o();
      return;
    }
    m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomAvatarController
 * JD-Core Version:    0.7.0.1
 */