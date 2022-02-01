package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;

public class DateCollectionListPageLoader$CacheContext
{
  public int a;
  public long a;
  public String a;
  
  public DateCollectionListPageLoader$CacheContext(DateCollectionListPageLoader paramDateCollectionListPageLoader, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    paramDateCollectionListPageLoader = ((MemoryManager)SuperManager.a(19)).a(paramString);
    if (paramDateCollectionListPageLoader != null) {
      a(paramDateCollectionListPageLoader);
    }
  }
  
  public void a(@NonNull MemoryInfoEntry paramMemoryInfoEntry)
  {
    this.jdField_a_of_type_Long = paramMemoryInfoEntry.seq;
    this.jdField_a_of_type_JavaLangString = paramMemoryInfoEntry.cookie;
    this.jdField_a_of_type_Int = paramMemoryInfoEntry.timeZone;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.CacheContext
 * JD-Core Version:    0.7.0.1
 */