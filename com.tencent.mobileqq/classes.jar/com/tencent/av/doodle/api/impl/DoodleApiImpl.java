package com.tencent.av.doodle.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.DoodleSurfaceView;
import com.tencent.av.doodle.DoodleToolbar;
import com.tencent.av.doodle.api.IDoodleApi;

public class DoodleApiImpl
  implements IDoodleApi
{
  VideoController mVideoController = VideoController.a();
  
  public View createDoodleSurfaceView(Context paramContext)
  {
    return new DoodleSurfaceView(paramContext);
  }
  
  public Class<?> getDoodleToolbarClass()
  {
    return DoodleToolbar.class;
  }
  
  public void notifyAddDoodleSurfaceView()
  {
    this.mVideoController.a.a(new Object[] { Integer.valueOf(161) });
  }
  
  public int sendAVFunChatMsg(int paramInt, byte[] paramArrayOfByte)
  {
    return this.mVideoController.a(paramInt, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.doodle.api.impl.DoodleApiImpl
 * JD-Core Version:    0.7.0.1
 */