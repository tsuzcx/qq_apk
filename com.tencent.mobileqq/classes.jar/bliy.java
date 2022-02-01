import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class bliy
  extends RecyclerView.OnScrollListener
  implements View.OnTouchListener, blja
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
  
  private bliy(blis paramblis) {}
  
  private void a()
  {
    boolean bool1 = true;
    blis.a(this.jdField_a_of_type_Blis, true);
    Object localObject;
    int i;
    if (blis.b(this.jdField_a_of_type_Blis))
    {
      boolean bool2 = this.jdField_a_of_type_Blis.c();
      localObject = this.jdField_a_of_type_Blis;
      if (!bool2) {
        blis.a((blis)localObject, bool1);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: isRealIdle=" + blis.c(this.jdField_a_of_type_Blis));
      }
      if (blis.c(this.jdField_a_of_type_Blis)) {
        blis.b(this.jdField_a_of_type_Blis, false);
      }
      localObject = this.jdField_a_of_type_Blis.a(blis.a(this.jdField_a_of_type_Blis));
      if (localObject == null) {
        break label178;
      }
      i = blis.a(this.jdField_a_of_type_Blis).getPosition((View)localObject);
      label136:
      if (blis.a(this.jdField_a_of_type_Blis, i, blis.a(this.jdField_a_of_type_Blis))) {
        break label183;
      }
      blis.a(this.jdField_a_of_type_Blis, (View)localObject, this.jdField_b_of_type_Boolean);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
      bool1 = false;
      break;
      label178:
      i = -1;
      break label136;
      label183:
      if ((!blis.a(this.jdField_a_of_type_Blis)) && (!blis.b(this.jdField_a_of_type_Blis))) {
        if (i > blis.a(this.jdField_a_of_type_Blis, blis.a(this.jdField_a_of_type_Blis))) {
          blis.a(this.jdField_a_of_type_Blis);
        } else if (i < blis.a(this.jdField_a_of_type_Blis)) {
          blis.b(this.jdField_a_of_type_Blis);
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    int i = -1;
    blis.a(this.jdField_a_of_type_Blis, false);
    View localView;
    if ((paramInt == 0) || (paramInt == 2))
    {
      localView = this.jdField_a_of_type_Blis.a(blis.a(this.jdField_a_of_type_Blis));
      if (localView == null) {
        break label173;
      }
      this.jdField_b_of_type_Int = blis.a(this.jdField_a_of_type_Blis).getPosition(localView);
    }
    label173:
    for (this.jdField_b_of_type_Int = blis.a(this.jdField_a_of_type_Blis, this.jdField_b_of_type_Int);; this.jdField_b_of_type_Int = -1)
    {
      if ((blis.b(this.jdField_a_of_type_Blis) != -1) && (blis.a(this.jdField_a_of_type_Blis).findViewByPosition(blis.b(this.jdField_a_of_type_Blis)) == null))
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
          paramInt = blis.a(this.jdField_a_of_type_Blis).getPosition(localView);
        }
        QLog.d("PagerSnapHelper", 2, paramInt);
      }
      return;
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (blis.a(this.jdField_a_of_type_Blis) == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
      } while ((blis.a(this.jdField_a_of_type_Blis).getAdapter() == null) || (!blis.a(this.jdField_a_of_type_Blis)));
      i = blis.a(this.jdField_a_of_type_Blis).getMinFlingVelocity();
      j = this.jdField_b_of_type_Int;
    } while ((Math.abs(paramFloat2) <= i) && (Math.abs(paramFloat1) <= i));
    try
    {
      TraceCompat.beginSection("snapFromFling");
      boolean bool = blis.a(this.jdField_a_of_type_Blis, blis.a(this.jdField_a_of_type_Blis), this.jdField_c_of_type_Float, this.d, paramFloat1, paramFloat2, j);
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
 * Qualified Name:     bliy
 * JD-Core Version:    0.7.0.1
 */