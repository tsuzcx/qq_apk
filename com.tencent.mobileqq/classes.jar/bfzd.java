import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class bfzd
  extends RecyclerView.OnScrollListener
  implements bfzf
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  
  private bfzd(bfyx parambfyx) {}
  
  private void a()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    int i;
    if (bfyx.b(this.jdField_a_of_type_Bfyx))
    {
      if (!this.jdField_a_of_type_Bfyx.c()) {
        bool1 = bool2;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: isRealIdle=" + bool1);
      }
      if (bool1) {
        bfyx.a(this.jdField_a_of_type_Bfyx, false);
      }
      View localView = this.jdField_a_of_type_Bfyx.a(bfyx.a(this.jdField_a_of_type_Bfyx));
      if (localView == null) {
        break label146;
      }
      i = bfyx.a(this.jdField_a_of_type_Bfyx).getPosition(localView);
      label104:
      if (bfyx.a(this.jdField_a_of_type_Bfyx, i, bfyx.a(this.jdField_a_of_type_Bfyx))) {
        break label151;
      }
      bfyx.a(this.jdField_a_of_type_Bfyx, localView, this.jdField_b_of_type_Boolean);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
      bool1 = false;
      break;
      label146:
      i = -1;
      break label104;
      label151:
      if ((!bfyx.a(this.jdField_a_of_type_Bfyx)) && (!bfyx.b(this.jdField_a_of_type_Bfyx))) {
        if (i > bfyx.a(this.jdField_a_of_type_Bfyx, bfyx.a(this.jdField_a_of_type_Bfyx))) {
          bfyx.a(this.jdField_a_of_type_Bfyx);
        } else if (i < bfyx.a(this.jdField_a_of_type_Bfyx)) {
          bfyx.b(this.jdField_a_of_type_Bfyx);
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    int i = -1;
    View localView;
    if ((paramInt == 0) || (paramInt == 2))
    {
      localView = this.jdField_a_of_type_Bfyx.a(bfyx.a(this.jdField_a_of_type_Bfyx));
      if (localView == null) {
        break label164;
      }
      this.jdField_b_of_type_Int = bfyx.a(this.jdField_a_of_type_Bfyx).getPosition(localView);
    }
    label164:
    for (this.jdField_b_of_type_Int = bfyx.a(this.jdField_a_of_type_Bfyx, this.jdField_b_of_type_Int);; this.jdField_b_of_type_Int = -1)
    {
      if ((bfyx.b(this.jdField_a_of_type_Bfyx) != -1) && (bfyx.a(this.jdField_a_of_type_Bfyx).findViewByPosition(bfyx.b(this.jdField_a_of_type_Bfyx)) == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: centerPosition has been recycler");
        }
        this.jdField_b_of_type_Boolean = true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("onScrollStateChanged: lastCenterView=");
        paramInt = i;
        if (localView != null) {
          paramInt = bfyx.a(this.jdField_a_of_type_Bfyx).getPosition(localView);
        }
        QLog.d("PagerSnapHelper", 2, paramInt);
      }
      return;
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (bfyx.a(this.jdField_a_of_type_Bfyx) == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
      } while ((bfyx.a(this.jdField_a_of_type_Bfyx).getAdapter() == null) || (!bfyx.a(this.jdField_a_of_type_Bfyx)));
      i = bfyx.a(this.jdField_a_of_type_Bfyx).getMinFlingVelocity();
      j = this.jdField_b_of_type_Int;
    } while ((Math.abs(paramFloat2) <= i) && (Math.abs(paramFloat1) <= i));
    try
    {
      TraceCompat.beginSection("snapFromFling");
      boolean bool = bfyx.a(this.jdField_a_of_type_Bfyx, bfyx.a(this.jdField_a_of_type_Bfyx), paramFloat1, paramFloat2, j);
      return bool;
    }
    finally
    {
      TraceCompat.endSection();
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: state=" + paramInt);
    }
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      TraceCompat.beginSection("snap onIdle");
      a();
      TraceCompat.endSection();
    }
    while (paramInt != 1) {
      return;
    }
    TraceCompat.beginSection("snap onDragging");
    a(i);
    TraceCompat.endSection();
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfzd
 * JD-Core Version:    0.7.0.1
 */