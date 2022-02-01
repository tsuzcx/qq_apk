import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpic.HotPicPageView.4.2;
import com.tencent.qphone.base.util.QLog;

public class avtu
  implements DialogInterface.OnClickListener
{
  public avtu(HotPicPageView.4.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
    if (this.a.a.jdField_a_of_type_Avub.a == 1) {
      this.a.a.jdField_a_of_type_Avub.a(0);
    }
    QLog.d("HotPicManagerHotPicPageView", 2, "user click button");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avtu
 * JD-Core Version:    0.7.0.1
 */