import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class bfzr
  implements View.OnLayoutChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  private bfzr(bfzo parambfzo) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    bfzo.a(this.jdField_a_of_type_Bfzo).removeOnLayoutChangeListener(this);
    if (bfzo.a(this.jdField_a_of_type_Bfzo).getItemCount() > bfzo.c(this.jdField_a_of_type_Bfzo) + bfzo.d(this.jdField_a_of_type_Bfzo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
      }
      paramView = this.jdField_a_of_type_Bfzo.a(bfzo.a(this.jdField_a_of_type_Bfzo));
      if ((!this.jdField_a_of_type_Bfzo.a(paramView)) || (this.jdField_a_of_type_Boolean)) {
        bfzo.a(this.jdField_a_of_type_Bfzo, paramView, this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfzr
 * JD-Core Version:    0.7.0.1
 */