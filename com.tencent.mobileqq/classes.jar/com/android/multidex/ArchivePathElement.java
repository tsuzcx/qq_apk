package com.android.multidex;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class ArchivePathElement
  implements ClassPathElement
{
  private final ZipFile archive;
  
  public ArchivePathElement(ZipFile paramZipFile)
  {
    this.archive = paramZipFile;
  }
  
  public void close()
  {
    this.archive.close();
  }
  
  public Iterable<String> list()
  {
    return new ArchivePathElement.1(this);
  }
  
  public InputStream open(String paramString)
  {
    ZipEntry localZipEntry = this.archive.getEntry(paramString);
    if (localZipEntry == null) {
      throw new FileNotFoundException("File \"" + paramString + "\" not found");
    }
    if (localZipEntry.isDirectory()) {
      throw new ArchivePathElement.DirectoryEntryException();
    }
    return this.archive.getInputStream(localZipEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.multidex.ArchivePathElement
 * JD-Core Version:    0.7.0.1
 */