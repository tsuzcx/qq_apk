package com.tencent.av.share;

import android.os.Handler;
import com.tencent.av.ReqGroupVideo.ReqCheckGroupCanJoin;
import com.tencent.av.ReqGroupVideo.RspCheckGroupCanJoin;
import com.tencent.av.business.handler.MessageHandler.MsgListener;
import com.tencent.mobileqq.app.ThreadManagerV2;

class AVSchema$2
  extends MessageHandler.MsgListener<ReqGroupVideo.ReqCheckGroupCanJoin, ReqGroupVideo.RspCheckGroupCanJoin>
{
  AVSchema$2(AVSchema paramAVSchema) {}
  
  public void a(long paramLong, boolean paramBoolean, ReqGroupVideo.ReqCheckGroupCanJoin paramReqCheckGroupCanJoin, ReqGroupVideo.RspCheckGroupCanJoin paramRspCheckGroupCanJoin, Object paramObject)
  {
    ThreadManagerV2.getUIHandlerV2().post(new AVSchema.2.1(this, paramRspCheckGroupCanJoin, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.2
 * JD-Core Version:    0.7.0.1
 */