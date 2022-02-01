import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class bksh
  implements View.OnLayoutChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  private bksh(bkse parambkse) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    bkse.a(this.jdField_a_of_type_Bkse).removeOnLayoutChangeListener(this);
    if (bkse.a(this.jdField_a_of_type_Bkse).getItemCount() > bkse.c(this.jdField_a_of_type_Bkse) + bkse.d(this.jdField_a_of_type_Bkse))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
      }
      paramView = this.jdField_a_of_type_Bkse.a(bkse.a(this.jdField_a_of_type_Bkse));
      if ((!this.jdField_a_of_type_Bkse.a(paramView)) || (this.jdField_a_of_type_Boolean)) {
        bkse.a(this.jdField_a_of_type_Bkse, paramView, this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksh
 * JD-Core Version:    0.7.0.1
 */