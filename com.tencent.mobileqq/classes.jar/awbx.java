import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

class awbx
  implements bieu
{
  bgpa jdField_a_of_type_Bgpa;
  boolean jdField_a_of_type_Boolean = false;
  
  awbx(awbw paramawbw, BaseActivity paramBaseActivity, avwp paramavwp) {}
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Awbw.a.isBackground_Pause) || (this.jdField_a_of_type_Awbw.a.isBackground_Stop)) {
      awbw.a(this.jdField_a_of_type_Awbw, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Avwp);
    }
    for (;;)
    {
      bcst.b(null, "CliOper", "", "", "0X800A978", "0X800A978", 0, 0, "", "0", "0", "");
      return true;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Bgpa = avxq.a(this.jdField_a_of_type_Avwp.a(), this.jdField_a_of_type_Avwp.a());
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_Bgpa != null) {
          this.jdField_a_of_type_Bgpa.setOnDismissListener(new awby(this));
        }
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Avwp.a(), this.jdField_a_of_type_Avwp.a(), 4);
    awbj.e();
    if (this.jdField_a_of_type_Bgpa != null) {}
    try
    {
      this.jdField_a_of_type_Bgpa.dismiss();
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbx
 * JD-Core Version:    0.7.0.1
 */