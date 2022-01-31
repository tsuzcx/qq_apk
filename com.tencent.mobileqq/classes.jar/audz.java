import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment;

public class audz
  implements best
{
  public audz(MsgBackupPCConfirmFragment paramMsgBackupPCConfirmFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      aufh.a("MsgBackupMsgBackupPCConfirmFragment", "click cancel btn bizType = %d, pcHandler %b", new Object[] { Integer.valueOf(this.a.b), Boolean.valueOf(aucf.c) });
      auey.a().c();
      if (!TextUtils.isEmpty(this.a.a)) {
        break label93;
      }
      this.a.a(this.a.getActivity());
      if (this.a.b != 2) {
        break label104;
      }
      auff.a("0X800A282");
    }
    label93:
    label104:
    while (!aucf.c)
    {
      return;
      this.a.onBackEvent();
      break;
    }
    auff.a("0X800A266", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     audz
 * JD-Core Version:    0.7.0.1
 */