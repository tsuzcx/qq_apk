package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.share.ShareChatReport;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.TestStructMsg;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.PoolingByteArrayOutputStream;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.util.LogUtil;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class VideoMsgTools
{
  static Map<String, String> a = new HashMap();
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString.contains(paramContext.getString(2131917863))) {
      return 2131168185;
    }
    if (paramBoolean) {
      return 2131168020;
    }
    return 2131168016;
  }
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramInt == 13)
    {
      if (paramString.contains(paramContext.getString(2131893348))) {
        return 0;
      }
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          return 2130843149;
        }
        return 2130843148;
      }
      if (paramBoolean2) {
        return 2130842907;
      }
      return 2130842906;
    }
    if (paramString.contains(paramContext.getString(2131917877))) {
      return a(paramBoolean1, paramBoolean2, paramBoolean3);
    }
    if (paramString.contains(paramContext.getString(2131917859)))
    {
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          return 2130843318;
        }
        return 2130843317;
      }
      if (paramBoolean2) {
        return 2130842907;
      }
      return 2130842906;
    }
    if (paramString.contains(paramContext.getString(2131917863)))
    {
      if (paramBoolean1) {
        return 2130843316;
      }
      return 2130842905;
    }
    if (paramString.contains(paramContext.getString(2131917866)))
    {
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          return 2130843318;
        }
        return 2130843317;
      }
      if (paramBoolean2) {
        return 2130842907;
      }
      return 2130842906;
    }
    if (paramString.contains(paramContext.getString(2131917867)))
    {
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          return 2130843318;
        }
        return 2130843317;
      }
      if (paramBoolean2) {
        return 2130842907;
      }
      return 2130842906;
    }
    if (paramString.contains(paramContext.getString(2131917865)))
    {
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          return 2130843318;
        }
        return 2130843317;
      }
      if (paramBoolean2) {
        return 2130842907;
      }
      return 2130842906;
    }
    if (paramString.contains(paramContext.getString(2131917868)))
    {
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          return 2130843318;
        }
        return 2130843317;
      }
      if (paramBoolean2) {
        return 2130842907;
      }
      return 2130842906;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return 2130843149;
      }
      return 2130843148;
    }
    if (paramBoolean2) {
      return 2130842907;
    }
    return 2130842906;
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
  
  private static int a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      if ((!paramBoolean2) && (!paramBoolean3)) {
        return 2130843317;
      }
      return 2130843318;
    }
    if ((!paramBoolean2) && (!paramBoolean3)) {
      return 2130842906;
    }
    return 2130842907;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    label264:
    StringBuilder localStringBuilder;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        if (paramInt1 != 2) {
          if (paramInt1 != 3) {
            if (paramInt1 != 6) {
              if (paramInt1 != 7)
              {
                if (paramInt1 == 9) {
                  break label381;
                }
                if (paramInt1 != 10) {
                  if (paramInt1 != 12)
                  {
                    if (paramInt1 == 15) {
                      break label381;
                    }
                    if (paramInt1 == 24) {
                      break label264;
                    }
                    if (paramInt1 != 53)
                    {
                      if (paramInt1 == 57) {
                        break label381;
                      }
                      if ((paramInt1 != 42) && (paramInt1 != 43)) {
                        if ((paramInt1 == 62) || (paramInt1 == 63)) {
                          break label381;
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
      switch (paramInt1)
      {
      default: 
        return "";
      case 49: 
        return paramContext.getString(2131917868);
        if (paramInt2 == 9500) {
          return paramContext.getString(2131917860);
        }
        return paramContext.getString(2131917859);
        return paramContext.getString(2131917861);
        if (paramBoolean)
        {
          if (paramInt2 == 9500) {
            return paramContext.getString(2131917879);
          }
          return paramContext.getString(2131917878);
        }
        if (paramInt2 == 9500) {
          return paramContext.getString(2131917864);
        }
        return paramContext.getString(2131917863);
        if (paramInt2 == 9500) {
          return paramContext.getString(2131917864);
        }
        return paramContext.getString(2131917863);
        return paramContext.getString(2131917867);
        if (paramInt2 == 9500) {
          return paramContext.getString(2131917864);
        }
        return paramContext.getString(2131917863);
        return paramContext.getString(2131917866);
      case 47: 
        if (paramString != null)
        {
          paramContext = paramContext.getString(2131917877);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramContext);
          localStringBuilder.append(" ");
          localStringBuilder.append(paramString);
          return localStringBuilder.toString();
        }
        if (paramBoolean)
        {
          if (paramInt2 == 9500) {
            return paramContext.getString(2131917860);
          }
          return paramContext.getString(2131917859);
        }
        if (paramInt2 == 9500) {
          return paramContext.getString(2131917864);
        }
        return paramContext.getString(2131917863);
        if (paramInt2 == 9500) {
          return paramContext.getString(2131917864);
        }
        return paramContext.getString(2131917863);
      }
    }
    label381:
    if (paramString != null)
    {
      paramContext = paramContext.getString(2131917877);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    if (paramInt2 == 9500) {
      return paramContext.getString(2131917860);
    }
    return paramContext.getString(2131917859);
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openMeetingMember, discussUin[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    QLog.w("VideoMsgTools", 1, ((StringBuilder)localObject).toString());
    localObject = new Intent(paramActivity, GAudioMembersCtrlActivity.class);
    ((Intent)localObject).putExtra("discussUin", paramString);
    ((Intent)localObject).putExtra("Owner", paramBoolean1);
    ((Intent)localObject).putExtra("isInRoom", paramBoolean2);
    ((Intent)localObject).putExtra("isFromMeeting", false);
    ((Intent)localObject).addFlags(268435456);
    paramActivity.startActivity((Intent)localObject);
  }
  
  static void a(BaseApplicationImpl paramBaseApplicationImpl, boolean paramBoolean, long paramLong, ArrayList<ResultRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "sendAddMemberResultBroadcastToVideo");
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((ResultRecord)paramArrayList.next()).uin);
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("addTipsVideoMsg uinType = ");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(", msgType = ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(", friendUin = ");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(", extra=");
    ((StringBuilder)localObject1).append(paramString2);
    AVLog.printAllUserLog("VideoMsgTools", ((StringBuilder)localObject1).toString());
    if (paramInt1 == -1) {
      return;
    }
    localObject1 = paramQQAppInterface.getMessageFacade();
    if (localObject1 != null)
    {
      int i;
      if (paramInt2 != 0)
      {
        if (paramInt2 != 1)
        {
          if (paramInt2 != 2) {
            if (paramInt2 != 3)
            {
              if (paramInt2 != 4)
              {
                if (paramInt2 != 5)
                {
                  if (paramInt2 != 24)
                  {
                    if (paramInt2 != 25)
                    {
                      if (paramInt2 != 28)
                      {
                        if (paramInt2 != 29)
                        {
                          if (paramInt2 != 35)
                          {
                            if (paramInt2 != 45)
                            {
                              if (paramInt2 != 66)
                              {
                                if (paramInt2 != 55)
                                {
                                  if (paramInt2 != 56) {
                                    switch (paramInt2)
                                    {
                                    default: 
                                      switch (paramInt2)
                                      {
                                      default: 
                                        switch (paramInt2)
                                        {
                                        default: 
                                          switch (paramInt2)
                                          {
                                          default: 
                                            paramString2 = paramQQAppInterface.getApp().getString(2131893238);
                                            break;
                                          case 64: 
                                            paramString2 = paramQQAppInterface.getApp().getString(2131917862);
                                            break;
                                          case 63: 
                                            paramString2 = paramQQAppInterface.getApp().getString(2131917873);
                                            break;
                                          case 62: 
                                            boolean bool = TextUtils.isEmpty(UITools.a(paramQQAppInterface, paramString1));
                                            paramString2 = paramQQAppInterface.getApp();
                                            if (bool) {
                                              i = 2131917871;
                                            } else {
                                              i = 2131917872;
                                            }
                                            paramString2 = paramString2.getString(i);
                                            if (!bool) {
                                              ReportController.b(null, "CliOper", "", "", "0X800A8D9", "0X800A8D9", 2, 0, "", "", "", "");
                                            }
                                            break;
                                          case 61: 
                                            paramString2 = paramQQAppInterface.getApp().getString(2131893599);
                                          }
                                          break;
                                        case 52: 
                                          paramString2 = paramQQAppInterface.getApp().getString(2131917874);
                                          break;
                                        case 51: 
                                          paramString2 = paramQQAppInterface.getApp().getString(2131917876);
                                          break;
                                        case 50: 
                                          paramString2 = paramQQAppInterface.getApp().getString(2131917869);
                                        }
                                        break;
                                      case 41: 
                                        localObject2 = new StringBuilder();
                                        ((StringBuilder)localObject2).append(paramQQAppInterface.getApp().getString(2131917870));
                                        ((StringBuilder)localObject2).append(paramString2);
                                        paramString2 = ((StringBuilder)localObject2).toString();
                                        break;
                                      case 40: 
                                        paramString2 = paramQQAppInterface.getApp().getString(2131893098);
                                        break;
                                      case 39: 
                                        paramString2 = paramQQAppInterface.getApp().getString(2131917916);
                                      }
                                      break;
                                    case 11: 
                                      paramString2 = paramQQAppInterface.getApp().getString(2131917843);
                                      break;
                                    case 10: 
                                      paramString2 = paramQQAppInterface.getApp().getString(2131917894);
                                      break;
                                    case 9: 
                                      if (paramBoolean) {
                                        paramString2 = paramQQAppInterface.getApp().getString(2131917847);
                                      } else {
                                        paramString2 = paramQQAppInterface.getApp().getString(2131917845);
                                      }
                                      break;
                                    case 8: 
                                      paramString2 = paramQQAppInterface.getApp().getString(2131917910);
                                      break;
                                    case 7: 
                                      paramString2 = paramQQAppInterface.getApp().getString(2131917853);
                                      break;
                                    }
                                  }
                                  paramString2 = paramQQAppInterface.getApp().getString(2131893187);
                                  break label881;
                                }
                                paramString2 = paramQQAppInterface.getApp().getString(2131917875);
                                break label881;
                              }
                              paramString2 = paramQQAppInterface.getApp().getString(2131893468);
                              ReportController.b(null, "CliOper", "", "", "0X800A8D9", "0X800A8D9", 1, 0, "", "", "", "");
                              break label881;
                            }
                            paramString2 = paramQQAppInterface.getApp().getString(2131893238);
                            break label881;
                          }
                          paramString2 = paramQQAppInterface.getApp().getString(2131917830);
                          break label881;
                        }
                        paramString2 = paramQQAppInterface.getApp().getString(2131917838);
                        break label881;
                      }
                      paramString2 = paramQQAppInterface.getApp().getString(2131917918);
                      break label881;
                    }
                    paramString2 = paramQQAppInterface.getApp().getString(2131917852);
                    break label881;
                  }
                }
                else
                {
                  paramString2 = paramQQAppInterface.getApp().getString(2131917849);
                  break label881;
                }
              }
              else
              {
                paramString2 = paramQQAppInterface.getApp().getString(2131917917);
                break label881;
              }
            }
            else
            {
              paramString2 = paramQQAppInterface.getApp().getString(2131917892);
              break label881;
            }
          }
          paramString2 = paramQQAppInterface.getApp().getString(2131917831);
        }
        else
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131917893);
        }
      }
      else {
        paramString2 = paramQQAppInterface.getApp().getString(2131917832);
      }
      label881:
      Object localObject2 = paramQQAppInterface.getCurrentAccountUin();
      String str = TransfileUtile.makeTransFileProtocolData(paramString2, 0L, 3, paramBoolean);
      if (paramInt1 == 9500)
      {
        ((DeviceMsgHandle)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a(paramString1, paramString2, MessageCache.c(), false, false, true);
        return;
      }
      if (paramInt2 == 66) {
        i = 1;
      } else {
        i = 0;
      }
      paramString2 = MessageRecordFactory.a(-1001);
      paramString2.selfuin = ((String)localObject2);
      paramString2.frienduin = paramString1;
      paramString2.senderuin = ((String)localObject2);
      paramString2.msg = str;
      paramString2.msgtype = -1001;
      paramString2.isread = true;
      paramString2.issend = 0;
      paramString2.istroop = paramInt1;
      paramString2.extraflag = 3;
      paramString2.time = MessageCache.c();
      if (i == 0) {
        ((QQMessageFacade)localObject1).a(paramString2, (String)localObject2);
      } else {
        ThreadManager.executeOnSubThread(new VideoMsgTools.4((QQMessageFacade)localObject1, paramString2));
      }
      if ((paramInt2 != 2) && (paramInt2 != 24))
      {
        if (paramInt2 == 0) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "0", "", "", "");
        }
      }
      else {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "0", "", "", "");
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showGuideBar uinType: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", msgType: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", isVideoMsg: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", friendUin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", selfUin: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", videoTime: ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", msgStr: ");
      localStringBuilder.append(paramString4);
      QLog.d("VideoMsgTools", 2, localStringBuilder.toString());
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addVideoMsgWithAvtype uinType = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", msgType = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", isVideoMsg = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", friendUin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", senderUin = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", isSender = ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(", extra = ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", isRead = ");
      localStringBuilder.append(paramBoolean3);
      localStringBuilder.append(", avtype = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", listSize = ");
      if (paramVarArgs == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(paramVarArgs.length);
      }
      localStringBuilder.append(localObject);
      QLog.d("VideoMsgTools", 2, localStringBuilder.toString());
    }
    if (paramInt1 == 2)
    {
      a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!paramString1.equals(paramQQAppInterface.getCurrentAccountUin())))
    {
      if (paramInt1 != 1011)
      {
        if (paramInt1 == -1) {
          return;
        }
        if (paramInt1 == 10003)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoMsgTools", 2, "uinType is nearbyVideo, return");
          }
          return;
        }
        if (paramInt1 == 1000)
        {
          localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          if ((localObject != null) && (!TextUtils.isEmpty(paramString2)))
          {
            paramString2 = ((TroopManager)localObject).f(paramString2);
            if (paramString2 != null) {
              paramString2 = paramString2.troopcode;
            } else if (QLog.isColorLevel()) {
              QLog.e("VideoMsgTools", 2, "can't find troop info!");
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.e("VideoMsgTools", 2, "can't get friend manager!");
            }
            return;
          }
        }
        if (((paramQQAppInterface.getAVNotifyCenter().t() != 1) && (paramQQAppInterface.getAVNotifyCenter().t() != 2)) || ((paramInt2 != 15) && (paramInt2 != 9) && (paramInt2 != 62) && (paramInt2 != 63)))
        {
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
        boolean bool;
        if ((paramQQAppInterface.getAVNotifyCenter().t() == 2) && (paramInt2 == 15)) {
          bool = true;
        } else {
          bool = paramBoolean1;
        }
        b(paramQQAppInterface, paramInt1, paramInt2, bool, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
        new Handler().postDelayed(new VideoMsgTools.1(paramInt2, paramQQAppInterface, paramInt1, paramBoolean1, paramString1, paramString3, paramString2, paramInt3, paramVarArgs), 500L);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("VideoMsgTools", 2, "friendUin & senderUin can't empty!");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3, Object... paramVarArgs)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addVideoMsg uinType = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", msgType = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", isVideoMsg = ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(", friendUin = ");
    ((StringBuilder)localObject).append(LogUtil.getSafePrintUin(paramString1));
    ((StringBuilder)localObject).append(", senderUin = ");
    ((StringBuilder)localObject).append(LogUtil.getSafePrintUin(paramString2));
    ((StringBuilder)localObject).append(", isSender = ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(", extra = ");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(", isRead = ");
    ((StringBuilder)localObject).append(paramBoolean3);
    QLog.d("VideoMsgTools", 1, ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!paramString1.equals(paramQQAppInterface.getCurrentAccountUin())))
    {
      if (paramInt1 != 1011)
      {
        if (paramInt1 == -1) {
          return;
        }
        if (paramInt1 == 10003)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoMsgTools", 2, "uinType is nearbyVideo, return");
          }
          return;
        }
        if (paramInt1 == 1000)
        {
          localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          if ((localObject != null) && (!TextUtils.isEmpty(paramString2)))
          {
            paramString2 = ((TroopManager)localObject).f(paramString2);
            if (paramString2 != null) {
              paramString2 = paramString2.troopcode;
            } else if (QLog.isColorLevel()) {
              QLog.e("VideoMsgTools", 2, "can't find troop info!");
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.e("VideoMsgTools", 2, "can't get friend manager!");
            }
            return;
          }
        }
        if (a(paramInt2))
        {
          if (b(paramInt2))
          {
            a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramBoolean2, paramBoolean3, 0, paramVarArgs);
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
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("VideoMsgTools", 2, "friendUin & senderUin can't empty!");
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, Object... paramVarArgs)
  {
    Object localObject3 = paramQQAppInterface.getCurrentAccountUin();
    Object localObject1 = paramQQAppInterface.getAVNotifyCenter();
    long l1 = Long.valueOf(paramString1).longValue();
    int i = ((AVNotifyCenter)localObject1).e(l1);
    if (paramInt2 != 0) {
      i = paramInt2;
    }
    if (paramInt1 == 3000) {
      i = 1;
    }
    localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(String.valueOf(i));
    if (!((Map)localObject1).containsKey(((StringBuilder)localObject2).toString()))
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(String.valueOf(i));
      ((Map)localObject1).put(((StringBuilder)localObject2).toString(), "add");
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.length() > 2))
    {
      if (paramInt1 == 3000) {
        localObject1 = paramQQAppInterface.getApp().getString(2131893313);
      } else if (paramInt1 == 1)
      {
        if (i == 10)
        {
          localObject1 = paramQQAppInterface.getApp().getString(2131893337);
        }
        else
        {
          localObject1 = paramQQAppInterface.getAVNotifyCenter().a(l1, i);
          if (localObject1 != null) {
            paramInt2 = ((AVNotifyCenter.VideoRoomInfo)localObject1).g;
          } else {
            paramInt2 = 0;
          }
          if ((localObject1 != null) && (((AVNotifyCenter.VideoRoomInfo)localObject1).a()))
          {
            localObject1 = paramQQAppInterface.getApp().getString(2131893341);
            break label318;
          }
          if ((localObject1 != null) && (((AVNotifyCenter.VideoRoomInfo)localObject1).b()))
          {
            localObject1 = paramQQAppInterface.getApp().getString(2131893348);
            break label318;
          }
          localObject1 = paramQQAppInterface.getApp().getString(2131893336);
          break label318;
        }
      }
      else {
        localObject1 = null;
      }
      paramInt2 = 0;
      label318:
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof msg_comm.Msg))) {
        localObject2 = (msg_comm.Msg)paramVarArgs[0];
      } else {
        localObject2 = null;
      }
      if (localObject2 != null) {
        l1 = ((msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get()).msg_time.get();
      } else {
        l1 = 0L;
      }
      long l2 = l1;
      if (paramVarArgs != null)
      {
        l2 = l1;
        if (paramVarArgs.length >= 2)
        {
          l2 = l1;
          if (paramVarArgs[0] != null)
          {
            l2 = l1;
            if ((paramVarArgs[0] instanceof Long))
            {
              l2 = l1;
              if (paramVarArgs[1] != null)
              {
                l2 = l1;
                if ((paramVarArgs[1] instanceof Long))
                {
                  l2 = ((Long)paramVarArgs[0]).longValue();
                  l3 = ((Long)paramVarArgs[1]).longValue();
                  if (l2 != 0L) {
                    l1 = l2;
                  }
                  l2 = l1;
                  if (l3 != 0L)
                  {
                    l2 = l3;
                    break label526;
                  }
                }
              }
            }
          }
        }
      }
      long l3 = 0L;
      l1 = l2;
      l2 = l3;
      label526:
      localObject2 = TransfileUtile.makeTransFileProtocolData((String)localObject1, 13L, 3, true);
      paramVarArgs = MessageRecordFactory.a(-2016);
      paramVarArgs.selfuin = ((String)localObject3);
      paramVarArgs.frienduin = paramString1;
      paramVarArgs.senderuin = paramString2;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("|");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("|");
      ((StringBuilder)localObject3).append(paramInt2);
      paramVarArgs.msg = ((StringBuilder)localObject3).toString();
      paramVarArgs.msgtype = -2016;
      paramVarArgs.isread = paramBoolean2;
      if (paramInt1 == 3000) {
        paramVarArgs.isread = true;
      }
      if (paramBoolean1) {
        paramVarArgs.issend = 1;
      } else {
        paramVarArgs.issend = 0;
      }
      paramVarArgs.istroop = paramInt1;
      paramVarArgs.extraflag = 3;
      if (l2 != 0L) {
        paramVarArgs.shmsgseq = l2;
      }
      paramVarArgs.extInt = i;
      if (l1 > 0L) {
        paramVarArgs.time = l1;
      } else {
        paramVarArgs.time = MessageCache.c();
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addMultiVideoMsg, [before add], uinType[");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append("], friendUin[");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append("], senderUin[");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append("], time[");
        ((StringBuilder)localObject2).append(paramVarArgs.time);
        ((StringBuilder)localObject2).append("], seq[");
        ((StringBuilder)localObject2).append(paramVarArgs.shmsgseq);
        ((StringBuilder)localObject2).append("], sendTime[");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append("], msgSeq[");
        ((StringBuilder)localObject2).append(l2);
        ((StringBuilder)localObject2).append("], uniseq[");
        ((StringBuilder)localObject2).append(paramVarArgs.uniseq);
        ((StringBuilder)localObject2).append("]");
        QLog.w("VideoMsgTools", 2, ((StringBuilder)localObject2).toString());
      }
      paramQQAppInterface.getMsgHandler().a(paramVarArgs, paramBoolean2);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        CUOpenCardGuideMng.a(paramQQAppInterface, paramVarArgs.frienduin, paramInt1, true, "qav");
      }
      if (QLog.isDevelopLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("addMultiVideoMsg, [after add], uinType[");
        paramQQAppInterface.append(paramInt1);
        paramQQAppInterface.append("], friendUin[");
        paramQQAppInterface.append(paramString1);
        paramQQAppInterface.append("], senderUin[");
        paramQQAppInterface.append(paramString2);
        paramQQAppInterface.append("], time[");
        paramQQAppInterface.append(paramVarArgs.time);
        paramQQAppInterface.append("], seq[");
        paramQQAppInterface.append(paramVarArgs.shmsgseq);
        paramQQAppInterface.append("], sendTime[");
        paramQQAppInterface.append(l1);
        paramQQAppInterface.append("], msgSeq[");
        paramQQAppInterface.append(l2);
        paramQQAppInterface.append("], uniseq[");
        paramQQAppInterface.append(paramVarArgs.uniseq);
        paramQQAppInterface.append("]");
        QLog.w("VideoMsgTools", 4, paramQQAppInterface.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("addMultiVideoMsg, err, uinType[");
      paramQQAppInterface.append(paramInt1);
      paramQQAppInterface.append("], friendUin[");
      paramQQAppInterface.append(paramString1);
      paramQQAppInterface.append("], senderUin[");
      paramQQAppInterface.append(paramString2);
      paramQQAppInterface.append("]");
      QLog.w("VideoMsgTools", 1, paramQQAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramQQAppInterface = paramQQAppInterface.getMsgCache();
    if (paramInt != 1006)
    {
      if (paramInt != 1021) {
        return;
      }
      paramQQAppInterface.m(paramString1, paramArrayOfByte);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    int i = QAVGroupConfig.b();
    int j = QAVGroupConfig.c();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramQQAppInterface.getCurrentAccountUin());
    j -= 1;
    i = Math.min(i - 1, j);
    boolean bool = QAVGroupConfig.a(paramQQAppInterface, paramString1);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("selectMemberToStartGAudioChat, uinType[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], groupUin[");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("], gruopName[");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("], bVideo[");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("], leftAutoSelectNum[");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("], leftMaxSelect[");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("], canShowInviteEntry[");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("], fromWhere[");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("]");
    QLog.w("VideoMsgTools", 1, ((StringBuilder)localObject).toString());
    Resources localResources = paramQQAppInterface.getApplication().getResources();
    localObject = localResources.getString(2131893257);
    String str = localResources.getString(2131893259);
    if ("AIOShareScreen".equals(paramString3))
    {
      localObject = localResources.getString(2131893473);
      str = localResources.getString(2131893260);
      bool = false;
    }
    Intent localIntent = new Intent();
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
    localIntent.putExtra("param_title", localResources.getString(2131893309));
    localIntent.putExtra("param_done_button_wording", (String)localObject);
    localIntent.putExtra("param_done_button_highlight_wording", str);
    localIntent.putExtra("show_invite_entry", bool);
    localIntent.putExtra("param_show_myself", false);
    if (paramInt == 1) {
      localIntent.putExtra("param_only_troop_member", true);
    } else {
      localIntent.putExtra("param_only_discussion_member", true);
    }
    paramContext = new WeakReference(paramContext);
    localIntent.putExtra("PARAM_ActivityResultReceiver", new VideoMsgTools.7(new Handler(), paramBoolean, paramContext, paramInt, paramString1, paramString3));
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.overridePendingTransition(2130772014, 0);
    }
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(paramQQAppInterface.getApplicationContext(), localIntent);
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
    long l2 = SeqUtil.a(paramIntent);
    paramIntent = new StringBuilder();
    paramIntent.append("addGroupMember begin, uin[");
    paramIntent.append(str);
    paramIntent.append("], roomID[");
    paramIntent.append(l1);
    paramIntent.append("], sTopActivity[");
    if (BaseActivity.sTopActivity != null) {
      bool = true;
    } else {
      bool = false;
    }
    paramIntent.append(bool);
    paramIntent.append("], seq[");
    paramIntent.append(l2);
    paramIntent.append("]");
    Object localObject = paramIntent.toString();
    paramIntent = "VideoMsgTools";
    QLog.w("VideoMsgTools", 1, (String)localObject);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
    localObject = localArrayList1.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
      if (Utils.e(localResultRecord.uin)) {
        localArrayList2.add(localResultRecord.uin);
      }
    }
    boolean bool = QAVGroupConfig.a(paramQQAppInterface, str);
    if (bool) {
      ShareChatReport.a();
    }
    int j = Math.max(QAVGroupConfig.d() - localArrayList1.size(), 0);
    j = Math.min(QAVGroupConfig.c(), j);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList2);
    localIntent.putExtra("room_create_time", i);
    localIntent.putExtra("room_id", l1);
    localIntent.putExtra("group_uin", str);
    localIntent.putExtra("param_groupcode", str);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_subtype", 1);
    localIntent.putExtra("param_entrance", 11);
    localIntent.putExtra("param_max", j);
    localIntent.putExtra("show_invite_entry", bool);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramContext.getString(2131893435));
    localIntent.putExtra("group_name", paramContext.getString(2131893434));
    localIntent.putExtra("param_done_button_wording", paramContext.getString(2131888562));
    localIntent.putExtra("param_done_button_highlight_wording", paramContext.getString(2131888563));
    AudioHelper.a("VideoMsgToolsaddGroupMember", localIntent.getExtras(), true);
    localIntent.putExtra("PARAM_ActivityResultReceiver", new VideoMsgTools.8(new Handler(), l2, str));
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.overridePendingTransition(2130772014, 0);
    }
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(paramQQAppInterface.getApplicationContext(), localIntent);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("addGroupMember end, uin[");
    paramQQAppInterface.append(str);
    paramQQAppInterface.append("], seq[");
    paramQQAppInterface.append(l2);
    paramQQAppInterface.append("]");
    QLog.w(paramIntent, 1, paramQQAppInterface.toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openMeetingMember, discussUin[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    QLog.w("VideoMsgTools", 1, ((StringBuilder)localObject).toString());
    localObject = new Intent(paramQQAppInterface.getApplication(), GAudioMembersCtrlActivity.class);
    ((Intent)localObject).putExtra("discussUin", paramString);
    ((Intent)localObject).addFlags(268435456);
    paramQQAppInterface.getApplication().startActivity((Intent)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    long l = AudioHelper.c();
    int i;
    if (paramInt == 1) {
      i = 8;
    } else {
      i = 48;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addMemberFromC2C, seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("], peerUin[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], supportUinType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], max[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("]");
      QLog.w("double_2_multi", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    paramString = new Intent();
    paramString.putExtra("param_type", paramInt);
    paramString.putExtra("param_subtype", 0);
    paramString.putExtra("param_from", 1001);
    paramString.putExtra("param_entrance", 36);
    paramString.putStringArrayListExtra("param_uins_selected_default", (ArrayList)localObject);
    paramString.putExtra("param_add_passed_members_to_result_set", true);
    paramString.putExtra("param_max", i);
    paramString.putExtra("param_donot_need_contacts", true);
    paramString.putExtra("param_title", paramQQAppInterface.getApplication().getString(2131893435));
    paramString.putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131888562));
    paramString.putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131888563));
    paramString.putExtra("PARAM_ActivityResultReceiver", new VideoMsgTools.6(new Handler(), l));
    paramString.addFlags(268435456);
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.overridePendingTransition(2130772014, 0);
    }
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(paramQQAppInterface.getApplicationContext(), paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, INetEngineListener paramINetEngineListener)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendHttpReq requestUrl  = ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", actid = ");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("VideoMsgTools", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramQQAppInterface == null) {
      return;
    }
    long l = 0L;
    label429:
    for (;;)
    {
      try
      {
        localObject1 = new URL(paramString1).getHost();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        String str = "";
        if ((!bool) && (((String)localObject1).endsWith(".qq.com")))
        {
          localObject2 = (TicketManager)paramQQAppInterface.getManager(2);
          localObject1 = paramQQAppInterface.getAccount();
          localObject2 = ((TicketManager)localObject2).getSkey((String)localObject1);
          l = a((String)localObject2);
          HttpNetReq localHttpNetReq = new HttpNetReq();
          localHttpNetReq.mCallback = paramINetEngineListener;
          localHttpNetReq.mHttpMethod = 0;
          localHttpNetReq.mOutStream = new PoolingByteArrayOutputStream(ByteArrayPool.getMaxBufInstance(), 153600);
          if (paramString3 != null) {
            break label429;
          }
          paramString3 = str;
          paramINetEngineListener = new StringBuilder();
          paramINetEngineListener.append(paramString1);
          paramINetEngineListener.append("g_tk=");
          paramINetEngineListener.append(l);
          paramINetEngineListener.append("&actid=");
          paramINetEngineListener.append(paramString2);
          paramINetEngineListener.append("&mp_ext_params=");
          paramINetEngineListener.append(URLUtil.c(paramString3));
          localHttpNetReq.mReqUrl = paramINetEngineListener.toString();
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("req.mReqUrl=");
            paramString1.append(localHttpNetReq.mReqUrl);
            QLog.i("VideoMsgTools", 2, paramString1.toString());
          }
          localHttpNetReq.mUseByteArrayPool = true;
          localHttpNetReq.mExcuteTimeLimit = 30000L;
          localHttpNetReq.mReqProperties.put("Connection", "Keep-Alive");
          localHttpNetReq.mReqProperties.put("Cookie", String.format("uin=o%s; skey=%s;", new Object[] { localObject1, localObject2 }));
          ((IHttpEngineService)paramQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
          return;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoMsgTools", 2, "sendHttpReq : ", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
        return;
      }
      localObject1 = "";
      Object localObject2 = localObject1;
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        bool1 = bool2;
        if (paramInt != 2)
        {
          bool1 = bool2;
          if (paramInt != 24)
          {
            bool1 = bool2;
            if (paramInt != 3)
            {
              bool1 = bool2;
              if (paramInt != 7)
              {
                bool1 = bool2;
                if (paramInt != 10)
                {
                  bool1 = bool2;
                  if (paramInt != 12)
                  {
                    bool1 = bool2;
                    if (paramInt != 42)
                    {
                      bool1 = bool2;
                      if (paramInt != 43)
                      {
                        bool1 = bool2;
                        if (paramInt != 13)
                        {
                          bool1 = bool2;
                          if (paramInt != 47)
                          {
                            bool1 = bool2;
                            if (paramInt != 48)
                            {
                              bool1 = bool2;
                              if (paramInt != 49)
                              {
                                bool1 = bool2;
                                if (paramInt != 53)
                                {
                                  bool1 = bool2;
                                  if (paramInt != 6)
                                  {
                                    if (paramInt == 9) {
                                      return true;
                                    }
                                    bool1 = false;
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
    return bool1;
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    MessageCache localMessageCache = paramQQAppInterface.getMsgCache();
    byte[] arrayOfByte = null;
    int i = 0;
    Object localObject;
    int j;
    if (paramInt != 1001)
    {
      localObject = arrayOfByte;
      if (paramInt != 1006) {
        if (paramInt != 1010)
        {
          if (paramInt != 1021)
          {
            if (paramInt != 10002)
            {
              if ((paramInt != 1024) && (paramInt != 1025))
              {
                if (paramInt != 1044)
                {
                  if (paramInt != 1045) {
                    localObject = arrayOfByte;
                  } else {
                    localObject = localMessageCache.a(paramString, paramQQAppInterface.getCurrentUin(), false);
                  }
                }
                else {
                  localObject = localMessageCache.b(paramString, paramQQAppInterface.getCurrentUin());
                }
              }
              else
              {
                arrayOfByte = new byte[3];
                byte[] tmp123_121 = arrayOfByte;
                tmp123_121[0] = 1;
                byte[] tmp129_123 = tmp123_121;
                tmp129_123[1] = 1;
                byte[] tmp135_129 = tmp129_123;
                tmp135_129[2] = 58;
                tmp135_129;
                paramString = paramQQAppInterface.getMsgCache().i(paramString);
                j = arrayOfByte.length;
                paramInt = j;
                if (paramString != null) {
                  paramInt = j + paramString.length;
                }
                paramQQAppInterface = new byte[paramInt];
                System.arraycopy(arrayOfByte, 0, paramQQAppInterface, 0, arrayOfByte.length);
                localObject = paramQQAppInterface;
                if (paramString != null)
                {
                  System.arraycopy(paramString, 0, paramQQAppInterface, arrayOfByte.length, paramString.length);
                  localObject = paramQQAppInterface;
                }
              }
            }
            else
            {
              arrayOfByte = new byte[3];
              byte[] tmp215_213 = arrayOfByte;
              tmp215_213[0] = 1;
              byte[] tmp221_215 = tmp215_213;
              tmp221_215[1] = 1;
              byte[] tmp227_221 = tmp221_215;
              tmp227_221[2] = -107;
              tmp227_221;
              paramString = localMessageCache.o(paramString);
              j = arrayOfByte.length;
              paramInt = j;
              if (paramString != null) {
                paramInt = j + paramString.length;
              }
              paramQQAppInterface = new byte[paramInt];
              System.arraycopy(arrayOfByte, 0, paramQQAppInterface, 0, arrayOfByte.length);
              localObject = paramQQAppInterface;
              if (paramString != null)
              {
                System.arraycopy(paramString, 0, paramQQAppInterface, arrayOfByte.length, paramString.length);
                localObject = paramQQAppInterface;
              }
            }
          }
          else {
            localObject = localMessageCache.l(paramString);
          }
        }
        else
        {
          paramQQAppInterface = localMessageCache.u(paramString);
          if (paramQQAppInterface != null)
          {
            localObject = new byte[paramQQAppInterface.length + 3];
            localObject[0] = 1;
            localObject[1] = 1;
            localObject[2] = -119;
            System.arraycopy(paramQQAppInterface, 0, localObject, 3, paramQQAppInterface.length);
          }
          else
          {
            localObject = new byte[3];
            Object tmp364_362 = localObject;
            tmp364_362[0] = 1;
            Object tmp370_364 = tmp364_362;
            tmp370_364[1] = 1;
            Object tmp376_370 = tmp370_364;
            tmp376_370[2] = -119;
            tmp376_370;
          }
        }
      }
    }
    else
    {
      arrayOfByte = new byte[3];
      byte[] tmp393_391 = arrayOfByte;
      tmp393_391[0] = 1;
      byte[] tmp399_393 = tmp393_391;
      tmp399_393[1] = 1;
      byte[] tmp405_399 = tmp399_393;
      tmp405_399[2] = 124;
      tmp405_399;
      paramString = localMessageCache.r(paramString);
      j = arrayOfByte.length;
      paramInt = j;
      if (paramString != null) {
        paramInt = j + paramString.length;
      }
      paramQQAppInterface = new byte[paramInt];
      System.arraycopy(arrayOfByte, 0, paramQQAppInterface, 0, arrayOfByte.length);
      localObject = paramQQAppInterface;
      if (paramString != null)
      {
        System.arraycopy(paramString, 0, paramQQAppInterface, arrayOfByte.length, paramString.length);
        localObject = paramQQAppInterface;
      }
    }
    if (localObject != null)
    {
      paramInt = i;
      while (paramInt < localObject.length)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("sig[");
          paramQQAppInterface.append(paramInt);
          paramQQAppInterface.append("]:");
          paramQQAppInterface.append(localObject[paramInt] & 0xFF);
          QLog.d("VideoMsgTools", 2, paramQQAppInterface.toString());
        }
        paramInt += 1;
      }
    }
    return localObject;
  }
  
  private static void b(long paramLong1, BaseApplicationImpl paramBaseApplicationImpl, int paramInt, boolean paramBoolean, long paramLong2, ArrayList<ResultRecord> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendResultBroadcastToVideoBySwitch, seq[");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("], roomId[");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("], uinType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.w("double_2_multi", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent("tencent.video.q2v.SwitchToMultiAudo");
    ((Intent)localObject).setPackage(paramBaseApplicationImpl.getPackageName());
    ((Intent)localObject).putExtra("result", paramBoolean);
    ((Intent)localObject).putExtra("roomId", paramLong2);
    ((Intent)localObject).putExtra("uinType", paramInt);
    SeqUtil.a((Intent)localObject, paramLong1);
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((ResultRecord)paramArrayList.next()).uin);
    }
    ((Intent)localObject).putStringArrayListExtra("memberUin", localArrayList);
    paramBaseApplicationImpl.sendBroadcast((Intent)localObject);
    if ((paramInt == 3000) && (paramBoolean)) {
      ((QCallFacade)paramBaseApplicationImpl.getRuntime().getManager(QQManagerFactory.RECENT_CALL_FACADE)).a(1, paramLong2, "", "");
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, Object... paramVarArgs)
  {
    long l;
    if (paramString1 != null) {
      l = Long.valueOf(paramString1).longValue();
    } else {
      l = 0L;
    }
    int j = paramQQAppInterface.getAVNotifyCenter().e(l);
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
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
    if (localQQMessageFacade != null)
    {
      boolean bool;
      if (paramInt2 != 20) {
        if (paramInt2 != 22)
        {
          if (paramInt2 != 44)
          {
            if (paramInt2 != 59)
            {
              if (paramInt2 != 60)
              {
                switch (paramInt2)
                {
                default: 
                  switch (paramInt2)
                  {
                  default: 
                    paramVarArgs = paramQQAppInterface.getApp().getString(2131893315);
                  }
                  break;
                }
                for (;;)
                {
                  bool = false;
                  label239:
                  localObject = paramVarArgs;
                  break label1069;
                  paramQQAppInterface.getAVNotifyCenter().c(16, l, 0);
                  paramVarArgs = paramQQAppInterface.getApp().getString(2131893335);
                  continue;
                  paramQQAppInterface.getAVNotifyCenter().c(15, l, 0);
                  paramVarArgs = paramQQAppInterface.getApp().getString(2131893332);
                  continue;
                  paramQQAppInterface.getAVNotifyCenter().c(14, l, 0);
                  paramVarArgs = paramQQAppInterface.getApp().getString(2131893335);
                  continue;
                  paramQQAppInterface.getAVNotifyCenter().c(13, l, 0);
                  paramVarArgs = paramQQAppInterface.getApp().getString(2131893332);
                  continue;
                  paramQQAppInterface.getAVNotifyCenter().c(6, l, 0);
                  if (paramInt1 == 3000)
                  {
                    paramVarArgs = paramQQAppInterface.getApp().getString(2131893264);
                  }
                  else
                  {
                    if (paramInt1 == 1)
                    {
                      paramVarArgs = paramQQAppInterface.getApp().getString(2131893329);
                      continue;
                      paramQQAppInterface.getAVNotifyCenter().c(5, l, 0);
                      if (paramInt1 == 3000)
                      {
                        paramVarArgs = paramQQAppInterface.getApp().getString(2131893263);
                        continue;
                      }
                      if (paramInt1 == 1)
                      {
                        if (paramString3 != null) {
                          paramInt3 = Integer.parseInt(paramString3);
                        } else {
                          paramInt3 = 0;
                        }
                        if (paramInt3 == 19) {
                          paramVarArgs = paramQQAppInterface.getApp().getString(2131893328);
                        } else {
                          paramVarArgs = paramQQAppInterface.getApp().getString(2131893327);
                        }
                        continue;
                        paramQQAppInterface.getAVNotifyCenter().c(4, l, 0);
                        if (paramInt1 == 3000)
                        {
                          paramVarArgs = paramQQAppInterface.getApp().getString(2131893266);
                          continue;
                        }
                        if (paramInt1 == 1)
                        {
                          paramVarArgs = paramQQAppInterface.getApp().getString(2131893330);
                          continue;
                        }
                      }
                    }
                    do
                    {
                      break label1063;
                      paramQQAppInterface.getAVNotifyCenter().c(3, l, 0);
                      if (paramInt1 == 3000)
                      {
                        paramVarArgs = paramQQAppInterface.getApp().getString(2131893289);
                        break;
                      }
                      if (paramInt1 == 1) {
                        paramVarArgs = paramQQAppInterface.getApp().getString(2131893331);
                      } else {
                        paramVarArgs = paramQQAppInterface.getApp().getString(2131893347);
                      }
                      bool = false;
                      break label239;
                      paramQQAppInterface.getAVNotifyCenter().c(1, l, 0);
                      paramVarArgs = a;
                      localObject = new StringBuilder();
                      ((StringBuilder)localObject).append(paramString1);
                      ((StringBuilder)localObject).append(String.valueOf(i));
                      if (!paramVarArgs.containsKey(((StringBuilder)localObject).toString())) {
                        return;
                      }
                      paramVarArgs = a;
                      localObject = new StringBuilder();
                      ((StringBuilder)localObject).append(paramString1);
                      ((StringBuilder)localObject).append(String.valueOf(i));
                      paramVarArgs.remove(((StringBuilder)localObject).toString());
                      paramVarArgs = paramQQAppInterface.getApp().getString(2131893315);
                      bool = true;
                      break label239;
                      if (!str.equals(paramString2)) {
                        break label802;
                      }
                      if (paramInt1 == 3000)
                      {
                        paramVarArgs = paramQQAppInterface.getApp().getString(2131893314);
                        break;
                      }
                    } while (paramInt1 != 1);
                    paramVarArgs = paramQQAppInterface.getApp().getString(2131893338);
                  }
                }
                label802:
                paramVarArgs = ContactUtils.a(paramQQAppInterface, paramString1, paramString2);
                if (paramInt1 == 3000)
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(paramVarArgs);
                  ((StringBuilder)localObject).append(paramQQAppInterface.getApp().getString(2131893313));
                  paramVarArgs = ((StringBuilder)localObject).toString();
                }
                else if (paramInt1 == 1)
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(paramVarArgs);
                  ((StringBuilder)localObject).append(paramQQAppInterface.getApp().getString(2131893336));
                  paramVarArgs = ((StringBuilder)localObject).toString();
                }
                else
                {
                  paramVarArgs = null;
                }
              }
              else
              {
                paramVarArgs = paramQQAppInterface.getApp().getString(2131893351);
              }
            }
            else {
              paramVarArgs = paramQQAppInterface.getApp().getString(2131893352);
            }
          }
          else
          {
            paramVarArgs = new StringBuilder();
            paramVarArgs.append(paramQQAppInterface.getApp().getString(2131917870));
            paramVarArgs.append(paramString3);
            paramVarArgs = paramVarArgs.toString();
          }
        }
        else
        {
          paramQQAppInterface.getAVNotifyCenter().c(2, l, 0);
          paramVarArgs = paramQQAppInterface.getApp().getString(2131893290);
        }
      }
      for (;;)
      {
        bool = false;
        localObject = paramVarArgs;
        break;
        if (paramInt1 == 3000) {
          paramVarArgs = paramQQAppInterface.getApp().getString(2131893279);
        } else if (paramInt1 == 1) {
          paramVarArgs = paramQQAppInterface.getApp().getString(2131893279);
        } else {
          label1063:
          paramVarArgs = null;
        }
      }
      label1069:
      paramVarArgs = (Object[])localObject;
      if (59 != paramInt2)
      {
        paramVarArgs = (Object[])localObject;
        if (paramInt2 != 60)
        {
          paramVarArgs = (Object[])localObject;
          if (i == 2)
          {
            paramVarArgs = (Object[])localObject;
            if (localObject != null)
            {
              if (paramInt1 == 1)
              {
                paramVarArgs = paramQQAppInterface.getAVNotifyCenter().a(l, i);
                if ((paramVarArgs != null) && (paramVarArgs.f == 2) && (paramVarArgs.g == 4))
                {
                  paramInt3 = 1;
                  break label1158;
                }
              }
              paramInt3 = 0;
              label1158:
              if (paramInt3 == 0) {
                paramVarArgs = ((String)localObject).replace(paramQQAppInterface.getApp().getString(2131917338), paramQQAppInterface.getApp().getString(2131917339));
              } else {
                paramVarArgs = ((String)localObject).replace(paramQQAppInterface.getApp().getString(2131917338), paramQQAppInterface.getApp().getString(2131917342));
              }
            }
          }
        }
      }
      paramQQAppInterface = MessageRecordFactory.a(-4008);
      paramQQAppInterface.selfuin = str;
      paramQQAppInterface.frienduin = paramString1;
      paramQQAppInterface.senderuin = str;
      paramQQAppInterface.msg = paramVarArgs;
      paramQQAppInterface.msgtype = -4008;
      paramQQAppInterface.isread = true;
      paramQQAppInterface.issend = 1;
      paramQQAppInterface.istroop = paramInt1;
      paramQQAppInterface.extraflag = 3;
      paramQQAppInterface.time = MessageCache.c();
      Object localObject = new ArrayList();
      ((List)localObject).add(paramQQAppInterface);
      if (bool) {
        localQQMessageFacade.a((List)localObject, str);
      } else {
        localQQMessageFacade.b((List)localObject, str);
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("addTipsMultiVideoMsg, msgType[");
        paramQQAppInterface.append(paramInt2);
        paramQQAppInterface.append("], discussionUin[");
        paramQQAppInterface.append(paramString1);
        paramQQAppInterface.append("], memberUin[");
        paramQQAppInterface.append(paramString2);
        paramQQAppInterface.append("], uinType[");
        paramQQAppInterface.append(paramInt1);
        paramQQAppInterface.append("], extra[");
        paramQQAppInterface.append(paramString3);
        paramQQAppInterface.append("], avtype[");
        paramQQAppInterface.append(i);
        paramQQAppInterface.append("], msgStr[");
        paramQQAppInterface.append(paramVarArgs);
        paramQQAppInterface.append("], bSaveDB[");
        paramQQAppInterface.append(bool);
        paramQQAppInterface.append("]");
        QLog.w("VideoMsgTools", 1, paramQQAppInterface.toString());
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3, Object... paramVarArgs)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addBubbleVideoMsg uinType = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", msgType = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", friendUin = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", senderUin = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", isSender = ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(", time = ");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(", isRead = ");
    ((StringBuilder)localObject).append(paramBoolean3);
    QLog.d("VideoMsgTools", 1, ((StringBuilder)localObject).toString());
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    localObject = a(paramQQAppInterface.getApp(), paramInt2, paramInt1, paramBoolean2, paramString3);
    String str2 = TransfileUtile.makeTransFileProtocolData((String)localObject, paramInt2, 3, paramBoolean1);
    if (paramInt1 == 9500)
    {
      ((DeviceMsgHandle)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a(paramString1, (String)localObject, MessageCache.c(), false, false, true);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof msg_comm.Msg))) {
      paramVarArgs = (msg_comm.Msg)paramVarArgs[0];
    } else {
      paramVarArgs = null;
    }
    long l2;
    if (paramVarArgs != null) {
      l2 = ((msg_comm.MsgHead)paramVarArgs.msg_head.get()).msg_time.get();
    } else {
      l2 = 0L;
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)) && (!"0".equals(paramString1)))
    {
      paramVarArgs = MessageRecordFactory.a(-2009);
      paramVarArgs.selfuin = str1;
      paramVarArgs.frienduin = paramString1;
      paramVarArgs.senderuin = paramString2;
      paramVarArgs.msg = str2;
      paramVarArgs.msgtype = -2009;
      if (paramString2.equals(paramString1)) {
        paramBoolean2 = false;
      }
      paramVarArgs.isread = paramBoolean3;
      if ((paramInt1 != 0) && (paramInt1 != 1000) && (paramInt1 != 1004) && (paramInt1 != 1006) && (paramInt1 != 1021) && (paramInt1 != 1010) && (paramInt1 != 1001) && (paramInt1 != 10002)) {
        break label431;
      }
      paramVarArgs.isread = true;
      label431:
      if (paramBoolean2) {
        paramVarArgs.issend = 1;
      } else {
        paramVarArgs.issend = 0;
      }
      paramVarArgs.istroop = paramInt1;
      paramVarArgs.extraflag = 3;
      paramString2 = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if (paramString2 != null)
      {
        paramString2 = paramString2.a().c(paramString1, paramInt1);
        if (paramString2 != null)
        {
          l1 = paramString2.lastCallTime;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("VideoMsgTools updateDoubleCallStatus lastCallTime = ");
            localStringBuilder.append(paramString2.lastCallTime);
            QLog.d("QCallFacade", 2, localStringBuilder.toString());
            break label561;
          }
          break label561;
        }
      }
      long l1 = 0L;
      label561:
      if (l2 > 0L) {
        paramVarArgs.time = l2;
      } else if (((String)localObject).equals(paramQQAppInterface.getApp().getString(2131917863))) {
        paramVarArgs.time = MessageCache.c();
      } else if ((l1 > 0L) && (paramInt2 != 7)) {
        paramVarArgs.time = MessageCache.c();
      } else {
        paramVarArgs.time = (MessageCache.c() - paramQQAppInterface.getAVNotifyCenter().A());
      }
      ThreadManager.executeOnSubThread(new VideoMsgTools.2(paramQQAppInterface, paramVarArgs, paramBoolean3, str1, (String)localObject, paramInt1, paramBoolean1));
      a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, str1, paramString3, str2);
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "addBubbleVideoMsg end");
      }
      return;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("addBubbleVideoMsg, illegal param, [");
    paramQQAppInterface.append(paramString2);
    paramQQAppInterface.append(",");
    paramQQAppInterface.append(paramString1);
    paramQQAppInterface.append("]");
    QLog.i("VideoMsgTools", 1, paramQQAppInterface.toString());
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addDiscussMember discussUin = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("VideoMsgTools", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    Object localObject1 = new ArrayList();
    if (localObject2 != null)
    {
      int j = ((ArrayList)localObject2).size();
      int i = 0;
      while (i < j)
      {
        localObject3 = (DiscussionMemberInfo)((ArrayList)localObject2).get(i);
        if (localObject3 != null) {
          ((ArrayList)localObject1).add(((DiscussionMemberInfo)localObject3).memberUin);
        }
        i += 1;
      }
    }
    localObject2 = new VideoMsgTools.5(new Handler());
    Object localObject3 = new Intent();
    ((Intent)localObject3).putStringArrayListExtra("param_uins_selected_default", (ArrayList)localObject1);
    ((Intent)localObject3).putExtra("param_groupcode", paramString);
    ((Intent)localObject3).putExtra("param_type", 3000);
    ((Intent)localObject3).putExtra("param_subtype", 1);
    ((Intent)localObject3).putExtra("param_entrance", 11);
    ((Intent)localObject3).putExtra("param_max", 100 - ((ArrayList)localObject1).size());
    ((Intent)localObject3).putExtra("param_donot_need_contacts", true);
    ((Intent)localObject3).putExtra("param_title", paramQQAppInterface.getApplication().getString(2131893435));
    ((Intent)localObject3).putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131888562));
    ((Intent)localObject3).putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131888563));
    ((Intent)localObject3).putExtra("PARAM_ActivityResultReceiver", (Parcelable)localObject2);
    ((Intent)localObject3).addFlags(268435456);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(paramQQAppInterface.getApplicationContext(), (Intent)localObject3);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send_struct_massage_upgrade.peerUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("VideoMsgTools", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = SharedPreUtils.b(paramQQAppInterface.getCurrentAccountUin());
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        localObject = null;
      } else {
        localObject = ((SharedPreferences)localObject).getString("qav_upgrade_invite_multi", null);
      }
    }
    else {
      localObject = ((SharedPreferences)localObject).getString("qav_upgrade_invite_video", null);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("configXML : ");
      localStringBuilder.append((String)localObject);
      QLog.i("VideoMsgTools", 2, localStringBuilder.toString());
    }
    if (localObject != null)
    {
      localObject = TestStructMsg.a((String)localObject);
      if (localObject != null)
      {
        ShareMsgHelper.a(paramQQAppInterface, paramString, 0, (AbsStructMsg)localObject, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("VideoMsgTools", 2, "absMsg is null! use default");
      }
      c(paramQQAppInterface, paramString, paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoMsgTools", 2, "configXML is null! use default");
    }
    c(paramQQAppInterface, paramString, paramInt);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 20) || (paramInt == 19) || (paramInt == 44) || (paramInt == 59) || (paramInt == 60) || (paramInt == 22) || (paramInt == 69) || (paramInt == 68) || (paramInt == 71) || (paramInt == 70);
  }
  
  static void c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject1 = paramQQAppInterface.getApp().getApplicationContext().getString(2131893694);
    Object localObject2 = paramQQAppInterface.getApp().getApplicationContext().getString(2131893693);
    localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(62).a((String)localObject2).e("https://im.qq.com/mobileqq/touch").a((String)localObject1, null).a();
    localObject2 = StructMsgElementFactory.a(2);
    String str = paramQQAppInterface.getApp().getApplicationContext().getString(2131893697);
    ((AbsStructMsgItem)localObject2).a("https://url.cn/hw298C", paramQQAppInterface.getApp().getApplicationContext().getString(2131893699), str);
    ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
    ShareMsgHelper.a(paramQQAppInterface, paramString, 0, (AbsStructMsg)localObject1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools
 * JD-Core Version:    0.7.0.1
 */