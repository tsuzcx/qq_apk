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
    if (this.a.a == null) {
      this.a.a = new ShareGroupDateListPageLoader.CacheContext(this.a, this.a.d);
    }
    this.a.e = this.a.a.a;
    ShareGroupDateListPageLoader.a(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDateListPageLoader.2
 * JD-Core Version:    0.7.0.1
 */