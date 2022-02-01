import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

class asqw
  implements DialogInterface.OnClickListener
{
  asqw(asqt paramasqt, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext != null) {}
    try
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", asqt.a(this.jdField_a_of_type_Asqt));
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendLimitChatManager", 2, "showRealNameAuthDialog click confirm " + asqt.a(this.jdField_a_of_type_Asqt));
      }
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqw
 * JD-Core Version:    0.7.0.1
 */