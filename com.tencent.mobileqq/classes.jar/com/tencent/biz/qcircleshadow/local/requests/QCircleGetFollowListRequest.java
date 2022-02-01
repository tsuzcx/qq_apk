package com.tencent.biz.qcircleshadow.local.requests;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFollowListReq;
import feedcloud.FeedCloudRead.StGetFollowListRsp;
import mqq.app.AppRuntime;

public class QCircleGetFollowListRequest
  extends QCircleBaseRequest
{
  private int mListNum = 100;
  private FeedCloudRead.StGetFollowListReq mRequest = new FeedCloudRead.StGetFollowListReq();
  
  public QCircleGetFollowListRequest(String paramString, long paramLong)
  {
    this(paramString, paramLong, false);
  }
  
  public QCircleGetFollowListRequest(String paramString, long paramLong, boolean paramBoolean)
  {
    FeedCloudCommon.StCommonExt localStCommonExt = new FeedCloudCommon.StCommonExt();
    FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
    localEntry.key.set("source");
    PBStringField localPBStringField = localEntry.value;
    Object localObject;
    if (paramBoolean)
    {
      localObject = "1";
      localPBStringField.set((String)localObject);
      localStCommonExt.mapInfo.add(localEntry);
      localObject = new FeedCloudCommon.Entry();
      ((FeedCloudCommon.Entry)localObject).key.set("timestamp");
      ((FeedCloudCommon.Entry)localObject).value.set(paramLong + "");
      localStCommonExt.mapInfo.add((MessageMicro)localObject);
      this.mRequest.extInfo.set(localStCommonExt);
      if (paramString != null) {
        this.mRequest.attachInfo.set(paramString);
      }
      this.mRequest.count.set(this.mListNum);
      this.mRequest.userId.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramString = this.mRequest.filterRelation;
      if (!paramBoolean) {
        break label257;
      }
    }
    label257:
    for (int i = 0;; i = 2)
    {
      paramString.set(i);
      paramString = this.mRequest.followMethod;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      paramString.set(i);
      return;
      localObject = "2";
      break;
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetFollowListRsp localStGetFollowListRsp = new FeedCloudRead.StGetFollowListRsp();
    localStGetFollowListRsp.mergeFrom(paramArrayOfByte);
    return localStGetFollowListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFollowList";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.requests.QCircleGetFollowListRequest
 * JD-Core Version:    0.7.0.1
 */