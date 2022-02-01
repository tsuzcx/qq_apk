package com.tencent.biz.qqstory.base.preload.cachecleaner;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class CacheCleaner$1
  extends SimpleJob<Void>
{
  CacheCleaner$1(CacheCleaner paramCacheCleaner, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    boolean bool = FileUtils.a(500L);
    if (this.a.a(bool)) {
      CacheCleaner.a(this.a, bool);
    }
    return null;
  }
  
  public int getJobType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner.1
 * JD-Core Version:    0.7.0.1
 */