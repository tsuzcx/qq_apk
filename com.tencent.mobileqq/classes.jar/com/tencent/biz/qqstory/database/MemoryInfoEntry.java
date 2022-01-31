package com.tencent.biz.qqstory.database;

import android.text.TextUtils;
import atmo;
import atoc;
import sfp;

public class MemoryInfoEntry
  extends atmo
  implements sfp
{
  public String cookie = "";
  public int isEnd = -1;
  public int isFriend = -1;
  public long maxCollectionIndex = -1L;
  public long seq = -1L;
  public int timeZone = -1;
  @atoc
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
      if (paramObject.maxCollectionIndex != -1L) {
        this.maxCollectionIndex = paramObject.maxCollectionIndex;
      }
      if (paramObject.seq != -1L) {
        this.seq = paramObject.seq;
      }
      if (paramObject.timeZone != -1) {
        this.timeZone = paramObject.timeZone;
      }
      if (!TextUtils.isEmpty(paramObject.cookie)) {
        this.cookie = paramObject.cookie;
      }
      if (paramObject.isEnd != -1) {
        this.isEnd = paramObject.isEnd;
      }
      if (paramObject.isFriend != -1) {
        this.isFriend = paramObject.isFriend;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.MemoryInfoEntry
 * JD-Core Version:    0.7.0.1
 */