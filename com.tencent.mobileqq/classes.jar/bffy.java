import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

class bffy
  implements View.OnFocusChangeListener
{
  bffy(bffu parambffu, bfev parambfev, bfga parambfga) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    QLog.i("xmediaEditor", 1, "mData.position:" + this.jdField_a_of_type_Bfev.c + ", text:" + this.jdField_a_of_type_Bfev.jdField_a_of_type_JavaLangString + ",onFocusChange:" + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bfga.a.setCursorVisible(true);
      this.jdField_a_of_type_Bffu.a.c(this.jdField_a_of_type_Bfga);
      this.jdField_a_of_type_Bfev.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfga.a.setFocusable(paramBoolean);
      this.jdField_a_of_type_Bfga.a.setFocusableInTouchMode(paramBoolean);
      return;
      this.jdField_a_of_type_Bfga.a.setCursorVisible(false);
      this.jdField_a_of_type_Bffu.a.d(this.jdField_a_of_type_Bfga);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffy
 * JD-Core Version:    0.7.0.1
 */