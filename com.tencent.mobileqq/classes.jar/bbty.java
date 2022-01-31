import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.agent.AuthorityActivity;

public class bbty
  implements DialogInterface.OnClickListener
{
  public bbty(AuthorityActivity paramAuthorityActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbty
 * JD-Core Version:    0.7.0.1
 */