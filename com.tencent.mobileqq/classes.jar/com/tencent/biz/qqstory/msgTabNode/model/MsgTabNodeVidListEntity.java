package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="unionId,nodeType,requestSource")
public class MsgTabNodeVidListEntity
  extends Entity
{
  public int nodeType;
  public long reqTimeStamp;
  public int requestSource;
  public byte[] rspData;
  public String unionId;
  
  public static String[] getArgs(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i = paramMsgTabNodeInfo.b;
    String str;
    if (paramMsgTabNodeInfo.d == null) {
      str = "";
    } else {
      str = paramMsgTabNodeInfo.d;
    }
    return new String[] { String.valueOf(i), str, String.valueOf(paramMsgTabNodeInfo.w) };
  }
  
  public static String getSelection()
  {
    return "nodeType=? and unionId=? and requestSource=?";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListEntity
 * JD-Core Version:    0.7.0.1
 */