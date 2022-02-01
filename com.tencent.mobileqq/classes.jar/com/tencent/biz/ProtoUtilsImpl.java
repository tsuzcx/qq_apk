package com.tencent.biz;

import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Arrays;

public class ProtoUtilsImpl
  implements IProtoUtils
{
  public void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    String[] arrayOfString = paramVarArgs;
    if (paramVarArgs != null)
    {
      arrayOfString = paramVarArgs;
      if (paramVarArgs.length > 0)
      {
        arrayOfString = (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length + 1);
        arrayOfString[(arrayOfString.length - 1)] = StoryReportor.a(BaseApplication.getContext());
      }
    }
    StoryReportor.b("story_net", paramString, paramInt1, paramInt2, arrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.ProtoUtilsImpl
 * JD-Core Version:    0.7.0.1
 */