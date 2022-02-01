package com.tencent.commonsdk.classload;

import android.os.Process;
import com.tencent.commonsdk.util.MD5Coding;
import java.io.File;

class DexClassLoaderUtil$CheckMD5Task
  implements Runnable
{
  private File file;
  private String info;
  private File infoFile;
  private String oldMD5;
  private File tempInfoFile;
  
  DexClassLoaderUtil$CheckMD5Task(File paramFile1, String paramString1, String paramString2, File paramFile2, File paramFile3)
  {
    this.file = paramFile1;
    this.info = paramString1;
    this.oldMD5 = paramString2;
    this.infoFile = paramFile2;
    this.tempInfoFile = paramFile3;
  }
  
  public void run()
  {
    String str1 = MD5Coding.encodeFile2HexStr(this.file.getAbsolutePath());
    String str2 = this.oldMD5;
    if (str2 == null)
    {
      DexClassLoaderUtil.access$000(this.infoFile, this.tempInfoFile, this.info, str1);
      return;
    }
    if (!str2.equalsIgnoreCase(str1))
    {
      this.file.delete();
      this.infoFile.delete();
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.commonsdk.classload.DexClassLoaderUtil.CheckMD5Task
 * JD-Core Version:    0.7.0.1
 */