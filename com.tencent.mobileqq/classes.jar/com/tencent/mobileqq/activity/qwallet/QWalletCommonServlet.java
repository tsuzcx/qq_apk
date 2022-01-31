package com.tencent.mobileqq.activity.qwallet;

import Wallet.DownloadChooseReq;
import Wallet.DownloadChooseRsp;
import Wallet.DownloadReportReq;
import Wallet.GetGroupRedPackListReq;
import Wallet.GetGroupRedPackListRsp;
import Wallet.GetSkinListReq;
import Wallet.GetSkinListRsp;
import Wallet.GoldMsgGetReq;
import Wallet.GoldMsgGetRsp;
import Wallet.GoldMsgSetReq;
import Wallet.GoldMsgSetRsp;
import Wallet.GroupGoldMsgGrabReq;
import Wallet.GroupGoldMsgGrabRsp;
import Wallet.JudgeDownloadReq;
import Wallet.JudgeDownloadRsp;
import Wallet.RedInfoSyncReq;
import Wallet.RedInfoSyncRsp;
import Wallet.ReqWalletConfig;
import Wallet.ResInfo;
import Wallet.RspWalletConfig;
import Wallet.SetSelectedSkinReq;
import Wallet.SetSelectedSkinRsp;
import Wallet.VoiceRedPackMatchReq;
import Wallet.VoiceRedPackMatchRsp;
import Wallet.WalletSkinReq;
import Wallet.WalletSkinRsp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgChatState;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgFriendSet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import xap;

public class QWalletCommonServlet
  extends MSFServlet
{
  public static void a(JceStruct paramJceStruct, int paramInt, BusinessObserver paramBusinessObserver)
  {
    a(paramJceStruct, paramBusinessObserver, paramInt, 0);
  }
  
  private static void a(JceStruct paramJceStruct, int paramInt1, BusinessObserver paramBusinessObserver, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), QWalletCommonServlet.class);
    localNewIntent.putExtra("req", paramJceStruct);
    localNewIntent.putExtra("cmd_type", paramInt1);
    localNewIntent.putExtra("callback_thread_type", paramInt2);
    localNewIntent.setObserver(paramBusinessObserver);
    localAppRuntime.startServlet(localNewIntent);
  }
  
  public static void a(JceStruct paramJceStruct, BusinessObserver paramBusinessObserver)
  {
    a(paramJceStruct, paramBusinessObserver, 0, 0);
  }
  
  public static void a(JceStruct paramJceStruct, BusinessObserver paramBusinessObserver, int paramInt)
  {
    a(paramJceStruct, paramBusinessObserver, 0, paramInt);
  }
  
  public static void a(JceStruct paramJceStruct, BusinessObserver paramBusinessObserver, int paramInt1, int paramInt2)
  {
    DownloadReportReq localDownloadReportReq = null;
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      if ((paramJceStruct instanceof DownloadReportReq))
      {
        a(paramJceStruct, 2, paramBusinessObserver, paramInt2);
        if (!QLog.isColorLevel()) {
          break label883;
        }
        localDownloadReportReq = (DownloadReportReq)paramJceStruct;
        paramBusinessObserver = new StringBuilder().append("send DownloadReportReq|").append(localDownloadReportReq.iType).append("|").append(localDownloadReportReq.sSpeed).append("|");
        paramJceStruct = (JceStruct)localObject1;
        if (localDownloadReportReq.vecResInfo != null)
        {
          paramJceStruct = (JceStruct)localObject1;
          if (localDownloadReportReq.vecResInfo.size() > 0) {
            paramJceStruct = ((ResInfo)localDownloadReportReq.vecResInfo.get(0)).sResId;
          }
        }
        QLog.d("QWalletCommonServlet", 2, paramJceStruct);
        return;
      }
      if (!(paramJceStruct instanceof JudgeDownloadReq)) {
        break label274;
      }
      a(paramJceStruct, 1, paramBusinessObserver, paramInt2);
      if (!QLog.isColorLevel()) {
        break label883;
      }
      localObject1 = (JudgeDownloadReq)paramJceStruct;
      paramBusinessObserver = new StringBuilder().append("send JudgeDownloadReq|").append(((JudgeDownloadReq)localObject1).iType).append("|");
      paramJceStruct = localDownloadReportReq;
      if (((JudgeDownloadReq)localObject1).vecResInfo != null)
      {
        paramJceStruct = localDownloadReportReq;
        if (((JudgeDownloadReq)localObject1).vecResInfo.size() > 0) {
          paramJceStruct = ((ResInfo)((JudgeDownloadReq)localObject1).vecResInfo.get(0)).sResId;
        }
      }
      QLog.d("QWalletCommonServlet", 2, paramJceStruct);
      return;
    }
    catch (Throwable paramJceStruct)
    {
      if (!QLog.isColorLevel()) {
        break label883;
      }
    }
    QLog.e("QWalletCommonServlet", 2, "sendRequest|" + paramJceStruct.toString());
    return;
    label274:
    if ((paramJceStruct instanceof DownloadChooseReq))
    {
      a(paramJceStruct, 3, paramBusinessObserver, paramInt2);
      if (QLog.isColorLevel())
      {
        localObject1 = (DownloadChooseReq)paramJceStruct;
        paramBusinessObserver = new StringBuilder().append("send DownloadChooseReq|");
        paramJceStruct = localObject2;
        if (((DownloadChooseReq)localObject1).vecResInfo != null)
        {
          paramJceStruct = localObject2;
          if (((DownloadChooseReq)localObject1).vecResInfo.size() > 0) {
            paramJceStruct = ((ResInfo)((DownloadChooseReq)localObject1).vecResInfo.get(0)).sResId;
          }
        }
        QLog.d("QWalletCommonServlet", 2, paramJceStruct);
      }
    }
    else if ((paramJceStruct instanceof GoldMsgGetReq))
    {
      a(paramJceStruct, 4, paramBusinessObserver, paramInt2);
      if (QLog.isColorLevel())
      {
        paramJceStruct = (GoldMsgGetReq)paramJceStruct;
        QLog.d("QWalletCommonServlet", 2, "send GoldMsgGetReq.|" + paramJceStruct);
      }
    }
    else if ((paramJceStruct instanceof GoldMsgSetReq))
    {
      a(paramJceStruct, 5, paramBusinessObserver, paramInt2);
      if (QLog.isColorLevel())
      {
        paramJceStruct = (GoldMsgSetReq)paramJceStruct;
        QLog.d("QWalletCommonServlet", 2, "send GoldMsgSetReq.|" + paramJceStruct);
      }
    }
    else if ((paramJceStruct instanceof WalletSkinReq))
    {
      a(paramJceStruct, 6, paramBusinessObserver, paramInt2);
      if (QLog.isColorLevel())
      {
        paramJceStruct = (WalletSkinReq)paramJceStruct;
        QLog.d("QWalletCommonServlet", 2, "send WalletSkinReq|" + paramJceStruct);
      }
    }
    else if ((paramJceStruct instanceof ReqWalletConfig))
    {
      if (paramInt1 != 1) {
        break label884;
      }
    }
    label883:
    label884:
    for (paramInt1 = 17;; paramInt1 = 10)
    {
      a(paramJceStruct, paramInt1, paramBusinessObserver, paramInt2);
      if (QLog.isColorLevel())
      {
        paramJceStruct = (ReqWalletConfig)paramJceStruct;
        QLog.d("QWalletCommonServlet", 2, "send ReqWalletConfig|" + paramJceStruct);
        return;
        if ((paramJceStruct instanceof GroupGoldMsgGrabReq))
        {
          a(paramJceStruct, 11, paramBusinessObserver, paramInt2);
          if (QLog.isColorLevel()) {
            QLog.d("QWalletCommonServlet", 2, "send WalletSkinReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof VoiceRedPackMatchReq))
        {
          a(paramJceStruct, 13, paramBusinessObserver, paramInt2);
          if (QLog.isColorLevel()) {
            QLog.d("QWalletCommonServlet", 2, "send VoiceRedPackMatchReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof GetSkinListReq))
        {
          a(paramJceStruct, 14, paramBusinessObserver, paramInt2);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (GetSkinListReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send GetSkinListReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof SetSelectedSkinReq))
        {
          a(paramJceStruct, 15, paramBusinessObserver, paramInt2);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (SetSelectedSkinReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send SetSelectedSkinReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof GetGroupRedPackListReq))
        {
          a(paramJceStruct, 18, paramBusinessObserver, paramInt2);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (GetGroupRedPackListReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send GetGroupRedPackListReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof RedInfoSyncReq))
        {
          a(paramJceStruct, 19, paramBusinessObserver, paramInt2);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (RedInfoSyncReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send RedInfoSyncReq|" + paramJceStruct);
          }
        }
      }
      return;
    }
  }
  
  public void notifyObserver(Intent paramIntent, int paramInt, boolean paramBoolean, Bundle paramBundle, Class paramClass)
  {
    int i = paramIntent.getIntExtra("callback_thread_type", 0);
    if (i == 0) {
      super.notifyObserver(paramIntent, paramInt, paramBoolean, paramBundle, paramClass);
    }
    do
    {
      do
      {
        return;
      } while ((i == 1) && (!(paramIntent instanceof NewIntent)));
      paramIntent = ((NewIntent)paramIntent).getObserver();
    } while (paramIntent == null);
    ThreadManager.post(new xap(this, paramIntent, paramInt, paramBoolean, paramBundle), 5, null, true);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg == null) || (paramIntent == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QWalletCommonServlet", 2, "onReceive request or response is null");
      }
      return;
    }
    Object localObject1 = paramFromServiceMsg.getServiceCmd();
    Object localObject2;
    if ("AdvRuleSvrCmd.judgeDownload".equals(localObject1))
    {
      localObject1 = null;
      if (paramFromServiceMsg.isSuccess()) {
        localObject1 = (JudgeDownloadRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new JudgeDownloadRsp());
      }
      localObject2 = new Bundle();
      if (localObject1 != null) {
        ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
      }
      ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
      notifyObserver(paramIntent, 1, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
      return;
    }
    if ("AdvRuleSvrCmd.downloadChoose".equals(localObject1))
    {
      localObject1 = null;
      if (paramFromServiceMsg.isSuccess()) {
        localObject1 = (DownloadChooseRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new DownloadChooseRsp());
      }
      localObject2 = new Bundle();
      if (localObject1 != null) {
        ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
      }
      ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
      notifyObserver(paramIntent, 3, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
      return;
    }
    boolean bool2;
    label254:
    boolean bool1;
    Bundle localBundle;
    if ("QQWalletPayReportSvc.getGoldMsgStatus".equals(localObject1))
    {
      bool2 = paramFromServiceMsg.isSuccess();
      if (bool2)
      {
        paramFromServiceMsg = (GoldMsgGetRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GoldMsgGetRsp());
        localObject2 = (GoldMsgGetReq)paramIntent.getSerializableExtra("req");
        if (QLog.isDevelopLevel()) {
          QLog.d("QWalletCommonServlet", 4, "reqFriendSetting onReceive cmd=" + (String)localObject1 + ",isSuccess=" + bool2 + ",req=" + localObject2 + ",rsp=" + paramFromServiceMsg);
        }
        bool1 = bool2;
        if (paramFromServiceMsg != null)
        {
          bool1 = bool2;
          if (paramFromServiceMsg.status != 0) {
            bool1 = false;
          }
        }
        localBundle = new Bundle();
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if (!(localObject1 instanceof QQAppInterface)) {
          break label2183;
        }
      }
    }
    label641:
    label646:
    label2183:
    for (localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();; localObject1 = null)
    {
      label426:
      label468:
      int i;
      if ((bool1) && (paramFromServiceMsg != null) && (localObject2 != null))
      {
        if (((GoldMsgGetReq)localObject2).type == 3)
        {
          long l;
          label530:
          int j;
          if (paramFromServiceMsg.goldMsgSwitch == GoldMsgGetRsp.GOLDMSG_SWITCH_ON)
          {
            l = paramFromServiceMsg.goldMsgPrice;
            GoldMsgChatHelper.GoldMsgChatState localGoldMsgChatState = GoldMsgChatHelper.a().a(0, String.valueOf(((GoldMsgGetReq)localObject2).friendUin));
            if (localGoldMsgChatState != null)
            {
              localGoldMsgChatState.jdField_a_of_type_Long = l;
              if (paramFromServiceMsg.status == GoldMsgGetRsp.STATUS_NOTINWHITELIST) {
                break label635;
              }
              bool2 = true;
              localGoldMsgChatState.jdField_a_of_type_Boolean = bool2;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              QWalletSetting.a((String)localObject1, "goldmsg_setmoneyfrom_" + ((GoldMsgGetReq)localObject2).friendUin, l);
            }
            if (GoldMsgChatHelper.GoldMsgFriendSet.a(String.valueOf(((GoldMsgGetReq)localObject2).friendUin)) == null) {
              break label641;
            }
            i = 1;
            GoldMsgChatHelper.GoldMsgFriendSet.a(paramFromServiceMsg.vGoldMsgFriend);
            if (GoldMsgChatHelper.GoldMsgFriendSet.a(String.valueOf(((GoldMsgGetReq)localObject2).friendUin)) == null) {
              break label646;
            }
            j = 1;
            label554:
            if (j == i) {
              break label652;
            }
          }
          label652:
          for (i = 1;; i = 0)
          {
            localBundle.putSerializable("req", (Serializable)localObject2);
            localBundle.putSerializable("rsp", paramFromServiceMsg);
            notifyObserver(paramIntent, 4, bool1, localBundle, GoldConfigObserver.class);
            if ((localObject2 == null) || (((GoldMsgGetReq)localObject2).type != 3) || (i == 0)) {
              break;
            }
            notifyObserver(paramIntent, 7, bool1, null, GoldConfigObserver.class);
            return;
            paramFromServiceMsg = null;
            break label254;
            l = 1L;
            break label426;
            label635:
            bool2 = false;
            break label468;
            i = 0;
            break label530;
            j = 0;
            break label554;
          }
        }
        if ((((GoldMsgGetReq)localObject2).type == 2) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          if (paramFromServiceMsg.goldMsgSwitch != GoldMsgGetRsp.GOLDMSG_SWITCH_ON) {
            break label709;
          }
        }
      }
      label709:
      for (bool2 = true;; bool2 = false)
      {
        GoldMsgChatHelper.GoldMsgFriendSet.a(String.valueOf(((GoldMsgGetReq)localObject2).friendUin), bool2, paramFromServiceMsg.goldMsgPrice);
        i = 0;
        break;
      }
      if ("QQWalletPayReportSvc.setGoldMsgStatus".equals(localObject1)) {
        if (!paramFromServiceMsg.isSuccess()) {
          break label2177;
        }
      }
      for (localObject1 = (GoldMsgSetRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GoldMsgSetRsp());; localObject1 = null)
      {
        localObject2 = (GoldMsgSetReq)paramIntent.getSerializableExtra("req");
        localBundle = new Bundle();
        if (localObject1 != null)
        {
          localBundle.putSerializable("rsp", (Serializable)localObject1);
          if ((localObject2 != null) && (((GoldMsgSetRsp)localObject1).status == 0))
          {
            localObject1 = BaseApplicationImpl.getApplication().getRuntime();
            if (!(localObject1 instanceof QQAppInterface)) {
              break label2171;
            }
          }
        }
        label2171:
        for (localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();; localObject1 = null)
        {
          if (((GoldMsgSetReq)localObject2).goldMsgSwitch == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              GoldMsgChatHelper.GoldMsgFriendSet.a(String.valueOf(((GoldMsgSetReq)localObject2).friendUin), bool1, ((GoldMsgSetReq)localObject2).goldMsgPrice);
            }
            localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
            notifyObserver(paramIntent, 5, paramFromServiceMsg.isSuccess(), localBundle, GoldConfigObserver.class);
            return;
          }
          if ("QQWalletPayReportSvc.getWalletSkin".equals(localObject1))
          {
            localObject1 = null;
            if (paramFromServiceMsg.isSuccess()) {
              localObject1 = (WalletSkinRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new WalletSkinRsp());
            }
            localObject2 = new Bundle();
            if (localObject1 != null) {
              ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
            }
            ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
            notifyObserver(paramIntent, 6, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
            return;
          }
          if ("WalletConfigSvr.getConfig".equals(localObject1))
          {
            localObject1 = null;
            if (paramFromServiceMsg.isSuccess()) {
              localObject1 = (RspWalletConfig)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new RspWalletConfig());
            }
            localObject2 = new Bundle();
            if (localObject1 != null) {
              ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
            }
            ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
            notifyObserver(paramIntent, 10, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
            return;
          }
          if ("WalletConfigSvr.setUserSession".equals(localObject1))
          {
            localObject1 = null;
            if (paramFromServiceMsg.isSuccess()) {
              localObject1 = (RspWalletConfig)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new RspWalletConfig());
            }
            localObject2 = new Bundle();
            if (localObject1 != null) {
              ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
            }
            ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
            notifyObserver(paramIntent, 17, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
            return;
          }
          if ((localObject1 != null) && (((String)localObject1).startsWith("QPayGoldMsg.104602")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QWalletCommonServlet", 2, "gold group msg grap back...");
            }
            localObject1 = null;
            if (paramFromServiceMsg.isSuccess()) {
              localObject1 = (GroupGoldMsgGrabRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GroupGoldMsgGrabRsp());
            }
            if (QLog.isColorLevel()) {
              QLog.d("QWalletCommonServlet", 2, "CMD_GOLDMSG_GROUP_GRAP isSuccess:" + paramFromServiceMsg.isSuccess());
            }
            if ((localObject1 != null) && (QLog.isColorLevel())) {
              QLog.d("QWalletCommonServlet", 2, "rsp.retcode = " + ((GroupGoldMsgGrabRsp)localObject1).retcode + " \nrsp.retmsg = " + ((GroupGoldMsgGrabRsp)localObject1).retmsg);
            }
            localObject2 = new Bundle();
            if (localObject1 != null) {
              ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
            }
            ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
            ((Bundle)localObject2).putInt("msfRetCode", paramFromServiceMsg.getResultCode());
            notifyObserver(paramIntent, 11, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
            return;
          }
          if ((localObject1 != null) && (((String)localObject1).startsWith("QQwalletVoicePack.macthVoice")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QWalletCommonServlet", 2, "voice redpacket msg grap back...");
            }
            localObject1 = null;
            if (paramFromServiceMsg.isSuccess()) {
              localObject1 = (VoiceRedPackMatchRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new VoiceRedPackMatchRsp());
            }
            if (QLog.isColorLevel()) {
              QLog.d("QWalletCommonServlet", 2, "CMD_VOICE_RED_PACKET isSuccess:" + paramFromServiceMsg.isSuccess());
            }
            if ((localObject1 != null) && (QLog.isColorLevel())) {
              QLog.d("QWalletCommonServlet", 2, "rsp.status = " + ((VoiceRedPackMatchRsp)localObject1).status);
            }
            localObject2 = new Bundle();
            if (localObject1 != null) {
              ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
            }
            ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
            ((Bundle)localObject2).putInt("msfRetCode", paramFromServiceMsg.getResultCode());
            notifyObserver(paramIntent, 13, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
            return;
          }
          if ("VAC_RedEnvelopeSkinSvc.GetSkinList".equals(localObject1))
          {
            localObject1 = null;
            if (QLog.isColorLevel()) {
              QLog.d("QWalletCommonServlet", 2, "GetSkinListRsp isSuccess:" + paramFromServiceMsg.isSuccess());
            }
            if (paramFromServiceMsg.isSuccess()) {
              localObject1 = (GetSkinListRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetSkinListRsp());
            }
            localObject2 = new Bundle();
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QWalletCommonServlet", 2, "GetSkinListRsp = " + localObject1);
              }
              ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
            }
            ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
            notifyObserver(paramIntent, 14, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
            return;
          }
          if ("VAC_RedEnvelopeSkinSvc.SetSelectedSkin".equals(localObject1))
          {
            localObject1 = null;
            if (QLog.isColorLevel()) {
              QLog.d("QWalletCommonServlet", 2, "SetSelectedSkinRsp isSuccess:" + paramFromServiceMsg.isSuccess());
            }
            if (paramFromServiceMsg.isSuccess()) {
              localObject1 = (SetSelectedSkinRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new SetSelectedSkinRsp());
            }
            localObject2 = new Bundle();
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QWalletCommonServlet", 2, "SetSelectedSkinRsp = " + localObject1);
              }
              ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
            }
            ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
            notifyObserver(paramIntent, 15, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
            return;
          }
          if ("GroupRedPackListSvc.getGroupRedPackList".equals(localObject1))
          {
            localObject1 = null;
            if (QLog.isColorLevel()) {
              QLog.d("QWalletCommonServlet", 2, "GetGroupRedPackListRsp isSuccess:" + paramFromServiceMsg.isSuccess());
            }
            if (paramFromServiceMsg.isSuccess()) {
              localObject1 = (GetGroupRedPackListRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetGroupRedPackListRsp());
            }
            localObject2 = new Bundle();
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QWalletCommonServlet", 2, "GetGroupRedPackListRsp = " + localObject1);
              }
              ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
            }
            ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
            notifyObserver(paramIntent, 18, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
            return;
          }
          if (!"WalletConfigSvr.syncRedInfo".equals(localObject1)) {
            break;
          }
          localObject1 = null;
          if (paramFromServiceMsg.isSuccess()) {
            localObject1 = (RedInfoSyncRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new RedInfoSyncRsp());
          }
          localObject2 = new Bundle();
          if (localObject1 != null) {
            ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
          }
          ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 19, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
          return;
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    switch (paramIntent.getExtras().getInt("cmd_type"))
    {
    case 7: 
    case 8: 
    case 9: 
    case 12: 
    case 16: 
    default: 
      return;
    case 1: 
      try
      {
        paramPacket.addRequestPacket("req", (JudgeDownloadReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("AdvRuleSvrCmd.judgeDownload");
        paramPacket.setFuncName("judgeDownload");
        paramPacket.setServantName("Wallet.FrequencyControlServer.FrequencyControlObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 2: 
      try
      {
        paramPacket.addRequestPacket("req", (DownloadReportReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("AdvRuleSvrCmd.downloadReport");
        paramPacket.setFuncName("downloadReport");
        paramPacket.setServantName("Wallet.FrequencyControlServer.FrequencyControlObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 3: 
      try
      {
        paramPacket.addRequestPacket("req", (DownloadChooseReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("AdvRuleSvrCmd.downloadChoose");
        paramPacket.setFuncName("downloadChoose");
        paramPacket.setServantName("Wallet.FrequencyControlServer.FrequencyControlObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 4: 
      try
      {
        paramPacket.addRequestPacket("req", (GoldMsgGetReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("QQWalletPayReportSvc.getGoldMsgStatus");
        paramPacket.setServantName("Wallet.GoldMsgConfigServer.GoldMsgConfigObj");
        paramPacket.setFuncName("getGoldMsgStatus");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 5: 
      try
      {
        paramPacket.addRequestPacket("req", (GoldMsgSetReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("QQWalletPayReportSvc.setGoldMsgStatus");
        paramPacket.setServantName("Wallet.GoldMsgConfigServer.GoldMsgConfigObj");
        paramPacket.setFuncName("setGoldMsgStatus");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 6: 
      try
      {
        paramPacket.addRequestPacket("req", (WalletSkinReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("QQWalletPayReportSvc.getWalletSkin");
        paramPacket.setFuncName("getWalletSkin");
        paramPacket.setServantName("Wallet.WalletSkinServer.WalletSkinObj");
        paramPacket.setTimeout(15000L);
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 10: 
      try
      {
        paramPacket.addRequestPacket("req", (ReqWalletConfig)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("WalletConfigSvr.getConfig");
        paramPacket.setFuncName("getConfig");
        paramPacket.setServantName("Wallet.MobileWalletConfigServer.MobileWalletConfigObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 17: 
      try
      {
        paramPacket.addRequestPacket("req", (ReqWalletConfig)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("WalletConfigSvr.setUserSession");
        paramPacket.setFuncName("setUserSession");
        paramPacket.setServantName("Wallet.MobileWalletConfigServer.MobileWalletConfigObj");
        return;
      }
      catch (Throwable paramIntent)
      {
        return;
      }
    case 11: 
      if (QLog.isColorLevel()) {
        QLog.d("QWalletCommonServlet", 2, "build gold group sso package...");
      }
      try
      {
        paramIntent = (GroupGoldMsgGrabReq)paramIntent.getSerializableExtra("req");
        paramPacket.addRequestPacket("req", paramIntent);
        paramPacket.setSSOCommand(String.format("%s.%s", new Object[] { "QPayGoldMsg.104602", paramIntent.groupcode }));
        paramPacket.setFuncName("SSOProxy");
        paramPacket.setServantName("Comm.RelayProxyServer.RelayProxyObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 13: 
      if (QLog.isColorLevel()) {
        QLog.d("QWalletCommonServlet", 2, "build voice redpacket sso package...");
      }
      try
      {
        paramPacket.addRequestPacket("req", (VoiceRedPackMatchReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("QQwalletVoicePack.macthVoice");
        paramPacket.setFuncName("macthVoice");
        paramPacket.setServantName("Wallet.VoiceMatchServer.VoiceMatchObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 14: 
      try
      {
        paramPacket.addRequestPacket("req", (GetSkinListReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("VAC_RedEnvelopeSkinSvc.GetSkinList");
        paramPacket.setFuncName("GetSkinList");
        paramPacket.setServantName("Wallet.RedEnvelopeSkinServer.RedEnvelopeSkinObj");
        paramPacket.setTimeout(15000L);
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 15: 
      try
      {
        paramPacket.addRequestPacket("req", (SetSelectedSkinReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("VAC_RedEnvelopeSkinSvc.SetSelectedSkin");
        paramPacket.setFuncName("SetSelectedSkin");
        paramPacket.setServantName("Wallet.RedEnvelopeSkinServer.RedEnvelopeSkinObj");
        paramPacket.setTimeout(15000L);
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 18: 
      try
      {
        paramPacket.addRequestPacket("req", (GetGroupRedPackListReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("GroupRedPackListSvc.getGroupRedPackList");
        paramPacket.setFuncName("getGroupRedPackList");
        paramPacket.setServantName("Wallet.GroupRedPackListServer.GroupRedPackListObj");
        paramPacket.setTimeout(5000L);
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    }
    try
    {
      paramPacket.addRequestPacket("req", (RedInfoSyncReq)paramIntent.getSerializableExtra("req"));
      paramPacket.setSSOCommand("WalletConfigSvr.syncRedInfo");
      paramPacket.setFuncName("syncRedInfo");
      paramPacket.setServantName("Wallet.MobileWalletConfigServer.MobileWalletConfigObj");
      return;
    }
    catch (OutOfMemoryError paramIntent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet
 * JD-Core Version:    0.7.0.1
 */