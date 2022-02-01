package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.player.IWSPlayerUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils.PlayerLayoutParams;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public abstract class WSVerticalVideoHolder
  extends WSVerticalBaseHolder<WSVerticalItemData>
{
  private static final int a = ScreenUtil.dip2px(46.0F);
  public WSPlayerParam f;
  public IWSPlayerUIDelegate g;
  
  public WSVerticalVideoHolder(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt1, paramInt2, paramWSVerticalPageFragment);
  }
  
  private void b(int paramInt)
  {
    View localView = l();
    if (localView == null) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2))
    {
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(0);
  }
  
  private int c(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSPlayerUtils.PlayerLayoutParams localPlayerLayoutParams = new WSPlayerUtils.PlayerLayoutParams(b(), k(), paramstSimpleMetaFeed.video.width, paramstSimpleMetaFeed.video.height, i(), f());
    int i = a(paramstSimpleMetaFeed);
    paramstSimpleMetaFeed = new StringBuilder();
    paramstSimpleMetaFeed.append("[WSVerticalVideoHolder.java][calculatePlayerLayoutRatio] videoScaleType:");
    paramstSimpleMetaFeed.append(i);
    paramstSimpleMetaFeed.append(", ");
    paramstSimpleMetaFeed.append(localPlayerLayoutParams.toString());
    WSLog.e("WSVerticalVideoHolder", paramstSimpleMetaFeed.toString());
    if (i != -1)
    {
      if (i != 1)
      {
        if (i != 2) {
          return WSPlayerUtils.b(localPlayerLayoutParams);
        }
        return WSPlayerUtils.a(this.d.getBaseActivity(), localPlayerLayoutParams, new WSVerticalVideoHolder.1(this));
      }
      return WSPlayerUtils.b(localPlayerLayoutParams);
    }
    return WSPlayerUtils.a(localPlayerLayoutParams);
  }
  
  private View k()
  {
    if ((this.c instanceof AbsWSVideoItemView)) {
      return ((AbsWSVideoItemView)this.c).j();
    }
    return null;
  }
  
  private View l()
  {
    if ((this.c instanceof AbsWSVideoItemView)) {
      return ((AbsWSVideoItemView)this.c).k();
    }
    return null;
  }
  
  public int a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return WSExpABTestManager.a().l();
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.bindData(paramWSVerticalItemData);
    if (this.c != null) {
      this.c.a(paramWSVerticalItemData);
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public int b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return c(paramstSimpleMetaFeed);
  }
  
  public abstract void c();
  
  public void c(int paramInt)
  {
    if ((this.d != null) && (this.d.e() != null))
    {
      this.d.e().f(a());
      this.d.e().e(a());
    }
    if (this.d != null)
    {
      this.d.e(g());
      this.d.f(h());
      this.d.d(paramInt + 1);
    }
    if (this.c != null) {
      this.c.b(paramInt);
    }
  }
  
  public abstract void d();
  
  public void d(int paramInt)
  {
    if (this.c != null) {
      this.c.c(paramInt);
    }
  }
  
  public abstract void e();
  
  public int f()
  {
    return ((WSVerticalPageContract.Presenter)this.d.aO_()).s();
  }
  
  protected boolean g()
  {
    return true;
  }
  
  protected boolean h()
  {
    return true;
  }
  
  public int i()
  {
    return ((WSVerticalPageContract.Presenter)this.d.aO_()).c();
  }
  
  public void j()
  {
    if (this.c != null) {
      this.c.d();
    }
  }
  
  public void onViewDetachedFromWindow()
  {
    super.onViewDetachedFromWindow();
    if (this.c != null) {
      this.c.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder
 * JD-Core Version:    0.7.0.1
 */