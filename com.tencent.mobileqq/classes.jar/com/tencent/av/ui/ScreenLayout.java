package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ScreenLayout
{
  protected int a;
  Context jdField_a_of_type_AndroidContentContext;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  protected boolean a;
  
  protected ScreenLayout(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    QLog.d("ScreenLayout", 1, "ScreenLayout. onCreate." + this);
  }
  
  public static ScreenLayout a(Context paramContext, VideoAppInterface paramVideoAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramContext = localObject;
    }
    for (;;)
    {
      return paramContext;
      if (paramBoolean)
      {
        try
        {
          paramContext = new ScreenLayoutSmallUIOrigin(paramContext, paramVideoAppInterface);
          continue;
        }
        finally {}
      }
      else
      {
        paramContext = new ScreenLayoutOrigin(paramContext, paramVideoAppInterface);
        continue;
        if (paramBoolean)
        {
          paramContext = new ScreenLayoutSmallUIDouble(paramContext, paramVideoAppInterface);
        }
        else
        {
          paramContext = new ScreenLayoutDoubleScreen(paramContext, paramVideoAppInterface);
          continue;
          if (paramBoolean)
          {
            paramContext = new ScreenLayoutSmallUIOrigin(paramContext, paramVideoAppInterface);
          }
          else
          {
            paramContext = new ScreenLayoutMultipleGrid(paramContext, paramVideoAppInterface);
            continue;
            if (paramBoolean)
            {
              paramContext = new ScreenLayoutSmallUIOrigin(paramContext, paramVideoAppInterface);
            }
            else
            {
              paramContext = new ScreenLayoutSliderWindow(paramContext, paramVideoAppInterface);
              continue;
              if (paramBoolean) {
                paramContext = new ScreenLayoutWatchTogetherDoubleUI(paramContext, paramVideoAppInterface);
              } else {
                paramContext = new ScreenLayoutSliderWindow(paramContext, paramVideoAppInterface);
              }
            }
          }
        }
      }
    }
  }
  
  public abstract int a();
  
  public void a()
  {
    QLog.d("ScreenLayout", 1, "ScreenLayout. onDestroy." + this);
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, ConcurrentHashMap<Long, VideoMemberInfo> paramConcurrentHashMap) {}
  
  public void a(SessionInfo paramSessionInfo, GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int != 0;
  }
  
  public abstract boolean b();
  
  public boolean c()
  {
    return a() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayout
 * JD-Core Version:    0.7.0.1
 */