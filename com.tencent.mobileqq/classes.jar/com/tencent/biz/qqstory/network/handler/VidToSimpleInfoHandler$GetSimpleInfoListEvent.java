package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import java.util.ArrayList;
import java.util.List;

public class VidToSimpleInfoHandler$GetSimpleInfoListEvent
  extends BaseEvent
{
  public String a;
  public List a;
  
  public VidToSimpleInfoHandler$GetSimpleInfoListEvent()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String toString()
  {
    return super.toString() + " collectionId=" + this.jdField_a_of_type_JavaLangString + "mSimpleInfoList.size=" + this.jdField_a_of_type_JavaUtilList.size() + "mSimpleInfoList=" + this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler.GetSimpleInfoListEvent
 * JD-Core Version:    0.7.0.1
 */