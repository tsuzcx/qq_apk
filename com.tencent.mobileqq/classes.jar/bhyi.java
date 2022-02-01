import VIP.AIOSendRes;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonRecDressup;
import com.tencent.mobileqq.utils.FileUtils;
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

public class bhyi
{
  private static bhyi jdField_a_of_type_Bhyi;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e = "mvip.p.a.aio_tlzkt";
  public static String f = "mvip.p.a.aio_tlzzs";
  static String g = anvx.a(2131699647);
  static String h = anvx.a(2131699645);
  static String i = anvx.a(2131699646);
  static String j = anvx.a(2131699644);
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
  
  public bhyi()
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
  
  public static bhyi a()
  {
    if (jdField_a_of_type_Bhyi == null) {}
    try
    {
      if (jdField_a_of_type_Bhyi == null) {
        jdField_a_of_type_Bhyi = new bhyi();
      }
      return jdField_a_of_type_Bhyi;
    }
    finally {}
  }
  
  private void a(String paramString, JSONObject paramJSONObject)
  {
    int i1;
    if (paramJSONObject.has("grayTail"))
    {
      paramJSONObject = paramJSONObject.getString("grayTail");
      this.jdField_a_of_type_Boolean = false;
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = paramJSONObject.split(";");
        i1 = 0;
      }
    }
    for (;;)
    {
      if (i1 < paramJSONObject.length)
      {
        CharSequence localCharSequence = paramJSONObject[i1];
        if ((!TextUtils.isEmpty(localCharSequence)) && (paramString.endsWith(localCharSequence.trim()))) {
          this.jdField_a_of_type_Boolean = true;
        }
      }
      else
      {
        return;
        paramJSONObject = null;
        break;
      }
      i1 += 1;
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("groupKeywords")) {}
    ArrayList localArrayList;
    for (paramJSONObject = paramJSONObject.optString("groupKeywords");; paramJSONObject = null)
    {
      if (TextUtils.isEmpty(paramJSONObject)) {
        break label148;
      }
      localArrayList = new ArrayList();
      String[] arrayOfString = paramJSONObject.split(";");
      int i1 = 0;
      while (i1 < arrayOfString.length)
      {
        String str = arrayOfString[i1];
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str.trim()))) {
          localArrayList.add(str.trim().toLowerCase());
        }
        i1 += 1;
      }
    }
    label148:
    for (this.jdField_c_of_type_ArrayOfJavaLangString = ((String[])localArrayList.toArray(new String[localArrayList.size()]));; this.jdField_c_of_type_ArrayOfJavaLangString = this.jdField_b_of_type_ArrayOfJavaLangString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 2, "keyword = " + paramJSONObject);
      }
      return;
    }
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
  
  private void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("keyword")) {
      paramJSONObject = paramJSONObject.getString("keyword");
    }
    while (!TextUtils.isEmpty(paramJSONObject))
    {
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.split(";");
      int i1 = 0;
      for (;;)
      {
        if (i1 < paramJSONObject.length)
        {
          CharSequence localCharSequence = paramJSONObject[i1];
          if ((!TextUtils.isEmpty(localCharSequence)) && (!TextUtils.isEmpty(localCharSequence.trim()))) {
            localArrayList.add(localCharSequence.trim().toLowerCase());
          }
          i1 += 1;
          continue;
          paramJSONObject = null;
          break;
        }
      }
      this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
    }
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
        paramContext = FileUtils.readFileContent(localFile);
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
    FileUtils.writeFile(paramContext.getFilesDir() + File.separator + "vipKerwordJson", paramString1);
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
        localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend(), paramSessionInfo.curType);
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
        String str3 = paramSessionInfo.curFriendUin;
        if (a(str3))
        {
          a(paramQQAppInterface, paramSessionInfo.curType, str3, System.currentTimeMillis());
          a(paramQQAppInterface, str3, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, paramSessionInfo.curType, -4021, str1, (String)localObject, str2, paramString);
          if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
            break label260;
          }
        }
        label260:
        for (paramQQAppInterface = "0";; paramQQAppInterface = "1")
        {
          VasWebviewUtil.reportVipKeywords(paramString, paramQQAppInterface, "0", a(paramSessionInfo.curType), str3, "", "", "", "", "");
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
    MessageRecord localMessageRecord = bcsa.a(paramInt2);
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
      paramInt1 = bcpt.jdField_a_of_type_Int;
      bcpt.jdField_a_of_type_Int = paramInt1 + 1;
      localMessageRecord.msgseq = paramInt1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        break label230;
      }
      l1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
      label137:
      localMessageRecord.shmsgseq = l1;
      localMessageRecord.msgUid = auea.b();
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        break label249;
      }
    }
    label224:
    label230:
    label249:
    for (long l1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;; l1 = bcrg.a())
    {
      localMessageRecord.time = l1;
      localMessageRecord.saveExtInfoToExtStr("aio_vip_keyword", paramString6);
      localMessageRecord.saveExtInfoToExtStr("aio_vip_tips_highlight", paramString4);
      localMessageRecord.saveExtInfoToExtStr("aio_vip_tips_open_url", paramString5);
      paramQQAppInterface.getMessageFacade().addMessage(localMessageRecord, paramQQAppInterface.getCurrentAccountUin());
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
    Object localObject = null;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString1);
        if (localJSONObject.has("switch"))
        {
          i1 = localJSONObject.getInt("switch");
          this.jdField_d_of_type_Int = i1;
          if (!localJSONObject.has("openWording")) {
            break label323;
          }
          paramString1 = localJSONObject.getString("openWording");
          this.k = paramString1;
          if (!localJSONObject.has("openHighlightWording")) {
            break label330;
          }
          paramString1 = localJSONObject.getString("openHighlightWording");
          this.m = paramString1;
          if (!localJSONObject.has("giftWording")) {
            break label337;
          }
          paramString1 = localJSONObject.getString("giftWording");
          this.l = paramString1;
          if (!localJSONObject.has("giftHighlightWording")) {
            break label344;
          }
          paramString1 = localJSONObject.getString("giftHighlightWording");
          this.n = paramString1;
          this.o = localJSONObject.optString("groupOpenWording", g);
          this.p = localJSONObject.optString("groupOpenHighlightWording", i);
          this.q = localJSONObject.optString("groupGiftWording", h);
          this.r = localJSONObject.optString("groupGiftHighlightWording", j);
          if (!localJSONObject.has("giftUrl")) {
            break label351;
          }
          paramString1 = localJSONObject.getString("giftUrl");
          this.s = paramString1;
          paramString1 = localObject;
          if (localJSONObject.has("openUrl")) {
            paramString1 = localJSONObject.getString("openUrl");
          }
          this.t = paramString1;
          a(paramString2, localJSONObject);
          b(localJSONObject);
          a(localJSONObject);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.d("AioVipKeywordHelper", 1, "parseKeyword : json error " + paramString1);
        return;
      }
      int i1 = 0;
      continue;
      label323:
      paramString1 = g;
      continue;
      label330:
      paramString1 = i;
      continue;
      label337:
      paramString1 = h;
      continue;
      label344:
      paramString1 = j;
      continue;
      label351:
      paramString1 = null;
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
        break label265;
      }
    }
    ArrayList localArrayList;
    int i2;
    int i1;
    label265:
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity.jdField_a_of_type_Boolean = bool1;
      localObject1 = paramAppRuntime.optJSONObject("aioVIPGrayTips");
      if (localObject1 == null) {
        break label383;
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
        break label295;
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
    label295:
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
    label383:
    localObject1 = paramAppRuntime.optJSONObject("recommendConfig");
    if (localObject1 != null) {
      EmoticonRecDressup.setRecommendClearTime(((JSONObject)localObject1).optLong("interval", 86400L));
    }
    localObject1 = paramAppRuntime.optJSONObject("lottieConfig");
    if (localObject1 != null) {
      if (((JSONObject)localObject1).optInt("switch") != 1) {
        break label767;
      }
    }
    label767:
    for (bool1 = true;; bool1 = false)
    {
      aumm.jdField_a_of_type_Boolean = bool1;
      QLog.i("AioVipKeywordHelper", 1, "lottieConfig.switch is " + bool1);
      localObject1 = paramAppRuntime.optJSONObject("ipProductGrayTips");
      if (localObject1 != null)
      {
        awyq.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("leftText", awyq.jdField_a_of_type_JavaLangString);
        awyq.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("linkText", awyq.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 2, "ipProductGrayTips: " + ((JSONObject)localObject1).toString());
        }
      }
      localObject1 = paramAppRuntime.optJSONObject("getStrangerInterval");
      if (localObject1 != null)
      {
        bhcs.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("interval", 5000);
        QLog.d("AioVipKeywordHelper", 1, "getStrangerInterval is " + bhcs.jdField_a_of_type_Int);
      }
      localObject1 = paramAppRuntime.optJSONObject("downloadTimeoutConfig");
      if (localObject1 != null)
      {
        asih.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("emotion", asih.jdField_b_of_type_Int);
        bool1 = bool2;
        if (((JSONObject)localObject1).optInt("emoTryReadNoLen", 0) == 1) {
          bool1 = true;
        }
        asih.jdField_b_of_type_Boolean = bool1;
        QLog.d("AioVipKeywordHelper", 1, "downloadTimeoutConfig is " + ((JSONObject)localObject1).toString());
      }
      localObject1 = paramAppRuntime.optJSONObject("tmsDualCoreConfig");
      if (localObject1 != null) {
        QLog.d("KC.TMSManager", 1, "tms DPC : " + ((JSONObject)localObject1).toString());
      }
      localObject1 = paramAppRuntime.optJSONArray("shareDomainConfig");
      if (localObject1 != null) {
        bhpz.a().a((JSONArray)localObject1);
      }
      asjs.a(paramAppRuntime.optJSONArray("h5MagicTips"));
      return;
    }
  }
  
  public boolean a(SessionInfo paramSessionInfo)
  {
    switch (paramSessionInfo.curType)
    {
    default: 
      return false;
    case 0: 
      return this.jdField_a_of_type_Boolean;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramSessionInfo.curFriendUin)) {
        return ((Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramSessionInfo.curFriendUin)).booleanValue();
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (paramSessionInfo.curFriendUin.endsWith(str))
          {
            this.jdField_a_of_type_JavaUtilMap.put(paramSessionInfo.curFriendUin, Boolean.valueOf(true));
            return true;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramSessionInfo.curFriendUin, Boolean.valueOf(false));
    }
    if (QLog.isColorLevel()) {
      QLog.d("AioVipKeywordHelper", 4, "current uin is not gray number.");
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (TextUtils.isEmpty(paramSessionInfo.curFriendUin)) {
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 2, "sessionInfo.curFriendUin=" + paramSessionInfo.curFriendUin + ", need not detect keyword.");
      }
    }
    long l1;
    label173:
    do
    {
      do
      {
        return false;
      } while ((bdfk.b()) || (this.jdField_d_of_type_Int == 0));
      l1 = 86400L;
      int i1;
      switch (paramSessionInfo.curType)
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
      long l2 = paramQQAppInterface.getApplication().getSharedPreferences("AioVipKeywordGrayTips_" + paramQQAppInterface.getCurrentAccountUin(), 0).getLong("lastShowGrayTipsTime_" + paramSessionInfo.curType + "_" + paramSessionInfo.curFriendUin, 0L);
      if (System.currentTimeMillis() - l2 >= 1000L * l1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AioVipKeywordHelper", 4, "VIP Keyword Function frequency = " + l1 + "s, so need not detect keyword.");
    return false;
    return a(paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhyi
 * JD-Core Version:    0.7.0.1
 */