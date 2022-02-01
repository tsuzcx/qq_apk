package com.tencent.av.doodle.api.impl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.DoodleController;
import com.tencent.av.doodle.DoodleSurfaceView;
import com.tencent.av.doodle.DoodleToolbar;
import com.tencent.av.doodle.api.IDoodleApi;
import com.tencent.av.ui.AVActivity;

public class DoodleApiImpl
  implements IDoodleApi
{
  VideoController mVideoController = VideoController.f();
  
  public View createDoodleSurfaceView(Context paramContext)
  {
    return new DoodleSurfaceView(paramContext);
  }
  
  public Class<?> getDoodleToolbarClass()
  {
    return DoodleToolbar.class;
  }
  
  public String getUnableTip(Context paramContext)
  {
    return DoodleController.a(paramContext);
  }
  
  public int getUnableTipResId()
  {
    return DoodleController.b();
  }
  
  public void hideDoodle(long paramLong, Activity paramActivity)
  {
    if ((paramActivity instanceof AVActivity)) {
      DoodleController.b(paramLong, (AVActivity)paramActivity);
    }
  }
  
  public boolean isDoodleUsable()
  {
    return DoodleController.a();
  }
  
  public void notifyAddDoodleSurfaceView()
  {
    this.mVideoController.e.a(new Object[] { Integer.valueOf(161) });
  }
  
  public int sendAVFunChatMsg(int paramInt, byte[] paramArrayOfByte)
  {
    return this.mVideoController.b(paramInt, paramArrayOfByte);
  }
  
  public void showDoodle(long paramLong, Activity paramActivity)
  {
    if ((paramActivity instanceof AVActivity)) {
      DoodleController.a(paramLong, (AVActivity)paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.doodle.api.impl.DoodleApiImpl
 * JD-Core Version:    0.7.0.1
 */