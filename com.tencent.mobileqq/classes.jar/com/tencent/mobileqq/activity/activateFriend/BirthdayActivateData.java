package com.tencent.mobileqq.activity.activateFriend;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneBirthdayFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneGiftMessage;

public class BirthdayActivateData
{
  public static String a()
  {
    try
    {
      Object localObject1 = new JSONObject();
      localObject2 = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      ((JSONObject)localObject1).put("app", "com.tencent.giftmall.greeting");
      ((JSONObject)localObject1).put("view", "greeting-0");
      ((JSONObject)localObject1).put("ver", "1.0.4.1");
      ((JSONObject)localObject2).put("greetingData", localJSONObject);
      ((JSONObject)localObject1).put("meta", localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" @arkgif getEmptyErroJson json data =");
      ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
      QLog.i("BirthdayActivateData", 1, ((StringBuilder)localObject2).toString());
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getEmptyErroJson");
      ((StringBuilder)localObject2).append(localException.toString());
      QLog.e("BirthdayActivateData", 1, ((StringBuilder)localObject2).toString());
    }
    return null;
  }
  
  public static String a(SubMsgType0x76.BirthdayNotify paramBirthdayNotify, QQAppInterface paramQQAppInterface)
  {
    Object localObject5 = paramBirthdayNotify;
    Object localObject1 = "BirthdayActivateData";
    Object localObject2 = localObject1;
    label1290:
    label1304:
    label1311:
    label1318:
    for (;;)
    {
      try
      {
        Object localObject4 = new JSONObject();
        localObject2 = localObject1;
        JSONObject localJSONObject1 = new JSONObject();
        localObject2 = localObject1;
        JSONObject localJSONObject2 = new JSONObject();
        localObject2 = localObject1;
        ((JSONObject)localObject4).put("app", "com.tencent.giftmall.greeting");
        localObject2 = localObject1;
        localJSONObject2.put("ua", WebSoUtils.a());
        String str2 = "meta";
        String str1 = "greetingData";
        if (localObject5 == null)
        {
          localObject2 = localObject1;
          ((JSONObject)localObject4).put("view", "greeting-0");
          localObject2 = localObject1;
          ((JSONObject)localObject4).put("ver", "1.0.4.1");
          localObject2 = localObject1;
          localJSONObject1.put("greetingData", localJSONObject2);
          localObject2 = localObject1;
          ((JSONObject)localObject4).put("meta", localJSONObject1);
          localObject2 = localObject1;
          paramBirthdayNotify = new StringBuilder();
          localObject2 = localObject1;
          paramBirthdayNotify.append("@arkgif msg_birthday_info is null  =");
          localObject2 = localObject1;
          paramBirthdayNotify.append(((JSONObject)localObject4).toString());
          localObject2 = localObject1;
          QLog.i("BirthdayActivateData", 1, paramBirthdayNotify.toString());
          localObject2 = localObject1;
          return ((JSONObject)localObject4).toString();
        }
        localObject2 = localObject1;
        String str3 = ((SubMsgType0x76.BirthdayNotify)localObject5).str_extend.get();
        localObject2 = localObject1;
        String str4;
        Object localObject6;
        boolean bool;
        if (!TextUtils.isEmpty(str3))
        {
          localObject2 = localObject1;
          localObject3 = new JSONObject(str3);
          localObject2 = localObject1;
          str4 = ((JSONObject)localObject3).getString("type");
          localObject2 = localObject1;
          localObject6 = ((JSONObject)localObject3).getString("ver");
          localObject2 = localObject1;
          bool = TextUtils.isEmpty(str4);
          if (bool) {
            break label1304;
          }
          localObject3 = str4;
          localObject2 = localObject1;
          if ("null".equals(str4)) {
            break label1304;
          }
          localObject2 = localObject1;
          ((JSONObject)localObject4).put("view", localObject3);
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject6)) {
            break label1311;
          }
          localObject3 = localObject6;
          localObject2 = localObject1;
          if ("null".equals(localObject6)) {
            break label1311;
          }
          localObject2 = localObject1;
          ((JSONObject)localObject4).put("ver", localObject3);
          localObject2 = localObject1;
          localObject3 = new StringBuilder();
          localObject2 = localObject1;
          ((StringBuilder)localObject3).append("@arkgif strExtend = ");
          localObject2 = localObject1;
          ((StringBuilder)localObject3).append(str3);
          localObject2 = localObject1;
          QLog.i("BirthdayActivateData", 1, ((StringBuilder)localObject3).toString());
        }
        else
        {
          localObject2 = localObject1;
          QLog.i("BirthdayActivateData", 1, "@arkgif json data strExtend is null  =");
          localObject2 = localObject1;
          ((JSONObject)localObject4).put("view", "greeting-0");
          localObject2 = localObject1;
          ((JSONObject)localObject4).put("ver", "1.0.4.1");
        }
        localObject2 = localObject1;
        localJSONObject2.put("str_extend", str3);
        localObject2 = localObject1;
        int i = ((SubMsgType0x76.BirthdayNotify)localObject5).rpt_msg_one_friend.get().size();
        localObject2 = localObject1;
        localObject5 = new JSONArray();
        int j = 0;
        localObject3 = localObject4;
        localObject4 = paramBirthdayNotify;
        long l1;
        if (j < i)
        {
          localObject2 = localObject1;
          l1 = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.BirthdayNotify)localObject4).rpt_msg_one_friend.get().get(j)).uint64_uin.get();
          localObject2 = localObject1;
          bool = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.BirthdayNotify)localObject4).rpt_msg_one_friend.get().get(j)).bool_lunar_birth.get();
          localObject2 = localObject1;
          k = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.BirthdayNotify)localObject4).rpt_msg_one_friend.get().get(j)).uint32_birth_month.get();
        }
        try
        {
          m = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.BirthdayNotify)localObject4).rpt_msg_one_friend.get().get(j)).uint32_birth_date.get();
          n = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.BirthdayNotify)localObject4).rpt_msg_one_friend.get().get(j)).uint32_birth_year.get();
          long l2 = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.BirthdayNotify)localObject4).rpt_msg_one_friend.get().get(j)).uint64_msg_send_time.get();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append("");
          localObject2 = ContactUtils.a(paramQQAppInterface, ((StringBuilder)localObject2).toString(), true);
          localObject4 = new JSONObject();
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append(l1);
          ((StringBuilder)localObject6).append("");
          ((JSONObject)localObject4).put("friendUin", ((StringBuilder)localObject6).toString());
          ((JSONObject)localObject4).put("lunarBirthday", bool);
          ((JSONObject)localObject4).put("birthdayYear", n);
          ((JSONObject)localObject4).put("birthdayMonth", k);
          ((JSONObject)localObject4).put("birthdayDay", m);
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append(l2);
          ((StringBuilder)localObject6).append("");
          ((JSONObject)localObject4).put("messageSendTime", ((StringBuilder)localObject6).toString());
          ((JSONObject)localObject4).put("nickName", localObject2);
          ((JSONArray)localObject5).put(j, localObject4);
          j += 1;
        }
        catch (Exception paramBirthdayNotify)
        {
          int m;
          int n;
          int i1;
          int i2;
          break label1290;
        }
        paramQQAppInterface = (QQAppInterface)localObject1;
        localJSONObject2.put("friendModels", localObject5);
        int k = paramBirthdayNotify.rpt_gift_msg.get().size();
        localObject2 = new JSONArray();
        j = 0;
        if (j < k)
        {
          localObject4 = new JSONObject();
          m = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(j)).gift_id.get();
          localObject5 = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(j)).gift_name.get();
          n = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(j)).type.get();
          localObject6 = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(j)).gift_url.get();
          i1 = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(j)).price.get();
          i2 = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(j)).play_cnt.get();
          str4 = ((SubMsgType0x76.OneGiftMessage)paramBirthdayNotify.rpt_gift_msg.get().get(j)).background_color.get();
          ((JSONObject)localObject4).put("gift_id", m);
          ((JSONObject)localObject4).put("gift_name", localObject5);
          ((JSONObject)localObject4).put("gift_type", n);
          ((JSONObject)localObject4).put("gift_url", localObject6);
          ((JSONObject)localObject4).put("gift_price", i1);
          ((JSONObject)localObject4).put("play_count", i2);
          ((JSONObject)localObject4).put("bgColorStr", str4);
          ((JSONArray)localObject2).put(j, localObject4);
          j += 1;
          continue;
        }
        localJSONObject2.put("giftModels", localObject2);
        localJSONObject1.put(str1, localJSONObject2);
        ((JSONObject)localObject3).put(str2, localJSONObject1);
        if (!QLog.isColorLevel()) {
          break label1318;
        }
        paramBirthdayNotify = new StringBuilder();
        paramBirthdayNotify.append("@arkgif json data friendnum=");
        paramBirthdayNotify.append(i);
        paramBirthdayNotify.append("strExtend = ");
        paramBirthdayNotify.append(str3);
        paramBirthdayNotify = paramBirthdayNotify.toString();
        localObject2 = paramQQAppInterface;
        QLog.i(paramQQAppInterface, 1, paramBirthdayNotify);
        localObject2 = localObject1;
        paramBirthdayNotify = ((JSONObject)localObject3).toString();
        return paramBirthdayNotify;
      }
      catch (Exception paramBirthdayNotify)
      {
        localObject1 = localObject2;
      }
      QLog.e((String)localObject1, 1, paramBirthdayNotify.toString());
      return a();
      Object localObject3 = "greeting-0";
      continue;
      localObject3 = "1.0.4.1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.BirthdayActivateData
 * JD-Core Version:    0.7.0.1
 */