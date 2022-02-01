package com.tencent.mobileqq.apollo.api.uitls.impl;

import java.io.File;
import java.io.FilenameFilter;

final class ApolloUtilImpl$5
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.toLowerCase().endsWith(".amr")) || (paramString.toLowerCase().endsWith(".mp3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl.5
 * JD-Core Version:    0.7.0.1
 */