package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.subscribe.bizdapters.CommodityAdapter;
import com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter;
import com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareDataChangeListener;
import com.tencent.biz.subscribe.transition.TransitionAnimHelper;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.base.video.player.videourl.api.IThirdVideoManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

public class SubscribeVideoDetailFragment
  extends SubscribeBaseFragment
  implements BlockMerger.ShareDataChangeListener
{
  private static int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RelativeFeedsAdapter jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter;
  private VideoHeaderBlock jdField_a_of_type_ComTencentBizSubscribeBizdaptersVideoHeaderBlock;
  protected BlockContainer a;
  private VideoPlayerView jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
  private ImageView b;
  private boolean c;
  
  protected View a()
  {
    return this.b;
  }
  
  protected TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    VideoHeaderBlock localVideoHeaderBlock = this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersVideoHeaderBlock;
    if (localVideoHeaderBlock != null) {
      localVideoHeaderBlock.a(paramStFeed);
    }
  }
  
  protected void a(View paramView)
  {
    if (this.mContentView == null) {
      return;
    }
    this.mContentView.setBackgroundColor(-16777216);
    hideTitleBar();
    if (getBaseActivity().getRequestedOrientation() != 1) {
      getBaseActivity().setRequestedOrientation(1);
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
      return;
    }
    paramView = new Bundle();
    paramView.putByteArray("bundle_key_subscribe_feed_bytes_array", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray());
    paramView.putSerializable("bundle_key_feed_extra_type_info", this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersVideoHeaderBlock = new VideoHeaderBlock(paramView);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersVideoHeaderBlock.a((ViewGroup)this.mContentView);
    if (this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersVideoHeaderBlock);
    }
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = ((BlockContainer)this.mContentView.findViewById(2131376516));
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersVideoHeaderBlock);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(new CommodityAdapter(paramView));
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter = new RelativeFeedsAdapter(paramView);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(this);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.c();
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView = ((VideoPlayerView)this.mContentView.findViewById(2131381007));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131371958);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369290));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850858);
    this.b = ((ImageView)this.mContentView.findViewById(2131369529));
    this.b.setBackgroundResource(2130850857);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369419));
    this.b.setOnClickListener(new SubscribeVideoDetailFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new SubscribeVideoDetailFragment.2(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setBaseVideoViewListenerSets(new SubscribeVideoDetailFragment.3(this));
  }
  
  public void a(ShareInfoBean paramShareInfoBean)
  {
    VideoPlayerView localVideoPlayerView = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
    if ((localVideoPlayerView != null) && (localVideoPlayerView.h())) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.h());
    }
    super.a(paramShareInfoBean);
  }
  
  public void a(String paramString, BlockMerger.ShareData paramShareData)
  {
    if (("share_key_subscribe_feeds_update".equals(paramString)) && (paramShareData != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper != null) && ((paramShareData.a instanceof CertifiedAccountMeta.StFeed)) && (((CertifiedAccountMeta.StFeed)paramShareData.a).type.get() == 3)) {
      ((IThirdVideoManager)QRoute.api(IThirdVideoManager.class)).sendUrlToUUIDRequest(((CertifiedAccountMeta.StFeed)paramShareData.a).video.playUrl.get(), new SubscribeVideoDetailFragment.4(this));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((LiuHaiUtils.b()) && (getBaseActivity() != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
      if (localObject != null)
      {
        if ((paramBoolean) && (!((VideoPlayerView)localObject).f()))
        {
          localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = paramInt;
          this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    float f = paramInt2 / paramInt1;
    paramInt2 = (int)(ImmersiveUtils.getScreenWidth() * f);
    int i = ImmersiveUtils.getScreenWidth();
    paramInt1 = paramInt2;
    if (paramInt2 > VideoHeaderBlock.jdField_a_of_type_Int) {
      paramInt1 = VideoHeaderBlock.jdField_a_of_type_Int;
    }
    return new int[] { i, paramInt1 };
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    super.b(paramStFeed);
    ThreadManager.b().post(new SubscribeVideoDetailFragment.5(this, paramStFeed));
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)
    {
      VideoHeaderBlock localVideoHeaderBlock = this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersVideoHeaderBlock;
      if (localVideoHeaderBlock == null) {
        return;
      }
      localVideoHeaderBlock.d(paramStFeed);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131558778;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    BlockContainer localBlockContainer = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer;
    if ((localBlockContainer != null) && (localBlockContainer.a())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    LiuHaiUtils.a(getBaseActivity());
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen();
    jdField_a_of_type_Int = hashCode();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersVideoHeaderBlock;
    if ((localObject != null) && (((VideoHeaderBlock)localObject).d()))
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer;
      if (localObject != null) {
        ((BlockContainer)localObject).b();
      }
    }
    TimeAndCountHelper.a().a("subscribe_freshman_interaction_guide");
    TimeAndCountHelper.a().a("subscribe_freshman_share_guide");
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersVideoHeaderBlock;
    if (localObject != null) {
      ((VideoHeaderBlock)localObject).g();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.jdField_a_of_type_Boolean)
    {
      VideoPlayerView localVideoPlayerView = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
      if (localVideoPlayerView != null)
      {
        if ((localVideoPlayerView.e()) && (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.d()))
        {
          this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.g();
          this.c = true;
        }
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.b(true);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onResume()
  {
    super.onResume();
    VideoPlayerView localVideoPlayerView;
    if (jdField_a_of_type_Int != hashCode())
    {
      localVideoPlayerView = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
      if (localVideoPlayerView != null)
      {
        localVideoPlayerView.i();
        QLog.d("SubscribeVideoDetailFragment", 4, "resetDataSource");
      }
    }
    else
    {
      localVideoPlayerView = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
      if (localVideoPlayerView != null)
      {
        if ((this.c) && (!localVideoPlayerView.e())) {
          this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.n();
        }
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.b(false);
        QLog.d("SubscribeVideoDetailFragment", 4, "continue to play");
      }
    }
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment
 * JD-Core Version:    0.7.0.1
 */