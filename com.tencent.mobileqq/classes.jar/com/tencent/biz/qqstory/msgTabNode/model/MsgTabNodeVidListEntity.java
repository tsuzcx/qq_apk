package com.tencent.biz.qqstory.msgTabNode.model;

import awbv;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import utx;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="unionId,nodeType,requestSource")
public class MsgTabNodeVidListEntity
  extends awbv
{
  public int nodeType;
  public long reqTimeStamp;
  public int requestSource;
  public byte[] rspData;
  public String unionId;
  
  public static String[] getArgs(utx paramutx)
  {
    int i = paramutx.jdField_a_of_type_Int;
    if (paramutx.jdField_a_of_type_JavaLangString == null) {}
    for (String str = "";; str = paramutx.jdField_a_of_type_JavaLangString) {
      return new String[] { String.valueOf(i), str, String.valueOf(paramutx.f) };
    }
  }
  
  public static String getSelection()
  {
    return "nodeType=? and unionId=? and requestSource=?";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListEntity
 * JD-Core Version:    0.7.0.1
 */