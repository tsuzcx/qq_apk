import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

class azbm
  implements View.OnFocusChangeListener
{
  azbm(azbi paramazbi, azaj paramazaj, azbo paramazbo) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    QLog.i("xmediaEditor", 1, "mData.position:" + this.jdField_a_of_type_Azaj.c + ", text:" + this.jdField_a_of_type_Azaj.jdField_a_of_type_JavaLangString + ",onFocusChange:" + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Azbo.a.setCursorVisible(true);
      this.jdField_a_of_type_Azbi.a.c(this.jdField_a_of_type_Azbo);
      this.jdField_a_of_type_Azaj.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Azbo.a.setFocusable(paramBoolean);
      this.jdField_a_of_type_Azbo.a.setFocusableInTouchMode(paramBoolean);
      return;
      this.jdField_a_of_type_Azbo.a.setCursorVisible(false);
      this.jdField_a_of_type_Azbi.a.d(this.jdField_a_of_type_Azbo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azbm
 * JD-Core Version:    0.7.0.1
 */