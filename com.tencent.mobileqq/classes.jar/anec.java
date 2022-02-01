import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;

public class anec
  implements DialogInterface.OnClickListener
{
  public anec(VideoBroadcastReceiver paramVideoBroadcastReceiver, int paramInt1, QQAppInterface paramQQAppInterface, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mrd.e(false, false);
    if (this.jdField_a_of_type_Int == 3000)
    {
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, false, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, false, null, true, new Object[0]);
      VideoBroadcastReceiver.a(this.jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver, 3, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.c, this.d);
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mrd.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anec
 * JD-Core Version:    0.7.0.1
 */