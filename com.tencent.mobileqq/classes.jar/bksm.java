import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class bksm
  implements DialogInterface.OnClickListener
{
  bksm(bksl parambksl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("minisdk_X5UpdateGuard", 2, "cancel");
    bksl.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksm
 * JD-Core Version:    0.7.0.1
 */