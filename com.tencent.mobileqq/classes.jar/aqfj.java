import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.qphone.base.util.QLog;

public class aqfj
  implements DialogInterface.OnClickListener
{
  public aqfj(HotPicPageView paramHotPicPageView, aqfp paramaqfp, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a(this.jdField_a_of_type_Aqfp, this.jdField_a_of_type_Int);
    QLog.d("HotPicManagerHotPicPageView", 2, "User allowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqfj
 * JD-Core Version:    0.7.0.1
 */