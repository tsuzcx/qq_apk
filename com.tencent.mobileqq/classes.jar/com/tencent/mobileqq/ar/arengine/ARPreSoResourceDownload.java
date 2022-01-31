package com.tencent.mobileqq.ar.arengine;

import aaht;
import aahu;
import aahv;
import aahw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class ARPreSoResourceDownload
{
  protected static INetEngine.IBreakDownFix a;
  public QQAppInterface a;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private PreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new aahw();
  }
  
  public ARPreSoResourceDownload(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(192));
  }
  
  public boolean a(ARPreSoResourceDownload.DownloadInfo paramDownloadInfo, ARPreSoResourceDownload.ARResourceDownloadCallback paramARResourceDownloadCallback)
  {
    if ((paramDownloadInfo == null) || (paramARResourceDownloadCallback == null)) {
      return false;
    }
    Object localObject1 = new aaht(this, paramDownloadInfo);
    ??? = new aahu(this);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = ((INetEngine.INetEngineListener)???);
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.c = paramDownloadInfo.c;
    localHttpNetReq.e = 1;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    paramDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramDownloadInfo);
        switch (NetworkUtil.a(BaseApplication.getContext()))
        {
        default: 
          i = 1;
          localObject1 = new aahv(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDownloadInfo.b, (HttpEngineTask.IHttpEngineTask)localObject1, localHttpNetReq, paramDownloadInfo, paramARResourceDownloadCallback);
          this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.a(10065, "prd", paramDownloadInfo.b, 0, paramDownloadInfo.jdField_a_of_type_JavaLangString, localHttpNetReq.c, i, 0, false, (AbsPreDownloadTask)localObject1);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramDownloadInfo.b, paramARResourceDownloadCallback);
          QLog.i("AREngine_ARPreSoResourceDownload", 1, "submitDownloadTask. url = " + paramDownloadInfo.jdField_a_of_type_JavaLangString);
          return true;
        }
      }
      int i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload
 * JD-Core Version:    0.7.0.1
 */