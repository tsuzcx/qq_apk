package com.tencent.ark.open;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;

final class ArkAppMgr$6
  implements FileFilter
{
  ArkAppMgr$6(String paramString, boolean paramBoolean) {}
  
  public boolean accept(File paramFile)
  {
    String str = paramFile.getName();
    int i = str.lastIndexOf('.');
    if (i <= 0) {}
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(str.substring(i)));
      str = str.substring(0, i);
    } while ((!ArkAppMgr.access$800(str)) || (ArkAppMgr.access$300(str, this.val$newAppVersion) >= 0));
    if (this.val$deleteOnExit) {
      paramFile.deleteOnExit();
    }
    for (;;)
    {
      return true;
      paramFile.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.6
 * JD-Core Version:    0.7.0.1
 */