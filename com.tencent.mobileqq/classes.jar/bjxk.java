import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class bjxk
  implements View.OnLayoutChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  private bjxk(bjxh parambjxh) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    bjxh.a(this.jdField_a_of_type_Bjxh).removeOnLayoutChangeListener(this);
    if (bjxh.a(this.jdField_a_of_type_Bjxh).getItemCount() > bjxh.c(this.jdField_a_of_type_Bjxh) + bjxh.d(this.jdField_a_of_type_Bjxh))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
      }
      paramView = this.jdField_a_of_type_Bjxh.a(bjxh.a(this.jdField_a_of_type_Bjxh));
      if ((!this.jdField_a_of_type_Bjxh.a(paramView)) || (this.jdField_a_of_type_Boolean)) {
        bjxh.a(this.jdField_a_of_type_Bjxh, paramView, this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxk
 * JD-Core Version:    0.7.0.1
 */