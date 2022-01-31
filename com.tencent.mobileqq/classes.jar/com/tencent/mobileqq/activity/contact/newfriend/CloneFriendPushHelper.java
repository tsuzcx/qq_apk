package com.tencent.mobileqq.activity.contact.newfriend;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
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
  public static final HashMap a;
  public static final HashSet a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaUtilHashSet)
    {
      jdField_a_of_type_Boolean = false;
      jdField_a_of_type_JavaUtilHashSet.clear();
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "initSet, uin=" + paramQQAppInterface.c() + ", hasInit=" + jdField_a_of_type_Boolean);
    }
    synchronized (jdField_a_of_type_JavaUtilHashSet)
    {
      if (jdField_a_of_type_Boolean) {
        return;
      }
      jdField_a_of_type_JavaUtilHashSet.clear();
      paramQQAppInterface = paramQQAppInterface.getPreferences().getStringSet("cloneFriendPush_" + paramQQAppInterface.c(), null);
      if (paramQQAppInterface != null) {
        jdField_a_of_type_JavaUtilHashSet.addAll(paramQQAppInterface);
      }
      jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "removeUin, uin=" + paramString);
    }
    synchronized (jdField_a_of_type_JavaUtilHashSet)
    {
      if (!jdField_a_of_type_Boolean) {
        a(paramQQAppInterface);
      }
      if (jdField_a_of_type_JavaUtilHashSet.contains(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CloneFriendPushHelper", 2, "addUin, contains, need remove");
        }
        jdField_a_of_type_JavaUtilHashSet.remove(paramString);
        paramQQAppInterface.getPreferences().edit().putStringSet("cloneFriendPush_" + paramQQAppInterface.c(), jdField_a_of_type_JavaUtilHashSet).commit();
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SubMsgType0x87.MsgBody paramMsgBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "onLinePush onReceivePush, app=" + paramQQAppInterface + ", msgBody=" + paramMsgBody);
    }
    List localList = paramMsgBody.rpt_msg_msg_notify.get();
    String str2;
    String str1;
    String str3;
    int j;
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      if (i < localList.size())
      {
        paramMsgBody = (SubMsgType0x87.MsgNotify)localList.get(i);
        if ((paramMsgBody != null) && (paramMsgBody.uint32_reqsubtype.get() == 2) && (paramMsgBody.msg_clone_info.has()))
        {
          localObject = (SubMsgType0x87.CloneInfo)paramMsgBody.msg_clone_info.get();
          if (localObject != null)
          {
            paramMsgBody = String.valueOf(((SubMsgType0x87.CloneInfo)localObject).uint64_uin.get());
            str2 = ((SubMsgType0x87.CloneInfo)localObject).bytes_remark.get().toStringUtf8();
            if (((SubMsgType0x87.CloneInfo)localObject).uint32_show_in_aio.get() != 1) {
              break label298;
            }
          }
        }
        label298:
        for (boolean bool = true;; bool = false)
        {
          str1 = String.valueOf(((SubMsgType0x87.CloneInfo)localObject).uint64_to_uin.get());
          str3 = ((SubMsgType0x87.CloneInfo)localObject).bytes_to_nick.get().toStringUtf8();
          j = ((SubMsgType0x87.CloneInfo)localObject).uint32_src_gender.get();
          if (QLog.isColorLevel()) {
            QLog.d("CloneFriendPushHelper", 2, "cloneInfo, uinC=" + paramMsgBody + ", nickC=" + str2 + ", showInAio=" + bool + ", uinB=" + str1 + ", nickB=" + str3 + ", gender=" + j);
          }
          if (bool) {
            break label304;
          }
          i += 1;
          break;
        }
        label304:
        localObject = str1 + paramMsgBody + paramQQAppInterface.c();
        if (jdField_a_of_type_JavaUtilHashMap.get(localObject) != null) {
          break label389;
        }
      }
    }
    label389:
    for (long l1 = 0L;; l1 = ((Long)jdField_a_of_type_JavaUtilHashMap.get(localObject)).longValue())
    {
      long l2 = System.currentTimeMillis();
      jdField_a_of_type_JavaUtilHashMap.put(localObject, Long.valueOf(l2));
      if (Math.abs(l2 - l1) >= 60000L) {
        break;
      }
      QLog.d("CloneFriendPushHelper", 1, "onReceivePush, gap < 60s");
      return;
    }
    Object localObject = new MessageForUniteGrayTip();
    String str4 = String.format("你的好友%s(%s)通过", new Object[] { str2, paramMsgBody });
    if (j == 1) {}
    for (paramMsgBody = "她";; paramMsgBody = "他")
    {
      paramMsgBody = String.format("会员好友克隆功能快速添加好友，将你添加到了%s的新号码%s(%s)的好友列表中。", new Object[] { paramMsgBody, str3, str1 });
      paramMsgBody = new UniteGrayTipParam(str1, str1, str4 + paramMsgBody, 0, -5040, 2686977, MessageCache.a());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 1);
      localBundle.putString("key_action_DATA", "http://mq.vip.qq.com/m/friendclone?_wv=1&_wwv=4");
      paramMsgBody.a(str4.length(), str4.length() + 8, localBundle);
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramMsgBody);
      UniteGrayTipUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
      paramMsgBody = new MessageForText();
      paramMsgBody.istroop = 0;
      paramMsgBody.frienduin = str1;
      paramMsgBody.senderuin = str1;
      paramMsgBody.isread = true;
      paramMsgBody.msg = String.format("我是%s，%s(%s)是我的新qq号，以后可以通过这个号联系我。", new Object[] { str2, str3, str1 });
      paramMsgBody.time = MessageCache.a();
      paramQQAppInterface.a().a(paramMsgBody, paramQQAppInterface.c());
      paramMsgBody = new MessageForUniteGrayTip();
      paramMsgBody.initGrayTipMsg(paramQQAppInterface, new UniteGrayTipParam(str1, str1, "以上是打招呼内容", 0, -5020, 2686977, MessageCache.a()));
      UniteGrayTipUtil.a(paramQQAppInterface, paramMsgBody);
      paramQQAppInterface.reportClickEvent("CliOper", "", "", "0X8008071", "0X8008071", 0, 0, "", "", "", "");
      b(paramQQAppInterface, str1);
      break;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilHashSet)
    {
      if (!jdField_a_of_type_Boolean) {
        a(paramQQAppInterface);
      }
      boolean bool = jdField_a_of_type_JavaUtilHashSet.contains(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("CloneFriendPushHelper", 2, "hasUin, uin=" + paramString + ", has=" + bool);
      }
      return bool;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "addUin, uin=" + paramString);
    }
    synchronized (jdField_a_of_type_JavaUtilHashSet)
    {
      if (!jdField_a_of_type_Boolean) {
        a(paramQQAppInterface);
      }
      if (!jdField_a_of_type_JavaUtilHashSet.contains(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CloneFriendPushHelper", 2, "addUin, not contains, need add");
        }
        jdField_a_of_type_JavaUtilHashSet.add(paramString);
        paramQQAppInterface.getPreferences().edit().putStringSet("cloneFriendPush_" + paramQQAppInterface.c(), jdField_a_of_type_JavaUtilHashSet).commit();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.CloneFriendPushHelper
 * JD-Core Version:    0.7.0.1
 */