package com.tencent.biz.qqstory.playvideo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

final class TVKPreloader$6
  extends SimpleJob<Object>
{
  TVKPreloader$6(String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = TVKPreloader.a();
    if (paramJobContext != null) {
      TVKPreloader.b(paramJobContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.6
 * JD-Core Version:    0.7.0.1
 */