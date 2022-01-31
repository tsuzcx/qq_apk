import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class bere
  extends RecyclerView.AdapterDataObserver
{
  bere(berd paramberd) {}
  
  private void a(int paramInt1, int paramInt2)
  {
    View localView = this.a.a(berd.a(this.a));
    if (localView != null) {}
    for (int i = berd.a(this.a).getPosition(localView);; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onPagerDataChanged: positionStart=" + paramInt1 + ", itemCount=" + paramInt2 + ", centerPosition=" + berd.b(this.a) + ", currentPosition=" + i);
      }
      if ((paramInt1 <= i) && (paramInt1 + paramInt2 - 1 >= i))
      {
        berg.a(berd.a(this.a), true);
        berd.a(this.a).addOnLayoutChangeListener(berd.a(this.a));
        berd.a(this.a).requestLayout();
      }
      return;
    }
  }
  
  public void onChanged()
  {
    a(0, berd.a(this.a).getItemCount());
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
    if (paramInt1 <= berd.b(this.a)) {
      berd.b(this.a, berd.b(this.a) + paramInt2);
    }
    a(paramInt1, paramInt2);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == berd.b(this.a)) {
      berd.b(this.a, paramInt2);
    }
    a(paramInt1, paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= berd.b(this.a)) {
      berd.b(this.a, berd.b(this.a) - paramInt2);
    }
    a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bere
 * JD-Core Version:    0.7.0.1
 */