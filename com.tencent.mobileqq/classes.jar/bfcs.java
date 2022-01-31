import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

class bfcs
  implements MethodChannel.MethodCallHandler
{
  bfcs(bfcr parambfcr) {}
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    paramResult.success(null);
    betc.a("miniapp-start-TISSUE-flutter_method_channel", paramMethodCall.method);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfcs
 * JD-Core Version:    0.7.0.1
 */