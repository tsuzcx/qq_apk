package com.tencent.aelight.camera.education.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IEducationEditPic
  extends QRouteApi
{
  public abstract void startAnswerSearchPicEditActivity(Activity paramActivity, String paramString, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.education.api.IEducationEditPic
 * JD-Core Version:    0.7.0.1
 */