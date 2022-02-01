package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.WSAutoShowCommentParams;
import com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper;
import com.tencent.biz.pubaccount.weishi_new.commercial.WSWidgetDataManager;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSClearModeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.main.WSVideoPageChangeObserver;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLoadMoreReportHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageEventHandler;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public abstract class AbsWSVerticalPagePresenter
  implements IFetchDataRspListener<WSVerticalItemData>, WSVerticalPageContract.Presenter
{
  private static final int a = ScreenUtil.dip2px(40.0F);
  private static final int b = ScreenUtil.dip2px(46.0F);
  protected boolean c;
  protected boolean d;
  public boolean e = true;
  public boolean f;
  public int g;
  protected boolean h;
  private final WeakReference<WSVerticalPageContract.View> i;
  private final WSLoadMoreReportHelper j;
  private final WSVerticalPageEventHandler k;
  private WSAutoShowCommentParams l;
  
  public AbsWSVerticalPagePresenter(WSVerticalPageContract.View paramView)
  {
    this.i = new WeakReference(paramView);
    this.j = new WSLoadMoreReportHelper(WSVerticalBeaconReport.c(z().k()));
    this.k = new WSVerticalPageEventHandler();
  }
  
  private int a(@Nullable List<WSVerticalItemData> paramList, @Nullable String paramString)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        return -1;
      }
      int m = 0;
      while (m < paramList.size())
      {
        WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramList.get(m);
        if ((localWSVerticalItemData.b() != null) && (paramString.equals(localWSVerticalItemData.b().id))) {
          return m;
        }
        m += 1;
      }
    }
    return -1;
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    WSVerticalPageContract.View localView = z();
    if (localView == null) {
      return;
    }
    this.c = false;
    this.j.a();
    localView.u();
    localView.aX_();
    a(paramInt, paramString);
    WSVerticalBeaconReport.a(null, paramBoolean, false, paramInt, localView.k(), localView.l());
  }
  
  private void a(String paramString1, String paramString2, WSPlayerManager paramWSPlayerManager)
  {
    if ((paramWSPlayerManager != null) && (paramWSPlayerManager.g()))
    {
      WSVerticalBeaconReport.a(paramString1, paramString2, paramWSPlayerManager.r(), this.g, n());
      this.e = true;
    }
  }
  
  private void a(List<WSVerticalItemData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramList.next();
      if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed))) {
        localArrayList.add(localWSVerticalItemData.b());
      }
    }
    WSPicLoader.a().a(localArrayList, false, "fullscreen_videoplay");
  }
  
  private void a(@NonNull List<WSVerticalItemData> paramList, @NonNull WSVerticalPageContract.View paramView, int paramInt)
  {
    paramInt = a(paramList, WSVerticalDataUtil.c((WSVerticalItemData)J().getItem(paramInt)));
    if (paramInt == -1)
    {
      a(paramList, paramView);
      return;
    }
    List localList = WeishiUtils.a(paramList, 0, paramInt);
    paramList = WeishiUtils.a(paramList, paramInt + 1, paramList.size());
    c(localList, paramView);
    b(paramList, paramView);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    WSVerticalPageContract.View localView = z();
    if ((localView != null) && (localView.b() != null) && ((paramBoolean1) || (paramBoolean2))) {
      localView.b().a(1);
    }
  }
  
  private int b(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return ((Integer)paramObject).intValue();
    }
    if (a(paramBoolean1, paramBoolean2, paramList, paramObject)) {
      return 0;
    }
    return 3;
  }
  
  private void b(@NonNull WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    this.h = ((WSClearModeEvent)paramWSSimpleBaseEvent).isClearMode();
    this.k.d(paramWSSimpleBaseEvent, z());
  }
  
  private void b(@Nullable WSVerticalPageContract.View paramView)
  {
    if ((paramView != null) && (paramView.b() != null))
    {
      paramView = paramView.b().b();
      if (paramView == null) {
        return;
      }
      this.g = paramView.getAdapterPosition();
      paramView = new StringBuilder();
      paramView.append("updateCurrentPosition() mCurrentPosition = ");
      paramView.append(this.g);
      WSLog.a("AbsWSVerticalPagePresenter", paramView.toString());
    }
  }
  
  private void b(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder, int paramInt)
  {
    if (!B()) {
      return;
    }
    Object localObject = z();
    if (localObject != null)
    {
      localObject = ((WSVerticalPageContract.View)localObject).b();
      if (localObject == null) {
        return;
      }
      if (!(paramBaseViewHolder instanceof WSVerticalVideoHolder)) {
        return;
      }
      localObject = ((WSVerticalPageAdapter)localObject).getDataList();
      WSWidgetDataManager.a().a(paramInt, (List)localObject, new AbsWSVerticalPagePresenter.1(this, paramBaseViewHolder));
    }
  }
  
  private void b(String paramString1, String paramString2, WSPlayerManager paramWSPlayerManager)
  {
    if ((this.e) && (paramWSPlayerManager != null) && ((paramWSPlayerManager.g()) || (paramWSPlayerManager.f())))
    {
      WSVerticalBeaconReport.a(paramString1, paramString2, paramWSPlayerManager.r(), false, this.g, n());
      paramWSPlayerManager.t();
      this.e = false;
    }
  }
  
  private boolean b(String paramString, List<WSVerticalItemData> paramList)
  {
    return (TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.size() <= 0);
  }
  
  private void u()
  {
    if (!H()) {
      return;
    }
    WSPublicAccReport.getInstance().closePublicAccReport(M());
  }
  
  public long A()
  {
    return 0L;
  }
  
  protected boolean B()
  {
    return false;
  }
  
  protected boolean C()
  {
    Object localObject = z();
    if (localObject != null)
    {
      localObject = ((WSVerticalPageContract.View)localObject).e();
      if ((localObject != null) && ((((WSPlayerManager)localObject).i()) || ((!((WSPlayerManager)localObject).g()) && (!((WSPlayerManager)localObject).f()))))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[isFirstVideoPlayInvalid] state:");
        localStringBuilder.append(((WSPlayerManager)localObject).m());
        WSLog.d("AbsWSVerticalPagePresenter", localStringBuilder.toString());
        return true;
      }
    }
    return false;
  }
  
  protected void D()
  {
    WSVerticalPageContract.View localView = (WSVerticalPageContract.View)this.i.get();
    if (localView != null)
    {
      if (!E()) {
        return;
      }
      localView.c(-16777216);
    }
  }
  
  protected boolean E()
  {
    return true;
  }
  
  public boolean F()
  {
    WSVerticalPageContract.View localView = z();
    return (localView != null) && (localView.q());
  }
  
  public boolean G()
  {
    return true;
  }
  
  protected boolean H()
  {
    return false;
  }
  
  protected boolean I()
  {
    return false;
  }
  
  protected WSVerticalPageAdapter J()
  {
    WSVerticalPageContract.View localView = z();
    if (localView != null) {
      return localView.b();
    }
    return null;
  }
  
  protected WSVerticalVideoHolder K()
  {
    WSVerticalPageAdapter localWSVerticalPageAdapter = J();
    if (localWSVerticalPageAdapter != null) {
      return localWSVerticalPageAdapter.b();
    }
    return null;
  }
  
  protected WSVerticalItemData L()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = K();
    if (localWSVerticalVideoHolder == null) {
      return null;
    }
    return (WSVerticalItemData)localWSVerticalVideoHolder.e;
  }
  
  public int M()
  {
    if ((!WSReportEventConstants.c) && (!this.d)) {
      return 2;
    }
    return 1;
  }
  
  @Nullable
  protected stSimpleMetaFeed N()
  {
    Object localObject1 = z();
    if (localObject1 != null)
    {
      Object localObject3 = ((WSVerticalPageContract.View)localObject1).b();
      if (localObject3 != null)
      {
        WSLog.a("AbsWSVerticalPagePresenter", "getTargetCacheFeed");
        Object localObject2 = WSAioListHelper.b();
        if (localObject2 != null) {
          return localObject2;
        }
        WSVerticalItemData localWSVerticalItemData = ((WSVerticalPageAdapter)localObject3).e();
        localObject1 = localObject2;
        if (localWSVerticalItemData != null)
        {
          localObject1 = localObject2;
          if (localWSVerticalItemData.b() != null) {
            localObject1 = localWSVerticalItemData.b();
          }
        }
        if ((localObject1 != null) && (!TextUtils.isEmpty(((stSimpleMetaFeed)localObject1).feed_desc)) && (((stSimpleMetaFeed)localObject1).video_type != 2)) {
          return localObject1;
        }
        int n = ((WSVerticalPageAdapter)localObject3).h();
        localObject3 = ((WSVerticalPageAdapter)localObject3).getDataList();
        localObject2 = localObject1;
        int m = n;
        if (n >= ((List)localObject3).size() - 2) {
          return localObject1;
        }
        for (;;)
        {
          m += 1;
          localObject1 = localObject2;
          if (m >= ((List)localObject3).size()) {
            break;
          }
          localObject1 = ((WSVerticalItemData)((List)localObject3).get(m)).b();
          if (((stSimpleMetaFeed)localObject1).video_type != 2)
          {
            if (!TextUtils.isEmpty(((stSimpleMetaFeed)localObject1).feed_desc)) {
              break;
            }
            localObject2 = localObject1;
          }
        }
        return localObject1;
      }
    }
    return null;
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  protected WSVerticalItemData a(String paramString, List<WSVerticalItemData> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[filterDataAndRemoveByFeedId] feedId:");
    ((StringBuilder)localObject).append(paramString);
    WSLog.d("AbsWSVerticalPagePresenter", ((StringBuilder)localObject).toString());
    if (b(paramString, paramList))
    {
      WSLog.d("AbsWSVerticalPagePresenter", "[filterDataAndRemoveByFeedId] feedId or itemList is empty!");
      return null;
    }
    localObject = new ArrayList(paramList).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)((Iterator)localObject).next();
      stSimpleMetaFeed localstSimpleMetaFeed = b(localWSVerticalItemData);
      if ((localstSimpleMetaFeed != null) && (TextUtils.equals(paramString, localstSimpleMetaFeed.id)))
      {
        paramList.remove(localWSVerticalItemData);
        return localWSVerticalItemData;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.j.a(z().l());
  }
  
  protected void a(int paramInt, String paramString)
  {
    WSVerticalPageContract.View localView = z();
    if ((localView != null) && (localView.b() != null) && (localView.b().isEmpty())) {
      localView.a(paramInt, paramString);
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = new AbsWSVerticalPagePresenter.3(this, paramInt, paramString, paramBoolean1);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(paramString);
      return;
    }
    paramString.run();
  }
  
  protected void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    WSVerticalVideoHolder localWSVerticalVideoHolder = K();
    if ((localWSVerticalVideoHolder != null) && (localWSVerticalVideoHolder.f != null)) {
      localWSVerticalVideoHolder.f.c = WSPlayerUtils.a(paramstSimpleMetaFeed);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.l = ((WSAutoShowCommentParams)paramBundle.getSerializable("auto_show_comment_params"));
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    this.g = paramInt;
    if (paramInt > 0) {
      this.d = true;
    }
    WSVerticalPageContract.View localView = z();
    if (localView == null) {
      return;
    }
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      WSVerticalVideoHolder localWSVerticalVideoHolder = (WSVerticalVideoHolder)paramViewHolder;
      localView.w().onVideoSelected((WSVerticalItemData)localWSVerticalVideoHolder.e, paramViewHolder.getAdapterPosition());
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
    {
      this.k.a(paramWSSimpleBaseEvent, z());
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof FollowEvent))
    {
      this.k.b(paramWSSimpleBaseEvent, z());
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSAddCommentEvent))
    {
      this.k.c(paramWSSimpleBaseEvent, z());
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSClearModeEvent)) {
      b(paramWSSimpleBaseEvent);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean) {}
  
  public void a(@NonNull WSVerticalPageContract.View paramView) {}
  
  protected void a(WSVerticalItemData paramWSVerticalItemData, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramWSVerticalItemData != null)
    {
      if (paramstSimpleMetaFeed == null) {
        return;
      }
      stSimpleMetaFeed localstSimpleMetaFeed = paramWSVerticalItemData.b();
      if ((paramstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null)) {
        paramstSimpleMetaFeed.floatingLayerCardStyle.cardType = localstSimpleMetaFeed.floatingLayerCardStyle.cardType;
      }
      paramWSVerticalItemData.a(paramstSimpleMetaFeed);
    }
  }
  
  public void a(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder, int paramInt)
  {
    WSLog.a("AbsWSVerticalPagePresenter", "onHandleBindCustomViewHolder");
    b(paramBaseViewHolder, paramInt);
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadDataUp mIsGettingDataList:");
    localStringBuilder.append(this.c);
    WSLog.e("WSEpisodeChoicePanel", localStringBuilder.toString());
    if (this.c) {
      return;
    }
    this.c = c(paramString);
  }
  
  public void a(String paramString, WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (WSFeedUtils.a(paramstSimpleMetaFeed.poster))
    {
      WSVerticalJumpUtils.a(paramString, paramWSVerticalPageFragment, paramstSimpleMetaFeed);
      return;
    }
    b(paramString, paramWSVerticalPageFragment, paramstSimpleMetaFeed);
  }
  
  protected void a(String paramString, WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    Map localMap = ((WSVerticalPageContract.Presenter)paramWSVerticalPageFragment.aO_()).n();
    localMap.put("click_status", String.valueOf(paramInt));
    WSVerticalBeaconReport.a(paramWSVerticalPageFragment.k(), paramWSVerticalPageFragment.l(), paramString, 1000001, paramstSimpleMetaFeed, localMap);
  }
  
  protected void a(@NonNull List<WSVerticalItemData> paramList, WSVerticalPageContract.View paramView)
  {
    paramView.a(paramList);
  }
  
  public void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    paramList = new AbsWSVerticalPagePresenter.2(this, paramList, paramBoolean1, paramBoolean2, paramObject);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(paramList);
      return;
    }
    paramList.run();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadData mIsGettingDataList:");
    localStringBuilder.append(this.c);
    WSLog.e("WSEpisodeChoicePanel", localStringBuilder.toString());
    if (this.c) {
      return;
    }
    this.c = b(paramBoolean1, paramBoolean2, paramString);
    if ((!paramBoolean1) && (this.c)) {
      this.j.b();
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, Object paramObject)
  {
    return false;
  }
  
  public int b()
  {
    return WSExpABTestManager.a().q();
  }
  
  protected stSimpleMetaFeed b(WSVerticalItemData paramWSVerticalItemData)
  {
    if (paramWSVerticalItemData != null)
    {
      paramWSVerticalItemData = paramWSVerticalItemData.b();
      if (paramWSVerticalItemData != null) {
        return paramWSVerticalItemData;
      }
    }
    return null;
  }
  
  protected WSVerticalItemData b(int paramInt)
  {
    WSVerticalPageAdapter localWSVerticalPageAdapter = J();
    if ((localWSVerticalPageAdapter != null) && (paramInt >= 0)) {
      return (WSVerticalItemData)localWSVerticalPageAdapter.getItem(paramInt);
    }
    return null;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(String paramString)
  {
    a(true, false, paramString);
  }
  
  protected void b(String paramString, WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSVerticalPageContract.View localView = z();
    if (localView == null) {
      return;
    }
    localView.w().onVideoPageHeaderClick();
    a(paramString, paramWSVerticalPageFragment, paramstSimpleMetaFeed, 1);
  }
  
  protected void b(@NonNull List<WSVerticalItemData> paramList, WSVerticalPageContract.View paramView)
  {
    paramView.a(paramList);
  }
  
  protected void b(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    WSVerticalPageContract.View localView = z();
    if (localView == null) {
      return;
    }
    this.c = false;
    this.j.a();
    localView.u();
    localView.aX_();
    if (paramList.size() > 0)
    {
      a(paramList);
      a(paramBoolean1, paramBoolean2);
      c(paramList, paramBoolean1, paramBoolean2, paramObject);
    }
    else
    {
      a(-1, "");
    }
    WSVerticalBeaconReport.a(paramList, paramBoolean2, true, -1, localView.k(), localView.l());
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[AbsWSVerticalPagePresenter.java][reportVideoPlay] isPlay:");
    ((StringBuilder)localObject1).append(paramBoolean);
    WSLog.e("WS_VIDEO_PLAY_TIME", ((StringBuilder)localObject1).toString());
    localObject1 = z();
    if (localObject1 != null)
    {
      Object localObject2 = ((WSVerticalPageContract.View)localObject1).b();
      if (localObject2 == null) {
        return;
      }
      localObject2 = ((WSVerticalPageAdapter)localObject2).d();
      if (paramBoolean)
      {
        a(((WSVerticalPageContract.View)localObject1).k(), ((WSVerticalPageContract.View)localObject1).l(), (WSPlayerManager)localObject2);
        return;
      }
      b(((WSVerticalPageContract.View)localObject1).k(), ((WSVerticalPageContract.View)localObject1).l(), (WSPlayerManager)localObject2);
    }
  }
  
  public abstract boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  public int c()
  {
    return a;
  }
  
  protected stSimpleMetaFeed c(int paramInt)
  {
    WSVerticalItemData localWSVerticalItemData = b(paramInt);
    if (localWSVerticalItemData != null) {
      return localWSVerticalItemData.b();
    }
    return null;
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    WSVerticalPageContract.View localView = z();
    if (localView == null) {
      return;
    }
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      WSVerticalVideoHolder localWSVerticalVideoHolder = (WSVerticalVideoHolder)paramViewHolder;
      localView.w().onVideoSelectedIdle((WSVerticalItemData)localWSVerticalVideoHolder.e, paramViewHolder.getAdapterPosition());
    }
  }
  
  protected void c(WSVerticalItemData paramWSVerticalItemData)
  {
    WSVerticalPageContract.View localView = z();
    if (localView != null) {
      localView.a(paramWSVerticalItemData);
    }
  }
  
  protected void c(@NonNull List<WSVerticalItemData> paramList, WSVerticalPageContract.View paramView)
  {
    paramView.b(paramList);
  }
  
  protected void c(@NonNull List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    WSVerticalPageContract.View localView = z();
    if (localView == null) {
      return;
    }
    int m = b(paramBoolean1, paramBoolean2, paramList, paramObject);
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m == 3) {
            b(paramList, localView);
          }
        }
        else {
          c(paramList, localView);
        }
      }
      else {
        a(paramList, localView, this.g);
      }
    }
    else {
      a(paramList, localView);
    }
    b(localView);
  }
  
  protected boolean c(String paramString)
  {
    return false;
  }
  
  public void d()
  {
    if (I()) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 10);
    }
  }
  
  public void destroy()
  {
    WSVerticalPageContract.View localView = z();
    if ((localView != null) && (localView.e() != null)) {
      localView.e().d(G());
    }
    if (H()) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 10);
    }
  }
  
  public void detachView() {}
  
  public void e()
  {
    D();
  }
  
  public void f()
  {
    WSVerticalPageContract.View localView = z();
    if ((localView != null) && (localView.e() != null) && (F()))
    {
      localView.e().p();
      b(true);
    }
    if (F()) {
      WSPlayerAudioControl.a().a(true);
    }
  }
  
  public void g()
  {
    WSVerticalPageContract.View localView = z();
    if ((localView != null) && (localView.e() != null))
    {
      localView.e().q();
      b(false);
    }
    WSPlayerAudioControl.a().a(false);
    j();
  }
  
  public void h()
  {
    this.f = true;
    WSReportDC898Vertical.b();
    u();
  }
  
  public boolean i()
  {
    return false;
  }
  
  public void j()
  {
    this.j.c();
  }
  
  public boolean k()
  {
    return false;
  }
  
  public WSPlayerParam l()
  {
    return null;
  }
  
  public Map<String, String> m()
  {
    return null;
  }
  
  public Map<String, String> n()
  {
    return new HashMap();
  }
  
  public boolean o()
  {
    return false;
  }
  
  public boolean p()
  {
    return false;
  }
  
  public void q()
  {
    this.j.a(this.g);
  }
  
  public boolean r()
  {
    return true;
  }
  
  public int s()
  {
    return b;
  }
  
  @Nullable
  public WSAutoShowCommentParams t()
  {
    return this.l;
  }
  
  public WSVerticalPageContract.View z()
  {
    WeakReference localWeakReference = this.i;
    if (localWeakReference != null) {
      return (WSVerticalPageContract.View)localWeakReference.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter
 * JD-Core Version:    0.7.0.1
 */