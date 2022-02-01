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
  private static AdvertisementCoverPreloadManager jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementCoverPreloadManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private URLDrawable.DownloadListener jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener = new AdvertisementCoverPreloadManager.1(this);
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public ImaxadThirdProcessorProxy a;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<String> b = new ArrayList();
  
  public AdvertisementCoverPreloadManager()
  {
    this.jdField_a_of_type_ComTencentMobileqqImaxadInjectImaxadThirdProcessorProxy = new ImaxadThirdProcessorProxy();
  }
  
  public static AdvertisementCoverPreloadManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementCoverPreloadManager == null) {
      jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementCoverPreloadManager = new AdvertisementCoverPreloadManager();
    }
    return jdField_a_of_type_ComTencentBizPubaccountAdvertisementManagerAdvertisementCoverPreloadManager;
  }
  
  private void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_ComTencentImageURLDrawable = this.jdField_a_of_type_ComTencentMobileqqImaxadInjectImaxadThirdProcessorProxy.a(str);
        if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable.setDownloadListener(this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener);
          this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly();
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
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          if ((!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(str)))
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(str);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("addImagesToPreload url:");
              localStringBuilder.append(str);
              QLog.d("AdvertisementCoverPreloadManager", 2, localStringBuilder.toString());
            }
          }
        }
        a();
      }
      return;
    }
    for (;;)
    {
      throw paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementCoverPreloadManager
 * JD-Core Version:    0.7.0.1
 */