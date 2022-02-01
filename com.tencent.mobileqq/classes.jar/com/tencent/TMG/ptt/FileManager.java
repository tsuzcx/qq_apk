package com.tencent.TMG.ptt;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;

public class FileManager
{
  private static FileManager s_instance;
  private int MAX_LENGTH = 5;
  private String TAG = "FileManager";
  private ArrayList<String> fileNameList = new ArrayList();
  private String fileNamePrx = "silk_";
  private String fullDirPath = null;
  private String silkFolderName = "tsilkfile";
  
  private boolean createSilkTempDir()
  {
    Object localObject1 = Environment.getExternalStorageDirectory().getAbsolutePath();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append(this.silkFolderName);
    localObject1 = ((StringBuilder)localObject2).toString();
    try
    {
      localObject1 = new File((String)localObject1);
      if (((File)localObject1).exists())
      {
        this.fullDirPath = ((File)localObject1).getAbsolutePath();
      }
      else
      {
        ((File)localObject1).mkdir();
        this.fullDirPath = ((File)localObject1).getAbsolutePath();
      }
      return true;
    }
    catch (Exception localException)
    {
      localObject2 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create temp file error : e = ");
      localStringBuilder.append(localException);
      Log.e((String)localObject2, localStringBuilder.toString());
    }
    return false;
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
    Object localObject = this.fullDirPath;
    if (localObject == null)
    {
      Log.e(this.TAG, "Target dir is null!");
      return true;
    }
    try
    {
      localObject = new File((String)localObject).listFiles();
      if (localObject != null)
      {
        if (localObject.length == 0) {
          return true;
        }
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("begin delete ");
        localStringBuilder.append(localObject.length);
        localStringBuilder.append(" files");
        Log.d(str, localStringBuilder.toString());
        int i = 0;
        while (i < localObject.length)
        {
          localObject[i].delete();
          i += 1;
        }
        Log.d(this.TAG, "end delete files");
      }
      return true;
    }
    catch (Exception localException)
    {
      label126:
      break label126;
    }
    Log.e(this.TAG, "delete all file failed!");
    return false;
  }
  
  public void deleteFile()
  {
    int j = this.fileNameList.size();
    int k = this.MAX_LENGTH;
    int i = 0;
    String str1;
    String str2;
    StringBuilder localStringBuilder;
    if (j > k) {
      while (i < this.fileNameList.size())
      {
        str1 = (String)this.fileNameList.get(i);
        try
        {
          File localFile1 = new File(str1);
          if (localFile1.exists()) {
            localFile1.delete();
          }
        }
        catch (Exception localException1)
        {
          str2 = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("delete file failed! file name = ");
          localStringBuilder.append(str1);
          localStringBuilder.append("exception = ");
          localStringBuilder.append(localException1);
          Log.e(str2, localStringBuilder.toString());
        }
        i += 1;
      }
    }
    if (this.fileNameList.size() > 0)
    {
      str1 = (String)this.fileNameList.get(0);
      this.fileNameList.remove(0);
      try
      {
        File localFile2 = new File(str1);
        if (localFile2.exists())
        {
          localFile2.delete();
          return;
        }
      }
      catch (Exception localException2)
      {
        str2 = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("delete file failed! file name = ");
        localStringBuilder.append(str1);
        localStringBuilder.append("exception = ");
        localStringBuilder.append(localException2);
        Log.e(str2, localStringBuilder.toString());
      }
    }
  }
  
  public String genSilkFileName()
  {
    if ((this.fullDirPath == null) && (!createSilkTempDir()))
    {
      Log.e(this.TAG, "can not create silk temp dir!");
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.fullDirPath);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(this.fileNamePrx);
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".silk");
    localObject = ((StringBuilder)localObject).toString();
    this.fileNameList.add(localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.FileManager
 * JD-Core Version:    0.7.0.1
 */