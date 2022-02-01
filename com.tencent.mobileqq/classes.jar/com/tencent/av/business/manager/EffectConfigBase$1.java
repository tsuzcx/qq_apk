package com.tencent.av.business.manager;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class EffectConfigBase$1
  implements INetEngineListener
{
  EffectConfigBase$1(EffectConfigBase paramEffectConfigBase, long paramLong, EffectConfigBase.ItemBase paramItemBase) {}
  
  public void onResp(NetResp paramNetResp)
  {
    int i = 0;
    EffectConfigBase.ItemBase localItemBase = (EffectConfigBase.ItemBase)paramNetResp.mReq.getUserData();
    String str1 = "";
    if (paramNetResp.mResult == 3)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, 重复下载, item[" + localItemBase + "], seq[" + this.jdField_a_of_type_Long + "]");
      return;
    }
    boolean bool;
    if (paramNetResp.mResult != 0)
    {
      str1 = "fail, mErrCode[" + paramNetResp.mErrCode + "], mErrDesc[" + paramNetResp.mErrDesc + "]";
      bool = false;
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 1, "startDownload, onResp, result[" + bool + "], resp.mResult[" + paramNetResp.mResult + "], item[" + localItemBase + "], seq[" + this.jdField_a_of_type_Long + "], " + str1 + "]");
      localItemBase.isDownloading = false;
      paramNetResp = this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler;
      if (bool) {
        i = 1;
      }
      paramNetResp.obtainMessage(1, i, (int)this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase).sendToTarget();
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.a(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase);
      return;
      String str3 = SecUtil.getFileMd5(paramNetResp.mReq.mOutPath);
      if (!localItemBase.getMd5().equalsIgnoreCase(str3))
      {
        str1 = "fail, md5不匹配, fileMD5[" + str3 + "], configMD5[" + localItemBase.getMd5() + "], mOutPath[" + paramNetResp.mReq.mOutPath + "]";
        bool = false;
      }
      else
      {
        try
        {
          FileUtils.a(paramNetResp.mReq.mOutPath, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.b(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase), false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_JavaLangString, 4, "startDownload, uncompressZip fail.", localIOException);
          }
          String str2 = HardCodeUtil.a(2131704001);
          bool = false;
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)(100L * paramLong1 / paramLong2), 0, this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectConfigBase.1
 * JD-Core Version:    0.7.0.1
 */