import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

class bfwd
  implements View.OnFocusChangeListener
{
  bfwd(bfvz parambfvz, bfva parambfva, bfwf parambfwf) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    QLog.i("xmediaEditor", 1, "mData.position:" + this.jdField_a_of_type_Bfva.c + ", text:" + this.jdField_a_of_type_Bfva.jdField_a_of_type_JavaLangString + ",onFocusChange:" + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bfwf.a.setCursorVisible(true);
      this.jdField_a_of_type_Bfvz.a.c(this.jdField_a_of_type_Bfwf);
      this.jdField_a_of_type_Bfva.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfwf.a.setFocusable(paramBoolean);
      this.jdField_a_of_type_Bfwf.a.setFocusableInTouchMode(paramBoolean);
      return;
      this.jdField_a_of_type_Bfwf.a.setCursorVisible(false);
      this.jdField_a_of_type_Bfvz.a.d(this.jdField_a_of_type_Bfwf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwd
 * JD-Core Version:    0.7.0.1
 */