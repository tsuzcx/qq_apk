package com.tencent.biz;

import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Arrays;

public class ProtoUtilsImpl
  implements IProtoUtils
{
  public void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      paramVarArgs = (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length + 1);
      paramVarArgs[(paramVarArgs.length - 1)] = StoryReportor.a(BaseApplication.getContext());
    }
    for (;;)
    {
      StoryReportor.b("story_net", paramString, paramInt1, paramInt2, paramVarArgs);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.ProtoUtilsImpl
 * JD-Core Version:    0.7.0.1
 */