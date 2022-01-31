import android.app.Activity;
import android.content.Context;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureUnit;
import dov.com.qq.im.setting.IQIMCameraContainer;

public class anre
  implements Runnable
{
  public anre(QIMCameraCaptureUnit paramQIMCameraCaptureUnit, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.a.a();
    if (localObject == null) {}
    do
    {
      return;
      QLog.e("VERSION_CODES", 2, "onCameraStarted error = " + this.jdField_a_of_type_JavaLangString);
      String str = ((Activity)localObject).getString(2131428347);
      localObject = DialogUtil.a((Context)localObject, 230).setMessage(str).setPositiveButton(((Activity)localObject).getString(2131428346), new anrf(this));
      try
      {
        ((QQCustomDialog)localObject).setCancelable(false);
        ((QQCustomDialog)localObject).show();
        return;
      }
      catch (WindowManager.BadTokenException localBadTokenException) {}
    } while (!QLog.isColorLevel());
    QLog.i("VERSION_CODES", 2, "", localBadTokenException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anre
 * JD-Core Version:    0.7.0.1
 */