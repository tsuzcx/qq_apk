package com.tencent.av.share;

import android.os.Handler;
import android.os.Looper;
import com.tencent.av.ReqGroupVideo.ReqShareBackflowVerify;
import com.tencent.av.ReqGroupVideo.RspShareBackflowVerify;
import com.tencent.av.business.handler.MessageHandler.MsgListener;

class AVSchema$MyMsgListener
  extends MessageHandler.MsgListener<ReqGroupVideo.ReqShareBackflowVerify, ReqGroupVideo.RspShareBackflowVerify>
{
  AVSchema.Info a;
  
  AVSchema$MyMsgListener(AVSchema paramAVSchema, AVSchema.Info paramInfo)
  {
    this.a = paramInfo;
  }
  
  public void a(long paramLong, boolean paramBoolean, ReqGroupVideo.ReqShareBackflowVerify paramReqShareBackflowVerify, ReqGroupVideo.RspShareBackflowVerify paramRspShareBackflowVerify, Object paramObject)
  {
    if (this.b.isDetached()) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new AVSchema.MyMsgListener.1(this, paramRspShareBackflowVerify, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.MyMsgListener
 * JD-Core Version:    0.7.0.1
 */