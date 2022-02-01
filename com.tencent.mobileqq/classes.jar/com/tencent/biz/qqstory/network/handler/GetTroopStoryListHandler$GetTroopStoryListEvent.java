package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import java.util.ArrayList;
import java.util.List;

public class GetTroopStoryListHandler$GetTroopStoryListEvent
  extends BasePageLoaderEvent
{
  public List<TroopStoryItemInfo> e = new ArrayList();
  public boolean f = true;
  public int h;
  public int i;
  public boolean j;
  public boolean k;
  public String l;
  
  public GetTroopStoryListHandler$GetTroopStoryListEvent(String paramString, ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
    this.l = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetTroopStoryListEvent{isUpdated=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", troopStoryItemInfoList=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetTroopStoryListHandler.GetTroopStoryListEvent
 * JD-Core Version:    0.7.0.1
 */