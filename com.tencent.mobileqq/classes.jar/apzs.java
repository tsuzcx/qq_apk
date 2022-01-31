import android.text.TextUtils;
import com.tencent.mobileqq.flutter.channel.model.RequestPacket;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.Map;

public abstract class apzs
  implements MethodChannel.MethodCallHandler
{
  public static final MethodCodec a = StandardMethodCodec.INSTANCE;
  
  protected abstract void a(RequestPacket paramRequestPacket, MethodChannel.Result paramResult);
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    QLog.d("SSOChannelHandler", 1, String.format("onMethodCall: %s", new Object[] { str }));
    if (TextUtils.isEmpty(str))
    {
      paramResult.notImplemented();
      return;
    }
    if (str.equals("sendRequest"))
    {
      paramMethodCall = paramMethodCall.argument("req");
      if ((paramMethodCall instanceof Map))
      {
        a(RequestPacket.fromMap((Map)paramMethodCall), paramResult);
        return;
      }
      paramResult.notImplemented();
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apzs
 * JD-Core Version:    0.7.0.1
 */