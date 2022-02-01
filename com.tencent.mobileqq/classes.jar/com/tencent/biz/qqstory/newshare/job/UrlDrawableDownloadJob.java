package com.tencent.biz.qqstory.newshare.job;

import android.text.TextUtils;
import com.tencent.biz.qqstory.newshare.model.Job;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.Map;

public class UrlDrawableDownloadJob
  extends Job
{
  private String a;
  private URLDrawable b;
  
  public UrlDrawableDownloadJob()
  {
    a(false, true);
  }
  
  public UrlDrawableDownloadJob(String paramString)
  {
    this();
    this.a = paramString;
  }
  
  public void a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    this.b = URLDrawable.getDrawable(this.a, localURLDrawableOptions);
    this.b.setURLDrawableListener(new UrlDrawableDownloadJob.1(this));
    if ((this.b.getStatus() == 1) && (this.b.getCurrDrawable() != null))
    {
      a("UrlDrawableDownloadJob_dra", this.b.getCurrDrawable());
      b(true);
      return;
    }
    this.b.startDownload();
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("UrlDrawableDownloadJob_iiu"))) {
      this.a = ((String)ShareUtils.a(this.h, "UrlDrawableDownloadJob_iiu", this.a));
    }
  }
  
  public boolean b()
  {
    if (TextUtils.isEmpty(this.a)) {
      return false;
    }
    return super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.UrlDrawableDownloadJob
 * JD-Core Version:    0.7.0.1
 */