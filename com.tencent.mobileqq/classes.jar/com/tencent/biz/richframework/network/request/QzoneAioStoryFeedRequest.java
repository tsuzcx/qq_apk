package com.tencent.biz.richframework.network.request;

import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_CLIENT.CLIENT.StGetUserNewestStoryReq;
import NS_QQ_STORY_CLIENT.CLIENT.StGetUserNewestStoryRsp;
import NS_QQ_STORY_CLIENT.CLIENT.StUinTime;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QzoneAioStoryFeedRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.qq_story_client.GetUserNewestStory";
  public static final String TAG = "QzoneAioStoryFeedRequest";
  private CLIENT.StGetUserNewestStoryReq req = new CLIENT.StGetUserNewestStoryReq();
  
  public QzoneAioStoryFeedRequest(COMM.StCommonExt paramStCommonExt, long paramLong1, long paramLong2)
  {
    CLIENT.StUinTime localStUinTime = new CLIENT.StUinTime();
    localStUinTime.newestTime.set(paramLong1);
    localStUinTime.uin.set(paramLong2);
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(localStUinTime);
    this.req.vecUinTime.set(localArrayList);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static CLIENT.StGetUserNewestStoryRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new CLIENT.StGetUserNewestStoryRsp();
    try
    {
      ((CLIENT.StGetUserNewestStoryRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("QzoneAioStoryFeedRequest", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.request.QzoneAioStoryFeedRequest
 * JD-Core Version:    0.7.0.1
 */