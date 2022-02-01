package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class DateCollectionListPageLoader$1
  extends SimpleJob<Object>
{
  DateCollectionListPageLoader$1(DateCollectionListPageLoader paramDateCollectionListPageLoader, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (this.a.a == null) {
      this.a.a = new DateCollectionListPageLoader.CacheContext(this.a, this.a.e);
    }
    this.a.b = "";
    DateCollectionListPageLoader.a(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */