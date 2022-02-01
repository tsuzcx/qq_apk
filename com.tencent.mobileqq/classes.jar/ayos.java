import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.1;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class ayos
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private String jdField_a_of_type_JavaLangString = "";
  private WeakReference<ayou> jdField_a_of_type_MqqUtilWeakReference;
  
  private void a(@NonNull ayot paramayot, Bitmap paramBitmap, int paramInt1, String paramString, int paramInt2)
  {
    ThreadManagerV2.postImmediately(new OnLineStatusBlurBg.1(this, paramayot, paramBitmap, paramInt1, paramInt2, paramString), null, false);
  }
  
  public void a(@NonNull ayot paramayot, ayou paramayou)
  {
    if ((paramayot.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (paramayou == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusBlurBg", 4, "startBlurBg activity or listener is empty");
      }
      return;
    }
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId)))
    {
      i = 1;
      if (i == 0) {
        break label120;
      }
    }
    String str;
    label120:
    for (int i = paramayot.b;; i = paramayot.jdField_a_of_type_Int)
    {
      str = paramayot.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivityName() + "_" + i;
      if (!str.equals(this.jdField_a_of_type_JavaLangString)) {
        break label128;
      }
      paramayou.a(true, this.jdField_a_of_type_AndroidGraphicsBitmap, i);
      return;
      i = 0;
      break;
    }
    label128:
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramayou);
    a(paramayot, awsf.a(paramayot.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), awsf.a(paramayot.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), str, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayos
 * JD-Core Version:    0.7.0.1
 */