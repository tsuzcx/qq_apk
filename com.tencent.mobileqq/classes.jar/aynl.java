import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aynl
  implements DialogInterface.OnClickListener
{
  aynl(aymu paramaymu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((aymu.a(this.a) != null) && (aymu.a(this.a).isShowing()))
      {
        this.a.c();
        aymu.a(this.a).dismiss();
        aymu.a(this.a, null);
      }
      label49:
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "switch status cancel");
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label49;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynl
 * JD-Core Version:    0.7.0.1
 */