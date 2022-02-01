package com.android.dx.cf.attrib;

import com.android.dx.cf.code.LocalVariableList;
import com.android.dx.util.MutabilityException;

public abstract class BaseLocalVariables
  extends BaseAttribute
{
  private final LocalVariableList localVariables;
  
  public BaseLocalVariables(String paramString, LocalVariableList paramLocalVariableList)
  {
    super(paramString);
    try
    {
      if (paramLocalVariableList.isMutable()) {
        throw new MutabilityException("localVariables.isMutable()");
      }
    }
    catch (NullPointerException paramString)
    {
      throw new NullPointerException("localVariables == null");
    }
    this.localVariables = paramLocalVariableList;
  }
  
  public final int byteLength()
  {
    return this.localVariables.size() * 10 + 8;
  }
  
  public final LocalVariableList getLocalVariables()
  {
    return this.localVariables;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.BaseLocalVariables
 * JD-Core Version:    0.7.0.1
 */