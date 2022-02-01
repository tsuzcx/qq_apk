import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class azpb
  implements DialogInterface.OnClickListener
{
  azpb(azoz paramazoz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpb
 * JD-Core Version:    0.7.0.1
 */