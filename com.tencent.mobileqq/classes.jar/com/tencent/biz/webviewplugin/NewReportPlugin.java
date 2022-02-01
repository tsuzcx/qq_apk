package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import com.tencent.mobileqq.nearby.INearbyFaceScoreManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
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
  private static String a = "https://jubao.qq.com/uniform_impeach/impeach_entry";
  public static boolean a = false;
  private static String b = "https://juabotest.qq.com/uniform_impeach/impeach_entry";
  
  public static int a(int paramInt)
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
    } else if (paramInt == 10009) {
      i = 25044;
    } else {
      i = 20002;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("chattype2scene: [%s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
    }
    return i;
  }
  
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
    if (paramInt == 20008)
    {
      paramString1 = paramQBaseActivity;
      if (!TextUtils.isEmpty(paramQBaseActivity)) {}
    }
    for (;;)
    {
      paramString1 = paramString2;
      label56:
      label342:
      do
      {
        j = 1;
        i = 1;
        paramQBaseActivity = paramString1;
        break label364;
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
          break label364;
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
              break label364;
            }
            if (paramInt == 22003)
            {
              paramString1 = paramQBaseActivity;
              if (!TextUtils.isEmpty(paramQBaseActivity)) {
                break label56;
              }
              break;
            }
            if (paramInt != 25028) {
              break label342;
            }
            paramString1 = paramQBaseActivity;
            if (TextUtils.isEmpty(paramQBaseActivity)) {
              paramString1 = paramString2;
            }
            i = 10010;
            paramQBaseActivity = paramString1;
          }
        }
        if (paramInt != 25029) {
          break label361;
        }
        paramString1 = paramQBaseActivity;
      } while (!TextUtils.isEmpty(paramQBaseActivity));
    }
    label361:
    int j = 0;
    label364:
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
    Bundle localBundle = a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    if ((paramSessionInfo.jdField_a_of_type_Int == 1033) || (paramSessionInfo.jdField_a_of_type_Int == 1034))
    {
      localBundle.putInt("topicid", paramSessionInfo.e);
      localBundle.putString("uinname", paramSessionInfo.h);
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
    if (jdField_a_of_type_Boolean) {
      return b;
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 22000)
    {
      if (paramInt != 22001)
      {
        if (paramInt != 22003)
        {
          if (paramInt != 25004)
          {
            if (paramInt != 25020)
            {
              if (paramInt != 25022)
              {
                if (paramInt != 25044)
                {
                  if (paramInt != 25054)
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
                  return "c2c_video";
                }
                return "c2c_stg_peiwan";
              }
              return "stg_wezone_c2c";
            }
            return "kuolie_feed_c2c";
          }
          return "c2c_chat_pop";
        }
        return "group_info";
      }
      return "discuss_mobile";
    }
    return "group_chat";
  }
  
  public static String a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, int paramInt2, String paramString7, Bundle paramBundle)
  {
    paramActivity = new StringBuilder(a(paramActivity, paramString1, "", paramString2, paramString3, "", paramString4, paramInt1, paramString5, paramString6, "", "", "", "", "", "", "", paramBundle));
    paramActivity.append("&msgs=");
    paramActivity.append(paramString7);
    paramActivity.append("&msg_count=");
    paramActivity.append(paramInt2);
    return paramActivity.toString();
  }
  
  /* Error */
  public static String a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +8 -> 12
    //   7: aload_1
    //   8: astore_2
    //   9: goto +3 -> 12
    //   12: new 200	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   19: astore 6
    //   21: aload 6
    //   23: ldc 225
    //   25: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 6
    //   31: ldc 227
    //   33: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 6
    //   39: ldc 229
    //   41: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 6
    //   47: ldc 231
    //   49: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 6
    //   55: ldc 233
    //   57: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 6
    //   63: ldc 235
    //   65: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 6
    //   71: aload_2
    //   72: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 6
    //   78: ldc 237
    //   80: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 6
    //   86: ldc 239
    //   88: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 8
    //   94: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +22 -> 119
    //   100: aload 6
    //   102: ldc 241
    //   104: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 6
    //   110: aload 8
    //   112: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: goto +22 -> 138
    //   119: aload 6
    //   121: ldc 241
    //   123: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 6
    //   129: iload 7
    //   131: invokestatic 243	com/tencent/biz/webviewplugin/NewReportPlugin:a	(I)Ljava/lang/String;
    //   134: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 6
    //   140: ldc 245
    //   142: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 6
    //   148: iload 7
    //   150: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 17
    //   156: ifnull +49 -> 205
    //   159: aload 17
    //   161: ldc 247
    //   163: invokevirtual 251	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   166: invokestatic 254	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   169: astore 8
    //   171: aload 8
    //   173: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +29 -> 205
    //   179: aload 6
    //   181: ldc_w 256
    //   184: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 6
    //   190: ldc_w 258
    //   193: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 6
    //   199: aload 8
    //   201: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_3
    //   206: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   209: ifne +22 -> 231
    //   212: aload 6
    //   214: ldc_w 260
    //   217: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 6
    //   223: aload_3
    //   224: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: goto +12 -> 240
    //   231: aload 6
    //   233: ldc_w 262
    //   236: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 4
    //   242: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifne +20 -> 265
    //   248: aload 6
    //   250: ldc_w 264
    //   253: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 6
    //   259: aload 4
    //   261: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 5
    //   267: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   270: ifne +20 -> 290
    //   273: aload 6
    //   275: ldc_w 256
    //   278: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 6
    //   284: aload 5
    //   286: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 9
    //   292: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   295: ifeq +32 -> 327
    //   298: aload_0
    //   299: instanceof 266
    //   302: ifeq +25 -> 327
    //   305: aload_0
    //   306: checkcast 266	com/tencent/mobileqq/app/BaseActivity
    //   309: getfield 270	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   312: aload_1
    //   313: aload 4
    //   315: iload 7
    //   317: aload 17
    //   319: invokestatic 273	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Ljava/lang/String;
    //   322: astore 9
    //   324: goto +3 -> 327
    //   327: aload 9
    //   329: iconst_1
    //   330: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   333: astore 5
    //   335: aload 10
    //   337: iconst_1
    //   338: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   341: astore 8
    //   343: aload 11
    //   345: iconst_1
    //   346: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   349: astore 9
    //   351: aload 12
    //   353: iconst_1
    //   354: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   357: astore 10
    //   359: aload 13
    //   361: iconst_1
    //   362: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   365: astore 11
    //   367: aload 14
    //   369: iconst_1
    //   370: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   373: astore 12
    //   375: aload 15
    //   377: iconst_1
    //   378: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   381: astore 13
    //   383: aload 6
    //   385: ldc_w 278
    //   388: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 6
    //   394: aload 5
    //   396: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 6
    //   402: ldc_w 280
    //   405: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 6
    //   411: aload 8
    //   413: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload 6
    //   419: ldc_w 282
    //   422: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 6
    //   428: aload 9
    //   430: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload 6
    //   436: ldc_w 284
    //   439: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 6
    //   445: aload 10
    //   447: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload 6
    //   453: ldc_w 286
    //   456: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 6
    //   462: aload 11
    //   464: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 6
    //   470: ldc_w 288
    //   473: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 6
    //   479: aload 12
    //   481: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload 6
    //   487: ldc_w 290
    //   490: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload 6
    //   496: aload 13
    //   498: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload 16
    //   504: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   507: ifeq +28 -> 535
    //   510: aload 6
    //   512: ldc_w 292
    //   515: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload 6
    //   521: ldc_w 294
    //   524: iconst_1
    //   525: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   528: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: goto +24 -> 556
    //   535: aload 6
    //   537: ldc_w 292
    //   540: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload 6
    //   546: aload 16
    //   548: iconst_1
    //   549: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   552: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: ldc_w 296
    //   559: ldc_w 298
    //   562: new 51	android/os/Bundle
    //   565: dup
    //   566: invokespecial 86	android/os/Bundle:<init>	()V
    //   569: invokestatic 303	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Lcom/tencent/open/base/http/HttpBaseUtil$Statistic;
    //   572: getfield 306	com/tencent/open/base/http/HttpBaseUtil$Statistic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   575: astore_0
    //   576: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   579: ifeq +918 -> 1497
    //   582: ldc 28
    //   584: iconst_2
    //   585: ldc_w 308
    //   588: iconst_1
    //   589: anewarray 4	java/lang/Object
    //   592: dup
    //   593: iconst_0
    //   594: aload_0
    //   595: aastore
    //   596: invokestatic 42	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   599: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: goto +3 -> 605
    //   605: aload_0
    //   606: invokestatic 313	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;)Ljava/lang/String;
    //   609: astore_0
    //   610: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   613: ifeq +23 -> 636
    //   616: ldc 28
    //   618: iconst_2
    //   619: ldc_w 315
    //   622: iconst_1
    //   623: anewarray 4	java/lang/Object
    //   626: dup
    //   627: iconst_0
    //   628: aload_0
    //   629: aastore
    //   630: invokestatic 42	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   633: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   636: goto +64 -> 700
    //   639: astore_3
    //   640: goto +21 -> 661
    //   643: astore_0
    //   644: goto +4 -> 648
    //   647: astore_0
    //   648: ldc_w 317
    //   651: astore 4
    //   653: aload_0
    //   654: astore_3
    //   655: aload 4
    //   657: astore_0
    //   658: goto +3 -> 661
    //   661: new 200	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   668: astore 4
    //   670: aload 4
    //   672: ldc_w 319
    //   675: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload 4
    //   681: aload_3
    //   682: invokevirtual 322	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   685: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: ldc 28
    //   691: iconst_1
    //   692: aload 4
    //   694: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   700: ldc_w 324
    //   703: aload_0
    //   704: invokestatic 327	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   707: astore_3
    //   708: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   711: ifeq +23 -> 734
    //   714: ldc 28
    //   716: iconst_2
    //   717: ldc_w 329
    //   720: iconst_1
    //   721: anewarray 4	java/lang/Object
    //   724: dup
    //   725: iconst_0
    //   726: aload_3
    //   727: aastore
    //   728: invokestatic 42	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   731: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   734: new 200	java/lang/StringBuilder
    //   737: dup
    //   738: sipush 200
    //   741: invokespecial 332	java/lang/StringBuilder:<init>	(I)V
    //   744: astore_0
    //   745: aload_0
    //   746: ldc 227
    //   748: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: aload_0
    //   753: ldc_w 334
    //   756: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload_0
    //   761: ldc 231
    //   763: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: aload_0
    //   768: ldc_w 334
    //   771: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: aload_0
    //   776: iload 7
    //   778: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   781: pop
    //   782: aload_0
    //   783: ldc_w 334
    //   786: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload_0
    //   791: aload_3
    //   792: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload_0
    //   797: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   800: astore_3
    //   801: aload_3
    //   802: invokestatic 339	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   805: invokevirtual 342	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   808: astore 4
    //   810: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   813: ifeq +31 -> 844
    //   816: ldc 28
    //   818: iconst_2
    //   819: ldc_w 344
    //   822: iconst_2
    //   823: anewarray 4	java/lang/Object
    //   826: dup
    //   827: iconst_0
    //   828: aload_3
    //   829: aastore
    //   830: dup
    //   831: iconst_1
    //   832: aload 4
    //   834: aastore
    //   835: invokestatic 42	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   838: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   841: goto +3 -> 844
    //   844: aload_0
    //   845: iconst_0
    //   846: invokevirtual 347	java/lang/StringBuilder:setLength	(I)V
    //   849: aload_0
    //   850: aload_2
    //   851: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: pop
    //   855: aload_0
    //   856: ldc_w 334
    //   859: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: pop
    //   863: aload_0
    //   864: aload 5
    //   866: iconst_0
    //   867: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   870: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: aload_0
    //   875: ldc_w 334
    //   878: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: pop
    //   882: aload_0
    //   883: aload 8
    //   885: iconst_0
    //   886: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   889: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: pop
    //   893: aload_0
    //   894: ldc_w 334
    //   897: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: pop
    //   901: aload_0
    //   902: aload 9
    //   904: iconst_0
    //   905: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   908: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: pop
    //   912: aload_0
    //   913: ldc_w 334
    //   916: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: pop
    //   920: aload_0
    //   921: aload 10
    //   923: iconst_0
    //   924: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   927: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: aload_0
    //   932: ldc_w 334
    //   935: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: aload_0
    //   940: aload 11
    //   942: iconst_0
    //   943: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   946: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload_0
    //   951: ldc_w 334
    //   954: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: pop
    //   958: aload_0
    //   959: aload 12
    //   961: iconst_0
    //   962: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   965: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: aload_0
    //   970: ldc_w 334
    //   973: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: aload_0
    //   978: aload 13
    //   980: iconst_0
    //   981: invokestatic 276	com/tencent/biz/webviewplugin/NewReportPlugin:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   984: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload_0
    //   989: ldc_w 334
    //   992: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload_0
    //   997: aload 4
    //   999: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: aload_0
    //   1004: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1007: astore_0
    //   1008: aload_0
    //   1009: ldc_w 349
    //   1012: invokevirtual 353	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1015: invokestatic 358	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   1018: astore_2
    //   1019: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1022: ifeq +27 -> 1049
    //   1025: ldc 28
    //   1027: iconst_2
    //   1028: ldc_w 360
    //   1031: iconst_2
    //   1032: anewarray 4	java/lang/Object
    //   1035: dup
    //   1036: iconst_0
    //   1037: aload_0
    //   1038: aastore
    //   1039: dup
    //   1040: iconst_1
    //   1041: aload_2
    //   1042: aastore
    //   1043: invokestatic 42	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1046: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1049: aload 6
    //   1051: ldc_w 362
    //   1054: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: pop
    //   1058: aload 6
    //   1060: aload_2
    //   1061: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: pop
    //   1065: aload 17
    //   1067: ifnull +396 -> 1463
    //   1070: aload 17
    //   1072: ldc 49
    //   1074: invokevirtual 74	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1077: ifeq +386 -> 1463
    //   1080: aload 17
    //   1082: ldc 57
    //   1084: invokevirtual 74	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1087: ifeq +376 -> 1463
    //   1090: aload 17
    //   1092: ldc 49
    //   1094: invokevirtual 55	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1097: astore_2
    //   1098: aload 17
    //   1100: ldc 57
    //   1102: invokevirtual 61	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1105: istore 7
    //   1107: ldc 116
    //   1109: astore_0
    //   1110: iload 7
    //   1112: iconst_1
    //   1113: if_icmpne +67 -> 1180
    //   1116: aload_1
    //   1117: aload_2
    //   1118: invokestatic 366	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1121: ifne +12 -> 1133
    //   1124: aload_1
    //   1125: iconst_1
    //   1126: invokestatic 368	com/tencent/biz/webviewplugin/NewReportPlugin:b	(I)Ljava/lang/String;
    //   1129: invokestatic 370	com/tencent/biz/webviewplugin/NewReportPlugin:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1132: astore_0
    //   1133: ldc_w 372
    //   1136: bipush 6
    //   1138: anewarray 4	java/lang/Object
    //   1141: dup
    //   1142: iconst_0
    //   1143: ldc 49
    //   1145: aastore
    //   1146: dup
    //   1147: iconst_1
    //   1148: aload_0
    //   1149: aastore
    //   1150: dup
    //   1151: iconst_2
    //   1152: ldc_w 374
    //   1155: aastore
    //   1156: dup
    //   1157: iconst_3
    //   1158: aload_2
    //   1159: aastore
    //   1160: dup
    //   1161: iconst_4
    //   1162: ldc 57
    //   1164: aastore
    //   1165: dup
    //   1166: iconst_5
    //   1167: iload 7
    //   1169: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1172: aastore
    //   1173: invokestatic 42	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1176: astore_0
    //   1177: goto +241 -> 1418
    //   1180: iload 7
    //   1182: sipush 3000
    //   1185: if_icmpne +70 -> 1255
    //   1188: aload_1
    //   1189: aload_2
    //   1190: invokestatic 366	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1193: ifne +15 -> 1208
    //   1196: aload_1
    //   1197: iconst_1
    //   1198: invokestatic 368	com/tencent/biz/webviewplugin/NewReportPlugin:b	(I)Ljava/lang/String;
    //   1201: invokestatic 370	com/tencent/biz/webviewplugin/NewReportPlugin:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1204: astore_0
    //   1205: goto +3 -> 1208
    //   1208: ldc_w 372
    //   1211: bipush 6
    //   1213: anewarray 4	java/lang/Object
    //   1216: dup
    //   1217: iconst_0
    //   1218: ldc 49
    //   1220: aastore
    //   1221: dup
    //   1222: iconst_1
    //   1223: aload_0
    //   1224: aastore
    //   1225: dup
    //   1226: iconst_2
    //   1227: ldc_w 374
    //   1230: aastore
    //   1231: dup
    //   1232: iconst_3
    //   1233: aload_2
    //   1234: aastore
    //   1235: dup
    //   1236: iconst_4
    //   1237: ldc 57
    //   1239: aastore
    //   1240: dup
    //   1241: iconst_5
    //   1242: iload 7
    //   1244: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1247: aastore
    //   1248: invokestatic 42	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1251: astore_0
    //   1252: goto +166 -> 1418
    //   1255: iload 7
    //   1257: sipush 1033
    //   1260: if_icmpeq +57 -> 1317
    //   1263: iload 7
    //   1265: sipush 1034
    //   1268: if_icmpne +6 -> 1274
    //   1271: goto +46 -> 1317
    //   1274: ldc_w 376
    //   1277: iconst_4
    //   1278: anewarray 4	java/lang/Object
    //   1281: dup
    //   1282: iconst_0
    //   1283: ldc 49
    //   1285: aastore
    //   1286: dup
    //   1287: iconst_1
    //   1288: aload_2
    //   1289: iconst_1
    //   1290: invokestatic 368	com/tencent/biz/webviewplugin/NewReportPlugin:b	(I)Ljava/lang/String;
    //   1293: invokestatic 370	com/tencent/biz/webviewplugin/NewReportPlugin:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1296: aastore
    //   1297: dup
    //   1298: iconst_2
    //   1299: ldc 57
    //   1301: aastore
    //   1302: dup
    //   1303: iconst_3
    //   1304: iload 7
    //   1306: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1309: aastore
    //   1310: invokestatic 42	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1313: astore_0
    //   1314: goto +104 -> 1418
    //   1317: aload 17
    //   1319: ldc 95
    //   1321: invokevirtual 61	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1324: istore 18
    //   1326: aload 17
    //   1328: ldc 100
    //   1330: invokevirtual 55	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1333: astore_0
    //   1334: aload_0
    //   1335: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1338: ifne +15 -> 1353
    //   1341: aload_0
    //   1342: invokevirtual 379	java/lang/String:getBytes	()[B
    //   1345: iconst_0
    //   1346: invokestatic 385	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   1349: astore_0
    //   1350: goto +3 -> 1353
    //   1353: ldc_w 387
    //   1356: bipush 8
    //   1358: anewarray 4	java/lang/Object
    //   1361: dup
    //   1362: iconst_0
    //   1363: ldc 49
    //   1365: aastore
    //   1366: dup
    //   1367: iconst_1
    //   1368: aload_2
    //   1369: iconst_1
    //   1370: invokestatic 368	com/tencent/biz/webviewplugin/NewReportPlugin:b	(I)Ljava/lang/String;
    //   1373: invokestatic 370	com/tencent/biz/webviewplugin/NewReportPlugin:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1376: aastore
    //   1377: dup
    //   1378: iconst_2
    //   1379: ldc 57
    //   1381: aastore
    //   1382: dup
    //   1383: iconst_3
    //   1384: iload 7
    //   1386: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1389: aastore
    //   1390: dup
    //   1391: iconst_4
    //   1392: ldc 95
    //   1394: aastore
    //   1395: dup
    //   1396: iconst_5
    //   1397: iload 18
    //   1399: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1402: aastore
    //   1403: dup
    //   1404: bipush 6
    //   1406: ldc 100
    //   1408: aastore
    //   1409: dup
    //   1410: bipush 7
    //   1412: aload_0
    //   1413: aastore
    //   1414: invokestatic 42	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1417: astore_0
    //   1418: aload_0
    //   1419: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1422: ifne +10 -> 1432
    //   1425: aload 6
    //   1427: aload_0
    //   1428: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: pop
    //   1432: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1435: ifeq +28 -> 1463
    //   1438: ldc 28
    //   1440: iconst_2
    //   1441: ldc_w 389
    //   1444: iconst_2
    //   1445: anewarray 4	java/lang/Object
    //   1448: dup
    //   1449: iconst_0
    //   1450: aload 17
    //   1452: aastore
    //   1453: dup
    //   1454: iconst_1
    //   1455: aload_0
    //   1456: aastore
    //   1457: invokestatic 42	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1460: invokestatic 46	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1463: aload 6
    //   1465: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1468: astore_0
    //   1469: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1472: ifeq +23 -> 1495
    //   1475: ldc 28
    //   1477: iconst_2
    //   1478: ldc_w 391
    //   1481: iconst_1
    //   1482: anewarray 4	java/lang/Object
    //   1485: dup
    //   1486: iconst_0
    //   1487: aload_0
    //   1488: aastore
    //   1489: invokestatic 42	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1492: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1495: aload_0
    //   1496: areturn
    //   1497: goto -892 -> 605
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1500	0	paramActivity	Activity
    //   0	1500	1	paramString1	String
    //   0	1500	2	paramString2	String
    //   0	1500	3	paramString3	String
    //   0	1500	4	paramString4	String
    //   0	1500	5	paramString5	String
    //   0	1500	6	paramString6	String
    //   0	1500	7	paramInt	int
    //   0	1500	8	paramString7	String
    //   0	1500	9	paramString8	String
    //   0	1500	10	paramString9	String
    //   0	1500	11	paramString10	String
    //   0	1500	12	paramString11	String
    //   0	1500	13	paramString12	String
    //   0	1500	14	paramString13	String
    //   0	1500	15	paramString14	String
    //   0	1500	16	paramString15	String
    //   0	1500	17	paramBundle	Bundle
    //   1324	74	18	i	int
    // Exception table:
    //   from	to	target	type
    //   610	636	639	java/lang/Exception
    //   582	602	643	java/lang/Exception
    //   605	610	643	java/lang/Exception
    //   556	582	647	java/lang/Exception
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
            break label344;
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
    label344:
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
      if (paramLong <= 0L)
      {
        paramLong = System.currentTimeMillis();
        ((INearbyFaceScoreManager)paramQBaseActivity.getAppRuntime().getManager(QQManagerFactory.FACE_SCORE_MANAGER)).a(Long.parseLong(paramString1), new NewReportPlugin.2(paramQBaseActivity, paramString1, paramString2, paramInt, paramString3, localQQProgressDialog, paramBundle, paramLong));
        return;
      }
      b(paramQBaseActivity, String.valueOf(paramLong), paramString1, paramString2, c(paramInt), b(paramInt, paramString3), localQQProgressDialog, paramBundle);
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
  
  public static void a(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if ((paramQBaseActivity != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString4)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NewReportPlugin", 2, String.format("safetyReport [%s, %s, %s, %s, %s]", new Object[] { paramString1, paramString2, paramString4, Integer.valueOf(paramInt), paramString5 }));
      }
      ThreadManager.excute(new NewReportPlugin.1(paramInt, paramQBaseActivity, paramString1, paramString2, paramString5, paramString3, paramString4), 16, null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewReportPlugin", 2, "safetyReport param null");
    }
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
      ThreadManager.excute(new NewReportPlugin.5(paramInt1, paramQBaseActivity, paramString1, paramString3, paramBundle, paramString2, paramString4, paramString5, paramInt2, paramString6, localQQProgressDialog), 16, null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewReportPlugin", 2, "actionSheetReport param null");
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
      ThreadManager.excute(new NewReportPlugin.4(paramInt, paramQBaseActivity, paramString1, paramString4, paramBundle, paramString2, paramString3, paramString5, paramString6, localQQProgressDialog), 16, null, false);
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
  
  public static String b(int paramInt)
  {
    if (paramInt == 2) {
      return "6bW#X@~L.+X)4%$>";
    }
    if (paramInt == 1) {}
    return "6bW#X@~L.+X)4%$>";
  }
  
  private static String b(int paramInt, String paramString)
  {
    int i = c(paramInt);
    if (i != paramInt) {
      paramString = a(i);
    }
    return paramString;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        paramString1 = Utils.a(a(paramString1.getBytes("utf-8"), paramString2, 1));
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
    int i = a(paramInt);
    Bundle localBundle = a(paramString1, paramInt);
    String str;
    if (paramInt == 0) {
      str = "1";
    } else {
      str = "0";
    }
    if ((paramInt != 3000) && (paramInt != 1))
    {
      if (paramInt != 1000) {
        paramString3 = null;
      }
    }
    else {
      paramString3 = paramString1;
    }
    if ((paramInt != 1001) && (paramInt != 10002))
    {
      if ((paramInt != 1034) && (paramInt != 1033) && (paramInt != 1044) && (paramInt != 1045))
      {
        a(paramQBaseActivity, paramString1, null, str, paramString3, paramString2, i, null, localBundle);
        return;
      }
      a(paramQBaseActivity, paramString1, b(paramString1, b(2)), str, paramString3, paramString2, i, null, localBundle);
      return;
    }
    a(paramQBaseActivity, 0L, paramString1, paramString3, i, null, localBundle);
  }
  
  private static void b(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, QQProgressDialog paramQQProgressDialog, Bundle paramBundle)
  {
    ThreadManager.excute(new NewReportPlugin.3(paramBundle, paramString4, paramInt, paramQBaseActivity, paramString2, paramString3, paramString1, paramQQProgressDialog), 16, null, false);
  }
  
  private static int c(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 3010) {
      i = 20006;
    }
    return i;
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
        paramString1 = Utils.a(paramString1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin
 * JD-Core Version:    0.7.0.1
 */