package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stRedDotReq;
import UserGrowth.stRedDotRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;

public class RedDotRequest
  extends WeishiRequest<stRedDotRsp>
{
  public RedDotRequest()
  {
    super("RedDot", 10001);
    this.c = new stRedDotReq(111, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.RedDotRequest
 * JD-Core Version:    0.7.0.1
 */