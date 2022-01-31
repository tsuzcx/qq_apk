import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;

public class apam
  implements DialogInterface.OnClickListener
{
  public apam(MessageForGrayTips.HightlightClickableSpan paramHightlightClickableSpan) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apam
 * JD-Core Version:    0.7.0.1
 */