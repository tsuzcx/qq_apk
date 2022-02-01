import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;

public class awud
  implements DialogInterface.OnDismissListener
{
  public awud(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MatchChatMsgListFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awud
 * JD-Core Version:    0.7.0.1
 */