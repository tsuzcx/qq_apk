package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstLiteral32;
import com.android.dx.rop.cst.CstLiteral64;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.ArrayList;

public final class ArrayData
  extends VariableSizeInsn
{
  private final Constant arrayType;
  private final int elemWidth;
  private final int initLength;
  private final CodeAddress user;
  private final ArrayList<Constant> values;
  
  public ArrayData(SourcePosition paramSourcePosition, CodeAddress paramCodeAddress, ArrayList<Constant> paramArrayList, Constant paramConstant)
  {
    super(paramSourcePosition, RegisterSpecList.EMPTY);
    if (paramCodeAddress == null) {
      throw new NullPointerException("user == null");
    }
    if (paramArrayList == null) {
      throw new NullPointerException("values == null");
    }
    if (paramArrayList.size() <= 0) {
      throw new IllegalArgumentException("Illegal number of init values");
    }
    this.arrayType = paramConstant;
    if ((paramConstant == CstType.BYTE_ARRAY) || (paramConstant == CstType.BOOLEAN_ARRAY)) {
      this.elemWidth = 1;
    }
    for (;;)
    {
      this.user = paramCodeAddress;
      this.values = paramArrayList;
      this.initLength = paramArrayList.size();
      return;
      if ((paramConstant == CstType.SHORT_ARRAY) || (paramConstant == CstType.CHAR_ARRAY))
      {
        this.elemWidth = 2;
      }
      else if ((paramConstant == CstType.INT_ARRAY) || (paramConstant == CstType.FLOAT_ARRAY))
      {
        this.elemWidth = 4;
      }
      else
      {
        if ((paramConstant != CstType.LONG_ARRAY) && (paramConstant != CstType.DOUBLE_ARRAY)) {
          break;
        }
        this.elemWidth = 8;
      }
    }
    throw new IllegalArgumentException("Unexpected constant type");
  }
  
  protected String argString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    int j = this.values.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append("\n    ");
      localStringBuffer.append(i);
      localStringBuffer.append(": ");
      localStringBuffer.append(((Constant)this.values.get(i)).toHuman());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public int codeSize()
  {
    return (this.initLength * this.elemWidth + 1) / 2 + 4;
  }
  
  protected String listingString0(boolean paramBoolean)
  {
    int i = this.user.getAddress();
    StringBuffer localStringBuffer = new StringBuffer(100);
    int j = this.values.size();
    localStringBuffer.append("fill-array-data-payload // for fill-array-data @ ");
    localStringBuffer.append(Hex.u2(i));
    i = 0;
    while (i < j)
    {
      localStringBuffer.append("\n  ");
      localStringBuffer.append(i);
      localStringBuffer.append(": ");
      localStringBuffer.append(((Constant)this.values.get(i)).toHuman());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public DalvInsn withRegisters(RegisterSpecList paramRegisterSpecList)
  {
    return new ArrayData(getPosition(), this.user, this.values, this.arrayType);
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput)
  {
    int j = this.values.size();
    paramAnnotatedOutput.writeShort(768);
    paramAnnotatedOutput.writeShort(this.elemWidth);
    paramAnnotatedOutput.writeInt(this.initLength);
    switch (this.elemWidth)
    {
    }
    for (;;)
    {
      if ((this.elemWidth == 1) && (j % 2 != 0)) {
        paramAnnotatedOutput.writeByte(0);
      }
      return;
      int i = 0;
      while (i < j)
      {
        paramAnnotatedOutput.writeByte((byte)((CstLiteral32)this.values.get(i)).getIntBits());
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        paramAnnotatedOutput.writeShort((short)((CstLiteral32)this.values.get(i)).getIntBits());
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        paramAnnotatedOutput.writeInt(((CstLiteral32)this.values.get(i)).getIntBits());
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        paramAnnotatedOutput.writeLong(((CstLiteral64)this.values.get(i)).getLongBits());
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.ArrayData
 * JD-Core Version:    0.7.0.1
 */