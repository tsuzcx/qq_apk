package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVidInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.VideoLocalCacheFilter;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nda;
import ndb;

public class MsgTabNodePullVideoBasicInfoSegment
  extends JobSegment
{
  private final BatchGetVideoInfo.VideoLocalCacheFilter a;
  
  public MsgTabNodePullVideoBasicInfoSegment()
  {
    this(new nda());
  }
  
  public MsgTabNodePullVideoBasicInfoSegment(BatchGetVideoInfo.VideoLocalCacheFilter paramVideoLocalCacheFilter)
  {
    this.a = paramVideoLocalCacheFilter;
  }
  
  protected void a(JobContext paramJobContext, MsgTabNodeVidListRequest.MsgTabNodeVidListResponse paramMsgTabNodeVidListResponse)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramMsgTabNodeVidListResponse == null) || (paramMsgTabNodeVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.video_list.isEmpty()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("list empty, info=");
        if (paramMsgTabNodeVidListResponse != null) {
          break label75;
        }
      }
      label75:
      for (paramJobContext = "null";; paramJobContext = paramMsgTabNodeVidListResponse.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo)
      {
        QLog.i("Q.qqstory.msgTab.jobPullBasicInfo", 2, paramJobContext);
        notifyResult(localArrayList);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.jobPullBasicInfo", 2, "pull video info start, info=" + paramMsgTabNodeVidListResponse.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo);
    }
    paramJobContext = new ArrayList();
    Object localObject = paramMsgTabNodeVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.video_list.get().iterator();
    while (((Iterator)localObject).hasNext())
    {
      qqstory_service.MsgTabNodeVidInfo localMsgTabNodeVidInfo = (qqstory_service.MsgTabNodeVidInfo)((Iterator)localObject).next();
      String str1 = localMsgTabNodeVidInfo.feed_id.get().toStringUtf8();
      int j = localMsgTabNodeVidInfo.vid_list.size();
      int i = 0;
      while (i < j)
      {
        String str2 = ((ByteStringMicro)localMsgTabNodeVidInfo.vid_list.get(i)).toStringUtf8();
        paramJobContext.add(str2);
        MsgTabVideoData localMsgTabVideoData = new MsgTabVideoData();
        localMsgTabVideoData.a = str1;
        localMsgTabVideoData.b = str2;
        localArrayList.add(localMsgTabVideoData);
        i += 1;
      }
    }
    paramJobContext = new BatchGetVideoInfo(paramJobContext);
    if (this.a != null) {
      paramJobContext.a = this.a;
    }
    paramJobContext.a(new ndb(this, localArrayList, paramMsgTabNodeVidListResponse));
    paramJobContext.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodePullVideoBasicInfoSegment
 * JD-Core Version:    0.7.0.1
 */