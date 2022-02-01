package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.ShareGroupCollectionItem;
import java.util.ArrayList;
import java.util.List;

public class ShareGroupPageLoader$GetShareGroupListEvent
  extends BasePageLoaderEvent
{
  public List<ShareGroupCollectionItem> e = new ArrayList();
  public int f;
  public String h;
  
  public ShareGroupPageLoader$GetShareGroupListEvent(ErrorMessage paramErrorMessage, String paramString)
  {
    super(paramErrorMessage);
    this.h = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetShareGroupListEvent{mShareGroupList=");
    localStringBuilder.append(this.e.size());
    localStringBuilder.append(", mShareGroupTotalCount=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.g.errorCode);
    localStringBuilder.append(", isLocalData=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isFirstPage=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isEnd=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.GetShareGroupListEvent
 * JD-Core Version:    0.7.0.1
 */