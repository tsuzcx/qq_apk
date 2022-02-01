package com.tencent.biz.pubaccount.weishi_new.recommend.data;

import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;

public abstract interface IWSNoticeRspListener
{
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(stNotificationRsp paramstNotificationRsp, RspHeaderBean paramRspHeaderBean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.IWSNoticeRspListener
 * JD-Core Version:    0.7.0.1
 */