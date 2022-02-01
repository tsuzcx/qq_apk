import android.text.TextUtils;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodCodec;

public abstract class auee
  extends aued
{
  MethodChannel a;
  
  public auee(String paramString, BinaryMessenger paramBinaryMessenger)
  {
    super(paramString, paramBinaryMessenger);
    MethodCodec localMethodCodec = a();
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("channelName must not be empty");
    }
    if (localMethodCodec == null) {
      throw new IllegalArgumentException("methodCodec must not be null");
    }
    this.a = new MethodChannel(paramBinaryMessenger, paramString, a());
    this.a.setMethodCallHandler(a());
  }
  
  public abstract MethodChannel.MethodCallHandler a();
  
  public abstract MethodCodec a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auee
 * JD-Core Version:    0.7.0.1
 */