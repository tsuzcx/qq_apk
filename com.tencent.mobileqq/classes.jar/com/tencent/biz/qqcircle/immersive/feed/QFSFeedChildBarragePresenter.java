package com.tencent.biz.qqcircle.immersive.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSCloseBarrageEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSGetBarrageEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSOpenBarrageEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBaseFeedPresenterEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoProgressChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoStatusEvent;
import com.tencent.biz.qqcircle.immersive.model.barrage.IQFSBarrageModel;
import com.tencent.biz.qqcircle.immersive.model.barrage.QFSBarrageModel;
import com.tencent.biz.qqcircle.immersive.model.barrage.bean.QFSLoadBarrageListBean;
import com.tencent.biz.qqcircle.immersive.utils.QFSCommonUtil;
import com.tencent.biz.qqcircle.immersive.utils.QFSSafeListUtils;
import com.tencent.biz.qqcircle.immersive.utils.QFSViewUtils;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.IQFSBarrageViewModel;
import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.QFSBarrageViewModel;
import com.tencent.biz.qqcircle.manager.QCircleSwitchConfigManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;

public class QFSFeedChildBarragePresenter
  extends QFSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
  implements SimpleEventReceiver
{
  private IQFSBarrageViewModel<FeedCloudMeta.StComment> i;
  private ViewGroup j;
  private long k = -1L;
  private int l = 0;
  private List<FeedCloudMeta.StComment> m;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r;
  
  private String A()
  {
    if (this.c == null) {
      return "null";
    }
    return ((FeedCloudMeta.StFeed)this.c).id.get();
  }
  
  private int B()
  {
    if (this.c == null) {
      return -1;
    }
    return ((FeedCloudMeta.StFeed)this.c).type.get();
  }
  
  private void C()
  {
    if (this.o)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[handlerBarrageLoadMore] request more loading flag is true.");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handlerBarrageLoadMore] handler barrage load more, current feed id: ");
    ((StringBuilder)localObject).append(A());
    ((StringBuilder)localObject).append(" | hash code: ");
    ((StringBuilder)localObject).append(hashCode());
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, ((StringBuilder)localObject).toString());
    this.o = true;
    localObject = QFSLoadBarrageListBean.a();
    ((QFSLoadBarrageListBean)localObject).a((FeedCloudMeta.StFeed)this.c);
    ((QFSLoadBarrageListBean)localObject).a(true);
    ((QFSLoadBarrageListBean)localObject).a(hashCode());
    QFSBarrageModel.a().a((QFSLoadBarrageListBean)localObject);
  }
  
  private void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateBarrageContentDuration] duration: ");
    localStringBuilder.append(paramInt);
    QLog.e("QDM-QFSFeedChildBarragePresenter", 1, localStringBuilder.toString());
    this.k = paramInt;
  }
  
  private void a(QCircleDanmakuEvent paramQCircleDanmakuEvent)
  {
    if (paramQCircleDanmakuEvent.eventStatus == 9)
    {
      QFSOpenBarrageEvent localQFSOpenBarrageEvent = new QFSOpenBarrageEvent();
      localQFSOpenBarrageEvent.setFeedId(paramQCircleDanmakuEvent.feedId);
      a(localQFSOpenBarrageEvent);
      return;
    }
    if (paramQCircleDanmakuEvent.eventStatus == 10) {
      m();
    }
  }
  
  private void a(@NonNull QFSGetBarrageEvent paramQFSGetBarrageEvent)
  {
    String str;
    if (this.c == null) {
      str = "";
    } else {
      str = ((FeedCloudMeta.StFeed)this.c).id.get();
    }
    if (!TextUtils.equals(str, paramQFSGetBarrageEvent.getFeedId()))
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[handlerGetBarrageEvent] current feed id: ", str, " | event feed id: ", paramQFSGetBarrageEvent.getFeedId() });
      return;
    }
    List localList = paramQFSGetBarrageEvent.getCommentList();
    int i1 = paramQFSGetBarrageEvent.getTotal();
    int i2 = QFSSafeListUtils.b(localList);
    int i3 = paramQFSGetBarrageEvent.getStartIndex();
    boolean bool = paramQFSGetBarrageEvent.isLoadMore();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i1);
    localStringBuilder.append(" ｜ feedId: ");
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[handlerGetBarrageEvent] is load more: ", Boolean.valueOf(bool), " | barrage size: ", Integer.valueOf(i2), " | total: ", localStringBuilder.toString(), str, " | event feed id: ", paramQFSGetBarrageEvent.getFeedId(), " | hash code: ", Integer.valueOf(hashCode()) });
    if (paramQFSGetBarrageEvent.isLoadMore())
    {
      a(localList, i1, i3);
      return;
    }
    a(localList, i1);
  }
  
  private void a(@NonNull QFSOpenBarrageEvent paramQFSOpenBarrageEvent)
  {
    if (!TextUtils.equals(paramQFSOpenBarrageEvent.getFeedId(), A())) {
      return;
    }
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[handlerOpenBarrageEvent] handler open barrage event.");
    QFSViewUtils.a(this.j, 0);
    n();
    o();
  }
  
  private void a(@NonNull QFSSeekEvent paramQFSSeekEvent)
  {
    if (this.i == null)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[handlerSeekBarEvent] barrage view model should not be null.");
      return;
    }
    if (!QCircleSwitchConfigManager.a().b())
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[handlerSeekBarEvent] barrage is close, flow end.");
      return;
    }
    if (paramQFSSeekEvent.mIsOnSeek)
    {
      QFSViewUtils.a(this.j, 8);
      return;
    }
    QFSViewUtils.a(this.j, 0);
  }
  
  private void a(QFSVideoProgressChangeEvent paramQFSVideoProgressChangeEvent)
  {
    if (paramQFSVideoProgressChangeEvent == null) {
      return;
    }
    if (paramQFSVideoProgressChangeEvent.a() != this.k)
    {
      a(paramQFSVideoProgressChangeEvent.a());
      b(false);
      t();
      return;
    }
    if (this.r)
    {
      b(false);
      l();
    }
  }
  
  private void a(@NonNull QFSVideoStatusEvent paramQFSVideoStatusEvent)
  {
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[handlerVideoStatusEvent] event: ", Boolean.valueOf(paramQFSVideoStatusEvent.a()) });
    b(paramQFSVideoStatusEvent.a());
    if ((this.i == null) && (!this.r))
    {
      this.q = false;
      t();
      return;
    }
    if (this.r)
    {
      s();
      return;
    }
    r();
  }
  
  private void a(List<FeedCloudMeta.StComment> paramList, int paramInt)
  {
    if (QFSSafeListUtils.a(paramList))
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[handlerGetBarrageEvent] set data source, barrage list should not is empty.");
      return;
    }
    List localList = this.m;
    if (localList == null) {
      this.m = new ArrayList();
    } else {
      localList.clear();
    }
    this.o = false;
    this.m.addAll(paramList);
    this.l = paramInt;
    t();
  }
  
  private void a(List<FeedCloudMeta.StComment> paramList, int paramInt1, int paramInt2)
  {
    if (QFSSafeListUtils.a(paramList))
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[appendBarrageDataSource] comments data source is empty, flow return.");
      return;
    }
    if (this.i == null)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[appendBarrageDataSource] barrage view model should be null, flow return.");
      return;
    }
    if (this.k <= 0L)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[appendBarrageDataSource] barrage view model should be null, flow return.");
      return;
    }
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[appendBarrageDataSource] size: ", Integer.valueOf(QFSSafeListUtils.b(paramList)), " | total: ", Integer.valueOf(paramInt1), " | startIndex: ", Integer.valueOf(paramInt2) });
    this.i.a(paramList, paramInt1, this.k, paramInt2);
    this.o = false;
  }
  
  private void b(View paramView)
  {
    if (paramView == null)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[addTextureLayoutToBarrageLayout] barrage layout should not be null.");
      return;
    }
    this.j.addView(paramView);
    if (QCircleSwitchConfigManager.a().b()) {
      QFSViewUtils.a(this.j, 0);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateVideoPause] isVideoPause: ");
    localStringBuilder.append(paramBoolean);
    QLog.w("QDM-QFSFeedChildBarragePresenter", 1, localStringBuilder.toString());
    this.r = paramBoolean;
  }
  
  private void c(boolean paramBoolean)
  {
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[loadMeasureFinish] load measure isLoadMore: ", Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      y();
      return;
    }
    z();
  }
  
  private IQFSBarrageViewModel<FeedCloudMeta.StComment> k()
  {
    if (this.i == null) {
      this.i = new QFSBarrageViewModel();
    }
    return this.i;
  }
  
  private void l()
  {
    if (this.i == null)
    {
      n();
      o();
      return;
    }
    if (this.p)
    {
      r();
      return;
    }
    o();
  }
  
  private void m()
  {
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[handlerCloseBarrageEvent] handler close barrage event.");
    QFSViewUtils.a(this.j, 8);
    q();
  }
  
  private void n()
  {
    List localList = this.m;
    if (localList != null) {
      localList.clear();
    }
    this.n = false;
    this.q = false;
  }
  
  private void o()
  {
    Object localObject = A();
    if (!u())
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[loadBarrageSource] current wns barrage not enabled, not load source, feed id: ", localObject });
      return;
    }
    if (!QCircleSwitchConfigManager.a().b())
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[loadBarrageSource] current barrage is close state, not load source, feed id: ", localObject });
      return;
    }
    if (this.n)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[loadBarrageSource] current barrage update data source flag == true, not load source, feed id: ", localObject });
      return;
    }
    this.n = true;
    p();
    localObject = QFSLoadBarrageListBean.a();
    ((QFSLoadBarrageListBean)localObject).a((FeedCloudMeta.StFeed)this.c);
    ((QFSLoadBarrageListBean)localObject).a(hashCode());
    ((QFSLoadBarrageListBean)localObject).a(false);
    QFSBarrageModel.a().a((QFSLoadBarrageListBean)localObject);
  }
  
  private void p()
  {
    if (3 == B())
    {
      a(0);
      return;
    }
    a(10000);
  }
  
  private void q()
  {
    IQFSBarrageViewModel localIQFSBarrageViewModel = this.i;
    if (localIQFSBarrageViewModel != null) {
      localIQFSBarrageViewModel.d();
    }
    v();
    this.i = null;
  }
  
  private void r()
  {
    IQFSBarrageViewModel localIQFSBarrageViewModel = this.i;
    if (localIQFSBarrageViewModel == null)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[handlerResumeBarrage] barrage view model should not be null.");
      return;
    }
    localIQFSBarrageViewModel.c();
  }
  
  private void s()
  {
    IQFSBarrageViewModel localIQFSBarrageViewModel = this.i;
    if (localIQFSBarrageViewModel == null)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[handlerPauseBarrage] barrage view model should not be null.");
      return;
    }
    localIQFSBarrageViewModel.b();
  }
  
  private void t()
  {
    if (this.r)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[tryUpdateDataSourceToBarrageView] video pause state, not play barrage.");
      return;
    }
    if (QFSSafeListUtils.a(this.m))
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[tryUpdateDataSourceToBarrageView] current feed barrages should not be null.");
      return;
    }
    if (this.k <= 0L)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[tryUpdateDataSourceToBarrageView] mVideoDuration <= ", Integer.valueOf(0) });
      return;
    }
    if (this.q)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[tryUpdateDataSourceToBarrageView] isStartDataSource == true, flow return.");
      return;
    }
    this.q = true;
    Context localContext = w();
    TextureView localTextureView = x();
    int i1;
    if (localTextureView == null) {
      i1 = -1;
    } else {
      i1 = localTextureView.hashCode();
    }
    int i2 = this.m.size();
    String str = A();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[tryUpdateDataSourceToBarrageView] barrage view hash code:");
    localStringBuilder.append(i1);
    localStringBuilder.append(" | net barrage total: ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" | barrage size: ");
    localStringBuilder.append(i2);
    localStringBuilder.append(" | video duration: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" | feed id: ");
    localStringBuilder.append(str);
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, localStringBuilder.toString());
    this.i = k();
    this.i.a(localContext, localTextureView);
    this.i.a(new QFSFeedChildBarragePresenter.FSBarrageListenerImpl(this));
    this.i.a(new QFSFeedChildBarragePresenter.FSBarrageLoadMoreListenerImpl(this));
    this.i.a((FeedCloudMeta.StFeed)this.c);
    this.i.a(this.m, this.l, this.k);
  }
  
  private boolean u()
  {
    return QCircleConfigHelper.a("qqcircle", "qqcircle_show_barrage_enabled", Integer.valueOf(1)).intValue() == 1;
  }
  
  private void v()
  {
    ViewGroup localViewGroup = this.j;
    if (localViewGroup == null)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[removeAllView] barrage layout should not be null.");
      return;
    }
    int i1 = localViewGroup.getChildCount();
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[removeAllView] remove all view, count: ", Integer.valueOf(i1) });
    if (i1 > 0) {
      this.j.removeAllViews();
    }
  }
  
  private Context w()
  {
    ViewGroup localViewGroup = this.j;
    if (localViewGroup == null)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[getViewContext()] barrage layout should not be null.");
      return null;
    }
    return localViewGroup.getContext();
  }
  
  private TextureView x()
  {
    Object localObject = w();
    if (localObject == null)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[createTextureView] context should not be null.");
      return null;
    }
    v();
    localObject = LayoutInflater.from((Context)localObject).inflate(2131627123, null);
    b((View)localObject);
    return (TextureView)((View)localObject).findViewById(2131433360);
  }
  
  private void y()
  {
    IQFSBarrageViewModel localIQFSBarrageViewModel = this.i;
    if (localIQFSBarrageViewModel == null)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[checkBarrageStart] barrage view model should not be null.");
      return;
    }
    if (localIQFSBarrageViewModel.e() == 4) {
      z();
    }
  }
  
  private void z()
  {
    IQFSBarrageViewModel localIQFSBarrageViewModel = this.i;
    if (localIQFSBarrageViewModel == null)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[startBarrage] barrage view mode should not be null.");
      return;
    }
    if (this.r)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[startBarrage] video pause, not start barrage.");
      return;
    }
    localIQFSBarrageViewModel.a();
  }
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.j = ((ViewGroup)paramView.findViewById(2131433359));
  }
  
  public void a(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    if (paramQFSFeedSelectInfo == null) {
      return;
    }
    if (paramQFSFeedSelectInfo.b() != this.d) {
      return;
    }
    String str = A();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" | isPausedState: ");
    localStringBuilder.append(this.p);
    localStringBuilder.append(" | hashCode: ");
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[onResumed] selectInfo: ", paramQFSFeedSelectInfo, localStringBuilder.toString(), Integer.valueOf(hashCode()), " | feedId: ", str });
    l();
    this.p = false;
  }
  
  public void a(QFSBaseFeedPresenterEvent paramQFSBaseFeedPresenterEvent)
  {
    if ((paramQFSBaseFeedPresenterEvent instanceof QFSVideoProgressChangeEvent))
    {
      a((QFSVideoProgressChangeEvent)paramQFSBaseFeedPresenterEvent);
      return;
    }
    if ((paramQFSBaseFeedPresenterEvent instanceof QFSVideoStatusEvent)) {
      a((QFSVideoStatusEvent)paramQFSBaseFeedPresenterEvent);
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.c;
    super.a(paramStFeed, paramInt);
    String str;
    if (paramStFeed == null) {
      str = "null";
    } else {
      str = paramStFeed.id.get();
    }
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[onBindData] data feed id: ", str });
    if (QFSCommonUtil.a(paramStFeed, localStFeed)) {
      return;
    }
    if (paramStFeed == null)
    {
      paramStFeed = new StringBuilder();
      paramStFeed.append("onBindData is null: ");
      paramStFeed.append(paramInt);
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, paramStFeed.toString());
      return;
    }
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[onBindData] position: ", Integer.valueOf(paramInt) });
  }
  
  public void c()
  {
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[onAttachedToWindow] current attached to window, hash code: ", Integer.valueOf(hashCode()), " | feed id: ", A() });
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void c(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    super.c(paramQFSFeedSelectInfo);
    if (paramQFSFeedSelectInfo == null) {
      return;
    }
    if (paramQFSFeedSelectInfo.b() != this.d) {
      return;
    }
    String str = A();
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[onPaused] selectInfo: ", paramQFSFeedSelectInfo, " | hashCode: ", Integer.valueOf(hashCode()), " | feedId: ", str });
    s();
    this.p = true;
  }
  
  public void d()
  {
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[onDetachedFromWindow] current detached from window, hash code: ", Integer.valueOf(hashCode()), " | feed id: ", A() });
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    q();
  }
  
  public void d(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    if (paramQFSFeedSelectInfo == null) {
      return;
    }
    if (paramQFSFeedSelectInfo.b() != this.d) {
      return;
    }
    n();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append(" | feed id: ");
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[onFeedSelected] selectInfo: ", paramQFSFeedSelectInfo, " | hashCode: ", localStringBuilder.toString(), A() });
    o();
  }
  
  public void e(QFSFeedSelectInfo paramQFSFeedSelectInfo)
  {
    if (paramQFSFeedSelectInfo == null) {
      return;
    }
    if (paramQFSFeedSelectInfo.b() != this.d) {
      return;
    }
    String str = A();
    QLog.d("QDM-QFSFeedChildBarragePresenter", 1, new Object[] { "[onFeedUnSelected] selectInfo: ", paramQFSFeedSelectInfo, " | hashCode: ", Integer.valueOf(hashCode()), " | feedId: ", str });
    q();
    n();
  }
  
  public ArrayList getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QFSGetBarrageEvent.class);
    localArrayList.add(QFSCloseBarrageEvent.class);
    localArrayList.add(QFSOpenBarrageEvent.class);
    localArrayList.add(QCircleDanmakuEvent.class);
    localArrayList.add(QFSSeekEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QFSGetBarrageEvent))
    {
      a((QFSGetBarrageEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QFSCloseBarrageEvent))
    {
      m();
      return;
    }
    if ((paramSimpleBaseEvent instanceof QFSOpenBarrageEvent))
    {
      a((QFSOpenBarrageEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QFSSeekEvent))
    {
      a((QFSSeekEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleDanmakuEvent)) {
      a((QCircleDanmakuEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBarragePresenter
 * JD-Core Version:    0.7.0.1
 */