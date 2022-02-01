package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;

public class ScreenLayoutSmallUIDoubleVertical
  extends ScreenLayout
{
  private void a(GLVideoView paramGLVideoView1, GLVideoView paramGLVideoView2, int paramInt1, int paramInt2)
  {
    int i = paramInt2 >> 1;
    paramGLVideoView1.a(0, 0, 0, 0);
    paramGLVideoView1.c(0, i, paramInt1, paramInt2);
    paramGLVideoView1.e(-15197410);
    paramGLVideoView2.a(0, 0, 0, 0);
    paramGLVideoView2.c(0, 0, paramInt1, i);
    paramGLVideoView2.e(-15197410);
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    boolean bool2 = this.b.getCurrentAccountUin().equals(paramArrayOfGLVideoView[1].d(0)) ^ true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("layoutCommon: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("|");
    localStringBuilder.append(bool2);
    AVLog.printColorLog("ScreenLayoutSmallUIDoubleVertical", localStringBuilder.toString());
    boolean bool1 = paramBoolean;
    if (bool2) {
      bool1 = paramBoolean ^ true;
    }
    if (bool1)
    {
      a(paramArrayOfGLVideoView[0], paramArrayOfGLVideoView[1], paramInt1, paramInt2);
      return;
    }
    a(paramArrayOfGLVideoView[1], paramArrayOfGLVideoView[0], paramInt1, paramInt2);
  }
  
  public int b()
  {
    return 6;
  }
  
  public boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayoutSmallUIDoubleVertical
 * JD-Core Version:    0.7.0.1
 */