package com.tencent.aelight.camera.qqstory.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IEditPicForQzone
  extends QRouteApi
{
  public abstract Intent newPictureEditIntentWithoutPublish(Activity paramActivity, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IEditPicForQzone
 * JD-Core Version:    0.7.0.1
 */