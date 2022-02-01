package com.tencent.mobileqq.activity.qwallet;

import Wallet.AuthCodeReq;
import Wallet.AuthCodeRsp;
import Wallet.DownloadChooseReq;
import Wallet.DownloadChooseRsp;
import Wallet.DownloadReportReq;
import Wallet.FocusMpIdReq;
import Wallet.FocusMpIdRsp;
import Wallet.GetBroadCastHbIdiomReq;
import Wallet.GetBroadCastHbIdiomRsp;
import Wallet.GetGroupRedPackListReq;
import Wallet.GetGroupRedPackListRsp;
import Wallet.GetMiniAppReq;
import Wallet.GetMiniAppRsp;
import Wallet.GetRandomHbIdiomReq;
import Wallet.GetRandomHbIdiomRsp;
import Wallet.GetSkinListReq;
import Wallet.GetSkinListRsp;
import Wallet.IdiomRedPackMatchReq;
import Wallet.IdiomRedPackMatchRsp;
import Wallet.IsUinFocusMpIdReq;
import Wallet.IsUinFocusMpIdRsp;
import Wallet.JudgeDownloadReq;
import Wallet.JudgeDownloadRsp;
import Wallet.RedInfoSyncReq;
import Wallet.RedInfoSyncRsp;
import Wallet.ReportHBGameReq;
import Wallet.ReportHBGameRsp;
import Wallet.ReqWalletConfig;
import Wallet.ResInfo;
import Wallet.RspWalletConfig;
import Wallet.SetSelectedSkinReq;
import Wallet.SetSelectedSkinRsp;
import Wallet.SongRedPackMatchReq;
import Wallet.SongRedPackMatchRsp;
import Wallet.VoiceRedPackMatchReq;
import Wallet.VoiceRedPackMatchRsp;
import Wallet.WalletSkinReq;
import Wallet.WalletSkinRsp;
import android.content.Intent;
import android.os.Bundle;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.protocol.GetArkTailReq;
import com.tencent.mobileqq.gamecenter.protocol.GetArkTailRsp;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoReq;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp;
import com.tencent.mobileqq.gamecenter.protocol.ReportTypeReq;
import com.tencent.mobileqq.gamecenter.protocol.ReportTypeRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

public class QWalletCommonServlet
  extends MSFServlet
{
  public static void a(JceStruct paramJceStruct, int paramInt, BusinessObserver paramBusinessObserver)
  {
    a(paramJceStruct, paramBusinessObserver, paramInt, 0, null);
  }
  
  private static void a(JceStruct paramJceStruct, int paramInt1, BusinessObserver paramBusinessObserver, int paramInt2, AppRuntime paramAppRuntime)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    }
    paramAppRuntime = new NewIntent(localAppRuntime.getApplication(), QWalletCommonServlet.class);
    paramAppRuntime.putExtra("req", paramJceStruct);
    paramAppRuntime.putExtra("cmd_type", paramInt1);
    paramAppRuntime.putExtra("callback_thread_type", paramInt2);
    paramAppRuntime.setObserver(paramBusinessObserver);
    localAppRuntime.startServlet(paramAppRuntime);
  }
  
  public static void a(JceStruct paramJceStruct, BusinessObserver paramBusinessObserver)
  {
    a(paramJceStruct, paramBusinessObserver, 0, 0, null);
  }
  
  public static void a(JceStruct paramJceStruct, BusinessObserver paramBusinessObserver, int paramInt)
  {
    a(paramJceStruct, paramBusinessObserver, 0, paramInt, null);
  }
  
  public static void a(JceStruct paramJceStruct, BusinessObserver paramBusinessObserver, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      if ((paramJceStruct instanceof DownloadReportReq))
      {
        a(paramJceStruct, 2, paramBusinessObserver, paramInt2, paramAppRuntime);
        if (!QLog.isColorLevel()) {
          break label1402;
        }
        paramAppRuntime = (DownloadReportReq)paramJceStruct;
        paramBusinessObserver = new StringBuilder().append("send DownloadReportReq|").append(paramAppRuntime.iType).append("|").append(paramAppRuntime.sSpeed).append("|");
        paramJceStruct = localObject1;
        if (paramAppRuntime.vecResInfo != null)
        {
          paramJceStruct = localObject1;
          if (paramAppRuntime.vecResInfo.size() > 0) {
            paramJceStruct = ((ResInfo)paramAppRuntime.vecResInfo.get(0)).sResId;
          }
        }
        QLog.d("QWalletCommonServlet", 2, paramJceStruct);
        return;
      }
      if (!(paramJceStruct instanceof JudgeDownloadReq)) {
        break label278;
      }
      a(paramJceStruct, 1, paramBusinessObserver, paramInt2, paramAppRuntime);
      if (!QLog.isColorLevel()) {
        break label1402;
      }
      paramAppRuntime = (JudgeDownloadReq)paramJceStruct;
      paramBusinessObserver = new StringBuilder().append("send JudgeDownloadReq|").append(paramAppRuntime.iType).append("|");
      paramJceStruct = localObject2;
      if (paramAppRuntime.vecResInfo != null)
      {
        paramJceStruct = localObject2;
        if (paramAppRuntime.vecResInfo.size() > 0) {
          paramJceStruct = ((ResInfo)paramAppRuntime.vecResInfo.get(0)).sResId;
        }
      }
      QLog.d("QWalletCommonServlet", 2, paramJceStruct);
      return;
    }
    catch (Throwable paramJceStruct)
    {
      if (!QLog.isColorLevel()) {
        break label1402;
      }
    }
    QLog.e("QWalletCommonServlet", 2, "sendRequest|" + paramJceStruct.toString());
    return;
    label278:
    if ((paramJceStruct instanceof DownloadChooseReq))
    {
      a(paramJceStruct, 3, paramBusinessObserver, paramInt2, paramAppRuntime);
      if (QLog.isColorLevel())
      {
        paramAppRuntime = (DownloadChooseReq)paramJceStruct;
        paramBusinessObserver = new StringBuilder().append("send DownloadChooseReq|");
        paramJceStruct = localObject3;
        if (paramAppRuntime.vecResInfo != null)
        {
          paramJceStruct = localObject3;
          if (paramAppRuntime.vecResInfo.size() > 0) {
            paramJceStruct = ((ResInfo)paramAppRuntime.vecResInfo.get(0)).sResId;
          }
        }
        QLog.d("QWalletCommonServlet", 2, paramJceStruct);
      }
    }
    else if ((paramJceStruct instanceof WalletSkinReq))
    {
      a(paramJceStruct, 6, paramBusinessObserver, paramInt2, paramAppRuntime);
      if (QLog.isColorLevel())
      {
        paramJceStruct = (WalletSkinReq)paramJceStruct;
        QLog.d("QWalletCommonServlet", 2, "send WalletSkinReq|" + paramJceStruct);
      }
    }
    else if ((paramJceStruct instanceof ReqWalletConfig))
    {
      if (paramInt1 != 1) {
        break label1403;
      }
    }
    label1402:
    label1403:
    for (paramInt1 = 17;; paramInt1 = 10)
    {
      a(paramJceStruct, paramInt1, paramBusinessObserver, paramInt2, paramAppRuntime);
      if (QLog.isColorLevel())
      {
        paramJceStruct = (ReqWalletConfig)paramJceStruct;
        QLog.d("QWalletCommonServlet", 2, "send ReqWalletConfig|" + paramJceStruct);
        return;
        if ((paramJceStruct instanceof VoiceRedPackMatchReq))
        {
          a(paramJceStruct, 13, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel()) {
            QLog.d("QWalletCommonServlet", 2, "send VoiceRedPackMatchReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof GetSkinListReq))
        {
          a(paramJceStruct, 14, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (GetSkinListReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send GetSkinListReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof SetSelectedSkinReq))
        {
          a(paramJceStruct, 15, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (SetSelectedSkinReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send SetSelectedSkinReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof GetGroupRedPackListReq))
        {
          a(paramJceStruct, 18, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (GetGroupRedPackListReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send GetGroupRedPackListReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof RedInfoSyncReq))
        {
          a(paramJceStruct, 19, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (RedInfoSyncReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send RedInfoSyncReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof ReportHBGameReq))
        {
          a(paramJceStruct, 20, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (ReportHBGameReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send ReportHBGameReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof SongRedPackMatchReq))
        {
          a(paramJceStruct, 21, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (SongRedPackMatchReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send SongRedPackMatchReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof AuthCodeReq))
        {
          a(paramJceStruct, 22, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (AuthCodeReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send AuthCodeReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof GetMiniAppReq))
        {
          a(paramJceStruct, 23, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (GetMiniAppReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send AuthCodeReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof IsUinFocusMpIdReq))
        {
          a(paramJceStruct, 24, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (IsUinFocusMpIdReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send UinFocusMp|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof FocusMpIdReq))
        {
          a(paramJceStruct, 25, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (FocusMpIdReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send AuthCodeReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof IdiomRedPackMatchReq))
        {
          a(paramJceStruct, 26, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (IdiomRedPackMatchReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send AuthCodeReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof GetRandomHbIdiomReq))
        {
          a(paramJceStruct, 27, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (GetRandomHbIdiomReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send AuthCodeReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof GetBroadCastHbIdiomReq))
        {
          a(paramJceStruct, 28, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (GetBroadCastHbIdiomReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send AuthCodeReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof GetArkTailReq))
        {
          a(paramJceStruct, 29, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (GetArkTailReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send GetArkTailReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof ReportTypeReq))
        {
          a(paramJceStruct, 30, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (ReportTypeReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send ReportTypeReq|" + paramJceStruct);
          }
        }
        else if ((paramJceStruct instanceof GmpEnterInfoReq))
        {
          a(paramJceStruct, 31, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (GmpEnterInfoReq)paramJceStruct;
            QLog.d("QWalletCommonServlet", 2, "send GET_GAME_ENTRY|" + paramJceStruct);
          }
        }
      }
      return;
    }
  }
  
  public static void a(JceStruct paramJceStruct, BusinessObserver paramBusinessObserver, AppRuntime paramAppRuntime)
  {
    a(paramJceStruct, paramBusinessObserver, 0, 0, paramAppRuntime);
  }
  
  public void notifyObserver(Intent paramIntent, int paramInt, boolean paramBoolean, Bundle paramBundle, Class<? extends BusinessObserver> paramClass)
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
    ThreadManager.post(new QWalletCommonServlet.1(this, paramIntent, paramInt, paramBoolean, paramBundle), 5, null, true);
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
    Object localObject = paramFromServiceMsg.getServiceCmd();
    if ("QQPayFrequencySvc.judgeDownload".equals(localObject)) {
      if (!paramFromServiceMsg.isSuccess()) {
        break label2446;
      }
    }
    label2436:
    label2441:
    label2446:
    for (localObject = (JudgeDownloadRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new JudgeDownloadRsp());; localObject = null)
    {
      Bundle localBundle = new Bundle();
      if (localObject != null) {
        localBundle.putSerializable("rsp", (Serializable)localObject);
      }
      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
      notifyObserver(paramIntent, 1, paramFromServiceMsg.isSuccess(), localBundle, null);
      return;
      if ("QQPayFrequencySvc.downloadChoose".equals(localObject)) {
        if (!paramFromServiceMsg.isSuccess()) {
          break label2441;
        }
      }
      for (localObject = (DownloadChooseRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new DownloadChooseRsp());; localObject = null)
      {
        localBundle = new Bundle();
        if (localObject != null) {
          localBundle.putSerializable("rsp", (Serializable)localObject);
        }
        localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
        notifyObserver(paramIntent, 3, paramFromServiceMsg.isSuccess(), localBundle, null);
        return;
        if ("QQWalletPayReportSvc.getWalletSkin".equals(localObject)) {
          if (!paramFromServiceMsg.isSuccess()) {
            break label2436;
          }
        }
        for (localObject = (WalletSkinRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new WalletSkinRsp());; localObject = null)
        {
          localBundle = new Bundle();
          if (localObject != null) {
            localBundle.putSerializable("rsp", (Serializable)localObject);
          }
          localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 6, paramFromServiceMsg.isSuccess(), localBundle, null);
          return;
          if ("WalletConfigSvr.getConfig".equals(localObject)) {
            if (!paramFromServiceMsg.isSuccess()) {
              break label2431;
            }
          }
          label2351:
          label2356:
          label2361:
          label2366:
          label2371:
          label2376:
          label2381:
          label2386:
          label2391:
          label2396:
          label2401:
          label2406:
          label2411:
          label2416:
          label2421:
          label2426:
          label2431:
          for (localObject = (RspWalletConfig)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new RspWalletConfig());; localObject = null)
          {
            localBundle = new Bundle();
            if (localObject != null) {
              localBundle.putSerializable("rsp", (Serializable)localObject);
            }
            localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
            notifyObserver(paramIntent, 10, paramFromServiceMsg.isSuccess(), localBundle, null);
            return;
            if ("WalletConfigSvr.setUserSession".equals(localObject)) {
              if (!paramFromServiceMsg.isSuccess()) {
                break label2426;
              }
            }
            for (localObject = (RspWalletConfig)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new RspWalletConfig());; localObject = null)
            {
              localBundle = new Bundle();
              if (localObject != null) {
                localBundle.putSerializable("rsp", (Serializable)localObject);
              }
              localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
              notifyObserver(paramIntent, 17, paramFromServiceMsg.isSuccess(), localBundle, null);
              return;
              if ((localObject != null) && (((String)localObject).startsWith("QQwalletVoicePack.macthVoice")))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QWalletCommonServlet", 2, "voice redpacket msg grap back...");
                }
                if (!paramFromServiceMsg.isSuccess()) {
                  break label2421;
                }
              }
              for (localObject = (VoiceRedPackMatchRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new VoiceRedPackMatchRsp());; localObject = null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QWalletCommonServlet", 2, "CMD_VOICE_RED_PACKET isSuccess:" + paramFromServiceMsg.isSuccess());
                }
                if ((localObject != null) && (QLog.isColorLevel())) {
                  QLog.d("QWalletCommonServlet", 2, "rsp.status = " + ((VoiceRedPackMatchRsp)localObject).status);
                }
                localBundle = new Bundle();
                if (localObject != null) {
                  localBundle.putSerializable("rsp", (Serializable)localObject);
                }
                localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                localBundle.putInt("msfRetCode", paramFromServiceMsg.getResultCode());
                notifyObserver(paramIntent, 13, paramFromServiceMsg.isSuccess(), localBundle, null);
                return;
                if ("VAC_RedEnvelopeSkinSvc.GetSkinList".equals(localObject))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("QWalletCommonServlet", 2, "GetSkinListRsp isSuccess:" + paramFromServiceMsg.isSuccess());
                  }
                  if (!paramFromServiceMsg.isSuccess()) {
                    break label2416;
                  }
                }
                for (localObject = (GetSkinListRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetSkinListRsp());; localObject = null)
                {
                  localBundle = new Bundle();
                  if (localObject != null)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("QWalletCommonServlet", 2, "GetSkinListRsp = " + localObject);
                    }
                    localBundle.putSerializable("rsp", (Serializable)localObject);
                  }
                  localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                  notifyObserver(paramIntent, 14, paramFromServiceMsg.isSuccess(), localBundle, null);
                  return;
                  if ("VAC_RedEnvelopeSkinSvc.SetSelectedSkin".equals(localObject))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("QWalletCommonServlet", 2, "SetSelectedSkinRsp isSuccess:" + paramFromServiceMsg.isSuccess());
                    }
                    if (!paramFromServiceMsg.isSuccess()) {
                      break label2411;
                    }
                  }
                  for (localObject = (SetSelectedSkinRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new SetSelectedSkinRsp());; localObject = null)
                  {
                    localBundle = new Bundle();
                    if (localObject != null)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("QWalletCommonServlet", 2, "SetSelectedSkinRsp = " + localObject);
                      }
                      localBundle.putSerializable("rsp", (Serializable)localObject);
                    }
                    localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                    notifyObserver(paramIntent, 15, paramFromServiceMsg.isSuccess(), localBundle, null);
                    return;
                    if ("GroupRedPackListSvc.getGroupRedPackList".equals(localObject))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("QWalletCommonServlet", 2, "GetGroupRedPackListRsp isSuccess:" + paramFromServiceMsg.isSuccess());
                      }
                      if (!paramFromServiceMsg.isSuccess()) {
                        break label2406;
                      }
                    }
                    for (localObject = (GetGroupRedPackListRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetGroupRedPackListRsp());; localObject = null)
                    {
                      localBundle = new Bundle();
                      if (localObject != null)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("QWalletCommonServlet", 2, "GetGroupRedPackListRsp = " + localObject);
                        }
                        localBundle.putSerializable("rsp", (Serializable)localObject);
                      }
                      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                      notifyObserver(paramIntent, 18, paramFromServiceMsg.isSuccess(), localBundle, null);
                      return;
                      if ("WalletConfigSvr.syncRedInfo".equals(localObject)) {
                        if (!paramFromServiceMsg.isSuccess()) {
                          break label2401;
                        }
                      }
                      for (localObject = (RedInfoSyncRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new RedInfoSyncRsp());; localObject = null)
                      {
                        localBundle = new Bundle();
                        if (localObject != null) {
                          localBundle.putSerializable("rsp", (Serializable)localObject);
                        }
                        localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                        notifyObserver(paramIntent, 19, paramFromServiceMsg.isSuccess(), localBundle, null);
                        return;
                        if ("GroupRedPackListSvc.reportHBGame".equals(localObject))
                        {
                          if (!paramFromServiceMsg.isSuccess()) {
                            break;
                          }
                          paramIntent = (ReportHBGameRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new ReportHBGameRsp());
                          if (!QLog.isColorLevel()) {
                            break;
                          }
                          QLog.d("QWalletCommonServlet", 2, "ReportHBGameRsp result = " + paramIntent.result);
                          return;
                        }
                        if ((localObject != null) && (((String)localObject).startsWith("QQwalletVoicePack.macthSong")))
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("QWalletCommonServlet", 2, "song redpacket msg grap back...");
                          }
                          if (!paramFromServiceMsg.isSuccess()) {
                            break label2396;
                          }
                        }
                        for (localObject = (SongRedPackMatchRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new SongRedPackMatchRsp());; localObject = null)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("QWalletCommonServlet", 2, "CMD_SONG_RED_PACKET isSuccess:" + paramFromServiceMsg.isSuccess());
                          }
                          if ((localObject != null) && (QLog.isColorLevel())) {
                            QLog.d("QWalletCommonServlet", 2, "rsp.status = " + ((SongRedPackMatchRsp)localObject).status);
                          }
                          localBundle = new Bundle();
                          if (localObject != null) {
                            localBundle.putSerializable("rsp", (Serializable)localObject);
                          }
                          localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                          notifyObserver(paramIntent, 21, paramFromServiceMsg.isSuccess(), localBundle, null);
                          return;
                          if ("VacThirdCodeSvc.fetchCodes".equals(localObject)) {
                            if (!paramFromServiceMsg.isSuccess()) {
                              break label2391;
                            }
                          }
                          for (localObject = (AuthCodeRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AuthCodeRsp());; localObject = null)
                          {
                            localBundle = new Bundle();
                            if (localObject != null) {
                              localBundle.putSerializable("rsp", (Serializable)localObject);
                            }
                            localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                            notifyObserver(paramIntent, 22, paramFromServiceMsg.isSuccess(), localBundle, null);
                            return;
                            if ("MiniAppSvc.get_mini_app".equals(localObject)) {
                              if (!paramFromServiceMsg.isSuccess()) {
                                break label2386;
                              }
                            }
                            for (localObject = (GetMiniAppRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetMiniAppRsp());; localObject = null)
                            {
                              localBundle = new Bundle();
                              if (localObject != null) {
                                localBundle.putSerializable("rsp", (Serializable)localObject);
                              }
                              localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                              notifyObserver(paramIntent, 23, paramFromServiceMsg.isSuccess(), localBundle, null);
                              return;
                              if ("MiniAppSvc.is_uin_focus_mpid".equals(localObject)) {
                                if (!paramFromServiceMsg.isSuccess()) {
                                  break label2381;
                                }
                              }
                              for (localObject = (IsUinFocusMpIdRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new IsUinFocusMpIdRsp());; localObject = null)
                              {
                                localBundle = new Bundle();
                                if (localObject != null) {
                                  localBundle.putSerializable("rsp", (Serializable)localObject);
                                }
                                localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                                notifyObserver(paramIntent, 24, paramFromServiceMsg.isSuccess(), localBundle, null);
                                return;
                                if ("MiniAppSvc.focus_mpid".equals(localObject)) {
                                  if (!paramFromServiceMsg.isSuccess()) {
                                    break label2376;
                                  }
                                }
                                for (localObject = (FocusMpIdRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new FocusMpIdRsp());; localObject = null)
                                {
                                  localBundle = new Bundle();
                                  if (localObject != null) {
                                    localBundle.putSerializable("rsp", (Serializable)localObject);
                                  }
                                  localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                                  notifyObserver(paramIntent, 25, paramFromServiceMsg.isSuccess(), localBundle, null);
                                  return;
                                  if ("QQwalletVoicePack.macthIdiom".equals(localObject)) {
                                    if (!paramFromServiceMsg.isSuccess()) {
                                      break label2371;
                                    }
                                  }
                                  for (localObject = (IdiomRedPackMatchRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new IdiomRedPackMatchRsp());; localObject = null)
                                  {
                                    localBundle = new Bundle();
                                    if (localObject != null) {
                                      localBundle.putSerializable("rsp", (Serializable)localObject);
                                    }
                                    localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                                    notifyObserver(paramIntent, 26, paramFromServiceMsg.isSuccess(), localBundle, null);
                                    return;
                                    if ("QQwalletVoicePack.GetRandomHbIdiom".equals(localObject)) {
                                      if (!paramFromServiceMsg.isSuccess()) {
                                        break label2366;
                                      }
                                    }
                                    for (localObject = (GetRandomHbIdiomRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetRandomHbIdiomRsp());; localObject = null)
                                    {
                                      localBundle = new Bundle();
                                      if (localObject != null) {
                                        localBundle.putSerializable("rsp", (Serializable)localObject);
                                      }
                                      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                                      notifyObserver(paramIntent, 27, paramFromServiceMsg.isSuccess(), localBundle, null);
                                      return;
                                      if ("QQwalletVoicePack.GetBroadCastHbIdiom".equals(localObject)) {
                                        if (!paramFromServiceMsg.isSuccess()) {
                                          break label2361;
                                        }
                                      }
                                      for (localObject = (GetBroadCastHbIdiomRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetBroadCastHbIdiomRsp());; localObject = null)
                                      {
                                        localBundle = new Bundle();
                                        if (localObject != null) {
                                          localBundle.putSerializable("rsp", (Serializable)localObject);
                                        }
                                        localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                                        notifyObserver(paramIntent, 28, paramFromServiceMsg.isSuccess(), localBundle, null);
                                        return;
                                        if ("GameCenterWebSvc.13571".equals(localObject)) {
                                          if (!paramFromServiceMsg.isSuccess()) {
                                            break label2356;
                                          }
                                        }
                                        for (localObject = (GetArkTailRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetArkTailRsp());; localObject = null)
                                        {
                                          localBundle = new Bundle();
                                          if (localObject != null) {
                                            localBundle.putSerializable("rsp", (Serializable)localObject);
                                          }
                                          localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                                          notifyObserver(paramIntent, 29, paramFromServiceMsg.isSuccess(), localBundle, null);
                                          return;
                                          if ("GameCenterWebSvc.13572".equals(localObject)) {
                                            if (!paramFromServiceMsg.isSuccess()) {
                                              break label2351;
                                            }
                                          }
                                          for (localObject = (ReportTypeRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new ReportTypeRsp());; localObject = null)
                                          {
                                            localBundle = new Bundle();
                                            if (localObject != null) {
                                              localBundle.putSerializable("rsp", (Serializable)localObject);
                                            }
                                            localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                                            notifyObserver(paramIntent, 30, paramFromServiceMsg.isSuccess(), localBundle, null);
                                            return;
                                            if (!"GameMpSvc.EnterInfo".equals(localObject)) {
                                              break;
                                            }
                                            if (paramFromServiceMsg.isSuccess()) {}
                                            for (localObject = (GmpEnterInfoRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GmpEnterInfoRsp());; localObject = null)
                                            {
                                              localBundle = new Bundle();
                                              if (localObject != null) {
                                                localBundle.putSerializable("rsp", (Serializable)localObject);
                                              }
                                              localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
                                              notifyObserver(paramIntent, 31, paramFromServiceMsg.isSuccess(), localBundle, null);
                                              return;
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    switch (paramIntent.getExtras().getInt("cmd_type"))
    {
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    case 12: 
    case 16: 
    default: 
      return;
    case 1: 
      try
      {
        paramPacket.addRequestPacket("req", (JudgeDownloadReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("QQPayFrequencySvc.judgeDownload");
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
        paramPacket.setSSOCommand("QQPayFrequencySvc.downloadReport");
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
        paramPacket.setSSOCommand("QQPayFrequencySvc.downloadChoose");
        paramPacket.setFuncName("downloadChoose");
        paramPacket.setServantName("Wallet.FrequencyControlServer.FrequencyControlObj");
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
    case 19: 
      try
      {
        paramPacket.addRequestPacket("req", (RedInfoSyncReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("WalletConfigSvr.syncRedInfo");
        paramPacket.setFuncName("syncRedInfo");
        paramPacket.setServantName("Wallet.MobileWalletConfigServer.MobileWalletConfigObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 20: 
      try
      {
        paramPacket.addRequestPacket("req", (ReportHBGameReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("GroupRedPackListSvc.reportHBGame");
        paramPacket.setFuncName("reportHBGame");
        paramPacket.setServantName("Wallet.WalletHBGameServer.WalletHBGameObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 22: 
      try
      {
        paramPacket.addRequestPacket("req", (AuthCodeReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("VacThirdCodeSvc.fetchCodes");
        paramPacket.setFuncName("fetchCodes");
        paramPacket.setServantName("VAC.AuthCodeCoroServer.AuthCodeCoroObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 23: 
      try
      {
        paramPacket.addRequestPacket("req", (GetMiniAppReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("MiniAppSvc.get_mini_app");
        paramPacket.setFuncName("get_mini_app");
        paramPacket.setServantName("Wallet.MiniAppServer.MiniAppObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 21: 
      try
      {
        paramPacket.addRequestPacket("req", (SongRedPackMatchReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("QQwalletVoicePack.macthSong");
        paramPacket.setFuncName("macthSong");
        paramPacket.setServantName("Wallet.VoiceMatchServer.VoiceMatchObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 24: 
      try
      {
        paramPacket.addRequestPacket("req", (IsUinFocusMpIdReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("MiniAppSvc.is_uin_focus_mpid");
        paramPacket.setFuncName("is_uin_focus_mpid");
        paramPacket.setServantName("Wallet.MiniAppServer.MiniAppObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 25: 
      try
      {
        paramPacket.addRequestPacket("req", (FocusMpIdReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("MiniAppSvc.focus_mpid");
        paramPacket.setFuncName("focus_mpid");
        paramPacket.setServantName("Wallet.MiniAppServer.MiniAppObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 26: 
      try
      {
        paramPacket.addRequestPacket("req", (IdiomRedPackMatchReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("QQwalletVoicePack.macthIdiom");
        paramPacket.setFuncName("macthIdiom");
        paramPacket.setServantName("Wallet.VoiceMatchServer.VoiceMatchObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 27: 
      try
      {
        paramPacket.addRequestPacket("req", (GetRandomHbIdiomReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("QQwalletVoicePack.GetRandomHbIdiom");
        paramPacket.setFuncName("GetRandomHbIdiom");
        paramPacket.setServantName("Wallet.VoiceMatchServer.VoiceMatchObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 28: 
      try
      {
        paramPacket.addRequestPacket("req", (GetBroadCastHbIdiomReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("QQwalletVoicePack.GetBroadCastHbIdiom");
        paramPacket.setFuncName("GetBroadCastHbIdiom");
        paramPacket.setServantName("Wallet.VoiceMatchServer.VoiceMatchObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 29: 
      try
      {
        paramPacket.addRequestPacket("req", (GetArkTailReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("GameCenterWebSvc.13571");
        paramPacket.setFuncName("GetArkTail");
        paramPacket.setServantName("GameCenter.GameContentAdaptServer.GameContentAdaptObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    case 30: 
      try
      {
        paramPacket.addRequestPacket("req", (ReportTypeReq)paramIntent.getSerializableExtra("req"));
        paramPacket.setSSOCommand("GameCenterWebSvc.13572");
        paramPacket.setFuncName("ReportType");
        paramPacket.setServantName("GameCenter.GameContentAdaptServer.GameContentAdaptObj");
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        return;
      }
    }
    try
    {
      paramPacket.addRequestPacket("req", (GmpEnterInfoReq)paramIntent.getSerializableExtra("req"));
      paramPacket.setSSOCommand("GameMpSvc.EnterInfo");
      paramPacket.setFuncName("EnterInfo");
      paramPacket.setServantName("GameCenter.GameMpoperServer.GameMpoperObj");
      return;
    }
    catch (OutOfMemoryError paramIntent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet
 * JD-Core Version:    0.7.0.1
 */