import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.StandardMethodCodec;

public abstract class apzq
  implements MethodChannel.MethodCallHandler
{
  public static final MethodCodec a = StandardMethodCodec.INSTANCE;
  
  protected abstract void a(String paramString, MethodChannel.Result paramResult);
  
  protected abstract void a(String paramString, Boolean paramBoolean, MethodChannel.Result paramResult);
  
  protected abstract void a(String paramString, Integer paramInteger, MethodChannel.Result paramResult);
  
  protected abstract void a(String paramString, Integer paramInteger, Boolean paramBoolean, MethodChannel.Result paramResult);
  
  protected abstract void b(String paramString, MethodChannel.Result paramResult);
  
  protected abstract void b(String paramString, Boolean paramBoolean, MethodChannel.Result paramResult);
  
  protected abstract void b(String paramString, Integer paramInteger, MethodChannel.Result paramResult);
  
  protected abstract void c(String paramString, MethodChannel.Result paramResult);
  
  protected abstract void c(String paramString, Integer paramInteger, MethodChannel.Result paramResult);
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    if ("setSpecialCare".equals(str))
    {
      a((String)paramMethodCall.argument("uin"), (Boolean)paramMethodCall.argument("isSpecialCare"), paramResult);
      return;
    }
    if ("setQzoneNotify".equals(str))
    {
      b((String)paramMethodCall.argument("uin"), (Boolean)paramMethodCall.argument("isQzoneNotify"), paramResult);
      return;
    }
    if ("getSCFSwitchs".equals(str))
    {
      a((String)paramMethodCall.argument("uin"), paramResult);
      return;
    }
    if ("getSpecialRing".equals(str))
    {
      b((String)paramMethodCall.argument("uin"), paramResult);
      return;
    }
    if ("openSpecialRingMall".equals(str))
    {
      c((String)paramMethodCall.argument("uin"), paramResult);
      return;
    }
    if ("onPageShowReport".equals(str))
    {
      a((String)paramMethodCall.argument("uin"), (Integer)paramMethodCall.argument("from"), paramResult);
      return;
    }
    if ("onBellShowReport".equals(str))
    {
      b((String)paramMethodCall.argument("uin"), (Integer)paramMethodCall.argument("from"), paramResult);
      return;
    }
    if ("onBellClickReport".equals(str))
    {
      c((String)paramMethodCall.argument("uin"), (Integer)paramMethodCall.argument("from"), paramResult);
      return;
    }
    if ("onSpecialCareSwitchReport".equals(str))
    {
      a((String)paramMethodCall.argument("uin"), (Integer)paramMethodCall.argument("from"), (Boolean)paramMethodCall.argument("isChecked"), paramResult);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apzq
 * JD-Core Version:    0.7.0.1
 */