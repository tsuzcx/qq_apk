package com.tencent.TMG.utils;

import android.util.Log;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CosFileTransfer
{
  public static final String TAG = "CosFileTransfer";
  
  public static void downloadFile(String paramString1, String paramString2, String paramString3, Object paramObject, CosFileTransfer.DownloadCosFileListener paramDownloadCosFileListener)
  {
    new Thread(new CosFileTransfer.2(paramString1, paramString2, paramString3, paramDownloadCosFileListener, paramObject)).start();
  }
  
  private static String getParamString(Map<String, String> paramMap, String paramString)
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
  
  private static File openFile(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      Log.e("CosFileTransfer", "checkFile| filePath == null.");
      return null;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      Log.e("CosFileTransfer", "checkFile| filePath is not exist. path=" + paramString);
      return null;
    }
    return localFile;
  }
  
  public static void uploadFile(String paramString1, String paramString2, String paramString3, int paramInt, Object paramObject, CosFileTransfer.UploadCosFileListener paramUploadCosFileListener)
  {
    new Thread(new CosFileTransfer.1(paramString1, paramInt, paramString2, paramString3, paramUploadCosFileListener, paramObject)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.utils.CosFileTransfer
 * JD-Core Version:    0.7.0.1
 */