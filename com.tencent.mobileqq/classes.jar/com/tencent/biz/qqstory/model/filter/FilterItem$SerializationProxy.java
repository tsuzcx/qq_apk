package com.tencent.biz.qqstory.model.filter;

import android.support.annotation.NonNull;
import java.io.Serializable;

class FilterItem$SerializationProxy
  implements Serializable
{
  private static final long serialVersionUID = 2L;
  public final String filterConfigMd5;
  public final String filterConfigUrl;
  public final long filterId;
  @NonNull
  public final String filterName;
  public final int filterType;
  
  private FilterItem$SerializationProxy(@NonNull FilterItem paramFilterItem)
  {
    this.filterId = paramFilterItem.filterId;
    this.filterName = paramFilterItem.filterName;
    this.filterType = paramFilterItem.filterType;
    this.filterConfigUrl = paramFilterItem.filterConfigUrl;
    this.filterConfigMd5 = paramFilterItem.filterConfigMd5;
  }
  
  private Object readResolve()
  {
    return new FilterItem(this.filterId, this.filterName, this.filterType, this.filterConfigUrl, this.filterConfigMd5, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.FilterItem.SerializationProxy
 * JD-Core Version:    0.7.0.1
 */