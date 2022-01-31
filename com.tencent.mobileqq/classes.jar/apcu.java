import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.2;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.3;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavPluginProxyService;

public class apcu
  extends aozw
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private bgqx jdField_a_of_type_Bgqx = new apcv(this);
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 80;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public apcu(Bundle paramBundle)
  {
    QfavPluginProxyService.a().a(3, this.jdField_a_of_type_Bgqx);
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QfavFilePreviewController.2(this), 300000L);
  }
  
  public int a()
  {
    return 4;
  }
  
  public boolean a()
  {
    if (3 != this.jdField_a_of_type_Int)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QfavFilePreviewController", 4, "sendCS: oldState = " + this.jdField_a_of_type_Int + ", newState = STATE_REQUESTING.");
      }
      this.jdField_a_of_type_Int = 1;
      return true;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QfavFilePreviewController.3(this), 2000L);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    QfavPluginProxyService.a().b(3, this.jdField_a_of_type_Bgqx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apcu
 * JD-Core Version:    0.7.0.1
 */