package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class QQStoryNetReqUtils
{
  private static final String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv/";
  private static final boolean jdField_a_of_type_Boolean = new File(jdField_a_of_type_JavaLangString + "testserver").exists();
  
  public static boolean a()
  {
    if (jdField_a_of_type_Boolean) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils
 * JD-Core Version:    0.7.0.1
 */