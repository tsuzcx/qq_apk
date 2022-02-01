package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.BasePageLoaderEvent;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import java.util.ArrayList;
import java.util.List;

public class GetTroopStoryListHandler$GetTroopStoryListEvent
  extends BasePageLoaderEvent
{
  public int a;
  public String a;
  public List<TroopStoryItemInfo> a;
  public int b;
  public boolean e = true;
  public boolean f;
  public boolean g;
  
  public GetTroopStoryListHandler$GetTroopStoryListEvent(String paramString, ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "GetTroopStoryListEvent{isUpdated=" + this.e + ", troopStoryItemInfoList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetTroopStoryListHandler.GetTroopStoryListEvent
 * JD-Core Version:    0.7.0.1
 */