import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.NestedScrollingParentLayout;

public class bhpk
  extends RecyclerView.OnScrollListener
{
  private boolean jdField_a_of_type_Boolean;
  
  public bhpk(NestedScrollingParentLayout paramNestedScrollingParentLayout) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (NestedScrollingParentLayout.a(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout) != NestedScrollingParentLayout.b(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != 0) || (!this.jdField_a_of_type_Boolean));
      this.jdField_a_of_type_Boolean = false;
      paramRecyclerView = NestedScrollingParentLayout.b(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout).getLayoutManager();
      paramRecyclerView = NestedScrollingParentLayout.a(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout).a(paramRecyclerView);
      NestedScrollingParentLayout.a(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout, NestedScrollingParentLayout.b(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout).getChildAdapterPosition(paramRecyclerView));
    } while (NestedScrollingParentLayout.a(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout) < 0);
    if (QLog.isColorLevel()) {
      QLog.d("NestedScrollingParentLayout", 2, "mVideoItemListener onScrollStateChanged onScrolled dx " + paramInt);
    }
    paramRecyclerView = NestedScrollingParentLayout.b(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout).a(NestedScrollingParentLayout.c(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout).getLayoutManager());
    paramRecyclerView.setTargetPosition(NestedScrollingParentLayout.a(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout));
    NestedScrollingParentLayout.c(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout).getLayoutManager().startSmoothScroll(paramRecyclerView);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NestedScrollingParentLayout", 2, "mVideoItemListener onScrolled dx +=" + paramInt1);
    }
    if (NestedScrollingParentLayout.a(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout) != NestedScrollingParentLayout.b(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout)) {}
    while ((NestedScrollingParentLayout.a(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout) >= 0) || ((paramInt1 == 0) && (paramInt2 == 0))) {
      return;
    }
    paramInt1 = (int)(paramInt1 / NestedScrollingParentLayout.a(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout));
    NestedScrollingParentLayout.c(this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout).scrollBy(paramInt1, paramInt2);
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhpk
 * JD-Core Version:    0.7.0.1
 */