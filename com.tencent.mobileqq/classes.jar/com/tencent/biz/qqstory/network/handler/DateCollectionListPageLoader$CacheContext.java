package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;

public class DateCollectionListPageLoader$CacheContext
{
  public long a;
  public String b = "";
  public int c;
  
  public DateCollectionListPageLoader$CacheContext(DateCollectionListPageLoader paramDateCollectionListPageLoader, String paramString)
  {
    paramDateCollectionListPageLoader = ((MemoryManager)SuperManager.a(19)).c(paramString);
    if (paramDateCollectionListPageLoader != null) {
      a(paramDateCollectionListPageLoader);
    }
  }
  
  public void a(@NonNull MemoryInfoEntry paramMemoryInfoEntry)
  {
    this.a = paramMemoryInfoEntry.seq;
    this.b = paramMemoryInfoEntry.cookie;
    this.c = paramMemoryInfoEntry.timeZone;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.CacheContext
 * JD-Core Version:    0.7.0.1
 */