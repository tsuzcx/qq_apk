package com.tencent.TMG.ptt;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;

public class FileManager
{
  private static FileManager s_instance = null;
  private int MAX_LENGTH = 5;
  private String TAG = "FileManager";
  private ArrayList<String> fileNameList = new ArrayList();
  private String fileNamePrx = "silk_";
  private String fullDirPath = null;
  private String silkFolderName = "tsilkfile";
  
  private boolean createSilkTempDir()
  {
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
    localObject = (String)localObject + "/" + this.silkFolderName;
    try
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        this.fullDirPath = ((File)localObject).getAbsolutePath();
      }
      else
      {
        ((File)localObject).mkdir();
        this.fullDirPath = ((File)localObject).getAbsolutePath();
      }
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "create temp file error : e = " + localException);
      return false;
    }
    return true;
  }
  
  public static FileManager getInstance()
  {
    if (s_instance == null)
    {
      s_instance = new FileManager();
      s_instance.createSilkTempDir();
      s_instance.deleteAllFile();
    }
    return s_instance;
  }
  
  public boolean deleteAllFile()
  {
    if (this.fullDirPath == null) {
      Log.e(this.TAG, "Target dir is null!");
    }
    for (;;)
    {
      return true;
      try
      {
        File[] arrayOfFile = new File(this.fullDirPath).listFiles();
        if ((arrayOfFile != null) && (arrayOfFile.length != 0))
        {
          Log.d(this.TAG, "begin delete " + arrayOfFile.length + " files");
          int i = 0;
          while (i < arrayOfFile.length)
          {
            arrayOfFile[i].delete();
            i += 1;
          }
          Log.d(this.TAG, "end delete files");
          return true;
        }
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "delete all file failed!");
      }
    }
    return false;
  }
  
  public void deleteFile()
  {
    int i = 0;
    String str;
    if (this.fileNameList.size() > this.MAX_LENGTH) {
      for (;;)
      {
        if (i >= this.fileNameList.size()) {
          break label159;
        }
        str = (String)this.fileNameList.get(i);
        try
        {
          File localFile1 = new File(str);
          if (localFile1.exists()) {
            localFile1.delete();
          }
          i += 1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.e(this.TAG, "delete file failed! file name = " + str + "exception = " + localException1);
          }
        }
      }
    }
    if (this.fileNameList.size() > 0)
    {
      str = (String)this.fileNameList.get(0);
      this.fileNameList.remove(0);
    }
    try
    {
      File localFile2 = new File(str);
      if (localFile2.exists()) {
        localFile2.delete();
      }
      label159:
      return;
    }
    catch (Exception localException2)
    {
      Log.e(this.TAG, "delete file failed! file name = " + str + "exception = " + localException2);
    }
  }
  
  public String genSilkFileName()
  {
    if ((this.fullDirPath == null) && (!createSilkTempDir()))
    {
      Log.e(this.TAG, "can not create silk temp dir!");
      return null;
    }
    String str = this.fullDirPath + "/" + this.fileNamePrx + System.currentTimeMillis() + ".silk";
    this.fileNameList.add(str);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.ptt.FileManager
 * JD-Core Version:    0.7.0.1
 */