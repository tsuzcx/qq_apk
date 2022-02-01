package com.tencent.biz.pubaccount.api.impl;

import android.content.Intent;
import android.os.Bundle;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.accountdetail.jce.GetRecvMsgStateReq;
import com.tencent.biz.pubaccount.accountdetail.jce.SetRecvMsgStateReq;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJNetworkUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.app.Servlet;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class PublicAccountServletImpl
  extends MSFServlet
  implements IPublicAccountServlet
{
  public static final String CMD_KANDIAN_BIU_GUIDE = "KandianSvc_biu_guide.";
  public static final String CMD_PREFIX_PUBLIC = "PubAccountSvc.";
  public static final String CMD_PREFIX_PUBLIC_REPORT = "PubAccountAdSvc.";
  private static final String NAME_NEED_HANDLER = "need_handler";
  private String TAG = "com.tencent.biz.pubaccount.api.impl.PublicAccountServlet";
  
  public void configNeedHandler(Intent paramIntent)
  {
    paramIntent.putExtra("need_handler", true);
  }
  
  protected byte[] getResponseBytesData(FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      return WupUtil.b(paramFromServiceMsg.getWupBuffer());
    }
    return null;
  }
  
  public Class<? extends Servlet> getServletClass()
  {
    return getClass();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onReceive");
    }
    byte[] arrayOfByte = getResponseBytesData(paramFromServiceMsg);
    ((IRIJNetworkUtils)QRoute.api(IRIJNetworkUtils.class)).debugReceivePb(paramFromServiceMsg);
    Object localObject = new Bundle();
    ((Bundle)localObject).putByteArray("data", arrayOfByte);
    ((Bundle)localObject).putInt("respones_code", paramFromServiceMsg.getBusinessFailCode());
    ((Bundle)localObject).putInt("type", paramIntent.getIntExtra("type", 0));
    if (paramIntent.getBooleanExtra("need_handler", false))
    {
      localObject = (PublicAccountHandlerImpl)((QQAppInterface)super.getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (localObject != null) {
        ((PublicAccountHandlerImpl)localObject).onReceive(paramIntent, paramFromServiceMsg, arrayOfByte);
      }
    }
    else
    {
      super.notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), (Bundle)localObject, null);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onReceive exit");
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onSend");
    }
    byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("data");
    Object localObject2 = paramIntent.getStringExtra("cmd");
    ((IRIJNetworkUtils)QRoute.api(IRIJNetworkUtils.class)).debugSendPb(arrayOfByte2, (String)localObject2);
    if (((String)localObject2).equals("get_business_recommend"))
    {
      paramIntent = new StringBuilder();
      paramIntent.append("PubAccBusiRecSvc.");
      paramIntent.append((String)localObject2);
      paramPacket.setSSOCommand(paramIntent.toString());
      localObject1 = arrayOfByte2;
    }
    else if (((String)localObject2).equals("post_punchcard_info"))
    {
      paramIntent = new StringBuilder();
      paramIntent.append("PubAccountSSOProxySvc.");
      paramIntent.append((String)localObject2);
      paramPacket.setSSOCommand(paramIntent.toString());
      localObject1 = arrayOfByte2;
    }
    else if ((!((String)localObject2).equals("PubAccountFollowSvc.follow")) && (!((String)localObject2).equals("PubAccountFollowSvc.subscribe")))
    {
      if (((String)localObject2).equals("PubAccountAdSvc.recent_list_report"))
      {
        paramPacket.setSSOCommand((String)localObject2);
        localObject1 = arrayOfByte2;
        break label1181;
      }
      if ((!((String)localObject2).equals("PubAccountArticleCenter.GetUrlByVid")) && (!((String)localObject2).equals("PubAccountArticleCenter.GetVidByUrl")) && (!((String)localObject2).equals("SQQShopAdSvr.GetUrlByVid")))
      {
        if (((String)localObject2).equals("PubAccountAdSvc."))
        {
          paramPacket.setSSOCommand("PubAccountAdSvc.ad_report");
          localObject1 = arrayOfByte2;
          break label1181;
        }
        if ((!((String)localObject2).equals("PubAccountSvc.net_connect_info")) && (!((String)localObject2).equals("PubAccountArticleCenter.GetRecommendPubAccount")) && (!((String)localObject2).equals("KdAdReportSsoSvr.kandian_ad")) && (!((String)localObject2).equals("KdAdReportSsoSvr.kandian_ad_report")) && (!((String)localObject2).equals("KdAdReportSsoSvr.kandian_ad_native")) && (!((String)localObject2).equals("KdAdReportSsoSvr.kandian_ad_report_new")) && (!((String)localObject2).equals("KdAdReportSsoSvr.kandian_ad_report_test")) && (!((String)localObject2).equals("MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_fetch")) && (!((String)localObject2).equals("MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_create")) && (!((String)localObject2).equals("MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_delete")) && (!((String)localObject2).equals("MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_like")) && (!((String)localObject2).equals("MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_report")) && (!((String)localObject2).equals("MQUpdateSvc_com_qq_kandian.web.firstCommentRead.getNewestList")) && (!((String)localObject2).equals("FeedsContentCenter.QualityReport")))
        {
          if (((String)localObject2).equals("getGuideFriends"))
          {
            paramIntent = new StringBuilder();
            paramIntent.append("KandianSvc_biu_guide.");
            paramIntent.append((String)localObject2);
            paramPacket.setSSOCommand(paramIntent.toString());
            localObject1 = arrayOfByte2;
            break label1181;
          }
          if (!((String)localObject2).equals("ConfigSvc.getRecvMsgState")) {}
        }
      }
    }
    try
    {
      localObject1 = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getName());
      paramIntent = ((ToServiceMsg)localObject1).getServiceCmd();
      localObject1 = (GetRecvMsgStateReq)((ToServiceMsg)localObject1).getAttribute("GetRecvMsgStateReq");
      paramPacket.setServantName("QQMP.ConfigServer.ConfigObj");
      paramPacket.setFuncName("getRecvMsgState");
      paramPacket.addRequestPacket("req", (JceStruct)localObject1);
      paramPacket.setSSOCommand(paramIntent);
      paramPacket.setTimeout(15000L);
      localObject1 = arrayOfByte2;
    }
    catch (Exception paramIntent)
    {
      label520:
      break label520;
    }
    Object localObject1 = arrayOfByte2;
    if (QLog.isColorLevel())
    {
      QLog.i(this.TAG, 2, "onSend exception");
      localObject1 = arrayOfByte2;
      break label1181;
      if (!((String)localObject2).equals("ConfigSvc.setRecvMsgState")) {}
    }
    try
    {
      localObject1 = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getName());
      paramIntent = ((ToServiceMsg)localObject1).getServiceCmd();
      localObject1 = (SetRecvMsgStateReq)((ToServiceMsg)localObject1).getAttribute("SetRecvMsgStateReq");
      paramPacket.setServantName("QQMP.ConfigServer.ConfigObj");
      paramPacket.setFuncName("setRecvMsgState");
      paramPacket.addRequestPacket("req", (JceStruct)localObject1);
      paramPacket.setSSOCommand(paramIntent);
      paramPacket.setTimeout(15000L);
      localObject1 = arrayOfByte2;
    }
    catch (Exception paramIntent)
    {
      label634:
      oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest;
      long l2;
      long l1;
      byte[] arrayOfByte1;
      IPublicAccountUtil localIPublicAccountUtil;
      QQAppInterface localQQAppInterface;
      StringBuilder localStringBuilder;
      break label634;
    }
    localObject1 = arrayOfByte2;
    if (QLog.isColorLevel())
    {
      QLog.i(this.TAG, 2, "onSend exception");
      localObject1 = arrayOfByte2;
      break label1181;
      if ("CertifiedAccountSvc.certified_account_read.GetFollowList".equals(localObject2))
      {
        paramPacket.setSSOCommand((String)localObject2);
        paramPacket.setTimeout(30000L);
        paramPacket.autoResend = true;
      }
      else if ("get_follow_list".equals(localObject2))
      {
        paramPacket.autoResend = true;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("PubAccountSvc.");
        ((StringBuilder)localObject1).append((String)localObject2);
        paramPacket.setSSOCommand(((StringBuilder)localObject1).toString());
      }
      else if ((!"CertifiedAccountSvc.certified_account_read.GetAccountMenu".equals(localObject2)) && (!"CertifiedAccountSvc.certified_account_write.SendMenuEvent".equals(localObject2)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("PubAccountSvc.");
        ((StringBuilder)localObject1).append((String)localObject2);
        paramPacket.setSSOCommand(((StringBuilder)localObject1).toString());
      }
      else
      {
        paramPacket.setSSOCommand((String)localObject2);
      }
      localObject1 = arrayOfByte2;
      if (((String)localObject2).equals("get_detail_info"))
      {
        localObject2 = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
        try
        {
          ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject2).mergeFrom(arrayOfByte2);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        localGetPublicAccountDetailInfoRequest = new oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest();
        l2 = ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject2).uin.get();
        l1 = l2;
        if (l2 < 0L) {
          l1 = -(-2147483648L - l2) + 2147483647L + 1L;
        }
        if (!paramIntent.getBooleanExtra("useNewProtocol", false))
        {
          arrayOfByte1 = arrayOfByte2;
          if ((super.getAppRuntime() instanceof QQAppInterface))
          {
            localIPublicAccountUtil = (IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class);
            localQQAppInterface = (QQAppInterface)super.getAppRuntime();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(l1);
            localStringBuilder.append("");
            arrayOfByte1 = arrayOfByte2;
            if (localIPublicAccountUtil.getAccountType(localQQAppInterface, localStringBuilder.toString()) == -4) {}
          }
        }
        else
        {
          paramIntent.putExtra("type", 1);
          localGetPublicAccountDetailInfoRequest.luin.set(l1);
          localGetPublicAccountDetailInfoRequest.seqno.set(((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject2).seqno.get());
          localGetPublicAccountDetailInfoRequest.version.set(((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject2).version.get());
          localGetPublicAccountDetailInfoRequest.versionInfo.set(((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject2).versionInfo.get());
          paramIntent = new oidb_sso.OIDBSSOPkg();
          paramIntent.uint32_command.set(3320);
          paramIntent.uint32_result.set(0);
          paramIntent.uint32_service_type.set(1);
          paramIntent.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localGetPublicAccountDetailInfoRequest.toByteArray()));
          arrayOfByte1 = paramIntent.toByteArray();
          paramPacket.setSSOCommand("OidbSvc.0xcf8");
          break label1181;
          paramPacket.setTimeout(15000L);
          paramPacket.setSSOCommand((String)localObject2);
          arrayOfByte1 = arrayOfByte2;
          break label1181;
          paramPacket.setTimeout(15000L);
          paramPacket.setSSOCommand((String)localObject2);
          arrayOfByte1 = arrayOfByte2;
          break label1181;
          paramPacket.setTimeout(10000L);
          paramPacket.setSSOCommand((String)localObject2);
          arrayOfByte1 = arrayOfByte2;
        }
      }
    }
    label1181:
    if (arrayOfByte1 != null) {
      paramPacket.putSendData(WupUtil.a(arrayOfByte1));
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onSend exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl
 * JD-Core Version:    0.7.0.1
 */