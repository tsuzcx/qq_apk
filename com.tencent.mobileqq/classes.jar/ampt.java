import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ampt
  implements DialogInterface.OnClickListener
{
  ampt(ampp paramampp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "clear click");
    }
    if (bhnv.d(ampp.a(this.a)))
    {
      bdll.b(this.a.a, "dc00898", "", "", "0X800A328", "0X800A328", 2, 0, "", "", "", "");
      ampp.b(this.a);
      this.a.a.a().a().f();
      ((FriendListHandler)this.a.a.a(1)).k();
      return;
    }
    QQToast.a(ampp.a(this.a), 2131693974, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampt
 * JD-Core Version:    0.7.0.1
 */