import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment;

public class arqw
  implements DialogInterface.OnClickListener
{
  public arqw(MsgBackupPcBaseFragment paramMsgBackupPcBaseFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    arsc.a("MsgBackup_MsgBackupPcBaseFragment", "showDisConnDialog mextra is not null! %b, isFromPcHandle = %b", new Object[] { Boolean.valueOf(TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)), Boolean.valueOf(this.a.e) });
    arpa.a().a().c();
    arpa.a().d();
    if (this.a.jdField_a_of_type_Boolean) {
      if ((!this.a.e) && (this.a.b == 1)) {
        this.a.a(this.a.getActivity());
      }
    }
    do
    {
      return;
      this.a.m();
      return;
      if (!this.a.e) {
        break;
      }
    } while (this.a.getActivity() == null);
    this.a.getActivity().setResult(1001);
    this.a.getActivity().finish();
    return;
    this.a.a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arqw
 * JD-Core Version:    0.7.0.1
 */