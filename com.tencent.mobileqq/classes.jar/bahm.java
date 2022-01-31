import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.teamwork.ReSendCmd;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.teamwork.TimDocSSOMsg.GetPadRightInfoReqBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.GetPadRightInfoRspBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.LoginInfo;
import com.tencent.pb.teamwork.TimDocSSOMsg.SetPadRightInfoReqBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.SetPadRightInfoRspBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xbab.cmd0xbab.GroupGetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab.GroupGetRsp;
import tencent.im.oidb.cmd0xbab.cmd0xbab.GroupSetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab.GroupSetRsp;
import tencent.im.oidb.cmd0xbab.cmd0xbab.ReqBody;
import tencent.im.oidb.cmd0xbab.cmd0xbab.RspBody;
import tencent.im.oidb.cmd0xbab.cmd0xbab.UserGetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab.UserGetRsp;
import tencent.im.oidb.cmd0xbab.cmd0xbab.UserSetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab.UserSetRsp;

public class bahm
  extends alpd
{
  private static String jdField_a_of_type_JavaLangString = "key_type_list";
  private static String jdField_b_of_type_JavaLangString;
  private volatile int jdField_a_of_type_Int;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  public boolean a;
  private volatile int jdField_b_of_type_Int;
  public boolean b;
  
  public bahm(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Boolean = bdne.b(paramQQAppInterface.getApp(), paramQQAppInterface.c(), "tencent_docs_config_enable_assistant", false);
    this.jdField_b_of_type_Boolean = bdne.b(paramQQAppInterface.getApp(), paramQQAppInterface.c(), "tencent_docs_config_preload_tool_process", false);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int j = -1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("global_padid", paramString1);
      paramString1 = bahp.b(localJSONObject, paramString2, "https://docs.qq.com/form/collect/recordcnt", "docs.qq.com");
      i = j;
      if (paramString1 != null)
      {
        paramString1 = new JSONObject(paramString1);
        i = j;
        if (paramString1.optInt("code", -1) == 0) {
          i = paramString1.optInt("total_cnt");
        }
      }
    }
    catch (JSONException paramString1)
    {
      do
      {
        int i = j;
      } while (!QLog.isColorLevel());
      QLog.e("TeamWorkHandler", 2, paramString1, new Object[0]);
    }
    return i;
    return -1;
  }
  
  private static File a(String paramString)
  {
    return new File(a(), bflr.b(paramString));
  }
  
  public static String a()
  {
    if (jdField_b_of_type_JavaLangString != null) {
      return jdField_b_of_type_JavaLangString;
    }
    String str = bkmi.a();
    str = str + "Tencent" + "/" + "tdoc" + "/";
    jdField_b_of_type_JavaLangString = str;
    return str;
  }
  
  private String a(ReSendCmd paramReSendCmd)
  {
    TicketManager localTicketManager = (TicketManager)this.mApp.getManager(2);
    if (localTicketManager != null)
    {
      paramReSendCmd = localTicketManager.GetSkey(this.mApp.getCurrentAccountUin(), 16L, new baho(this, localTicketManager, paramReSendCmd));
      if ((paramReSendCmd != null) && (paramReSendCmd._sig != null))
      {
        paramReSendCmd = new String(paramReSendCmd._sig);
        QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey with promise success! ");
        return paramReSendCmd;
      }
      QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey from server now! ");
    }
    for (;;)
    {
      return null;
      QLog.e("TeamWorkHandler", 1, "getSkeyFromServerAndRetry,ticketmanager is null");
    }
  }
  
  private String a(ReSendCmd paramReSendCmd, boolean paramBoolean)
  {
    Object localObject = (TicketManager)this.mApp.getManager(2);
    if (localObject != null)
    {
      String str = this.app.getCurrentAccountUin();
      bahn localbahn = new bahn(this, (TicketManager)localObject, paramReSendCmd);
      localObject = ((TicketManager)localObject).GetPskey(str, 16L, new String[] { "docs.qq.com" }, localbahn);
      if ((localObject != null) && (((Ticket)localObject)._pskey_map != null) && (((Ticket)localObject)._pskey_map.get("docs.qq.com") != null))
      {
        QLog.i("TeamWorkHandler", 1, "getPskeyFromServerAndRetry get pskey with promise success! isImediately Resend: " + paramBoolean);
        localObject = new String((byte[])((Ticket)localObject)._pskey_map.get("docs.qq.com"));
        if (paramBoolean)
        {
          a(paramReSendCmd);
          return localObject;
        }
      }
      else
      {
        QLog.i("TeamWorkHandler", 1, "getPskeyFromServerAndRetry get pskey from server now!");
      }
    }
    else
    {
      for (;;)
      {
        return null;
        QLog.e("TeamWorkHandler", 1, "getPskeyFromServerAndRetry,ticketmanager is null");
      }
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    return Uri.parse(paramString).getLastPathSegment();
  }
  
  public static String a(String paramString, bagf parambagf)
  {
    int j = 1;
    localObject2 = null;
    try
    {
      i = parambagf.jdField_a_of_type_Int;
      if (i != 0) {
        break label461;
      }
      i = 1;
    }
    catch (JSONException parambagf)
    {
      for (;;)
      {
        int i;
        JSONObject localJSONObject;
        Object localObject1;
        paramString = localObject2;
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkHandler", 2, parambagf, new Object[0]);
        }
        continue;
        paramString = null;
      }
    }
    localJSONObject = new JSONObject();
    localJSONObject.put("url", URLEncoder.encode(parambagf.e));
    if (parambagf.j != null) {
      localJSONObject.put("title", URLEncoder.encode(parambagf.j));
    }
    localJSONObject.put("type", 0);
    if (parambagf.k == null)
    {
      localObject1 = "0";
      localJSONObject.put("folderId", localObject1);
      localObject1 = new StringBuilder("https://docs.qq.com/cgi-bin/online_docs/wxqrcode").append('?').append("domainId=").append(parambagf.i).append("&padId=").append(parambagf.h).append("&dataType=");
      if (parambagf.jdField_b_of_type_Int != 3) {
        break label390;
      }
    }
    for (;;)
    {
      localObject1 = bahp.a(paramString, j + "&page=" + "pages/shareFriend/shareFriend" + "&ac=" + "share" + "&t=" + "0" + "&policy=" + String.valueOf(i) + "&right_flag=" + "1" + "&param=" + localJSONObject.toString() + "&type=" + "1", "docs.qq.com");
      if (localObject1 == null) {
        break label456;
      }
      parambagf = new JSONObject((String)localObject1);
      paramString = parambagf;
      for (;;)
      {
        try
        {
          if (parambagf.optInt("retcode", -1) != 0)
          {
            parambagf.put("retcode", -1);
            paramString = parambagf;
            if (QLog.isColorLevel())
            {
              QLog.e("TeamWorkHandler", 2, "failed result" + (String)localObject1);
              paramString = parambagf;
            }
          }
          parambagf = paramString;
          if (paramString == null) {
            paramString = new JSONObject();
          }
        }
        catch (JSONException localJSONException2)
        {
          label390:
          paramString = parambagf;
          parambagf = localJSONException2;
          continue;
        }
        try
        {
          paramString.put("retcode", -1);
          parambagf = paramString;
        }
        catch (JSONException localJSONException1)
        {
          parambagf = paramString;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("TeamWorkHandler", 2, localJSONException1, new Object[0]);
          parambagf = paramString;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TeamWorkHandler", 2, parambagf.toString());
      }
      return (String)parambagf.opt("key");
      localObject1 = parambagf.k;
      break;
      j = 0;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      Object localObject = paramString1.split("\\$");
      if (localObject.length == 2)
      {
        new JSONObject();
        try
        {
          paramString1 = UUID.randomUUID().toString().replaceAll("-", "");
          StringBuilder localStringBuilder1 = new StringBuilder().append("TOK=").append(paramString1);
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("domain_id=");
          localStringBuilder2.append(localObject[0]);
          localStringBuilder2.append("&pad_id=");
          localStringBuilder2.append(localObject[1]);
          localStringBuilder2.append("&list_type=");
          localStringBuilder2.append(5);
          localStringBuilder2.append("&xsrf=");
          localStringBuilder2.append(paramString1);
          localObject = new HashMap();
          ((Map)localObject).put("HTTP_X_XSRF_PROTECTION", paramString1);
          paramString1 = bahp.a(localStringBuilder2.toString(), paramString2, "https://docs.qq.com/cgi-bin/online_docs/doc_delete", "docs.qq.com", localStringBuilder1.toString(), (Map)localObject, false);
          return paramString1;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
        }
      }
    }
    return null;
  }
  
  /* Error */
  public static JSONObject a(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_2
    //   3: new 122	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 376
    //   13: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc_w 378
    //   23: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload_1
    //   27: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: ldc 69
    //   35: invokestatic 311	bahp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +155 -> 197
    //   45: new 58	org/json/JSONObject
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 77	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 313
    //   61: iconst_m1
    //   62: invokevirtual 83	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   65: ifeq +50 -> 115
    //   68: aload_2
    //   69: ldc_w 313
    //   72: iconst_m1
    //   73: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   76: pop
    //   77: aload_2
    //   78: astore_0
    //   79: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +33 -> 115
    //   85: ldc_w 380
    //   88: iconst_2
    //   89: new 122	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 315
    //   99: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 4
    //   104: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_2
    //   114: astore_0
    //   115: aload_0
    //   116: astore_2
    //   117: aload_0
    //   118: ifnonnull +20 -> 138
    //   121: new 58	org/json/JSONObject
    //   124: dup
    //   125: invokespecial 59	org/json/JSONObject:<init>	()V
    //   128: astore_2
    //   129: aload_2
    //   130: ldc_w 313
    //   133: iconst_m1
    //   134: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   137: pop
    //   138: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +14 -> 155
    //   144: ldc_w 380
    //   147: iconst_2
    //   148: aload_2
    //   149: invokevirtual 306	org/json/JSONObject:toString	()Ljava/lang/String;
    //   152: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_2
    //   156: areturn
    //   157: astore_2
    //   158: aload_3
    //   159: astore_0
    //   160: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +15 -> 178
    //   166: ldc_w 380
    //   169: iconst_2
    //   170: aload_2
    //   171: iconst_0
    //   172: anewarray 98	java/lang/Object
    //   175: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   178: goto -63 -> 115
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 381	org/json/JSONException:printStackTrace	()V
    //   186: goto -48 -> 138
    //   189: astore_3
    //   190: aload_2
    //   191: astore_0
    //   192: aload_3
    //   193: astore_2
    //   194: goto -34 -> 160
    //   197: aconst_null
    //   198: astore_0
    //   199: goto -84 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramString1	String
    //   0	202	1	paramInt	int
    //   0	202	2	paramString2	String
    //   1	158	3	localObject	Object
    //   189	4	3	localJSONException	JSONException
    //   38	65	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	40	157	org/json/JSONException
    //   45	55	157	org/json/JSONException
    //   129	138	181	org/json/JSONException
    //   57	77	189	org/json/JSONException
    //   79	113	189	org/json/JSONException
  }
  
  private static JSONObject a(String paramString, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("uintype", paramInt);
    localJSONObject.put("uin", paramString);
    if (paramBoolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localJSONObject.put("info", paramInt);
      localJSONObject.put("new", 1);
      return localJSONObject;
    }
  }
  
  /* Error */
  public static JSONObject a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: new 122	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 393
    //   13: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: ldc 69
    //   25: invokestatic 311	bahp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +150 -> 180
    //   33: new 58	org/json/JSONObject
    //   36: dup
    //   37: aload_3
    //   38: invokespecial 77	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: astore_0
    //   44: aload_1
    //   45: ldc_w 313
    //   48: iconst_m1
    //   49: invokevirtual 83	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   52: ifeq +48 -> 100
    //   55: aload_1
    //   56: ldc_w 313
    //   59: iconst_m1
    //   60: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   63: pop
    //   64: aload_1
    //   65: astore_0
    //   66: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +31 -> 100
    //   72: ldc 96
    //   74: iconst_2
    //   75: new 122	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 315
    //   85: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_3
    //   89: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_1
    //   99: astore_0
    //   100: aload_0
    //   101: astore_1
    //   102: aload_0
    //   103: ifnonnull +20 -> 123
    //   106: new 58	org/json/JSONObject
    //   109: dup
    //   110: invokespecial 59	org/json/JSONObject:<init>	()V
    //   113: astore_1
    //   114: aload_1
    //   115: ldc_w 313
    //   118: iconst_m1
    //   119: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   122: pop
    //   123: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +13 -> 139
    //   129: ldc 96
    //   131: iconst_2
    //   132: aload_1
    //   133: invokevirtual 306	org/json/JSONObject:toString	()Ljava/lang/String;
    //   136: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_1
    //   140: areturn
    //   141: astore_1
    //   142: aload_2
    //   143: astore_0
    //   144: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +14 -> 161
    //   150: ldc 96
    //   152: iconst_2
    //   153: aload_1
    //   154: iconst_0
    //   155: anewarray 98	java/lang/Object
    //   158: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   161: goto -61 -> 100
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 381	org/json/JSONException:printStackTrace	()V
    //   169: goto -46 -> 123
    //   172: astore_2
    //   173: aload_1
    //   174: astore_0
    //   175: aload_2
    //   176: astore_1
    //   177: goto -33 -> 144
    //   180: aconst_null
    //   181: astore_0
    //   182: goto -82 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramString1	String
    //   0	185	1	paramString2	String
    //   1	142	2	localObject	Object
    //   172	4	2	localJSONException	JSONException
    //   28	61	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	29	141	org/json/JSONException
    //   33	42	141	org/json/JSONException
    //   114	123	164	org/json/JSONException
    //   44	64	172	org/json/JSONException
    //   66	98	172	org/json/JSONException
  }
  
  /* Error */
  public static JSONObject a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 5
    //   8: new 122	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 398
    //   18: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc_w 400
    //   28: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: ldc_w 402
    //   35: invokestatic 404	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 378
    //   44: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_2
    //   48: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc_w 406
    //   54: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_3
    //   58: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 408
    //   64: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload 4
    //   69: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: ldc 69
    //   77: invokestatic 311	bahp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_3
    //   81: aload_3
    //   82: ifnull +187 -> 269
    //   85: new 58	org/json/JSONObject
    //   88: dup
    //   89: aload_3
    //   90: invokespecial 77	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   93: astore_1
    //   94: aload_1
    //   95: astore_0
    //   96: aload_1
    //   97: ldc_w 313
    //   100: iconst_m1
    //   101: invokevirtual 83	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   104: ifeq +49 -> 153
    //   107: aload_1
    //   108: ldc_w 313
    //   111: iconst_m1
    //   112: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload_1
    //   117: astore_0
    //   118: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +32 -> 153
    //   124: ldc_w 410
    //   127: iconst_2
    //   128: new 122	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 315
    //   138: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_3
    //   142: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_1
    //   152: astore_0
    //   153: aload_0
    //   154: astore_1
    //   155: aload_0
    //   156: ifnonnull +20 -> 176
    //   159: new 58	org/json/JSONObject
    //   162: dup
    //   163: invokespecial 59	org/json/JSONObject:<init>	()V
    //   166: astore_1
    //   167: aload_1
    //   168: ldc_w 313
    //   171: iconst_m1
    //   172: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   175: pop
    //   176: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +14 -> 193
    //   182: ldc_w 410
    //   185: iconst_2
    //   186: aload_1
    //   187: invokevirtual 306	org/json/JSONObject:toString	()Ljava/lang/String;
    //   190: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload_1
    //   194: areturn
    //   195: astore_1
    //   196: aload 6
    //   198: astore_0
    //   199: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +15 -> 217
    //   205: ldc_w 410
    //   208: iconst_2
    //   209: aload_1
    //   210: iconst_0
    //   211: anewarray 98	java/lang/Object
    //   214: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   217: goto -64 -> 153
    //   220: astore_1
    //   221: aload 7
    //   223: astore_0
    //   224: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +15 -> 242
    //   230: ldc_w 410
    //   233: iconst_2
    //   234: aload_1
    //   235: iconst_0
    //   236: anewarray 98	java/lang/Object
    //   239: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   242: goto -89 -> 153
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 381	org/json/JSONException:printStackTrace	()V
    //   250: goto -74 -> 176
    //   253: astore_3
    //   254: aload_1
    //   255: astore_0
    //   256: aload_3
    //   257: astore_1
    //   258: goto -34 -> 224
    //   261: astore_3
    //   262: aload_1
    //   263: astore_0
    //   264: aload_3
    //   265: astore_1
    //   266: goto -67 -> 199
    //   269: aconst_null
    //   270: astore_0
    //   271: goto -118 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramString1	String
    //   0	274	1	paramString2	String
    //   0	274	2	paramInt	int
    //   0	274	3	paramString3	String
    //   0	274	4	paramString4	String
    //   0	274	5	paramString5	String
    //   4	193	6	localObject1	Object
    //   1	221	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	81	195	org/json/JSONException
    //   85	94	195	org/json/JSONException
    //   6	81	220	java/io/UnsupportedEncodingException
    //   85	94	220	java/io/UnsupportedEncodingException
    //   167	176	245	org/json/JSONException
    //   96	116	253	java/io/UnsupportedEncodingException
    //   118	151	253	java/io/UnsupportedEncodingException
    //   96	116	261	org/json/JSONException
    //   118	151	261	org/json/JSONException
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      String str = bahp.b(paramJSONObject, paramString, "https://docs.qq.com/cgi-go/imp/import_form_cache", "docs.qq.com");
      if (str != null)
      {
        paramJSONObject = new JSONObject(str);
        paramString = paramJSONObject;
      }
      label87:
      return null;
    }
    catch (JSONException localJSONException1)
    {
      do
      {
        try
        {
          if (paramJSONObject.optInt("retcode", -1) != 0)
          {
            paramJSONObject.put("retcode", -1);
            paramString = paramJSONObject;
            if (QLog.isColorLevel())
            {
              QLog.e("TeamWorkHandler", 2, "checkFormCache failed result" + str);
              paramString = paramJSONObject;
            }
          }
          return paramString;
        }
        catch (JSONException localJSONException2)
        {
          break label87;
        }
        localJSONException1 = localJSONException1;
        paramJSONObject = null;
        paramString = paramJSONObject;
      } while (!QLog.isColorLevel());
      QLog.e("TeamWorkHandler", 2, localJSONException1, new Object[0]);
      return paramJSONObject;
    }
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    try
    {
      paramString2 = bahp.a(paramJSONObject, paramString1, "https://docs.qq.com/cgi-go/imp/import_form_file", paramString2);
      if (paramString2 != null)
      {
        paramJSONObject = new JSONObject(paramString2);
        paramString1 = paramJSONObject;
      }
      label77:
      return null;
    }
    catch (JSONException paramString2)
    {
      do
      {
        try
        {
          if (paramJSONObject.optInt("retcode", -1) != 0)
          {
            paramString1 = paramJSONObject;
            if (QLog.isColorLevel())
            {
              QLog.e("TeamWorkHandler", 2, "checkFormCache failed result" + paramString2);
              paramString1 = paramJSONObject;
            }
          }
          return paramString1;
        }
        catch (JSONException paramString2)
        {
          break label77;
        }
        paramString2 = paramString2;
        paramJSONObject = null;
        paramString1 = paramJSONObject;
      } while (!QLog.isColorLevel());
      QLog.e("TeamWorkHandler", 2, paramString2, new Object[0]);
      return paramJSONObject;
    }
  }
  
  public static void a()
  {
    Object localObject1 = new File(a());
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (System.currentTimeMillis() - localObject2.lastModified() > 7200000L) {
          localObject2.delete();
        }
        i += 1;
      }
    }
  }
  
  private void a(ReSendCmd paramReSendCmd)
  {
    if (paramReSendCmd != null)
    {
      QLog.i("TeamWorkHandler", 1, " reTrySendCmd retry cmd：" + paramReSendCmd.jdField_a_of_type_Int);
      if (paramReSendCmd.jdField_a_of_type_Int == 9) {
        a(paramReSendCmd.d, paramReSendCmd.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public static void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = bahp.b("doc_url=" + URLEncoder.encode(paramString3), paramString1, "https://docs.qq.com/cgi-bin/online_docs/doc_content", "docs.qq.com");
    if (!TextUtils.isEmpty(paramString1)) {
      bdhb.a(a(), bflr.b(paramString2), paramString1);
    }
  }
  
  private boolean a(ReSendCmd paramReSendCmd)
  {
    if (paramReSendCmd != null)
    {
      int i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramReSendCmd.jdField_a_of_type_Int, 0);
      QLog.i("TeamWorkHandler", 1, " handleResponseTry retry cmd：" + paramReSendCmd.jdField_a_of_type_Int + ", retryCount: " + i);
      if ((paramReSendCmd != null) && (i < 3))
      {
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramReSendCmd.jdField_a_of_type_Int, i + 1);
        String str = a(paramReSendCmd, true);
        if ((!TextUtils.isEmpty(str)) && (str.length() > 0)) {
          QLog.i("TeamWorkHandler", 1, " handleResponseTry retry to get pskey from SDK success,cmd: " + paramReSendCmd.jdField_a_of_type_Int);
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    paramString = a(paramString);
    if (System.currentTimeMillis() - paramString.lastModified() > 7200000L)
    {
      paramString.delete();
      return false;
    }
    return paramString.exists();
  }
  
  public static boolean a(String paramString, bagf parambagf)
  {
    Object localObject = UUID.randomUUID().toString().replaceAll("-", "");
    parambagf = new StringBuilder("https://docs.qq.com/cgi-bin/api/wechatshare/shareTips").append('?').append("domainId=").append(parambagf.i).append("&padId=").append(parambagf.h).append("&xsrf=").append((String)localObject);
    localObject = new StringBuilder().append("TOK=").append((String)localObject);
    try
    {
      paramString = bahp.a(paramString, parambagf.toString(), "docs.qq.com", ((StringBuilder)localObject).toString());
      if (paramString != null)
      {
        if (new JSONObject(paramString).optInt("retcode", -1) == 0) {
          break label157;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkHandler", 2, "wechatShareTips failed result" + paramString);
        }
      }
    }
    catch (JSONException paramString)
    {
      label157:
      while (!QLog.isColorLevel()) {}
      QLog.e("TeamWorkHandler", 2, paramString, new Object[0]);
    }
    return false;
    return true;
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, int paramInt, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    if (TextUtils.isEmpty(paramString3)) {
      return false;
    }
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("policy", paramInt);
      if (((paramList1 == null) || (paramList1.isEmpty())) && ((paramList2 == null) || (paramList2.isEmpty())) && ((paramList3 == null) || (paramList3.isEmpty()))) {
        break label288;
      }
      localJSONArray = new JSONArray();
      if (paramList1 != null)
      {
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext())
        {
          String str = (String)paramList1.next();
          if (str != null) {
            localJSONArray.put(a(str, 0, paramBoolean2));
          }
        }
      }
      if (paramList2 == null) {
        break label219;
      }
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TeamWorkHandler", 2, paramString1, new Object[0]);
      }
      return false;
    }
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (String)paramList1.next();
      if (paramList2 != null) {
        localJSONArray.put(a(paramList2, 2, paramBoolean2));
      }
    }
    label219:
    if (paramList3 != null)
    {
      paramList1 = paramList3.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if (paramList2 != null) {
          localJSONArray.put(a(paramList2, 3, paramBoolean2));
        }
      }
    }
    localJSONObject.put("addmemlist", localJSONArray);
    label288:
    paramList1 = UUID.randomUUID().toString().replaceAll("-", "");
    paramString2 = new StringBuilder(String.format("https://docs.qq.com/cgi-bin/redirect/%s/ep/api/setpadinfo", new Object[] { paramString2 })).append('?').append("localPadId=").append(paramString3).append("&type=1").append("&data=").append(localJSONObject.toString()).append("&dataType=");
    if (paramBoolean1) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString2 = paramString2.append(paramInt).append("&xsrf=").append(paramList1);
      paramString3 = new StringBuilder().append("TOK=").append(paramList1);
      paramString1 = bahp.a(paramString1, paramString2.toString(), "docs.qq.com", paramString3.toString());
      if (paramString1 == null) {
        break;
      }
      if (new JSONObject(paramString1).optInt("retcode", -1) == 0) {
        break label490;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("TeamWorkHandler", 2, "setPolicy4AllByHttp failed result" + paramString1);
      break;
    }
    label490:
    return true;
  }
  
  public static String b(String paramString)
  {
    return bdhb.a(a(paramString));
  }
  
  public static JSONObject b(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      String str = bahp.b(paramJSONObject, paramString, "https://docs.qq.com/cgi-go/imp/import_form_url", "docs.qq.com");
      if (str != null)
      {
        paramJSONObject = new JSONObject(str);
        paramString = paramJSONObject;
      }
      label78:
      return null;
    }
    catch (JSONException localJSONException1)
    {
      do
      {
        try
        {
          if (paramJSONObject.optInt("retcode", -1) != 0)
          {
            paramString = paramJSONObject;
            if (QLog.isColorLevel())
            {
              QLog.e("TeamWorkHandler", 2, "checkFormCache failed result" + str);
              paramString = paramJSONObject;
            }
          }
          return paramString;
        }
        catch (JSONException localJSONException2)
        {
          break label78;
        }
        localJSONException1 = localJSONException1;
        paramJSONObject = null;
        paramString = paramJSONObject;
      } while (!QLog.isColorLevel());
      QLog.e("TeamWorkHandler", 2, localJSONException1, new Object[0]);
      return paramJSONObject;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int i = ((Integer)paramToServiceMsg.getAttribute(jdField_a_of_type_JavaLangString)).intValue();
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleSetPadRightsInfo ,resultCode: " + paramFromServiceMsg.getResultCode());
    }
    if (!bool) {
      paramToServiceMsg = "";
    }
    for (;;)
    {
      if (!bool) {
        QLog.i("TeamWorkHandler", 1, " handleGetPadRightsInfo faied code: " + paramFromServiceMsg.getResultCode());
      }
      notifyUI(6, bool, new Object[] { paramToServiceMsg, Integer.valueOf(i) });
      return;
      paramToServiceMsg = new TimDocSSOMsg.SetPadRightInfoRspBody();
      int j;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        j = paramToServiceMsg.uint32_retcode.get();
        if (j == 0) {
          break label247;
        }
        QLog.e("TeamWorkHandler", 1, "error handleSetPadRightsInfo  url : " + "" + ",retCode: " + j);
        paramToServiceMsg = "";
        bool = false;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.i("TeamWorkHandler", 1, " handleSetPadRightsInfo exception: " + paramToServiceMsg.toString());
        paramToServiceMsg = "";
        bool = false;
      }
      continue;
      label247:
      paramToServiceMsg = paramToServiceMsg.bytes_pad_url.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkHandler", 2, " handleSetPadRightsInfo url : " + paramToServiceMsg + ",retCode: " + j);
      }
      bool = true;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramToServiceMsg.getAttribute("data");
      long l = ((Long)paramToServiceMsg.getAttribute("seq")).longValue();
      paramToServiceMsg = new cmd0xbab.RspBody();
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      int i;
      if (j == 0)
      {
        paramToServiceMsg = (cmd0xbab.UserGetRsp)paramToServiceMsg.user_get_rsp.get();
        int k = paramToServiceMsg.policy.get();
        int m = paramToServiceMsg.privilege_flag.get();
        int n = paramToServiceMsg.member_number.get();
        int i1 = paramToServiceMsg.exp_remain_time.get();
        i = paramToServiceMsg.exp_set_time.get();
        QLog.i("TeamWorkHandler" + bagj.i, 2, " handleGetUserAuthDocsGrayTips  | policy=" + k + " privilege =" + m + " memberNum = " + n + " remainTime = " + i1 + " setTime= " + i);
        if ((Integer.valueOf(localDocsGrayTipsInfo.n).intValue() == m) && (Integer.valueOf(localDocsGrayTipsInfo.m).intValue() == k))
        {
          if ((i == 0) || (i1 != 0)) {
            break label425;
          }
          i = 0;
        }
      }
      for (;;)
      {
        a(localDocsGrayTipsInfo, i, l);
        boolean bool = true;
        paramToServiceMsg = "";
        for (;;)
        {
          if (!bool) {
            notifyUI(8, bool, new Object[] { localDocsGrayTipsInfo, paramToServiceMsg, Long.valueOf(l) });
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("TeamWorkHandler" + bagj.i, 2, " handleGetUserAuthDocsGrayTips ,result: " + j);
          return;
          bool = false;
          paramToServiceMsg = this.app.getApp().getString(2131720699);
          continue;
          bool = false;
          paramToServiceMsg = localDocsGrayTipsInfo.k;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("TeamWorkHandler" + bagj.i, 1, " handleGetUserAuthDocsGrayTips exception = " + paramToServiceMsg.toString());
      return;
    }
    label425:
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      DocsGrayTipsInfo localDocsGrayTipsInfo;
      try
      {
        localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramToServiceMsg.getAttribute("data");
        long l = ((Long)paramToServiceMsg.getAttribute("seq")).longValue();
        paramToServiceMsg = new cmd0xbab.RspBody();
        int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
        if (i == 0)
        {
          paramToServiceMsg = (cmd0xbab.UserSetRsp)paramToServiceMsg.user_set_rsp.get();
          paramToServiceMsg = localDocsGrayTipsInfo.j;
          if ("1".equals(localDocsGrayTipsInfo.d))
          {
            azqs.b(null, "CliOper", "", "", "0X8009550", "0X8009550", 0, 0, "", "", "", "");
            break label309;
            notifyUI(9, bool, new Object[] { localDocsGrayTipsInfo, paramToServiceMsg, Long.valueOf(l) });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("TeamWorkHandler" + bagj.i, 2, " handleSetUserAuthDocsGrayTips ,result: " + i);
          }
          else if ("2".equals(localDocsGrayTipsInfo.d))
          {
            azqs.b(null, "CliOper", "", "", "0X8009552", "0X8009552", 0, 0, "", "", "", "");
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("TeamWorkHandler" + bagj.i, 1, " handleSetUserAuthDocsGrayTips  exception = " + paramToServiceMsg.toString());
        return;
      }
      boolean bool = false;
      paramToServiceMsg = localDocsGrayTipsInfo.k;
      continue;
      label309:
      bool = true;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramToServiceMsg.getAttribute("data");
      long l = ((Long)paramToServiceMsg.getAttribute("seq")).longValue();
      paramToServiceMsg = new cmd0xbab.RspBody();
      int k = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      boolean bool;
      if (k == 0)
      {
        paramToServiceMsg = (cmd0xbab.GroupGetRsp)paramToServiceMsg.group_get_rsp.get();
        int i = paramToServiceMsg.policy.get();
        paramFromServiceMsg = paramToServiceMsg.user_list.get();
        int n = paramToServiceMsg.total_members.get();
        int i1 = paramToServiceMsg.privilege_members.get();
        int i2 = paramToServiceMsg.privilege_flag.get();
        int i3 = paramToServiceMsg.member_number.get();
        int m = paramToServiceMsg.exp_remain_time.get();
        int j = paramToServiceMsg.exp_set_time.get();
        QLog.i("TeamWorkHandler" + bagj.i, 1, " handleGetGroupAuthDocsGrayTips  | policy = " + i + " userInfoList.size() = " + paramFromServiceMsg.size() + " totalMembers = " + n + " privilegeMembers = " + i1 + " privilege = " + i2 + " memberNum = " + i3 + " remainTime = " + m + " setTime = " + j + " docsGrayTipsInfo.policy = " + localDocsGrayTipsInfo.m + " docsGrayTipsInfo.privilege = " + localDocsGrayTipsInfo.n);
        if ((Integer.valueOf(localDocsGrayTipsInfo.n).intValue() == i2) && (Integer.valueOf(localDocsGrayTipsInfo.m).intValue() == i))
        {
          i = j;
          if (j != 0)
          {
            i = j;
            if (m == 0) {
              i = 0;
            }
          }
          b(localDocsGrayTipsInfo, i, l);
          bool = true;
          paramToServiceMsg = "";
        }
      }
      for (;;)
      {
        QLog.i("TeamWorkHandler" + bagj.i, 1, " handleGetGroupAuthDocsGrayTips. result = " + k + ", isSuccess = " + bool);
        if (bool) {
          break;
        }
        notifyUI(10, bool, new Object[] { localDocsGrayTipsInfo, paramToServiceMsg, Long.valueOf(l) });
        return;
        bool = false;
        paramToServiceMsg = this.app.getApp().getString(2131720699);
        continue;
        bool = false;
        paramToServiceMsg = localDocsGrayTipsInfo.k;
      }
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("TeamWorkHandler" + bagj.i, 1, " handleGetGroupAuthDocsGrayTips exception = " + paramToServiceMsg.toString());
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      DocsGrayTipsInfo localDocsGrayTipsInfo;
      try
      {
        localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramToServiceMsg.getAttribute("data");
        long l = ((Long)paramToServiceMsg.getAttribute("seq")).longValue();
        paramToServiceMsg = new cmd0xbab.RspBody();
        int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
        if (i == 0)
        {
          paramToServiceMsg = (cmd0xbab.GroupSetRsp)paramToServiceMsg.group_set_rsp.get();
          paramToServiceMsg = localDocsGrayTipsInfo.j;
          if ("1".equals(localDocsGrayTipsInfo.d))
          {
            azqs.b(null, "CliOper", "", "", "0X8009550", "0X8009550", 1, 0, "", "", "", "");
            break label303;
            QLog.i("TeamWorkHandler" + bagj.i, 1, " handleSetGroupAuthDocsGrayTips. result = " + i);
            notifyUI(11, bool, new Object[] { localDocsGrayTipsInfo, paramToServiceMsg, Long.valueOf(l) });
          }
          else if ("2".equals(localDocsGrayTipsInfo.d))
          {
            azqs.b(null, "CliOper", "", "", "0X8009552", "0X8009552", 1, 0, "", "", "", "");
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("TeamWorkHandler" + bagj.i, 1, " handleSetGroupAuthDocsGrayTips  exception = " + paramToServiceMsg.toString());
        return;
      }
      boolean bool = false;
      paramToServiceMsg = localDocsGrayTipsInfo.k;
      continue;
      label303:
      bool = true;
    }
  }
  
  TimDocSSOMsg.LoginInfo a(String paramString, ReSendCmd paramReSendCmd)
  {
    Object localObject = (TicketManager)this.mApp.getManager(2);
    if (localObject != null)
    {
      String str2 = ((TicketManager)localObject).getPskey(this.mApp.getCurrentAccountUin(), "docs.qq.com");
      String str1 = ((TicketManager)localObject).getSkey(this.mApp.getAccount());
      if (!TextUtils.isEmpty(str2))
      {
        localObject = new TimDocSSOMsg.LoginInfo();
        ((TimDocSSOMsg.LoginInfo)localObject).bytes_pskey.set(ByteStringMicro.copyFromUtf8(str2));
        this.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(str1))
        {
          this.jdField_b_of_type_Int = 0;
          if (localObject != null) {
            ((TimDocSSOMsg.LoginInfo)localObject).bytes_skey.set(ByteStringMicro.copyFromUtf8(str1));
          }
        }
        label317:
        label319:
        do
        {
          do
          {
            return localObject;
            QLog.i("TeamWorkHandler", 1, paramString + " pSkey is null, try to get pskey from server,reTryGetPskeyCount " + this.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_Int < 3) && (paramReSendCmd != null))
            {
              this.jdField_a_of_type_Int += 1;
              str2 = a(paramReSendCmd, false);
              if (TextUtils.isEmpty(str2)) {
                break label336;
              }
              this.jdField_a_of_type_Int = 0;
              localObject = new TimDocSSOMsg.LoginInfo();
              ((TimDocSSOMsg.LoginInfo)localObject).bytes_pskey.set(ByteStringMicro.copyFromUtf8(str2));
              break;
            }
            this.jdField_a_of_type_Int = 0;
            localObject = new TimDocSSOMsg.LoginInfo();
            break;
            QLog.i("TeamWorkHandler", 1, paramString + " skey is null,try to get skey from server, reTryGetSkeyCount: " + this.jdField_b_of_type_Int);
            if ((this.jdField_b_of_type_Int >= 3) || (paramReSendCmd == null)) {
              break label319;
            }
            this.jdField_b_of_type_Int += 1;
            paramString = a(paramReSendCmd);
            if (TextUtils.isEmpty(paramString)) {
              break label317;
            }
            this.jdField_b_of_type_Int = 0;
          } while (localObject == null);
          ((TimDocSSOMsg.LoginInfo)localObject).bytes_skey.set(ByteStringMicro.copyFromUtf8(paramString));
          return localObject;
          return null;
          this.jdField_a_of_type_Int = 0;
        } while (localObject != null);
        return new TimDocSSOMsg.LoginInfo();
        label336:
        localObject = null;
      }
    }
    return null;
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = "xsrf=" + paramString3 + "&uin=" + paramString1;
      paramString2 = "vfwebqq=" + paramString2 + ";TOK=" + paramString3;
      paramString1 = bahp.a(paramString1, this.app.getCurrentAccountUin(), "https://docs.qq.com/cgi-bin/online_docs/tool_decryptuin", "docs.qq.com", paramString2, null, false);
      if (TextUtils.isEmpty(paramString1)) {
        return null;
      }
      paramString1 = new JSONObject(paramString1);
      int i = paramString1.optInt("cgicode", -1);
      paramString2 = paramString1.optString("msg");
      if (i == 0) {
        return paramString1.optString("uin");
      }
      QLog.w("TeamWorkHandler", 1, "no result, cgicode: " + i + " msg: " + paramString2);
      return null;
    }
    catch (JSONException paramString1)
    {
      QLog.e("TeamWorkHandler", 1, paramString1.getLocalizedMessage(), paramString1);
    }
    return null;
  }
  
  /* Error */
  public JSONObject a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 191	bahm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   9: ldc_w 865
    //   12: ldc 69
    //   14: invokestatic 311	bahp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +148 -> 167
    //   22: new 58	org/json/JSONObject
    //   25: dup
    //   26: aload_3
    //   27: invokespecial 77	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: ldc_w 313
    //   37: iconst_m1
    //   38: invokevirtual 83	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   41: ifeq +48 -> 89
    //   44: aload_2
    //   45: ldc_w 313
    //   48: iconst_m1
    //   49: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   52: pop
    //   53: aload_2
    //   54: astore_1
    //   55: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +31 -> 89
    //   61: ldc 96
    //   63: iconst_2
    //   64: new 122	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 315
    //   74: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_3
    //   78: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload_2
    //   88: astore_1
    //   89: aload_1
    //   90: astore_2
    //   91: aload_1
    //   92: ifnonnull +20 -> 112
    //   95: new 58	org/json/JSONObject
    //   98: dup
    //   99: invokespecial 59	org/json/JSONObject:<init>	()V
    //   102: astore_2
    //   103: aload_2
    //   104: ldc_w 313
    //   107: iconst_m1
    //   108: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   111: pop
    //   112: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +13 -> 128
    //   118: ldc 96
    //   120: iconst_2
    //   121: aload_2
    //   122: invokevirtual 306	org/json/JSONObject:toString	()Ljava/lang/String;
    //   125: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_2
    //   129: areturn
    //   130: astore_2
    //   131: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +14 -> 148
    //   137: ldc 96
    //   139: iconst_2
    //   140: aload_2
    //   141: iconst_0
    //   142: anewarray 98	java/lang/Object
    //   145: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   148: goto -59 -> 89
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 381	org/json/JSONException:printStackTrace	()V
    //   156: goto -44 -> 112
    //   159: astore_3
    //   160: aload_2
    //   161: astore_1
    //   162: aload_3
    //   163: astore_2
    //   164: goto -33 -> 131
    //   167: aconst_null
    //   168: astore_1
    //   169: goto -80 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	bahm
    //   1	91	1	localObject1	Object
    //   151	2	1	localJSONException1	JSONException
    //   161	8	1	localObject2	Object
    //   30	99	2	localObject3	Object
    //   130	31	2	localJSONException2	JSONException
    //   163	1	2	localJSONException3	JSONException
    //   17	61	3	str	String
    //   159	4	3	localJSONException4	JSONException
    // Exception table:
    //   from	to	target	type
    //   2	18	130	org/json/JSONException
    //   22	31	130	org/json/JSONException
    //   103	112	151	org/json/JSONException
    //   33	53	159	org/json/JSONException
    //   55	87	159	org/json/JSONException
  }
  
  /* Error */
  public JSONObject a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 339	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   5: invokevirtual 340	java/util/UUID:toString	()Ljava/lang/String;
    //   8: ldc_w 342
    //   11: ldc_w 344
    //   14: invokevirtual 347	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   17: astore 4
    //   19: new 122	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 868
    //   26: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: bipush 63
    //   31: invokevirtual 267	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   34: ldc_w 870
    //   37: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokestatic 434	java/lang/System:currentTimeMillis	()J
    //   43: invokevirtual 873	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: ldc_w 357
    //   49: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload 4
    //   54: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: astore_2
    //   58: aload_1
    //   59: invokestatic 470	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   62: ifne +15 -> 77
    //   65: aload_2
    //   66: ldc_w 875
    //   69: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: new 122	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 349
    //   87: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 4
    //   92: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: astore_1
    //   96: aload_0
    //   97: getfield 191	bahm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   100: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   103: aload_2
    //   104: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: ldc 69
    //   109: aload_1
    //   110: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 500	bahp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 4
    //   118: aload 4
    //   120: invokestatic 470	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +143 -> 266
    //   126: new 58	org/json/JSONObject
    //   129: dup
    //   130: aload 4
    //   132: invokespecial 77	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   135: astore_2
    //   136: aload_2
    //   137: astore_1
    //   138: aload_2
    //   139: ldc_w 313
    //   142: iconst_m1
    //   143: invokevirtual 83	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   146: ifeq +40 -> 186
    //   149: aload_2
    //   150: astore_1
    //   151: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +32 -> 186
    //   157: ldc 96
    //   159: iconst_2
    //   160: new 122	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 877
    //   170: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload 4
    //   175: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_2
    //   185: astore_1
    //   186: aload_1
    //   187: astore_2
    //   188: aload_1
    //   189: ifnonnull +20 -> 209
    //   192: new 58	org/json/JSONObject
    //   195: dup
    //   196: invokespecial 59	org/json/JSONObject:<init>	()V
    //   199: astore_2
    //   200: aload_2
    //   201: ldc_w 313
    //   204: iconst_m1
    //   205: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   208: pop
    //   209: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +13 -> 225
    //   215: ldc 96
    //   217: iconst_2
    //   218: aload_2
    //   219: invokevirtual 306	org/json/JSONObject:toString	()Ljava/lang/String;
    //   222: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_2
    //   226: areturn
    //   227: astore_2
    //   228: aload_3
    //   229: astore_1
    //   230: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq +14 -> 247
    //   236: ldc 96
    //   238: iconst_2
    //   239: aload_2
    //   240: iconst_0
    //   241: anewarray 98	java/lang/Object
    //   244: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   247: goto -61 -> 186
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 381	org/json/JSONException:printStackTrace	()V
    //   255: goto -46 -> 209
    //   258: astore_3
    //   259: aload_2
    //   260: astore_1
    //   261: aload_3
    //   262: astore_2
    //   263: goto -33 -> 230
    //   266: aconst_null
    //   267: astore_1
    //   268: goto -82 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	bahm
    //   0	271	1	paramString	String
    //   57	169	2	localObject1	Object
    //   227	33	2	localJSONException1	JSONException
    //   262	1	2	localJSONException2	JSONException
    //   1	228	3	localObject2	Object
    //   258	4	3	localJSONException3	JSONException
    //   17	157	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	77	227	org/json/JSONException
    //   77	136	227	org/json/JSONException
    //   200	209	250	org/json/JSONException
    //   138	149	258	org/json/JSONException
    //   151	184	258	org/json/JSONException
  }
  
  /* Error */
  public JSONObject a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: invokestatic 339	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   11: invokevirtual 340	java/util/UUID:toString	()Ljava/lang/String;
    //   14: ldc_w 342
    //   17: ldc_w 344
    //   20: invokevirtual 347	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 4
    //   25: new 122	java/lang/StringBuilder
    //   28: dup
    //   29: ldc_w 880
    //   32: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: bipush 63
    //   37: invokevirtual 267	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   40: ldc_w 870
    //   43: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokestatic 434	java/lang/System:currentTimeMillis	()J
    //   49: invokevirtual 873	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   52: ldc_w 357
    //   55: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 4
    //   60: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: astore_2
    //   64: new 122	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 349
    //   74: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 4
    //   79: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: astore 4
    //   84: aload_1
    //   85: aload_0
    //   86: getfield 191	bahm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   89: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   92: aload_2
    //   93: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: ldc 69
    //   98: aload 4
    //   100: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 883	bahp:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 4
    //   108: aload 4
    //   110: ifnull +143 -> 253
    //   113: new 58	org/json/JSONObject
    //   116: dup
    //   117: aload 4
    //   119: invokespecial 77	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   122: astore_2
    //   123: aload_2
    //   124: astore_1
    //   125: aload_2
    //   126: ldc_w 313
    //   129: iconst_m1
    //   130: invokevirtual 83	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   133: ifeq +40 -> 173
    //   136: aload_2
    //   137: astore_1
    //   138: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +32 -> 173
    //   144: ldc 96
    //   146: iconst_2
    //   147: new 122	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 885
    //   157: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 4
    //   162: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload_2
    //   172: astore_1
    //   173: aload_1
    //   174: astore_2
    //   175: aload_1
    //   176: ifnonnull +20 -> 196
    //   179: new 58	org/json/JSONObject
    //   182: dup
    //   183: invokespecial 59	org/json/JSONObject:<init>	()V
    //   186: astore_2
    //   187: aload_2
    //   188: ldc_w 313
    //   191: iconst_m1
    //   192: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   195: pop
    //   196: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +13 -> 212
    //   202: ldc 96
    //   204: iconst_2
    //   205: aload_2
    //   206: invokevirtual 306	org/json/JSONObject:toString	()Ljava/lang/String;
    //   209: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload_2
    //   213: areturn
    //   214: astore_2
    //   215: aload_3
    //   216: astore_1
    //   217: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +14 -> 234
    //   223: ldc 96
    //   225: iconst_2
    //   226: aload_2
    //   227: iconst_0
    //   228: anewarray 98	java/lang/Object
    //   231: invokestatic 102	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   234: goto -61 -> 173
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 381	org/json/JSONException:printStackTrace	()V
    //   242: goto -46 -> 196
    //   245: astore_3
    //   246: aload_2
    //   247: astore_1
    //   248: aload_3
    //   249: astore_2
    //   250: goto -33 -> 217
    //   253: aconst_null
    //   254: astore_1
    //   255: goto -82 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	bahm
    //   0	258	1	paramJSONObject	JSONObject
    //   63	150	2	localObject1	Object
    //   214	33	2	localJSONException1	JSONException
    //   249	1	2	localJSONException2	JSONException
    //   1	215	3	localObject2	Object
    //   245	4	3	localJSONException3	JSONException
    //   23	138	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	108	214	org/json/JSONException
    //   113	123	214	org/json/JSONException
    //   187	196	237	org/json/JSONException
    //   125	136	245	org/json/JSONException
    //   138	171	245	org/json/JSONException
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!bdin.d(BaseApplicationImpl.getContext())) {
      notifyUI(5, false, new Object[] { "", Integer.valueOf(paramInt) });
    }
    do
    {
      return;
      TimDocSSOMsg.GetPadRightInfoReqBody localGetPadRightInfoReqBody = new TimDocSSOMsg.GetPadRightInfoReqBody();
      localGetPadRightInfoReqBody.uint32_appid.set(2);
      localGetPadRightInfoReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
      ReSendCmd localReSendCmd = new ReSendCmd();
      localReSendCmd.jdField_a_of_type_Int = 9;
      localReSendCmd.d = paramInt;
      localReSendCmd.jdField_a_of_type_JavaLangString = paramString;
      Object localObject = a("send GetPadRightInfoReqBody", localReSendCmd);
      if (localObject == null)
      {
        QLog.e("TeamWorkHandler", 1, "---- GetPadRightInfoReqBody -- loginInfo is null ---");
        return;
      }
      localGetPadRightInfoReqBody.msg_login_info.set((MessageMicro)localObject);
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.GetPadRightInfo");
      ((ToServiceMsg)localObject).putWupBuffer(localGetPadRightInfoReqBody.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).addAttribute(jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
      ((ToServiceMsg)localObject).extraData.putParcelable("key_resend_cmd", localReSendCmd);
      super.sendPbReq((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send GetPadRightInfoReqBody,padUrl: " + paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, List<TimDocSSOMsg.UinRightInfo> paramList)
  {
    if (!bdin.d(BaseApplicationImpl.getContext())) {
      notifyUI(6, false, new Object[] { "", Integer.valueOf(paramInt2) });
    }
    do
    {
      return;
      TimDocSSOMsg.SetPadRightInfoReqBody localSetPadRightInfoReqBody = new TimDocSSOMsg.SetPadRightInfoReqBody();
      localSetPadRightInfoReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
      TimDocSSOMsg.LoginInfo localLoginInfo = a("send setPadRightsInfo", null);
      if (localLoginInfo != null) {
        localSetPadRightInfoReqBody.msg_login_info.set(localLoginInfo);
      }
      localSetPadRightInfoReqBody.uint32_appid.set(2);
      localSetPadRightInfoReqBody.uint32_pad_right.set(paramInt1);
      if ((paramList != null) && (paramList.size() > 0)) {
        localSetPadRightInfoReqBody.rpt_msg_uin_right_info.set(paramList);
      }
      paramList = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.SetPadRightInfo");
      paramList.addAttribute(jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt2));
      paramList.putWupBuffer(localSetPadRightInfoReqBody.toByteArray());
      paramList.setTimeout(30000L);
      super.sendPbReq(paramList);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send setPadRightsInfo,padUrl: " + paramString);
  }
  
  public void a(DocsGrayTipsInfo paramDocsGrayTipsInfo, int paramInt, long paramLong)
  {
    boolean bool = false;
    try
    {
      if (!bdin.d(BaseApplicationImpl.getContext()))
      {
        localObject1 = BaseApplicationImpl.getContext();
        if (TextUtils.isEmpty(paramDocsGrayTipsInfo.l)) {}
        for (paramDocsGrayTipsInfo = this.app.getApp().getString(2131694768);; paramDocsGrayTipsInfo = paramDocsGrayTipsInfo.l)
        {
          QQToast.a((Context)localObject1, paramDocsGrayTipsInfo, 0).a();
          return;
        }
      }
      Object localObject1 = new cmd0xbab.UserSetReq();
      ((cmd0xbab.UserSetReq)localObject1).uin.set(Long.parseLong(paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString));
      ((cmd0xbab.UserSetReq)localObject1).doc_url.set(paramDocsGrayTipsInfo.jdField_b_of_type_JavaLangString);
      ((cmd0xbab.UserSetReq)localObject1).policy.set(Integer.valueOf(paramDocsGrayTipsInfo.h).intValue());
      Object localObject2 = ((cmd0xbab.UserSetReq)localObject1).only;
      if (Integer.valueOf(paramDocsGrayTipsInfo.i).intValue() == 1) {
        bool = true;
      }
      ((PBBoolField)localObject2).set(bool);
      ((cmd0xbab.UserSetReq)localObject1).privilege_flag.set(Integer.valueOf(paramDocsGrayTipsInfo.g).intValue());
      ((cmd0xbab.UserSetReq)localObject1).exp_set_time.set(paramInt);
      localObject2 = new cmd0xbab.ReqBody();
      ((cmd0xbab.ReqBody)localObject2).user_set_req.set((MessageMicro)localObject1);
      localObject1 = makeOIDBPkg("OidbSvc.0xbab_2", 2987, 2, ((cmd0xbab.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("data", paramDocsGrayTipsInfo);
      ((ToServiceMsg)localObject1).addAttribute("seq", Long.valueOf(paramLong));
      sendPbReq((ToServiceMsg)localObject1);
      QLog.i("TeamWorkHandler" + bagj.i, 2, "set user auth | uin = " + paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString + " docUrl = " + paramDocsGrayTipsInfo.jdField_b_of_type_JavaLangString + " setploicy = " + paramDocsGrayTipsInfo.h + " setonly= " + paramDocsGrayTipsInfo.i + " setprivilege=" + paramDocsGrayTipsInfo.g + " bNeedtime = " + paramDocsGrayTipsInfo.r + " settime=" + paramInt);
      return;
    }
    catch (Exception paramDocsGrayTipsInfo)
    {
      QLog.e("TeamWorkHandler" + bagj.i, 1, "set user auth exception = " + paramDocsGrayTipsInfo.toString());
    }
  }
  
  public void a(DocsGrayTipsInfo paramDocsGrayTipsInfo, long paramLong)
  {
    try
    {
      if (!bdin.d(BaseApplicationImpl.getContext()))
      {
        localObject = BaseApplicationImpl.getContext();
        if (TextUtils.isEmpty(paramDocsGrayTipsInfo.l)) {}
        for (paramDocsGrayTipsInfo = this.app.getApp().getString(2131694768);; paramDocsGrayTipsInfo = paramDocsGrayTipsInfo.l)
        {
          QQToast.a((Context)localObject, paramDocsGrayTipsInfo, 0).a();
          return;
        }
      }
      Object localObject = new cmd0xbab.UserGetReq();
      ((cmd0xbab.UserGetReq)localObject).uin.set(Long.parseLong(paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString));
      ((cmd0xbab.UserGetReq)localObject).doc_url.set(paramDocsGrayTipsInfo.jdField_b_of_type_JavaLangString);
      cmd0xbab.ReqBody localReqBody = new cmd0xbab.ReqBody();
      localReqBody.user_get_req.set((MessageMicro)localObject);
      localObject = makeOIDBPkg("OidbSvc.0xbab_1", 2987, 1, localReqBody.toByteArray());
      ((ToServiceMsg)localObject).addAttribute("data", paramDocsGrayTipsInfo);
      ((ToServiceMsg)localObject).addAttribute("seq", Long.valueOf(paramLong));
      sendPbReq((ToServiceMsg)localObject);
      QLog.i("TeamWorkHandler" + bagj.i, 2, "get user auth | uin = " + paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString + " docUrl = " + paramDocsGrayTipsInfo.jdField_b_of_type_JavaLangString);
      return;
    }
    catch (Exception paramDocsGrayTipsInfo)
    {
      QLog.e("TeamWorkHandler" + bagj.i, 1, "get user auth exception = " + paramDocsGrayTipsInfo.toString());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int i = ((Integer)paramToServiceMsg.getAttribute(jdField_a_of_type_JavaLangString)).intValue();
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleGetPadRightsInfo ,resultCode: " + paramFromServiceMsg.getResultCode());
    }
    if (!bool) {
      paramToServiceMsg = "";
    }
    label122:
    TimDocSSOMsg.GetPadRightInfoRspBody localGetPadRightInfoRspBody;
    for (;;)
    {
      if (!bool) {
        QLog.i("TeamWorkHandler", 1, " handleGetPadRightsInfo faied code: " + paramFromServiceMsg.getResultCode());
      }
      notifyUI(5, bool, new Object[] { paramToServiceMsg, Integer.valueOf(i) });
      return;
      localGetPadRightInfoRspBody = new TimDocSSOMsg.GetPadRightInfoRspBody();
      try
      {
        localGetPadRightInfoRspBody.mergeFrom((byte[])paramObject);
        int j = localGetPadRightInfoRspBody.uint32_retcode.get();
        if (j == 0) {
          break label277;
        }
        QLog.e("TeamWorkHandler", 1, "error handleGetPadRightsInfo url : " + "" + ",retCode: " + j);
        if ((j == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd")))) {
          break label122;
        }
        paramToServiceMsg = "";
        bool = false;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.i("TeamWorkHandler", 1, " handleGetPadRightsInfo exception: " + paramToServiceMsg.toString());
        paramToServiceMsg = "";
        bool = false;
      }
      continue;
      label277:
      paramToServiceMsg = localGetPadRightInfoRspBody.bytes_pad_url.get().toStringUtf8();
      if (localGetPadRightInfoRspBody.uint32_pad_right.has()) {
        break;
      }
      QLog.e("TeamWorkHandler", 1, "error handleGetPadRightsInfo url : " + paramToServiceMsg + ",has not padrights filed ");
      bool = false;
    }
    i = localGetPadRightInfoRspBody.uint32_pad_right.get();
    paramFromServiceMsg = localGetPadRightInfoRspBody.rpt_msg_uin_right_info.get();
    if (0 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TeamWorkHandler", 2, "pad is not exxisted ,but in other list find : " + false);
      }
      notifyUI(7, true, new Object[] { paramToServiceMsg, Integer.valueOf(i), paramFromServiceMsg });
      return;
    }
    if ((i == 1) || (i == 2)) {
      throw new NullPointerException();
    }
    new ArrayList();
    throw new NullPointerException();
  }
  
  public void b(DocsGrayTipsInfo paramDocsGrayTipsInfo, int paramInt, long paramLong)
  {
    boolean bool = false;
    try
    {
      if (!bdin.d(BaseApplicationImpl.getContext()))
      {
        localObject1 = BaseApplicationImpl.getContext();
        if (TextUtils.isEmpty(paramDocsGrayTipsInfo.l)) {}
        for (paramDocsGrayTipsInfo = this.app.getApp().getString(2131694768);; paramDocsGrayTipsInfo = paramDocsGrayTipsInfo.l)
        {
          QQToast.a((Context)localObject1, paramDocsGrayTipsInfo, 0).a();
          return;
        }
      }
      Object localObject1 = new cmd0xbab.GroupSetReq();
      ((cmd0xbab.GroupSetReq)localObject1).group_code.set(Long.parseLong(paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString));
      ((cmd0xbab.GroupSetReq)localObject1).doc_url.set(paramDocsGrayTipsInfo.jdField_b_of_type_JavaLangString);
      ((cmd0xbab.GroupSetReq)localObject1).policy.set(Integer.valueOf(paramDocsGrayTipsInfo.h).intValue());
      Object localObject2 = ((cmd0xbab.GroupSetReq)localObject1).only;
      if (Integer.valueOf(paramDocsGrayTipsInfo.i).intValue() == 1) {
        bool = true;
      }
      ((PBBoolField)localObject2).set(bool);
      ((cmd0xbab.GroupSetReq)localObject1).privilege_flag.set(Integer.valueOf(paramDocsGrayTipsInfo.g).intValue());
      ((cmd0xbab.GroupSetReq)localObject1).exp_set_time.set(paramInt);
      localObject2 = new cmd0xbab.ReqBody();
      ((cmd0xbab.ReqBody)localObject2).group_set_req.set((MessageMicro)localObject1);
      localObject1 = makeOIDBPkg("OidbSvc.0xbab_4", 2987, 4, ((cmd0xbab.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("data", paramDocsGrayTipsInfo);
      ((ToServiceMsg)localObject1).addAttribute("seq", Long.valueOf(paramLong));
      sendPbReq((ToServiceMsg)localObject1);
      QLog.i("TeamWorkHandler" + bagj.i, 1, "set group auth | uin = " + paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString + " docUrl = " + paramDocsGrayTipsInfo.jdField_b_of_type_JavaLangString + " setploicy = " + paramDocsGrayTipsInfo.h + " setonly= " + paramDocsGrayTipsInfo.i + " setprivilege=" + paramDocsGrayTipsInfo.g + " bNeedtime = " + paramDocsGrayTipsInfo.r + " settime=" + paramInt);
      return;
    }
    catch (Exception paramDocsGrayTipsInfo)
    {
      QLog.e("TeamWorkHandler" + bagj.i, 1, "set group auth exception = " + paramDocsGrayTipsInfo.toString());
    }
  }
  
  public void b(DocsGrayTipsInfo paramDocsGrayTipsInfo, long paramLong)
  {
    try
    {
      if (!bdin.d(BaseApplicationImpl.getContext()))
      {
        localObject = BaseApplicationImpl.getContext();
        if (TextUtils.isEmpty(paramDocsGrayTipsInfo.l)) {}
        for (paramDocsGrayTipsInfo = this.app.getApp().getString(2131694768);; paramDocsGrayTipsInfo = paramDocsGrayTipsInfo.l)
        {
          QQToast.a((Context)localObject, paramDocsGrayTipsInfo, 0).a();
          return;
        }
      }
      Object localObject = new cmd0xbab.GroupGetReq();
      ((cmd0xbab.GroupGetReq)localObject).group_code.set(Long.parseLong(paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString));
      ((cmd0xbab.GroupGetReq)localObject).doc_url.set(paramDocsGrayTipsInfo.jdField_b_of_type_JavaLangString);
      cmd0xbab.ReqBody localReqBody = new cmd0xbab.ReqBody();
      localReqBody.group_get_req.set((MessageMicro)localObject);
      localObject = makeOIDBPkg("OidbSvc.0xbab_3", 2987, 3, localReqBody.toByteArray());
      ((ToServiceMsg)localObject).addAttribute("data", paramDocsGrayTipsInfo);
      ((ToServiceMsg)localObject).addAttribute("seq", Long.valueOf(paramLong));
      sendPbReq((ToServiceMsg)localObject);
      QLog.i("TeamWorkHandler" + bagj.i, 1, "get group auth | uin = " + paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString + " docUrl = " + paramDocsGrayTipsInfo.jdField_b_of_type_JavaLangString + ", msgSeq = " + paramLong);
      return;
    }
    catch (Exception paramDocsGrayTipsInfo)
    {
      QLog.e("TeamWorkHandler" + bagj.i, 1, "get group auth exception = " + paramDocsGrayTipsInfo.toString());
    }
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return baht.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("TimDocSvc.GetPadRightInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("TimDocSvc.SetPadRightInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xbab_1".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xbab_2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xbab_3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xbab_4".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
    f(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahm
 * JD-Core Version:    0.7.0.1
 */