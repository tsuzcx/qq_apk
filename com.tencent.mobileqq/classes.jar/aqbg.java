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

public class aqbg
  implements aqbr, Manager
{
  public static aqdb a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a;
  private int jdField_a_of_type_Int;
  private alpq jdField_a_of_type_Alpq = new aqbh(this);
  private LruCache<String, ExtendFriendUserInfo> jdField_a_of_type_AndroidUtilLruCache = new LruCache(50);
  private aqbj jdField_a_of_type_Aqbj;
  private aqbl jdField_a_of_type_Aqbl = new aqbi(this);
  private aqbm jdField_a_of_type_Aqbm;
  private aqex jdField_a_of_type_Aqex;
  private awgf jdField_a_of_type_Awgf;
  private awrl jdField_a_of_type_Awrl;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private oidb_0xdb1.SchoolInfo jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private aqex jdField_b_of_type_Aqex;
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
    jdField_a_of_type_JavaLangString = alud.a(2131704662);
  }
  
  public aqbg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alpq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aqbl);
    this.jdField_a_of_type_Aqbm = new aqbm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aqbm.a(this);
    this.jdField_a_of_type_Aqex = new aqex(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
    this.jdField_b_of_type_Aqex = new aqex(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.jdField_a_of_type_Awgf = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    ThreadManager.postImmediately(new ExtendFriendManager.3(this), null, true);
  }
  
  private aqbj a(String paramString)
  {
    int j = 0;
    aqbj localaqbj = new aqbj();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        localaqbj.jdField_a_of_type_JavaLangString = paramString.optString("contactEntranceTitle");
        localaqbj.jdField_b_of_type_JavaLangString = paramString.optString("contactEntranceLine1");
        localaqbj.jdField_c_of_type_JavaLangString = paramString.optString("contactEntranceLine2");
        localaqbj.jdField_d_of_type_JavaLangString = paramString.optString("addEntranceTitle");
        localaqbj.jdField_e_of_type_JavaLangString = paramString.optString("addEntranceLine1");
        localaqbj.jdField_a_of_type_Int = paramString.optInt("maxPlayers");
        localaqbj.jdField_b_of_type_Int = paramString.optInt("minPlayers");
        localaqbj.jdField_c_of_type_Int = paramString.optInt("voiceMaxLength");
        localaqbj.jdField_d_of_type_Int = paramString.optInt("maxSlipTimes");
        localaqbj.jdField_e_of_type_Int = paramString.optInt("redisplayInterval");
        localaqbj.jdField_f_of_type_JavaLangString = paramString.optString("defaultDecleration");
        localaqbj.jdField_f_of_type_Int = paramString.optInt("declerationMinLen");
        localaqbj.jdField_g_of_type_Int = paramString.optInt("isExpandEntranceOnTop");
        localaqbj.jdField_g_of_type_JavaLangString = paramString.optString("resourceURL");
        localaqbj.jdField_h_of_type_JavaLangString = paramString.optString("resourceMD5");
        localaqbj.jdField_h_of_type_Int = paramString.optInt("isShowGroup");
        localaqbj.jdField_j_of_type_JavaLangString = paramString.optString("ExpandExamImg");
        localaqbj.jdField_l_of_type_Int = paramString.optInt("exposureTimeLimit", 2);
        localaqbj.jdField_a_of_type_Boolean = paramString.optBoolean("showVipIcon", false);
        localaqbj.jdField_m_of_type_Int = paramString.optInt("GrayTipsMsgCount", 50);
        localaqbj.jdField_k_of_type_JavaLangString = paramString.optString("GrayTipsMsg");
        localaqbj.jdField_l_of_type_JavaLangString = paramString.optString("GrayTipsMsgLight");
        localaqbj.n = paramString.optInt("IceBreakSwitch", 1);
        localaqbj.jdField_m_of_type_JavaLangString = paramString.optString("BeatWarning");
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendManager", 2, "parseConfig config.exposureTimeLimit:" + localaqbj.jdField_l_of_type_Int);
        }
        localaqbj.jdField_a_of_type_JavaUtilList.clear();
        JSONArray localJSONArray = paramString.optJSONArray("defaultTags");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            localaqbj.jdField_a_of_type_JavaUtilList.add(localJSONArray.optString(i));
            i += 1;
            continue;
          }
        }
        localaqbj.jdField_b_of_type_JavaUtilList.clear();
        localJSONArray = paramString.optJSONArray("searchTags");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            localaqbj.jdField_b_of_type_JavaUtilList.add(localJSONArray.optString(i));
            i += 1;
            continue;
          }
        }
        localaqbj.jdField_i_of_type_JavaLangString = paramString.optString("searchHint");
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
            aqbk localaqbk = new aqbk(this);
            localaqbk.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
            if ("aioVideo".equals(localaqbk.jdField_a_of_type_JavaLangString))
            {
              localaqbk.jdField_b_of_type_JavaLangString = localJSONObject.optString("resourceURLAndroid");
              localaqbk.jdField_c_of_type_JavaLangString = localJSONObject.optString("resourceMD5Android");
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendManager", 2, String.format("aiovideo use android url:%s", new Object[] { localaqbk.jdField_b_of_type_JavaLangString }));
              }
              if (!localaqbk.a()) {
                break label695;
              }
              localaqbj.jdField_a_of_type_JavaUtilHashMap.put(localaqbk.jdField_a_of_type_JavaLangString, localaqbk);
              break label695;
            }
            localaqbk.jdField_b_of_type_JavaLangString = localJSONObject.optString("resourceURL");
            localaqbk.jdField_c_of_type_JavaLangString = localJSONObject.optString("resourceMD5");
            continue;
          }
        }
        localaqbj.jdField_i_of_type_Int = paramString.optInt("ExpandMatchSwitch");
      }
      catch (JSONException paramString)
      {
        QLog.e("ExtendFriendManager", 2, "parseConfig fail.", paramString);
        return null;
      }
      localaqbj.jdField_j_of_type_Int = paramString.optInt("isNuanSSFirst");
      localaqbj.jdField_k_of_type_Int = paramString.optInt("isVoiceMatchOpen");
      return localaqbj;
      label695:
      i += 1;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("setAnswerQuestionFlag, uin: %s, flag: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    bdne.g(paramString).edit().putBoolean("sp_extend_friend_question", paramBoolean).apply();
  }
  
  private void a(oidb_0xdb1.SchoolInfo paramSchoolInfo)
  {
    int j = 0;
    if (paramSchoolInfo != null)
    {
      this.jdField_a_of_type_Awrl = new awrl();
      Object localObject = this.jdField_a_of_type_Awrl;
      int i;
      if (paramSchoolInfo.uint32_idx.has())
      {
        i = paramSchoolInfo.uint32_idx.get();
        ((awrl)localObject).jdField_a_of_type_Int = i;
        localObject = this.jdField_a_of_type_Awrl;
        i = j;
        if (paramSchoolInfo.uint32_category.has()) {
          i = paramSchoolInfo.uint32_category.get();
        }
        ((awrl)localObject).jdField_b_of_type_Int = i;
        awrl localawrl = this.jdField_a_of_type_Awrl;
        if (!paramSchoolInfo.str_school_id.has()) {
          break label147;
        }
        localObject = paramSchoolInfo.str_school_id.get();
        label104:
        localawrl.jdField_a_of_type_JavaLangString = ((String)localObject);
        localObject = this.jdField_a_of_type_Awrl;
        if (!paramSchoolInfo.str_school_name.has()) {
          break label154;
        }
      }
      label147:
      label154:
      for (paramSchoolInfo = paramSchoolInfo.str_school_name.get();; paramSchoolInfo = "")
      {
        ((awrl)localObject).jdField_b_of_type_JavaLangString = paramSchoolInfo;
        return;
        i = 0;
        break;
        localObject = "";
        break label104;
      }
    }
    this.jdField_a_of_type_Awrl = null;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = bdne.g(paramString).getBoolean("sp_extend_friend_question", true);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "needAnswerQuestion: " + bool);
    }
    return bool;
  }
  
  private void c(boolean paramBoolean)
  {
    ((aqbe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).notifyUI(5, true, Boolean.valueOf(paramBoolean));
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig=%s mDownloader=%s", new Object[] { this.jdField_a_of_type_Aqbj, this.jdField_a_of_type_Aqbm }));
    }
    if ((this.jdField_a_of_type_Aqbj != null) && (this.jdField_a_of_type_Aqbm != null)) {}
    try
    {
      this.jdField_a_of_type_Aqbm.a(this.jdField_a_of_type_Aqbj.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqbj.jdField_h_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Aqbm.a())
      {
        this.jdField_a_of_type_Aqbm.a();
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
    String str = aqhh.a("expand_question_dialog.png");
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
      if ((this.jdField_a_of_type_Aqbj == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Aqbj.jdField_j_of_type_JavaLangString))) {
        break label152;
      }
      i = beag.a(new beae(this.jdField_a_of_type_Aqbj.jdField_j_of_type_JavaLangString, localFile), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        Card localCard = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
          if (jdField_a_of_type_Aqdb != null)
          {
            jdField_a_of_type_Aqdb.jdField_a_of_type_Boolean = bool1;
            jdField_a_of_type_Aqdb.jdField_b_of_type_Boolean = bool2;
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
        QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData %s", new Object[] { jdField_a_of_type_Aqdb }));
      }
      return;
      bool1 = false;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if ((this.jdField_a_of_type_Aqbj == null) || (this.jdField_a_of_type_Aqbj.jdField_a_of_type_Int <= 0)) {
        break label66;
      }
    }
    label66:
    for (this.jdField_a_of_type_Int = (this.jdField_a_of_type_Aqbj.jdField_b_of_type_Int + new Random().nextInt(this.jdField_a_of_type_Aqbj.jdField_a_of_type_Int - this.jdField_a_of_type_Aqbj.jdField_b_of_type_Int));; this.jdField_a_of_type_Int = new Random().nextInt(10000000)) {
      return this.jdField_a_of_type_Int;
    }
  }
  
  public aqbj a()
  {
    return this.jdField_a_of_type_Aqbj;
  }
  
  public aqex a()
  {
    return this.jdField_a_of_type_Aqex;
  }
  
  public awrl a()
  {
    return this.jdField_a_of_type_Awrl;
  }
  
  public ExtendFriendUserInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.jdField_a_of_type_Awgf == null) || (!this.jdField_a_of_type_Awgf.a())) {
      return null;
    }
    return (ExtendFriendUserInfo)this.jdField_a_of_type_Awgf.a(ExtendFriendUserInfo.class, paramString);
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
  
  public ArrayList<aosx> a()
  {
    return aosy.a().a();
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
    //   1: getfield 454	aqbg:jdField_b_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 82	aqbg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12: invokevirtual 650	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: aload_0
    //   16: getfield 82	aqbg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 653	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: ldc_w 655
    //   25: invokestatic 660	bdga:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_1
    //   29: aload_1
    //   30: invokestatic 514	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifne +76 -> 109
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 662	aqbg:a	(Ljava/lang/String;)Laqbj;
    //   41: astore_2
    //   42: getstatic 46	aqbg:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   45: astore_1
    //   46: aload_1
    //   47: monitorenter
    //   48: aload_0
    //   49: getfield 454	aqbg:jdField_b_of_type_Boolean	Z
    //   52: ifne +13 -> 65
    //   55: aload_0
    //   56: aload_2
    //   57: putfield 130	aqbg:jdField_a_of_type_Aqbj	Laqbj;
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 454	aqbg:jdField_b_of_type_Boolean	Z
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
    //   109: getstatic 46	aqbg:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   112: astore_1
    //   113: aload_1
    //   114: monitorenter
    //   115: aload_0
    //   116: getfield 454	aqbg:jdField_b_of_type_Boolean	Z
    //   119: ifne +8 -> 127
    //   122: aload_0
    //   123: iconst_1
    //   124: putfield 454	aqbg:jdField_b_of_type_Boolean	Z
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
    //   0	137	0	this	aqbg
    //   84	22	1	localException	Exception
    //   41	16	2	localaqbj	aqbj
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
    aqgz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateCurExtendFriendSchoolInfo ,idx = " + paramInt1 + ",schoolName = " + paramString1 + ",schoolId = " + paramString2 + ",schoolCategory = " + paramInt2);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      this.jdField_a_of_type_Awrl = null;
      return;
    }
    if (this.jdField_a_of_type_Awrl == null) {
      this.jdField_a_of_type_Awrl = new awrl();
    }
    this.jdField_a_of_type_Awrl.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Awrl.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Awrl.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Awrl.jdField_b_of_type_Int = paramInt2;
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
      if ((this.jdField_a_of_type_Awgf != null) && (this.jdField_a_of_type_Awgf.a()))
      {
        if (paramExtendFriendUserInfo.getStatus() != 1000) {
          break label90;
        }
        this.jdField_a_of_type_Awgf.b(paramExtendFriendUserInfo);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ExtendFriendManager", 2, "updateExtendFriendUserInfo " + paramExtendFriendUserInfo.uin);
        return;
        label90:
        if (paramExtendFriendUserInfo.getStatus() == 1001) {
          this.jdField_a_of_type_Awgf.a(paramExtendFriendUserInfo);
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
    aqbj localaqbj = a(???);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Aqbj = localaqbj;
      this.jdField_b_of_type_Boolean = true;
      boolean bool = aqfx.a(this.jdField_a_of_type_Aqbj);
      ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.4(this, bool));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getUnlimitMatchUserInfo() uin = " + paramString1 + " matchUin = " + paramString2 + "uinType=" + paramInt);
    }
    ((aqbe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).a(paramString1, paramString2, paramInt);
  }
  
  public void a(List<String> paramList1, List<String> paramList2)
  {
    int i = 0;
    paramList1 = azaw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
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
  
  public boolean a(aqbj paramaqbj)
  {
    boolean bool = true;
    if ((paramaqbj == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramaqbj = bdne.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
        int i = paramaqbj.getInt("sp_extend_friend_entry_contact", 0);
        int j = paramaqbj.getInt("sp_extend_friend_entry_add_friend", 0);
        if ((i != 1) || (j != 1)) {
          break label89;
        }
        return bool;
      }
      catch (Exception paramaqbj)
      {
        paramaqbj.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ExtendFriendManager", 2, paramaqbj.getMessage());
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
      if (this.jdField_a_of_type_Aqbj != null) {
        i = this.jdField_a_of_type_Aqbj.jdField_m_of_type_Int;
      }
    }
    return i;
  }
  
  public aqbj b()
  {
    if (!a()) {
      a();
    }
    return this.jdField_a_of_type_Aqbj;
  }
  
  public aqex b()
  {
    return this.jdField_b_of_type_Aqex;
  }
  
  public String b()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (a())
    {
      aqbj localaqbj = a();
      localObject1 = localObject2;
      if (localaqbj != null) {
        localObject1 = localaqbj.jdField_i_of_type_JavaLangString;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = alud.a(2131704659);
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
    ((aqbe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).notifyUI(18, true, null);
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
      if (this.jdField_a_of_type_Aqbj != null) {
        str1 = this.jdField_a_of_type_Aqbj.jdField_k_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    if ((this.jdField_a_of_type_Awgf != null) && (this.jdField_a_of_type_Awgf.a())) {
      this.jdField_a_of_type_Awgf.a(ExtendFriendUserInfo.class);
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
      if (this.jdField_a_of_type_Aqbj != null) {
        str1 = this.jdField_a_of_type_Aqbj.jdField_l_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public boolean d()
  {
    if ((a()) && (this.jdField_a_of_type_Aqbj != null)) {}
    for (int i = this.jdField_a_of_type_Aqbj.n;; i = 1) {
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
      if (this.jdField_a_of_type_Aqbj != null) {
        str1 = this.jdField_a_of_type_Aqbj.jdField_m_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool3 = aqgz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    if (this.jdField_a_of_type_Aqbj == null) {}
    while (this.jdField_a_of_type_Aqbj.jdField_i_of_type_Int != 1) {
      return false;
    }
    return true;
  }
  
  public String g()
  {
    if (this.jdField_a_of_type_Awrl != null) {
      return this.jdField_a_of_type_Awrl.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean g()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Aqbj != null) && (this.jdField_a_of_type_Aqbj.jdField_k_of_type_Int == 1)) {}
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alpq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aqbl);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Aqbm != null)
    {
      this.jdField_a_of_type_Aqbm.b();
      this.jdField_a_of_type_Aqbm.a(null);
      this.jdField_a_of_type_Aqbm = null;
      this.jdField_a_of_type_Boolean = false;
    }
    jdField_a_of_type_Aqdb = null;
    if (this.jdField_a_of_type_AndroidUtilLruCache != null) {
      this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbg
 * JD-Core Version:    0.7.0.1
 */