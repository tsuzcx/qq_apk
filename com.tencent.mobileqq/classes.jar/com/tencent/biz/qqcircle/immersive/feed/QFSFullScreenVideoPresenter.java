package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenCloseEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.widget.BaseVideoView.InitListener;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.TimeUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity.Builder;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.Map;

public class QFSFullScreenVideoPresenter
  implements View.OnClickListener
{
  private boolean A = false;
  private FeedCloudMeta.StFeed a;
  private QFSVideoView b;
  private URLImageView c;
  private SeekBar d;
  private View e;
  private FrameLayout f;
  private LinearLayout g;
  private TextView h;
  private TextView i;
  private FrameLayout j;
  private RelativeLayout k;
  private TextView l;
  private TextView m;
  private ImageView n;
  private QCircleAsyncTextView o;
  private TextView p;
  private QCircleAvatarView q;
  private ImageView r;
  private LinearLayout s;
  private LinearLayout t;
  private QFSPlusFollowView u;
  private View v;
  private int w;
  private int x;
  private int y;
  private boolean z = true;
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)((URLImageView)localObject).getLayoutParams();
      if (localObject != null)
      {
        ((FrameLayout.LayoutParams)localObject).width = paramInt1;
        ((FrameLayout.LayoutParams)localObject).height = paramInt2;
        ((FrameLayout.LayoutParams)localObject).gravity = 17;
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void a(View paramView, String paramString)
  {
    if ((this.a != null) && (paramView != null) && (!TextUtils.isEmpty(paramString)))
    {
      Map localMap = new QCircleDTParamBuilder().buildElementParams();
      localMap.putAll(QCirclePluginReportUtil.a(this.a));
      localMap.put("xsj_feed_index", Integer.valueOf(this.y + 1));
      localMap.put("xsj_target_qq", this.a.poster.id.get());
      localMap.put("xsj_action_type", "follow");
      VideoReport.reportEvent(paramString, paramView, localMap);
      return;
    }
    QLog.d("QFSFullScreenVideoPresenter", 1, "dtReportCustomReport : mFeedData , view or eventId is null. ");
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    if (paramLinearLayout == null)
    {
      QLog.d("QFSFullScreenVideoPresenter", 1, "set animation error, authorLayout is null. ");
      return;
    }
    LayoutTransition localLayoutTransition = new LayoutTransition();
    localLayoutTransition.setDuration(400L);
    paramLinearLayout.setLayoutTransition(localLayoutTransition);
  }
  
  private void a(SeekBar paramSeekBar)
  {
    a(false, paramSeekBar);
  }
  
  private void a(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    paramSeekBar = this.i;
    if ((paramSeekBar != null) && (paramBoolean))
    {
      RFWTypefaceUtil.a(paramSeekBar, false);
      paramSeekBar = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TimeUtils.a(paramInt));
      localStringBuilder.append(" / ");
      paramSeekBar.setText(localStringBuilder.toString());
    }
  }
  
  private void a(@NonNull QFSPlusFollowView paramQFSPlusFollowView)
  {
    paramQFSPlusFollowView.setItemReportListener(new QFSFullScreenVideoPresenter.6(this, paramQFSPlusFollowView));
  }
  
  private void a(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("QFSFullScreenVideoPresenter", 1, "doOnVideoPrepare");
    b(0);
    RFThreadManager.getUIHandler().post(new QFSFullScreenVideoPresenter.4(this, paramISuperPlayer));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.z)
    {
      QFSVideoView localQFSVideoView = this.b;
      if (localQFSVideoView == null) {
        return;
      }
      if (localQFSVideoView.getSuperPlayer() == null)
      {
        b(paramBoolean);
        return;
      }
      if (this.b.getSuperPlayer().isPlaying())
      {
        b(1);
        return;
      }
      if (this.b.getSuperPlayer().isPausing())
      {
        b(0);
        return;
      }
      b(paramBoolean);
    }
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private void a(boolean paramBoolean, SeekBar paramSeekBar)
  {
    if ((this.g != null) && (paramSeekBar != null) && (this.k != null))
    {
      if (this.s == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTrackTouchView, trackState = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("QFSFullScreenVideoPresenter", 1, localStringBuilder.toString());
      if (paramBoolean)
      {
        this.g.setVisibility(0);
        paramSeekBar.setThumb(paramSeekBar.getContext().getResources().getDrawable(2130845108));
        this.k.setVisibility(8);
        this.s.setVisibility(8);
        return;
      }
      this.g.setVisibility(8);
      paramSeekBar.setThumb(paramSeekBar.getContext().getResources().getDrawable(2130845107));
      this.k.setVisibility(0);
      this.s.setVisibility(0);
    }
  }
  
  private void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("change play status to = ");
    localStringBuilder.append(paramInt);
    QLog.d("QFSFullScreenVideoPresenter", 1, localStringBuilder.toString());
    RFThreadManager.getUIHandler().post(new QFSFullScreenVideoPresenter.1(this, paramInt));
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)((QFSVideoView)localObject).getLayoutParams();
      if (localObject != null)
      {
        ((FrameLayout.LayoutParams)localObject).width = paramInt1;
        ((FrameLayout.LayoutParams)localObject).height = paramInt2;
        ((FrameLayout.LayoutParams)localObject).gravity = 17;
        this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void b(View paramView)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((FeedCloudMeta.StFeed)localObject).poster != null))
    {
      localObject = new QCircleInitBean();
      ((QCircleInitBean)localObject).setUser((FeedCloudMeta.StUser)this.a.poster.get());
      QCircleLauncher.b(paramView.getContext(), (QCircleInitBean)localObject);
    }
  }
  
  private void b(SeekBar paramSeekBar)
  {
    a(true, paramSeekBar);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (this.a == null) {
        return;
      }
      QLog.d("QFSFullScreenVideoPresenter", 1, "startANewPlayer");
      QFSVideoView localQFSVideoView = this.b;
      FeedCloudMeta.StFeed localStFeed = this.a;
      int i1 = 0;
      localQFSVideoView.setData(localStFeed, 0);
      if (paramBoolean == true) {
        i1 = this.w;
      }
      this.b.setInitListener(l());
      this.b.setVideoPath(this.a.video, i1);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (this.v != null)
    {
      if (!QCirclePluginConfig.I()) {
        return;
      }
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.v.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = paramInt1;
        localLayoutParams.height = paramInt2;
        localLayoutParams.gravity = 17;
        this.v.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("change view status to = ");
    localStringBuilder.append(paramBoolean);
    QLog.d("QFSFullScreenVideoPresenter", 1, localStringBuilder.toString());
    RFThreadManager.getUIHandler().post(new QFSFullScreenVideoPresenter.2(this, paramBoolean));
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == this.w) && (this.x == paramInt1)) {
      return;
    }
    TextView localTextView = this.l;
    if (localTextView == null) {
      return;
    }
    this.w = paramInt2;
    this.x = paramInt1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TimeUtils.a(paramInt2));
    localStringBuilder.append(" / ");
    localTextView.setText(localStringBuilder.toString());
  }
  
  private void e()
  {
    if (this.c != null)
    {
      Object localObject = this.a;
      if ((localObject != null) && (((FeedCloudMeta.StFeed)localObject).cover != null))
      {
        if (this.a.cover.picUrl == null) {
          return;
        }
        localObject = new Option().setUrl(this.a.cover.picUrl.get()).setTargetView(this.c);
        QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
      }
    }
  }
  
  private void f()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (((FeedCloudMeta.StFeed)localObject).id != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("feed id = ");
      ((StringBuilder)localObject).append(this.a.id.get());
      QLog.d("QFSFullScreenVideoPresenter", 1, ((StringBuilder)localObject).toString());
    }
    if ((this.p != null) && (this.a.poster != null) && (this.a.poster.nick != null) && (!TextUtils.isEmpty(this.a.poster.nick.get())))
    {
      this.p.setText(this.a.poster.nick.get());
    }
    else
    {
      localObject = this.p;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    if ((this.o != null) && (this.a.content != null) && (!TextUtils.isEmpty(this.a.content.get())))
    {
      this.o.setText(this.a.content.get());
    }
    else
    {
      localObject = this.o;
      if (localObject != null) {
        ((QCircleAsyncTextView)localObject).setVisibility(8);
      }
    }
    if ((this.q != null) && (this.a.poster != null)) {
      this.q.setUser(this.a.poster);
    }
    if ((this.u != null) && (this.a.poster != null))
    {
      this.u.setUserData((FeedCloudMeta.StUser)this.a.poster.get(), this.a);
      this.u.setFollowedDismiss(true);
    }
  }
  
  private void g()
  {
    if (this.b == null) {
      return;
    }
    QLog.d("QFSFullScreenVideoPresenter", 1, "releasePlayer");
    VideoReport.unbindVideoPlayerInfo(this.b);
    this.b.release();
    c(false);
  }
  
  private void h()
  {
    FeedCloudMeta.StFeed localStFeed = this.a;
    if (localStFeed != null)
    {
      if (localStFeed.cover == null) {
        return;
      }
      int i3 = this.a.cover.height.get();
      int i4 = this.a.cover.width.get();
      int i1 = ImmersiveUtils.c();
      int i2 = ImmersiveUtils.b();
      float f2 = i1;
      float f1 = i4;
      f2 /= f1;
      float f3 = i3;
      i3 = (int)(f2 * f3);
      if (i3 > i2) {
        i1 = (int)(i2 / f3 * f1);
      } else {
        i2 = i3;
      }
      b(i1, i2);
      a(i1, i2);
      c(i1, i2);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void i()
  {
    this.f.setOnTouchListener(new QFSFullScreenVideoPresenter.3(this));
  }
  
  private void j()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (this.a == null) {
        return;
      }
      VideoReport.setElementId(localObject, "em_xsj_multimedia");
      localObject = new QCircleDTParamBuilder().buildElementParams();
      ((Map)localObject).putAll(QCirclePluginReportUtil.a(this.a));
      ((Map)localObject).put("xsj_feed_index", Integer.valueOf(this.y + 1));
      ((Map)localObject).put("xsj_custom_pgid", "pg_xsj_full_screen_page");
      localObject = new VideoEntity.Builder().setContentId(this.a.id.get()).setPage("pg_xsj_full_screen_page").setContentType(2).setVideoDuration(this.a.video.duration.get()).setVideoView(this.b).addCustomParams((Map)localObject).ignoreReport(false).bizReady(true).build();
      VideoReport.bindVideoPlayerInfo(this.b, (VideoEntity)localObject);
    }
  }
  
  private void k()
  {
    if ((this.a != null) && (this.q != null))
    {
      if (this.p == null) {
        return;
      }
      Map localMap = new QCircleDTParamBuilder().buildElementParams();
      localMap.putAll(QCirclePluginReportUtil.a(this.a));
      localMap.put("xsj_feed_index", Integer.valueOf(this.y + 1));
      VideoReport.setElementId(this.q, "em_xsj_author_avatar");
      VideoReport.setElementParams(this.q, localMap);
      VideoReport.setElementId(this.p, "em_xsj_author_name");
      VideoReport.setElementParams(this.p, localMap);
    }
  }
  
  private BaseVideoView.InitListener l()
  {
    return new QFSFullScreenVideoPresenter.5(this);
  }
  
  public long a()
  {
    return this.w;
  }
  
  public void a(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void a(@NonNull View paramView)
  {
    this.v = paramView;
    this.b = ((QFSVideoView)paramView.findViewById(2131441988));
    this.c = ((URLImageView)paramView.findViewById(2131441982));
    this.n = ((ImageView)paramView.findViewById(2131441980));
    this.d = ((SeekBar)paramView.findViewById(2131441983));
    this.e = paramView.findViewById(2131441987);
    this.f = ((FrameLayout)paramView.findViewById(2131441970));
    this.g = ((LinearLayout)paramView.findViewById(2131441978));
    this.h = ((TextView)paramView.findViewById(2131441986));
    this.i = ((TextView)paramView.findViewById(2131441985));
    this.j = ((FrameLayout)paramView.findViewById(2131441984));
    this.k = ((RelativeLayout)paramView.findViewById(2131441977));
    this.l = ((TextView)paramView.findViewById(2131441989));
    this.m = ((TextView)paramView.findViewById(2131441991));
    this.o = ((QCircleAsyncTextView)paramView.findViewById(2131441976));
    this.p = ((TextView)paramView.findViewById(2131441973));
    this.q = ((QCircleAvatarView)paramView.findViewById(2131441975));
    this.r = ((ImageView)paramView.findViewById(2131441974));
    this.s = ((LinearLayout)paramView.findViewById(2131441990));
    this.t = ((LinearLayout)paramView.findViewById(2131441972));
    this.u = ((QFSPlusFollowView)paramView.findViewById(2131441971));
    this.n.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.p.setOnClickListener(this);
    a(this.u);
    a(this.t);
    this.o.setSpecialClickAreaColor(2131168464);
  }
  
  public void a(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    this.a = paramStFeed;
    f();
    h();
    e();
    c(false);
    i();
    k();
  }
  
  public void a(Long paramLong)
  {
    this.w = paramLong.intValue();
  }
  
  public void b()
  {
    QLog.d("QFSFullScreenVideoPresenter", 1, "onResume");
    this.z = true;
    a(true);
  }
  
  public void c()
  {
    QLog.d("QFSFullScreenVideoPresenter", 1, "onStop");
    this.z = false;
    g();
  }
  
  public void d()
  {
    FrameLayout localFrameLayout = this.j;
    if (localFrameLayout != null)
    {
      if (this.k == null) {
        return;
      }
      if (!this.A)
      {
        localFrameLayout.setVisibility(8);
        this.k.setVisibility(8);
        this.A = true;
        return;
      }
      localFrameLayout.setVisibility(0);
      this.k.setVisibility(0);
      this.A = false;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      if (paramView.getId() == 2131441974)
      {
        SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenCloseEvent());
      }
      else if (paramView.getId() == 2131441980)
      {
        a(true);
      }
      else if ((paramView.getId() == 2131441972) || (paramView.getId() == 2131441973) || (paramView.getId() == 2131441975))
      {
        b(paramView);
        SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenCloseEvent());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter
 * JD-Core Version:    0.7.0.1
 */