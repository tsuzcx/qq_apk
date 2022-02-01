import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class beew
  implements DialogInterface.OnClickListener
{
  public beew(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((QQCustomDialog)paramDialogInterface).getCheckBoxState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beew
 * JD-Core Version:    0.7.0.1
 */