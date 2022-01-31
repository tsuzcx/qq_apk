import android.text.TextUtils;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodCodec;

public abstract class arwu
  extends arwt
{
  MethodChannel a;
  
  public arwu(String paramString, BinaryMessenger paramBinaryMessenger)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwu
 * JD-Core Version:    0.7.0.1
 */