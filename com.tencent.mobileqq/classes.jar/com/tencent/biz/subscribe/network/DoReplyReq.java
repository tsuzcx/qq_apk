package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoReplyReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoReplyRsp;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class DoReplyReq
  extends VSBaseRequest
{
  public static final int OPER_TYPE_ADD = 1;
  public static final int OPER_TYPE_DELETE = 0;
  CertifiedAccountWrite.StDoReplyReq req = new CertifiedAccountWrite.StDoReplyReq();
  
  public DoReplyReq(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply, int paramInt)
  {
    this.req.feed.set(paramStFeed);
    this.req.comment.set(paramStComment);
    this.req.reply.set(paramStReply);
    this.req.replyType.set(paramInt);
    if (paramInt == 1) {
      this.req.reply.id.set("");
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CertifiedAccountWrite.StDoReplyRsp localStDoReplyRsp = new CertifiedAccountWrite.StDoReplyRsp();
    localStDoReplyRsp.mergeFrom(paramArrayOfByte);
    return localStDoReplyRsp;
  }
  
  public String getCmdName()
  {
    return "CertifiedAccountSvc.certified_account_write.DoReply";
  }
  
  public byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.network.DoReplyReq
 * JD-Core Version:    0.7.0.1
 */