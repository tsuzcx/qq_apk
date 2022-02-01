package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.QCircleCollection;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.immersive.adapter.QFSLayerPageAdapter;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSLayerHeadViewRefreshInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSRecentlyFeedStateData;
import com.tencent.biz.qqcircle.immersive.events.QFSFolderLazyInitEvent;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSTabFragmentIoc;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.richframework.part.utils.ArrayUtils;
import com.tencent.biz.qqcircle.viewmodels.QCircleTabFeedViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleColdBootService;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.event.QCircleFeedOptEvent;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.event.QCirclePublishBoxStatusEvent;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleCounter.RedPointInfo;
import qqcircle.QQCircleFeedBase.StPageRedPointInfo;

public class QFSLayerTabPart
  extends QFSLayerBasePart
  implements IQFSFeedIoc
{
  private static final long h = QCircleConfigHelper.aF();
  private final QCircleTabFeedViewModel i;
  private final QCircleTabInfo j;
  private int k;
  private IQFSTabFragmentIoc l;
  private int m;
  private String n = null;
  private boolean o;
  private byte[] p;
  private QQCircleFeedBase.StPageRedPointInfo q;
  private boolean r;
  private boolean s;
  private QCircleInitBean t;
  
  public QFSLayerTabPart(QCircleTabInfo paramQCircleTabInfo)
  {
    I();
    this.j = paramQCircleTabInfo;
    this.i = new QCircleTabFeedViewModel();
    this.i.a(paramQCircleTabInfo);
    QCircleFeedDataCenter.a().a(String.valueOf(paramQCircleTabInfo.a()), this.i);
    this.k = 0;
  }
  
  private void H()
  {
    if ((c() != null) && (c().getIntent() != null))
    {
      Object localObject = (QCircleFolderBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      int i1 = ((QCircleFolderBean)localObject).getQQCircleUnreadRedNum();
      boolean bool2 = false;
      if (i1 > 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        if (((QCircleFolderBean)localObject).getQQCircleUnreadRedNum() > EeveeRedpointUtil.getFolderMessageNoticeBubbleLastExposeNum()) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.o = bool1;
      }
      this.p = ((QCircleFolderBean)localObject).getRedDotTransInfo();
      localObject = this.p;
      if ((localObject != null) && (localObject.length > 0)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      boolean bool1 = bool2;
      if (!this.o)
      {
        bool1 = bool2;
        if (i1 == 0)
        {
          bool1 = bool2;
          if (!this.r) {
            bool1 = true;
          }
        }
      }
      this.g = bool1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enableMemCache:");
      ((StringBuilder)localObject).append(this.g);
      QLog.d("QFSLayerTabPart", 1, ((StringBuilder)localObject).toString());
      if (!this.g) {
        ((IQCircleColdBootService)QRoute.api(IQCircleColdBootService.class)).clear(this.j.c());
      }
    }
  }
  
  private void I()
  {
    if (c() == null) {
      return;
    }
    if (this.t != null) {
      return;
    }
    Object localObject = c().getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("key_bundle_common_init_bean")))
    {
      localObject = ((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean");
      if ((localObject instanceof QCircleInitBean)) {
        this.t = ((QCircleInitBean)localObject);
      }
    }
  }
  
  private void J()
  {
    this.i.d().observe(m(), new QFSLayerTabPart.2(this));
    K();
  }
  
  private void K()
  {
    this.a.setOnRefreshViewStatusListener(new QFSLayerTabPart.3(this));
    L();
    v();
  }
  
  private void L()
  {
    QCircleTabFeedViewModel localQCircleTabFeedViewModel = this.i;
    if (localQCircleTabFeedViewModel != null)
    {
      localQCircleTabFeedViewModel.a(d(this.j.a()));
      this.i.a(this.q);
    }
  }
  
  private boolean M()
  {
    return this.j.a() == 1;
  }
  
  private void N()
  {
    if (!TextUtils.isEmpty(this.n)) {
      u();
    }
  }
  
  private boolean O()
  {
    return d() == bl_();
  }
  
  private void P()
  {
    SimpleEventBus.getInstance().dispatchEvent(new QFSFolderLazyInitEvent(1, h * 2L, true));
    SimpleEventBus.getInstance().dispatchEvent(new QFSFolderLazyInitEvent(2, h * 4L, false));
  }
  
  private List<FeedCloudMeta.StFeed> a(ArrayList<FeedBlockData> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((FeedBlockData)paramArrayList.next()).b());
    }
    return localArrayList;
  }
  
  private void a(QCircleFeedOptEvent paramQCircleFeedOptEvent)
  {
    if (paramQCircleFeedOptEvent.getOptType() == 1) {
      A();
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, float paramFloat)
  {
    if (paramBoolean) {
      return;
    }
    QFSLayerHeadViewRefreshInfo localQFSLayerHeadViewRefreshInfo = new QFSLayerHeadViewRefreshInfo(paramInt);
    localQFSLayerHeadViewRefreshInfo.a(paramFloat);
    this.l.a("event_layer_head_view_refresh_status", new Object[] { localQFSLayerHeadViewRefreshInfo });
  }
  
  private String d(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 6) {
        return QCircleBaseTabFragment.f;
      }
      return QCircleBaseTabFragment.e;
    }
    return QCircleBaseTabFragment.d;
  }
  
  private void e(int paramInt)
  {
    if ((this.b != null) && (!ArrayUtils.a(paramInt, this.b.getDataList())))
    {
      if (!O()) {
        return;
      }
      FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.b.getDataList().get(paramInt)).b();
      QFSRecentlyFeedStateData localQFSRecentlyFeedStateData = new QFSRecentlyFeedStateData();
      localQFSRecentlyFeedStateData.a = localStFeed;
      localQFSRecentlyFeedStateData.b = ((FeedCloudMeta.StUser)localStFeed.poster.get());
      QCircleFeedDataCenter.a().c().postValue(localQFSRecentlyFeedStateData);
    }
  }
  
  protected void A()
  {
    if (this.b != null)
    {
      if (this.a == null) {
        return;
      }
      QFSFeedSelectInfo localQFSFeedSelectInfo = new QFSFeedSelectInfo(this.a.getViewPager2().getCurrentItem());
      this.b.e(localQFSFeedSelectInfo);
      this.a.getViewPager2().setCurrentItem(0, true);
    }
  }
  
  protected void B()
  {
    RFThreadManager.getUIHandler().postDelayed(new QFSLayerTabPart.5(this), h);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QFSLayerTabPart_");
    Object localObject = this.j;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((QCircleTabInfo)localObject).b();
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    e(paramInt);
    if (paramInt > 0) {
      QFSMessageNoticePart.p();
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b.a(this);
    J();
  }
  
  public void a(IQFSTabFragmentIoc paramIQFSTabFragmentIoc)
  {
    this.l = paramIQFSTabFragmentIoc;
  }
  
  protected void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    super.a(paramUIStateData);
    if (paramUIStateData == null) {
      return;
    }
    if (!paramUIStateData.i()) {
      QLog.d(a(), 1, "handleFeedDataRsp is refresh clearLocalRedPoint");
    }
    if (((paramUIStateData.c() == 3) || (paramUIStateData.c() == 5)) && (O()))
    {
      QCirclePeriodCollect.record(String.valueOf(this.j.c()), "page_loaded");
      B();
      P();
    }
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    IQFSTabFragmentIoc localIQFSTabFragmentIoc = this.l;
    if (localIQFSTabFragmentIoc != null) {
      localIQFSTabFragmentIoc.a(paramString, paramVarArgs);
    }
    if (("event_set_viewpager_enable".equals(paramString)) && (paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof Boolean)) && (this.a != null)) {
      this.a.d(((Boolean)paramVarArgs[0]).booleanValue());
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    y();
    if (paramBoolean1)
    {
      QLog.i(a(), 1, "requestData() loadMore");
      this.i.a(this.k);
      return;
    }
    QLog.i(a(), 1, "requestData() refresh");
    this.i.a(paramBoolean2, this.k, w());
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    e(paramInt);
  }
  
  protected void b(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (this.j.c() != 40) {
      return;
    }
    if (paramQCircleFeedEvent.mState == 6)
    {
      if (this.b == null) {
        return;
      }
      this.n = paramQCircleFeedEvent.mTargetId;
      N();
    }
  }
  
  public int bk_()
  {
    return this.d;
  }
  
  public int bl_()
  {
    IQFSTabFragmentIoc localIQFSTabFragmentIoc = this.l;
    if (localIQFSTabFragmentIoc != null) {
      return localIQFSTabFragmentIoc.bl_();
    }
    return -1;
  }
  
  public void c(int paramInt)
  {
    this.m = paramInt;
  }
  
  public int d()
  {
    return this.m;
  }
  
  public QCircleInitBean e()
  {
    I();
    return this.t;
  }
  
  public int f()
  {
    IQFSTabFragmentIoc localIQFSTabFragmentIoc = this.l;
    if (localIQFSTabFragmentIoc != null) {
      return localIQFSTabFragmentIoc.f();
    }
    return -1;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    if (localArrayList != null)
    {
      localArrayList.add(QCirclePublishBoxStatusEvent.class);
      localArrayList.add(QCircleFeedOptEvent.class);
    }
    return localArrayList;
  }
  
  public void k()
  {
    super.k();
    z();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    t();
    H();
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    e(this.d);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QCirclePublishBoxStatusEvent))
    {
      if (((QCirclePublishBoxStatusEvent)paramSimpleBaseEvent).taskCount <= 0)
      {
        if ((this.s) && (d() == 0))
        {
          G().post(new QFSLayerTabPart.4(this));
          QLog.d("QFSLayerTabPart", 2, "onReceiveEvent, event == QCirclePublishBoxStatusEvent");
        }
        this.s = false;
        return;
      }
      this.s = true;
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleFeedOptEvent)) {
      a((QCircleFeedOptEvent)paramSimpleBaseEvent);
    }
  }
  
  protected void p()
  {
    o();
    if (s())
    {
      this.e.a();
      this.a.e();
    }
  }
  
  public void t()
  {
    int i1 = this.j.a();
    boolean bool = true;
    if (1 == i1)
    {
      QQCircleCounter.RedPointInfo localRedPointInfo = QCircleHostRedPointHelper.getSmallRedPointInfotByAppid("circle_entrance");
      if (localRedPointInfo != null)
      {
        List localList = localRedPointInfo.rptRedInfo.get();
        if ((localList != null) && (localList.size() > 0))
        {
          this.q = new QQCircleFeedBase.StPageRedPointInfo();
          this.q.redType.set(localRedPointInfo.redType.get());
          this.q.setHasFlag(true);
          break label91;
        }
      }
      bool = false;
      label91:
      this.r = bool;
    }
  }
  
  protected void u()
  {
    RFThreadManager.getUIHandler().postDelayed(new QFSLayerTabPart.1(this), 200L);
  }
  
  protected void v()
  {
    if ((!this.g) || (!this.i.h()))
    {
      QCircleCollection.a("qcircle_feed");
      a(false, M());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initViewData without page cache");
    Object localObject = this.j;
    if (localObject == null) {
      localObject = "empty";
    } else {
      localObject = ((QCircleTabInfo)localObject).b();
    }
    localStringBuilder.append((String)localObject);
    QLog.d("QCircleFolderCacheHelper", 1, localStringBuilder.toString());
  }
  
  protected QCircleFolderBean w()
  {
    if ((c() != null) && (c().getIntent() != null) && (c().getIntent().hasExtra("key_bundle_common_init_bean"))) {
      return (QCircleFolderBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }
    return null;
  }
  
  public void x()
  {
    this.a.d();
  }
  
  protected void y()
  {
    boolean bool = O();
    this.k = (bool ^ true);
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initPullSceneType isRealVisibleToUser :");
    localStringBuilder.append(bool);
    localStringBuilder.append(",SceneType : ");
    localStringBuilder.append(this.k);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  protected void z()
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("savePageCache");
    Object localObject = this.j;
    if (localObject != null) {
      localObject = ((QCircleTabInfo)localObject).b();
    } else {
      localObject = "empty";
    }
    localStringBuilder.append((String)localObject);
    QLog.d(str, 1, localStringBuilder.toString());
    for (;;)
    {
      try
      {
        if (this.i != null)
        {
          if (this.a == null) {
            break label135;
          }
          i1 = this.a.getViewPager2().getCurrentItem();
          localObject = a(this.b.getDataList());
          if (((List)localObject).size() == 0) {
            return;
          }
          this.i.a((List)localObject);
          this.i.a(i1, 0);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label135:
      int i1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerTabPart
 * JD-Core Version:    0.7.0.1
 */