import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment;

public class auii
  implements bexc
{
  public auii(MsgBackupPCConfirmFragment paramMsgBackupPCConfirmFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      aujq.a("MsgBackupMsgBackupPCConfirmFragment", "click cancel btn bizType = %d, pcHandler %b", new Object[] { Integer.valueOf(this.a.b), Boolean.valueOf(augo.c) });
      aujh.a().c();
      if (!TextUtils.isEmpty(this.a.a)) {
        break label93;
      }
      this.a.a(this.a.getActivity());
      if (this.a.b != 2) {
        break label104;
      }
      aujo.a("0X800A282");
    }
    label93:
    label104:
    while (!augo.c)
    {
      return;
      this.a.onBackEvent();
      break;
    }
    aujo.a("0X800A266", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auii
 * JD-Core Version:    0.7.0.1
 */