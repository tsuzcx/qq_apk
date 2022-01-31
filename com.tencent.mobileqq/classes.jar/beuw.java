import android.webkit.ValueCallback;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;

public class beuw
  implements behp
{
  private int a;
  public ITTJSRuntime a;
  
  public beuw(ITTJSRuntime paramITTJSRuntime, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime = paramITTJSRuntime;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime.evaluateCallbackJs(paramInt, paramString);
      return;
    }
    betc.d("[minigame] GameJsRuntime", "evaluateCallbackJs on null realJsRuntime");
  }
  
  public void a(String paramString, ValueCallback paramValueCallback)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime.evaluateJs(paramString);
      return;
    }
    betc.d("[minigame] GameJsRuntime", "evaluateJs on null realJsRuntime");
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeITTJSRuntime.evaluateSubscribeJs(paramString1, paramString2);
      return;
    }
    betc.d("[minigame] GameJsRuntime", "evaluateSubcribeJS on null realJsRuntime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beuw
 * JD-Core Version:    0.7.0.1
 */