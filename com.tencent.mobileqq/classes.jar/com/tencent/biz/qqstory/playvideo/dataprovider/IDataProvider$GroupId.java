package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.utils.AssertUtils;

public class IDataProvider$GroupId
{
  public String b;
  public String c;
  
  public IDataProvider$GroupId(@NonNull String paramString)
  {
    this.b = paramString;
    AssertUtils.checkNotEmpty(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (GroupId)paramObject;
      String str = this.b;
      if (str != null) {
        return str.equals(paramObject.b);
      }
      return paramObject.b == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.b;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = this.c;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId
 * JD-Core Version:    0.7.0.1
 */