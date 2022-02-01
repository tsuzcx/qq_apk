package com.tencent.mm.vfs;

import java.io.OutputStreamWriter;

public class VFSFileWriter
  extends OutputStreamWriter
{
  public VFSFileWriter(VFSFile paramVFSFile)
  {
    super(VFSFileOp.openWrite(paramVFSFile.getUri(), paramVFSFile.resolve(), false));
  }
  
  public VFSFileWriter(VFSFile paramVFSFile, boolean paramBoolean)
  {
    super(VFSFileOp.openWrite(paramVFSFile.getUri(), paramVFSFile.resolve(), paramBoolean));
  }
  
  public VFSFileWriter(String paramString)
  {
    super(VFSFileOp.openWrite(paramString, false));
  }
  
  public VFSFileWriter(String paramString, boolean paramBoolean)
  {
    super(VFSFileOp.openWrite(paramString, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSFileWriter
 * JD-Core Version:    0.7.0.1
 */