import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class biev
  implements View.OnLayoutChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  private biev(bies parambies) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    bies.a(this.jdField_a_of_type_Bies).removeOnLayoutChangeListener(this);
    if (bies.a(this.jdField_a_of_type_Bies).getItemCount() > bies.c(this.jdField_a_of_type_Bies) + bies.d(this.jdField_a_of_type_Bies))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
      }
      paramView = this.jdField_a_of_type_Bies.a(bies.a(this.jdField_a_of_type_Bies));
      if ((!this.jdField_a_of_type_Bies.a(paramView)) || (this.jdField_a_of_type_Boolean)) {
        bies.a(this.jdField_a_of_type_Bies, paramView, this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biev
 * JD-Core Version:    0.7.0.1
 */