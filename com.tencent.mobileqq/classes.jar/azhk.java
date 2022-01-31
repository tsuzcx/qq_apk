import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;

public final class azhk
  implements DialogInterface.OnClickListener
{
  public azhk(Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      return;
    }
    TroopBarPublishUtils.c(this.a);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azhk
 * JD-Core Version:    0.7.0.1
 */