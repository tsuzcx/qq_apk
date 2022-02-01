package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.Display.Mode;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class DisplayCompat
{
  private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
  private static final int DISPLAY_SIZE_4K_WIDTH = 3840;
  
  private static Point getPhysicalDisplaySize(@NonNull Context paramContext, @NonNull Display paramDisplay)
  {
    Point localPoint;
    if (Build.VERSION.SDK_INT < 28) {
      localPoint = parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", paramDisplay);
    } else {
      localPoint = parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", paramDisplay);
    }
    if (localPoint != null) {
      return localPoint;
    }
    if (isSonyBravia4kTv(paramContext)) {
      return new Point(3840, 2160);
    }
    paramContext = new Point();
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramDisplay = paramDisplay.getMode();
      paramContext.x = paramDisplay.getPhysicalWidth();
      paramContext.y = paramDisplay.getPhysicalHeight();
      return paramContext;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramDisplay.getRealSize(paramContext);
      return paramContext;
    }
    paramDisplay.getSize(paramContext);
    return paramContext;
  }
  
  @SuppressLint({"ArrayReturn"})
  @NonNull
  public static DisplayCompat.ModeCompat[] getSupportedModes(@NonNull Context paramContext, @NonNull Display paramDisplay)
  {
    paramContext = getPhysicalDisplaySize(paramContext, paramDisplay);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramDisplay = paramDisplay.getSupportedModes();
      ArrayList localArrayList = new ArrayList(paramDisplay.length);
      int i = 0;
      int j = 0;
      while (i < paramDisplay.length)
      {
        if (physicalSizeEquals(paramDisplay[i], paramContext))
        {
          localArrayList.add(i, new DisplayCompat.ModeCompat(paramDisplay[i], true));
          j = 1;
        }
        else
        {
          localArrayList.add(i, new DisplayCompat.ModeCompat(paramDisplay[i], false));
        }
        i += 1;
      }
      if (j == 0) {
        localArrayList.add(new DisplayCompat.ModeCompat(paramContext));
      }
      return (DisplayCompat.ModeCompat[])localArrayList.toArray(new DisplayCompat.ModeCompat[0]);
    }
    return new DisplayCompat.ModeCompat[] { new DisplayCompat.ModeCompat(paramContext) };
  }
  
  @Nullable
  private static String getSystemProperty(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString = (String)localClass.getMethod("get", new Class[] { String.class }).invoke(localClass, new Object[] { paramString });
      return paramString;
    }
    catch (Exception paramString)
    {
      label39:
      break label39;
    }
    return null;
  }
  
  private static boolean isSonyBravia4kTv(@NonNull Context paramContext)
  {
    return (isTv(paramContext)) && ("Sony".equals(Build.MANUFACTURER)) && (Build.MODEL.startsWith("BRAVIA")) && (paramContext.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd"));
  }
  
  private static boolean isTv(@NonNull Context paramContext)
  {
    paramContext = (UiModeManager)paramContext.getSystemService("uimode");
    return (paramContext != null) && (paramContext.getCurrentModeType() == 4);
  }
  
  private static Point parseDisplaySize(@NonNull String paramString)
  {
    paramString = paramString.trim().split("x", -1);
    if (paramString.length == 2)
    {
      int i = Integer.parseInt(paramString[0]);
      int j = Integer.parseInt(paramString[1]);
      if ((i > 0) && (j > 0)) {
        return new Point(i, j);
      }
    }
    throw new NumberFormatException();
  }
  
  @Nullable
  private static Point parsePhysicalDisplaySizeFromSystemProperties(@NonNull String paramString, @NonNull Display paramDisplay)
  {
    if (paramDisplay.getDisplayId() == 0)
    {
      paramString = getSystemProperty(paramString);
      if (TextUtils.isEmpty(paramString)) {}
    }
    try
    {
      paramString = parseDisplaySize(paramString);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      label26:
      break label26;
    }
    return null;
  }
  
  @RequiresApi(23)
  private static boolean physicalSizeEquals(Display.Mode paramMode, Point paramPoint)
  {
    return ((paramMode.getPhysicalWidth() == paramPoint.x) && (paramMode.getPhysicalHeight() == paramPoint.y)) || ((paramMode.getPhysicalWidth() == paramPoint.y) && (paramMode.getPhysicalHeight() == paramPoint.x));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.DisplayCompat
 * JD-Core Version:    0.7.0.1
 */