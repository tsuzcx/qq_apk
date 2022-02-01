package com.android.dx.dex.file;

class DebugInfoDecoder$LocalEntry
{
  public int address;
  public boolean isStart;
  public int nameIndex;
  public int reg;
  public int signatureIndex;
  public int typeIndex;
  
  public DebugInfoDecoder$LocalEntry(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.address = paramInt1;
    this.isStart = paramBoolean;
    this.reg = paramInt2;
    this.nameIndex = paramInt3;
    this.typeIndex = paramInt4;
    this.signatureIndex = paramInt5;
  }
  
  public String toString()
  {
    int i = this.address;
    if (this.isStart) {}
    for (String str = "start";; str = "end") {
      return String.format("[%x %s v%d %04x %04x %04x]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(this.reg), Integer.valueOf(this.nameIndex), Integer.valueOf(this.typeIndex), Integer.valueOf(this.signatureIndex) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.DebugInfoDecoder.LocalEntry
 * JD-Core Version:    0.7.0.1
 */