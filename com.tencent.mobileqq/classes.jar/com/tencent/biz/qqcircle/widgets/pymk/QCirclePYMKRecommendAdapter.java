package com.tencent.biz.qqcircle.widgets.pymk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter;
import com.tencent.biz.qqcircle.report.QCircleFeedCardReportHelper;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCirclePreLoadPicUtil;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.event.QCircleAddblackUpdateEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StItemInfo;

public class QCirclePYMKRecommendAdapter
  extends QCircleRecommendBaseAdapter
  implements SimpleEventReceiver
{
  protected boolean g = false;
  private int h;
  private QCircleFeedCardReportHelper i;
  private QCircleFeedReportScroller j;
  private QCircleReportBean k;
  private int l = 0;
  private RecyclerView m;
  private QCirclePYMKRecommendAdapter.IWidgetHideIntercept n;
  
  private void a(int paramInt, QCirclePYMKRecommendItemViewHolder paramQCirclePYMKRecommendItemViewHolder)
  {
    if (this.a == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[updateItemViewMargin] data == null.");
      return;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramQCirclePYMKRecommendItemViewHolder.itemView.getLayoutParams();
    if ((paramInt > 0) && (paramInt == this.a.size() - 1)) {
      paramInt = ImmersiveUtils.a(-5.0F);
    } else {
      paramInt = ImmersiveUtils.a(-15.0F);
    }
    localLayoutParams.setMargins(0, 0, paramInt, 0);
    paramQCirclePYMKRecommendItemViewHolder.itemView.setLayoutParams(localLayoutParams);
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder)
  {
    QCircleFeedCardReportHelper localQCircleFeedCardReportHelper = this.i;
    if (localQCircleFeedCardReportHelper == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[notifyReportHelperAttached] card report helper should not be null.");
      return;
    }
    if ((paramViewHolder instanceof QCirclePYMKRecommendItemViewHolder)) {
      localQCircleFeedCardReportHelper.a((QCirclePYMKRecommendItemViewHolder)paramViewHolder);
    }
  }
  
  private void a(QCirclePYMKRecommendItemViewHolder paramQCirclePYMKRecommendItemViewHolder)
  {
    int i1 = this.l;
    if (i1 == -1)
    {
      QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, new Object[] { "[updatePageId] page id is: ", Integer.valueOf(-1), ", not change." });
      return;
    }
    if (paramQCirclePYMKRecommendItemViewHolder == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[updatePageId] item holder should not be null.");
      return;
    }
    paramQCirclePYMKRecommendItemViewHolder.b(i1);
  }
  
  private void a(QCircleAddblackUpdateEvent paramQCircleAddblackUpdateEvent)
  {
    if (paramQCircleAddblackUpdateEvent.blackstate == 1)
    {
      QLog.d("PYMK-QCirclePYMKRecommendAdapter", 4, "add black event receive");
      QQCircleDitto.StItemInfo localStItemInfo = new QQCircleDitto.StItemInfo();
      localStItemInfo.id.set(paramQCircleAddblackUpdateEvent.mUserId);
      a(localStItemInfo, 1);
    }
  }
  
  private void a(QCircleFollowUpdateEvent paramQCircleFollowUpdateEvent)
  {
    if (paramQCircleFollowUpdateEvent == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[handleFollowUpdateState] event should not be null.");
      return;
    }
    if (QCirclePluginUtil.c(paramQCircleFollowUpdateEvent.mFollowStatus))
    {
      paramQCircleFollowUpdateEvent = paramQCircleFollowUpdateEvent.mUserId;
      QLog.d("PYMK-QCirclePYMKRecommendAdapter", 4, new Object[] { "[handleFollowUpdateState] remove uid: ", paramQCircleFollowUpdateEvent });
      QQCircleDitto.StItemInfo localStItemInfo = new QQCircleDitto.StItemInfo();
      localStItemInfo.id.set(paramQCircleFollowUpdateEvent);
      a(localStItemInfo, 1);
    }
  }
  
  private void a(List<QQCircleDitto.StItemInfo> paramList)
  {
    if (this.a == null)
    {
      QLog.w("PYMK-QCirclePYMKRecommendAdapter", 1, "[notifyDataChange] data should not be null.");
      return;
    }
    if (this.e == null)
    {
      QLog.w("PYMK-QCirclePYMKRecommendAdapter", 1, "[notifyDataChange] widget should not be null.");
      return;
    }
    List localList = QCirclePreLoadPicUtil.a(paramList);
    this.a.clear();
    this.a.addAll(localList);
    int i1 = 0;
    QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, new Object[] { "[notifyDataChange] pymk recommend list size: ", Integer.valueOf(paramList.size()) });
    paramList = this.e;
    if (this.a.isEmpty()) {
      i1 = 8;
    }
    paramList.setVisibility(i1);
    a();
  }
  
  private void b(RecyclerView paramRecyclerView)
  {
    QCircleFeedCardReportHelper localQCircleFeedCardReportHelper = this.i;
    if (localQCircleFeedCardReportHelper == null)
    {
      QLog.w("PYMK-QCirclePYMKRecommendAdapter", 1, "[updateRecyclerDetached] card report helper should not be null.");
      return;
    }
    paramRecyclerView.removeOnScrollListener(localQCircleFeedCardReportHelper);
    paramRecyclerView = this.j;
    if (paramRecyclerView != null) {
      paramRecyclerView.b(this.i);
    }
    this.i.d();
  }
  
  private void c()
  {
    Object localObject = this.m;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((RecyclerView)localObject).getLayoutManager();
    }
    if (!(localObject instanceof LinearLayoutManager))
    {
      QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[updateVisibleItePageId] update visible item page id fail, not equals linear layout manager.");
      return;
    }
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)localObject;
    int i2 = localLinearLayoutManager.findLastVisibleItemPosition();
    int i1 = localLinearLayoutManager.findFirstVisibleItemPosition();
    while (i1 < i2 + 1)
    {
      localObject = localLinearLayoutManager.findViewByPosition(i1);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((View)localObject).getTag();
      }
      if ((localObject instanceof QCirclePYMKRecommendItemViewHolder)) {
        a((QCirclePYMKRecommendItemViewHolder)localObject);
      }
      i1 += 1;
    }
  }
  
  private void d()
  {
    if (this.i == null)
    {
      this.i = new QCircleFeedCardReportHelper();
      this.i.a(this.d);
      QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[updateCardReportHelperValue] new create a report helper.");
    }
    QCircleFeedReportScroller localQCircleFeedReportScroller = this.j;
    if (localQCircleFeedReportScroller != null) {
      localQCircleFeedReportScroller.a(this.i);
    }
    this.i.a(this.b, this.c);
    int i1 = this.l;
    if (i1 != -1) {
      this.i.a(i1);
    }
  }
  
  private void e()
  {
    if (this.d == null) {
      return;
    }
    if (this.i == null) {
      this.i = new QCircleFeedCardReportHelper();
    }
    this.i.a(this.d);
    f();
  }
  
  private void f()
  {
    QCircleFeedReportScroller localQCircleFeedReportScroller = this.j;
    if (localQCircleFeedReportScroller == null) {
      return;
    }
    QCircleFeedCardReportHelper localQCircleFeedCardReportHelper = this.i;
    if (localQCircleFeedCardReportHelper == null) {
      return;
    }
    localQCircleFeedReportScroller.a(localQCircleFeedCardReportHelper);
  }
  
  public QCirclePYMKRecommendItemViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    int i1 = paramInt;
    if (this.g) {
      i1 = 50002;
    }
    paramInt = 2131626952;
    if (QCircleConfigHelper.bg()) {
      paramInt = 2131627167;
    }
    if (i1 == 50001) {
      paramInt = 2131626951;
    } else if (i1 == 50002) {
      paramInt = 2131626950;
    }
    return new QCirclePYMKRecommendItemViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false));
  }
  
  public void a(QCircleFeedReportScroller paramQCircleFeedReportScroller)
  {
    this.j = paramQCircleFeedReportScroller;
    f();
  }
  
  public void a(QCirclePYMKRecommendAdapter.IWidgetHideIntercept paramIWidgetHideIntercept)
  {
    this.n = paramIWidgetHideIntercept;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.k = paramQCircleReportBean;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt1, List<QQCircleDitto.StItemInfo> paramList, int paramInt2)
  {
    if (paramStFeed == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[setDatas] feed should not be null.");
      return;
    }
    this.b = paramStFeed;
    this.c = paramInt1;
    this.h = paramInt2;
    d();
    a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
    c();
  }
  
  public boolean b()
  {
    QCirclePYMKRecommendAdapter.IWidgetHideIntercept localIWidgetHideIntercept = this.n;
    return (localIWidgetHideIntercept != null) && (localIWidgetHideIntercept.c());
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    localArrayList.add(QCircleAddblackUpdateEvent.class);
    return localArrayList;
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.h;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    e();
    QCircleFeedCardReportHelper localQCircleFeedCardReportHelper = this.i;
    if (localQCircleFeedCardReportHelper == null)
    {
      QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[onAttachedToRecyclerView] card report helper should not be null.");
      return;
    }
    paramRecyclerView.addOnScrollListener(localQCircleFeedCardReportHelper);
    this.m = paramRecyclerView;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.a.size() > paramInt) && ((paramViewHolder instanceof QCirclePYMKRecommendItemViewHolder)))
    {
      paramViewHolder = (QCirclePYMKRecommendItemViewHolder)paramViewHolder;
      a(paramViewHolder);
      paramViewHolder.a(this);
      paramViewHolder.a(this.b);
      paramViewHolder.a(this.c);
      paramViewHolder.a(this.k);
      paramViewHolder.a(this.a.get(paramInt), paramInt, this.h);
      a(paramInt, paramViewHolder);
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    b(paramRecyclerView);
    this.m = null;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent))
    {
      a((QCircleFollowUpdateEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleAddblackUpdateEvent)) {
      a((QCircleAddblackUpdateEvent)paramSimpleBaseEvent);
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    a(paramViewHolder);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendAdapter
 * JD-Core Version:    0.7.0.1
 */