import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class bksk
  extends RecyclerView.OnScrollListener
  implements View.OnTouchListener, bksm
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean;
  private float d;
  
  private bksk(bkse parambkse) {}
  
  private void a()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    int i;
    if (bkse.b(this.jdField_a_of_type_Bkse))
    {
      if (!this.jdField_a_of_type_Bkse.c()) {
        bool1 = bool2;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: isRealIdle=" + bool1);
      }
      if (bool1) {
        bkse.a(this.jdField_a_of_type_Bkse, false);
      }
      View localView = this.jdField_a_of_type_Bkse.a(bkse.a(this.jdField_a_of_type_Bkse));
      if (localView == null) {
        break label146;
      }
      i = bkse.a(this.jdField_a_of_type_Bkse).getPosition(localView);
      label104:
      if (bkse.a(this.jdField_a_of_type_Bkse, i, bkse.a(this.jdField_a_of_type_Bkse))) {
        break label151;
      }
      bkse.a(this.jdField_a_of_type_Bkse, localView, this.jdField_b_of_type_Boolean);
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
      if ((!bkse.a(this.jdField_a_of_type_Bkse)) && (!bkse.b(this.jdField_a_of_type_Bkse))) {
        if (i > bkse.a(this.jdField_a_of_type_Bkse, bkse.a(this.jdField_a_of_type_Bkse))) {
          bkse.a(this.jdField_a_of_type_Bkse);
        } else if (i < bkse.a(this.jdField_a_of_type_Bkse)) {
          bkse.b(this.jdField_a_of_type_Bkse);
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
      localView = this.jdField_a_of_type_Bkse.a(bkse.a(this.jdField_a_of_type_Bkse));
      if (localView == null) {
        break label164;
      }
      this.jdField_b_of_type_Int = bkse.a(this.jdField_a_of_type_Bkse).getPosition(localView);
    }
    label164:
    for (this.jdField_b_of_type_Int = bkse.a(this.jdField_a_of_type_Bkse, this.jdField_b_of_type_Int);; this.jdField_b_of_type_Int = -1)
    {
      if ((bkse.b(this.jdField_a_of_type_Bkse) != -1) && (bkse.a(this.jdField_a_of_type_Bkse).findViewByPosition(bkse.b(this.jdField_a_of_type_Bkse)) == null))
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
          paramInt = bkse.a(this.jdField_a_of_type_Bkse).getPosition(localView);
        }
        QLog.d("PagerSnapHelper", 2, paramInt);
      }
      return;
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (bkse.a(this.jdField_a_of_type_Bkse) == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
      } while ((bkse.a(this.jdField_a_of_type_Bkse).getAdapter() == null) || (!bkse.a(this.jdField_a_of_type_Bkse)));
      i = bkse.a(this.jdField_a_of_type_Bkse).getMinFlingVelocity();
      j = this.jdField_b_of_type_Int;
    } while ((Math.abs(paramFloat2) <= i) && (Math.abs(paramFloat1) <= i));
    try
    {
      TraceCompat.beginSection("snapFromFling");
      boolean bool = bkse.a(this.jdField_a_of_type_Bkse, bkse.a(this.jdField_a_of_type_Bkse), this.jdField_c_of_type_Float, this.d, paramFloat1, paramFloat2, j);
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
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 2: 
      do
      {
        return false;
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_Float <= 0.0F) {
          this.jdField_a_of_type_Float = paramMotionEvent.getX();
        }
      } while (this.jdField_b_of_type_Float > 0.0F);
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      return false;
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float - paramMotionEvent.getX());
    }
    for (this.d = (this.jdField_b_of_type_Float - paramMotionEvent.getY());; this.d = 0.0F)
    {
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_c_of_type_Boolean = false;
      return false;
      this.jdField_c_of_type_Float = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksk
 * JD-Core Version:    0.7.0.1
 */