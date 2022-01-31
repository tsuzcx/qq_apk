import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class berd
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private OrientationHelper jdField_a_of_type_AndroidSupportV7WidgetOrientationHelper;
  private berg jdField_a_of_type_Berg;
  private berh jdField_a_of_type_Berh;
  private beri jdField_a_of_type_Beri;
  private berj jdField_a_of_type_Berj;
  private RecyclerViewCompat jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private OrientationHelper jdField_b_of_type_AndroidSupportV7WidgetOrientationHelper;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  
  public berd()
  {
    this(0, 25.0F);
  }
  
  public berd(int paramInt, float paramFloat)
  {
    a();
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  private int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  private int a(int paramInt)
  {
    int i = a();
    int j = a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    if (paramInt < i) {}
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= j);
    return j;
  }
  
  private int a(LinearLayoutManager paramLinearLayoutManager, OrientationHelper paramOrientationHelper)
  {
    if (paramLinearLayoutManager.getClipToPadding()) {}
    for (int i = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;; i = paramOrientationHelper.getEnd() / 2) {
      return i + this.e;
    }
  }
  
  private int a(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return c(paramLinearLayoutManager, paramView, paramOrientationHelper);
    }
    return b(paramLinearLayoutManager, paramView, paramOrientationHelper);
  }
  
  private int a(OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getStartAfterPadding() + this.e;
  }
  
  private int a(RecyclerView.LayoutManager paramLayoutManager)
  {
    return paramLayoutManager.getItemCount() - this.jdField_a_of_type_Int - 1;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView == null) || (paramRecyclerView.getAdapter() == null) || (paramRecyclerView.getLayoutManager() == null)) {
      throw new IllegalStateException("PagerSnapHelper can't attach to the RecyclerView before setup Adapter or LayoutManager");
    }
    if (!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
      throw new IllegalStateException("PagerSnapHelper can only attach to the RecyclerView with LinearLayoutManager");
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    RecyclerView.ViewHolder localViewHolder;
    int i;
    if ((paramView != null) && (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) && (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null))
    {
      localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getChildViewHolder(paramView);
      i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getPosition(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "dispatchPagerChanged: position=" + i + ", centerPosition=" + this.jdField_c_of_type_Int + ", reset=" + paramBoolean);
      }
      if ((localViewHolder != null) && (i != -1) && ((i != this.jdField_c_of_type_Int) || (paramBoolean)) && (!a(i, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager))) {
        break label124;
      }
    }
    label124:
    do
    {
      return;
      this.jdField_c_of_type_Int = i;
    } while (this.jdField_a_of_type_Beri == null);
    TraceCompat.beginSection("onPagerChanged");
    this.jdField_a_of_type_Beri.a(localViewHolder);
    TraceCompat.endSection();
  }
  
  private boolean a(int paramInt, RecyclerView.LayoutManager paramLayoutManager)
  {
    int i = a(paramLayoutManager);
    return (paramInt < a()) || (paramInt > i);
  }
  
  private boolean a(@NonNull LinearLayoutManager paramLinearLayoutManager, float paramFloat1, float paramFloat2, int paramInt)
  {
    int i = 1;
    if (paramLinearLayoutManager.getItemCount() == 0) {}
    label147:
    label168:
    for (;;)
    {
      return false;
      View localView = a(paramLinearLayoutManager);
      if (localView != null)
      {
        int j = paramLinearLayoutManager.getPosition(localView);
        if (j != -1)
        {
          j = a(j);
          if (paramLinearLayoutManager.canScrollHorizontally()) {
            if (paramFloat1 > 0.0F)
            {
              if ((paramInt == -1) || (j == paramInt)) {
                break label147;
              }
              paramInt = j;
            }
          }
          for (;;)
          {
            if (paramInt == -1) {
              break label168;
            }
            paramInt = a(paramInt);
            if (QLog.isColorLevel()) {
              QLog.d("PagerSnapHelper", 2, "snapFromFling: position=" + paramInt);
            }
            return a(paramInt);
            i = 0;
            break;
            if (paramFloat2 > 0.0F) {
              break;
            }
            i = 0;
            break;
            if (i != 0) {
              paramInt = j + 1;
            } else {
              paramInt = j - 1;
            }
          }
        }
      }
    }
  }
  
  @NonNull
  private int[] a(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLinearLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = a(paramLinearLayoutManager, paramView, a(paramLinearLayoutManager));
    }
    while (paramLinearLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = a(paramLinearLayoutManager, paramView, a(paramLinearLayoutManager));
      return arrayOfInt;
      arrayOfInt[0] = 0;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  private int b(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) - a(paramOrientationHelper);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Beri != null)
    {
      this.jdField_a_of_type_Beri.a();
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: onFooterRebound");
      }
    }
  }
  
  private int c(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2 - a(paramLinearLayoutManager, paramOrientationHelper);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: onHeaderRebound");
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.a() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.jdField_a_of_type_Berj = new berj(this, null);
    this.jdField_a_of_type_Berg = new berg(this, null);
    this.jdField_a_of_type_Berh = new berh(this, null);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnScrollListener(this.jdField_a_of_type_Berj);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setOnFlingListener(this.jdField_a_of_type_Berj);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnLayoutChangeListener(this.jdField_a_of_type_Berg);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnLayoutChangeListener(this.jdField_a_of_type_Berh);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getAdapter().registerAdapterDataObserver(new bere(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.removeOnScrollListener(this.jdField_a_of_type_Berj);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setOnFlingListener(null);
  }
  
  protected LinearSmoothScroller a(LinearLayoutManager paramLinearLayoutManager)
  {
    return new berf(this, this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getContext(), paramLinearLayoutManager);
  }
  
  @NonNull
  protected OrientationHelper a(LinearLayoutManager paramLinearLayoutManager)
  {
    if (paramLinearLayoutManager.canScrollVertically())
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetOrientationHelper == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetOrientationHelper = OrientationHelper.createOrientationHelper(paramLinearLayoutManager, 1);
      }
      return this.jdField_a_of_type_AndroidSupportV7WidgetOrientationHelper;
    }
    if (this.jdField_b_of_type_AndroidSupportV7WidgetOrientationHelper == null) {
      this.jdField_b_of_type_AndroidSupportV7WidgetOrientationHelper = OrientationHelper.createOrientationHelper(paramLinearLayoutManager, 0);
    }
    return this.jdField_b_of_type_AndroidSupportV7WidgetOrientationHelper;
  }
  
  @Nullable
  public View a(LinearLayoutManager paramLinearLayoutManager)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int m = paramLinearLayoutManager.getChildCount();
    if (m == 0) {}
    OrientationHelper localOrientationHelper;
    int i;
    int j;
    do
    {
      return localObject2;
      localOrientationHelper = a(paramLinearLayoutManager);
      i = 2147483647;
      j = 0;
      localObject2 = localObject1;
    } while (j >= m);
    localObject2 = paramLinearLayoutManager.getChildAt(j);
    int k = Math.abs(a(paramLinearLayoutManager, (View)localObject2, localOrientationHelper));
    if (k < i)
    {
      localObject1 = localObject2;
      i = k;
    }
    for (;;)
    {
      j += 1;
      break;
    }
  }
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat == null) || (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramView == null) || (a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getPosition(paramView), this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager)) || (paramView == null));
      paramView = a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, paramView);
    } while ((paramView[0] == 0) && (paramView[1] == 0));
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.scrollBy(paramView[0], paramView[1]);
  }
  
  public void a(beri paramberi)
  {
    this.jdField_a_of_type_Beri = paramberi;
  }
  
  public void a(@Nullable RecyclerViewCompat paramRecyclerViewCompat)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat == paramRecyclerViewCompat) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
        f();
      }
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = paramRecyclerViewCompat;
    } while (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat == null);
    a(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = ((LinearLayoutManager)this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.getLayoutManager());
    e();
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat == null) || (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null)) {}
    int i;
    do
    {
      return false;
      i = this.jdField_c_of_type_Int + 1;
    } while (a(i, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager));
    a(i);
    return true;
  }
  
  public boolean a(int paramInt)
  {
    if (a(paramInt, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager)) {}
    View localView;
    int i;
    int j;
    do
    {
      return false;
      localView = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "snapToTargetPosition: position=" + paramInt + ", view=" + localView);
      }
      if (localView == null)
      {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.smoothScrollToPosition(paramInt);
        this.jdField_a_of_type_Boolean = true;
        return true;
      }
      localObject = a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, localView);
      i = localObject[0];
      j = localObject[1];
    } while ((i == 0) && (j == 0));
    Object localObject = a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    ((RecyclerView.SmoothScroller)localObject).setTargetPosition(paramInt);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.startSmoothScroll((RecyclerView.SmoothScroller)localObject);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean) {
      a(localView, false);
    }
    if ((paramInt == a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager)) && ((i < 0) || (j < 0))) {
      b();
    }
    for (;;)
    {
      return true;
      if ((paramInt == a()) && ((i > 0) || (j > 0))) {
        d();
      }
    }
  }
  
  public boolean a(View paramView)
  {
    if (paramView == null) {}
    int i;
    do
    {
      return false;
      i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getPosition(paramView);
    } while (i == -1);
    return a(a(i));
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat == null) || (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null)) {}
    int i;
    do
    {
      return false;
      i = this.jdField_c_of_type_Int - 1;
    } while (a(i, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager));
    a(i);
    return true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnLayoutChangeListener(this.jdField_a_of_type_Berg);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat == null) || (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null)) {}
    View localView;
    do
    {
      return false;
      localView = a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    } while (localView == null);
    if (QLog.isColorLevel()) {
      QLog.d("PagerSnapHelper", 2, "snapToCenterPosition: findCenterView=" + this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getPosition(localView));
    }
    return a(localView);
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void e(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void f(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat == null) || (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null)) {
      return;
    }
    a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     berd
 * JD-Core Version:    0.7.0.1
 */