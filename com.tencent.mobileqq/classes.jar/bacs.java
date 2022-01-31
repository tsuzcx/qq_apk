import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

class bacs
  implements View.OnFocusChangeListener
{
  bacs(baco parambaco, babp parambabp, bacu parambacu) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    QLog.i("xmediaEditor", 1, "mData.position:" + this.jdField_a_of_type_Babp.c + ", text:" + this.jdField_a_of_type_Babp.jdField_a_of_type_JavaLangString + ",onFocusChange:" + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bacu.a.setCursorVisible(true);
      this.jdField_a_of_type_Baco.a.c(this.jdField_a_of_type_Bacu);
      this.jdField_a_of_type_Babp.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bacu.a.setFocusable(paramBoolean);
      this.jdField_a_of_type_Bacu.a.setFocusableInTouchMode(paramBoolean);
      return;
      this.jdField_a_of_type_Bacu.a.setCursorVisible(false);
      this.jdField_a_of_type_Baco.a.d(this.jdField_a_of_type_Bacu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bacs
 * JD-Core Version:    0.7.0.1
 */