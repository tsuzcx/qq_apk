package com.tencent.biz.richframework.network.request;

import NS_QQ_STORY_CLIENT.CLIENT.StGetStoryFeedListReq;
import NS_QQ_STORY_CLIENT.CLIENT.StGetStoryFeedListRsp;
import NS_QQ_STORY_CLIENT.CLIENT.StUinTime;
import android.support.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetMineStoryFeedListRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.qq_story_client.GetStoryFeedList";
  private static final int PAGE_SIZE = 10;
  private static final String TAG = "GetMineStoryFeedListRequest";
  private final CLIENT.StGetStoryFeedListReq mReq = new CLIENT.StGetStoryFeedListReq();
  
  public GetMineStoryFeedListRequest(int paramInt, CLIENT.StUinTime paramStUinTime)
  {
    this.mReq.listType.set(paramInt);
    this.mReq.uinTime.set(paramStUinTime);
    this.mReq.listNum.set(10);
  }
  
  @Nullable
  public static CLIENT.StGetStoryFeedListRsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      setErrorLog("data is null");
      return null;
    }
    paramArrayOfByte = decode(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      setErrorLog("storyData is null");
      return null;
    }
    CLIENT.StGetStoryFeedListRsp localStGetStoryFeedListRsp = new CLIENT.StGetStoryFeedListRsp();
    try
    {
      localStGetStoryFeedListRsp.mergeFrom(paramArrayOfByte);
      return localStGetStoryFeedListRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      setErrorLog("onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  private static void setErrorLog(String paramString)
  {
    if (RFLog.isColorLevel()) {
      RFLog.e("GetMineStoryFeedListRequest", RFLog.CLR, paramString);
    }
  }
  
  public byte[] getBusiBuf()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.request.GetMineStoryFeedListRequest
 * JD-Core Version:    0.7.0.1
 */