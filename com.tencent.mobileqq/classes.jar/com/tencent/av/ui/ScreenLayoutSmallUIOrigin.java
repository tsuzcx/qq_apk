package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ScreenLayoutSmallUIOrigin
  extends ScreenLayout
{
  protected Display e;
  
  protected ScreenLayoutSmallUIOrigin(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.e = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
  }
  
  public void a(SessionInfo paramSessionInfo, GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.a == null) {
      return;
    }
    int i = this.a.getResources().getDimensionPixelSize(2131300023);
    if (paramInt4 != 0) {
      paramInt3 = this.a.getResources().getDimensionPixelSize(2131300024);
    } else {
      paramInt3 = i;
    }
    int k = (paramInt1 - i * 2) / 4;
    int j = paramInt2 - k - paramInt3 - paramInt4;
    paramInt3 = paramInt2 - paramInt3 - paramInt4;
    if (paramBoolean)
    {
      paramInt1 = paramArrayOfGLVideoView[1].f().left;
      paramInt2 = paramArrayOfGLVideoView[1].f().right;
    }
    else
    {
      paramInt2 = paramInt1 - i;
      paramInt1 = paramInt1 - k - i;
    }
    paramArrayOfGLVideoView[1].c(paramInt1, j, paramInt2, paramInt3);
    if (paramBoolean)
    {
      paramInt1 = paramArrayOfGLVideoView[2].f().left;
      paramInt2 = paramArrayOfGLVideoView[2].f().right;
    }
    else
    {
      paramInt2 = paramInt1;
      paramInt1 -= k;
    }
    paramArrayOfGLVideoView[2].c(paramInt1, j, paramInt2, paramInt3);
    if (paramBoolean)
    {
      paramInt1 = paramArrayOfGLVideoView[3].f().left;
      paramInt2 = paramArrayOfGLVideoView[3].f().right;
    }
    else
    {
      paramInt2 = paramInt1;
      paramInt1 -= k;
    }
    paramArrayOfGLVideoView[3].c(paramInt1, j, paramInt2, paramInt3);
    if (paramBoolean)
    {
      paramInt1 = paramArrayOfGLVideoView[4].f().left;
      paramInt2 = paramArrayOfGLVideoView[4].f().right;
    }
    else
    {
      paramInt2 = paramInt1;
      paramInt1 -= k;
    }
    paramArrayOfGLVideoView[4].c(paramInt1, j, paramInt2, paramInt3);
    paramArrayOfGLVideoView[1].e(-15197410);
    paramArrayOfGLVideoView[2].e(-15197410);
    paramArrayOfGLVideoView[3].e(-15197410);
    paramArrayOfGLVideoView[4].e(-15197410);
    paramArrayOfGLVideoView[1].a(2, 3, 3, 3);
    paramArrayOfGLVideoView[2].a(2, 3, 2, 3);
    paramArrayOfGLVideoView[3].a(2, 3, 2, 3);
    paramArrayOfGLVideoView[4].a(3, 3, 2, 3);
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSmallVideoViewLayout position: ");
      localStringBuilder.append(paramInt1);
      QLog.d("ScreenLayoutSmallUIOrigin", 2, localStringBuilder.toString());
    }
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenLayoutSmallUIOrigin", 2, "setSmallVideoViewLayout mContext == null");
      }
      return;
    }
    this.a.getResources().getDimensionPixelSize(2131300025);
    this.a.getResources().getDimensionPixelSize(2131300022);
    this.a.getResources().getDimensionPixelSize(2131300023);
    this.a.getResources().getDimensionPixelSize(2131300024);
    int m;
    int k;
    int i;
    if (this.e.getRotation() % 2 == 0)
    {
      m = this.a.getResources().getDimensionPixelSize(2131298642);
      k = this.a.getResources().getDimensionPixelSize(2131298639);
      i = this.a.getResources().getDimensionPixelSize(2131298640);
      j = this.a.getResources().getDimensionPixelSize(2131298641);
    }
    else
    {
      m = this.a.getResources().getDimensionPixelSize(2131298639);
      k = this.a.getResources().getDimensionPixelSize(2131298642);
      i = this.a.getResources().getDimensionPixelSize(2131298641);
      j = this.a.getResources().getDimensionPixelSize(2131298640);
    }
    int n = j;
    if (paramInt5 == 0) {
      n = i;
    }
    int i1 = 0;
    int j = i;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            paramInt2 = 0;
            paramInt3 = 0;
            i = 0;
            paramInt1 = i1;
            break label384;
          }
          paramInt1 = i + m;
          paramInt2 = paramInt3 - k - n - paramInt5;
        }
        else
        {
          i = paramInt2 - m - i;
          paramInt2 = paramInt3 - k - n - paramInt5;
          paramInt3 = paramInt2 + k;
          paramInt1 = i + m;
          break label384;
        }
      }
      else {
        j = paramInt2 - m - i;
      }
    }
    else
    {
      paramInt1 = j + m;
      paramInt2 = n + paramInt4;
      i = j;
    }
    paramInt3 = paramInt2 + k;
    label384:
    paramArrayOfGLVideoView[1].c(i, paramInt2, paramInt1, paramInt3);
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramArrayOfGLVideoView[1].a(3, 3, 3, 3);
    paramArrayOfGLVideoView[1].e(-15197410);
    a(paramArrayOfGLVideoView, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public int b()
  {
    return 1;
  }
  
  public boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayoutSmallUIOrigin
 * JD-Core Version:    0.7.0.1
 */