import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.triton.sdk.bridge.IInspectorAgent;
import com.tencent.mobileqq.triton.sdk.bridge.IInspectorAgent.IDebuggerMessageListener;

public class bevm
  implements IInspectorAgent
{
  private IInspectorAgent.IDebuggerMessageListener jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeIInspectorAgent$IDebuggerMessageListener;
  private IInspectorAgent jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeIInspectorAgent;
  
  public void a(IInspectorAgent paramIInspectorAgent)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeIInspectorAgent = paramIInspectorAgent;
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeIInspectorAgent.setOnDebuggerMessageListener(this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeIInspectorAgent$IDebuggerMessageListener);
  }
  
  public void sendMessageToDebugger(@NonNull String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeIInspectorAgent != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeIInspectorAgent.sendMessageToDebugger(paramString);
    }
  }
  
  public void setOnDebuggerMessageListener(@Nullable IInspectorAgent.IDebuggerMessageListener paramIDebuggerMessageListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeIInspectorAgent$IDebuggerMessageListener = paramIDebuggerMessageListener;
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeIInspectorAgent != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeIInspectorAgent.setOnDebuggerMessageListener(this.jdField_a_of_type_ComTencentMobileqqTritonSdkBridgeIInspectorAgent$IDebuggerMessageListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevm
 * JD-Core Version:    0.7.0.1
 */