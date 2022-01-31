import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class biao
  implements View.OnLayoutChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  private biao(bial parambial) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    bial.a(this.jdField_a_of_type_Bial).removeOnLayoutChangeListener(this);
    if (bial.a(this.jdField_a_of_type_Bial).getItemCount() > bial.c(this.jdField_a_of_type_Bial) + bial.d(this.jdField_a_of_type_Bial))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
      }
      paramView = this.jdField_a_of_type_Bial.a(bial.a(this.jdField_a_of_type_Bial));
      if ((!this.jdField_a_of_type_Bial.a(paramView)) || (this.jdField_a_of_type_Boolean)) {
        bial.a(this.jdField_a_of_type_Bial, paramView, this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biao
 * JD-Core Version:    0.7.0.1
 */