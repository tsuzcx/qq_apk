package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.AppSwitcherDescription;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.ClipboardContentFormat;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SoundType;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemChromeStyle;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay;
import java.util.ArrayList;
import java.util.List;

public class XPlatformPlugin
{
  public static final int DEFAULT_SYSTEM_UI = 1280;
  private Activity activity;
  private PlatformChannel.SystemChromeStyle currentTheme;
  private int mEnabledOverlays;
  private PlatformChannel.PlatformMessageHandler mPlatformMessageHandler = new XPlatformPlugin.1(this);
  private PlatformChannel platformChannel;
  
  public XPlatformPlugin(PlatformChannel paramPlatformChannel)
  {
    this.platformChannel = paramPlatformChannel;
    this.mEnabledOverlays = 1280;
  }
  
  private CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat paramClipboardContentFormat)
  {
    ClipData localClipData = ((ClipboardManager)this.activity.getSystemService("clipboard")).getPrimaryClip();
    if (localClipData == null) {
      return null;
    }
    if ((paramClipboardContentFormat == null) || (paramClipboardContentFormat == PlatformChannel.ClipboardContentFormat.PLAIN_TEXT)) {
      return localClipData.getItemAt(0).coerceToText(this.activity);
    }
    return null;
  }
  
  private List<Rect> getSystemGestureExclusionRects()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return this.activity.getWindow().getDecorView().getSystemGestureExclusionRects();
    }
    return null;
  }
  
  private void playSystemSound(PlatformChannel.SoundType paramSoundType)
  {
    if (paramSoundType == PlatformChannel.SoundType.CLICK) {
      this.activity.getWindow().getDecorView().playSoundEffect(0);
    }
  }
  
  private void popSystemNavigator()
  {
    this.activity.finish();
  }
  
  private void restoreSystemChromeSystemUIOverlays()
  {
    updateSystemUiOverlays();
  }
  
  private void setClipboardData(String paramString)
  {
    ((ClipboardManager)this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", paramString));
  }
  
  private void setSystemChromeApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription paramAppSwitcherDescription)
  {
    if (Build.VERSION.SDK_INT < 21) {}
    do
    {
      return;
      if ((Build.VERSION.SDK_INT < 28) && (Build.VERSION.SDK_INT > 21)) {
        this.activity.setTaskDescription(new ActivityManager.TaskDescription(paramAppSwitcherDescription.label, null, paramAppSwitcherDescription.color));
      }
    } while (Build.VERSION.SDK_INT < 28);
    paramAppSwitcherDescription = new ActivityManager.TaskDescription(paramAppSwitcherDescription.label, 0, paramAppSwitcherDescription.color);
    this.activity.setTaskDescription(paramAppSwitcherDescription);
  }
  
  private void setSystemChromeEnabledSystemUIOverlays(List<PlatformChannel.SystemUiOverlay> paramList)
  {
    int i;
    int j;
    if (paramList.size() == 0)
    {
      i = 5894;
      j = 0;
      label15:
      if (j >= paramList.size()) {
        break label102;
      }
      PlatformChannel.SystemUiOverlay localSystemUiOverlay = (PlatformChannel.SystemUiOverlay)paramList.get(j);
      switch (XPlatformPlugin.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[localSystemUiOverlay.ordinal()])
      {
      }
    }
    for (;;)
    {
      j += 1;
      break label15;
      i = 1798;
      break;
      i = i & 0xFFFFFDFF & 0xFFFFFFFD;
      continue;
      i &= 0xFFFFFFFB;
    }
    label102:
    this.mEnabledOverlays = i;
    updateSystemUiOverlays();
  }
  
  private void setSystemChromePreferredOrientations(int paramInt)
  {
    this.activity.setRequestedOrientation(paramInt);
  }
  
  private void setSystemChromeSystemUIOverlayStyle(PlatformChannel.SystemChromeStyle paramSystemChromeStyle)
  {
    Object localObject = this.activity.getWindow();
    View localView = ((Window)localObject).getDecorView();
    int k = localView.getSystemUiVisibility();
    int i = k;
    int j;
    if (Build.VERSION.SDK_INT >= 26)
    {
      j = k;
      if (paramSystemChromeStyle.systemNavigationBarIconBrightness == null) {}
    }
    switch (XPlatformPlugin.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[paramSystemChromeStyle.systemNavigationBarIconBrightness.ordinal()])
    {
    default: 
      j = k;
      i = j;
      if (paramSystemChromeStyle.systemNavigationBarColor != null)
      {
        ((Window)localObject).setNavigationBarColor(paramSystemChromeStyle.systemNavigationBarColor.intValue());
        i = j;
      }
      k = i;
      if (Build.VERSION.SDK_INT >= 23)
      {
        j = i;
        if (paramSystemChromeStyle.statusBarIconBrightness != null) {
          switch (XPlatformPlugin.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[paramSystemChromeStyle.statusBarIconBrightness.ordinal()])
          {
          default: 
            j = i;
          }
        }
      }
      break;
    }
    for (;;)
    {
      k = j;
      if (paramSystemChromeStyle.statusBarColor != null)
      {
        ((Window)localObject).setStatusBarColor(paramSystemChromeStyle.statusBarColor.intValue());
        k = j;
      }
      localObject = paramSystemChromeStyle.systemNavigationBarDividerColor;
      localView.setSystemUiVisibility(k);
      this.currentTheme = paramSystemChromeStyle;
      return;
      j = k & 0xFFFFFFEF;
      break;
      j = k | 0x10;
      break;
      j = i & 0xFFFFDFFF;
      continue;
      j = i | 0x2000;
    }
  }
  
  private void setSystemGestureExclusionRects(ArrayList<Rect> paramArrayList)
  {
    if (Build.VERSION.SDK_INT < 29) {
      return;
    }
    this.activity.getWindow().getDecorView().setSystemGestureExclusionRects(paramArrayList);
  }
  
  private void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType paramHapticFeedbackType)
  {
    View localView = this.activity.getWindow().getDecorView();
    switch (XPlatformPlugin.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[paramHapticFeedbackType.ordinal()])
    {
    default: 
      return;
    case 5: 
      localView.performHapticFeedback(4);
      return;
    case 4: 
      localView.performHapticFeedback(6);
      return;
    case 3: 
      localView.performHapticFeedback(3);
      return;
    case 2: 
      localView.performHapticFeedback(1);
      return;
    }
    localView.performHapticFeedback(0);
  }
  
  public void attachToActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.platformChannel.setPlatformMessageHandler(this.mPlatformMessageHandler);
  }
  
  public void detachActivity()
  {
    this.activity = null;
    this.mPlatformMessageHandler = null;
  }
  
  public void updateSystemUiOverlays()
  {
    this.activity.getWindow().getDecorView().setSystemUiVisibility(this.mEnabledOverlays);
    if (this.currentTheme != null) {
      setSystemChromeSystemUIOverlayStyle(this.currentTheme);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.idlefish.flutterboost.XPlatformPlugin
 * JD-Core Version:    0.7.0.1
 */