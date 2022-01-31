import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

class bace
  implements View.OnFocusChangeListener
{
  bace(baca parambaca, babb parambabb, bacg parambacg) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    QLog.i("xmediaEditor", 1, "mData.position:" + this.jdField_a_of_type_Babb.c + ", text:" + this.jdField_a_of_type_Babb.jdField_a_of_type_JavaLangString + ",onFocusChange:" + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bacg.a.setCursorVisible(true);
      this.jdField_a_of_type_Baca.a.c(this.jdField_a_of_type_Bacg);
      this.jdField_a_of_type_Babb.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bacg.a.setFocusable(paramBoolean);
      this.jdField_a_of_type_Bacg.a.setFocusableInTouchMode(paramBoolean);
      return;
      this.jdField_a_of_type_Bacg.a.setCursorVisible(false);
      this.jdField_a_of_type_Baca.a.d(this.jdField_a_of_type_Bacg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bace
 * JD-Core Version:    0.7.0.1
 */