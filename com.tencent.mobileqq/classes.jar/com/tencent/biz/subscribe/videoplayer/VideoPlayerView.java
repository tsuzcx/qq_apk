package com.tencent.biz.subscribe.videoplayer;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.framework.BaseVideoView;
import com.tencent.biz.subscribe.framework.BaseVideoViewListenerSets;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.NetworkManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class VideoPlayerView
  extends BaseVideoView
{
  private static final HashMap<View, Integer> B = new HashMap();
  private static float F = 1.0F;
  private static final SparseBooleanArray ak = new SparseBooleanArray();
  private static boolean am;
  private ArrayList<View> A = new ArrayList();
  private boolean C = false;
  private boolean D;
  private String E = "";
  private boolean G;
  private int H;
  private boolean I = true;
  private boolean J = true;
  private View K;
  private CertifiedAccountMeta.StFeed L;
  private TextView M;
  private View N;
  private SquareImageView O;
  private FollowTextView P;
  private SubscribeVideoDetailFragment Q;
  private View R;
  private TextView S;
  private boolean T;
  private VideoNextFeedsView U;
  private View V;
  private View W;
  private long Z = 0L;
  private SystemBarCompact aA;
  private int aB;
  private ExtraTypeInfo aC;
  private SeekBar aD;
  private View aa;
  private HashMap<String, Boolean> ab = new HashMap();
  private boolean ac;
  private boolean ad;
  private long ae;
  private IVideoOuterStatusListener af;
  private boolean ag = false;
  private boolean ah = false;
  private long ai;
  private long aj;
  private long al;
  private boolean an = false;
  private String ao;
  private View ap;
  private SquareImageView aq;
  private TextView ar;
  private FollowTextView as;
  private LinearLayout at;
  private LinearLayout au;
  private boolean av;
  private boolean aw;
  private View ax;
  private int ay = 1;
  private boolean az;
  protected TextView k;
  protected TextView l;
  protected ImageView m;
  protected ImageView n;
  protected ImageView o;
  protected ImageView p;
  protected ProgressBar q;
  protected View r;
  protected URLImageView s;
  private View t;
  private View u;
  private final int v = 2;
  private final int w = 3;
  private boolean x = false;
  private int[] y = null;
  private int[] z = LiuHaiUtils.e(getContext());
  
  public VideoPlayerView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoPlayerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoPlayerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void A()
  {
    this.t.setOnTouchListener(new VideoPlayerView.1(this));
    this.S.setOnClickListener(new VideoPlayerView.2(this));
    this.P.setFollowStateChangeListener(new VideoPlayerView.3(this));
    this.n.setOnClickListener(new VideoPlayerView.4(this));
    this.m.setOnClickListener(new VideoPlayerView.5(this));
    this.V.setOnClickListener(new VideoPlayerView.6(this));
    this.W.setOnClickListener(new VideoPlayerView.7(this));
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void B()
  {
    if ((getSuperPlayer() != null) && (this.n != null))
    {
      if (getSuperPlayer().isPlaying())
      {
        h();
        return;
      }
      e();
    }
  }
  
  private void C()
  {
    if (this.I) {
      J();
    } else {
      K();
    }
    this.G = true;
  }
  
  private void D()
  {
    E();
    L();
    this.V = findViewById(2131437565);
    this.W = findViewById(2131437566);
    this.s = ((URLImageView)findViewById(2131436651));
    setVideoCover(this.s);
    this.N = findViewById(2131433262);
    this.P = ((FollowTextView)findViewById(2131448469));
    this.O = ((SquareImageView)findViewById(2131436499));
    this.R = findViewById(2131450156);
    this.S = ((TextView)findViewById(2131448533));
    F();
    if (getPlayerVideoView() != null) {
      getPlayerVideoView().setXYaxis(2);
    }
    NetworkManager.registNetStatusListener(this);
  }
  
  private void E()
  {
    this.t = findViewById(2131445069);
    this.k = ((TextView)this.t.findViewById(2131448869));
    this.M = ((TextView)this.t.findViewById(2131448814));
    this.l = ((TextView)this.t.findViewById(2131448868));
    this.m = ((ImageView)this.t.findViewById(2131436391));
    this.aa = this.t.findViewById(2131437422);
    this.K = this.t.findViewById(2131437579);
    this.u = this.t.findViewById(2131437595);
    this.n = ((ImageView)this.t.findViewById(2131436655));
    this.o = ((ImageView)this.t.findViewById(2131436657));
    this.p = ((ImageView)this.t.findViewById(2131436654));
    this.q = ((ProgressBar)this.t.findViewById(2131436653));
    this.aD = ((SeekBar)this.t.findViewById(2131445502));
  }
  
  private void F()
  {
    HashMap localHashMap = B;
    View localView = this.t;
    Integer localInteger = Integer.valueOf(0);
    localHashMap.put(localView, localInteger);
    B.put(this.p, localInteger);
    B.put(this.n, localInteger);
    B.put(this.o, localInteger);
    B.put(this.aD, localInteger);
    B.put(this.m, localInteger);
    ak.put(this.t.getId(), true);
    ak.put(this.V.getId(), true);
    ak.put(this.W.getId(), true);
  }
  
  private void G()
  {
    this.ao = null;
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  private void H()
  {
    setState(1);
    this.aw = false;
    Object localObject = this.t;
    if ((localObject != null) && (!this.ad)) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.aa;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (this.u != null)
    {
      localObject = this.n;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130839130);
      }
      this.u.setVisibility(0);
      e(true);
    }
    localObject = this.N;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
      this.N.setVisibility(8);
    }
    N();
    getMainHandler().removeMessages(3);
  }
  
  private void I()
  {
    Object localObject1 = this.L;
    if ((localObject1 != null) && (((CertifiedAccountMeta.StFeed)localObject1).poster != null) && (getSuperPlayer() != null))
    {
      long l1 = System.currentTimeMillis() - this.ai;
      localObject1 = new StringBuilder();
      int i;
      if (l1 >= getSuperPlayer().getDurationMs()) {
        i = 1;
      } else {
        i = 0;
      }
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      String str = this.L.poster.id.get();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getSuperPlayer().getDurationMs());
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1);
      localStringBuilder.append("");
      VSReporter.a(str, "auth_video", "play", 0, 0, new String[] { localObject2, localStringBuilder.toString(), localObject1, this.L.id.get() });
    }
    if (getSecondBufferCount() > 0)
    {
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("time_cost", Long.valueOf(getBufferBeginTime()));
      ((HashMap)localObject1).put("count", Integer.valueOf(getSecondBufferCount()));
      ((HashMap)localObject1).put("url", this.ao);
      VSReporter.a("subscribe_account_video_play_extra_buffer", VSReporter.b((HashMap)localObject1));
    }
    VSReporter.a("subscribe_account_video_download", VSReporter.a(VSReporter.a(Long.valueOf(this.i).longValue(), 0L, this.ao, 0L)));
    if (getSuperPlayer() != null)
    {
      double d2 = getSuperPlayer().getCurrentPositionMs();
      double d1 = getSuperPlayer().getDurationMs();
      if ((d2 > 0.0D) && (d1 > 0.0D) && (d2 <= d1))
      {
        Double.isNaN(d2);
        Double.isNaN(d1);
        d2 /= d1;
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("rate", String.format("%.2f", new Object[] { Double.valueOf(d2 * 100.0D) }));
        ((HashMap)localObject1).put("url", this.ao);
        ((HashMap)localObject1).put("attach_info", String.valueOf(d1));
        VSReporter.a("subscribe_account_video_play_complete_rate", VSReporter.b((HashMap)localObject1));
      }
    }
  }
  
  private void J()
  {
    if ((this.I) && (!this.J))
    {
      Iterator localIterator = B.keySet().iterator();
      while (localIterator.hasNext()) {
        a((View)localIterator.next(), 1, 0);
      }
      this.I = false;
    }
  }
  
  private void K()
  {
    if (!this.I)
    {
      Object localObject = B.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        a((View)((Iterator)localObject).next(), 0, 1);
      }
      this.I = true;
      localObject = this.u;
      if ((localObject != null) && (((View)localObject).getVisibility() == 8)) {
        this.u.setVisibility(0);
      }
    }
  }
  
  private void L()
  {
    this.ap = findViewById(2131433248);
    this.U = ((VideoNextFeedsView)this.ap.findViewById(2131449959));
    this.ax = this.ap.findViewById(2131437567);
    this.au = ((LinearLayout)this.ap.findViewById(2131433247));
    this.aq = ((SquareImageView)this.ap.findViewById(2131436384));
    this.at = ((LinearLayout)this.ap.findViewById(2131437453));
    this.ar = ((TextView)this.ap.findViewById(2131448472));
    this.as = ((FollowTextView)this.ap.findViewById(2131433888));
    this.r = this.ap.findViewById(2131448704);
    VideoPlayerView.13 local13 = new VideoPlayerView.13(this);
    this.r.setOnClickListener(local13);
    this.ax.setOnClickListener(local13);
    this.U.setOnClickListener(new VideoPlayerView.14(this));
    this.U.setOnCounterListener(new VideoPlayerView.15(this));
  }
  
  private void M()
  {
    Object localObject = this.t;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.ap;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.N;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
      this.N.setVisibility(8);
    }
    localObject = this.U;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((VideoNextFeedsView)localObject).getLayoutParams();
      if (w())
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
      }
      this.U.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.au;
    if (localObject != null)
    {
      int i;
      if (w()) {
        i = 0;
      } else {
        i = 8;
      }
      ((LinearLayout)localObject).setVisibility(i);
    }
    if ((w()) && (this.L != null))
    {
      localObject = this.ar;
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        this.ar.setText(this.L.poster.nick.get());
      }
      if (this.aq != null) {
        SubImageLoader.a(this.L.poster.icon.get(), this.aq);
      }
      localObject = this.as;
      if (localObject != null)
      {
        ((FollowTextView)localObject).setOnlyFollowMode(true);
        this.as.setFeedData(this.L);
        this.as.setExtraTypeInfo(getExtraTypeInfo());
        this.as.setFollowStateChangeListener(new VideoPlayerView.16(this));
      }
      if (this.at != null)
      {
        localObject = this.au;
        if (localObject != null)
        {
          localObject = (RelativeLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
          if (((getContext() instanceof Activity)) && (((Activity)getContext()).getRequestedOrientation() == 0))
          {
            ((RelativeLayout.LayoutParams)localObject).addRule(2, this.U.getId());
            this.at.setOrientation(0);
            ((LinearLayout.LayoutParams)this.as.getLayoutParams()).rightMargin = ImmersiveUtils.dpToPx(12.0F);
          }
          else
          {
            this.at.setOrientation(1);
            ((LinearLayout.LayoutParams)this.as.getLayoutParams()).rightMargin = 0;
            ((RelativeLayout.LayoutParams)localObject).addRule(2, 0);
          }
          this.as.requestLayout();
        }
      }
      localObject = this.ax;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = this.ax;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
  }
  
  private void N()
  {
    Object localObject = this.ap;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
      this.ap.setVisibility(8);
    }
    localObject = this.U;
    if ((localObject != null) && (((VideoNextFeedsView)localObject).getVisibility() == 0)) {
      this.U.c();
    }
  }
  
  private void O()
  {
    if (getPlayerVideoView() != null)
    {
      boolean bool;
      if (getPlayerVideoView().getRenderViewWidth() > getPlayerVideoView().getRenderViewHeight()) {
        bool = true;
      } else {
        bool = false;
      }
      this.av = bool;
    }
  }
  
  private void P()
  {
    O();
    int i = this.z[0];
    if (getLayoutParams().width != -1) {
      i = getLayoutParams().width;
    }
    this.y = new int[] { i, getLayoutParams().height };
    int[] arrayOfInt;
    if (this.av)
    {
      if ((getContext() instanceof Activity)) {
        ((Activity)getContext()).setRequestedOrientation(0);
      }
      arrayOfInt = this.z;
      b(new int[] { arrayOfInt[1], arrayOfInt[0] });
    }
    else
    {
      arrayOfInt = this.z;
      b(new int[] { arrayOfInt[0], arrayOfInt[1] });
    }
    setHideViewVisible(8);
    setFullState(true);
    Q();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
  }
  
  private void Q()
  {
    if (this.L != null)
    {
      localObject = this.M;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      R();
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(2130839125);
    }
  }
  
  private void R()
  {
    if ((this.M != null) && ((getContext() instanceof Activity)))
    {
      int i;
      if (((Activity)getContext()).getRequestedOrientation() == 0) {
        i = 25;
      } else {
        i = 12;
      }
      this.M.setMaxEms(i);
    }
  }
  
  private void S()
  {
    Object localObject = this.L;
    if (localObject != null)
    {
      int i = ((CertifiedAccountMeta.StFeed)localObject).poster.followState.get();
      int j = 0;
      if (i == 0)
      {
        localObject = this.ab;
        if ((localObject != null) && (((HashMap)localObject).get(this.L.poster.id.get()) == null))
        {
          i = 0;
          break label65;
        }
      }
      i = 1;
      label65:
      localObject = this.P;
      if (localObject != null)
      {
        ((FollowTextView)localObject).setOnlyFollowMode(true);
        this.P.setFeedData(this.L);
        this.P.setExtraTypeInfo(getExtraTypeInfo());
      }
      if ((i == 0) && (!this.aw) && (w())) {
        i = 1;
      } else {
        i = 0;
      }
      if (this.N != null)
      {
        if (i != 0)
        {
          this.aw = true;
          localObject = this.L;
          if (localObject != null) {
            VSReporter.b(((CertifiedAccountMeta.StFeed)localObject).poster.id.get(), "auth_video", "half_exp", 0, 0, new String[] { "", "", this.L.poster.nick.get(), this.L.title.get() });
          }
        }
        localObject = this.N;
        if (i != 0) {
          i = j;
        } else {
          i = 8;
        }
        ((View)localObject).setVisibility(i);
        getMainHandler().sendEmptyMessageDelayed(3, 5000L);
      }
    }
  }
  
  private void T()
  {
    Object localObject = this.M;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.m;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(2130839127);
    }
    localObject = this.N;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  private void U()
  {
    if ((getContext() instanceof Activity))
    {
      ((Activity)getContext()).setRequestedOrientation(1);
      TextView localTextView = this.M;
      if (localTextView != null) {
        localTextView.setMaxEms(12);
      }
    }
    b(this.y);
    setHideViewVisible(0);
    setFullState(false);
    T();
    if (this.ay == 10) {
      M();
    }
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, false);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { paramInt1, paramInt2 });
    localObjectAnimator.setDuration(0L);
    localObjectAnimator.addListener(new VideoPlayerView.12(this, paramInt2, paramView, paramBoolean, paramInt1));
    localObjectAnimator.start();
  }
  
  private boolean a(String paramString)
  {
    try
    {
      String[] arrayOfString = ((String)VSConfigManager.a().a("KEY_HIT_FOR_VID_URLS", "http://qzvv.video.qq.com/qzone|https://qzvv.video.qq.com/qzone")).split("\\|");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = paramString.startsWith(arrayOfString[i]);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private void b(int[] paramArrayOfInt)
  {
    getLayoutParams().width = paramArrayOfInt[0];
    getLayoutParams().height = paramArrayOfInt[1];
    setLayoutParams(getLayoutParams());
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.Q != null)
    {
      localObject = this.U.getNextFeed();
      if (localObject != null)
      {
        this.Q.c((CertifiedAccountMeta.StFeed)localObject);
        String str = ((CertifiedAccountMeta.StFeed)localObject).poster.id.get();
        if (paramBoolean) {
          localObject = "next_play";
        } else {
          localObject = "next_clk";
        }
        VSReporter.b(str, "auth_video", (String)localObject, 0, 0, new String[0]);
      }
    }
    Object localObject = this.s;
    if (localObject != null)
    {
      ((URLImageView)localObject).setBackgroundResource(0);
      this.s.setVisibility(8);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject = this.q;
    int j = 0;
    int i;
    if (localObject != null)
    {
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      ((ProgressBar)localObject).setVisibility(i);
    }
    localObject = this.n;
    if (localObject != null)
    {
      i = j;
      if (paramBoolean) {
        i = 8;
      }
      ((ImageView)localObject).setVisibility(i);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (!LiuHaiUtils.b()) {
      return;
    }
    Object localObject;
    if ((paramBoolean) && (!this.av))
    {
      localObject = this.Q;
      if (localObject != null) {
        ((SubscribeVideoDetailFragment)localObject).a(true, this.aB);
      }
      localObject = this.t;
      if (localObject != null) {
        ((View)localObject).setPadding(0, this.aB, 0, 0);
      }
    }
    else
    {
      localObject = this.Q;
      if (localObject != null) {
        ((SubscribeVideoDetailFragment)localObject).a(false, this.aB);
      }
      localObject = this.t;
      if (localObject != null) {
        ((View)localObject).setPadding(0, 0, 0, 0);
      }
    }
  }
  
  private void setFullState(boolean paramBoolean)
  {
    this.x = paramBoolean;
    Object localObject = this.Q;
    if ((localObject != null) && (((SubscribeVideoDetailFragment)localObject).getBaseActivity() != null))
    {
      localObject = this.Q.getBaseActivity().getWindow().getDecorView();
      if (this.x)
      {
        localObject = this.aA;
        if (localObject != null) {
          ((SystemBarCompact)localObject).setStatusBarVisible(2, 0);
        }
        this.Q.getBaseActivity().getWindow().setFlags(1024, 1024);
        LiuHaiUtils.h(this.Q.getBaseActivity());
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(this.Q.getBaseActivity());
      }
      else
      {
        SystemBarCompact localSystemBarCompact = this.aA;
        if (localSystemBarCompact != null) {
          localSystemBarCompact.setStatusBarVisible(0, 10);
        }
        this.Q.getBaseActivity().getWindow().clearFlags(1024);
        LiuHaiUtils.g(this.Q.getBaseActivity());
        ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFFFFD);
      }
    }
    localObject = this.U;
    if (localObject != null) {
      ((VideoNextFeedsView)localObject).setUIState(paramBoolean, this.av);
    }
    f(this.x);
  }
  
  private void setHideViewVisible(int paramInt)
  {
    Object localObject = this.A;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.A.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        if (localView != null) {
          localView.setVisibility(paramInt);
        }
      }
    }
  }
  
  private void setState(int paramInt)
  {
    this.ay = paramInt;
  }
  
  protected void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  protected void a(long paramLong1, long paramLong2) {}
  
  protected void a(Context paramContext, View paramView)
  {
    D();
    A();
  }
  
  protected void a(Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.o;
    if (localImageView != null)
    {
      int i;
      if (paramBoolean) {
        i = 2130839132;
      } else {
        i = 2130839131;
      }
      localImageView.setImageResource(i);
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.y = paramArrayOfInt;
    paramArrayOfInt = this.M;
    if (paramArrayOfInt != null)
    {
      int[] arrayOfInt = this.y;
      int i;
      if (arrayOfInt[0] > arrayOfInt[1]) {
        i = 25;
      } else {
        i = 12;
      }
      paramArrayOfInt.setMaxEms(i);
    }
  }
  
  protected void b(long paramLong1, long paramLong2) {}
  
  public void b(boolean paramBoolean)
  {
    VideoNextFeedsView localVideoNextFeedsView = this.U;
    if (localVideoNextFeedsView != null) {
      localVideoNextFeedsView.a(paramBoolean);
    }
  }
  
  public void c(View paramView)
  {
    this.A.add(paramView);
  }
  
  public void d(View paramView)
  {
    B.put(paramView, Integer.valueOf(paramView.getVisibility()));
  }
  
  public void e()
  {
    if (getSuperPlayer() != null)
    {
      setState(5);
      if ((this.d) && (this.aj > 0L))
      {
        this.ai -= System.currentTimeMillis() - this.aj;
        this.aj = 0L;
      }
      this.d = false;
      super.e();
      Object localObject = this.af;
      if (localObject != null) {
        ((IVideoOuterStatusListener)localObject).onVideoStart((int)getSuperPlayer().getDurationMs());
      }
      localObject = this.n;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130839129);
      }
    }
  }
  
  public void g()
  {
    super.g();
    I();
    Object localObject = this.A;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = ak;
    if (localObject != null) {
      ((SparseBooleanArray)localObject).clear();
    }
    localObject = B;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    localArrayList.add(CommentListShowStateEvent.class);
    localArrayList.add(SharePanelShowStateEvent.class);
    return localArrayList;
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    return this.aC;
  }
  
  protected int getLayoutId()
  {
    return 2131624402;
  }
  
  public SeekBar getProgressBar()
  {
    return this.aD;
  }
  
  public void h()
  {
    if (getSuperPlayer() != null)
    {
      setState(7);
      super.h();
      this.d = true;
      this.aj = System.currentTimeMillis();
      ImageView localImageView = this.n;
      if (localImageView != null) {
        localImageView.setImageResource(2130839130);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != -1001)
    {
      if (i != 2)
      {
        if (i != 3) {
          return false;
        }
        paramMessage = this.N;
        if (paramMessage != null)
        {
          paramMessage.setVisibility(8);
          return false;
        }
      }
      else
      {
        J();
        return false;
      }
    }
    else
    {
      if (this.C) {
        i = paramMessage.arg2 - paramMessage.arg1;
      } else {
        i = paramMessage.arg1;
      }
      int j = i / 1000;
      i = j / 60;
      j %= 60;
      if ((getSuperPlayer() != null) && (getSuperPlayer().getCurrentPositionMs() > getSuperPlayer().getDurationMs() / 2L) && (!this.aw)) {
        S();
      }
      if (!this.ag)
      {
        TextView localTextView = this.l;
        if (localTextView != null) {
          localTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        }
        if ((this.h != null) && (((Boolean)paramMessage.obj).booleanValue()))
        {
          this.h.a(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }), paramMessage.arg2, paramMessage.arg1);
          return false;
        }
      }
      else if ((this.af != null) && (((Boolean)paramMessage.obj).booleanValue()))
      {
        this.af.onVideoProgressUpdate(paramMessage.arg1);
      }
    }
    return false;
  }
  
  public void i()
  {
    I();
    setState(8);
    super.i();
  }
  
  protected void l()
  {
    super.l();
    if ((this.G) || (this.J))
    {
      this.H = 0;
      this.G = false;
    }
    int i = this.H;
    if (i > 120)
    {
      getMainHandler().sendEmptyMessage(2);
      return;
    }
    this.H = (i + 1);
  }
  
  protected void m() {}
  
  protected boolean n()
  {
    return true;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.ac = false;
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    getMainHandler().post(new VideoPlayerView.18(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.ac = true;
    VideoNextFeedsView localVideoNextFeedsView = this.U;
    if (localVideoNextFeedsView != null) {
      localVideoNextFeedsView.c();
    }
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super.onError(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
    getMainHandler().post(new VideoPlayerView.19(this, paramInt1));
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    super.onInfo(paramISuperPlayer, paramInt, paramLong1, paramLong2, paramObject);
    getMainHandler().post(new VideoPlayerView.20(this, paramInt));
    return false;
  }
  
  public void onNetworkChanged(String paramString1, String paramString2)
  {
    if (!"wifi".equals(paramString2)) {
      getMainHandler().post(new VideoPlayerView.21(this));
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FollowUpdateEvent))
    {
      paramSimpleBaseEvent = (FollowUpdateEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.followStatus == 0)
      {
        localObject = this.ab;
        if (localObject != null) {
          ((HashMap)localObject).remove(paramSimpleBaseEvent.useId);
        }
      }
      else
      {
        localObject = this.ab;
        if (localObject != null) {
          ((HashMap)localObject).put(paramSimpleBaseEvent.useId, Boolean.valueOf(true));
        }
      }
      Object localObject = this.L;
      if (localObject != null) {
        ((CertifiedAccountMeta.StFeed)localObject).poster.followState.set(paramSimpleBaseEvent.followStatus);
      }
    }
    else
    {
      if ((paramSimpleBaseEvent instanceof CommentListShowStateEvent))
      {
        this.az = ((CommentListShowStateEvent)paramSimpleBaseEvent).shown;
        return;
      }
      if ((paramSimpleBaseEvent instanceof SharePanelShowStateEvent)) {
        this.az = ((SharePanelShowStateEvent)paramSimpleBaseEvent).shown;
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    super.onStartTrackingTouch(paramSeekBar);
    this.J = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    super.onStopTrackingTouch(paramSeekBar);
    this.J = false;
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    super.onVideoPrepared(paramISuperPlayer);
    getMainHandler().post(new VideoPlayerView.17(this, paramISuperPlayer));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (w())
    {
      SubscribeVideoDetailFragment localSubscribeVideoDetailFragment = this.Q;
      if ((localSubscribeVideoDetailFragment != null) && (localSubscribeVideoDetailFragment.getBaseActivity() != null)) {
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(this.Q.getBaseActivity());
      }
    }
  }
  
  public boolean p()
  {
    if ((getSuperPlayer() != null) && (getPlayerVideoView() != null))
    {
      if (w()) {
        U();
      }
      ThreadManager.getUIHandler().postDelayed(new VideoPlayerView.8(this), 500L);
      return true;
    }
    QLog.d("VideoPlayerView", 4, "enterFloat to early, player is not init");
    return false;
  }
  
  public boolean q()
  {
    return this.ag;
  }
  
  public void r()
  {
    this.af = ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(new VideoPlayerView.9(this));
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFullScreenViewClickListener(new VideoPlayerView.10(this));
    String str = ((IFloatingWrapperManager)QRoute.api(IFloatingWrapperManager.class)).getFloatingVideoWrapperName();
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setWindowClickListener(str, new VideoPlayerView.11(this));
  }
  
  public boolean s()
  {
    return (getSuperPlayer() != null) && (getSuperPlayer().isPlaying());
  }
  
  public void setCleanMode(boolean paramBoolean)
  {
    this.ad = paramBoolean;
    View localView = this.t;
    if (localView != null)
    {
      int i;
      if (paramBoolean) {
        i = 8;
      } else {
        i = 0;
      }
      localView.setVisibility(i);
    }
  }
  
  public void setContinueFeeds(List<CertifiedAccountMeta.StFeed> paramList)
  {
    if (paramList != null)
    {
      VideoNextFeedsView localVideoNextFeedsView = this.U;
      if (localVideoNextFeedsView != null) {
        localVideoNextFeedsView.setData(paramList);
      }
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.aC = paramExtraTypeInfo;
  }
  
  public void setHostFragment(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment)
  {
    this.Q = paramSubscribeVideoDetailFragment;
    if (this.Q.getBaseActivity() != null)
    {
      this.aA = ((PublicFragmentActivity)this.Q.getBaseActivity()).mSystemBarComp;
      this.aB = LiuHaiUtils.e(this.Q.getBaseActivity());
    }
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    if (getSuperPlayer() != null) {
      getSuperPlayer().setLoopback(paramBoolean);
    }
  }
  
  public void setNeedWifiTips(boolean paramBoolean)
  {
    this.T = paramBoolean;
  }
  
  public void setNextVideoClickListener(View.OnClickListener paramOnClickListener)
  {
    ImageView localImageView = this.p;
    if (localImageView != null) {
      localImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOutPutMute(boolean paramBoolean)
  {
    if (getSuperPlayer() != null) {
      getSuperPlayer().setOutputMute(paramBoolean);
    }
  }
  
  public void setPreviewVideoClickListener(View.OnClickListener paramOnClickListener)
  {
    ImageView localImageView = this.o;
    if (localImageView != null) {
      localImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setRevertProgress(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public void setVideoFeeds(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    this.L = paramStFeed;
    setVideoPath(paramStFeed.video.fileId.get(), paramStFeed.video.playUrl.get());
    if (this.O != null) {
      SubImageLoader.a(paramStFeed.poster.icon.get(), this.O);
    }
    paramStFeed = this.M;
    if (paramStFeed != null) {
      paramStFeed.setText(this.L.title.get());
    }
  }
  
  public void setVideoPath(String paramString1, String paramString2)
  {
    G();
    H();
    VSReporter.b();
    String str = paramString1;
    Object localObject = paramString2;
    if (!StringUtil.isEmpty(paramString2))
    {
      str = paramString1;
      localObject = paramString2;
      if (a(paramString2))
      {
        localObject = Uri.parse(paramString2);
        paramString2 = paramString1;
        if (localObject != null)
        {
          ((Uri)localObject).getQueryParameter("playerformat");
          paramString2 = paramString1;
          if (StringUtil.isEmpty(paramString1)) {
            paramString2 = ((Uri)localObject).getQueryParameter("vid");
          }
        }
        localObject = null;
        str = paramString2;
      }
    }
    if (localObject != null) {
      this.ao = ((String)localObject);
    } else {
      this.ao = str;
    }
    K();
    this.J = true;
    super.setVideoPath(str, (String)localObject, 0);
    this.ae = System.currentTimeMillis();
    VSReporter.a("subscribe_account_video_start_play", VSReporter.a(VSReporter.a(0L, 0L, this.ao, 0L)));
    VSReporter.a("subscribe_account_video_start_download", VSReporter.a(VSReporter.a(0L, 0L, this.ao, 0L)));
    this.ai = System.currentTimeMillis();
  }
  
  public void setVideoViewCover(String paramString)
  {
    if (this.s != null)
    {
      this.E = paramString;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130842939);
        localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130842939);
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if (paramString != null)
        {
          this.s.setImageDrawable(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setWifiAutoPlay(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public void t()
  {
    super.e();
  }
  
  public boolean u()
  {
    return this.av;
  }
  
  public boolean v()
  {
    if (this.x)
    {
      U();
      return true;
    }
    return false;
  }
  
  public boolean w()
  {
    return this.x;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView
 * JD-Core Version:    0.7.0.1
 */