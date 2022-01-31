package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class MsgTabNodeRecommendActivityReadEntity
  extends Entity
{
  public static final int HAS_READ = 1;
  public static final String TABLE_NAME = MsgTabNodeRecommendActivityReadEntity.class.getSimpleName();
  public int hasRead;
  public int nodeType;
  @unique
  public String unionId;
  
  public MsgTabNodeRecommendActivityReadEntity() {}
  
  public MsgTabNodeRecommendActivityReadEntity(MsgTabNodeInfo paramMsgTabNodeInfo, int paramInt)
  {
    this.nodeType = paramMsgTabNodeInfo.jdField_a_of_type_Int;
    this.unionId = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
    this.hasRead = paramInt;
  }
  
  public String toString()
  {
    return "MsgTabNodeEntity{nodeType=" + this.nodeType + ", unionId='" + this.unionId + '\'' + ", hasRead='" + this.hasRead;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeRecommendActivityReadEntity
 * JD-Core Version:    0.7.0.1
 */