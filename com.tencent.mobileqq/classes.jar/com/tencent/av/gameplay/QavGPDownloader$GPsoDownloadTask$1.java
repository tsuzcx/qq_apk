package com.tencent.av.gameplay;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class QavGPDownloader$GPsoDownloadTask$1
  implements INetEngineListener
{
  QavGPDownloader$GPsoDownloadTask$1(QavGPDownloader.GPsoDownloadTask paramGPsoDownloadTask, String paramString, QAVGamePlaySoConfigInfo paramQAVGamePlaySoConfigInfo, int paramInt) {}
  
  public void onResp(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    if (this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloader$GPsoDownloadTask.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq == localHttpNetReq) {
      this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloader$GPsoDownloadTask.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGPDownloadManager", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localHttpNetReq.mReqUrl, Integer.valueOf(paramNetResp.mResult), Integer.valueOf(paramNetResp.mHttpCode), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = new File(localHttpNetReq.mOutPath);
      if (paramNetResp.exists())
      {
        try
        {
          String str = paramNetResp.getParent();
          FileUtils.a(localHttpNetReq.mOutPath, str, false);
          QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载成功了. path[%s]", new Object[] { str }));
          QavGPDownloader.a(this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          QavGPDownloader.a(-1);
          return;
        }
        paramNetResp.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        QavGPDownloader.a(100 / this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloader$GPsoDownloadTask.jdField_a_of_type_Int + this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloader$GPsoDownloadTask.b);
        paramNetResp = this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloader$GPsoDownloadTask;
        paramNetResp.b += 100 / this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloader$GPsoDownloadTask.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloader$GPsoDownloadTask.a(this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo, this.jdField_a_of_type_Int - 1)) {
          this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloader$GPsoDownloadTask.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      i = 0;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      QavGPDownloader.a(i / this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloader$GPsoDownloadTask.jdField_a_of_type_Int + this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloader$GPsoDownloadTask.b);
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gameplay.QavGPDownloader.GPsoDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */