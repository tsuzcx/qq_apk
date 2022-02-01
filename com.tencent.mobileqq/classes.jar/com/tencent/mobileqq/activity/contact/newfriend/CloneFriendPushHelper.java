package com.tencent.mobileqq.activity.contact.newfriend;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.CloneInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgNotify;

@TargetApi(11)
public class CloneFriendPushHelper
{
  public static boolean a = false;
  public static final HashSet<String> b = new HashSet();
  public static final HashMap<String, Long> c = new HashMap();
  
  public static void a()
  {
    synchronized (b)
    {
      a = false;
      b.clear();
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("removeUin, uin=");
      ((StringBuilder)???).append(paramString);
      QLog.d("CloneFriendPushHelper", 2, ((StringBuilder)???).toString());
    }
    synchronized (b)
    {
      if (!a) {
        a(paramQQAppInterface);
      }
      if (b.contains(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CloneFriendPushHelper", 2, "addUin, contains, need remove");
        }
        b.remove(paramString);
        paramString = paramQQAppInterface.getPreferences().edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cloneFriendPush_");
        localStringBuilder.append(paramQQAppInterface.getCurrentUin());
        paramString.putStringSet(localStringBuilder.toString(), b).commit();
      }
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    MessageForText localMessageForText = new MessageForText();
    localMessageForText.istroop = 0;
    localMessageForText.frienduin = paramString2;
    localMessageForText.senderuin = paramString2;
    localMessageForText.isread = true;
    localMessageForText.msg = String.format(HardCodeUtil.a(2131900155), new Object[] { paramString1, paramString3, paramString2 });
    localMessageForText.time = MessageCache.c();
    paramQQAppInterface.getMessageFacade().a(localMessageForText, paramQQAppInterface.getCurrentUin());
  }
  
  static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt);
    a(paramQQAppInterface, paramString2, paramString3, paramString4);
    d(paramQQAppInterface, paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SubMsgType0x87.MsgBody paramMsgBody)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLinePush onReceivePush, app=");
      ((StringBuilder)localObject1).append(paramQQAppInterface);
      ((StringBuilder)localObject1).append(", msgBody=");
      ((StringBuilder)localObject1).append(paramMsgBody);
      QLog.d("CloneFriendPushHelper", 2, ((StringBuilder)localObject1).toString());
    }
    paramMsgBody = paramMsgBody.rpt_msg_msg_notify.get();
    if ((paramMsgBody != null) && (paramMsgBody.size() > 0))
    {
      int i = 0;
      while (i < paramMsgBody.size())
      {
        localObject1 = (SubMsgType0x87.MsgNotify)paramMsgBody.get(i);
        if ((localObject1 != null) && (((SubMsgType0x87.MsgNotify)localObject1).uint32_reqsubtype.get() == 2) && (((SubMsgType0x87.MsgNotify)localObject1).msg_clone_info.has()))
        {
          Object localObject2 = (SubMsgType0x87.CloneInfo)((SubMsgType0x87.MsgNotify)localObject1).msg_clone_info.get();
          if (localObject2 != null)
          {
            localObject1 = String.valueOf(((SubMsgType0x87.CloneInfo)localObject2).uint64_uin.get());
            String str1 = ((SubMsgType0x87.CloneInfo)localObject2).bytes_remark.get().toStringUtf8();
            boolean bool;
            if (((SubMsgType0x87.CloneInfo)localObject2).uint32_show_in_aio.get() == 1) {
              bool = true;
            } else {
              bool = false;
            }
            String str2 = String.valueOf(((SubMsgType0x87.CloneInfo)localObject2).uint64_to_uin.get());
            String str3 = ((SubMsgType0x87.CloneInfo)localObject2).bytes_to_nick.get().toStringUtf8();
            int j = ((SubMsgType0x87.CloneInfo)localObject2).uint32_src_gender.get();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("cloneInfo, uinC=");
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(", nickC=");
              ((StringBuilder)localObject2).append(str1);
              ((StringBuilder)localObject2).append(", showInAio=");
              ((StringBuilder)localObject2).append(bool);
              ((StringBuilder)localObject2).append(", uinB=");
              ((StringBuilder)localObject2).append(str2);
              ((StringBuilder)localObject2).append(", nickB=");
              ((StringBuilder)localObject2).append(str3);
              ((StringBuilder)localObject2).append(", gender=");
              ((StringBuilder)localObject2).append(j);
              QLog.d("CloneFriendPushHelper", 2, ((StringBuilder)localObject2).toString());
            }
            if (bool)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(str2);
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(paramQQAppInterface.getCurrentUin());
              localObject2 = ((StringBuilder)localObject2).toString();
              long l1;
              if (c.get(localObject2) == null) {
                l1 = 0L;
              } else {
                l1 = ((Long)c.get(localObject2)).longValue();
              }
              long l2 = System.currentTimeMillis();
              c.put(localObject2, Long.valueOf(l2));
              if (Math.abs(l2 - l1) < 60000L)
              {
                QLog.d("CloneFriendPushHelper", 1, "onReceivePush, gap < 60s");
                return;
              }
              a(paramQQAppInterface, (String)localObject1, str1, str2, str3, j);
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8008071", "0X8008071", 0, 0, "", "", "", "");
              c(paramQQAppInterface, str2);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("initSet, uin=");
      ((StringBuilder)???).append(paramQQAppInterface.getCurrentUin());
      ((StringBuilder)???).append(", hasInit=");
      ((StringBuilder)???).append(a);
      QLog.d("CloneFriendPushHelper", 2, ((StringBuilder)???).toString());
    }
    synchronized (b)
    {
      if (a) {
        return false;
      }
      b.clear();
      SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cloneFriendPush_");
      localStringBuilder.append(paramQQAppInterface.getCurrentUin());
      paramQQAppInterface = localSharedPreferences.getStringSet(localStringBuilder.toString(), null);
      if (paramQQAppInterface != null) {
        b.addAll(paramQQAppInterface);
      }
      a = true;
      return true;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    Object localObject1 = HardCodeUtil.a(2131900158);
    paramString2 = String.format("%s(%s)", new Object[] { paramString2, paramString1 });
    String str1 = HardCodeUtil.a(2131900156);
    if (paramInt == 1) {
      paramInt = 2131900150;
    } else {
      paramInt = 2131900153;
    }
    String str2 = String.format(str1, new Object[] { HardCodeUtil.a(paramInt) });
    String str3 = String.format("%s(%s)", new Object[] { paramString4, paramString3 });
    paramString4 = HardCodeUtil.a(2131900154);
    str1 = HardCodeUtil.a(2131900151);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append(str3);
    ((StringBuilder)localObject2).append("的好友列表中。\n不想和他们是好友关系，可选择");
    ((StringBuilder)localObject2).append(paramString4);
    ((StringBuilder)localObject2).append("。\n不想再被其他好友克隆，可选择");
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append("。");
    localObject2 = new UniteGrayTipParam(paramString3, paramString3, ((StringBuilder)localObject2).toString(), 0, -5040, 2686977, MessageCache.c());
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", 44);
    localBundle.putString("key_action_DATA", paramString1);
    paramInt = ((String)localObject1).length();
    ((UniteGrayTipParam)localObject2).a(paramInt, paramString2.length() + paramInt, localBundle);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 44);
    ((Bundle)localObject1).putString("key_action_DATA", paramString3);
    paramInt = paramInt + paramString2.length() + str2.length();
    ((UniteGrayTipParam)localObject2).a(paramInt, str3.length() + paramInt, (Bundle)localObject1);
    paramString3 = new Bundle();
    paramString3.putInt("key_action", 45);
    paramString3.putString("key_action_DATA", paramString1);
    paramString3.putString("key_a_action_DATA", String.format(HardCodeUtil.a(2131900157), new Object[] { paramString2, str3 }));
    paramInt = paramInt + str3.length() + 22;
    ((UniteGrayTipParam)localObject2).a(paramInt, paramString4.length() + paramInt, paramString3);
    paramString1 = new Bundle();
    paramString1.putInt("key_action", 1);
    paramString1.putString("key_action_DATA", "https://ti.qq.com/friendship_auth/index.html?_wv=3#clone_setting");
    paramInt = paramInt + paramString4.length() + 16;
    ((UniteGrayTipParam)localObject2).a(paramInt, str1.length() + paramInt, paramString1);
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject2);
    UniteGrayTipMsgUtil.a(paramQQAppInterface, localMessageForUniteGrayTip);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    synchronized (b)
    {
      if (!a) {
        a(paramQQAppInterface);
      }
      boolean bool = b.contains(paramString);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("hasUin, uin=");
        paramQQAppInterface.append(paramString);
        paramQQAppInterface.append(", has=");
        paramQQAppInterface.append(bool);
        QLog.d("CloneFriendPushHelper", 2, paramQQAppInterface.toString());
      }
      return bool;
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("addUin, uin=");
      ((StringBuilder)???).append(paramString);
      QLog.d("CloneFriendPushHelper", 2, ((StringBuilder)???).toString());
    }
    synchronized (b)
    {
      if (!a) {
        a(paramQQAppInterface);
      }
      if (!b.contains(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CloneFriendPushHelper", 2, "addUin, not contains, need add");
        }
        b.add(paramString);
        paramString = paramQQAppInterface.getPreferences().edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cloneFriendPush_");
        localStringBuilder.append(paramQQAppInterface.getCurrentUin());
        paramString.putStringSet(localStringBuilder.toString(), b).commit();
      }
      return;
    }
  }
  
  private static void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, new UniteGrayTipParam(paramString, paramString, HardCodeUtil.a(2131900152), 0, -5020, 2686977, MessageCache.c()));
    UniteGrayTipMsgUtil.a(paramQQAppInterface, localMessageForUniteGrayTip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.CloneFriendPushHelper
 * JD-Core Version:    0.7.0.1
 */