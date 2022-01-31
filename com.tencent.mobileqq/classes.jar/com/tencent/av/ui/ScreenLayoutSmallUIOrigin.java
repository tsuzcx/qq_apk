package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ARZimuTask;
import com.tencent.qphone.base.util.QLog;

public class ScreenLayoutSmallUIOrigin
  extends ScreenLayout
{
  protected Display a;
  
  protected ScreenLayoutSmallUIOrigin(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(SessionInfo paramSessionInfo, GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559730);
    if (paramInt4 != 0) {}
    for (paramInt3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559731);; paramInt3 = i)
    {
      int k = (paramInt1 - i * 2) / 4;
      int j = paramInt2 - k - paramInt3 - paramInt4;
      paramInt3 = paramInt2 - paramInt3 - paramInt4;
      if (paramBoolean)
      {
        paramInt1 = paramArrayOfGLVideoView[1].b().left;
        paramInt2 = paramArrayOfGLVideoView[1].b().right;
        paramArrayOfGLVideoView[1].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label312;
        }
        paramInt2 = paramArrayOfGLVideoView[2].b().left;
        paramInt1 = paramArrayOfGLVideoView[2].b().right;
        label131:
        paramArrayOfGLVideoView[2].b(paramInt2, j, paramInt1, paramInt3);
        if (!paramBoolean) {
          break label321;
        }
        paramInt1 = paramArrayOfGLVideoView[3].b().left;
        paramInt2 = paramArrayOfGLVideoView[3].b().right;
        label170:
        paramArrayOfGLVideoView[3].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label330;
        }
        paramInt2 = paramArrayOfGLVideoView[4].b().left;
        paramInt1 = paramArrayOfGLVideoView[4].b().right;
      }
      for (;;)
      {
        paramArrayOfGLVideoView[4].b(paramInt2, j, paramInt1, paramInt3);
        paramArrayOfGLVideoView[1].i(-16777216);
        paramArrayOfGLVideoView[2].i(-16777216);
        paramArrayOfGLVideoView[3].i(-16777216);
        paramArrayOfGLVideoView[4].i(-16777216);
        paramArrayOfGLVideoView[1].a(2, 3, 3, 3);
        paramArrayOfGLVideoView[2].a(2, 3, 2, 3);
        paramArrayOfGLVideoView[3].a(2, 3, 2, 3);
        paramArrayOfGLVideoView[4].a(3, 3, 2, 3);
        return;
        paramInt2 = paramInt1 - i;
        paramInt1 = paramInt1 - k - i;
        break;
        label312:
        paramInt2 = paramInt1 - k;
        break label131;
        label321:
        paramInt1 = paramInt2 - k;
        break label170;
        label330:
        paramInt2 = paramInt1 - k;
      }
    }
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ScreenLayoutSmallUIOrigin", 2, "setSmallVideoViewLayout position: " + paramInt1);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenLayoutSmallUIOrigin", 2, "setSmallVideoViewLayout mContext == null");
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559728);
    this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559729);
    this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559730);
    this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559731);
    int m;
    int k;
    int i;
    int j;
    if (this.jdField_a_of_type_AndroidViewDisplay.getRotation() % 2 == 0)
    {
      m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559925);
      k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559926);
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559927);
      j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559928);
      if (paramInt5 != 0) {
        break label450;
      }
      j = i;
    }
    label450:
    for (;;)
    {
      switch (paramInt1)
      {
      default: 
        paramInt2 = 0;
        paramInt3 = 0;
        i = 0;
        paramInt1 = n;
      }
      for (;;)
      {
        paramArrayOfGLVideoView[1].b(i, paramInt3, paramInt2, paramInt1);
        ARZimuTask.a("setSmallVideoViewLayout " + m + "|" + k);
        return;
        m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559926);
        k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559925);
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559928);
        j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559927);
        break;
        paramInt2 = i + m;
        paramInt3 = j + paramInt4;
        paramInt1 = paramInt3 + k;
        continue;
        i = paramInt2 - m - i;
        paramInt2 = i + m;
        paramInt3 = j + paramInt4;
        paramInt1 = paramInt3 + k;
        continue;
        paramInt2 = i + m;
        paramInt3 = paramInt3 - k - j - paramInt5;
        paramInt1 = paramInt3 + k;
        continue;
        i = paramInt2 - m - i;
        paramInt3 = paramInt3 - k - j - paramInt5;
        paramInt2 = i + m;
        paramInt1 = paramInt3 + k;
      }
    }
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramArrayOfGLVideoView[1].a(3, 3, 3, 3);
    paramArrayOfGLVideoView[1].i(-16777216);
    a(paramArrayOfGLVideoView, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayoutSmallUIOrigin
 * JD-Core Version:    0.7.0.1
 */