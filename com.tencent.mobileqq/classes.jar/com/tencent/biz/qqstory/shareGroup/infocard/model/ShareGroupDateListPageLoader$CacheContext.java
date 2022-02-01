package com.tencent.biz.qqstory.shareGroup.infocard.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;

public class ShareGroupDateListPageLoader$CacheContext
{
  public long a;
  public String b = "";
  public int c;
  
  public ShareGroupDateListPageLoader$CacheContext(ShareGroupDateListPageLoader paramShareGroupDateListPageLoader, String paramString)
  {
    paramShareGroupDateListPageLoader = ((MemoryManager)SuperManager.a(19)).c(paramString);
    if (paramShareGroupDateListPageLoader != null) {
      a(paramShareGroupDateListPageLoader);
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
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDateListPageLoader.CacheContext
 * JD-Core Version:    0.7.0.1
 */