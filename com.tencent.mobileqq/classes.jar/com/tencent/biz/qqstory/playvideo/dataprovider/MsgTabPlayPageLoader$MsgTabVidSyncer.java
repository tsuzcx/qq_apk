package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInsertLocalVideoInfoSegment;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodePullVideoBasicInfoSegment;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListPullSegment;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class MsgTabPlayPageLoader$MsgTabVidSyncer
  implements IGroupPageLoader.IVidFullSyncer
{
  private final MsgTabPlayPageLoader.MsgTabGroupId a;
  
  public MsgTabPlayPageLoader$MsgTabVidSyncer(MsgTabPlayPageLoader.MsgTabGroupId paramMsgTabGroupId)
  {
    this.a = paramMsgTabGroupId;
  }
  
  public void a(IGroupPageLoader.IVidFullSyncer.CallBack paramCallBack)
  {
    Stream localStream2 = Stream.of(this.a.a).map(new ThreadOffFunction("Q.qqstory.player.data.MsgTabPlayPageLoader", 2)).map(new MsgTabNodeVidListPullSegment("Q.qqstory.player.data.MsgTabPlayPageLoader", this.a.d, this.a.e, this.a));
    Stream localStream1 = localStream2;
    if (this.a.a.b == 5) {
      localStream1 = localStream2.map(new MsgTabNodePullVideoBasicInfoSegment()).map(new MsgTabNodeInsertLocalVideoInfoSegment(this.a.a));
    }
    localStream1.subscribe(new MsgTabPlayPageLoader.MsgTabVidSyncer.1(this, paramCallBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabVidSyncer
 * JD-Core Version:    0.7.0.1
 */