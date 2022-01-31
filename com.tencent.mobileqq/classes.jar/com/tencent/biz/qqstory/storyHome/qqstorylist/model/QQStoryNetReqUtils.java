package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep;
import com.tencent.mobileqq.app.AppConstants;
import java.lang.ref.WeakReference;
import nxx;
import nxy;

public class QQStoryNetReqUtils
{
  private static final String a = AppConstants.aI + "/Tencent/com/tencent/mobileqq/";
  
  public static void a(QQStoryNetReqUtils.RequestCallBack paramRequestCallBack)
  {
    paramRequestCallBack = new WeakReference(paramRequestCallBack);
    GetUserSelfInfoStep localGetUserSelfInfoStep = new GetUserSelfInfoStep(null);
    localGetUserSelfInfoStep.a(new nxx(paramRequestCallBack));
    localGetUserSelfInfoStep.a(new nxy(paramRequestCallBack));
    localGetUserSelfInfoStep.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils
 * JD-Core Version:    0.7.0.1
 */