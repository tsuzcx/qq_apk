package com.tencent.biz.qqcircle.requests;

import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.jetbrains.annotations.NotNull;

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
    localQQHeadUrlRsp.mergeFrom(paramArrayOfByte);
    return localQQHeadUrlRsp;
  }
  
  public byte[] encode()
  {
    return getRequestByteData();
  }
  
  public String getCmdName()
  {
    return "IncreaseURLSvr.QQHeadUrlReq";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  public byte[] getRequestByteKey()
  {
    return new QQHeadUrl.QQHeadUrlReq().toByteArray();
  }
  
  @NotNull
  public MessageMicro getRequestWrapper(ByteStringMicro paramByteStringMicro)
  {
    return null;
  }
  
  public Object[] parseResponseWrapper(byte[] paramArrayOfByte)
  {
    return new Object[] { Long.valueOf(0L), "", ByteStringMicro.copyFrom(paramArrayOfByte) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetHeadUrlRequest
 * JD-Core Version:    0.7.0.1
 */