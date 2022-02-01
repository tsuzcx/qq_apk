package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ARZimuTask;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ScreenLayoutSliderWindow
  extends ScreenLayout
{
  private int b = 0;
  
  public ScreenLayoutSliderWindow(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.b = ((int)DisplayUtils.a(paramContext, 100.0F));
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, ConcurrentHashMap<Long, VideoMemberInfo> paramConcurrentHashMap)
  {
    paramRect2.set(paramRect1.left, paramRect1.top - paramInt, paramRect1.right, paramRect1.bottom - paramInt);
  }
  
  public void a(SessionInfo paramSessionInfo, GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = 0;
    if (this.jdField_a_of_type_AndroidContentContext == null) {}
    while (paramArrayOfGLVideoView == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299266);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299263);
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299264);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299265);
    if (paramInt5 == 0) {
      i = m;
    }
    for (;;)
    {
      int j;
      int k;
      switch (paramInt1)
      {
      default: 
        j = 0;
        k = 0;
        m = 0;
        i = n;
      }
      for (;;)
      {
        paramArrayOfGLVideoView[1].b(m, k, j, i);
        ARZimuTask.b(i2, i1);
        ARZimuTask.a(m, k);
        ARZimuTask.a(paramInt1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("ScreenLayoutSliderWindow", 1, "setSmallVideoViewLayout, position[" + paramInt1 + "], width[" + paramInt2 + "], height[" + paramInt3 + "], layout[" + m + ", " + k + ", " + j + ", " + i + "], topOffset[" + paramInt4 + "], bottomOffset[" + paramInt5 + "], mGlSmallViewTopOffset[" + this.b + "]");
        return;
        j = m + i1;
        k = i + paramInt4;
        i = k + i2;
        continue;
        m = paramInt2 - i1 - m;
        j = m + i1;
        k = i + paramInt4;
        i = k + i2;
        continue;
        j = m + i1;
        k = paramInt3 - i2 - i - paramInt5;
        i = k + i2;
        continue;
        m = paramInt2 - i1 - m;
        j = m + i1;
        k = paramInt3 - i2 - i - paramInt5;
        i = k + i2;
      }
    }
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramArrayOfGLVideoView[0].a(0, 0, 0, 0);
    paramArrayOfGLVideoView[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfGLVideoView[0].d(-15197410);
    paramArrayOfGLVideoView[1].a(3, 3, 3, 3);
    paramArrayOfGLVideoView[1].d(-15197410);
    a(paramArrayOfGLVideoView, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public boolean b()
  {
    ControlUIObserver.CPreEventInfo localCPreEventInfo = new ControlUIObserver.CPreEventInfo(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8004), localCPreEventInfo });
      if (QLog.isDevelopLevel()) {
        QLog.w("ScreenLayoutSliderWindow", 1, "canSwitchView, mBlock[" + localCPreEventInfo.jdField_b_of_type_Boolean + "], mBlockName[" + localCPreEventInfo.jdField_b_of_type_JavaLangString + "]");
      }
    }
    return !localCPreEventInfo.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayoutSliderWindow
 * JD-Core Version:    0.7.0.1
 */