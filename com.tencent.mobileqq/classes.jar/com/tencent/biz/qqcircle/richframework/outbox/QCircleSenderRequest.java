package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.BytesEntry;

public class QCircleSenderRequest
  extends QCircleBaseRequest
{
  public static final String KEY_RESPONSE_DATA = "response_data";
  private byte[] mRequestByteData;
  private String mRequestCmdName;
  private long[] mRequestRetCodes = null;
  
  public QCircleSenderRequest(String paramString, byte[] paramArrayOfByte)
  {
    this.mRequestCmdName = paramString;
    this.mRequestByteData = paramArrayOfByte;
    setRetryCount(2);
  }
  
  public QCircleSenderRequest(String paramString, byte[] paramArrayOfByte, long[] paramArrayOfLong)
  {
    this.mRequestCmdName = paramString;
    this.mRequestByteData = paramArrayOfByte;
    this.mRequestRetCodes = paramArrayOfLong;
    setRetryCount(2);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
    localBytesEntry.key.set("response_data");
    localBytesEntry.value.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    return localBytesEntry;
  }
  
  public String getCmdName()
  {
    return this.mRequestCmdName;
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequestByteData;
  }
  
  public long[] getRetryRetCodes()
  {
    return this.mRequestRetCodes;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.outbox.QCircleSenderRequest
 * JD-Core Version:    0.7.0.1
 */