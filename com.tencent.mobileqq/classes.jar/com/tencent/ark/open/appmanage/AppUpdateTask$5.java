package com.tencent.ark.open.appmanage;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;

final class AppUpdateTask$5
  implements FileFilter
{
  AppUpdateTask$5(String paramString, boolean paramBoolean) {}
  
  public boolean accept(File paramFile)
  {
    String str = paramFile.getName();
    int i = str.lastIndexOf('.');
    if (i <= 0) {
      return false;
    }
    if (TextUtils.isEmpty(str.substring(i))) {
      return false;
    }
    str = str.substring(0, i);
    if (!Utility.isValidAppVersion(str)) {
      return false;
    }
    if (Utility.compareVersionString(str, this.val$newAppVersion) >= 0) {
      return false;
    }
    if (this.val$deleteOnExit) {
      paramFile.deleteOnExit();
    } else {
      paramFile.delete();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.AppUpdateTask.5
 * JD-Core Version:    0.7.0.1
 */