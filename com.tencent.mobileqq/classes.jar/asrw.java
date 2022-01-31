import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.qphone.base.util.QLog;

class asrw
  implements DialogInterface.OnClickListener
{
  asrw(asrp paramasrp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    asrp.jdField_a_of_type_Boolean = false;
    asrp.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), false);
    this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(-11);
    QLog.d("PresenceInterfaceImpl", 2, "User disallowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrw
 * JD-Core Version:    0.7.0.1
 */