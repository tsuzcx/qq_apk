package com.tencent.hippy.qq.update.qarchive.tools.zip;

final class ZipOutputStream$CurrentEntry
{
  private long bytesRead = 0L;
  private boolean causedUseOfZip64 = false;
  private long dataStart = 0L;
  private final ZipEntry entry;
  private boolean hasWritten;
  private long localDataStart = 0L;
  
  private ZipOutputStream$CurrentEntry(ZipEntry paramZipEntry)
  {
    this.entry = paramZipEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipOutputStream.CurrentEntry
 * JD-Core Version:    0.7.0.1
 */