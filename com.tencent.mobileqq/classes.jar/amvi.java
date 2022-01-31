import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import dov.com.qq.im.capture.data.ComboLockManager;

public class amvi
  implements Runnable
{
  public amvi(ComboLockManager paramComboLockManager, Context paramContext, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    DialogUtil.b(localBaseActivity, 0, this.jdField_a_of_type_AndroidContentContext.getString(2131439284), localBaseActivity.getString(2131439285), 2131439286, 2131439287, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amvi
 * JD-Core Version:    0.7.0.1
 */