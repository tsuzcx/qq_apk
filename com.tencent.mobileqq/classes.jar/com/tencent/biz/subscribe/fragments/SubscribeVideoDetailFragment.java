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
  private static int m;
  protected BlockContainer h;
  private VideoPlayerView i;
  private View j;
  private boolean k;
  private TextView l;
  private VideoHeaderBlock n;
  private RelativeFeedsAdapter o;
  private ImageView p;
  private ImageView q;
  
  protected View a()
  {
    return this.q;
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    VideoHeaderBlock localVideoHeaderBlock = this.n;
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
    if (this.a == null) {
      return;
    }
    paramView = new Bundle();
    paramView.putByteArray("bundle_key_subscribe_feed_bytes_array", this.a.toByteArray());
    paramView.putSerializable("bundle_key_feed_extra_type_info", this.b);
    this.n = new VideoHeaderBlock(paramView);
    this.n.a((ViewGroup)this.mContentView);
    if (this.g != null) {
      this.g.a(this.n);
    }
    this.h = ((BlockContainer)this.mContentView.findViewById(2131444760));
    this.h.setLayoutManagerType(3, 2);
    this.h.setParentFragment(this);
    this.h.setEnableLoadMore(true);
    this.h.setExtraTypeInfo(this.b);
    this.h.a(this.n);
    this.h.a(new CommodityAdapter(paramView));
    this.o = new RelativeFeedsAdapter(paramView);
    this.h.a(this.o);
    this.h.a(this);
    this.h.e();
    this.i = ((VideoPlayerView)this.mContentView.findViewById(2131450008));
    this.i.setExtraTypeInfo(this.b);
    this.j = this.mContentView.findViewById(2131439403);
    this.p = ((ImageView)this.mContentView.findViewById(2131436276));
    this.p.setBackgroundResource(2130852704);
    this.q = ((ImageView)this.mContentView.findViewById(2131436627));
    this.q.setBackgroundResource(2130852701);
    this.l = ((TextView)this.mContentView.findViewById(2131436456));
    this.q.setOnClickListener(new SubscribeVideoDetailFragment.1(this));
    this.p.setOnClickListener(new SubscribeVideoDetailFragment.2(this));
    this.i.setBaseVideoViewListenerSets(new SubscribeVideoDetailFragment.3(this));
  }
  
  public void a(ShareInfoBean paramShareInfoBean)
  {
    VideoPlayerView localVideoPlayerView = this.i;
    if ((localVideoPlayerView != null) && (localVideoPlayerView.w())) {
      this.c.a(this.i.w());
    }
    super.a(paramShareInfoBean);
  }
  
  public void a(String paramString, BlockMerger.ShareData paramShareData)
  {
    if (("share_key_subscribe_feeds_update".equals(paramString)) && (paramShareData != null) && (this.c != null) && ((paramShareData.a instanceof CertifiedAccountMeta.StFeed)) && (((CertifiedAccountMeta.StFeed)paramShareData.a).type.get() == 3)) {
      ((IThirdVideoManager)QRoute.api(IThirdVideoManager.class)).sendUrlToUUIDRequest(((CertifiedAccountMeta.StFeed)paramShareData.a).video.playUrl.get(), new SubscribeVideoDetailFragment.4(this));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((LiuHaiUtils.b()) && (getBaseActivity() != null) && (this.j != null))
    {
      Object localObject = this.i;
      if (localObject != null)
      {
        if ((paramBoolean) && (!((VideoPlayerView)localObject).u()))
        {
          localObject = this.j.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = paramInt;
          this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.j.setVisibility(0);
          return;
        }
        this.j.setVisibility(8);
      }
    }
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    float f = paramInt2 / paramInt1;
    paramInt2 = (int)(ImmersiveUtils.getScreenWidth() * f);
    int i1 = ImmersiveUtils.getScreenWidth();
    paramInt1 = paramInt2;
    if (paramInt2 > VideoHeaderBlock.g) {
      paramInt1 = VideoHeaderBlock.g;
    }
    return new int[] { i1, paramInt1 };
  }
  
  protected TextView b()
  {
    return this.l;
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    super.b(paramStFeed);
    ThreadManager.b().post(new SubscribeVideoDetailFragment.5(this, paramStFeed));
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.i != null)
    {
      VideoHeaderBlock localVideoHeaderBlock = this.n;
      if (localVideoHeaderBlock == null) {
        return;
      }
      localVideoHeaderBlock.d(paramStFeed);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131624398;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    BlockContainer localBlockContainer = this.h;
    if ((localBlockContainer != null) && (localBlockContainer.b())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    LiuHaiUtils.f(getBaseActivity());
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen();
    m = hashCode();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.n;
    if ((localObject != null) && (((VideoHeaderBlock)localObject).x()))
    {
      localObject = this.h;
      if (localObject != null) {
        ((BlockContainer)localObject).c();
      }
    }
    TimeAndCountHelper.a().a("subscribe_freshman_interaction_guide");
    TimeAndCountHelper.a().a("subscribe_freshman_share_guide");
    localObject = this.n;
    if (localObject != null) {
      ((VideoHeaderBlock)localObject).n();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.e)
    {
      VideoPlayerView localVideoPlayerView = this.i;
      if (localVideoPlayerView != null)
      {
        if ((localVideoPlayerView.s()) && (!this.i.q()))
        {
          this.i.h();
          this.k = true;
        }
        this.i.b(true);
      }
    }
    this.e = false;
  }
  
  public void onResume()
  {
    super.onResume();
    VideoPlayerView localVideoPlayerView;
    if (m != hashCode())
    {
      localVideoPlayerView = this.i;
      if (localVideoPlayerView != null)
      {
        localVideoPlayerView.j();
        QLog.d("SubscribeVideoDetailFragment", 4, "resetDataSource");
      }
    }
    else
    {
      localVideoPlayerView = this.i;
      if (localVideoPlayerView != null)
      {
        if ((this.k) && (!localVideoPlayerView.s())) {
          this.i.t();
        }
        this.i.b(false);
        QLog.d("SubscribeVideoDetailFragment", 4, "continue to play");
      }
    }
    this.k = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment
 * JD-Core Version:    0.7.0.1
 */