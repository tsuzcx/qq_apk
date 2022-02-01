package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.Comparator;
import java.util.Map;

class ZipFile$2
  implements Comparator<ZipEntry>
{
  ZipFile$2(ZipFile paramZipFile) {}
  
  public int compare(ZipEntry paramZipEntry1, ZipEntry paramZipEntry2)
  {
    if (paramZipEntry1 == paramZipEntry2) {
      return 0;
    }
    paramZipEntry1 = (ZipFile.OffsetEntry)ZipFile.access$700(this.this$0).get(paramZipEntry1);
    paramZipEntry2 = (ZipFile.OffsetEntry)ZipFile.access$700(this.this$0).get(paramZipEntry2);
    if (paramZipEntry1 == null) {
      return 1;
    }
    if (paramZipEntry2 == null) {
      return -1;
    }
    long l = ZipFile.OffsetEntry.access$200(paramZipEntry1) - ZipFile.OffsetEntry.access$200(paramZipEntry2);
    if (l == 0L) {
      return 0;
    }
    if (l < 0L) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipFile.2
 * JD-Core Version:    0.7.0.1
 */