package com.tencent.biz.qqstory.shareGroup.infocard.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;

public class ShareGroupDateListPageLoader$CacheContext
{
  public int a;
  public long a;
  public String a;
  
  public ShareGroupDateListPageLoader$CacheContext(ShareGroupDateListPageLoader paramShareGroupDateListPageLoader, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    paramShareGroupDateListPageLoader = ((MemoryManager)SuperManager.a(19)).a(paramString);
    if (paramShareGroupDateListPageLoader != null) {
      a(paramShareGroupDateListPageLoader);
    }
  }
  
  public void a(@NonNull MemoryInfoEntry paramMemoryInfoEntry)
  {
    this.jdField_a_of_type_Long = paramMemoryInfoEntry.seq;
    this.jdField_a_of_type_JavaLangString = paramMemoryInfoEntry.cookie;
    this.jdField_a_of_type_Int = paramMemoryInfoEntry.timeZone;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDateListPageLoader.CacheContext
 * JD-Core Version:    0.7.0.1
 */