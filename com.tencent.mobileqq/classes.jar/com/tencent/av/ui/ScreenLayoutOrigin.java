package com.tencent.av.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.AVLog;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ARZimuTask;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import com.tencent.av.ui.funchat.zimu.ZimuViewLive;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class ScreenLayoutOrigin
  extends ScreenLayout
{
  int a;
  public GLRootView a;
  public boolean a;
  int b = -1;
  private int c;
  
  public ScreenLayoutOrigin(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
    this.jdField_a_of_type_Int = -1;
    this.c = ((int)DisplayUtils.a(paramContext, 100.0F));
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(SessionInfo paramSessionInfo, GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    paramArrayOfGLVideoView[0].a(0, 0, 0, 0);
    paramArrayOfGLVideoView[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfGLVideoView[0].i(-16777216);
    int i;
    if (paramSessionInfo.D == 2)
    {
      paramArrayOfGLVideoView[0].a(Boolean.valueOf(false));
      paramArrayOfGLVideoView[1].a(Boolean.valueOf(true));
      paramArrayOfGLVideoView[2].a(Boolean.valueOf(true));
      paramArrayOfGLVideoView[3].a(Boolean.valueOf(true));
      paramArrayOfGLVideoView[4].a(Boolean.valueOf(true));
      if ((!paramArrayOfGLVideoView[0].c()) || ((paramInt3 != 0) && (paramInt3 != 180)) || (paramArrayOfGLVideoView[0].g())) {
        break label463;
      }
      if (paramInt3 == 0) {
        paramArrayOfGLVideoView[0].a(0, 0, 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559765));
      }
    }
    else
    {
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559730);
      if (paramInt4 == 0) {
        break label520;
      }
    }
    label520:
    for (paramInt3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559731);; paramInt3 = i)
    {
      int k = (paramInt1 - i * 2) / 4;
      int j = paramInt2 - k - paramInt3 - paramInt4;
      paramInt3 = paramInt2 - paramInt3 - paramInt4;
      if (paramBoolean)
      {
        paramInt1 = paramArrayOfGLVideoView[1].b().left;
        paramInt2 = paramArrayOfGLVideoView[1].b().right;
        label236:
        paramArrayOfGLVideoView[1].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label493;
        }
        paramInt2 = paramArrayOfGLVideoView[2].b().left;
        paramInt1 = paramArrayOfGLVideoView[2].b().right;
        label275:
        paramArrayOfGLVideoView[2].b(paramInt2, j, paramInt1, paramInt3);
        if (!paramBoolean) {
          break label502;
        }
        paramInt1 = paramArrayOfGLVideoView[3].b().left;
        paramInt2 = paramArrayOfGLVideoView[3].b().right;
        label314:
        paramArrayOfGLVideoView[3].b(paramInt1, j, paramInt2, paramInt3);
        if (!paramBoolean) {
          break label511;
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
        paramArrayOfGLVideoView[0].a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559765), 0, 0);
        break;
        label463:
        paramArrayOfGLVideoView[0].a(0, 0, 0, 0);
        break;
        paramInt2 = paramInt1 - i;
        paramInt1 = paramInt1 - k - i;
        break label236;
        label493:
        paramInt2 = paramInt1 - k;
        break label275;
        label502:
        paramInt1 = paramInt2 - k;
        break label314;
        label511:
        paramInt2 = paramInt1 - k;
      }
    }
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OriginScreenLayout", 2, "setSmallVideoViewLayout position: " + paramInt1);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OriginScreenLayout", 2, "setSmallVideoViewLayout mContext == null");
      }
      return;
    }
    if (paramArrayOfGLVideoView == null)
    {
      AVLog.e("OriginScreenLayout", "setSmallVideoViewLayout mGlVideoView == null");
      return;
    }
    int n = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559728);
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559729);
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559730);
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559731);
    if (paramInt5 == 0) {
      m = k;
    }
    for (;;)
    {
      int i = paramInt5;
      Object localObject;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        localObject = (ZimuView)((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131362516);
        i = paramInt5;
        if (localObject != null)
        {
          i = paramInt5;
          if ((localObject instanceof ZimuViewLive))
          {
            localObject = (ZimuViewLive)localObject;
            i = paramInt5;
            if (((ZimuViewLive)localObject).a()) {
              i = ((ZimuViewLive)localObject).c();
            }
          }
        }
      }
      int j;
      switch (paramInt1)
      {
      default: 
        paramInt4 = 0;
        paramInt5 = 0;
        i = 0;
        j = 0;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.getLayoutParams();
          if (this.b == -1)
          {
            this.jdField_a_of_type_Int = paramInt2;
            this.b = paramInt3;
          }
          if (paramInt2 == n) {
            break;
          }
          ((RelativeLayout.LayoutParams)localObject).leftMargin = (paramInt2 - n - k);
          ((RelativeLayout.LayoutParams)localObject).topMargin = (this.c + m);
          ((RelativeLayout.LayoutParams)localObject).height = i1;
          ((RelativeLayout.LayoutParams)localObject).width = n;
          this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.layout(paramInt2 - n - k, this.c + m, paramInt2 - k, m + this.c + i1);
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 < paramArrayOfGLVideoView.length)
            {
              paramArrayOfGLVideoView[paramInt1].g(8);
              paramInt1 += 1;
              continue;
              paramInt5 = k + n;
              i = m + paramInt4;
              paramInt4 = i + i1;
              j = k;
              break;
              j = paramInt2 - n - k;
              paramInt5 = j + n;
              i = m + paramInt4;
              paramInt4 = i + i1;
              break;
              paramInt5 = k + n;
              i = paramInt3 - i1 - m - i;
              paramInt4 = i + i1;
              j = k;
              break;
              j = paramInt2 - n - k;
              paramInt5 = j + n;
              i = paramInt3 - i1 - m - i;
              paramInt4 = i + i1;
              break;
            }
          }
          paramArrayOfGLVideoView[1].g(0);
          paramArrayOfGLVideoView[1].b(0, 0, n, i1);
          return;
        }
      }
      paramArrayOfGLVideoView[1].b(j, i, paramInt5, paramInt4);
      ARZimuTask.a("setSmallVideoViewLayout: smallWindows" + i1 + "|" + n);
      ARZimuTask.b(i1, n);
      ARZimuTask.a(j, i);
      ARZimuTask.a(paramInt1);
      return;
    }
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramArrayOfGLVideoView[0].a(0, 0, 0, 0);
    paramArrayOfGLVideoView[0].b(0, 0, paramInt1, paramInt2);
    paramArrayOfGLVideoView[0].i(-16777216);
    paramArrayOfGLVideoView[1].a(3, 3, 3, 3);
    paramArrayOfGLVideoView[1].i(-16777216);
    a(paramArrayOfGLVideoView, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public boolean a()
  {
    ControlUIObserver.CPreEventInfo localCPreEventInfo = new ControlUIObserver.CPreEventInfo(null);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8004), localCPreEventInfo });
      if (QLog.isDevelopLevel()) {
        QLog.w("OriginScreenLayout", 1, "canSwitchView, mCanSwitch[" + localCPreEventInfo.b + "], mBlockName[" + localCPreEventInfo.a + "]");
      }
    }
    return !localCPreEventInfo.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayoutOrigin
 * JD-Core Version:    0.7.0.1
 */