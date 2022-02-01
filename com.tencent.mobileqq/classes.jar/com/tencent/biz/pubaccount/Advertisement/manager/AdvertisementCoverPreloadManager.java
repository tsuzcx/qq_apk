package com.tencent.biz.pubaccount.Advertisement.manager;

import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.imaxad.inject.ImaxadThirdProcessorProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class AdvertisementCoverPreloadManager
{
  private static AdvertisementCoverPreloadManager b;
  private static final Object c = new Object();
  public ImaxadThirdProcessorProxy a = new ImaxadThirdProcessorProxy();
  private ArrayList<String> d = new ArrayList();
  private ArrayList<String> e = new ArrayList();
  private URLDrawable.DownloadListener f = new AdvertisementCoverPreloadManager.1(this);
  private URLDrawable g;
  
  public static AdvertisementCoverPreloadManager a()
  {
    if (b == null) {
      b = new AdvertisementCoverPreloadManager();
    }
    return b;
  }
  
  private void c()
  {
    synchronized (c)
    {
      if ((this.g == null) && (this.d != null) && (this.d.size() > 0))
      {
        String str = (String)this.d.get(0);
        this.g = this.a.a(str);
        if (this.g != null)
        {
          this.g.setDownloadListener(this.f);
          this.g.downloadImediatly();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("startImageDownload url:");
            localStringBuilder.append(str);
            QLog.d("AdvertisementCoverPreloadManager", 2, localStringBuilder.toString());
          }
        }
      }
      return;
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    synchronized (c)
    {
      if ((this.d != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          if ((!TextUtils.isEmpty(str)) && (!this.d.contains(str)))
          {
            this.d.add(str);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("addImagesToPreload url:");
              localStringBuilder.append(str);
              QLog.d("AdvertisementCoverPreloadManager", 2, localStringBuilder.toString());
            }
          }
        }
        c();
      }
      return;
    }
    for (;;)
    {
      throw paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementCoverPreloadManager
 * JD-Core Version:    0.7.0.1
 */