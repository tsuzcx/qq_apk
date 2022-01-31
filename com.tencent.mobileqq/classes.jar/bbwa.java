import VIP.AIOSendRes;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.AioVipKeywordHelper.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class bbwa
{
  private static bbwa jdField_a_of_type_Bbwa;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e = "mvip.p.a.aio_tlzkt";
  public static String f = "mvip.p.a.aio_tlzzs";
  static String g = ajyc.a(2131700136);
  static String h = ajyc.a(2131700134);
  static String i = ajyc.a(2131700135);
  static String j = ajyc.a(2131700133);
  public int a;
  public long a;
  public SessionInfo a;
  public MessageRecord a;
  public List<String> a;
  public Map<String, Boolean> a;
  private boolean jdField_a_of_type_Boolean;
  public String[] a;
  public int b;
  public long b;
  private String[] b;
  public int c;
  public long c;
  private String[] c;
  private int d;
  public long d;
  public String k = g;
  public String l = h;
  public String m = i;
  public String n = j;
  public String o = g;
  public String p = i;
  public String q = h;
  public String r = j;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  
  static
  {
    jdField_a_of_type_JavaLangString = "mvip.pt.android.aiocuifei_recikai";
    jdField_b_of_type_JavaLangString = "mvip.pt.android.aiocuifei_recizeng";
    jdField_c_of_type_JavaLangString = "mvip.p.a.aio_qunkt";
    jdField_d_of_type_JavaLangString = "mvip.p.a.aio_qunzs";
  }
  
  public bbwa()
  {
    this.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Long = 86400L;
    this.jdField_b_of_type_Long = 86400L;
    this.jdField_c_of_type_Long = 86400L;
    this.jdField_d_of_type_Long = 2000L;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static bbwa a()
  {
    if (jdField_a_of_type_Bbwa == null) {}
    try
    {
      if (jdField_a_of_type_Bbwa == null) {
        jdField_a_of_type_Bbwa = new bbwa();
      }
      return jdField_a_of_type_Bbwa;
    }
    finally {}
  }
  
  private static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() > 2);
  }
  
  private String[] a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramBoolean) {
      if ((this.jdField_b_of_type_ArrayOfJavaLangString != null) && (this.jdField_b_of_type_ArrayOfJavaLangString.length >= 1)) {}
    }
    for (i1 = 1;; i1 = 1) {
      do
      {
        if (i1 != 0) {
          a(paramContext, paramString);
        }
        if (!paramBoolean) {
          break;
        }
        return this.jdField_b_of_type_ArrayOfJavaLangString;
      } while ((this.jdField_c_of_type_ArrayOfJavaLangString != null) && (this.jdField_c_of_type_ArrayOfJavaLangString.length >= 1));
    }
    return this.jdField_c_of_type_ArrayOfJavaLangString;
  }
  
  public Pair<String, String> a(boolean paramBoolean, int paramInt)
  {
    String str2 = "";
    String str1 = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      return new Pair(str2, str1);
      if (paramBoolean) {}
      for (str2 = this.k;; str2 = this.l)
      {
        if (!paramBoolean) {
          break label86;
        }
        str1 = this.m;
        break;
      }
      label86:
      str1 = this.n;
      continue;
      if (paramBoolean) {}
      for (str2 = this.o;; str2 = this.q)
      {
        if (!paramBoolean) {
          break label125;
        }
        str1 = this.p;
        break;
      }
      label125:
      str1 = this.r;
    }
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "0";
    case 1: 
      return "1";
    }
    return "2";
  }
  
  public String a(boolean paramBoolean, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      if (paramBoolean) {
        return jdField_a_of_type_JavaLangString;
      }
      return jdField_b_of_type_JavaLangString;
    case 1: 
      if (paramBoolean) {
        return jdField_c_of_type_JavaLangString;
      }
      return jdField_d_of_type_JavaLangString;
    }
    if (paramBoolean) {
      return e;
    }
    return f;
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return;
      Object localObject = null;
      File localFile = new File(paramContext.getFilesDir(), "vipKerwordJson");
      paramContext = localObject;
      if (localFile.exists()) {
        paramContext = bbdj.a(localFile);
      }
    } while (TextUtils.isEmpty(paramContext));
    a(paramContext, paramString);
    a(BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AioVipKeywordHelper", 2, "updateKeywordJson");
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    a(paramString1, paramString2);
    bbdj.a(paramContext.getFilesDir() + File.separator + "vipKerwordJson", paramString1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, long paramLong)
  {
    paramQQAppInterface.getApplication().getSharedPreferences("AioVipKeywordGrayTips_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putLong("lastShowGrayTipsTime_" + paramInt + "_" + paramString, paramLong).commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface, AIOSendRes paramAIOSendRes)
  {
    if (paramAIOSendRes != null)
    {
      this.u = paramAIOSendRes.sGrayStipMsg;
      if (paramAIOSendRes.mHighLightMap != null)
      {
        Iterator localIterator = paramAIOSendRes.mHighLightMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          this.v = ((String)localIterator.next());
          this.w = ((String)paramAIOSendRes.mHighLightMap.get(this.v));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 4, "fetched tips from server: tips=" + this.u + ", highlight=" + this.v + ", openUrl=" + this.w);
      }
      if ((this.x != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.x, true);
        this.x = null;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, String paramString, Context paramContext, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramChatMessage == null) || (TextUtils.isEmpty(paramString))) {
      QLog.e("AioVipKeywordHelper", 1, "detectKeyword : params error");
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AioVipKeywordHelper", 4, "keyword has been detected, message is ignored.");
      return;
    } while (!a(paramQQAppInterface, paramSessionInfo));
    ThreadManager.executeOnSubThread(new AioVipKeywordHelper.1(this, paramQQAppInterface, paramSessionInfo, paramContext, paramString, paramChatMessage, paramBoolean), true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject;
      String str1;
      label58:
      String str2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend(), paramSessionInfo.jdField_a_of_type_Int);
        if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
          break label231;
        }
        if (!paramBoolean) {
          break label196;
        }
        str1 = this.u;
        if (!paramBoolean) {
          break label209;
        }
        localObject = this.v;
        if (!paramBoolean) {
          break label222;
        }
        str2 = this.w;
        break label271;
      }
      for (;;)
      {
        label72:
        String str3 = paramSessionInfo.jdField_a_of_type_JavaLangString;
        if (a(str3))
        {
          a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, str3, System.currentTimeMillis());
          a(paramQQAppInterface, str3, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, paramSessionInfo.jdField_a_of_type_Int, -4021, str1, (String)localObject, str2, paramString);
          if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
            break label260;
          }
        }
        label260:
        for (paramQQAppInterface = "0";; paramQQAppInterface = "1")
        {
          VasWebviewUtil.reportVipKeywords(paramString, paramQQAppInterface, "0", a(paramSessionInfo.jdField_a_of_type_Int), str3, "", "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
          if (paramBoolean)
          {
            this.w = null;
            this.v = null;
            this.u = null;
          }
          return;
          label196:
          str1 = (String)((Pair)localObject).first;
          break;
          label209:
          localObject = (String)((Pair)localObject).second;
          break label58;
          label222:
          str2 = this.t;
          break label271;
          label231:
          str1 = (String)((Pair)localObject).first;
          localObject = (String)((Pair)localObject).second;
          str2 = this.s;
          break label72;
        }
      }
    }
    finally {}
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    MessageRecord localMessageRecord = axaq.a(paramInt2);
    localMessageRecord.selfuin = paramQQAppInterface.getCurrentAccountUin();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "";
    }
    localMessageRecord.frienduin = str;
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1 = "";
      localMessageRecord.senderuin = paramString1;
      localMessageRecord.msg = paramString3;
      localMessageRecord.msgtype = paramInt2;
      localMessageRecord.isread = true;
      if (!paramString2.equals(paramQQAppInterface.getAccount())) {
        break label224;
      }
      paramInt2 = 1;
      label87:
      localMessageRecord.issend = paramInt2;
      localMessageRecord.istroop = paramInt1;
      paramInt1 = awyl.jdField_a_of_type_Int;
      awyl.jdField_a_of_type_Int = paramInt1 + 1;
      localMessageRecord.msgseq = paramInt1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        break label230;
      }
      l1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
      label137:
      localMessageRecord.shmsgseq = l1;
      localMessageRecord.msgUid = apue.b();
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        break label249;
      }
    }
    label224:
    label230:
    label249:
    for (long l1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;; l1 = awzw.a())
    {
      localMessageRecord.time = l1;
      localMessageRecord.saveExtInfoToExtStr("aio_vip_keyword", paramString6);
      localMessageRecord.saveExtInfoToExtStr("aio_vip_tips_highlight", paramString4);
      localMessageRecord.saveExtInfoToExtStr("aio_vip_tips_open_url", paramString5);
      paramQQAppInterface.a().a(localMessageRecord, paramQQAppInterface.getCurrentAccountUin());
      return;
      paramString1 = paramString2;
      break;
      paramInt2 = 0;
      break label87;
      l1 = Math.abs(new Random().nextInt());
      break label137;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    String[] arrayOfString = null;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString1);
        if (!((JSONObject)localObject).has("switch")) {
          break label676;
        }
        i1 = ((JSONObject)localObject).getInt("switch");
        this.jdField_d_of_type_Int = i1;
        if (((JSONObject)localObject).has("openWording"))
        {
          paramString1 = ((JSONObject)localObject).getString("openWording");
          this.k = paramString1;
          if (((JSONObject)localObject).has("openHighlightWording"))
          {
            paramString1 = ((JSONObject)localObject).getString("openHighlightWording");
            this.m = paramString1;
            if (!((JSONObject)localObject).has("giftWording")) {
              continue;
            }
            paramString1 = ((JSONObject)localObject).getString("giftWording");
            this.l = paramString1;
            if (!((JSONObject)localObject).has("giftHighlightWording")) {
              continue;
            }
            paramString1 = ((JSONObject)localObject).getString("giftHighlightWording");
            this.n = paramString1;
            this.o = ((JSONObject)localObject).optString("groupOpenWording", g);
            this.p = ((JSONObject)localObject).optString("groupOpenHighlightWording", i);
            this.q = ((JSONObject)localObject).optString("groupGiftWording", h);
            this.r = ((JSONObject)localObject).optString("groupGiftHighlightWording", j);
            if (!((JSONObject)localObject).has("giftUrl")) {
              break label681;
            }
            paramString1 = ((JSONObject)localObject).getString("giftUrl");
            this.s = paramString1;
            if (!((JSONObject)localObject).has("openUrl")) {
              break label686;
            }
            paramString1 = ((JSONObject)localObject).getString("openUrl");
            this.t = paramString1;
            if (!((JSONObject)localObject).has("grayTail")) {
              break label691;
            }
            paramString1 = ((JSONObject)localObject).getString("grayTail");
            this.jdField_a_of_type_Boolean = false;
            if (!TextUtils.isEmpty(paramString1))
            {
              paramString1 = paramString1.split(";");
              i1 = 0;
              if (i1 < paramString1.length)
              {
                localCharSequence = paramString1[i1];
                if ((TextUtils.isEmpty(localCharSequence)) || (!paramString2.endsWith(localCharSequence.trim()))) {
                  break label696;
                }
                this.jdField_a_of_type_Boolean = true;
              }
            }
            if (!((JSONObject)localObject).has("keyword")) {
              break label703;
            }
            paramString1 = ((JSONObject)localObject).getString("keyword");
            if (TextUtils.isEmpty(paramString1)) {
              continue;
            }
            paramString2 = new ArrayList();
            paramString1 = paramString1.split(";");
            i1 = 0;
            if (i1 >= paramString1.length) {
              continue;
            }
            CharSequence localCharSequence = paramString1[i1];
            if ((TextUtils.isEmpty(localCharSequence)) || (TextUtils.isEmpty(localCharSequence.trim()))) {
              break label669;
            }
            paramString2.add(localCharSequence.trim().toLowerCase());
            break label669;
          }
        }
        else
        {
          paramString1 = g;
          continue;
        }
        paramString1 = i;
        continue;
        paramString1 = h;
        continue;
        paramString1 = j;
        continue;
        this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])paramString2.toArray(new String[paramString2.size()]));
        paramString1 = arrayOfString;
        if (((JSONObject)localObject).has("groupKeywords")) {
          paramString1 = ((JSONObject)localObject).optString("groupKeywords");
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString2 = new ArrayList();
          arrayOfString = paramString1.split(";");
          i1 = 0;
          if (i1 < arrayOfString.length)
          {
            localObject = arrayOfString[i1];
            if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(((String)localObject).trim()))) {
              break label708;
            }
            paramString2.add(((String)localObject).trim().toLowerCase());
            break label708;
          }
          this.jdField_c_of_type_ArrayOfJavaLangString = ((String[])paramString2.toArray(new String[paramString2.size()]));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AioVipKeywordHelper", 2, "keyword = " + paramString1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.d("AioVipKeywordHelper", 1, "parseKeyword : json error " + paramString1);
        return;
      }
      this.jdField_c_of_type_ArrayOfJavaLangString = this.jdField_b_of_type_ArrayOfJavaLangString;
      continue;
      label669:
      i1 += 1;
      continue;
      label676:
      int i1 = 0;
      continue;
      label681:
      paramString1 = null;
      continue;
      label686:
      paramString1 = null;
      continue;
      label691:
      paramString1 = null;
      continue;
      label696:
      i1 += 1;
      continue;
      label703:
      paramString1 = null;
      continue;
      label708:
      i1 += 1;
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    boolean bool2 = false;
    paramAppRuntime = VasQuickUpdateManager.getJSONFromLocal(paramAppRuntime, "vip_personal_card.json", true, null);
    if (paramAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 2, "parsejson file not exists");
      }
      return;
    }
    Object localObject1 = paramAppRuntime.optJSONObject("isChooseStyleClosed");
    if (localObject1 != null) {
      if (((JSONObject)localObject1).optInt("isChooseStyleClosed", 0) != 1) {
        break label266;
      }
    }
    ArrayList localArrayList;
    int i2;
    int i1;
    label266:
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity.jdField_a_of_type_Boolean = bool1;
      localObject1 = paramAppRuntime.optJSONObject("aioVIPGrayTips");
      if (localObject1 == null) {
        break label385;
      }
      this.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("c2cEnable", 1);
      this.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("groupEnable", 1);
      this.jdField_c_of_type_Int = ((JSONObject)localObject1).optInt("discussGroupEnable", 1);
      this.jdField_a_of_type_Long = ((JSONObject)localObject1).optLong("c2cFreq", 86400L);
      this.jdField_b_of_type_Long = ((JSONObject)localObject1).optLong("groupFreq", 86400L);
      this.jdField_c_of_type_Long = ((JSONObject)localObject1).optLong("discussGroupFreq", 86400L);
      this.jdField_d_of_type_Long = ((JSONObject)localObject1).optLong("fetchWordingTolerateTime", 2000L);
      Object localObject2 = ((JSONObject)localObject1).optString("dirtyWords");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label296;
      }
      localArrayList = new ArrayList();
      localObject2 = ((String)localObject2).split(";");
      i2 = localObject2.length;
      i1 = 0;
      while (i1 < i2)
      {
        CharSequence localCharSequence = localObject2[i1];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localArrayList.add(localCharSequence.trim().toLowerCase());
        }
        i1 += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
    label296:
    localObject1 = ((JSONObject)localObject1).optString("groupGrayTail");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = ((String)localObject1).split(";");
      i2 = localObject1.length;
      i1 = 0;
      while (i1 < i2)
      {
        localArrayList = localObject1[i1];
        if (!TextUtils.isEmpty(localArrayList)) {
          this.jdField_a_of_type_JavaUtilList.add(localArrayList.trim().toLowerCase());
        }
        i1 += 1;
      }
    }
    label385:
    localObject1 = paramAppRuntime.optJSONObject("recommendConfig");
    if (localObject1 != null) {
      anzi.a(((JSONObject)localObject1).optLong("interval", 86400L));
    }
    localObject1 = paramAppRuntime.optJSONObject("lottieConfig");
    if (localObject1 != null) {
      if (((JSONObject)localObject1).optInt("switch") != 1) {
        break label769;
      }
    }
    label769:
    for (bool1 = true;; bool1 = false)
    {
      apzf.jdField_a_of_type_Boolean = bool1;
      QLog.i("AioVipKeywordHelper", 1, "lottieConfig.switch is " + bool1);
      localObject1 = paramAppRuntime.optJSONObject("ipProductGrayTips");
      if (localObject1 != null)
      {
        askc.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("leftText", askc.jdField_a_of_type_JavaLangString);
        askc.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("linkText", askc.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 2, "ipProductGrayTips: " + ((JSONObject)localObject1).toString());
        }
      }
      localObject1 = paramAppRuntime.optJSONObject("getStrangerInterval");
      if (localObject1 != null)
      {
        bbby.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("interval", 5000);
        QLog.d("AioVipKeywordHelper", 1, "getStrangerInterval is " + bbby.jdField_a_of_type_Int);
      }
      localObject1 = paramAppRuntime.optJSONObject("downloadTimeoutConfig");
      if (localObject1 != null)
      {
        anvs.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("emotion", anvs.jdField_b_of_type_Int);
        bool1 = bool2;
        if (((JSONObject)localObject1).optInt("emoTryReadNoLen", 0) == 1) {
          bool1 = true;
        }
        anvs.jdField_b_of_type_Boolean = bool1;
        QLog.d("AioVipKeywordHelper", 1, "downloadTimeoutConfig is " + ((JSONObject)localObject1).toString());
      }
      localObject1 = paramAppRuntime.optJSONObject("tmsDualCoreConfig");
      if (localObject1 != null) {
        QLog.d("KC.TMSManager", 1, "tms DPC : " + ((JSONObject)localObject1).toString());
      }
      localObject1 = paramAppRuntime.optJSONArray("shareDomainConfig");
      if (localObject1 != null) {
        bbrw.a().a((JSONArray)localObject1);
      }
      anxb.a(paramAppRuntime.optJSONArray("h5MagicTips"));
      return;
    }
  }
  
  public boolean a(SessionInfo paramSessionInfo)
  {
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      return false;
    case 0: 
      return this.jdField_a_of_type_Boolean;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
        return ((Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramSessionInfo.jdField_a_of_type_JavaLangString)).booleanValue();
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (paramSessionInfo.jdField_a_of_type_JavaLangString.endsWith(str))
          {
            this.jdField_a_of_type_JavaUtilMap.put(paramSessionInfo.jdField_a_of_type_JavaLangString, Boolean.valueOf(true));
            return true;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramSessionInfo.jdField_a_of_type_JavaLangString, Boolean.valueOf(false));
    }
    if (QLog.isColorLevel()) {
      QLog.d("AioVipKeywordHelper", 4, "current uin is not gray number.");
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 2, "sessionInfo.curFriendUin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + ", need not detect keyword.");
      }
    }
    long l1;
    label173:
    do
    {
      do
      {
        return false;
      } while ((axmt.b()) || (this.jdField_d_of_type_Int == 0));
      l1 = 86400L;
      int i1;
      switch (paramSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        i1 = 0;
      }
      for (;;)
      {
        if (i1 != 0) {
          break label173;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AioVipKeywordHelper", 4, "VIP Keyword Function is closed.");
        return false;
        i1 = this.jdField_a_of_type_Int;
        l1 = this.jdField_a_of_type_Long;
        continue;
        i1 = this.jdField_b_of_type_Int;
        l1 = this.jdField_b_of_type_Long;
        continue;
        i1 = this.jdField_c_of_type_Int;
        l1 = this.jdField_c_of_type_Long;
      }
      long l2 = paramQQAppInterface.getApplication().getSharedPreferences("AioVipKeywordGrayTips_" + paramQQAppInterface.getCurrentAccountUin(), 0).getLong("lastShowGrayTipsTime_" + paramSessionInfo.jdField_a_of_type_Int + "_" + paramSessionInfo.jdField_a_of_type_JavaLangString, 0L);
      if (System.currentTimeMillis() - l2 >= 1000L * l1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AioVipKeywordHelper", 4, "VIP Keyword Function frequency = " + l1 + "s, so need not detect keyword.");
    return false;
    return a(paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbwa
 * JD-Core Version:    0.7.0.1
 */