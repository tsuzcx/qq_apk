package com.idlefish.flutterboost;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.AppSwitcherDescription;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.ClipboardContentFormat;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SoundType;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemChromeStyle;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay;
import java.util.ArrayList;
import java.util.List;

class XPlatformPlugin$1
  implements PlatformChannel.PlatformMessageHandler
{
  XPlatformPlugin$1(XPlatformPlugin paramXPlatformPlugin) {}
  
  public CharSequence getClipboardData(@Nullable PlatformChannel.ClipboardContentFormat paramClipboardContentFormat)
  {
    return XPlatformPlugin.access$800(this.this$0, paramClipboardContentFormat);
  }
  
  public List<Rect> getSystemGestureExclusionRects()
  {
    return XPlatformPlugin.access$1000(this.this$0);
  }
  
  public void playSystemSound(@NonNull PlatformChannel.SoundType paramSoundType)
  {
    XPlatformPlugin.access$000(this.this$0, paramSoundType);
  }
  
  public void popSystemNavigator()
  {
    XPlatformPlugin.access$700(this.this$0);
  }
  
  public void restoreSystemUiOverlays()
  {
    XPlatformPlugin.access$500(this.this$0);
  }
  
  public void setApplicationSwitcherDescription(@NonNull PlatformChannel.AppSwitcherDescription paramAppSwitcherDescription)
  {
    XPlatformPlugin.access$300(this.this$0, paramAppSwitcherDescription);
  }
  
  public void setClipboardData(@NonNull String paramString)
  {
    XPlatformPlugin.access$900(this.this$0, paramString);
  }
  
  public void setPreferredOrientations(int paramInt)
  {
    XPlatformPlugin.access$200(this.this$0, paramInt);
  }
  
  public void setSystemGestureExclusionRects(@NonNull ArrayList<Rect> paramArrayList)
  {
    XPlatformPlugin.access$1100(this.this$0, paramArrayList);
  }
  
  public void setSystemUiOverlayStyle(@NonNull PlatformChannel.SystemChromeStyle paramSystemChromeStyle)
  {
    XPlatformPlugin.access$600(this.this$0, paramSystemChromeStyle);
  }
  
  public void showSystemOverlays(@NonNull List<PlatformChannel.SystemUiOverlay> paramList)
  {
    XPlatformPlugin.access$400(this.this$0, paramList);
  }
  
  public void vibrateHapticFeedback(@NonNull PlatformChannel.HapticFeedbackType paramHapticFeedbackType)
  {
    XPlatformPlugin.access$100(this.this$0, paramHapticFeedbackType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.XPlatformPlugin.1
 * JD-Core Version:    0.7.0.1
 */