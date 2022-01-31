import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;

public abstract class blvp
  extends blxd
{
  private final RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new blvq(this);
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  SpeedFlexibleRecyclerView jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView;
  
  private boolean a(@NonNull RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    LinearSmoothScroller localLinearSmoothScroller = a(paramLayoutManager);
    if (localLinearSmoothScroller == null) {}
    do
    {
      return false;
      paramInt1 = a(paramLayoutManager, paramInt1, paramInt2);
    } while (paramInt1 == -1);
    localLinearSmoothScroller.setTargetPosition(paramInt1);
    paramLayoutManager.startSmoothScroll(localLinearSmoothScroller);
    return true;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.a() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setOnFlingListener(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.removeOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setOnFlingListener(null);
  }
  
  public abstract int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2);
  
  @Nullable
  public LinearSmoothScroller a(RecyclerView.LayoutManager paramLayoutManager)
  {
    return new blvr(this, this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getContext());
  }
  
  @Nullable
  public abstract View a(RecyclerView.LayoutManager paramLayoutManager);
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView == null) {}
    Object localObject;
    do
    {
      View localView;
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getLayoutManager();
        } while (localObject == null);
        localView = a((RecyclerView.LayoutManager)localObject);
      } while (localView == null);
      localObject = a((RecyclerView.LayoutManager)localObject, localView);
    } while ((localObject[0] == 0) && (localObject[1] == 0));
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.smoothScrollBy(localObject[0], localObject[1]);
  }
  
  public void a(@Nullable SpeedFlexibleRecyclerView paramSpeedFlexibleRecyclerView)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView == paramSpeedFlexibleRecyclerView) {}
    do
    {
      return;
      if (this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView != null) {
        c();
      }
      this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView = paramSpeedFlexibleRecyclerView;
    } while (this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView == null);
    b();
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getContext(), new DecelerateInterpolator());
    a();
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager localLayoutManager = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getLayoutManager();
    if (localLayoutManager == null) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getAdapter() == null);
      i = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getMinFlingVelocity();
    } while (((Math.abs(paramInt2) <= i) && (Math.abs(paramInt1) <= i)) || (!a(localLayoutManager, paramInt1, paramInt2)));
    return true;
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetScroller.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    return new int[] { this.jdField_a_of_type_AndroidWidgetScroller.getFinalX(), this.jdField_a_of_type_AndroidWidgetScroller.getFinalY() };
  }
  
  @Nullable
  public abstract int[] a(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvp
 * JD-Core Version:    0.7.0.1
 */