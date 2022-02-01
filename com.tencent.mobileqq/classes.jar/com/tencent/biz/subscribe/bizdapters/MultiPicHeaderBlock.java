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
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private SubscribeFollowInfoView jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView;
  private RelativeMultiPicHeadItemView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView;
  
  public MultiPicHeaderBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a();
      if ((localStFeed.id.get().equals(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get())) && (localStFeed.title.get().equals(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get())) && (localStFeed.createTime.get() == this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.createTime.get()) && (localStFeed.images.size() == this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.images.size())) {
        return true;
      }
    }
    return false;
  }
  
  private void e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.setData(paramStFeed);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setData(paramStFeed);
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.getVisibility() == 4) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setVisibility(0);
      }
    }
    if ((a() instanceof SubscribeMultiPicFragment)) {
      ((SubscribeMultiPicFragment)a()).a(System.currentTimeMillis());
    }
  }
  
  protected View a()
  {
    if ((a() instanceof SubscribeMultiPicFragment)) {
      return ((SubscribeMultiPicFragment)a()).b();
    }
    return null;
  }
  
  public BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    if ((a() instanceof SubscribeMultiPicFragment))
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView = new SubscribeFollowInfoView(a());
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setExtraTypeInfo(a());
      paramMultiViewBlock = new LinearLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(29.0F));
      paramMultiViewBlock.leftMargin = ImmersiveUtils.dpToPx(9.0F);
      paramMultiViewBlock.rightMargin = ImmersiveUtils.dpToPx(15.0F);
      paramMultiViewBlock.gravity = 16;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setLayoutParams(paramMultiViewBlock);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView = ((SubscribeMultiPicFragment)a()).c();
      ((SubscribeMultiPicFragment)a()).a().addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView = new RelativeMultiPicHeadItemView(paramViewGroup.getContext());
    if (this.jdField_a_of_type_ComTencentBizSubscribeUtilsGestureToLaunchPageHelper != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeUtilsGestureToLaunchPageHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a());
    }
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView;
  }
  
  protected void a(long paramLong, String paramString)
  {
    super.a(paramLong, paramString);
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean)
  {
    e((CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get());
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.getVisibility() == 8)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if ((a() != null) && ((a().getLayoutManager() instanceof StaggeredGridLayoutManager))) {
      ((StaggeredGridLayoutManager)a().getLayoutManager()).scrollToPositionWithOffset(0, 0);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public void a(MultiViewBlock paramMultiViewBlock, int paramInt)
  {
    if ((paramMultiViewBlock.a() != null) && ("RELATIVE_ADAPTER_UNIQUE_KEY".equals(paramMultiViewBlock.a()))) {
      ((RelativeFeedsAdapter)paramMultiViewBlock).a(new MultiPicHeaderBlock.1(this));
    }
  }
  
  public void a(LoadInfo paramLoadInfo) {}
  
  public void d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {}
    do
    {
      return;
      VSReporter.a(paramStFeed.poster.id.get(), "auth_" + SubscribeShareHelper.a(a()), "clk_recom", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (SubscribeLaucher.b(paramStFeed.type.get()))
      {
        this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(paramStFeed);
        b("share_key_subscribe_feeds_update", new BlockMerger.ShareData(paramStFeed, true));
        return;
      }
      SubscribeLaucher.a(a(), paramStFeed);
    } while (a() == null);
    a().finish();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a().setAlpha(0.0F);
    }
  }
  
  public void l()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onTransAnimateInit disableLoading!");
    b();
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a().setAlpha(0.0F);
    }
  }
  
  public void m()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a().setAlpha(1.0F);
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a().setAlpha(1.0F);
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!d()) {
      e(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.MultiPicHeaderBlock
 * JD-Core Version:    0.7.0.1
 */