package com.tencent.biz.richframework.part.block.base;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import com.tencent.qphone.base.util.QLog;

class QCirclePagerSnapHelper$1
  extends RecyclerView.AdapterDataObserver
{
  QCirclePagerSnapHelper$1(QCirclePagerSnapHelper paramQCirclePagerSnapHelper) {}
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.a;
    localObject = ((QCirclePagerSnapHelper)localObject).a(QCirclePagerSnapHelper.c((QCirclePagerSnapHelper)localObject));
    int i;
    if (localObject != null) {
      i = QCirclePagerSnapHelper.c(this.a).getPosition((View)localObject);
    } else {
      i = -1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPagerDataChanged: positionStart=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", itemCount=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", centerPosition=");
      ((StringBuilder)localObject).append(QCirclePagerSnapHelper.h(this.a));
      ((StringBuilder)localObject).append(", currentPosition=");
      ((StringBuilder)localObject).append(i);
      QLog.d("PagerSnapHelper", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 <= i) && (paramInt1 + paramInt2 - 1 >= i))
    {
      QCirclePagerSnapHelper.OnLayoutChangedListenerImpl.a(QCirclePagerSnapHelper.j(this.a), true);
      QCirclePagerSnapHelper.i(this.a).addOnLayoutChangeListener(QCirclePagerSnapHelper.j(this.a));
      QCirclePagerSnapHelper.i(this.a).requestLayout();
    }
  }
  
  public void onChanged()
  {
    a(0, QCirclePagerSnapHelper.c(this.a).getItemCount());
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramObject == null) {
      onItemRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= QCirclePagerSnapHelper.h(this.a))
    {
      QCirclePagerSnapHelper localQCirclePagerSnapHelper = this.a;
      QCirclePagerSnapHelper.b(localQCirclePagerSnapHelper, QCirclePagerSnapHelper.h(localQCirclePagerSnapHelper) + paramInt2);
    }
    a(paramInt1, paramInt2);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == QCirclePagerSnapHelper.h(this.a)) {
      QCirclePagerSnapHelper.b(this.a, paramInt2);
    }
    a(paramInt1, paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= QCirclePagerSnapHelper.h(this.a))
    {
      QCirclePagerSnapHelper localQCirclePagerSnapHelper = this.a;
      QCirclePagerSnapHelper.b(localQCirclePagerSnapHelper, QCirclePagerSnapHelper.h(localQCirclePagerSnapHelper) - paramInt2);
    }
    a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */