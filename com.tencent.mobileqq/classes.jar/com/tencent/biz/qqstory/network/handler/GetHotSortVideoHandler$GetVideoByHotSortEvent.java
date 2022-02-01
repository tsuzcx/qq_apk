package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import java.util.ArrayList;

public class GetHotSortVideoHandler$GetVideoByHotSortEvent
  extends BaseEvent
{
  public ArrayList<HotSortVideoEntry> a;
  public boolean b;
  public boolean c = false;
  public boolean d = false;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" GetVideoByHotSortEvent ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetVideoByHotSortEvent
 * JD-Core Version:    0.7.0.1
 */