import com.tencent.qqmini.sdk.log.QMLog;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

class bhgp
  implements MethodChannel.MethodCallHandler
{
  bhgp(bhgo parambhgo) {}
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    paramResult.success(null);
    QMLog.d("miniapp-start-TISSUE-flutter_method_channel", paramMethodCall.method);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgp
 * JD-Core Version:    0.7.0.1
 */