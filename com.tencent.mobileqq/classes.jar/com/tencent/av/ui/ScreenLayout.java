package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

public abstract class ScreenLayout
{
  Context jdField_a_of_type_AndroidContentContext;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  
  protected ScreenLayout(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
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
        if (paramBoolean) {
          paramContext = new ScreenLayoutSmallUIDouble(paramContext, paramVideoAppInterface);
        } else {
          paramContext = new ScreenLayoutDoubleScreen(paramContext, paramVideoAppInterface);
        }
      }
    }
  }
  
  public abstract int a();
  
  public void a(SessionInfo paramSessionInfo, GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {}
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(GLVideoView[] paramArrayOfGLVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public abstract boolean a();
  
  public boolean b()
  {
    return a() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.ScreenLayout
 * JD-Core Version:    0.7.0.1
 */