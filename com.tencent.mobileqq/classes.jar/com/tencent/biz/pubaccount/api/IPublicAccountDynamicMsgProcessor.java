package com.tencent.biz.pubaccount.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IPublicAccountDynamicMsgProcessor
  extends QRouteApi
{
  public abstract IPublicAccountDynamicMsgProcessor init(AppInterface paramAppInterface, BusinessHandler paramBusinessHandler);
  
  public abstract void processHistoryMsg(long paramLong, List<msg_comm.Msg> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountDynamicMsgProcessor
 * JD-Core Version:    0.7.0.1
 */