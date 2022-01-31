package com.tencent.biz.qqstory.storyHome.qqstorylist.common;

import nxw;

public class StringAppendTool
{
  public static ThreadLocal a = new nxw();
  
  public static String a(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = (StringBuilder)a.get();
    if (paramVarArgs.length > 0)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        if (localObject != null) {
          localStringBuilder.append(localObject.toString());
        }
        i += 1;
      }
    }
    return "";
    paramVarArgs = localStringBuilder.toString();
    if (localStringBuilder.length() > 512) {
      a.set(new StringBuilder(512));
    }
    localStringBuilder.setLength(0);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.common.StringAppendTool
 * JD-Core Version:    0.7.0.1
 */