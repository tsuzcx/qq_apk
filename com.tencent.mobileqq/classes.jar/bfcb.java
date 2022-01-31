import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

class bfcb
  implements MethodChannel.MethodCallHandler
{
  bfcb(bfca parambfca) {}
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    paramResult.success(null);
    besl.a("miniapp-start-TISSUE-flutter_method_channel", paramMethodCall.method);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfcb
 * JD-Core Version:    0.7.0.1
 */