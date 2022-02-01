package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.MessageForReminder;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a.MsgBody;

public class QQNotifyHelper
{
  public static int a(byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0x13a.MsgBody();
    try
    {
      ((submsgtype0x13a.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      JSONObject localJSONObject = new JSONObject(((submsgtype0x13a.MsgBody)localObject).bytes_push_data.get().toStringUtf8()).optJSONObject("ark_data");
      localObject = localJSONObject;
      if (paramArrayOfByte != null) {
        localObject = localJSONObject.getJSONObject("meta");
      }
      paramArrayOfByte = (byte[])localObject;
      if (localObject != null) {
        paramArrayOfByte = ((JSONObject)localObject).optJSONObject("metaData");
      }
      if (paramArrayOfByte == null) {
        break label90;
      }
      int i = paramArrayOfByte.optInt("friend_type");
      return i;
    }
    catch (JSONException paramArrayOfByte) {}catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    QLog.e("QQNotifyHelper", 1, "parse Friend type error: ", paramArrayOfByte);
    label90:
    return -1;
  }
  
  public static String a(int paramInt)
  {
    String str = HardCodeUtil.a(2131914388);
    if (paramInt == 1) {
      str = HardCodeUtil.a(2131914389);
    }
    return str;
  }
  
  public static String a(AcsMsg paramAcsMsg)
  {
    if (paramAcsMsg == null) {
      return null;
    }
    if (paramAcsMsg.type == 0) {
      return paramAcsMsg.msg_id;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAcsMsg.msg_id);
    localStringBuilder.append("-");
    localStringBuilder.append(paramAcsMsg.sub_time);
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    String str = HardCodeUtil.a(2131914469);
    if ((paramInt1 != 0) && (paramInt1 != 6))
    {
      if (paramInt1 == -1) {
        str = HardCodeUtil.a(2131914469);
      }
    }
    else {
      str = a(paramInt2);
    }
    QQToast.makeText(paramContext, 2, str, 0).show();
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQNotifyHelper", 1, "doReport app is null");
      }
      return;
    }
    HashMap localHashMap = new HashMap(12);
    localHashMap.put("time_stamp", String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    localHashMap.put("bussiness_id", paramString2);
    localHashMap.put("remind_id", paramString3);
    localHashMap.put("uin", paramAppInterface.getCurrentAccountUin());
    if (paramString4 != null) {
      localHashMap.put("flag1", paramString4);
    }
    if (paramString5 != null) {
      localHashMap.put("flag2", paramString5);
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", paramString1, true, 0L, 0L, localHashMap, "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator = paramQQAppInterface.getMessageFacade().h(AppConstants.ACTIVATE_FRIENDS_UIN, 9002).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (a(localMessageRecord))
      {
        QLog.d("QQNotifyHelper", 1, new Object[] { "delete msg: ", Long.valueOf(System.currentTimeMillis()), " msgTime: ", Long.valueOf(localMessageRecord.time * 1000L) });
        paramQQAppInterface.getMessageFacade().h(QQConstants.a, 9002, localMessageRecord.uniseq);
      }
    }
  }
  
  private static boolean a(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForReminder)) && (b(paramMessageRecord.msgData)))
    {
      long l = paramMessageRecord.time;
      if (System.currentTimeMillis() - l * 1000L > 86400000L) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b(byte[] paramArrayOfByte)
  {
    submsgtype0x13a.MsgBody localMsgBody = new submsgtype0x13a.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      boolean bool = TextUtils.equals("97f2e3f9e7a46a25a4e986296e5ab4b1", new JSONObject(localMsgBody.bytes_push_data.get().toStringUtf8()).optString("msg_id"));
      return bool;
    }
    catch (JSONException paramArrayOfByte) {}catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    QLog.e("QQNotifyHelper", 1, "parse Friend type error: ", paramArrayOfByte);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifyHelper
 * JD-Core Version:    0.7.0.1
 */