package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.BaseEvent;
import java.util.ArrayList;
import java.util.List;

public class MemoryDataPuller$GetMemoryCollectionKeyEvent
  extends BaseEvent
{
  public List<String> a = new ArrayList();
  public ArrayList<String> b;
  public boolean c;
  public String d;
  
  public MemoryDataPuller$GetMemoryCollectionKeyEvent(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller.GetMemoryCollectionKeyEvent
 * JD-Core Version:    0.7.0.1
 */