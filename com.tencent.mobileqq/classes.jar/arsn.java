import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodCodec;

public class arsn
  extends arsl
{
  public arsn(String paramString, BinaryMessenger paramBinaryMessenger)
  {
    super(paramString, paramBinaryMessenger);
  }
  
  public MethodChannel.MethodCallHandler a()
  {
    return new arso(this);
  }
  
  public MethodCodec a()
  {
    return arsp.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsn
 * JD-Core Version:    0.7.0.1
 */