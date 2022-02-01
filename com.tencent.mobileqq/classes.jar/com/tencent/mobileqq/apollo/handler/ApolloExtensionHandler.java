package com.tencent.mobileqq.apollo.handler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.hiboom.protocol.DiyEmotionPb.Filter_Req;
import com.hiboom.protocol.DiyEmotionPb.Filter_Req_Comm;
import com.hiboom.protocol.DiyEmotionPb.Filter_Rsp;
import com.hiboom.protocol.DiyEmotionPb.Filter_Text_Req;
import com.hiboom.protocol.DiyEmotionPb.Filter_Text_Rsp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.STServiceMonitItem;
import com.tencent.mobileqq.WebSsoBody.STServiceMonitReq;
import com.tencent.mobileqq.activity.pendant.PendantTipsInfo;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.listener.ApolloRspCallback;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.request.ApolloRequestCallbackManager;
import com.tencent.mobileqq.apollo.request.ApolloRequestReceiveParams;
import com.tencent.mobileqq.apollo.request.ApolloRequestReceiver;
import com.tencent.mobileqq.apollo.request.ApolloStoreRequestReceiver;
import com.tencent.mobileqq.apollo.request.CmGameRequestReceiver;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.Dispatcher;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.MutualMarkConfigHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.praise.praise_sso.TPraiseSsoReq;
import com.tencent.mobileqq.praise.praise_sso.TPraiseSsoRsp;
import com.tencent.mobileqq.praise.praise_sso.TSsoCmd0x1Req;
import com.tencent.mobileqq.praise.praise_sso.TSsoCmd0x1Rsp;
import com.tencent.mobileqq.profile.like.OnPraiseSetCallback;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig.EffectInfo;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.GetUrlRsp;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.QuickUpdateRsp;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.SCPreloadOrReport;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.SyncVCRRsp;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.UpdateInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.VCR;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.graytips.api.IVasGrayTips;
import com.tencent.mobileqq.vas.handler.GetStrangerVasInfoHandler;
import com.tencent.mobileqq.vas.qqvaluecard.QqValueGetValueHandler;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.ColorClearableEditText.Paragraph;
import com.tencent.pb.apollo.CmGameMsgTunnel.AddrDistribueReq;
import com.tencent.pb.apollo.STExploreInfo.STEntryIdInfo;
import com.tencent.pb.apollo.STExploreInfo.STGetMsgReq;
import com.tencent.pb.apollo.STGameLogin.STGameLoginReq;
import com.tencent.pb.gamecenter.MonitReport.MonitReportReq;
import com.tencent.pb.gamecenter.MonitReport.PublicAccountReq;
import com.tencent.pb.pendantMarket.PendantMarket.SetAddonReq;
import com.tencent.pb.pendantMarket.PendantMarket.SetAddonRsp;
import com.tencent.pb.pendantMarket.PendantMarket.TipsInfo;
import com.tencent.pb.scupdate.SCUpdatePB.GetUrlReq;
import com.tencent.pb.scupdate.SCUpdatePB.GetUrlRsp;
import com.tencent.pb.scupdate.SCUpdatePB.ItemVersion;
import com.tencent.pb.scupdate.SCUpdatePB.SCPreload;
import com.tencent.pb.scupdate.SCUpdatePB.SCReport;
import com.tencent.pb.scupdate.SCUpdatePB.SCUpdateReq;
import com.tencent.pb.scupdate.SCUpdatePB.SCUpdateReqComm;
import com.tencent.pb.scupdate.SCUpdatePB.SCUpdateRsp;
import com.tencent.pb.scupdate.SCUpdatePB.SCUpdateRspComm;
import com.tencent.pb.scupdate.SCUpdatePB.SyncVCRReq;
import com.tencent.pb.scupdate.SCUpdatePB.SyncVCRRsp;
import com.tencent.pb.scupdate.SCUpdatePB.UpdateInfo;
import com.tencent.pb.scupdate.SCUpdatePB.VCR;
import com.tencent.pb.vas.uni_gray_tip.UniGrayTip.FromChannel;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ClientInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.MemberInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ReqBody;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RichCardNameElem;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.qqshop.qqshop_code.SReq;
import tencent.qun.group_effect.group_effect_commu.ReqBody;
import tencent.qun.group_effect.group_effect_commu.RspBody;
import tencent.qun.group_effect.group_effect_commu.TEffectDetail;
import tencent.qun.group_effect.group_effect_commu.TEntryNotifyReq0x2000;
import tencent.qun.group_effect.group_effect_commu.TEntryNotifyRsp0x2000;
import tencent.qun.group_effect.group_effect_commu.TGetMyEffectReq0x2;
import tencent.qun.group_effect.group_effect_commu.TGetMyEffectRsp0x2;

public class ApolloExtensionHandler
  extends BusinessHandler
  implements IApolloExtensionHandler
{
  public static final String a = "com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler";
  public static String b = "Addon.Set";
  public static String c = "IndividPub.ExpTips";
  public static final Map<String, IVasExtensionHandler> f = new HashMap();
  private static String i = "ApolloExtensionHandler";
  private static long j;
  private static long k = 0L;
  public int d = 0;
  public int e = 0;
  public Vector<Long> g = new Vector();
  public Bundle h;
  private HashMap<String, BusinessObserver> l = new HashMap();
  private QQAppInterface m;
  private Dispatcher<ApolloRequestReceiveParams> n;
  private OnPraiseSetCallback o;
  private List<ApolloExtensionHandler.OnQueryBaseInfoListener> p = new ArrayList();
  
  static
  {
    f.put("qqvalue.GetQQValue", new QqValueGetValueHandler());
    f.put("OidbSvc.0x5eb_99", new GetStrangerVasInfoHandler());
  }
  
  public ApolloExtensionHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.m = paramQQAppInterface;
    this.n = new Dispatcher();
    this.n.a(ApolloRequestReceiver.class);
    this.n.a(ApolloStoreRequestReceiver.class);
    this.n.a(CmGameRequestReceiver.class);
  }
  
  @NotNull
  private NewIntent a(String paramString, BaseApplication paramBaseApplication, byte[] paramArrayOfByte)
  {
    paramBaseApplication = new NewIntent(paramBaseApplication, ApolloExtensionServlet.class);
    paramBaseApplication.putExtra("cmd", paramString);
    paramBaseApplication.putExtra("data", paramArrayOfByte);
    return paramBaseApplication;
  }
  
  private void a(WebSSOAgent.UniSsoServerReq paramUniSsoServerReq, JSONObject paramJSONObject, String paramString)
  {
    paramUniSsoServerReq.reqdata.set(paramJSONObject.toString());
    paramUniSsoServerReq = a(paramString, this.m.getApp(), paramUniSsoServerReq.toByteArray());
    this.m.startServlet(paramUniSsoServerReq);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, BusinessObserver paramBusinessObserver, Object paramObject)
  {
    ThreadManager.getSubThreadHandler().post(new ApolloExtensionHandler.UpdateRunnable(paramBusinessObserver, paramFromServiceMsg.isSuccess(), paramObject));
  }
  
  private void a(Long[] paramArrayOfLong, String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramString = "android";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("android.");
        ((StringBuilder)localObject).append(paramString);
        paramString = ((StringBuilder)localObject).toString();
      }
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("from", paramString);
      paramString = new JSONArray();
      JSONArray localJSONArray = new JSONArray();
      int i2 = paramArrayOfLong.length;
      int i1 = 0;
      while (i1 < i2)
      {
        long l1 = paramArrayOfLong[i1].longValue();
        paramString.put(l1);
        localJSONArray.put(l1);
        i1 += 1;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("producer", Build.PRODUCT);
      localJSONObject.put("model", Build.MODEL);
      localJSONObject.put("cpuCount", DeviceInfoUtil.h());
      localJSONObject.put("cpuFrequency", DeviceInfoUtil.k());
      localJSONObject.put("systemTotalMemory", DeviceInfoUtil.a());
      ((JSONObject)localObject).put("deviceInfo", localJSONObject);
      ((JSONObject)localObject).put("uins", paramString);
      ((JSONObject)localObject).put("3dUins", localJSONArray);
      ((JSONObject)localObject).put("detail", 1);
      ((JSONObject)localObject).put("cmd", "apollo_core.get_avatar");
      paramString = g("8.8.17");
      paramString.reqdata.set(((JSONObject)localObject).toString());
      paramString = a("apollo_core.get_avatar", this.m.getApp(), paramString.toByteArray());
      paramString.putExtra("uinArr", paramArrayOfLong);
      this.m.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      this.g.remove(paramArrayOfLong);
      if (QLog.isColorLevel()) {
        QLog.e(i, 2, paramString.getMessage());
      }
    }
  }
  
  private boolean a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, String paramString)
  {
    if ("Praise.sso".equals(paramString))
    {
      a(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    }
    else if ("gxzbpublic.filter".equals(paramString))
    {
      g(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    }
    else if ("OidbSvc.0x8fc_3".equals(paramString))
    {
      b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    }
    else if ("vaspoke.check".equals(paramString))
    {
      e(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    }
    else if (paramString.equals(b))
    {
      a(paramIntent, paramArrayOfByte);
    }
    else if ("scupdate.handle".equals(paramString))
    {
      b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    }
    else
    {
      if (!"Groupeffect.commop".equals(paramString)) {
        break label145;
      }
      f(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    }
    return true;
    label145:
    return false;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      paramIntent = new Oidb_0x8fc.RspBody();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          notifyUI(27, true, null);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleModifyColorNick sso fail result = ");
          paramObject.append(paramFromServiceMsg.uint32_result.get());
          QLog.d("ColorNick", 2, paramObject.toString());
        }
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label219;
        }
        i1 = paramFromServiceMsg.uint32_result.get();
        if (!paramIntent.strErrInfo.has()) {
          break label225;
        }
        paramIntent = paramIntent.strErrInfo.get();
        notifyUI(27, false, new Object[] { Integer.valueOf(i1), paramIntent });
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e("ColorNick", 1, "handleModifyColorNick error: ", paramIntent);
        notifyUI(27, false, Integer.valueOf(-1));
      }
      return;
      label219:
      int i1 = -1;
      continue;
      label225:
      paramIntent = "";
    }
  }
  
  private boolean c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("__cmd_seq__");
    if (!TextUtils.isEmpty(str))
    {
      if (!this.l.containsKey(str)) {
        return false;
      }
      BusinessObserver localBusinessObserver = (BusinessObserver)this.l.get(str);
      if (localBusinessObserver == null) {
        return false;
      }
      this.l.remove(str);
      paramIntent = (Class)paramIntent.getSerializableExtra("__rspClass__");
      if (paramIntent == null)
      {
        a(paramFromServiceMsg, localBusinessObserver, paramArrayOfByte);
        return true;
      }
      try
      {
        paramIntent = (MessageMicro)paramIntent.newInstance();
        paramIntent.mergeFrom(paramArrayOfByte);
        a(paramFromServiceMsg, localBusinessObserver, paramIntent);
        return true;
      }
      catch (Exception paramIntent)
      {
        QLog.e(i, 1, "response is error", paramIntent);
      }
    }
    return false;
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str;
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = i;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleCMGameResp],data:");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {}
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new JSONObject(paramFromServiceMsg.rspdata.get());
        paramArrayOfByte.put("errCode", (int)paramFromServiceMsg.ret.get());
        paramArrayOfByte = paramArrayOfByte.toString();
        str = paramIntent.getStringExtra("cmd");
        int i1 = paramIntent.getIntExtra("callFrom", 0);
        localObject = (ApolloGameManagerImpl)this.m.getRuntimeService(IApolloGameManager.class, "all");
        if (i1 == 4)
        {
          paramIntent = (SpriteContext)SpriteUtil.a(this.m);
          if (paramIntent != null) {
            paramIntent.a(str, paramArrayOfByte);
          }
        }
        else if ("apollo_terminal_info.get_user_slaves_v2".equals(str))
        {
          localObject = ((ApolloManagerServiceImpl)this.m.getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager();
          if (localObject != null) {
            ((ApolloPanelManager)localObject).a(paramFromServiceMsg.ret.get(), paramArrayOfByte, paramIntent.getStringExtra("reqData"));
          }
        }
        if (QLog.isColorLevel())
        {
          paramIntent = i;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ret:");
          ((StringBuilder)localObject).append(paramFromServiceMsg.ret.get());
          ((StringBuilder)localObject).append(",data:");
          ((StringBuilder)localObject).append(paramArrayOfByte);
          ((StringBuilder)localObject).append(",cmd:");
          ((StringBuilder)localObject).append(str);
          QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        QLog.e(i, 1, "resp data is err.");
        return;
      }
    }
    catch (Exception paramIntent)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = i;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("errInfo->");
        paramArrayOfByte.append(paramIntent.getMessage());
        QLog.d(paramFromServiceMsg, 2, paramArrayOfByte.toString());
      }
    }
  }
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramIntent.getIntExtra("id", -1));
    localBundle.putString("name", paramIntent.getStringExtra("name"));
    localBundle.putString("minVersion", paramIntent.getStringExtra("minVersion"));
    localBundle.putInt("feeType", paramIntent.getIntExtra("feeType", 0));
    localBundle.putInt("fromType", paramIntent.getIntExtra("fromType", 0));
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        long l1 = paramIntent.ret.get();
        paramIntent = paramIntent.errmsg.get();
        if (l1 == 0L)
        {
          notifyUI(23, true, localBundle);
          return;
        }
        localBundle.putLong("result", l1);
        localBundle.putString("msg", paramIntent);
        paramFromServiceMsg = i;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("handlePokeAuthResp failed ");
        paramArrayOfByte.append(paramIntent);
        QLog.e(paramFromServiceMsg, 1, paramArrayOfByte.toString());
      }
      catch (Exception paramIntent)
      {
        localBundle.putInt("result", -254);
        localBundle.putString("msg", HardCodeUtil.a(2131913250));
        if (!QLog.isColorLevel()) {
          break label318;
        }
      }
      QLog.e(i, 2, "handlePokeAuthResp failed ", paramIntent);
    }
    else
    {
      localBundle.putInt("result", -255);
      localBundle.putString("msg", HardCodeUtil.a(2131913251));
      if (QLog.isColorLevel())
      {
        paramIntent = i;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("handlePokeAuthResp fail ret: ");
        paramArrayOfByte.append(paramFromServiceMsg.getResultCode());
        QLog.e(paramIntent, 2, paramArrayOfByte.toString());
      }
    }
    label318:
    notifyUI(23, false, localBundle);
  }
  
  private void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramFromServiceMsg = new group_effect_commu.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        long l1 = paramIntent.getLongExtra("usrdata", 0L);
        if (paramFromServiceMsg.ret.get() == 0)
        {
          paramIntent = (ITroopEnterEffectService)this.m.getRuntimeService(ITroopEnterEffectService.class, "all");
          if (l1 == 8192L)
          {
            paramFromServiceMsg = (group_effect_commu.TEntryNotifyRsp0x2000)paramFromServiceMsg.st_entry_notify.get();
            if (paramFromServiceMsg != null)
            {
              paramArrayOfByte = (group_effect_commu.TEffectDetail)paramFromServiceMsg.st_userconfig.get();
              paramIntent.setNotifyInterval(paramFromServiceMsg.notify_interval.get() * 1000);
            }
            if (!QLog.isColorLevel()) {
              return;
            }
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleTroopEnterEffectCMD ENTER_GROUP success notifyInteval = ");
            paramFromServiceMsg.append(paramIntent.getNotifyInterval());
            QLog.d("TroopEnterEffect", 2, paramFromServiceMsg.toString());
            return;
          }
          if (l1 != 2L) {
            return;
          }
          paramFromServiceMsg = (group_effect_commu.TGetMyEffectRsp0x2)paramFromServiceMsg.st_get_effect.get();
          if (paramFromServiceMsg != null)
          {
            if (paramFromServiceMsg.ret.get() != 0)
            {
              QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD getMyEffect fail");
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("TroopEnterEffect", 2, "handleTroopEnterEffectCMD getMyEffect success");
            }
            paramArrayOfByte = new TroopEnterEffectConfig.EffectInfo();
            paramArrayOfByte.a(paramFromServiceMsg);
            paramIntent.updateEffectInfo(paramArrayOfByte);
            paramIntent.saveEffectConfigData(paramFromServiceMsg);
            SharedPreUtils.c(this.m.getApplication(), this.m.getCurrentAccountUin(), System.currentTimeMillis());
            notifyUI(26, true, null);
            return;
          }
          QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD getMyEffect rsp is null");
          return;
        }
        paramIntent = new StringBuilder();
        paramIntent.append("handleTroopEnterEffectCMD error cmd = ");
        paramIntent.append(l1);
        paramIntent.append(" ret = ");
        paramIntent.append(paramFromServiceMsg.ret.get());
        QLog.e("TroopEnterEffect", 1, paramIntent.toString());
        return;
      }
      catch (Exception paramIntent)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleTroopEnterEffectCMD error: ");
        paramFromServiceMsg.append(paramIntent.getMessage());
        QLog.e("TroopEnterEffect", 1, paramFromServiceMsg.toString());
        return;
      }
    }
    else
    {
      paramIntent = new StringBuilder();
      paramIntent.append("handleTroopEnterEffectCMD fail data = ");
      paramIntent.append(paramArrayOfByte);
      paramIntent.append(" errorcode = ");
      paramIntent.append(paramFromServiceMsg.getResultCode());
      paramIntent.append(" ssoSeq = ");
      paramIntent.append(paramFromServiceMsg.getRequestSsoSeq());
      QLog.e("TroopEnterEffect", 1, paramIntent.toString());
    }
  }
  
  @NotNull
  private WebSSOAgent.UniSsoServerReq g(String paramString)
  {
    WebSSOAgent.UniSsoServerReqComm localUniSsoServerReqComm = new WebSSOAgent.UniSsoServerReqComm();
    localUniSsoServerReqComm.platform.set(109L);
    localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
    localUniSsoServerReqComm.mqqver.set(paramString);
    paramString = new WebSSOAgent.UniSsoServerReq();
    paramString.comm.set(localUniSsoServerReqComm);
    return paramString;
  }
  
  private void g(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramIntent = (DiyEmotionPb.Filter_Rsp)new DiyEmotionPb.Filter_Rsp().mergeFrom(paramArrayOfByte);
        if (paramIntent.ret.get() != 0L) {
          break label290;
        }
        i1 = 1;
        if (i1 == 0) {
          break label296;
        }
        bool1 = ((Boolean)paramIntent.rspcmd_0x01.is_valid.get(0)).booleanValue();
        paramIntent = new Bundle();
        if (paramFromServiceMsg.getResultCode() != 1002) {
          break label302;
        }
        paramIntent.putBoolean("timeout", bool2);
        paramIntent.putBoolean("legalSuccess", bool1);
        long l1 = SystemClock.uptimeMillis() - j;
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "RichTextIllegalWordTime", bool1, l1, 0L, null, "");
        if (QLog.isColorLevel())
        {
          paramIntent = i;
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("costTime:");
          paramFromServiceMsg.append(l1);
          paramFromServiceMsg.append(" isTimeOut:");
          paramFromServiceMsg.append(bool2);
          paramFromServiceMsg.append(" legalSuccess:");
          paramFromServiceMsg.append(bool1);
          QLog.d(paramIntent, 2, paramFromServiceMsg.toString());
        }
        try
        {
          ((IVasService)this.m.getRuntimeService(IVasService.class, "")).getHiBoomManager().onDirtywordFilterResult(bool1);
          return;
        }
        catch (Exception paramIntent) {}
        paramFromServiceMsg = i;
      }
      catch (Exception paramIntent) {}
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("diy handler onRecive fail err:");
      paramArrayOfByte.append(paramIntent.getMessage());
      QLog.e(paramFromServiceMsg, 2, paramArrayOfByte.toString());
      return;
      label290:
      int i1 = 0;
      continue;
      label296:
      boolean bool1 = false;
      continue;
      label302:
      bool2 = false;
    }
  }
  
  public QQAppInterface a()
  {
    return this.m;
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = this.m;
    if (localObject1 == null)
    {
      QLog.e(i, 1, "[getExploreInfo] app is null");
      return;
    }
    if (((IApolloManagerService)((QQAppInterface)localObject1).getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(this.m.getCurrentUin()) != 2) {
      localObject1 = "apollo_interact.get_msg";
    } else {
      localObject1 = "cmshowar_message_plat.get_msg";
    }
    long l1 = NetConnInfoCenter.getServerTime();
    Object localObject2;
    Object localObject3;
    if (paramInt == 1)
    {
      if (this.d == 0)
      {
        localObject2 = this.m.getApp();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("apollo_sp");
        ((StringBuilder)localObject3).append(this.m.getCurrentUin());
        this.d = ((BaseApplication)localObject2).getSharedPreferences(((StringBuilder)localObject3).toString(), 0).getInt("next_req_st_drawer", (int)l1);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = i;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[getExploreInfo] exploreDrawerSt:");
        ((StringBuilder)localObject3).append(this.d);
        ((StringBuilder)localObject3).append(",currentTime:");
        ((StringBuilder)localObject3).append(l1);
        ((StringBuilder)localObject3).append("|");
        ((StringBuilder)localObject3).append(paramInt);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if (this.d <= l1) {}
    }
    else
    {
      if (this.e == 0)
      {
        localObject2 = this.m.getApp();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("apollo_sp");
        ((StringBuilder)localObject3).append(this.m.getCurrentUin());
        this.e = ((BaseApplication)localObject2).getSharedPreferences(((StringBuilder)localObject3).toString(), 0).getInt("next_req_st_drawer_friend_card", (int)l1);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = i;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[getExploreInfo] exploreFriendCardSt:");
        ((StringBuilder)localObject3).append(this.e);
        ((StringBuilder)localObject3).append(",currentTime:");
        ((StringBuilder)localObject3).append(l1);
        ((StringBuilder)localObject3).append("|");
        ((StringBuilder)localObject3).append(paramInt);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if (this.e > l1) {
        return;
      }
    }
    try
    {
      localObject2 = i;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[getExploreInfo] cmd: ");
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.i((String)localObject2, 1, ((StringBuilder)localObject3).toString());
      localObject2 = new STExploreInfo.STGetMsgReq();
      ((STExploreInfo.STGetMsgReq)localObject2).app_type.set(1);
      localObject3 = new STExploreInfo.STEntryIdInfo();
      ((STExploreInfo.STEntryIdInfo)localObject3).num.set(1);
      ((STExploreInfo.STEntryIdInfo)localObject3).entry_id.set(paramInt);
      ((STExploreInfo.STGetMsgReq)localObject2).eid_list.add((MessageMicro)localObject3);
      localObject3 = g("8.8.17");
      ((WebSSOAgent.UniSsoServerReq)localObject3).pbReqData.set(ByteStringMicro.copyFrom(((STExploreInfo.STGetMsgReq)localObject2).toByteArray()));
      localObject1 = a((String)localObject1, this.m.getApp(), ((WebSSOAgent.UniSsoServerReq)localObject3).toByteArray());
      this.m.startServlet((NewIntent)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(i, 1, new Object[] { "[getExploreInfo] exception: ", localException.getMessage() });
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    QLog.d(i, 1, "getPadFaceAd");
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("uin", Long.parseLong(this.m.getCurrentAccountUin()));
      localJSONObject3.put("id", paramInt2);
      localJSONObject3.put("redpoint", paramInt1);
      localJSONObject3.put("last_time", paramLong);
      localJSONObject3.put("qq_plat", 1);
      localJSONObject3.put("qq_version", "8.8.17.5770");
      localJSONObject2.put("req", localJSONObject3);
      localJSONObject1.put("12818", localJSONObject2);
      a(g("8.8.17.5770"), localJSONObject1, "QQVacCommSvc.get_padface_add");
      return;
    }
    catch (Exception localException)
    {
      QLog.e(i, 1, "[getPadFaceAd] exception=", localException);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle, OnPraiseSetCallback paramOnPraiseSetCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = i;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requestPraiseAuth, praiseId=");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new praise_sso.TSsoCmd0x1Req();
    ((praise_sso.TSsoCmd0x1Req)localObject1).i32_itemId.set(paramInt);
    Object localObject2 = new praise_sso.TPraiseSsoReq();
    ((praise_sso.TPraiseSsoReq)localObject2).i32_cmd.set(1);
    ((praise_sso.TPraiseSsoReq)localObject2).i32_implat.set(109);
    ((praise_sso.TPraiseSsoReq)localObject2).str_qq_ver.set("8.8.17.5770");
    ((praise_sso.TPraiseSsoReq)localObject2).st_cmd0x1_req.set((MessageMicro)localObject1);
    localObject1 = a("Praise.sso", this.m.getApp(), ((praise_sso.TPraiseSsoReq)localObject2).toByteArray());
    this.h = paramBundle;
    this.o = paramOnPraiseSetCallback;
    this.m.startServlet((NewIntent)localObject1);
  }
  
  public void a(int paramInt, String paramString)
  {
    UniGrayTip.FromChannel localFromChannel = new UniGrayTip.FromChannel();
    localFromChannel.channel.set(paramInt);
    PBStringField localPBStringField = localFromChannel.fromUin;
    if (paramString == null) {
      paramString = "";
    }
    localPBStringField.set(paramString);
    ((IVasGrayTips)QRoute.api(IVasGrayTips.class)).requestUnitGrayTips(2, localFromChannel, null, null);
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("id", paramInt1);
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = g("8.8.17");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = a("vaspoke.check", this.m.getApp(), localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("timeout", 20000);
      ((NewIntent)localObject).putExtra("id", paramInt1);
      ((NewIntent)localObject).putExtra("name", paramString1);
      ((NewIntent)localObject).putExtra("minVersion", paramString2);
      ((NewIntent)localObject).putExtra("feeType", paramInt2);
      ((NewIntent)localObject).putExtra("fromType", paramInt3);
      this.m.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(i, 2, "handlePokeAuth failed ", paramString1);
      }
    }
  }
  
  public void a(int paramInt, String paramString, ApolloRspCallback paramApolloRspCallback)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "apollo_core.set_status");
      if (TextUtils.isEmpty(paramString))
      {
        paramString = "android";
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("android.");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
      }
      localJSONObject.put("from", paramString);
      localJSONObject.put("status", paramInt);
      paramString = g("8.8.17");
      paramString.reqdata.set(localJSONObject.toString());
      paramString = a("apollo_core.set_status", this.m.getApp(), paramString.toByteArray());
      paramString.putExtra("apollo_status", paramInt);
      ApolloRequestCallbackManager.a.a(paramApolloRspCallback, paramString);
      this.m.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(i, 2, "changeApolloStatus failed ", paramString);
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = i;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[reportGamePubAccountMsgList] status:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(",msg:");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(",url:");
      ((StringBuilder)localObject2).append(paramString2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new MonitReport.MonitReportReq();
    ((MonitReport.MonitReportReq)localObject1).type.set(1);
    Object localObject2 = new MonitReport.PublicAccountReq();
    ((MonitReport.PublicAccountReq)localObject2).action.set(paramInt);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = Long.valueOf(0L);
    } else {
      paramString1 = Long.valueOf(Long.parseLong(paramString1));
    }
    ((MonitReport.PublicAccountReq)localObject2).msgid.set(paramString1.longValue());
    ((MonitReport.PublicAccountReq)localObject2).url.set(paramString2);
    ((MonitReport.PublicAccountReq)localObject2).ts.set(NetConnInfoCenter.getServerTimeMillis());
    ((MonitReport.MonitReportReq)localObject1).public_acct_req.add((MessageMicro)localObject2);
    paramString1 = g("8.8.17");
    paramString1.pbReqData.set(ByteStringMicro.copyFrom(((MonitReport.MonitReportReq)localObject1).toByteArray()));
    paramString1 = a("gc_monitor_report.report_public_acct_info", this.m.getApp(), paramString1.toByteArray());
    this.m.startServlet(paramString1);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, float paramFloat, int paramInt3, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "apollo_core.check_act");
      if (TextUtils.isEmpty(paramString3))
      {
        localObject = "android";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("android.");
        ((StringBuilder)localObject).append(paramString3);
        localObject = ((StringBuilder)localObject).toString();
      }
      localJSONObject.put("from", localObject);
      localJSONObject.put("actid", paramInt1);
      Object localObject = g("8.8.17");
      ((WebSSOAgent.UniSsoServerReq)localObject).reqdata.set(localJSONObject.toString());
      localObject = a("apollo_core.check_act", this.m.getApp(), ((WebSSOAgent.UniSsoServerReq)localObject).toByteArray());
      ((NewIntent)localObject).putExtra("actionId", paramInt1);
      if (!TextUtils.isEmpty(paramString1)) {
        ((NewIntent)localObject).putExtra("actionText", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        ((NewIntent)localObject).putExtra("textType", paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        ((NewIntent)localObject).putExtra("optFrom", paramString3);
      }
      ((NewIntent)localObject).putExtra("audioId", paramInt2);
      ((NewIntent)localObject).putExtra("audioTime", paramFloat);
      ((NewIntent)localObject).putExtra("isPlayDefultAudio", paramInt3);
      this.m.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = i;
        paramString3 = new StringBuilder();
        paramString3.append("checkActionAuth failed id: ");
        paramString3.append(paramInt1);
        QLog.e(paramString2, 2, paramString3.toString(), paramString1);
      }
    }
  }
  
  public void a(int paramInt, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = i;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[reportGamePubAccountMsgList] status:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" size:");
      ((StringBuilder)localObject2).append(paramList.size());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new MonitReport.MonitReportReq();
    ((MonitReport.MonitReportReq)localObject1).type.set(1);
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
      MonitReport.PublicAccountReq localPublicAccountReq = new MonitReport.PublicAccountReq();
      localPublicAccountReq.action.set(paramInt);
      paramList = localMessageRecord.getExtInfoFromExtStr("pa_msgId");
      if (TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("pa_msgId"))) {
        paramList = "0";
      }
      localPublicAccountReq.msgid.set(Long.parseLong(paramList));
      localPublicAccountReq.ts.set(NetConnInfoCenter.getServerTimeMillis());
      ((MonitReport.MonitReportReq)localObject1).public_acct_req.add(localPublicAccountReq);
    }
    paramList = g("8.8.17");
    paramList.pbReqData.set(ByteStringMicro.copyFrom(((MonitReport.MonitReportReq)localObject1).toByteArray()));
    paramList = a("gc_monitor_report.report_public_acct_info", this.m.getApp(), paramList.toByteArray());
    this.m.startServlet(paramList);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    NewIntent localNewIntent = new NewIntent(this.m.getApp(), ApolloExtensionServlet.class);
    localNewIntent.putExtra("cmd", b);
    localNewIntent.putExtra("pendantId", paramLong);
    localNewIntent.putExtra("seriesId", paramInt1);
    localNewIntent.putExtra("uin", this.m.getCurrentAccountUin());
    PendantMarket.SetAddonReq localSetAddonReq = new PendantMarket.SetAddonReq();
    localSetAddonReq.cmd.set(2);
    localSetAddonReq.int_platform.set(2);
    localSetAddonReq.long_addon_id.set(paramLong);
    localSetAddonReq.str_qq_version.set("8.8.17");
    if (paramInt2 != -1) {
      localSetAddonReq.int_from_type.set(paramInt2);
    }
    localNewIntent.putExtra("data", localSetAddonReq.toByteArray());
    localNewIntent.putExtra("timeout", 30000);
    this.m.startServlet(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Object localObject1 = new group_effect_commu.ReqBody();
    ((group_effect_commu.ReqBody)localObject1).u64_cmd.set(paramLong1);
    ((group_effect_commu.ReqBody)localObject1).u64_uin.set(Long.parseLong(this.m.getCurrentAccountUin()));
    ((group_effect_commu.ReqBody)localObject1).i32_implat.set(109);
    ((group_effect_commu.ReqBody)localObject1).str_version.set(DeviceInfoUtil.e());
    Object localObject2;
    if (paramLong1 == 8192L)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendTroopEnterEffectCMD ENTER_GROUP troopId = ");
        ((StringBuilder)localObject2).append(paramLong2);
        QLog.d("TroopEnterEffect", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new group_effect_commu.TEntryNotifyReq0x2000();
      ((group_effect_commu.TEntryNotifyReq0x2000)localObject2).group_id.set(paramLong2);
      ((group_effect_commu.ReqBody)localObject1).st_entry_notify.set((MessageMicro)localObject2);
    }
    else if (paramLong1 == 2L)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendTroopEnterEffectCMD GET_MY_EFFECT troopId = ");
        ((StringBuilder)localObject2).append(paramLong2);
        QLog.d("TroopEnterEffect", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new group_effect_commu.TGetMyEffectReq0x2();
      ((group_effect_commu.ReqBody)localObject1).st_get_effect.set((MessageMicro)localObject2);
    }
    localObject1 = a("Groupeffect.commop", this.m.getApp(), ((group_effect_commu.ReqBody)localObject1).toByteArray());
    ((NewIntent)localObject1).putExtra("usrdata", paramLong1);
    this.m.startServlet((NewIntent)localObject1);
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(i, 2, "handlePraiseAuthResponse");
    }
    try
    {
      if (!paramFromServiceMsg.isSuccess())
      {
        paramIntent = i;
        paramObject = new StringBuilder();
        paramObject.append("handlePraiseAuthResponse, isSuccess false, error code=");
        paramObject.append(paramFromServiceMsg.getResultCode());
        QLog.e(paramIntent, 1, paramObject.toString());
        return;
      }
      paramIntent = new praise_sso.TPraiseSsoRsp();
      paramIntent.mergeFrom((byte[])paramObject);
      int i1 = paramIntent.i32_ret.get();
      paramIntent = (praise_sso.TSsoCmd0x1Rsp)paramIntent.st_cmd0x1_rsp.get();
      int i2 = paramIntent.i32_itemId.get();
      paramIntent = paramIntent.str_url.get();
      if (i1 == 0)
      {
        PraiseManager.a(this.m, i2);
      }
      else
      {
        paramFromServiceMsg = i;
        paramObject = new StringBuilder();
        paramObject.append("handlePraiseAuthResponse, ret=");
        paramObject.append(i1);
        QLog.e(paramFromServiceMsg, 1, paramObject.toString());
      }
      if ((this.h != null) && (this.o != null))
      {
        this.o.a(i1, i2, paramIntent, this.h);
        this.h = null;
        this.o = null;
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e(i, 1, "handlePraiseAuthResponse exception", paramIntent);
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("cmd");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (c(paramIntent, paramFromServiceMsg, paramArrayOfByte)) {
      return;
    }
    if (paramIntent.getBooleanExtra("isCMShowJSRequest", false))
    {
      d(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return;
    }
    Object localObject = new ApolloRequestReceiveParams();
    ((ApolloRequestReceiveParams)localObject).b = paramIntent;
    ((ApolloRequestReceiveParams)localObject).c = paramFromServiceMsg;
    ((ApolloRequestReceiveParams)localObject).d = paramArrayOfByte;
    ((ApolloRequestReceiveParams)localObject).e = this;
    ((ApolloRequestReceiveParams)localObject).a = this.m;
    if (this.n.a(str, localObject)) {
      return;
    }
    if (a(paramIntent, paramFromServiceMsg, paramArrayOfByte, str)) {
      return;
    }
    localObject = (IVasExtensionHandler)f.get(str);
    if (localObject != null)
    {
      ((IVasExtensionHandler)localObject).a(this, paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = i;
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("unknow cmd :");
      paramFromServiceMsg.append(str);
      QLog.e(paramIntent, 2, paramFromServiceMsg.toString());
    }
  }
  
  public void a(Intent paramIntent, byte[] paramArrayOfByte)
  {
    PendantMarket.SetAddonRsp localSetAddonRsp = new PendantMarket.SetAddonRsp();
    Object localObject2;
    try
    {
      localSetAddonRsp.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localSetAddonRsp;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      paramArrayOfByte = null;
      localObject2 = i;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("handlePendantAuthRsp rsp.mergeFrom e=");
      ((StringBuilder)localObject3).append(localInvalidProtocolBufferMicroException);
      QLog.e((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    }
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject3 = new Bundle();
    int i1 = paramArrayOfByte.int_result.get();
    ((Bundle)localObject3).putLong("pendantId", paramIntent.getLongExtra("pendantId", -1L));
    ((Bundle)localObject3).getInt("seriesId", paramIntent.getIntExtra("seriesId", -1));
    ((Bundle)localObject3).putString("uin", paramIntent.getStringExtra("uin"));
    Object localObject1;
    Object localObject4;
    if (i1 != 0)
    {
      boolean bool = paramArrayOfByte.tips_info.has();
      localObject1 = "";
      if (bool)
      {
        localObject4 = new PendantMarket.TipsInfo();
        try
        {
          ((PendantMarket.TipsInfo)localObject4).mergeFrom(paramArrayOfByte.tips_info.toByteArray());
          PendantTipsInfo localPendantTipsInfo = new PendantTipsInfo();
          bool = ((PendantMarket.TipsInfo)localObject4).valid.get();
          localPendantTipsInfo.valid = bool;
          if (bool)
          {
            localPendantTipsInfo.type = ((PendantMarket.TipsInfo)localObject4).type.get();
            localObject2 = ((PendantMarket.TipsInfo)localObject4).title_wording.get();
            paramIntent = (Intent)localObject2;
            if (((String)localObject2).equals("")) {
              paramIntent = HardCodeUtil.a(2131913248);
            }
            localPendantTipsInfo.titleWording = paramIntent;
            localPendantTipsInfo.wording = ((PendantMarket.TipsInfo)localObject4).wording.get();
            localObject2 = ((PendantMarket.TipsInfo)localObject4).right_btn_wording.get();
            paramIntent = (Intent)localObject2;
            if (((String)localObject2).equals("")) {
              paramIntent = HardCodeUtil.a(2131913249);
            }
            localPendantTipsInfo.rightBtnWording = paramIntent;
            localObject2 = ((PendantMarket.TipsInfo)localObject4).left_btn_wording.get();
            paramIntent = (Intent)localObject2;
            if (((String)localObject2).equals("")) {
              paramIntent = HardCodeUtil.a(2131898212);
            }
            localPendantTipsInfo.leftBtnWording = paramIntent;
            localPendantTipsInfo.vipType = ((PendantMarket.TipsInfo)localObject4).vip_type.get();
            localPendantTipsInfo.vipMonth = ((PendantMarket.TipsInfo)localObject4).vip_month.get();
            localPendantTipsInfo.url = ((PendantMarket.TipsInfo)localObject4).url.get();
          }
          ((Bundle)localObject3).putSerializable("tipsInfo", localPendantTipsInfo);
        }
        catch (InvalidProtocolBufferMicroException paramIntent)
        {
          localObject2 = i;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("handlePendantAuthRsp tipsInfo.mergeFrom e=");
          ((StringBuilder)localObject4).append(paramIntent);
          QLog.e((String)localObject2, 1, ((StringBuilder)localObject4).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("response from server error: ");
        paramIntent.append(i1);
        QLog.e("VasExtensionHandler", 2, paramIntent.toString());
      }
      ((Bundle)localObject3).putInt("result", i1);
      if ((i1 != 1002) && (i1 != 1004)) {
        if (i1 != 6001)
        {
          if (i1 == 2001) {}
        }
        else
        {
          if (paramArrayOfByte.str_msg.has()) {
            paramIntent = paramArrayOfByte.str_msg.get();
          } else {
            paramIntent = "";
          }
          if (paramArrayOfByte.str_url.has()) {
            localObject1 = paramArrayOfByte.str_url.get();
          }
          ((Bundle)localObject3).putString("tips", paramIntent);
          ((Bundle)localObject3).putString("url", (String)localObject1);
        }
      }
      notifyUI(1, false, localObject3);
      return;
    }
    paramArrayOfByte = this.m;
    if (paramArrayOfByte != null)
    {
      localObject2 = (FriendsManager)paramArrayOfByte.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject4 = paramIntent.getStringExtra("uin");
      localObject1 = ((FriendsManager)localObject2).x((String)localObject4);
      paramArrayOfByte = (byte[])localObject1;
      if (localObject1 == null)
      {
        paramArrayOfByte = new ExtensionInfo();
        paramArrayOfByte.uin = ((String)localObject4);
      }
      paramArrayOfByte.pendantId = paramIntent.getLongExtra("pendantId", -1L);
      paramArrayOfByte.pendantDiyId = paramIntent.getIntExtra("pendantDiyId", 0);
      paramArrayOfByte.timestamp = System.currentTimeMillis();
      ((FriendsManager)localObject2).a(paramArrayOfByte);
    }
    notifyUI(1, true, localObject3);
  }
  
  public void a(ApolloExtensionHandler.OnQueryBaseInfoListener paramOnQueryBaseInfoListener)
  {
    synchronized (this.p)
    {
      this.p.add(paramOnQueryBaseInfoListener);
      return;
    }
  }
  
  public void a(ApolloBaseInfo paramApolloBaseInfo)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = i;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("apolloDrawerStatus:");
        ((StringBuilder)localObject2).append(paramApolloBaseInfo.apolloDrawerStatus);
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(";apolloCardStatus:");
        ((StringBuilder)localObject3).append(paramApolloBaseInfo.apolloCardStatus);
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(";apolloAIOStatus:");
        localStringBuilder.append(paramApolloBaseInfo.apolloAIOStatus);
        QLog.d((String)localObject1, 2, new Object[] { "setCMShowSwitch ", localObject2, localObject3, localStringBuilder.toString() });
      }
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("drawer", paramApolloBaseInfo.apolloDrawerStatus);
      ((JSONObject)localObject1).put("data_card", paramApolloBaseInfo.apolloCardStatus);
      ((JSONObject)localObject1).put("aio", paramApolloBaseInfo.apolloAIOStatus);
      ((JSONObject)localObject1).put("from", "aioDoubleTap");
      a(g("8.8.17.5770"), (JSONObject)localObject1, "apollo_router_light.cmshow_2d_linkcmd_set_user_switch");
      return;
    }
    catch (Exception paramApolloBaseInfo)
    {
      QLog.e(i, 1, "[setCMShowSwitch] exception=", paramApolloBaseInfo);
    }
  }
  
  public void a(String paramString)
  {
    if (this.m != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.m.getLongAccountUin()));
      a(localArrayList, paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(i, 2, "[buyActionByGold]");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "apollo_currency.buy_item_by_curre");
      localJSONObject.put("from", "Android");
      localJSONObject.put("toUin", Long.parseLong(paramString));
      localJSONObject.put("isSave", 0);
      localJSONObject.put("isGift", 0);
      paramString = new JSONArray();
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("type", 3);
      ((JSONObject)localObject).put("id", paramInt1);
      paramString.put(localObject);
      localJSONObject.put("buyList", paramString);
      localObject = ((TicketManager)this.m.getManager(2)).getSkey(this.m.getCurrentAccountUin());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("skey=");
      paramString = (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramString = "";
      }
      localStringBuilder.append(paramString);
      localJSONObject.put("Cookie", localStringBuilder.toString());
      paramString = g("8.8.17");
      paramString.reqdata.set(localJSONObject.toString());
      paramString = a("apollo_currency.buy_item_by_curre", this.m.getApp(), paramString.toByteArray());
      paramString.putExtra("id", paramInt1);
      paramString.putExtra("packageId", paramInt2);
      this.m.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(i, 1, "[handleBuyActionByGold] exception=", paramString);
    }
  }
  
  public void a(String paramString, int paramInt, ApolloRspCallback paramApolloRspCallback)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramString = "android";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("android.");
        ((StringBuilder)localObject).append(paramString);
        paramString = ((StringBuilder)localObject).toString();
      }
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_core.set_model");
      ((JSONObject)localObject).put("from", paramString);
      ((JSONObject)localObject).put("model", paramInt);
      paramString = g("8.8.17");
      paramString.reqdata.set(((JSONObject)localObject).toString());
      paramString = a("apollo_core.set_model", this.m.getApp(), paramString.toByteArray());
      paramString.putExtra("model", paramInt);
      ApolloRequestCallbackManager.a.a(paramApolloRspCallback, paramString);
      this.m.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(i, 1, paramString.getMessage());
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    long l1 = paramLong;
    if (0L == paramLong) {
      l1 = -1L;
    }
    if (QLog.isColorLevel()) {
      QLog.d(i, 2, "");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "apollo_core.get_user_info_v2");
      if (TextUtils.isEmpty(paramString2))
      {
        paramString2 = "android";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("android.");
        ((StringBuilder)localObject).append(paramString2);
        paramString2 = ((StringBuilder)localObject).toString();
      }
      localJSONObject.put("from", paramString2);
      localJSONObject.put("touin", Long.valueOf(paramString1));
      localJSONObject.put("mask", l1);
      Object localObject = ((TicketManager)this.m.getManager(2)).getSkey(this.m.getCurrentAccountUin());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("skey=");
      paramString2 = (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramString2 = "";
      }
      localStringBuilder.append(paramString2);
      localJSONObject.put("Cookie", localStringBuilder.toString());
      paramString2 = g("8.8.17");
      paramString2.reqdata.set(localJSONObject.toString());
      paramString2 = a("apollo_core.get_user_info_v2", this.m.getApp(), paramString2.toByteArray());
      paramString2.putExtra("touin", paramString1);
      paramString2.putExtra("mask", l1);
      this.m.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(i, 1, "getUserApolloInfo failed ", paramString1);
    }
  }
  
  public void a(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.p)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        ApolloExtensionHandler.OnQueryBaseInfoListener localOnQueryBaseInfoListener = (ApolloExtensionHandler.OnQueryBaseInfoListener)localIterator.next();
        if (localOnQueryBaseInfoListener.b(paramString, paramApolloBaseInfo)) {
          localArrayList.add(localOnQueryBaseInfoListener);
        }
      }
      this.p.removeAll(localArrayList);
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(String paramString, MessageMicro paramMessageMicro, Class paramClass, BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), ApolloExtensionServlet.class);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    long l1 = k + 1L;
    k = l1;
    ((StringBuilder)localObject).append(l1);
    localObject = ((StringBuilder)localObject).toString();
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramMessageMicro.toByteArray());
    localNewIntent.putExtra("timeout", 30000L);
    localNewIntent.putExtra("__cmd_seq__", (String)localObject);
    localNewIntent.putExtra("__rspClass__", paramClass);
    this.l.put(localObject, paramBusinessObserver);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(String paramString, Object paramObject, int paramInt)
  {
    try
    {
      paramObject = (ArrayList)paramObject;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ColorNick", 1, "[modifyTroopMemberCardInfoWithColorNick] error! ", paramObject);
      }
      paramObject = null;
    }
    if ((paramObject != null) && (paramObject.size() != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("modifyTroopMemberCardInfoWithColorNick troopUin = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ColorNick", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Oidb_0x8fc.ReqBody();
      ((Oidb_0x8fc.ReqBody)localObject).uint64_group_code.set(Long.parseLong(paramString));
      ArrayList localArrayList1 = new ArrayList();
      Oidb_0x8fc.MemberInfo localMemberInfo = new Oidb_0x8fc.MemberInfo();
      long l1 = Long.parseLong(this.m.getCurrentAccountUin());
      localMemberInfo.uint64_uin.set(l1);
      ArrayList localArrayList2 = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramObject.iterator();
      while (localIterator.hasNext())
      {
        ColorClearableEditText.Paragraph localParagraph = (ColorClearableEditText.Paragraph)localIterator.next();
        Oidb_0x8fc.RichCardNameElem localRichCardNameElem = new Oidb_0x8fc.RichCardNameElem();
        int i1 = localParagraph.e;
        if (i1 != 1)
        {
          if ((i1 == 2) || (i1 == 3))
          {
            paramObject = localParagraph.c;
            paramString = paramObject;
            if (paramObject.substring(0, 1).equals("<")) {
              paramString = paramObject.substring(1);
            }
            paramObject = paramString;
            if (paramString.substring(paramString.length() - 1).equals(">")) {
              paramObject = paramString.substring(0, paramString.length() - 1);
            }
            localRichCardNameElem.bytes_ctrl.set(ByteStringMicro.copyFrom(paramObject.getBytes()));
          }
        }
        else
        {
          localRichCardNameElem.bytes_text.set(ByteStringMicro.copyFrom(localParagraph.c.getBytes()));
          localStringBuilder.append(localParagraph.c);
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("modifyTroopMemberCardInfoWithColorNick type = ");
          paramString.append(localParagraph.e);
          paramString.append(" text = ");
          paramString.append(localParagraph.c);
          QLog.d("ColorNick", 2, paramString.toString());
        }
        localArrayList2.add(localRichCardNameElem);
      }
      paramString = new Oidb_0x8fc.CommCardNameBuf();
      paramString.rpt_rich_card_name.set(localArrayList2);
      paramString.uint32_cool_id.set(paramInt);
      localMemberInfo.bytes_comm_rich_card_name.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
      localMemberInfo.member_card_name.set(ByteStringMicro.copyFrom(localStringBuilder.toString().getBytes()));
      localArrayList1.add(localMemberInfo);
      ((Oidb_0x8fc.ReqBody)localObject).rpt_mem_level_info.set(localArrayList1);
      paramString = new Oidb_0x8fc.ClientInfo();
      paramString.uint32_implat.set(109);
      paramString.string_clientver.set(DeviceInfoUtil.e());
      ((Oidb_0x8fc.ReqBody)localObject).msg_client_info.set(paramString);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(2300);
      paramString.uint32_service_type.set(3);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x8fc.ReqBody)localObject).toByteArray()));
      paramString = a("OidbSvc.0x8fc_3", this.m.getApp(), paramString.toByteArray());
      this.m.startServlet(paramString);
      return;
    }
    QLog.e("ColorNick", 1, "modifyTroopMemberCardInfoWithColorNick paragraphs is empty");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "apollo_extend.zan");
      if (TextUtils.isEmpty(paramString2))
      {
        paramString2 = "android";
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("android.");
        localStringBuilder.append(paramString2);
        paramString2 = localStringBuilder.toString();
      }
      localJSONObject.put("from", paramString2);
      localJSONObject.put("touin", Long.parseLong(paramString1));
      a(g("8.8.17"), localJSONObject, "apollo_extend.zan");
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(i, 1, "changeApolloStatus failed ", paramString1);
    }
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, int paramInt)
  {
    QLog.d(i, 1, "[reportGameAchievement]");
    try
    {
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = g("8.8.17.5770");
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("appid", paramString1);
      localJSONObject3.put("tt", 1);
      localJSONObject3.put("type", paramInt);
      localJSONObject3.put("uin", paramString2);
      localJSONObject3.put("skey", ((TicketManager)this.m.getManager(2)).getSkey(this.m.getCurrentAccountUin()));
      localJSONObject2.put("req", localJSONObject3);
      localJSONObject1.put("13077", localJSONObject2);
      localUniSsoServerReq.reqdata.set(localJSONObject1.toString());
      paramString2 = a("GameCenterWebSvc.13077", this.m.getApp(), localUniSsoServerReq.toByteArray());
      paramString2.putExtra("appid", paramString1);
      this.m.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(i, 1, "[reportGameAchievement] exception=", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {}
    try
    {
      paramString1 = new StringBuilder();
      paramString1.append(i);
      paramString1.append("_apollo_store_stability_");
      QLog.e(paramString1.toString(), 1, "reportApolloStoreStabilityData. cmd == null || url == null");
      return;
    }
    catch (Exception paramString1)
    {
      Object localObject1;
      Object localObject2;
      paramString2 = new StringBuilder();
      paramString2.append(i);
      paramString2.append("_apollo_store_stability_");
      QLog.e(paramString2.toString(), 1, "reportApolloStoreStabilityData failed ", paramString1);
    }
    localObject1 = new WebSsoBody.STServiceMonitReq();
    localObject2 = new WebSsoBody.STServiceMonitItem();
    ((WebSsoBody.STServiceMonitItem)localObject2).errcode.set(paramInt1);
    if (!TextUtils.isEmpty(paramString1)) {
      ((WebSsoBody.STServiceMonitItem)localObject2).cmd.set(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ((WebSsoBody.STServiceMonitItem)localObject2).url.set(paramString2);
    }
    ((WebSsoBody.STServiceMonitItem)localObject2).cost.set(paramInt2);
    ((WebSsoBody.STServiceMonitItem)localObject2).src.set(1);
    ((WebSsoBody.STServiceMonitReq)localObject1).list.add((MessageMicro)localObject2);
    localObject2 = g("8.8.17");
    ((WebSSOAgent.UniSsoServerReq)localObject2).pbReqData.set(ByteStringMicro.copyFrom(((WebSsoBody.STServiceMonitReq)localObject1).toByteArray()));
    localObject1 = a("apollo_dc_report.service_monit", this.m.getApp(), ((WebSSOAgent.UniSsoServerReq)localObject2).toByteArray());
    this.m.startServlet((NewIntent)localObject1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportApolloStoreStabilityData cmd: ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" url:");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" errcode:");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" cost:");
      ((StringBuilder)localObject1).append(paramInt2);
      paramString1 = new StringBuilder();
      paramString1.append(i);
      paramString1.append("_apollo_store_stability_");
      QLog.d(paramString1.toString(), 2, ((StringBuilder)localObject1).toString());
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, BusinessObserver paramBusinessObserver)
  {
    try
    {
      a(paramString1, paramString2.getBytes("ISO8859_1"), paramBusinessObserver);
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), ApolloExtensionServlet.class);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    long l1 = k + 1L;
    k = l1;
    ((StringBuilder)localObject).append(l1);
    localObject = ((StringBuilder)localObject).toString();
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("timeout", 30000L);
    localNewIntent.putExtra("__cmd_seq__", (String)localObject);
    this.l.put(localObject, paramBusinessObserver);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(ArrayList<Long> paramArrayList, String paramString)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      paramArrayList.removeAll(this.g);
      Object localObject = paramArrayList;
      if (paramArrayList.size() > 1)
      {
        paramArrayList = new HashSet(paramArrayList);
        localObject = new ArrayList();
        ((ArrayList)localObject).addAll(paramArrayList);
      }
      this.g.addAll((Collection)localObject);
      if (QLog.isColorLevel())
      {
        paramArrayList = i;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getGetUserApolloDress uinList size: ");
        localStringBuilder.append(((ArrayList)localObject).size());
        localStringBuilder.append(", queue size: ");
        localStringBuilder.append(this.g.size());
        localStringBuilder.append(",from: ");
        localStringBuilder.append(paramString);
        QLog.d(paramArrayList, 2, localStringBuilder.toString());
      }
      int i2;
      for (int i1 = 0; i1 < ((ArrayList)localObject).size(); i1 = i2)
      {
        i2 = i1 + 16;
        int i3;
        if (i2 < ((ArrayList)localObject).size()) {
          i3 = i2;
        } else {
          i3 = ((ArrayList)localObject).size();
        }
        a((Long[])new ArrayList(((ArrayList)localObject).subList(i1, i3)).toArray(new Long[0]), paramString);
      }
    }
  }
  
  public void a(long... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, "getApolloStandAction.");
    }
    if (paramVarArgs.length == 0) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "apollo_terminal_info.get_user_appear_info");
      localJSONObject.put("from", "android");
      JSONArray localJSONArray = new JSONArray();
      int i1 = 0;
      while (i1 < paramVarArgs.length)
      {
        localJSONArray.put(paramVarArgs[i1]);
        i1 += 1;
      }
      localJSONObject.put("touins", localJSONArray);
      a(g("8.8.17"), localJSONObject, "apollo_terminal_info.get_user_appear_info");
      return;
    }
    catch (Exception paramVarArgs)
    {
      if (QLog.isColorLevel()) {
        QLog.e(i, 2, "getApolloStandAction failed ", paramVarArgs);
      }
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramArrayOfString[i1];
      try
      {
        long l1 = Long.parseLong(str);
        ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l1));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i1 += 1;
    }
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_vip_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_vip_level.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_status.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_timestamp.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_cmshow_3d_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_flag_super_yellow_diamond.set(1);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1515);
    localOIDBSSOPkg.uint32_service_type.set(15);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5eb_15", this.m.getApp(), localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).putExtra("uins", paramArrayOfString);
    this.m.startServlet((NewIntent)localObject);
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    a(paramArrayOfString, paramArrayOfInt, 99);
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt)
  {
    GetStrangerVasInfoHandler.a(this.m, paramArrayOfString, paramArrayOfInt, paramInt);
  }
  
  public void b()
  {
    try
    {
      if (this.m == null)
      {
        QLog.e(i, 1, "[getApolloLoginData] app is null");
        return;
      }
      Object localObject = new STGameLogin.STGameLoginReq();
      ((STGameLogin.STGameLoginReq)localObject).local_ts.set((int)0L);
      ((STGameLogin.STGameLoginReq)localObject).from.set("android");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = g("8.8.17.5770");
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((STGameLogin.STGameLoginReq)localObject).toByteArray()));
      if (QLog.isColorLevel()) {
        QLog.d(i, 1, new Object[] { "getApolloGameLoginReq ts:", Long.valueOf(0L) });
      }
      localObject = new NewIntent(this.m.getApp(), ApolloExtensionServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "apollo_game_login.get_user_game_list_info");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.m.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(i, 1, "[getApolloGameLoginReq] exception=", localException);
    }
  }
  
  public void b(int paramInt)
  {
    QLog.d(i, 1, "reportPadFaceShown");
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("uin", Long.parseLong(this.m.getCurrentAccountUin()));
      localJSONObject3.put("id", paramInt);
      localJSONObject3.put("qq_plat", 1);
      localJSONObject3.put("qq_version", "8.8.17.5770");
      localJSONObject2.put("req", localJSONObject3);
      localJSONObject1.put("12827", localJSONObject2);
      a(g("8.8.17.5770"), localJSONObject1, "QQVacCommSvc.report_padface_shown");
      return;
    }
    catch (Exception localException)
    {
      QLog.e(i, 1, "[reportPadFaceShown] exception=", localException);
    }
  }
  
  public void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
      paramIntent = new SCUpdatePB.SCUpdateRsp();
    }
    for (;;)
    {
      try
      {
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = i;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("handleQuickUpdate ret: ");
          paramArrayOfByte.append(paramIntent.ret.get());
          QLog.d(paramFromServiceMsg, 2, paramArrayOfByte.toString());
        }
        if (!paramIntent.comm.cookie.has()) {
          break label664;
        }
        l1 = paramIntent.comm.cookie.get();
        if (paramIntent.ret.get() == 0L)
        {
          int i1;
          Object localObject;
          if (paramIntent.cmd.get() == 1)
          {
            paramFromServiceMsg = new VasQuickUpdateManager.SyncVCRRsp();
            paramFromServiceMsg.cookie = l1;
            paramFromServiceMsg.seq = paramIntent.rsp0x01.seq.get();
            paramFromServiceMsg.continueFlag = paramIntent.rsp0x01.continue_flag.get();
            paramFromServiceMsg.polltime = paramIntent.comm.polltime.get();
            paramFromServiceMsg.syncSwitch = paramIntent.rsp0x01.sync_switch.get();
            paramFromServiceMsg.environment = paramIntent.rsp0x01.environment.get();
            i1 = 0;
            if (i1 < paramIntent.rsp0x01.vcr_list.size())
            {
              paramArrayOfByte = (SCUpdatePB.VCR)paramIntent.rsp0x01.vcr_list.get(i1);
              localObject = new VasQuickUpdateManager.VCR();
              ((VasQuickUpdateManager.VCR)localObject).set(paramArrayOfByte);
              paramFromServiceMsg.vcrList.add(localObject);
              i1 += 1;
              continue;
            }
            paramFromServiceMsg.preload.ver = paramIntent.rsp0x01.preload.plver.get();
            paramFromServiceMsg.preload.setList(paramIntent.rsp0x01.preload.item_list);
            paramFromServiceMsg.report.ver = paramIntent.rsp0x01.report.rpver.get();
            paramFromServiceMsg.report.setList(paramIntent.rsp0x01.report.item_list);
            notifyUI(16, true, paramFromServiceMsg);
            return;
          }
          if (paramIntent.cmd.get() == 2)
          {
            paramFromServiceMsg = new VasQuickUpdateManager.GetUrlRsp();
            paramFromServiceMsg.cookie = l1;
            i1 = 0;
            if (i1 < paramIntent.rsp0x02.update_list.size())
            {
              paramArrayOfByte = (SCUpdatePB.UpdateInfo)paramIntent.rsp0x02.update_list.get(i1);
              localObject = new VasQuickUpdateManager.UpdateInfo();
              ((VasQuickUpdateManager.UpdateInfo)localObject).set(paramArrayOfByte, i1);
              paramFromServiceMsg.updateList.add(localObject);
              i1 += 1;
              continue;
            }
            notifyUI(17, true, paramFromServiceMsg);
          }
        }
        else
        {
          paramFromServiceMsg = i;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("handleQuickUpdate result = ");
          paramArrayOfByte.append(paramIntent.ret.get());
          paramArrayOfByte.append("msg = ");
          paramArrayOfByte.append(paramIntent.msg.get());
          QLog.e(paramFromServiceMsg, 1, paramArrayOfByte.toString());
          paramFromServiceMsg = new VasQuickUpdateManager.QuickUpdateRsp();
          paramFromServiceMsg.ret = paramIntent.ret.get();
          paramFromServiceMsg.cookie = l1;
          if (paramIntent.cmd.get() == 1)
          {
            notifyUI(16, false, paramFromServiceMsg);
            return;
          }
          if (paramIntent.cmd.get() == 2)
          {
            notifyUI(17, false, paramFromServiceMsg);
            return;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e(i, 1, "handleQuickUpdate error: ", paramFromServiceMsg);
        paramFromServiceMsg = new VasQuickUpdateManager.QuickUpdateRsp();
        paramFromServiceMsg.ret = -1L;
        paramFromServiceMsg.cookie = 0L;
        if (paramIntent.cmd.get() == 1)
        {
          notifyUI(16, false, paramFromServiceMsg);
          return;
        }
        if (paramIntent.cmd.get() == 2) {
          notifyUI(17, false, paramFromServiceMsg);
        }
      }
      return;
      label664:
      long l1 = 0L;
    }
  }
  
  public void b(ApolloExtensionHandler.OnQueryBaseInfoListener paramOnQueryBaseInfoListener)
  {
    synchronized (this.p)
    {
      this.p.remove(paramOnQueryBaseInfoListener);
      return;
    }
  }
  
  public void b(String paramString)
  {
    a(new String[] { paramString });
  }
  
  public void b(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.p)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        ApolloExtensionHandler.OnQueryBaseInfoListener localOnQueryBaseInfoListener = (ApolloExtensionHandler.OnQueryBaseInfoListener)localIterator.next();
        if (localOnQueryBaseInfoListener.a(paramString, paramApolloBaseInfo)) {
          localArrayList.add(localOnQueryBaseInfoListener);
        }
      }
      this.p.removeAll(localArrayList);
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[doCMGameReq], cmd:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",reqData:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", app: ");
      localStringBuilder.append(this.m);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    try
    {
      localObject = g("8.8.17.5770");
      ((WebSSOAgent.UniSsoServerReq)localObject).reqdata.set(paramString2);
      localObject = a(paramString1, this.m.getApp(), ((WebSSOAgent.UniSsoServerReq)localObject).toByteArray());
      ((NewIntent)localObject).putExtra("callFrom", paramInt);
      ((NewIntent)localObject).putExtra("isCMShowJSRequest", true);
      if ("apollo_terminal_info.get_user_slaves_v2".equals(paramString1)) {
        ((NewIntent)localObject).putExtra("reqData", paramString2);
      }
      this.m.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(i, 1, "doCMGameReq failed ", paramString1);
    }
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    try
    {
      SCUpdatePB.SCUpdateReq localSCUpdateReq = new SCUpdatePB.SCUpdateReq();
      localSCUpdateReq.comm.plat.set(109);
      localSCUpdateReq.comm.qver.set(ByteStringMicro.copyFrom("8.8.17.5770".getBytes()));
      localSCUpdateReq.comm.osrelease.set(ByteStringMicro.copyFrom(String.valueOf(Build.VERSION.SDK_INT).getBytes()));
      localSCUpdateReq.comm.network.set(NetworkUtil.getNetworkType(this.m.getApplication()));
      localSCUpdateReq.comm.setHasFlag(true);
      paramString2 = new JSONObject(paramString2);
      if (paramString2.has("cookie")) {
        localSCUpdateReq.comm.cookie.set(paramString2.optLong("cookie"));
      }
      if (paramString2.has("force")) {
        localSCUpdateReq.comm.force.set(paramString2.optInt("force"));
      } else {
        localSCUpdateReq.comm.force.set(2);
      }
      boolean bool = "SyncVCRReq".equals(paramString1);
      long l1;
      long l2;
      long l3;
      Object localObject;
      int i2;
      SCUpdatePB.ItemVersion localItemVersion;
      if (bool)
      {
        localSCUpdateReq.cmd.set(1);
        l1 = paramString2.optLong("seq");
        i1 = paramString2.optInt("sync_mode");
        l2 = paramString2.optLong("plver");
        l3 = paramString2.optLong("rpver");
        localSCUpdateReq.req0x01.seq.set(l1);
        localSCUpdateReq.req0x01.sync_mode.set(i1);
        localSCUpdateReq.req0x01.plver.set(l2);
        localSCUpdateReq.req0x01.rpver.set(l3);
        paramString1 = paramString2.optJSONArray("item_list");
        if (paramString1 != null)
        {
          i1 = 0;
          while (i1 < paramString1.length())
          {
            localObject = paramString1.getJSONObject(i1);
            i2 = ((JSONObject)localObject).optInt("bid");
            paramString2 = ((JSONObject)localObject).optString("scid");
            localObject = ((JSONObject)localObject).optString("version");
            localItemVersion = new SCUpdatePB.ItemVersion();
            localItemVersion.bid.set(i2);
            localItemVersion.scid.set(paramString2);
            localItemVersion.version.set((String)localObject);
            localSCUpdateReq.req0x01.item_list.add(localItemVersion);
            i1 += 1;
          }
        }
        localSCUpdateReq.req0x01.setHasFlag(true);
      }
      else if ("GetUrlReq".equals(paramString1))
      {
        localSCUpdateReq.cmd.set(2);
        l1 = paramString2.optLong("delta_mode");
        l2 = paramString2.optLong("storage_mode");
        l3 = paramString2.optLong("compress_mode");
        paramString1 = paramString2.optString("from");
        localSCUpdateReq.comm.from.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
        localSCUpdateReq.req0x02.delta_mode.set((int)l1);
        localSCUpdateReq.req0x02.storage_mode.set((int)l2);
        localSCUpdateReq.req0x02.compress_mode.set((int)l3);
        paramString1 = paramString2.optJSONArray("item_list");
        if (paramString1 != null)
        {
          i1 = 0;
          while (i1 < paramString1.length())
          {
            localObject = paramString1.getJSONObject(i1);
            i2 = ((JSONObject)localObject).optInt("bid");
            paramString2 = ((JSONObject)localObject).optString("scid");
            localObject = ((JSONObject)localObject).optString("srcMd5");
            localItemVersion = new SCUpdatePB.ItemVersion();
            localItemVersion.bid.set(i2);
            localItemVersion.scid.set(paramString2);
            localItemVersion.version.set((String)localObject);
            localSCUpdateReq.req0x02.item_list.add(localItemVersion);
            i1 += 1;
          }
        }
        localSCUpdateReq.req0x02.setHasFlag(true);
      }
      localSCUpdateReq.setHasFlag(true);
      paramString1 = a("scupdate.handle", this.m.getApp(), localSCUpdateReq.toByteArray());
      this.m.startServlet(paramString1);
      return true;
    }
    catch (Throwable paramString1)
    {
      int i1;
      if (QLog.isColorLevel())
      {
        paramString1 = paramString1.getStackTrace();
        i1 = 0;
        while (i1 < paramString1.length)
        {
          QLog.e(i, 2, paramString1[i1].toString());
          i1 += 1;
        }
      }
    }
    return false;
  }
  
  public void c()
  {
    QLog.d(i, 1, "getCmGameConnInfo");
    try
    {
      if (this.m == null)
      {
        QLog.e(i, 1, "[getCmGameConnInfo] app null");
        return;
      }
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.8.17");
      CmGameMsgTunnel.AddrDistribueReq localAddrDistribueReq = new CmGameMsgTunnel.AddrDistribueReq();
      localAddrDistribueReq.appid.set(2);
      localAddrDistribueReq.net_type.set(CmGameUtil.h());
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(localAddrDistribueReq.toByteArray()));
      localObject = a("ltgame_addr_distribute.get_iplist", this.m.getApp(), localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("timeout", 15000L);
      this.m.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(i, 1, "[getCmGameConnInfo] exception=", localException);
    }
  }
  
  public void c(String paramString)
  {
    qqshop_code.SReq localSReq = new qqshop_code.SReq();
    localSReq.appid.set(100273020);
    localSReq.version.set(1);
    PBStringField localPBStringField = localSReq.redirect_uri;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    localPBStringField.set(str);
    paramString = a("SQQShopAuthCodeSvc.AuthCode", this.m.getApp(), localSReq.toByteArray());
    paramString.putExtra("timeout", 3000L);
    this.m.startServlet(paramString);
  }
  
  public void c(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_motto.get_user_motto");
      if (TextUtils.isEmpty(paramString2))
      {
        paramString2 = "android";
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("android.");
        localStringBuilder.append(paramString2);
        paramString2 = localStringBuilder.toString();
      }
      ((JSONObject)localObject).put("from", paramString2);
      paramString2 = new JSONArray();
      paramString2.put(Long.parseLong(paramString1));
      ((JSONObject)localObject).put("uins", paramString2);
      a(g("8.8.17"), (JSONObject)localObject, "apollo_motto.get_user_motto");
      if (QLog.isColorLevel())
      {
        paramString2 = i;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getUserSignStr uin: ");
        ((StringBuilder)localObject).append(paramString1);
        QLog.d(paramString2, 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(i, 2, "getUserSignStr failed ", paramString1);
      }
    }
  }
  
  public void d()
  {
    a(new String[] { this.m.getCurrentAccountUin() }, new int[] { 45033 });
  }
  
  public void d(String paramString)
  {
    Object localObject1 = this.m.getCurrentAccountUin();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("special_care_tip_show_");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = this.m.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      int i1 = ((SharedPreferences)localObject2).getInt((String)localObject1, 0);
      if (i1 == 0) {
        return;
      }
      ((SharedPreferences)localObject2).edit().remove((String)localObject1).commit();
      switch (i1)
      {
      default: 
        paramString = i;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showIfHadSpecialCareTip have error type ");
        ((StringBuilder)localObject1).append(i1);
        QLog.e(paramString, 1, ((StringBuilder)localObject1).toString());
        return;
      case 6: 
        localObject1 = this.m.getApp().getString(2131890163);
        break;
      case 5: 
        localObject1 = this.m.getApp().getString(2131890166);
        break;
      case 4: 
        localObject1 = this.m.getApp().getString(2131890164);
        break;
      case 3: 
        localObject1 = this.m.getApp().getString(2131890167);
        break;
      case 2: 
        localObject1 = this.m.getApp().getString(2131890168);
        break;
      case 1: 
        localObject1 = this.m.getApp().getString(2131890165);
      }
      paramString = new UniteGrayTipParam(paramString, paramString, (String)localObject1, 0, -5020, 2097156, MessageCache.c());
      Object localObject3 = new Bundle();
      localObject2 = HardCodeUtil.a(2131913252);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((Bundle)localObject3).putInt("key_action", 21);
        ((Bundle)localObject3).putString("key_action_DATA", Integer.toString(i1));
        int i2 = ((String)localObject1).lastIndexOf((String)localObject2);
        if (i2 >= 0) {
          paramString.a(i2, ((String)localObject2).length() + i2, (Bundle)localObject3);
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("showIfHadSpecialCareTip grayStr=");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("spanPos=");
          ((StringBuilder)localObject3).append(i2);
          ((StringBuilder)localObject3).append("iconName=");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.d("reactive", 2, ((StringBuilder)localObject3).toString());
        }
        VasWebviewUtil.a(this.m.getCurrentAccountUin(), "Care", "CareTipShow", "", 1, 0, 0, null, Integer.toString(i1), null);
      }
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).hasRead = 0;
      ((MessageForUniteGrayTip)localObject1).subType = 0;
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.m, paramString);
      UniteGrayTipMsgUtil.a(this.m, (MessageForUniteGrayTip)localObject1);
    }
  }
  
  public void e(String paramString)
  {
    Object localObject2 = this.m.getCurrentAccountUin();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("hot_friend_new_boat_graytip_sp");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("hot_friend_new_boat_graytip_sp");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append("_tips");
      localObject2 = ((StringBuilder)localObject3).toString();
      Object localObject4 = this.m.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      int i1 = ((SharedPreferences)localObject4).getInt((String)localObject1, 0);
      localObject3 = ((SharedPreferences)localObject4).getString((String)localObject2, "");
      if (i1 == 0) {
        return;
      }
      ((SharedPreferences)localObject4).edit().remove((String)localObject1).remove((String)localObject2).commit();
      if (i1 != 1)
      {
        paramString = i;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showIfHadNewBoatTips have error type ");
        ((StringBuilder)localObject1).append(i1);
        QLog.e(paramString, 1, ((StringBuilder)localObject1).toString());
        return;
      }
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        QLog.e(i, 1, "showIfHadNewBoatTips grayStr null ");
        return;
      }
      if (((String)localObject3).contains("gray_small_ship")) {
        localObject1 = ((String)localObject3).replace("gray_small_ship", " ");
      } else {
        localObject1 = localObject3;
      }
      localObject2 = localObject1;
      if (((String)localObject1).contains("gray_big_ship")) {
        localObject2 = ((String)localObject1).replace("gray_big_ship", " ");
      }
      paramString = new UniteGrayTipParam(paramString, paramString, (String)localObject2, 0, -5020, 2097156, MessageCache.c());
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject1 = MutualMarkConfigHelper.a(this.m, 12L, 1L);
        localObject3 = MutualMarkConfigHelper.a(this.m, 12L, 2L);
        i1 = ((String)localObject2).lastIndexOf((String)localObject1);
        int i2 = ((String)localObject2).lastIndexOf((String)localObject3);
        localObject2 = new Bundle();
        localObject4 = new Bundle();
        if (i1 >= 0)
        {
          ((Bundle)localObject2).putString("image_resource", "gray_small_ship");
          paramString.a(i1 - 1, i1, (Bundle)localObject2);
          ((Bundle)localObject4).putInt("key_action", 11);
          ((Bundle)localObject4).putString("key_action_DATA", (String)localObject1);
          paramString.a(i1, ((String)localObject1).length() + i1, (Bundle)localObject4);
        }
        if (i2 >= 0)
        {
          ((Bundle)localObject2).putString("image_resource", "gray_big_ship");
          paramString.a(i2 - 1, i2, (Bundle)localObject2);
          ((Bundle)localObject4).putInt("key_action", 11);
          ((Bundle)localObject4).putString("key_action_DATA", (String)localObject3);
          paramString.a(i2, ((String)localObject3).length() + i2, (Bundle)localObject4);
        }
      }
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).hasRead = 0;
      ((MessageForUniteGrayTip)localObject1).subType = 0;
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.m, paramString);
      UniteGrayTipMsgUtil.a(this.m, (MessageForUniteGrayTip)localObject1);
    }
  }
  
  public void f(String paramString)
  {
    Object localObject = paramString;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(i, 2, "content == null");
      }
      localObject = "";
    }
    paramString = new DiyEmotionPb.Filter_Req();
    paramString.cmd.set(1);
    DiyEmotionPb.Filter_Req_Comm localFilter_Req_Comm = new DiyEmotionPb.Filter_Req_Comm();
    localFilter_Req_Comm.platform.set(1L);
    localFilter_Req_Comm.mqqver.set("8.8.17");
    localFilter_Req_Comm.osver.set(Build.VERSION.RELEASE);
    DiyEmotionPb.Filter_Text_Req localFilter_Text_Req = new DiyEmotionPb.Filter_Text_Req();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localFilter_Text_Req.text.set(localArrayList);
    paramString.comm.set(localFilter_Req_Comm);
    paramString.reqcmd_0x01.set(localFilter_Text_Req);
    localObject = this.m;
    if (localObject != null)
    {
      paramString = a("gxzbpublic.filter", ((QQAppInterface)localObject).getApp(), paramString.toByteArray());
      paramString.putExtra("timeout", 30000L);
      j = SystemClock.uptimeMillis();
      this.m.startServlet(paramString);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return IApolloExtensionObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler
 * JD-Core Version:    0.7.0.1
 */