import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

class bcbb
  implements View.OnFocusChangeListener
{
  bcbb(bcax parambcax, bbzy parambbzy, bcbd parambcbd) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    QLog.i("xmediaEditor", 1, "mData.position:" + this.jdField_a_of_type_Bbzy.c + ", text:" + this.jdField_a_of_type_Bbzy.jdField_a_of_type_JavaLangString + ",onFocusChange:" + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bcbd.a.setCursorVisible(true);
      this.jdField_a_of_type_Bcax.a.c(this.jdField_a_of_type_Bcbd);
      this.jdField_a_of_type_Bbzy.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bcbd.a.setFocusable(paramBoolean);
      this.jdField_a_of_type_Bcbd.a.setFocusableInTouchMode(paramBoolean);
      return;
      this.jdField_a_of_type_Bcbd.a.setCursorVisible(false);
      this.jdField_a_of_type_Bcax.a.d(this.jdField_a_of_type_Bcbd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbb
 * JD-Core Version:    0.7.0.1
 */