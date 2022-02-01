package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentPart;
import com.tencent.biz.qqcircle.immersive.adapter.QFSLayerPageAdapter;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSFeedPositionChangeEvent;
import com.tencent.biz.qqcircle.immersive.manager.QFSPictureReloadManager;
import com.tencent.biz.qqcircle.immersive.utils.QFSSafeListUtils;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;

public class QFSLayerBasePart
  extends QFSBasePart
  implements SimpleEventReceiver
{
  protected QFSPageTurnContainer a;
  protected QFSLayerPageAdapter b;
  protected int c = -1;
  protected int d = -1;
  protected QCircleStatusView e;
  protected QCirclePanelLoadingView f;
  protected boolean g;
  private QFSFeedPositionChangeEvent h;
  
  private void a(String paramString, int paramInt, FeedBlockData paramFeedBlockData)
  {
    if (paramFeedBlockData == null) {
      paramFeedBlockData = null;
    } else {
      paramFeedBlockData = paramFeedBlockData.b();
    }
    if (paramFeedBlockData == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!paramString.equals(paramFeedBlockData.poster.id.get())) {
      return;
    }
    try
    {
      this.b.delete(paramInt);
      this.b.notifyItemRemoved(paramInt);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("QFSLayerBasePart", 1, "onReceiveEvent() delete local feed error!", paramString);
    }
  }
  
  private void c(int paramInt)
  {
    QFSFeedPositionChangeEvent localQFSFeedPositionChangeEvent = this.h;
    if (localQFSFeedPositionChangeEvent == null) {
      this.h = new QFSFeedPositionChangeEvent(paramInt);
    } else {
      localQFSFeedPositionChangeEvent.setPosition(paramInt);
    }
    SimpleEventBus.getInstance().dispatchEvent(this.h);
  }
  
  private void c(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (paramQCircleFeedEvent == null) {
      return;
    }
    a(paramQCircleFeedEvent);
    if (paramQCircleFeedEvent.mState == 3)
    {
      d(paramQCircleFeedEvent);
      t();
      return;
    }
    if (paramQCircleFeedEvent.mState == 6)
    {
      b(paramQCircleFeedEvent);
      t();
    }
  }
  
  private void d()
  {
    e();
  }
  
  private void d(int paramInt)
  {
    RFThreadManager.getUIHandler().post(new QFSLayerBasePart.4(this, paramInt));
  }
  
  private void d(QCircleFeedEvent paramQCircleFeedEvent)
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    boolean bool = ((QFSLayerPageAdapter)localObject).b(paramQCircleFeedEvent.mTargetId);
    localObject = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleFSFeedEvent removeFeed  feedId = ");
    localStringBuilder.append(paramQCircleFeedEvent.mTargetId);
    localStringBuilder.append(" | result = ");
    localStringBuilder.append(bool);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (bool) {
      b(false);
    }
  }
  
  private void e()
  {
    this.a.getViewPager2().registerOnPageChangeCallback(new QFSLayerBasePart.2(this));
    this.a.setOnLoadDataCallback(new QFSLayerBasePart.3(this));
  }
  
  private void f()
  {
    QFSLayerPageAdapter localQFSLayerPageAdapter = this.b;
    if ((localQFSLayerPageAdapter != null) && (localQFSLayerPageAdapter.getDataList() != null))
    {
      if (this.b.getDataList().size() <= this.d) {
        return;
      }
      c("layer_notify_part_update_feed", (FeedBlockData)QFSSafeListUtils.a(this.b.getDataList(), this.d));
    }
  }
  
  private void t()
  {
    if ((s()) && (c() != null)) {
      c().onBackPressed();
    }
  }
  
  public String a()
  {
    return "QFSLayerBasePart";
  }
  
  protected void a(int paramInt)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle mLayerPageContainer onPageSelected  position = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , mCurrentFeedPos = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" , mLastFeedPos = ");
    localStringBuilder.append(this.c);
    QLog.d(str, 1, localStringBuilder.toString());
    int i = this.d;
    if ((i != -1) && (i != paramInt)) {
      d(i);
    }
    this.d = paramInt;
    b(this.d);
    f();
    c(paramInt);
  }
  
  protected void a(long paramLong, String paramString)
  {
    o();
    if (a(paramLong))
    {
      r().clearData();
      r().notifyDataSetChanged();
      this.e.c(paramString);
      this.a.e();
      return;
    }
    if (s())
    {
      this.e.c(paramString);
      this.a.e();
      return;
    }
    QCircleToastUtil.a(paramLong, QCircleToast.c, paramString, 1);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((QFSPageTurnContainer)paramView.findViewById(2131433854));
    this.b = new QFSLayerPageAdapter();
    this.a.getViewPager2().setAdapter(this.b);
    this.a.setChildDisallowInterceptListener(new QFSLayerBasePart.1(this));
    this.e = ((QCircleStatusView)paramView.findViewById(2131433848));
    this.e.setForceBlackStyle(true);
    this.f = ((QCirclePanelLoadingView)paramView.findViewById(2131433853));
    this.a.d(true);
    d();
  }
  
  protected void a(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (this.b != null)
    {
      if (this.a == null) {
        return;
      }
      boolean bool2 = false;
      boolean bool1;
      if (paramQCircleFeedEvent.mState == 3)
      {
        bool1 = this.b.a(paramQCircleFeedEvent.mTargetId);
      }
      else
      {
        bool1 = bool2;
        if (paramQCircleFeedEvent.mState == 6)
        {
          bool1 = bool2;
          if (TextUtils.equals(String.valueOf(i()), "pg_ks_following_page")) {
            bool1 = this.b.c(paramQCircleFeedEvent.mTargetId);
          }
        }
      }
      if (!bool1) {
        return;
      }
      String str = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyFeedDeleteChangeBefore needRemove , event : ");
      localStringBuilder.append(paramQCircleFeedEvent.toString());
      QLog.i(str, 1, localStringBuilder.toString());
      paramQCircleFeedEvent = new QFSFeedSelectInfo(this.a.getViewPager2().getCurrentItem()).a(1);
      this.b.e(paramQCircleFeedEvent);
    }
  }
  
  protected void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("listUIStateData = ");
    localStringBuilder.append(paramUIStateData.c());
    QLog.d(str, 1, localStringBuilder.toString());
    if (q() != null)
    {
      if (r() == null) {
        return;
      }
      int i = paramUIStateData.c();
      if (i != 0)
      {
        if (i != 1)
        {
          if ((i != 2) && (i != 3))
          {
            if (i != 4)
            {
              if (i == 5) {
                a(paramUIStateData, true);
              }
            }
            else
            {
              QLog.e(a(), 1, "handleFeedsRsp() return error status");
              if (paramUIStateData.f() == null) {
                str = HardCodeUtil.a(2131895632);
              } else {
                str = paramUIStateData.f();
              }
              a(paramUIStateData.g(), str);
            }
          }
          else
          {
            str = a();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleFeedsRsp() return success  , size = ");
            localStringBuilder.append(((List)paramUIStateData.e()).size());
            localStringBuilder.append(" , isLoadMore = ");
            localStringBuilder.append(paramUIStateData.i());
            localStringBuilder.append(" , isFinish = ");
            localStringBuilder.append(paramUIStateData.h());
            QLog.i(str, 1, localStringBuilder.toString());
            a(paramUIStateData, false);
          }
        }
        else
        {
          QLog.e(a(), 1, "handleLoadState()");
          n();
        }
      }
      else
      {
        QLog.e(a(), 1, "handleEmptyState() return empty data");
        p();
      }
      if (i != 1)
      {
        this.a.a(paramUIStateData.h() ^ true);
        this.a.b(paramUIStateData.h() ^ true);
      }
    }
  }
  
  protected void a(UIStateData<List<FeedBlockData>> paramUIStateData, boolean paramBoolean)
  {
    o();
    QCircleStatusView localQCircleStatusView = this.e;
    if (localQCircleStatusView == null) {
      return;
    }
    localQCircleStatusView.c();
    this.a.f();
    if (paramUIStateData.i())
    {
      b(paramUIStateData);
    }
    else
    {
      this.b.a(paramUIStateData);
      if (this.b.getDataList().size() == 0) {
        return;
      }
      int i;
      if (paramBoolean) {
        i = paramUIStateData.j();
      } else {
        i = 0;
      }
      if (this.a.getViewPager2().getCurrentItem() != i) {
        this.a.getViewPager2().setCurrentItem(i, false);
      } else {
        a(i);
      }
    }
    QFSPictureReloadManager.a().a((List)paramUIStateData.e());
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected boolean a(long paramLong)
  {
    return (paramLong == 10009L) || (QCircleContentPart.a(paramLong));
  }
  
  protected void b(int paramInt)
  {
    RFThreadManager.getUIHandler().postDelayed(new QFSLayerBasePart.5(this, paramInt), 100L);
  }
  
  protected void b(QCircleFeedEvent paramQCircleFeedEvent)
  {
    paramQCircleFeedEvent = paramQCircleFeedEvent.mTargetId;
    if (TextUtils.isEmpty(paramQCircleFeedEvent)) {
      return;
    }
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = ((QFSLayerPageAdapter)localObject).getDataList();
    if (localObject == null) {
      return;
    }
    int i = ((ArrayList)localObject).size() - 1;
    while (i >= 0)
    {
      a(paramQCircleFeedEvent, i, (FeedBlockData)((ArrayList)localObject).get(i));
      i -= 1;
    }
    b(true);
  }
  
  protected void b(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    this.b.a(paramUIStateData);
  }
  
  public void b(boolean paramBoolean)
  {
    Handler localHandler = RFThreadManager.getUIHandler();
    QFSLayerBasePart.6 local6 = new QFSLayerBasePart.6(this);
    long l;
    if (paramBoolean) {
      l = 0L;
    } else {
      l = 200L;
    }
    localHandler.postDelayed(local6, l);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  protected void n()
  {
    if (!s()) {
      return;
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((QCircleStatusView)localObject).c();
    }
    localObject = this.f;
    if (localObject != null) {
      ((QCirclePanelLoadingView)localObject).a();
    }
  }
  
  protected void o()
  {
    QCirclePanelLoadingView localQCirclePanelLoadingView = this.f;
    if (localQCirclePanelLoadingView != null) {
      localQCirclePanelLoadingView.b();
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onActivityDestroyed  mCurrentFeedPos = ");
    localStringBuilder.append(this.d);
    QLog.d(str, 1, localStringBuilder.toString());
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.b();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onActivityPaused  mCurrentFeedPos = ");
    localStringBuilder.append(this.d);
    QLog.d(str, 1, localStringBuilder.toString());
    super.onActivityPaused(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.b(new QFSFeedSelectInfo(this.d));
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onActivityResumed  mCurrentFeedPos = ");
    localStringBuilder.append(this.d);
    QLog.d(str, 1, localStringBuilder.toString());
    super.onActivityResumed(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.a(new QFSFeedSelectInfo(this.d));
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onActivityStopped  mCurrentFeedPos = ");
    localStringBuilder.append(this.d);
    QLog.d(str, 1, localStringBuilder.toString());
    super.onActivityStopped(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.c(new QFSFeedSelectInfo(this.d));
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent)) {
      c((QCircleFeedEvent)paramSimpleBaseEvent);
    }
  }
  
  protected void p()
  {
    o();
    if (s())
    {
      this.e.a("");
      this.a.e();
    }
  }
  
  public QFSPageTurnContainer q()
  {
    return this.a;
  }
  
  public QFSLayerPageAdapter r()
  {
    return this.b;
  }
  
  protected boolean s()
  {
    return r().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
 * JD-Core Version:    0.7.0.1
 */