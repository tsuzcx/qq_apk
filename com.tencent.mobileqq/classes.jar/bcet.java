import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.16;
import com.tencent.qphone.base.util.QLog;

public class bcet
  implements DialogInterface.OnClickListener
{
  public bcet(VisitorTroopCardFragment.16 param16) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.a.cancel();
      return;
    }
    try
    {
      arys.a(this.a.this$0.getActivity(), true, "action_game_join_group", Long.valueOf(this.a.this$0.getActivity().getIntent().getStringExtra("appid")).longValue(), -1, this.a.a);
      this.a.this$0.a.cancel();
      this.a.this$0.getActivity().finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("VisitorTroopCardFragment.Activity", 1, "showAlertDlg error = " + paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcet
 * JD-Core Version:    0.7.0.1
 */