package com.tencent.biz.qqstory.newshare.job;

import android.text.TextUtils;
import com.tencent.biz.qqstory.newshare.model.Job;
import com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager.UrlBitmapDownloaderImp;
import com.tencent.biz.qqstory.shareGroup.icon.UrlBitmapDownloader;
import java.io.File;
import java.util.Map;

public class DownloadPic2FileJob
  extends Job
{
  public UrlBitmapDownloader a;
  private String b;
  private String c;
  private boolean d;
  
  public DownloadPic2FileJob()
  {
    this("", null, false);
  }
  
  public DownloadPic2FileJob(String paramString1, String paramString2, boolean paramBoolean)
  {
    a(false, true);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramBoolean;
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.b))
    {
      a(this.b);
      return;
    }
    b(false);
  }
  
  public void a(String paramString)
  {
    File localFile1 = new File(this.c);
    try
    {
      File localFile2 = localFile1.getParentFile();
      if ((localFile2 != null) && (!localFile2.exists())) {
        localFile2.mkdirs();
      }
      if (localFile1.exists()) {
        localFile1.delete();
      }
    }
    catch (Exception localException)
    {
      label45:
      break label45;
    }
    this.a = new ShareGroupIconManager.UrlBitmapDownloaderImp();
    this.a.a(paramString, 0, 0, new DownloadPic2FileJob.1(this, paramString));
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      if (paramMap.containsKey("DownloadPic2FileJob_iiu")) {
        this.b = ((String)b("DownloadPic2FileJob_iiu"));
      }
      if (paramMap.containsKey("DownloadPic2FileJob_isfp")) {
        this.c = ((String)b("DownloadPic2FileJob_isfp"));
      }
      if (paramMap.containsKey("DownloadPic2FileJob_IN_ROUND")) {
        this.d = ((Boolean)b("DownloadPic2FileJob_IN_ROUND")).booleanValue();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.DownloadPic2FileJob
 * JD-Core Version:    0.7.0.1
 */