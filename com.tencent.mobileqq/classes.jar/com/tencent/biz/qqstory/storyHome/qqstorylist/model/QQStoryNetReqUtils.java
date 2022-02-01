package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class QQStoryNetReqUtils
{
  private static final String a;
  private static final boolean b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append("/testEnv/");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("testserver");
    b = new File(localStringBuilder.toString()).exists();
  }
  
  public static boolean a()
  {
    boolean bool = b;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils
 * JD-Core Version:    0.7.0.1
 */