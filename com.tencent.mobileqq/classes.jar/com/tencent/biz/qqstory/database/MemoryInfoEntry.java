package com.tencent.biz.qqstory.database;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class MemoryInfoEntry
  extends Entity
  implements Copyable
{
  public String cookie = "";
  public int isEnd = -1;
  public int isFriend = -1;
  public long maxCollectionIndex = -1L;
  public long seq = -1L;
  public int timeZone = -1;
  @unique
  public String unionId = "";
  
  public MemoryInfoEntry() {}
  
  public MemoryInfoEntry(String paramString)
  {
    this.unionId = paramString;
  }
  
  public static String getUnionIdSelectionNoArg()
  {
    return "unionId=?";
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof MemoryInfoEntry))
    {
      paramObject = (MemoryInfoEntry)paramObject;
      if (!TextUtils.isEmpty(paramObject.unionId)) {
        this.unionId = paramObject.unionId;
      }
      long l = paramObject.maxCollectionIndex;
      if (l != -1L) {
        this.maxCollectionIndex = l;
      }
      l = paramObject.seq;
      if (l != -1L) {
        this.seq = l;
      }
      int i = paramObject.timeZone;
      if (i != -1) {
        this.timeZone = i;
      }
      if (!TextUtils.isEmpty(paramObject.cookie)) {
        this.cookie = paramObject.cookie;
      }
      i = paramObject.isEnd;
      if (i != -1) {
        this.isEnd = i;
      }
      i = paramObject.isFriend;
      if (i != -1) {
        this.isFriend = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.MemoryInfoEntry
 * JD-Core Version:    0.7.0.1
 */