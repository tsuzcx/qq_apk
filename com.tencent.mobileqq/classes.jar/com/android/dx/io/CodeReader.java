package com.android.dx.io;

import com.android.dx.io.instructions.DecodedInstruction;

public final class CodeReader
{
  private CodeReader.Visitor fallbackVisitor = null;
  private CodeReader.Visitor fieldVisitor = null;
  private CodeReader.Visitor methodVisitor = null;
  private CodeReader.Visitor stringVisitor = null;
  private CodeReader.Visitor typeVisitor = null;
  
  private void callVisit(DecodedInstruction[] paramArrayOfDecodedInstruction, DecodedInstruction paramDecodedInstruction)
  {
    CodeReader.Visitor localVisitor1 = null;
    switch (CodeReader.1.$SwitchMap$com$android$dx$io$IndexType[OpcodeInfo.getIndexType(paramDecodedInstruction.getOpcode()).ordinal()])
    {
    }
    for (;;)
    {
      CodeReader.Visitor localVisitor2 = localVisitor1;
      if (localVisitor1 == null) {
        localVisitor2 = this.fallbackVisitor;
      }
      if (localVisitor2 != null) {
        localVisitor2.visit(paramArrayOfDecodedInstruction, paramDecodedInstruction);
      }
      return;
      localVisitor1 = this.stringVisitor;
      continue;
      localVisitor1 = this.typeVisitor;
      continue;
      localVisitor1 = this.fieldVisitor;
      continue;
      localVisitor1 = this.methodVisitor;
    }
  }
  
  public void setAllVisitors(CodeReader.Visitor paramVisitor)
  {
    this.fallbackVisitor = paramVisitor;
    this.stringVisitor = paramVisitor;
    this.typeVisitor = paramVisitor;
    this.fieldVisitor = paramVisitor;
    this.methodVisitor = paramVisitor;
  }
  
  public void setFallbackVisitor(CodeReader.Visitor paramVisitor)
  {
    this.fallbackVisitor = paramVisitor;
  }
  
  public void setFieldVisitor(CodeReader.Visitor paramVisitor)
  {
    this.fieldVisitor = paramVisitor;
  }
  
  public void setMethodVisitor(CodeReader.Visitor paramVisitor)
  {
    this.methodVisitor = paramVisitor;
  }
  
  public void setStringVisitor(CodeReader.Visitor paramVisitor)
  {
    this.stringVisitor = paramVisitor;
  }
  
  public void setTypeVisitor(CodeReader.Visitor paramVisitor)
  {
    this.typeVisitor = paramVisitor;
  }
  
  public void visitAll(DecodedInstruction[] paramArrayOfDecodedInstruction)
  {
    int j = paramArrayOfDecodedInstruction.length;
    int i = 0;
    if (i < j)
    {
      DecodedInstruction localDecodedInstruction = paramArrayOfDecodedInstruction[i];
      if (localDecodedInstruction == null) {}
      for (;;)
      {
        i += 1;
        break;
        callVisit(paramArrayOfDecodedInstruction, localDecodedInstruction);
      }
    }
  }
  
  public void visitAll(short[] paramArrayOfShort)
  {
    visitAll(DecodedInstruction.decodeAll(paramArrayOfShort));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.CodeReader
 * JD-Core Version:    0.7.0.1
 */