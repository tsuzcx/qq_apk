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
  public static final int a;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private VideoPlayerView jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
  private SubscribeFollowInfoView jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView;
  private RelativeVideoHeadItemView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private GestureDetectorCompat jdField_a_of_type_ComTencentWidgetItemtouchhelperGestureDetectorCompat;
  private Stack<CertifiedAccountMeta.StFeed> jdField_a_of_type_JavaUtilStack;
  private int jdField_b_of_type_Int = ImmersiveUtils.getScreenWidth();
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int jdField_c_of_type_Int = this.jdField_b_of_type_Int * 9 / 16;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  static
  {
    jdField_a_of_type_Int = ImmersiveUtils.getScreenHeight() * 2 / 3;
  }
  
  public VideoHeaderBlock(Bundle paramBundle)
  {
    super(paramBundle);
    boolean bool;
    if (Integer.parseInt(QzoneConfig.getInstance().getConfig("qqsubscribe", "ShowFloatEntrance", "1")) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_c_of_type_Boolean = bool;
  }
  
  private float a()
  {
    return this.e / this.jdField_d_of_type_Int;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (this.e < this.jdField_d_of_type_Int) {
      return false;
    }
    int m;
    if ((a() != null) && ((a().getLayoutManager() instanceof StaggeredGridLayoutManager)))
    {
      int[] arrayOfInt = new int[a().getLayoutManager().getColumnCountForAccessibility(null, null)];
      ((StaggeredGridLayoutManager)a().getLayoutManager()).findFirstCompletelyVisibleItemPositions(arrayOfInt);
      m = arrayOfInt[0];
    }
    else
    {
      m = 0;
    }
    int n = paramMotionEvent.getAction();
    int i1 = paramMotionEvent.getActionIndex();
    if (n != 0)
    {
      if (n != 2) {
        return false;
      }
      i1 = (int)(paramMotionEvent.getX() + 0.5F);
      n = (int)(paramMotionEvent.getY() + 0.5F);
      i1 -= this.j;
      n = (int)((n - this.i) * 0.6F);
      if ((Math.abs(i1) > this.h) && (Math.abs(i1) >= Math.abs(n))) {
        return false;
      }
      float f1 = paramMotionEvent.getY() - this.i;
      if ((f1 < 0.0F) && (this.g > this.jdField_c_of_type_Int)) {
        return true;
      }
      if ((f1 > 0.0F) && (this.g < this.f) && (m == 0)) {
        return true;
      }
    }
    else
    {
      this.j = ((int)(paramMotionEvent.getX() + 0.5F));
      this.i = ((int)(paramMotionEvent.getY() + 0.5F));
      this.k = MotionEventCompat.findPointerIndex(paramMotionEvent, i1);
    }
    return false;
  }
  
  private CertifiedAccountMeta.StFeed b()
  {
    Stack localStack = this.jdField_a_of_type_JavaUtilStack;
    if (localStack != null)
    {
      if (localStack.empty()) {
        return null;
      }
      this.jdField_a_of_type_JavaUtilStack.pop();
      if (this.jdField_a_of_type_JavaUtilStack.empty()) {
        return null;
      }
      return (CertifiedAccountMeta.StFeed)this.jdField_a_of_type_JavaUtilStack.pop();
    }
    return null;
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView = ((VideoPlayerView)paramView.findViewById(2131381007));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370264);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369879);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setWifiAutoPlay(true);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setNeedWifiTips(true);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setHostFragment((SubscribeVideoDetailFragment)a());
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.a(false);
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.c(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentWidgetItemtouchhelperGestureDetectorCompat = new GestureDetectorCompat(a(), new VideoHeaderBlock.ItemTouchHelperGestureListener(this, null));
    this.h = ViewConfiguration.get(a()).getScaledTouchSlop();
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setVideoViewCover(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.url.get());
      if ((!this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.fileId.get().equals("")) || (!this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.playUrl.get().equals(""))) {
        e(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      }
    }
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setExtraTypeInfo(a());
  }
  
  private void e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (StringUtil.a(paramStFeed.video.fileId.get()))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "video fileId is empty");
      return;
    }
    if (StringUtil.a(paramStFeed.video.playUrl.get()))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "video playUrl is empty");
      return;
    }
    VideoPlayerView localVideoPlayerView = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
    if (localVideoPlayerView != null)
    {
      this.jdField_d_of_type_Boolean = true;
      localVideoPlayerView.setVideoViewCover(paramStFeed.cover.url.get());
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setVideoFeeds(paramStFeed);
    }
  }
  
  private void f(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_JavaUtilStack == null) {
      this.jdField_a_of_type_JavaUtilStack = new Stack();
    }
    this.jdField_a_of_type_JavaUtilStack.push(paramStFeed);
    paramStFeed = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
    if (paramStFeed != null)
    {
      int m = this.jdField_a_of_type_JavaUtilStack.size();
      boolean bool = true;
      if (m <= 1) {
        bool = false;
      }
      paramStFeed.a(bool);
    }
  }
  
  private void q()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new VideoHeaderBlock.1(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setPreviewVideoClickListener(new VideoHeaderBlock.2(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setNextVideoClickListener(new VideoHeaderBlock.3(this));
    if (a() != null) {
      a().a(new VideoHeaderBlock.4(this));
    }
    a().addOnItemTouchListener(new VideoHeaderBlock.5(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setOnTouchListener(new VideoHeaderBlock.6(this));
  }
  
  private void r()
  {
    s();
    VideoPlayerView localVideoPlayerView = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
    if (localVideoPlayerView != null)
    {
      localVideoPlayerView.a(new int[] { this.jdField_b_of_type_Int, this.f });
      if (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.h())
      {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.getLayoutParams().height = this.f;
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.requestLayout();
      }
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
      return;
    }
    this.jdField_d_of_type_Int = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.width.get();
    this.e = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.video.height.get();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resetVideoHW width:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", height:");
    localStringBuilder.append(this.e);
    QLog.i(str, 1, localStringBuilder.toString());
    if (this.jdField_d_of_type_Int <= 0)
    {
      this.jdField_d_of_type_Int = 1920;
      this.e = 1080;
    }
    int n = (int)(this.jdField_b_of_type_Int * a());
    int i1 = jdField_a_of_type_Int;
    int m = n;
    if (n > i1) {
      m = i1;
    }
    this.f = m;
    this.g = this.f;
  }
  
  protected View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView = new RelativeVideoHeadItemView(a());
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView;
  }
  
  public RelativeFeedsAdapter a()
  {
    return (RelativeFeedsAdapter)a().a("RELATIVE_ADAPTER_UNIQUE_KEY");
  }
  
  protected void a(long paramLong, String paramString)
  {
    super.a(paramLong, paramString);
    paramString = this.jdField_c_of_type_AndroidWidgetImageView;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
    paramString = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      paramString = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
      if (paramString != null) {
        paramString.h();
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean)
  {
    paramStGetFeedDetailRsp = (CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get();
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (paramStGetFeedDetailRsp != null) && (SubscribeLaucher.a(paramStGetFeedDetailRsp.type.get())))
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView;
      if (localObject != null) {
        ((RelativeVideoHeadItemView)localObject).setData(paramStGetFeedDetailRsp);
      }
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView;
      if (localObject != null) {
        ((SubscribeFollowInfoView)localObject).setData(paramStGetFeedDetailRsp);
      }
      if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (Build.VERSION.SDK_INT > 20) && (this.jdField_c_of_type_Boolean)) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (!this.jdField_d_of_type_Boolean) {
        e(paramStGetFeedDetailRsp);
      } else {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "has init played");
      }
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)a()).mSystemBarComp;
    if (!SimpleUIUtil.a())
    {
      paramBundle = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
      if (paramBundle != null) {
        paramBundle.setStatusBarDrawable(new ColorDrawable(-16777216));
      }
    }
    if (this.jdField_a_of_type_JavaUtilStack == null)
    {
      this.jdField_a_of_type_JavaUtilStack = new Stack();
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
        this.jdField_a_of_type_JavaUtilStack.push(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      }
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView = ((SubscribeFollowInfoView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370220));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setHostActivity(a());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setExtraTypeInfo(a());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369290));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369484));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369529));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369347));
    if (a() != null)
    {
      LiuHaiUtils.a(a());
      LiuHaiUtils.enableNotch(a());
    }
    if ((Build.VERSION.SDK_INT <= 20) || (!this.jdField_c_of_type_Boolean)) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    c(this.jdField_a_of_type_AndroidViewViewGroup);
    r();
    q();
  }
  
  protected void a(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    paramView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, localLayoutParams);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(LoadInfo paramLoadInfo) {}
  
  public void a(String paramString, BlockMerger.ShareData paramShareData)
  {
    if (("share_key_continue_feeds".equals(paramString)) && (paramShareData != null))
    {
      paramString = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
      if (paramString != null) {
        paramString.setContinueFeeds((List)paramShareData.a);
      }
    }
  }
  
  public View b()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView;
  }
  
  protected void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    super.b(paramStFeed);
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null)
    {
      paramStFeed = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
      if ((paramStFeed != null) && (paramStFeed.h())) {
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setVisibility(8);
      }
    }
  }
  
  public boolean b()
  {
    VideoPlayerView localVideoPlayerView = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
    if ((localVideoPlayerView != null) && (localVideoPlayerView.g())) {
      return true;
    }
    return super.b();
  }
  
  public void d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
        return;
      }
      if (paramStFeed == null) {
        return;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      Object localObject = paramStFeed.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("auth_");
      localStringBuilder.append(SubscribeShareHelper.a(a()));
      VSReporter.a((String)localObject, localStringBuilder.toString(), "clk_recom", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
      if (!SubscribeLaucher.a(paramStFeed.type.get()))
      {
        SubscribeLaucher.a(a(), paramStFeed);
        if (a() != null) {
          a().finish();
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
        if (localObject != null) {
          ((VideoPlayerView)localObject).h();
        }
        this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
        f(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        r();
        this.jdField_d_of_type_Boolean = false;
        e(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(paramStFeed);
        b("share_key_subscribe_feeds_update", new BlockMerger.ShareData(paramStFeed, true));
        if (a() != null) {
          a().scrollToPosition(0);
        }
      }
    }
  }
  
  public boolean d()
  {
    VideoPlayerView localVideoPlayerView = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
    if (localVideoPlayerView != null) {
      return localVideoPlayerView.d() ^ true;
    }
    return true;
  }
  
  public void k()
  {
    VideoPlayerView localVideoPlayerView = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
    if (localVideoPlayerView != null) {
      localVideoPlayerView.setAlpha(0.0F);
    }
  }
  
  public void l()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onTransAnimateInit disableLoading!");
    b();
    VideoPlayerView localVideoPlayerView = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
    if (localVideoPlayerView != null) {
      localVideoPlayerView.setAlpha(0.0F);
    }
  }
  
  public void m()
  {
    VideoPlayerView localVideoPlayerView = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
    if (localVideoPlayerView != null) {
      localVideoPlayerView.setAlpha(1.0F);
    }
  }
  
  public void n()
  {
    VideoPlayerView localVideoPlayerView = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
    if (localVideoPlayerView != null) {
      localVideoPlayerView.setAlpha(1.0F);
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onBindViewHolder(paramViewHolder, paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeVideoHeadItemView;
    if (localObject != null) {
      ((RelativeVideoHeadItemView)localObject).setData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView;
    if (localObject != null) {
      ((SubscribeFollowInfoView)localObject).b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    paramRecyclerView = this.jdField_a_of_type_JavaUtilStack;
    if (paramRecyclerView != null) {
      paramRecyclerView.clear();
    }
    paramRecyclerView = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
    if (paramRecyclerView != null) {
      paramRecyclerView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock
 * JD-Core Version:    0.7.0.1
 */