import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.qphone.base.util.QLog;

public class aqzn
  implements DialogInterface.OnClickListener
{
  public aqzn(HotPicPageView paramHotPicPageView, aqzt paramaqzt, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a(this.jdField_a_of_type_Aqzt, this.jdField_a_of_type_Int);
    QLog.d("HotPicManagerHotPicPageView", 2, "User allowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqzn
 * JD-Core Version:    0.7.0.1
 */