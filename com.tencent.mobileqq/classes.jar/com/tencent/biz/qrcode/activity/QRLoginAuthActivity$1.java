package com.tencent.biz.qrcode.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.qq.taf.jce.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.ErrMsg;

class QRLoginAuthActivity$1
  extends WtloginObserver
{
  QRLoginAuthActivity$1(QRLoginAuthActivity paramQRLoginAuthActivity) {}
  
  public void onCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("OnCloseCode userAccount=");
      paramArrayOfByte1.append(paramString);
      paramArrayOfByte1.append(" ret=");
      paramArrayOfByte1.append(paramInt);
      QLog.d("QRLoginAuthActivity", 2, paramArrayOfByte1.toString());
    }
    paramArrayOfByte1 = null;
    paramString = paramArrayOfByte1;
    if (paramInt == 0)
    {
      paramString = paramArrayOfByte1;
      if (paramWUserSigInfo != null) {
        paramString = WtloginHelper.getLoginTlvValue(paramWUserSigInfo, 54);
      }
    }
    paramArrayOfByte1 = new Message();
    paramWUserSigInfo = new Bundle();
    paramWUserSigInfo.putInt("ret", paramInt);
    paramWUserSigInfo.putByteArray("errMsg", paramArrayOfByte2);
    if (paramString != null) {
      paramWUserSigInfo.putByteArray("devInfo", paramString);
    }
    paramArrayOfByte1.setData(paramWUserSigInfo);
    paramArrayOfByte1.what = 2;
    this.a.a.sendMessage(paramArrayOfByte1);
  }
  
  public void onException(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnException e=");
      localStringBuilder.append(paramString);
      QLog.d("QRLoginAuthActivity", 2, localStringBuilder.toString());
    }
    paramString = new Message();
    paramString.what = 3;
    this.a.a.sendMessage(paramString);
  }
  
  public void onVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      paramErrMsg = new StringBuilder();
      paramErrMsg.append("OnVerifyCode userAccount=");
      paramErrMsg.append(paramString);
      paramErrMsg.append(" ret=");
      paramErrMsg.append(paramInt);
      QLog.d("QRLoginAuthActivity", 2, paramErrMsg.toString());
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.d = paramString;
    paramErrMsg = null;
    paramString = paramErrMsg;
    if (paramArrayList != null)
    {
      paramString = paramErrMsg;
      if (paramArrayList.size() > 0)
      {
        paramString = new ByteArrayOutputStream();
        int i = 0;
        while (i < paramArrayList.size())
        {
          try
          {
            paramString.write(HexUtil.hexStr2Bytes((String)paramArrayList.get(i)));
          }
          catch (Throwable paramErrMsg)
          {
            paramErrMsg.printStackTrace();
          }
          i += 1;
        }
        paramString = paramString.toByteArray();
      }
    }
    paramArrayList = new Message();
    paramErrMsg = new Bundle();
    paramErrMsg.putInt("ret", paramInt);
    paramErrMsg.putByteArray("tlv", paramString);
    paramErrMsg.putByteArray("appName", paramArrayOfByte1);
    paramErrMsg.putByteArray("errMsg", paramArrayOfByte2);
    paramArrayList.setData(paramErrMsg);
    paramArrayList.what = 1;
    this.a.a.sendMessage(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginAuthActivity.1
 * JD-Core Version:    0.7.0.1
 */