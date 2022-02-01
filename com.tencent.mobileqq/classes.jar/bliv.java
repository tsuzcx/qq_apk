import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class bliv
  implements View.OnLayoutChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  private bliv(blis paramblis) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    blis.a(this.jdField_a_of_type_Blis).removeOnLayoutChangeListener(this);
    if (blis.a(this.jdField_a_of_type_Blis).getItemCount() > blis.c(this.jdField_a_of_type_Blis) + blis.d(this.jdField_a_of_type_Blis))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
      }
      paramView = this.jdField_a_of_type_Blis.a(blis.a(this.jdField_a_of_type_Blis));
      if ((!this.jdField_a_of_type_Blis.a(paramView)) || (this.jdField_a_of_type_Boolean)) {
        blis.a(this.jdField_a_of_type_Blis, paramView, this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bliv
 * JD-Core Version:    0.7.0.1
 */