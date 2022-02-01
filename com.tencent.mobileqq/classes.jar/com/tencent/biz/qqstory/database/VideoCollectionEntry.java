package com.tencent.biz.qqstory.database;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class VideoCollectionEntry
  extends Entity
{
  public String address;
  public int collectionCount;
  public String collectionId;
  public long collectionTime;
  public int collectionType;
  public long dbIndex;
  public String feedId;
  public String groupId;
  public int hasShareToDiscover;
  @unique
  public String key;
  public String label;
  public String nextCookie;
  public String unionId;
  public int viewCount;
  public int viewTimes;
  
  public static int getCollectionId(String paramString)
  {
    String[] arrayOfString = paramString.split("_");
    try
    {
      int i = Integer.valueOf(arrayOfString[1]).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label19:
      break label19;
    }
    SLog.e("VideoCollectionEntry", "NumberFormatException while getCollectionId. collectionKey is %s,", new Object[] { paramString });
    return -1;
  }
  
  public static String getCollectionKey(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static int getCollectionType(String paramString)
  {
    return Integer.valueOf(paramString.split("_")[0]).intValue();
  }
  
  public static String getKeySelectionNoArgs()
  {
    return "key=?";
  }
  
  public static String getQueryListSql()
  {
    return "unionId=? and dbIndex > ?";
  }
  
  public static String getUinSelectionNoArgs()
  {
    return "unionId=?";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.VideoCollectionEntry
 * JD-Core Version:    0.7.0.1
 */