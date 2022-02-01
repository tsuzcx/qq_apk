package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;

public class ScreenLayoutSmallUIDouble
  extends ScreenLayout
{
  protected ScreenLayoutSmallUIDouble(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  private void a(GLVideoView paramGLVideoView1, GLVideoView paramGLVideoView2, int paramInt)
  {
    int i = paramInt >> 1;
    int j = ScreenLayoutDoubleScreen.b(paramInt);
    paramGLVideoView1.a(0, 0, 0, 0);
    paramGLVideoView1.b(i, 0, paramInt, j);
    paramGLVideoView1.d(-15197410);
    paramGLVideoView2.a(0, 0, 0, 0);
    paramGLVideoView2.b(0, 0, i, j);
    paramGLVideoView2.d(-15197410);
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    boolean bool;
    if (!this.a.getCurrentAccountUin().equals(paramArrayOfGLVideoView[1].a(0)))
    {
      bool = true;
      AVLog.printColorLog("ScreenLayoutSmallUIDouble", "layoutCommon: " + paramBoolean + "|" + bool);
      if (!bool) {
        break label112;
      }
      if (paramBoolean) {
        break label94;
      }
      paramBoolean = true;
    }
    label94:
    label112:
    for (;;)
    {
      if (paramBoolean)
      {
        a(paramArrayOfGLVideoView[0], paramArrayOfGLVideoView[1], paramInt1);
        return;
        bool = false;
        break;
        paramBoolean = false;
        continue;
      }
      a(paramArrayOfGLVideoView[1], paramArrayOfGLVideoView[0], paramInt1);
      return;
    }
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayoutSmallUIDouble
 * JD-Core Version:    0.7.0.1
 */