package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.CstString;

public final class AttSourceFile
  extends BaseAttribute
{
  public static final String ATTRIBUTE_NAME = "SourceFile";
  private final CstString sourceFile;
  
  public AttSourceFile(CstString paramCstString)
  {
    super("SourceFile");
    if (paramCstString == null) {
      throw new NullPointerException("sourceFile == null");
    }
    this.sourceFile = paramCstString;
  }
  
  public int byteLength()
  {
    return 8;
  }
  
  public CstString getSourceFile()
  {
    return this.sourceFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.AttSourceFile
 * JD-Core Version:    0.7.0.1
 */