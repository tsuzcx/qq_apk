import android.content.Context;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class apgq
{
  Context a;
  public ayxa a;
  public QQCustomDialog a;
  
  public apgq(Context paramContext, ayxa paramayxa)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ayxa = paramayxa;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230);
    paramContext = new apgr(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131690143, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690142, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131690145);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceUIController", 2, "doOnClickFeedBack");
    }
    bdla.b(null, "dc00898", "", "", "0X8008352", "0X8008352", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgq
 * JD-Core Version:    0.7.0.1
 */