import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class bbfx
  implements View.OnClickListener
{
  bbfx(bbfw parambbfw, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WholePeoplePlugin", 2, "onClick " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Bbfw.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbfx
 * JD-Core Version:    0.7.0.1
 */