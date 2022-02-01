package com.tencent.biz.qqcircle.scrollers;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.events.QCircleFeedViewExportEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.manager.QCircleStickHideManager;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

public class QCircleFeedExportScroller
  extends QCircleFeedBaseScroller
  implements View.OnTouchListener
{
  private static String g = "QCircleFeedExportScroller";
  private int h = 0;
  private Bundle i = null;
  
  private void a(LinearLayoutManager paramLinearLayoutManager)
  {
    int j = paramLinearLayoutManager.findFirstVisibleItemPosition();
    int k = paramLinearLayoutManager.findLastVisibleItemPosition();
    a(this.b, j, k);
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramRecyclerView == null) {
      return;
    }
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (paramRecyclerView == null) {
      return;
    }
    if (paramInt1 <= paramInt2) {
      while (paramInt1 <= paramInt2)
      {
        View localView = paramRecyclerView.findViewByPosition(paramInt1);
        if ((localView instanceof QCircleBaseWidgetView)) {
          b((QCircleBaseWidgetView)localView);
        }
        paramInt1 += 1;
      }
    }
  }
  
  private void a(QCircleBaseWidgetView paramQCircleBaseWidgetView)
  {
    if (!f())
    {
      QLog.d(g, 1, new Object[] { "[QCFE][checkViewStartExpose] view hash code:", Integer.valueOf(paramQCircleBaseWidgetView.hashCode()) });
      return;
    }
    if (paramQCircleBaseWidgetView == null)
    {
      QLog.d(g, 1, "[QCFE][checkViewStartExpose] view not is null.");
      return;
    }
    paramQCircleBaseWidgetView.post(new QCircleFeedExportScroller.1(this, paramQCircleBaseWidgetView));
  }
  
  private void a(SafeStaggeredGridLayoutManager paramSafeStaggeredGridLayoutManager)
  {
    int[] arrayOfInt = paramSafeStaggeredGridLayoutManager.findFirstVisibleItemPositions(null);
    paramSafeStaggeredGridLayoutManager = paramSafeStaggeredGridLayoutManager.findLastVisibleItemPositions(null);
    if ((arrayOfInt != null) && (paramSafeStaggeredGridLayoutManager != null) && (arrayOfInt.length != 0))
    {
      if (paramSafeStaggeredGridLayoutManager.length == 0) {
        return;
      }
      if (arrayOfInt.length > 1) {
        return;
      }
      a(this.b, arrayOfInt[0], paramSafeStaggeredGridLayoutManager[0]);
    }
  }
  
  private void b(@NonNull QCircleBaseWidgetView paramQCircleBaseWidgetView)
  {
    if (!(paramQCircleBaseWidgetView instanceof QCircleInsFeedItemView)) {
      return;
    }
    if (!a(paramQCircleBaseWidgetView)) {
      return;
    }
    QCircleInsFeedItemView localQCircleInsFeedItemView = (QCircleInsFeedItemView)paramQCircleBaseWidgetView;
    Object localObject = c(paramQCircleBaseWidgetView);
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((FeedCloudMeta.StFeed)localObject).id.get();
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.d(g, 1, "[QCFE][startRecordFeedExposeTask] current feed id is empty.");
      return;
    }
    QLog.d(g, 1, new Object[] { "[QCFE][startRecordFeedExposeTask] view hash code: ", Integer.valueOf(paramQCircleBaseWidgetView.hashCode()) });
    paramQCircleBaseWidgetView = g();
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedViewExportEvent((String)localObject, paramQCircleBaseWidgetView, localQCircleInsFeedItemView.getReportBean()));
  }
  
  private FeedCloudMeta.StFeed c(@NonNull QCircleBaseWidgetView paramQCircleBaseWidgetView)
  {
    paramQCircleBaseWidgetView = paramQCircleBaseWidgetView.getData();
    if ((paramQCircleBaseWidgetView instanceof FeedBlockData)) {
      return ((FeedBlockData)paramQCircleBaseWidgetView).b();
    }
    return null;
  }
  
  private void h()
  {
    if ((f()) && (this.b != null))
    {
      RecyclerView.LayoutManager localLayoutManager = this.b.getLayoutManager();
      try
      {
        if ((localLayoutManager instanceof LinearLayoutManager))
        {
          a((LinearLayoutManager)localLayoutManager);
          return;
        }
        if ((localLayoutManager instanceof SafeStaggeredGridLayoutManager))
        {
          a((SafeStaggeredGridLayoutManager)localLayoutManager);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e(g, 1, "[QCFE][handlerGridManagerExport] ex", localException);
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    h();
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.itemView instanceof QCircleBaseWidgetView)) {
      a((QCircleBaseWidgetView)paramViewHolder.itemView);
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (paramInt1 == 0) {
      try
      {
        a(paramRecyclerView, paramInt2, paramInt3);
      }
      catch (Exception paramRecyclerView)
      {
        paramRecyclerView.printStackTrace();
      }
    }
    this.h = paramInt1;
  }
  
  public void b() {}
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void c() {}
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.h != 0) {
      return;
    }
    if ((paramViewHolder.itemView instanceof QCircleBaseWidgetView)) {
      a((QCircleBaseWidgetView)paramViewHolder.itemView);
    }
  }
  
  public void d() {}
  
  public void e() {}
  
  public Bundle g()
  {
    if (this.i == null) {
      this.i = new Bundle();
    }
    return this.i;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QCircleStickHideManager.a().b();
    if (paramMotionEvent.getAction() == 0) {
      h();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedExportScroller
 * JD-Core Version:    0.7.0.1
 */