package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import odx;
import ody;

public class QQStoryNetReqUtils
{
  private static final String jdField_a_of_type_JavaLangString = AppConstants.aJ + "/Tencent/com/tencent/mobileqq/";
  private static final boolean jdField_a_of_type_Boolean = new File(jdField_a_of_type_JavaLangString + "testserver").exists();
  
  public static void a(QQStoryNetReqUtils.RequestCallBack paramRequestCallBack)
  {
    paramRequestCallBack = new WeakReference(paramRequestCallBack);
    GetUserSelfInfoStep localGetUserSelfInfoStep = new GetUserSelfInfoStep(null);
    localGetUserSelfInfoStep.a(new odx(paramRequestCallBack));
    localGetUserSelfInfoStep.a(new ody(paramRequestCallBack));
    localGetUserSelfInfoStep.a();
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Boolean) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils
 * JD-Core Version:    0.7.0.1
 */