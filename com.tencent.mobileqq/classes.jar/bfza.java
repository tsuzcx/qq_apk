import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class bfza
  implements View.OnLayoutChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  private bfza(bfyx parambfyx) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    bfyx.a(this.jdField_a_of_type_Bfyx).removeOnLayoutChangeListener(this);
    if (bfyx.a(this.jdField_a_of_type_Bfyx).getItemCount() > bfyx.c(this.jdField_a_of_type_Bfyx) + bfyx.d(this.jdField_a_of_type_Bfyx))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
      }
      paramView = this.jdField_a_of_type_Bfyx.a(bfyx.a(this.jdField_a_of_type_Bfyx));
      if ((!this.jdField_a_of_type_Bfyx.a(paramView)) || (this.jdField_a_of_type_Boolean)) {
        bfyx.a(this.jdField_a_of_type_Bfyx, paramView, this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfza
 * JD-Core Version:    0.7.0.1
 */