package com.qflutter.video;

import android.content.Context;
import android.view.Surface;
import android.view.View;
import java.util.Map;

public class QflutterVideoViewSource
{
  private static QflutterVideoViewSource.Provider provider;
  
  public static View getVideoView(Context paramContext, int paramInt, Surface paramSurface, Map<String, Object> paramMap)
  {
    if (provider != null)
    {
      paramContext = provider.getView(paramContext, paramInt, paramSurface, paramMap);
      if ((paramContext instanceof IQflutterVideoView)) {
        return paramContext;
      }
      throw new RuntimeException("view provided to QFlutter should implement IQFlutterVideoView");
    }
    throw new RuntimeException("provider should not be null when getVideoView been called");
  }
  
  public static void setProvider(QflutterVideoViewSource.Provider paramProvider)
  {
    provider = paramProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.video.QflutterVideoViewSource
 * JD-Core Version:    0.7.0.1
 */