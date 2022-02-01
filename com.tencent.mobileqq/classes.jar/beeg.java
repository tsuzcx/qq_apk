import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;

public class beeg
  implements DialogInterface.OnClickListener
{
  public beeg(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((bhpc)paramDialogInterface).getCheckBoxState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beeg
 * JD-Core Version:    0.7.0.1
 */