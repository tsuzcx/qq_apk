import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class bfzp
  extends RecyclerView.AdapterDataObserver
{
  bfzp(bfzo parambfzo) {}
  
  private void a(int paramInt1, int paramInt2)
  {
    View localView = this.a.a(bfzo.a(this.a));
    if (localView != null) {}
    for (int i = bfzo.a(this.a).getPosition(localView);; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onPagerDataChanged: positionStart=" + paramInt1 + ", itemCount=" + paramInt2 + ", centerPosition=" + bfzo.b(this.a) + ", currentPosition=" + i);
      }
      if ((paramInt1 <= i) && (paramInt1 + paramInt2 - 1 >= i))
      {
        bfzr.a(bfzo.a(this.a), true);
        bfzo.a(this.a).addOnLayoutChangeListener(bfzo.a(this.a));
        bfzo.a(this.a).requestLayout();
      }
      return;
    }
  }
  
  public void onChanged()
  {
    a(0, bfzo.a(this.a).getItemCount());
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
    if (paramInt1 <= bfzo.b(this.a)) {
      bfzo.b(this.a, bfzo.b(this.a) + paramInt2);
    }
    a(paramInt1, paramInt2);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == bfzo.b(this.a)) {
      bfzo.b(this.a, paramInt2);
    }
    a(paramInt1, paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= bfzo.b(this.a)) {
      bfzo.b(this.a, bfzo.b(this.a) - paramInt2);
    }
    a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfzp
 * JD-Core Version:    0.7.0.1
 */