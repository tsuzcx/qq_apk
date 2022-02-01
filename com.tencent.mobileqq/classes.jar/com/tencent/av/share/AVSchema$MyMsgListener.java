package com.tencent.av.share;

import android.os.Handler;
import android.os.Looper;
import com.tencent.av.ReqGroupVideo.ReqShareBackflowVerify;
import com.tencent.av.ReqGroupVideo.RspShareBackflowVerify;
import com.tencent.av.business.handler.MessageHandler.MsgListener;

class AVSchema$MyMsgListener
  extends MessageHandler.MsgListener<ReqGroupVideo.ReqShareBackflowVerify, ReqGroupVideo.RspShareBackflowVerify>
{
  AVSchema.Info jdField_a_of_type_ComTencentAvShareAVSchema$Info;
  
  AVSchema$MyMsgListener(AVSchema paramAVSchema, AVSchema.Info paramInfo)
  {
    this.jdField_a_of_type_ComTencentAvShareAVSchema$Info = paramInfo;
  }
  
  public void a(long paramLong, boolean paramBoolean, ReqGroupVideo.ReqShareBackflowVerify paramReqShareBackflowVerify, ReqGroupVideo.RspShareBackflowVerify paramRspShareBackflowVerify, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentAvShareAVSchema.isDetached()) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new AVSchema.MyMsgListener.1(this, paramRspShareBackflowVerify, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.MyMsgListener
 * JD-Core Version:    0.7.0.1
 */