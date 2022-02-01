package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.utils.AssertUtils;

public class IDataProvider$GroupId
{
  public String a;
  public String b;
  
  public IDataProvider$GroupId(@NonNull String paramString)
  {
    this.a = paramString;
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
      String str = this.a;
      if (str != null) {
        return str.equals(paramObject.a);
      }
      return paramObject.a == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.a;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = this.b;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId
 * JD-Core Version:    0.7.0.1
 */