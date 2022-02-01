package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.commercial.WSWidgetDataManager;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.IVerticalRspListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public abstract class AbsWSVerticalPagePresenter
  implements WSVerticalPageContract.Presenter, IVerticalRspListener
{
  private static final int b;
  public int a;
  private final WeakReference<WSVerticalPageContract.View> a;
  protected boolean a;
  public boolean b;
  public boolean c;
  private boolean d;
  
  static
  {
    jdField_b_of_type_Int = ScreenUtil.dip2px(40.0F);
  }
  
  public AbsWSVerticalPagePresenter(WSVerticalPageContract.View paramView)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramView);
  }
  
  private stSimpleMetaFeed a(WSVerticalItemData paramWSVerticalItemData)
  {
    if ((paramWSVerticalItemData != null) && ((paramWSVerticalItemData.a() instanceof stSimpleMetaFeed))) {
      return paramWSVerticalItemData.a();
    }
    return null;
  }
  
  private void a()
  {
    if (!f()) {
      return;
    }
    WSPublicAccReport.getInstance().closePublicAccReport(c());
  }
  
  private void a(int paramInt, String paramString)
  {
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null) && (localView.a().c())) {
      localView.a(paramInt, paramString);
    }
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    WSVerticalPageContract.View localView = a();
    if (localView == null) {
      return;
    }
    this.d = false;
    localView.f();
    localView.e();
    a(paramInt, paramString);
    WSVerticalBeaconReport.a(null, paramBoolean, false, paramInt, localView.a(), localView.b());
  }
  
  private void a(String paramString1, String paramString2, WSPlayerManager paramWSPlayerManager)
  {
    if ((paramWSPlayerManager != null) && (paramWSPlayerManager.c()))
    {
      WSVerticalBeaconReport.a(paramString1, paramString2, paramWSPlayerManager.a(), this.jdField_a_of_type_Int);
      this.jdField_b_of_type_Boolean = true;
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
    WeishiUtils.a(localArrayList, false, "fullscreen_videoplay");
  }
  
  private void a(List<WSVerticalItemData> paramList, boolean paramBoolean)
  {
    WSVerticalPageContract.View localView = a();
    if (localView == null) {
      return;
    }
    if (paramBoolean)
    {
      localView.a(paramList);
      return;
    }
    localView.a(paramList);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null) && ((paramBoolean1) || (paramBoolean2))) {
      localView.a().a(1);
    }
  }
  
  private void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSLog.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForComment]");
    paramWSSimpleBaseEvent = (WSAddCommentEvent)paramWSSimpleBaseEvent;
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((WSVerticalPageContract.View)localObject).a();
    } while ((localObject == null) || (((WSVerticalPageAdapter)localObject).b() == null));
    localObject = ((WSVerticalPageAdapter)localObject).b();
    int i = 0;
    label47:
    WSVerticalItemData localWSVerticalItemData;
    if (i < ((List)localObject).size())
    {
      localWSVerticalItemData = (WSVerticalItemData)((List)localObject).get(i);
      if ((localWSVerticalItemData != null) && (localWSVerticalItemData.a() != null)) {
        break label89;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label89:
      if (TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), localWSVerticalItemData.a().id))
      {
        WSLog.c("AbsWSVerticalPagePresenter", "data.getItemInfo().total_comment_num:" + localWSVerticalItemData.a().total_comment_num);
        WSLog.c("AbsWSVerticalPagePresenter", "wsAddCommentEvent.getCommentNum():" + paramWSSimpleBaseEvent.getCommentNum());
        localWSVerticalItemData.a().total_comment_num = ((int)paramWSSimpleBaseEvent.getCommentNum());
        b(paramWSSimpleBaseEvent.getFeedId());
      }
    }
  }
  
  private void b(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder, int paramInt)
  {
    if (!b()) {}
    do
    {
      do
      {
        return;
        localObject = a();
      } while (localObject == null);
      localObject = ((WSVerticalPageContract.View)localObject).a();
    } while ((localObject == null) || (!(paramBaseViewHolder instanceof WSVerticalVideoHolder)));
    Object localObject = ((WSVerticalPageAdapter)localObject).b();
    WSWidgetDataManager.a().a(paramInt, (List)localObject, new AbsWSVerticalPagePresenter.1(this, paramBaseViewHolder));
  }
  
  private void b(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
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
            ((WSVerticalVideoHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.c(2);
          }
        }
        i += 1;
      }
    }
  }
  
  private void b(String paramString1, String paramString2, WSPlayerManager paramWSPlayerManager)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramWSPlayerManager != null) && ((paramWSPlayerManager.c()) || (paramWSPlayerManager.b())))
    {
      WSVerticalBeaconReport.a(paramString1, paramString2, paramWSPlayerManager.a(), false, this.jdField_a_of_type_Int);
      paramWSPlayerManager.g();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private void b(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    WSVerticalPageContract.View localView = a();
    if (localView == null) {
      return;
    }
    this.d = false;
    localView.f();
    localView.e();
    if (paramList.size() > 0)
    {
      a(paramList);
      a(paramBoolean1, paramBoolean2);
      a(paramList, a(paramBoolean1, paramBoolean2, paramList, paramObject));
    }
    for (;;)
    {
      WSVerticalBeaconReport.a(paramList, paramBoolean2, true, -1, localView.a(), localView.b());
      return;
      a(-1, "");
    }
  }
  
  private void c(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSLog.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    Object localObject1 = a();
    if (localObject1 == null) {}
    do
    {
      return;
      localObject1 = ((WSVerticalPageContract.View)localObject1).a();
    } while ((localObject1 == null) || (((WSVerticalPageAdapter)localObject1).b() == null));
    localObject1 = ((WSVerticalPageAdapter)localObject1).b();
    int i = 0;
    label48:
    Object localObject2;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (WSVerticalItemData)((List)localObject1).get(i);
      if ((localObject2 != null) && (((WSVerticalItemData)localObject2).a() != null) && (((WSVerticalItemData)localObject2).a().poster != null)) {
        break label101;
      }
    }
    for (;;)
    {
      i += 1;
      break label48;
      break;
      label101:
      localObject2 = ((WSVerticalItemData)localObject2).a().poster;
      if (TextUtils.equals(((stSimpleMetaPerson)localObject2).id, paramWSSimpleBaseEvent.getPersonId()))
      {
        ((stSimpleMetaPerson)localObject2).followStatus = paramWSSimpleBaseEvent.getIsFollow();
        c(paramWSSimpleBaseEvent.getPersonId());
      }
    }
  }
  
  private void c(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
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
          if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.poster != null) && (TextUtils.equals(localstSimpleMetaFeed.poster.id, paramString)))
          {
            ((WSVerticalVideoHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.c(1);
            WSLog.b("AbsWSVerticalPagePresenter", "[updateFollowStatus]" + localstSimpleMetaFeed.poster.followStatus);
          }
        }
        i += 1;
      }
    }
  }
  
  private void d(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSLog.b("AbsWSVerticalPagePresenter", "[handleOnReceiveEventForLike]");
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((WSVerticalPageContract.View)localObject).a();
    } while ((localObject == null) || (((WSVerticalPageAdapter)localObject).b() == null));
    localObject = ((WSVerticalPageAdapter)localObject).b();
    int i = 0;
    label56:
    WSVerticalItemData localWSVerticalItemData;
    if (i < ((List)localObject).size())
    {
      localWSVerticalItemData = (WSVerticalItemData)((List)localObject).get(i);
      if ((localWSVerticalItemData != null) && (localWSVerticalItemData.a() != null)) {
        break label100;
      }
    }
    label100:
    while (!TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), localWSVerticalItemData.a().id))
    {
      i += 1;
      break label56;
      break;
    }
    int j;
    label147:
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (paramWSSimpleBaseEvent.getRspIsDing() != localWSVerticalItemData.a().is_ding)
    {
      if (localWSVerticalItemData.a().is_ding != 1) {
        break label193;
      }
      j = 1;
      if (j == 0) {
        break label198;
      }
      localstSimpleMetaFeed = localWSVerticalItemData.a();
    }
    for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
    {
      localWSVerticalItemData.a().is_ding = paramWSSimpleBaseEvent.getRspIsDing();
      d(paramWSSimpleBaseEvent.getFeedId());
      break;
      label193:
      j = 0;
      break label147;
      label198:
      localstSimpleMetaFeed = localWSVerticalItemData.a();
    }
  }
  
  private void d(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
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
            ((WSVerticalVideoHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.c(0);
          }
        }
        i += 1;
      }
    }
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
  
  public WSVerticalPageContract.View a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      return (WSVerticalPageContract.View)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
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
  
  public void a(Bundle paramBundle) {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt > 0) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (paramWSSimpleBaseEvent == null) {}
    do
    {
      return;
      if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
      {
        d(paramWSSimpleBaseEvent);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof FollowEvent))
      {
        c(paramWSSimpleBaseEvent);
        return;
      }
    } while (!(paramWSSimpleBaseEvent instanceof WSAddCommentEvent));
    b(paramWSSimpleBaseEvent);
  }
  
  public void a(@NonNull WSVerticalPageContract.View paramView) {}
  
  public void a(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder, int paramInt)
  {
    WSLog.a("AbsWSVerticalPagePresenter", "onHandleBindCustomViewHolder");
    b(paramBaseViewHolder, paramInt);
  }
  
  public void a(String paramString)
  {
    a(true, false, paramString);
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
    if (this.d) {
      return;
    }
    this.d = a(paramBoolean1, paramBoolean2, paramString);
  }
  
  public boolean a()
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
  
  public void b(boolean paramBoolean)
  {
    WSLog.e("WS_VIDEO_PLAY_TIME", "[AbsWSVerticalPagePresenter.java][reportVideoPlay] isPlay:" + paramBoolean);
    WSVerticalPageContract.View localView = a();
    if (localView != null)
    {
      localObject = localView.a();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    Object localObject = ((WSVerticalPageAdapter)localObject).a();
    if (paramBoolean)
    {
      a(localView.a(), localView.b(), (WSPlayerManager)localObject);
      return;
    }
    b(localView.a(), localView.b(), (WSPlayerManager)localObject);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public int c()
  {
    int i = 2;
    if ((WSReportEventConstants.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
      i = 1;
    }
    return i;
  }
  
  public void c() {}
  
  protected boolean c()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((WSVerticalPageContract.View)localObject).a();
      if ((localObject != null) && ((((WSPlayerManager)localObject).e()) || ((!((WSPlayerManager)localObject).c()) && (!((WSPlayerManager)localObject).b()))))
      {
        WSLog.d("AbsWSVerticalPagePresenter", "[isFirstVideoPlayInvalid] state:" + ((WSPlayerManager)localObject).a());
        return true;
      }
    }
    return false;
  }
  
  public void d()
  {
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null)) {
      localView.a().d(e());
    }
    if (f()) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 10);
    }
  }
  
  public boolean d()
  {
    return true;
  }
  
  public void e() {}
  
  public boolean e()
  {
    return true;
  }
  
  public void f()
  {
    if (g()) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 10);
    }
  }
  
  protected boolean f()
  {
    return false;
  }
  
  public void g()
  {
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null) && (d()))
    {
      localView.a().e();
      b(true);
    }
    if (d()) {
      WSPlayerAudioControl.a().a(true);
    }
  }
  
  protected boolean g()
  {
    return false;
  }
  
  public void h()
  {
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null))
    {
      localView.a().f();
      b(false);
    }
    WSPlayerAudioControl.a().a(false);
  }
  
  public void i()
  {
    this.c = true;
    WSReportDC898Vertical.b();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter
 * JD-Core Version:    0.7.0.1
 */