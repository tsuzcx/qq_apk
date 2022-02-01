package com.tencent.TMG.ptt;

import android.util.Log;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;

public class FileTransfer
{
  public static final String TAG = "FileTransfer";
  private static FileTransfer s_instance;
  
  public static FileTransfer getInstance()
  {
    if (s_instance == null) {
      try
      {
        if (s_instance == null) {
          s_instance = new FileTransfer();
        }
      }
      finally {}
    }
    return s_instance;
  }
  
  private String getParamString(Map<String, String> paramMap, String paramString)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      for (paramMap = (Map<String, String>)localObject2;; paramMap = ((StringBuilder)localObject2).toString())
      {
        localObject1 = paramMap;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)localIterator.next();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramMap);
        ((StringBuilder)localObject2).append("--");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("\r\n");
        paramMap = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramMap);
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=\"");
        ((StringBuilder)localObject2).append((String)((Map.Entry)localObject1).getKey());
        ((StringBuilder)localObject2).append("\"\r\n\r\n");
        paramMap = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramMap);
        ((StringBuilder)localObject2).append((String)((Map.Entry)localObject1).getValue());
        ((StringBuilder)localObject2).append("\r\n");
      }
    }
    return localObject1;
  }
  
  private File openFile(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      Object localObject = new File(paramString);
      if (!((File)localObject).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkFile| filePath is not exist. path=");
        ((StringBuilder)localObject).append(paramString);
        Log.e("FileTransfer", ((StringBuilder)localObject).toString());
        return null;
      }
      return localObject;
    }
    Log.e("FileTransfer", "checkFile| filePath == null.");
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.FileTransfer
 * JD-Core Version:    0.7.0.1
 */