package com.tencent.mobileqq.activity.qwallet.preload;

import java.io.Serializable;

public class PreloadManager$PathResult
  implements Serializable
{
  public String filePath;
  public String folderPath;
  public String url;
  
  public PreloadManager$PathResult() {}
  
  public PreloadManager$PathResult(String paramString1, String paramString2, String paramString3)
  {
    this.filePath = paramString1;
    this.folderPath = paramString2;
    this.url = paramString3;
  }
  
  public static PathResult getFailRes(String paramString)
  {
    return new PathResult(null, null, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult
 * JD-Core Version:    0.7.0.1
 */