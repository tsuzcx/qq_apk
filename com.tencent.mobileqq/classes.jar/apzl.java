import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;

public abstract class apzl
  implements MethodChannel.MethodCallHandler
{
  public static final MethodCodec a = StandardMethodCodec.INSTANCE;
  
  protected abstract void a(String paramString, MethodChannel.Result paramResult);
  
  protected abstract void a(String paramString, Integer paramInteger, MethodChannel.Result paramResult);
  
  protected abstract void a(String paramString, Integer paramInteger, Double paramDouble, MethodChannel.Result paramResult);
  
  protected abstract void a(String paramString1, Integer paramInteger, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, MethodChannel.Result paramResult);
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    if ("reportException".equals(str))
    {
      a((String)paramMethodCall.argument("pagePath"), (Integer)paramMethodCall.argument("category"), (String)paramMethodCall.argument("errorType"), (String)paramMethodCall.argument("errorMsg"), (String)paramMethodCall.argument("stack"), (HashMap)paramMethodCall.argument("extraInfo"), paramResult);
      return;
    }
    if ("recordPageView".equals(str))
    {
      a((String)paramMethodCall.argument("pagePath"), paramResult);
      return;
    }
    if ("reportScrollPerfomance".equals(str))
    {
      a((String)paramMethodCall.argument("pagePath"), (Integer)paramMethodCall.argument("FPS"), (Double)paramMethodCall.argument("dropRate"), paramResult);
      return;
    }
    if ("reportPageLoadTime".equals(str))
    {
      a((String)paramMethodCall.argument("pagePath"), (Integer)paramMethodCall.argument("loadTime"), paramResult);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apzl
 * JD-Core Version:    0.7.0.1
 */