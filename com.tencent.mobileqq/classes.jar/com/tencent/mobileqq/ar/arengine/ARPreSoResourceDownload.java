package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class ARPreSoResourceDownload
{
  public QQAppInterface a;
  private IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = null;
  private IPreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<ARPreSoResourceDownload.DownloadInfo> jdField_a_of_type_JavaUtilArrayList = null;
  private HashMap<String, ARPreSoResourceDownload.ARResourceDownloadCallback> jdField_a_of_type_JavaUtilHashMap;
  
  public ARPreSoResourceDownload(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController = ((IPreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPreDownloadController.class));
  }
  
  public boolean a(ARPreSoResourceDownload.DownloadInfo paramDownloadInfo, ARPreSoResourceDownload.ARResourceDownloadCallback paramARResourceDownloadCallback)
  {
    if (paramDownloadInfo != null)
    {
      if (paramARResourceDownloadCallback == null) {
        return false;
      }
      Object localObject1 = new ARPreSoResourceDownload.1(this, paramDownloadInfo);
      ??? = new ARPreSoResourceDownload.2(this);
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = ((INetEngineListener)???);
      localHttpNetReq.mReqUrl = paramDownloadInfo.jdField_a_of_type_JavaLangString;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = paramDownloadInfo.c;
      localHttpNetReq.mPrioty = 1;
      localHttpNetReq.mSupportBreakResume = true;
      paramDownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramDownloadInfo);
        int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (i != 1)
        {
          if (i == 2) {
            break label152;
          }
          if (i == 3) {
            break label147;
          }
          if (i == 4) {}
        }
        else
        {
          i = 1;
          break label154;
        }
        i = 4;
        break label154;
        label147:
        i = 3;
        break label154;
        label152:
        i = 2;
        label154:
        localObject1 = new ARPreSoResourceDownload.3(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDownloadInfo.b, (HttpEngineTask.IHttpEngineTask)localObject1, localHttpNetReq, paramDownloadInfo, paramARResourceDownloadCallback);
        this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController.requestPreDownload(10065, "prd", paramDownloadInfo.b, 0, paramDownloadInfo.jdField_a_of_type_JavaLangString, localHttpNetReq.mOutPath, i, 0, false, (AbsPreDownloadTask)localObject1);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramDownloadInfo.b, paramARResourceDownloadCallback);
        paramARResourceDownloadCallback = new StringBuilder();
        paramARResourceDownloadCallback.append("submitDownloadTask. url = ");
        paramARResourceDownloadCallback.append(paramDownloadInfo.jdField_a_of_type_JavaLangString);
        QLog.i("AREngine_ARPreSoResourceDownload", 1, paramARResourceDownloadCallback.toString());
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload
 * JD-Core Version:    0.7.0.1
 */