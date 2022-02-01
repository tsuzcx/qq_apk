package com.tencent.biz.pubaccount.NativeAd.preload;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class NativeAdPreloadManager
  implements IBitmapCallback, Manager
{
  private int a;
  private int b;
  private ImageRequest c;
  private final Object d = new Object();
  private ArrayList<String> e = new ArrayList();
  
  public NativeAdPreloadManager(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (WindowManager)paramQQAppInterface.getApplication().getSystemService("window");
    if (localObject != null)
    {
      paramQQAppInterface = new DisplayMetrics();
      ((WindowManager)localObject).getDefaultDisplay().getMetrics(paramQQAppInterface);
      this.a = paramQQAppInterface.widthPixels;
      this.b = paramQQAppInterface.heightPixels;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("createManager width:");
        ((StringBuilder)localObject).append(paramQQAppInterface.widthPixels);
        ((StringBuilder)localObject).append(", height:");
        ((StringBuilder)localObject).append(paramQQAppInterface.heightPixels);
        QLog.d("NativeAdPreloadManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    DownloadManager.b();
  }
  
  private void b()
  {
    synchronized (this.d)
    {
      if ((this.c == null) && (this.e != null) && (this.e.size() > 0))
      {
        String str = (String)this.e.remove(0);
        try
        {
          Object localObject3 = new URL(str);
          if (((IImageManager)QRoute.api(IImageManager.class)).isLocalFileExist((URL)localObject3))
          {
            b();
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("startImageDownload url:");
              ((StringBuilder)localObject3).append(str);
              ((StringBuilder)localObject3).append(", file exist!");
              QLog.d("NativeAdPreloadManager", 2, ((StringBuilder)localObject3).toString());
            }
          }
          else
          {
            this.c = new ImageRequest();
            this.c.a = ((URL)localObject3);
            this.c.b = this.a;
            this.c.c = this.b;
            localObject3 = ((IImageManager)QRoute.api(IImageManager.class)).getBitmap(this.c);
            if (localObject3 != null)
            {
              ((ICloseableBitmap)localObject3).a();
              this.c = null;
              b();
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("startImageDownload url:");
                ((StringBuilder)localObject3).append(str);
                ((StringBuilder)localObject3).append(", bitmap cached!");
                QLog.d("NativeAdPreloadManager", 2, ((StringBuilder)localObject3).toString());
              }
            }
            else
            {
              ((IImageManager)QRoute.api(IImageManager.class)).loadImage(this.c, this);
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("startImageDownload url:");
                ((StringBuilder)localObject3).append(str);
                ((StringBuilder)localObject3).append(", begin load!");
                QLog.d("NativeAdPreloadManager", 2, ((StringBuilder)localObject3).toString());
              }
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      return;
    }
  }
  
  public void a()
  {
    synchronized (this.d)
    {
      if (this.e != null)
      {
        this.e.clear();
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdPreloadManager", 2, "clearPreloadList");
        }
      }
      return;
    }
  }
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, ICloseableBitmap paramICloseableBitmap)
  {
    if (QLog.isColorLevel())
    {
      paramICloseableBitmap = new StringBuilder();
      paramICloseableBitmap.append("onSuccess url:");
      paramICloseableBitmap.append(paramImageRequest.a.toString());
      QLog.d("NativeAdPreloadManager", 2, paramICloseableBitmap.toString());
    }
    if (paramImageRequest.equals(this.c))
    {
      this.c = null;
      b();
    }
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramThrowable = new StringBuilder();
      paramThrowable.append("onFail url:");
      paramThrowable.append(paramImageRequest.a.toString());
      QLog.d("NativeAdPreloadManager", 2, paramThrowable.toString());
    }
    if (paramImageRequest.equals(this.c))
    {
      this.c = null;
      b();
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.d)
    {
      StringBuilder localStringBuilder;
      if ((this.e != null) && (!TextUtils.isEmpty(paramString)) && (!this.e.contains(paramString)))
      {
        this.e.add(paramString);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("addImageToPreload url:");
          localStringBuilder.append(paramString);
          QLog.d("NativeAdPreloadManager", 2, localStringBuilder.toString());
        }
        b();
      }
      else if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addImageToPreload url:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", skip");
        QLog.d("NativeAdPreloadManager", 2, localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    synchronized (this.d)
    {
      if ((this.e != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          StringBuilder localStringBuilder;
          if ((!TextUtils.isEmpty(str)) && (!this.e.contains(str)))
          {
            this.e.add(str);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("addImagesToPreload url:");
              localStringBuilder.append(str);
              QLog.d("NativeAdPreloadManager", 2, localStringBuilder.toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("addImagesToPreload url:");
            localStringBuilder.append(str);
            localStringBuilder.append(", skip");
            QLog.d("NativeAdPreloadManager", 2, localStringBuilder.toString());
          }
        }
        b();
      }
      return;
    }
    for (;;)
    {
      throw paramArrayList;
    }
  }
  
  public void onDestroy()
  {
    synchronized (this.d)
    {
      this.c = null;
      this.e.clear();
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdPreloadManager", 2, "onDestroy");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.preload.NativeAdPreloadManager
 * JD-Core Version:    0.7.0.1
 */