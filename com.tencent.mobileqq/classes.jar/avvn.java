import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment;

public class avvn
  implements DialogInterface.OnClickListener
{
  public avvn(MsgBackupPcBaseFragment paramMsgBackupPcBaseFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    avwu.a("MsgBackup_MsgBackupPcBaseFragment", "showStopMigrateDialog mextra is not null! %b, isFromPcHandle = %b", new Object[] { Boolean.valueOf(TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)), Boolean.valueOf(this.a.e) });
    avtq.a().a().c();
    avtq.a().a().a(null);
    if (this.a.jdField_a_of_type_Boolean) {
      if ((!this.a.e) && (this.a.b == 1))
      {
        this.a.a(this.a.getActivity());
        if (!this.a.f)
        {
          if (this.a.b != 1) {
            break label189;
          }
          if (this.a.e) {
            avwr.a("0X800A267", 2);
          }
        }
        label141:
        if (this.a.f)
        {
          if (this.a.b != 1) {
            break label309;
          }
          if (this.a.e) {
            avwr.a("0X800A267", 3);
          }
        }
      }
    }
    label189:
    while (this.a.b != 2)
    {
      return;
      this.a.m();
      break;
      if (this.a.b != 2) {
        break label141;
      }
      avwr.a("0X800A289", 1);
      break label141;
      if (this.a.e) {
        if (this.a.getActivity() != null)
        {
          this.a.getActivity().setResult(1001);
          this.a.getActivity().finish();
        }
      }
      for (;;)
      {
        if ((this.a.f) || (this.a.b != 1) || (!this.a.e)) {
          break label307;
        }
        avwr.a("0X800A267", 1);
        break;
        this.a.a(this.a.getActivity());
      }
      break label141;
    }
    label307:
    label309:
    avwr.a("0X800A289", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvn
 * JD-Core Version:    0.7.0.1
 */