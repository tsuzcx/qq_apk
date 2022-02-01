package com.tencent.av.so;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class ResDownloadControl$1
  implements INetEngineListener
{
  ResDownloadControl$1(ResDownloadControl paramResDownloadControl, ResDownloadControl.DownloadInfo paramDownloadInfo) {}
  
  public void onResp(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = new File(localHttpNetReq.mOutPath);
      if (paramNetResp.exists())
      {
        try
        {
          if (ResMgr.a(localHttpNetReq.mOutPath, this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo.resZipMd5))
          {
            String str = paramNetResp.getParent();
            FileUtils.uncompressZip(localHttpNetReq.mOutPath, str, false);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append(File.separator);
            localStringBuilder.append(this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo.resFileName);
            boolean bool = ResMgr.a(localStringBuilder.toString(), this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo.resMd5);
            if (bool) {
              i = 1;
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i = 0;
        }
        paramNetResp.delete();
        break label163;
      }
    }
    int i = 0;
    label163:
    if (i != 0)
    {
      paramNetResp = new StringBuilder();
      paramNetResp.append("download successfully. ");
      paramNetResp.append(this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo);
      QLog.i("AVResMgr", 1, paramNetResp.toString());
      if (this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo.resId.equalsIgnoreCase("AVTraeSo")) {
        ResMgr.b();
      } else if (this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo.resId.equalsIgnoreCase("AVAINSMediaLabModel")) {
        ResMgr.a();
      } else if (this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo.resId.equalsIgnoreCase("AVSDKSo")) {
        ResMgr.c();
      }
      ResDownloadControl.a(1, 100, this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo);
    }
    else
    {
      paramNetResp = new StringBuilder();
      paramNetResp.append("download end but failed. uncompressZip failed or md5 not match. ");
      paramNetResp.append(this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo);
      QLog.e("AVResMgr", 1, paramNetResp.toString());
      ResDownloadControl.a(-1, this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.b, this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo);
    }
    if (this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq == localHttpNetReq)
    {
      paramNetResp = this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo;
      paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
      paramNetResp.jdField_a_of_type_Int = 0;
      ResDownloadControl.a(this.jdField_a_of_type_ComTencentAvSoResDownloadControl).remove(this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    } else if (paramLong1 >= paramLong2) {
      i = 99;
    } else {
      i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    }
    this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.b = i;
    if (QLog.isColorLevel())
    {
      paramNetReq = new StringBuilder();
      paramNetReq.append("download... progress = ");
      paramNetReq.append(i);
      paramNetReq.append(", ");
      paramNetReq.append(this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo);
      QLog.d("AVResMgr", 2, paramNetReq.toString());
    }
    ResDownloadControl.a(2, i, this.jdField_a_of_type_ComTencentAvSoResDownloadControl$DownloadInfo.jdField_a_of_type_ComTencentAvSoResInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.so.ResDownloadControl.1
 * JD-Core Version:    0.7.0.1
 */