package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import java.util.ArrayList;

public class GetHotSortVideoHandler$GetVideoByHotSortEvent
  extends BaseEvent
{
  public ArrayList<HotSortVideoEntry> a;
  public boolean a;
  public boolean b = false;
  public boolean c = false;
  
  public String toString()
  {
    return " GetVideoByHotSortEvent " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetVideoByHotSortEvent
 * JD-Core Version:    0.7.0.1
 */