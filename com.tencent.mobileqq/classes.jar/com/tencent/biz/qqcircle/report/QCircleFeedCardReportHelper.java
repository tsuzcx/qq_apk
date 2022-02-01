package com.tencent.biz.qqcircle.report;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller.OnFeedScrollerListener;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendItemViewHolder;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendView;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.qqcircle.report.QCircleLpReportDc05502.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import qqcircle.QQCircleDitto.StItemInfo;

public class QCircleFeedCardReportHelper
  extends RecyclerView.OnScrollListener
  implements ReportBean<QCircleReportBean>, QCircleFeedReportScroller.OnFeedScrollerListener
{
  private static String a = "QCircleFeedCardReportHelper";
  private FeedCloudMeta.StFeed b;
  private int c;
  private volatile boolean d = false;
  private ArrayList<QCirclePYMKRecommendItemViewHolder> e = new ArrayList();
  private HashMap<QCirclePYMKRecommendItemViewHolder, Long> f = new HashMap();
  private boolean g;
  private int h;
  private QCircleReportBean i;
  private RecyclerView j;
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.f.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      float f2 = 0.0F;
      Object localObject1;
      float f1;
      int k;
      Object localObject2;
      if (paramBoolean)
      {
        localObject1 = this.j;
        f1 = f2;
        k = paramInt1;
        if (localObject1 != null)
        {
          k = ((LinearLayoutManager)((RecyclerView)localObject1).getLayoutManager()).findFirstVisibleItemPosition();
          f1 = f2;
        }
      }
      else
      {
        localObject1 = ((QCirclePYMKRecommendItemViewHolder)localEntry.getKey()).itemView;
        localObject2 = new Rect(0, 0, ImmersiveUtils.b(), ImmersiveUtils.c());
        ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
        f1 = (((Rect)localObject2).right - ((Rect)localObject2).left) * (((Rect)localObject2).bottom - ((Rect)localObject2).top) / (((View)localObject1).getWidth() * ((View)localObject1).getHeight());
        k = paramInt1;
      }
      if ((!paramBoolean) && (((QCirclePYMKRecommendItemViewHolder)localEntry.getKey()).c() >= k) && (((QCirclePYMKRecommendItemViewHolder)localEntry.getKey()).c() <= paramInt2))
      {
        paramInt1 = k;
        if (((QCirclePYMKRecommendItemViewHolder)localEntry.getKey()).c() >= k)
        {
          paramInt1 = k;
          if (((QCirclePYMKRecommendItemViewHolder)localEntry.getKey()).c() <= paramInt2)
          {
            paramInt1 = k;
            if (f1 >= 0.8F) {}
          }
        }
      }
      else
      {
        long l = System.currentTimeMillis() - ((Long)localEntry.getValue()).longValue();
        localObject1 = ((QCirclePYMKRecommendItemViewHolder)localEntry.getKey()).b();
        if (localObject1 != null) {
          QCircleLpReportDc05502.report(new QCircleLpReportDc05502.DataBuilder(QCirclePluginReportUtil.c(this.b).setToUin(((QQCircleDitto.StItemInfo)localObject1).id.get()).setFeedType1(3).setFeedType2(1).setFeedType3(1).setIndex(this.c).setExt2(String.valueOf(((QCirclePYMKRecommendItemViewHolder)localEntry.getKey()).c() - k + 1)).setStayTime(l).setContainerSeq(((QCirclePYMKRecommendItemViewHolder)localEntry.getKey()).c()).setPageId(this.h)));
        }
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PYMKScrollReport reportCardExposeTime  pymkPos = ");
        ((StringBuilder)localObject2).append(((QCirclePYMKRecommendItemViewHolder)localEntry.getKey()).c());
        ((StringBuilder)localObject2).append(" , durationTime = ");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(" , notCompute = ");
        ((StringBuilder)localObject2).append(paramBoolean);
        ((StringBuilder)localObject2).append(" , firstVisiblePos = ");
        ((StringBuilder)localObject2).append(k);
        QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        localIterator.remove();
        paramInt1 = k;
      }
    }
  }
  
  private void b(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null)
    {
      if (!(paramRecyclerView.getLayoutManager() instanceof SafeStaggeredGridLayoutManager)) {
        return;
      }
      paramRecyclerView = (SafeStaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
      Object localObject = paramRecyclerView.findFirstVisibleItemPositions(null);
      int[] arrayOfInt = paramRecyclerView.findLastVisibleItemPositions(null);
      if ((localObject.length >= 1) && (arrayOfInt.length >= 1))
      {
        if (localObject[0] > arrayOfInt[0]) {
          return;
        }
        int k = localObject[0];
        while (k <= arrayOfInt[0])
        {
          localObject = paramRecyclerView.findViewByPosition(k);
          if ((localObject instanceof QCirclePYMKRecommendView))
          {
            RecyclerView localRecyclerView = ((QCirclePYMKRecommendView)localObject).getRecyclerView();
            if (localRecyclerView == null) {
              return;
            }
            Rect localRect = new Rect(0, 0, ImmersiveUtils.b(), ImmersiveUtils.c());
            ((View)localObject).getGlobalVisibleRect(localRect);
            if ((localRect.bottom - localRect.top) / ((View)localObject).getHeight() >= 0.8F) {
              c(localRecyclerView);
            } else {
              a(true, -1, -1);
            }
          }
          k += 1;
        }
      }
    }
  }
  
  private void b(QCirclePYMKRecommendItemViewHolder paramQCirclePYMKRecommendItemViewHolder)
  {
    if (paramQCirclePYMKRecommendItemViewHolder != null) {
      try
      {
        localObject1 = paramQCirclePYMKRecommendItemViewHolder.itemView;
        if (localObject1 == null) {
          return;
        }
        int m = ImmersiveUtils.b();
        int n = ImmersiveUtils.c();
        int k = 0;
        localObject2 = new Rect(0, 0, m, n);
        ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
        m = ((View)localObject1).getWidth();
        if (((Rect)localObject2).right > 0) {
          k = ((Rect)localObject2).right - ((Rect)localObject2).left;
        }
        if (k / m >= 0.5D)
        {
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("PYMKScrollReport report card expose index:");
          ((StringBuilder)localObject2).append(paramQCirclePYMKRecommendItemViewHolder.c());
          QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          c(paramQCirclePYMKRecommendItemViewHolder);
          return;
        }
      }
      catch (Exception paramQCirclePYMKRecommendItemViewHolder)
      {
        Object localObject1 = a;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkCardExpose exception:");
        ((StringBuilder)localObject2).append(paramQCirclePYMKRecommendItemViewHolder.toString());
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private void c(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null)
    {
      if (!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
        return;
      }
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
      int m = localLinearLayoutManager.findFirstVisibleItemPosition();
      int n = localLinearLayoutManager.findLastVisibleItemPosition();
      if (m > n) {
        return;
      }
      int k = m;
      while (k <= n)
      {
        Object localObject1 = localLinearLayoutManager.findViewByPosition(k);
        Object localObject2 = paramRecyclerView.findViewHolderForLayoutPosition(k);
        if (!(localObject2 instanceof QCirclePYMKRecommendItemViewHolder)) {
          return;
        }
        localObject2 = (QCirclePYMKRecommendItemViewHolder)localObject2;
        Rect localRect = new Rect(0, 0, ImmersiveUtils.b(), ImmersiveUtils.c());
        ((View)localObject1).getGlobalVisibleRect(localRect);
        float f1 = (localRect.right - localRect.left) * (localRect.bottom - localRect.top) / (((View)localObject1).getWidth() * ((View)localObject1).getHeight());
        if ((f1 >= 0.8F) && (!this.f.keySet().contains(localObject2)))
        {
          this.f.put(localObject2, Long.valueOf(System.currentTimeMillis()));
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("PYMKScrollReport checkCardExposeTimeHorizontal addMapList rate = ");
          ((StringBuilder)localObject2).append(f1);
          QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        k += 1;
      }
      a(false, m, n);
    }
  }
  
  private void c(QCirclePYMKRecommendItemViewHolder paramQCirclePYMKRecommendItemViewHolder)
  {
    Object localObject = this.j;
    int k;
    if (localObject != null) {
      k = ((LinearLayoutManager)((RecyclerView)localObject).getLayoutManager()).findFirstVisibleItemPosition();
    } else {
      k = 0;
    }
    localObject = paramQCirclePYMKRecommendItemViewHolder.b();
    if (localObject != null) {
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(this.b).setToUin(((QQCircleDitto.StItemInfo)localObject).id.get()).setFeedType1(3).setFeedType2(1).setActionType(3).setSubActionType(1).setExt2(String.valueOf(paramQCirclePYMKRecommendItemViewHolder.c() - k + 1)).setIndex(this.c).setContainerSeq(paramQCirclePYMKRecommendItemViewHolder.c()).setPageId(this.h)));
    }
  }
  
  private void d(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null)
    {
      if (!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
        return;
      }
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
      int m = localLinearLayoutManager.findFirstVisibleItemPosition();
      int n = localLinearLayoutManager.findLastVisibleItemPosition();
      int k = m;
      if (m > n) {
        return;
      }
      while (k <= n)
      {
        Object localObject2 = localLinearLayoutManager.findViewByPosition(k);
        Object localObject1 = paramRecyclerView.findViewHolderForLayoutPosition(k);
        if (!(localObject1 instanceof QCirclePYMKRecommendItemViewHolder)) {
          return;
        }
        localObject1 = (QCirclePYMKRecommendItemViewHolder)localObject1;
        int i1 = ImmersiveUtils.b();
        int i2 = ImmersiveUtils.c();
        m = 0;
        Object localObject3 = new Rect(0, 0, i1, i2);
        ((View)localObject2).getGlobalVisibleRect((Rect)localObject3);
        i1 = ((View)localObject2).getWidth();
        if (((Rect)localObject3).right > 0) {
          m = ((Rect)localObject3).right - ((Rect)localObject3).left;
        }
        if (m / i1 >= 0.5D)
        {
          localObject2 = a;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("PYMKScrollReport report card expose index:");
          ((StringBuilder)localObject3).append(k);
          QLog.d((String)localObject2, 1, ((StringBuilder)localObject3).toString());
          c((QCirclePYMKRecommendItemViewHolder)localObject1);
        }
        k += 1;
      }
    }
  }
  
  private void e()
  {
    if (!this.d)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PYMKScrollReport checkFirstScreenCardExpose report expose size:");
      localStringBuilder.append(this.e.size());
      QLog.d(str, 1, localStringBuilder.toString());
      int k = 0;
      while (k < this.e.size())
      {
        b((QCirclePYMKRecommendItemViewHolder)this.e.get(k));
        k += 1;
      }
      this.d = true;
    }
    this.e.clear();
  }
  
  public QCircleReportBean a()
  {
    return this.i;
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.j = paramRecyclerView;
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (Math.abs(paramInt2) < 10) {
      return;
    }
    b(paramRecyclerView);
  }
  
  public void a(QCirclePYMKRecommendItemViewHolder paramQCirclePYMKRecommendItemViewHolder)
  {
    if (!this.d) {
      this.e.add(paramQCirclePYMKRecommendItemViewHolder);
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    this.b = paramStFeed;
    this.c = paramInt;
  }
  
  public void b()
  {
    a(true, -1, -1);
  }
  
  public void c()
  {
    c(this.j);
  }
  
  public void d()
  {
    e();
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PYMKScrollReport onScrollStateChanged");
      localStringBuilder.append(paramInt);
      QLog.d(str, 1, localStringBuilder.toString());
      try
      {
        d(paramRecyclerView);
        c(paramRecyclerView);
      }
      catch (Exception paramRecyclerView)
      {
        paramRecyclerView.printStackTrace();
      }
      if (this.g) {
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(this.b).setFeedType1(3).setFeedType2(1).setActionType(30).setSubActionType(2).setIndex(this.c).setPageId(this.h)));
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    boolean bool;
    if (paramInt1 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.g = bool;
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleFeedCardReportHelper
 * JD-Core Version:    0.7.0.1
 */