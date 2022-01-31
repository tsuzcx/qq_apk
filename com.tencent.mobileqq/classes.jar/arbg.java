import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.qphone.base.util.QLog;

class arbg
  implements DialogInterface.OnClickListener
{
  arbg(araz paramaraz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    araz.jdField_a_of_type_Boolean = false;
    araz.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), false);
    this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(-11);
    QLog.d("PresenceInterfaceImpl", 2, "User disallowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arbg
 * JD-Core Version:    0.7.0.1
 */