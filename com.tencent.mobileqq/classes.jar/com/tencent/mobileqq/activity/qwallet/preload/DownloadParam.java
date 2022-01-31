package com.tencent.mobileqq.activity.qwallet.preload;

import aivy;
import com.tencent.util.Pair;
import java.io.Serializable;
import java.util.List;

public class DownloadParam
  implements Serializable
{
  public static final int FILE_POS_INNER = 1;
  public static final int FILE_POS_SDCARD = 0;
  public String filePath;
  public int filePos = 0;
  public List<Pair<String, String>> headers;
  public boolean isForceUnzip;
  public boolean isPreDownload;
  public String md5 = "";
  public String md5ForChecked = "";
  public long md5Time;
  public String url;
  
  public void standardlize()
  {
    if (aivy.b) {
      this.filePos = 1;
    }
  }
  
  public String toString()
  {
    return "DownloadParam{url='" + this.url + '\'' + ", md5='" + this.md5 + '\'' + ", md5Time=" + this.md5Time + ", isForceUnzip=" + this.isForceUnzip + ", headers=" + this.headers + ", md5ForChecked=" + this.md5ForChecked + ", filePos=" + this.filePos + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.DownloadParam
 * JD-Core Version:    0.7.0.1
 */