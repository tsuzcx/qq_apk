import android.graphics.Bitmap;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.1;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class azbe
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private String jdField_a_of_type_JavaLangString = "";
  private WeakReference<azbg> jdField_a_of_type_MqqUtilWeakReference;
  
  private void a(@NonNull azbf paramazbf, Bitmap paramBitmap, int paramInt1, String paramString, int paramInt2)
  {
    ThreadManagerV2.postImmediately(new OnLineStatusBlurBg.1(this, paramazbf, paramBitmap, paramInt1, paramInt2, paramString), null, false);
  }
  
  public void a(@NonNull azbf paramazbf, azbg paramazbg)
  {
    if ((paramazbf.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (paramazbg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusBlurBg", 4, "startBlurBg activity or listener is empty");
      }
      return;
    }
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId)))
    {
      i = 1;
      if (Build.VERSION.SDK_INT > 20) {
        break label90;
      }
      if (i == 0) {
        break label82;
      }
    }
    label82:
    for (int i = paramazbf.c;; i = paramazbf.jdField_a_of_type_Int)
    {
      paramazbg.a(false, null, i);
      return;
      i = 0;
      break;
    }
    label90:
    if (i != 0) {}
    String str;
    for (i = paramazbf.c;; i = paramazbf.b)
    {
      str = paramazbf.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivityName() + "_" + i;
      if (!str.equals(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      paramazbg.a(true, this.jdField_a_of_type_AndroidGraphicsBitmap, i);
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramazbg);
    a(paramazbf, axeh.a(paramazbf.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), axeh.a(paramazbf.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), str, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbe
 * JD-Core Version:    0.7.0.1
 */