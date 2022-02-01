import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class blit
  extends RecyclerView.AdapterDataObserver
{
  blit(blis paramblis) {}
  
  private void a(int paramInt1, int paramInt2)
  {
    View localView = this.a.a(blis.a(this.a));
    if (localView != null) {}
    for (int i = blis.a(this.a).getPosition(localView);; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onPagerDataChanged: positionStart=" + paramInt1 + ", itemCount=" + paramInt2 + ", centerPosition=" + blis.b(this.a) + ", currentPosition=" + i);
      }
      if ((paramInt1 <= i) && (paramInt1 + paramInt2 - 1 >= i))
      {
        bliv.a(blis.a(this.a), true);
        blis.a(this.a).addOnLayoutChangeListener(blis.a(this.a));
        blis.a(this.a).requestLayout();
      }
      return;
    }
  }
  
  public void onChanged()
  {
    a(0, blis.a(this.a).getItemCount());
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
    if (paramInt1 <= blis.b(this.a)) {
      blis.b(this.a, blis.b(this.a) + paramInt2);
    }
    a(paramInt1, paramInt2);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == blis.b(this.a)) {
      blis.b(this.a, paramInt2);
    }
    a(paramInt1, paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= blis.b(this.a)) {
      blis.b(this.a, blis.b(this.a) - paramInt2);
    }
    a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blit
 * JD-Core Version:    0.7.0.1
 */