package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VidPollInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VidRateInfo;
import java.util.ArrayList;
import java.util.List;

public final class GetVidPollInfoHandler$GetVidPollInfoEvent
  extends BaseEvent
{
  public List<qqstory_struct.VidPollInfo> a = new ArrayList();
  public List<qqstory_struct.VidRateInfo> b = new ArrayList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetVidPollInfoHandler.GetVidPollInfoEvent
 * JD-Core Version:    0.7.0.1
 */