import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class autz
  implements DialogInterface.OnClickListener
{
  autz(autv paramautv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autz
 * JD-Core Version:    0.7.0.1
 */