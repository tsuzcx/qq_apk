package com.tencent.biz.richframework.part.block.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class QCirclePagerSnapHelper$TouchEventProcessor
  extends RecyclerView.OnScrollListener
  implements View.OnTouchListener
{
  private boolean b = false;
  private int c = 0;
  private int d = -1;
  private boolean e = false;
  private boolean f = false;
  private float g;
  private float h;
  private float i;
  private float j;
  private QCirclePagerSnapHelper.TouchEventProcessor.TouchFlingListener k;
  
  private QCirclePagerSnapHelper$TouchEventProcessor(QCirclePagerSnapHelper paramQCirclePagerSnapHelper) {}
  
  private void a(int paramInt)
  {
    QCirclePagerSnapHelper.a(this.a, false);
    if ((paramInt == 0) || (paramInt == 2))
    {
      Object localObject = this.a;
      localObject = ((QCirclePagerSnapHelper)localObject).a(QCirclePagerSnapHelper.c((QCirclePagerSnapHelper)localObject));
      paramInt = -1;
      if (localObject != null)
      {
        this.d = QCirclePagerSnapHelper.c(this.a).getPosition((View)localObject);
        this.d = QCirclePagerSnapHelper.a(this.a, this.d);
      }
      else
      {
        this.d = -1;
      }
      if ((QCirclePagerSnapHelper.h(this.a) != -1) && (QCirclePagerSnapHelper.c(this.a).findViewByPosition(QCirclePagerSnapHelper.h(this.a)) == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: centerPosition has been recycler");
        }
        this.e = true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onScrollStateChanged: lastCenterView=");
        if (localObject != null) {
          paramInt = QCirclePagerSnapHelper.c(this.a).getPosition((View)localObject);
        }
        localStringBuilder.append(paramInt);
        QLog.d("PagerSnapHelper", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void b()
  {
    QCirclePagerSnapHelper.a(this.a, true);
    if (QCirclePagerSnapHelper.a(this.a))
    {
      boolean bool = this.a.a();
      QCirclePagerSnapHelper.a(this.a, bool ^ true);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScrollStateChanged: isRealIdle=");
      ((StringBuilder)localObject).append(QCirclePagerSnapHelper.b(this.a));
      QLog.d("PagerSnapHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (QCirclePagerSnapHelper.b(this.a)) {
      QCirclePagerSnapHelper.b(this.a, false);
    }
    Object localObject = this.a;
    localObject = ((QCirclePagerSnapHelper)localObject).a(QCirclePagerSnapHelper.c((QCirclePagerSnapHelper)localObject));
    int m;
    if (localObject != null) {
      m = QCirclePagerSnapHelper.c(this.a).getPosition((View)localObject);
    } else {
      m = -1;
    }
    QCirclePagerSnapHelper localQCirclePagerSnapHelper = this.a;
    if (!QCirclePagerSnapHelper.a(localQCirclePagerSnapHelper, m, QCirclePagerSnapHelper.c(localQCirclePagerSnapHelper)))
    {
      QCirclePagerSnapHelper.a(this.a, (View)localObject, this.e);
    }
    else if ((!QCirclePagerSnapHelper.d(this.a)) && (!QCirclePagerSnapHelper.a(this.a)))
    {
      localObject = this.a;
      if (m > QCirclePagerSnapHelper.a((QCirclePagerSnapHelper)localObject, QCirclePagerSnapHelper.c((QCirclePagerSnapHelper)localObject))) {
        QCirclePagerSnapHelper.e(this.a);
      } else if (m < QCirclePagerSnapHelper.f(this.a)) {
        QCirclePagerSnapHelper.g(this.a);
      }
    }
    this.e = false;
  }
  
  public QCirclePagerSnapHelper.TouchEventProcessor.TouchFlingListener a()
  {
    if (this.k == null) {
      this.k = new QCirclePagerSnapHelper.TouchEventProcessor.TouchFlingListener(this, null);
    }
    return this.k;
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramRecyclerView = new StringBuilder();
      paramRecyclerView.append("onScrollStateChanged: state=");
      paramRecyclerView.append(paramInt);
      QLog.d("PagerSnapHelper", 2, paramRecyclerView.toString());
    }
    int m = this.c;
    this.c = paramInt;
    if (paramInt == 0)
    {
      TraceCompat.beginSection("snap onIdle");
      b();
      TraceCompat.endSection();
      return;
    }
    if (paramInt == 1)
    {
      TraceCompat.beginSection("snap onDragging");
      a(m);
      TraceCompat.endSection();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.b = true;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if (m != 1)
    {
      if (m != 2) {
        return false;
      }
      this.f = true;
      if (this.g <= 0.0F) {
        this.g = paramMotionEvent.getX();
      }
      if (this.h <= 0.0F)
      {
        this.h = paramMotionEvent.getY();
        return false;
      }
    }
    else
    {
      if (this.f)
      {
        this.i = (this.g - paramMotionEvent.getX());
        this.j = (this.h - paramMotionEvent.getY());
      }
      else
      {
        this.i = 0.0F;
        this.j = 0.0F;
      }
      this.g = 0.0F;
      this.h = 0.0F;
      this.f = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper.TouchEventProcessor
 * JD-Core Version:    0.7.0.1
 */