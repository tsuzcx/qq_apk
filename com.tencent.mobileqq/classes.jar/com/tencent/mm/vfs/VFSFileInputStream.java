package com.tencent.mm.vfs;

import java.io.FilterInputStream;

public class VFSFileInputStream
  extends FilterInputStream
{
  public VFSFileInputStream(VFSFile paramVFSFile)
  {
    super(VFSFileOp.openRead(paramVFSFile.getUri(), paramVFSFile.resolve()));
  }
  
  public VFSFileInputStream(String paramString)
  {
    super(VFSFileOp.openRead(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSFileInputStream
 * JD-Core Version:    0.7.0.1
 */