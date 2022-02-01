import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class bltk
  implements View.OnLayoutChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  private bltk(blth paramblth) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    blth.a(this.jdField_a_of_type_Blth).removeOnLayoutChangeListener(this);
    if (blth.a(this.jdField_a_of_type_Blth).getItemCount() > blth.c(this.jdField_a_of_type_Blth) + blth.d(this.jdField_a_of_type_Blth))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
      }
      paramView = this.jdField_a_of_type_Blth.a(blth.a(this.jdField_a_of_type_Blth));
      if ((!this.jdField_a_of_type_Blth.a(paramView)) || (this.jdField_a_of_type_Boolean)) {
        blth.a(this.jdField_a_of_type_Blth, paramView, this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltk
 * JD-Core Version:    0.7.0.1
 */