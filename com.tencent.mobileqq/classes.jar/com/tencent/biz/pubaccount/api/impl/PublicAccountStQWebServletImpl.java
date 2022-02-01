package com.tencent.biz.pubaccount.api.impl;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.biz.pubaccount.api.IPublicAccountStQWebServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.remote.FromServiceMsg;

public class PublicAccountStQWebServletImpl
  extends PublicAccountServletImpl
  implements IPublicAccountStQWebServlet
{
  protected byte[] getResponseBytesData(FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = super.getResponseBytesData(paramFromServiceMsg);
    if (paramFromServiceMsg != null)
    {
      PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
      try
      {
        localStQWebRsp.mergeFrom(paramFromServiceMsg);
        paramFromServiceMsg = localStQWebRsp.busiBuff.get().toByteArray();
        return paramFromServiceMsg;
      }
      catch (Throwable paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountStQWebServletImpl
 * JD-Core Version:    0.7.0.1
 */