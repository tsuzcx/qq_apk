package com.tencent.aelight.camera.util.api;

import android.app.Activity;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAEEditorJumpUtil
  extends QRouteApi
{
  public abstract void picChooseJump(int paramInt, @Nullable Activity paramActivity, @Nullable PhotoCommonBaseData paramPhotoCommonBaseData, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.util.api.IAEEditorJumpUtil
 * JD-Core Version:    0.7.0.1
 */