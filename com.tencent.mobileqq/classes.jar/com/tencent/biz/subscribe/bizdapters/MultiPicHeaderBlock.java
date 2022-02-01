package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.transition.inter.ITransAnimStateListener;
import com.tencent.biz.subscribe.utils.GestureToLaunchPageHelper;
import com.tencent.biz.subscribe.widget.SubscribeBannerView;
import com.tencent.biz.subscribe.widget.SubscribeFollowInfoView;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeMultiPicHeadItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class MultiPicHeaderBlock
  extends DetailBaseBlock
  implements ITransAnimStateListener
{
  private RelativeMultiPicHeadItemView g;
  private long k;
  private SubscribeFollowInfoView l;
  private View m;
  
  public MultiPicHeaderBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((RelativeMultiPicHeadItemView)localObject).setData(paramStFeed);
    }
    localObject = this.l;
    if (localObject != null)
    {
      ((SubscribeFollowInfoView)localObject).setData(paramStFeed);
      if (this.l.getVisibility() == 4) {
        this.l.setVisibility(0);
      }
    }
    if ((A() instanceof SubscribeMultiPicFragment)) {
      ((SubscribeMultiPicFragment)A()).a(System.currentTimeMillis());
    }
  }
  
  private boolean v()
  {
    if (this.g.getData() != null)
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)this.g.getData();
      if ((localStFeed.id.get().equals(this.c.id.get())) && (localStFeed.title.get().equals(this.c.title.get())) && (localStFeed.createTime.get() == this.c.createTime.get()) && (localStFeed.images.size() == this.c.images.size())) {
        return true;
      }
    }
    return false;
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    if ((A() instanceof SubscribeMultiPicFragment))
    {
      this.l = new SubscribeFollowInfoView(H());
      this.l.setExtraTypeInfo(K());
      paramMultiViewBlock = new LinearLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(29.0F));
      paramMultiViewBlock.leftMargin = ImmersiveUtils.dpToPx(9.0F);
      paramMultiViewBlock.rightMargin = ImmersiveUtils.dpToPx(15.0F);
      paramMultiViewBlock.gravity = 16;
      this.l.setLayoutParams(paramMultiViewBlock);
      this.l.setVisibility(4);
      this.m = ((SubscribeMultiPicFragment)A()).j();
      ((SubscribeMultiPicFragment)A()).k().addView(this.l);
    }
    this.g = new RelativeMultiPicHeadItemView(paramViewGroup.getContext());
    if (this.e != null) {
      this.e.a(this.g.getBannerView());
    }
    return this.g;
  }
  
  protected void a(long paramLong, String paramString)
  {
    super.a(paramLong, paramString);
    paramString = this.l;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
    paramString = this.m;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean)
  {
    e((CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get());
    paramStGetFeedDetailRsp = this.l;
    if ((paramStGetFeedDetailRsp != null) && (paramStGetFeedDetailRsp.getVisibility() == 8)) {
      this.l.setVisibility(0);
    }
    paramStGetFeedDetailRsp = this.m;
    if ((paramStGetFeedDetailRsp != null) && (paramStGetFeedDetailRsp.getVisibility() == 8)) {
      this.m.setVisibility(0);
    }
    if ((J() != null) && ((J().getLayoutManager() instanceof StaggeredGridLayoutManager))) {
      ((StaggeredGridLayoutManager)J().getLayoutManager()).scrollToPositionWithOffset(0, 0);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public void a(MultiViewBlock paramMultiViewBlock, int paramInt)
  {
    if ((paramMultiViewBlock.bA_() != null) && ("RELATIVE_ADAPTER_UNIQUE_KEY".equals(paramMultiViewBlock.bA_()))) {
      ((RelativeFeedsAdapter)paramMultiViewBlock).a(new MultiPicHeaderBlock.1(this));
    }
  }
  
  public void a(LoadInfo paramLoadInfo) {}
  
  public void d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (System.currentTimeMillis() - this.k < 500L) {
      return;
    }
    String str = paramStFeed.poster.id.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("auth_");
    localStringBuilder.append(SubscribeShareHelper.a(K()));
    VSReporter.a(str, localStringBuilder.toString(), "clk_recom", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
    this.k = System.currentTimeMillis();
    if (SubscribeLaucher.b(paramStFeed.type.get()))
    {
      this.c = paramStFeed;
      this.b.a(paramStFeed);
      b("share_key_subscribe_feeds_update", new BlockMerger.ShareData(paramStFeed, true));
      return;
    }
    SubscribeLaucher.a(G(), paramStFeed);
    if (G() != null) {
      G().finish();
    }
  }
  
  protected View h()
  {
    if ((A() instanceof SubscribeMultiPicFragment)) {
      return ((SubscribeMultiPicFragment)A()).i();
    }
    return null;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!v()) {
      e(this.c);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    paramRecyclerView = this.g;
    if (paramRecyclerView != null) {
      paramRecyclerView.a();
    }
  }
  
  public void r()
  {
    RelativeMultiPicHeadItemView localRelativeMultiPicHeadItemView = this.g;
    if ((localRelativeMultiPicHeadItemView != null) && (localRelativeMultiPicHeadItemView.getBannerView() != null)) {
      this.g.getBannerView().setAlpha(0.0F);
    }
  }
  
  public void s()
  {
    QLog.d(a, 1, "onTransAnimateInit disableLoading!");
    e();
    RelativeMultiPicHeadItemView localRelativeMultiPicHeadItemView = this.g;
    if ((localRelativeMultiPicHeadItemView != null) && (localRelativeMultiPicHeadItemView.getBannerView() != null)) {
      this.g.getBannerView().setAlpha(0.0F);
    }
  }
  
  public void t()
  {
    RelativeMultiPicHeadItemView localRelativeMultiPicHeadItemView = this.g;
    if ((localRelativeMultiPicHeadItemView != null) && (localRelativeMultiPicHeadItemView.getBannerView() != null)) {
      this.g.getBannerView().setAlpha(1.0F);
    }
  }
  
  public void u()
  {
    RelativeMultiPicHeadItemView localRelativeMultiPicHeadItemView = this.g;
    if ((localRelativeMultiPicHeadItemView != null) && (localRelativeMultiPicHeadItemView.getBannerView() != null)) {
      this.g.getBannerView().setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.MultiPicHeaderBlock
 * JD-Core Version:    0.7.0.1
 */