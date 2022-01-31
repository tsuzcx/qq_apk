import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class ayfz
  implements DialogInterface.OnClickListener
{
  public ayfz(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.setResult(-1, null);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayfz
 * JD-Core Version:    0.7.0.1
 */