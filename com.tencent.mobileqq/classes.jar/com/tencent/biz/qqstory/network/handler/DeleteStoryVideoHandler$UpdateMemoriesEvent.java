package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import java.util.ArrayList;

public class DeleteStoryVideoHandler$UpdateMemoriesEvent
  extends BaseEvent
{
  public ArrayList<DeleteStoryVideoHandler.StateVideoCollectionItem> a = new ArrayList();
  public final int b;
  
  public DeleteStoryVideoHandler$UpdateMemoriesEvent(int paramInt)
  {
    this.b = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpdateMemoriesEvent{dateList=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", source=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler.UpdateMemoriesEvent
 * JD-Core Version:    0.7.0.1
 */