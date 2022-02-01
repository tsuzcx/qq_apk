import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.ui.LocationDialogUtil.6;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

public class awqy
  implements DialogInterface.OnClickListener
{
  public awqy(LocationDialogUtil.6 param6) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, new Object[] { "onClick: invoked. showStartShareLocationDialog  ", " which: ", Integer.valueOf(paramInt) });
    }
    if (BaseActivity.sTopActivity != null) {
      LocationShareFragment.b(BaseActivity.sTopActivity, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_JavaLangString, this.a.b);
    }
    try
    {
      awpq.a(BaseActivity.sTopActivity.app).a(true);
      label79:
      awql.a(this.a.b, "0X800A769");
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      break label79;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqy
 * JD-Core Version:    0.7.0.1
 */