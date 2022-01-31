package com.tencent.mm.vfs;

class VFSUtils$FileSystemVersionException
  extends RuntimeException
{
  VFSUtils$FileSystemVersionException(Class<?> paramClass, int paramInt1, int paramInt2)
  {
    super("Version mismatch when unmarhelling " + paramClass.getName() + " (" + paramInt2 + " expected, " + paramInt1 + " got");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSUtils.FileSystemVersionException
 * JD-Core Version:    0.7.0.1
 */