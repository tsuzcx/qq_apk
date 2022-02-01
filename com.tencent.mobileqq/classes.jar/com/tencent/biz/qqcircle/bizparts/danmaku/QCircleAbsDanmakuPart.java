package com.tencent.biz.qqcircle.bizparts.danmaku;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.comment.QCircleCommentBusiness;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.fragments.content.ImmersiveEventHelper;
import com.tencent.biz.qqcircle.manager.QCircleSwitchConfigManager;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public abstract class QCircleAbsDanmakuPart
  extends QCircleBasePart
  implements QCircleDanmakuSmartView.OnDanmakuSmartCallback, SimpleEventReceiver
{
  private QCircleDanmakuSmartView a;
  private QCircleCommentInfo c;
  private volatile String d;
  private boolean e = true;
  private boolean f = false;
  private boolean g = false;
  private View h;
  private ImmersiveEventHelper i;
  
  public QCircleAbsDanmakuPart()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    w();
  }
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, String paramString)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setExt1(paramString).setPageId(f()).setfpageid(e()));
      return;
    }
    QLog.e("QCircleReportHelper_Refactor-QCircleAbsDanmakuPart", 2, "ExtraTypeInfo is null or lost feed,actionType:84,subActionType:1");
  }
  
  private void a(QCircleContentImmersiveEvent paramQCircleContentImmersiveEvent)
  {
    QLog.d("Refactor-QCircleAbsDanmakuPart", 2, new Object[] { "[handlerQCircleContentImmersiveEvent] isImmersive: ", Boolean.valueOf(QCircleContentImmersiveEvent.isImmersive()) });
    if (QCircleContentImmersiveEvent.isImmersive())
    {
      n();
      q();
      return;
    }
    if (!this.g)
    {
      l();
      return;
    }
    if (m()) {
      p();
    }
  }
  
  private void a(QCircleDanmakuEvent paramQCircleDanmakuEvent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("event.eventStatus: ");
      localStringBuilder.append(paramQCircleDanmakuEvent.eventStatus);
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, localStringBuilder.toString());
    }
    a(paramQCircleDanmakuEvent.isCommentPanelOpen);
    switch (paramQCircleDanmakuEvent.eventStatus)
    {
    default: 
    case 11: 
      a(paramQCircleDanmakuEvent.commentInfo);
      return;
    case 10: 
      this.e = false;
      QCircleSwitchConfigManager.a().a(false);
      o();
      return;
    case 9: 
      this.e = true;
      QCircleSwitchConfigManager.a().a(true);
      l();
      return;
    case 8: 
      if (m())
      {
        p();
        return;
      }
      break;
    case 7: 
      if (n())
      {
        q();
        return;
      }
      break;
    case 6: 
      q();
      return;
    case 5: 
      p();
      return;
    case 4: 
      m();
      return;
    case 3: 
      n();
      return;
    case 2: 
      o();
      return;
    case 1: 
      l();
    }
  }
  
  private String c(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.id == null) {
      paramStFeed = "";
    } else {
      paramStFeed = paramStFeed.id.get();
    }
    QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = s();
    Object localObject = paramStFeed;
    if (localStBusiInfoCommentListData != null)
    {
      localObject = paramStFeed;
      if (localStBusiInfoCommentListData.comment != null)
      {
        localObject = paramStFeed;
        if (localStBusiInfoCommentListData.reply != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramStFeed);
          ((StringBuilder)localObject).append(localStBusiInfoCommentListData.comment.id.get());
          ((StringBuilder)localObject).append(localStBusiInfoCommentListData.reply.id.get());
          localObject = ((StringBuilder)localObject).toString();
        }
      }
    }
    return localObject;
  }
  
  private boolean d(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed != null) && (paramStFeed.type != null) && (2 == paramStFeed.type.get());
  }
  
  private QQCircleFeedBase.StBusiInfoCommentListData s()
  {
    try
    {
      Object localObject = t();
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      localObject = ((QCircleInitBean)localObject).getBusiInfoData();
      if (localObject != null) {
        localStBusiInfoCommentListData.mergeFrom((byte[])localObject);
      }
      localStBusiInfoCommentListData.setHasFlag(true);
      return localStBusiInfoCommentListData;
    }
    catch (Exception localException)
    {
      QLog.e("Refactor-QCircleAbsDanmakuPart", 2, localException, new Object[0]);
    }
    return null;
  }
  
  private QCircleInitBean t()
  {
    return (QCircleInitBean)((Activity)g()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
  }
  
  private boolean u()
  {
    return 57 == f();
  }
  
  private QCircleExtraTypeInfo v()
  {
    if (E() != null) {
      return (QCircleExtraTypeInfo)d("get_report_extra_type_info", "");
    }
    return null;
  }
  
  private void w()
  {
    QCircleContentImmersiveEvent.resetImmersive();
    this.i = new ImmersiveEventHelper();
    this.i.a(this.h);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (r())
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[onInitView] current activity is finishing state, exit handler.");
      return;
    }
    if (!(paramView instanceof ViewGroup))
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[onInitView] current root view not is view group, exit handler.");
      return;
    }
    QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[onInitView] init view...");
    ViewGroup localViewGroup = (ViewGroup)paramView;
    this.h = paramView;
    this.a = new QCircleDanmakuSmartView(g());
    this.a.setOnDanmakuSmartCallback(this);
    this.a.setContentDetailPage(u());
    localViewGroup.addView(this.a);
  }
  
  public void a(@NonNull QCircleCommentInfo paramQCircleCommentInfo)
  {
    FeedCloudMeta.StFeed localStFeed = paramQCircleCommentInfo.b;
    if (localStFeed == null)
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[loadData] feed == null.");
      return;
    }
    String str = c(localStFeed);
    if (TextUtils.isEmpty(str))
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[loadData] real cell id is empty.");
      return;
    }
    if (TextUtils.equals(str, this.d)) {
      return;
    }
    this.d = str;
    o();
    QCircleDanmakuSmartView localQCircleDanmakuSmartView = this.a;
    if (localQCircleDanmakuSmartView != null)
    {
      localQCircleDanmakuSmartView.a(paramQCircleCommentInfo);
      this.c = paramQCircleCommentInfo;
    }
    paramQCircleCommentInfo = QCircleCommentBusiness.a().c(str);
    QLog.d("Refactor-QCircleAbsDanmakuPart", 2, new Object[] { "[loadData] real cell id: ", str });
    if ((paramQCircleCommentInfo != null) && (paramQCircleCommentInfo.size() > 0))
    {
      if (QCircleSwitchConfigManager.a().b()) {
        l();
      }
    }
    else {
      QCircleCommentBusiness.a().a(2, localStFeed, false);
    }
  }
  
  public void a(QCircleDanmakuSmartView.DoLikeSuccessParam paramDoLikeSuccessParam)
  {
    int j = paramDoLikeSuccessParam.a;
    String str1 = paramDoLikeSuccessParam.b;
    int k = paramDoLikeSuccessParam.d;
    String str2 = paramDoLikeSuccessParam.c;
    paramDoLikeSuccessParam = this.c.b;
    if ((paramDoLikeSuccessParam != null) && (paramDoLikeSuccessParam.id != null)) {
      paramDoLikeSuccessParam = paramDoLikeSuccessParam.id.get();
    } else {
      paramDoLikeSuccessParam = "";
    }
    SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentPraiseUpdateEvent(j, 1, paramDoLikeSuccessParam, str2, str1, k));
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = v();
    if (d(paramStFeed)) {
      paramStFeed = "1";
    } else {
      paramStFeed = "2";
    }
    a(84, 2, localQCircleExtraTypeInfo, paramStFeed);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void b(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = v();
    if (d(paramStFeed)) {
      paramStFeed = "1";
    } else {
      paramStFeed = "2";
    }
    a(84, 1, localQCircleExtraTypeInfo, paramStFeed);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleDanmakuEvent.class);
    localArrayList.add(QCircleContentImmersiveEvent.class);
    return localArrayList;
  }
  
  public void i()
  {
    o();
    ImmersiveEventHelper localImmersiveEventHelper = this.i;
    if (localImmersiveEventHelper != null) {
      localImmersiveEventHelper.a();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  protected void l()
  {
    if (this.g) {
      return;
    }
    if (QCircleContentImmersiveEvent.isImmersive())
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[handlerOpenDanmaku] content is immersive state.");
      return;
    }
    if (!this.e)
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[handlerOpenDanmaku] danmaku current barrage is false.");
      return;
    }
    if (TextUtils.isEmpty(this.d))
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[handlerOpenDanmaku] open danmaku request call id not is empty.");
      return;
    }
    if (this.a != null)
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, new Object[] { "[handlerOpenDanmaku] request cell id: ", this.d });
      ArrayList localArrayList = QCircleCommentBusiness.a().c(this.d);
      this.a.a(localArrayList);
      this.g = true;
      return;
    }
    QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[handlerOpenDanmaku] danmaku smart is null.");
  }
  
  protected boolean m()
  {
    if (!this.g)
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[handlerResume] no open danmaku, not resume.");
      return false;
    }
    if (QCircleContentImmersiveEvent.isImmersive())
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[handlerResume] content is immersive state.");
      return false;
    }
    if (!this.e)
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[handlerResume] current barrage open is false.");
      return false;
    }
    if (this.f)
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[handlerResume] comment panel open is true.");
      return false;
    }
    if (this.a == null)
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[handlerResume] danmaku smart is null.");
      return false;
    }
    QLog.d("Refactor-QCircleAbsDanmakuPart", 2, new Object[] { "[handlerResume] request cell id: ", this.d });
    return this.a.c();
  }
  
  protected boolean n()
  {
    if (this.a == null)
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[handlerPause] danmaku smart is null.");
      return false;
    }
    QLog.d("Refactor-QCircleAbsDanmakuPart", 2, new Object[] { "[handlerPause] request cell id: ", this.d });
    return this.a.d();
  }
  
  protected void o()
  {
    if (this.a != null)
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, new Object[] { "[handlerRelease] request cell id: ", this.d });
      this.a.e();
    }
    this.g = false;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleDanmakuEvent))
    {
      a((QCircleDanmakuEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleContentImmersiveEvent)) {
      a((QCircleContentImmersiveEvent)paramSimpleBaseEvent);
    }
  }
  
  protected void p()
  {
    if (!this.e)
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[setDanmakuLayerToVisible] barrage open is true.");
      return;
    }
    if (this.a == null)
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[setDanmakuLayerToVisible] danmaku smart is null.");
      return;
    }
    QLog.d("Refactor-QCircleAbsDanmakuPart", 2, new Object[] { "[setDanmakuLayerToVisible] request cell id: ", this.d });
    this.a.a();
  }
  
  protected void q()
  {
    if (this.a == null)
    {
      QLog.d("Refactor-QCircleAbsDanmakuPart", 2, "[setDanmakuLayerToGone] danmaku smart is null.");
      return;
    }
    QLog.d("Refactor-QCircleAbsDanmakuPart", 2, new Object[] { "[setDanmakuLayerToGone] request cell id: ", this.d });
    this.a.b();
  }
  
  protected abstract boolean r();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.QCircleAbsDanmakuPart
 * JD-Core Version:    0.7.0.1
 */