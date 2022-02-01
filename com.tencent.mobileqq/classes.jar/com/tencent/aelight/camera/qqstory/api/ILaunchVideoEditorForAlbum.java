package com.tencent.aelight.camera.qqstory.api;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.struct.camera.BaseVideoCaptureResult;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ILaunchVideoEditorForAlbum
  extends QRouteApi
{
  public abstract void jumpToEditVideoActivity(Activity paramActivity, BaseVideoCaptureResult paramBaseVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Bundle paramBundle1, int paramInt, @Nullable Bundle paramBundle2);
  
  public abstract void setVideoParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.ILaunchVideoEditorForAlbum
 * JD-Core Version:    0.7.0.1
 */