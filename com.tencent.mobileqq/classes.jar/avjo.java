import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;

class avjo
  implements DialogInterface.OnClickListener
{
  avjo(avjn paramavjn, BaseChatPie paramBaseChatPie, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity();
    Intent localIntent = new Intent(localBaseActivity, QQVasH5PayBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    localBaseActivity.startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjo
 * JD-Core Version:    0.7.0.1
 */