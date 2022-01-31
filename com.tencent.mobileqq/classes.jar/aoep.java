import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.3;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.4;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aoep
  implements aofa, Manager
{
  public static aogj a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a;
  private int jdField_a_of_type_Int;
  private ajtq jdField_a_of_type_Ajtq = new aoeq(this);
  private LruCache<String, ExtendFriendUserInfo> jdField_a_of_type_AndroidUtilLruCache = new LruCache(50);
  private aoes jdField_a_of_type_Aoes;
  private aoeu jdField_a_of_type_Aoeu = new aoer(this);
  private aoev jdField_a_of_type_Aoev;
  private aoif jdField_a_of_type_Aoif;
  private aukn jdField_a_of_type_Aukn;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  public String b;
  private boolean b;
  private String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajyc.a(2131704267);
  }
  
  public aoep(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajtq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoeu);
    this.jdField_a_of_type_Aoev = new aoev(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aoev.a(this);
    this.jdField_a_of_type_Aoif = new aoif(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aukn = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    ThreadManager.postImmediately(new ExtendFriendManager.3(this), null, true);
  }
  
  private aoes a(String paramString)
  {
    int j = 0;
    aoes localaoes = new aoes();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        localaoes.jdField_a_of_type_JavaLangString = paramString.optString("contactEntranceTitle");
        localaoes.jdField_b_of_type_JavaLangString = paramString.optString("contactEntranceLine1");
        localaoes.jdField_c_of_type_JavaLangString = paramString.optString("contactEntranceLine2");
        localaoes.jdField_d_of_type_JavaLangString = paramString.optString("addEntranceTitle");
        localaoes.jdField_e_of_type_JavaLangString = paramString.optString("addEntranceLine1");
        localaoes.jdField_a_of_type_Int = paramString.optInt("maxPlayers");
        localaoes.jdField_b_of_type_Int = paramString.optInt("minPlayers");
        localaoes.jdField_c_of_type_Int = paramString.optInt("voiceMaxLength");
        localaoes.jdField_d_of_type_Int = paramString.optInt("maxSlipTimes");
        localaoes.jdField_e_of_type_Int = paramString.optInt("redisplayInterval");
        localaoes.jdField_f_of_type_JavaLangString = paramString.optString("defaultDecleration");
        localaoes.jdField_f_of_type_Int = paramString.optInt("declerationMinLen");
        localaoes.jdField_g_of_type_Int = paramString.optInt("isExpandEntranceOnTop");
        localaoes.jdField_g_of_type_JavaLangString = paramString.optString("resourceURL");
        localaoes.jdField_h_of_type_JavaLangString = paramString.optString("resourceMD5");
        localaoes.jdField_h_of_type_Int = paramString.optInt("isShowGroup");
        localaoes.jdField_j_of_type_JavaLangString = paramString.optString("ExpandExamImg");
        localaoes.jdField_k_of_type_Int = paramString.optInt("exposureTimeLimit", 2);
        localaoes.jdField_a_of_type_Boolean = paramString.optBoolean("showVipIcon", false);
        localaoes.jdField_l_of_type_Int = paramString.optInt("GrayTipsMsgCount", 50);
        localaoes.jdField_k_of_type_JavaLangString = paramString.optString("GrayTipsMsg");
        localaoes.jdField_l_of_type_JavaLangString = paramString.optString("GrayTipsMsgLight");
        localaoes.jdField_m_of_type_Int = paramString.optInt("IceBreakSwitch", 1);
        localaoes.jdField_m_of_type_JavaLangString = paramString.optString("BeatWarning");
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendManager", 2, "parseConfig config.exposureTimeLimit:" + localaoes.jdField_k_of_type_Int);
        }
        localaoes.jdField_a_of_type_JavaUtilList.clear();
        JSONArray localJSONArray = paramString.optJSONArray("defaultTags");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            localaoes.jdField_a_of_type_JavaUtilList.add(localJSONArray.optString(i));
            i += 1;
            continue;
          }
        }
        localaoes.jdField_b_of_type_JavaUtilList.clear();
        localJSONArray = paramString.optJSONArray("searchTags");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            localaoes.jdField_b_of_type_JavaUtilList.add(localJSONArray.optString(i));
            i += 1;
            continue;
          }
        }
        localaoes.jdField_i_of_type_JavaLangString = paramString.optString("searchHint");
        localJSONArray = paramString.optJSONArray("ExpandMatchRes");
        if (localJSONArray != null)
        {
          i = j;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject == null) {
              break label679;
            }
            aoet localaoet = new aoet(this);
            localaoet.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
            if ("aioVideo".equals(localaoet.jdField_a_of_type_JavaLangString))
            {
              localaoet.jdField_b_of_type_JavaLangString = localJSONObject.optString("resourceURLAndroid");
              localaoet.jdField_c_of_type_JavaLangString = localJSONObject.optString("resourceMD5Android");
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendManager", 2, String.format("aiovideo use android url:%s", new Object[] { localaoet.jdField_b_of_type_JavaLangString }));
              }
              if (!localaoet.a()) {
                break label679;
              }
              localaoes.jdField_a_of_type_JavaUtilHashMap.put(localaoet.jdField_a_of_type_JavaLangString, localaoet);
              break label679;
            }
            localaoet.jdField_b_of_type_JavaLangString = localJSONObject.optString("resourceURL");
            localaoet.jdField_c_of_type_JavaLangString = localJSONObject.optString("resourceMD5");
            continue;
          }
        }
        localaoes.jdField_i_of_type_Int = paramString.optInt("ExpandMatchSwitch");
      }
      catch (JSONException paramString)
      {
        QLog.e("ExtendFriendManager", 2, "parseConfig fail.", paramString);
        return null;
      }
      localaoes.jdField_j_of_type_Int = paramString.optInt("isNuanSSFirst");
      return localaoes;
      label679:
      i += 1;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("setAnswerQuestionFlag, uin: %s, flag: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    bbjn.g(paramString).edit().putBoolean("sp_extend_friend_question", paramBoolean).apply();
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = bbjn.g(paramString).getBoolean("sp_extend_friend_question", true);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "needAnswerQuestion: " + bool);
    }
    return bool;
  }
  
  private void c(boolean paramBoolean)
  {
    ((aoeo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).notifyUI(5, true, Boolean.valueOf(paramBoolean));
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig=%s mDownloader=%s", new Object[] { this.jdField_a_of_type_Aoes, this.jdField_a_of_type_Aoev }));
    }
    if ((this.jdField_a_of_type_Aoes != null) && (this.jdField_a_of_type_Aoev != null)) {}
    try
    {
      this.jdField_a_of_type_Aoev.a(this.jdField_a_of_type_Aoes.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aoes.jdField_h_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Aoev.a())
      {
        this.jdField_a_of_type_Aoev.a();
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
    String str = aokl.a("expand_question_dialog.png");
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
      if ((this.jdField_a_of_type_Aoes == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Aoes.jdField_j_of_type_JavaLangString))) {
        break label149;
      }
      i = bbwi.a(new bbwg(this.jdField_a_of_type_Aoes.jdField_j_of_type_JavaLangString, localFile), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendManager", 2, "downloadQuestionRes success!");
    return;
    QLog.e("ExtendFriendManager", 1, String.format("downloadQuestionRes fail, ret = %s", new Object[] { Integer.valueOf(i) }));
    return;
    label149:
    QLog.e("ExtendFriendManager", 1, "downloadQuestionRes, config or url is empty!");
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (;;)
    {
      try
      {
        Card localCard = ((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
          if (jdField_a_of_type_Aogj != null)
          {
            jdField_a_of_type_Aogj.jdField_a_of_type_Boolean = bool1;
            jdField_a_of_type_Aogj.b = bool2;
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
        QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData %s", new Object[] { jdField_a_of_type_Aogj }));
      }
      return;
      bool1 = false;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if ((this.jdField_a_of_type_Aoes == null) || (this.jdField_a_of_type_Aoes.jdField_a_of_type_Int <= 0)) {
        break label66;
      }
    }
    label66:
    for (this.jdField_a_of_type_Int = (this.jdField_a_of_type_Aoes.jdField_b_of_type_Int + new Random().nextInt(this.jdField_a_of_type_Aoes.jdField_a_of_type_Int - this.jdField_a_of_type_Aoes.jdField_b_of_type_Int));; this.jdField_a_of_type_Int = new Random().nextInt(10000000)) {
      return this.jdField_a_of_type_Int;
    }
  }
  
  public aoes a()
  {
    return this.jdField_a_of_type_Aoes;
  }
  
  public aoif a()
  {
    return this.jdField_a_of_type_Aoif;
  }
  
  public ExtendFriendUserInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.jdField_a_of_type_Aukn == null) || (!this.jdField_a_of_type_Aukn.a())) {
      return null;
    }
    return (ExtendFriendUserInfo)this.jdField_a_of_type_Aukn.a(ExtendFriendUserInfo.class, paramString);
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
  
  public ArrayList<amxi> a()
  {
    return amxj.a().a();
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (a())
    {
      aoes localaoes = a();
      if (localaoes == null) {
        break label105;
      }
      localArrayList.addAll(localaoes.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      if (localArrayList.size() == 0)
      {
        localArrayList.add(ajyc.a(2131704268));
        localArrayList.add(ajyc.a(2131704269));
        localArrayList.add(ajyc.a(2131704257));
        localArrayList.add(ajyc.a(2131704265));
        localArrayList.add(ajyc.a(2131704248));
      }
      localArrayList.add(0, jdField_a_of_type_JavaLangString);
      return localArrayList;
      label105:
      QLog.e("ExtendFriendManager", 2, "getDefaultTags CONFIG IS NULL ");
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 391	aoep:b	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 63	aoep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12: invokevirtual 588	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: aload_0
    //   16: getfield 63	aoep:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 591	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: ldc_w 593
    //   25: invokestatic 598	bbcj:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_1
    //   29: aload_1
    //   30: invokestatic 451	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifne +74 -> 107
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 600	aoep:a	(Ljava/lang/String;)Laoes;
    //   41: astore_2
    //   42: getstatic 40	aoep:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   45: astore_1
    //   46: aload_1
    //   47: monitorenter
    //   48: aload_0
    //   49: getfield 391	aoep:b	Z
    //   52: ifne +13 -> 65
    //   55: aload_0
    //   56: aload_2
    //   57: putfield 107	aoep:jdField_a_of_type_Aoes	Laoes;
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 391	aoep:b	Z
    //   65: aload_1
    //   66: monitorexit
    //   67: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq -63 -> 7
    //   73: ldc 245
    //   75: iconst_2
    //   76: ldc_w 602
    //   79: invokestatic 604	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: return
    //   83: astore_1
    //   84: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq -80 -> 7
    //   90: ldc 245
    //   92: iconst_2
    //   93: aload_1
    //   94: invokevirtual 607	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: aload_1
    //   98: invokestatic 609	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   101: return
    //   102: astore_2
    //   103: aload_1
    //   104: monitorexit
    //   105: aload_2
    //   106: athrow
    //   107: getstatic 40	aoep:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   110: astore_1
    //   111: aload_1
    //   112: monitorenter
    //   113: aload_0
    //   114: getfield 391	aoep:b	Z
    //   117: ifne +8 -> 125
    //   120: aload_0
    //   121: iconst_1
    //   122: putfield 391	aoep:b	Z
    //   125: aload_1
    //   126: monitorexit
    //   127: goto -60 -> 67
    //   130: astore_2
    //   131: aload_1
    //   132: monitorexit
    //   133: aload_2
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	aoep
    //   83	21	1	localException	Exception
    //   41	16	2	localaoes	aoes
    //   102	4	2	localObject3	Object
    //   130	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	29	83	java/lang/Exception
    //   48	65	102	finally
    //   65	67	102	finally
    //   103	105	102	finally
    //   113	125	130	finally
    //   125	127	130	finally
    //   131	133	130	finally
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
      if ((this.jdField_a_of_type_Aukn != null) && (this.jdField_a_of_type_Aukn.a()))
      {
        if (paramExtendFriendUserInfo.getStatus() != 1000) {
          break label89;
        }
        this.jdField_a_of_type_Aukn.b(paramExtendFriendUserInfo);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ExtendFriendManager", 2, "updateExtendFriendUserInfo " + paramExtendFriendUserInfo.uin);
        return;
        label89:
        if (paramExtendFriendUserInfo.getStatus() == 1001) {
          this.jdField_a_of_type_Aukn.a(paramExtendFriendUserInfo);
        }
      }
    }
  }
  
  public void a(String arg1)
  {
    aoes localaoes = a(???);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Aoes = localaoes;
      this.b = true;
      boolean bool = aojh.a(this.jdField_a_of_type_Aoes);
      ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.4(this, bool));
      return;
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
    return this.b;
  }
  
  public boolean a(aoes paramaoes)
  {
    boolean bool = true;
    if ((paramaoes == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramaoes = bbjn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
        int i = paramaoes.getInt("sp_extend_friend_entry_contact", 0);
        int j = paramaoes.getInt("sp_extend_friend_entry_add_friend", 0);
        if ((i != 1) || (j != 1)) {
          break label88;
        }
        return bool;
      }
      catch (Exception paramaoes)
      {
        paramaoes.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ExtendFriendManager", 2, paramaoes.getMessage());
      return false;
      label88:
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
      if (this.jdField_a_of_type_Aoes != null) {
        i = this.jdField_a_of_type_Aoes.jdField_l_of_type_Int;
      }
    }
    return i;
  }
  
  public aoes b()
  {
    if (!a()) {
      a();
    }
    return this.jdField_a_of_type_Aoes;
  }
  
  public String b()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (a())
    {
      aoes localaoes = a();
      localObject1 = localObject2;
      if (localaoes != null) {
        localObject1 = localaoes.jdField_i_of_type_JavaLangString;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = ajyc.a(2131704264);
    }
    return localObject2;
  }
  
  public List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (a())
    {
      aoes localaoes = a();
      if (localaoes != null) {
        localArrayList.addAll(localaoes.jdField_b_of_type_JavaUtilList);
      }
    }
    if (localArrayList.size() == 0)
    {
      localArrayList.add(ajyc.a(2131704241));
      localArrayList.add(ajyc.a(2131704236));
      localArrayList.add(ajyc.a(2131704272));
      localArrayList.add(ajyc.a(2131704240));
      localArrayList.add("语C");
      localArrayList.add(ajyc.a(2131704251));
      localArrayList.add(ajyc.a(2131704252));
      localArrayList.add(ajyc.a(2131704271));
    }
    return localArrayList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateMatchChatConfig ");
    }
    ((aoeo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).notifyUI(18, true, null);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c(paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String c()
  {
    String str2 = "";
    String str1 = str2;
    if (a())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Aoes != null) {
        str1 = this.jdField_a_of_type_Aoes.jdField_k_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    if ((this.jdField_a_of_type_Aukn != null) && (this.jdField_a_of_type_Aukn.a())) {
      this.jdField_a_of_type_Aukn.a(ExtendFriendUserInfo.class);
    }
  }
  
  public boolean c()
  {
    if ((a()) && (this.jdField_a_of_type_Aoes != null)) {}
    for (int i = this.jdField_a_of_type_Aoes.jdField_m_of_type_Int;; i = 1) {
      return i == 1;
    }
  }
  
  public String d()
  {
    String str2 = "";
    String str1 = str2;
    if (a())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Aoes != null) {
        str1 = this.jdField_a_of_type_Aoes.jdField_l_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Aoes == null) {}
    while (this.jdField_a_of_type_Aoes.jdField_i_of_type_Int != 1) {
      return false;
    }
    return true;
  }
  
  public String e()
  {
    String str2 = "";
    String str1 = str2;
    if (a())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Aoes != null) {
        str1 = this.jdField_a_of_type_Aoes.jdField_m_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public boolean e()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Aoes != null) && (this.jdField_a_of_type_Aoes.jdField_j_of_type_Int == 1)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "bNuanSSAtFirstTab  " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajtq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoeu);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Aoev != null)
    {
      this.jdField_a_of_type_Aoev.b();
      this.jdField_a_of_type_Aoev.a(null);
      this.jdField_a_of_type_Aoev = null;
      this.jdField_a_of_type_Boolean = false;
    }
    jdField_a_of_type_Aogj = null;
    if (this.jdField_a_of_type_AndroidUtilLruCache != null) {
      this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoep
 * JD-Core Version:    0.7.0.1
 */