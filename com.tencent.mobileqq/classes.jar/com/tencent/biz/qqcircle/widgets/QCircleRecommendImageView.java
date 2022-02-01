package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import androidx.annotation.Nullable;
import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationStateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushBubbleEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleTaskCenterEvent;
import com.tencent.biz.qqcircle.events.QCircleUndoPushUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSPushTenTimesEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetTaskCenterListRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender;
import com.tencent.biz.qqcircle.richframework.sender.iml.req.QCirclePushMergeReqInterceptor;
import com.tencent.biz.qqcircle.richframework.sender.iml.req.QCirclePushReportReqInterceptor;
import com.tencent.biz.qqcircle.richframework.sender.iml.rsp.QCirclePushRspInterceptor;
import com.tencent.biz.qqcircle.utils.QCircleDrawableCacheUtils;
import com.tencent.biz.qqcircle.utils.QCircleProtoUtil;
import com.tencent.biz.qqcircle.utils.QCircleTipsUtil;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.delegate.IApplicationDelegate;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadResult;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper.OnThemeUpdateListener;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoPushReq;
import feedcloud.FeedCloudWrite.StDoPushRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

public class QCircleRecommendImageView
  extends FrameAnimationView
  implements SimpleEventReceiver, Call.OnRspCallBack, QCircleSkinHelper.OnThemeUpdateListener
{
  private static final int A = QCircleConfigHelper.d();
  private static boolean H = false;
  private static RFWMultiDownloadHelper b;
  private static boolean c;
  private static Map<String, RFWMultiDownloadHelper.DownloadResult> d;
  private static int u;
  private static int v;
  private static final int z;
  private boolean B = false;
  private int C;
  private int D;
  private int E;
  private int F;
  private boolean G = false;
  private Animation.AnimationListener I;
  private QCirclePushReportReqInterceptor J;
  private int K = -1;
  private int L = -1;
  private int M = -1;
  private int N = -1;
  private QCircleExtraTypeInfo O;
  private int e;
  private int f;
  private int g;
  private FeedCloudMeta.StFeed h;
  private FeedCloudMeta.StPushList i;
  private QQAnimationDrawable j;
  private boolean k;
  private QQAnimationDrawable l;
  private int m;
  private long n;
  private long o;
  private long p;
  private int q;
  private int r;
  private boolean s = false;
  private boolean t;
  private Timer w;
  private QCircleRecommendImageView.LongPressTimerTask x;
  private boolean y = true;
  
  static
  {
    v();
    b = new RFWMultiDownloadHelper();
    u = 400;
    v = 200;
    z = QCircleConfigHelper.c();
  }
  
  public QCircleRecommendImageView(Context paramContext)
  {
    this(paramContext, null);
    b();
  }
  
  public QCircleRecommendImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    b();
  }
  
  public QCircleRecommendImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
    c();
    b();
  }
  
  private QQAnimationDrawable a(String paramString)
  {
    try
    {
      if ((d != null) && (d.containsKey(paramString)))
      {
        paramString = (RFWMultiDownloadHelper.DownloadResult)d.get(paramString);
        if (paramString != null)
        {
          paramString = AnimationDrawableFactory.a(paramString.mFilePath);
          if ((paramString != null) && (paramString.length > 0))
          {
            localObject = new QQAnimationDrawable();
            ((QQAnimationDrawable)localObject).a(paramString);
            return localObject;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject = getBusinessTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAnimationDrawable error");
      localStringBuilder.append(paramString.getMessage());
      QLog.e((String)localObject, 1, localStringBuilder.toString());
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    setPadding(this.C, this.D, this.E, this.F);
    try
    {
      if (paramInt >= z)
      {
        if ((this.m == 5) && (this.M != -1)) {
          setImageDrawable(QCircleDrawableCacheUtils.a(this.N));
        } else {
          setImageDrawable(QCircleDrawableCacheUtils.a(2130845090));
        }
      }
      else if ((this.m == 5) && (this.M != -1)) {
        setImageDrawable(QCircleDrawableCacheUtils.a(this.M));
      } else {
        setImageDrawable(QCircleDrawableCacheUtils.a(2130845394));
      }
      if ((this.m != 1) && (this.m != 3) && (this.m != 4))
      {
        if (this.m == 2)
        {
          setBackgroundDrawable(QCircleDrawableCacheUtils.a(2130845067));
          return;
        }
        if ((this.m != 5) || (this.K == -1)) {
          break label209;
        }
        setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(this.K));
        return;
      }
      setBackgroundDrawable(QCircleDrawableCacheUtils.a(2130845306));
      return;
    }
    catch (Exception localException)
    {
      label198:
      label209:
      break label198;
    }
    QLog.e(getBusinessTag(), 1, "showRecommendView setBackgroundDrawable error");
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      c(paramInt2);
    }
  }
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, String paramString)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setPageId(paramQCircleExtraTypeInfo.pageType).setExt1(paramString));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_QCircleRecommend_", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  private void a(int paramInt, String paramString)
  {
    FeedCloudMeta.StFeed localStFeed = this.h;
    if ((localStFeed != null) && (QCirclePluginUtil.b((FeedCloudMeta.StUser)localStFeed.poster.get())))
    {
      h();
      return;
    }
    if (QCirclePluginConfig.a().D() < paramInt)
    {
      c(0);
      o();
    }
    else
    {
      int i1 = this.f;
      if (i1 + paramInt <= z)
      {
        this.f = (i1 + paramInt);
        if (paramInt == 1) {
          this.g += 1;
        } else {
          this.g = this.f;
        }
        c(true);
        localStFeed = this.h;
        if ((localStFeed != null) && (!TextUtils.isEmpty(localStFeed.id.get())))
        {
          SimpleEventBus.getInstance().dispatchEvent(new QCirclePushAnimationEvent(this.h.id.get(), this.g, 3, this.m));
          a(paramString, paramInt);
        }
        QCirclePluginConfig.a().c(QCirclePluginConfig.a().D() - paramInt);
      }
      else
      {
        QLog.e(getBusinessTag(), 1, "consume over MAX_PUSH_TIME");
        o();
      }
    }
    p();
  }
  
  private void a(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cP, paramInt, 0);
    this.K = paramContext.getResourceId(R.styleable.cQ, -1);
    this.L = paramContext.getResourceId(R.styleable.cU, 2130845392);
    this.M = paramContext.getResourceId(R.styleable.cT, 2130845394);
    this.N = paramContext.getResourceId(R.styleable.cR, 2130845090);
    this.m = paramContext.getInteger(R.styleable.cS, -1);
    paramContext.recycle();
  }
  
  private void a(View paramView)
  {
    if (paramView.getId() == 2131441756)
    {
      t();
      SimpleEventBus.getInstance().dispatchEvent(new QFSPushTenTimesEvent(getFeedData()));
      return;
    }
    if (paramView.getId() == 2131441755)
    {
      u();
      return;
    }
    if (paramView.getId() == 2131441754)
    {
      i();
      return;
    }
    if (paramView.getId() == 2131441753) {
      s();
    }
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, FeedCloudWrite.StDoPushRsp paramStDoPushRsp, QCircleDoRecommendRequest paramQCircleDoRecommendRequest)
  {
    if ((paramStDoPushRsp != null) && (paramStDoPushRsp.myFuel != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("feedId", paramStFeed.id.get());
      localHashMap.put("fuelCount", Integer.valueOf(paramStDoPushRsp.myFuel.get()));
      localHashMap.put("eventType", "updateFuel");
      TencentQQCirclePlugin.sendEvent("tencent_qqcircle/dataChange", localHashMap);
    }
    if ((paramQCircleDoRecommendRequest != null) && (paramQCircleDoRecommendRequest.getReq() != null) && (paramQCircleDoRecommendRequest.getReq().comboCount != null) && (paramQCircleDoRecommendRequest.getReq().push.hasClickCount != null) && (paramQCircleDoRecommendRequest.getReq().push.totalClickCount != null))
    {
      paramStDoPushRsp = new HashMap();
      paramStDoPushRsp.put("feedId", paramStFeed.id.get());
      paramStDoPushRsp.put("hasClickCount", Integer.valueOf(paramQCircleDoRecommendRequest.getReq().comboCount.get() + paramQCircleDoRecommendRequest.getReq().push.hasClickCount.get()));
      paramStDoPushRsp.put("totalClickCount", Integer.valueOf(paramQCircleDoRecommendRequest.getReq().comboCount.get() + paramQCircleDoRecommendRequest.getReq().push.totalClickCount.get()));
      paramStDoPushRsp.put("eventType", "pushFeed");
      TencentQQCirclePlugin.sendEvent("tencent_qqcircle/dataChange", paramStDoPushRsp);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject1 = this.h;
    if (localObject1 != null)
    {
      Object localObject2 = this.i;
      if (localObject2 != null)
      {
        localObject1 = new QCircleDoRecommendRequest((FeedCloudMeta.StFeed)localObject1, paramInt, (FeedCloudMeta.StPushList)localObject2, 0);
        localObject2 = this.J;
        if (localObject2 != null) {
          ((QCirclePushReportReqInterceptor)localObject2).a(paramString);
        }
        QCircleRequestSender.a().b().a(new QCirclePushMergeReqInterceptor()).a(this.J).a(new QCirclePushRspInterceptor()).a(localObject1).a();
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt > 0)
    {
      a(paramInt);
      a(34, 2, this.O, String.valueOf(paramInt));
      return;
    }
    d();
  }
  
  private void b(String paramString)
  {
    RFThreadManager.getUIHandler().post(new QCircleRecommendImageView.6(this, paramString));
  }
  
  private void c()
  {
    if (this.m == 5)
    {
      b.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/new_layer_mode/animation/pushAppear.zip", QCirclePluginConfig.e()));
      b.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/new_layer_mode/animation/pushDisappear.zip", QCirclePluginConfig.e()));
      b.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/new_layer_mode/animation/pushFinalDisappear.zip", QCirclePluginConfig.e()));
    }
    else
    {
      b.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/rocket_start.zip", QCirclePluginConfig.e()));
      b.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/rocket_end.zip", QCirclePluginConfig.e()));
      b.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/wezone_url/defaultmode/8417/feed_push_explode/feed_push_explode_pressed_seq_v2.zip", QCirclePluginConfig.e()));
    }
    b.start();
  }
  
  private void c(int paramInt)
  {
    String str = getBusinessTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fuel is use up: ");
    localStringBuilder.append(paramInt);
    QLog.d(str, 1, localStringBuilder.toString());
    if (QCirclePluginGlobalInfo.h() != 1)
    {
      getShareInfo();
      k();
      return;
    }
    if (paramInt == 0)
    {
      QCirclePopupWindowHelper.a().a(getContext(), getContext().getString(2131895743));
      l();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (!c)
    {
      b.setListener(new QCircleRecommendImageView.4(this, paramBoolean));
      b.start();
      return;
    }
    try
    {
      RFThreadManager.getUIHandler().post(new QCircleRecommendImageView.5(this, paramBoolean));
      return;
    }
    catch (Exception localException)
    {
      String str = getBusinessTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playError ");
      localStringBuilder.append(localException.getMessage());
      QLog.i(str, 1, localStringBuilder.toString());
      localException.printStackTrace();
    }
  }
  
  private void d()
  {
    setPadding(this.C, this.D, this.E, this.F);
    try
    {
      if ((this.m != 1) && (this.m != 3) && (this.m != 4))
      {
        if (this.m == 2)
        {
          setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845067));
          setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845392));
          return;
        }
        if (this.m != 5) {
          break label173;
        }
        if (this.K != -1) {
          setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(this.K));
        }
        if (this.L == -1) {
          break label173;
        }
        setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(this.L));
        return;
      }
      setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845305));
      setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845393));
      return;
    }
    catch (Exception localException)
    {
      label162:
      label173:
      break label162;
    }
    QLog.e(getBusinessTag(), 1, "showUnRecommendView setBackgroundDrawable error");
  }
  
  private void d(int paramInt)
  {
    QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
    try
    {
      localStFeedBusiReqData.mergeFrom(this.h.busiData.get().toByteArray());
      if (localStFeedBusiReqData.pushList != null)
      {
        b(paramInt);
        this.e = paramInt;
        this.f = paramInt;
        str = getBusinessTag();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("hasLikeCount");
        localStringBuilder.append(this.e);
        QLog.d(str, 1, localStringBuilder.toString());
        QCircleProtoUtil.a(localStFeedBusiReqData.pushList, paramInt);
        this.i = localStFeedBusiReqData.pushList;
        this.h.busiData.set(ByteStringMicro.copyFrom(localStFeedBusiReqData.toByteArray()));
        return;
      }
    }
    catch (Exception localException)
    {
      String str = getBusinessTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("receiveEvent error");
      localStringBuilder.append(localException.getMessage());
      QLog.e(str, 1, localStringBuilder.toString());
      localException.printStackTrace();
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
  }
  
  private void e()
  {
    if (this.y)
    {
      int i1 = this.m;
      if (i1 == 2)
      {
        setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845067));
        return;
      }
      if ((i1 == 1) || (i1 == 3) || (i1 == 4))
      {
        setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845306));
        setWillNotDraw(true);
      }
    }
  }
  
  private void f()
  {
    if (this.k) {
      return;
    }
    Object localObject = this.j;
    if ((localObject != null) && (((QQAnimationDrawable)localObject).isRunning())) {
      return;
    }
    if (this.m == 5) {
      this.j = a("https://downv6.qq.com/video_story/qcircle/new_layer_mode/animation/pushAppear.zip");
    } else {
      this.j = a("https://downv6.qq.com/video_story/qcircle/animation/rocket_start.zip");
    }
    localObject = this.j;
    if (localObject == null)
    {
      QLog.d(getBusinessTag(), 1, "mStartAnimationDrawable is null");
      return;
    }
    ((QQAnimationDrawable)localObject).b(true);
    this.j.a(480L);
    this.j.a(new QCircleRecommendImageView.1(this));
    setImageDrawable(this.j);
    this.j.start();
    localObject = this.I;
    if (localObject != null) {
      ((Animation.AnimationListener)localObject).onAnimationStart(null);
    }
  }
  
  private void g()
  {
    Object localObject = this.l;
    if ((localObject != null) && (((QQAnimationDrawable)localObject).isRunning())) {
      return;
    }
    int i1 = this.m;
    if ((i1 != 2) && (i1 != 1) && (i1 != 3) && (i1 != 4))
    {
      if (i1 == 5)
      {
        if (this.f >= z) {
          this.l = a("https://downv6.qq.com/video_story/qcircle/new_layer_mode/animation/pushFinalDisappear.zip");
        } else {
          this.l = a("https://downv6.qq.com/video_story/qcircle/new_layer_mode/animation/pushDisappear.zip");
        }
      }
      else
      {
        localObject = getBusinessTag();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showEnd error pageType");
        localStringBuilder.append(this.m);
        QLog.e((String)localObject, 1, localStringBuilder.toString());
      }
    }
    else if (this.f >= z) {
      this.l = a("https://downv6.qq.com/video_story/wezone_url/defaultmode/8417/feed_push_explode/feed_push_explode_pressed_seq_v2.zip");
    } else {
      this.l = a("https://downv6.qq.com/video_story/qcircle/animation/rocket_end.zip");
    }
    localObject = this.l;
    if (localObject == null)
    {
      QLog.d(getBusinessTag(), 1, "mStartAnimationDrawable is null");
      return;
    }
    ((QQAnimationDrawable)localObject).b(true);
    this.l.a(250L);
    this.l.a(new QCircleRecommendImageView.2(this));
    postDelayed(new QCircleRecommendImageView.3(this), 250L);
    setImageDrawable(this.l);
    this.l.start();
  }
  
  private String getBusinessTag()
  {
    if (this.h != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QCircleRecommend_id:");
      localStringBuilder.append(this.h.id.get());
      return localStringBuilder.toString();
    }
    return "QCircleRecommend_";
  }
  
  private int getPushTimes()
  {
    FeedCloudMeta.StPushList localStPushList = this.i;
    if (localStPushList == null) {
      return 0;
    }
    return localStPushList.hasClickCount.get();
  }
  
  private void getShareInfo()
  {
    if (H) {
      return;
    }
    QCircleGetTaskCenterListRequest localQCircleGetTaskCenterListRequest = new QCircleGetTaskCenterListRequest(RFApplication.getInstance().getAccountId());
    localQCircleGetTaskCenterListRequest.setEnableCache(false);
    H = true;
    VSNetworkHelper.getInstance().sendRequest(getContext(), localQCircleGetTaskCenterListRequest, new QCircleRecommendImageView.7(this));
  }
  
  private void h()
  {
    QCirclePopupWindowHelper.a().a(getContext(), getContext().getResources().getString(2131895643));
  }
  
  private void i()
  {
    QCircleToast.a(QCircleToast.c, getResources().getString(2131895781, new Object[] { Integer.valueOf(z) }), 0);
  }
  
  private void j()
  {
    QCircleToast.a(QCircleToast.c, 2131895642, 0);
  }
  
  private void k()
  {
    if (this.h != null) {
      SimpleEventBus.getInstance().dispatchEvent(new QCirclePushBubbleEvent(0, this.h.id.get(), this.m));
    }
  }
  
  private void l()
  {
    QCircleTaskCenterEvent localQCircleTaskCenterEvent = new QCircleTaskCenterEvent(getContext().hashCode(), true);
    SimpleEventBus.getInstance().dispatchEvent(new QCirclePushBubbleEvent(0, "", this.m));
    SimpleEventBus.getInstance().dispatchEvent(localQCircleTaskCenterEvent);
  }
  
  private void m()
  {
    int i1;
    if (this.o - this.p > u) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i1 != 0) && (this.e >= 1) && (!q()))
    {
      r();
      return;
    }
    int i2 = this.f;
    int i3 = z;
    if (i2 >= i3)
    {
      if (this.e >= i3)
      {
        i();
        return;
      }
      this.G = true;
      return;
    }
    this.f = (i2 + 1);
    c(true);
    if (i1 != 0)
    {
      this.g = 1;
      SimpleEventBus.getInstance().dispatchEvent(new QCirclePushAnimationEvent(getFeedData().id.get(), 1, 1, this.m));
    }
    else
    {
      this.g += 1;
      SimpleEventBus.getInstance().dispatchEvent(new QCirclePushAnimationEvent(getFeedData().id.get(), this.g, 2, this.m));
    }
    QCirclePluginConfig.a().c(QCirclePluginConfig.a().D() - 1);
    a("clck", 1);
    p();
  }
  
  private void n()
  {
    o();
    this.w = new Timer();
    this.x = new QCircleRecommendImageView.LongPressTimerTask(this);
    Timer localTimer = this.w;
    QCircleRecommendImageView.LongPressTimerTask localLongPressTimerTask = this.x;
    int i1 = v;
    localTimer.schedule(localLongPressTimerTask, i1, i1);
  }
  
  private void o()
  {
    Timer localTimer = this.w;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.w.purge();
    }
  }
  
  private void p()
  {
    if (this.f >= z) {
      SimpleEventBus.getInstance().dispatchEvent(new QFSPushTenTimesEvent(getFeedData()));
    }
  }
  
  private boolean q()
  {
    return this.f != this.e;
  }
  
  private void r()
  {
    boolean bool1;
    if (this.f < z) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = QCirclePushInfoManager.a().d(this.h.id.get());
    QCirclePopupWindowHelper.a().a(this, bool1, bool2, new QCircleRecommendImageView.9(this), new QCircleRecommendImageView.10(this));
    o();
  }
  
  private void s()
  {
    if (this.f == this.e)
    {
      j();
      return;
    }
    QLog.e("QCircleRecommend_", 1, "is do pushing, need waiting and not stopping long press timer");
  }
  
  private void t()
  {
    int i1 = z - this.f;
    if (i1 >= 1) {
      a(i1, "ten_push_clck");
    }
  }
  
  private void u()
  {
    QCirclePushReportReqInterceptor localQCirclePushReportReqInterceptor = this.J;
    if (localQCirclePushReportReqInterceptor != null) {
      localQCirclePushReportReqInterceptor.a("long_press_cancel");
    }
    QCirclePushInfoManager.a().a(this.h, this.J);
  }
  
  protected void a()
  {
    this.k = false;
    b(getPushTimes());
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      this.f = this.e;
      RFThreadManager.getUIHandler().post(new QCircleRecommendImageView.8(this));
    }
    if (((paramObject1 instanceof QCircleDoRecommendRequest)) && ((paramObject2 instanceof FeedCloudWrite.StDoPushRsp)))
    {
      paramObject1 = (QCircleDoRecommendRequest)paramObject1;
      if ((paramObject1.getReq() != null) && (this.h != null) && (paramObject1.getReq().feed.id.get().equals(this.h.id.get())))
      {
        paramObject2 = (FeedCloudWrite.StDoPushRsp)paramObject2;
        if (paramLong == 0L)
        {
          paramString = getBusinessTag();
          paramBundle = new StringBuilder();
          paramBundle.append("req traceId:");
          paramBundle.append(paramObject1.getTraceId());
          QLog.d(paramString, 1, paramBundle.toString());
          paramString = getBusinessTag();
          paramBundle = new StringBuilder();
          paramBundle.append("QCircleDoRecommendRequest push success myFuel:");
          paramBundle.append(paramObject2.myFuel.get());
          paramBundle.append("consumeFuel");
          paramBundle.append(paramObject2.consumeFuel.get());
          QLog.d(paramString, 1, paramBundle.toString());
          a(paramObject2.myFuel.get(), paramObject2.consumeFuel.get());
        }
        else if (paramLong == 700207L)
        {
          QLog.d(getBusinessTag(), 1, "CW_HAVE_PUSH_MAX_CNT");
          i();
        }
        else if (paramLong == 700202L)
        {
          if (QCirclePluginGlobalInfo.h() != 1)
          {
            k();
          }
          else
          {
            QCirclePopupWindowHelper.a().a(getContext(), getContext().getString(2131895742));
            l();
          }
        }
        else
        {
          paramBundle = getBusinessTag();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("net_error");
          localStringBuilder.append(paramLong);
          QLog.d(paramBundle, 1, localStringBuilder.toString());
          b(paramString);
        }
        b(getPushTimes());
        this.f = this.e;
        a(this.h, paramObject2, paramObject1);
        if (QCircleTipsUtil.b())
        {
          paramString = QCircleTipsUtil.a(1);
          if (paramString != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePushBubbleEvent(4, this.h.id.get(), this.m, paramString));
          }
        }
      }
      else
      {
        QLog.d("QCircleRecommend_", 1, "unExceptOnReceive");
      }
    }
  }
  
  protected void b()
  {
    this.C = getPaddingLeft();
    this.D = getPaddingTop();
    this.E = getPaddingRight();
    this.F = getPaddingBottom();
    d();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  @QCircleFeedClick
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    JoinPoint localJoinPoint = Factory.makeJP(P, this, this, paramMotionEvent);
    return Conversions.booleanValue(a(this, paramMotionEvent, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint));
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePushAnimationStateEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    localArrayList.add(QCircleUndoPushUpdateEvent.class);
    return localArrayList;
  }
  
  public FeedCloudMeta.StFeed getFeedData()
  {
    return this.h;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
    QCircleSkinHelper.getInstance().registerOnThemeUpdateListener(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QCircleSkinHelper.getInstance().unregisterOnThemeUpdateListener(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent.mHashCode != hashCode()) && (this.h != null))
    {
      Object localObject;
      if ((paramSimpleBaseEvent instanceof QCirclePushAnimationStateEvent))
      {
        localObject = (QCirclePushAnimationStateEvent)paramSimpleBaseEvent;
        if ((((QCirclePushAnimationStateEvent)localObject).mTargetFeedId.equals(this.h.id.get())) && (((QCirclePushAnimationStateEvent)localObject).mSceneType == this.m))
        {
          String str = getBusinessTag();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mTargetFeedId:");
          localStringBuilder.append(((QCirclePushAnimationStateEvent)localObject).mTargetFeedId);
          localStringBuilder.append("mPage");
          localStringBuilder.append(((QCirclePushAnimationStateEvent)localObject).mSceneType);
          QLog.d(str, 1, localStringBuilder.toString());
          if (this.G)
          {
            i();
            this.G = false;
          }
          c(false);
        }
      }
      if ((paramSimpleBaseEvent instanceof QCirclePushUpdateEvent))
      {
        localObject = (QCirclePushUpdateEvent)paramSimpleBaseEvent;
        if (((QCirclePushUpdateEvent)localObject).mTargetFeedId.equals(this.h.id.get()))
        {
          QLog.d(getBusinessTag(), 1, "updateFeedPushInfo");
          d(((QCirclePushUpdateEvent)localObject).mAllPushTimes);
        }
      }
      if (((paramSimpleBaseEvent instanceof QCircleUndoPushUpdateEvent)) && (((QCircleUndoPushUpdateEvent)paramSimpleBaseEvent).mTargetFeedId.equals(this.h.id.get()))) {
        d(0);
      }
      return;
    }
    QLog.d(getBusinessTag(), 1, "receive event sent by self or feed is null");
  }
  
  public void onThemeUpdate()
  {
    b(this.f);
  }
  
  public void setEnableCancelPush(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public void setExtraTypeInfo(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.O = paramQCircleExtraTypeInfo;
  }
  
  public void setFeedData(FeedBlockData paramFeedBlockData, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed = paramFeedBlockData.b();
    this.m = paramInt;
    if ((localStFeed != null) && (localStFeed.busiData.get() != null))
    {
      this.h = localStFeed;
      try
      {
        Object localObject = (QQCircleFeedBase.StFeedBusiReqData)paramFeedBlockData.a("DITTO_FEED_BUSI_REQ_DATA");
        paramFeedBlockData = (FeedBlockData)localObject;
        if (localObject == null)
        {
          paramFeedBlockData = new QQCircleFeedBase.StFeedBusiReqData();
          paramFeedBlockData.mergeFrom(localStFeed.busiData.get().toByteArray());
        }
        this.i = paramFeedBlockData.pushList;
        if (this.i != null)
        {
          QCirclePushInfoManager.a().a(localStFeed.id.get(), this.i);
          this.e = this.i.hasClickCount.get();
          this.f = this.e;
          paramFeedBlockData = getBusinessTag();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("hashCode");
          ((StringBuilder)localObject).append(hashCode());
          ((StringBuilder)localObject).append("feedId:");
          ((StringBuilder)localObject).append(this.h.id.get());
          ((StringBuilder)localObject).append("  hasClickCount");
          ((StringBuilder)localObject).append(this.e);
          QLog.d(paramFeedBlockData, 1, ((StringBuilder)localObject).toString());
        }
      }
      catch (Exception paramFeedBlockData)
      {
        QLog.e("QCircleRecommend_", 1, paramFeedBlockData, new Object[0]);
      }
      b(this.e);
    }
  }
  
  public void setPageType(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setPushAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.I = paramAnimationListener;
  }
  
  public void setPushReportReqInterceptor(QCirclePushReportReqInterceptor paramQCirclePushReportReqInterceptor)
  {
    this.J = paramQCirclePushReportReqInterceptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView
 * JD-Core Version:    0.7.0.1
 */