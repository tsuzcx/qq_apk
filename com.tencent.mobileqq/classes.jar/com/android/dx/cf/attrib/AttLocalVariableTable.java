package com.android.dx.cf.attrib;

import com.android.dx.cf.code.LocalVariableList;

public final class AttLocalVariableTable
  extends BaseLocalVariables
{
  public static final String ATTRIBUTE_NAME = "LocalVariableTable";
  
  public AttLocalVariableTable(LocalVariableList paramLocalVariableList)
  {
    super("LocalVariableTable", paramLocalVariableList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.AttLocalVariableTable
 * JD-Core Version:    0.7.0.1
 */