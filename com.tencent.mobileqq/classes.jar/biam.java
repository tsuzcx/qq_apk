import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class biam
  extends RecyclerView.AdapterDataObserver
{
  biam(bial parambial) {}
  
  private void a(int paramInt1, int paramInt2)
  {
    View localView = this.a.a(bial.a(this.a));
    if (localView != null) {}
    for (int i = bial.a(this.a).getPosition(localView);; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onPagerDataChanged: positionStart=" + paramInt1 + ", itemCount=" + paramInt2 + ", centerPosition=" + bial.b(this.a) + ", currentPosition=" + i);
      }
      if ((paramInt1 <= i) && (paramInt1 + paramInt2 - 1 >= i))
      {
        biao.a(bial.a(this.a), true);
        bial.a(this.a).addOnLayoutChangeListener(bial.a(this.a));
        bial.a(this.a).requestLayout();
      }
      return;
    }
  }
  
  public void onChanged()
  {
    a(0, bial.a(this.a).getItemCount());
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
    if (paramInt1 <= bial.b(this.a)) {
      bial.b(this.a, bial.b(this.a) + paramInt2);
    }
    a(paramInt1, paramInt2);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == bial.b(this.a)) {
      bial.b(this.a, paramInt2);
    }
    a(paramInt1, paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= bial.b(this.a)) {
      bial.b(this.a, bial.b(this.a) - paramInt2);
    }
    a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biam
 * JD-Core Version:    0.7.0.1
 */