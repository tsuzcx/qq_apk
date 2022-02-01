package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
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
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    if (paramArrayOfGLVideoView == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299269);
    int n = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299266);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299267);
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299268);
    if (paramInt5 == 0) {
      k = j;
    }
    int m = 0;
    int i = j;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            i = 0;
            j = 0;
            k = 0;
            break label207;
          }
        }
        else {
          j = paramInt2 - i1 - j;
        }
        m = j + i1;
        i = paramInt3 - n - k - paramInt5;
        k = m;
      }
      else
      {
        i = paramInt2 - i1 - j;
      }
    }
    else
    {
      j = i + i1;
      m = k + paramInt4;
      k = j;
      j = i;
      i = m;
    }
    n += i;
    m = k;
    k = j;
    j = n;
    label207:
    paramArrayOfGLVideoView[1].b(k, i, m, j);
    if (QLog.isColorLevel())
    {
      paramArrayOfGLVideoView = new StringBuilder();
      paramArrayOfGLVideoView.append("setSmallVideoViewLayout, position[");
      paramArrayOfGLVideoView.append(paramInt1);
      paramArrayOfGLVideoView.append("], width[");
      paramArrayOfGLVideoView.append(paramInt2);
      paramArrayOfGLVideoView.append("], height[");
      paramArrayOfGLVideoView.append(paramInt3);
      paramArrayOfGLVideoView.append("], layout[");
      paramArrayOfGLVideoView.append(k);
      paramArrayOfGLVideoView.append(", ");
      paramArrayOfGLVideoView.append(i);
      paramArrayOfGLVideoView.append(", ");
      paramArrayOfGLVideoView.append(m);
      paramArrayOfGLVideoView.append(", ");
      paramArrayOfGLVideoView.append(j);
      paramArrayOfGLVideoView.append("], topOffset[");
      paramArrayOfGLVideoView.append(paramInt4);
      paramArrayOfGLVideoView.append("], bottomOffset[");
      paramArrayOfGLVideoView.append(paramInt5);
      paramArrayOfGLVideoView.append("], mGlSmallViewTopOffset[");
      paramArrayOfGLVideoView.append(this.b);
      paramArrayOfGLVideoView.append("]");
      QLog.w("ScreenLayoutSliderWindow", 1, paramArrayOfGLVideoView.toString());
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
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("canSwitchView, mBlock[");
        localStringBuilder.append(localCPreEventInfo.a);
        localStringBuilder.append("], mBlockName[");
        localStringBuilder.append(localCPreEventInfo.b);
        localStringBuilder.append("]");
        QLog.w("ScreenLayoutSliderWindow", 1, localStringBuilder.toString());
      }
    }
    return localCPreEventInfo.a ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayoutSliderWindow
 * JD-Core Version:    0.7.0.1
 */