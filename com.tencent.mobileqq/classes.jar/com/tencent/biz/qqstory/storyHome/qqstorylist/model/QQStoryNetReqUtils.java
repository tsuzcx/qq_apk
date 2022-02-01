package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class QQStoryNetReqUtils
{
  private static final String jdField_a_of_type_JavaLangString;
  private static final boolean jdField_a_of_type_Boolean;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append("/testEnv/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("testserver");
    jdField_a_of_type_Boolean = new File(localStringBuilder.toString()).exists();
  }
  
  public static boolean a()
  {
    boolean bool = jdField_a_of_type_Boolean;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils
 * JD-Core Version:    0.7.0.1
 */