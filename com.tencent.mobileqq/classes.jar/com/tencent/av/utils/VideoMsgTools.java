package com.tencent.av.utils;

import ajhh;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import aric;
import aufl;
import aufp;
import awao;
import awbi;
import awqx;
import awui;
import awul;
import awum;
import awuv;
import awwg;
import axro;
import axrr;
import axrt;
import axsp;
import axwb;
import azzz;
import babh;
import baeg;
import baei;
import baic;
import baig;
import befm;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import krx;
import mgc;
import min;
import mjg;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import xvq;

public class VideoMsgTools
{
  static Map<String, String> a = new HashMap();
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString.contains(paramContext.getString(2131654857))) {
      return 2131101389;
    }
    if (paramBoolean) {
      return 2131101282;
    }
    return 2131101278;
  }
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2130841542;
    if (paramInt == 13) {
      if (paramBoolean1)
      {
        paramInt = i;
        if (paramBoolean2) {
          paramInt = 2130841543;
        }
      }
    }
    do
    {
      return paramInt;
      if (paramBoolean2) {
        return 2130841342;
      }
      return 2130841341;
      if (paramString.contains(paramContext.getString(2131654871)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130841693;
          }
          return 2130841692;
        }
        if (paramBoolean2) {
          return 2130841342;
        }
        return 2130841341;
      }
      if (paramString.contains(paramContext.getString(2131654853)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130841693;
          }
          return 2130841692;
        }
        if (paramBoolean2) {
          return 2130841342;
        }
        return 2130841341;
      }
      if (paramString.contains(paramContext.getString(2131654857)))
      {
        if (paramBoolean1) {
          return 2130841691;
        }
        return 2130841340;
      }
      if (paramString.contains(paramContext.getString(2131654860)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130841693;
          }
          return 2130841692;
        }
        if (paramBoolean2) {
          return 2130841342;
        }
        return 2130841341;
      }
      if (paramString.contains(paramContext.getString(2131654861)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130841693;
          }
          return 2130841692;
        }
        if (paramBoolean2) {
          return 2130841342;
        }
        return 2130841341;
      }
      if (paramString.contains(paramContext.getString(2131654859)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130841693;
          }
          return 2130841692;
        }
        if (paramBoolean2) {
          return 2130841342;
        }
        return 2130841341;
      }
      if (paramString.contains(paramContext.getString(2131654862)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130841693;
          }
          return 2130841692;
        }
        if (paramBoolean2) {
          return 2130841342;
        }
        return 2130841341;
      }
      if (!paramBoolean1) {
        break;
      }
      paramInt = i;
    } while (!paramBoolean2);
    return 2130841543;
    if (paramBoolean2) {
      return 2130841342;
    }
    return 2130841341;
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
    case 62: 
    case 63: 
      if (paramString != null)
      {
        paramContext = paramContext.getString(2131654871);
        return paramContext + " " + paramString;
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131654854);
      }
      return paramContext.getString(2131654853);
    case 2: 
    case 24: 
    case 47: 
      if (paramString != null)
      {
        paramContext = paramContext.getString(2131654871);
        return paramContext + " " + paramString;
      }
      if (paramBoolean)
      {
        if (paramInt2 == 9500) {
          return paramContext.getString(2131654854);
        }
        return paramContext.getString(2131654853);
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131654858);
      }
      return paramContext.getString(2131654857);
    case 1: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131654858);
      }
      return paramContext.getString(2131654857);
    case 3: 
      return paramContext.getString(2131654860);
    case 10: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131654858);
      }
      return paramContext.getString(2131654857);
    case 7: 
      return paramContext.getString(2131654861);
    case 12: 
      if (paramBoolean)
      {
        if (paramInt2 == 9500) {
          return paramContext.getString(2131654873);
        }
        return paramContext.getString(2131654872);
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131654858);
      }
      return paramContext.getString(2131654857);
    case 42: 
    case 43: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131654854);
      }
      return paramContext.getString(2131654853);
    case 49: 
      return paramContext.getString(2131654862);
    case 53: 
      return paramContext.getString(2131654855);
    }
    if (paramInt2 == 9500) {
      return paramContext.getString(2131654858);
    }
    return paramContext.getString(2131654857);
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.w("VideoMsgTools", 1, "openMeetingMember, discussUin[" + paramString + "]");
    Intent localIntent = new Intent(paramActivity, GAudioMembersCtrlActivity.class);
    localIntent.putExtra("discussUin", paramString);
    localIntent.putExtra("Owner", paramBoolean1);
    localIntent.putExtra("isInRoom", paramBoolean2);
    localIntent.putExtra("isFromMeeting", false);
    localIntent.addFlags(268435456);
    paramActivity.startActivity(localIntent);
  }
  
  static void a(BaseApplicationImpl paramBaseApplicationImpl, boolean paramBoolean, long paramLong, ArrayList<ResultRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "sendAddMemberResultBroadcastToVideo");
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((ResultRecord)paramArrayList.next()).jdField_a_of_type_JavaLangString);
    }
    paramArrayList = new Intent("tencent.video.q2v.AddDiscussMember");
    paramArrayList.setPackage(paramBaseApplicationImpl.getPackageName());
    paramArrayList.putExtra("result", paramBoolean);
    paramArrayList.putExtra("roomId", paramLong);
    paramArrayList.putStringArrayListExtra("newMemberUin", localArrayList);
    paramBaseApplicationImpl.sendBroadcast(paramArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2)
  {
    krx.d("VideoMsgTools", "addTipsVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", friendUin = " + paramString1 + ", extra=" + paramString2);
    if (paramInt1 == -1) {}
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
    case 65: 
    default: 
      paramString2 = paramQQAppInterface.getApp().getString(2131630099);
    }
    label1160:
    for (;;)
    {
      String str1 = paramQQAppInterface.getCurrentAccountUin();
      String str2 = axwb.a(paramString2, 0L, 3, paramBoolean);
      int i;
      if (paramInt1 == 9500)
      {
        ((xvq)paramQQAppInterface.a(49)).a(paramString1, paramString2, awao.a(), false, false, true);
        return;
        paramString2 = paramQQAppInterface.getApp().getString(2131654830);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131654882);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131654829);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131654881);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131654909);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131654844);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131654847);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131654898);
        continue;
        if (paramBoolean)
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131654843);
        }
        else
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131654841);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131654883);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131654839);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131654846);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131654910);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131654833);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131654828);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131654904);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131629986);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131654864) + paramString2;
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131630099);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131654863);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131654870);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131654868);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131654869);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131630062);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131630440);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131630316);
          awqx.b(null, "CliOper", "", "", "0X800A8D9", "0X800A8D9", 1, 0, "", "", "", "");
          continue;
          boolean bool = TextUtils.isEmpty(mjg.a(paramQQAppInterface, paramString1));
          paramString2 = paramQQAppInterface.getApp();
          if (bool) {}
          for (i = 2131654865;; i = 2131654866)
          {
            paramString2 = paramString2.getString(i);
            if (bool) {
              break label1160;
            }
            awqx.b(null, "CliOper", "", "", "0X800A8D9", "0X800A8D9", 2, 0, "", "", "", "");
            break;
          }
          paramString2 = paramQQAppInterface.getApp().getString(2131654856);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131654867);
        }
      }
      else
      {
        if (paramInt2 == 66)
        {
          i = 1;
          paramString2 = awbi.a(-1001);
          paramString2.selfuin = str1;
          paramString2.frienduin = paramString1;
          paramString2.senderuin = str1;
          paramString2.msg = str2;
          paramString2.msgtype = -1001;
          paramString2.isread = true;
          paramString2.issend = 0;
          paramString2.istroop = paramInt1;
          paramString2.extraflag = 3;
          paramString2.time = awao.a();
          if (i != 0) {
            break label1111;
          }
          localQQMessageFacade.a(paramString2, str1);
        }
        for (;;)
        {
          if ((paramInt2 != 2) && (paramInt2 != 24)) {
            break label1128;
          }
          awqx.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "0", "", "", "");
          return;
          i = 0;
          break;
          label1111:
          ThreadManager.executeOnSubThread(new VideoMsgTools.4(localQQMessageFacade, paramString2));
        }
        label1128:
        if (paramInt2 != 0) {
          break;
        }
        awqx.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "0", "", "", "");
        return;
      }
    }
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
    ThreadManager.executeOnSubThread(new VideoMsgTools.3(paramInt2, paramQQAppInterface, paramBoolean, paramString3, paramString2, paramString1));
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
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
      if ((localTroopManager != null) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString2 = localTroopManager.b(paramString2);
        if (paramString2 != null) {
          paramString2 = paramString2.troopcode;
        }
      }
    }
    for (;;)
    {
      if (((paramQQAppInterface.a().e() == 1) || (paramQQAppInterface.a().e() == 2)) && ((paramInt2 == 15) || (paramInt2 == 9) || (paramInt2 == 62) || (paramInt2 == 63))) {
        if ((paramQQAppInterface.a().e() != 2) || (paramInt2 != 15)) {
          break label514;
        }
      }
      label514:
      for (boolean bool = true;; bool = paramBoolean1)
      {
        b(paramQQAppInterface, paramInt1, paramInt2, bool, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
        new Handler().postDelayed(new VideoMsgTools.1(paramInt2, paramQQAppInterface, paramInt1, paramBoolean1, paramString1, paramString3, paramString2, paramInt3, paramVarArgs), 500L);
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
    label142:
    do
    {
      break label142;
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
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
      if ((localTroopManager != null) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString2 = localTroopManager.b(paramString2);
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
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, Object... paramVarArgs)
  {
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
      if ((TextUtils.isEmpty(paramString1)) || (paramString1.length() <= 2))
      {
        if (QLog.isColorLevel()) {
          QLog.w("VideoMsgTools", 1, "addMultiVideoMsg, err, uinType[" + paramInt1 + "], friendUin[" + paramString1 + "], senderUin[" + paramString2 + "]");
        }
        return;
      }
      String str1;
      if (paramInt1 == 3000) {
        str1 = paramQQAppInterface.getApp().getString(2131630176);
      }
      for (;;)
      {
        label204:
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
        paramVarArgs = axwb.a(str1, 13L, 3, true);
        localObject1 = awbi.a(-2016);
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
          label397:
          ((MessageRecord)localObject1).istroop = paramInt1;
          ((MessageRecord)localObject1).extraflag = 3;
          if (localAVNotifyCenter != null) {
            ((MessageRecord)localObject1).extInt = paramInt2;
          }
          if (l <= 0L) {
            break label591;
          }
        }
        label591:
        for (((MessageRecord)localObject1).time = l;; ((MessageRecord)localObject1).time = awao.a())
        {
          if (QLog.isColorLevel()) {
            QLog.w("VideoMsgTools", 1, "addMultiVideoMsg, uinType[" + paramInt1 + "], friendUin[" + paramString1 + "], senderUin[" + paramString2 + "], uniseq[" + ((MessageRecord)localObject1).uniseq + "]");
          }
          paramQQAppInterface.a().a((MessageRecord)localObject1, paramBoolean2);
          if (TextUtils.isEmpty(str1)) {
            break;
          }
          aric.a(paramQQAppInterface, ((MessageRecord)localObject1).frienduin, paramInt1, true, "qav");
          return;
          if (paramInt1 != 1) {
            break label602;
          }
          if (paramInt2 == 10)
          {
            str1 = paramQQAppInterface.getApp().getString(2131630195);
            break label204;
          }
          str1 = paramQQAppInterface.getApp().getString(2131630194);
          break label204;
          ((MessageRecord)localObject1).issend = 0;
          break label397;
        }
        label602:
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
    paramQQAppInterface.n(paramString1, paramArrayOfByte);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = baei.a();
    int j = baei.b();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramQQAppInterface.getCurrentAccountUin());
    j -= 1;
    i = Math.min(i - 1, j);
    boolean bool = baei.a(paramQQAppInterface, paramString1);
    QLog.w("VideoMsgTools", 1, "selectMemberToStartGAudioChat, uinType[" + paramInt + "], groupUin[" + paramString1 + "], gruopName[" + paramString2 + "], bVideo[" + paramBoolean + "], leftAutoSelectNum[" + i + "], leftMaxSelect[" + j + "], canShowInviteEntry[" + bool + "]");
    Resources localResources = paramQQAppInterface.getApplication().getResources();
    Intent localIntent = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_enable_all_select", true);
    localIntent.putExtra("param_all_select_max_num", i);
    localIntent.putExtra("param_max", j);
    localIntent.putExtra("group_uin", paramString1);
    localIntent.putExtra("group_name", paramString2);
    localIntent.putExtra("param_type", paramInt);
    localIntent.putExtra("param_subtype", 5);
    localIntent.putExtra("param_entrance", 35);
    localIntent.putExtra("param_title", localResources.getString(2131630172));
    localIntent.putExtra("param_done_button_wording", localResources.getString(2131630121));
    localIntent.putExtra("param_done_button_highlight_wording", localResources.getString(2131630123));
    localIntent.putExtra("show_invite_entry", bool);
    localIntent.putExtra("param_show_myself", false);
    if (paramInt == 1) {
      localIntent.putExtra("param_only_troop_member", true);
    }
    for (;;)
    {
      paramContext = new WeakReference(paramContext);
      localIntent.putExtra("PARAM_ActivityResultReceiver", new VideoMsgTools.7(new Handler(), paramBoolean, paramContext, paramInt, paramString1));
      b(paramQQAppInterface, paramQQAppInterface.getApp(), localIntent);
      return;
      localIntent.putExtra("param_only_discussion_member", true);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      AudioHelper.a("VideoMsgTools.addGroupMember", paramIntent.getExtras(), true);
    }
    String str = paramIntent.getStringExtra("uin");
    long l1 = paramIntent.getLongExtra("room_id", 0L);
    int i = paramIntent.getIntExtra("room_create_time", 0);
    ArrayList localArrayList1 = paramIntent.getParcelableArrayListExtra("memberlist");
    long l2 = min.a(paramIntent);
    paramIntent = new StringBuilder().append("addGroupMember begin, uin[").append(str).append("], roomID[").append(l1).append("], sTopActivity[");
    if (BaseActivity.sTopActivity != null) {}
    ArrayList localArrayList2;
    for (boolean bool = true;; bool = false)
    {
      QLog.w("VideoMsgTools", 1, bool + "], seq[" + l2 + "]");
      paramIntent = new Intent(paramContext, SelectMemberActivity.class);
      paramIntent.addFlags(268435456);
      localArrayList2 = new ArrayList(localArrayList1.size());
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (azzz.d(localResultRecord.jdField_a_of_type_JavaLangString)) {
          localArrayList2.add(localResultRecord.jdField_a_of_type_JavaLangString);
        }
      }
    }
    bool = baei.a(paramQQAppInterface, str);
    if (bool) {
      mgc.a();
    }
    int j = Math.max(baei.c() - localArrayList1.size(), 0);
    j = Math.min(baei.b(), j);
    paramIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList2);
    paramIntent.putExtra("room_create_time", i);
    paramIntent.putExtra("room_id", l1);
    paramIntent.putExtra("group_uin", str);
    paramIntent.putExtra("param_groupcode", str);
    paramIntent.putExtra("param_type", 1);
    paramIntent.putExtra("param_subtype", 1);
    paramIntent.putExtra("param_entrance", 11);
    paramIntent.putExtra("param_max", j);
    paramIntent.putExtra("show_invite_entry", bool);
    paramIntent.putExtra("param_donot_need_contacts", true);
    paramIntent.putExtra("param_title", paramContext.getString(2131630285));
    paramIntent.putExtra("group_name", paramContext.getString(2131630284));
    paramIntent.putExtra("param_done_button_wording", paramContext.getString(2131626068));
    paramIntent.putExtra("param_done_button_highlight_wording", paramContext.getString(2131626069));
    AudioHelper.a("VideoMsgToolsaddGroupMember", paramIntent.getExtras(), true);
    paramIntent.putExtra("PARAM_ActivityResultReceiver", new VideoMsgTools.8(new Handler(), l2, str));
    b(paramQQAppInterface, paramContext, paramIntent);
    QLog.w("VideoMsgTools", 1, "addGroupMember end, uin[" + str + "], seq[" + l2 + "]");
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
    long l = AudioHelper.b();
    int i = 48;
    if (paramInt == 1) {
      i = 8;
    }
    if (QLog.isColorLevel()) {
      QLog.w("double_2_multi", 1, "addMemberFromC2C, seq[" + l + "], peerUin[" + paramString + "], supportUinType[" + paramInt + "], max[" + i + "]");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramString = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    paramString.putExtra("param_type", paramInt);
    paramString.putExtra("param_subtype", 0);
    paramString.putExtra("param_from", 1001);
    paramString.putExtra("param_entrance", 36);
    paramString.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    paramString.putExtra("param_add_passed_members_to_result_set", true);
    paramString.putExtra("param_max", i);
    paramString.putExtra("param_donot_need_contacts", true);
    paramString.putExtra("param_title", paramQQAppInterface.getApplication().getString(2131630285));
    paramString.putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131626068));
    paramString.putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131626069));
    paramString.putExtra("PARAM_ActivityResultReceiver", new VideoMsgTools.6(new Handler(), l));
    paramString.addFlags(268435456);
    b(paramQQAppInterface, paramQQAppInterface.getApp(), paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, axrt paramaxrt)
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
      localObject2 = new axro();
      ((axro)localObject2).jdField_a_of_type_Axrt = paramaxrt;
      ((axro)localObject2).jdField_a_of_type_Int = 0;
      ((axro)localObject2).jdField_a_of_type_JavaIoOutputStream = new baeg(ByteArrayPool.getMaxBufInstance(), 153600);
      paramaxrt = paramString3;
      if (paramString3 == null) {
        paramaxrt = "";
      }
      ((axro)localObject2).jdField_a_of_type_JavaLangString = (paramString1 + "g_tk=" + l1 + "&actid=" + paramString2 + "&mp_ext_params=" + befm.a(paramaxrt));
      if (QLog.isColorLevel()) {
        QLog.i("VideoMsgTools", 2, "req.mReqUrl=" + ((axro)localObject2).jdField_a_of_type_JavaLangString);
      }
      ((axro)localObject2).o = true;
      ((axro)localObject2).c = 30000L;
      ((axro)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Connection", "Keep-Alive");
      ((axro)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Cookie", String.format("uin=o%s; skey=%s;", new Object[] { str1, localObject1 }));
      paramQQAppInterface.getNetEngine(0).a((axsp)localObject2);
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
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 24) || (paramInt == 3) || (paramInt == 7) || (paramInt == 10) || (paramInt == 12) || (paramInt == 42) || (paramInt == 43) || (paramInt == 13) || (paramInt == 47) || (paramInt == 48) || (paramInt == 49) || (paramInt == 53) || (paramInt == 6) || (paramInt == 9);
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
            localObject = ((awao)localObject).m(paramString);
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
            localObject = ((awao)localObject).k(paramString);
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
            paramQQAppInterface = ((awao)localObject).h(paramString);
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
            paramString = ((awao)localObject).p(paramString);
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
  
  private static void b(long paramLong1, BaseApplicationImpl paramBaseApplicationImpl, int paramInt, boolean paramBoolean, long paramLong2, ArrayList<ResultRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.w("double_2_multi", 2, "sendResultBroadcastToVideoBySwitch, seq[" + paramLong1 + "], roomId[" + paramLong2 + "], seq[" + paramLong1 + "], uinType[" + paramInt + "]");
    }
    Intent localIntent = new Intent("tencent.video.q2v.SwitchToMultiAudo");
    localIntent.setPackage(paramBaseApplicationImpl.getPackageName());
    localIntent.putExtra("result", paramBoolean);
    localIntent.putExtra("roomId", paramLong2);
    localIntent.putExtra("uinType", paramInt);
    min.a(localIntent, paramLong1);
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((ResultRecord)paramArrayList.next()).jdField_a_of_type_JavaLangString);
    }
    localIntent.putStringArrayListExtra("memberUin", localArrayList);
    paramBaseApplicationImpl.sendBroadcast(localIntent);
    if ((paramInt == 3000) && (paramBoolean)) {
      ((aufl)paramBaseApplicationImpl.getRuntime().getManager(38)).a(1, paramLong2, "", "");
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, Object... paramVarArgs)
  {
    if (paramString1 != null) {}
    for (long l = Long.valueOf(paramString1).longValue();; l = 0L)
    {
      int j = paramQQAppInterface.a().b(l);
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
      Object localObject;
      boolean bool;
      if (localQQMessageFacade != null)
      {
        paramVarArgs = null;
        localObject = null;
        switch (paramInt2)
        {
        default: 
          paramVarArgs = paramQQAppInterface.getApp().getString(2131630178);
          bool = false;
        }
      }
      for (;;)
      {
        localObject = paramVarArgs;
        if (59 != paramInt2)
        {
          localObject = paramVarArgs;
          if (paramInt2 != 60)
          {
            localObject = paramVarArgs;
            if (i == 2)
            {
              localObject = paramVarArgs;
              if (paramVarArgs != null) {
                localObject = paramVarArgs.replace(paramQQAppInterface.getApp().getString(2131654463), paramQQAppInterface.getApp().getString(2131654464));
              }
            }
          }
        }
        paramQQAppInterface = awbi.a(-4008);
        paramQQAppInterface.selfuin = str;
        paramQQAppInterface.frienduin = paramString1;
        paramQQAppInterface.senderuin = str;
        paramQQAppInterface.msg = ((String)localObject);
        paramQQAppInterface.msgtype = -4008;
        paramQQAppInterface.isread = true;
        paramQQAppInterface.issend = 1;
        paramQQAppInterface.istroop = paramInt1;
        paramQQAppInterface.extraflag = 3;
        paramQQAppInterface.time = awao.a();
        paramVarArgs = new ArrayList();
        paramVarArgs.add(paramQQAppInterface);
        if (bool) {
          localQQMessageFacade.a(paramVarArgs, str);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("VideoMsgTools", 1, "addTipsMultiVideoMsg, msgType[" + paramInt2 + "], discussionUin[" + paramString1 + "], memberUin[" + paramString2 + "], uinType[" + paramInt1 + "], extra[" + paramString3 + "], avtype[" + i + "], msgStr[" + (String)localObject + "], bSaveDB[" + bool + "]");
          }
          do
          {
            return;
            if (str.equals(paramString2))
            {
              if (paramInt1 == 3000)
              {
                paramVarArgs = paramQQAppInterface.getApp().getString(2131630177);
                bool = false;
                break;
              }
              if (paramInt1 != 1) {
                break label1204;
              }
              paramVarArgs = paramQQAppInterface.getApp().getString(2131630196);
              bool = false;
              break;
            }
            localObject = babh.c(paramQQAppInterface, paramString1, paramString2);
            if (paramInt1 == 3000) {
              paramVarArgs = (String)localObject + paramQQAppInterface.getApp().getString(2131630176);
            }
            for (;;)
            {
              bool = false;
              break;
              if (paramInt1 == 1) {
                paramVarArgs = (String)localObject + paramQQAppInterface.getApp().getString(2131630194);
              }
            }
            paramQQAppInterface.a().b(1, l, 0);
          } while (!a.containsKey(paramString1 + String.valueOf(i)));
          a.remove(paramString1 + String.valueOf(i));
          paramVarArgs = paramQQAppInterface.getApp().getString(2131630178);
          bool = true;
          break;
          paramQQAppInterface.a().b(2, l, 0);
          paramVarArgs = paramQQAppInterface.getApp().getString(2131630153);
          bool = false;
          break;
          paramQQAppInterface.a().b(3, l, 0);
          if (paramInt1 == 3000)
          {
            paramVarArgs = paramQQAppInterface.getApp().getString(2131630152);
            bool = false;
            break;
          }
          if (paramInt1 == 1)
          {
            paramVarArgs = paramQQAppInterface.getApp().getString(2131630191);
            bool = false;
            break;
          }
          paramVarArgs = paramQQAppInterface.getApp().getString(2131630204);
          bool = false;
          break;
          paramQQAppInterface.a().b(4, l, 0);
          if (paramInt1 == 3000)
          {
            paramVarArgs = paramQQAppInterface.getApp().getString(2131630129);
            bool = false;
            break;
          }
          if (paramInt1 != 1) {
            break label1204;
          }
          paramVarArgs = paramQQAppInterface.getApp().getString(2131630190);
          bool = false;
          break;
          paramQQAppInterface.a().b(5, l, 0);
          if (paramInt1 == 3000)
          {
            paramVarArgs = paramQQAppInterface.getApp().getString(2131630126);
            bool = false;
            break;
          }
          if (paramInt1 != 1) {
            break label1204;
          }
          paramInt3 = 0;
          if (paramString3 != null) {
            paramInt3 = Integer.parseInt(paramString3);
          }
          if (paramInt3 == 19) {}
          for (paramVarArgs = paramQQAppInterface.getApp().getString(2131630188);; paramVarArgs = paramQQAppInterface.getApp().getString(2131630187))
          {
            bool = false;
            break;
          }
          paramQQAppInterface.a().b(6, l, 0);
          if (paramInt1 == 3000)
          {
            paramVarArgs = paramQQAppInterface.getApp().getString(2131630127);
            bool = false;
            break;
          }
          if (paramInt1 != 1) {
            break label1204;
          }
          paramVarArgs = paramQQAppInterface.getApp().getString(2131630189);
          bool = false;
          break;
          if (paramInt1 == 3000)
          {
            paramVarArgs = paramQQAppInterface.getApp().getString(2131630142);
            bool = false;
            break;
          }
          if (paramInt1 != 1) {
            break label1204;
          }
          paramVarArgs = paramQQAppInterface.getApp().getString(2131630142);
          bool = false;
          break;
          paramVarArgs = paramQQAppInterface.getApp().getString(2131654864) + paramString3;
          bool = false;
          break;
          paramVarArgs = paramQQAppInterface.getApp().getString(2131630208);
          bool = false;
          break;
          paramVarArgs = paramQQAppInterface.getApp().getString(2131630207);
          bool = false;
          break;
          localQQMessageFacade.c(paramVarArgs, str);
        }
        label1204:
        bool = false;
        paramVarArgs = (Object[])localObject;
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3, Object... paramVarArgs)
  {
    QLog.d("VideoMsgTools", 1, "addBubbleVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", isSender = " + paramBoolean2 + ", time = " + paramString3 + ", isRead = " + paramBoolean3);
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    String str2 = a(paramQQAppInterface.getApp(), paramInt2, paramInt1, paramBoolean2, paramString3);
    String str3 = axwb.a(str2, paramInt2, 3, paramBoolean1);
    if (paramInt1 == 9500)
    {
      ((xvq)paramQQAppInterface.a(49)).a(paramString1, str2, awao.a(), false, false, true);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof msg_comm.Msg))) {}
    for (paramVarArgs = (msg_comm.Msg)paramVarArgs[0];; paramVarArgs = null)
    {
      if (paramVarArgs != null) {}
      for (long l1 = ((msg_comm.MsgHead)paramVarArgs.msg_head.get()).msg_time.get();; l1 = 0L)
      {
        if (TextUtils.isEmpty(paramString2)) {
          break label609;
        }
        paramVarArgs = awbi.a(-2009);
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
        label355:
        long l3;
        if (paramBoolean2)
        {
          paramVarArgs.issend = 1;
          paramVarArgs.istroop = paramInt1;
          paramVarArgs.extraflag = 3;
          paramString2 = (aufl)paramQQAppInterface.getManager(38);
          if (paramString2 == null) {
            break label599;
          }
          paramString2 = paramString2.a().a(paramString1, paramInt1);
          if (paramString2 == null) {
            break label599;
          }
          l3 = paramString2.lastCallTime;
          l2 = l3;
          if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, "VideoMsgTools updateDoubleCallStatus lastCallTime = " + paramString2.lastCallTime);
          }
        }
        label599:
        for (long l2 = l3;; l2 = 0L)
        {
          if (l1 > 0L) {
            paramVarArgs.time = l1;
          }
          for (;;)
          {
            ThreadManager.executeOnSubThread(new VideoMsgTools.2(paramQQAppInterface, paramVarArgs, paramBoolean3, str1, str2, paramInt1, paramBoolean1));
            a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, str1, paramString3, str3);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("VideoMsgTools", 2, "addBubbleVideoMsg end");
            return;
            paramVarArgs.issend = 0;
            break label355;
            if (str2.equals(paramQQAppInterface.getApp().getString(2131654857))) {
              paramVarArgs.time = awao.a();
            } else if ((l2 > 0L) && (paramInt2 != 7)) {
              paramVarArgs.time = awao.a();
            } else {
              paramVarArgs.time = (awao.a() - paramQQAppInterface.a().d());
            }
          }
        }
      }
      label609:
      break;
    }
  }
  
  static void b(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramContext.startActivity(paramIntent, ActivityOptions.makeCustomAnimation(paramContext, 2130771997, 0).toBundle());
      return;
    }
    paramQQAppInterface.getApp().startActivity(paramIntent);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addDiscussMember discussUin = " + paramString);
    }
    Object localObject1 = ((ajhh)paramQQAppInterface.getManager(53)).a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      int j = ((ArrayList)localObject1).size();
      int i = 0;
      while (i < j)
      {
        localObject2 = (DiscussionMemberInfo)((ArrayList)localObject1).get(i);
        if (localObject2 != null) {
          localArrayList.add(((DiscussionMemberInfo)localObject2).memberUin);
        }
        i += 1;
      }
    }
    localObject1 = new VideoMsgTools.5(new Handler());
    Object localObject2 = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    ((Intent)localObject2).putStringArrayListExtra("param_uins_selected_default", localArrayList);
    ((Intent)localObject2).putExtra("param_groupcode", paramString);
    ((Intent)localObject2).putExtra("param_type", 3000);
    ((Intent)localObject2).putExtra("param_subtype", 1);
    ((Intent)localObject2).putExtra("param_entrance", 11);
    ((Intent)localObject2).putExtra("param_max", 100 - localArrayList.size());
    ((Intent)localObject2).putExtra("param_donot_need_contacts", true);
    ((Intent)localObject2).putExtra("param_title", paramQQAppInterface.getApplication().getString(2131630285));
    ((Intent)localObject2).putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131626068));
    ((Intent)localObject2).putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131626069));
    ((Intent)localObject2).putExtra("PARAM_ActivityResultReceiver", (Parcelable)localObject1);
    ((Intent)localObject2).addFlags(268435456);
    paramQQAppInterface.getApplication().startActivity((Intent)localObject2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "send_struct_massage_upgrade.peerUin = " + paramString + ", type = " + paramInt);
    }
    Object localObject = baig.b(paramQQAppInterface.getCurrentAccountUin());
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
      localObject = awwg.a((String)localObject);
      if (localObject == null) {
        break;
      }
      baic.a(paramQQAppInterface, paramString, 0, (AbsStructMsg)localObject, null);
      return;
      localObject = ((SharedPreferences)localObject).getString("qav_upgrade_invite_video", null);
      continue;
      localObject = ((SharedPreferences)localObject).getString("qav_upgrade_invite_multi", null);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoMsgTools", 2, "absMsg is null! use default");
    }
    c(paramQQAppInterface, paramString, paramInt);
    return;
    label178:
    if (QLog.isColorLevel()) {
      QLog.i("VideoMsgTools", 2, "configXML is null! use default");
    }
    c(paramQQAppInterface, paramString, paramInt);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 20) || (paramInt == 19) || (paramInt == 44) || (paramInt == 59) || (paramInt == 60) || (paramInt == 22);
  }
  
  static void c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject1 = paramQQAppInterface.getApp().getApplicationContext().getString(2131630515);
    Object localObject2 = paramQQAppInterface.getApp().getApplicationContext().getString(2131630514);
    localObject1 = new awui(StructMsgForGeneralShare.class).c(62).a((String)localObject2).e("https://im.qq.com/mobileqq/touch").a((String)localObject1, null).a();
    localObject2 = awuv.a(2);
    String str = paramQQAppInterface.getApp().getApplicationContext().getString(2131630518);
    ((awum)localObject2).a("http://url.cn/hw298C", paramQQAppInterface.getApp().getApplicationContext().getString(2131630520), str);
    ((AbsShareMsg)localObject1).addItem((awul)localObject2);
    baic.a(paramQQAppInterface, paramString, 0, (AbsStructMsg)localObject1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools
 * JD-Core Version:    0.7.0.1
 */