package com.tencent.biz.qqcircle.requests;

import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._ProfileContants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class QCircleGetHeadUrlRequest
  extends QCircleBaseRequest
{
  public final QQHeadUrl.QQHeadUrlReq mReq = new QQHeadUrl.QQHeadUrlReq();
  
  public QCircleGetHeadUrlRequest(long paramLong1, long paramLong2)
  {
    this.mReq.srcUsrType.set(1);
    this.mReq.srcUin.set(paramLong1);
    this.mReq.dstUsrType.set(1);
    QQHeadUrl.ReqUsrInfo localReqUsrInfo = new QQHeadUrl.ReqUsrInfo();
    localReqUsrInfo.dstUin.set(paramLong2);
    localReqUsrInfo.timestamp.set(0);
    this.mReq.dstUsrInfos.add(localReqUsrInfo);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQHeadUrl.QQHeadUrlRsp localQQHeadUrlRsp = new QQHeadUrl.QQHeadUrlRsp();
    try
    {
      localQQHeadUrlRsp.mergeFrom(paramArrayOfByte);
      return localQQHeadUrlRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localQQHeadUrlRsp;
  }
  
  public byte[] encode()
  {
    return getRequestByteData();
  }
  
  public String getCmdName()
  {
    return QCircleHostConstants._ProfileContants.CMD_GETQQHEAD_NEW();
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  public byte[] getRequestByteKey()
  {
    return new QQHeadUrl.QQHeadUrlReq().toByteArray();
  }
  
  protected byte[] getRequestWrapper(ByteStringMicro paramByteStringMicro)
  {
    return new byte[0];
  }
  
  public Object[] parseResponseHeadInfo(byte[] paramArrayOfByte)
  {
    return new Object[] { Long.valueOf(0L), "", ByteStringMicro.copyFrom(paramArrayOfByte) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetHeadUrlRequest
 * JD-Core Version:    0.7.0.1
 */