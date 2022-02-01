import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment;

public class axbm
  implements bivu
{
  public axbm(MsgBackupPCConfirmFragment paramMsgBackupPCConfirmFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      axcw.a("MsgBackupMsgBackupPCConfirmFragment", "click cancel btn bizType = %d, pcHandler %b", new Object[] { Integer.valueOf(this.a.b), Boolean.valueOf(awzs.c) });
      axcm.a().c();
      if (!TextUtils.isEmpty(this.a.a)) {
        break label93;
      }
      this.a.a(this.a.getActivity());
      if (this.a.b != 2) {
        break label104;
      }
      axct.a("0X800A282");
    }
    label93:
    label104:
    while (!awzs.c)
    {
      return;
      this.a.onBackEvent();
      break;
    }
    axct.a("0X800A266", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbm
 * JD-Core Version:    0.7.0.1
 */