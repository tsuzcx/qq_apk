package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class ScreenLayoutOrigin
  extends ScreenLayout
{
  private int b = 0;
  
  public ScreenLayoutOrigin(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.b = ((int)DisplayUtils.a(paramContext, 100.0F));
  }
  
  private void b(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramArrayOfGLVideoView[0].a(0, 0, 0, 0);
    paramArrayOfGLVideoView[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfGLVideoView[0].d(-15197410);
    paramArrayOfGLVideoView[1].a(3, 3, 3, 3);
    paramArrayOfGLVideoView[1].d(-15197410);
    a(paramArrayOfGLVideoView, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  private void c(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramBoolean = paramArrayOfGLVideoView[0].a().equalsIgnoreCase(paramArrayOfGLVideoView[0].c());
    GLVideoView localGLVideoView;
    if (paramBoolean) {
      localGLVideoView = paramArrayOfGLVideoView[0];
    } else {
      localGLVideoView = paramArrayOfGLVideoView[1];
    }
    if (paramBoolean) {
      paramArrayOfGLVideoView = paramArrayOfGLVideoView[1];
    } else {
      paramArrayOfGLVideoView = paramArrayOfGLVideoView[0];
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt3 = 0;
    } else {
      paramInt3 = AIOUtils.b(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt4 = 0;
    } else {
      paramInt4 = AIOUtils.b(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    paramInt1 = paramInt1 - paramInt3 - AIOUtils.b(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramInt2 = paramInt2 - AIOUtils.b(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) - paramInt4;
    localGLVideoView.a(0, 0, 0, 0);
    localGLVideoView.d(-15197410);
    paramInt4 += paramInt2;
    localGLVideoView.b(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt4);
    paramInt1 = paramInt1 - paramInt3 - AIOUtils.b(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramArrayOfGLVideoView.a(0, 0, 0, 0);
    paramArrayOfGLVideoView.d(-15197410);
    paramArrayOfGLVideoView.b(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4);
  }
  
  private void d(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramBoolean = paramArrayOfGLVideoView[0].a().equalsIgnoreCase(paramArrayOfGLVideoView[0].c());
    GLVideoView localGLVideoView;
    if (paramBoolean) {
      localGLVideoView = paramArrayOfGLVideoView[0];
    } else {
      localGLVideoView = paramArrayOfGLVideoView[1];
    }
    if (paramBoolean) {
      paramArrayOfGLVideoView = paramArrayOfGLVideoView[1];
    } else {
      paramArrayOfGLVideoView = paramArrayOfGLVideoView[0];
    }
    paramInt3 = AIOUtils.b(120.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramInt4 = AIOUtils.b(172.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramInt1 = (paramInt1 - paramInt3 * 2 - 2) / 2;
    paramInt2 = paramInt2 - paramInt4 - AIOUtils.b(161.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localGLVideoView.a(0, 0, 0, 0);
    localGLVideoView.d(-15197410);
    paramInt5 = paramInt1 + paramInt3;
    paramInt4 += paramInt2;
    localGLVideoView.b(paramInt1, paramInt2, paramInt5, paramInt4);
    paramInt1 = paramInt5 + 2;
    paramArrayOfGLVideoView.a(0, 0, 0, 0);
    paramArrayOfGLVideoView.d(-15197410);
    paramArrayOfGLVideoView.b(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4);
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(SessionInfo paramSessionInfo, GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    paramArrayOfGLVideoView[0].a(0, 0, 0, 0);
    paramArrayOfGLVideoView[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfGLVideoView[0].d(-15197410);
    if (paramSessionInfo.j == 2)
    {
      paramArrayOfGLVideoView[0].a(Boolean.valueOf(false));
      paramArrayOfGLVideoView[1].a(Boolean.valueOf(true));
      paramArrayOfGLVideoView[2].a(Boolean.valueOf(true));
      paramArrayOfGLVideoView[3].a(Boolean.valueOf(true));
      paramArrayOfGLVideoView[4].a(Boolean.valueOf(true));
      if ((paramArrayOfGLVideoView[0].f()) && ((paramInt3 == 0) || (paramInt3 == 180)) && (!paramArrayOfGLVideoView[0].j()))
      {
        if (paramInt3 == 0) {
          paramArrayOfGLVideoView[0].a(0, 0, 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297837));
        } else {
          paramArrayOfGLVideoView[0].a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297837), 0, 0);
        }
      }
      else {
        paramArrayOfGLVideoView[0].a(0, 0, 0, 0);
      }
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299267);
    if (paramInt4 != 0) {
      paramInt3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299268);
    } else {
      paramInt3 = i;
    }
    int k = (paramInt1 - i * 2) / 4;
    int j = paramInt2 - k - paramInt3 - paramInt4;
    paramInt3 = paramInt2 - paramInt3 - paramInt4;
    if (paramBoolean)
    {
      paramInt1 = paramArrayOfGLVideoView[1].b().left;
      paramInt2 = paramArrayOfGLVideoView[1].b().right;
    }
    else
    {
      paramInt2 = paramInt1 - i;
      paramInt1 = paramInt1 - k - i;
    }
    paramArrayOfGLVideoView[1].b(paramInt1, j, paramInt2, paramInt3);
    if (paramBoolean)
    {
      paramInt1 = paramArrayOfGLVideoView[2].b().left;
      paramInt2 = paramArrayOfGLVideoView[2].b().right;
    }
    else
    {
      paramInt2 = paramInt1;
      paramInt1 -= k;
    }
    paramArrayOfGLVideoView[2].b(paramInt1, j, paramInt2, paramInt3);
    if (paramBoolean)
    {
      paramInt1 = paramArrayOfGLVideoView[3].b().left;
      paramInt2 = paramArrayOfGLVideoView[3].b().right;
    }
    else
    {
      paramInt2 = paramInt1;
      paramInt1 -= k;
    }
    paramArrayOfGLVideoView[3].b(paramInt1, j, paramInt2, paramInt3);
    if (paramBoolean)
    {
      paramInt1 = paramArrayOfGLVideoView[4].b().left;
      paramInt2 = paramArrayOfGLVideoView[4].b().right;
    }
    else
    {
      paramInt2 = paramInt1;
      paramInt1 -= k;
    }
    paramArrayOfGLVideoView[4].b(paramInt1, j, paramInt2, paramInt3);
    paramArrayOfGLVideoView[1].d(-15197410);
    paramArrayOfGLVideoView[2].d(-15197410);
    paramArrayOfGLVideoView[3].d(-15197410);
    paramArrayOfGLVideoView[4].d(-15197410);
    paramArrayOfGLVideoView[1].a(2, 3, 3, 3);
    paramArrayOfGLVideoView[2].a(2, 3, 2, 3);
    paramArrayOfGLVideoView[3].a(2, 3, 2, 3);
    paramArrayOfGLVideoView[4].a(3, 3, 2, 3);
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
      QLog.w("OriginScreenLayout", 1, paramArrayOfGLVideoView.toString());
    }
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      b(paramArrayOfGLVideoView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
      return;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      c(paramArrayOfGLVideoView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
      return;
    }
    if (this.jdField_a_of_type_Int == 1) {
      d(paramArrayOfGLVideoView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
    }
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
        localStringBuilder.append("canSwitchView, mCanSwitch[");
        localStringBuilder.append(localCPreEventInfo.jdField_a_of_type_Boolean);
        localStringBuilder.append("], mBlockName[");
        localStringBuilder.append(localCPreEventInfo.b);
        localStringBuilder.append("]");
        QLog.w("OriginScreenLayout", 1, localStringBuilder.toString());
      }
    }
    return localCPreEventInfo.jdField_a_of_type_Boolean ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayoutOrigin
 * JD-Core Version:    0.7.0.1
 */