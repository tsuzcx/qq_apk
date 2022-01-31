package com.tencent.biz.pubaccount;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class PublicAccountServlet
  extends MSFServlet
{
  private String a = "com.tencent.biz.pubaccount.PublicAccountServlet";
  
  public static void a(Intent paramIntent)
  {
    paramIntent.putExtra("need_handler", true);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "onReceive");
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (byte[] arrayOfByte = WupUtil.b(paramFromServiceMsg.getWupBuffer());; arrayOfByte = null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putByteArray("data", arrayOfByte);
      ((Bundle)localObject).putInt("respones_code", paramFromServiceMsg.getBusinessFailCode());
      if (paramIntent.getBooleanExtra("need_handler", false))
      {
        localObject = (PublicAccountHandler)((QQAppInterface)super.getAppRuntime()).a(11);
        if (localObject != null) {
          ((PublicAccountHandler)localObject).a(paramIntent, paramFromServiceMsg, arrayOfByte);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "onReceive exit");
        }
        return;
        super.notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), (Bundle)localObject, null);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "onSend");
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramIntent = paramIntent.getStringExtra("cmd");
    if (paramIntent.equals("get_business_recommend")) {
      paramPacket.setSSOCommand("PubAccBusiRecSvc." + paramIntent);
    }
    for (;;)
    {
      paramPacket.putSendData(WupUtil.a(arrayOfByte));
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "onSend exit");
      }
      return;
      if (paramIntent.equals("post_punchcard_info"))
      {
        paramPacket.setSSOCommand("PubAccountSSOProxySvc." + paramIntent);
      }
      else if ((paramIntent.equals("PubAccountFollowSvc.follow")) || (paramIntent.equals("PubAccountFollowSvc.subscribe")))
      {
        paramPacket.setTimeout(10000L);
        paramPacket.setSSOCommand(paramIntent);
      }
      else if (paramIntent.equals("PubAccountAdSvc.recent_list_report"))
      {
        paramPacket.setSSOCommand(paramIntent);
      }
      else if ((paramIntent.equals("PubAccountArticleCenter.GetUrlByVid")) || (paramIntent.equals("PubAccountArticleCenter.GetVidByUrl")) || (paramIntent.equals("SQQShopAdSvr.GetUrlByVid")))
      {
        paramPacket.setTimeout(15000L);
        paramPacket.setSSOCommand(paramIntent);
      }
      else if (paramIntent.equals("PubAccountAdSvc."))
      {
        paramPacket.setSSOCommand("PubAccountAdSvc.ad_report");
      }
      else if ((paramIntent.equals("PubAccountSvc.net_connect_info")) || (paramIntent.equals("PubAccountArticleCenter.GetRecommendPubAccount")) || (paramIntent.equals("MQUpdateSvc_com_qq_mp.web.proxy.kandian_ad")) || (paramIntent.equals("MQUpdateSvc_com_qq_mp.web.proxy.kandian_ad_report")) || (paramIntent.equals("MQUpdateSvc_com_qq_mp.web.proxy.kandian_ad_native")) || (paramIntent.equals("MQUpdateSvc_com_qq_mp.web.proxy.kandian_ad_report_new")) || (paramIntent.equals("MQUpdateSvc_com_qq_mp.web.proxy.kandian_ad_report_test")) || (paramIntent.equals(NativeCommentServlet.c)) || (paramIntent.equals(NativeCommentServlet.b)) || (paramIntent.equals(NativeCommentServlet.d)) || (paramIntent.equals(NativeCommentServlet.e)))
      {
        paramPacket.setTimeout(15000L);
        paramPacket.setSSOCommand(paramIntent);
      }
      else if (paramIntent.equals("getGuideFriends"))
      {
        paramPacket.setSSOCommand("KandianSvc_biu_guide." + paramIntent);
      }
      else
      {
        paramPacket.setSSOCommand("PubAccountSvc." + paramIntent);
        if ("get_follow_list".equals(paramIntent)) {
          paramPacket.autoResend = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountServlet
 * JD-Core Version:    0.7.0.1
 */