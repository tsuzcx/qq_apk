import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.open.agent.BindGroupConfirmActivity.8;
import com.tencent.qphone.base.util.QLog;

public class bjbu
  implements DialogInterface.OnClickListener
{
  public bjbu(BindGroupConfirmActivity.8 param8) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.a.cancel();
      this.a.this$0.finish();
      return;
    }
    try
    {
      ForwardSdkShareOption.a(this.a.this$0, true, "action_game_bind_group", Long.valueOf(this.a.this$0.c).longValue(), -1, this.a.a);
      this.a.this$0.a.cancel();
      BindGroupConfirmActivity.a(this.a.this$0, -1);
      BindGroupConfirmActivity.a(this.a.this$0);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("BindGroupConfirmActivity", 1, "showAlertDlg error = " + paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbu
 * JD-Core Version:    0.7.0.1
 */