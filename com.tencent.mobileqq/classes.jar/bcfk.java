import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

class bcfk
  implements View.OnFocusChangeListener
{
  bcfk(bcfg parambcfg, bceh parambceh, bcfm parambcfm) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    QLog.i("xmediaEditor", 1, "mData.position:" + this.jdField_a_of_type_Bceh.c + ", text:" + this.jdField_a_of_type_Bceh.jdField_a_of_type_JavaLangString + ",onFocusChange:" + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bcfm.a.setCursorVisible(true);
      this.jdField_a_of_type_Bcfg.a.c(this.jdField_a_of_type_Bcfm);
      this.jdField_a_of_type_Bceh.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bcfm.a.setFocusable(paramBoolean);
      this.jdField_a_of_type_Bcfm.a.setFocusableInTouchMode(paramBoolean);
      return;
      this.jdField_a_of_type_Bcfm.a.setCursorVisible(false);
      this.jdField_a_of_type_Bcfg.a.d(this.jdField_a_of_type_Bcfm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfk
 * JD-Core Version:    0.7.0.1
 */