package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.Statistic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class NewReportPlugin
{
  public static boolean a = false;
  private static String b = "https://jubao.qq.com/uniform_impeach/impeach_entry";
  private static String c = "https://juabotest.qq.com/uniform_impeach/impeach_entry";
  
  public static Bundle a(int paramInt, QBaseActivity paramQBaseActivity, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramQBaseActivity = paramBundle.getString("chatuin");
    } else {
      paramQBaseActivity = null;
    }
    int i;
    if (paramBundle != null) {
      i = paramBundle.getInt("chattype");
    } else {
      i = -1;
    }
    label56:
    int j;
    if (paramInt == 20008)
    {
      paramString1 = paramQBaseActivity;
      if (TextUtils.isEmpty(paramQBaseActivity)) {
        paramString1 = paramString2;
      }
      j = 1;
      i = 1;
      paramQBaseActivity = paramString1;
    }
    else
    {
      if (paramInt == 20013)
      {
        paramString1 = paramQBaseActivity;
        if (TextUtils.isEmpty(paramQBaseActivity)) {
          paramString1 = paramString2;
        }
        i = 3000;
        paramQBaseActivity = paramString1;
      }
      for (;;)
      {
        j = 1;
        break label478;
        if (paramInt == 20015)
        {
          paramString2 = paramQBaseActivity;
          if (TextUtils.isEmpty(paramQBaseActivity)) {
            paramString2 = paramString1;
          }
          i = 1044;
          paramQBaseActivity = paramString2;
        }
        else if (paramInt == 25020)
        {
          paramString2 = paramQBaseActivity;
          if (TextUtils.isEmpty(paramQBaseActivity)) {
            paramString2 = paramString1;
          }
          i = 1045;
          paramQBaseActivity = paramString2;
        }
        else if (paramInt == 20016)
        {
          paramString2 = paramQBaseActivity;
          if (TextUtils.isEmpty(paramQBaseActivity)) {
            paramString2 = paramString1;
          }
          i = 1000;
          paramQBaseActivity = paramString2;
        }
        else if (paramInt == 20019)
        {
          paramString2 = paramQBaseActivity;
          if (TextUtils.isEmpty(paramQBaseActivity)) {
            paramString2 = paramString1;
          }
          i = 1004;
          paramQBaseActivity = paramString2;
        }
        else if (paramInt == 20017)
        {
          paramString2 = paramQBaseActivity;
          if (TextUtils.isEmpty(paramQBaseActivity)) {
            paramString2 = paramString1;
          }
          i = 1022;
          paramQBaseActivity = paramString2;
        }
        else if (paramInt == 20018)
        {
          paramString2 = paramQBaseActivity;
          if (TextUtils.isEmpty(paramQBaseActivity)) {
            paramString2 = paramString1;
          }
          i = 10002;
          paramQBaseActivity = paramString2;
        }
        else
        {
          if (paramInt == 21001)
          {
            paramString2 = paramQBaseActivity;
            if (TextUtils.isEmpty(paramQBaseActivity)) {
              paramString2 = paramString1;
            }
            j = 1;
            i = 0;
            paramQBaseActivity = paramString2;
            break label478;
          }
          if (paramInt == 22003)
          {
            paramString1 = paramQBaseActivity;
            if (!TextUtils.isEmpty(paramQBaseActivity)) {
              break label56;
            }
            break;
          }
          if (paramInt == 25028)
          {
            paramString1 = paramQBaseActivity;
            if (TextUtils.isEmpty(paramQBaseActivity)) {
              paramString1 = paramString2;
            }
            i = 10010;
            paramQBaseActivity = paramString1;
          }
          else
          {
            if (paramInt == 25029)
            {
              paramString1 = paramQBaseActivity;
              if (!TextUtils.isEmpty(paramQBaseActivity)) {
                break label56;
              }
              break;
            }
            if ((paramInt != 25080) && (paramInt != 25086) && (paramInt != 25082) && (paramInt != 25098) && (paramInt != 25099) && (paramInt != 25090))
            {
              j = 0;
              break label478;
            }
            i = 10014;
            if ((paramInt != 25080) && (paramInt != 25082) && (paramInt != 25098) && (paramInt != 25099) && (paramInt != 25090)) {
              paramBundle.putString("groupcode", "");
            } else {
              paramBundle.putString("groupcode", paramString2);
            }
          }
        }
      }
    }
    label478:
    paramString1 = paramBundle;
    if (j != 0) {
      if (paramBundle == null)
      {
        paramString1 = a(paramQBaseActivity, i);
      }
      else if (paramBundle.containsKey("chatuin"))
      {
        paramString1 = paramBundle;
        if (paramBundle.containsKey("chattype")) {}
      }
      else
      {
        paramBundle.putString("chatuin", paramQBaseActivity);
        paramBundle.putInt("chattype", i);
        paramString1 = paramBundle;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("preDealReportForScene [%s, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramQBaseActivity, Integer.valueOf(i) }));
    }
    return paramString1;
  }
  
  public static Bundle a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return new Bundle();
    }
    Bundle localBundle = a(paramSessionInfo.b, paramSessionInfo.a);
    if ((paramSessionInfo.a == 1033) || (paramSessionInfo.a == 1034))
    {
      localBundle.putInt("topicid", paramSessionInfo.v);
      localBundle.putString("uinname", paramSessionInfo.w);
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("makeReportExtraParamsForProfile [%s]", new Object[] { localBundle }));
    }
    return localBundle;
  }
  
  public static Bundle a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("chatuin", paramString);
    localBundle.putInt("chattype", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("makeReportExtraParams [%s]", new Object[] { localBundle }));
    }
    return localBundle;
  }
  
  private static String a()
  {
    if (a) {
      return c;
    }
    return b;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 22000)
    {
      if (paramInt != 22001)
      {
        if (paramInt != 25098)
        {
          if (paramInt != 25099)
          {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      return "";
                    case 25062: 
                      return "c2c_chat_action";
                    case 25061: 
                      return "stg_c2c_action";
                    }
                    return "person_in_group_action";
                  case 25031: 
                    return "vide_game";
                  case 25030: 
                    return "c2c_friendsuccess";
                  case 25029: 
                    return "stg_anonymous_c2c";
                  }
                  return "stg_sound_chat";
                case 25095: 
                  return "gamebox_c2c";
                case 25090: 
                  return "qq_station_audio_channel";
                case 25086: 
                  return "qq_station";
                case 25082: 
                  return "qq_station_uin";
                case 25080: 
                  return "qq_station_ugc";
                case 25054: 
                  return "c2c_video";
                case 25044: 
                  return "c2c_stg_peiwan";
                case 25022: 
                  return "stg_wezone_c2c";
                case 25020: 
                  return "kuolie_feed_c2c";
                case 25004: 
                  return "c2c_chat_pop";
                }
                return "group_info";
              case 21003: 
                return "c2c_honest_friend";
              case 21002: 
                return "c2c_honest_say";
              case 21001: 
                return "c2c_info";
              }
              return "c2c_chat";
            case 20020: 
              return "stg_addressbook_c2c";
            case 20019: 
              return "stg_discuss_c2c";
            case 20018: 
              return "stg_buluo_c2c";
            case 20017: 
              return "stg_checkmsg_c2c";
            case 20016: 
              return "stg_group_c2c";
            case 20015: 
              return "stg_kuolie_c2c";
            case 20014: 
              return "stg_kuolie_group";
            case 20013: 
              return "person_in_discuss";
            case 20012: 
              return "nearby_hotchat";
            case 20011: 
              return "stg_apply_for_group";
            case 20010: 
              return "stg_add_friend";
            case 20009: 
              return "stg_invite_togroup";
            case 20008: 
              return "person_in_group";
            case 20007: 
              return "nearby_yan_zhi_pei_dui";
            case 20006: 
              return "nearby_fjdt";
            case 20005: 
              return "nearby_kuoli";
            case 20004: 
              return "nearby_chat";
            case 20003: 
              return "nearby_info";
            case 20002: 
              return "stg_single_chat";
            }
            return "stg_profile";
          }
          return "non_live_broadcast";
        }
        return "channel_live_telecast";
      }
      return "discuss_mobile";
    }
    return "group_chat";
  }
  
  private static String a(int paramInt, String paramString)
  {
    int i = d(paramInt);
    if (i != paramInt) {
      paramString = a(i);
    }
    return paramString;
  }
  
  private static String a(Activity paramActivity, int paramInt, String paramString, Bundle paramBundle)
  {
    String str1 = "";
    String str2 = str1;
    if (paramInt == 25099)
    {
      paramBundle = paramBundle.get("chatuin");
      if ((paramBundle instanceof String)) {
        str1 = (String)paramBundle;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("channel_id=");
      paramBundle.append(str1);
      paramBundle.append("|tinyid=");
      paramBundle.append(paramString);
      str2 = paramBundle.toString();
      long l = b(paramActivity, str1);
      if (l != 0L)
      {
        paramActivity = new StringBuilder();
        paramActivity.append(str2);
        paramActivity.append("|roomid=");
        paramActivity.append(l);
        return paramActivity.toString();
      }
    }
    return str2;
  }
  
  public static String a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, int paramInt2, String paramString7, Bundle paramBundle)
  {
    paramActivity = new StringBuilder(a(paramActivity, paramString1, "", paramString2, paramString3, a(paramActivity, paramInt1, paramString1, paramBundle), paramString4, paramInt1, paramString5, paramString6, "", "", "", "", "", "", "", paramBundle));
    paramActivity.append("&msgs=");
    paramActivity.append(paramString7);
    paramActivity.append("&msg_count=");
    paramActivity.append(paramInt2);
    return paramActivity.toString();
  }
  
  public static String a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = paramString1;
    }
    paramString6 = new StringBuilder();
    paramString6.append("system=");
    paramString6.append("android");
    paramString6.append("&version=");
    paramString6.append("8.8.17");
    paramString6.append("&uintype=1");
    paramString6.append("&eviluin=");
    paramString6.append(paramString2);
    paramString6.append("&appname=KQQ");
    paramString6.append("&appid=2400002");
    if (!TextUtils.isEmpty(paramString7))
    {
      paramString6.append("&subapp=");
      paramString6.append(paramString7);
    }
    else
    {
      paramString6.append("&subapp=");
      paramString6.append(a(paramInt));
    }
    paramString6.append("&scene=");
    paramString6.append(paramInt);
    if (paramBundle != null)
    {
      paramString7 = String.valueOf(paramBundle.getLong("anonymousseq"));
      if (!TextUtils.isEmpty(paramString7))
      {
        paramString6.append("&contentid=");
        paramString6.append("anonymousseq=");
        paramString6.append(paramString7);
      }
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString6.append("&buddyflag=");
      paramString6.append(paramString3);
    }
    else
    {
      paramString6.append("&buddyflag=0");
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString6.append("&groupid=");
      paramString6.append(paramString4);
    }
    if (!TextUtils.isEmpty(paramString5))
    {
      paramString6.append("&contentid=");
      paramString6.append(paramString5);
    }
    if ((TextUtils.isEmpty(paramString8)) && ((paramActivity instanceof BaseActivity))) {
      paramActivity = a(((BaseActivity)paramActivity).app, paramString1, paramString4, paramInt, paramBundle);
    } else {
      paramActivity = paramString8;
    }
    if (paramInt == 25098) {
      paramActivity = "";
    }
    paramString7 = a(paramActivity, true);
    paramString8 = a(paramString9, true);
    paramString9 = a(paramString10, true);
    paramString10 = a(paramString11, true);
    paramString11 = a(paramString12, true);
    paramString12 = a(paramString13, true);
    paramString13 = a(paramString14, true);
    paramString6.append("&srv_para=");
    paramString6.append(paramString7);
    paramString6.append("&text_evidence=");
    paramString6.append(paramString8);
    paramString6.append("&img_evidence=");
    paramString6.append(paramString9);
    paramString6.append("&url_evidence=");
    paramString6.append(paramString10);
    paramString6.append("&video_evidence=");
    paramString6.append(paramString11);
    paramString6.append("&file_evidence=");
    paramString6.append(paramString12);
    paramString6.append("&audio_evidence=");
    paramString6.append(paramString13);
    if (TextUtils.isEmpty(paramString15))
    {
      paramString6.append("&user_input_param=");
      paramString6.append(a("REPORT_IP=0&EVIL_IP=0", true));
    }
    else
    {
      paramString6.append("&user_input_param=");
      paramString6.append(a(paramString15, true));
    }
    paramString3 = "abcdabcdabcdabcd";
    label1870:
    for (;;)
    {
      try
      {
        paramString5 = HttpBaseUtil.a("https://jubao.qq.com/uniform_impeach/impeach_cryptokey", "GET", new Bundle()).a;
        if (!QLog.isColorLevel()) {
          break label1870;
        }
        paramActivity = paramString3;
        try
        {
          QLog.d("NewReportPlugin", 2, String.format("makePostData step1: %s", new Object[] { paramString5 }));
          paramActivity = paramString3;
          paramString3 = a(paramString5);
          paramActivity = paramString3;
          if (QLog.isColorLevel())
          {
            paramActivity = paramString3;
            QLog.d("NewReportPlugin", 2, String.format("makePostData step2: %s", new Object[] { paramString3 }));
          }
          paramActivity = paramString3;
        }
        catch (Exception paramString3) {}
        paramString5 = new StringBuilder();
      }
      catch (Exception paramString5)
      {
        paramActivity = paramString3;
        paramString3 = paramString5;
      }
      paramString5.append("get cryptograph exception");
      paramString5.append(paramString3.getMessage());
      QLog.d("NewReportPlugin", 1, paramString5.toString());
      paramString3 = a("d41d8cd98f00b204e9800998ecf8427e", paramActivity);
      if (QLog.isColorLevel()) {
        QLog.d("NewReportPlugin", 2, String.format("makePostData step3: %s", new Object[] { paramString3 }));
      }
      paramActivity = new StringBuilder(200);
      paramActivity.append("android");
      paramActivity.append("_");
      paramActivity.append("8.8.17");
      paramActivity.append("_");
      paramActivity.append(paramInt);
      paramActivity.append("_");
      paramActivity.append(paramString3);
      paramString3 = paramActivity.toString();
      paramString5 = MD5Utils.toMD5(paramString3).toUpperCase();
      if (QLog.isColorLevel()) {
        QLog.d("NewReportPlugin", 2, String.format("makePostData step4: [%s, %s]", new Object[] { paramString3, paramString5 }));
      }
      paramActivity.setLength(0);
      paramActivity.append(paramString2);
      paramActivity.append("_");
      paramActivity.append(a(paramString7, false));
      paramActivity.append("_");
      paramActivity.append(a(paramString8, false));
      paramActivity.append("_");
      paramActivity.append(a(paramString9, false));
      paramActivity.append("_");
      paramActivity.append(a(paramString10, false));
      paramActivity.append("_");
      paramActivity.append(a(paramString11, false));
      paramActivity.append("_");
      paramActivity.append(a(paramString12, false));
      paramActivity.append("_");
      paramActivity.append(a(paramString13, false));
      paramActivity.append("_");
      paramActivity.append(paramString5);
      paramActivity = paramActivity.toString();
      paramString2 = MD5.toMD5(paramActivity.getBytes("UTF-8"));
      if (QLog.isColorLevel()) {
        QLog.d("NewReportPlugin", 2, String.format("makePostData step5: [%s, %s]", new Object[] { paramActivity, paramString2 }));
      }
      paramString6.append("&cryptograph=");
      paramString6.append(paramString2);
      if ((paramBundle != null) && (paramBundle.containsKey("chatuin")) && (paramBundle.containsKey("chattype")))
      {
        paramString2 = paramBundle.getString("chatuin");
        int i = paramBundle.getInt("chattype");
        if (i == 1)
        {
          if (!TextUtils.equals(paramString1, paramString2)) {
            paramActivity = b(paramString1, c(1));
          } else {
            paramActivity = "";
          }
          paramActivity = String.format("&%s=%s&%s=%s&%s=%s", new Object[] { "chatuin", paramActivity, "groupcode", paramString2, "chattype", Integer.valueOf(i) });
        }
        else if (i == 3000)
        {
          if (!TextUtils.equals(paramString1, paramString2)) {
            paramActivity = b(paramString1, c(1));
          } else {
            paramActivity = "";
          }
          paramActivity = String.format("&%s=%s&%s=%s&%s=%s", new Object[] { "chatuin", paramActivity, "groupcode", paramString2, "chattype", Integer.valueOf(i) });
        }
        else if (i == 10014)
        {
          paramActivity = b(paramString2, c(1));
          if (paramInt == 25086) {
            paramActivity = String.format("&%s=%s&%s=%s&%s=%s", new Object[] { "chatuin", paramActivity, "groupcode", "", "chattype", Integer.valueOf(i) });
          } else {
            paramActivity = String.format("&%s=%s&%s=%s&%s=%s", new Object[] { "chatuin", paramActivity, "groupcode", paramString4, "chattype", Integer.valueOf(i) });
          }
        }
        else if ((i != 1033) && (i != 1034))
        {
          if (i == 10007)
          {
            paramActivity = b(paramString2, c(1));
            paramString1 = paramBundle.getString("roleId").split("&")[0];
            paramString2 = paramBundle.getString("roleId").split("&")[1];
            paramActivity = String.format("&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", new Object[] { "chatuin", paramActivity, "chattype", Integer.valueOf(i), "friendroleid", paramString1, "myroleid", paramString2, "contentid", "evilroleId=".concat(paramString1).concat("|").concat("roleId=").concat(paramString2), "jubao_game_sig", Base64.encodeToString(paramBundle.getByteArray("jubao_game_sig"), 0) });
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append("联调 sig = ");
              paramString1.append(Arrays.toString(paramBundle.getByteArray("jubao_game_sig")));
              QLog.i("NewReportPlugin", 2, paramString1.toString());
            }
          }
          else
          {
            paramActivity = String.format("&%s=%s&%s=%s", new Object[] { "chatuin", b(paramString2, c(1)), "chattype", Integer.valueOf(i) });
          }
        }
        else
        {
          paramInt = paramBundle.getInt("topicid");
          paramActivity = paramBundle.getString("uinname");
          if (!TextUtils.isEmpty(paramActivity)) {
            paramActivity = Base64.encodeToString(paramActivity.getBytes(), 0);
          }
          paramActivity = String.format("&%s=%s&%s=%s&%s=%s&%s=%s", new Object[] { "chatuin", b(paramString2, c(1)), "chattype", Integer.valueOf(i), "topicid", Integer.valueOf(paramInt), "uinname", paramActivity });
        }
        if (!TextUtils.isEmpty(paramActivity)) {
          paramString6.append(paramActivity);
        }
        if (QLog.isColorLevel()) {
          QLog.i("NewReportPlugin", 2, String.format("extra_chat [%s] -- [%s] ", new Object[] { paramBundle, paramActivity }));
        }
      }
      paramActivity = paramString6.toString();
      if (QLog.isColorLevel()) {
        QLog.d("NewReportPlugin", 2, String.format("makePostData post: %s", new Object[] { paramActivity }));
      }
      return paramActivity;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    String str;
    int i;
    if ((paramBundle != null) && (paramBundle.containsKey("chatuin")) && (paramBundle.containsKey("chattype")))
    {
      str = paramBundle.getString("chatuin");
      i = paramBundle.getInt("chattype");
    }
    else
    {
      str = null;
      i = -1;
    }
    int k = 50;
    int j;
    if (i != -1)
    {
      paramBundle = str;
      j = k;
      if (!TextUtils.isEmpty(str)) {}
    }
    else
    {
      if ((paramInt != 22003) && (paramInt != 22000) && (paramInt != 20009) && (paramInt != 20008) && (paramInt != 20014) && (paramInt != 25029))
      {
        if ((paramInt != 22001) && (paramInt != 20013))
        {
          if (paramInt == 20012)
          {
            paramBundle = paramString2;
            i = 1;
            j = k;
            break label366;
          }
          if (paramInt == 21002) {
            i = 1034;
          }
          for (;;)
          {
            paramBundle = paramString1;
            j = k;
            break;
            if (paramInt == 21003) {
              i = 1033;
            } else if ((paramInt != 20015) && (paramInt != 20005))
            {
              if (paramInt == 25020)
              {
                i = 1045;
              }
              else if (paramInt == 20017)
              {
                i = 1022;
              }
              else if (paramInt == 20016)
              {
                i = 1000;
              }
              else if (paramInt == 20018)
              {
                i = 10002;
              }
              else if (paramInt == 20019)
              {
                i = 1004;
              }
              else if (paramInt == 25028)
              {
                i = 10010;
              }
              else
              {
                if (paramInt == 25095)
                {
                  i = 10007;
                  paramBundle = paramString2;
                  j = k;
                  break;
                }
                paramBundle = paramString1;
                i = 0;
                j = k;
                break;
              }
            }
            else {
              i = 1044;
            }
          }
        }
        i = 3000;
      }
      else
      {
        i = 1;
      }
      paramBundle = paramString2;
      j = 200;
    }
    label366:
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(paramBundle, i, j);
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("getMsgForReport [%s, %s, %s, %s]", new Object[] { paramBundle, Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(paramQQAppInterface.size()) }));
    }
    return a(paramString1, paramString2, paramInt, j, paramQQAppInterface);
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getString("key");
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "abcdabcdabcdabcd";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = paramString2.equals("abcdabcdabcdabcd");
      if (bool) {
        paramString2 = paramString2.getBytes("UTF-8");
      } else {
        paramString2 = Base64.decode(paramString2.getBytes("UTF-8"), 0);
      }
      Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
      localCipher.init(2, new SecretKeySpec(paramString1.getBytes(), "AES"));
      paramString1 = new String(localCipher.doFinal(paramString2));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("decrypt Key has something wrong : ");
      paramString2.append(paramString1.toString());
      QLog.e("NewReportPlugin", 1, paramString2.toString());
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<MessageRecord> paramList)
  {
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject2;
    Object localObject3;
    while (paramList.hasNext())
    {
      localObject2 = (MessageRecord)paramList.next();
      if ((localObject2 instanceof MessageForMixedMsg))
      {
        localObject2 = (MessageForMixedMsg)localObject2;
        if (((MessageForMixedMsg)localObject2).msgElemList != null)
        {
          localObject3 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (MessageRecord)((Iterator)localObject3).next();
            if (a((MessageRecord)localObject4))
            {
              ((MessageRecord)localObject4).istroop = ((MessageForMixedMsg)localObject2).istroop;
              ((MessageRecord)localObject4).senderuin = ((MessageForMixedMsg)localObject2).senderuin;
              ((MessageRecord)localObject4).selfuin = ((MessageForMixedMsg)localObject2).selfuin;
              ((MessageRecord)localObject4).frienduin = ((MessageForMixedMsg)localObject2).frienduin;
              ((List)localObject1).add(localObject4);
            }
          }
        }
      }
      else if (a((MessageRecord)localObject2))
      {
        if ((!(localObject2 instanceof MessageForText)) && (!(localObject2 instanceof MessageForLongMsg))) {
          ((List)localObject1).add(localObject2);
        } else if (((MessageRecord)localObject2).msgtype == -1000) {
          ((List)localObject1).add(localObject2);
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject4 = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    int i;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      i = 0;
      if (!bool) {
        break;
      }
      paramList = (MessageRecord)localIterator.next();
      if (paramList != null)
      {
        if ((paramList.istroop != 1000) && (paramList.istroop != 1004)) {
          localObject2 = paramList.senderuin;
        } else if (paramList.isSend()) {
          localObject2 = paramList.selfuin;
        } else {
          localObject2 = paramList.frienduin;
        }
        if (((paramInt1 != 20008) && (paramInt1 != 20013)) || (((TextUtils.isEmpty(paramString2)) || (TextUtils.equals((CharSequence)localObject2, paramString1))) && ((paramInt1 != 20012) || (TextUtils.equals((CharSequence)localObject2, paramString1)))))
        {
          if ((paramList instanceof MessageForPic))
          {
            paramList = (MessageForPic)paramList;
            paramList.parse();
            localObject1 = paramList.uuid;
          }
          for (paramList = "2";; paramList = "1")
          {
            i = 0;
            localObject3 = paramList;
            break label530;
            if ((!(paramList instanceof MessageForText)) && (!(paramList instanceof MessageForLongMsg)))
            {
              if (!(paramList instanceof MessageForStructing)) {
                break;
              }
              paramList = ((MessageForStructing)paramList).structingMsg;
              if (paramList == null) {
                break;
              }
              localObject1 = a(paramList.getXml(), false);
              i = 1;
              localObject3 = "3";
              break label530;
            }
            localObject1 = new QQText(paramList.msg, 3).toPlainText();
          }
          label530:
          paramList = (List<MessageRecord>)localObject1;
          if (i == 0)
          {
            paramList = (List<MessageRecord>)localObject1;
            try
            {
              localObject1 = ((String)localObject1).replace("\"", "\\\"");
              paramList = (List<MessageRecord>)localObject1;
              localObject1 = ((String)localObject1).replace("'", "\\'");
              paramList = (List<MessageRecord>)localObject1;
              localObject1 = ((String)localObject1).replace("|", "\\|");
              paramList = (List<MessageRecord>)localObject1;
              localObject1 = ((String)localObject1).replace(":", "\\:");
              paramList = (List<MessageRecord>)localObject1;
              localObject1 = ((String)localObject1).replace(";", "\\;");
              paramList = (List<MessageRecord>)localObject1;
              localObject1 = ((String)localObject1).replace("[", "\\[");
              paramList = (List<MessageRecord>)localObject1;
              localObject1 = ((String)localObject1).replace("]", "\\]");
              paramList = (List<MessageRecord>)localObject1;
              localObject1 = ((String)localObject1).replace("=", "\\=");
              paramList = (List<MessageRecord>)localObject1;
              localObject1 = ((String)localObject1).replace("\n", "");
              paramList = (List<MessageRecord>)localObject1;
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
          localStringBuilder.setLength(0);
          localStringBuilder.append("[");
          localStringBuilder.append("uin=");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(";");
          localStringBuilder.append("content=");
          localStringBuilder.append(paramList);
          localStringBuilder.append(";");
          localStringBuilder.append("type=");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append("]");
          ((List)localObject4).add(localStringBuilder.toString());
        }
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("chatmsg:");
    paramInt1 = i;
    if (((List)localObject4).size() > paramInt2) {
      paramInt1 = ((List)localObject4).size() - paramInt2;
    }
    while (paramInt1 < ((List)localObject4).size())
    {
      paramString1.append((String)((List)localObject4).get(paramInt1));
      paramInt1 += 1;
    }
    return paramString1.toString();
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    String str2 = "";
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    if (paramBoolean) {}
    try
    {
      return URLEncoder.encode(str1, "UTF-8");
    }
    catch (Throwable paramString) {}catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label73;
    }
    paramString = URLDecoder.decode(str1, "UTF-8");
    return paramString;
    QLog.i("NewReportPlugin", 1, String.format("encodeOrDecodeStr [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), str1 }), paramString);
    return str1;
    label73:
    if (paramBoolean) {
      paramString = str2;
    } else {
      paramString = str1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("encodeOrDecodeStr [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), str1 }), localUnsupportedEncodingException);
    }
    return paramString;
  }
  
  public static String a(List<ChatMessage> paramList)
  {
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (MessageRecord)paramList.next();
      if ((localObject2 instanceof MessageForMixedMsg))
      {
        localObject2 = (MessageForMixedMsg)localObject2;
        if (((MessageForMixedMsg)localObject2).msgElemList != null)
        {
          localObject3 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (MessageRecord)((Iterator)localObject3).next();
            if (a((MessageRecord)localObject4))
            {
              ((MessageRecord)localObject4).istroop = ((MessageForMixedMsg)localObject2).istroop;
              ((MessageRecord)localObject4).senderuin = ((MessageForMixedMsg)localObject2).senderuin;
              ((MessageRecord)localObject4).selfuin = ((MessageForMixedMsg)localObject2).selfuin;
              ((MessageRecord)localObject4).frienduin = ((MessageForMixedMsg)localObject2).frienduin;
              ((List)localObject1).add(localObject4);
            }
          }
        }
      }
      else
      {
        ((List)localObject1).add(localObject2);
      }
    }
    Object localObject4 = new StringBuilder();
    Object localObject3 = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    int i;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      i = 0;
      if (!bool) {
        break;
      }
      paramList = (MessageRecord)localIterator.next();
      if (paramList != null)
      {
        String str = paramList.senderuin;
        bool = paramList instanceof MessageForText;
        localObject1 = "6";
        if ((!bool) && (!(paramList instanceof MessageForLongMsg)))
        {
          if ((paramList instanceof MessageForPic))
          {
            paramList = (MessageForPic)paramList;
            paramList.parse();
            paramList = paramList.uuid;
            localObject1 = "2";
          }
          else
          {
            if ((paramList instanceof MessageForStructing))
            {
              paramList = ((MessageForStructing)paramList).structingMsg;
              if (paramList == null) {
                continue;
              }
              localObject1 = a(paramList.getXml(), false);
              localObject2 = "3";
              i = 1;
              break label448;
            }
            if ((paramList instanceof MessageForShortVideo))
            {
              paramList = (MessageForShortVideo)paramList;
              paramList.parse();
              paramList = paramList.uuid;
              localObject1 = "5";
            }
            else if ((paramList instanceof MessageForFile))
            {
              paramList = (MessageForFile)paramList;
              paramList.parse();
              paramList = paramList.url;
            }
            else if ((paramList instanceof MessageForTroopFile))
            {
              paramList = (MessageForTroopFile)paramList;
              paramList.parse();
              paramList = paramList.url;
            }
            else
            {
              if (!(paramList instanceof MessageForPtt)) {
                continue;
              }
              paramList = (MessageForPtt)paramList;
              paramList.parse();
              paramList = paramList.url;
              localObject1 = "7";
            }
          }
        }
        else
        {
          paramList = new QQText(paramList.msg, 3).toPlainText();
          localObject1 = "1";
        }
        i = 0;
        localObject2 = localObject1;
        localObject1 = paramList;
        label448:
        paramList = (List<ChatMessage>)localObject1;
        if (i == 0)
        {
          paramList = (List<ChatMessage>)localObject1;
          try
          {
            localObject1 = ((String)localObject1).replace("\"", "\\\"");
            paramList = (List<ChatMessage>)localObject1;
            localObject1 = ((String)localObject1).replace("'", "\\'");
            paramList = (List<ChatMessage>)localObject1;
            localObject1 = ((String)localObject1).replace("|", "\\|");
            paramList = (List<ChatMessage>)localObject1;
            localObject1 = ((String)localObject1).replace(":", "\\:");
            paramList = (List<ChatMessage>)localObject1;
            localObject1 = ((String)localObject1).replace(";", "\\;");
            paramList = (List<ChatMessage>)localObject1;
            localObject1 = ((String)localObject1).replace("[", "\\[");
            paramList = (List<ChatMessage>)localObject1;
            localObject1 = ((String)localObject1).replace("]", "\\]");
            paramList = (List<ChatMessage>)localObject1;
            localObject1 = ((String)localObject1).replace("=", "\\=");
            paramList = (List<ChatMessage>)localObject1;
            localObject1 = ((String)localObject1).replace("\n", "");
            paramList = (List<ChatMessage>)localObject1;
          }
          catch (Throwable localThrowable)
          {
            QLog.e("NewReportPlugin", 1, localThrowable, new Object[0]);
          }
        }
        ((StringBuilder)localObject4).setLength(0);
        ((StringBuilder)localObject4).append("[");
        ((StringBuilder)localObject4).append("uin=");
        ((StringBuilder)localObject4).append(str);
        ((StringBuilder)localObject4).append(";");
        ((StringBuilder)localObject4).append("content=");
        ((StringBuilder)localObject4).append(paramList);
        ((StringBuilder)localObject4).append(";");
        ((StringBuilder)localObject4).append("type=");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append("]");
        ((List)localObject3).add(((StringBuilder)localObject4).toString());
      }
    }
    paramList = new StringBuilder();
    paramList.append("chatmsg:");
    if (((List)localObject3).size() > 50) {
      i = ((List)localObject3).size() - 50;
    }
    while (i < ((List)localObject3).size())
    {
      paramList.append((String)((List)localObject3).get(i));
      i += 1;
    }
    return paramList.toString();
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    try
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("BSafeReportPost", true);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.getBytes("utf-8");
      }
      localIntent.putExtra("SafeReportData", paramString);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("ishiderefresh", true);
      localIntent.putExtra("ishidebackforward", true);
      paramActivity.startActivity(localIntent.putExtra("url", a()));
      return;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("doJumpReport exception: ");
        paramString.append(paramActivity.getMessage());
        QLog.d("NewReportPlugin", 2, paramString.toString());
      }
    }
  }
  
  public static void a(QBaseActivity paramQBaseActivity, int paramInt, String paramString1, String paramString2)
  {
    b(paramQBaseActivity, paramInt, paramString1, paramString2, null);
  }
  
  public static void a(QBaseActivity paramQBaseActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    b(paramQBaseActivity, paramInt, paramString1, paramString2, paramString3);
  }
  
  public static void a(QBaseActivity paramQBaseActivity, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle)
  {
    if ((paramQBaseActivity != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewReportPlugin", 2, String.format("nearbySafetyReport [%s, %s, %s]", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt) }));
      }
      QQProgressDialog localQQProgressDialog = new QQProgressDialog(paramQBaseActivity, paramQBaseActivity.getTitleBarHeight());
      try
      {
        localQQProgressDialog.show();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      String str;
      if (paramLong <= 0L) {
        str = paramString1;
      } else {
        str = String.valueOf(paramLong);
      }
      a(paramQBaseActivity, str, paramString1, paramString2, d(paramInt), a(paramInt, paramString3), localQQProgressDialog, paramBundle);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewReportPlugin", 2, "nearbySafetyReport param null");
    }
  }
  
  public static void a(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if ((paramQBaseActivity != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NewReportPlugin", 2, String.format("safetyReport [%s, %s, %s, %s, %s]", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt), paramString4 }));
      }
      a(paramQBaseActivity, paramString1, null, null, paramString2, paramString3, paramInt, paramString4, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewReportPlugin", 2, "safetyReport param null");
    }
  }
  
  private static void a(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, QQProgressDialog paramQQProgressDialog, Bundle paramBundle)
  {
    ThreadManager.excute(new NewReportPlugin.2(paramBundle, paramString4, paramInt, paramQBaseActivity, paramString2, paramString3, paramString1, paramQQProgressDialog), 16, null, false);
  }
  
  public static void a(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, String paramString6, Bundle paramBundle)
  {
    if ((paramQBaseActivity != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString4)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NewReportPlugin", 2, String.format("actionSheetReport [org: %s, g: %s,  s: %s, extra: %s]", new Object[] { paramString1, paramString3, Integer.valueOf(paramInt1), paramBundle }));
      }
      QQProgressDialog localQQProgressDialog = new QQProgressDialog(paramQBaseActivity, paramQBaseActivity.getTitleBarHeight());
      try
      {
        localQQProgressDialog.show();
      }
      catch (Exception localException)
      {
        QLog.e("NewReportPlugin", 1, localException, new Object[0]);
      }
      ThreadManager.excute(new NewReportPlugin.4(paramInt1, paramQBaseActivity, paramString1, paramString3, paramBundle, paramString2, paramString4, paramString5, paramInt2, paramString6, localQQProgressDialog), 16, null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewReportPlugin", 2, "actionSheetReport param null");
    }
  }
  
  public static void a(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, Bundle paramBundle)
  {
    if ((paramQBaseActivity != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString4)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NewReportPlugin", 2, String.format("safetyReport [%s, %s, %s, %s, %s]", new Object[] { paramString1, paramString2, paramString4, Integer.valueOf(paramInt), paramString5 }));
      }
      ThreadManager.excute(new NewReportPlugin.1(paramInt, paramQBaseActivity, paramString1, paramString2, paramBundle, paramString5, paramString3, paramString4), 16, null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewReportPlugin", 2, "safetyReport param null");
    }
  }
  
  public static void a(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, Bundle paramBundle)
  {
    if ((paramQBaseActivity != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString5)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NewReportPlugin", 2, String.format("safetyNewReport [org: %s, encrypt: %s,  g: %s,  s: %s, extra: %s]", new Object[] { paramString1, paramString2, paramString4, Integer.valueOf(paramInt), paramBundle }));
      }
      QQProgressDialog localQQProgressDialog = new QQProgressDialog(paramQBaseActivity, paramQBaseActivity.getTitleBarHeight());
      try
      {
        localQQProgressDialog.show();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      ThreadManager.excute(new NewReportPlugin.3(paramInt, paramQBaseActivity, paramString1, paramString4, paramBundle, paramString2, paramString3, paramString5, paramString6, localQQProgressDialog), 16, null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewReportPlugin", 2, "safetyReport param null");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
    {
      if (TextUtils.isEmpty(paramString1)) {
        paramString1 = "0";
      }
      paramQQAppInterface = URLEncoder.encode(paramString2);
      paramString2 = new StringBuilder();
      paramString2.append("groupuin=");
      paramString2.append(paramString1);
      paramString2.append("&eviluin=0&anonyid=");
      paramString2.append(paramQQAppInterface);
      paramString2.append("&impeachuin=");
      paramString2.append(paramString3);
      paramString2.append("&msglist=");
      paramString2.append(paramString4);
      paramQQAppInterface = paramString2.toString();
      paramString1 = new StringBuilder();
      paramString1.append(paramQQAppInterface);
      paramString1.append("&uin_source=unfriend");
      paramQQAppInterface = paramString1.toString();
      paramString1 = new StringBuilder();
      paramString1.append("SourceID=401&appname=KQQ&jubaotype=uin&system=android&subapp=BusinessCard&");
      paramString1.append(paramQQAppInterface);
      paramQQAppInterface = paramString1.toString();
      if (paramQQAppInterface == null) {
        paramQQAppInterface = null;
      }
      try
      {
        paramQQAppInterface = paramQQAppInterface.getBytes("utf-8");
        paramString1 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
        paramString1.putExtra("BSafeReportPost", true);
        paramString1.putExtra("SafeReportData", paramQQAppInterface);
        paramString1.putExtra("hide_more_button", true);
        paramString1.putExtra("ishiderefresh", true);
        paramString1.putExtra("ishidebackforward", true);
        paramString1.putExtra("url", "https://jubao.qq.com/cn/jubao");
        paramString1.addFlags(268435456);
        BaseApplication.getContext().startActivity(paramString1);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("safetyReport exception");
          paramString1.append(paramQQAppInterface.getMessage());
          QLog.d("NewReportPlugin", 2, paramString1.toString());
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, "safetyReport param null");
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForLongMsg)) || ((paramMessageRecord instanceof MessageForStructing)) || ((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg));
  }
  
  private static byte[] a(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      try
      {
        int j = paramArrayOfByte.length;
        int i = j;
        if (j % 16 != 0) {
          i = j + (16 - j % 16);
        }
        byte[] arrayOfByte = new byte[i];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
        paramArrayOfByte = Cipher.getInstance("AES/ECB/NoPadding");
        paramArrayOfByte.init(paramInt, new SecretKeySpec(paramString.getBytes(), "AES"));
        paramArrayOfByte = paramArrayOfByte.doFinal(arrayOfByte);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramString = new StringBuilder();
        paramString.append("encryOrDecryStr error: ");
        paramString.append(paramArrayOfByte.getMessage());
        QLog.e("NewReportPlugin", 1, paramString.toString());
      }
    }
    return null;
  }
  
  public static int b(int paramInt)
  {
    int i;
    if (paramInt == 1) {
      i = 20008;
    } else if (paramInt == 3000) {
      i = 20013;
    } else if (paramInt == 1004) {
      i = 20019;
    } else if (paramInt == 0) {
      i = 21000;
    } else if (paramInt == 1044) {
      i = 20015;
    } else if (paramInt == 1045) {
      i = 25020;
    } else if (paramInt == 1000) {
      i = 20016;
    } else if (paramInt == 1022) {
      i = 20017;
    } else if (paramInt == 10002) {
      i = 20018;
    } else if (paramInt == 1001) {
      i = 20004;
    } else if (paramInt == 1034) {
      i = 21002;
    } else if (paramInt == 1033) {
      i = 21003;
    } else if (paramInt == 1006) {
      i = 20020;
    } else if (paramInt == 10008) {
      i = 25022;
    } else if (paramInt == 10010) {
      i = 25028;
    } else if (paramInt == 10007) {
      i = 25095;
    } else {
      i = 20002;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("chattype2scene: [%s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
    }
    return i;
  }
  
  private static long b(Activity paramActivity, String paramString)
  {
    boolean bool = paramActivity instanceof QBaseActivity;
    long l2 = 0L;
    long l1 = l2;
    if (bool)
    {
      paramActivity = ((IGPSService)((QBaseActivity)paramActivity).getAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(paramString);
      l1 = l2;
      if (paramActivity != null) {
        l1 = paramActivity.getLiveRoomId();
      }
    }
    return l1;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        paramString1 = Utils.b(a(paramString1.getBytes("utf-8"), paramString2, 1));
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return null;
  }
  
  private static void b(QBaseActivity paramQBaseActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    int i = b(paramInt);
    Bundle localBundle = a(paramString1, paramInt);
    String str2;
    if (paramInt == 0) {
      str2 = "1";
    } else {
      str2 = "0";
    }
    Object localObject = null;
    String str1;
    if ((paramInt != 3000) && (paramInt != 1))
    {
      str1 = paramString3;
      if (paramInt != 1000) {
        if (paramInt == 10007) {
          str1 = paramString3;
        } else {
          str1 = null;
        }
      }
    }
    else
    {
      str1 = paramString1;
    }
    if ((paramInt != 1001) && (paramInt != 10002))
    {
      if ((paramInt != 1034) && (paramInt != 1033) && (paramInt != 1044) && (paramInt != 1045))
      {
        if (paramInt == 10007)
        {
          localBundle.putString("roleId", str1.split("_")[1]);
          localBundle.putString("chatuin", str1.split("_")[0]);
          localBundle.putInt("chattype", 10007);
          AppRuntime localAppRuntime = paramQBaseActivity.getAppRuntime();
          paramString3 = localObject;
          if (localAppRuntime != null) {
            paramString3 = ((MessageCache)paramQBaseActivity.getAppRuntime().getMsgCache()).c(str1.split("_")[0], localAppRuntime.getCurrentUin());
          }
          localBundle.putByteArray("jubao_game_sig", paramString3);
          a(paramQBaseActivity, paramString1, null, str2, str1.split("_")[0], paramString2, i, null, localBundle);
          return;
        }
        a(paramQBaseActivity, paramString1, null, str2, str1, paramString2, i, null, localBundle);
        return;
      }
      a(paramQBaseActivity, paramString1, b(paramString1, c(2)), str2, str1, paramString2, i, null, localBundle);
      return;
    }
    a(paramQBaseActivity, 0L, paramString1, str1, i, null, localBundle);
  }
  
  public static String c(int paramInt)
  {
    if (paramInt == 2) {
      return "6bW#X@~L.+X)4%$>";
    }
    if (paramInt == 1) {}
    return "6bW#X@~L.+X)4%$>";
  }
  
  public static String c(String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = localObject4;
    if (!bool) {}
    for (;;)
    {
      try
      {
        paramString1 = Utils.h(paramString1);
        if ((paramString1 == null) || (paramString1.length <= 0)) {
          break label128;
        }
        paramString1 = a(paramString1, paramString2, 2);
        localObject1 = localObject4;
        if (paramString1 == null) {
          break label125;
        }
        localObject1 = localObject4;
        if (paramString1.length <= 0) {
          break label125;
        }
        paramString1 = new String(paramString1, "UTF-8");
        try
        {
          int i = paramString1.indexOf(0);
          if (i >= 0)
          {
            paramString2 = paramString1.substring(0, i);
            return paramString2;
          }
          return paramString1;
        }
        catch (Throwable paramString2) {}catch (UnsupportedEncodingException paramString2) {}
        paramString2.printStackTrace();
      }
      catch (Throwable paramString2)
      {
        paramString1 = localObject2;
        paramString2.printStackTrace();
        return paramString1;
      }
      catch (UnsupportedEncodingException paramString2)
      {
        paramString1 = localObject3;
      }
      localObject1 = paramString1;
      label125:
      return localObject1;
      label128:
      paramString1 = null;
    }
  }
  
  private static int d(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 3010) {
      i = 20006;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin
 * JD-Core Version:    0.7.0.1
 */