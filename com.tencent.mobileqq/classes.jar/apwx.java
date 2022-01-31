import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.3;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.4;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.5;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.RspBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SchoolInfo;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SearchKeyWord;

public class apwx
  implements apxi, Manager
{
  public static apys a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a;
  private int jdField_a_of_type_Int;
  private allb jdField_a_of_type_Allb = new apwy(this);
  private LruCache<String, ExtendFriendUserInfo> jdField_a_of_type_AndroidUtilLruCache = new LruCache(50);
  private apxa jdField_a_of_type_Apxa;
  private apxc jdField_a_of_type_Apxc = new apwz(this);
  private apxd jdField_a_of_type_Apxd;
  private aqao jdField_a_of_type_Aqao;
  private awbw jdField_a_of_type_Awbw;
  private awnc jdField_a_of_type_Awnc;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private oidb_0xdb1.SchoolInfo jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private aqao jdField_b_of_type_Aqao;
  public String b;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean;
  private String e;
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131704650);
  }
  
  public apwx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Allb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Apxc);
    this.jdField_a_of_type_Apxd = new apxd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Apxd.a(this);
    this.jdField_a_of_type_Aqao = new aqao(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
    this.jdField_b_of_type_Aqao = new aqao(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.jdField_a_of_type_Awbw = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    ThreadManager.postImmediately(new ExtendFriendManager.3(this), null, true);
  }
  
  private apxa a(String paramString)
  {
    int j = 0;
    apxa localapxa = new apxa();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        localapxa.jdField_a_of_type_JavaLangString = paramString.optString("contactEntranceTitle");
        localapxa.jdField_b_of_type_JavaLangString = paramString.optString("contactEntranceLine1");
        localapxa.jdField_c_of_type_JavaLangString = paramString.optString("contactEntranceLine2");
        localapxa.jdField_d_of_type_JavaLangString = paramString.optString("addEntranceTitle");
        localapxa.jdField_e_of_type_JavaLangString = paramString.optString("addEntranceLine1");
        localapxa.jdField_a_of_type_Int = paramString.optInt("maxPlayers");
        localapxa.jdField_b_of_type_Int = paramString.optInt("minPlayers");
        localapxa.jdField_c_of_type_Int = paramString.optInt("voiceMaxLength");
        localapxa.jdField_d_of_type_Int = paramString.optInt("maxSlipTimes");
        localapxa.jdField_e_of_type_Int = paramString.optInt("redisplayInterval");
        localapxa.jdField_f_of_type_JavaLangString = paramString.optString("defaultDecleration");
        localapxa.jdField_f_of_type_Int = paramString.optInt("declerationMinLen");
        localapxa.jdField_g_of_type_Int = paramString.optInt("isExpandEntranceOnTop");
        localapxa.jdField_g_of_type_JavaLangString = paramString.optString("resourceURL");
        localapxa.jdField_h_of_type_JavaLangString = paramString.optString("resourceMD5");
        localapxa.jdField_h_of_type_Int = paramString.optInt("isShowGroup");
        localapxa.jdField_j_of_type_JavaLangString = paramString.optString("ExpandExamImg");
        localapxa.jdField_l_of_type_Int = paramString.optInt("exposureTimeLimit", 2);
        localapxa.jdField_a_of_type_Boolean = paramString.optBoolean("showVipIcon", false);
        localapxa.jdField_m_of_type_Int = paramString.optInt("GrayTipsMsgCount", 50);
        localapxa.jdField_k_of_type_JavaLangString = paramString.optString("GrayTipsMsg");
        localapxa.jdField_l_of_type_JavaLangString = paramString.optString("GrayTipsMsgLight");
        localapxa.n = paramString.optInt("IceBreakSwitch", 1);
        localapxa.jdField_m_of_type_JavaLangString = paramString.optString("BeatWarning");
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendManager", 2, "parseConfig config.exposureTimeLimit:" + localapxa.jdField_l_of_type_Int);
        }
        localapxa.jdField_a_of_type_JavaUtilList.clear();
        JSONArray localJSONArray = paramString.optJSONArray("defaultTags");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            localapxa.jdField_a_of_type_JavaUtilList.add(localJSONArray.optString(i));
            i += 1;
            continue;
          }
        }
        localapxa.jdField_b_of_type_JavaUtilList.clear();
        localJSONArray = paramString.optJSONArray("searchTags");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            localapxa.jdField_b_of_type_JavaUtilList.add(localJSONArray.optString(i));
            i += 1;
            continue;
          }
        }
        localapxa.jdField_i_of_type_JavaLangString = paramString.optString("searchHint");
        localJSONArray = paramString.optJSONArray("ExpandMatchRes");
        if (localJSONArray != null)
        {
          i = j;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject == null) {
              break label695;
            }
            apxb localapxb = new apxb(this);
            localapxb.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
            if ("aioVideo".equals(localapxb.jdField_a_of_type_JavaLangString))
            {
              localapxb.jdField_b_of_type_JavaLangString = localJSONObject.optString("resourceURLAndroid");
              localapxb.jdField_c_of_type_JavaLangString = localJSONObject.optString("resourceMD5Android");
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendManager", 2, String.format("aiovideo use android url:%s", new Object[] { localapxb.jdField_b_of_type_JavaLangString }));
              }
              if (!localapxb.a()) {
                break label695;
              }
              localapxa.jdField_a_of_type_JavaUtilHashMap.put(localapxb.jdField_a_of_type_JavaLangString, localapxb);
              break label695;
            }
            localapxb.jdField_b_of_type_JavaLangString = localJSONObject.optString("resourceURL");
            localapxb.jdField_c_of_type_JavaLangString = localJSONObject.optString("resourceMD5");
            continue;
          }
        }
        localapxa.jdField_i_of_type_Int = paramString.optInt("ExpandMatchSwitch");
      }
      catch (JSONException paramString)
      {
        QLog.e("ExtendFriendManager", 2, "parseConfig fail.", paramString);
        return null;
      }
      localapxa.jdField_j_of_type_Int = paramString.optInt("isNuanSSFirst");
      localapxa.jdField_k_of_type_Int = paramString.optInt("isVoiceMatchOpen");
      return localapxa;
      label695:
      i += 1;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("setAnswerQuestionFlag, uin: %s, flag: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    bdiv.g(paramString).edit().putBoolean("sp_extend_friend_question", paramBoolean).apply();
  }
  
  private void a(oidb_0xdb1.SchoolInfo paramSchoolInfo)
  {
    int j = 0;
    if (paramSchoolInfo != null)
    {
      this.jdField_a_of_type_Awnc = new awnc();
      Object localObject = this.jdField_a_of_type_Awnc;
      int i;
      if (paramSchoolInfo.uint32_idx.has())
      {
        i = paramSchoolInfo.uint32_idx.get();
        ((awnc)localObject).jdField_a_of_type_Int = i;
        localObject = this.jdField_a_of_type_Awnc;
        i = j;
        if (paramSchoolInfo.uint32_category.has()) {
          i = paramSchoolInfo.uint32_category.get();
        }
        ((awnc)localObject).jdField_b_of_type_Int = i;
        awnc localawnc = this.jdField_a_of_type_Awnc;
        if (!paramSchoolInfo.str_school_id.has()) {
          break label147;
        }
        localObject = paramSchoolInfo.str_school_id.get();
        label104:
        localawnc.jdField_a_of_type_JavaLangString = ((String)localObject);
        localObject = this.jdField_a_of_type_Awnc;
        if (!paramSchoolInfo.str_school_name.has()) {
          break label154;
        }
      }
      label147:
      label154:
      for (paramSchoolInfo = paramSchoolInfo.str_school_name.get();; paramSchoolInfo = "")
      {
        ((awnc)localObject).jdField_b_of_type_JavaLangString = paramSchoolInfo;
        return;
        i = 0;
        break;
        localObject = "";
        break label104;
      }
    }
    this.jdField_a_of_type_Awnc = null;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = bdiv.g(paramString).getBoolean("sp_extend_friend_question", true);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "needAnswerQuestion: " + bool);
    }
    return bool;
  }
  
  private void c(boolean paramBoolean)
  {
    ((apwv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).notifyUI(5, true, Boolean.valueOf(paramBoolean));
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig=%s mDownloader=%s", new Object[] { this.jdField_a_of_type_Apxa, this.jdField_a_of_type_Apxd }));
    }
    if ((this.jdField_a_of_type_Apxa != null) && (this.jdField_a_of_type_Apxd != null)) {}
    try
    {
      this.jdField_a_of_type_Apxd.a(this.jdField_a_of_type_Apxa.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Apxa.jdField_h_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Apxd.a())
      {
        this.jdField_a_of_type_Apxd.a();
        b(false);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mResourceReady=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
        }
        return;
        b(true);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ExtendFriendManager", 1, "checkToDownloadResource fail.", localException);
      }
    }
  }
  
  private void e()
  {
    String str = aqcy.a("expand_question_dialog.png");
    File localFile = new File(str);
    boolean bool = localFile.exists();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("downloadQuestionRes, filePath:%s, isExist:%s", new Object[] { str, Boolean.valueOf(bool) }));
    }
    if (bool) {}
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Apxa == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Apxa.jdField_j_of_type_JavaLangString))) {
        break label152;
      }
      i = bdvx.a(new bdvv(this.jdField_a_of_type_Apxa.jdField_j_of_type_JavaLangString, localFile), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendManager", 2, "downloadQuestionRes success!");
    return;
    QLog.e("ExtendFriendManager", 1, String.format("downloadQuestionRes fail, ret = %s", new Object[] { Integer.valueOf(i) }));
    return;
    label152:
    QLog.e("ExtendFriendManager", 1, "downloadQuestionRes, config or url is empty!");
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (;;)
    {
      try
      {
        Card localCard = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        if (localCard != null)
        {
          if (TextUtils.isEmpty(localCard.declaration)) {
            continue;
          }
          bool1 = true;
          boolean bool2 = localCard.isShowCard;
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData profileComplete=%s showCard=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
          }
          if (jdField_a_of_type_Apys != null)
          {
            jdField_a_of_type_Apys.jdField_a_of_type_Boolean = bool1;
            jdField_a_of_type_Apys.jdField_b_of_type_Boolean = bool2;
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool1;
        QLog.e("ExtendFriendManager", 1, "updateSwitchInCacheData fail.", localException);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData %s", new Object[] { jdField_a_of_type_Apys }));
      }
      return;
      bool1 = false;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if ((this.jdField_a_of_type_Apxa == null) || (this.jdField_a_of_type_Apxa.jdField_a_of_type_Int <= 0)) {
        break label66;
      }
    }
    label66:
    for (this.jdField_a_of_type_Int = (this.jdField_a_of_type_Apxa.jdField_b_of_type_Int + new Random().nextInt(this.jdField_a_of_type_Apxa.jdField_a_of_type_Int - this.jdField_a_of_type_Apxa.jdField_b_of_type_Int));; this.jdField_a_of_type_Int = new Random().nextInt(10000000)) {
      return this.jdField_a_of_type_Int;
    }
  }
  
  public apxa a()
  {
    return this.jdField_a_of_type_Apxa;
  }
  
  public aqao a()
  {
    return this.jdField_a_of_type_Aqao;
  }
  
  public awnc a()
  {
    return this.jdField_a_of_type_Awnc;
  }
  
  public ExtendFriendUserInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.jdField_a_of_type_Awbw == null) || (!this.jdField_a_of_type_Awbw.a())) {
      return null;
    }
    return (ExtendFriendUserInfo)this.jdField_a_of_type_Awbw.a(ExtendFriendUserInfo.class, paramString);
  }
  
  public ExtendFriendUserInfo a(String paramString, boolean paramBoolean)
  {
    ExtendFriendUserInfo localExtendFriendUserInfo2 = (ExtendFriendUserInfo)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    ExtendFriendUserInfo localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
    if (localExtendFriendUserInfo2 == null)
    {
      localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
      if (paramBoolean)
      {
        localExtendFriendUserInfo2 = a(paramString);
        localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
        if (localExtendFriendUserInfo2 != null)
        {
          this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, localExtendFriendUserInfo2);
          localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
        }
      }
    }
    return localExtendFriendUserInfo1;
  }
  
  public String a()
  {
    int k = 0;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      String str = String.valueOf(a());
      int i = str.length();
      int m = str.length() / 3 + i;
      int n = str.length() % 3;
      i = n;
      int j = m;
      if (n == 0)
      {
        i = n + 3;
        j = m - 1;
      }
      char[] arrayOfChar = new char[j];
      m = 0;
      j = k;
      k = i;
      i = m;
      if (i < arrayOfChar.length)
      {
        if (i == k)
        {
          k += 4;
          arrayOfChar[i] = ',';
          j += 1;
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfChar[i] = str.charAt(i - j);
        }
      }
      this.jdField_c_of_type_JavaLangString = new String(arrayOfChar);
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public ArrayList<aooo> a()
  {
    return aoop.a().a();
  }
  
  public List<String> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (paramInt > 0)
      {
        paramInt = Math.min(paramInt, 5);
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList.subList(0, paramInt));
      }
    }
    for (;;)
    {
      localArrayList.add(0, jdField_a_of_type_JavaLangString);
      return localArrayList;
      paramInt = this.jdField_b_of_type_JavaUtilArrayList.size();
      if (paramInt > 0)
      {
        paramInt = Math.min(paramInt, 5);
        localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList.subList(0, paramInt));
      }
    }
  }
  
  public oidb_0xdb1.SchoolInfo a()
  {
    return this.jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 454	apwx:jdField_b_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 82	apwx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12: invokevirtual 650	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: aload_0
    //   16: getfield 82	apwx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 653	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: ldc_w 655
    //   25: invokestatic 660	bdbr:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_1
    //   29: aload_1
    //   30: invokestatic 514	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifne +76 -> 109
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 662	apwx:a	(Ljava/lang/String;)Lapxa;
    //   41: astore_2
    //   42: getstatic 46	apwx:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   45: astore_1
    //   46: aload_1
    //   47: monitorenter
    //   48: aload_0
    //   49: getfield 454	apwx:jdField_b_of_type_Boolean	Z
    //   52: ifne +13 -> 65
    //   55: aload_0
    //   56: aload_2
    //   57: putfield 130	apwx:jdField_a_of_type_Apxa	Lapxa;
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 454	apwx:jdField_b_of_type_Boolean	Z
    //   65: aload_1
    //   66: monitorexit
    //   67: invokestatic 263	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq -63 -> 7
    //   73: ldc_w 265
    //   76: iconst_2
    //   77: ldc_w 664
    //   80: invokestatic 666	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: return
    //   84: astore_1
    //   85: invokestatic 263	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq -81 -> 7
    //   91: ldc_w 265
    //   94: iconst_2
    //   95: aload_1
    //   96: invokevirtual 669	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   99: aload_1
    //   100: invokestatic 671	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: return
    //   104: astore_2
    //   105: aload_1
    //   106: monitorexit
    //   107: aload_2
    //   108: athrow
    //   109: getstatic 46	apwx:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   112: astore_1
    //   113: aload_1
    //   114: monitorenter
    //   115: aload_0
    //   116: getfield 454	apwx:jdField_b_of_type_Boolean	Z
    //   119: ifne +8 -> 127
    //   122: aload_0
    //   123: iconst_1
    //   124: putfield 454	apwx:jdField_b_of_type_Boolean	Z
    //   127: aload_1
    //   128: monitorexit
    //   129: goto -62 -> 67
    //   132: astore_2
    //   133: aload_1
    //   134: monitorexit
    //   135: aload_2
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	apwx
    //   84	22	1	localException	Exception
    //   41	16	2	localapxa	apxa
    //   104	4	2	localObject3	Object
    //   132	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	29	84	java/lang/Exception
    //   48	65	104	finally
    //   65	67	104	finally
    //   105	107	104	finally
    //   115	127	132	finally
    //   127	129	132	finally
    //   133	135	132	finally
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateCampusCertificateStatus campusCertificateStatus = " + this.jdField_c_of_type_Int + ",new status = " + paramInt1);
    }
    this.jdField_c_of_type_Int = paramInt1;
    aqcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateCurExtendFriendSchoolInfo ,idx = " + paramInt1 + ",schoolName = " + paramString1 + ",schoolId = " + paramString2 + ",schoolCategory = " + paramInt2);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      this.jdField_a_of_type_Awnc = null;
      return;
    }
    if (this.jdField_a_of_type_Awnc == null) {
      this.jdField_a_of_type_Awnc = new awnc();
    }
    this.jdField_a_of_type_Awnc.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Awnc.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Awnc.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Awnc.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.5(this));
  }
  
  public void a(ExtendFriendUserInfo paramExtendFriendUserInfo)
  {
    if (paramExtendFriendUserInfo == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidUtilLruCache.put(paramExtendFriendUserInfo.uin, paramExtendFriendUserInfo);
      if ((this.jdField_a_of_type_Awbw != null) && (this.jdField_a_of_type_Awbw.a()))
      {
        if (paramExtendFriendUserInfo.getStatus() != 1000) {
          break label90;
        }
        this.jdField_a_of_type_Awbw.b(paramExtendFriendUserInfo);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ExtendFriendManager", 2, "updateExtendFriendUserInfo " + paramExtendFriendUserInfo.uin);
        return;
        label90:
        if (paramExtendFriendUserInfo.getStatus() == 1001) {
          this.jdField_a_of_type_Awbw.a(paramExtendFriendUserInfo);
        }
      }
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_0xdb1.RspBody paramRspBody)
  {
    ArrayList localArrayList = null;
    boolean bool2 = true;
    Object localObject2 = "";
    int j;
    String str1;
    label48:
    int i;
    label65:
    label92:
    boolean bool1;
    label101:
    label126:
    String str2;
    label136:
    label163:
    label187:
    Object localObject1;
    if (paramRspBody.enum_school_verify_status.has())
    {
      j = paramRspBody.enum_school_verify_status.get();
      if (!paramRspBody.str_school_verify_tips.has()) {
        break label448;
      }
      str1 = paramRspBody.str_school_verify_tips.get();
      this.jdField_e_of_type_JavaLangString = str1;
      if (!TextUtils.isEmpty(str1)) {
        break label455;
      }
      i = 1;
      a(j, i);
      if (!paramRspBody.uint32_user_identity.has()) {
        break label461;
      }
      i = paramRspBody.uint32_user_identity.get();
      if (i != 1) {
        break label467;
      }
      bool1 = true;
      this.jdField_d_of_type_Boolean = bool1;
      if (!paramRspBody.uint32_need_display_school_info.has()) {
        break label473;
      }
      i = paramRspBody.uint32_need_display_school_info.get();
      if (i != 1) {
        break label479;
      }
      bool1 = bool2;
      this.jdField_c_of_type_Boolean = bool1;
      if (!paramRspBody.msg_new_school_info.has()) {
        break label485;
      }
      paramFromServiceMsg = (oidb_0xdb1.SchoolInfo)paramRspBody.msg_new_school_info.get();
      this.jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo = paramFromServiceMsg;
      if (!paramRspBody.str_suggest_school_name.has()) {
        break label490;
      }
      str2 = paramRspBody.str_suggest_school_name.get();
      this.jdField_d_of_type_JavaLangString = str2;
      if (!paramRspBody.msg_kuolie_school_info.has()) {
        break label497;
      }
      localObject1 = (oidb_0xdb1.SchoolInfo)paramRspBody.msg_kuolie_school_info.get();
      label215:
      a((oidb_0xdb1.SchoolInfo)localObject1);
      paramFromServiceMsg = (FromServiceMsg)localObject2;
      if (localObject1 != null)
      {
        if (!((oidb_0xdb1.SchoolInfo)localObject1).str_school_name.has()) {
          break label503;
        }
        paramFromServiceMsg = ((oidb_0xdb1.SchoolInfo)localObject1).str_school_name.get();
      }
      label249:
      if (!paramToServiceMsg.extraData.getBoolean("key_need_get_online_number", false)) {
        break label734;
      }
      if (!paramRspBody.uint32_online_num.has()) {
        break label509;
      }
      i = paramRspBody.uint32_online_num.get();
    }
    for (;;)
    {
      label282:
      this.jdField_b_of_type_Int = i;
      if (paramToServiceMsg.extraData.getBoolean("key_need_get_search_keywords", false))
      {
        if (paramRspBody.msg_campus_search_keywords.has())
        {
          localObject1 = paramRspBody.msg_campus_search_keywords.get();
          label321:
          paramToServiceMsg = localArrayList;
          if (paramRspBody.msg_voice_search_keywords.has()) {
            paramToServiceMsg = paramRspBody.msg_voice_search_keywords.get();
          }
          localArrayList = new ArrayList();
          localObject2 = new ArrayList();
          if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
            localObject1 = ((List)localObject1).iterator();
          }
        }
        else
        {
          label384:
          label525:
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label527;
            }
            paramRspBody = (oidb_0xdb1.SearchKeyWord)((Iterator)localObject1).next();
            if (paramRspBody.str_school_name.has()) {}
            for (paramRspBody = paramRspBody.str_school_name.get();; paramRspBody = "")
            {
              if (TextUtils.isEmpty(paramRspBody)) {
                break label525;
              }
              localArrayList.add(paramRspBody);
              break label384;
              j = 0;
              break;
              label448:
              str1 = "";
              break label48;
              label455:
              i = 2;
              break label65;
              label461:
              i = 0;
              break label92;
              label467:
              bool1 = false;
              break label101;
              label473:
              i = 0;
              break label126;
              label479:
              bool1 = false;
              break label136;
              label485:
              paramFromServiceMsg = null;
              break label163;
              label490:
              str2 = "";
              break label187;
              label497:
              localObject1 = null;
              break label215;
              label503:
              paramFromServiceMsg = "";
              break label249;
              label509:
              i = 0;
              break label282;
              localObject1 = null;
              break label321;
            }
          }
        }
        label527:
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
        {
          paramRspBody = paramToServiceMsg.iterator();
          label607:
          while (paramRspBody.hasNext())
          {
            paramToServiceMsg = (oidb_0xdb1.SearchKeyWord)paramRspBody.next();
            if (paramToServiceMsg.str_school_name.has()) {}
            for (paramToServiceMsg = paramToServiceMsg.str_school_name.get();; paramToServiceMsg = "")
            {
              if (TextUtils.isEmpty(paramToServiceMsg)) {
                break label607;
              }
              ((List)localObject2).add(paramToServiceMsg);
              break;
            }
          }
        }
        a(localArrayList, (List)localObject2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "handleGetExtendFriendPermissionAndStatusResponse. ,verifyStatus = " + j + ",verifyTips = " + str1 + ",serverSuggestSchoolName = " + str2 + ",schoolNameInExtendFriendCard = " + paramFromServiceMsg + ",onlineNumber = " + i + ",needShowEduBackgroundUpdateDialog = " + this.jdField_c_of_type_Boolean + ",profileNewSchoolInfo = " + this.jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo + ",isUserStudentOrNot = " + this.jdField_d_of_type_Boolean);
      }
      return;
      label734:
      i = 0;
    }
  }
  
  public void a(String arg1)
  {
    apxa localapxa = a(???);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Apxa = localapxa;
      this.jdField_b_of_type_Boolean = true;
      boolean bool = aqbo.a(this.jdField_a_of_type_Apxa);
      ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.4(this, bool));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getUnlimitMatchUserInfo() uin = " + paramString1 + " matchUin = " + paramString2 + "uinType=" + paramInt);
    }
    ((apwv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).a(paramString1, paramString2, paramInt);
  }
  
  public void a(List<String> paramList1, List<String> paramList2)
  {
    int i = 0;
    paramList1 = aywn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("updateSearchKeyWords campusHotTags=%s", new Object[] { Arrays.toString(paramList1) }));
    }
    if ((paramList1 != null) && (paramList1.length > 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int j = paramList1.length;
      while (i < j)
      {
        Object localObject = paramList1[i];
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        i += 1;
      }
    }
    if (paramList2 != null)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.addAll(paramList2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("onResourceDownloadComplete mResourceReady=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(apxa paramapxa)
  {
    boolean bool = true;
    if ((paramapxa == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramapxa = bdiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
        int i = paramapxa.getInt("sp_extend_friend_entry_contact", 0);
        int j = paramapxa.getInt("sp_extend_friend_entry_add_friend", 0);
        if ((i != 1) || (j != 1)) {
          break label89;
        }
        return bool;
      }
      catch (Exception paramapxa)
      {
        paramapxa.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ExtendFriendManager", 2, paramapxa.getMessage());
      return false;
      label89:
      bool = false;
    }
  }
  
  public int b()
  {
    int j = 2147483647;
    int i = j;
    if (a())
    {
      i = j;
      if (this.jdField_a_of_type_Apxa != null) {
        i = this.jdField_a_of_type_Apxa.jdField_m_of_type_Int;
      }
    }
    return i;
  }
  
  public apxa b()
  {
    if (!a()) {
      a();
    }
    return this.jdField_a_of_type_Apxa;
  }
  
  public aqao b()
  {
    return this.jdField_b_of_type_Aqao;
  }
  
  public String b()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (a())
    {
      apxa localapxa = a();
      localObject1 = localObject2;
      if (localapxa != null) {
        localObject1 = localapxa.jdField_i_of_type_JavaLangString;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = alpo.a(2131704647);
    }
    return localObject2;
  }
  
  public List<String> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1) {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    while (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
      return localArrayList;
    }
    localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    return localArrayList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateMatchChatConfig ");
    }
    ((apwv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).notifyUI(18, true, null);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c(paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String c()
  {
    String str2 = "";
    String str1 = str2;
    if (a())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Apxa != null) {
        str1 = this.jdField_a_of_type_Apxa.jdField_k_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    if ((this.jdField_a_of_type_Awbw != null) && (this.jdField_a_of_type_Awbw.a())) {
      this.jdField_a_of_type_Awbw.a(ExtendFriendUserInfo.class);
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String d()
  {
    String str2 = "";
    String str1 = str2;
    if (a())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Apxa != null) {
        str1 = this.jdField_a_of_type_Apxa.jdField_l_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public boolean d()
  {
    if ((a()) && (this.jdField_a_of_type_Apxa != null)) {}
    for (int i = this.jdField_a_of_type_Apxa.n;; i = 1) {
      return i == 1;
    }
  }
  
  public String e()
  {
    String str2 = "";
    String str1 = str2;
    if (a())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Apxa != null) {
        str1 = this.jdField_a_of_type_Apxa.jdField_m_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool3 = aqcq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool1 = bool2;
    if (bool3) {
      if ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 2))
      {
        bool1 = bool2;
        if (this.jdField_c_of_type_Int != 3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "isNeedShowCertificateBanner result = " + bool1 + ",showFlag = " + bool3);
    }
    return bool1;
  }
  
  public String f()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Apxa == null) {}
    while (this.jdField_a_of_type_Apxa.jdField_i_of_type_Int != 1) {
      return false;
    }
    return true;
  }
  
  public String g()
  {
    if (this.jdField_a_of_type_Awnc != null) {
      return this.jdField_a_of_type_Awnc.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean g()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Apxa != null) && (this.jdField_a_of_type_Apxa.jdField_k_of_type_Int == 1)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "bVoiceMatchOpen  " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Allb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Apxc);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Apxd != null)
    {
      this.jdField_a_of_type_Apxd.b();
      this.jdField_a_of_type_Apxd.a(null);
      this.jdField_a_of_type_Apxd = null;
      this.jdField_a_of_type_Boolean = false;
    }
    jdField_a_of_type_Apys = null;
    if (this.jdField_a_of_type_AndroidUtilLruCache != null) {
      this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwx
 * JD-Core Version:    0.7.0.1
 */