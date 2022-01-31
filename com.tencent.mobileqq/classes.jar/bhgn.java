import android.content.Context;
import android.util.AttributeSet;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.StringCodec;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

final class bhgn
  extends FlutterView
{
  private final BasicMessageChannel<String> a = new BasicMessageChannel(this, "flutter/lifecycle", StringCodec.INSTANCE);
  
  bhgn(Context paramContext, AttributeSet paramAttributeSet, FlutterNativeView paramFlutterNativeView)
  {
    super(paramContext, paramAttributeSet, paramFlutterNativeView);
  }
  
  public void onFirstFrame()
  {
    super.onFirstFrame();
    setAlpha(1.0F);
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    this.a.send("AppLifecycleState.resumed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgn
 * JD-Core Version:    0.7.0.1
 */