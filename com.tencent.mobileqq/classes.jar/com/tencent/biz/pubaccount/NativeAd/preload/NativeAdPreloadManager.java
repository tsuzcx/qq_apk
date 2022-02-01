package com.tencent.biz.pubaccount.NativeAd.preload;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.IBitmapCallback;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.mobileqq.app.QQAppInterface;
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
  private int jdField_a_of_type_Int;
  private ImageRequest jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  
  public NativeAdPreloadManager(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (WindowManager)paramQQAppInterface.getApplication().getSystemService("window");
    if (paramQQAppInterface != null)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramQQAppInterface.getDefaultDisplay().getMetrics(localDisplayMetrics);
      this.jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
      this.b = localDisplayMetrics.heightPixels;
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdPreloadManager", 2, "createManager width:" + localDisplayMetrics.widthPixels + ", height:" + localDisplayMetrics.heightPixels);
      }
    }
    DownloadManager.a();
  }
  
  private void b()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        String str1;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest == null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          str1 = (String)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        }
        try
        {
          Object localObject2 = new URL(str1);
          if (ImageManager.a().a((URL)localObject2))
          {
            b();
            if (QLog.isColorLevel()) {
              QLog.d("NativeAdPreloadManager", 2, "startImageDownload url:" + str1 + ", file exist!");
            }
            return;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest = new ImageRequest();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.jdField_a_of_type_JavaNetURL = ((URL)localObject2);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.b = this.b;
          localObject2 = ImageManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest);
          if (localObject2 != null)
          {
            ((CloseableBitmap)localObject2).a();
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest = null;
            b();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("NativeAdPreloadManager", 2, "startImageDownload url:" + str1 + ", bitmap cached!");
            continue;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
        }
      }
      ImageManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest, this);
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdPreloadManager", 2, "startImageDownload url:" + str2 + ", begin load!");
      }
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdPreloadManager", 2, "clearPreloadList");
        }
      }
      return;
    }
  }
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, CloseableBitmap paramCloseableBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdPreloadManager", 2, "onSuccess url:" + paramImageRequest.jdField_a_of_type_JavaNetURL.toString());
    }
    if (paramImageRequest.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest = null;
      b();
    }
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdPreloadManager", 2, "onFail url:" + paramImageRequest.jdField_a_of_type_JavaNetURL.toString());
    }
    if (paramImageRequest.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest = null;
      b();
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!TextUtils.isEmpty(paramString)) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdPreloadManager", 2, "addImageToPreload url:" + paramString);
        }
        b();
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("NativeAdPreloadManager", 2, "addImageToPreload url:" + paramString + ", skip");
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    for (;;)
    {
      String str;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramArrayList == null) || (paramArrayList.size() <= 0)) {
          break label158;
        }
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break;
        }
        str = (String)paramArrayList.next();
        if ((!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(str)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("NativeAdPreloadManager", 2, "addImagesToPreload url:" + str);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdPreloadManager", 2, "addImagesToPreload url:" + str + ", skip");
      }
    }
    b();
    label158:
  }
  
  public void onDestroy()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest = null;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdPreloadManager", 2, "onDestroy");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.preload.NativeAdPreloadManager
 * JD-Core Version:    0.7.0.1
 */