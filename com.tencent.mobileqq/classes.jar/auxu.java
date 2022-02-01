import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;
import com.tencent.mobileqq.widget.QQToast;

public class auxu
  implements DialogInterface.OnClickListener
{
  public auxu(QQSettingMsgClearFragment paramQQSettingMsgClearFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aqws.a(2);
    QQSettingMsgClearFragment.b(this.a);
    QQSettingMsgClearFragment.c(this.a);
    QQToast.a(this.a.getActivity(), this.a.getString(2131691798), 0).b(this.a.getActivity().getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxu
 * JD-Core Version:    0.7.0.1
 */