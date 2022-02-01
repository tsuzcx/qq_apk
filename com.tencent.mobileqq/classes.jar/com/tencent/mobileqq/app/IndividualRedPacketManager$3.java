package com.tencent.mobileqq.app;

import java.io.File;
import java.util.Comparator;

class IndividualRedPacketManager$3
  implements Comparator<File>
{
  IndividualRedPacketManager$3(IndividualRedPacketManager paramIndividualRedPacketManager) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    long l2 = 0L;
    long l1;
    if (paramFile1 != null) {
      l1 = paramFile1.lastModified();
    } else {
      l1 = 0L;
    }
    if (paramFile2 != null) {
      l2 = paramFile2.lastModified();
    }
    if (l2 < l1) {
      return -1;
    }
    if (l2 > l1) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.3
 * JD-Core Version:    0.7.0.1
 */