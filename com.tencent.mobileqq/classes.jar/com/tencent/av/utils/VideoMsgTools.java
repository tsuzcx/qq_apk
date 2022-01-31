package com.tencent.av.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.TestStructMsg;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.PoolingByteArrayOutputStream;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kib;
import kic;
import kid;
import kif;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONObject;

public class VideoMsgTools
{
  static Map a = new HashMap();
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString.contains(paramContext.getString(2131428839))) {
      return 2131494295;
    }
    if (paramBoolean) {
      return 2131494223;
    }
    return 2131494220;
  }
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2130840227;
    if (paramInt == 13) {
      if (paramBoolean1)
      {
        paramInt = i;
        if (paramBoolean2) {
          paramInt = 2130840228;
        }
      }
    }
    do
    {
      return paramInt;
      if (paramBoolean2) {
        return 2130840072;
      }
      return 2130840071;
      if (paramString.contains(paramContext.getString(2131428841)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130840344;
          }
          return 2130840343;
        }
        if (paramBoolean2) {
          return 2130840072;
        }
        return 2130840071;
      }
      if (paramString.contains(paramContext.getString(2131428842)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130840344;
          }
          return 2130840343;
        }
        if (paramBoolean2) {
          return 2130840072;
        }
        return 2130840071;
      }
      if (paramString.contains(paramContext.getString(2131428839)))
      {
        if (paramBoolean1) {
          return 2130840342;
        }
        return 2130840070;
      }
      if (paramString.contains(paramContext.getString(2131428845)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130840344;
          }
          return 2130840343;
        }
        if (paramBoolean2) {
          return 2130840072;
        }
        return 2130840071;
      }
      if (paramString.contains(paramContext.getString(2131428838)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130840344;
          }
          return 2130840343;
        }
        if (paramBoolean2) {
          return 2130840072;
        }
        return 2130840071;
      }
      if (paramString.contains(paramContext.getString(2131428844)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130840344;
          }
          return 2130840343;
        }
        if (paramBoolean2) {
          return 2130840072;
        }
        return 2130840071;
      }
      if (paramString.contains(paramContext.getString(2131429178)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130840344;
          }
          return 2130840343;
        }
        if (paramBoolean2) {
          return 2130840072;
        }
        return 2130840071;
      }
      if (!paramBoolean1) {
        break;
      }
      paramInt = i;
    } while (!paramBoolean2);
    return 2130840228;
    if (paramBoolean2) {
      return 2130840072;
    }
    return 2130840071;
  }
  
  static int a(String paramString)
  {
    int k = paramString.length();
    int j = 5381;
    int i = 0;
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
    case 9: 
    case 15: 
    case 48: 
    case 59: 
      if (paramString != null)
      {
        paramContext = paramContext.getString(2131428841);
        return paramContext + " " + paramString;
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131428843);
      }
      return paramContext.getString(2131428842);
    case 2: 
    case 24: 
    case 47: 
      if (paramString != null)
      {
        paramContext = paramContext.getString(2131428841);
        return paramContext + " " + paramString;
      }
      if (paramBoolean)
      {
        if (paramInt2 == 9500) {
          return paramContext.getString(2131428843);
        }
        return paramContext.getString(2131428842);
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131428840);
      }
      return paramContext.getString(2131428839);
    case 1: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131428840);
      }
      return paramContext.getString(2131428839);
    case 3: 
      return paramContext.getString(2131428845);
    case 10: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131428840);
      }
      return paramContext.getString(2131428839);
    case 7: 
      return paramContext.getString(2131428838);
    case 12: 
      if (paramBoolean)
      {
        if (paramInt2 == 9500) {
          return paramContext.getString(2131428843);
        }
        return paramContext.getString(2131428842);
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131428840);
      }
      return paramContext.getString(2131428839);
    case 42: 
    case 43: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131428843);
      }
      return paramContext.getString(2131428842);
    case 49: 
      return paramContext.getString(2131429178);
    case 53: 
      return paramContext.getString(2131429180);
    }
    if (paramInt2 == 9500) {
      return paramContext.getString(2131428840);
    }
    return paramContext.getString(2131428839);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    localObject5 = null;
    String str1 = null;
    localJSONObject1 = null;
    if (paramQQAppInterface == null) {
      return;
    }
    String str2 = paramQQAppInterface.getCurrentAccountUin();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)paramQQAppInterface.getManager(35)).a("101300.101301");
    Object localObject1 = localAppInfo.buffer.get();
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject6 = new JSONObject();
            if (((JSONObject)localObject6).optBoolean("isRead")) {
              continue;
            }
            localObject1 = ((JSONObject)localObject6).optString("_show_mission");
            JSONObject localJSONObject2 = ((JSONObject)localObject6).optJSONObject("param");
            if (localJSONObject2 == null) {
              continue;
            }
            localJSONObject1 = localJSONObject2.optJSONObject((String)localObject1);
            j = localJSONObject1.getInt("_red_ext_value");
          }
        }
        catch (Exception localException1)
        {
          Object localObject6;
          Object localObject2 = null;
          int i = 0;
          int j = 0;
          continue;
          i = 0;
          continue;
          i = 1004;
          continue;
          i = 1000;
          continue;
          i = 3;
          continue;
          i = 1;
          continue;
          i = 3000;
          continue;
          Object localObject3;
          Object localObject4 = null;
          i = 0;
          j = 0;
          localObject5 = localJSONObject1;
          continue;
        }
        try
        {
          i = localJSONObject1.getInt("_red_ext_call_type");
        }
        catch (Exception localException2)
        {
          localObject3 = null;
          i = 0;
          continue;
        }
        try
        {
          localObject1 = localJSONObject1.getString("_red_ext_uin");
          localObject5 = str1;
        }
        catch (Exception localException3)
        {
          localObject4 = null;
          continue;
        }
        try
        {
          str1 = localJSONObject1.getString("_red_ext_id");
          localObject5 = str1;
          ((JSONObject)localObject6).put("isRead", true);
          localObject5 = str1;
          localAppInfo.buffer.set(((JSONObject)localObject6).toString());
          localObject5 = str1;
          if (QLog.isColorLevel()) {
            QLog.d("VideoMsgTools", 2, "WL_DEBUG addPstnRedTouchMsg _red_ext_call_type = " + i + ", friendUin = " + (String)localObject1 + ", senderUin = " + str2);
          }
          if ((j == 0) || (localObject1 == null) || (((String)localObject1).length() <= 2)) {
            break;
          }
          switch (i)
          {
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          default: 
            i = 0;
            localObject6 = String.format(paramQQAppInterface.getApp().getString(2131429579), new Object[] { Integer.valueOf(j) });
            localObject1 = new UniteGrayTipParam((String)localObject1, str2, (String)localObject6, i, -5040, 131073, MessageCache.a());
            ((UniteGrayTipParam)localObject1).d = ((String)localObject5);
            localObject5 = new Bundle();
            ((Bundle)localObject5).putInt("key_action", 1);
            ((Bundle)localObject5).putString("key_action_DATA", "https://imgcache.qq.com/lightalk/lightalk_pay/qq/index.html?_wv=1025&type=");
            ((UniteGrayTipParam)localObject1).a(4, ((String)localObject6).length() - 7, (Bundle)localObject5);
            localObject5 = new MessageForUniteGrayTip();
            ((MessageForUniteGrayTip)localObject5).initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject1);
            UniteGrayTipUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject5);
            return;
          }
        }
        catch (Exception localException4) {}
      }
      localObject6 = new JSONObject((String)localObject1);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2)
  {
    AVLog.d("VideoMsgTools", "addTipsVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", friendUin = " + paramString1 + ", extra=" + paramString2);
    if (paramInt1 == -1) {}
    do
    {
      QQMessageFacade localQQMessageFacade;
      do
      {
        return;
        localQQMessageFacade = paramQQAppInterface.a();
      } while (localQQMessageFacade == null);
      switch (paramInt2)
      {
      case 6: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 26: 
      case 27: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 36: 
      case 37: 
      case 38: 
      case 42: 
      case 43: 
      case 44: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
      case 53: 
      case 54: 
      case 57: 
      case 58: 
      case 59: 
      case 60: 
      default: 
        paramString2 = paramQQAppInterface.getApp().getString(2131429090);
      }
      String str1;
      String str2;
      for (;;)
      {
        str1 = paramQQAppInterface.getCurrentAccountUin();
        str2 = TransfileUtile.a(paramString2, 0L, 3, paramBoolean);
        if (paramInt1 != 9500) {
          break;
        }
        ((DeviceMsgHandle)paramQQAppInterface.a(49)).a(paramString1, paramString2, MessageCache.a(), false, false, true);
        return;
        paramString2 = paramQQAppInterface.getApp().getString(2131428672);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131428675);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131428673);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131428674);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131428676);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131428677);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131428679);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131428804);
        continue;
        if (paramBoolean)
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131428680);
        }
        else
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131428681);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131428684);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131428685);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131428742);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131428743);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131428744);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131428746);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131428745);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131429066);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131428846) + paramString2;
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131429090);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131429179);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131429181);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131429182);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131429183);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131429038);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131429651);
        }
      }
      paramString2 = MessageRecordFactory.a(-1001);
      paramString2.selfuin = str1;
      paramString2.frienduin = paramString1;
      paramString2.senderuin = str1;
      paramString2.msg = str2;
      paramString2.msgtype = -1001;
      paramString2.isread = true;
      paramString2.issend = 0;
      paramString2.istroop = paramInt1;
      paramString2.extraflag = 3;
      paramString2.time = MessageCache.a();
      localQQMessageFacade.a(paramString2, str1);
      if ((paramInt2 == 2) || (paramInt2 == 24))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "0", "", "", "");
        return;
      }
    } while (paramInt2 != 0);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "0", "", "", "");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "showGuideBar uinType: " + paramInt1 + ", msgType: " + paramInt2 + ", isVideoMsg: " + paramBoolean + ", friendUin: " + paramString1 + ", selfUin: " + paramString2 + ", videoTime: " + paramString3 + ", msgStr: " + paramString4);
    }
    if (1008 == paramInt1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "public account should not show guide bar.");
      }
      return;
    }
    ThreadManager.executeOnSubThread(new kid(paramInt2, paramQQAppInterface, paramBoolean, paramString3, paramString2, paramString1));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addLightalkMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", isVideoMsg = " + paramBoolean1 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", isSender = " + paramBoolean2 + ", extra = " + paramString3 + ", isRead = " + paramBoolean3);
    }
    paramQQAppInterface.a();
    paramString3 = TransfileUtile.a(a(paramQQAppInterface.getApp(), paramInt2, paramInt1, paramBoolean2, paramString3), paramInt2, 3, paramBoolean1);
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramString2 = MessageRecordFactory.a(-2026);
    paramString2.selfuin = str;
    paramString2.frienduin = paramString1;
    paramString2.senderuin = str;
    paramString2.msg = paramString3;
    paramString2.msgtype = -2026;
    paramString2.isread = false;
    paramString2.issend = 0;
    paramString2.extraflag = 3;
    paramString2.time = MessageCache.a();
    if (paramInt1 == 26)
    {
      paramString2.istroop = paramInt1;
      if (!paramBoolean2) {
        break label306;
      }
      paramString2.issend = 1;
      label230:
      if ((paramQQAppInterface.isAppOnForeground(paramQQAppInterface.getApp())) && (!QQUtils.a(paramQQAppInterface.getApp()))) {
        break label315;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "background");
      }
    }
    for (;;)
    {
      paramQQAppInterface = (QCallFacade)paramQQAppInterface.getManager(37);
      paramQQAppInterface.a((MessageForVideo)paramString2, false);
      paramQQAppInterface.a((MessageForVideo)paramString2);
      return;
      paramString2.istroop = 8;
      break;
      label306:
      paramString2.issend = 0;
      break label230;
      label315:
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "foreground");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3, int paramInt3, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addVideoMsgWithAvtype uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", isVideoMsg = " + paramBoolean1 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", isSender = " + paramBoolean2 + ", extra = " + paramString3 + ", isRead = " + paramBoolean3 + ", avtype = " + paramInt3);
    }
    if (paramInt1 == 2) {
      a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!paramString1.equals(paramQQAppInterface.getCurrentAccountUin()))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("VideoMsgTools", 2, "friendUin & senderUin can't empty!");
        return;
      } while ((paramInt1 == 1011) || (paramInt1 == -1));
      if (paramInt1 != 10003) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoMsgTools", 2, "uinType is nearbyVideo, return");
    return;
    if (paramInt1 == 1000)
    {
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
      if ((localTroopManager != null) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString2 = localTroopManager.a(paramString2);
        if (paramString2 != null) {
          paramString2 = paramString2.troopcode;
        }
      }
    }
    for (;;)
    {
      if (((paramQQAppInterface.a().e() == 1) || (paramQQAppInterface.a().e() == 2)) && ((paramInt2 == 15) || (paramInt2 == 9))) {
        if ((paramQQAppInterface.a().e() != 2) || (paramInt2 != 15)) {
          break label501;
        }
      }
      label501:
      for (boolean bool = true;; bool = paramBoolean1)
      {
        b(paramQQAppInterface, paramInt1, paramInt2, bool, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
        new Handler().postDelayed(new kib(paramInt2, paramQQAppInterface, paramInt1, paramBoolean1, paramString1, paramString3, paramString2, paramInt3, paramVarArgs), 500L);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("VideoMsgTools", 2, "can't find troop info!");
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("VideoMsgTools", 2, "can't get friend manager!");
        return;
        if (a(paramInt2))
        {
          if (b(paramInt2))
          {
            a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramBoolean2, paramBoolean3, paramInt3, paramVarArgs);
            return;
          }
          b(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
          return;
        }
        if (b(paramInt2))
        {
          b(paramQQAppInterface, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3, paramVarArgs);
          return;
        }
        a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString3);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3, Object... paramVarArgs)
  {
    QLog.d("VideoMsgTools", 1, "addVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", isVideoMsg = " + paramBoolean1 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", isSender = " + paramBoolean2 + ", extra = " + paramString3 + ", isRead = " + paramBoolean3);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramString1.equals(paramQQAppInterface.getCurrentAccountUin()))) {
      if (QLog.isColorLevel()) {
        QLog.e("VideoMsgTools", 2, "friendUin & senderUin can't empty!");
      }
    }
    label141:
    do
    {
      break label141;
      do
      {
        return;
      } while ((paramInt1 == 1011) || (paramInt1 == -1));
      if (paramInt1 != 10003) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoMsgTools", 2, "uinType is nearbyVideo, return");
    return;
    if (paramInt1 == 1000)
    {
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
      if ((localTroopManager != null) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString2 = localTroopManager.a(paramString2);
        if (paramString2 != null) {
          paramString2 = paramString2.troopcode;
        }
      }
    }
    for (;;)
    {
      if (a(paramInt2))
      {
        if (b(paramInt2))
        {
          a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramBoolean2, paramBoolean3, 0, paramVarArgs);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("VideoMsgTools", 2, "can't find troop info!");
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("VideoMsgTools", 2, "can't get friend manager!");
          return;
        }
        b(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
        return;
      }
      if (b(paramInt2))
      {
        b(paramQQAppInterface, paramInt1, paramInt2, paramString1, paramString2, paramString3, 0, paramVarArgs);
        return;
      }
      a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString3);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addPstnMsg uinType:" + paramInt + ", friendUin:" + paramString1 + ", senderUin:" + paramString2 + ", isPstn:" + paramBoolean + ", callId:" + paramString3);
    }
    paramQQAppInterface.a();
    String str1 = TransfileUtile.a(a(paramQQAppInterface.getApp(), 59, paramInt, true, "0"), 59, 3, false);
    String str2 = paramQQAppInterface.getCurrentAccountUin();
    paramString2 = MessageRecordFactory.a(-2046);
    paramString2.selfuin = str2;
    paramString2.frienduin = paramString1;
    paramString2.senderuin = str2;
    paramString2.msg = str1;
    paramString2.msgtype = -2046;
    paramString2.isread = true;
    paramString2.issend = 1;
    paramString2.istroop = paramInt;
    paramString2.extraflag = 3;
    paramString2.time = MessageCache.a();
    paramString1 = (QCallFacade)paramQQAppInterface.getManager(37);
    paramQQAppInterface = (PstnManager)paramQQAppInterface.getManager(142);
    try
    {
      paramString1.a((MessageForVideo)paramString2, false);
      paramQQAppInterface.a(paramString3, paramString2);
      paramString1.a((MessageForVideo)paramString2);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.i("VideoMsgTools", 2, "insert pstn record exception:" + paramQQAppInterface);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addMultiVideoMsg uinType = " + paramInt1 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2);
    }
    String str2 = paramQQAppInterface.getCurrentAccountUin();
    AVNotifyCenter localAVNotifyCenter = paramQQAppInterface.a();
    int i = localAVNotifyCenter.b(Long.valueOf(paramString1).longValue());
    if (paramInt2 != 0) {
      i = paramInt2;
    }
    if (paramInt1 == 3000) {}
    for (paramInt2 = 1;; paramInt2 = i)
    {
      if (!a.containsKey(paramString1 + String.valueOf(paramInt2))) {
        a.put(paramString1 + String.valueOf(paramInt2), "add");
      }
      if ((TextUtils.isEmpty(paramString1)) || (paramString1.length() <= 2)) {
        return;
      }
      String str1;
      if (paramInt1 == 3000) {
        str1 = paramQQAppInterface.getApp().getString(2131428989);
      }
      for (;;)
      {
        label197:
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramVarArgs != null)
        {
          localObject1 = localObject2;
          if (paramVarArgs.length > 0)
          {
            localObject1 = localObject2;
            if (paramVarArgs[0] != null)
            {
              localObject1 = localObject2;
              if ((paramVarArgs[0] instanceof msg_comm.Msg)) {
                localObject1 = (msg_comm.Msg)paramVarArgs[0];
              }
            }
          }
        }
        long l = 0L;
        if (localObject1 != null) {
          l = ((msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get()).msg_time.get();
        }
        paramVarArgs = TransfileUtile.a(str1, 13L, 3, true);
        localObject1 = MessageRecordFactory.a(-2016);
        ((MessageRecord)localObject1).selfuin = str2;
        ((MessageRecord)localObject1).frienduin = paramString1;
        ((MessageRecord)localObject1).senderuin = paramString2;
        ((MessageRecord)localObject1).msg = (paramVarArgs + "|" + paramInt2);
        ((MessageRecord)localObject1).msgtype = -2016;
        ((MessageRecord)localObject1).isread = paramBoolean2;
        if (paramInt1 == 3000) {
          ((MessageRecord)localObject1).isread = true;
        }
        if (paramBoolean1)
        {
          ((MessageRecord)localObject1).issend = 1;
          label390:
          ((MessageRecord)localObject1).istroop = paramInt1;
          ((MessageRecord)localObject1).extraflag = 3;
          if (localAVNotifyCenter != null) {
            ((MessageRecord)localObject1).extInt = paramInt2;
          }
          if (l <= 0L) {
            break label513;
          }
        }
        label513:
        for (((MessageRecord)localObject1).time = l;; ((MessageRecord)localObject1).time = MessageCache.a())
        {
          paramQQAppInterface.a().a((MessageRecord)localObject1, paramBoolean2);
          if (TextUtils.isEmpty(str1)) {
            break;
          }
          CUOpenCardGuideMng.a(paramQQAppInterface, ((MessageRecord)localObject1).frienduin, paramInt1, true, "qav");
          return;
          if (paramInt1 != 1) {
            break label524;
          }
          if (paramInt2 == 10)
          {
            str1 = paramQQAppInterface.getApp().getString(2131428991);
            break label197;
          }
          str1 = paramQQAppInterface.getApp().getString(2131428990);
          break label197;
          ((MessageRecord)localObject1).issend = 0;
          break label390;
        }
        label524:
        str1 = null;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    switch (paramInt)
    {
    case 1006: 
    default: 
      return;
    }
    paramQQAppInterface.o(paramString1, paramArrayOfByte);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = (QCallFacade)paramQQAppInterface.getManager(37);
    try
    {
      paramQQAppInterface.b((MessageForVideo)paramMessageRecord);
      paramQQAppInterface.a((MessageForVideo)paramMessageRecord);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.i("VideoMsgTools", 2, "update pstn record exception = " + paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    QLog.w("VideoMsgTools", 1, "openMeetingMember, discussUin[" + paramString + "]");
    Intent localIntent = new Intent(paramQQAppInterface.getApplication(), GAudioMembersCtrlActivity.class);
    localIntent.putExtra("discussUin", paramString);
    localIntent.addFlags(268435456);
    paramQQAppInterface.getApplication().startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "send_struct_massage_upgrade.peerUin = " + paramString + ", type = " + paramInt);
    }
    Object localObject = SharedPreUtils.c(paramQQAppInterface.getCurrentAccountUin());
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoMsgTools", 2, "configXML : " + (String)localObject);
      }
      if (localObject == null) {
        break label178;
      }
      localObject = TestStructMsg.a((String)localObject);
      if (localObject == null) {
        break;
      }
      ShareMsgHelper.a(paramQQAppInterface, paramString, 0, (AbsStructMsg)localObject, null);
      return;
      localObject = ((SharedPreferences)localObject).getString("qav_upgrade_invite_video", null);
      continue;
      localObject = ((SharedPreferences)localObject).getString("qav_upgrade_invite_multi", null);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoMsgTools", 2, "absMsg is null! use default");
    }
    b(paramQQAppInterface, paramString, paramInt);
    return;
    label178:
    if (QLog.isColorLevel()) {
      QLog.i("VideoMsgTools", 2, "configXML is null! use default");
    }
    b(paramQQAppInterface, paramString, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addDiscussMember discussUin = " + paramString);
    }
    ArrayList localArrayList2 = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1;
    if (localArrayList2 != null)
    {
      int j = localArrayList2.size();
      int i = 0;
      while (i < j)
      {
        localObject1 = (DiscussionMemberInfo)localArrayList2.get(i);
        if (localObject1 != null) {
          localArrayList1.add(((DiscussionMemberInfo)localObject1).memberUin);
        }
        i += 1;
      }
    }
    if (((PstnManager)paramQQAppInterface.getManager(142)).a() == 1)
    {
      localArrayList2 = new ArrayList();
      if (paramArrayList1 != null)
      {
        localObject1 = (PhoneContactManager)paramQQAppInterface.getManager(10);
        if (localObject1 != null)
        {
          paramArrayList1 = paramArrayList1.iterator();
          while (paramArrayList1.hasNext())
          {
            Object localObject2 = (Long)paramArrayList1.next();
            localObject2 = ((PhoneContactManager)localObject1).a(localObject2 + "");
            if (localObject2 != null) {
              localArrayList2.add(((PhoneContact)localObject2).mobileNo);
            }
          }
        }
      }
      if (paramArrayList2 != null) {
        localArrayList2.addAll(paramArrayList2);
      }
      paramArrayList1 = new Intent(paramQQAppInterface.getApplication(), PhoneContactSelectActivity.class);
      paramArrayList1.putStringArrayListExtra("param_uins_selected_default", localArrayList1);
      if (paramArrayList3 != null) {
        paramArrayList1.putStringArrayListExtra("param_uin_selected_default_contact", paramArrayList3);
      }
      paramArrayList1.putExtra("param_groupcode", paramString);
      paramArrayList1.putExtra("param_type", 3000);
      paramArrayList1.putExtra("param_subtype", 1);
      paramArrayList1.putExtra("param_entrance", 19);
      paramArrayList1.putExtra("param_max", 100 - localArrayList1.size());
      paramArrayList1.putExtra("param_ui_flag", paramInt);
      paramArrayList1.putExtra("param_uin_divider_list", localArrayList2);
      paramArrayList1.putExtra("param_divider_title", paramQQAppInterface.getApp().getString(2131438365));
      paramArrayList1.putExtra("param_no_answer_list_default_selected", paramBoolean);
      paramArrayList1.addFlags(268435456);
      paramArrayList1.putExtra("sendToVideo", true);
      paramArrayList1.putExtra("ShowJoinDiscTips", true);
      paramArrayList1.putExtra("param_title", paramQQAppInterface.getApplication().getString(2131438369));
      paramArrayList1.putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131435075));
      paramArrayList1.putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131435994));
      paramQQAppInterface.getApplication().startActivity(paramArrayList1);
      return;
    }
    paramArrayList1 = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    paramArrayList1.putStringArrayListExtra("param_uins_selected_default", localArrayList1);
    paramArrayList1.putExtra("param_groupcode", paramString);
    paramArrayList1.putExtra("param_type", 3000);
    paramArrayList1.putExtra("param_subtype", 1);
    paramArrayList1.putExtra("param_entrance", 11);
    paramArrayList1.putExtra("param_max", 100 - localArrayList1.size());
    paramArrayList1.addFlags(268435456);
    paramArrayList1.putExtra("sendToVideo", true);
    paramArrayList1.putExtra("ShowJoinDiscTips", true);
    paramArrayList1.putExtra("param_title", paramQQAppInterface.getApplication().getString(2131428951));
    paramArrayList1.putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131435075));
    paramArrayList1.putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131435994));
    paramQQAppInterface.getApplication().startActivity(paramArrayList1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, INetEngine.INetEngineListener paramINetEngineListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "sendHttpReq requestUrl  = " + paramString1 + ", actid = " + paramString2);
    }
    if (paramQQAppInterface == null) {
      return;
    }
    long l2 = 0L;
    Object localObject2 = "";
    String str2 = "";
    try
    {
      String str3 = new URL(paramString1).getHost();
      String str1 = str2;
      Object localObject1 = localObject2;
      long l1 = l2;
      if (!TextUtils.isEmpty(str3))
      {
        str1 = str2;
        localObject1 = localObject2;
        l1 = l2;
        if (str3.endsWith(".qq.com"))
        {
          localObject1 = (TicketManager)paramQQAppInterface.getManager(2);
          str1 = paramQQAppInterface.getAccount();
          localObject1 = ((TicketManager)localObject1).getSkey(str1);
          l1 = a((String)localObject1);
        }
      }
      localObject2 = new HttpNetReq();
      ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = paramINetEngineListener;
      ((HttpNetReq)localObject2).jdField_a_of_type_Int = 0;
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaIoOutputStream = new PoolingByteArrayOutputStream(ByteArrayPool.getMaxBufInstance(), 153600);
      paramINetEngineListener = paramString3;
      if (paramString3 == null) {
        paramINetEngineListener = "";
      }
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangString = (paramString1 + "g_tk=" + l1 + "&actid=" + paramString2 + "&mp_ext_params=" + URLUtil.a(paramINetEngineListener));
      if (QLog.isColorLevel()) {
        QLog.i("VideoMsgTools", 2, "req.mReqUrl=" + ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangString);
      }
      ((HttpNetReq)localObject2).o = true;
      ((HttpNetReq)localObject2).c = 30000L;
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Connection", "Keep-Alive");
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Cookie", String.format("uin=o%s; skey=%s;", new Object[] { str1, localObject1 }));
      paramQQAppInterface.getNetEngine(0).a((NetReq)localObject2);
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoMsgTools", 2, "sendHttpReq : ", paramQQAppInterface);
      }
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = QAVGroupConfig.a(paramQQAppInterface, paramString1);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramQQAppInterface.getCurrentAccountUin());
    int j = i - localArrayList.size();
    QLog.w("VideoMsgTools", 1, "addMembersToNewGroupAndStartMulAudioChat, groupUin[" + paramString1 + "], gruopName[" + paramString2 + "], bVideo[" + paramBoolean + "], maxSelectNum[" + i + "], leftSelectNum[" + j + "], defaultSelectNum[" + localArrayList.size() + "]");
    Intent localIntent = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    Resources localResources = paramQQAppInterface.getApplication().getResources();
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_max", j);
    localIntent.putExtra("group_uin", paramString1);
    localIntent.putExtra("group_name", paramString2);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_entrance", 13);
    localIntent.addFlags(268435456);
    localIntent.putExtra("param_title", localResources.getString(2131429500));
    localIntent.putExtra("param_done_button_wording", localResources.getString(2131429498));
    localIntent.putExtra("param_done_button_highlight_wording", localResources.getString(2131429499));
    localIntent.putExtra("param_only_troop_member", true);
    localIntent.putExtra("isVideo", paramBoolean);
    localIntent.putExtra("result_receiver", new VideoMsgTools.4(new Handler(), paramBoolean, paramQQAppInterface));
    paramQQAppInterface.getApplication().startActivity(localIntent);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 24) || (paramInt == 3) || (paramInt == 7) || (paramInt == 10) || (paramInt == 12) || (paramInt == 42) || (paramInt == 43) || (paramInt == 13) || (paramInt == 47) || (paramInt == 48) || (paramInt == 49) || (paramInt == 53) || (paramInt == 6) || (paramInt == 9);
  }
  
  public static boolean a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramRedTypeInfo != null)
    {
      bool1 = bool2;
      if (paramRedTypeInfo.red_type.get() == 0) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "isPstnRedTouchShow showRedDot  = " + bool1);
    }
    return bool1;
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    Object localObject = paramQQAppInterface.a();
    switch (paramInt)
    {
    default: 
      paramQQAppInterface = null;
    }
    label501:
    for (;;)
    {
      if (paramQQAppInterface != null)
      {
        paramInt = 0;
        for (;;)
        {
          if (paramInt < paramQQAppInterface.length)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoMsgTools", 2, "sig[" + paramInt + "]:" + (paramQQAppInterface[paramInt] & 0xFF));
            }
            paramInt += 1;
            continue;
            byte[] arrayOfByte = new byte[3];
            tmp148_146 = arrayOfByte;
            tmp148_146[0] = 1;
            tmp154_148 = tmp148_146;
            tmp154_148[1] = 1;
            tmp160_154 = tmp154_148;
            tmp160_154[2] = 124;
            tmp160_154;
            localObject = ((MessageCache)localObject).m(paramString);
            int i = arrayOfByte.length;
            paramInt = i;
            if (localObject != null) {
              paramInt = i + localObject.length;
            }
            paramString = new byte[paramInt];
            System.arraycopy(arrayOfByte, 0, paramString, 0, arrayOfByte.length);
            paramQQAppInterface = paramString;
            if (localObject == null) {
              break label501;
            }
            System.arraycopy(localObject, 0, paramString, arrayOfByte.length, localObject.length);
            paramQQAppInterface = paramString;
            break;
            arrayOfByte = new byte[3];
            tmp239_237 = arrayOfByte;
            tmp239_237[0] = 1;
            tmp245_239 = tmp239_237;
            tmp245_239[1] = 1;
            tmp251_245 = tmp245_239;
            tmp251_245[2] = -107;
            tmp251_245;
            localObject = ((MessageCache)localObject).k(paramString);
            i = arrayOfByte.length;
            paramInt = i;
            if (localObject != null) {
              paramInt = i + localObject.length;
            }
            paramString = new byte[paramInt];
            System.arraycopy(arrayOfByte, 0, paramString, 0, arrayOfByte.length);
            paramQQAppInterface = paramString;
            if (localObject == null) {
              break label501;
            }
            System.arraycopy(localObject, 0, paramString, arrayOfByte.length, localObject.length);
            paramQQAppInterface = paramString;
            break;
            paramQQAppInterface = null;
            break;
            paramQQAppInterface = ((MessageCache)localObject).h(paramString);
            break;
            arrayOfByte = new byte[3];
            tmp345_343 = arrayOfByte;
            tmp345_343[0] = 1;
            tmp351_345 = tmp345_343;
            tmp351_345[1] = 1;
            tmp357_351 = tmp351_345;
            tmp357_351[2] = 58;
            tmp357_351;
            localObject = paramQQAppInterface.a().d(paramString);
            i = arrayOfByte.length;
            paramInt = i;
            if (localObject != null) {
              paramInt = i + localObject.length;
            }
            paramString = new byte[paramInt];
            System.arraycopy(arrayOfByte, 0, paramString, 0, arrayOfByte.length);
            paramQQAppInterface = paramString;
            if (localObject == null) {
              break label501;
            }
            System.arraycopy(localObject, 0, paramString, arrayOfByte.length, localObject.length);
            paramQQAppInterface = paramString;
            break;
            paramString = ((MessageCache)localObject).q(paramString);
            if (paramString != null)
            {
              paramQQAppInterface = new byte[paramString.length + 3];
              paramQQAppInterface[0] = 1;
              paramQQAppInterface[1] = 1;
              paramQQAppInterface[2] = -119;
              System.arraycopy(paramString, 0, paramQQAppInterface, 3, paramString.length);
              break;
            }
            paramQQAppInterface = new byte[] { 1, 1, -119 };
            break;
          }
        }
      }
      return paramQQAppInterface;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, Object... paramVarArgs)
  {
    if (paramString1 != null) {}
    for (long l = Long.valueOf(paramString1).longValue();; l = 0L)
    {
      int j = paramQQAppInterface.a().b(l);
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "addTipsMultiVideoMsg msgType = " + paramInt2 + ", discussionUin = " + paramString1 + ", memberUin = " + paramString2 + ", uinType = " + paramInt1 + ", extra = " + paramString3 + ", avtype = " + j);
      }
      int i = j;
      if (paramVarArgs != null)
      {
        i = j;
        if (paramVarArgs.length > 0)
        {
          i = j;
          if (paramVarArgs[0] != null)
          {
            i = j;
            if ((paramVarArgs[0] instanceof Integer)) {
              i = ((Integer)paramVarArgs[0]).intValue();
            }
          }
        }
      }
      if (paramInt3 != 0) {
        i = paramInt3;
      }
      if (paramInt1 == 3000) {
        i = 1;
      }
      String str = paramQQAppInterface.getCurrentAccountUin();
      QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
      if (localQQMessageFacade != null)
      {
        paramVarArgs = null;
        switch (paramInt2)
        {
        default: 
          if (paramInt1 == 3000)
          {
            paramString2 = paramQQAppInterface.getApp().getString(2131428993);
            if ((59 == paramInt2) || (paramInt2 == 60) || (i != 2) || (paramString2 == null)) {
              break label1169;
            }
          }
          break;
        }
      }
      label1169:
      for (paramQQAppInterface = paramString2.replace(paramQQAppInterface.getApp().getString(2131433813), paramQQAppInterface.getApp().getString(2131433815));; paramQQAppInterface = paramString2)
      {
        paramString2 = MessageRecordFactory.a(-4008);
        paramString2.selfuin = str;
        paramString2.frienduin = paramString1;
        paramString2.senderuin = str;
        paramString2.msg = paramQQAppInterface;
        paramString2.msgtype = -4008;
        paramString2.isread = true;
        paramString2.issend = 1;
        paramString2.istroop = paramInt1;
        paramString2.extraflag = 3;
        paramString2.time = MessageCache.a();
        paramQQAppInterface = new ArrayList();
        paramQQAppInterface.add(paramString2);
        localQQMessageFacade.c(paramQQAppInterface, str);
        do
        {
          return;
          if (str.equals(paramString2))
          {
            if (paramInt1 == 3000)
            {
              paramString2 = paramQQAppInterface.getApp().getString(2131428987);
              break;
            }
            paramString2 = paramVarArgs;
            if (paramInt1 != 1) {
              break;
            }
            paramString2 = paramQQAppInterface.getApp().getString(2131428988);
            break;
          }
          paramString3 = ContactUtils.c(paramQQAppInterface, paramString1, paramString2);
          if (paramInt1 == 3000)
          {
            paramString2 = paramString3 + paramQQAppInterface.getApp().getString(2131428989);
            break;
          }
          paramString2 = paramVarArgs;
          if (paramInt1 != 1) {
            break;
          }
          paramString2 = paramString3 + paramQQAppInterface.getApp().getString(2131428990);
          break;
          paramQQAppInterface.a().a(l, 0);
        } while (!a.containsKey(paramString1 + String.valueOf(i)));
        a.remove(paramString1 + String.valueOf(i));
        if (paramInt1 == 3000)
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131428993);
          break;
        }
        paramString2 = paramVarArgs;
        if (paramInt1 != 1) {
          break;
        }
        paramString2 = paramQQAppInterface.getApp().getString(2131428994);
        break;
        paramQQAppInterface.a().a(l, 0);
        paramString2 = paramQQAppInterface.getApp().getString(2131428995);
        break;
        paramQQAppInterface.a().a(l, 0);
        if (paramInt1 == 3000)
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131428996);
          break;
        }
        if (paramInt1 == 1)
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131428997);
          break;
        }
        paramString2 = paramQQAppInterface.getApp().getString(2131428998);
        break;
        paramQQAppInterface.a().a(l, 0);
        if (paramInt1 == 3000)
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131428999);
          break;
        }
        paramString2 = paramVarArgs;
        if (paramInt1 != 1) {
          break;
        }
        paramString2 = paramQQAppInterface.getApp().getString(2131429000);
        break;
        paramQQAppInterface.a().a(l, 0);
        if (paramInt1 == 3000)
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131429001);
          break;
        }
        paramString2 = paramVarArgs;
        if (paramInt1 != 1) {
          break;
        }
        paramInt3 = 0;
        if (paramString3 != null) {
          paramInt3 = Integer.parseInt(paramString3);
        }
        if (paramInt3 == 19)
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131429003);
          break;
        }
        paramString2 = paramQQAppInterface.getApp().getString(2131429002);
        break;
        paramQQAppInterface.a().a(l, 0);
        if (paramInt1 == 3000)
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131429005);
          break;
        }
        paramString2 = paramVarArgs;
        if (paramInt1 != 1) {
          break;
        }
        paramString2 = paramQQAppInterface.getApp().getString(2131429006);
        break;
        if (paramInt1 == 3000)
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131429004);
          break;
        }
        paramString2 = paramVarArgs;
        if (paramInt1 != 1) {
          break;
        }
        paramString2 = paramQQAppInterface.getApp().getString(2131429004);
        break;
        paramString2 = paramQQAppInterface.getApp().getString(2131428846) + paramString3;
        break;
        paramString2 = paramQQAppInterface.getApp().getString(2131429110);
        break;
        paramString2 = paramQQAppInterface.getApp().getString(2131429111);
        break;
        paramString2 = paramVarArgs;
        if (paramInt1 != 1) {
          break;
        }
        paramString2 = paramQQAppInterface.getApp().getString(2131428994);
        break;
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3, Object... paramVarArgs)
  {
    QLog.d("VideoMsgTools", 1, "addBubbleVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", isSender = " + paramBoolean2 + ", time = " + paramString3 + ", isRead = " + paramBoolean3);
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    String str2 = a(paramQQAppInterface.getApp(), paramInt2, paramInt1, paramBoolean2, paramString3);
    String str3 = TransfileUtile.a(str2, paramInt2, 3, paramBoolean1);
    if (paramInt1 == 9500)
    {
      ((DeviceMsgHandle)paramQQAppInterface.a(49)).a(paramString1, str2, MessageCache.a(), false, false, true);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof msg_comm.Msg))) {}
    for (paramVarArgs = (msg_comm.Msg)paramVarArgs[0];; paramVarArgs = null)
    {
      if (paramVarArgs != null) {}
      for (long l1 = ((msg_comm.MsgHead)paramVarArgs.msg_head.get()).msg_time.get();; l1 = 0L)
      {
        if (TextUtils.isEmpty(paramString2)) {
          break label607;
        }
        paramVarArgs = MessageRecordFactory.a(-2009);
        paramVarArgs.selfuin = str1;
        paramVarArgs.frienduin = paramString1;
        paramVarArgs.senderuin = paramString2;
        paramVarArgs.msg = str3;
        paramVarArgs.msgtype = -2009;
        if (paramString2.equals(paramString1)) {
          paramBoolean2 = false;
        }
        paramVarArgs.isread = paramBoolean3;
        if ((paramInt1 == 0) || (paramInt1 == 1000) || (paramInt1 == 1004) || (paramInt1 == 1006) || (paramInt1 == 1021) || (paramInt1 == 1010) || (paramInt1 == 1001) || (paramInt1 == 10002)) {
          paramVarArgs.isread = true;
        }
        label354:
        long l3;
        if (paramBoolean2)
        {
          paramVarArgs.issend = 1;
          paramVarArgs.istroop = paramInt1;
          paramVarArgs.extraflag = 3;
          paramString2 = (QCallFacade)paramQQAppInterface.getManager(37);
          if (paramString2 == null) {
            break label597;
          }
          paramString2 = paramString2.a().a(paramString1, paramInt1);
          if (paramString2 == null) {
            break label597;
          }
          l3 = paramString2.lastCallTime;
          l2 = l3;
          if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, "VideoMsgTools updateDoubleCallStatus lastCallTime = " + paramString2.lastCallTime);
          }
        }
        label597:
        for (long l2 = l3;; l2 = 0L)
        {
          if (l1 > 0L) {
            paramVarArgs.time = l1;
          }
          for (;;)
          {
            ThreadManager.executeOnSubThread(new kic(paramQQAppInterface, paramVarArgs, paramBoolean3, str1, str2, paramInt1, paramBoolean1));
            a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, str1, paramString3, str3);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("VideoMsgTools", 2, "addBubbleVideoMsg end");
            return;
            paramVarArgs.issend = 0;
            break label354;
            if (str2.equals(paramQQAppInterface.getApp().getString(2131428839))) {
              paramVarArgs.time = MessageCache.a();
            } else if ((l2 > 0L) && (paramInt2 != 7)) {
              paramVarArgs.time = l2;
            } else {
              paramVarArgs.time = (MessageCache.a() - paramQQAppInterface.a().d());
            }
          }
        }
      }
      label607:
      break;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = ((PstnManager)paramQQAppInterface.getManager(142)).a();
    QLog.w("VideoMsgTools", 1, "addDiscussMemberFromC2C, peerUin[" + paramString + "], pstnGrayFlag[" + i + "]");
    if (i == 1)
    {
      localIntent = new Intent(paramQQAppInterface.getApplication(), PhoneContactSelectActivity.class);
      localIntent.putExtra("param_type", 3000);
      localIntent.putExtra("param_subtype", 0);
      localIntent.putExtra("param_from", 1001);
      localIntent.putExtra("param_entrance", 20);
      localIntent.putExtra("param_ui_flag", 0);
      localArrayList = new ArrayList();
      localArrayList.add(paramString);
      localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
      localIntent.putExtra("param_add_passed_members_to_result_set", true);
      localIntent.putExtra("param_max", 100 - localArrayList.size() - 1);
      localIntent.addFlags(268435456);
      localIntent.putExtra("sendToVideo", true);
      localIntent.putExtra("ShowJoinDiscTips", true);
      localIntent.putExtra("param_title", paramQQAppInterface.getApplication().getString(2131428951));
      localIntent.putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131435075));
      localIntent.putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131435994));
      paramQQAppInterface.getApplication().startActivity(localIntent);
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1001);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_add_passed_members_to_result_set", true);
    localIntent.putExtra("param_max", 100 - localArrayList.size() - 1);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sendToVideo", true);
    localIntent.putExtra("ShowJoinDiscTips", true);
    localIntent.putExtra("param_title", paramQQAppInterface.getApplication().getString(2131428951));
    localIntent.putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131435075));
    localIntent.putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131435994));
    paramQQAppInterface.getApplication().startActivity(localIntent);
  }
  
  static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str1 = paramQQAppInterface.getApp().getApplicationContext().getString(2131429461);
    Object localObject = paramQQAppInterface.getApp().getApplicationContext().getString(2131429460);
    localObject = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(62).a((String)localObject).c("https://im.qq.com/mobileqq/touch").a(str1, null).a();
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    str1 = paramQQAppInterface.getApp().getApplicationContext().getString(2131429458);
    String str2 = paramQQAppInterface.getApp().getApplicationContext().getString(2131429455);
    if (paramInt == 1) {
      str1 = paramQQAppInterface.getApp().getApplicationContext().getString(2131429459);
    }
    localAbsStructMsgItem.a("http://url.cn/hw298C", str2, str1);
    ((AbsShareMsg)localObject).addItem(localAbsStructMsgItem);
    ShareMsgHelper.a(paramQQAppInterface, paramString, 0, (AbsStructMsg)localObject, null);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 20) || (paramInt == 19) || (paramInt == 44) || (paramInt == 59) || (paramInt == 60) || (paramInt == 22);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l = AudioHelper.a();
    QLog.d("VideoMsgTools", 1, "addGroupMember_" + l + ", begin, uin[" + paramString + "]");
    paramQQAppInterface.addObserver(new kif(l, paramString, paramQQAppInterface));
    TroopHandler localTroopHandler = (TroopHandler)paramQQAppInterface.a(20);
    if (localTroopHandler != null) {
      localTroopHandler.a(true, paramString, ((TroopManager)paramQQAppInterface.getManager(51)).b(paramString).troopcode, true, 6, System.currentTimeMillis());
    }
    QAVGroupConfig.a("addGroupMember_" + l, paramQQAppInterface, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools
 * JD-Core Version:    0.7.0.1
 */