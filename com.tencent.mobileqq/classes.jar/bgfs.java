import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

class bgfs
  implements View.OnFocusChangeListener
{
  bgfs(bgfo parambgfo, bgep parambgep, bgfu parambgfu) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    QLog.i("xmediaEditor", 1, "mData.position:" + this.jdField_a_of_type_Bgep.c + ", text:" + this.jdField_a_of_type_Bgep.jdField_a_of_type_JavaLangString + ",onFocusChange:" + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bgfu.a.setCursorVisible(true);
      this.jdField_a_of_type_Bgfo.a.c(this.jdField_a_of_type_Bgfu);
      this.jdField_a_of_type_Bgep.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bgfu.a.setFocusable(paramBoolean);
      this.jdField_a_of_type_Bgfu.a.setFocusableInTouchMode(paramBoolean);
      return;
      this.jdField_a_of_type_Bgfu.a.setCursorVisible(false);
      this.jdField_a_of_type_Bgfo.a.d(this.jdField_a_of_type_Bgfu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfs
 * JD-Core Version:    0.7.0.1
 */