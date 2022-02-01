package com.android.dx.rop.code;

import com.android.dx.rop.cst.CstString;
import com.android.dx.util.Hex;

public final class SourcePosition
{
  public static final SourcePosition NO_INFO = new SourcePosition(null, -1, -1);
  private final int address;
  private final int line;
  private final CstString sourceFile;
  
  public SourcePosition(CstString paramCstString, int paramInt1, int paramInt2)
  {
    if (paramInt1 < -1) {
      throw new IllegalArgumentException("address < -1");
    }
    if (paramInt2 < -1) {
      throw new IllegalArgumentException("line < -1");
    }
    this.sourceFile = paramCstString;
    this.address = paramInt1;
    this.line = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof SourcePosition)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this == paramObject);
      paramObject = (SourcePosition)paramObject;
      if (this.address != paramObject.address) {
        break;
      }
      bool1 = bool2;
    } while (sameLineAndFile(paramObject));
    return false;
  }
  
  public int getAddress()
  {
    return this.address;
  }
  
  public int getLine()
  {
    return this.line;
  }
  
  public CstString getSourceFile()
  {
    return this.sourceFile;
  }
  
  public int hashCode()
  {
    return this.sourceFile.hashCode() + this.address + this.line;
  }
  
  public boolean sameLine(SourcePosition paramSourcePosition)
  {
    return this.line == paramSourcePosition.line;
  }
  
  public boolean sameLineAndFile(SourcePosition paramSourcePosition)
  {
    return (this.line == paramSourcePosition.line) && ((this.sourceFile == paramSourcePosition.sourceFile) || ((this.sourceFile != null) && (this.sourceFile.equals(paramSourcePosition.sourceFile))));
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(50);
    if (this.sourceFile != null)
    {
      localStringBuffer.append(this.sourceFile.toHuman());
      localStringBuffer.append(":");
    }
    if (this.line >= 0) {
      localStringBuffer.append(this.line);
    }
    localStringBuffer.append('@');
    if (this.address < 0) {
      localStringBuffer.append("????");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(Hex.u2(this.address));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.SourcePosition
 * JD-Core Version:    0.7.0.1
 */