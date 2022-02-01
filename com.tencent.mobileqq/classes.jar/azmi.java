import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public final class azmi
  implements DialogInterface.OnClickListener
{
  public azmi(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bhgf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), null);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmi
 * JD-Core Version:    0.7.0.1
 */