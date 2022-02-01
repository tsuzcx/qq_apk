package com.tencent.component.network.utils;

import android.content.Context;
import java.io.File;

final class FileUtils$2
  implements FileUtils.AssetFileComparator
{
  public boolean equals(Context paramContext, String paramString, File paramFile)
  {
    long l = FileUtils.getAssetLength(paramContext, paramString);
    return (l != -1L) && (l == paramFile.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.utils.FileUtils.2
 * JD-Core Version:    0.7.0.1
 */