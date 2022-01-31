package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class MsgTabNodeVidListEntity
  extends Entity
{
  public int nodeType;
  public long reqTimeStamp;
  public byte[] rspData;
  @unique
  public String unionId;
  
  public static String[] getArgs(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i = paramMsgTabNodeInfo.jdField_a_of_type_Int;
    if (paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString == null) {}
    for (paramMsgTabNodeInfo = "";; paramMsgTabNodeInfo = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString) {
      return new String[] { String.valueOf(i), paramMsgTabNodeInfo };
    }
  }
  
  public static String getSelection()
  {
    return "nodeType=? and unionId=?";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListEntity
 * JD-Core Version:    0.7.0.1
 */