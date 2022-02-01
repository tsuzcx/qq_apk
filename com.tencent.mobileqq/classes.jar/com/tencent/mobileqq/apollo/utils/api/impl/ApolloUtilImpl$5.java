package com.tencent.mobileqq.apollo.utils.api.impl;

import java.io.File;
import java.util.Comparator;

final class ApolloUtilImpl$5
  implements Comparator<File>
{
  public int a(File paramFile1, File paramFile2)
  {
    if ((paramFile1.exists()) && (paramFile2.exists()))
    {
      if (paramFile1.lastModified() - paramFile2.lastModified() > 0L) {
        return 1;
      }
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl.5
 * JD-Core Version:    0.7.0.1
 */