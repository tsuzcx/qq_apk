package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.events.QCircleFeedVoiceEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller;
import com.tencent.biz.qqcircle.utils.QCircleABTestUtils;
import com.tencent.biz.qqcircle.utils.QCircleAvatarListUtils;
import com.tencent.biz.qqcircle.utils.QCircleThemeUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.viewmodels.QCircleBackFlowSplashViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.qqcircle.widgets.QCircleSplashPYMKRecommendWidget;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.BackflowPymkDescEntry;
import qqcircle.QQCircleFeedBase.StBackflowPymkPageData;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class QCircleBackFlowSplashPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  QCircleAvatarListView a;
  private View c;
  private ViewGroup d;
  private LinearLayout e;
  private QCircleBackFlowSplashViewModel f;
  private View g;
  private boolean h;
  private URLImageView i;
  private URLImageView j;
  private URLImageView k;
  private ImageView l;
  private ImageView m;
  private ImageView n;
  private View o;
  private View p;
  private FrameLayout q;
  private TextView r;
  private QCircleFolderBean s;
  
  private void a(TextView paramTextView, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    paramString = paramString.replaceAll("%d", localStringBuilder.toString());
    int i1 = paramString.indexOf(String.valueOf(paramInt));
    paramString = new SpannableString(paramString);
    paramString.setSpan(new QCircleBackFlowSplashPart.2(this, ViewUtils.a(17.0F)), i1, String.valueOf(paramInt).length() + i1, 33);
    paramTextView.setText(paramString);
  }
  
  private void a(UIStateData<FeedCloudRead.StGetFeedListRsp> paramUIStateData)
  {
    int i1 = paramUIStateData.c();
    if ((i1 != 2) && (i1 != 3))
    {
      if (i1 != 4) {
        return;
      }
      ApngImage.pauseByTag(33);
      this.o.setVisibility(8);
      u();
      return;
    }
    b(paramUIStateData);
  }
  
  private void a(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    if (paramStGetFeedListRsp != null)
    {
      if (paramStGetFeedListRsp.vecFeed.size() == 0) {
        return;
      }
      QCircleSplashPYMKRecommendWidget localQCircleSplashPYMKRecommendWidget = new QCircleSplashPYMKRecommendWidget(g());
      localQCircleSplashPYMKRecommendWidget.setSplashRecommendPageId(94);
      localQCircleSplashPYMKRecommendWidget.bindData(new FeedBlockData((FeedCloudMeta.StFeed)paramStGetFeedListRsp.vecFeed.get(0)), 0);
      this.q.addView(localQCircleSplashPYMKRecommendWidget);
    }
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
  
  private void a(QQCircleFeedBase.StFeedListBusiRspData paramStFeedListBusiRspData)
  {
    View localView = this.p;
    if ((localView != null) && (this.a != null))
    {
      TextView localTextView = this.r;
      if (localTextView == null) {
        return;
      }
      if (paramStFeedListBusiRspData == null)
      {
        localView.setVisibility(8);
        return;
      }
      localTextView.setText(paramStFeedListBusiRspData.backflowPymkPageData.content.get());
      paramStFeedListBusiRspData = paramStFeedListBusiRspData.backflowPymkPageData.friends.get();
      if (paramStFeedListBusiRspData.size() > 0)
      {
        this.p.setVisibility(0);
        this.a.setData(QCircleAvatarListUtils.a(paramStFeedListBusiRspData, 3));
        return;
      }
      this.p.setVisibility(8);
    }
  }
  
  private void b(UIStateData<FeedCloudRead.StGetFeedListRsp> paramUIStateData)
  {
    if (this.d == null) {
      return;
    }
    ApngImage.pauseByTag(33);
    this.o.setVisibility(8);
    QQCircleFeedBase.StFeedListBusiRspData localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
    try
    {
      localStFeedListBusiRspData.mergeFrom(((FeedCloudRead.StGetFeedListRsp)paramUIStateData.e()).busiRspData.get().toByteArray());
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse backflowPymkPageData error ");
      localStringBuilder.append(localInvalidProtocolBufferMicroException.getMessage());
      QLog.e("QCircleBackFlowSplashPart", 1, localStringBuilder.toString());
    }
    a(localStFeedListBusiRspData);
    b(localStFeedListBusiRspData);
    a((FeedCloudRead.StGetFeedListRsp)paramUIStateData.e());
    c(localStFeedListBusiRspData);
    paramUIStateData = this.n;
    if (paramUIStateData != null) {
      paramUIStateData.setVisibility(0);
    }
    paramUIStateData = this.i;
    if (paramUIStateData != null) {
      paramUIStateData.setVisibility(0);
    }
    paramUIStateData = this.j;
    if (paramUIStateData != null) {
      paramUIStateData.setVisibility(0);
    }
    paramUIStateData = this.k;
    if (paramUIStateData != null) {
      paramUIStateData.setVisibility(0);
    }
    x();
  }
  
  private void b(QQCircleFeedBase.StFeedListBusiRspData paramStFeedListBusiRspData)
  {
    if (paramStFeedListBusiRspData == null) {
      return;
    }
    paramStFeedListBusiRspData = paramStFeedListBusiRspData.backflowPymkPageData.backflowPymkDescEntry.get().iterator();
    while (paramStFeedListBusiRspData.hasNext())
    {
      QQCircleFeedBase.BackflowPymkDescEntry localBackflowPymkDescEntry = (QQCircleFeedBase.BackflowPymkDescEntry)paramStFeedListBusiRspData.next();
      if (localBackflowPymkDescEntry.needDisplay.get())
      {
        TextView localTextView = (TextView)LayoutInflater.from(g()).inflate(2131626860, null);
        this.e.addView(localTextView);
        float f1;
        if (this.h) {
          f1 = 14.0F;
        } else {
          f1 = 12.6F;
        }
        localTextView.setTextSize(1, f1);
        a(localTextView, localBackflowPymkDescEntry.describe.get(), localBackflowPymkDescEntry.count.get());
      }
    }
    this.e.setVisibility(0);
    v();
  }
  
  private void c(QQCircleFeedBase.StFeedListBusiRspData paramStFeedListBusiRspData)
  {
    if (paramStFeedListBusiRspData == null) {
      return;
    }
    Object localObject = this.k.getLayoutParams();
    float f1;
    if ((localObject instanceof LinearLayout.LayoutParams))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localObject;
      if (this.h) {
        f1 = 80.0F;
      } else {
        f1 = 40.0F;
      }
      localLayoutParams.topMargin = ViewUtils.a(f1);
    }
    if (this.h) {
      f1 = 220.0F;
    } else {
      f1 = 187.0F;
    }
    ((ViewGroup.LayoutParams)localObject).width = ViewUtils.a(f1);
    if (this.h) {
      f1 = 68.0F;
    } else {
      f1 = 57.799999F;
    }
    ((ViewGroup.LayoutParams)localObject).height = ViewUtils.a(f1);
    localObject = paramStFeedListBusiRspData.backflowPymkPageData.backgroundImage.picUrl.get();
    paramStFeedListBusiRspData = (QQCircleFeedBase.StFeedListBusiRspData)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramStFeedListBusiRspData = QCircleSkinHelper.getInstance().getUrl("invitation_welcome_title");
    }
    a(QCircleSkinHelper.getInstance().convertUrl(paramStFeedListBusiRspData), this.k, null, null);
  }
  
  private boolean i()
  {
    WindowManager localWindowManager = c().getWindowManager();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i1 = localDisplayMetrics.widthPixels;
    return localDisplayMetrics.heightPixels / i1 > 1.777778F;
  }
  
  private void l()
  {
    QCircleFeedPlayerScroller.a(true);
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedVoiceEvent(1));
  }
  
  private void m()
  {
    QCircleFeedPlayerScroller.a(false);
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedVoiceEvent(2));
  }
  
  private void n()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        ImmersiveUtils.clearCoverForStatus(c().getWindow(), true);
        ImmersiveUtils.setStatusTextColor(true, c().getWindow());
      }
      else if (Build.VERSION.SDK_INT >= 19)
      {
        c().getWindow().addFlags(67108864);
      }
      View localView = this.c;
      if (localView != null)
      {
        localView.setFitsSystemWindows(false);
        this.c.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  private void o()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      QCircleThemeUtil.a(c(), QCircleSkinHelper.getInstance().getColor(2131167059));
      ImmersiveUtils.setStatusTextColor(QCircleCommonUtil.isInNightMode() ^ true, c().getWindow());
      this.c.setFitsSystemWindows(true);
      this.c.setPadding(0, ImmersiveUtils.getStatusBarHeight(g()) - 1, 0, 0);
    }
  }
  
  private void p()
  {
    this.f = ((QCircleBackFlowSplashViewModel)a(QCircleBackFlowSplashViewModel.class));
    this.f.a.observe(j(), new QCircleBackFlowSplashPart.1(this));
    this.f.a(this.s.getPymkTranferData());
    this.f.b();
  }
  
  private void q()
  {
    l();
    r();
    s();
    t();
  }
  
  private void r()
  {
    Object localObject = this.i.getLayoutParams();
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localObject;
      int i1;
      if (this.h) {
        i1 = 0;
      } else {
        i1 = -ViewUtils.a(20.0F);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = i1;
    }
    a(QCircleSkinHelper.getInstance().getUrl("invitation_deco_top"), this.i, null, null);
    a(QCircleSkinHelper.getInstance().getUrl("invitation_deco_bottom"), this.j, null, null);
  }
  
  private void s()
  {
    Object localObject = new ColorDrawable(Color.parseColor("#00000000"));
    localObject = VasApngUtil.getApngURLDrawable("https://sola.gtimg.cn/aoi/sola/20200918151615_aXis1JAyE1.png", new int[] { 33 }, (Drawable)localObject);
    this.l.setImageDrawable((Drawable)localObject);
    ApngImage.playByTag(33);
  }
  
  private void t()
  {
    Object localObject = this.m;
    if (localObject == null) {
      return;
    }
    localObject = ((ImageView)localObject).getLayoutParams();
    this.m.setVisibility(0);
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localObject;
      float f1;
      if (this.h) {
        f1 = 44.0F;
      } else {
        f1 = 18.0F;
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = ViewUtils.a(f1);
    }
    w();
  }
  
  private void u()
  {
    ViewGroup localViewGroup = this.d;
    if (localViewGroup != null)
    {
      localViewGroup.removeAllViews();
      this.d.setVisibility(8);
      m();
      o();
    }
  }
  
  private void v()
  {
    LinearLayout localLinearLayout = this.e;
    if (localLinearLayout == null) {
      return;
    }
    VideoReport.setElementId(localLinearLayout, "em_xsj_user_stat");
  }
  
  private void w()
  {
    ImageView localImageView = this.m;
    if (localImageView == null) {
      return;
    }
    VideoReport.setElementId(localImageView, "em_xsj_back_button");
  }
  
  private void x()
  {
    ImageView localImageView = this.n;
    if (localImageView == null) {
      return;
    }
    VideoReport.setElementId(localImageView, "em_xsj_entry_button");
  }
  
  public String a()
  {
    return "QCircleBackFlowSplashPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.s = ((QCircleFolderBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
    if (!QCircleHostGlobalInfo.isLostUser()) {
      return;
    }
    if (QCircleHostGlobalInfo.isCurrentTabActive())
    {
      QCircleHostGlobalInfo.setIsLostUser(false);
      return;
    }
    if (this.s.isPublish())
    {
      QCircleHostGlobalInfo.setIsLostUser(false);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInitView hasExperiment");
    localStringBuilder.append(QCircleABTestUtils.a("exp_wezone_reflow_entry_page1"));
    QLog.d("QCircleBackFlowSplashPart", 1, localStringBuilder.toString());
    if (QCircleABTestUtils.a("exp_wezone_reflow_entry_page1"))
    {
      this.g = paramView;
      this.h = i();
      this.d = ((ViewGroup)((ViewStub)this.g.findViewById(2131441665)).inflate());
      this.i = ((URLImageView)this.d.findViewById(2131441840));
      this.j = ((URLImageView)this.d.findViewById(2131441839));
      this.e = ((LinearLayout)this.d.findViewById(2131441572));
      this.l = ((ImageView)this.d.findViewById(2131441732));
      this.o = this.d.findViewById(2131441733);
      this.q = ((FrameLayout)this.d.findViewById(2131441838));
      this.k = ((URLImageView)this.d.findViewById(2131441771));
      this.m = ((ImageView)this.d.findViewById(2131441728));
      this.n = ((ImageView)this.d.findViewById(2131436512));
      this.r = ((TextView)this.d.findViewById(2131441884));
      this.a = ((QCircleAvatarListView)this.d.findViewById(2131441683));
      this.p = this.d.findViewById(2131441841);
      this.n.setOnClickListener(this);
      this.m.setOnClickListener(this);
      n();
      bb_();
      p();
      q();
      QCircleHostGlobalInfo.setIsLostUser(false);
    }
    QCircleABTestUtils.b("exp_wezone_reflow_entry_page1");
  }
  
  public void b(View paramView)
  {
    this.c = paramView;
  }
  
  public void bb_()
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportDaTongRegister  mPymkRoot == null , subPage: ");
      ((StringBuilder)localObject).append(a());
      QLog.i("QCircleBackFlowSplashPart", 1, ((StringBuilder)localObject).toString());
      return;
    }
    VideoReport.setPageId(localObject, "pg_xsj_reflow_entry_page");
    VideoReport.setPageParams(this.d, new QCircleDTParamBuilder().buildPageParams(a()));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportDaTongRegister  subPage: ");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append(", pageId: ");
    ((StringBuilder)localObject).append("pg_xsj_new_entry_page");
    QLog.i("QCircleBackFlowSplashPart", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436512)
    {
      m();
      u();
    }
    else if (paramView.getId() == 2131441728)
    {
      c().onBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleBackFlowSplashPart
 * JD-Core Version:    0.7.0.1
 */