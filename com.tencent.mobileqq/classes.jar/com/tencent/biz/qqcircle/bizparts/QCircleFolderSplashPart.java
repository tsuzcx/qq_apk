package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoControlEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVoiceEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller;
import com.tencent.biz.qqcircle.utils.QCircleABTestUtils;
import com.tencent.biz.qqcircle.utils.QCircleAvatarListUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.viewmodels.QCircleSplashViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.qqcircle.widgets.QCircleSplashPYMKRecommendWidget;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.io.IOException;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StNewUserPymkPageData;

public class QCircleFolderSplashPart
  extends QCircleBasePart
  implements TextureView.SurfaceTextureListener
{
  private View a;
  private ViewStub c;
  private ViewGroup d;
  private ViewGroup e;
  private boolean f;
  private TextureView g;
  private MediaPlayer h;
  private Button i;
  private boolean j = false;
  private int k;
  private int l;
  private URLImageView m;
  private URLImageView n;
  private QCircleSplashViewModel o;
  private View p;
  private URLImageView q;
  private boolean r;
  private QCircleFolderBean s;
  private int t = 0;
  
  private void A()
  {
    View localView = this.e.findViewById(2131441728);
    if (localView != null)
    {
      Object localObject = localView.getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        float f1;
        if (this.r) {
          f1 = 44.0F;
        } else {
          f1 = 18.0F;
        }
        ((RelativeLayout.LayoutParams)localObject).topMargin = ViewUtils.a(f1);
      }
      localView.setVisibility(0);
      localView.setOnClickListener(new QCircleFolderSplashPart.10(this));
    }
  }
  
  private void B()
  {
    FrameLayout localFrameLayout = (FrameLayout)this.e.findViewById(2131441838);
    QCircleSplashPYMKRecommendWidget localQCircleSplashPYMKRecommendWidget = new QCircleSplashPYMKRecommendWidget(g());
    localQCircleSplashPYMKRecommendWidget.setSplashRecommendPageId(M());
    localQCircleSplashPYMKRecommendWidget.bindData(new FeedBlockData((FeedCloudMeta.StFeed)this.o.b().vecFeed.get().get(0)), 0);
    localFrameLayout.addView(localQCircleSplashPYMKRecommendWidget);
  }
  
  private void H()
  {
    if (this.i.getVisibility() != 0)
    {
      this.i.setVisibility(0);
      this.i.setOnClickListener(new QCircleFolderSplashPart.11(this));
    }
  }
  
  private void I()
  {
    QLog.d("QCircleFolderSplashPart", 1, "release...");
    Object localObject = this.h;
    if (localObject != null)
    {
      ((MediaPlayer)localObject).release();
      this.h = null;
    }
    localObject = this.d;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(8);
    }
  }
  
  private void J()
  {
    I();
    QLog.d("QCircleFolderSplashPart", 1, "hideSpashView");
    QCirclePluginConfig.a().i();
  }
  
  private boolean K()
  {
    return (("10".equals(this.s.getLaunchFrom())) || ("8".equals(this.s.getLaunchFrom()))) && (!TextUtils.isEmpty(this.s.getUin()));
  }
  
  private void L()
  {
    ViewGroup localViewGroup = this.e;
    if (localViewGroup != null)
    {
      localViewGroup.setVisibility(8);
      o();
      b(false);
      p();
    }
  }
  
  private int M()
  {
    int i1 = this.t;
    if (i1 == 1) {
      return 86;
    }
    if (i1 == 2) {
      return 90;
    }
    return 82;
  }
  
  private void a(Context paramContext)
  {
    if (K())
    {
      QCircleInitBean localQCircleInitBean = new QCircleInitBean();
      localQCircleInitBean.setUin(this.s.getUin());
      QCircleLauncher.b(paramContext, localQCircleInitBean);
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(62).setSubActionType(1).setThrActionType(2));
      G().postDelayed(new QCircleFolderSplashPart.12(this), 300L);
      return;
    }
    L();
  }
  
  private void a(View paramView, String paramString)
  {
    n();
    RFThreadManager.execute(new QCircleFolderSplashPart.1(this));
    this.c = ((ViewStub)paramView.findViewById(2131441666));
    paramView = this.c;
    if (paramView != null) {
      this.d = ((ViewGroup)paramView.inflate());
    }
    this.g = ((TextureView)this.d.findViewById(2131446249));
    this.m = ((URLImageView)this.d.findViewById(2131436513));
    this.n = ((URLImageView)this.d.findViewById(2131436514));
    this.i = ((Button)this.d.findViewById(2131435217));
    this.i.setVisibility(8);
    this.k = 0;
    if ("3".equals(paramString)) {
      this.k = 2;
    } else if ("4".equals(paramString)) {
      this.k = 1;
    } else if ("10".equals(paramString)) {
      this.k = 3;
    }
    paramView = new StringBuilder();
    paramView.append("jumpFromSubAction:");
    paramView.append(this.k);
    QLog.d("QCircleFolderSplashPart", 1, paramView.toString());
    s();
    v();
    this.t = 0;
    q();
    paramString = new QCircleLpReportDc05504.DataBuilder();
    paramView = this.s;
    if (paramView != null) {
      paramView = paramView.mInviteUin;
    } else {
      paramView = "";
    }
    QCircleLpReportDc05504.report(paramString.setToUin(paramView).setActionType(19).setSubActionType(3).setThrActionType(this.k));
  }
  
  private void a(String paramString)
  {
    Object localObject = this.e.findViewById(2131441771).getLayoutParams();
    if ((localObject instanceof LinearLayout.LayoutParams))
    {
      localObject = (LinearLayout.LayoutParams)localObject;
      float f1;
      if (this.r) {
        f1 = 100.0F;
      } else {
        f1 = 50.0F;
      }
      ((LinearLayout.LayoutParams)localObject).topMargin = ViewUtils.a(f1);
    }
    localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = QCircleSkinHelper.getInstance().getUrl("invitation_welcome_title");
    }
    a(QCircleSkinHelper.getInstance().convertUrl((String)localObject), (URLImageView)this.e.findViewById(2131441771), null, null);
  }
  
  private void a(String paramString, ImageView paramImageView, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    paramString = new Option().setTargetView(paramImageView).setUrl(paramString).setTargetView(paramImageView);
    if (paramDrawable1 != null) {
      paramString.setLoadingDrawable(paramDrawable1);
    }
    if (paramDrawable2 != null) {
      paramString.setFailDrawable(paramDrawable2);
    }
    QCircleFeedPicLoader.setViewWidthHeight(paramString, paramImageView);
    QCircleFeedPicLoader.g().loadImage(paramString, null);
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.s != null) && (c() != null))
    {
      if (c().getIntent() == null) {
        return;
      }
      this.s.setOpenPymk(paramBoolean);
      c().getIntent().putExtra("key_bundle_common_init_bean", this.s);
    }
  }
  
  private boolean l()
  {
    WindowManager localWindowManager = c().getWindowManager();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i1 = localDisplayMetrics.widthPixels;
    return localDisplayMetrics.heightPixels / i1 > 1.777778F;
  }
  
  private void m()
  {
    this.t = this.s.getPymkJumpType();
    r();
    w();
  }
  
  private void n()
  {
    QCircleFeedPlayerScroller.a(true);
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedVoiceEvent(1));
  }
  
  private void o()
  {
    QCircleFeedPlayerScroller.a(false);
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedVoiceEvent(2));
  }
  
  private void p()
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedVideoControlEvent(true));
  }
  
  private void q()
  {
    this.o = ((QCircleSplashViewModel)a(QCircleSplashViewModel.class));
    this.o.a.observe(j(), new QCircleFolderSplashPart.2(this));
    this.o.a(this.t);
  }
  
  private void r()
  {
    this.o = ((QCircleSplashViewModel)a(QCircleSplashViewModel.class));
    this.o.a.observe(j(), new QCircleFolderSplashPart.3(this));
    this.o.a(this.s.getPymkTranferData());
    this.o.a(this.t);
  }
  
  private void s()
  {
    if (QCirclePluginConfig.a().o() != null)
    {
      this.j = true;
      this.h = new ReportMediaPlayer();
      this.h.setOnPreparedListener(new QCircleFolderSplashPart.4(this));
      this.h.setOnErrorListener(new QCircleFolderSplashPart.5(this));
      this.h.setOnCompletionListener(new QCircleFolderSplashPart.6(this));
      QLog.d("QCircleFolderSplashPart", 4, "loadSplash video");
    }
  }
  
  private void t()
  {
    if (this.o.b() != null)
    {
      J();
      w();
      return;
    }
    QLog.e("QCircleFolderSplashPart", 1, "showPymk:mViewModel.getResult()==null");
    J();
    o();
    b(false);
    p();
    a(g());
    c("show_publish_feed_guide_bubble", null);
  }
  
  private void u()
  {
    this.d.findViewById(2131436585).setVisibility(0);
    this.d.setBackgroundColor(0);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(19).setSubActionType(3).setThrActionType(0).setvid("2"));
    G().postDelayed(new QCircleFolderSplashPart.7(this), this.l);
  }
  
  private void v()
  {
    if (this.j)
    {
      this.g.setVisibility(0);
      this.g.setSurfaceTextureListener(this);
      G().postDelayed(new QCircleFolderSplashPart.8(this), this.l);
      this.q = ((URLImageView)this.d.findViewById(2131436585));
      this.q.setVisibility(0);
      a(QCircleSkinHelper.getInstance().getUrl("invitation_splash_frame_1"), this.q, null, null);
    }
    else
    {
      u();
    }
    if (!TextUtils.isEmpty(QCirclePluginConfig.a().q())) {
      a(QCirclePluginConfig.a().q(), this.m, QCircleSkinHelper.getInstance().getDrawable(2130845416), QCircleSkinHelper.getInstance().getDrawable(2130845416));
    }
    if (!TextUtils.isEmpty(QCirclePluginConfig.a().r())) {
      a(QCirclePluginConfig.a().r(), this.n, QCircleSkinHelper.getInstance().getDrawable(2130845417), QCircleSkinHelper.getInstance().getDrawable(2130845417));
    }
  }
  
  private void w()
  {
    this.c = ((ViewStub)this.p.findViewById(2131441665));
    ViewStub localViewStub = this.c;
    if (localViewStub != null) {
      this.e = ((ViewGroup)localViewStub.inflate());
    }
    n();
    x();
    y();
    A();
    z();
    i();
  }
  
  private void x()
  {
    Object localObject = this.e.findViewById(2131441840).getLayoutParams();
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localObject;
      int i1;
      if (this.r) {
        i1 = 0;
      } else {
        i1 = -ViewUtils.a(20.0F);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = i1;
    }
    a(QCircleSkinHelper.getInstance().getUrl("invitation_deco_top"), (URLImageView)this.e.findViewById(2131441840), null, null);
    a(QCircleSkinHelper.getInstance().getUrl("invitation_deco_bottom"), (URLImageView)this.e.findViewById(2131441839), null, null);
  }
  
  private void y()
  {
    Object localObject = new ColorDrawable(Color.parseColor("#00000000"));
    localObject = VasApngUtil.getApngURLDrawable("https://sola.gtimg.cn/aoi/sola/20200918151615_aXis1JAyE1.png", new int[] { 33 }, (Drawable)localObject);
    ((ImageView)this.e.findViewById(2131441732)).setImageDrawable((Drawable)localObject);
    ApngImage.playByTag(33);
  }
  
  private void z()
  {
    if (this.e == null) {
      return;
    }
    if (this.o.b() != null)
    {
      ApngImage.pauseByTag(33);
      this.e.findViewById(2131441733).setVisibility(8);
      QQCircleFeedBase.StFeedListBusiRspData localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
      if (this.o.b().busiRspData.has())
      {
        try
        {
          localStFeedListBusiRspData.mergeFrom(this.o.b().busiRspData.get().toByteArray());
          if (localStFeedListBusiRspData.newUserPymkPageData != null)
          {
            if (((QQCircleFeedBase.StNewUserPymkPageData)localStFeedListBusiRspData.newUserPymkPageData.get()).content != null) {
              ((TextView)this.e.findViewById(2131441884)).setText(((QQCircleFeedBase.StNewUserPymkPageData)localStFeedListBusiRspData.newUserPymkPageData.get()).content.get());
            }
            ((QCircleAvatarListView)this.e.findViewById(2131441683)).setData(QCircleAvatarListUtils.a(localStFeedListBusiRspData.newUserPymkPageData.friends.get(), 3));
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        this.e.findViewById(2131436512).setVisibility(0);
        this.e.findViewById(2131436512).setOnClickListener(new QCircleFolderSplashPart.9(this));
        B();
        a(((FeedCloudMeta.StImage)((QQCircleFeedBase.StNewUserPymkPageData)localStFeedListBusiRspData.newUserPymkPageData.get()).backgroundImage.get()).picUrl.get());
        this.e.findViewById(2131441771).setVisibility(0);
        this.e.findViewById(2131441840).setVisibility(0);
        this.e.findViewById(2131441839).setVisibility(0);
      }
    }
  }
  
  public String a()
  {
    return "QCircleFolderSplashPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if ((QCircleHostGlobalInfo.isLostUser()) && (QCircleABTestUtils.a("exp_wezone_reflow_entry_page1"))) {
      return;
    }
    this.p = paramView;
    this.s = ((QCircleFolderBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
    Object localObject = this.s;
    if (localObject != null) {
      localObject = ((QCircleFolderBean)localObject).getLaunchFrom();
    } else {
      localObject = "";
    }
    this.r = l();
    QCircleFolderBean localQCircleFolderBean = this.s;
    if (localQCircleFolderBean == null) {
      return;
    }
    if ((localQCircleFolderBean.isEnableSplash()) && (QCirclePluginConfig.a().g()))
    {
      a(paramView, (String)localObject);
      return;
    }
    if ((this.s.getOpenPymk()) && (!QCircleABTestUtils.a("exp_wezone_reflow_entry_page1"))) {
      m();
    }
  }
  
  public void b(View paramView)
  {
    this.a = paramView;
  }
  
  public void i()
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportDaTongRegister  mPymkRoot == null , subPage: ");
      ((StringBuilder)localObject).append(a());
      QLog.i("QCircleFolderSplashPart", 1, ((StringBuilder)localObject).toString());
      return;
    }
    VideoReport.setPageId(localObject, "pg_xsj_new_entry_page");
    VideoReport.setPageParams(this.e, new QCircleDTParamBuilder().buildPageParams(a()));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportDaTongRegister  subPage: ");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append(", pageId: ");
    ((StringBuilder)localObject).append("pg_xsj_new_entry_page");
    QLog.i("QCircleFolderSplashPart", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    this.l = QCirclePluginConfig.a().p();
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.h;
    if (paramActivity != null)
    {
      paramActivity.setOnCompletionListener(null);
      this.h.setOnErrorListener(null);
      this.h.setOnPreparedListener(null);
      if (this.h.isPlaying())
      {
        this.h.stop();
        this.h.release();
        this.h = null;
      }
      J();
    }
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
    if (this.h != null)
    {
      if (!this.f)
      {
        QLog.d("QCircleFolderSplashPart", 4, "has not play");
        this.f = true;
        this.g.requestFocus();
        if (QCirclePluginConfig.a().o() != null) {
          try
          {
            this.h.setDataSource(g(), QCirclePluginConfig.a().o());
            this.h.prepareAsync();
            QLog.d("QCircleFolderSplashPart", 4, "mediaplayer prepareAsync");
          }
          catch (IOException paramActivity)
          {
            paramActivity.printStackTrace();
            QLog.d("QCircleFolderSplashPart", 4, "setSource or prepare error", paramActivity);
            u();
          }
        } else {
          u();
        }
        QCirclePopupWindowHelper.a().a(false);
        return;
      }
      QLog.d("QCircleFolderSplashPart", 4, "showPymk");
      t();
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    MediaPlayer localMediaPlayer = this.h;
    if (localMediaPlayer != null) {
      localMediaPlayer.setSurface(new Surface(paramSurfaceTexture));
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart
 * JD-Core Version:    0.7.0.1
 */