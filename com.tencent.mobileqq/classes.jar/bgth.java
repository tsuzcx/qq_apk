import android.webkit.ValueCallback;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qqmini.sdk.log.QMLog;

public class bgth
  implements bghn
{
  private int jdField_a_of_type_Int;
  public ITTJSRuntime a;
  private final String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public bgth(ITTJSRuntime paramITTJSRuntime, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = ("[minigame] " + this + "[" + paramInt + "]");
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime = paramITTJSRuntime;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (a()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime.evaluateCallbackJs(paramInt, paramString);
      return;
    }
    QMLog.e(this.jdField_a_of_type_JavaLangString, "evaluateCallbackJs on null realJsRuntime");
  }
  
  public void a(String paramString, ValueCallback paramValueCallback)
  {
    if (a()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime.evaluateJs(paramString);
      return;
    }
    QMLog.e(this.jdField_a_of_type_JavaLangString, "evaluateJs on null realJsRuntime");
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (a()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime.evaluateSubscribeJs(paramString1, paramString2);
      return;
    }
    QMLog.e(this.jdField_a_of_type_JavaLangString, "evaluateSubscribeJS on null realJsRuntime");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgth
 * JD-Core Version:    0.7.0.1
 */