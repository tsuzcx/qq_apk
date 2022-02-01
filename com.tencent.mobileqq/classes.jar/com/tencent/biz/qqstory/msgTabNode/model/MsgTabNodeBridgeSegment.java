package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgTabNodeBridgeSegment
  extends JobSegment<MsgTabNodeVidListRequest.MsgTabNodeVidListResponse, List<MsgTabVideoData>>
{
  public static List<MsgTabVideoData> a(List<MsgTabNodeVideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)paramList.next();
      MsgTabVideoData localMsgTabVideoData = new MsgTabVideoData();
      localMsgTabVideoData.b = localMsgTabNodeVideoInfo.d;
      localMsgTabVideoData.c = localMsgTabNodeVideoInfo.c;
      localMsgTabVideoData.d = localMsgTabNodeVideoInfo.a;
      localMsgTabVideoData.a = localMsgTabNodeVideoInfo.b;
      localArrayList.add(localMsgTabVideoData);
    }
    return localArrayList;
  }
  
  protected void a(JobContext paramJobContext, MsgTabNodeVidListRequest.MsgTabNodeVidListResponse paramMsgTabNodeVidListResponse)
  {
    if (paramMsgTabNodeVidListResponse == null)
    {
      notifyResult(new ArrayList());
      return;
    }
    notifyResult(a(paramMsgTabNodeVidListResponse.a.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeBridgeSegment
 * JD-Core Version:    0.7.0.1
 */