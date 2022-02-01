package com.tencent.biz.qqcircle.immersive.feed;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._TVK_PlayerMsg;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoControlEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoCurrentTimeEvent;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSTouchBean;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBaseFeedPresenterEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSTapClickEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoProgressChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoReplayEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoStatusEvent;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.immersive.utils.QFSCommonUtil;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.widget.BaseVideoView.InitListener;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.qqcircle.utils.QCircleSplashUtils;
import com.tencent.biz.qqcircle.utils.TimeUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity.Builder;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QFSFeedChildVideoPresenter
  extends QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
{
  private boolean A = true;
  private boolean B;
  private QFSVideoProgressChangeEvent C = null;
  private QFSVideoView i;
  private ImageView j;
  private SeekBar k;
  private View l;
  private FrameLayout m;
  private LinearLayout n;
  private TextView o;
  private TextView p;
  private ImageView q;
  private FrameLayout r;
  private View s;
  private View t;
  private int u;
  private int v;
  private QFSVideoReplayEvent w = null;
  private int x;
  private int y;
  private ConcurrentHashMap<String, Long> z = new ConcurrentHashMap();
  
  private BaseVideoView.InitListener a(String paramString)
  {
    return new QFSFeedChildVideoPresenter.3(this, paramString);
  }
  
  private void a(int paramInt)
  {
    if (this.t != null)
    {
      if (this.c == null) {
        return;
      }
      if (((FeedCloudMeta.StFeed)this.c).video.orientation.get() == 2) {
        try
        {
          this.t.setVisibility(0);
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.t.getLayoutParams();
          int i1 = ImmersiveUtils.getStatusBarHeight(this.t.getContext());
          localLayoutParams.topMargin = ((DisplayUtil.a((Activity)this.t.getContext()) + paramInt - i1) / 2);
          this.t.setLayoutParams(localLayoutParams);
          return;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("update full screen view status error, msg = ");
          localStringBuilder.append(localException.getMessage());
          QLog.e("QFSFeedChildVideoPresenter", 1, localStringBuilder.toString());
          this.t.setVisibility(8);
          return;
        }
      }
      this.t.setVisibility(8);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      return;
    }
    int i2 = this.b.getHeight();
    int i1 = i2;
    if (i2 == 0)
    {
      View localView = ((Activity)this.b.getContext()).findViewById(2131444762);
      i1 = i2;
      if (localView != null) {
        i1 = localView.getHeight();
      }
    }
    if (i1 > 0) {
      b((int)(i1 * (paramInt1 / paramInt2)), i1);
    }
    a(this.i, -1, -1);
  }
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, String paramString)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setExt1(paramString).setPageId(f()).setfpageid(Integer.valueOf(h()).intValue()));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_QFSFeedChildVideoPresenter", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt2 == this.u) && (this.v == paramInt1)) {
      return;
    }
    Long localLong = (Long)this.z.get(paramString);
    if (localLong != null)
    {
      long l1 = paramInt1;
      if ((l1 == localLong.longValue()) || (Math.abs(l1 - localLong.longValue()) <= 100L)) {}
    }
    else
    {
      this.z.put(paramString, Long.valueOf(paramInt2));
    }
    this.u = paramInt2;
    this.v = paramInt1;
    if (this.C == null) {
      this.C = new QFSVideoProgressChangeEvent();
    }
    this.C.b(paramInt1);
    this.C.a(paramInt2);
    b(this.C);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 0) && (paramInt1 != 0))
    {
      int i1 = ImmersiveUtils.getScreenWidth();
      int i2 = -1;
      if ((paramInt1 == -1) && (paramInt2 == -1)) {
        i1 = -1;
      } else {
        i2 = (int)(i1 / paramInt1 * paramInt2);
      }
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new FrameLayout.LayoutParams(i1, i2);
      }
      localLayoutParams1.width = i1;
      localLayoutParams1.height = i2;
      localLayoutParams1.gravity = 17;
      paramView.setLayoutParams(localLayoutParams1);
      a(i2);
      paramView = new StringBuilder();
      paramView.append("setSize origin:");
      paramView.append(paramInt1);
      paramView.append("|");
      paramView.append(paramInt2);
      paramView.append(" target:");
      paramView.append(i1);
      paramView.append("|");
      paramView.append(i2);
      paramView.append("|");
      paramView.append(hashCode());
      QLog.d("QFSFeedChildVideoPresenter", 1, paramView.toString());
      return;
    }
    QLog.d("QFSFeedChildVideoPresenter", 1, "setSize origin size zero");
  }
  
  private void a(SeekBar paramSeekBar)
  {
    this.B = false;
    this.n.setVisibility(8);
    paramSeekBar.getLayoutParams().height = ImmersiveUtils.dpToPx(2.0F);
    paramSeekBar.requestLayout();
    SimpleEventBus localSimpleEventBus = SimpleEventBus.getInstance();
    if (this.c == null) {
      paramSeekBar = "";
    } else {
      paramSeekBar = ((FeedCloudMeta.StFeed)this.c).id.get();
    }
    localSimpleEventBus.dispatchEvent(new QFSSeekEvent(paramSeekBar, false));
  }
  
  private void a(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    paramSeekBar = this.p;
    if ((paramSeekBar != null) && (paramBoolean))
    {
      RFWTypefaceUtil.a(paramSeekBar, false);
      paramSeekBar = this.p;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TimeUtils.a(paramInt));
      localStringBuilder.append(" / ");
      paramSeekBar.setText(localStringBuilder.toString());
    }
  }
  
  private void a(QCircleFeedVideoControlEvent paramQCircleFeedVideoControlEvent)
  {
    if (!paramQCircleFeedVideoControlEvent.isPlay()) {
      return;
    }
    c(false);
  }
  
  private void a(QCircleFeedVideoCurrentTimeEvent paramQCircleFeedVideoCurrentTimeEvent)
  {
    if ((this.c != null) && (((FeedCloudMeta.StFeed)this.c).video != null) && (((FeedCloudMeta.StFeed)this.c).video.playUrl != null))
    {
      if (paramQCircleFeedVideoCurrentTimeEvent == null) {
        return;
      }
      String str = QFSCommonUtil.b(((FeedCloudMeta.StFeed)this.c).video.playUrl.get());
      if ((!TextUtils.isEmpty(str)) && (this.z.containsKey(str))) {
        this.z.replace(str, Long.valueOf(paramQCircleFeedVideoCurrentTimeEvent.getCurrentTime()));
      }
    }
  }
  
  private void a(ISuperPlayer paramISuperPlayer)
  {
    if (!s()) {
      return;
    }
    if (this.i != null)
    {
      if (this.c == null) {
        return;
      }
      if (QCirclePluginUtil.b(((FeedCloudMeta.StFeed)this.c).video.width.get(), ((FeedCloudMeta.StFeed)this.c).video.height.get())) {
        paramISuperPlayer.setXYaxis(QCircleHostConstants._TVK_PlayerMsg.PLAYER_SCALE_Y_FULLSCREEN());
      } else {
        paramISuperPlayer.setXYaxis(QCircleHostConstants._TVK_PlayerMsg.PLAYER_SCALE_ORIGINAL_FULLSCREEN());
      }
      u();
      this.i.h();
      RFThreadManager.getUIHandler().post(new QFSFeedChildVideoPresenter.4(this, paramISuperPlayer));
      this.x = ((int)paramISuperPlayer.getDurationMs());
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    Object localObject = this.j;
    if (localObject == null) {
      return;
    }
    localObject = (FrameLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    if (localObject != null)
    {
      ((FrameLayout.LayoutParams)localObject).width = paramInt1;
      ((FrameLayout.LayoutParams)localObject).height = paramInt2;
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void b(SeekBar paramSeekBar)
  {
    this.B = true;
    this.n.setVisibility(0);
    paramSeekBar.getLayoutParams().height = ImmersiveUtils.dpToPx(4.0F);
    paramSeekBar.requestLayout();
    SimpleEventBus localSimpleEventBus = SimpleEventBus.getInstance();
    if (this.c == null) {
      paramSeekBar = "";
    } else {
      paramSeekBar = ((FeedCloudMeta.StFeed)this.c).id.get();
    }
    localSimpleEventBus.dispatchEvent(new QFSSeekEvent(paramSeekBar, true));
  }
  
  private void b(String paramString)
  {
    if (this.c != null)
    {
      if (!((FeedCloudMeta.StFeed)this.c).id.get().equals(paramString)) {
        return;
      }
      paramString = this.i;
      if (paramString != null)
      {
        if (paramString.getSuperPlayer() == null) {
          return;
        }
        if (this.i.getSuperPlayer().isPlaying())
        {
          y();
          return;
        }
        if (this.i.getSuperPlayer().isPausing()) {
          z();
        }
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.b == null)
    {
      QLog.d("QFSFeedChildVideoPresenter", 1, "[hideVideoContainer] container should not be null.");
      return;
    }
    View localView = this.b;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
  }
  
  private void c(boolean paramBoolean)
  {
    if (q()) {
      return;
    }
    if (this.i.getSuperPlayer() == null)
    {
      d(paramBoolean);
      return;
    }
    if (!this.i.getSuperPlayer().isPlaying())
    {
      if (this.i.getSuperPlayer().isPausing()) {
        return;
      }
      d(paramBoolean);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.c;
    this.i.setData(localStFeed, this.d);
    Object localObject = QFSCommonUtil.b(localStFeed.video.playUrl.get());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append(" playUrlKey:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("|");
    localStringBuilder.append(this.z.containsKey(localObject));
    QLog.d("QFSFeedChildVideoPresenter", 1, localStringBuilder.toString());
    long l1;
    if ((paramBoolean) && (this.z.containsKey(localObject))) {
      l1 = ((Long)this.z.get(localObject)).longValue();
    } else {
      l1 = 0L;
    }
    localObject = a((String)localObject);
    this.i.setInitListener((BaseVideoView.InitListener)localObject);
    this.i.setVideoPath(localStFeed.video, (int)l1);
    this.q.setVisibility(8);
  }
  
  private void e(boolean paramBoolean)
  {
    ImageView localImageView = this.j;
    if (localImageView != null)
    {
      if (this.k == null) {
        return;
      }
      if (paramBoolean)
      {
        localImageView.setVisibility(8);
        this.k.setVisibility(0);
        return;
      }
      localImageView.setVisibility(0);
      this.k.setVisibility(8);
    }
  }
  
  private void k()
  {
    int i1 = ((FeedCloudMeta.StFeed)this.c).video.width.get();
    int i2 = ((FeedCloudMeta.StFeed)this.c).video.height.get();
    if (QCirclePluginUtil.a(i1, i2))
    {
      a(this.j, -1, -1);
      a(this.i, -1, -1);
      return;
    }
    if (QCirclePluginUtil.b(i1, i2))
    {
      a(i1, i2);
      return;
    }
    a(this.j, i1, i2);
    a(this.i, i1, i2);
  }
  
  private void l()
  {
    View localView = this.s;
    if (localView == null) {
      return;
    }
    localView.setVisibility(8);
  }
  
  private void m()
  {
    this.v = 0;
    this.u = 0;
    this.y = 0;
    this.x = 0;
  }
  
  private void n()
  {
    View localView = this.t;
    if (localView == null) {
      return;
    }
    localView.setOnClickListener(new QFSFeedChildVideoPresenter.1(this));
  }
  
  private void o()
  {
    if (this.j == null) {
      return;
    }
    Object localObject = (FeedCloudMeta.StFeed)this.c;
    if (TextUtils.isEmpty(((FeedCloudMeta.StFeed)localObject).cover.layerPicUrl.get())) {
      localObject = new Option().setUrl(((FeedCloudMeta.StFeed)localObject).cover.picUrl.get()).setTargetView(this.j);
    } else {
      localObject = new Option().setUrl(((FeedCloudMeta.StFeed)localObject).cover.layerPicUrl.get()).setTargetView(this.j);
    }
    ((Option)localObject).setLoadingDrawable(new ColorDrawable(QCircleSkinHelper.getInstance().getColor(2131167067)));
    QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
  }
  
  private void p()
  {
    QFSVideoView localQFSVideoView = this.i;
    if (localQFSVideoView == null) {
      return;
    }
    localQFSVideoView.setLoadingView(this.l);
    this.i.setProgressBar(this.k);
    this.m.setOnTouchListener(new QFSFeedChildVideoPresenter.2(this));
  }
  
  private boolean q()
  {
    if ((this.a != null) && (s()) && (this.i != null)) {
      return false;
    }
    QLog.d("QFSFeedChildVideoPresenter", 1, "canNotPlay");
    return true;
  }
  
  private void r()
  {
    if (q()) {
      return;
    }
    QLog.d("QFSFeedChildVideoPresenter", 1, "executeFromSelected");
    d(false);
  }
  
  private boolean s()
  {
    int i1 = this.a.bk_();
    int i2 = this.a.bl_();
    int i3 = this.a.d();
    boolean bool2 = ASInject.g().getAsEngineDelegate().isOnThirdTab("qcircle-app");
    if (this.a.e() != null) {
      localObject = this.a.e().getSchemeAttrs();
    } else {
      localObject = null;
    }
    boolean bool1;
    if ((localObject != null) && (String.valueOf(11).equals(((HashMap)localObject).get("key_jump_from")))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool3 = QCircleSplashUtils.a(this.a.e());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("currentFeedPos:");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(" | mPos:");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(" | currentSelectedTab:");
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(" | currentTabIndex:");
    ((StringBuilder)localObject).append(i3);
    ((StringBuilder)localObject).append(" | isOnThirdTab:");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(" pageId:");
    ((StringBuilder)localObject).append(f());
    ((StringBuilder)localObject).append("| mIsOnResume");
    ((StringBuilder)localObject).append(this.A);
    ((StringBuilder)localObject).append("| isFromBottom");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append("| isShowSplash");
    ((StringBuilder)localObject).append(bool3);
    ((StringBuilder)localObject).append(hashCode());
    QLog.d("QFSFeedChildVideoPresenter", 1, ((StringBuilder)localObject).toString());
    return (i1 == this.d) && (i2 == i3) && ((bool2) || (!QCirclePluginUtil.d()) || (!bool1)) && (this.A) && (!bool3);
  }
  
  private void t()
  {
    if (this.w == null) {
      this.w = new QFSVideoReplayEvent();
    }
    if (((this.x > 30000) && (this.y == 1)) || ((this.x <= 30000) && (this.y == 2))) {
      b(this.w);
    }
  }
  
  private void u()
  {
    if (this.i != null)
    {
      if (this.c == null) {
        return;
      }
      VideoReport.setElementId(this.i, "em_xsj_multimedia");
      Object localObject = new QCircleDTParamBuilder().buildElementParams();
      ((Map)localObject).putAll(QCirclePluginReportUtil.a(this.h));
      ((Map)localObject).put("xsj_feed_index", Integer.valueOf(this.d + 1));
      ((Map)localObject).put("xsj_custom_pgid", g());
      localObject = new VideoEntity.Builder().setContentId(((FeedCloudMeta.StFeed)this.c).id.get()).setPage(g()).setContentType(2).setVideoDuration(((FeedCloudMeta.StFeed)this.c).video.duration.get()).setVideoView(this.i).addCustomParams((Map)localObject).ignoreReport(false).bizReady(true).build();
      VideoReport.bindVideoPlayerInfo(this.i, (VideoEntity)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dtReportBindVideoData  pos = ");
      ((StringBuilder)localObject).append(this.d);
      QLog.i("QFSFeedChildVideoPresenter", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean v()
  {
    return false;
  }
  
  private void w()
  {
    QFSVideoView localQFSVideoView = this.i;
    if (localQFSVideoView == null) {
      return;
    }
    VideoReport.unbindVideoPlayerInfo(localQFSVideoView);
    this.i.release();
    e(false);
  }
  
  private boolean x()
  {
    return (this.c != null) && (((FeedCloudMeta.StFeed)this.c).type.get() == 3);
  }
  
  private void y()
  {
    QFSVideoView localQFSVideoView = this.i;
    if (localQFSVideoView != null)
    {
      if (localQFSVideoView.getSuperPlayer() == null) {
        return;
      }
      if (this.i.getSuperPlayer().isPlaying())
      {
        VideoReport.unbindVideoPlayerInfo(this.i);
        this.i.b();
        b(new QFSVideoStatusEvent(true));
        this.q.setVisibility(0);
      }
      a(2, 6, e(), "");
    }
  }
  
  private void z()
  {
    QFSVideoView localQFSVideoView = this.i;
    if (localQFSVideoView != null)
    {
      if (localQFSVideoView.getSuperPlayer() == null) {
        return;
      }
      if (this.i.getSuperPlayer().isPausing())
      {
        u();
        this.i.h();
        b(new QFSVideoStatusEvent(false));
        this.q.setVisibility(8);
      }
    }
  }
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.b = ((ViewStub)paramView.findViewById(2131441968)).inflate();
    this.i = ((QFSVideoView)this.b.findViewById(2131433405));
    this.j = ((ImageView)this.b.findViewById(2131433367));
    this.q = ((ImageView)this.b.findViewById(2131433371));
    this.k = ((SeekBar)paramView.findViewById(2131433386));
    this.l = paramView.findViewById(2131433403);
    this.m = ((FrameLayout)paramView.findViewById(2131433326));
    this.n = ((LinearLayout)paramView.findViewById(2131433376));
    this.o = ((TextView)paramView.findViewById(2131433399));
    this.p = ((TextView)paramView.findViewById(2131433398));
    this.r = ((FrameLayout)paramView.findViewById(2131442019));
    this.s = ((ViewStub)paramView.findViewById(2131441981)).inflate();
    this.t = this.s.findViewById(2131441979);
    p();
    n();
  }
  
  public void a(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.a(paramQFSFeedSelectInfo);
    this.A = true;
    if (this.i == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResumed:");
      localStringBuilder.append(paramQFSFeedSelectInfo);
      localStringBuilder.append(" | mPos:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" | ");
      localStringBuilder.append(hashCode());
      localStringBuilder.append("|playView is null");
      QLog.d("QFSFeedChildVideoPresenter", 1, localStringBuilder.toString());
      return;
    }
    if (paramQFSFeedSelectInfo == null) {
      return;
    }
    if (this.d == paramQFSFeedSelectInfo.b()) {
      c(true);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResumed:");
    localStringBuilder.append(paramQFSFeedSelectInfo);
    localStringBuilder.append(" | mPos:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" | ");
    localStringBuilder.append(hashCode());
    QLog.d("QFSFeedChildVideoPresenter", 1, localStringBuilder.toString());
  }
  
  protected void a(QFSBaseFeedPresenterEvent paramQFSBaseFeedPresenterEvent)
  {
    super.a(paramQFSBaseFeedPresenterEvent);
    if ((paramQFSBaseFeedPresenterEvent instanceof QFSTapClickEvent)) {
      b(((QFSTapClickEvent)paramQFSBaseFeedPresenterEvent).a());
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.c;
    super.a(paramStFeed, paramInt);
    if (paramStFeed.type.get() != 3)
    {
      b(false);
      l();
      return;
    }
    b(true);
    FrameLayout localFrameLayout = this.m;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(0);
    }
    localFrameLayout = this.r;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(8);
    }
    if (QFSCommonUtil.a(paramStFeed, localStFeed)) {
      return;
    }
    if (paramStFeed == null)
    {
      paramStFeed = new StringBuilder();
      paramStFeed.append("onBindData is null: ");
      paramStFeed.append(paramInt);
      QLog.d("QFSFeedChildVideoPresenter", 1, paramStFeed.toString());
      return;
    }
    m();
    paramStFeed = this.q;
    if (paramStFeed != null) {
      paramStFeed.setVisibility(8);
    }
    k();
    o();
    e(false);
  }
  
  public boolean a(QFSTouchBean paramQFSTouchBean)
  {
    super.a(paramQFSTouchBean);
    return this.B;
  }
  
  public void b(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.b(paramQFSFeedSelectInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPaused:");
    localStringBuilder.append(paramQFSFeedSelectInfo);
    localStringBuilder.append(" | mPos:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" | ");
    localStringBuilder.append(hashCode());
    QLog.d("QFSFeedChildVideoPresenter", 1, localStringBuilder.toString());
  }
  
  public void c()
  {
    super.c();
    QFSVideoView localQFSVideoView = this.i;
    if (localQFSVideoView != null) {
      localQFSVideoView.setReportBean(i());
    }
  }
  
  public void c(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.c(paramQFSFeedSelectInfo);
    this.A = false;
    w();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStop:");
    localStringBuilder.append(paramQFSFeedSelectInfo);
    localStringBuilder.append(" |  | mPos:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|playView is null");
    QLog.d("QFSFeedChildVideoPresenter", 1, localStringBuilder.toString());
  }
  
  public void d()
  {
    super.d();
  }
  
  public void d(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    if (paramQFSFeedSelectInfo == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSelected:");
    localStringBuilder.append(paramQFSFeedSelectInfo);
    localStringBuilder.append(" | mPos:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" | ");
    localStringBuilder.append(hashCode());
    QLog.d("QFSFeedChildVideoPresenter", 1, localStringBuilder.toString());
    if (paramQFSFeedSelectInfo.b() != this.d) {
      return;
    }
    r();
  }
  
  public void e(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    if (paramQFSFeedSelectInfo == null) {
      return;
    }
    if (paramQFSFeedSelectInfo.b() != this.d) {
      return;
    }
    if (paramQFSFeedSelectInfo.a() == 1) {
      this.d = -1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUnSelected:");
    localStringBuilder.append(paramQFSFeedSelectInfo);
    localStringBuilder.append(" | mPos:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" | ");
    localStringBuilder.append(hashCode());
    QLog.d("QFSFeedChildVideoPresenter", 1, localStringBuilder.toString());
    w();
  }
  
  public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(QCircleFeedVideoControlEvent.class);
    localArrayList.add(QCircleFeedVideoCurrentTimeEvent.class);
    return localArrayList;
  }
  
  public void j()
  {
    super.j();
    if (x()) {
      a(1, 1, e(), "2");
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QCircleFeedVideoControlEvent))
    {
      a((QCircleFeedVideoControlEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleFeedVideoCurrentTimeEvent)) {
      a((QCircleFeedVideoCurrentTimeEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter
 * JD-Core Version:    0.7.0.1
 */