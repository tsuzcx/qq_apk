import android.graphics.Bitmap;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.1;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class azhl
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private String jdField_a_of_type_JavaLangString = "";
  private WeakReference<azhn> jdField_a_of_type_MqqUtilWeakReference;
  
  private void a(@NonNull azhm paramazhm, Bitmap paramBitmap, int paramInt1, String paramString, int paramInt2)
  {
    ThreadManagerV2.postImmediately(new OnLineStatusBlurBg.1(this, paramazhm, paramBitmap, paramInt1, paramInt2, paramString), null, false);
  }
  
  public void a(@NonNull azhm paramazhm, azhn paramazhn)
  {
    if ((paramazhm.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (paramazhn == null))
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
    for (int i = paramazhm.c;; i = paramazhm.jdField_a_of_type_Int)
    {
      paramazhn.a(false, null, i);
      return;
      i = 0;
      break;
    }
    label90:
    if (i != 0) {}
    String str;
    for (i = paramazhm.c;; i = paramazhm.b)
    {
      str = paramazhm.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivityName() + "_" + i;
      if (!str.equals(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      paramazhn.a(true, this.jdField_a_of_type_AndroidGraphicsBitmap, i);
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramazhn);
    a(paramazhm, axky.a(paramazhm.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), axky.a(paramazhm.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), str, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhl
 * JD-Core Version:    0.7.0.1
 */