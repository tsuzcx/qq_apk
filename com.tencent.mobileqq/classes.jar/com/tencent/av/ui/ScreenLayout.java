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
    paramContext = new StringBuilder();
    paramContext.append("ScreenLayout. onCreate.");
    paramContext.append(this);
    QLog.d("ScreenLayout", 1, paramContext.toString());
  }
  
  public static ScreenLayout a(Context paramContext, VideoAppInterface paramVideoAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              paramContext = localObject;
              break label187;
            }
            if (!paramBoolean) {}
          }
        }
      }
    }
    try
    {
      paramContext = new ScreenLayoutWatchTogetherDoubleUI(paramContext, paramVideoAppInterface);
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          label187:
          throw paramContext;
        }
      }
    }
    paramContext = new ScreenLayoutSliderWindow(paramContext, paramVideoAppInterface);
    break label204;
    if (paramBoolean)
    {
      paramContext = new ScreenLayoutSmallUIOrigin(paramContext, paramVideoAppInterface);
    }
    else
    {
      paramContext = new ScreenLayoutSliderWindow(paramContext, paramVideoAppInterface);
      break label204;
      if (paramBoolean)
      {
        paramContext = new ScreenLayoutSmallUIOrigin(paramContext, paramVideoAppInterface);
      }
      else
      {
        paramContext = new ScreenLayoutMultipleGrid(paramContext, paramVideoAppInterface);
        break label204;
        if (paramBoolean)
        {
          paramContext = new ScreenLayoutSmallUIDouble(paramContext, paramVideoAppInterface);
        }
        else
        {
          paramContext = new ScreenLayoutDoubleScreen(paramContext, paramVideoAppInterface);
          break label204;
          if (paramBoolean)
          {
            paramContext = new ScreenLayoutSmallUIOrigin(paramContext, paramVideoAppInterface);
          }
          else
          {
            paramContext = new ScreenLayoutOrigin(paramContext, paramVideoAppInterface);
            break label204;
            return paramContext;
          }
        }
      }
    }
  }
  
  public abstract int a();
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScreenLayout. onDestroy.");
    localStringBuilder.append(this);
    QLog.d("ScreenLayout", 1, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayout
 * JD-Core Version:    0.7.0.1
 */