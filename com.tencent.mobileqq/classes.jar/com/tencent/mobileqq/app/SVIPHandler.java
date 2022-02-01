package com.tencent.mobileqq.app;

import ColorNick.QC.readItemInfoReq;
import ColorNick.QC.readItemInfoRsp;
import GROUP.MessageRemindReq;
import GROUP.MessageRemindRsp;
import MQQ.GetRoamToastReq;
import MQQ.GetRoamToastRsp;
import ProfileLogic.QC.readUserInfoReq;
import ProfileLogic.QC.readUserInfoRsp;
import ProfileLogic.QC.setUserFlagReq;
import ProfileLogic.QC.setUserFlagRsp;
import ProfileLogic.QC.setUserProfileReq;
import ProfileLogic.QC.setUserProfileRsp;
import QC.BubbleRecommendReq;
import QC.BubbleRecommendRsp;
import QC.BubbleReq;
import QC.FaceReq;
import QC.FaceRsp;
import QC.FontRecommendReq;
import QC.FontRecommendRsp;
import QC.FontReq;
import QC.GetUsrKeyWordInfoReq;
import QC.Hamlet;
import QC.LoginInfo;
import QC.SetFontBubbleReq;
import QC.SetFontBubbleRsp;
import QC.UniLoginCheckReq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleManager.LruLinkedHashMap;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TCheckReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TCheckRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontReq.TDiyFontReqInfo;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontRsp.TDiyFontRspInfo;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontFreshReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontFreshRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckReq.TMd5Info;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckRsp.TMd5Ret;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontSsoReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontSsoRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TGetPosterFontReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TGetPosterFontRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TSetPosterFontReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TSetPosterFontRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TTipsInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class SVIPHandler
  extends BusinessHandler
  implements ISVIPHandler
{
  private static int k;
  public BubbleManager a = null;
  private boolean b = false;
  private int c = 0;
  private QQAppInterface d;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  
  SVIPHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.d = paramQQAppInterface;
    this.a = ((BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER));
  }
  
  public static LoginInfo a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      String str = paramQQAppInterface.getCurrentAccountUin();
      paramQQAppInterface = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(str);
      LoginInfo localLoginInfo = new LoginInfo();
      localLoginInfo.lUin = Long.parseLong(str);
      localLoginInfo.iKeyType = 1;
      localLoginInfo.sSKey = paramQQAppInterface;
      localLoginInfo.iOpplat = 2;
      localLoginInfo.sClientVer = DeviceInfoUtil.e();
      return localLoginInfo;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("SVIPHandler", 1, "getLoginInfo fail", paramQQAppInterface);
    }
    return null;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (IFontManagerService)this.d.getRuntimeService(IFontManagerService.class, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetUserFont isSuccess = ");
      localStringBuilder.append(paramFromServiceMsg.isSuccess());
      localStringBuilder.append(" data = ");
      localStringBuilder.append(StructLongMessageDownloadProcessor.bytesToHexString((byte[])paramObject));
      QLog.d("SVIPHandler", 2, localStringBuilder.toString());
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = new VipFontUpdate.TFontSsoRsp();
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = (VipFontUpdate.TFontMd5CheckRsp)paramObject.st_md5_check_rsp.get();
        if ((paramFromServiceMsg.rpt_md5_ret.has()) && (paramFromServiceMsg.rpt_md5_ret.get().size() > 0))
        {
          paramFromServiceMsg = (VipFontUpdate.TFontMd5CheckRsp.TMd5Ret)paramFromServiceMsg.rpt_md5_ret.get().get(0);
          int m = paramFromServiceMsg.i32_check_ret.get();
          int n = paramFromServiceMsg.i32_check_font_id.get();
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleGetUserFont fontid = ");
            paramFromServiceMsg.append(n);
            paramFromServiceMsg.append(" md5ret = ");
            paramFromServiceMsg.append(m);
            QLog.d("SVIPHandler", 2, paramFromServiceMsg.toString());
          }
          if ((n == b()) && (m > 0)) {
            paramToServiceMsg.reDownloadFont(n, this.i);
          }
        }
        paramFromServiceMsg = (VipFontUpdate.TFontFreshRsp)paramObject.st_fresh_rsp.get();
        if (!paramFromServiceMsg.i32_font_type.has()) {
          break label430;
        }
        VasShieldFont.b = paramFromServiceMsg.i32_font_type.get();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetFontShieldType type= ");
          paramFromServiceMsg.append(VasShieldFont.b);
          QLog.d("VasShieldFont", 2, paramFromServiceMsg.toString());
        }
        VasShieldFont.c = this.d.getCurrentUin();
        VasShieldFont.a(this.d);
      }
      catch (Exception paramFromServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("handleGetUserFont error: ");
        paramObject.append(paramFromServiceMsg.getMessage());
        QLog.e("SVIPHandler", 1, paramObject.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("handleGetUserFont response not success message = ");
      paramObject.append(paramFromServiceMsg.getResultCode());
      QLog.e("SVIPHandler", 2, paramObject.toString());
    }
    label430:
    paramToServiceMsg.setHasCheckMd5(true);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new VipFontUpdate.TFontSsoRsp();
      try
      {
        paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = (VipFontUpdate.TDiyFontRsp)paramToServiceMsg.st_diyfont_rsp.get();
        ArrayList localArrayList = new ArrayList();
        FriendsManager localFriendsManager = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Iterator localIterator = paramToServiceMsg.rpt_font_rsp_info.get().iterator();
        while (localIterator.hasNext())
        {
          VipFontUpdate.TDiyFontRsp.TDiyFontRspInfo localTDiyFontRspInfo = (VipFontUpdate.TDiyFontRsp.TDiyFontRspInfo)localIterator.next();
          String str = String.valueOf(localTDiyFontRspInfo.u64_uin.get());
          paramObject = localTDiyFontRspInfo.str_diy_font_config.get();
          paramToServiceMsg = paramObject;
          if (paramObject == null) {
            paramToServiceMsg = "";
          }
          int m = localTDiyFontRspInfo.i32_font_id.get();
          if (QLog.isColorLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append("handleGetDiyFontConfig uin = ");
            paramObject.append(str);
            paramObject.append(" fontId = ");
            paramObject.append(m);
            paramObject.append(" config = ");
            paramObject.append(paramToServiceMsg);
            paramObject.append(" seq = ");
            paramObject.append(paramFromServiceMsg.getRequestSsoSeq());
            QLog.d("FontManagerConstants", 2, paramObject.toString());
          }
          paramObject = localFriendsManager.x(str);
          if (paramObject.diyFontConfigMap == null) {
            paramObject.diyFontConfigMap = new ConcurrentHashMap();
          }
          if ((!paramObject.diyFontConfigMap.containsKey(Integer.valueOf(m))) || (!paramToServiceMsg.equals(paramObject.diyFontConfigMap.get(Integer.valueOf(m)))))
          {
            paramObject.diyFontConfigMap.put(Integer.valueOf(m), paramToServiceMsg);
            ((IFontManagerService)this.d.getRuntimeService(IFontManagerService.class, "")).updateDiyConfig(str, m);
            localArrayList.add(paramObject);
          }
        }
        if (localArrayList.size() > 0)
        {
          localFriendsManager.b(localArrayList);
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("FontManagerConstants", 2, "handleGetDiyFontConfig return empty");
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetDiyFontConfig error: + ");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.e("FontManagerConstants", 1, paramFromServiceMsg.toString());
        return;
      }
    }
    else
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetDiyFontConfig not success errorcode = ");
      paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
      paramToServiceMsg.append(" seq = ");
      paramToServiceMsg.append(paramFromServiceMsg.getRequestSsoSeq());
      QLog.e("FontManagerConstants", 1, paramToServiceMsg.toString());
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int m = paramToServiceMsg.extraData.getInt("hiboom_auth_type");
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = new VipFontUpdate.TFontSsoRsp();
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if (paramObject.i32_ret.get() != 0)
        {
          notifyUI(102, false, Integer.valueOf(m));
          return;
        }
        paramFromServiceMsg = (VipFontUpdate.TCheckRsp)paramObject.st_check_rsp.get();
        if (paramFromServiceMsg != null)
        {
          notifyUI(102, true, new Object[] { Integer.valueOf(paramFromServiceMsg.i32_ret.get()), ((VipFontUpdate.TTipsInfo)paramFromServiceMsg.st_tips_info.get()).toByteArray(), Integer.valueOf(paramToServiceMsg.extraData.getInt("hiboom_id")), paramToServiceMsg.extraData.getString("hiboom_text"), Integer.valueOf(m) });
          return;
        }
        QLog.e("SVIPHandler", 1, "handleAuthHiBoom fail authRsp is null");
        notifyUI(102, false, Integer.valueOf(m));
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleAuthHiBoom error: ");
        paramFromServiceMsg.append(paramToServiceMsg.getLocalizedMessage());
        paramFromServiceMsg.append(Log.getStackTraceString(paramToServiceMsg));
        QLog.e("SVIPHandler", 1, paramFromServiceMsg.toString());
        notifyUI(102, false, Integer.valueOf(m));
        return;
      }
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleAuthHiBoom fail isSuccess = ");
    paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
    paramToServiceMsg.append(" data is null : ");
    boolean bool;
    if (paramObject == null) {
      bool = true;
    } else {
      bool = false;
    }
    paramToServiceMsg.append(bool);
    QLog.e("SVIPHandler", 1, paramToServiceMsg.toString());
    notifyUI(102, false, Integer.valueOf(m));
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new VipFontUpdate.TFontSsoRsp();
      try
      {
        paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = ((IVasService)this.d.getRuntimeService(IVasService.class, "")).getHiBoomManager();
        if (paramToServiceMsg.i32_ret.get() != 0)
        {
          paramObject = new StringBuilder();
          paramObject.append("handleGetHiBoomList fail ret = ");
          paramObject.append(paramToServiceMsg.i32_ret.get());
          QLog.e("HiBoomFont", 1, paramObject.toString());
          paramFromServiceMsg.getHiBoomListFromLocal();
          return;
        }
        paramToServiceMsg = (VipFontUpdate.TGetPosterFontRsp)paramToServiceMsg.st_getposterfont_rsp.get();
        if (paramToServiceMsg != null)
        {
          paramFromServiceMsg.parseHiBoomList(paramToServiceMsg, true);
          return;
        }
        QLog.e("HiBoomFont", 1, "handleGetHiBoomList st_getposterfont_rsp is null");
        paramFromServiceMsg.getHiBoomListFromLocal();
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetHiBoomList error: ");
        paramFromServiceMsg.append(Log.getStackTraceString(paramToServiceMsg));
        QLog.e("HiBoomFont", 1, paramFromServiceMsg.toString());
        return;
      }
    }
    QLog.e("HiBoomFont", 1, "handleGetHiBoomList fail");
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("hiboom_auth_is_send", false);
    String str = paramToServiceMsg.extraData.getString("hiboom_text", "");
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = new VipFontUpdate.TFontSsoRsp();
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if (paramObject.i32_ret.get() != 0)
        {
          notifyUI(103, false, null);
          return;
        }
        paramFromServiceMsg = (VipFontUpdate.TSetPosterFontRsp)paramObject.st_setposterfont_rsp.get();
        if (paramFromServiceMsg == null)
        {
          notifyUI(103, false, Boolean.valueOf(bool));
          return;
        }
        int m = paramToServiceMsg.extraData.getInt("hiboom_id");
        notifyUI(103, true, new Object[] { Integer.valueOf(paramFromServiceMsg.i32_ret.get()), Integer.valueOf(m), ((VipFontUpdate.TTipsInfo)paramFromServiceMsg.st_tips_info.get()).toByteArray(), Boolean.valueOf(bool), str });
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleSetHiBoom error:");
        paramFromServiceMsg.append(Log.getStackTraceString(paramToServiceMsg));
        QLog.e("HiBoomFont", 1, paramFromServiceMsg.toString());
        notifyUI(103, false, Boolean.valueOf(bool));
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleRequestColorNickPanel resp = ");
      paramToServiceMsg.append(paramFromServiceMsg.toString());
      QLog.d("SVIPHandler", 2, paramToServiceMsg.toString());
    }
    if ((paramObject instanceof readItemInfoRsp))
    {
      notifyUI(105, true, (readItemInfoRsp)paramObject);
      return;
    }
    notifyUI(105, false, null);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if ((paramObject instanceof MessageRemindRsp))
      {
        notifyUI(113, true, paramObject);
        return;
      }
      notifyUI(113, false, null);
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleGetBigTroopExpiredInfo resp failed:");
    paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
    QLog.e("vip_pretty.SVIPHandler", 1, paramToServiceMsg.toString());
    notifyUI(113, false, null);
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof FontRecommendRsp))
    {
      notifyUI(107, true, paramObject);
      return;
    }
    notifyUI(107, false, null);
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof BubbleRecommendRsp))
    {
      notifyUI(108, true, paramObject);
      return;
    }
    notifyUI(108, false, null);
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int m = paramToServiceMsg.extraData.getInt("setFontBubbleSeq");
    if ((paramObject instanceof SetFontBubbleRsp))
    {
      notifyUI(109, true, new Object[] { paramObject, Integer.valueOf(m) });
      return;
    }
    notifyUI(109, false, new Object[] { null, Integer.valueOf(m) });
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof GetRoamToastRsp))
    {
      notifyUI(111, true, paramObject);
      return;
    }
    notifyUI(111, false, paramObject);
  }
  
  private LoginInfo n()
  {
    return a(this.d);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof FaceRsp))
    {
      notifyUI(112, true, paramObject);
      return;
    }
    notifyUI(112, false, paramObject);
  }
  
  private int o()
  {
    if (OSUtils.isMIUI()) {
      return 1;
    }
    if (OSUtils.isEMUI()) {
      return 2;
    }
    if (OSUtils.isFlymeOS()) {
      return 5;
    }
    if (!TextUtils.isEmpty(SystemUtil.a("ro.build.version.opporom"))) {
      return 3;
    }
    if (!TextUtils.isEmpty(SystemUtil.a("ro.vivo.os.version"))) {
      return 4;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    int m = this.d.getApp().getSharedPreferences(paramString, 0).getInt("svip_colorScreen_id", 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getColorScreenId ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" id ");
      localStringBuilder.append(m);
      QLog.d("SVIPHandler", 2, localStringBuilder.toString());
    }
    return m;
  }
  
  public void a()
  {
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(1);
    Object localObject1 = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject1).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("8.8.17.5770");
    Object localObject3 = new VipFontUpdate.TFontFreshReq();
    ((VipFontUpdate.TFontFreshReq)localObject3).i32_local_font_id.set(b());
    ((VipFontUpdate.TFontFreshReq)localObject3).i32_cpu_freq.set((int)DeviceInfoUtil.l());
    ((VipFontUpdate.TFontFreshReq)localObject3).i32_cpu_num.set(DeviceInfoUtil.h());
    ((VipFontUpdate.TFontFreshReq)localObject3).i32_total_mem.set((int)(DeviceInfoUtil.a() / 1048576L));
    Object localObject2 = Build.BRAND.toUpperCase();
    localObject1 = localObject2;
    if (((String)localObject2).equals("HONOR")) {
      localObject1 = "HUAWEI";
    }
    ((VipFontUpdate.TFontFreshReq)localObject3).str_brand.set((String)localObject1);
    ((VipFontUpdate.TFontFreshReq)localObject3).str_model.set(Build.MODEL.toUpperCase());
    ((VipFontUpdate.TFontFreshReq)localObject3).i32_os_type.set(o());
    ((VipFontUpdate.TFontFreshReq)localObject3).i32_version.set(Build.VERSION.SDK_INT);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((VipFontUpdate.TFontFreshReq)localObject3).i32_cpu_freq.get());
      ((StringBuilder)localObject1).append(" | ");
      ((StringBuilder)localObject1).append(((VipFontUpdate.TFontFreshReq)localObject3).i32_cpu_num.get());
      ((StringBuilder)localObject1).append(" | ");
      ((StringBuilder)localObject1).append(((VipFontUpdate.TFontFreshReq)localObject3).i32_total_mem.get());
      ((StringBuilder)localObject1).append(" | ");
      ((StringBuilder)localObject1).append(((VipFontUpdate.TFontFreshReq)localObject3).str_brand.get());
      ((StringBuilder)localObject1).append(" | ");
      ((StringBuilder)localObject1).append(((VipFontUpdate.TFontFreshReq)localObject3).str_model.get());
      ((StringBuilder)localObject1).append(" | ");
      ((StringBuilder)localObject1).append(((VipFontUpdate.TFontFreshReq)localObject3).i32_os_type.get());
      ((StringBuilder)localObject1).append(" | ");
      ((StringBuilder)localObject1).append(((VipFontUpdate.TFontFreshReq)localObject3).i32_version.get());
      QLog.d("VasShieldFont", 2, ((StringBuilder)localObject1).toString());
    }
    localTFontSsoReq.st_fresh_req.set((MessageMicro)localObject3);
    VasShieldFont.a();
    VasShieldFont.e = b();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pbGetUserFont: ");
      ((StringBuilder)localObject1).append(VasShieldFont.e);
      QLog.d("VasShieldFont", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new VipFontUpdate.TFontMd5CheckReq();
    localObject2 = new VipFontUpdate.TFontMd5CheckReq.TMd5Info();
    ((VipFontUpdate.TFontMd5CheckReq.TMd5Info)localObject2).i32_font_id.set(b());
    localObject3 = ((IFontManagerService)this.d.getRuntimeService(IFontManagerService.class, "")).findFontInfo(b(), this.i);
    if (localObject3 != null)
    {
      Object localObject4 = new File(((FontInfo)localObject3).b);
      if ((((File)localObject4).exists()) && (((File)localObject4).isFile()))
      {
        try
        {
          localObject3 = new FileInputStream((File)localObject4);
          localObject4 = MD5.toMD5Byte((InputStream)localObject3, ((File)localObject4).length());
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("fontFile MD5 = ");
            localStringBuilder2.append(StructLongMessageDownloadProcessor.bytesToHexString((byte[])localObject4));
            QLog.d("SVIPHandler", 2, localStringBuilder2.toString());
          }
          ((VipFontUpdate.TFontMd5CheckReq.TMd5Info)localObject2).bytes_md5.set(ByteStringMicro.copyFrom((byte[])localObject4));
          ((FileInputStream)localObject3).close();
        }
        catch (Exception localException)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("pbGetUserFont error");
          ((StringBuilder)localObject4).append(localException.getMessage());
          QLog.e("SVIPHandler", 1, ((StringBuilder)localObject4).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("fontFile exists = ");
        localStringBuilder1.append(((File)localObject4).exists());
        localStringBuilder1.append(" ,isFile = ");
        localStringBuilder1.append(((File)localObject4).isFile());
        QLog.e("SVIPHandler", 2, localStringBuilder1.toString());
      }
    }
    ((VipFontUpdate.TFontMd5CheckReq)localObject1).rpt_md5_info.add((MessageMicro)localObject2);
    localTFontSsoReq.st_md5_check_req.set((MessageMicro)localObject1);
    localObject1 = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "Font.fresh");
    ((ToServiceMsg)localObject1).putWupBuffer(localTFontSsoReq.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("CMD", 1);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (paramInt != this.e)
      {
        this.e = paramInt;
        this.d.getApp().getSharedPreferences(this.d.getCurrentAccountUin(), 0).edit().putInt("svip_bubble_id", paramInt).commit();
      }
      this.b = false;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setSelfFontInfo id = ");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" type = ");
        ((StringBuilder)localObject1).append(paramInt2);
        QLog.d("SVIPHandler", 2, ((StringBuilder)localObject1).toString());
      }
      if ((paramInt1 != this.h) || (paramInt2 != this.i))
      {
        FriendsManager localFriendsManager = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
        ExtensionInfo localExtensionInfo = localFriendsManager.x(this.d.getAccount());
        localObject1 = localExtensionInfo;
        if (localExtensionInfo == null)
        {
          localObject1 = new ExtensionInfo();
          ((ExtensionInfo)localObject1).uin = this.d.getAccount();
        }
        ((ExtensionInfo)localObject1).uVipFont = paramInt1;
        ((ExtensionInfo)localObject1).vipFontType = paramInt2;
        this.h = paramInt1;
        this.i = paramInt2;
        localFriendsManager.a((ExtensionInfo)localObject1);
      }
      if (VasShieldFont.e != paramInt1)
      {
        VasShieldFont.e = paramInt1;
        localObject1 = this.d.getHandler(ChatActivity.class);
        if (localObject1 != null)
        {
          ((MqqHandler)localObject1).removeMessages(87);
          ((MqqHandler)localObject1).sendEmptyMessage(87);
        }
      }
      this.b = false;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    SetFontBubbleReq localSetFontBubbleReq = new SetFontBubbleReq();
    localSetFontBubbleReq.stLogin = n();
    if (localSetFontBubbleReq.stLogin == null) {
      return;
    }
    localSetFontBubbleReq.stFontReq = new FontReq(paramInt1);
    localSetFontBubbleReq.stBubbleReq = new BubbleReq(paramInt2);
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "FontBubbleRecommend.setFontBubble");
    localToServiceMsg.extraData.putInt("setFontBubbleSeq", paramInt3);
    localToServiceMsg.extraData.putSerializable("req", localSetFontBubbleReq);
    this.d.sendToService(localToServiceMsg);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(2);
    Object localObject = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("8.8.17.5770");
    localObject = new VipFontUpdate.TCheckReq();
    ((VipFontUpdate.TCheckReq)localObject).i32_font_id.set(paramInt1);
    ((VipFontUpdate.TCheckReq)localObject).i32_type.set(paramInt2);
    ((VipFontUpdate.TCheckReq)localObject).str_message_test.set(paramString);
    localTFontSsoReq.st_check_req.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "Font.fresh");
    int m = NetworkState.getNetworkType();
    if (m != 1)
    {
      if ((m != 4) && (m != 5)) {
        ((ToServiceMsg)localObject).setTimeout(5000L);
      } else {
        ((ToServiceMsg)localObject).setTimeout(10000L);
      }
    }
    else {
      ((ToServiceMsg)localObject).setTimeout(5000L);
    }
    ((ToServiceMsg)localObject).putWupBuffer(localTFontSsoReq.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("CMD", 2);
    ((ToServiceMsg)localObject).extraData.putInt("hiboom_id", paramInt1);
    ((ToServiceMsg)localObject).extraData.putString("hiboom_text", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("hiboom_auth_type", paramInt2);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      if ((paramInt != this.f) && (this.d != null))
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("setSelfBubbleDiyTextId->");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.d("SVIPHandler", 2, ((StringBuilder)localObject1).toString());
        }
        this.f = paramInt;
        this.d.getApp().getSharedPreferences(this.d.getCurrentAccountUin(), 0).edit().putInt("svip_bubble_diy_text_id", paramInt).commit();
        if (paramInt > 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.d.getAccount());
          ((StringBuilder)localObject1).append("_");
          ((StringBuilder)localObject1).append(paramInt);
          localObject1 = ((StringBuilder)localObject1).toString();
          if (paramBoolean) {
            ThreadManager.post(new SVIPHandler.1(this, (String)localObject1), 5, null, false);
          } else {
            BubbleDiyFetcher.a().a(this.d, (String)localObject1, null);
          }
        }
      }
      this.b = false;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setHiboom id = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("HiBoomFont", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new VipFontUpdate.TFontSsoReq();
    ((VipFontUpdate.TFontSsoReq)localObject1).u32_cmd.set(5);
    Object localObject2 = new Random();
    ((VipFontUpdate.TFontSsoReq)localObject1).u64_seq.set(((Random)localObject2).nextInt(1000));
    ((VipFontUpdate.TFontSsoReq)localObject1).i32_implat.set(109);
    ((VipFontUpdate.TFontSsoReq)localObject1).str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    ((VipFontUpdate.TFontSsoReq)localObject1).str_mqqver.set("8.8.17.5770");
    localObject2 = new VipFontUpdate.TSetPosterFontReq();
    ((VipFontUpdate.TSetPosterFontReq)localObject2).i32_font_id.set(paramInt);
    ((VipFontUpdate.TFontSsoReq)localObject1).st_setposterfont_req.set((MessageMicro)localObject2);
    localObject2 = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "Font.fresh");
    ((ToServiceMsg)localObject2).putWupBuffer(((VipFontUpdate.TFontSsoReq)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putInt("CMD", 5);
    ((ToServiceMsg)localObject2).extraData.putInt("hiboom_id", paramInt);
    ((ToServiceMsg)localObject2).extraData.putBoolean("hiboom_auth_is_send", paramBoolean);
    ((ToServiceMsg)localObject2).extraData.putString("hiboom_text", paramString);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = new MessageRemindReq();
    ((MessageRemindReq)localObject1).iGroupCode = paramLong;
    Object localObject2 = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    localObject2 = ((TroopManager)localObject2).f(localStringBuilder.toString());
    if (localObject2 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getBigTroopExpiredInfo troopInfo == null, troopUin: ");
        ((StringBuilder)localObject1).append(paramLong);
        QLog.e("SVIPHandler", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    ((MessageRemindReq)localObject1).uOwnerUin = Long.parseLong(((TroopInfo)localObject2).troopowneruin);
    ((MessageRemindReq)localObject1).dwAppId = AppSetting.d();
    ((MessageRemindReq)localObject1).sKey = ((TicketManager)this.d.getManager(2)).getSkey(this.d.getAccount());
    if (((MessageRemindReq)localObject1).sKey != null)
    {
      localObject2 = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "GroupCare.getMessageRemindInfo");
      ((ToServiceMsg)localObject2).extraData.putSerializable("req", (Serializable)localObject1);
      this.d.sendToService((ToServiceMsg)localObject2);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getBigTroopExpiredInfo skey == null, troopUin: ");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.e("SVIPHandler", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(GetRoamToastRsp paramGetRoamToastRsp)
  {
    Object localObject = this.d.getCurrentAccountUin();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("SVIPHandler", 1, "closeToast null uin");
      return;
    }
    localObject = this.d.getApp().getSharedPreferences((String)localObject, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("roam_toast_close_");
    localStringBuilder.append(paramGetRoamToastRsp.sToastKey);
    paramGetRoamToastRsp = localStringBuilder.toString();
    int m = ((SharedPreferences)localObject).getInt(paramGetRoamToastRsp, 0);
    localObject = ((SharedPreferences)localObject).edit();
    m += 1;
    ((SharedPreferences.Editor)localObject).putInt(paramGetRoamToastRsp, m).commit();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("closeToast: ");
      ((StringBuilder)localObject).append(paramGetRoamToastRsp);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(m);
      QLog.d("SVIPHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    paramBusinessObserver = createToServiceMsg("QCUniBusinessLogin.check", paramBusinessObserver, paramBoolean);
    UniLoginCheckReq localUniLoginCheckReq = new UniLoginCheckReq(n(), new ArrayList(), 2L, new GetUsrKeyWordInfoReq());
    paramBusinessObserver.extraData.putSerializable("req", localUniLoginCheckReq);
    this.d.sendToService(paramBusinessObserver);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      if (!paramMessageRecord.needVipBubble()) {
        return;
      }
      if ((AnonymousChatHelper.c(paramMessageRecord)) && (AnonymousChatHelper.f(paramMessageRecord))) {
        return;
      }
      if ((paramMessageRecord.istroop != 1001) && (paramMessageRecord.istroop != 10002))
      {
        if (g() > 0)
        {
          paramMessageRecord.vipBubbleID = SVIPHandlerConstants.a(d(), g());
          paramMessageRecord.vipBubbleDiyTextId = g();
        }
        else
        {
          paramMessageRecord.vipBubbleID = d();
        }
        if ((paramMessageRecord instanceof MessageForPtt))
        {
          int m = h();
          if (m > 0) {
            paramMessageRecord.vipBubbleID = m;
          }
        }
        paramMessageRecord.vipSubBubbleId = e();
        if (paramMessageRecord.vipSubBubbleId != 0)
        {
          paramMessageRecord.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(paramMessageRecord.vipSubBubbleId));
          i();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("addSendingBubbleId: changeSubBubbleId, messageRecord: ");
            localStringBuilder.append(paramMessageRecord.getClass().getSimpleName());
            QLog.i("SVIPHandler", 2, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleFriendClone: resp=");
      paramToServiceMsg.append(paramFromServiceMsg.toString());
      QLog.d("SVIPHandler", 2, paramToServiceMsg.toString());
    }
    if (((paramObject instanceof ArrayList)) && (((Integer)((ArrayList)paramObject).get(0)).intValue() == 0))
    {
      notifyUI(104, true, paramObject);
      return;
    }
    notifyUI(104, false, null);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = this.d.getApp().getSharedPreferences(paramString, 0);
    ((SharedPreferences)localObject).getInt("svip_colorScreen_id", 0);
    ((SharedPreferences)localObject).edit().putInt("svip_colorScreen_id", paramInt).commit();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setColorScreenId ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" id ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SVIPHandler", 2, ((StringBuilder)localObject).toString());
    }
    this.b = false;
  }
  
  public void a(ArrayList<Hamlet> paramArrayList, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    paramBusinessObserver = createToServiceMsg("QCUniBusinessLogin.check", paramBusinessObserver, paramBoolean);
    paramArrayList = new UniLoginCheckReq(n(), paramArrayList, 3L, new GetUsrKeyWordInfoReq());
    paramBusinessObserver.extraData.putSerializable("req", paramArrayList);
    this.d.sendToService(paramBusinessObserver);
  }
  
  public void a(Map<String, Integer> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManagerConstants", 2, "pbGetDiyFontConfig");
    }
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(3);
    Object localObject = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("8.8.17.5770");
    localObject = new VipFontUpdate.TDiyFontReq();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      VipFontUpdate.TDiyFontReq.TDiyFontReqInfo localTDiyFontReqInfo = new VipFontUpdate.TDiyFontReq.TDiyFontReqInfo();
      localTDiyFontReqInfo.u64_uin.set(Long.parseLong(str));
      localTDiyFontReqInfo.i32_font_id.set(((Integer)paramMap.get(str)).intValue());
      ((VipFontUpdate.TDiyFontReq)localObject).rpt_font_req_info.add(localTDiyFontReqInfo);
    }
    localTFontSsoReq.st_diyfont_req.set((MessageMicro)localObject);
    paramMap = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "Font.fresh");
    paramMap.putWupBuffer(localTFontSsoReq.toByteArray());
    paramMap.extraData.putInt("CMD", 3);
    sendPbReq(paramMap);
  }
  
  public int b()
  {
    try
    {
      if (this.h == -1)
      {
        ExtensionInfo localExtensionInfo = ((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(this.d.getAccount());
        if (localExtensionInfo == null) {
          return 0;
        }
        this.h = ((int)localExtensionInfo.uVipFont);
        this.i = localExtensionInfo.vipFontType;
      }
      int m = this.h;
      return m;
    }
    finally {}
  }
  
  public int b(MessageRecord paramMessageRecord)
  {
    int n = SVIPHandlerConstants.a(paramMessageRecord.vipBubbleID);
    if (n == 0) {
      return 0;
    }
    int m;
    if (paramMessageRecord.vipSubBubbleId != 0)
    {
      m = paramMessageRecord.vipSubBubbleId;
    }
    else
    {
      String str = paramMessageRecord.getExtInfoFromExtStr("bubble_sub_id");
      if (QLog.isColorLevel()) {
        QLog.i("SVIPHandler", 2, String.format("try get bubbleSubId from msg id %d : %s", new Object[] { Long.valueOf(paramMessageRecord.uniseq), str }));
      }
      if (!TextUtils.isEmpty(str)) {
        m = Integer.parseInt(str);
      } else {
        m = 0;
      }
    }
    if ((m != 0) && (b(n, m)))
    {
      paramMessageRecord.vipSubBubbleId = m;
      return m;
    }
    paramMessageRecord.vipSubBubbleId = 0;
    return n;
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (paramInt != this.g)
      {
        this.g = paramInt;
        this.d.getApp().getSharedPreferences(this.d.getCurrentAccountUin(), 0).edit().putInt("svip_bubble_voice_print_id", paramInt).commit();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    try
    {
      if ((paramInt != this.j) && (this.d != null))
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("setSelfPendantDiyId->");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.d("SVIPHandler", 2, ((StringBuilder)localObject1).toString());
        }
        this.j = paramInt;
        if (paramInt > 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.d.getAccount());
          ((StringBuilder)localObject1).append("_");
          ((StringBuilder)localObject1).append(paramInt);
          localObject1 = ((StringBuilder)localObject1).toString();
          if (paramBoolean) {
            ThreadManager.post(new SVIPHandler.2(this, (String)localObject1), 5, null, false);
          } else {
            DiyPendantFetcher.a().a(this.d, (String)localObject1, null);
          }
        }
      }
      this.b = false;
      return;
    }
    finally {}
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleRequestDefaultCard: resp=");
      paramToServiceMsg.append(paramFromServiceMsg.toString());
      QLog.d("SVIPHandler", 2, paramToServiceMsg.toString());
    }
    if ((!(paramObject instanceof readUserInfoRsp)) && (!(paramObject instanceof setUserProfileRsp)) && (!(paramObject instanceof setUserFlagRsp)))
    {
      notifyUI(106, false, paramFromServiceMsg.getServiceCmd());
      return;
    }
    notifyUI(106, true, paramObject);
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    Object localObject = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((BubbleManager)localObject).g != null)
      {
        localObject = (BubbleConfig)this.a.g.get(Integer.valueOf(paramInt1));
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((BubbleConfig)localObject).c())
          {
            bool1 = bool2;
            if (((BubbleConfig)localObject).a(paramInt2)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean b(GetRoamToastRsp paramGetRoamToastRsp)
  {
    Object localObject = this.d.getCurrentAccountUin();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("SVIPHandler", 1, "shouldShowToast null uin");
      return false;
    }
    localObject = this.d.getApp().getSharedPreferences((String)localObject, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("roam_toast_close_");
    localStringBuilder.append(paramGetRoamToastRsp.sToastKey);
    paramGetRoamToastRsp = localStringBuilder.toString();
    int m = ((SharedPreferences)localObject).getInt(paramGetRoamToastRsp, 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shouldShowToast: ");
      ((StringBuilder)localObject).append(paramGetRoamToastRsp);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(m);
      QLog.d("SVIPHandler", 2, ((StringBuilder)localObject).toString());
    }
    return m < 2;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont", 2, "getHiBoomList");
    }
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(4);
    Object localObject = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("8.8.17.5770");
    localObject = new VipFontUpdate.TGetPosterFontReq();
    ((VipFontUpdate.TGetPosterFontReq)localObject).isgetrecommend.set(1);
    localTFontSsoReq.st_getposterfont_req.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "Font.fresh");
    ((ToServiceMsg)localObject).putWupBuffer(localTFontSsoReq.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("CMD", 4);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void c(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setMagicFont setup = ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("SVIPHandler", 2, ((StringBuilder)localObject1).toString());
      }
      FriendsManager localFriendsManager = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
      ExtensionInfo localExtensionInfo = localFriendsManager.x(this.d.getAccount());
      Object localObject1 = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = this.d.getAccount();
      }
      if (((ExtensionInfo)localObject1).magicFont != paramInt)
      {
        ((ExtensionInfo)localObject1).magicFont = paramInt;
        if (1 == paramInt) {
          ((ExtensionInfo)localObject1).fontEffect = 0;
        }
      }
      localFriendsManager.a((ExtensionInfo)localObject1);
      this.b = false;
      return;
    }
    finally {}
  }
  
  public ToServiceMsg createToServiceMsg(String paramString, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    return super.createToServiceMsg(paramString, paramBusinessObserver, paramBoolean);
  }
  
  public int d()
  {
    try
    {
      if (this.e == -1) {
        this.e = this.d.getApp().getSharedPreferences(this.d.getCurrentAccountUin(), 0).getInt("svip_bubble_id", 0);
      }
      int m = SVIPHandlerConstants.a(this.e);
      return m;
    }
    finally {}
  }
  
  public void d(int paramInt)
  {
    label202:
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("setFontEffect fontEffectId = ");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.d("SVIPHandler", 2, ((StringBuilder)localObject1).toString());
        }
        FriendsManager localFriendsManager = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Object localObject1 = localFriendsManager.x(this.d.getAccount());
        int n = 1;
        if (localObject1 == null)
        {
          localObject1 = new ExtensionInfo();
          ((ExtensionInfo)localObject1).uin = this.d.getAccount();
          ((ExtensionInfo)localObject1).fontEffect = -1;
          m = 1;
          if (((ExtensionInfo)localObject1).fontEffect == paramInt) {
            break label202;
          }
          ((ExtensionInfo)localObject1).fontEffect = paramInt;
          ((ExtensionInfo)localObject1).fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
          ((IFontManagerService)this.d.getRuntimeService(IFontManagerService.class, "")).resetLastSendReportTime();
          m = n;
          if (paramInt != 0)
          {
            ((ExtensionInfo)localObject1).magicFont = 0;
            m = n;
          }
          if (m != 0) {
            localFriendsManager.a((ExtensionInfo)localObject1);
          }
          this.b = false;
          return;
        }
      }
      finally {}
      int m = 0;
    }
  }
  
  public int e()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((BubbleManager)localObject).g != null))
    {
      localObject = (BubbleConfig)this.a.g.get(Integer.valueOf(d()));
      if ((localObject != null) && (((BubbleConfig)localObject).c()))
      {
        int m = ((BubbleConfig)localObject).a();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("main bubbleid: ");
          ((StringBuilder)localObject).append(this.e);
          ((StringBuilder)localObject).append(", subBubbleId: ");
          ((StringBuilder)localObject).append(m);
          QLog.i("SVIPHandler", 2, ((StringBuilder)localObject).toString());
        }
        return m;
      }
    }
    return 0;
  }
  
  public void e(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "groupnick.readitem");
    readItemInfoReq localreadItemInfoReq = new readItemInfoReq(109L, DeviceInfoUtil.e(), paramInt);
    localToServiceMsg.extraData.putSerializable("req", localreadItemInfoReq);
    this.d.sendToService(localToServiceMsg);
  }
  
  public int f()
  {
    try
    {
      String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.MsgLengthByBubble.name(), "0");
      int n = 0;
      int m;
      try
      {
        m = Integer.parseInt(str);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        m = n;
        if (QLog.isColorLevel())
        {
          QLog.e("SVIPHandler", 2, localNumberFormatException.getMessage());
          m = n;
        }
      }
      return m;
    }
    finally {}
  }
  
  public void f(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "profilelogic.readUserInfo");
    readUserInfoReq localreadUserInfoReq = new readUserInfoReq(DeviceInfoUtil.e(), 109, paramInt);
    localToServiceMsg.extraData.putSerializable("req", localreadUserInfoReq);
    this.d.sendToService(localToServiceMsg);
  }
  
  public int g()
  {
    try
    {
      if (this.f == -1) {
        this.f = this.d.getApp().getSharedPreferences(this.d.getCurrentAccountUin(), 0).getInt("svip_bubble_diy_text_id", 0);
      }
      int m = this.f;
      return m;
    }
    finally {}
  }
  
  public void g(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "profilelogic.setUserProfile");
    setUserProfileReq localsetUserProfileReq = new setUserProfileReq(paramInt, DeviceInfoUtil.e(), 109);
    localToServiceMsg.extraData.putSerializable("req", localsetUserProfileReq);
    this.d.sendToService(localToServiceMsg);
  }
  
  public int h()
  {
    try
    {
      if (this.g == -1) {
        this.g = this.d.getApp().getSharedPreferences(this.d.getCurrentAccountUin(), 0).getInt("svip_bubble_voice_print_id", 0);
      }
      int m = this.g;
      return m;
    }
    finally {}
  }
  
  public void h(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "profilelogic.setUserFlag");
    setUserFlagReq localsetUserFlagReq = new setUserFlagReq(paramInt, DeviceInfoUtil.e(), 109);
    localToServiceMsg.extraData.putSerializable("req", localsetUserFlagReq);
    this.d.sendToService(localToServiceMsg);
  }
  
  public void i()
  {
    try
    {
      if ((this.a != null) && (this.a.g != null))
      {
        BubbleConfig localBubbleConfig = (BubbleConfig)this.a.g.get(Integer.valueOf(d()));
        if ((localBubbleConfig != null) && (localBubbleConfig.c())) {
          localBubbleConfig.b();
        }
      }
      return;
    }
    finally {}
  }
  
  public void i(int paramInt)
  {
    FaceReq localFaceReq = new FaceReq();
    localFaceReq.stLogin = n();
    if (localFaceReq.stLogin == null) {
      return;
    }
    localFaceReq.faceID = paramInt;
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "Face.setFace");
    localToServiceMsg.extraData.putSerializable("req", localFaceReq);
    this.d.sendToService(localToServiceMsg);
  }
  
  public int j()
  {
    int m = VasUtil.b(this.d).getVipStatus().getPrivilegeFlags(null);
    if ((m & 0x4) != 0) {
      return 3;
    }
    if ((m & 0x2) != 0) {
      return 1;
    }
    if ((m & 0x1) != 0) {
      return 2;
    }
    return 0;
  }
  
  public void k()
  {
    FontRecommendReq localFontRecommendReq = new FontRecommendReq();
    localFontRecommendReq.stLogin = n();
    if (localFontRecommendReq.stLogin == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "FontBubbleRecommend.getFontRecommend");
    localToServiceMsg.extraData.putSerializable("req", localFontRecommendReq);
    this.d.sendToService(localToServiceMsg);
  }
  
  public void l()
  {
    BubbleRecommendReq localBubbleRecommendReq = new BubbleRecommendReq();
    localBubbleRecommendReq.stLogin = n();
    if (localBubbleRecommendReq.stLogin == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "FontBubbleRecommend.getBubbleRecommend");
    localToServiceMsg.extraData.putSerializable("req", localBubbleRecommendReq);
    this.d.sendToService(localToServiceMsg);
  }
  
  public void m()
  {
    try
    {
      Object localObject1 = this.d.getCurrentAccountUin();
      Object localObject2 = ((TicketManager)this.d.getManager(2)).getSkey((String)localObject1);
      localObject1 = new GetRoamToastReq(Long.parseLong((String)localObject1), (String)localObject2);
      localObject2 = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "RoamWrap.GetRoamToast");
      ((ToServiceMsg)localObject2).extraData.putSerializable("req", (Serializable)localObject1);
      this.d.sendToService((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SVIPHandler", 1, "getRoamToast fail", localException);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return SVIPObserver.class;
  }
  
  public void onDestroy()
  {
    BubbleManager localBubbleManager = this.a;
    if ((localBubbleManager != null) && (localBubbleManager.g != null)) {
      this.a.g.clear();
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("Font.fresh".equals(paramFromServiceMsg.getServiceCmd()))
    {
      int m = paramToServiceMsg.extraData.getInt("CMD");
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 4)
            {
              if (m != 5) {
                return;
              }
              g(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            f(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("FriendClone.CloneAuthStatus".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("groupnick.readitem".equals(paramFromServiceMsg.getServiceCmd()))
    {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().startsWith("profilelogic."))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("GroupCare.getMessageRemindInfo"))
    {
      i(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getFontRecommend"))
    {
      j(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getBubbleRecommend"))
    {
      k(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("FontBubbleRecommend.setFontBubble"))
    {
      l(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("RoamWrap.GetRoamToast"))
    {
      m(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("Face.setFace"))
    {
      n(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    notifyUI(paramToServiceMsg, 0, true, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SVIPHandler
 * JD-Core Version:    0.7.0.1
 */