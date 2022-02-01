package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import java.util.ArrayList;
import java.util.List;

public class DateCollectionListPageLoader$GetCollectionListEvent
  extends BasePageLoaderEvent
{
  public List<VideoCollectionItem> e = new ArrayList();
  public int f = -1;
  public boolean h = true;
  public String i;
  public String j;
  
  public DateCollectionListPageLoader$GetCollectionListEvent(String paramString, ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
    this.i = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetCollectionListEvent{isEnd=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", isUpdated=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", isLocalData=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isFirstPage=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isRefreshFromLoadMore=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", collectionList=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", totalVideoCount=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", context='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent
 * JD-Core Version:    0.7.0.1
 */