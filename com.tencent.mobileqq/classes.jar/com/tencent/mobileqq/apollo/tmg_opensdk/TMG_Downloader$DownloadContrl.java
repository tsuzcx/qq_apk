package com.tencent.mobileqq.apollo.tmg_opensdk;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class TMG_Downloader$DownloadContrl
{
  TMG_DownloadInfo jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_DownloadInfo = null;
  TMG_Downloader.TMG_Downloader_DownloadEvent jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_Downloader$TMG_Downloader_DownloadEvent;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(TMG_DownloadInfo paramTMG_DownloadInfo, int paramInt)
  {
    String str1;
    if (!TMG_Downloader.b(paramTMG_DownloadInfo))
    {
      String str2 = paramTMG_DownloadInfo.a;
      str1 = paramTMG_DownloadInfo.b;
      String str3 = TMG_Downloader.a(paramTMG_DownloadInfo);
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new TMG_Downloader.DownloadContrl.1(this, str1, paramTMG_DownloadInfo);
      localHttpNetReq.setUserData(str1);
      localHttpNetReq.mReqUrl = str2;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = new File(str3).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      paramTMG_DownloadInfo = (IHttpEngineService)CmGameUtil.a().getRuntimeService(IHttpEngineService.class, "all");
      if (paramTMG_DownloadInfo == null) {
        break label212;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
      paramTMG_DownloadInfo.sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    }
    label212:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_Downloader$TMG_Downloader_DownloadEvent != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_Downloader$TMG_Downloader_DownloadEvent.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_Downloader$TMG_Downloader_DownloadEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_Downloader$TMG_Downloader_DownloadEvent.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(TMG_DownloadInfo paramTMG_DownloadInfo, TMG_Downloader.TMG_Downloader_DownloadEvent paramTMG_Downloader_DownloadEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_Downloader$TMG_Downloader_DownloadEvent = paramTMG_Downloader_DownloadEvent;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_DownloadInfo == paramTMG_DownloadInfo) || (TextUtils.isEmpty(paramTMG_DownloadInfo.b)) || (paramTMG_DownloadInfo.b.equals(this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_DownloadInfo.b))) {
        break label220;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(bool) }));
      }
      if (!bool)
      {
        return this.jdField_a_of_type_Boolean;
        bool = true;
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null)
        {
          paramTMG_Downloader_DownloadEvent = (IHttpEngineService)CmGameUtil.a().getRuntimeService(IHttpEngineService.class, "all");
          if (paramTMG_Downloader_DownloadEvent != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.getUserData() }));
            paramTMG_Downloader_DownloadEvent.cancelReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_DownloadInfo = paramTMG_DownloadInfo;
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_DownloadInfo }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_DownloadInfo, 1);
        return this.jdField_a_of_type_Boolean;
        label220:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.tmg_opensdk.TMG_Downloader.DownloadContrl
 * JD-Core Version:    0.7.0.1
 */