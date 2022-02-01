package com.tencent.biz.richframework.part.block.base;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;

class QCirclePagerSnapHelper$OnLayoutChangedListenerImpl
  implements View.OnLayoutChangeListener
{
  private boolean b = false;
  
  private QCirclePagerSnapHelper$OnLayoutChangedListenerImpl(QCirclePagerSnapHelper paramQCirclePagerSnapHelper) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    QCirclePagerSnapHelper.i(this.a).removeOnLayoutChangeListener(this);
    if (QCirclePagerSnapHelper.c(this.a).getItemCount() > QCirclePagerSnapHelper.n(this.a) + QCirclePagerSnapHelper.o(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
      }
      paramView = this.a;
      paramView = paramView.a(QCirclePagerSnapHelper.c(paramView));
      if ((!this.a.a(paramView)) || (this.b)) {
        QCirclePagerSnapHelper.a(this.a, paramView, this.b);
      }
      this.b = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper.OnLayoutChangedListenerImpl
 * JD-Core Version:    0.7.0.1
 */