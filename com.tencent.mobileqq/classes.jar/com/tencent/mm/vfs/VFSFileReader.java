package com.tencent.mm.vfs;

import java.io.InputStreamReader;

public class VFSFileReader
  extends InputStreamReader
{
  public VFSFileReader(VFSFile paramVFSFile)
  {
    super(VFSFileOp.openRead(paramVFSFile.getUri(), paramVFSFile.resolve()));
  }
  
  public VFSFileReader(String paramString)
  {
    super(VFSFileOp.openRead(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSFileReader
 * JD-Core Version:    0.7.0.1
 */