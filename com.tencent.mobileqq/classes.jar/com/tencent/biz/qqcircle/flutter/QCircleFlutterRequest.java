package com.tencent.biz.qqcircle.flutter;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;

public class QCircleFlutterRequest
  extends QCircleBaseRequest
{
  protected String cmd;
  protected byte[] req;
  protected byte[] rsp;
  
  public QCircleFlutterRequest(String paramString, byte[] paramArrayOfByte)
  {
    this.cmd = paramString;
    this.req = paramArrayOfByte;
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    this.rsp = paramArrayOfByte;
    return new QCircleFlutterRequest.1(this);
  }
  
  public String getCmdName()
  {
    return this.cmd;
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req;
  }
  
  public byte[] getResponseByteData()
  {
    return this.rsp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QCircleFlutterRequest
 * JD-Core Version:    0.7.0.1
 */