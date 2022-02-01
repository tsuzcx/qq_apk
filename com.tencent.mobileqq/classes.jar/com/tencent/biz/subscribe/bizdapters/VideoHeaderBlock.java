package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.part.block.BlockMerger;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.transition.inter.ITransAnimStateListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.widget.SubscribeFollowInfoView;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeVideoHeadItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tencent.widget.itemtouchhelper.GestureDetectorCompat;
import common.config.service.QzoneConfig;
import java.util.List;
import java.util.Stack;

public class VideoHeaderBlock
  extends DetailBaseBlock
  implements ITransAnimStateListener
{
  public static final int g = ImmersiveUtils.getScreenHeight() * 2 / 3;
  private boolean A;
  private GestureDetectorCompat B;
  private int C;
  private int D;
  private int E;
  private int F;
  private ViewGroup G;
  private View H;
  private View I;
  private boolean J;
  private SystemBarCompact k;
  private VideoPlayerView l;
  private int m = ImmersiveUtils.getScreenWidth();
  private int n = this.m * 9 / 16;
  private Stack<CertifiedAccountMeta.StFeed> o;
  private RelativeVideoHeadItemView p;
  private long q;
  private int r;
  private int s;
  private int t;
  private int u;
  private ImageView v;
  private RelativeLayout w;
  private ImageView x;
  private ImageView y;
  private SubscribeFollowInfoView z;
  
  public VideoHeaderBlock(Bundle paramBundle)
  {
    super(paramBundle);
    boolean bool;
    if (Integer.parseInt(QzoneConfig.getInstance().getConfig("qqsubscribe", "ShowFloatEntrance", "1")) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.A = bool;
  }
  
  private void O()
  {
    this.y.setOnClickListener(new VideoHeaderBlock.1(this));
    this.l.setPreviewVideoClickListener(new VideoHeaderBlock.2(this));
    this.l.setNextVideoClickListener(new VideoHeaderBlock.3(this));
    if (w() != null) {
      w().a(new VideoHeaderBlock.4(this));
    }
    J().addOnItemTouchListener(new VideoHeaderBlock.5(this));
    this.z.setOnTouchListener(new VideoHeaderBlock.6(this));
  }
  
  private void P()
  {
    Q();
    VideoPlayerView localVideoPlayerView = this.l;
    if (localVideoPlayerView != null)
    {
      localVideoPlayerView.a(new int[] { this.m, this.t });
      if (!this.l.w())
      {
        this.l.getLayoutParams().height = this.t;
        this.l.requestLayout();
      }
    }
  }
  
  private void Q()
  {
    if (this.c == null) {
      return;
    }
    this.r = this.c.video.width.get();
    this.s = this.c.video.height.get();
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resetVideoHW width:");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", height:");
    localStringBuilder.append(this.s);
    QLog.i(str, 1, localStringBuilder.toString());
    if (this.r <= 0)
    {
      this.r = 1920;
      this.s = 1080;
    }
    int j = (int)(this.m * R());
    int i1 = g;
    int i = j;
    if (j > i1) {
      i = i1;
    }
    this.t = i;
    this.u = this.t;
  }
  
  private float R()
  {
    return this.s / this.r;
  }
  
  private CertifiedAccountMeta.StFeed S()
  {
    Stack localStack = this.o;
    if (localStack != null)
    {
      if (localStack.empty()) {
        return null;
      }
      this.o.pop();
      if (this.o.empty()) {
        return null;
      }
      return (CertifiedAccountMeta.StFeed)this.o.pop();
    }
    return null;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (this.s < this.r) {
      return false;
    }
    int i;
    if ((J() != null) && ((J().getLayoutManager() instanceof StaggeredGridLayoutManager)))
    {
      int[] arrayOfInt = new int[J().getLayoutManager().getColumnCountForAccessibility(null, null)];
      ((StaggeredGridLayoutManager)J().getLayoutManager()).findFirstCompletelyVisibleItemPositions(arrayOfInt);
      i = arrayOfInt[0];
    }
    else
    {
      i = 0;
    }
    int j = paramMotionEvent.getAction();
    int i1 = paramMotionEvent.getActionIndex();
    if (j != 0)
    {
      if (j != 2) {
        return false;
      }
      i1 = (int)(paramMotionEvent.getX() + 0.5F);
      j = (int)(paramMotionEvent.getY() + 0.5F);
      i1 -= this.E;
      j = (int)((j - this.D) * 0.6F);
      if ((Math.abs(i1) > this.C) && (Math.abs(i1) >= Math.abs(j))) {
        return false;
      }
      float f = paramMotionEvent.getY() - this.D;
      if ((f < 0.0F) && (this.u > this.n)) {
        return true;
      }
      if ((f > 0.0F) && (this.u < this.t) && (i == 0)) {
        return true;
      }
    }
    else
    {
      this.E = ((int)(paramMotionEvent.getX() + 0.5F));
      this.D = ((int)(paramMotionEvent.getY() + 0.5F));
      this.F = MotionEventCompat.findPointerIndex(paramMotionEvent, i1);
    }
    return false;
  }
  
  private void d(View paramView)
  {
    this.l = ((VideoPlayerView)paramView.findViewById(2131450008));
    this.H = paramView.findViewById(2131437471);
    this.I = this.H.findViewById(2131437017);
    this.l.setWifiAutoPlay(true);
    this.l.setNeedWifiTips(true);
    this.l.setHostFragment((SubscribeVideoDetailFragment)A());
    this.l.c(this.b);
    this.l.a(false);
    this.l.d(this.w);
    this.B = new GestureDetectorCompat(G(), new VideoHeaderBlock.ItemTouchHelperGestureListener(this, null));
    this.C = ViewConfiguration.get(G()).getScaledTouchSlop();
    if (this.c != null)
    {
      this.l.setVideoViewCover(this.c.cover.url.get());
      if ((!this.c.video.fileId.get().equals("")) || (!this.c.video.playUrl.get().equals(""))) {
        e(this.c);
      }
    }
    this.l.setExtraTypeInfo(K());
  }
  
  private void e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (StringUtil.isEmpty(paramStFeed.video.fileId.get()))
    {
      QLog.w(a, 1, "video fileId is empty");
      return;
    }
    if (StringUtil.isEmpty(paramStFeed.video.playUrl.get()))
    {
      QLog.w(a, 1, "video playUrl is empty");
      return;
    }
    VideoPlayerView localVideoPlayerView = this.l;
    if (localVideoPlayerView != null)
    {
      this.J = true;
      localVideoPlayerView.setVideoViewCover(paramStFeed.cover.url.get());
      this.l.setVideoFeeds(paramStFeed);
    }
  }
  
  private void f(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.o == null) {
      this.o = new Stack();
    }
    this.o.push(paramStFeed);
    paramStFeed = this.l;
    if (paramStFeed != null)
    {
      int i = this.o.size();
      boolean bool = true;
      if (i <= 1) {
        bool = false;
      }
      paramStFeed.a(bool);
    }
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.p = new RelativeVideoHeadItemView(G());
    return this.p;
  }
  
  protected void a(long paramLong, String paramString)
  {
    super.a(paramLong, paramString);
    paramString = this.y;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
    paramString = this.x;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
    if (this.H != null)
    {
      paramString = this.l;
      if (paramString != null) {
        paramString.i();
      }
      this.H.setVisibility(8);
    }
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean)
  {
    paramStGetFeedDetailRsp = (CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get();
    if ((this.l != null) && (paramStGetFeedDetailRsp != null) && (SubscribeLaucher.a(paramStGetFeedDetailRsp.type.get())))
    {
      Object localObject = this.p;
      if (localObject != null) {
        ((RelativeVideoHeadItemView)localObject).setData(paramStGetFeedDetailRsp);
      }
      localObject = this.z;
      if (localObject != null) {
        ((SubscribeFollowInfoView)localObject).setData(paramStGetFeedDetailRsp);
      }
      if ((this.y != null) && (Build.VERSION.SDK_INT > 20) && (this.A)) {
        this.y.setVisibility(0);
      }
      localObject = this.x;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (!this.J) {
        e(paramStGetFeedDetailRsp);
      } else {
        QLog.i(a, 1, "has init played");
      }
      if (this.H.getVisibility() == 8) {
        this.H.setVisibility(0);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.k = ((PublicFragmentActivity)G()).mSystemBarComp;
    if (!SimpleUIUtil.e())
    {
      paramBundle = this.k;
      if (paramBundle != null) {
        paramBundle.setStatusBarDrawable(new ColorDrawable(-16777216));
      }
    }
    if (this.o == null)
    {
      this.o = new Stack();
      if (this.c != null) {
        this.o.push(this.c);
      }
    }
    this.z = ((SubscribeFollowInfoView)this.G.findViewById(2131437406));
    this.z.setHostActivity(G());
    this.z.setExtraTypeInfo(K());
    this.v = ((ImageView)this.G.findViewById(2131436276));
    this.w = ((RelativeLayout)this.G.findViewById(2131436555));
    this.x = ((ImageView)this.G.findViewById(2131436627));
    this.y = ((ImageView)this.G.findViewById(2131436361));
    if (G() != null)
    {
      LiuHaiUtils.f(G());
      LiuHaiUtils.enableNotch(G());
    }
    if ((Build.VERSION.SDK_INT <= 20) || (!this.A)) {
      this.y.setVisibility(8);
    }
    d(this.G);
    P();
    O();
  }
  
  protected void a(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    paramView.setLayoutParams(localLayoutParams);
    this.G.addView(paramView, localLayoutParams);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.G = paramViewGroup;
  }
  
  public void a(LoadInfo paramLoadInfo) {}
  
  public void a(String paramString, BlockMerger.ShareData paramShareData)
  {
    if (("share_key_continue_feeds".equals(paramString)) && (paramShareData != null))
    {
      paramString = this.l;
      if (paramString != null) {
        paramString.setContinueFeeds((List)paramShareData.a);
      }
    }
  }
  
  protected void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    super.b(paramStFeed);
    if (this.b != null)
    {
      paramStFeed = this.l;
      if ((paramStFeed != null) && (paramStFeed.w())) {
        this.b.setVisibility(8);
      }
    }
  }
  
  public void d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      if (System.currentTimeMillis() - this.q < 500L) {
        return;
      }
      if (paramStFeed == null) {
        return;
      }
      this.q = System.currentTimeMillis();
      Object localObject = paramStFeed.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("auth_");
      localStringBuilder.append(SubscribeShareHelper.a(K()));
      VSReporter.a((String)localObject, localStringBuilder.toString(), "clk_recom", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
      if (!SubscribeLaucher.a(paramStFeed.type.get()))
      {
        SubscribeLaucher.a(G(), paramStFeed);
        if (G() != null) {
          G().finish();
        }
      }
      else
      {
        localObject = this.l;
        if (localObject != null) {
          ((VideoPlayerView)localObject).i();
        }
        this.c = paramStFeed;
        f(this.c);
        P();
        this.J = false;
        e(this.c);
        this.b.a(paramStFeed);
        b("share_key_subscribe_feeds_update", new BlockMerger.ShareData(paramStFeed, true));
        if (J() != null) {
          J().scrollToPosition(0);
        }
      }
    }
  }
  
  protected View h()
  {
    return this.I;
  }
  
  public boolean i()
  {
    VideoPlayerView localVideoPlayerView = this.l;
    if ((localVideoPlayerView != null) && (localVideoPlayerView.v())) {
      return true;
    }
    return super.i();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onBindViewHolder(paramViewHolder, paramInt);
    Object localObject = this.p;
    if (localObject != null) {
      ((RelativeVideoHeadItemView)localObject).setData(this.c);
    }
    localObject = this.z;
    if (localObject != null) {
      ((SubscribeFollowInfoView)localObject).b(this.c);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    paramRecyclerView = this.o;
    if (paramRecyclerView != null) {
      paramRecyclerView.clear();
    }
    paramRecyclerView = this.l;
    if (paramRecyclerView != null) {
      paramRecyclerView.g();
    }
  }
  
  public void r()
  {
    VideoPlayerView localVideoPlayerView = this.l;
    if (localVideoPlayerView != null) {
      localVideoPlayerView.setAlpha(0.0F);
    }
  }
  
  public void s()
  {
    QLog.d(a, 1, "onTransAnimateInit disableLoading!");
    e();
    VideoPlayerView localVideoPlayerView = this.l;
    if (localVideoPlayerView != null) {
      localVideoPlayerView.setAlpha(0.0F);
    }
  }
  
  public void t()
  {
    VideoPlayerView localVideoPlayerView = this.l;
    if (localVideoPlayerView != null) {
      localVideoPlayerView.setAlpha(1.0F);
    }
  }
  
  public void u()
  {
    VideoPlayerView localVideoPlayerView = this.l;
    if (localVideoPlayerView != null) {
      localVideoPlayerView.setAlpha(1.0F);
    }
  }
  
  public View v()
  {
    return this.z;
  }
  
  public RelativeFeedsAdapter w()
  {
    return (RelativeFeedsAdapter)B().b("RELATIVE_ADAPTER_UNIQUE_KEY");
  }
  
  public boolean x()
  {
    VideoPlayerView localVideoPlayerView = this.l;
    if (localVideoPlayerView != null) {
      return localVideoPlayerView.q() ^ true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock
 * JD-Core Version:    0.7.0.1
 */