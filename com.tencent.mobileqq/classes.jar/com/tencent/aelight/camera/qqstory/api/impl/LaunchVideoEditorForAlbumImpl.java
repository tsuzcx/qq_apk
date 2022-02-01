package com.tencent.aelight.camera.qqstory.api.impl;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.util.JumpUtil;
import com.tencent.aelight.camera.aioeditor.setting.CaptureEntranceParams;
import com.tencent.aelight.camera.aioeditor.setting.CaptureVideoParams;
import com.tencent.aelight.camera.aioeditor.setting.CaptureVideoParams.CaptureVideoParamsBuilder;
import com.tencent.aelight.camera.qqstory.api.ILaunchVideoEditorForAlbum;
import com.tencent.aelight.camera.struct.camera.BaseVideoCaptureResult;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public class LaunchVideoEditorForAlbumImpl
  implements ILaunchVideoEditorForAlbum
{
  CaptureEntranceParams mEntranceParams;
  
  private CaptureVideoParams createCaptureVideoParamsByEntrance(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new CaptureVideoParams.CaptureVideoParamsBuilder().a(false).c(true).b(false).c(2).a();
    }
    return new CaptureVideoParams.CaptureVideoParamsBuilder().a(true).c(true).b(true).c(2).a();
  }
  
  public void jumpToEditVideoActivity(Activity paramActivity, BaseVideoCaptureResult paramBaseVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Bundle paramBundle1, int paramInt, @Nullable Bundle paramBundle2)
  {
    JumpUtil.a(paramActivity, paramBaseVideoCaptureResult, paramLocalMediaInfo, this.mEntranceParams, paramBundle1, paramInt, paramBundle2);
  }
  
  public void setVideoParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mEntranceParams = new CaptureEntranceParams(paramInt1, paramInt2, paramInt3);
    this.mEntranceParams.a(createCaptureVideoParamsByEntrance(paramInt4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.LaunchVideoEditorForAlbumImpl
 * JD-Core Version:    0.7.0.1
 */