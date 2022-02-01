import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;

class apkc
  implements DialogInterface.OnClickListener
{
  apkc(apkb paramapkb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      QQToast.a(this.a.a, 2, 2131690087, 0).a();
      paramDialogInterface.dismiss();
      bdll.b(null, "dc00898", "", "", "0X8008353", "0X8008353", 0, 0, "", "", "", "");
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkc
 * JD-Core Version:    0.7.0.1
 */