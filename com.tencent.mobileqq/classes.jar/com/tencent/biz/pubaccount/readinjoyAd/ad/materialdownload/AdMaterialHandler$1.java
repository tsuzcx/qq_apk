package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody;
import tencent.im.oidb.cmd0x885.oidb_0x885.RspBody;

class AdMaterialHandler$1
  extends ProtoUtils.TroopProtocolObserver
{
  AdMaterialHandler$1(AdMaterialHandler paramAdMaterialHandler) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        paramBundle = new oidb_0x6cf.RspBody();
        if (paramArrayOfByte != null) {
          paramBundle.mergeFrom(paramArrayOfByte);
        }
        paramBundle = (oidb_0x885.RspBody)paramBundle.msg_ad_rsp.get();
        if ((paramInt == 0) && (paramArrayOfByte != null)) {
          paramBundle.mergeFrom(paramArrayOfByte);
        }
        bool = QLog.isColorLevel();
        if (bool)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("errorCode = ");
          paramArrayOfByte.append(paramInt);
          paramArrayOfByte.append(", rspBody.bytes_ad_user_info.has = ");
          paramArrayOfByte.append(paramBundle.bytes_ad_user_info.has());
          QLog.d("AdMaterialHandler", 2, paramArrayOfByte.toString());
        }
        if ((paramBundle != null) && (paramBundle.bytes_ad_user_info.has()))
        {
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("errorCode = ");
            paramArrayOfByte.append(paramInt);
            paramArrayOfByte.append(", rspBody.bytes_ad_user_info = ");
            paramArrayOfByte.append(paramBundle.bytes_ad_user_info.get().toStringUtf8());
            QLog.d("AdMaterialHandler", 2, paramArrayOfByte.toString());
          }
          paramArrayOfByte = this.a;
          if (paramInt == 0)
          {
            bool = true;
            paramArrayOfByte.notifyUI(1, bool, paramBundle.bytes_ad_user_info.get().toStringUtf8());
            SuperMaskReportMgr.a.a("", "requestSuccess", 1);
          }
        }
        else
        {
          SuperMaskReportMgr.a.a("", "requestFail", 1);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("Exception error");
          paramBundle.append(QLog.getStackTraceString(paramArrayOfByte));
          QLog.d("AdMaterialHandler", 2, paramBundle.toString());
        }
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialHandler.1
 * JD-Core Version:    0.7.0.1
 */