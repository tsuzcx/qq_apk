import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aqet
  implements DialogInterface.OnClickListener
{
  aqet(aqeq paramaqeq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "handleSDForImageShare dismiss Exception:", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqet
 * JD-Core Version:    0.7.0.1
 */