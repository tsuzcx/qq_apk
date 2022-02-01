import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;

class aomy
  implements DialogInterface.OnCancelListener
{
  aomy(aoms paramaoms) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    aoms.a(this.a, null);
    QLog.d("AccountPhoneUnityManager", 1, "dialog cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aomy
 * JD-Core Version:    0.7.0.1
 */