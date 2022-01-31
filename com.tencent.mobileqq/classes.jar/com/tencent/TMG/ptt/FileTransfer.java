package com.tencent.TMG.ptt;

import android.util.Log;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FileTransfer
{
  public static final String TAG = "FileTransfer";
  private static FileTransfer s_instance = null;
  
  public static FileTransfer getInstance()
  {
    if (s_instance == null) {}
    try
    {
      if (s_instance == null) {
        s_instance = new FileTransfer();
      }
      return s_instance;
    }
    finally {}
  }
  
  private String getParamString(Map<String, String> paramMap, String paramString)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      for (paramMap = "";; paramMap = paramMap + (String)((Map.Entry)localObject).getValue() + "\r\n")
      {
        localObject = paramMap;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        paramMap = paramMap + "--" + paramString + "\r\n";
        paramMap = paramMap + "Content-Disposition: form-data; name=\"" + (String)((Map.Entry)localObject).getKey() + "\"\r\n\r\n";
      }
    }
    Object localObject = "";
    return localObject;
  }
  
  private File openFile(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      Log.e("FileTransfer", "checkFile| filePath == null.");
      return null;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      Log.e("FileTransfer", "checkFile| filePath is not exist. path=" + paramString);
      return null;
    }
    return localFile;
  }
  
  public void applyMessageKey(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Log.i("FileTransfer", String.format("applyMessageKey| appid=%s, bucket=%s, region=%s, sign=%s", new Object[] { paramString1, paramString2, paramString3, paramString4 }));
  }
  
  public void downloadFile(String paramString1, String paramString2, String paramString3, PttListener.DownloadFileListener paramDownloadFileListener)
  {
    new Thread(new FileTransfer.2(this, paramString1, paramString2, paramString3, paramDownloadFileListener)).start();
  }
  
  public void uploadFile(String paramString1, String paramString2, String paramString3, int paramInt, PttListener.UploadFileListener paramUploadFileListener)
  {
    new Thread(new FileTransfer.1(this, paramString1, paramInt, paramString2, paramString3, paramUploadFileListener)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.ptt.FileTransfer
 * JD-Core Version:    0.7.0.1
 */