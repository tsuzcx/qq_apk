import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

class bepa
  implements View.OnFocusChangeListener
{
  bepa(beow parambeow, benx parambenx, bepc parambepc) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    QLog.i("xmediaEditor", 1, "mData.position:" + this.jdField_a_of_type_Benx.c + ", text:" + this.jdField_a_of_type_Benx.jdField_a_of_type_JavaLangString + ",onFocusChange:" + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bepc.a.setCursorVisible(true);
      this.jdField_a_of_type_Beow.a.c(this.jdField_a_of_type_Bepc);
      this.jdField_a_of_type_Benx.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bepc.a.setFocusable(paramBoolean);
      this.jdField_a_of_type_Bepc.a.setFocusableInTouchMode(paramBoolean);
      return;
      this.jdField_a_of_type_Bepc.a.setCursorVisible(false);
      this.jdField_a_of_type_Beow.a.d(this.jdField_a_of_type_Bepc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepa
 * JD-Core Version:    0.7.0.1
 */