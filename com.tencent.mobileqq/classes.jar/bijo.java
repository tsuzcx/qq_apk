import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class bijo
  implements bijt
{
  public bijo(WebSoService paramWebSoService, long paramLong, WebSoService.WebSoState paramWebSoState, Handler paramHandler, String paramString) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebSoService", 2, "verifyHtmlData cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_a_of_type_Bijf.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.f = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.e = false;
      bijv.a("load from cache");
      WebSoService.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      VipUtils.a(null, "webview_report", "0X8006566", "0X8006566", 0, 1, new String[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    VipUtils.a(null, "webview_report", "0X8006566", "0X8006566", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bijo
 * JD-Core Version:    0.7.0.1
 */