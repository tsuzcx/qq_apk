package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.commercial.WSWidgetDataManager;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSClearModeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.WSLoadMoreReportHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalCommonVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
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
  private static final int b;
  public int a;
  private WSLoadMoreReportHelper jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper;
  private final WeakReference<WSVerticalPageContract.View> jdField_a_of_type_MqqUtilWeakReference;
  protected boolean a;
  protected boolean b;
  public boolean c = true;
  public boolean d;
  protected boolean e;
  
  static
  {
    jdField_b_of_type_Int = ScreenUtil.dip2px(40.0F);
  }
  
  public AbsWSVerticalPagePresenter(WSVerticalPageContract.View paramView)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper = new WSLoadMoreReportHelper(WSVerticalBeaconReport.a(a().a()));
  }
  
  private int a(@Nullable List<WSVerticalItemData> paramList, @Nullable String paramString)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        return -1;
      }
      int i = 0;
      while (i < paramList.size())
      {
        WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramList.get(i);
        if ((localWSVerticalItemData.a() != null) && (paramString.equals(localWSVerticalItemData.a().id))) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return ((Integer)paramObject).intValue();
    }
    if (a(paramBoolean1, paramBoolean2, paramList, paramObject)) {
      return 0;
    }
    return 3;
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    WSVerticalPageContract.View localView = a();
    if (localView == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper.a();
    localView.f();
    localView.e();
    a(paramInt, paramString);
    WSVerticalBeaconReport.a(null, paramBoolean, false, paramInt, localView.a(), localView.b());
  }
  
  private void a(String paramString1, String paramString2, WSPlayerManager paramWSPlayerManager)
  {
    if ((paramWSPlayerManager != null) && (paramWSPlayerManager.c()))
    {
      WSVerticalBeaconReport.a(paramString1, paramString2, paramWSPlayerManager.a(), this.jdField_a_of_type_Int, b());
      this.c = true;
    }
  }
  
  private void a(List<WSVerticalItemData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramList.next();
      if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed))) {
        localArrayList.add(localWSVerticalItemData.a());
      }
    }
    WSPicLoader.a(localArrayList, false, "fullscreen_videoplay");
  }
  
  private void a(@NonNull List<WSVerticalItemData> paramList, @NonNull WSVerticalPageContract.View paramView, int paramInt)
  {
    paramInt = a(paramList, WSVerticalDataUtil.a((WSVerticalItemData)a().getItem(paramInt)));
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
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null) && ((paramBoolean1) || (paramBoolean2))) {
      localView.a().a(1);
    }
  }
  
  private boolean a(String paramString, List<WSVerticalItemData> paramList)
  {
    return (TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.size() <= 0);
  }
  
  private void b(@NonNull WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    boolean bool = ((WSClearModeEvent)paramWSSimpleBaseEvent).isClearMode();
    this.e = bool;
    Object localObject = a();
    if (localObject != null)
    {
      paramWSSimpleBaseEvent = ((WSVerticalPageContract.View)localObject).a();
      if (paramWSSimpleBaseEvent != null)
      {
        localObject = ((WSVerticalPageContract.View)localObject).a();
        if (localObject == null) {
          return;
        }
        ((WSVerticalPageAdapter)localObject).a(bool);
        int i = 0;
        while (i < paramWSSimpleBaseEvent.getChildCount())
        {
          localObject = paramWSSimpleBaseEvent.getChildViewHolder(paramWSSimpleBaseEvent.getChildAt(i));
          if ((localObject instanceof WSVerticalCommonVideoHolder)) {
            ((WSVerticalCommonVideoHolder)localObject).b(bool);
          }
          i += 1;
        }
      }
    }
  }
  
  private void b(@Nullable WSVerticalPageContract.View paramView)
  {
    if ((paramView != null) && (paramView.a() != null))
    {
      paramView = paramView.a().a();
      if (paramView == null) {
        return;
      }
      this.jdField_a_of_type_Int = paramView.getAdapterPosition();
      paramView = new StringBuilder();
      paramView.append("updateCurrentPosition() mCurrentPosition = ");
      paramView.append(this.jdField_a_of_type_Int);
      WSLog.a("AbsWSVerticalPagePresenter", paramView.toString());
    }
  }
  
  private void b(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder, int paramInt)
  {
    if (!g()) {
      return;
    }
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((WSVerticalPageContract.View)localObject).a();
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
    if ((this.c) && (paramWSPlayerManager != null) && ((paramWSPlayerManager.c()) || (paramWSPlayerManager.b())))
    {
      WSVerticalBeaconReport.a(paramString1, paramString2, paramWSPlayerManager.a(), false, this.jdField_a_of_type_Int, b());
      paramWSPlayerManager.g();
      this.c = false;
    }
  }
  
  private void c(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSLog.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForComment]");
    paramWSSimpleBaseEvent = (WSAddCommentEvent)paramWSSimpleBaseEvent;
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    localObject = ((WSVerticalPageContract.View)localObject).a();
    if (localObject != null)
    {
      if (((WSVerticalPageAdapter)localObject).getDataList() == null) {
        return;
      }
      localObject = ((WSVerticalPageAdapter)localObject).getDataList();
      int i = 0;
      while (i < ((List)localObject).size())
      {
        WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)((List)localObject).get(i);
        if ((localWSVerticalItemData != null) && (localWSVerticalItemData.a() != null) && (TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), localWSVerticalItemData.a().id)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("data.getItemInfo().total_comment_num:");
          localStringBuilder.append(localWSVerticalItemData.a().total_comment_num);
          WSLog.c("AbsWSVerticalPagePresenter", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("wsAddCommentEvent.getCommentNum():");
          localStringBuilder.append(paramWSSimpleBaseEvent.getCommentNum());
          WSLog.c("AbsWSVerticalPagePresenter", localStringBuilder.toString());
          localWSVerticalItemData.a().total_comment_num = ((int)paramWSSimpleBaseEvent.getCommentNum());
          c(paramWSSimpleBaseEvent.getFeedId());
        }
        i += 1;
      }
    }
  }
  
  private void c(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((WSVerticalPageContract.View)localObject1).a();
    int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
      if ((localObject2 instanceof WSVerticalVideoHolder))
      {
        localObject2 = (WSVerticalVideoHolder)localObject2;
        stSimpleMetaFeed localstSimpleMetaFeed = a((WSVerticalItemData)((WSVerticalVideoHolder)localObject2).jdField_a_of_type_JavaLangObject);
        if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, paramString))) {
          ((WSVerticalVideoHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.d(2);
        }
      }
      i += 1;
    }
  }
  
  private void d(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSLog.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    Object localObject1 = a();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((WSVerticalPageContract.View)localObject1).a();
    if (localObject1 != null)
    {
      if (((WSVerticalPageAdapter)localObject1).getDataList() == null) {
        return;
      }
      localObject1 = ((WSVerticalPageAdapter)localObject1).getDataList();
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        Object localObject2 = (WSVerticalItemData)((List)localObject1).get(i);
        if ((localObject2 != null) && (((WSVerticalItemData)localObject2).a() != null) && (((WSVerticalItemData)localObject2).a().poster != null))
        {
          localObject2 = ((WSVerticalItemData)localObject2).a().poster;
          if (TextUtils.equals(((stSimpleMetaPerson)localObject2).id, paramWSSimpleBaseEvent.getPersonId()))
          {
            ((stSimpleMetaPerson)localObject2).followStatus = paramWSSimpleBaseEvent.getIsFollow();
            d(paramWSSimpleBaseEvent.getPersonId());
          }
        }
        i += 1;
      }
    }
  }
  
  private void d(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((WSVerticalPageContract.View)localObject1).a();
    int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
      if ((localObject2 instanceof WSVerticalVideoHolder))
      {
        Object localObject3 = (WSVerticalVideoHolder)localObject2;
        localObject2 = a((WSVerticalItemData)((WSVerticalVideoHolder)localObject3).jdField_a_of_type_JavaLangObject);
        if ((localObject2 != null) && (((stSimpleMetaFeed)localObject2).poster != null) && (TextUtils.equals(((stSimpleMetaFeed)localObject2).poster.id, paramString)))
        {
          ((WSVerticalVideoHolder)localObject3).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.d(1);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[updateFollowStatus]");
          ((StringBuilder)localObject3).append(((stSimpleMetaFeed)localObject2).poster.followStatus);
          WSLog.b("AbsWSVerticalPagePresenter", ((StringBuilder)localObject3).toString());
        }
      }
      i += 1;
    }
  }
  
  private void e(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSLog.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForLike]");
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    localObject = ((WSVerticalPageContract.View)localObject).a();
    if (localObject != null)
    {
      if (((WSVerticalPageAdapter)localObject).getDataList() == null) {
        return;
      }
      localObject = ((WSVerticalPageAdapter)localObject).getDataList();
      int i = 0;
      while (i < ((List)localObject).size())
      {
        WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)((List)localObject).get(i);
        if ((localWSVerticalItemData != null) && (localWSVerticalItemData.a() != null) && (TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), localWSVerticalItemData.a().id)))
        {
          if (paramWSSimpleBaseEvent.getRspIsDing() != localWSVerticalItemData.a().is_ding)
          {
            int j;
            if (localWSVerticalItemData.a().is_ding == 1) {
              j = 1;
            } else {
              j = 0;
            }
            stSimpleMetaFeed localstSimpleMetaFeed;
            if (j != 0)
            {
              localstSimpleMetaFeed = localWSVerticalItemData.a();
              localstSimpleMetaFeed.ding_count -= 1;
            }
            else
            {
              localstSimpleMetaFeed = localWSVerticalItemData.a();
              localstSimpleMetaFeed.ding_count += 1;
            }
          }
          localWSVerticalItemData.a().is_ding = paramWSSimpleBaseEvent.getRspIsDing();
          e(paramWSSimpleBaseEvent.getFeedId());
        }
        i += 1;
      }
    }
  }
  
  private void e(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((WSVerticalPageContract.View)localObject1).a();
    int j = ((VideoFeedsRecyclerView)localObject1).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = ((VideoFeedsRecyclerView)localObject1).getChildViewHolder(((VideoFeedsRecyclerView)localObject1).getChildAt(i));
      if ((localObject2 instanceof WSVerticalVideoHolder))
      {
        localObject2 = (WSVerticalVideoHolder)localObject2;
        stSimpleMetaFeed localstSimpleMetaFeed = a((WSVerticalItemData)((WSVerticalVideoHolder)localObject2).jdField_a_of_type_JavaLangObject);
        if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, paramString))) {
          ((WSVerticalVideoHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.d(0);
        }
      }
      i += 1;
    }
  }
  
  private void k()
  {
    if (!k()) {
      return;
    }
    WSPublicAccReport.getInstance().closePublicAccReport(c());
  }
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public long a()
  {
    return 0L;
  }
  
  @Nullable
  protected stSimpleMetaFeed a()
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      Object localObject3 = ((WSVerticalPageContract.View)localObject1).a();
      if (localObject3 != null)
      {
        WSLog.a("AbsWSVerticalPagePresenter", "getTargetCacheFeed");
        Object localObject2 = WSAioListHelper.a();
        if (localObject2 != null) {
          return localObject2;
        }
        WSVerticalItemData localWSVerticalItemData = ((WSVerticalPageAdapter)localObject3).a();
        localObject1 = localObject2;
        if (localWSVerticalItemData != null)
        {
          localObject1 = localObject2;
          if (localWSVerticalItemData.a() != null) {
            localObject1 = localWSVerticalItemData.a();
          }
        }
        if ((localObject1 != null) && (!TextUtils.isEmpty(((stSimpleMetaFeed)localObject1).feed_desc)) && (((stSimpleMetaFeed)localObject1).video_type != 2)) {
          return localObject1;
        }
        int j = ((WSVerticalPageAdapter)localObject3).a();
        localObject3 = ((WSVerticalPageAdapter)localObject3).getDataList();
        localObject2 = localObject1;
        int i = j;
        if (j >= ((List)localObject3).size() - 2) {
          return localObject1;
        }
        for (;;)
        {
          i += 1;
          localObject1 = localObject2;
          if (i >= ((List)localObject3).size()) {
            break;
          }
          localObject1 = ((WSVerticalItemData)((List)localObject3).get(i)).a();
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
  
  protected stSimpleMetaFeed a(int paramInt)
  {
    WSVerticalItemData localWSVerticalItemData = a(paramInt);
    if (localWSVerticalItemData != null) {
      return localWSVerticalItemData.a();
    }
    return null;
  }
  
  protected stSimpleMetaFeed a(WSVerticalItemData paramWSVerticalItemData)
  {
    if (paramWSVerticalItemData != null)
    {
      paramWSVerticalItemData = paramWSVerticalItemData.a();
      if (paramWSVerticalItemData != null) {
        return paramWSVerticalItemData;
      }
    }
    return null;
  }
  
  public WSPlayerParam a()
  {
    return null;
  }
  
  protected WSVerticalPageAdapter a()
  {
    WSVerticalPageContract.View localView = a();
    if (localView != null) {
      return localView.a();
    }
    return null;
  }
  
  public WSVerticalPageContract.View a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localWeakReference != null) {
      return (WSVerticalPageContract.View)localWeakReference.get();
    }
    return null;
  }
  
  protected WSVerticalItemData a()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = a();
    if (localWSVerticalVideoHolder == null) {
      return null;
    }
    return (WSVerticalItemData)localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject;
  }
  
  protected WSVerticalItemData a(int paramInt)
  {
    WSVerticalPageAdapter localWSVerticalPageAdapter = a();
    if ((localWSVerticalPageAdapter != null) && (paramInt >= 0)) {
      return (WSVerticalItemData)localWSVerticalPageAdapter.getItem(paramInt);
    }
    return null;
  }
  
  protected WSVerticalItemData a(String paramString, List<WSVerticalItemData> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[filterDataAndRemoveByFeedId] feedId:");
    ((StringBuilder)localObject).append(paramString);
    WSLog.d("AbsWSVerticalPagePresenter", ((StringBuilder)localObject).toString());
    if (a(paramString, paramList))
    {
      WSLog.d("AbsWSVerticalPagePresenter", "[filterDataAndRemoveByFeedId] feedId or itemList is empty!");
      return null;
    }
    localObject = new ArrayList(paramList).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)((Iterator)localObject).next();
      stSimpleMetaFeed localstSimpleMetaFeed = a(localWSVerticalItemData);
      if ((localstSimpleMetaFeed != null) && (TextUtils.equals(paramString, localstSimpleMetaFeed.id)))
      {
        paramList.remove(localWSVerticalItemData);
        return localWSVerticalItemData;
      }
    }
    return null;
  }
  
  protected WSVerticalVideoHolder a()
  {
    WSVerticalPageAdapter localWSVerticalPageAdapter = a();
    if (localWSVerticalPageAdapter != null) {
      return localWSVerticalPageAdapter.a();
    }
    return null;
  }
  
  public Map<String, String> a()
  {
    return null;
  }
  
  public void a() {}
  
  protected void a(int paramInt, String paramString)
  {
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null) && (localView.a().isEmpty())) {
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
    WSVerticalVideoHolder localWSVerticalVideoHolder = a();
    if ((localWSVerticalVideoHolder != null) && (localWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null)) {
      localWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.a = WSPlayerUtils.a(paramstSimpleMetaFeed);
    }
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt > 0) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (paramWSSimpleBaseEvent == null) {
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
    {
      e(paramWSSimpleBaseEvent);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof FollowEvent))
    {
      d(paramWSSimpleBaseEvent);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSAddCommentEvent))
    {
      c(paramWSSimpleBaseEvent);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSClearModeEvent)) {
      b(paramWSSimpleBaseEvent);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean) {}
  
  public void a(@NonNull WSVerticalPageContract.View paramView) {}
  
  protected void a(WSVerticalItemData paramWSVerticalItemData)
  {
    WSVerticalPageContract.View localView = a();
    if (localView != null) {
      localView.a(paramWSVerticalItemData);
    }
  }
  
  protected void a(WSVerticalItemData paramWSVerticalItemData, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramWSVerticalItemData != null)
    {
      if (paramstSimpleMetaFeed == null) {
        return;
      }
      stSimpleMetaFeed localstSimpleMetaFeed = paramWSVerticalItemData.a();
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
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    WSLog.e("WSEpisodeChoicePanel", localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = a(paramString);
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
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    WSLog.e("WSEpisodeChoicePanel", localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = a(paramBoolean1, paramBoolean2, paramString);
    if ((!paramBoolean1) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper.b();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, Object paramObject)
  {
    return false;
  }
  
  public int b()
  {
    return jdField_b_of_type_Int;
  }
  
  public Map<String, String> b()
  {
    return new HashMap();
  }
  
  public void b()
  {
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null)) {
      localView.a().d(j());
    }
    if (k()) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 10);
    }
  }
  
  public void b(String paramString)
  {
    a(true, false, paramString);
  }
  
  protected void b(@NonNull List<WSVerticalItemData> paramList, WSVerticalPageContract.View paramView)
  {
    paramView.a(paramList);
  }
  
  protected void b(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    WSVerticalPageContract.View localView = a();
    if (localView == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper.a();
    localView.f();
    localView.e();
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
    WSVerticalBeaconReport.a(paramList, paramBoolean2, true, -1, localView.a(), localView.b());
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[AbsWSVerticalPagePresenter.java][reportVideoPlay] isPlay:");
    ((StringBuilder)localObject1).append(paramBoolean);
    WSLog.e("WS_VIDEO_PLAY_TIME", ((StringBuilder)localObject1).toString());
    localObject1 = a();
    if (localObject1 != null)
    {
      Object localObject2 = ((WSVerticalPageContract.View)localObject1).a();
      if (localObject2 == null) {
        return;
      }
      localObject2 = ((WSVerticalPageAdapter)localObject2).a();
      if (paramBoolean)
      {
        a(((WSVerticalPageContract.View)localObject1).a(), ((WSVerticalPageContract.View)localObject1).b(), (WSPlayerManager)localObject2);
        return;
      }
      b(((WSVerticalPageContract.View)localObject1).a(), ((WSVerticalPageContract.View)localObject1).b(), (WSPlayerManager)localObject2);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    if ((!WSReportEventConstants.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
      return 2;
    }
    return 1;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper.a(a().b());
  }
  
  protected void c(@NonNull List<WSVerticalItemData> paramList, WSVerticalPageContract.View paramView)
  {
    paramView.b(paramList);
  }
  
  protected void c(@NonNull List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    WSVerticalPageContract.View localView = a();
    if (localView == null) {
      return;
    }
    int i = a(paramBoolean1, paramBoolean2, paramList, paramObject);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            b(paramList, localView);
          }
        }
        else {
          c(paramList, localView);
        }
      }
      else {
        a(paramList, localView, this.jdField_a_of_type_Int);
      }
    }
    else {
      a(paramList, localView);
    }
    b(localView);
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    if (l()) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 10);
    }
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e() {}
  
  public void f()
  {
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null) && (i()))
    {
      localView.a().e();
      b(true);
    }
    if (i()) {
      WSPlayerAudioControl.a().a(true);
    }
  }
  
  public void g()
  {
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null))
    {
      localView.a().f();
      b(false);
    }
    WSPlayerAudioControl.a().a(false);
    i();
  }
  
  protected boolean g()
  {
    return false;
  }
  
  public void h()
  {
    this.d = true;
    WSReportDC898Vertical.b();
    k();
  }
  
  protected boolean h()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((WSVerticalPageContract.View)localObject).a();
      if ((localObject != null) && ((((WSPlayerManager)localObject).e()) || ((!((WSPlayerManager)localObject).c()) && (!((WSPlayerManager)localObject).b()))))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[isFirstVideoPlayInvalid] state:");
        localStringBuilder.append(((WSPlayerManager)localObject).a());
        WSLog.d("AbsWSVerticalPagePresenter", localStringBuilder.toString());
        return true;
      }
    }
    return false;
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper.d();
  }
  
  public boolean i()
  {
    return true;
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper.c();
  }
  
  public boolean j()
  {
    return true;
  }
  
  protected boolean k()
  {
    return false;
  }
  
  protected boolean l()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter
 * JD-Core Version:    0.7.0.1
 */