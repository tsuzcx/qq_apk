import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment;

public class arqu
  implements bbpw
{
  public arqu(MsgBackupPCConfirmFragment paramMsgBackupPCConfirmFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      arsc.a("MsgBackupMsgBackupPCConfirmFragment", "click cancel btn bizType = %d, pcHandler %b", new Object[] { Integer.valueOf(this.a.b), Boolean.valueOf(arpa.c) });
      arrt.a().c();
      if (!TextUtils.isEmpty(this.a.a)) {
        break label93;
      }
      this.a.a(this.a.getActivity());
      if (this.a.b != 2) {
        break label104;
      }
      arsa.a("0X800A282");
    }
    label93:
    label104:
    while (!arpa.c)
    {
      return;
      this.a.onBackEvent();
      break;
    }
    arsa.a("0X800A266", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arqu
 * JD-Core Version:    0.7.0.1
 */