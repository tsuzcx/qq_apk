package com.tencent.biz.qqcircle.scrollers;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QCircleFeedScrollManager
  extends RecyclerView.OnScrollListener
{
  public static String a = "QCircleFeedScrollHelper";
  public static float b = 500.0F;
  public static float c = 3.0F;
  public static int d = -1;
  public static int e = 0;
  public static int f = 1;
  private final RecyclerView g;
  private BaseListViewAdapter h;
  private final Context i;
  private boolean j = false;
  private int k;
  private int l;
  private long m;
  private List<QCircleFeedBaseScroller> n = new ArrayList();
  
  public QCircleFeedScrollManager(Context paramContext, RecyclerView paramRecyclerView, BaseListViewAdapter paramBaseListViewAdapter)
  {
    this.i = paramContext;
    this.g = paramRecyclerView;
    this.h = paramBaseListViewAdapter;
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).a(paramRecyclerView, paramInt1, paramInt2, paramBoolean);
    }
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).a(paramRecyclerView, paramInt1, paramLayoutManager, paramInt2, paramInt3, paramInt4, paramInt5, this.j);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int[] arrayOfInt = g();
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).a(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3], paramBoolean);
    }
  }
  
  private int[] g()
  {
    int[] arrayOfInt = new int[4];
    try
    {
      if (this.g != null)
      {
        Object localObject;
        if ((this.g.getLayoutManager() instanceof SafeStaggeredGridLayoutManager))
        {
          localObject = (SafeStaggeredGridLayoutManager)this.g.getLayoutManager();
          arrayOfInt[0] = localObject.findFirstVisibleItemPositions(null)[0];
          arrayOfInt[1] = localObject.findLastVisibleItemPositions(null)[0];
          arrayOfInt[2] = localObject.findFirstCompletelyVisibleItemPositions(null)[0];
          arrayOfInt[3] = localObject.findLastCompletelyVisibleItemPositions(null)[0];
          return arrayOfInt;
        }
        if ((this.g.getLayoutManager() instanceof SafeGridLayoutManager))
        {
          localObject = (SafeGridLayoutManager)this.g.getLayoutManager();
          arrayOfInt[0] = ((SafeGridLayoutManager)localObject).findFirstVisibleItemPosition();
          arrayOfInt[1] = ((SafeGridLayoutManager)localObject).findLastVisibleItemPosition();
          arrayOfInt[2] = ((SafeGridLayoutManager)localObject).findFirstCompletelyVisibleItemPosition();
          arrayOfInt[3] = ((SafeGridLayoutManager)localObject).findLastCompletelyVisibleItemPosition();
          return arrayOfInt;
        }
        if ((this.g.getLayoutManager() instanceof SafeLinearLayoutManager))
        {
          localObject = (SafeLinearLayoutManager)this.g.getLayoutManager();
          arrayOfInt[0] = ((SafeLinearLayoutManager)localObject).findFirstVisibleItemPosition();
          arrayOfInt[1] = ((SafeLinearLayoutManager)localObject).findLastVisibleItemPosition();
          arrayOfInt[2] = ((SafeLinearLayoutManager)localObject).findFirstCompletelyVisibleItemPosition();
          arrayOfInt[3] = ((SafeLinearLayoutManager)localObject).findLastCompletelyVisibleItemPosition();
          return arrayOfInt;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return arrayOfInt;
  }
  
  public void a()
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).a(paramViewHolder);
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).a(paramRecyclerView);
    }
  }
  
  public void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).a(paramQCircleExtraTypeInfo);
    }
  }
  
  public void a(QCircleFeedBaseScroller paramQCircleFeedBaseScroller)
  {
    if (paramQCircleFeedBaseScroller != null)
    {
      paramQCircleFeedBaseScroller.a(this.i, this.g, this.h, this);
      this.n.add(paramQCircleFeedBaseScroller);
    }
  }
  
  public void b()
  {
    this.k = d;
    this.l = 0;
    this.m = 0L;
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).b(paramInt);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).b(paramViewHolder);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).b();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).c();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((QCircleFeedBaseScroller)localIterator.next()).d();
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    RecyclerView.LayoutManager localLayoutManager = this.g.getLayoutManager();
    int[] arrayOfInt = g();
    a(paramRecyclerView, paramInt, localLayoutManager, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    int i1;
    String str;
    StringBuilder localStringBuilder;
    if (paramInt2 >= 0)
    {
      this.j = true;
      i1 = this.k;
      if ((i1 != e) && (i1 != d))
      {
        b();
        str = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("change orient to up:");
        localStringBuilder.append(this.k);
        QLog.d(str, 4, localStringBuilder.toString());
      }
      if (this.m == 0L) {
        this.m = System.currentTimeMillis();
      }
      this.l += paramInt2;
      this.k = e;
    }
    else
    {
      this.j = false;
      i1 = this.k;
      if ((i1 != f) && (i1 != d))
      {
        b();
        str = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("change orient to down:");
        localStringBuilder.append(this.k);
        QLog.d(str, 4, localStringBuilder.toString());
      }
      if (this.m == 0L) {
        this.m = System.currentTimeMillis();
      }
      this.l += paramInt2;
      this.k = f;
    }
    float f1 = (float)(System.currentTimeMillis() - this.m);
    boolean bool1;
    if (f1 > b)
    {
      b();
      if (Math.abs(this.l / f1) < c)
      {
        if (paramInt2 >= 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        a(bool1);
      }
    }
    if (paramInt2 >= 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    a(paramRecyclerView, paramInt1, paramInt2, bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedScrollManager
 * JD-Core Version:    0.7.0.1
 */