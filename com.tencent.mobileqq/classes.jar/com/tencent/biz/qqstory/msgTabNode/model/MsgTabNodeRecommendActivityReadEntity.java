package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="unionId,nodeType")
public class MsgTabNodeRecommendActivityReadEntity
  extends Entity
{
  public static final int HAS_READ = 1;
  public static final String TABLE_NAME = "MsgTabNodeRecommendActivityReadEntity";
  public int hasRead;
  public int nodeType;
  public String unionId;
  
  public MsgTabNodeRecommendActivityReadEntity() {}
  
  public MsgTabNodeRecommendActivityReadEntity(MsgTabNodeInfo paramMsgTabNodeInfo, int paramInt)
  {
    this.nodeType = paramMsgTabNodeInfo.jdField_a_of_type_Int;
    this.unionId = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
    this.hasRead = paramInt;
  }
  
  public static String[] getArgs(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i = paramMsgTabNodeInfo.jdField_a_of_type_Int;
    if (paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString == null) {
      paramMsgTabNodeInfo = "";
    } else {
      paramMsgTabNodeInfo = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
    }
    return new String[] { String.valueOf(i), paramMsgTabNodeInfo };
  }
  
  public static String getSelection()
  {
    return "nodeType=? and unionId=?";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgTabNodeEntity{nodeType=");
    localStringBuilder.append(this.nodeType);
    localStringBuilder.append(", unionId='");
    localStringBuilder.append(this.unionId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hasRead='");
    localStringBuilder.append(this.hasRead);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeRecommendActivityReadEntity
 * JD-Core Version:    0.7.0.1
 */