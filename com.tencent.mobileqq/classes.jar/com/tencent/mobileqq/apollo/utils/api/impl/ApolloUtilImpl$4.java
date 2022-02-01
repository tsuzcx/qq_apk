package com.tencent.mobileqq.apollo.utils.api.impl;

import java.io.File;
import java.io.FilenameFilter;

final class ApolloUtilImpl$4
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.toLowerCase().endsWith(".amr")) || (paramString.toLowerCase().endsWith(".mp3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl.4
 * JD-Core Version:    0.7.0.1
 */