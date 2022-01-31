import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class berg
  implements View.OnLayoutChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  private berg(berd paramberd) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    berd.a(this.jdField_a_of_type_Berd).removeOnLayoutChangeListener(this);
    if (berd.a(this.jdField_a_of_type_Berd).getItemCount() > berd.c(this.jdField_a_of_type_Berd) + berd.d(this.jdField_a_of_type_Berd))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
      }
      paramView = this.jdField_a_of_type_Berd.a(berd.a(this.jdField_a_of_type_Berd));
      if ((!this.jdField_a_of_type_Berd.a(paramView)) || (this.jdField_a_of_type_Boolean)) {
        berd.a(this.jdField_a_of_type_Berd, paramView, this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     berg
 * JD-Core Version:    0.7.0.1
 */