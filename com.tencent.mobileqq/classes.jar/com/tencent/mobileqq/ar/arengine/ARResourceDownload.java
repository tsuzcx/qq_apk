package com.tencent.mobileqq.ar.arengine;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ARResourceDownload
{
  public AppInterface a;
  private IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<ARResourceDownload.DownloadInfo> jdField_a_of_type_JavaUtilArrayList = null;
  
  public ARResourceDownload(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        QLog.i("AREngine_ARResourceDownload", 1, "cancelDownloadTask. url = " + ((ARResourceDownload.DownloadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.cancelReq(((ARResourceDownload.DownloadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
  }
  
  public boolean a(ARResourceDownload.DownloadInfo paramDownloadInfo, ARResourceDownload.ARResourceDownloadCallback arg2)
  {
    if ((paramDownloadInfo == null) || (??? == null)) {
      return false;
    }
    ??? = new ARResourceDownload.1(this, paramDownloadInfo, ???);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = ???;
    localHttpNetReq.mReqUrl = paramDownloadInfo.jdField_a_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramDownloadInfo.c;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.mSupportBreakResume = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.sendReq(localHttpNetReq);
    paramDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramDownloadInfo);
      QLog.i("AREngine_ARResourceDownload", 1, "submitDownloadTask. url = " + paramDownloadInfo.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARResourceDownload
 * JD-Core Version:    0.7.0.1
 */