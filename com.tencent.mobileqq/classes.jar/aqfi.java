import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpic.HotPicPageView.4.2;
import com.tencent.qphone.base.util.QLog;

public class aqfi
  implements DialogInterface.OnClickListener
{
  public aqfi(HotPicPageView.4.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
    if (this.a.a.jdField_a_of_type_Aqfp.a == 1) {
      this.a.a.jdField_a_of_type_Aqfp.a(0);
    }
    QLog.d("HotPicManagerHotPicPageView", 2, "user click button");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqfi
 * JD-Core Version:    0.7.0.1
 */