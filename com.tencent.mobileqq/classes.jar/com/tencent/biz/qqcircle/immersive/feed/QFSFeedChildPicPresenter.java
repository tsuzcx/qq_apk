package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPicPositionChangeEvent;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.immersive.request.QFSGetMusicInfoRequest;
import com.tencent.biz.qqcircle.immersive.utils.QFSSafeListUtils;
import com.tencent.biz.qqcircle.immersive.views.QFSAudioView;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender;
import com.tencent.biz.qqcircle.utils.QCircleSplashUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StFeedMusic;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QFSFeedChildPicPresenter
  extends QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
{
  private FrameLayout i;
  private TextView j;
  private QFSImageBanner k;
  private FrameLayout l;
  private int m = -1;
  private QFSAudioView n;
  private boolean o = true;
  
  private FeedCloudMeta.StImage a(int paramInt)
  {
    List localList;
    if (this.c == null) {
      localList = null;
    } else {
      localList = ((FeedCloudMeta.StFeed)this.c).images.get();
    }
    return (FeedCloudMeta.StImage)QFSSafeListUtils.a(localList, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.k.a(new QFSFeedChildPicPresenter.3(this));
    this.k.setData(w());
    this.k.setReportBean(i());
    if (e() != null) {
      this.k.setPlayScene(e().mPlayScene);
    }
    if (paramInt2 > 1) {
      this.k.setLoopDurationTime(s());
    }
  }
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, String paramString, FeedCloudMeta.StImage paramStImage)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      paramQCircleExtraTypeInfo = new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setExt1(paramString).setPageId(f()).setfpageid(Integer.valueOf(h()).intValue());
      paramInt1 = t();
      if ((x()) && (paramInt1 > 0)) {
        paramQCircleExtraTypeInfo.setExt5(String.valueOf(paramInt1));
      }
      if (paramStImage != null) {
        paramQCircleExtraTypeInfo.setLloc(paramStImage.picId.get());
      }
      QCircleLpReportDc05507.report(paramQCircleExtraTypeInfo);
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_PIC-QFSFeedChildPicPresenter", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  private void a(FeedBlockData paramFeedBlockData, int paramInt)
  {
    if (paramFeedBlockData != null)
    {
      if (paramFeedBlockData.b() == null) {
        return;
      }
      VideoReport.setElementId(this.k, "em_xsj_multimedia");
      Object localObject = new QCircleDTParamBuilder().buildElementParams();
      ((Map)localObject).putAll(QCirclePluginReportUtil.a(paramFeedBlockData));
      ((Map)localObject).put("xsj_feed_index", Integer.valueOf(paramInt + 1));
      VideoReport.setElementParams(this, (Map)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("em_xsj_multimedia");
      ((StringBuilder)localObject).append(paramFeedBlockData.b().id.get());
      VideoReport.setElementReuseIdentifier(this, ((StringBuilder)localObject).toString());
      VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
      VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
      paramFeedBlockData = new StringBuilder();
      paramFeedBlockData.append("dtReportBindPicRecycler  pos = ");
      paramFeedBlockData.append(paramInt);
      QLog.i("PIC-QFSFeedChildPicPresenter", 1, paramFeedBlockData.toString());
    }
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed1, FeedCloudMeta.StFeed paramStFeed2)
  {
    if (paramStFeed2 == null) {
      return;
    }
    paramStFeed2 = paramStFeed2.images.get();
    if (paramStFeed1 == null) {
      return;
    }
    paramStFeed1 = paramStFeed1.images.get();
    int i1 = 0;
    while (i1 < paramStFeed1.size())
    {
      if ((paramStFeed2.size() > i1) && (paramStFeed2.get(i1) != null)) {
        ((FeedCloudMeta.StImage)paramStFeed1.get(i1)).busiData.set(((FeedCloudMeta.StImage)paramStFeed2.get(i1)).busiData.get());
      }
      i1 += 1;
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[updateProgressText] text should not be empty.");
      return;
    }
    if (this.j == null)
    {
      QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[updateProgressText] progress text view should not be null.");
      return;
    }
    QLog.d("PIC-QFSFeedChildPicPresenter", 1, new Object[] { "[updateProgressText] text: ", paramString });
    this.j.setText(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramString = new QFSGetMusicInfoRequest(localArrayList);
    QCircleRequestSender.a().b().a(paramString).a(new QFSFeedChildPicPresenter.2(this, paramInt)).a();
  }
  
  private void b(int paramInt)
  {
    QCircleFeedDataCenter.a().a(((FeedCloudMeta.StFeed)this.c).id.get(), paramInt);
    c(paramInt);
    this.m = paramInt;
    b(new QFSPicPositionChangeEvent(v(), paramInt));
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    if (!x()) {
      return;
    }
    a(true);
    Object localObject = paramStFeed.id.get();
    ArrayList localArrayList = new ArrayList();
    localObject = QCirclePluginGlobalInfo.b((String)localObject);
    a((FeedCloudMeta.StFeed)localObject, paramStFeed);
    if (localObject != null) {
      localArrayList.add(localObject);
    } else {
      localArrayList.add(paramStFeed);
    }
    QLog.d("PIC-QFSFeedChildPicPresenter", 1, new Object[] { "[initPicPosition] data hash code: ", Integer.valueOf(paramStFeed.hashCode()), " | feed id: ", r(), " | vertical position: ", Integer.valueOf(this.d), " | horizontal position: ", Integer.valueOf(paramInt) });
  }
  
  private void b(String paramString)
  {
    try
    {
      QCircleFeedDataCenter.a().a(paramString, new QFSFeedChildPicPresenter.FeedStateObserver(this));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("PIC-QFSFeedChildPicPresenter", 1, paramString.getMessage());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (!x()) {
      return;
    }
    SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(paramBoolean));
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.k;
    boolean bool = true;
    if (localObject == null)
    {
      QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[updateProgressText] mImageBanner should not be null.");
      return;
    }
    int i1 = ((QFSImageBanner)localObject).getRealCount();
    QLog.d("PIC-QFSFeedChildPicPresenter", 1, new Object[] { "[updateProgressText] position: ", Integer.valueOf(paramInt), " | totalCount: ", Integer.valueOf(i1) });
    if (i1 >= 1)
    {
      paramInt = paramInt % i1 + 1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(i1);
      a(((StringBuilder)localObject).toString());
      if (paramInt != i1) {
        bool = false;
      }
      b(bool);
      return;
    }
    a("");
  }
  
  private void k()
  {
    if (m()) {
      return;
    }
    if (this.n != null)
    {
      if (!x()) {
        return;
      }
      FeedCloudMeta.StFeedMusic localStFeedMusic = w().musicInfo;
      if ((localStFeedMusic != null) && (!TextUtils.isEmpty(localStFeedMusic.playUrl.get())))
      {
        int i1 = localStFeedMusic.startPos.get();
        int i2 = localStFeedMusic.endPos.get();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[startPlayer] url = ");
        localStringBuilder.append(localStFeedMusic.playUrl.get());
        localStringBuilder.append(",start = ");
        localStringBuilder.append(i1);
        localStringBuilder.append(",end = ");
        localStringBuilder.append(i2);
        QLog.i("PIC-QFSFeedChildPicPresenter", 1, localStringBuilder.toString());
        this.n.setPlayRange(i1, i2);
        this.n.setVideoPath(null, localStFeedMusic.playUrl.get(), i1);
        this.n.getSuperPlayer().setOnErrorListener(new QFSFeedChildPicPresenter.1(this, localStFeedMusic, i1));
        return;
      }
      QLog.i("PIC-QFSFeedChildPicPresenter", 1, "[startPlayer] music is null");
    }
  }
  
  private void l()
  {
    if (n()) {
      return;
    }
    if (x())
    {
      QFSImageBanner localQFSImageBanner = this.k;
      if (localQFSImageBanner == null) {
        return;
      }
      localQFSImageBanner.setIQFSFeedIoc(this.a);
      this.k.setEnableLoop(true);
      this.k.a();
    }
  }
  
  private boolean m()
  {
    return (this.a == null) || (this.n == null) || (!y());
  }
  
  private boolean n()
  {
    return (this.a == null) || (this.k == null) || (!y());
  }
  
  private void o()
  {
    QFSAudioView localQFSAudioView = this.n;
    if (localQFSAudioView == null) {
      return;
    }
    localQFSAudioView.release();
  }
  
  private void p()
  {
    QFSImageBanner localQFSImageBanner = this.k;
    if (localQFSImageBanner == null) {
      return;
    }
    localQFSImageBanner.b();
  }
  
  private void q()
  {
    if (!x())
    {
      QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[reloadPicPosition] current feed not is pic type.");
      return;
    }
    Object localObject = v();
    this.m = -1;
    int i1 = QCircleFeedDataCenter.a().b((String)localObject);
    if (f() == 57) {
      i1 = 0;
    }
    this.m = i1;
    localObject = this.k;
    if (localObject != null) {
      ((QFSImageBanner)localObject).setCurrentItem(this.m, false);
    }
    b(this.m);
    QLog.d("PIC-QFSFeedChildPicPresenter", 1, new Object[] { "[reloadPictureContent] change new feed, current position: ", Integer.valueOf(i1) });
  }
  
  private String r()
  {
    if (this.c == null) {
      return "";
    }
    return ((FeedCloudMeta.StFeed)this.c).id.get();
  }
  
  private int s()
  {
    int i1 = QCircleConfigHelper.a("qqcircle", "qqcircle_auto_play_picture_interval", Integer.valueOf(1500)).intValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getPictureInterval] intervalTime = ");
    localStringBuilder.append(i1);
    QLog.i("PIC-QFSFeedChildPicPresenter", 1, localStringBuilder.toString());
    return Math.max(i1, 1500);
  }
  
  private int t()
  {
    return QCircleConfigHelper.a("qqcircle", "qqcircle_auto_play_exposure_time", Integer.valueOf(700)).intValue();
  }
  
  private int u()
  {
    if (this.c == null)
    {
      QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[getPictureCount] data should not be null.");
      return 0;
    }
    return ((FeedCloudMeta.StFeed)this.c).images.get().size();
  }
  
  private String v()
  {
    if (this.c == null) {
      return "";
    }
    return ((FeedCloudMeta.StFeed)this.c).id.get();
  }
  
  private FeedCloudMeta.StFeed w()
  {
    return (FeedCloudMeta.StFeed)this.c;
  }
  
  private boolean x()
  {
    FeedCloudMeta.StFeed localStFeed = w();
    return (localStFeed != null) && (localStFeed.type.get() == 2);
  }
  
  private boolean y()
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
    ((StringBuilder)localObject).append(this.o);
    ((StringBuilder)localObject).append("| isFromBottom");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append("| isShowSplash");
    ((StringBuilder)localObject).append(bool3);
    ((StringBuilder)localObject).append(hashCode());
    QLog.d("PIC-QFSFeedChildPicPresenter", 1, ((StringBuilder)localObject).toString());
    return (i1 == this.d) && (i2 == i3) && ((bool2) || (!QCirclePluginUtil.d()) || (!bool1)) && (this.o) && (!bool3);
  }
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.b = ((ViewStub)paramView.findViewById(2131441963)).inflate();
    this.i = ((FrameLayout)paramView.findViewById(2131442019));
    this.j = ((TextView)paramView.findViewById(2131442020));
    this.k = ((QFSImageBanner)paramView.findViewById(2131441992));
    this.l = ((FrameLayout)paramView.findViewById(2131433326));
    this.n = new QFSAudioView(paramView.getContext());
    a(false);
  }
  
  public void a(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.a(paramQFSFeedSelectInfo);
    this.o = true;
    if (paramQFSFeedSelectInfo == null) {
      return;
    }
    if (this.d != paramQFSFeedSelectInfo.b()) {
      return;
    }
    k();
    l();
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    super.a(paramStFeed, paramInt);
    boolean bool = x();
    int i1 = 0;
    if (!bool)
    {
      a(false);
      return;
    }
    Object localObject = this.k;
    if (localObject != null) {
      ((QFSImageBanner)localObject).setVerticalPos(this.d);
    }
    this.d = paramInt;
    localObject = v();
    QLog.d("PIC-QFSFeedChildPicPresenter", 1, new Object[] { "[onBindData] bind data feed id: ", localObject, "mPos: ", Integer.valueOf(this.d) });
    paramInt = QCircleFeedDataCenter.a().b((String)localObject);
    if (f() == 57) {
      paramInt = 0;
    }
    int i2 = u();
    b(paramStFeed, paramInt);
    if ((this.b.getContext() instanceof LifecycleOwner)) {
      b((String)localObject);
    }
    paramStFeed = this.i;
    if (paramStFeed != null)
    {
      if (i2 < 1) {
        i1 = 8;
      }
      paramStFeed.setVisibility(i1);
    }
    paramStFeed = this.l;
    if (paramStFeed != null) {
      paramStFeed.setVisibility(4);
    }
    a(this.h, this.d);
    a(paramInt, i2);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.b != null)
    {
      View localView = this.b;
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localView.setVisibility(i1);
    }
  }
  
  public void c()
  {
    super.c();
  }
  
  public void c(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.c(paramQFSFeedSelectInfo);
    this.o = false;
    paramQFSFeedSelectInfo = this.k;
    if (paramQFSFeedSelectInfo != null) {
      paramQFSFeedSelectInfo.b();
    }
    o();
    p();
  }
  
  public void d()
  {
    super.d();
  }
  
  public void d(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.d(paramQFSFeedSelectInfo);
    if (paramQFSFeedSelectInfo == null) {
      return;
    }
    if (paramQFSFeedSelectInfo.b() != this.d) {
      return;
    }
    QLog.d("PIC-QFSFeedChildPicPresenter", 1, new Object[] { "[onFeedSelected] feed id: ", r() });
    l();
    q();
    k();
  }
  
  public void e(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.e(paramQFSFeedSelectInfo);
    QLog.d("PIC-QFSFeedChildPicPresenter", 1, new Object[] { "[onFeedUnSelected] feed id: ", r() });
    b(true);
    o();
  }
  
  public void j()
  {
    super.j();
    if (x()) {
      a(1, 1, e(), "1", a(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildPicPresenter
 * JD-Core Version:    0.7.0.1
 */