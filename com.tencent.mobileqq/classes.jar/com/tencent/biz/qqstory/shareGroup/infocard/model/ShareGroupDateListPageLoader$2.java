package com.tencent.biz.qqstory.shareGroup.infocard.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class ShareGroupDateListPageLoader$2
  extends SimpleJob<Object>
{
  ShareGroupDateListPageLoader$2(ShareGroupDateListPageLoader paramShareGroupDateListPageLoader, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (this.a.a == null)
    {
      paramJobContext = this.a;
      paramJobContext.a = new ShareGroupDateListPageLoader.CacheContext(paramJobContext, paramJobContext.d);
    }
    paramJobContext = this.a;
    paramJobContext.e = paramJobContext.a.a;
    ShareGroupDateListPageLoader.a(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDateListPageLoader.2
 * JD-Core Version:    0.7.0.1
 */