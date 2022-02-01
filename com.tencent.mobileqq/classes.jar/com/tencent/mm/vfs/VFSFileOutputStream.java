package com.tencent.mm.vfs;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class VFSFileOutputStream
  extends FilterOutputStream
{
  public VFSFileOutputStream(VFSFile paramVFSFile)
  {
    super(VFSFileOp.openWrite(paramVFSFile.getUri(), paramVFSFile.resolve(), false));
  }
  
  public VFSFileOutputStream(VFSFile paramVFSFile, boolean paramBoolean)
  {
    super(VFSFileOp.openWrite(paramVFSFile.getUri(), paramVFSFile.resolve(), paramBoolean));
  }
  
  public VFSFileOutputStream(String paramString)
  {
    super(VFSFileOp.openWrite(paramString, false));
  }
  
  public VFSFileOutputStream(String paramString, boolean paramBoolean)
  {
    super(VFSFileOp.openWrite(paramString, paramBoolean));
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSFileOutputStream
 * JD-Core Version:    0.7.0.1
 */