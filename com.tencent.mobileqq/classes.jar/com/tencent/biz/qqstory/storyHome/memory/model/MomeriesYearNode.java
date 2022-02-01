package com.tencent.biz.qqstory.storyHome.memory.model;

import com.tencent.biz.qqstory.database.MemoriesYearNodeEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.YearNodeInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import wev;

public class MomeriesYearNode
  extends BaseUIItem
  implements wev
{
  public int videoCount;
  public int year;
  
  public void convertFrom() {}
  
  public void convertFrom(MemoriesYearNodeEntry paramMemoriesYearNodeEntry)
  {
    this.year = paramMemoriesYearNodeEntry.year;
    this.videoCount = paramMemoriesYearNodeEntry.videoCount;
  }
  
  public void convertFrom(qqstory_struct.YearNodeInfo paramYearNodeInfo)
  {
    this.year = paramYearNodeInfo.year.get();
    this.videoCount = paramYearNodeInfo.video_total_count.get();
  }
  
  public MemoriesYearNodeEntry convertTo()
  {
    MemoriesYearNodeEntry localMemoriesYearNodeEntry = new MemoriesYearNodeEntry();
    localMemoriesYearNodeEntry.year = this.year;
    localMemoriesYearNodeEntry.videoCount = this.videoCount;
    return localMemoriesYearNodeEntry;
  }
  
  public void copy(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (MomeriesYearNode)paramObject;
    this.year = paramObject.year;
    this.videoCount = paramObject.videoCount;
  }
  
  public String toString()
  {
    return "MomeriesYearNode{year=" + this.year + ", videoCount=" + this.videoCount + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode
 * JD-Core Version:    0.7.0.1
 */