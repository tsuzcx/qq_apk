package com.tencent.biz.qqstory.storyHome.qqstorylist.common;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;

public class InfoPrinter
{
  public static void a(String paramString, Object... paramVarArgs)
  {
    SLog.e(paramString, StringAppendTool.a(paramVarArgs));
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString, 2, StringAppendTool.a(paramVarArgs));
    }
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    SLog.d(paramString, StringAppendTool.a(paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter
 * JD-Core Version:    0.7.0.1
 */