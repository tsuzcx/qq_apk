import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;

class amtg
  implements DialogInterface.OnClickListener
{
  amtg(amtf paramamtf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      QQToast.a(this.a.a, 2, 2131690232, 0).a();
      paramDialogInterface.dismiss();
      azmj.b(null, "dc00898", "", "", "0X8008353", "0X8008353", 0, 0, "", "", "", "");
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtg
 * JD-Core Version:    0.7.0.1
 */