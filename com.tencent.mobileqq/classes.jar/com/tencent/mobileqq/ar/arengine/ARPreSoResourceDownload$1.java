package com.tencent.mobileqq.ar.arengine;

import android.text.TextUtils;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class ARPreSoResourceDownload$1
  implements HttpEngineTask.IHttpEngineTask
{
  ARPreSoResourceDownload$1(ARPreSoResourceDownload paramARPreSoResourceDownload, ARPreSoResourceDownload.DownloadInfo paramDownloadInfo) {}
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask)
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, "onPreDownloadStart");
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {
      QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download init. url = " + ((HttpNetReq)paramNetResp.mReq).mReqUrl);
    }
    for (;;)
    {
      return;
      int i;
      synchronized (ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload))
      {
        if (ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload) != null)
        {
          i = 0;
          label67:
          if (i < ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload).size())
          {
            if (!((ARPreSoResourceDownload.DownloadInfo)ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$DownloadInfo.jdField_a_of_type_JavaLangString)) {
              break label342;
            }
            ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload).remove(i);
          }
        }
      }
      synchronized (ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload))
      {
        ??? = (ARPreSoResourceDownload.ARResourceDownloadCallback)ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload).get(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$DownloadInfo.b);
        if (paramNetResp.mResult == 0)
        {
          if (ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload) != null) {
            ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload).preDownloadSuccess(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$DownloadInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$DownloadInfo.jdField_a_of_type_Long);
          }
          ??? = new File(((HttpNetReq)paramNetResp.mReq).mOutPath);
          String str = PortalUtils.a(((File)???).getAbsolutePath());
          if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$DownloadInfo.b))) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$DownloadInfo.jdField_a_of_type_Int != 1))
          {
            QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download end. MD5 check error. url = " + ((HttpNetReq)paramNetResp.mReq).mReqUrl + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
            if (??? == null) {
              continue;
            }
            ((ARPreSoResourceDownload.ARResourceDownloadCallback)???).a(false, this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$DownloadInfo);
            return;
            label342:
            i += 1;
            break label67;
            paramNetResp = finally;
            throw paramNetResp;
          }
        }
      }
      for (boolean bool = true; ??? != null; bool = false)
      {
        ((ARPreSoResourceDownload.ARResourceDownloadCallback)???).a(bool, this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$DownloadInfo);
        return;
        if (ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload) != null) {
          ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload).preDownloadSuccess(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$DownloadInfo.jdField_a_of_type_JavaLangString, -1L);
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARPreSoResourceDownload", 2, "onUpdateProgeress. url = " + ((HttpNetReq)???).mReqUrl + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    synchronized (ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload))
    {
      ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = (ARPreSoResourceDownload.ARResourceDownloadCallback)ARPreSoResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload).get(this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$DownloadInfo.b);
      if (localARResourceDownloadCallback != null) {
        localARResourceDownloadCallback.a(paramLong1, paramLong2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.1
 * JD-Core Version:    0.7.0.1
 */