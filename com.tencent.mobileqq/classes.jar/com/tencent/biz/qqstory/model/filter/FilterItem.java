package com.tencent.biz.qqstory.model.filter;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class FilterItem
  implements Serializable
{
  public static final int TYPE_BLACK = 5;
  public static final int TYPE_COLD = 4;
  public static final int TYPE_FAST = 0;
  public static final int TYPE_LITTLE_FAST = 11;
  public static final int TYPE_LOCATION = 7;
  public static final int TYPE_LOMO = 3;
  public static final int TYPE_NONE = -1;
  public static final int TYPE_PICTURE = 10;
  public static final int TYPE_REVERT = 2;
  public static final int TYPE_SLOW = 1;
  public static final int TYPE_SPEED = 8;
  public static final int TYPE_TEMP = 9;
  public static final int TYPE_TIME = 6;
  public static final int TYPE_VERY_SLOW = 12;
  public final String filterConfigMd5;
  public final String filterConfigUrl;
  public final long filterId;
  @NonNull
  public final String filterName;
  public final int filterType;
  
  private FilterItem(long paramLong, @NonNull String paramString1, int paramInt, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      paramString1 = new StringBuilder();
      paramString1.append("illegal filter type : ");
      paramString1.append(paramInt);
      paramString1.append(" from id : ");
      paramString1.append(paramLong);
      throw new IllegalArgumentException(paramString1.toString());
    case 10: 
      if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
      {
        paramString1 = new StringBuilder();
        paramString1.append("can not find url or md5 : type=");
        paramString1.append(paramInt);
        paramString1.append(", url=");
        paramString1.append(paramString2);
        paramString1.append(", md5=");
        paramString1.append(paramString3);
        paramString1.append(" from id : ");
        paramString1.append(paramLong);
        throw new IllegalArgumentException(paramString1.toString());
      }
      break;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramLong >= 0L)
      {
        this.filterId = paramLong;
        this.filterName = paramString1;
        this.filterType = paramInt;
        this.filterConfigUrl = paramString2;
        this.filterConfigMd5 = paramString3;
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("filter id should not less than zero : ");
      paramString1.append(paramLong);
      throw new IllegalArgumentException(paramString1.toString());
    }
    throw new IllegalArgumentException("filter name should not be empty");
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    throw new InvalidObjectException("proxy required");
  }
  
  private Object writeReplace()
  {
    return new FilterItem.SerializationProxy(this, null);
  }
  
  public boolean isLocalType()
  {
    switch (this.filterType)
    {
    case 8: 
    default: 
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilterItem{id=");
    localStringBuilder.append(this.filterId);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.filterName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.filterType);
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.filterConfigUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.filterConfigMd5);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.FilterItem
 * JD-Core Version:    0.7.0.1
 */