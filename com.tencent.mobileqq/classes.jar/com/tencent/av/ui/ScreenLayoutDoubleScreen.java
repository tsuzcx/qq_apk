package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.AVLog;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

public class ScreenLayoutDoubleScreen
  extends ScreenLayout
{
  protected ScreenLayoutDoubleScreen(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  private void a(GLVideoView paramGLVideoView1, GLVideoView paramGLVideoView2, int paramInt)
  {
    int i = paramInt >> 1;
    int j = c(paramInt);
    paramGLVideoView1.a(0, 0, 0, 0);
    paramGLVideoView1.c(0, 0, i, j);
    paramGLVideoView1.e(-15197410);
    paramGLVideoView2.a(0, 0, 0, 0);
    paramGLVideoView2.c(i, 0, paramInt, j);
    paramGLVideoView2.e(-15197410);
  }
  
  public static int b(int paramInt)
  {
    return (paramInt << 16) / 1201 >> 6;
  }
  
  public static int c(int paramInt)
  {
    return paramInt * 1201 >> 10;
  }
  
  public void a(SessionInfo paramSessionInfo, GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {}
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    boolean bool2 = this.b.getCurrentAccountUin().equals(paramArrayOfGLVideoView[1].d(0)) ^ true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("layoutCommon: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("|");
    localStringBuilder.append(bool2);
    AVLog.printColorLog("ScreenLayoutDoubleScreen", localStringBuilder.toString());
    boolean bool1 = paramBoolean;
    if (bool2) {
      bool1 = paramBoolean ^ true;
    }
    if (bool1)
    {
      a(paramArrayOfGLVideoView[1], paramArrayOfGLVideoView[0], paramInt1);
      return;
    }
    a(paramArrayOfGLVideoView[0], paramArrayOfGLVideoView[1], paramInt1);
  }
  
  public int b()
  {
    return 2;
  }
  
  public boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayoutDoubleScreen
 * JD-Core Version:    0.7.0.1
 */