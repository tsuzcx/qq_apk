package com.android.dx.cf.iface;

import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.TypeList;

public abstract interface ClassFile
  extends HasAttribute
{
  public abstract int getAccessFlags();
  
  public abstract AttributeList getAttributes();
  
  public abstract ConstantPool getConstantPool();
  
  public abstract FieldList getFields();
  
  public abstract TypeList getInterfaces();
  
  public abstract int getMagic();
  
  public abstract int getMajorVersion();
  
  public abstract MethodList getMethods();
  
  public abstract int getMinorVersion();
  
  public abstract CstString getSourceFile();
  
  public abstract CstType getSuperclass();
  
  public abstract CstType getThisClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.iface.ClassFile
 * JD-Core Version:    0.7.0.1
 */