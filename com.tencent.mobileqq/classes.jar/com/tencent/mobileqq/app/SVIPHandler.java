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
import com.etrump.mixlayout.FontManager;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleManager.LruLinkedHashMap;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
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
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class SVIPHandler
  extends BusinessHandler
{
  private static int h = 0;
  private int jdField_a_of_type_Int = 0;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public BubbleManager a;
  private boolean jdField_a_of_type_Boolean = false;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  
  SVIPHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager = ((BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER));
  }
  
  public static int a(long paramLong)
  {
    return (int)(0xFFFFFFFF & paramLong);
  }
  
  public static long a(int paramInt1, int paramInt2)
  {
    return paramInt2 << 32 | paramInt1;
  }
  
  private LoginInfo a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      localLoginInfo.sClientVer = DeviceInfoUtil.c();
      return localLoginInfo;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("SVIPHandler", 1, "getLoginInfo fail", paramQQAppInterface);
    }
    return null;
  }
  
  public static int b(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "handleGetUserFont isSuccess = " + paramFromServiceMsg.isSuccess() + " data = " + StructLongMessageDownloadProcessor.bytesToHexString((byte[])paramObject));
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      paramObject = new VipFontUpdate.TFontSsoRsp();
    }
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = (VipFontUpdate.TFontMd5CheckRsp)paramObject.st_md5_check_rsp.get();
        if ((paramFromServiceMsg.rpt_md5_ret.has()) && (paramFromServiceMsg.rpt_md5_ret.get().size() > 0))
        {
          paramFromServiceMsg = (VipFontUpdate.TFontMd5CheckRsp.TMd5Ret)paramFromServiceMsg.rpt_md5_ret.get().get(0);
          int i = paramFromServiceMsg.i32_check_ret.get();
          int j = paramFromServiceMsg.i32_check_font_id.get();
          if (QLog.isColorLevel()) {
            QLog.d("SVIPHandler", 2, "handleGetUserFont fontid = " + j + " md5ret = " + i);
          }
          if ((j == a()) && (i > 0)) {
            paramToServiceMsg.b(j, this.f);
          }
        }
        paramFromServiceMsg = (VipFontUpdate.TFontFreshRsp)paramObject.st_fresh_rsp.get();
        if (paramFromServiceMsg.i32_font_type.has())
        {
          VasShieldFont.jdField_a_of_type_Int = paramFromServiceMsg.i32_font_type.get();
          if (QLog.isColorLevel()) {
            QLog.d("VasShieldFont", 2, "handleGetFontShieldType type= " + VasShieldFont.jdField_a_of_type_Int);
          }
          VasShieldFont.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
          VasShieldFont.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("SVIPHandler", 1, "handleGetUserFont error: " + paramFromServiceMsg.getMessage());
        continue;
      }
      paramToServiceMsg.b.set(true);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("SVIPHandler", 2, "handleGetUserFont response not success message = " + paramFromServiceMsg.getResultCode());
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new VipFontUpdate.TFontSsoRsp();
      do
      {
        ArrayList localArrayList;
        FriendsManager localFriendsManager;
        try
        {
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
          paramToServiceMsg = (VipFontUpdate.TDiyFontRsp)paramToServiceMsg.st_diyfont_rsp.get();
          localArrayList = new ArrayList();
          localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
            int i = localTDiyFontRspInfo.i32_font_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "handleGetDiyFontConfig uin = " + str + " fontId = " + i + " config = " + paramToServiceMsg + " seq = " + paramFromServiceMsg.getRequestSsoSeq());
            }
            paramObject = localFriendsManager.a(str);
            if (paramObject.diyFontConfigMap == null) {
              paramObject.diyFontConfigMap = new ConcurrentHashMap();
            }
            if ((!paramObject.diyFontConfigMap.containsKey(Integer.valueOf(i))) || (!paramToServiceMsg.equals(paramObject.diyFontConfigMap.get(Integer.valueOf(i)))))
            {
              paramObject.diyFontConfigMap.put(Integer.valueOf(i), paramToServiceMsg);
              ((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).b(str, i);
              localArrayList.add(paramObject);
            }
          }
          if (localArrayList.size() <= 0) {
            continue;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          QLog.e("VasFont", 1, "handleGetDiyFontConfig error: + " + paramToServiceMsg.getMessage());
          return;
        }
        localFriendsManager.b(localArrayList);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("VasFont", 2, "handleGetDiyFontConfig return empty");
      return;
    }
    QLog.e("VasFont", 1, "handleGetDiyFontConfig not success errorcode = " + paramFromServiceMsg.getResultCode() + " seq = " + paramFromServiceMsg.getRequestSsoSeq());
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("hiboom_auth_type");
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = new VipFontUpdate.TFontSsoRsp();
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if (paramObject.i32_ret.get() != 0)
        {
          notifyUI(102, false, Integer.valueOf(i));
          return;
        }
        paramFromServiceMsg = (VipFontUpdate.TCheckRsp)paramObject.st_check_rsp.get();
        if (paramFromServiceMsg != null)
        {
          notifyUI(102, true, new Object[] { Integer.valueOf(paramFromServiceMsg.i32_ret.get()), ((VipFontUpdate.TTipsInfo)paramFromServiceMsg.st_tips_info.get()).toByteArray(), Integer.valueOf(paramToServiceMsg.extraData.getInt("hiboom_id")), paramToServiceMsg.extraData.getString("hiboom_text"), Integer.valueOf(i) });
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("SVIPHandler", 1, "handleAuthHiBoom error: " + paramToServiceMsg.getLocalizedMessage() + Log.getStackTraceString(paramToServiceMsg));
        notifyUI(102, false, Integer.valueOf(i));
        return;
      }
      QLog.e("SVIPHandler", 1, "handleAuthHiBoom fail authRsp is null");
      notifyUI(102, false, Integer.valueOf(i));
      return;
    }
    paramToServiceMsg = new StringBuilder().append("handleAuthHiBoom fail isSuccess = ").append(paramFromServiceMsg.isSuccess()).append(" data is null : ");
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.e("SVIPHandler", 1, bool);
      notifyUI(102, false, Integer.valueOf(i));
      return;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new VipFontUpdate.TFontSsoRsp();
      try
      {
        paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = (HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HIBOOM_MANAGER);
        if (paramToServiceMsg.i32_ret.get() != 0)
        {
          QLog.e("HiBoomFont", 1, "handleGetHiBoomList fail ret = " + paramToServiceMsg.i32_ret.get());
          paramFromServiceMsg.c();
          return;
        }
        paramToServiceMsg = (VipFontUpdate.TGetPosterFontRsp)paramToServiceMsg.st_getposterfont_rsp.get();
        if (paramToServiceMsg != null)
        {
          paramFromServiceMsg.a(paramToServiceMsg, true);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("HiBoomFont", 1, "handleGetHiBoomList error: " + Log.getStackTraceString(paramToServiceMsg));
        return;
      }
      QLog.e("HiBoomFont", 1, "handleGetHiBoomList st_getposterfont_rsp is null");
      paramFromServiceMsg.c();
      return;
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
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("HiBoomFont", 1, "handleSetHiBoom error:" + Log.getStackTraceString(paramToServiceMsg));
        notifyUI(103, false, Boolean.valueOf(bool));
        return;
      }
      int i = paramToServiceMsg.extraData.getInt("hiboom_id");
      notifyUI(103, true, new Object[] { Integer.valueOf(paramFromServiceMsg.i32_ret.get()), Integer.valueOf(i), ((VipFontUpdate.TTipsInfo)paramFromServiceMsg.st_tips_info.get()).toByteArray(), Boolean.valueOf(bool), str });
    }
  }
  
  private int h()
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
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "handleRequestColorNickPanel resp = " + paramFromServiceMsg.toString());
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
    QLog.e("vip_pretty.SVIPHandler", 1, "handleGetBigTroopExpiredInfo resp failed:" + paramFromServiceMsg.getResultCode());
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
    int i = paramToServiceMsg.extraData.getInt("setFontBubbleSeq");
    if ((paramObject instanceof SetFontBubbleRsp))
    {
      notifyUI(109, true, new Object[] { paramObject, Integer.valueOf(i) });
      return;
    }
    notifyUI(109, false, new Object[] { null, Integer.valueOf(i) });
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
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof FaceRsp))
    {
      notifyUI(112, true, paramObject);
      return;
    }
    notifyUI(112, false, paramObject);
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/tencent/mobileqq/app/SVIPHandler:e	I
    //   6: iconst_m1
    //   7: if_icmpne +54 -> 61
    //   10: aload_0
    //   11: getfield 46	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: getstatic 289	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   17: invokevirtual 57	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   20: checkcast 291	com/tencent/mobileqq/app/FriendsManager
    //   23: aload_0
    //   24: getfield 46	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 570	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   30: invokevirtual 353	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnonnull +9 -> 44
    //   38: iconst_0
    //   39: istore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_1
    //   43: ireturn
    //   44: aload_0
    //   45: aload_2
    //   46: getfield 573	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   49: l2i
    //   50: putfield 40	com/tencent/mobileqq/app/SVIPHandler:e	I
    //   53: aload_0
    //   54: aload_2
    //   55: getfield 576	com/tencent/mobileqq/data/ExtensionInfo:vipFontType	I
    //   58: putfield 42	com/tencent/mobileqq/app/SVIPHandler:f	I
    //   61: aload_0
    //   62: getfield 40	com/tencent/mobileqq/app/SVIPHandler:e	I
    //   65: istore_1
    //   66: goto -26 -> 40
    //   69: astore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	SVIPHandler
    //   39	27	1	i	int
    //   33	22	2	localExtensionInfo	ExtensionInfo
    //   69	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	69	finally
    //   44	61	69	finally
    //   61	66	69	finally
  }
  
  public int a(MessageRecord paramMessageRecord)
  {
    int j = a(paramMessageRecord.vipBubbleID);
    if (j == 0) {
      return 0;
    }
    int i;
    if (paramMessageRecord.vipSubBubbleId != 0) {
      i = paramMessageRecord.vipSubBubbleId;
    }
    for (;;)
    {
      if ((i != 0) && (a(j, i)))
      {
        paramMessageRecord.vipSubBubbleId = i;
        return i;
        String str = paramMessageRecord.getExtInfoFromExtStr("bubble_sub_id");
        if (QLog.isColorLevel()) {
          QLog.i("SVIPHandler", 2, String.format("try get bubbleSubId from msg id %d : %s", new Object[] { Long.valueOf(paramMessageRecord.uniseq), str }));
        }
        if (!TextUtils.isEmpty(str)) {
          i = Integer.parseInt(str);
        }
      }
      else
      {
        paramMessageRecord.vipSubBubbleId = 0;
        return j;
      }
      i = 0;
    }
  }
  
  public int a(String paramString)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(paramString, 0).getInt("svip_colorScreen_id", 0);
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "getColorScreenId " + paramString + " id " + i);
    }
    return i;
  }
  
  public void a()
  {
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(1);
    Object localObject1 = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject1).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("8.5.5.5105");
    Object localObject3 = new VipFontUpdate.TFontFreshReq();
    ((VipFontUpdate.TFontFreshReq)localObject3).i32_local_font_id.set(a());
    ((VipFontUpdate.TFontFreshReq)localObject3).i32_cpu_freq.set((int)DeviceInfoUtil.c());
    ((VipFontUpdate.TFontFreshReq)localObject3).i32_cpu_num.set(DeviceInfoUtil.b());
    ((VipFontUpdate.TFontFreshReq)localObject3).i32_total_mem.set((int)(DeviceInfoUtil.a() / 1048576L));
    Object localObject2 = Build.BRAND.toUpperCase();
    localObject1 = localObject2;
    if (((String)localObject2).equals("HONOR")) {
      localObject1 = "HUAWEI";
    }
    ((VipFontUpdate.TFontFreshReq)localObject3).str_brand.set((String)localObject1);
    ((VipFontUpdate.TFontFreshReq)localObject3).str_model.set(Build.MODEL.toUpperCase());
    ((VipFontUpdate.TFontFreshReq)localObject3).i32_os_type.set(h());
    ((VipFontUpdate.TFontFreshReq)localObject3).i32_version.set(Build.VERSION.SDK_INT);
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, ((VipFontUpdate.TFontFreshReq)localObject3).i32_cpu_freq.get() + " | " + ((VipFontUpdate.TFontFreshReq)localObject3).i32_cpu_num.get() + " | " + ((VipFontUpdate.TFontFreshReq)localObject3).i32_total_mem.get() + " | " + ((VipFontUpdate.TFontFreshReq)localObject3).str_brand.get() + " | " + ((VipFontUpdate.TFontFreshReq)localObject3).str_model.get() + " | " + ((VipFontUpdate.TFontFreshReq)localObject3).i32_os_type.get() + " | " + ((VipFontUpdate.TFontFreshReq)localObject3).i32_version.get());
    }
    localTFontSsoReq.st_fresh_req.set((MessageMicro)localObject3);
    VasShieldFont.a();
    VasShieldFont.c = a();
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, "pbGetUserFont: " + VasShieldFont.c);
    }
    localObject1 = new VipFontUpdate.TFontMd5CheckReq();
    localObject2 = new VipFontUpdate.TFontMd5CheckReq.TMd5Info();
    ((VipFontUpdate.TFontMd5CheckReq.TMd5Info)localObject2).i32_font_id.set(a());
    localObject3 = ((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(a(), this.f);
    Object localObject4;
    if (localObject3 != null)
    {
      localObject4 = new File(((FontInfo)localObject3).a);
      if ((!((File)localObject4).exists()) || (!((File)localObject4).isFile())) {
        break label649;
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = new FileInputStream((File)localObject4);
        localObject4 = MD5.toMD5Byte((InputStream)localObject3, ((File)localObject4).length());
        if (QLog.isColorLevel()) {
          QLog.d("SVIPHandler", 2, "fontFile MD5 = " + StructLongMessageDownloadProcessor.bytesToHexString((byte[])localObject4));
        }
        ((VipFontUpdate.TFontMd5CheckReq.TMd5Info)localObject2).bytes_md5.set(ByteStringMicro.copyFrom((byte[])localObject4));
        ((FileInputStream)localObject3).close();
      }
      catch (Exception localException)
      {
        QLog.e("SVIPHandler", 1, "pbGetUserFont error" + localException.getMessage());
        continue;
      }
      ((VipFontUpdate.TFontMd5CheckReq)localObject1).rpt_md5_info.add((MessageMicro)localObject2);
      localTFontSsoReq.st_md5_check_req.set((MessageMicro)localObject1);
      localObject1 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Font.fresh");
      ((ToServiceMsg)localObject1).putWupBuffer(localTFontSsoReq.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("CMD", 1);
      sendPbReq((ToServiceMsg)localObject1);
      return;
      label649:
      if (QLog.isColorLevel()) {
        QLog.e("SVIPHandler", 2, "fontFile exists = " + ((File)localObject4).exists() + " ,isFile = " + ((File)localObject4).isFile());
      }
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (paramInt != this.b)
      {
        this.b = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putInt("svip_bubble_id", paramInt).commit();
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SVIPHandler", 2, "setSelfFontInfo id = " + paramInt1 + " type = " + paramInt2);
      }
      Object localObject1;
      if ((paramInt1 != this.e) || (paramInt2 != this.f))
      {
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        ExtensionInfo localExtensionInfo = localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        localObject1 = localExtensionInfo;
        if (localExtensionInfo == null)
        {
          localObject1 = new ExtensionInfo();
          ((ExtensionInfo)localObject1).uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        }
        ((ExtensionInfo)localObject1).uVipFont = paramInt1;
        ((ExtensionInfo)localObject1).vipFontType = paramInt2;
        this.e = paramInt1;
        this.f = paramInt2;
        localFriendsManager.a((ExtensionInfo)localObject1);
      }
      if (VasShieldFont.c != paramInt1)
      {
        VasShieldFont.c = paramInt1;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject1 != null)
        {
          ((MqqHandler)localObject1).removeMessages(87);
          ((MqqHandler)localObject1).sendEmptyMessage(87);
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    SetFontBubbleReq localSetFontBubbleReq = new SetFontBubbleReq();
    localSetFontBubbleReq.stLogin = a();
    if (localSetFontBubbleReq.stLogin == null) {
      return;
    }
    localSetFontBubbleReq.stFontReq = new FontReq(paramInt1);
    localSetFontBubbleReq.stBubbleReq = new BubbleReq(paramInt2);
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "FontBubbleRecommend.setFontBubble");
    localToServiceMsg.extraData.putInt("setFontBubbleSeq", paramInt3);
    localToServiceMsg.extraData.putSerializable("req", localSetFontBubbleReq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(2);
    Object localObject = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("8.5.5.5105");
    localObject = new VipFontUpdate.TCheckReq();
    ((VipFontUpdate.TCheckReq)localObject).i32_font_id.set(paramInt1);
    ((VipFontUpdate.TCheckReq)localObject).i32_type.set(paramInt2);
    ((VipFontUpdate.TCheckReq)localObject).str_message_test.set(paramString);
    localTFontSsoReq.st_check_req.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Font.fresh");
    switch (NetworkState.getNetworkType())
    {
    case 2: 
    case 3: 
    default: 
      ((ToServiceMsg)localObject).setTimeout(5000L);
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).putWupBuffer(localTFontSsoReq.toByteArray());
      ((ToServiceMsg)localObject).extraData.putInt("CMD", 2);
      ((ToServiceMsg)localObject).extraData.putInt("hiboom_id", paramInt1);
      ((ToServiceMsg)localObject).extraData.putString("hiboom_text", paramString);
      ((ToServiceMsg)localObject).extraData.putInt("hiboom_auth_type", paramInt2);
      sendPbReq((ToServiceMsg)localObject);
      return;
      ((ToServiceMsg)localObject).setTimeout(5000L);
      continue;
      ((ToServiceMsg)localObject).setTimeout(10000L);
    }
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 36	com/tencent/mobileqq/app/SVIPHandler:c	I
    //   7: if_icmpeq +139 -> 146
    //   10: aload_0
    //   11: getfield 46	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: ifnull +132 -> 146
    //   17: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +29 -> 49
    //   23: ldc 112
    //   25: iconst_2
    //   26: new 132	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 953
    //   36: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_1
    //   40: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: iload_1
    //   51: putfield 36	com/tencent/mobileqq/app/SVIPHandler:c	I
    //   54: aload_0
    //   55: getfield 46	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   58: invokevirtual 616	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   61: aload_0
    //   62: getfield 46	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   65: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   68: iconst_0
    //   69: invokevirtual 622	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   72: invokeinterface 846 1 0
    //   77: ldc_w 955
    //   80: iload_1
    //   81: invokeinterface 853 3 0
    //   86: invokeinterface 856 1 0
    //   91: pop
    //   92: iload_1
    //   93: ifle +53 -> 146
    //   96: new 132	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   103: aload_0
    //   104: getfield 46	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   107: invokevirtual 570	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   110: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 957
    //   116: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload_1
    //   120: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_3
    //   127: iload_2
    //   128: ifeq +26 -> 154
    //   131: new 959	com/tencent/mobileqq/app/SVIPHandler$1
    //   134: dup
    //   135: aload_0
    //   136: aload_3
    //   137: invokespecial 962	com/tencent/mobileqq/app/SVIPHandler$1:<init>	(Lcom/tencent/mobileqq/app/SVIPHandler;Ljava/lang/String;)V
    //   140: iconst_5
    //   141: aconst_null
    //   142: iconst_0
    //   143: invokestatic 968	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 28	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_Boolean	Z
    //   151: aload_0
    //   152: monitorexit
    //   153: return
    //   154: invokestatic 973	com/tencent/mobileqq/bubble/BubbleDiyFetcher:a	()Lcom/tencent/mobileqq/bubble/BubbleDiyFetcher;
    //   157: aload_0
    //   158: getfield 46	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   161: aload_3
    //   162: aconst_null
    //   163: invokevirtual 976	com/tencent/mobileqq/bubble/BubbleDiyFetcher:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   166: goto -20 -> 146
    //   169: astore_3
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_3
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	SVIPHandler
    //   0	174	1	paramInt	int
    //   0	174	2	paramBoolean	boolean
    //   126	36	3	str	String
    //   169	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	49	169	finally
    //   49	92	169	finally
    //   96	127	169	finally
    //   131	146	169	finally
    //   146	151	169	finally
    //   154	166	169	finally
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont", 2, "setHiboom id = " + paramInt);
    }
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(5);
    Object localObject = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("8.5.5.5105");
    localObject = new VipFontUpdate.TSetPosterFontReq();
    ((VipFontUpdate.TSetPosterFontReq)localObject).i32_font_id.set(paramInt);
    localTFontSsoReq.st_setposterfont_req.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Font.fresh");
    ((ToServiceMsg)localObject).putWupBuffer(localTFontSsoReq.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("CMD", 5);
    ((ToServiceMsg)localObject).extraData.putInt("hiboom_id", paramInt);
    ((ToServiceMsg)localObject).extraData.putBoolean("hiboom_auth_is_send", paramBoolean);
    ((ToServiceMsg)localObject).extraData.putString("hiboom_text", paramString);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong)
  {
    MessageRemindReq localMessageRemindReq = new MessageRemindReq();
    localMessageRemindReq.iGroupCode = paramLong;
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramLong + "");
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("SVIPHandler", 2, "getBigTroopExpiredInfo troopInfo == null, troopUin: " + paramLong);
      }
    }
    do
    {
      return;
      localMessageRemindReq.uOwnerUin = Long.parseLong(((TroopInfo)localObject).troopowneruin);
      localMessageRemindReq.dwAppId = AppSetting.a();
      localMessageRemindReq.sKey = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (localMessageRemindReq.sKey != null)
      {
        localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "GroupCare.getMessageRemindInfo");
        ((ToServiceMsg)localObject).extraData.putSerializable("req", localMessageRemindReq);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService((ToServiceMsg)localObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SVIPHandler", 2, "getBigTroopExpiredInfo skey == null, troopUin: " + paramLong);
  }
  
  public void a(GetRoamToastRsp paramGetRoamToastRsp)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      QLog.e("SVIPHandler", 1, "closeToast null uin");
    }
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences((String)localObject, 0);
      paramGetRoamToastRsp = "roam_toast_close_" + paramGetRoamToastRsp.sToastKey;
      i = ((SharedPreferences)localObject).getInt(paramGetRoamToastRsp, 0);
      ((SharedPreferences)localObject).edit().putInt(paramGetRoamToastRsp, i + 1).commit();
    } while (!QLog.isColorLevel());
    QLog.d("SVIPHandler", 2, "closeToast: " + paramGetRoamToastRsp + "," + (i + 1));
  }
  
  public void a(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    paramBusinessObserver = createToServiceMsg("QCUniBusinessLogin.check", paramBusinessObserver, paramBoolean);
    UniLoginCheckReq localUniLoginCheckReq = new UniLoginCheckReq(a(), new ArrayList(), 2L, new GetUsrKeyWordInfoReq());
    paramBusinessObserver.extraData.putSerializable("req", localUniLoginCheckReq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(paramBusinessObserver);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (!paramMessageRecord.needVipBubble())) {
      break label11;
    }
    label11:
    while (((AnonymousChatHelper.a(paramMessageRecord)) && (AnonymousChatHelper.b(paramMessageRecord))) || (paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) {
      return;
    }
    if (e() > 0)
    {
      paramMessageRecord.vipBubbleID = a(b(), e());
      paramMessageRecord.vipBubbleDiyTextId = e();
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForPtt))
      {
        int i = f();
        if (i > 0) {
          paramMessageRecord.vipBubbleID = i;
        }
      }
      paramMessageRecord.vipSubBubbleId = c();
      if (paramMessageRecord.vipSubBubbleId == 0) {
        break;
      }
      paramMessageRecord.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(paramMessageRecord.vipSubBubbleId));
      c();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("SVIPHandler", 2, "addSendingBubbleId: changeSubBubbleId, messageRecord: " + paramMessageRecord.getClass().getSimpleName());
      return;
      paramMessageRecord.vipBubbleID = b();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "handleFriendClone: resp=" + paramFromServiceMsg.toString());
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
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(paramString, 0);
    localSharedPreferences.getInt("svip_colorScreen_id", 0);
    localSharedPreferences.edit().putInt("svip_colorScreen_id", paramInt).commit();
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "setColorScreenId " + paramString + " id " + paramInt);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    paramString = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "FriendClone.CloneAuthStatus");
    paramString.extraData.putInt("operation", paramInt);
    paramString.extraData.putString("uUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramString.extraData.putBoolean("bOpenAuth", paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(paramString);
  }
  
  public void a(ArrayList<Hamlet> paramArrayList, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    paramBusinessObserver = createToServiceMsg("QCUniBusinessLogin.check", paramBusinessObserver, paramBoolean);
    paramArrayList = new UniLoginCheckReq(a(), paramArrayList, 3L, new GetUsrKeyWordInfoReq());
    paramBusinessObserver.extraData.putSerializable("req", paramArrayList);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(paramBusinessObserver);
  }
  
  public void a(Map<String, Integer> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "pbGetDiyFontConfig");
    }
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(3);
    Object localObject = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("8.5.5.5105");
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
    paramMap = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Font.fresh");
    paramMap.putWupBuffer(localTFontSsoReq.toByteArray());
    paramMap.extraData.putInt("CMD", 3);
    sendPbReq(paramMap);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a != null))
    {
      BubbleConfig localBubbleConfig = (BubbleConfig)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a.get(Integer.valueOf(paramInt1));
      return (localBubbleConfig != null) && (localBubbleConfig.a()) && (localBubbleConfig.a(paramInt2));
    }
    return false;
  }
  
  public boolean a(GetRoamToastRsp paramGetRoamToastRsp)
  {
    boolean bool = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("SVIPHandler", 1, "shouldShowToast null uin");
      return false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences((String)localObject, 0);
    paramGetRoamToastRsp = "roam_toast_close_" + paramGetRoamToastRsp.sToastKey;
    int i = ((SharedPreferences)localObject).getInt(paramGetRoamToastRsp, 0);
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "shouldShowToast: " + paramGetRoamToastRsp + "," + i);
    }
    if (i < 2) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int b()
  {
    try
    {
      if (this.b == -1) {
        this.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("svip_bubble_id", 0);
      }
      int i = a(this.b);
      return i;
    }
    finally {}
  }
  
  public void b()
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
    localTFontSsoReq.str_mqqver.set("8.5.5.5105");
    localObject = new VipFontUpdate.TGetPosterFontReq();
    ((VipFontUpdate.TGetPosterFontReq)localObject).isgetrecommend.set(1);
    localTFontSsoReq.st_getposterfont_req.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Font.fresh");
    ((ToServiceMsg)localObject).putWupBuffer(localTFontSsoReq.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("CMD", 4);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (paramInt != this.d)
      {
        this.d = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putInt("svip_bubble_voice_print_id", paramInt).commit();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void b(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 44	com/tencent/mobileqq/app/SVIPHandler:g	I
    //   7: if_icmpeq +101 -> 108
    //   10: aload_0
    //   11: getfield 46	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: ifnull +94 -> 108
    //   17: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +29 -> 49
    //   23: ldc 112
    //   25: iconst_2
    //   26: new 132	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 1190
    //   36: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_1
    //   40: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: iload_1
    //   51: putfield 44	com/tencent/mobileqq/app/SVIPHandler:g	I
    //   54: iload_1
    //   55: ifle +53 -> 108
    //   58: new 132	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   65: aload_0
    //   66: getfield 46	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 570	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   72: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 957
    //   78: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: iload_1
    //   82: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_3
    //   89: iload_2
    //   90: ifeq +26 -> 116
    //   93: new 1192	com/tencent/mobileqq/app/SVIPHandler$2
    //   96: dup
    //   97: aload_0
    //   98: aload_3
    //   99: invokespecial 1193	com/tencent/mobileqq/app/SVIPHandler$2:<init>	(Lcom/tencent/mobileqq/app/SVIPHandler;Ljava/lang/String;)V
    //   102: iconst_5
    //   103: aconst_null
    //   104: iconst_0
    //   105: invokestatic 968	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield 28	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_Boolean	Z
    //   113: aload_0
    //   114: monitorexit
    //   115: return
    //   116: invokestatic 1198	com/tencent/mobileqq/addon/DiyPendantFetcher:a	()Lcom/tencent/mobileqq/addon/DiyPendantFetcher;
    //   119: aload_0
    //   120: getfield 46	com/tencent/mobileqq/app/SVIPHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   123: aload_3
    //   124: aconst_null
    //   125: invokevirtual 1201	com/tencent/mobileqq/addon/DiyPendantFetcher:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/app/BusinessObserver;)Lcom/tencent/mobileqq/addon/DiyPendantEntity;
    //   128: pop
    //   129: goto -21 -> 108
    //   132: astore_3
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_3
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	SVIPHandler
    //   0	137	1	paramInt	int
    //   0	137	2	paramBoolean	boolean
    //   88	36	3	str	String
    //   132	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	49	132	finally
    //   49	54	132	finally
    //   58	89	132	finally
    //   93	108	132	finally
    //   108	113	132	finally
    //   116	129	132	finally
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "handleRequestDefaultCard: resp=" + paramFromServiceMsg.toString());
    }
    if (((paramObject instanceof readUserInfoRsp)) || ((paramObject instanceof setUserProfileRsp)) || ((paramObject instanceof setUserFlagRsp)))
    {
      notifyUI(106, true, paramObject);
      return;
    }
    notifyUI(106, false, paramFromServiceMsg.getServiceCmd());
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a != null))
    {
      BubbleConfig localBubbleConfig = (BubbleConfig)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a.get(Integer.valueOf(b()));
      if ((localBubbleConfig != null) && (localBubbleConfig.a()))
      {
        int i = localBubbleConfig.a();
        if (QLog.isColorLevel()) {
          QLog.i("SVIPHandler", 2, "main bubbleid: " + this.b + ", subBubbleId: " + i);
        }
        return i;
      }
    }
    return 0;
  }
  
  public void c()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a != null))
      {
        BubbleConfig localBubbleConfig = (BubbleConfig)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a.get(Integer.valueOf(b()));
        if ((localBubbleConfig != null) && (localBubbleConfig.a())) {
          localBubbleConfig.a();
        }
      }
      return;
    }
    finally {}
  }
  
  public void c(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SVIPHandler", 2, "setMagicFont setup = " + paramInt);
      }
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      ExtensionInfo localExtensionInfo2 = localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
      if (localExtensionInfo2 == null)
      {
        localExtensionInfo1 = new ExtensionInfo();
        localExtensionInfo1.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      }
      if (localExtensionInfo1.magicFont != paramInt)
      {
        localExtensionInfo1.magicFont = paramInt;
        if (1 == paramInt) {
          localExtensionInfo1.fontEffect = 0;
        }
      }
      localFriendsManager.a(localExtensionInfo1);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  public ToServiceMsg createToServiceMsg(String paramString, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    return super.createToServiceMsg(paramString, paramBusinessObserver, paramBoolean);
  }
  
  /* Error */
  public int d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1231
    //   5: invokestatic 1237	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   8: checkcast 1231	com/tencent/mobileqq/dpc/api/IDPCApi
    //   11: getstatic 1243	com/tencent/mobileqq/dpc/enumname/DPCNames:MsgLengthByBubble	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   14: invokevirtual 1246	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   17: ldc_w 1248
    //   20: invokeinterface 1251 3 0
    //   25: astore_3
    //   26: iconst_0
    //   27: istore_2
    //   28: aload_3
    //   29: invokestatic 612	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   32: istore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_1
    //   36: ireturn
    //   37: astore_3
    //   38: iload_2
    //   39: istore_1
    //   40: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq -10 -> 33
    //   46: ldc 112
    //   48: iconst_2
    //   49: aload_3
    //   50: invokevirtual 1252	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   53: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iload_2
    //   57: istore_1
    //   58: goto -25 -> 33
    //   61: astore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	SVIPHandler
    //   32	26	1	i	int
    //   27	30	2	j	int
    //   25	4	3	str	String
    //   37	13	3	localNumberFormatException	java.lang.NumberFormatException
    //   61	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	33	37	java/lang/NumberFormatException
    //   2	26	61	finally
    //   28	33	61	finally
    //   40	56	61	finally
  }
  
  public void d()
  {
    FontRecommendReq localFontRecommendReq = new FontRecommendReq();
    localFontRecommendReq.stLogin = a();
    if (localFontRecommendReq.stLogin == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "FontBubbleRecommend.getFontRecommend");
    localToServiceMsg.extraData.putSerializable("req", localFontRecommendReq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
  }
  
  public void d(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("SVIPHandler", 2, "setFontEffect fontEffectId = " + paramInt);
        }
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        ExtensionInfo localExtensionInfo = localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if (localExtensionInfo == null)
        {
          localExtensionInfo = new ExtensionInfo();
          localExtensionInfo.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
          localExtensionInfo.fontEffect = -1;
          i = 1;
          if (localExtensionInfo.fontEffect != paramInt)
          {
            localExtensionInfo.fontEffect = paramInt;
            localExtensionInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
            ((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).e();
            if (paramInt == 0) {
              break label168;
            }
            localExtensionInfo.magicFont = 0;
            break label168;
          }
          if (i != 0) {
            localFriendsManager.a(localExtensionInfo);
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
      }
      finally {}
      int i = 0;
      continue;
      label168:
      i = 1;
    }
  }
  
  public int e()
  {
    try
    {
      if (this.c == -1) {
        this.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("svip_bubble_diy_text_id", 0);
      }
      int i = this.c;
      return i;
    }
    finally {}
  }
  
  public void e()
  {
    BubbleRecommendReq localBubbleRecommendReq = new BubbleRecommendReq();
    localBubbleRecommendReq.stLogin = a();
    if (localBubbleRecommendReq.stLogin == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "FontBubbleRecommend.getBubbleRecommend");
    localToServiceMsg.extraData.putSerializable("req", localBubbleRecommendReq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
  }
  
  public void e(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "groupnick.readitem");
    readItemInfoReq localreadItemInfoReq = new readItemInfoReq(109L, DeviceInfoUtil.c(), paramInt);
    localToServiceMsg.extraData.putSerializable("req", localreadItemInfoReq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
  }
  
  public int f()
  {
    try
    {
      if (this.d == -1) {
        this.d = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("svip_bubble_voice_print_id", 0);
      }
      int i = this.d;
      return i;
    }
    finally {}
  }
  
  public void f()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      Object localObject2 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey((String)localObject1);
      localObject1 = new GetRoamToastReq(Long.parseLong((String)localObject1), (String)localObject2);
      localObject2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "RoamWrap.GetRoamToast");
      ((ToServiceMsg)localObject2).extraData.putSerializable("req", (Serializable)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SVIPHandler", 1, "getRoamToast fail", localException);
    }
  }
  
  public void f(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "profilelogic.readUserInfo");
    readUserInfoReq localreadUserInfoReq = new readUserInfoReq(DeviceInfoUtil.c(), 109, paramInt);
    localToServiceMsg.extraData.putSerializable("req", localreadUserInfoReq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
  }
  
  public int g()
  {
    int i = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    if ((i & 0x4) != 0) {
      return 3;
    }
    if ((i & 0x2) != 0) {
      return 1;
    }
    if ((i & 0x1) != 0) {
      return 2;
    }
    return 0;
  }
  
  public void g(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "profilelogic.setUserProfile");
    setUserProfileReq localsetUserProfileReq = new setUserProfileReq(paramInt, DeviceInfoUtil.c(), 109);
    localToServiceMsg.extraData.putSerializable("req", localsetUserProfileReq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
  }
  
  public void h(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "profilelogic.setUserFlag");
    setUserFlagReq localsetUserFlagReq = new setUserFlagReq(paramInt, DeviceInfoUtil.c(), 109);
    localToServiceMsg.extraData.putSerializable("req", localsetUserFlagReq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
  }
  
  public void i(int paramInt)
  {
    FaceReq localFaceReq = new FaceReq();
    localFaceReq.stLogin = a();
    if (localFaceReq.stLogin == null) {
      return;
    }
    localFaceReq.faceID = paramInt;
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Face.setFace");
    localToServiceMsg.extraData.putSerializable("req", localFaceReq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return SVIPObserver.class;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a.clear();
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("Font.fresh".equals(paramFromServiceMsg.getServiceCmd()))
    {
      switch (paramToServiceMsg.extraData.getInt("CMD"))
      {
      default: 
        return;
      case 1: 
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      case 3: 
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      case 2: 
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      case 4: 
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
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