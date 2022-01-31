import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aryk
  implements DialogInterface.OnClickListener
{
  aryk(aryh paramaryh) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryk
 * JD-Core Version:    0.7.0.1
 */