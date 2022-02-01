package com.android.multidex;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class ArchivePathElement$1$1
  implements Iterator<String>
{
  Enumeration<? extends ZipEntry> delegate = ArchivePathElement.access$000(this.this$1.this$0).entries();
  ZipEntry next = null;
  
  ArchivePathElement$1$1(ArchivePathElement.1 param1) {}
  
  public boolean hasNext()
  {
    while ((this.next == null) && (this.delegate.hasMoreElements()))
    {
      this.next = ((ZipEntry)this.delegate.nextElement());
      if (this.next.isDirectory()) {
        this.next = null;
      }
    }
    return this.next != null;
  }
  
  public String next()
  {
    if (hasNext())
    {
      String str = this.next.getName();
      this.next = null;
      return str;
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.multidex.ArchivePathElement.1.1
 * JD-Core Version:    0.7.0.1
 */