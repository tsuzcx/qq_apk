package com.tencent.biz.qqcircle.manager;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StRelationInfo;
import feedcloud.FeedCloudRead.StGetFollowListRsp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QCircleSpecialFollowManager$SpecialFollowListResp
{
  public final List<FeedCloudMeta.StRelationInfo> a;
  public final QCircleSpecialFollowManager.MoreInfo b;
  private final int c;
  
  private QCircleSpecialFollowManager$SpecialFollowListResp(FeedCloudRead.StGetFollowListRsp paramStGetFollowListRsp, int paramInt)
  {
    this.a = new LinkedList(paramStGetFollowListRsp.relationInfo.get());
    if (paramStGetFollowListRsp.hasNext.get() == 1)
    {
      String str = paramStGetFollowListRsp.attachInfo.get();
      paramStGetFollowListRsp = paramStGetFollowListRsp.extInfo.mapInfo.get().iterator();
      label60:
      FeedCloudCommon.Entry localEntry;
      for (long l = 0L; paramStGetFollowListRsp.hasNext(); l = Long.parseLong(localEntry.value.get()))
      {
        localEntry = (FeedCloudCommon.Entry)paramStGetFollowListRsp.next();
        if ((localEntry == null) || (!"timestamp".equals(localEntry.key.get()))) {
          break label60;
        }
      }
      this.b = new QCircleSpecialFollowManager.MoreInfo(str, l, paramInt, null);
    }
    else
    {
      this.b = null;
    }
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager.SpecialFollowListResp
 * JD-Core Version:    0.7.0.1
 */