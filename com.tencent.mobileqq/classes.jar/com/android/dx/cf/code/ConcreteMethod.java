package com.android.dx.cf.code;

import com.android.dx.cf.attrib.AttCode;
import com.android.dx.cf.attrib.AttLineNumberTable;
import com.android.dx.cf.attrib.AttLocalVariableTable;
import com.android.dx.cf.attrib.AttLocalVariableTypeTable;
import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.ClassFile;
import com.android.dx.cf.iface.Method;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;

public final class ConcreteMethod
  implements Method
{
  private final boolean accSuper;
  private final AttCode attCode;
  private final LineNumberList lineNumbers;
  private final LocalVariableList localVariables;
  private final Method method;
  private final CstString sourceFile;
  
  public ConcreteMethod(Method paramMethod, int paramInt, CstString paramCstString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.method = paramMethod;
    if ((paramInt & 0x20) != 0) {}
    AttributeList localAttributeList;
    for (boolean bool = true;; bool = false)
    {
      this.accSuper = bool;
      this.sourceFile = paramCstString;
      this.attCode = ((AttCode)paramMethod.getAttributes().findFirst("Code"));
      localAttributeList = this.attCode.getAttributes();
      paramMethod = LineNumberList.EMPTY;
      if (!paramBoolean1) {
        break;
      }
      for (paramCstString = (AttLineNumberTable)localAttributeList.findFirst("LineNumberTable");; paramCstString = (AttLineNumberTable)localAttributeList.findNext(paramCstString))
      {
        localObject = paramMethod;
        if (paramCstString == null) {
          break;
        }
        paramMethod = LineNumberList.concat(paramMethod, paramCstString.getLineNumbers());
      }
    }
    Object localObject = paramMethod;
    this.lineNumbers = ((LineNumberList)localObject);
    paramMethod = LocalVariableList.EMPTY;
    paramCstString = paramMethod;
    if (paramBoolean2)
    {
      for (paramCstString = (AttLocalVariableTable)localAttributeList.findFirst("LocalVariableTable"); paramCstString != null; paramCstString = (AttLocalVariableTable)localAttributeList.findNext(paramCstString)) {
        paramMethod = LocalVariableList.concat(paramMethod, paramCstString.getLocalVariables());
      }
      localObject = LocalVariableList.EMPTY;
      for (paramCstString = (AttLocalVariableTypeTable)localAttributeList.findFirst("LocalVariableTypeTable"); paramCstString != null; paramCstString = (AttLocalVariableTypeTable)localAttributeList.findNext(paramCstString)) {
        localObject = LocalVariableList.concat((LocalVariableList)localObject, paramCstString.getLocalVariables());
      }
      paramCstString = paramMethod;
      if (((LocalVariableList)localObject).size() == 0) {}
    }
    for (paramMethod = LocalVariableList.mergeDescriptorsAndSignatures(paramMethod, (LocalVariableList)localObject);; paramMethod = paramCstString)
    {
      this.localVariables = paramMethod;
      return;
    }
  }
  
  public ConcreteMethod(Method paramMethod, ClassFile paramClassFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramMethod, paramClassFile.getAccessFlags(), paramClassFile.getSourceFile(), paramBoolean1, paramBoolean2);
  }
  
  public boolean getAccSuper()
  {
    return this.accSuper;
  }
  
  public int getAccessFlags()
  {
    return this.method.getAccessFlags();
  }
  
  public AttributeList getAttributes()
  {
    return this.method.getAttributes();
  }
  
  public ByteCatchList getCatches()
  {
    return this.attCode.getCatches();
  }
  
  public BytecodeArray getCode()
  {
    return this.attCode.getCode();
  }
  
  public CstType getDefiningClass()
  {
    return this.method.getDefiningClass();
  }
  
  public CstString getDescriptor()
  {
    return this.method.getDescriptor();
  }
  
  public Prototype getEffectiveDescriptor()
  {
    return this.method.getEffectiveDescriptor();
  }
  
  public LineNumberList getLineNumbers()
  {
    return this.lineNumbers;
  }
  
  public LocalVariableList getLocalVariables()
  {
    return this.localVariables;
  }
  
  public int getMaxLocals()
  {
    return this.attCode.getMaxLocals();
  }
  
  public int getMaxStack()
  {
    return this.attCode.getMaxStack();
  }
  
  public CstString getName()
  {
    return this.method.getName();
  }
  
  public CstNat getNat()
  {
    return this.method.getNat();
  }
  
  public SourcePosition makeSourcePosistion(int paramInt)
  {
    return new SourcePosition(this.sourceFile, paramInt, this.lineNumbers.pcToLine(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.ConcreteMethod
 * JD-Core Version:    0.7.0.1
 */