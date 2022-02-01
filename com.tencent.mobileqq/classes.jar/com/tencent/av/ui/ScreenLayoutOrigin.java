package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ARZimuTask;
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
    if (paramBoolean)
    {
      localGLVideoView = paramArrayOfGLVideoView[0];
      if (!paramBoolean) {
        break label178;
      }
      paramArrayOfGLVideoView = paramArrayOfGLVideoView[1];
      label36:
      if (!this.jdField_a_of_type_Boolean) {
        break label185;
      }
      paramInt3 = 0;
      label46:
      if (!this.jdField_a_of_type_Boolean) {
        break label202;
      }
    }
    label178:
    label185:
    label202:
    for (paramInt4 = 0;; paramInt4 = AIOUtils.a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
    {
      paramInt1 = paramInt1 - paramInt3 - AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramInt2 = paramInt2 - AIOUtils.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) - paramInt4;
      localGLVideoView.a(0, 0, 0, 0);
      localGLVideoView.d(-15197410);
      localGLVideoView.b(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
      paramInt1 = paramInt1 - paramInt3 - AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramArrayOfGLVideoView.a(0, 0, 0, 0);
      paramArrayOfGLVideoView.d(-15197410);
      paramArrayOfGLVideoView.b(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
      return;
      localGLVideoView = paramArrayOfGLVideoView[1];
      break;
      paramArrayOfGLVideoView = paramArrayOfGLVideoView[0];
      break label36;
      paramInt3 = AIOUtils.a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      break label46;
    }
  }
  
  private void d(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramBoolean = paramArrayOfGLVideoView[0].a().equalsIgnoreCase(paramArrayOfGLVideoView[0].c());
    GLVideoView localGLVideoView;
    if (paramBoolean)
    {
      localGLVideoView = paramArrayOfGLVideoView[0];
      if (!paramBoolean) {
        break label168;
      }
    }
    label168:
    for (paramArrayOfGLVideoView = paramArrayOfGLVideoView[1];; paramArrayOfGLVideoView = paramArrayOfGLVideoView[0])
    {
      paramInt3 = AIOUtils.a(120.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramInt4 = AIOUtils.a(172.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramInt1 = (paramInt1 - paramInt3 * 2 - 2) / 2;
      paramInt2 = paramInt2 - paramInt4 - AIOUtils.a(161.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGLVideoView.a(0, 0, 0, 0);
      localGLVideoView.d(-15197410);
      localGLVideoView.b(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
      paramInt1 = paramInt1 + paramInt3 + 2;
      paramArrayOfGLVideoView.a(0, 0, 0, 0);
      paramArrayOfGLVideoView.d(-15197410);
      paramArrayOfGLVideoView.b(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
      return;
      localGLVideoView = paramArrayOfGLVideoView[1];
      break;
    }
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
    int i;
    if (paramSessionInfo.D == 2)
    {
      paramArrayOfGLVideoView[0].a(Boolean.valueOf(false));
      paramArrayOfGLVideoView[1].a(Boolean.valueOf(true));
      paramArrayOfGLVideoView[2].a(Boolean.valueOf(true));
      paramArrayOfGLVideoView[3].a(Boolean.valueOf(true));
      paramArrayOfGLVideoView[4].a(Boolean.valueOf(true));
      if ((!paramArrayOfGLVideoView[0].f()) || ((paramInt3 != 0) && (paramInt3 != 180)) || (paramArrayOfGLVideoView[0].k())) {
        break label471;
      }
      if (paramInt3 == 0) {
        paramArrayOfGLVideoView[0].a(0, 0, 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297844));
      }
    }
    else
    {
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299264);
      if (paramInt4 == 0) {
        break label528;
      }
    }
    label519:
    label528:
    for (paramInt3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299265);; paramInt3 = i)
    {
      int k = (paramInt1 - i * 2) / 4;
      int j = paramInt2 - k - paramInt3 - paramInt4;
      paramInt3 = paramInt2 - paramInt3 - paramInt4;
      if (paramBoolean)
      {
        paramInt1 = paramArrayOfGLVideoView[1].b().left;
        paramInt2 = paramArrayOfGLVideoView[1].b().right;
        label244:
        paramArrayOfGLVideoView[1].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label501;
        }
        paramInt2 = paramArrayOfGLVideoView[2].b().left;
        paramInt1 = paramArrayOfGLVideoView[2].b().right;
        label283:
        paramArrayOfGLVideoView[2].b(paramInt2, j, paramInt1, paramInt3);
        if (!paramBoolean) {
          break label510;
        }
        paramInt1 = paramArrayOfGLVideoView[3].b().left;
        paramInt2 = paramArrayOfGLVideoView[3].b().right;
        label322:
        paramArrayOfGLVideoView[3].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label519;
        }
        paramInt2 = paramArrayOfGLVideoView[4].b().left;
        paramInt1 = paramArrayOfGLVideoView[4].b().right;
      }
      for (;;)
      {
        paramArrayOfGLVideoView[4].b(paramInt2, j, paramInt1, paramInt3);
        paramArrayOfGLVideoView[1].d(-15197410);
        paramArrayOfGLVideoView[2].d(-15197410);
        paramArrayOfGLVideoView[3].d(-15197410);
        paramArrayOfGLVideoView[4].d(-15197410);
        paramArrayOfGLVideoView[1].a(2, 3, 3, 3);
        paramArrayOfGLVideoView[2].a(2, 3, 2, 3);
        paramArrayOfGLVideoView[3].a(2, 3, 2, 3);
        paramArrayOfGLVideoView[4].a(3, 3, 2, 3);
        return;
        paramArrayOfGLVideoView[0].a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297844), 0, 0);
        break;
        label471:
        paramArrayOfGLVideoView[0].a(0, 0, 0, 0);
        break;
        paramInt2 = paramInt1 - i;
        paramInt1 = paramInt1 - k - i;
        break label244;
        label501:
        paramInt2 = paramInt1 - k;
        break label283;
        label510:
        paramInt1 = paramInt2 - k;
        break label322;
        paramInt2 = paramInt1 - k;
      }
    }
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
        QLog.w("OriginScreenLayout", 1, "setSmallVideoViewLayout, position[" + paramInt1 + "], width[" + paramInt2 + "], height[" + paramInt3 + "], layout[" + m + ", " + k + ", " + j + ", " + i + "], topOffset[" + paramInt4 + "], bottomOffset[" + paramInt5 + "], mGlSmallViewTopOffset[" + this.b + "]");
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
    if (this.jdField_a_of_type_Int == 0) {
      b(paramArrayOfGLVideoView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 2)
      {
        c(paramArrayOfGLVideoView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
        return;
      }
    } while (this.jdField_a_of_type_Int != 1);
    d(paramArrayOfGLVideoView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
  }
  
  public boolean b()
  {
    ControlUIObserver.CPreEventInfo localCPreEventInfo = new ControlUIObserver.CPreEventInfo(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8004), localCPreEventInfo });
      if (QLog.isDevelopLevel()) {
        QLog.w("OriginScreenLayout", 1, "canSwitchView, mCanSwitch[" + localCPreEventInfo.jdField_b_of_type_Boolean + "], mBlockName[" + localCPreEventInfo.jdField_b_of_type_JavaLangString + "]");
      }
    }
    return !localCPreEventInfo.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayoutOrigin
 * JD-Core Version:    0.7.0.1
 */