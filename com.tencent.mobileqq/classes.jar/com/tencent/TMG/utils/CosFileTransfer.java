package com.tencent.TMG.utils;

import android.util.Log;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
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
  
  private static File openFile(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      Object localObject = new File(paramString);
      if (!((File)localObject).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkFile| filePath is not exist. path=");
        ((StringBuilder)localObject).append(paramString);
        Log.e("CosFileTransfer", ((StringBuilder)localObject).toString());
        return null;
      }
      return localObject;
    }
    Log.e("CosFileTransfer", "checkFile| filePath == null.");
    return null;
  }
  
  public static void uploadFile(String paramString1, String paramString2, String paramString3, int paramInt, Object paramObject, CosFileTransfer.UploadCosFileListener paramUploadCosFileListener)
  {
    new Thread(new CosFileTransfer.1(paramString1, paramInt, paramString2, paramString3, paramUploadCosFileListener, paramObject)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.utils.CosFileTransfer
 * JD-Core Version:    0.7.0.1
 */