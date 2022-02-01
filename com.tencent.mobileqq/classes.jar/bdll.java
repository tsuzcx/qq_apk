import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;

public class bdll
  implements DialogInterface.OnClickListener
{
  public bdll(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((bgpa)paramDialogInterface).getCheckBoxState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdll
 * JD-Core Version:    0.7.0.1
 */