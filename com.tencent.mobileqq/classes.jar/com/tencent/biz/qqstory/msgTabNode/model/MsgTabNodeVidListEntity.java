package com.tencent.biz.qqstory.msgTabNode.model;

import atmo;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import ssm;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="unionId,nodeType,requestSource")
public class MsgTabNodeVidListEntity
  extends atmo
{
  public int nodeType;
  public long reqTimeStamp;
  public int requestSource;
  public byte[] rspData;
  public String unionId;
  
  public static String[] getArgs(ssm paramssm)
  {
    int i = paramssm.jdField_a_of_type_Int;
    if (paramssm.jdField_a_of_type_JavaLangString == null) {}
    for (String str = "";; str = paramssm.jdField_a_of_type_JavaLangString) {
      return new String[] { String.valueOf(i), str, String.valueOf(paramssm.f) };
    }
  }
  
  public static String getSelection()
  {
    return "nodeType=? and unionId=? and requestSource=?";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListEntity
 * JD-Core Version:    0.7.0.1
 */