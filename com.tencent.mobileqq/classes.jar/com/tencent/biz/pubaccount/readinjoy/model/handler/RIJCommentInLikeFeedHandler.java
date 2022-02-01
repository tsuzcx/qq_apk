package com.tencent.biz.pubaccount.readinjoy.model.handler;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspBody;

public abstract class RIJCommentInLikeFeedHandler
  extends RIJBaseArticleInfoHandler
{
  public RIJCommentInLikeFeedHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  protected int a(FromServiceMsg paramFromServiceMsg, Object paramObject, MessageMicro paramMessageMicro)
  {
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramMessageMicro);
    QLog.d("RIJCommentInLikeFeedHandler", 1, "parse0x83eRspResultCode result code :" + j);
    int i = j;
    if (j == 84) {
      i = 0;
    }
    return i;
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 5;
    boolean bool = true;
    int k = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0xb83.RspBody());
    int i;
    if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1))) {
      i = 4;
    }
    for (;;)
    {
      if (i == 4) {
        ReadinjoyReportUtils.a(k, paramToServiceMsg, 1, null);
      }
      if (i == 0) {
        ReadinjoyReportUtils.a(k, paramToServiceMsg, 3, null);
      }
      paramFromServiceMsg = ReadInJoyUtils.a();
      if (k == 0) {}
      for (;;)
      {
        RIJStatisticCollectorReport.a(paramFromServiceMsg, bool, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"), k, i);
        return;
        if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(2)))
        {
          i = 4;
          break;
        }
        i = j;
        if (paramToServiceMsg.getAttribute("ugc_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1))) {
          break;
        }
        i = j;
        if (paramToServiceMsg.getAttribute("up_master_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1))) {
          break;
        }
        if (paramToServiceMsg.getAttribute("submit_comment", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          i = 0;
          break;
        }
        if (paramToServiceMsg.getAttributes().get("0x83e_upvote_operation_type") == null) {
          break label241;
        }
        i = ((Integer)paramToServiceMsg.getAttributes().get("0x83e_upvote_operation_type")).intValue();
        break;
        bool = false;
      }
      label241:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedHandler
 * JD-Core Version:    0.7.0.1
 */