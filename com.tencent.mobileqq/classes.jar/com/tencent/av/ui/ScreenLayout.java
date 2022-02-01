package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ScreenLayout
{
  Context a;
  VideoAppInterface b;
  protected int c = 0;
  protected boolean d = false;
  
  protected ScreenLayout(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramContext;
    this.b = paramVideoAppInterface;
    paramContext = new StringBuilder();
    paramContext.append("ScreenLayout. onCreate.");
    paramContext.append(this);
    QLog.d("ScreenLayout", 1, paramContext.toString());
  }
  
  public static ScreenLayout a(Context paramContext, VideoAppInterface paramVideoAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramContext = localObject;
      break;
    case 6: 
      if (!paramBoolean) {
        break;
      }
    }
    try
    {
      paramContext = new ScreenLayoutSmallUIOrigin(paramContext, paramVideoAppInterface);
    }
    finally {}
    paramContext = new ScreenLayoutDoubleVerticalScreen(paramContext, paramVideoAppInterface);
    break label241;
    if (paramBoolean)
    {
      paramContext = new ScreenLayoutWatchTogetherDoubleUI(paramContext, paramVideoAppInterface);
    }
    else
    {
      paramContext = new ScreenLayoutSliderWindow(paramContext, paramVideoAppInterface);
      break label241;
      if (paramBoolean)
      {
        paramContext = new ScreenLayoutSmallUIOrigin(paramContext, paramVideoAppInterface);
      }
      else
      {
        paramContext = new ScreenLayoutSliderWindow(paramContext, paramVideoAppInterface);
        break label241;
        if (paramBoolean)
        {
          paramContext = new ScreenLayoutSmallUIOrigin(paramContext, paramVideoAppInterface);
        }
        else
        {
          paramContext = new ScreenLayoutMultipleGrid(paramContext, paramVideoAppInterface);
          break label241;
          if (paramBoolean)
          {
            paramContext = new ScreenLayoutSmallUIDouble(paramContext, paramVideoAppInterface);
          }
          else
          {
            paramContext = new ScreenLayoutDoubleScreen(paramContext, paramVideoAppInterface);
            break label241;
            if (paramBoolean) {
              paramContext = new ScreenLayoutSmallUIOrigin(paramContext, paramVideoAppInterface);
            } else {
              paramContext = new ScreenLayoutOrigin(paramContext, paramVideoAppInterface);
            }
          }
        }
      }
    }
    label241:
    for (;;)
    {
      return paramContext;
    }
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScreenLayout. onDestroy.");
    localStringBuilder.append(this);
    QLog.d("ScreenLayout", 1, localStringBuilder.toString());
    this.a = null;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, ConcurrentHashMap<Long, VideoMemberInfo> paramConcurrentHashMap) {}
  
  public void a(SessionInfo paramSessionInfo, GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {}
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public abstract int b();
  
  public boolean c()
  {
    return this.c != 0;
  }
  
  public abstract boolean d();
  
  public boolean e()
  {
    return (b() == 2) || (b() == 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayout
 * JD-Core Version:    0.7.0.1
 */