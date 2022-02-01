package com.tencent.biz.pubaccount.weishi_new.net.common;

import com.qq.jce.wup.UniAttribute;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;

public abstract interface WSResponseDecoder$DecodeCallback<T>
{
  public abstract void decodeFailure(UniAttribute paramUniAttribute, int paramInt, String paramString);
  
  public abstract void decodeSuccess(T paramT, int paramInt, String paramString, RspHeaderBean paramRspHeaderBean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSResponseDecoder.DecodeCallback
 * JD-Core Version:    0.7.0.1
 */