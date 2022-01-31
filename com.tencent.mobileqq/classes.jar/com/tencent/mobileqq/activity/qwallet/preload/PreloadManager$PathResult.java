package com.tencent.mobileqq.activity.qwallet.preload;

import java.io.Serializable;

public class PreloadManager$PathResult
  implements Serializable
{
  public String filePath;
  public String folderPath;
  public boolean isAlreadyExist;
  public int subErrCode;
  public String url;
  
  public PreloadManager$PathResult() {}
  
  public PreloadManager$PathResult(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.filePath = paramString1;
    this.folderPath = paramString2;
    this.url = paramString3;
    this.subErrCode = paramInt;
  }
  
  public static PathResult getFailRes(String paramString)
  {
    return getFailRes(paramString, 0);
  }
  
  public static PathResult getFailRes(String paramString, int paramInt)
  {
    return new PathResult(null, null, paramString, paramInt);
  }
  
  public String toString()
  {
    return "PathResult{file='" + this.filePath + '\'' + ", folder='" + this.folderPath + '\'' + ", url='" + this.url + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult
 * JD-Core Version:    0.7.0.1
 */